package com.tencent.qqnt.shortvideo.api.impl;

import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.luggage.wxa.p004if.u;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qqnt.shortvideo.api.IVideoCompress;
import com.tencent.qqnt.shortvideo.compress.AIOVideoCompressProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J2\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/shortvideo/api/impl/VideoCompressImpl;", "Lcom/tencent/qqnt/shortvideo/api/IVideoCompress;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "findCompressTask", "", "removeCompressTask", "Lcom/tencent/qqnt/shortvideo/api/IVideoCompress$b;", "listener", "setCompressListener", "", "inVideoPath", CustomImageProps.QUALITY, "", "userData", u.NAME, "<init>", "()V", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class VideoCompressImpl implements IVideoCompress {
    @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress
    public void compressVideo(long taskId, @NotNull String inVideoPath, boolean quality, @Nullable Object userData, @NotNull IVideoCompress.b listener) {
        Intrinsics.checkNotNullParameter(inVideoPath, "inVideoPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        AIOVideoCompressProcessor.INSTANCE.a().e(taskId, new AIOVideoCompressProcessor.c(taskId, inVideoPath, quality, userData, listener));
    }

    @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress
    public boolean findCompressTask(long taskId) {
        if (AIOVideoCompressProcessor.INSTANCE.a().d(taskId) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress
    public void removeCompressTask(long taskId) {
        AIOVideoCompressProcessor.INSTANCE.a().c(taskId);
    }

    @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress
    public void setCompressListener(long taskId, @NotNull IVideoCompress.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        AIOVideoCompressProcessor.c d16 = AIOVideoCompressProcessor.INSTANCE.a().d(taskId);
        if (d16 != null) {
            d16.u(listener);
        }
    }
}
