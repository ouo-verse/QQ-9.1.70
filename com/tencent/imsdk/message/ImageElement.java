package com.tencent.imsdk.message;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ImageElement extends MessageBaseElement {
    private int compressType;
    private int imageFormat;
    private int largeImageFileSize;
    private int largeImageHeight;
    private String largeImageUUID;
    private String largeImageUrl;
    private int largeImageWidth;
    private String originImageFilePath;
    private int originImageFileSize;
    private int originImageHeight;
    private String originImageUUID;
    private String originImageUrl;
    private int originImageWidth;
    private int thumbImageFileSize;
    private int thumbImageHeight;
    private String thumbImageUUID;
    private String thumbImageUrl;
    private int thumbImageWidth;

    public ImageElement() {
        setElementType(3);
    }

    public int getCompressType() {
        return this.compressType;
    }

    public int getImageFormat() {
        return this.imageFormat;
    }

    public int getLargeImageFileSize() {
        return this.largeImageFileSize;
    }

    public int getLargeImageHeight() {
        return this.largeImageHeight;
    }

    public String getLargeImageUUID() {
        return this.largeImageUUID;
    }

    public String getLargeImageUrl() {
        return this.largeImageUrl;
    }

    public int getLargeImageWidth() {
        return this.largeImageWidth;
    }

    public String getOriginImageFilePath() {
        return this.originImageFilePath;
    }

    public int getOriginImageFileSize() {
        return this.originImageFileSize;
    }

    public int getOriginImageHeight() {
        return this.originImageHeight;
    }

    public String getOriginImageUUID() {
        return this.originImageUUID;
    }

    public String getOriginImageUrl() {
        return this.originImageUrl;
    }

    public int getOriginImageWidth() {
        return this.originImageWidth;
    }

    public int getThumbImageFileSize() {
        return this.thumbImageFileSize;
    }

    public int getThumbImageHeight() {
        return this.thumbImageHeight;
    }

    public String getThumbImageUUID() {
        return this.thumbImageUUID;
    }

    public String getThumbImageUrl() {
        return this.thumbImageUrl;
    }

    public int getThumbImageWidth() {
        return this.thumbImageWidth;
    }

    public void setOriginImageFilePath(String str) {
        this.originImageFilePath = str;
    }

    @Override // com.tencent.imsdk.message.MessageBaseElement
    public boolean update(MessageBaseElement messageBaseElement) {
        if (this.elementType == messageBaseElement.elementType) {
            ImageElement imageElement = (ImageElement) messageBaseElement;
            if (this.originImageFilePath.equals(imageElement.originImageFilePath)) {
                this.imageFormat = imageElement.imageFormat;
                this.compressType = imageElement.compressType;
                this.originImageUUID = imageElement.originImageUUID;
                this.originImageUrl = imageElement.originImageUrl;
                this.originImageFileSize = imageElement.originImageFileSize;
                this.originImageWidth = imageElement.originImageWidth;
                this.originImageHeight = imageElement.originImageHeight;
                this.thumbImageUUID = imageElement.thumbImageUUID;
                this.thumbImageUrl = imageElement.thumbImageUrl;
                this.thumbImageFileSize = imageElement.thumbImageFileSize;
                this.thumbImageWidth = imageElement.thumbImageWidth;
                this.thumbImageHeight = imageElement.thumbImageHeight;
                this.largeImageUUID = imageElement.largeImageUUID;
                this.largeImageUrl = imageElement.largeImageUrl;
                this.largeImageFileSize = imageElement.largeImageFileSize;
                this.largeImageWidth = imageElement.largeImageWidth;
                this.largeImageHeight = imageElement.largeImageHeight;
                return true;
            }
            return false;
        }
        return false;
    }
}
