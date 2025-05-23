package com.tencent.aelight.camera.ae.flashshow;

import android.view.View;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/bh;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class bh {

    /* renamed from: a, reason: collision with root package name */
    public static final bh f64208a = new bh();

    bh() {
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_ICON);
        HashMap<String, Object> e16 = ab.c().e();
        Intrinsics.checkNotNullExpressionValue(e16, "g().generateElementParams()");
        e16.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_ICON);
        VideoReport.reportEvent("dt_imp", view, e16);
    }

    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_ALBUM_TAB);
        VideoReport.setElementParams(view, ab.c().e());
        VideoReport.reportEvent("dt_clck", view, null);
    }
}
