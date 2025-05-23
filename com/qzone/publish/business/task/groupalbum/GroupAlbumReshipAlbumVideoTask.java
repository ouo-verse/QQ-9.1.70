package com.qzone.publish.business.task.groupalbum;

import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.qzone.publish.business.task.c;
import com.qzone.publish.ui.model.MediaWrapper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/publish/business/task/groupalbum/GroupAlbumReshipAlbumVideoTask;", "Lcom/qzone/publish/business/task/groupalbum/GroupAlbumReshipAlbumTask;", "", "getLogTag", "", "getFakeSize", "Lcom/qzone/publish/business/task/c;", "getInfo", "", "isVideoTask", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "params", "<init>", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class GroupAlbumReshipAlbumVideoTask extends GroupAlbumReshipAlbumTask {
    private static final String TAG = "GroupAlbumReshipAlbumVideoTask";

    public GroupAlbumReshipAlbumVideoTask() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask
    protected long getFakeSize() {
        return 0L;
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public c getInfo() {
        Object firstOrNull;
        String str;
        Object firstOrNull2;
        Integer intOrNull;
        ShuoshuoVideoInfo videoInfo;
        Map<String, Object> map;
        ShuoshuoVideoInfo videoInfo2;
        c info = super.getInfo();
        info.f51185a = "\u8f6c\u8f7d\u89c6\u9891\u5230\u76f8\u518c\u300a" + this.params.getAlbumInfo().getAlbumName() + "\u300b";
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.params.getMediaWrapperList());
        MediaWrapper mediaWrapper = (MediaWrapper) firstOrNull;
        if (mediaWrapper == null || (videoInfo2 = mediaWrapper.getVideoInfo()) == null || (str = videoInfo2.mCoverUrl) == null) {
            str = "";
        }
        info.f51192h = str;
        info.f51193i = true;
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.params.getMediaWrapperList());
        MediaWrapper mediaWrapper2 = (MediaWrapper) firstOrNull2;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(String.valueOf((mediaWrapper2 == null || (videoInfo = mediaWrapper2.getVideoInfo()) == null || (map = videoInfo.extraInfo) == null) ? null : map.get("status")));
        info.f51186b = getDetail(intOrNull != null ? intOrNull.intValue() : 0);
        Intrinsics.checkNotNullExpressionValue(info, "info");
        return info;
    }

    @Override // com.qzone.publish.business.task.groupalbum.GroupAlbumReshipAlbumTask, com.qzone.publish.business.task.groupalbum.GroupAlbumReshipBaseTask, com.qzone.publish.business.task.groupalbum.GroupAlbumUploadBaseTask
    public String getLogTag() {
        return super.getLogTag() + "_GroupAlbumReshipAlbumVideoTask";
    }

    @Override // com.qzone.publish.business.task.QZoneQueueTask, com.qzone.publish.business.task.IQueueTask
    public boolean isVideoTask() {
        return true;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ GroupAlbumReshipAlbumVideoTask(com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.qzone.publish.business.task.groupalbum.GroupAlbumReshipAlbumVideoTask.<init>(com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumReshipAlbumVideoTask(GroupAlbumUploadAlbumParams params) {
        super(params);
        Intrinsics.checkNotNullParameter(params, "params");
    }
}
