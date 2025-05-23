package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import com.tencent.util.Pair;

/* compiled from: P */
/* loaded from: classes20.dex */
public class l {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Pair<Integer, String> b() {
        VasMMKVProxy d16 = d();
        return new Pair<>(Integer.valueOf(d16.decodeInt(JsonRuleKey.OPERATOR, 0)), d16.decodeString("phoneNum", ""));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Pair<Boolean, Integer> c() {
        VasMMKVProxy d16 = d();
        return new Pair<>(Boolean.valueOf(d16.decodeBool(KingCardJsPlugin.BUSINESS_NAME, false)), Integer.valueOf(d16.decodeInt("kingCardProduct", 0)));
    }

    private static VasMMKVProxy d() {
        return VasMMKV.getKingCard("sdk");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean e() {
        return d().decodeBool("supportActivationView", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean j(@NonNull String str, @NonNull c25.f fVar) {
        boolean z16;
        boolean z17;
        VasMMKVProxy d16 = d();
        int i3 = -1;
        if (d16.decodeInt("kingCardProduct", -1) != fVar.f30243b) {
            d16.encodeString("phoneNum", fVar.f30244c);
            d16.encodeInt(JsonRuleKey.OPERATOR, fVar.f30245d);
            d16.encodeInt("kingCardProduct", fVar.f30243b);
            if (fVar.f30242a > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            d16.encodeBool(KingCardJsPlugin.BUSINESS_NAME, z17);
        }
        VasMMKVProxy kingCard = VasMMKV.getKingCard(str);
        int decodeInt = kingCard.decodeInt("kingCardSdk", -1);
        IKingCardManager kingCardManager = VasUtil.getService().getKingCardManager();
        int i16 = fVar.f30242a;
        if (i16 != 0) {
            if (i16 == 1) {
                if (fVar.f30243b == 90155946) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
            } else {
                i3 = 0;
            }
        }
        if (decodeInt == i3) {
            return false;
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        kingCardManager.setKingCardState(z16);
        kingCard.encodeInt("kingCardSdk", i3);
        kingCard.encodeInt("toast_version", 0);
        kingCard.encodeInt("popup_version_v2", 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void k(boolean z16) {
        d().encodeBool("supportActivationView", z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.i(m(), 2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(Activity activity) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(TMSManager.a aVar, boolean z16) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        throw null;
    }

    String m() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Runnable runnable) {
        throw null;
    }
}
