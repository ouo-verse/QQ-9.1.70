package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompat";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface AutoSizeTextType {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @RequiresApi(26)
    /* loaded from: classes.dex */
    public static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences = false;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        OreoCallback(ActionMode.Callback callback, TextView textView) {
            this.mCallback = callback;
            this.mTextView = textView;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : InstalledAppListMonitor.queryIntentActivities(packageManager, createProcessTextIntent(), 0)) {
                if (isSupportedActivity(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        private boolean isEditable(TextView textView) {
            if ((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()) {
                return true;
            }
            return false;
        }

        private boolean isSupportedActivity(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            if (str == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }

        private void recomputeProcessTextMenuItems(Menu menu) {
            Method declaredMethod;
            Context context = this.mTextView.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.mInitializedMenuBuilderReferences) {
                this.mInitializedMenuBuilderReferences = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.mMenuBuilderClass = cls;
                    this.mMenuBuilderRemoveItemAtMethod = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.mCanUseMenuBuilderReferences = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.mMenuBuilderClass = null;
                    this.mMenuBuilderRemoveItemAtMethod = null;
                    this.mCanUseMenuBuilderReferences = false;
                }
            }
            try {
                if (this.mCanUseMenuBuilderReferences && this.mMenuBuilderClass.isInstance(menu)) {
                    declaredMethod = this.mMenuBuilderRemoveItemAtMethod;
                } else {
                    declaredMethod = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> supportedActivities = getSupportedActivities(context, packageManager);
                for (int i3 = 0; i3 < supportedActivities.size(); i3++) {
                    ResolveInfo resolveInfo = supportedActivities.get(i3);
                    menu.add(0, 0, i3 + 100, resolveInfo.loadLabel(packageManager)).setIntent(createProcessTextIntentForResolveInfo(resolveInfo, this.mTextView)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @NonNull
        ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mCallback.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mCallback.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.mCallback.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            recomputeProcessTextMenuItems(menu);
            return this.mCallback.onPrepareActionMode(actionMode, menu);
        }
    }

    TextViewCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMaxTextSize(@NonNull TextView textView) {
        int autoSizeMaxTextSize;
        if (Build.VERSION.SDK_INT >= 27) {
            autoSizeMaxTextSize = textView.getAutoSizeMaxTextSize();
            return autoSizeMaxTextSize;
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeMaxTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMinTextSize(@NonNull TextView textView) {
        int autoSizeMinTextSize;
        if (Build.VERSION.SDK_INT >= 27) {
            autoSizeMinTextSize = textView.getAutoSizeMinTextSize();
            return autoSizeMinTextSize;
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeMinTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeStepGranularity(@NonNull TextView textView) {
        int autoSizeStepGranularity;
        if (Build.VERSION.SDK_INT >= 27) {
            autoSizeStepGranularity = textView.getAutoSizeStepGranularity();
            return autoSizeStepGranularity;
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeStepGranularity();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView textView) {
        int[] autoSizeTextAvailableSizes;
        if (Build.VERSION.SDK_INT >= 27) {
            autoSizeTextAvailableSizes = textView.getAutoSizeTextAvailableSizes();
            return autoSizeTextAvailableSizes;
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeTextAvailableSizes();
        }
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeTextType(@NonNull TextView textView) {
        int autoSizeTextType;
        if (Build.VERSION.SDK_INT >= 27) {
            autoSizeTextType = textView.getAutoSizeTextType();
            return autoSizeTextType;
        }
        if (textView instanceof AutoSizeableTextView) {
            return ((AutoSizeableTextView) textView).getAutoSizeTextType();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getCompoundDrawableTintList(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return textView.getCompoundDrawableTintList();
        }
        if (textView instanceof TintableCompoundDrawablesView) {
            return ((TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getCompoundDrawableTintMode(@NonNull TextView textView) {
        Preconditions.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return textView.getCompoundDrawableTintMode();
        }
        if (textView instanceof TintableCompoundDrawablesView) {
            return ((TintableCompoundDrawablesView) textView).getSupportCompoundDrawablesTintMode();
        }
        return null;
    }

    @NonNull
    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(@NonNull TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(@NonNull TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(@NonNull TextView textView) {
        return textView.getMaxLines();
    }

    public static int getMinLines(@NonNull TextView textView) {
        return textView.getMinLines();
    }

    @RequiresApi(18)
    private static int getTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        if (textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL) {
            return 1;
        }
        return 7;
    }

    @RequiresApi(18)
    private static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView textView) {
        DecimalFormatSymbols decimalFormatSymbols;
        String[] digitStrings;
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        boolean z16 = false;
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            decimalFormatSymbols = DecimalFormatSymbols.getInstance(textView.getTextLocale());
            digitStrings = decimalFormatSymbols.getDigitStrings();
            byte directionality = Character.getDirectionality(digitStrings[0].codePointAt(0));
            if (directionality != 1 && directionality != 2) {
                return TextDirectionHeuristics.LTR;
            }
            return TextDirectionHeuristics.RTL;
        }
        if (textView.getLayoutDirection() == 1) {
            z16 = true;
        }
        switch (textView.getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                if (z16) {
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                }
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    @NonNull
    public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView textView) {
        PrecomputedText.Params textMetricsParams;
        if (Build.VERSION.SDK_INT >= 28) {
            textMetricsParams = textView.getTextMetricsParams();
            return new PrecomputedTextCompat.Params(textMetricsParams);
        }
        PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint(textView.getPaint()));
        builder.setBreakStrategy(textView.getBreakStrategy());
        builder.setHyphenationFrequency(textView.getHyphenationFrequency());
        builder.setTextDirection(getTextDirectionHeuristic(textView));
        return builder.build();
    }

    private static Field retrieveField(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException unused) {
            Log.e(LOG_TAG, "Could not retrieve " + str + " field.");
            return field;
        }
    }

    private static int retrieveIntFromField(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            Log.d(LOG_TAG, "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView textView, int i3, int i16, int i17, int i18) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i3, i16, i17, i18);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithConfiguration(i3, i16, i17, i18);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView textView, @NonNull int[] iArr, int i3) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView textView, int i3) {
        if (Build.VERSION.SDK_INT >= 27) {
            textView.setAutoSizeTextTypeWithDefaults(i3);
        } else if (textView instanceof AutoSizeableTextView) {
            ((AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintList(@NonNull TextView textView, @Nullable ColorStateList colorStateList) {
        Preconditions.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintMode(@NonNull TextView textView, @Nullable PorterDuff.Mode mode) {
        Preconditions.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public static void setCustomSelectionActionModeCallback(@NonNull TextView textView, @NonNull ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(textView, callback));
    }

    public static void setFirstBaselineToTopHeight(@NonNull TextView textView, @IntRange(from = 0) @Px int i3) {
        int i16;
        Preconditions.checkArgumentNonnegative(i3);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i3);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i16 = fontMetricsInt.top;
        } else {
            i16 = fontMetricsInt.ascent;
        }
        if (i3 > Math.abs(i16)) {
            textView.setPadding(textView.getPaddingLeft(), i3 + i16, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void setLastBaselineToBottomHeight(@NonNull TextView textView, @IntRange(from = 0) @Px int i3) {
        int i16;
        Preconditions.checkArgumentNonnegative(i3);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i16 = fontMetricsInt.bottom;
        } else {
            i16 = fontMetricsInt.descent;
        }
        if (i3 > Math.abs(i16)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i3 - i16);
        }
    }

    public static void setLineHeight(@NonNull TextView textView, @IntRange(from = 0) @Px int i3) {
        Preconditions.checkArgumentNonnegative(i3);
        if (i3 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i3 - r0, 1.0f);
        }
    }

    public static void setPrecomputedText(@NonNull TextView textView, @NonNull PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(precomputedTextCompat.getPrecomputedText());
        } else {
            if (getTextMetricsParams(textView).equalsWithoutTextDirection(precomputedTextCompat.getParams())) {
                textView.setText(precomputedTextCompat);
                return;
            }
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    public static void setTextAppearance(@NonNull TextView textView, @StyleRes int i3) {
        textView.setTextAppearance(i3);
    }

    public static void setTextMetricsParams(@NonNull TextView textView, @NonNull PrecomputedTextCompat.Params params) {
        textView.setTextDirection(getTextDirection(params.getTextDirection()));
        textView.getPaint().set(params.getTextPaint());
        textView.setBreakStrategy(params.getBreakStrategy());
        textView.setHyphenationFrequency(params.getHyphenationFrequency());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        if ((callback instanceof OreoCallback) && Build.VERSION.SDK_INT >= 26) {
            return ((OreoCallback) callback).getWrappedCallback();
        }
        return callback;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView textView, @Nullable ActionMode.Callback callback) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 && i3 <= 27 && !(callback instanceof OreoCallback) && callback != null) {
            return new OreoCallback(callback, textView);
        }
        return callback;
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @DrawableRes int i3, @DrawableRes int i16, @DrawableRes int i17, @DrawableRes int i18) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i16, i17, i18);
    }
}
