package com.qzone.publish.business.model.intimate;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001.BG\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\bH\u00c6\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\bH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\rH\u00c6\u0003JI\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\b2\b\b\u0002\u0010\u0012\u001a\u00020\rH\u00c6\u0001J\t\u0010\u0014\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR.\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R.\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadTaskBatchInfo;", "Ljava/io/Serializable;", "", "isPublishEnd", "isPublishSucceed", "shouldPublish", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "component1", "Ljava/util/concurrent/ConcurrentHashMap;", "", "component2", "Lcom/qzone/publish/business/model/intimate/IntimateUploadMediaResult;", "component3", "Lcom/qzone/publish/business/model/intimate/PublishStage;", "component4", "uploadParams", "uploadResultBoolMap", "uploadResultMap", "publishStage", "copy", "toString", "", "hashCode", "", "other", "equals", "Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "getUploadParams", "()Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;", "setUploadParams", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "getUploadResultBoolMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setUploadResultBoolMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getUploadResultMap", "setUploadResultMap", "Lcom/qzone/publish/business/model/intimate/PublishStage;", "getPublishStage", "()Lcom/qzone/publish/business/model/intimate/PublishStage;", "setPublishStage", "(Lcom/qzone/publish/business/model/intimate/PublishStage;)V", "<init>", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadAlbumParams;Ljava/util/concurrent/ConcurrentHashMap;Ljava/util/concurrent/ConcurrentHashMap;Lcom/qzone/publish/business/model/intimate/PublishStage;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class IntimateUploadTaskBatchInfo implements Serializable {
    private static final long serialVersionUID = -2203078732665558765L;
    private PublishStage publishStage;
    private IntimateUploadAlbumParams uploadParams;
    private ConcurrentHashMap<String, Boolean> uploadResultBoolMap;
    private ConcurrentHashMap<String, IntimateUploadMediaResult> uploadResultMap;

    public IntimateUploadTaskBatchInfo() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: component1, reason: from getter */
    public final IntimateUploadAlbumParams getUploadParams() {
        return this.uploadParams;
    }

    public final ConcurrentHashMap<String, Boolean> component2() {
        return this.uploadResultBoolMap;
    }

    public final ConcurrentHashMap<String, IntimateUploadMediaResult> component3() {
        return this.uploadResultMap;
    }

    /* renamed from: component4, reason: from getter */
    public final PublishStage getPublishStage() {
        return this.publishStage;
    }

    public final IntimateUploadTaskBatchInfo copy(IntimateUploadAlbumParams uploadParams, ConcurrentHashMap<String, Boolean> uploadResultBoolMap, ConcurrentHashMap<String, IntimateUploadMediaResult> uploadResultMap, PublishStage publishStage) {
        Intrinsics.checkNotNullParameter(uploadParams, "uploadParams");
        Intrinsics.checkNotNullParameter(uploadResultBoolMap, "uploadResultBoolMap");
        Intrinsics.checkNotNullParameter(uploadResultMap, "uploadResultMap");
        Intrinsics.checkNotNullParameter(publishStage, "publishStage");
        return new IntimateUploadTaskBatchInfo(uploadParams, uploadResultBoolMap, uploadResultMap, publishStage);
    }

    public final PublishStage getPublishStage() {
        return this.publishStage;
    }

    public final IntimateUploadAlbumParams getUploadParams() {
        return this.uploadParams;
    }

    public final ConcurrentHashMap<String, Boolean> getUploadResultBoolMap() {
        return this.uploadResultBoolMap;
    }

    public final ConcurrentHashMap<String, IntimateUploadMediaResult> getUploadResultMap() {
        return this.uploadResultMap;
    }

    public int hashCode() {
        return (((((this.uploadParams.hashCode() * 31) + this.uploadResultBoolMap.hashCode()) * 31) + this.uploadResultMap.hashCode()) * 31) + this.publishStage.hashCode();
    }

    public final boolean isPublishEnd() {
        PublishStage publishStage = this.publishStage;
        return publishStage == PublishStage.SUCCEED || publishStage == PublishStage.FAILED;
    }

    public final boolean isPublishSucceed() {
        return this.publishStage == PublishStage.SUCCEED;
    }

    public final void setPublishStage(PublishStage publishStage) {
        Intrinsics.checkNotNullParameter(publishStage, "<set-?>");
        this.publishStage = publishStage;
    }

    public final void setUploadParams(IntimateUploadAlbumParams intimateUploadAlbumParams) {
        Intrinsics.checkNotNullParameter(intimateUploadAlbumParams, "<set-?>");
        this.uploadParams = intimateUploadAlbumParams;
    }

    public final void setUploadResultBoolMap(ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.uploadResultBoolMap = concurrentHashMap;
    }

    public final void setUploadResultMap(ConcurrentHashMap<String, IntimateUploadMediaResult> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.uploadResultMap = concurrentHashMap;
    }

    public final boolean shouldPublish() {
        PublishStage publishStage = this.publishStage;
        return publishStage == PublishStage.NONE || publishStage == PublishStage.FAILED;
    }

    public String toString() {
        return "IntimateUploadTaskBatchInfo(uploadParams=" + this.uploadParams + ", uploadResultBoolMap=" + this.uploadResultBoolMap + ", uploadResultMap=" + this.uploadResultMap + ", publishStage=" + this.publishStage + ")";
    }

    public IntimateUploadTaskBatchInfo(IntimateUploadAlbumParams uploadParams, ConcurrentHashMap<String, Boolean> uploadResultBoolMap, ConcurrentHashMap<String, IntimateUploadMediaResult> uploadResultMap, PublishStage publishStage) {
        Intrinsics.checkNotNullParameter(uploadParams, "uploadParams");
        Intrinsics.checkNotNullParameter(uploadResultBoolMap, "uploadResultBoolMap");
        Intrinsics.checkNotNullParameter(uploadResultMap, "uploadResultMap");
        Intrinsics.checkNotNullParameter(publishStage, "publishStage");
        this.uploadParams = uploadParams;
        this.uploadResultBoolMap = uploadResultBoolMap;
        this.uploadResultMap = uploadResultMap;
        this.publishStage = publishStage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntimateUploadTaskBatchInfo copy$default(IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo, IntimateUploadAlbumParams intimateUploadAlbumParams, ConcurrentHashMap concurrentHashMap, ConcurrentHashMap concurrentHashMap2, PublishStage publishStage, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            intimateUploadAlbumParams = intimateUploadTaskBatchInfo.uploadParams;
        }
        if ((i3 & 2) != 0) {
            concurrentHashMap = intimateUploadTaskBatchInfo.uploadResultBoolMap;
        }
        if ((i3 & 4) != 0) {
            concurrentHashMap2 = intimateUploadTaskBatchInfo.uploadResultMap;
        }
        if ((i3 & 8) != 0) {
            publishStage = intimateUploadTaskBatchInfo.publishStage;
        }
        return intimateUploadTaskBatchInfo.copy(intimateUploadAlbumParams, concurrentHashMap, concurrentHashMap2, publishStage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntimateUploadTaskBatchInfo)) {
            return false;
        }
        IntimateUploadTaskBatchInfo intimateUploadTaskBatchInfo = (IntimateUploadTaskBatchInfo) other;
        return Intrinsics.areEqual(this.uploadParams, intimateUploadTaskBatchInfo.uploadParams) && Intrinsics.areEqual(this.uploadResultBoolMap, intimateUploadTaskBatchInfo.uploadResultBoolMap) && Intrinsics.areEqual(this.uploadResultMap, intimateUploadTaskBatchInfo.uploadResultMap) && this.publishStage == intimateUploadTaskBatchInfo.publishStage;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ IntimateUploadTaskBatchInfo(com.qzone.publish.business.model.intimate.IntimateUploadAlbumParams r20, java.util.concurrent.ConcurrentHashMap r21, java.util.concurrent.ConcurrentHashMap r22, com.qzone.publish.business.model.intimate.PublishStage r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r19 = this;
            r0 = r24 & 1
            if (r0 == 0) goto L1f
            com.qzone.publish.business.model.intimate.IntimateUploadAlbumParams r0 = new com.qzone.publish.business.model.intimate.IntimateUploadAlbumParams
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
            goto L21
        L1f:
            r0 = r20
        L21:
            r1 = r24 & 2
            if (r1 == 0) goto L2b
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap
            r1.<init>()
            goto L2d
        L2b:
            r1 = r21
        L2d:
            r2 = r24 & 4
            if (r2 == 0) goto L37
            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap
            r2.<init>()
            goto L39
        L37:
            r2 = r22
        L39:
            r3 = r24 & 8
            if (r3 == 0) goto L42
            com.qzone.publish.business.model.intimate.PublishStage r3 = com.qzone.publish.business.model.intimate.PublishStage.NONE
            r4 = r19
            goto L46
        L42:
            r4 = r19
            r3 = r23
        L46:
            r4.<init>(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qzone.publish.business.model.intimate.IntimateUploadTaskBatchInfo.<init>(com.qzone.publish.business.model.intimate.IntimateUploadAlbumParams, java.util.concurrent.ConcurrentHashMap, java.util.concurrent.ConcurrentHashMap, com.qzone.publish.business.model.intimate.PublishStage, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
