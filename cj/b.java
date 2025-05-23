package cj;

import com.qzone.reborn.groupalbum.selectmedia.util.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "req", "", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {
    public static final void a(RichMediaElementGetReq req) {
        Intrinsics.checkNotNullParameter(req, "req");
        w e16 = f.e();
        if (e16 != null) {
            e16.getRichMediaElement(req);
        }
        c.f56957a.a("KernelService", " dowLoadMedia request " + req + " ");
    }

    public static final Flow<FileTransNotifyInfo> b() {
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaDownloadCompleteFlow();
    }
}
