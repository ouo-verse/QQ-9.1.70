package com.tencent.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TypedArrayWarpper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private TypedArray f384701a;

    public TypedArrayWarpper(TypedArray typedArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) typedArray);
        } else {
            this.f384701a = typedArray;
        }
    }

    public boolean getBoolean(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getBoolean(i3, z16);
        }
        return z16;
    }

    public int getColor(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getColor(i3, i16);
        }
        return i16;
    }

    public ColorStateList getColorStateList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        if (i3 >= 0) {
            return this.f384701a.getColorStateList(i3);
        }
        return null;
    }

    public float getDimension(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Float) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Float.valueOf(f16))).floatValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getDimension(i3, f16);
        }
        return f16;
    }

    public int getDimensionPixelOffset(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getDimensionPixelOffset(i3, i16);
        }
        return i16;
    }

    public int getDimensionPixelSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getDimensionPixelSize(i3, i16);
        }
        return i16;
    }

    public Drawable getDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Drawable) iPatchRedirector.redirect((short) 23, (Object) this, i3);
        }
        if (i3 >= 0) {
            return this.f384701a.getDrawable(i3);
        }
        return null;
    }

    public float getFloat(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Float.valueOf(f16))).floatValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getFloat(i3, f16);
        }
        return f16;
    }

    public float getFraction(int i3, int i16, int i17, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Float) iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(f16))).floatValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getFraction(i3, i16, i17, f16);
        }
        return f16;
    }

    public int getIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        return this.f384701a.getIndex(i3);
    }

    public int getIndexCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f384701a.getIndexCount();
    }

    public int getInt(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getInt(i3, i16);
        }
        return i16;
    }

    public int getInteger(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getInteger(i3, i16);
        }
        return i16;
    }

    public int getLayoutDimension(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? this.f384701a.getLayoutDimension(i3, str) : ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, i3, (Object) str)).intValue();
    }

    public String getNonResourceString(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        if (i3 >= 0) {
            return this.f384701a.getNonResourceString(i3);
        }
        return null;
    }

    public String getPositionDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.f384701a.getPositionDescription();
    }

    public int getResourceId(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getResourceId(i3, i16);
        }
        return i16;
    }

    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Resources) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f384701a.getResources();
    }

    public String getString(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (i3 >= 0) {
            return this.f384701a.getString(i3);
        }
        return null;
    }

    public CharSequence getText(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        if (i3 >= 0) {
            return this.f384701a.getText(i3);
        }
        return null;
    }

    public CharSequence[] getTextArray(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (CharSequence[]) iPatchRedirector.redirect((short) 24, (Object) this, i3);
        }
        if (i3 >= 0) {
            return this.f384701a.getTextArray(i3);
        }
        return null;
    }

    public boolean getValue(int i3, TypedValue typedValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, i3, (Object) typedValue)).booleanValue();
        }
        if (i3 >= 0) {
            return this.f384701a.getValue(i3, typedValue);
        }
        return false;
    }

    public boolean hasValue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, i3)).booleanValue();
        }
        if (i3 >= 0) {
            return this.f384701a.hasValue(i3);
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f384701a.hashCode();
    }

    public int length() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f384701a.length();
    }

    public TypedValue peekValue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (TypedValue) iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
        if (i3 >= 0) {
            return this.f384701a.peekValue(i3);
        }
        return null;
    }

    public void recycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            this.f384701a.recycle();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.f384701a.toString();
    }

    public int getLayoutDimension(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? i3 >= 0 ? this.f384701a.getLayoutDimension(i3, i16) : i16 : ((Integer) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
    }
}
