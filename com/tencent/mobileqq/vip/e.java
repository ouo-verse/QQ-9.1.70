package com.tencent.mobileqq.vip;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static int a() {
        return b(VasUtil.getCurrentUin());
    }

    public static int b(String str) {
        VasMMKVProxy kingCard = VasMMKV.getKingCard(str);
        int decodeInt = kingCard.decodeInt("kingCardSdk", -1);
        int decodeInt2 = kingCard.decodeInt(KingCardJsPlugin.BUSINESS_NAME, -1);
        int decodeInt3 = kingCard.decodeInt("kingCard2", -1);
        if (decodeInt >= 0) {
            if (decodeInt > 0) {
                return 1;
            }
            return 0;
        }
        if (decodeInt2 < 0 && decodeInt3 < 0) {
            return -1;
        }
        if (decodeInt2 > 0 || decodeInt3 > 0) {
            return 1;
        }
        return 0;
    }
}
