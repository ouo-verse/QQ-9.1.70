package com.tencent.mobileqq.troop.troopblacklist.utils;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J,\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0007R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/utils/a;", "", "", "elementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "", "isOwner", "", "g", "isPgIn", "e", "isChecked", "b", "f", "eventId", "isConfirm", "c", "", "Ljava/util/Map;", "pgParams", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f299464a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, Object> pgParams;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f299464a = new a();
            pgParams = new LinkedHashMap();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final HashMap<String, Object> a(String elementId) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.putAll(pgParams);
        hashMap.put("dt_eid", elementId);
        hashMap.put("eid", elementId);
        hashMap.put("cur_pg", pgParams);
        return hashMap;
    }

    public static /* synthetic */ void d(a aVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aVar.c(str, z16);
    }

    public final void b(boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isChecked);
            return;
        }
        HashMap<String, Object> a16 = a("em_group_check_btn");
        a16.put("pick_status", Integer.valueOf(isChecked ? 1 : 0));
        VideoReport.reportEvent("dt_clck", a16);
    }

    public final void c(@NotNull String eventId, boolean isConfirm) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, eventId, Boolean.valueOf(isConfirm));
            return;
        }
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        HashMap<String, Object> a16 = a("em_group_del_confirm_pop");
        if (isConfirm) {
            str = MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM;
        } else {
            str = "cancel";
        }
        a16.put("click_type", str);
        VideoReport.reportEvent(eventId, a16);
    }

    public final void e(boolean isPgIn) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isPgIn);
            return;
        }
        if (isPgIn) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        VideoReport.reportEvent(str, pgParams);
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            VideoReport.reportEvent("dt_clck", a("em_group_top_right_remove"));
        }
    }

    public final void g(boolean isOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isOwner);
            return;
        }
        pgParams.put("dt_pgid", "pg_group_blacklist_manage");
        pgParams.put("pgid", "pg_group_blacklist_manage");
        Map<String, Object> map = pgParams;
        if (isOwner) {
            i3 = 1;
        }
        map.put("group_user_type", Integer.valueOf(i3));
    }
}
