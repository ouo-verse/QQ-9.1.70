package com.tencent.theme.font;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Field;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MiuiFontHook implements IFontHook {
    static IPatchRedirector $redirector_;
    private static HashSet<String> mFontsWhiteList;
    private static boolean sIsHook;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11195);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            sIsHook = false;
        }
    }

    public MiuiFontHook() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private HashSet<String> getFontsWhiteList() {
        Field field;
        try {
            try {
                field = Class.forName("miui.util.TypefaceUtils$FontsWhiteListHolder").getDeclaredField("mFontsWhiteList");
            } catch (Exception unused) {
                field = null;
            }
        } catch (Exception unused2) {
            field = Class.forName("miui.util.TypefaceUtils").getDeclaredField("mFontsWhiteList");
        }
        if (field != null) {
            field.setAccessible(true);
            try {
                HashSet<String> hashSet = (HashSet) field.get(null);
                mFontsWhiteList = hashSet;
                if (hashSet == null) {
                    HashSet<String> hashSet2 = new HashSet<>();
                    mFontsWhiteList = hashSet2;
                    field.set(null, hashSet2);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return mFontsWhiteList;
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
        if (mFontsWhiteList == null) {
            getFontsWhiteList();
        }
        HashSet<String> hashSet = mFontsWhiteList;
        if (hashSet != null && hashSet.contains("com.tencent.mobileqq")) {
            mFontsWhiteList.remove("com.tencent.mobileqq");
        }
        sIsHook = true;
        return true;
    }

    @Override // com.tencent.theme.font.IFontHook
    public boolean restore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (sIsHook) {
            try {
                HashSet<String> hashSet = mFontsWhiteList;
                if (hashSet != null) {
                    hashSet.add("com.tencent.mobileqq");
                }
                sIsHook = false;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return !sIsHook;
    }
}
