package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h {
    static IPatchRedirector $redirector_;

    public static <T extends i> T a(Class<T> cls) {
        try {
            return (T) Class.forName(cls.getName()).newInstance();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static <T extends Thread> T b(Class<T> cls) {
        try {
            return (TroopUploadingThread) Class.forName(cls.getName()).newInstance();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
