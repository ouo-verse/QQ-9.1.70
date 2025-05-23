package com.tencent.mobileqq.qwallet;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJB\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007J!\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ^\u0010\u0013\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0007Jh\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/c;", "", "", "actionName", "r2", "r3", "r4", "r5", "", "e", "opName", "", "opType", "c", "(Ljava/lang/String;Ljava/lang/Integer;)V", "toUin", "optType", IProfileCardConst.KEY_FROM_TYPE, "result", "d", "Lmqq/app/AppRuntime;", "app", "g", "", "b", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f277112a = new c();

    c() {
    }

    private final boolean b() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void c(@NotNull String opName, @Nullable Integer opType) {
        int i3;
        Intrinsics.checkNotNullParameter(opName, "opName");
        if (opType != null) {
            i3 = opType.intValue();
        } else {
            i3 = -1;
        }
        d("", opName, QCircleDaTongConstant.ElementParamValue.WALLET, i3, 0, "", "", "android", AppSetting.f99551k);
    }

    @JvmStatic
    public static final void d(@Nullable String toUin, @Nullable String actionName, @Nullable String optType, int fromType, int result, @Nullable String r26, @Nullable String r36, @Nullable String r46, @Nullable String r56) {
        AppRuntime appRuntime;
        c cVar = f277112a;
        if (cVar.b()) {
            appRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        cVar.g(appRuntime, toUin, actionName, optType, fromType, result, r26, r36, r46, r56);
    }

    @JvmStatic
    public static final void e(@Nullable String actionName, @Nullable String r26, @Nullable String r36, @Nullable String r46, @Nullable String r56) {
        d("", actionName, QCircleDaTongConstant.ElementParamValue.WALLET, 0, 0, r26, r36, r46, r56);
    }

    public static /* synthetic */ void f(String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        if ((i3 & 8) != 0) {
            str4 = "";
        }
        if ((i3 & 16) != 0) {
            str5 = "";
        }
        e(str, str2, str3, str4, str5);
    }

    private final void g(final AppRuntime app, final String toUin, final String actionName, final String optType, final int fromType, final int result, final String r26, final String r36, final String r46, final String r56) {
        if (QLog.isDebugVersion()) {
            QLog.i("QWallet644Reporter", 4, "report: " + app + QbAddrData.DATA_SPLITER + toUin + QbAddrData.DATA_SPLITER + actionName + QbAddrData.DATA_SPLITER + optType + QbAddrData.DATA_SPLITER + fromType + QbAddrData.DATA_SPLITER + result + QbAddrData.DATA_SPLITER + r26 + QbAddrData.DATA_SPLITER + r36 + QbAddrData.DATA_SPLITER + r46 + QbAddrData.DATA_SPLITER + r56);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.b
            @Override // java.lang.Runnable
            public final void run() {
                c.h(AppRuntime.this, toUin, optType, actionName, fromType, result, r26, r36, r46, r56);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AppRuntime appRuntime, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7) {
        ReportController.o(appRuntime, "P_CliOper", "Vip_pay_mywallet", str, str2, str3, i3, i16, str4, str5, str6, str7);
    }
}
