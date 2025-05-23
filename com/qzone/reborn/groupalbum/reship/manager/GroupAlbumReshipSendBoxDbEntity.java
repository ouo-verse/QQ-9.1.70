package com.qzone.reborn.groupalbum.reship.manager;

import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes37.dex */
public class GroupAlbumReshipSendBoxDbEntity extends Entity {
    public byte[] data;
    public String groupId;
    public long insertTime;
    public String mediaId;

    public GroupAlbumReshipSendBoxDbEntity() {
        this.groupId = "";
        this.mediaId = "";
    }

    public String toString() {
        return "GroupAlbumSendBoxDbEntity{groupId='" + this.groupId + "', mediaId=" + this.mediaId + "', insertTime=" + this.insertTime + "'}";
    }

    public GroupAlbumReshipSendBoxDbEntity(String str, String str2, byte[] bArr, long j3) {
        this.groupId = str;
        this.mediaId = str2;
        this.data = bArr;
        this.insertTime = j3;
    }
}
