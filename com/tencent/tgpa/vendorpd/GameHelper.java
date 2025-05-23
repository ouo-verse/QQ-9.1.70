package com.tencent.tgpa.vendorpd;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tgpa.vendorpd.GamePredownloader;
import com.tencent.tgpa.vendorpd.gradish.GradishWrapper;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GameHelper {
    static IPatchRedirector $redirector_;
    private static volatile GamePredownloader mInstance;

    public GameHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int combinePackage(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return getGamePredownloader().combinePackage(context, str, str2, str3, str4, str5, str6);
    }

    public static void enableDebug(boolean z16) {
        getGamePredownloader().enableDebug(z16);
    }

    private static GamePredownloader getGamePredownloader() {
        if (mInstance == null) {
            synchronized (GameHelper.class) {
                if (mInstance == null) {
                    mInstance = new GamePredownloaderImpl();
                }
            }
        }
        return mInstance;
    }

    public static void getGameVersionUpdateInfo(Context context, String str, ArrayList<String> arrayList, GameCallback gameCallback) {
        getGamePredownloader().getGameVersionUpdateInfo(context, str, arrayList, gameCallback);
    }

    public static void init(String str, String str2) {
        getGamePredownloader().setApiKey(str);
        getGamePredownloader().setApiSecret(str2);
    }

    public static void reportPreDownladInfo(Context context, HashMap<String, String> hashMap) {
        getGamePredownloader().reportPreDownladInfo(context, hashMap);
    }

    public static void setLogAble(boolean z16) {
        getGamePredownloader().setLogAble(z16);
    }

    public static void init(String str, String str2, GamePredownloader.LibLoader libLoader) {
        getGamePredownloader().setApiKey(str);
        getGamePredownloader().setApiSecret(str2);
        GradishWrapper.tryLoadLibrary(libLoader);
    }

    @Deprecated
    public static void reportPreDownladInfo(HashMap<String, String> hashMap) {
        getGamePredownloader().reportPreDownladInfo(null, hashMap);
    }

    public static void init(String str, String str2, String str3) {
        getGamePredownloader().setApiKey(str);
        getGamePredownloader().setApiSecret(str2);
        getGamePredownloader().setDeviceIdentifier(str3);
    }
}
