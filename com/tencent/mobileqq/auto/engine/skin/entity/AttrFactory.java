package com.tencent.mobileqq.auto.engine.skin.entity;

import android.content.Context;
import com.tencent.mobileqq.auto.engine.skin.loader.ContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AttrFactory {
    static IPatchRedirector $redirector_;
    private static final String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7796);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAG = "SKIN" + AttrFactory.class.getSimpleName();
    }

    public AttrFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SkinAttr createAttr(Context context, String str, int i3, String str2, String str3) {
        if (i3 == 0) {
            return null;
        }
        try {
            SkinAttr createAttrByName = createAttrByName(str, str3);
            if (createAttrByName != null) {
                createAttrByName.setBaseValue(context, str, str2, ContextHolder.getContext().getResources().getResourceTypeName(i3), i3);
            }
            return createAttrByName;
        } catch (Exception unused) {
            return null;
        }
    }

    private static SkinAttr createAttrByName(String str, String str2) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1240751833:
                if (str.equals("TextColorAttr")) {
                    c16 = 0;
                    break;
                }
                break;
            case -289402411:
                if (str.equals("SrcAttr")) {
                    c16 = 1;
                    break;
                }
                break;
            case 424945759:
                if (str.equals("BackgroundAttr")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return new TextColorAttr(str2);
            case 1:
                return new SrcAttr(str2);
            case 2:
                return new BackgroundAttr(str2);
            default:
                return null;
        }
    }
}
