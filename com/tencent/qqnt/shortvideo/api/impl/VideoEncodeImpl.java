package com.tencent.qqnt.shortvideo.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.shortvideo.g;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.shortvideo.api.IVideoEncode;
import com.tencent.qqnt.shortvideo.api.impl.VideoEncodeImpl;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J8\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/shortvideo/api/impl/VideoEncodeImpl;", "Lcom/tencent/qqnt/shortvideo/api/IVideoEncode;", "", "videoPath", "getShortVideoFakeIdByPath", "videoFileSourceDir", "getShortVideoFakeIdByDir", "Landroid/content/Context;", "context", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "thumbPath", "thumbMD5", "Lcom/tencent/qqnt/shortvideo/api/IVideoEncode$a;", "cb", "", "encodeVideo", "removeEncodeTask", "Landroid/os/Bundle;", "bundle", "setEncodeParam", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/activity/shortvideo/EncodeVideoTask;", "encodeTaskMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class VideoEncodeImpl implements IVideoEncode {
    private static final String TAG = "VideoEncodeImpl";
    private final ConcurrentHashMap<Long, EncodeVideoTask> encodeTaskMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/shortvideo/api/impl/VideoEncodeImpl$b", "Lcom/tencent/mobileqq/shortvideo/g;", "", "videoPath", "", "videoMd5", "thumbPath", "", "thumbWidth", "thumbHeight", "thumbMd5", QFSEdgeItem.KEY_VIDEO_TIME, "", "a", "errorCode", "onError", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f362205a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IVideoEncode.a f362206b;

        b(long j3, IVideoEncode.a aVar) {
            this.f362205a = j3;
            this.f362206b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(long j3, int i3, String thumbPath, String videoPath, int i16, int i17, IVideoEncode.a cb5) {
            Intrinsics.checkNotNullParameter(thumbPath, "$thumbPath");
            Intrinsics.checkNotNullParameter(videoPath, "$videoPath");
            Intrinsics.checkNotNullParameter(cb5, "$cb");
            if (QLog.isColorLevel()) {
                QLog.i(VideoEncodeImpl.TAG, 2, "[encodeVideo] success, taskId=" + j3 + " videoTime=" + i3 + "thumbPath=" + thumbPath + " videoPath=" + videoPath + " thumbSize=" + i16 + "," + i17);
            }
            IVideoEncode.a.C9700a.a(cb5, videoPath, 0, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(long j3, int i3, IVideoEncode.a cb5) {
            Intrinsics.checkNotNullParameter(cb5, "$cb");
            QLog.w(VideoEncodeImpl.TAG, 1, "[encodeVideo] encode failed, taskId=" + j3 + " code=" + i3);
            cb5.onError(i3);
        }

        @Override // com.tencent.mobileqq.shortvideo.g
        public void onError(final int errorCode) {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final long j3 = this.f362205a;
            final IVideoEncode.a aVar = this.f362206b;
            uIHandler.post(new Runnable() { // from class: zx3.c
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEncodeImpl.b.e(j3, errorCode, aVar);
                }
            });
        }

        @Override // com.tencent.mobileqq.shortvideo.g
        public void a(final String videoPath, byte[] videoMd5, final String thumbPath, final int thumbWidth, final int thumbHeight, byte[] thumbMd5, final int videoTime) {
            Intrinsics.checkNotNullParameter(videoPath, "videoPath");
            Intrinsics.checkNotNullParameter(videoMd5, "videoMd5");
            Intrinsics.checkNotNullParameter(thumbPath, "thumbPath");
            Intrinsics.checkNotNullParameter(thumbMd5, "thumbMd5");
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final long j3 = this.f362205a;
            final IVideoEncode.a aVar = this.f362206b;
            uIHandler.post(new Runnable() { // from class: zx3.d
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEncodeImpl.b.d(j3, videoTime, thumbPath, videoPath, thumbWidth, thumbHeight, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void encodeVideo$lambda$1$lambda$0(IVideoEncode.a cb5) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.onError(-1);
    }

    private final String getShortVideoFakeIdByDir(String videoFileSourceDir) {
        String str = videoFileSourceDir + File.separator + "configure.txt";
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            QLog.w(TAG, 1, "configure file empty!");
            return null;
        }
        try {
            String readFileToString = FileUtils.readFileToString(new File(str));
            if (readFileToString == null) {
                return null;
            }
            String replace = new Regex("[\\t\\n\\r]").replace(readFileToString, "");
            if (TextUtils.isEmpty(replace)) {
                return null;
            }
            return replace;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[getShortVideoFakeId] exc=" + e16 + " dir=" + videoFileSourceDir);
            return null;
        }
    }

    private final String getShortVideoFakeIdByPath(String videoPath) {
        String parent = new File(videoPath).getParent();
        if (TextUtils.isEmpty(parent)) {
            return null;
        }
        Intrinsics.checkNotNull(parent);
        return getShortVideoFakeIdByDir(parent);
    }

    @Override // com.tencent.qqnt.shortvideo.api.IVideoEncode
    public void removeEncodeTask(long taskId) {
        EncodeVideoTask remove = this.encodeTaskMap.remove(Long.valueOf(taskId));
        if (remove == null) {
            QLog.w(TAG, 1, "[removeEncodeTask] task not found, id=" + taskId);
            return;
        }
        QLog.i(TAG, 1, "[removeEncodeTask] task is removed, id=" + taskId);
        if (remove.f186213t) {
            return;
        }
        QLog.i(TAG, 1, "[removeEncodeTask] task is cancelled, id=" + taskId);
        remove.y();
    }

    @Override // com.tencent.qqnt.shortvideo.api.IVideoEncode
    public void setEncodeParam(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @Override // com.tencent.qqnt.shortvideo.api.IVideoEncode
    public void encodeVideo(final Context context, final long taskId, final String thumbPath, final String thumbMD5, final String videoPath, final IVideoEncode.a cb5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(thumbPath, "thumbPath");
        Intrinsics.checkNotNullParameter(thumbMD5, "thumbMD5");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i(TAG, 1, "[encodeVideo] taskId=" + taskId + ", thumbPath=" + thumbPath + ", thumbMD5=" + thumbMD5 + " videoPath=" + videoPath);
        ThreadManagerV2.excute(new Runnable() { // from class: zx3.a
            @Override // java.lang.Runnable
            public final void run() {
                VideoEncodeImpl.encodeVideo$lambda$1(VideoEncodeImpl.this, videoPath, taskId, thumbPath, thumbMD5, context, cb5);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void encodeVideo$lambda$1(VideoEncodeImpl this$0, String videoPath, long j3, String thumbPath, String thumbMD5, Context context, final IVideoEncode.a cb5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoPath, "$videoPath");
        Intrinsics.checkNotNullParameter(thumbPath, "$thumbPath");
        Intrinsics.checkNotNullParameter(thumbMD5, "$thumbMD5");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        String shortVideoFakeIdByPath = this$0.getShortVideoFakeIdByPath(videoPath);
        if (TextUtils.isEmpty(shortVideoFakeIdByPath)) {
            QLog.i(TAG, 1, "[encodeVideo] failed to get fake video id, taskId=" + j3 + " videoPath=" + videoPath);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: zx3.b
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEncodeImpl.encodeVideo$lambda$1$lambda$0(IVideoEncode.a.this);
                }
            });
            return;
        }
        EncodeVideoTask encodeVideoTask = this$0.encodeTaskMap.get(Long.valueOf(j3));
        if (encodeVideoTask == null) {
            EncodeVideoTask encodeVideoTask2 = new EncodeVideoTask(context, shortVideoFakeIdByPath, true, new EncodeVideoTask.d(thumbPath, thumbMD5, null, 0, 0));
            Utils.executeAsyncTaskOnSerialExcuter(encodeVideoTask2, null);
            this$0.encodeTaskMap.put(Long.valueOf(j3), encodeVideoTask2);
            encodeVideoTask = encodeVideoTask2;
        }
        encodeVideoTask.I(new b(j3, cb5));
    }
}
