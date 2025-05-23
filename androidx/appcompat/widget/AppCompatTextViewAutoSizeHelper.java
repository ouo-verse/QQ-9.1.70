package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    private static final int VERY_WIDE = 1048576;
    private final Context mContext;
    private final Impl mImpl;
    private TextPaint mTempTextPaint;

    @NonNull
    private final TextView mTextView;
    private static final RectF TEMP_RECTF = new RectF();
    private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache = new ConcurrentHashMap<>();
    private int mAutoSizeTextType = 0;
    private boolean mNeedsAutoSizeText = false;
    private float mAutoSizeStepGranularityInPx = -1.0f;
    private float mAutoSizeMinTextSizeInPx = -1.0f;
    private float mAutoSizeMaxTextSizeInPx = -1.0f;
    private int[] mAutoSizeTextSizesInPx = new int[0];
    private boolean mHasPresetAutoSizeValues = false;

    /* compiled from: P */
    @RequiresApi(23)
    /* loaded from: classes.dex */
    private static class Impl23 extends Impl {
        Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* compiled from: P */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    private static class Impl29 extends Impl23 {
        Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            textDirectionHeuristic = textView.getTextDirectionHeuristic();
            builder.setTextDirection(textDirectionHeuristic);
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        boolean isHorizontallyScrollable(TextView textView) {
            boolean isHorizontallyScrollable;
            isHorizontallyScrollable = textView.isHorizontallyScrollable();
            return isHorizontallyScrollable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextViewAutoSizeHelper(@NonNull TextView textView) {
        this.mTextView = textView;
        this.mContext = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new Impl29();
        } else {
            this.mImpl = new Impl23();
        }
    }

    private static <T> T accessAndReturnWithDefault(@NonNull Object obj, @NonNull String str, @NonNull T t16) {
        try {
            Field textViewField = getTextViewField(str);
            if (textViewField == null) {
                return t16;
            }
            return (T) textViewField.get(obj);
        } catch (IllegalAccessException e16) {
            Log.w(TAG, "Failed to access TextView#" + str + " member", e16);
            return t16;
        }
    }

    private int[] cleanupAutoSizePresetSizes(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            if (i3 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i3)) < 0) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i16 = 0; i16 < size; i16++) {
            iArr2[i16] = ((Integer) arrayList.get(i16)).intValue();
        }
        return iArr2;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    @RequiresApi(23)
    private StaticLayout createStaticLayoutForMeasuring(CharSequence charSequence, Layout.Alignment alignment, int i3, int i16) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.mTempTextPaint, i3);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
        if (i16 == -1) {
            i16 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i16);
        try {
            this.mImpl.computeAndSetTextDirection(obtain, this.mTextView);
        } catch (ClassCastException unused) {
            Log.w(TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence charSequence, Layout.Alignment alignment, int i3) {
        return new StaticLayout(charSequence, this.mTempTextPaint, i3, alignment, ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    @RequiresApi(16)
    private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence charSequence, Layout.Alignment alignment, int i3) {
        return new StaticLayout(charSequence, this.mTempTextPaint, i3, alignment, this.mTextView.getLineSpacingMultiplier(), this.mTextView.getLineSpacingExtra(), this.mTextView.getIncludeFontPadding());
    }

    private int findLargestTextSizeWhichFits(RectF rectF) {
        int length = this.mAutoSizeTextSizesInPx.length;
        if (length != 0) {
            int i3 = 1;
            int i16 = length - 1;
            int i17 = 0;
            while (i3 <= i16) {
                int i18 = (i3 + i16) / 2;
                if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[i18], rectF)) {
                    int i19 = i18 + 1;
                    i17 = i3;
                    i3 = i19;
                } else {
                    i17 = i18 - 1;
                    i16 = i17;
                }
            }
            return this.mAutoSizeTextSizesInPx[i17];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    @Nullable
    private static Field getTextViewField(@NonNull String str) {
        try {
            Field field = sTextViewFieldByNameCache.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                sTextViewFieldByNameCache.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e16) {
            Log.w(TAG, "Failed to access TextView#" + str + " member", e16);
            return null;
        }
    }

    @Nullable
    private static Method getTextViewMethod(@NonNull String str) {
        try {
            Method method = sTextViewMethodByNameCache.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                sTextViewMethodByNameCache.put(str, method);
            }
            return method;
        } catch (Exception e16) {
            Log.w(TAG, "Failed to retrieve TextView#" + str + "() method", e16);
            return null;
        }
    }

    static <T> T invokeAndReturnWithDefault(@NonNull Object obj, @NonNull String str, @NonNull T t16) {
        try {
            return (T) getTextViewMethod(str).invoke(obj, new Object[0]);
        } catch (Exception e16) {
            Log.w(TAG, "Failed to invoke TextView#" + str + "() method", e16);
            return t16;
        }
    }

    private void setRawTextSize(float f16) {
        if (f16 != this.mTextView.getPaint().getTextSize()) {
            this.mTextView.getPaint().setTextSize(f16);
            boolean isInLayout = this.mTextView.isInLayout();
            if (this.mTextView.getLayout() != null) {
                this.mNeedsAutoSizeText = false;
                try {
                    Method textViewMethod = getTextViewMethod("nullLayouts");
                    if (textViewMethod != null) {
                        textViewMethod.invoke(this.mTextView, new Object[0]);
                    }
                } catch (Exception e16) {
                    Log.w(TAG, "Failed to invoke TextView#nullLayouts() method", e16);
                }
                if (!isInLayout) {
                    this.mTextView.requestLayout();
                } else {
                    this.mTextView.forceLayout();
                }
                this.mTextView.invalidate();
            }
        }
    }

    private boolean setupAutoSizeText() {
        if (supportsAutoSizeText() && this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                int floor = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
                int[] iArr = new int[floor];
                for (int i3 = 0; i3 < floor; i3++) {
                    iArr[i3] = Math.round(this.mAutoSizeMinTextSizeInPx + (i3 * this.mAutoSizeStepGranularityInPx));
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            }
            this.mNeedsAutoSizeText = true;
        } else {
            this.mNeedsAutoSizeText = false;
        }
        return this.mNeedsAutoSizeText;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = typedArray.getDimensionPixelSize(i3, -1);
            }
            this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            setupAutoSizeUniformPresetSizesConfiguration();
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        boolean z16;
        if (this.mAutoSizeTextSizesInPx.length > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mHasPresetAutoSizeValues = z16;
        if (z16) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = r0[0];
            this.mAutoSizeMaxTextSizeInPx = r0[r1 - 1];
            this.mAutoSizeStepGranularityInPx = -1.0f;
        }
        return z16;
    }

    private boolean suggestedSizeFitsInSpace(int i3, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.mTextView.getText();
        TransformationMethod transformationMethod = this.mTextView.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.mTextView)) != null) {
            text = transformation;
        }
        int maxLines = this.mTextView.getMaxLines();
        initTempTextPaint(i3);
        StaticLayout createLayout = createLayout(text, (Layout.Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        if ((maxLines != -1 && (createLayout.getLineCount() > maxLines || createLayout.getLineEnd(createLayout.getLineCount() - 1) != text.length())) || createLayout.getHeight() > rectF.bottom) {
            return false;
        }
        return true;
    }

    private boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float f16, float f17, float f18) throws IllegalArgumentException {
        if (f16 > 0.0f) {
            if (f17 > f16) {
                if (f18 > 0.0f) {
                    this.mAutoSizeTextType = 1;
                    this.mAutoSizeMinTextSizeInPx = f16;
                    this.mAutoSizeMaxTextSizeInPx = f17;
                    this.mAutoSizeStepGranularityInPx = f18;
                    this.mHasPresetAutoSizeValues = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f18 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f17 + "px) is less or equal to minimum auto-size text size (" + f16 + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f16 + "px) is less or equal to (0px)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void autoSizeText() {
        int measuredWidth;
        if (!isAutoSizeEnabled()) {
            return;
        }
        if (this.mNeedsAutoSizeText) {
            if (this.mTextView.getMeasuredHeight() > 0 && this.mTextView.getMeasuredWidth() > 0) {
                if (this.mImpl.isHorizontallyScrollable(this.mTextView)) {
                    measuredWidth = 1048576;
                } else {
                    measuredWidth = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                }
                int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                if (measuredWidth > 0 && height > 0) {
                    RectF rectF = TEMP_RECTF;
                    synchronized (rectF) {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float findLargestTextSizeWhichFits = findLargestTextSizeWhichFits(rectF);
                        if (findLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                            setTextSizeInternal(0, findLargestTextSizeWhichFits);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.mNeedsAutoSizeText = true;
    }

    @VisibleForTesting
    StaticLayout createLayout(CharSequence charSequence, Layout.Alignment alignment, int i3, int i16) {
        return createStaticLayoutForMeasuring(charSequence, alignment, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    @VisibleForTesting
    void initTempTextPaint(int i3) {
        TextPaint textPaint = this.mTempTextPaint;
        if (textPaint == null) {
            this.mTempTextPaint = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isAutoSizeEnabled() {
        if (supportsAutoSizeText() && this.mAutoSizeTextType != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(@Nullable AttributeSet attributeSet, int i3) {
        float f16;
        float f17;
        float f18;
        int resourceId;
        Context context = this.mContext;
        int[] iArr = R.styleable.AppCompatTextView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        TextView textView = this.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i3, 0);
        int i16 = R.styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.mAutoSizeTextType = obtainStyledAttributes.getInt(i16, 0);
        }
        int i17 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
        if (obtainStyledAttributes.hasValue(i17)) {
            f16 = obtainStyledAttributes.getDimension(i17, -1.0f);
        } else {
            f16 = -1.0f;
        }
        int i18 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
        if (obtainStyledAttributes.hasValue(i18)) {
            f17 = obtainStyledAttributes.getDimension(i18, -1.0f);
        } else {
            f17 = -1.0f;
        }
        int i19 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        if (obtainStyledAttributes.hasValue(i19)) {
            f18 = obtainStyledAttributes.getDimension(i19, -1.0f);
        } else {
            f18 = -1.0f;
        }
        int i26 = R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i26) && (resourceId = obtainStyledAttributes.getResourceId(i26, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            setupAutoSizeUniformPresetSizes(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (supportsAutoSizeText()) {
            if (this.mAutoSizeTextType == 1) {
                if (!this.mHasPresetAutoSizeValues) {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    if (f17 == -1.0f) {
                        f17 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (f18 == -1.0f) {
                        f18 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (f16 == -1.0f) {
                        f16 = 1.0f;
                    }
                    validateAndSetAutoSizeTextTypeUniformConfiguration(f17, f18, f16);
                }
                setupAutoSizeText();
                return;
            }
            return;
        }
        this.mAutoSizeTextType = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i16, int i17, int i18) throws IllegalArgumentException {
        if (supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i18, i3, displayMetrics), TypedValue.applyDimension(i18, i16, displayMetrics), TypedValue.applyDimension(i18, i17, displayMetrics));
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i3) throws IllegalArgumentException {
        if (supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i3 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    for (int i16 = 0; i16 < length; i16++) {
                        iArr2[i16] = Math.round(TypedValue.applyDimension(i3, iArr[i16], displayMetrics));
                    }
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr2);
                if (!setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.mHasPresetAutoSizeValues = false;
            }
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        if (supportsAutoSizeText()) {
            if (i3 != 0) {
                if (i3 == 1) {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (setupAutoSizeText()) {
                        autoSizeText();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Unknown auto-size text type: " + i3);
            }
            clearAutoSizeConfiguration();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setTextSizeInternal(int i3, float f16) {
        Resources resources;
        Context context = this.mContext;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i3, f16, resources.getDisplayMetrics()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Impl {
        Impl() {
        }

        boolean isHorizontallyScrollable(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }

        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
        }
    }
}
