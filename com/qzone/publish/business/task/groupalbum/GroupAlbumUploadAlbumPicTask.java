package com.qzone.publish.business.task.groupalbum;

import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.qzone.publish.business.publishqueue.intimate.b;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.publish.ui.model.a;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.c;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StMedia;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J8\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/publish/business/task/groupalbum/GroupAlbumUploadAlbumPicTask;", "Lcom/qzone/publish/business/task/groupalbum/GroupAlbumUploadAlbumTask;", "", "getLogTag", "Lcom/qzone/publish/ui/model/a;", "buildUploadParams", "", "getFakeSize", "", "Lqzone/QZoneBaseMeta$StMedia;", "uploadResult", "", "uploadResultBool", "", QzoneIPCModule.RESULT_CODE, "", "onUploadFinish", "Lcom/qzone/publish/business/task/c;", "getInfo", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "params", "<init>", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class GroupAlbumUploadAlbumPicTask extends GroupAlbumUploadAlbumTask {
    private static final String TAG = "GroupAlbumUploadAlbumPicTask";

    public GroupAlbumUploadAlbumPicTask() {
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
        ImageInfo imageInfo;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.params.getMediaWrapperList());
        MediaWrapper mediaWrapper = (MediaWrapper) firstOrNull;
        return c.y((mediaWrapper == null || (imageInfo = mediaWrapper.getImageInfo()) == null) ? null : imageInfo.mPath, this.params.getRequestParams().getPicQuality());
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public com.qzone.publish.business.task.c getInfo() {
        Object firstOrNull;
        String str;
        com.qzone.publish.business.task.c info = super.getInfo();
        info.f51185a = "\u4e0a\u4f20\u7167\u7247\u5230\u76f8\u518c\u300a" + this.params.getAlbumInfo().getAlbumName() + "\u300b";
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.params.getMediaWrapperList());
        MediaWrapper mediaWrapper = (MediaWrapper) firstOrNull;
        if (mediaWrapper == null || (str = b.a(mediaWrapper)) == null) {
            str = "";
        }
        info.f51192h = str;
        int i3 = info.f51187c;
        if (i3 == 0 || i3 == 1) {
            long j3 = this.mRecvDataSize;
            if (j3 > 0) {
                long j16 = this.mTotalSize;
                if (j16 > 0) {
                    info.f51190f = (int) ((100 * j3) / j16);
                    info.f51186b = j3 + "K/" + j16 + "K";
                }
            }
            info.f51190f = 0;
        }
        Intrinsics.checkNotNullExpressionValue(info, "super.getInfo().apply {\n\u2026}\n            }\n        }");
        return info;
    }

    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumTask, com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask
    public String getLogTag() {
        return super.getLogTag() + "_GroupAlbumUploadAlbumPicTask";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumTask, com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask
    public void onUploadFinish(Map<String, QZoneBaseMeta$StMedia> uploadResult, Map<String, Boolean> uploadResultBool, int resultCode) {
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        Intrinsics.checkNotNullParameter(uploadResultBool, "uploadResultBool");
        super.onUploadFinish(uploadResult, uploadResultBool, resultCode);
        Iterator<Map.Entry<String, Boolean>> it = uploadResultBool.entrySet().iterator();
        while (it.hasNext()) {
            doReportAlbumEvent(0, it.next().getValue().booleanValue(), resultCode);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ GroupAlbumUploadAlbumPicTask(com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumPicTask.<init>(com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumUploadAlbumPicTask(GroupAlbumUploadAlbumParams params) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
    }
}
