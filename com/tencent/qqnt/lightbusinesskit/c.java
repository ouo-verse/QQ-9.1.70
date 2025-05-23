package com.tencent.qqnt.lightbusinesskit;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.UIConfig;
import com.tencent.qqnt.msg.f;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/lightbusinesskit/c;", "", "", "a", "", "b", "<init>", "()V", "qq-light-business-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f359323a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f359323a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00db  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String a() {
        boolean z16;
        String str;
        ExpEntityInfo expEntity;
        boolean z17;
        if (ABTestController.getInstance().isTabInited(ABTestController.APPID_1505)) {
            ExpEntityInfo expEntity2 = ABTestController.getInstance().getExpEntity("exp_friend_message_dynamic_reminder");
            Intrinsics.checkNotNullExpressionValue(expEntity2, "getInstance().getExpEnti\u2026MESSAGE_DYNAMIC_REMINDER)");
            boolean z18 = false;
            if (expEntity2.isExpOnline() && expEntity2.isExperiment("exp_friend_message_dynamic_remind_1_B")) {
                z16 = true;
            } else {
                z16 = false;
            }
            String str2 = "1";
            if (!expEntity2.isExpInvalid()) {
                QLog.d("RevealConfigSwitch", 2, "experiment1 isExperimentB:" + z16);
                if (z16) {
                    str = "1";
                    String str3 = str;
                    expEntity2.reportExpExposure();
                    expEntity = ABTestController.getInstance().getExpEntity("exp_friend_message_dynamic_reminder_4");
                    Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026SSAGE_DYNAMIC_REMINDER_4)");
                    if (!expEntity.isExpOnline() && expEntity.isExperiment("exp_friend_message_dynamic_reminder_4_B")) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (expEntity.isExpOnline() && expEntity.isExperiment("exp_friend_message_dynamic_reminder_4_C")) {
                        z18 = true;
                    }
                    if (!expEntity.isExpInvalid()) {
                        QLog.d("RevealConfigSwitch", 2, "experiment2 isExperimentB2:" + z17 + " isExperimentC2:" + z18);
                        if (z17) {
                            str = "1";
                            str3 = str;
                        }
                        if (z18) {
                            str3 = "2";
                            expEntity.reportExpExposure();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("qzone", str2);
                            jSONObject.put("qcircle", str3);
                            if (QLog.isDevelopLevel()) {
                                QLog.d("RevealConfigSwitch", 1, "isRevealExperiment " + jSONObject + ", expEntityInfo1.isExpOnline = " + expEntity2.isExpOnline() + ", expEntityInfo2.isExpOnline = " + expEntity.isExpOnline());
                            }
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "configJSON.toString()");
                            return jSONObject2;
                        }
                    }
                    str2 = str;
                    expEntity.reportExpExposure();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("qzone", str2);
                    jSONObject3.put("qcircle", str3);
                    if (QLog.isDevelopLevel()) {
                    }
                    String jSONObject22 = jSONObject3.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject22, "configJSON.toString()");
                    return jSONObject22;
                }
            }
            str = "0";
            String str32 = str;
            expEntity2.reportExpExposure();
            expEntity = ABTestController.getInstance().getExpEntity("exp_friend_message_dynamic_reminder_4");
            Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEnti\u2026SSAGE_DYNAMIC_REMINDER_4)");
            if (!expEntity.isExpOnline()) {
            }
            z17 = false;
            if (expEntity.isExpOnline()) {
                z18 = true;
            }
            if (!expEntity.isExpInvalid()) {
            }
            str2 = str;
            expEntity.reportExpExposure();
            JSONObject jSONObject32 = new JSONObject();
            jSONObject32.put("qzone", str2);
            jSONObject32.put("qcircle", str32);
            if (QLog.isDevelopLevel()) {
            }
            String jSONObject222 = jSONObject32.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject222, "configJSON.toString()");
            return jSONObject222;
        }
        QLog.d("RevealConfigSwitch", 1, "getConfig json empty");
        return "";
    }

    @JvmStatic
    public static final void b() {
        IQQNTWrapperSession k3;
        String a16 = a();
        boolean z16 = true;
        QLog.d("RevealConfigSwitch", 1, "[updateRevealConfig] is call. config=" + a16);
        if (a16.length() <= 0) {
            z16 = false;
        }
        if (z16 && (k3 = f.k()) != null) {
            k3.onUIConfigUpdate(UIConfig.KREVEALCFG, a16);
        }
    }
}
