package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J(\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007JX\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JX\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/webviewplugin/O3ReportUtil;", "", "", "i", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "chatType", "", "chatUin", "impeachUinParam", "troopUin", "", "k", "j", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "buddyFlag", "selfUin", "scene", "reportMsg", "msgCount", "msgEncBase64", "Landroid/os/Bundle;", QQBrowserActivity.APP_PARAM, "d", tl.h.F, "g", "f", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class O3ReportUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final O3ReportUtil f97341a = new O3ReportUtil();

    O3ReportUtil() {
    }

    @JvmStatic
    public static final void d(@NotNull final QBaseActivity activity, @NotNull final String senderUin, @NotNull final String buddyFlag, @NotNull final String troopUin, @NotNull final String selfUin, final int scene, @NotNull final String reportMsg, final int msgCount, @NotNull final String msgEncBase64, @NotNull final Bundle extraParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(buddyFlag, "buddyFlag");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(reportMsg, "reportMsg");
        Intrinsics.checkNotNullParameter(msgEncBase64, "msgEncBase64");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        if (i()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.webviewplugin.s
                @Override // java.lang.Runnable
                public final void run() {
                    O3ReportUtil.e(QBaseActivity.this, senderUin, buddyFlag, troopUin, selfUin, scene, reportMsg, msgCount, msgEncBase64, extraParams);
                }
            }, 16, null, true);
        } else {
            NewReportPlugin.b(activity, senderUin, buddyFlag, troopUin, selfUin, scene, reportMsg, msgCount, msgEncBase64, extraParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(QBaseActivity activity, String senderUin, String buddyFlag, String troopUin, String selfUin, int i3, String reportMsg, int i16, String msgEncBase64, Bundle extraParams) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(senderUin, "$senderUin");
        Intrinsics.checkNotNullParameter(buddyFlag, "$buddyFlag");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(selfUin, "$selfUin");
        Intrinsics.checkNotNullParameter(reportMsg, "$reportMsg");
        Intrinsics.checkNotNullParameter(msgEncBase64, "$msgEncBase64");
        Intrinsics.checkNotNullParameter(extraParams, "$extraParams");
        f97341a.f(activity, senderUin, buddyFlag, troopUin, selfUin, i3, reportMsg, i16, msgEncBase64, extraParams);
    }

    private final void f(QBaseActivity activity, String senderUin, String buddyFlag, String troopUin, String selfUin, int scene, String reportMsg, int msgCount, String msgEncBase64, Bundle extraParams) {
        Integer num;
        if (QLog.isDebugVersion()) {
            QLog.d("O3ReportUtil", 4, "handleActionSheetReport, senderUin=" + senderUin + ", reportMsg=" + reportMsg);
        }
        com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
        String str = "10006";
        switch (scene) {
            case 25060:
                str = "10098";
                break;
            case 100730:
                str = "100730";
                break;
            case 101063:
                str = String.valueOf(scene);
                break;
            case 101064:
                str = String.valueOf(scene);
                break;
            case 101082:
                str = String.valueOf(scene);
                break;
        }
        bVar.i(str);
        bVar.n(senderUin);
        bVar.o(2);
        bVar.j(buddyFlag);
        bVar.r(troopUin);
        bVar.q(troopUin);
        int i3 = 0;
        bVar.s(0);
        bVar.m(NewReportPlugin.m(activity, scene, senderUin, extraParams));
        bVar.l(senderUin);
        if (extraParams.containsKey("chattype")) {
            Object obj = extraParams.get("chattype");
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            }
        }
        bVar.k(String.valueOf(i3));
        bVar.x(NewReportPlugin.h("REPORT_IP=0&EVIL_IP=0", true));
        bVar.v(reportMsg);
        bVar.u(msgEncBase64);
        bVar.t(String.valueOf(msgCount));
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(activity, bVar);
    }

    private final void g(final QBaseActivity activity, int chatType, String chatUin, String impeachUinParam, String troopUin) {
        String str;
        String str2;
        if (QLog.isDebugVersion()) {
            QLog.d("O3ReportUtil", 4, "handleSafetyReportForChat, chatType=" + chatType + ", chatUin=" + chatUin + ", impeachUinParam=" + impeachUinParam);
        }
        final com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
        String str3 = "10005";
        bVar.i("10005");
        if (chatType != 0) {
            if (chatType != 1003) {
                if (chatType != 1022) {
                    if (chatType != 1046) {
                        if (chatType != 10008) {
                            if (chatType != 1000) {
                                if (chatType == 1001) {
                                    str3 = "10022";
                                }
                            } else {
                                str3 = "10105";
                            }
                        } else {
                            str3 = "100985";
                        }
                    } else {
                        str3 = "10133";
                    }
                } else {
                    str3 = "10039";
                }
            } else {
                str3 = "10250";
            }
        }
        bVar.i(str3);
        if (h(chatUin)) {
            if (chatType == 1) {
                str2 = "101063";
            } else {
                str2 = "100730";
            }
            bVar.i(str2);
        }
        bVar.n(chatUin);
        bVar.o(2);
        bVar.r(troopUin);
        bVar.q(troopUin);
        if (chatType == 0) {
            str = "1";
        } else {
            str = "0";
        }
        bVar.j(str);
        bVar.s(0);
        bVar.l(chatUin);
        bVar.k(String.valueOf(chatType));
        bVar.x(NewReportPlugin.h("REPORT_IP=0&EVIL_IP=0", true));
        int u16 = NewReportPlugin.u(chatType);
        Bundle G = NewReportPlugin.G(chatUin, chatType);
        Bundle P = NewReportPlugin.P(u16, activity, chatUin, "", G);
        String valueOf = String.valueOf(G.getLong("anonymousseq"));
        if (!TextUtils.isEmpty(valueOf)) {
            bVar.m("anonymousseq=" + valueOf);
        }
        NTJuBaoUtil.b("", chatUin, "", u16, P, new Function1<String, Unit>() { // from class: com.tencent.biz.webviewplugin.O3ReportUtil$handleSafetyReportForChat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str4) {
                invoke2(str4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String reportMsg) {
                Intrinsics.checkNotNullParameter(reportMsg, "reportMsg");
                com.tencent.mobileqq.dt.api.b.this.v(reportMsg);
                ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(activity, com.tencent.mobileqq.dt.api.b.this);
            }
        });
    }

    private final boolean h(String chatUin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return ((ITroopRobotService) peekAppRuntime.getRuntimeService(ITroopRobotService.class, "")).isRobotUin(chatUin);
    }

    @JvmStatic
    private static final boolean i() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("relation_8968_secure_report_upgrade", false);
    }

    @JvmStatic
    public static final void j(@NotNull final QBaseActivity activity, final int chatType, @NotNull final String chatUin, @NotNull final String impeachUinParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(chatUin, "chatUin");
        Intrinsics.checkNotNullParameter(impeachUinParam, "impeachUinParam");
        if (i()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.webviewplugin.t
                @Override // java.lang.Runnable
                public final void run() {
                    O3ReportUtil.m(QBaseActivity.this, chatType, chatUin, impeachUinParam);
                }
            }, 16, null, true);
        } else {
            NewReportPlugin.U(activity, chatType, chatUin, impeachUinParam);
        }
    }

    @JvmStatic
    public static final void k(@NotNull final QBaseActivity activity, final int chatType, @NotNull final String chatUin, @NotNull final String impeachUinParam, @NotNull final String troopUin) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(chatUin, "chatUin");
        Intrinsics.checkNotNullParameter(impeachUinParam, "impeachUinParam");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (i()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.webviewplugin.u
                @Override // java.lang.Runnable
                public final void run() {
                    O3ReportUtil.l(QBaseActivity.this, chatType, chatUin, impeachUinParam, troopUin);
                }
            }, 16, null, true);
        } else {
            NewReportPlugin.V(activity, chatType, chatUin, impeachUinParam, troopUin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QBaseActivity activity, int i3, String chatUin, String impeachUinParam, String troopUin) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(chatUin, "$chatUin");
        Intrinsics.checkNotNullParameter(impeachUinParam, "$impeachUinParam");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        f97341a.g(activity, i3, chatUin, impeachUinParam, troopUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QBaseActivity activity, int i3, String chatUin, String impeachUinParam) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(chatUin, "$chatUin");
        Intrinsics.checkNotNullParameter(impeachUinParam, "$impeachUinParam");
        f97341a.g(activity, i3, chatUin, impeachUinParam, "");
    }
}
