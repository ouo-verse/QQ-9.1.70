package com.tencent.mobileqq.upgrade;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
    
        if (r0 != 4) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a() {
        int netWorkType = HttpUtil.getNetWorkType();
        int i3 = 1;
        if (netWorkType != 1) {
            int i16 = 2;
            if (netWorkType != 2) {
                i3 = 3;
                if (netWorkType != 3) {
                    i16 = 4;
                }
                i3 = i16;
            }
        } else {
            i3 = 0;
        }
        return String.valueOf(i3);
    }

    public static String b() {
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType != 1) {
            if (netWorkType != 2) {
                if (netWorkType != 3) {
                    if (netWorkType != 4) {
                        return "X";
                    }
                    return QADNetStatus.G_4;
                }
                return QADNetStatus.G_3;
            }
            return QADNetStatus.G_2;
        }
        return "wifi";
    }
}
