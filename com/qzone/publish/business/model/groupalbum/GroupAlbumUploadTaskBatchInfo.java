package com.qzone.publish.business.model.groupalbum;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001#B=\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0015\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u00c6\u0003J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004H\u00c6\u0003J?\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadTaskBatchInfo;", "Ljava/io/Serializable;", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "component1", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "component2", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadMediaResult;", "component3", "uploadParams", "uploadResultBoolMap", "uploadResultMap", "copy", "toString", "", "hashCode", "", "other", "equals", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "getUploadParams", "()Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "setUploadParams", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "getUploadResultBoolMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setUploadResultBoolMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getUploadResultMap", "setUploadResultMap", "<init>", "(Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;Ljava/util/concurrent/ConcurrentHashMap;Ljava/util/concurrent/ConcurrentHashMap;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class GroupAlbumUploadTaskBatchInfo implements Serializable {
    private static final long serialVersionUID = -2203078732665558772L;
    private GroupAlbumUploadAlbumParams uploadParams;
    private ConcurrentHashMap<String, Boolean> uploadResultBoolMap;
    private ConcurrentHashMap<String, GroupAlbumUploadMediaResult> uploadResultMap;

    public GroupAlbumUploadTaskBatchInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final GroupAlbumUploadAlbumParams getUploadParams() {
        return this.uploadParams;
    }

    public final ConcurrentHashMap<String, Boolean> component2() {
        return this.uploadResultBoolMap;
    }

    public final ConcurrentHashMap<String, GroupAlbumUploadMediaResult> component3() {
        return this.uploadResultMap;
    }

    public final GroupAlbumUploadTaskBatchInfo copy(GroupAlbumUploadAlbumParams uploadParams, ConcurrentHashMap<String, Boolean> uploadResultBoolMap, ConcurrentHashMap<String, GroupAlbumUploadMediaResult> uploadResultMap) {
        Intrinsics.checkNotNullParameter(uploadParams, "uploadParams");
        Intrinsics.checkNotNullParameter(uploadResultBoolMap, "uploadResultBoolMap");
        Intrinsics.checkNotNullParameter(uploadResultMap, "uploadResultMap");
        return new GroupAlbumUploadTaskBatchInfo(uploadParams, uploadResultBoolMap, uploadResultMap);
    }

    public final GroupAlbumUploadAlbumParams getUploadParams() {
        return this.uploadParams;
    }

    public final ConcurrentHashMap<String, Boolean> getUploadResultBoolMap() {
        return this.uploadResultBoolMap;
    }

    public final ConcurrentHashMap<String, GroupAlbumUploadMediaResult> getUploadResultMap() {
        return this.uploadResultMap;
    }

    public int hashCode() {
        return (((this.uploadParams.hashCode() * 31) + this.uploadResultBoolMap.hashCode()) * 31) + this.uploadResultMap.hashCode();
    }

    public final void setUploadParams(GroupAlbumUploadAlbumParams groupAlbumUploadAlbumParams) {
        Intrinsics.checkNotNullParameter(groupAlbumUploadAlbumParams, "<set-?>");
        this.uploadParams = groupAlbumUploadAlbumParams;
    }

    public final void setUploadResultBoolMap(ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.uploadResultBoolMap = concurrentHashMap;
    }

    public final void setUploadResultMap(ConcurrentHashMap<String, GroupAlbumUploadMediaResult> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.uploadResultMap = concurrentHashMap;
    }

    public String toString() {
        return "GroupAlbumUploadTaskBatchInfo(uploadParams=" + this.uploadParams + ", uploadResultBoolMap=" + this.uploadResultBoolMap + ", uploadResultMap=" + this.uploadResultMap + ")";
    }

    public GroupAlbumUploadTaskBatchInfo(GroupAlbumUploadAlbumParams uploadParams, ConcurrentHashMap<String, Boolean> uploadResultBoolMap, ConcurrentHashMap<String, GroupAlbumUploadMediaResult> uploadResultMap) {
        Intrinsics.checkNotNullParameter(uploadParams, "uploadParams");
        Intrinsics.checkNotNullParameter(uploadResultBoolMap, "uploadResultBoolMap");
        Intrinsics.checkNotNullParameter(uploadResultMap, "uploadResultMap");
        this.uploadParams = uploadParams;
        this.uploadResultBoolMap = uploadResultBoolMap;
        this.uploadResultMap = uploadResultMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupAlbumUploadTaskBatchInfo copy$default(GroupAlbumUploadTaskBatchInfo groupAlbumUploadTaskBatchInfo, GroupAlbumUploadAlbumParams groupAlbumUploadAlbumParams, ConcurrentHashMap concurrentHashMap, ConcurrentHashMap concurrentHashMap2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            groupAlbumUploadAlbumParams = groupAlbumUploadTaskBatchInfo.uploadParams;
        }
        if ((i3 & 2) != 0) {
            concurrentHashMap = groupAlbumUploadTaskBatchInfo.uploadResultBoolMap;
        }
        if ((i3 & 4) != 0) {
            concurrentHashMap2 = groupAlbumUploadTaskBatchInfo.uploadResultMap;
        }
        return groupAlbumUploadTaskBatchInfo.copy(groupAlbumUploadAlbumParams, concurrentHashMap, concurrentHashMap2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupAlbumUploadTaskBatchInfo)) {
            return false;
        }
        GroupAlbumUploadTaskBatchInfo groupAlbumUploadTaskBatchInfo = (GroupAlbumUploadTaskBatchInfo) other;
        return Intrinsics.areEqual(this.uploadParams, groupAlbumUploadTaskBatchInfo.uploadParams) && Intrinsics.areEqual(this.uploadResultBoolMap, groupAlbumUploadTaskBatchInfo.uploadResultBoolMap) && Intrinsics.areEqual(this.uploadResultMap, groupAlbumUploadTaskBatchInfo.uploadResultMap);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ GroupAlbumUploadTaskBatchInfo(com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams r20, java.util.concurrent.ConcurrentHashMap r21, java.util.concurrent.ConcurrentHashMap r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r19 = this;
            r0 = r23 & 1
            if (r0 == 0) goto L1f
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
            goto L21
        L1f:
            r0 = r20
        L21:
            r1 = r23 & 2
            if (r1 == 0) goto L2b
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap
            r1.<init>()
            goto L2d
        L2b:
            r1 = r21
        L2d:
            r2 = r23 & 4
            if (r2 == 0) goto L39
            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap
            r2.<init>()
            r3 = r19
            goto L3d
        L39:
            r3 = r19
            r2 = r22
        L3d:
            r3.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qzone.publish.business.model.groupalbum.GroupAlbumUploadTaskBatchInfo.<init>(com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams, java.util.concurrent.ConcurrentHashMap, java.util.concurrent.ConcurrentHashMap, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
