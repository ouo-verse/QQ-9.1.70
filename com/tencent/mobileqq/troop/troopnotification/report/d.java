package com.tencent.mobileqq.troop.troopnotification.report;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyGroup;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyInvitorRole;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyUser;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import com.tencent.qqnt.notification.f;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J<\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00162\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J<\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00162\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001a2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010$\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010%\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010(\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010,\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010-\u001a\u00020\u0004R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u00101R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/report/d;", "", "Landroid/os/Bundle;", "params", "", "v", "", "inOut", "", "category", DomainData.DOMAIN_NAME, "Landroid/view/View;", "view", "", "eid", "Lcom/tencent/qqnt/notification/f;", "msg", "u", "uin", "groupId", "reasonCode", "pid", "", "e", "tab", h.F, "", "f", "(Lcom/tencent/qqnt/notification/f;)[Ljava/lang/String;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "g", "o", "t", "r", "p", "d", "c", "tabCategory", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "operateType", "i", "j", "k", "b", "I", "lastNoticeTab", "Ljava/util/Map;", "pageCustomParams", "", "categoryToReportId", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f300921a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int lastNoticeTab;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Object> pageCustomParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> categoryToReportId;

    static {
        Map<Integer, Integer> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        f300921a = new d();
        pageCustomParams = new LinkedHashMap();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, 1), TuplesKt.to(1, 2), TuplesKt.to(2, 3), TuplesKt.to(-1000, 4));
        categoryToReportId = mapOf;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, String> e(String uin, String groupId, int reasonCode, String pid, String eid) {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("dt_pgid", pid), TuplesKt.to("dt_eid", eid), TuplesKt.to("to_uin", uin), TuplesKt.to("group_id", groupId), TuplesKt.to("suspicious_reason", String.valueOf(reasonCode)));
        return mutableMapOf;
    }

    private final String[] f(f msg2) {
        String str;
        boolean z16;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String valueOf = String.valueOf(msg2.j().group.groupCode);
        String str9 = "0";
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
        int i3 = msg2.j().originMsgType;
        String str10 = null;
        if (i3 != 1) {
            str3 = "";
            if (i3 != 2) {
                if (i3 != 3) {
                    String str11 = "byquit_page";
                    if (i3 != 6) {
                        if (i3 != 7) {
                            str11 = "un_admin_page";
                            if (i3 != 15) {
                                if (i3 != 16) {
                                    if (i3 != 22) {
                                        switch (i3) {
                                            case 10:
                                                if (!z16) {
                                                    str9 = "1";
                                                }
                                                str7 = "refuseinvite_page";
                                                break;
                                            case 11:
                                                str8 = "refuseask_page";
                                                str4 = "";
                                                str3 = str8;
                                                str9 = str4;
                                                break;
                                            case 12:
                                                if (!z16) {
                                                    str9 = "1";
                                                }
                                                str7 = "refuseagree_page";
                                                break;
                                            case 13:
                                                str8 = "quit_page";
                                                str4 = "";
                                                str3 = str8;
                                                str9 = str4;
                                                break;
                                            default:
                                                str9 = "";
                                                str4 = str9;
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                        str4 = "";
                        str3 = str11;
                    }
                    str9 = "1";
                    str4 = "";
                    str3 = str11;
                } else {
                    GroupNotifyUser groupNotifyUser = msg2.j().actionUser;
                    if (groupNotifyUser != null) {
                        str6 = groupNotifyUser.uid;
                    } else {
                        str6 = null;
                    }
                    AppRuntime f16 = bg.f();
                    if (f16 != null) {
                        str10 = f16.getCurrentUid();
                    }
                    if (!Intrinsics.areEqual(str6, str10)) {
                        str9 = "1";
                    }
                    str7 = "set_admin_page";
                }
                str3 = str7;
                str4 = "";
            } else {
                if (msg2.c() != 1) {
                    str9 = "1";
                }
                str4 = str9;
                str9 = "";
                str3 = "enter_invite";
            }
            return new String[]{str3, valueOf, str, str9, str4};
        }
        if (msg2.c() == -1000) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        if (msg2.c() != 1) {
            GroupNotifyUser groupNotifyUser2 = msg2.j().actionUser;
            if (groupNotifyUser2 != null) {
                str5 = groupNotifyUser2.uid;
            } else {
                str5 = null;
            }
            AppRuntime f17 = bg.f();
            if (f17 != null) {
                str10 = f17.getCurrentUid();
            }
            if (!Intrinsics.areEqual(str5, str10)) {
                str9 = "1";
            } else {
                str9 = "2";
            }
        }
        str3 = "enter_askjoin";
        str4 = str9;
        str9 = str2;
        return new String[]{str3, valueOf, str, str9, str4};
    }

    private final Map<String, String> h(String uin, String groupId, int reasonCode, int tab, String eid) {
        Map<String, String> e16 = e(uin, groupId, reasonCode, "pg_group_notice", eid);
        e16.put("tab_name", String.valueOf(tab));
        return e16;
    }

    private final void n(boolean inOut, int category) {
        int i3;
        Integer num = categoryToReportId.get(Integer.valueOf(category));
        if (num != null) {
            int intValue = num.intValue();
            if (!inOut && lastNoticeTab == 0) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("dt_pgid", "pg_group_notice");
            linkedHashMap.putAll(pageCustomParams);
            if (inOut && (i3 = lastNoticeTab) != 0) {
                linkedHashMap.put("tab_name", String.valueOf(i3));
                VideoReport.reportEvent("pgout", linkedHashMap);
            }
            linkedHashMap.put("tab_name", String.valueOf(intValue));
            if (inOut) {
                VideoReport.reportEvent("pgin", linkedHashMap);
                lastNoticeTab = intValue;
            } else {
                VideoReport.reportEvent("pgout", linkedHashMap);
                lastNoticeTab = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int i3) {
        f300921a.n(false, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(int i3) {
        f300921a.n(true, i3);
    }

    private final void u(View view, String eid, f msg2) {
        String str;
        int i3;
        VideoReport.setElementId(view, eid);
        VideoReport.setElementReuseIdentifier(view, String.valueOf(msg2.j().seq));
        com.tencent.qqnt.notification.b b16 = msg2.b();
        if (b16 == null || (str = b16.c()) == null) {
            str = "";
        }
        String str2 = str;
        String valueOf = String.valueOf(msg2.j().group.groupCode);
        int i16 = (int) msg2.j().joinGroupSuspiciousCode;
        Integer num = categoryToReportId.get(Integer.valueOf(msg2.c()));
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        VideoReport.setElementParams(view, h(str2, valueOf, i16, i3, eid));
    }

    private final void v(Bundle params) {
        String str;
        if (params == null) {
            return;
        }
        int i3 = params.getInt("key_from", 0);
        Map<String, Object> map = pageCustomParams;
        if (i3 != 2) {
            if (i3 != 3) {
                str = "";
            } else {
                str = AegisLogger.PUSH;
            }
        } else {
            str = "msg_list";
        }
        map.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, str);
        String string = params.getString(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, "0");
        Intrinsics.checkNotNullExpressionValue(string, "params.getString(ILaunch\u2026ilApi.KEY_PUSH_TYPE, \"0\")");
        map.put(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, string);
    }

    public final void c(@NotNull View view, @NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        u(view, "em_group_agree", msg2);
    }

    public final void d(@NotNull View view, @NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        u(view, "em_group_user_profile", msg2);
    }

    public final void g(@NotNull FragmentActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        v(activity.getIntent().getExtras());
        ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "enter_verify", 0, 0, "", "", "", "");
        VideoReport.addToDetectionWhitelist(activity);
    }

    public final void i(@NotNull GroupNotifyOperateType operateType, @NotNull f msg2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) operateType, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        String[] f17 = f(msg2);
        if (msg2.c() == 1) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        if (msg2.c() == -1000) {
            eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "unnormal_join", 0, 0, String.valueOf(msg2.j().group.groupCode), String.valueOf(msg2.j().originMsgType), msg2.j().warningTips);
        } else {
            int i16 = msg2.j().originMsgType;
            if (i16 != 1) {
                if (i16 == 2) {
                    eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "agree_invite", 0, 0, f17[1], f17[2], f17[3], "0");
                }
            } else {
                eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "agree_ask", 0, 0, f17[1], f17[2], f17[3], "0");
            }
        }
        ReportController.o(f16, "dc00899", "Grp_contacts_news", "", UinConfigManager.KEY_ADS, "todotab_notice_confirm", i3, 0, f17[1], String.valueOf(msg2.j().originMsgType), String.valueOf(msg2.j().seq), "");
        if (msg2.j().originMsgType == 2) {
            ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "agree_invite", 0, 0, f17[1], "", "0", "0");
        }
    }

    public final void j(@NotNull f msg2) {
        com.tencent.qqnt.notification.b b16;
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null || (b16 = msg2.b()) == null) {
            return;
        }
        if (b16.b() == 2) {
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
            return;
        }
        ReportController.o(f16, "P_CliOper", "Grp_contacts", "", UinConfigManager.KEY_ADS, "see_fromdata", 0, 0, String.valueOf(msg2.j().group.groupCode), "3", "", "");
        eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "see_fromdata", 0, 0, String.valueOf(msg2.j().group.groupCode), "");
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        ReportController.o(f16, "dc00899", "Grp_contacts_news", "", UinConfigManager.KEY_ADS, "clear_clk", 0, 0, "", "", "", "");
    }

    public final void l(@NotNull f msg2) {
        String[] f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.c() == -1000) {
            f16 = new String[]{"unnormal_edit", String.valueOf(msg2.j().group.groupCode), String.valueOf(msg2.j().originMsgType), msg2.j().warningTips, ""};
        } else {
            f16 = f(msg2);
        }
        eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, f16[0], 3, 0, f16[1], f16[2], f16[3], f16[4]);
    }

    public final void m(int tabCategory, @NotNull f msg2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, tabCategory, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        if (tabCategory != 0) {
            if (tabCategory != 1) {
                return;
            } else {
                i3 = 2;
            }
        } else {
            i3 = 1;
        }
        ReportController.o(f16, "dc00899", "Grp_contacts_news", "", UinConfigManager.KEY_ADS, "todotab_notice_exp", i3, 0, String.valueOf(msg2.j().seq), String.valueOf(msg2.j().group.groupCode), String.valueOf(msg2.j().originMsgType), "");
    }

    public final void o(@NotNull FragmentActivity activity) {
        f fVar;
        Long l3;
        GroupNotifyMsg j3;
        GroupNotifyGroup groupNotifyGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        int intExtra = activity.getIntent().getIntExtra("key_from", 0);
        String str = "1";
        String str2 = "3";
        if (intExtra != 1) {
            if (intExtra != 2) {
                str = "";
                str2 = "";
            } else if (!activity.getIntent().getBooleanExtra(ILaunchTroopSysMsgUIUtilApi.KEY_HAS_RED, false)) {
                str = "3";
            } else {
                ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
                String str3 = null;
                if (iTroopNotificationInnerService != null) {
                    fVar = iTroopNotificationInnerService.getLatestMsg();
                } else {
                    fVar = null;
                }
                if (fVar != null && (j3 = fVar.j()) != null && (groupNotifyGroup = j3.group) != null) {
                    l3 = Long.valueOf(groupNotifyGroup.groupCode);
                } else {
                    l3 = null;
                }
                TroopInfoRepo troopInfoRepo = TroopInfoRepo.INSTANCE;
                if (l3 != null) {
                    str3 = l3.toString();
                }
                TroopInfo troopInfoFromCache = troopInfoRepo.getTroopInfoFromCache(str3);
                if (troopInfoFromCache == null || !troopInfoFromCache.isOwnerOrAdmin()) {
                    str = "2";
                }
                str2 = str;
                str = "2";
            }
        }
        eu.g("Grp_contacts_news", UinConfigManager.KEY_ADS, "enter_verify", 0, 0, str, str2);
    }

    public final void p(final int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, category);
            return;
        }
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        bg.f302144a.j(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.report.c
            @Override // java.lang.Runnable
            public final void run() {
                d.q(category);
            }
        });
        if (category == -1000) {
            ReportController.o(f16, "dc00899", "Grp_contacts_news", "", UinConfigManager.KEY_ADS, "unnormal_tab_exp", 0, 0, "", "", "", "");
        }
    }

    public final void r(final int category) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, category);
            return;
        }
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        bg.f302144a.j(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.report.b
            @Override // java.lang.Runnable
            public final void run() {
                d.s(category);
            }
        });
        if (category != -1000) {
            if (category != 1) {
                if (category != 2) {
                    str = null;
                } else {
                    str = "quit_tab_exp";
                }
            } else {
                str = "todo_tab_exp";
            }
        } else {
            str = "unnormal_tab_exp";
        }
        String str2 = str;
        if (str2 != null) {
            ReportController.o(f16, "dc00899", "Grp_contacts_news", "", UinConfigManager.KEY_ADS, str2, 0, 0, "", "", "", "");
        }
    }

    public final void t(int category) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, category);
            return;
        }
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        if (category != -1000) {
            if (category != 1) {
                if (category != 2) {
                    str = null;
                } else {
                    str = "quit_tab_clk";
                }
            } else {
                str = "todo_tab_clk";
            }
        } else {
            str = "unnormal_tab_clk";
        }
        String str2 = str;
        if (str2 != null) {
            ReportController.o(f16, "dc00899", "Grp_contacts_news", "", UinConfigManager.KEY_ADS, str2, 0, 0, "", "", "", "");
        }
    }
}
