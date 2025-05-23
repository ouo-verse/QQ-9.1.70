package com.tencent.mobileqq.troopmanage.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troopmanage.component.bv;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ6\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007J6\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/report/a;", "", "", "dtReportPgId", "elementId", "", "params", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "a", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f303239a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63078);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f303239a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(a aVar, String str, String str2, Map map, TroopManageViewModel troopManageViewModel, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        aVar.a(str, str2, map, troopManageViewModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(a aVar, String str, String str2, Map map, TroopManageViewModel troopManageViewModel, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        aVar.c(str, str2, map, troopManageViewModel);
    }

    public final void a(@NotNull String dtReportPgId, @NotNull String elementId, @Nullable Map<String, ? extends Object> params, @NotNull TroopManageViewModel viewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, dtReportPgId, elementId, params, viewModel);
            return;
        }
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        HashMap<String, Object> a16 = bv.INSTANCE.a(viewModel);
        a16.put("dt_pgid", dtReportPgId);
        a16.put("pgid", dtReportPgId);
        HashMap hashMap = new HashMap();
        if (params != null) {
            hashMap.putAll(params);
        }
        hashMap.put("dt_eid", elementId);
        hashMap.put("eid", elementId);
        hashMap.put("cur_pg", a16);
        VideoReport.reportEvent("dt_clck", hashMap);
    }

    public final void c(@NotNull String dtReportPgId, @NotNull String elementId, @Nullable Map<String, ? extends Object> params, @NotNull TroopManageViewModel viewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, dtReportPgId, elementId, params, viewModel);
            return;
        }
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        HashMap<String, Object> a16 = bv.INSTANCE.a(viewModel);
        a16.put("dt_pgid", dtReportPgId);
        a16.put("pgid", dtReportPgId);
        HashMap hashMap = new HashMap();
        if (params != null) {
            hashMap.putAll(params);
        }
        hashMap.put("dt_eid", elementId);
        hashMap.put("eid", elementId);
        hashMap.put("cur_pg", a16);
        VideoReport.reportEvent("dt_imp", hashMap);
    }
}
