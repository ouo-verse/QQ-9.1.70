package com.tencent.mobileqq.zootopia.ue;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/c;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/d;", DownloadInfo.spKey_Config, "", "u9", "destroy", "resume", "pause", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface c extends ZPlanEngineStatusUpdateListener {
    void destroy();

    void pause();

    void resume();

    void u9(FragmentActivity activity, d config);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a {
        public static void a(c cVar) {
            ZPlanEngineStatusUpdateListener.a.a(cVar);
        }

        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public static void b(c cVar) {
            ZPlanEngineStatusUpdateListener.a.b(cVar);
        }

        public static void c(c cVar, boolean z16) {
            ZPlanEngineStatusUpdateListener.a.c(cVar, z16);
        }

        public static void d(c cVar) {
            ZPlanEngineStatusUpdateListener.a.d(cVar);
        }

        public static void e(c cVar) {
            ZPlanEngineStatusUpdateListener.a.e(cVar);
        }

        public static void f(c cVar) {
            ZPlanEngineStatusUpdateListener.a.f(cVar);
        }

        public static void g(c cVar) {
            ZPlanEngineStatusUpdateListener.a.g(cVar);
        }

        public static void h(c cVar, int i3, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            ZPlanEngineStatusUpdateListener.a.h(cVar, i3, errorMessage);
        }

        public static void k(c cVar, boolean z16) {
            ZPlanEngineStatusUpdateListener.a.i(cVar, z16);
        }

        public static void i(c cVar) {
        }

        public static void j(c cVar) {
        }
    }
}
