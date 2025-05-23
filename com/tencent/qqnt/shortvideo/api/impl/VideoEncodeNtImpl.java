package com.tencent.qqnt.shortvideo.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.shortvideo.api.IVideoCompress;
import com.tencent.qqnt.shortvideo.api.IVideoEncode;
import com.tencent.qqnt.shortvideo.compress.AIOVideoCompressProcessor;
import cy3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/shortvideo/api/impl/VideoEncodeNtImpl;", "Lcom/tencent/qqnt/shortvideo/api/IVideoEncode;", "Landroid/content/Context;", "context", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "thumbPath", "thumbMD5", "videoPath", "Lcom/tencent/qqnt/shortvideo/api/IVideoEncode$a;", "cb", "", "encodeVideo", "removeEncodeTask", "Landroid/os/Bundle;", "bundle", "setEncodeParam", "<init>", "()V", "Companion", "a", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class VideoEncodeNtImpl implements IVideoEncode {

    @NotNull
    private static final String TAG = "VideoEncodeNtImpl";

    @Override // com.tencent.qqnt.shortvideo.api.IVideoEncode
    public void encodeVideo(@NotNull Context context, long taskId, @NotNull String thumbPath, @NotNull String thumbMD5, @NotNull String videoPath, @NotNull IVideoEncode.a cb5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(thumbPath, "thumbPath");
        Intrinsics.checkNotNullParameter(thumbMD5, "thumbMD5");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i(TAG, 1, "[encodeVideo] taskId=" + taskId + ", thumbPath=" + thumbPath + ", thumbMD5=" + thumbMD5 + " videoPath=" + videoPath);
        AIOVideoCompressProcessor.INSTANCE.a().e(taskId, new AIOVideoCompressProcessor.c(taskId, videoPath, false, null, new b(cb5)));
    }

    @Override // com.tencent.qqnt.shortvideo.api.IVideoEncode
    public void removeEncodeTask(long taskId) {
        QLog.i(TAG, 1, "[removeEncodeTask] taskId=" + taskId);
        AIOVideoCompressProcessor.INSTANCE.a().c(taskId);
    }

    @Override // com.tencent.qqnt.shortvideo.api.IVideoEncode
    public void setEncodeParam(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/qqnt/shortvideo/api/impl/VideoEncodeNtImpl$b", "Lcom/tencent/qqnt/shortvideo/api/IVideoCompress$b;", "", "userData", "", "isNeedCompress", "", "c", "", "percent", "d", "Lcy3/a;", QCircleScheme.AttrDetail.VIDEO_INFO, "a", "", "finishCode", "b", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements IVideoCompress.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IVideoEncode.a f362207a;

        b(IVideoEncode.a aVar) {
            this.f362207a = aVar;
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress.b
        public boolean a(@Nullable Object userData, @Nullable a videoInfo) {
            return true;
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress.b
        public void b(@Nullable Object userData, int finishCode, @Nullable a videoInfo) {
            if (finishCode == 3) {
                QLog.i(VideoEncodeNtImpl.TAG, 1, "[onFinish] canceled");
                return;
            }
            if (finishCode == 1 && videoInfo != null) {
                QLog.i(VideoEncodeNtImpl.TAG, 1, "[onFinish] success, videoInfo=" + videoInfo);
                this.f362207a.a(videoInfo.getPath(), videoInfo.getVideoCodecFormatType());
                return;
            }
            QLog.i(VideoEncodeNtImpl.TAG, 1, "[onFinish] error, finishCode=" + finishCode);
            this.f362207a.onError(-1);
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress.b
        public void c(@Nullable Object userData, boolean isNeedCompress) {
        }

        @Override // com.tencent.qqnt.shortvideo.api.IVideoCompress.b
        public void d(@Nullable Object userData, float percent) {
        }
    }
}
