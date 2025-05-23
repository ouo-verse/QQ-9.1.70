package com.tencent.mobileqq.springhb.debug;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.ReportInfo;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import tencent.im.spring_hb.ReportData$NYReportItem;
import tencent.im.spring_hb.ReportData$NYReportRsp;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u000b\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\n0\u0007J\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002R\u0011\u0010\u0010\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0017\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/springhb/debug/b;", "", "", "isDev", "isGame", "", "g", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/springhb/ReportInfo;", "f", "Ltencent/im/spring_hb/ReportData$NYReportItem;", "a", "isRealTime", "e", "i", "()Z", "isPublicVersion", "c", "needHookSvr", "b", "needHookRealTime", h.F, "()I", "rspTimeOut", "Ltencent/im/spring_hb/ReportData$NYReportRsp;", "d", "()Ltencent/im/spring_hb/ReportData$NYReportRsp;", "nyReportRsp", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f289046a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20627);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f289046a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int g(boolean isDev, boolean isGame) {
        if (isDev) {
            if (isGame) {
                return 3;
            }
            return 1;
        }
        if (isGame) {
            return 2;
        }
        return 0;
    }

    public final int a(@NotNull LinkedList<ReportData$NYReportItem> linkedList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) linkedList)).intValue();
        }
        Intrinsics.checkNotNullParameter(linkedList, "<this>");
        Iterator<T> it = linkedList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((ReportData$NYReportItem) it.next()).count.get();
        }
        return i3;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (!i() && com.tencent.mobileqq.springhb.util.a.b(com.tencent.mobileqq.springhb.util.a.f289630a, "hook_real_time", false, "2024_spring_hb_debug_", false, null, 24, null)) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!i() && com.tencent.mobileqq.springhb.util.a.b(com.tencent.mobileqq.springhb.util.a.f289630a, "hook_svr_switch", false, "2024_spring_hb_debug_", false, null, 24, null)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ReportData$NYReportRsp d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ReportData$NYReportRsp) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ReportData$NYReportRsp reportData$NYReportRsp = new ReportData$NYReportRsp();
        PBUInt32Field pBUInt32Field = reportData$NYReportRsp.ret;
        com.tencent.mobileqq.springhb.util.a aVar = com.tencent.mobileqq.springhb.util.a.f289630a;
        pBUInt32Field.set(com.tencent.mobileqq.springhb.util.a.d(aVar, "ret_code", 0, "2024_spring_hb_debug_", false, null, 24, null));
        reportData$NYReportRsp.batchSize.set(com.tencent.mobileqq.springhb.util.a.d(aVar, "batch_size", 18, "2024_spring_hb_debug_", false, null, 24, null));
        reportData$NYReportRsp.reportInterval.set((int) com.tencent.mobileqq.springhb.util.a.f(aVar, "report_interval", 1200L, "2024_spring_hb_debug_", false, null, 24, null));
        reportData$NYReportRsp.switchToBgInterval.set((int) com.tencent.mobileqq.springhb.util.a.f(aVar, "switch_to_bg_interval", 5L, "2024_spring_hb_debug_", false, null, 24, null));
        reportData$NYReportRsp.reportLevel.set(com.tencent.mobileqq.springhb.util.a.d(aVar, "report_level", 0, "2024_spring_hb_debug_", false, null, 24, null));
        reportData$NYReportRsp.reportLevelTime.set((int) com.tencent.mobileqq.springhb.util.a.f(aVar, "report_level_time", 86400L, "2024_spring_hb_debug_", false, null, 24, null));
        return reportData$NYReportRsp;
    }

    @NotNull
    public final ReportInfo e(boolean isDev, boolean isGame, boolean isRealTime) {
        String str;
        String str2;
        int random;
        Map mapOf;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ReportInfo) iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(isDev), Boolean.valueOf(isGame), Boolean.valueOf(isRealTime));
        }
        if (isDev) {
            str = APMidasPayAPI.ENV_DEV;
        } else {
            str = WadlResult.WEB_KEY_PROGRESS;
        }
        if (isGame) {
            str2 = "game";
        } else {
            str2 = "spring";
        }
        String str3 = "entrance_" + str + "_" + str2;
        random = RangesKt___RangesKt.random(new IntRange(1, com.tencent.mobileqq.springhb.util.a.d(com.tencent.mobileqq.springhb.util.a.f289630a, "report_random", 5, "2024_spring_hb_debug_", false, null, 24, null)), Random.INSTANCE);
        String str4 = "exp_" + random;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("web_version", "1.1"), TuplesKt.to(QCircleQualityReporter.KEY_OBJ_ID, QCircleQualityReporter.KEY_OBJ_ID), TuplesKt.to("oper_res", "oper_res"), TuplesKt.to("card_id", "card_id"), TuplesKt.to("changci_id", "888"), TuplesKt.to("ext1", "ext1"), TuplesKt.to("ext2", "ext2"), TuplesKt.to("ext3", "ext3"), TuplesKt.to("ext4", "ext4"), TuplesKt.to("ext5", "ext5"), TuplesKt.to("ext6", "ext6"), TuplesKt.to("ext7", "ext7"), TuplesKt.to("ext8", "ext8"), TuplesKt.to("ext9", "ext9"), TuplesKt.to("testest", "test1"));
        int g16 = g(isDev, isGame);
        if (isGame) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportInfo create = ReportInfo.create(str3, "test", "swip", "score_page", str4, mapOf, isRealTime, g16, i3);
        Intrinsics.checkNotNullExpressionValue(create, "create(\"entrance_${if (i\u2026_TYPE_SPRING_HB\n        )");
        return create;
    }

    public final int f(@NotNull LinkedList<ReportInfo> linkedList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) linkedList)).intValue();
        }
        Intrinsics.checkNotNullParameter(linkedList, "<this>");
        Iterator<T> it = linkedList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((ReportInfo) it.next()).count;
        }
        return i3;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.springhb.util.a.d(com.tencent.mobileqq.springhb.util.a.f289630a, "rsp_time_out", 30000, "2024_spring_hb_debug_", false, null, 24, null);
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }
}
