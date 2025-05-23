package com.tencent.mqpsdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f336148a;

    /* renamed from: b, reason: collision with root package name */
    public static String f336149b;

    /* renamed from: c, reason: collision with root package name */
    public static String f336150c;

    /* renamed from: d, reason: collision with root package name */
    public static String f336151d;

    /* renamed from: e, reason: collision with root package name */
    public static String f336152e;

    /* renamed from: f, reason: collision with root package name */
    public static String f336153f;

    /* renamed from: g, reason: collision with root package name */
    public static String f336154g;

    /* renamed from: h, reason: collision with root package name */
    public static String f336155h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77450);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f336148a = "ctnet";
        f336149b = "ctwap";
        f336150c = "cmnet";
        f336151d = "cmwap";
        f336152e = "uninet";
        f336153f = "uniwap";
        f336154g = "3gnet";
        f336155h = "3gwap";
    }

    public static String a(Context context) {
        String currentAPN = AppNetConnInfo.getCurrentAPN();
        if (!TextUtils.isEmpty(currentAPN)) {
            if (currentAPN.startsWith(f336148a)) {
                return f336148a;
            }
            if (currentAPN.startsWith(f336149b)) {
                return f336149b;
            }
            if (currentAPN.startsWith(f336150c)) {
                return f336150c;
            }
            if (currentAPN.startsWith(f336151d)) {
                return f336151d;
            }
            if (currentAPN.startsWith(f336152e)) {
                return f336152e;
            }
            if (currentAPN.startsWith(f336153f)) {
                return f336153f;
            }
            if (currentAPN.startsWith(f336154g)) {
                return f336154g;
            }
            if (currentAPN.startsWith(f336155h)) {
                return f336155h;
            }
        }
        return "nomatch";
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
    
        if (r3 != 1) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(Context context) {
        int connInfo = AppNetConnInfo.getConnInfo();
        int i3 = 1;
        if (connInfo == 0) {
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            if (mobileInfo != 1) {
                i3 = 3;
                if (mobileInfo != 2) {
                    if (mobileInfo == 3) {
                        i3 = 4;
                    }
                    i3 = 0;
                }
            } else {
                i3 = 2;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("NetUtil", 2, "getNetType " + i3);
        }
        return i3;
    }
}
