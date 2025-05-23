package com.tencent.theme.font;

import android.graphics.Typeface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes26.dex */
public class OppoFontHook implements IFontHook {
    static IPatchRedirector $redirector_;
    private static boolean sIsHook;
    private Field mCurrentTypefaceField;
    private Typeface[] mCurrentTypefacesCache;

    public OppoFontHook() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Field getCurrentTypefaceField() {
        Field field = null;
        try {
            field = Class.forName("oppo.content.res.OppoFontUtils").getDeclaredField("sCurrentTypefaces");
            field.setAccessible(true);
            return field;
        } catch (Exception unused) {
            return field;
        }
    }

    @Override // com.tencent.theme.font.IFontHook
    public boolean hookFont() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (sIsHook) {
            return false;
        }
        if (this.mCurrentTypefaceField == null) {
            this.mCurrentTypefaceField = getCurrentTypefaceField();
        }
        Field field = this.mCurrentTypefaceField;
        if (field != null) {
            try {
                this.mCurrentTypefacesCache = (Typeface[]) field.get(null);
                Field declaredField = Typeface.class.getDeclaredField("sDefaults");
                declaredField.setAccessible(true);
                this.mCurrentTypefaceField.set(null, (Typeface[]) declaredField.get(null));
            } catch (Exception unused) {
            }
            sIsHook = true;
        }
        return sIsHook;
    }

    @Override // com.tencent.theme.font.IFontHook
    public boolean restore() {
        Typeface[] typefaceArr;
        Field field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!sIsHook || (typefaceArr = this.mCurrentTypefacesCache) == null || (field = this.mCurrentTypefaceField) == null) {
            return false;
        }
        try {
            field.set(null, typefaceArr);
            sIsHook = false;
        } catch (IllegalAccessException unused) {
        }
        return !sIsHook;
    }
}
