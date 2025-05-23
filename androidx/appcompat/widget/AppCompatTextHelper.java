package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;

    @NonNull
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;

    @NonNull
    private final TextView mView;
    private int mStyle = 0;
    private int mFontWeight = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextHelper(@NonNull TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        }
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i3) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i3);
        if (tintList != null) {
            TintInfo tintInfo = new TintInfo();
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = tintList;
            return tintInfo;
        }
        return null;
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
                Drawable drawable7 = compoundDrawablesRelative[0];
                if (drawable7 == null && compoundDrawablesRelative[2] == null) {
                    Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
                    TextView textView = this.mView;
                    if (drawable == null) {
                        drawable = compoundDrawables[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawables[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = compoundDrawables[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawables[3];
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                    return;
                }
                TextView textView2 = this.mView;
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative[1];
                }
                Drawable drawable8 = compoundDrawablesRelative[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.mView.getCompoundDrawablesRelative();
        TextView textView3 = this.mView;
        if (drawable5 == null) {
            drawable5 = compoundDrawablesRelative2[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawablesRelative2[1];
        }
        if (drawable6 == null) {
            drawable6 = compoundDrawablesRelative2[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawablesRelative2[3];
        }
        textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
    }

    private void setCompoundTints() {
        TintInfo tintInfo = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int i3, float f16) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i3, f16);
    }

    private void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        String string;
        Typeface create;
        boolean z16;
        boolean z17;
        Typeface create2;
        this.mStyle = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int i3 = Build.VERSION.SDK_INT;
        boolean z18 = false;
        if (i3 >= 28) {
            int i16 = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i16;
            if (i16 != -1) {
                this.mStyle = (this.mStyle & 2) | 0;
            }
        }
        int i17 = R.styleable.TextAppearance_android_fontFamily;
        if (!tintTypedArray.hasValue(i17) && !tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            int i18 = R.styleable.TextAppearance_android_typeface;
            if (tintTypedArray.hasValue(i18)) {
                this.mAsyncFontPending = false;
                int i19 = tintTypedArray.getInt(i18, 1);
                if (i19 != 1) {
                    if (i19 != 2) {
                        if (i19 == 3) {
                            this.mFontTypeface = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.mFontTypeface = Typeface.SERIF;
                    return;
                }
                this.mFontTypeface = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.mFontTypeface = null;
        int i26 = R.styleable.TextAppearance_fontFamily;
        if (tintTypedArray.hasValue(i26)) {
            i17 = i26;
        }
        final int i27 = this.mFontWeight;
        final int i28 = this.mStyle;
        if (!context.isRestricted()) {
            final WeakReference weakReference = new WeakReference(this.mView);
            try {
                Typeface font = tintTypedArray.getFont(i17, this.mStyle, new ResourcesCompat.FontCallback() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrieved(@NonNull Typeface typeface) {
                        int i29;
                        boolean z19;
                        if (Build.VERSION.SDK_INT >= 28 && (i29 = i27) != -1) {
                            if ((i28 & 2) != 0) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            typeface = Typeface.create(typeface, i29, z19);
                        }
                        AppCompatTextHelper.this.onAsyncTypefaceReceived(weakReference, typeface);
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrievalFailed(int i29) {
                    }
                });
                if (font != null) {
                    if (i3 >= 28 && this.mFontWeight != -1) {
                        Typeface create3 = Typeface.create(font, 0);
                        int i29 = this.mFontWeight;
                        if ((this.mStyle & 2) != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        create2 = Typeface.create(create3, i29, z17);
                        this.mFontTypeface = create2;
                    } else {
                        this.mFontTypeface = font;
                    }
                }
                if (this.mFontTypeface == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.mAsyncFontPending = z16;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.mFontTypeface == null && (string = tintTypedArray.getString(i17)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.mFontWeight != -1) {
                Typeface create4 = Typeface.create(string, 0);
                int i36 = this.mFontWeight;
                if ((this.mStyle & 2) != 0) {
                    z18 = true;
                }
                create = Typeface.create(create4, i36, z18);
                this.mFontTypeface = create;
                return;
            }
            this.mFontTypeface = Typeface.create(string, this.mStyle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint != null || this.mDrawableEndTint != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
            applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public ColorStateList getCompoundDrawableTintList() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0222  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadFromAttributes(@Nullable AttributeSet attributeSet, int i3) {
        boolean z16;
        boolean z17;
        String str;
        String str2;
        boolean z18;
        int i16;
        Typeface typeface;
        TintTypedArray obtainStyledAttributes;
        int resourceId;
        Drawable drawable;
        int resourceId2;
        Drawable drawable2;
        int resourceId3;
        Drawable drawable3;
        int resourceId4;
        Drawable drawable4;
        int resourceId5;
        Drawable drawable5;
        int resourceId6;
        Drawable drawable6;
        int i17;
        int i18;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        int[] autoSizeTextAvailableSizes;
        int autoSizeStepGranularity;
        LocaleList forLanguageTags;
        int i19;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        int[] iArr = R.styleable.AppCompatTextHelper;
        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i3, 0);
        TextView textView = this.mView;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes2.getWrappedTypeArray(), i3, 0);
        int resourceId7 = obtainStyledAttributes2.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        int i26 = R.styleable.AppCompatTextHelper_android_drawableLeft;
        if (obtainStyledAttributes2.hasValue(i26)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i26, 0));
        }
        int i27 = R.styleable.AppCompatTextHelper_android_drawableTop;
        if (obtainStyledAttributes2.hasValue(i27)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i27, 0));
        }
        int i28 = R.styleable.AppCompatTextHelper_android_drawableRight;
        if (obtainStyledAttributes2.hasValue(i28)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i28, 0));
        }
        int i29 = R.styleable.AppCompatTextHelper_android_drawableBottom;
        if (obtainStyledAttributes2.hasValue(i29)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i29, 0));
        }
        int i36 = Build.VERSION.SDK_INT;
        int i37 = R.styleable.AppCompatTextHelper_android_drawableStart;
        if (obtainStyledAttributes2.hasValue(i37)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i37, 0));
        }
        int i38 = R.styleable.AppCompatTextHelper_android_drawableEnd;
        if (obtainStyledAttributes2.hasValue(i38)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i38, 0));
        }
        obtainStyledAttributes2.recycle();
        boolean z19 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (resourceId7 != -1) {
            TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, resourceId7, R.styleable.TextAppearance);
            if (!z19) {
                int i39 = R.styleable.TextAppearance_textAllCaps;
                if (obtainStyledAttributes3.hasValue(i39)) {
                    z16 = obtainStyledAttributes3.getBoolean(i39, false);
                    z17 = true;
                    updateTypefaceAndStyle(context, obtainStyledAttributes3);
                    i19 = R.styleable.TextAppearance_textLocale;
                    if (!obtainStyledAttributes3.hasValue(i19)) {
                        str2 = obtainStyledAttributes3.getString(i19);
                    } else {
                        str2 = null;
                    }
                    if (i36 >= 26) {
                        int i46 = R.styleable.TextAppearance_fontVariationSettings;
                        if (obtainStyledAttributes3.hasValue(i46)) {
                            str = obtainStyledAttributes3.getString(i46);
                            obtainStyledAttributes3.recycle();
                        }
                    }
                    str = null;
                    obtainStyledAttributes3.recycle();
                }
            }
            z16 = false;
            z17 = false;
            updateTypefaceAndStyle(context, obtainStyledAttributes3);
            i19 = R.styleable.TextAppearance_textLocale;
            if (!obtainStyledAttributes3.hasValue(i19)) {
            }
            if (i36 >= 26) {
            }
            str = null;
            obtainStyledAttributes3.recycle();
        } else {
            z16 = false;
            z17 = false;
            str = null;
            str2 = null;
        }
        TintTypedArray obtainStyledAttributes4 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.TextAppearance, i3, 0);
        if (!z19) {
            int i47 = R.styleable.TextAppearance_textAllCaps;
            if (obtainStyledAttributes4.hasValue(i47)) {
                z16 = obtainStyledAttributes4.getBoolean(i47, false);
                z18 = true;
                i16 = R.styleable.TextAppearance_textLocale;
                if (obtainStyledAttributes4.hasValue(i16)) {
                    str2 = obtainStyledAttributes4.getString(i16);
                }
                if (i36 >= 26) {
                    int i48 = R.styleable.TextAppearance_fontVariationSettings;
                    if (obtainStyledAttributes4.hasValue(i48)) {
                        str = obtainStyledAttributes4.getString(i48);
                    }
                }
                if (i36 >= 28) {
                    int i49 = R.styleable.TextAppearance_android_textSize;
                    if (obtainStyledAttributes4.hasValue(i49) && obtainStyledAttributes4.getDimensionPixelSize(i49, -1) == 0) {
                        this.mView.setTextSize(0, 0.0f);
                    }
                }
                updateTypefaceAndStyle(context, obtainStyledAttributes4);
                obtainStyledAttributes4.recycle();
                if (!z19 && z18) {
                    setAllCaps(z16);
                }
                typeface = this.mFontTypeface;
                if (typeface != null) {
                    if (this.mFontWeight == -1) {
                        this.mView.setTypeface(typeface, this.mStyle);
                    } else {
                        this.mView.setTypeface(typeface);
                    }
                }
                if (str != null) {
                    this.mView.setFontVariationSettings(str);
                }
                if (str2 != null) {
                    if (i36 >= 24) {
                        TextView textView2 = this.mView;
                        forLanguageTags = LocaleList.forLanguageTags(str2);
                        textView2.setTextLocales(forLanguageTags);
                    } else {
                        this.mView.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
                    }
                }
                this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i3);
                if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
                    autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
                    if (autoSizeTextAvailableSizes.length > 0) {
                        autoSizeStepGranularity = this.mView.getAutoSizeStepGranularity();
                        if (autoSizeStepGranularity != -1.0f) {
                            this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
                        } else {
                            this.mView.setAutoSizeTextTypeUniformWithPresetSizes(autoSizeTextAvailableSizes, 0);
                        }
                    }
                }
                obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextView);
                resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
                if (resourceId == -1) {
                    drawable = appCompatDrawableManager.getDrawable(context, resourceId);
                } else {
                    drawable = null;
                }
                resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
                if (resourceId2 == -1) {
                    drawable2 = appCompatDrawableManager.getDrawable(context, resourceId2);
                } else {
                    drawable2 = null;
                }
                resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
                if (resourceId3 == -1) {
                    drawable3 = appCompatDrawableManager.getDrawable(context, resourceId3);
                } else {
                    drawable3 = null;
                }
                resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
                if (resourceId4 == -1) {
                    drawable4 = appCompatDrawableManager.getDrawable(context, resourceId4);
                } else {
                    drawable4 = null;
                }
                resourceId5 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
                if (resourceId5 == -1) {
                    drawable5 = appCompatDrawableManager.getDrawable(context, resourceId5);
                } else {
                    drawable5 = null;
                }
                resourceId6 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
                if (resourceId6 == -1) {
                    drawable6 = appCompatDrawableManager.getDrawable(context, resourceId6);
                } else {
                    drawable6 = null;
                }
                setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, drawable6);
                i17 = R.styleable.AppCompatTextView_drawableTint;
                if (obtainStyledAttributes.hasValue(i17)) {
                    TextViewCompat.setCompoundDrawableTintList(this.mView, obtainStyledAttributes.getColorStateList(i17));
                }
                i18 = R.styleable.AppCompatTextView_drawableTintMode;
                if (obtainStyledAttributes.hasValue(i18)) {
                    TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i18, -1), null));
                }
                dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
                dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
                dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
                obtainStyledAttributes.recycle();
                if (dimensionPixelSize != -1) {
                    TextViewCompat.setFirstBaselineToTopHeight(this.mView, dimensionPixelSize);
                }
                if (dimensionPixelSize2 != -1) {
                    TextViewCompat.setLastBaselineToBottomHeight(this.mView, dimensionPixelSize2);
                }
                if (dimensionPixelSize3 == -1) {
                    TextViewCompat.setLineHeight(this.mView, dimensionPixelSize3);
                    return;
                }
                return;
            }
        }
        z18 = z17;
        i16 = R.styleable.TextAppearance_textLocale;
        if (obtainStyledAttributes4.hasValue(i16)) {
        }
        if (i36 >= 26) {
        }
        if (i36 >= 28) {
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes4);
        obtainStyledAttributes4.recycle();
        if (!z19) {
            setAllCaps(z16);
        }
        typeface = this.mFontTypeface;
        if (typeface != null) {
        }
        if (str != null) {
        }
        if (str2 != null) {
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i3);
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
            if (autoSizeTextAvailableSizes.length > 0) {
            }
        }
        obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.AppCompatTextView);
        resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        if (resourceId == -1) {
        }
        resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        if (resourceId2 == -1) {
        }
        resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        if (resourceId3 == -1) {
        }
        resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (resourceId4 == -1) {
        }
        resourceId5 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        if (resourceId5 == -1) {
        }
        resourceId6 = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        if (resourceId6 == -1) {
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, drawable6);
        i17 = R.styleable.AppCompatTextView_drawableTint;
        if (obtainStyledAttributes.hasValue(i17)) {
        }
        i18 = R.styleable.AppCompatTextView_drawableTintMode;
        if (obtainStyledAttributes.hasValue(i18)) {
        }
        dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
        obtainStyledAttributes.recycle();
        if (dimensionPixelSize != -1) {
        }
        if (dimensionPixelSize2 != -1) {
        }
        if (dimensionPixelSize3 == -1) {
        }
    }

    void onAsyncTypefaceReceived(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.mStyle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            autoSizeText();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSetTextAppearance(Context context, int i3) {
        String string;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i3, R.styleable.TextAppearance);
        int i16 = R.styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i16)) {
            setAllCaps(obtainStyledAttributes.getBoolean(i16, false));
        }
        int i17 = Build.VERSION.SDK_INT;
        int i18 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i18) && obtainStyledAttributes.getDimensionPixelSize(i18, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        if (i17 >= 26) {
            int i19 = R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i19) && (string = obtainStyledAttributes.getString(i19)) != null) {
                this.mView.setFontVariationSettings(string);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAllCaps(boolean z16) {
        this.mView.setAllCaps(z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i16, int i17, int i18) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i3) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCompoundDrawableTintList(@Nullable ColorStateList colorStateList) {
        boolean z16;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        if (colorStateList != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        tintInfo.mHasTintList = z16;
        setCompoundTints();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode mode) {
        boolean z16;
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        if (mode != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        tintInfo.mHasTintMode = z16;
        setCompoundTints();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSize(int i3, float f16) {
        if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && !isAutoSizeEnabled()) {
            setTextSizeInternal(i3, f16);
        }
    }
}
