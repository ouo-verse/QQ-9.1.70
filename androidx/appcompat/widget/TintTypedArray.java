package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i3, boolean z16) {
        return this.mWrapped.getBoolean(i3, z16);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return this.mWrapped.getChangingConfigurations();
    }

    public int getColor(int i3, int i16) {
        return this.mWrapped.getColor(i3, i16);
    }

    public ColorStateList getColorStateList(int i3) {
        int resourceId;
        ColorStateList colorStateList;
        if (this.mWrapped.hasValue(i3) && (resourceId = this.mWrapped.getResourceId(i3, 0)) != 0 && (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) != null) {
            return colorStateList;
        }
        return this.mWrapped.getColorStateList(i3);
    }

    public float getDimension(int i3, float f16) {
        return this.mWrapped.getDimension(i3, f16);
    }

    public int getDimensionPixelOffset(int i3, int i16) {
        return this.mWrapped.getDimensionPixelOffset(i3, i16);
    }

    public int getDimensionPixelSize(int i3, int i16) {
        return this.mWrapped.getDimensionPixelSize(i3, i16);
    }

    public Drawable getDrawable(int i3) {
        int resourceId;
        if (this.mWrapped.hasValue(i3) && (resourceId = this.mWrapped.getResourceId(i3, 0)) != 0) {
            return AppCompatResources.getDrawable(this.mContext, resourceId);
        }
        return this.mWrapped.getDrawable(i3);
    }

    public Drawable getDrawableIfKnown(int i3) {
        int resourceId;
        if (this.mWrapped.hasValue(i3) && (resourceId = this.mWrapped.getResourceId(i3, 0)) != 0) {
            return AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
        }
        return null;
    }

    public float getFloat(int i3, float f16) {
        return this.mWrapped.getFloat(i3, f16);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i3, int i16, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i3, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i16, fontCallback);
    }

    public float getFraction(int i3, int i16, int i17, float f16) {
        return this.mWrapped.getFraction(i3, i16, i17, f16);
    }

    public int getIndex(int i3) {
        return this.mWrapped.getIndex(i3);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int i3, int i16) {
        return this.mWrapped.getInt(i3, i16);
    }

    public int getInteger(int i3, int i16) {
        return this.mWrapped.getInteger(i3, i16);
    }

    public int getLayoutDimension(int i3, String str) {
        return this.mWrapped.getLayoutDimension(i3, str);
    }

    public String getNonResourceString(int i3) {
        return this.mWrapped.getNonResourceString(i3);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int i3, int i16) {
        return this.mWrapped.getResourceId(i3, i16);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int i3) {
        return this.mWrapped.getString(i3);
    }

    public CharSequence getText(int i3) {
        return this.mWrapped.getText(i3);
    }

    public CharSequence[] getTextArray(int i3) {
        return this.mWrapped.getTextArray(i3);
    }

    public int getType(int i3) {
        return this.mWrapped.getType(i3);
    }

    public boolean getValue(int i3, TypedValue typedValue) {
        return this.mWrapped.getValue(i3, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i3) {
        return this.mWrapped.hasValue(i3);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int i3) {
        return this.mWrapped.peekValue(i3);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i3, int i16) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i3, i16));
    }

    public int getLayoutDimension(int i3, int i16) {
        return this.mWrapped.getLayoutDimension(i3, i16);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i3, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i3, iArr));
    }
}
