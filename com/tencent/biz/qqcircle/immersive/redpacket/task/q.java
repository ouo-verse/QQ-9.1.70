package com.tencent.biz.qqcircle.immersive.redpacket.task;

import com.tencent.biz.qqcircle.immersive.redpacket.task.o;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.mobileqq.winkpublish.result.MediaUploadResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0004\rB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/q;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/e;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "", "a", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "", "i", "cancel", "", "Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "b", "Ljava/util/Map;", "cloudCoverResult", "", "c", "cloudCoverTask", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/q$b;", "d", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/q$b;", "taskListener", "()Ljava/lang/String;", "tag", "<init>", "()V", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class q extends e<AddRedPacketCoverData> {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final ImageResult f89569f = new ImageResult(null, "default", null, 0, 0, 0, 0, null, 253, null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final ImageResult f89570g = new ImageResult(null, "failed", null, 0, 0, 0, 0, null, 253, null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, ImageResult> cloudCoverResult = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Long, String> cloudCoverTask = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b taskListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BE\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/q$b;", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "", "v", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "onTaskChange", "", "", "Lcom/tencent/mobileqq/winkpublish/result/ImageResult;", "d", "Ljava/util/Map;", "cloudCoverResult", "", "e", "cloudCoverTask", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "f", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;", "data", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "callback", "<init>", "(Ljava/util/Map;Ljava/util/Map;Lcom/tencent/biz/qqcircle/immersive/redpacket/task/a;Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends ITaskListener.Stub {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<String, ImageResult> cloudCoverResult;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<Long, String> cloudCoverTask;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AddRedPacketCoverData data;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final o<AddRedPacketCoverData> callback;

        public b(@NotNull Map<String, ImageResult> cloudCoverResult, @NotNull Map<Long, String> cloudCoverTask, @NotNull AddRedPacketCoverData data, @NotNull o<AddRedPacketCoverData> callback) {
            Intrinsics.checkNotNullParameter(cloudCoverResult, "cloudCoverResult");
            Intrinsics.checkNotNullParameter(cloudCoverTask, "cloudCoverTask");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.cloudCoverResult = cloudCoverResult;
            this.cloudCoverTask = cloudCoverTask;
            this.data = data;
            this.callback = callback;
        }

        private final void v() {
            boolean z16;
            QLog.d("UploadCoverProcess", 1, "checkCloudCoverResult, cloudCoverResult:" + this.cloudCoverResult + ", data:" + this.data);
            String staticCoverPath = this.data.getStaticCoverPath();
            String apngCoverPath = this.data.getApngCoverPath();
            boolean z17 = false;
            if (staticCoverPath != null && staticCoverPath.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (apngCoverPath == null || apngCoverPath.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    ImageResult imageResult = this.cloudCoverResult.get(staticCoverPath);
                    ImageResult imageResult2 = this.cloudCoverResult.get(apngCoverPath);
                    if (!Intrinsics.areEqual(imageResult, q.f89569f) && !Intrinsics.areEqual(imageResult2, q.f89569f)) {
                        if (imageResult != null && !Intrinsics.areEqual(imageResult, q.f89570g) && imageResult2 != null && !Intrinsics.areEqual(imageResult2, q.f89570g)) {
                            this.data.k(imageResult);
                            this.data.h(imageResult2);
                            this.callback.onSuccess(this.data);
                            return;
                        }
                        o.a.a(this.callback, null, 1, null);
                        return;
                    }
                    return;
                }
            }
            QLog.w("UploadCoverProcess", 1, "checkCloudCoverResult, staticCoverPath or apngCoverPath is null or empty ");
            o.a.a(this.callback, null, 1, null);
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(@Nullable TaskInfo taskInfo) {
            if (taskInfo == null) {
                QLog.w("UploadCoverProcess", 1, "onTaskChange, taskInfo is null ");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UploadCoverProcess", 1, "onTaskChange, taskInfo:" + taskInfo + ", cloudCoverTask:" + this.cloudCoverTask);
            }
            if (!taskInfo.isTrueUpload() || !this.cloudCoverTask.keySet().contains(Long.valueOf(taskInfo.getTaskId()))) {
                return;
            }
            if (taskInfo.isFinish() && (!taskInfo.getMediaInfos().isEmpty()) && (taskInfo.getMediaInfos().get(0).getUploadResult() instanceof ImageResult)) {
                String mediaPath = taskInfo.getMediaInfos().get(0).getMediaPath();
                MediaUploadResult uploadResult = taskInfo.getMediaInfos().get(0).getUploadResult();
                Intrinsics.checkNotNull(uploadResult, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.result.ImageResult");
                ImageResult imageResult = (ImageResult) uploadResult;
                QLog.d("UploadCoverProcess", 1, "onTaskChange, succeed, localPath:" + mediaPath + ", result:" + imageResult);
                this.cloudCoverResult.put(mediaPath, imageResult);
                v();
                return;
            }
            if (taskInfo.isCancelled()) {
                String str = this.cloudCoverTask.get(Long.valueOf(taskInfo.getTaskId()));
                QLog.d("UploadCoverProcess", 1, "onTaskChange, cancelled, localPath:" + str);
                if (str != null) {
                    this.cloudCoverResult.put(str, q.f89570g);
                    v();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/task/q$c", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements WinkPublishHelper2.Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AddRedPacketCoverData f89579b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ o<AddRedPacketCoverData> f89580c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f89581d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f89582e;

        c(AddRedPacketCoverData addRedPacketCoverData, o<AddRedPacketCoverData> oVar, String str, String str2) {
            this.f89579b = addRedPacketCoverData;
            this.f89580c = oVar;
            this.f89581d = str;
            this.f89582e = str2;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(service, "service");
            b bVar = new b(q.this.cloudCoverResult, q.this.cloudCoverTask, this.f89579b, this.f89580c);
            q.this.taskListener = bVar;
            service.addTaskListener(bVar);
            ja0.a aVar = ja0.a.f409680a;
            TaskInfo g16 = aVar.g(this.f89581d);
            if (g16 != null) {
                q qVar = q.this;
                qVar.cloudCoverTask.put(Long.valueOf(g16.getTaskId()), this.f89581d);
            }
            TaskInfo g17 = aVar.g(this.f89582e);
            if (g17 != null) {
                q qVar2 = q.this;
                qVar2.cloudCoverTask.put(Long.valueOf(g17.getTaskId()), this.f89582e);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    @NotNull
    public String a() {
        return "UploadCoverProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.e
    @NotNull
    public String c() {
        return "UploadCoverProcess";
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.e, com.tencent.biz.qqcircle.immersive.redpacket.task.p
    public void cancel() {
        super.cancel();
        WinkPublishServiceProxy2 service = WinkPublishHelper2.INSTANCE.getService(1);
        if (service != null) {
            Iterator<T> it = this.cloudCoverTask.keySet().iterator();
            while (it.hasNext()) {
                service.cancelTaskWithId(((Number) it.next()).longValue());
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.p
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull AddRedPacketCoverData data, @NotNull o<AddRedPacketCoverData> callback) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("UploadCoverProcess", 1, "doProcess, data:" + data);
        String staticCoverPath = data.getStaticCoverPath();
        String apngCoverPath = data.getApngCoverPath();
        if (staticCoverPath != null && staticCoverPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (apngCoverPath != null && apngCoverPath.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                d.a(this.cloudCoverResult, new String[]{staticCoverPath, apngCoverPath}, f89569f);
                this.cloudCoverTask.clear();
                WinkPublishHelper2.INSTANCE.bindService(11, new c(data, callback, staticCoverPath, apngCoverPath));
                return;
            }
        }
        QLog.w("UploadCoverProcess", 1, "doProcess, staticCoverPath or apngCoverPath is null or empty ");
        o.a.a(callback, null, 1, null);
    }
}
