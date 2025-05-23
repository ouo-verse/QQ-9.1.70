package com.tencent.qqnt.notification.report;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0007J(\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0007JY\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJY\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\u000f\u0010\u000eJH\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0007JH\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/notification/report/h;", "", "", "pageId", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", "p", "t", "elemId", "", "switchOn", "eventParams", "y", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;)V", BdhLogUtil.LogTag.Tag_Conn, "l", tl.h.F, "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f359873a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45509);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f359873a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(String pageId, String elemId, Boolean bool, Map map, Map map2) {
        String str;
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        Intrinsics.checkNotNullParameter(elemId, "$elemId");
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", pageId);
        hashMap.put("dt_eid", elemId);
        if (bool != null) {
            if (bool.booleanValue()) {
                str = "1";
            } else {
                str = "2";
            }
            hashMap.put("after_click_state", str);
        }
        if (map != null) {
            hashMap.put("cur_pg", map);
        }
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        VideoReport.reportEvent("dt_clck", hashMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("NotificationReport", 4, "reportSwitchClicked: pageId: " + pageId + " elemId: " + elemId + " switchOn: " + bool + " params:" + hashMap);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void B(@NotNull String pageId, @NotNull String elemId, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        D(pageId, elemId, bool, null, null, 24, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void C(@NotNull final String pageId, @NotNull final String elemId, @Nullable final Boolean switchOn, @Nullable final Map<String, String> pageParams, @Nullable final Map<String, String> eventParams) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.notification.report.c
            @Override // java.lang.Runnable
            public final void run() {
                h.E(pageId, elemId, switchOn, pageParams, eventParams);
            }
        }, 16, null, false);
    }

    public static /* synthetic */ void D(String str, String str2, Boolean bool, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        if ((i3 & 16) != 0) {
            map2 = null;
        }
        C(str, str2, bool, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(String pageId, String elemId, Boolean bool, Map map, Map map2) {
        String str;
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        Intrinsics.checkNotNullParameter(elemId, "$elemId");
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", pageId);
        hashMap.put("dt_eid", elemId);
        if (bool != null) {
            if (bool.booleanValue()) {
                str = "1";
            } else {
                str = "2";
            }
            hashMap.put("after_click_state", str);
        }
        if (map != null) {
            hashMap.put("cur_pg", map);
        }
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        VideoReport.reportEvent("dt_imp", hashMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("NotificationReport", 4, "reportSwitchShown: pageId: " + pageId + " elemId: " + elemId + " switchOn: " + bool + " params:" + hashMap);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(@NotNull String pageId, @NotNull String elemId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        i(pageId, elemId, null, null, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void h(@NotNull final String pageId, @NotNull final String elemId, @Nullable final Map<String, String> pageParams, @Nullable final Map<String, String> eventParams) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.notification.report.g
            @Override // java.lang.Runnable
            public final void run() {
                h.j(pageId, elemId, pageParams, eventParams);
            }
        }, 16, null, false);
    }

    public static /* synthetic */ void i(String str, String str2, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            map2 = null;
        }
        h(str, str2, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String pageId, String elemId, Map map, Map map2) {
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        Intrinsics.checkNotNullParameter(elemId, "$elemId");
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", pageId);
        hashMap.put("dt_eid", elemId);
        if (map != null) {
            hashMap.put("cur_pg", map);
        }
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        VideoReport.reportEvent("dt_clck", hashMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("NotificationReport", 4, "reportSwitchShown: pageId: " + pageId + " elemId: " + elemId + " params:" + hashMap);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void k(@NotNull String pageId, @NotNull String elemId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        m(pageId, elemId, null, null, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void l(@NotNull final String pageId, @NotNull final String elemId, @Nullable final Map<String, String> pageParams, @Nullable final Map<String, String> eventParams) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.notification.report.f
            @Override // java.lang.Runnable
            public final void run() {
                h.n(pageId, elemId, pageParams, eventParams);
            }
        }, 16, null, false);
    }

    public static /* synthetic */ void m(String str, String str2, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            map2 = null;
        }
        l(str, str2, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String pageId, String elemId, Map map, Map map2) {
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        Intrinsics.checkNotNullParameter(elemId, "$elemId");
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", pageId);
        hashMap.put("dt_eid", elemId);
        if (map != null) {
            hashMap.put("cur_pg", map);
        }
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        VideoReport.reportEvent("dt_imp", hashMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("NotificationReport", 4, "reportSwitchShown: pageId: " + pageId + " elemId: " + elemId + " params:" + hashMap);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void o(@NotNull String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        q(pageId, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void p(@NotNull final String pageId, @Nullable final Map<String, String> pageParams) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.notification.report.d
            @Override // java.lang.Runnable
            public final void run() {
                h.r(pageId, pageParams);
            }
        }, 16, null, false);
    }

    public static /* synthetic */ void q(String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        p(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(String pageId, Map map) {
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", pageId);
        if (map != null) {
            hashMap.putAll(map);
        }
        VideoReport.reportEvent("dt_pgin", hashMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("NotificationReport", 4, "reportPageIn: pageId: " + pageId + " ");
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void s(@NotNull String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        u(pageId, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void t(@NotNull final String pageId, @Nullable final Map<String, String> pageParams) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.notification.report.b
            @Override // java.lang.Runnable
            public final void run() {
                h.v(pageId, pageParams);
            }
        }, 16, null, false);
    }

    public static /* synthetic */ void u(String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        t(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(String pageId, Map map) {
        Intrinsics.checkNotNullParameter(pageId, "$pageId");
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", pageId);
        if (map != null) {
            hashMap.putAll(map);
        }
        VideoReport.reportEvent("dt_pgout", hashMap);
        if (QLog.isDevelopLevel()) {
            QLog.d("NotificationReport", 4, "reportPageOut: pageId: " + pageId);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void w(@NotNull String pageId, @NotNull String elemId, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        z(pageId, elemId, bool, null, null, 24, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void x(@NotNull String pageId, @NotNull String elemId, @Nullable Boolean bool, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        z(pageId, elemId, bool, map, null, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void y(@NotNull final String pageId, @NotNull final String elemId, @Nullable final Boolean switchOn, @Nullable final Map<String, String> pageParams, @Nullable final Map<String, String> eventParams) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.notification.report.e
            @Override // java.lang.Runnable
            public final void run() {
                h.A(pageId, elemId, switchOn, pageParams, eventParams);
            }
        }, 16, null, false);
    }

    public static /* synthetic */ void z(String str, String str2, Boolean bool, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        if ((i3 & 16) != 0) {
            map2 = null;
        }
        y(str, str2, bool, map, map2);
    }
}
