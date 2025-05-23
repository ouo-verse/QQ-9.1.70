package com.tencent.sqshow.zootopia.avatar;

import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/c;", "", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "", "onFirstFrame", "", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "success", "engineInitFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface c {
    void engineInitFinish(boolean success);

    void onFirstFrame(FirstFrameResult result);

    void serviceConnected(boolean connect);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static void b(c cVar, FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public static void a(c cVar, boolean z16) {
        }

        public static void c(c cVar, boolean z16) {
        }
    }
}
