package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MediaClusteringListReq {
    public int count;
    public int seq;
    public String fileSetId = "";
    public ClusteringType type = ClusteringType.values()[0];
    public FaceAvatarResize faceAvatarResize = new FaceAvatarResize();
    public FlashTransferSceneType sceneType = FlashTransferSceneType.values()[0];

    public int getCount() {
        return this.count;
    }

    public FaceAvatarResize getFaceAvatarResize() {
        return this.faceAvatarResize;
    }

    public String getFileSetId() {
        return this.fileSetId;
    }

    public FlashTransferSceneType getSceneType() {
        return this.sceneType;
    }

    public int getSeq() {
        return this.seq;
    }

    public ClusteringType getType() {
        return this.type;
    }
}
