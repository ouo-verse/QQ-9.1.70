package com.tencent.tavsticker.model;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TAVStickerResource {
    private ByteBuffer byteBuffer;
    private String filePath;
    private TAVResourceType resourceType;

    public TAVStickerResource(TAVResourceType tAVResourceType, String str, ByteBuffer byteBuffer) {
        TAVResourceType tAVResourceType2 = TAVResourceType.UNKNOWN;
        this.resourceType = tAVResourceType;
        this.filePath = str;
        this.byteBuffer = byteBuffer;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public TAVResourceType getResourceType() {
        return this.resourceType;
    }

    public String toString() {
        return "TAVStickerResource {resourceType : " + this.resourceType + ", filePath : " + this.filePath + "}";
    }
}
