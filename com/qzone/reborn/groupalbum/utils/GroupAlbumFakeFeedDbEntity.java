package com.qzone.reborn.groupalbum.utils;

import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes37.dex */
public class GroupAlbumFakeFeedDbEntity extends Entity {
    public String clintKey;
    public byte[] data;
    public String ext1;
    public String ext2;
    public String ext3;
    public String ext4;
    public byte[] extData;
    public String groupId;
    public long insertTime;

    public GroupAlbumFakeFeedDbEntity() {
        this.groupId = "";
        this.clintKey = "";
        this.ext1 = "";
        this.ext2 = "";
        this.ext3 = "";
        this.ext4 = "";
    }

    public String toString() {
        return "GroupAlbumFakeFeedDbEntity{groupId='" + this.groupId + "'clintKey=" + this.clintKey + "', ext1='" + this.ext1 + "', ext2='" + this.ext2 + "', ext3='" + this.ext3 + "', ext4='" + this.ext4 + "'}";
    }

    public GroupAlbumFakeFeedDbEntity(String str, String str2, byte[] bArr, byte[] bArr2) {
        this.ext1 = "";
        this.ext2 = "";
        this.ext3 = "";
        this.ext4 = "";
        this.groupId = str;
        this.clintKey = str2;
        this.data = bArr;
        this.extData = bArr2;
    }
}
