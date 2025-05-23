package com.tencent.mobileqq.troop.troopnotification.report;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyInvitorRole;
import com.tencent.qqnt.notification.f;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J<\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/report/a;", "", "", "uin", "groupId", "", "reasonCode", "pid", "eid", "", "f", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/notification/f;", "msg", "", "a", "g", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "e", "c", "b", "d", "p", "", "isExtraTag", "o", "k", h.F, "j", "i", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f300918a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59734);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f300918a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(String eid, View view, f msg2) {
        String str;
        VideoReport.setElementId(view, eid);
        com.tencent.qqnt.notification.b b16 = msg2.b();
        if (b16 == null || (str = b16.c()) == null) {
            str = "";
        }
        VideoReport.setElementParams(view, f(str, String.valueOf(msg2.j().group.groupCode), (int) msg2.j().joinGroupSuspiciousCode, "pg_group_add_apply", eid));
    }

    private final Map<String, String> f(String uin, String groupId, int reasonCode, String pid, String eid) {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("dt_pgid", pid), TuplesKt.to("dt_eid", eid), TuplesKt.to("to_uin", uin), TuplesKt.to("group_id", groupId), TuplesKt.to("suspicious_reason", String.valueOf(reasonCode)));
        return mutableMapOf;
    }

    private final String g(f msg2) {
        if (msg2.c() != 1) {
            return "";
        }
        int i3 = msg2.j().originMsgType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 22) {
                    return "";
                }
            } else {
                return "0";
            }
        }
        return "1";
    }

    public final void b(@NotNull View view, @NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a("em_group_refuse_btn", view, msg2);
    }

    public final void c(@NotNull View view, @NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a("em_group_agree_btn", view, msg2);
    }

    public final void d(@NotNull View view, @NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a("em_group_risk_warn", view, msg2);
    }

    public final void e(@NotNull FragmentActivity activity, @NotNull View view, @NotNull f msg2) {
        String str;
        Map mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, view, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        VideoReport.setPageId(view, "pg_group_add_apply");
        Pair[] pairArr = new Pair[3];
        com.tencent.qqnt.notification.b b16 = msg2.b();
        if (b16 == null || (str = b16.c()) == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("to_uin", str);
        pairArr[1] = TuplesKt.to("group_id", String.valueOf(msg2.j().group.groupCode));
        pairArr[2] = TuplesKt.to("suspicious_reason", String.valueOf(msg2.j().joinGroupSuspiciousCode));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) mapOf));
        VideoReport.addToDetectionWhitelist(activity);
    }

    public final void h(@NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        ReportController.o(f16, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "report", 0, 0, String.valueOf(msg2.j().group.groupCode), g(msg2), "", "");
    }

    public final void i(@NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "again_join", 0, 0, String.valueOf(msg2.j().group.groupCode));
        }
    }

    public final void j(@NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "again_join", 0, 0, String.valueOf(msg2.j().group.groupCode));
        }
    }

    public final void k(@NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        ReportController.o(f16, "P_CliOper", "Grp_sysmsg", "", "verify_msg", "black", 0, 0, String.valueOf(msg2.j().group.groupCode), g(msg2), "", "");
    }

    public final void l(@NotNull f msg2) {
        Integer num;
        String str;
        boolean z16;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        boolean z17 = false;
        if (msg2.j().originMsgType != 1 && msg2.j().originMsgType != 22) {
            if (msg2.g()) {
                str = "0";
            } else {
                str = "1";
            }
            if (msg2.j().invitationExt.invitorRole != GroupNotifyInvitorRole.GROUP_OWNER && msg2.j().invitationExt.invitorRole != GroupNotifyInvitorRole.GROUP_ADMIN) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (msg2.j().originMsgType == 2) {
                String valueOf = String.valueOf(msg2.j().group.groupCode);
                if (z16) {
                    str3 = "0";
                } else {
                    str3 = "1";
                }
                ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "refuse_invite", 0, 0, valueOf, str, str3, "1");
                return;
            }
            if (msg2.j().originMsgType == 1) {
                String valueOf2 = String.valueOf(msg2.j().group.groupCode);
                String str4 = msg2.j().warningTips;
                if (str4 == null || str4.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "refuse_ask", 0, 0, valueOf2, str, str2, "1");
                return;
            }
            return;
        }
        if (msg2.c() == -1000) {
            eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "unnormal_edit_reject", 0, 0, String.valueOf(msg2.j().group.groupCode), String.valueOf(msg2.j().originMsgType), msg2.j().warningTips);
        }
        ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "refuse_ask_has_reason", 0, 0, String.valueOf(msg2.j().group.groupCode), String.valueOf(msg2.j().originMsgType), "", "1");
        int c16 = msg2.c();
        if (c16 != 0) {
            if (c16 != 1) {
                num = null;
            } else {
                num = 2;
            }
        } else {
            num = 1;
        }
        if (num != null) {
            ReportController.o(f16, "dc00899", "Grp_contacts_news", "", UinConfigManager.KEY_ADS, "todotab_noticeinfo_reject", num.intValue(), 0, String.valueOf(msg2.j().group.groupCode), String.valueOf(msg2.j().originMsgType), String.valueOf(msg2.j().seq), "");
        }
    }

    public final void m(@NotNull f msg2) {
        String str;
        boolean z16;
        int i3;
        int i16;
        String str2;
        Integer valueOf;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        boolean z17 = false;
        if (msg2.c() == -1000) {
            eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "unnormal_edit_join", 0, 0, String.valueOf(msg2.j().group.groupCode), String.valueOf(msg2.j().originMsgType), msg2.j().warningTips);
        }
        if (msg2.g()) {
            str = "0";
        } else {
            str = "1";
        }
        if (msg2.j().invitationExt.invitorRole != GroupNotifyInvitorRole.GROUP_OWNER && msg2.j().invitationExt.invitorRole != GroupNotifyInvitorRole.GROUP_ADMIN) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (msg2.j().originMsgType == 2) {
            String str4 = str;
            String valueOf2 = String.valueOf(msg2.j().group.groupCode);
            if (z16) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            i3 = 2;
            ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "agree_invite", 0, 0, valueOf2, str4, str3, "1");
            i16 = 1;
        } else {
            String str5 = str;
            i3 = 2;
            if (msg2.j().originMsgType == 1) {
                String valueOf3 = String.valueOf(msg2.j().group.groupCode);
                String str6 = msg2.j().warningTips;
                if (str6 == null || str6.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                i16 = 1;
                ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "agree_ask", 0, 0, valueOf3, str5, str2, "1");
            } else {
                i16 = 1;
            }
        }
        int c16 = msg2.c();
        if (c16 != 0) {
            if (c16 != i16) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(i3);
            }
        } else {
            valueOf = Integer.valueOf(i16);
        }
        if (valueOf != null) {
            ReportController.o(f16, "dc00899", "Grp_contacts_news", "", UinConfigManager.KEY_ADS, "todotab_noticeinfo_confirm", valueOf.intValue(), 0, String.valueOf(msg2.j().group.groupCode), String.valueOf(msg2.j().originMsgType), String.valueOf(msg2.j().seq), "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(@NotNull f msg2) {
        String str;
        String str2;
        String str3;
        int c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        if (msg2.g()) {
            str = "0";
        } else {
            str = "1";
        }
        int i3 = msg2.j().originMsgType;
        Integer num = null;
        if (i3 != 1) {
            if (i3 != 2) {
                str3 = null;
                if (str3 != null) {
                    eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, str3, 0, 0, String.valueOf(msg2.j().group.groupCode), str);
                }
                c16 = msg2.c();
                if (c16 == 0) {
                    if (c16 == 1) {
                        num = 2;
                    }
                } else {
                    num = 1;
                }
                if (num == null) {
                    ReportController.o(f16, "dc00899", "Grp_contacts_news", "", UinConfigManager.KEY_ADS, "todotab_noticeinfo_ignore", num.intValue(), 0, String.valueOf(msg2.j().group.groupCode), String.valueOf(msg2.j().originMsgType), String.valueOf(msg2.j().seq), "");
                    return;
                }
                return;
            }
            str2 = "ignore_invite";
        } else {
            str2 = "ignore_ask";
        }
        str3 = str2;
        if (str3 != null) {
        }
        c16 = msg2.c();
        if (c16 == 0) {
        }
        if (num == null) {
        }
    }

    public final void o(boolean isExtraTag, @NotNull f msg2) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(isExtraTag), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        if (isExtraTag) {
            int i3 = msg2.j().originMsgType;
            if (i3 != 3) {
                if (i3 != 11) {
                    if (i3 != 6 && i3 != 7) {
                        if (i3 != 15 && i3 != 16) {
                            str = "3";
                        }
                    } else {
                        str = "2";
                    }
                } else {
                    str = "0";
                }
            }
            str = "1";
        } else {
            str = "";
        }
        ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "see_fromdata", 0, 0, String.valueOf(msg2.j().group.groupCode), str, "", "");
        eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "see_fromdata", 0, 0, String.valueOf(msg2.j().group.groupCode), str);
    }

    public final void p(@NotNull f msg2) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        if (msg2.j().originMsgType != 2 && msg2.j().originMsgType != 10 && msg2.j().originMsgType != 12) {
            z16 = false;
        } else {
            z16 = true;
        }
        String valueOf = String.valueOf(msg2.j().group.groupCode);
        String str2 = "0";
        if (z16) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "see_data", 0, 0, valueOf, str, "", "");
        String[] strArr = new String[2];
        strArr[0] = String.valueOf(msg2.j().group.groupCode);
        if (!z16) {
            str2 = "1";
        }
        strArr[1] = str2;
        eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "see_data", 0, 0, strArr);
    }
}
