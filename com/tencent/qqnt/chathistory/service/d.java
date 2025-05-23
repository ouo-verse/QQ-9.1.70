package com.tencent.qqnt.chathistory.service;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002\u001a\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/kernel/api/w;", "c", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "d", "g", "e", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "req", "", "b", "chathistory_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d {
    public static final void b(@NotNull RichMediaElementGetReq req) {
        Intrinsics.checkNotNullParameter(req, "req");
        w e16 = f.e();
        if (e16 != null) {
            e16.getRichMediaElement(req);
        }
        com.tencent.qqnt.chathistory.util.d.f354054a.a("KernelService", " dowLoadMedia request " + req + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w c() {
        return ((IKernelService) MobileQQ.sMobileQQ.waitAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService();
    }

    @NotNull
    public static final Flow<FileTransNotifyInfo> d() {
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaDownloadCompleteFlow();
    }

    @NotNull
    public static final Flow<FileTransNotifyInfo> e() {
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaDownloadProgressFlow();
    }

    @NotNull
    public static final Flow<FileTransNotifyInfo> f() {
        return FlowKt.merge(d(), g(), e());
    }

    @NotNull
    public static final Flow<FileTransNotifyInfo> g() {
        return ((IMsgService) QRoute.api(IMsgService.class)).registerRichMediaUploadCompleteFlow();
    }
}
