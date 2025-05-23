package com.qzone.publish.business.task.groupalbum;

import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.qzone.publish.business.protocol.QzoneMediaUploadRequest;
import com.qzone.publish.business.publishqueue.intimate.b;
import com.qzone.publish.business.task.c;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.publish.ui.model.a;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J8\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/publish/business/task/groupalbum/GroupAlbumUploadAlbumVideoTask;", "Lcom/qzone/publish/business/task/groupalbum/GroupAlbumUploadAlbumTask;", "", "getLogTag", "Lcom/qzone/publish/ui/model/a;", "buildUploadParams", "", "getFakeSize", "", "Lqzone/QZoneBaseMeta$StMedia;", "uploadResult", "", "uploadResultBool", "", QzoneIPCModule.RESULT_CODE, "", "onUploadFinish", "Lcom/qzone/publish/business/task/c;", "getInfo", "isVideoTask", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "params", "<init>", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class GroupAlbumUploadAlbumVideoTask extends GroupAlbumUploadAlbumTask {
    private static final String TAG = "GroupAlbumUploadAlbumVideoTask";

    public GroupAlbumUploadAlbumVideoTask() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask
    public a buildUploadParams() {
        return super.buildUploadParams();
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    protected long getFakeSize() {
        Object firstOrNull;
        ShuoshuoVideoInfo videoInfo;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.params.getMediaWrapperList());
        MediaWrapper mediaWrapper = (MediaWrapper) firstOrNull;
        if (mediaWrapper == null || (videoInfo = mediaWrapper.getVideoInfo()) == null) {
            return 0L;
        }
        double d16 = videoInfo.mEstimateSize;
        return d16 > 0.0d ? (long) d16 : videoInfo.mSize;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        Object firstOrNull;
        String str;
        c info = super.getInfo();
        info.f51185a = "\u4e0a\u4f20\u89c6\u9891\u5230\u76f8\u518c\u300a" + this.params.getAlbumInfo().getAlbumName() + "\u300b";
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.params.getMediaWrapperList());
        MediaWrapper mediaWrapper = (MediaWrapper) firstOrNull;
        if (mediaWrapper == null || (str = b.a(mediaWrapper)) == null) {
            str = "";
        }
        info.f51192h = str;
        boolean z16 = true;
        info.f51193i = true;
        int state = getState();
        if (state != 1) {
            if ((state == 2 || state == 3) && this.mResultCode != 0) {
                String str2 = this.f45835msg;
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                }
                if (!z16) {
                    info.f51186b = this.f45835msg;
                }
            }
        } else {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = (int) ((100 * j3) / j16);
                    info.f51186b = "\u4e0a\u4f20\u89c6\u9891" + j3 + "K/" + j16 + "K";
                }
            }
            QZoneRequest qZoneRequest = this.mRequest;
            if (qZoneRequest instanceof QzoneMediaUploadRequest) {
                Intrinsics.checkNotNull(qZoneRequest, "null cannot be cast to non-null type com.qzone.publish.business.protocol.QzoneMediaUploadRequest");
                info = ((QzoneMediaUploadRequest) qZoneRequest).getInfo(info);
            }
        }
        Intrinsics.checkNotNullExpressionValue(info, "info");
        return info;
    }

    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumTask, com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask
    public String getLogTag() {
        return super.getLogTag() + "_GroupAlbumUploadAlbumVideoTask";
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isVideoTask() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumTask, com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask
    public void onUploadFinish(Map<String, QZoneBaseMeta$StMedia> uploadResult, Map<String, Boolean> uploadResultBool, int resultCode) {
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        Intrinsics.checkNotNullParameter(uploadResultBool, "uploadResultBool");
        super.onUploadFinish(uploadResult, uploadResultBool, resultCode);
        Iterator<Map.Entry<String, Boolean>> it = uploadResultBool.entrySet().iterator();
        while (it.hasNext()) {
            doReportAlbumEvent(1, it.next().getValue().booleanValue(), resultCode);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ GroupAlbumUploadAlbumVideoTask(com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r19 = this;
            r0 = r21 & 1
            if (r0 == 0) goto L21
            com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams r0 = new com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams
            r1 = r0
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 8191(0x1fff, float:1.1478E-41)
            r18 = 0
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18)
            r1 = r19
            goto L25
        L21:
            r1 = r19
            r0 = r20
        L25:
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumVideoTask.<init>(com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumUploadAlbumVideoTask(GroupAlbumUploadAlbumParams params) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
    }
}
