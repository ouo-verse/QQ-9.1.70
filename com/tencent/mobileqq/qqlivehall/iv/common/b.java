package com.tencent.mobileqq.qqlivehall.iv.common;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends Resources {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final Resources f274113a;

    public b(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources);
        } else {
            this.f274113a = resources;
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (XmlResourceParser) iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
        return this.f274113a.getAnimation(i3);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, i3)).booleanValue();
        }
        return this.f274113a.getBoolean(i3);
    }

    @Override // android.content.res.Resources
    public int getColor(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, i3)).intValue();
        }
        return this.f274113a.getColor(i3);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 23, (Object) this, i3);
        }
        return this.f274113a.getColorStateList(i3);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (Configuration) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.f274113a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this, i3)).floatValue();
        }
        return this.f274113a.getDimension(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, i3)).intValue();
        }
        return this.f274113a.getDimensionPixelOffset(i3);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        return this.f274113a.getDimensionPixelSize(i3);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? this.f274113a.getDrawable(i3) : (Drawable) iPatchRedirector.redirect((short) 17, (Object) this, i3);
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public Drawable getDrawableForDensity(int i3, int i16) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? this.f274113a.getDrawableForDensity(i3, i16) : (Drawable) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // android.content.res.Resources
    public float getFraction(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Float) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).floatValue();
        }
        return this.f274113a.getFraction(i3, i16, i17);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, this, str, str2, str3)).intValue();
        }
        return this.f274113a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (int[]) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        return this.f274113a.getIntArray(i3);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, i3)).intValue();
        }
        return this.f274113a.getInteger(i3);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (XmlResourceParser) iPatchRedirector.redirect((short) 26, (Object) this, i3);
        }
        return this.f274113a.getLayout(i3);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Movie) iPatchRedirector.redirect((short) 21, (Object) this, i3);
        }
        return this.f274113a.getMovie(i3);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i16, Object... objArr) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.f274113a.getQuantityString(i3, i16, objArr) : (String) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i3, int i16) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return this.f274113a.getQuantityText(i3, i16);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, (Object) this, i3);
        }
        return this.f274113a.getResourceEntryName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this, i3);
        }
        return this.f274113a.getResourceName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this, i3);
        }
        return this.f274113a.getResourcePackageName(i3);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this, i3);
        }
        return this.f274113a.getResourceTypeName(i3);
    }

    @Override // android.content.res.Resources
    public String getString(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f274113a.getString(i3) : (String) iPatchRedirector.redirect((short) 4, (Object) this, i3);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        return this.f274113a.getStringArray(i3);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f274113a.getText(i3) : (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CharSequence[]) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return this.f274113a.getTextArray(i3);
    }

    @Override // android.content.res.Resources
    public void getValue(int i3, TypedValue typedValue, boolean z16) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            this.f274113a.getValue(i3, typedValue, z16);
        } else {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(i3), typedValue, Boolean.valueOf(z16));
        }
    }

    @Override // android.content.res.Resources
    @RequiresApi(15)
    public void getValueForDensity(int i3, int i16, TypedValue typedValue, boolean z16) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), typedValue, Boolean.valueOf(z16));
        } else {
            this.f274113a.getValueForDensity(i3, i16, typedValue, z16);
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (XmlResourceParser) iPatchRedirector.redirect((short) 28, (Object) this, i3);
        }
        return this.f274113a.getXml(i3);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (TypedArray) iPatchRedirector.redirect((short) 35, (Object) this, (Object) attributeSet, (Object) iArr);
        }
        return this.f274113a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TypedArray) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        return this.f274113a.obtainTypedArray(i3);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) ? this.f274113a.openRawResource(i3) : (InputStream) iPatchRedirector.redirect((short) 29, (Object) this, i3);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i3) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (AssetFileDescriptor) iPatchRedirector.redirect((short) 31, (Object) this, i3);
        }
        return this.f274113a.openRawResourceFd(i3);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, str, attributeSet, bundle);
        } else {
            this.f274113a.parseBundleExtra(str, attributeSet, bundle);
        }
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) xmlResourceParser, (Object) bundle);
        } else {
            this.f274113a.parseBundleExtras(xmlResourceParser, bundle);
        }
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) configuration, (Object) displayMetrics);
            return;
        }
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f274113a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawable(int i3, Resources.Theme theme) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.f274113a.getDrawable(i3, theme) : (Drawable) iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) theme);
    }

    @Override // android.content.res.Resources
    @RequiresApi(21)
    public Drawable getDrawableForDensity(int i3, int i16, Resources.Theme theme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? this.f274113a.getDrawableForDensity(i3, i16, theme) : (Drawable) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), theme);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i3, int i16) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f274113a.getQuantityString(i3, i16) : (String) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // android.content.res.Resources
    public String getString(int i3, Object... objArr) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f274113a.getString(i3, objArr) : (String) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i3, CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.f274113a.getText(i3, charSequence) : (CharSequence) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) charSequence);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z16) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
            this.f274113a.getValue(str, typedValue, z16);
        } else {
            iPatchRedirector.redirect((short) 34, this, str, typedValue, Boolean.valueOf(z16));
        }
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i3, TypedValue typedValue) throws Resources.NotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) ? this.f274113a.openRawResource(i3, typedValue) : (InputStream) iPatchRedirector.redirect((short) 30, (Object) this, i3, (Object) typedValue);
    }
}
