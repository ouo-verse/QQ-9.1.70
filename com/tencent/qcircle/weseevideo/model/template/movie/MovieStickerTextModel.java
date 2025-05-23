package com.tencent.qcircle.weseevideo.model.template.movie;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MovieStickerTextModel {
    private int stickerTextColor = -1;
    private String stickerTextContent;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MovieStickerTextModel movieStickerTextModel = (MovieStickerTextModel) obj;
        if (this.stickerTextColor == movieStickerTextModel.stickerTextColor && this.stickerTextContent.equals(movieStickerTextModel.stickerTextContent)) {
            return true;
        }
        return false;
    }

    public int getStickerTextColor() {
        return this.stickerTextColor;
    }

    public String getStickerTextContent() {
        return this.stickerTextContent;
    }

    public void setStickerTextColor(int i3) {
        this.stickerTextColor = i3;
    }

    public void setStickerTextContent(String str) {
        this.stickerTextContent = str;
    }

    public String toString() {
        return "MovieStickerTextModel{stickerTextContent='" + this.stickerTextContent + "', stickerTextColor=" + this.stickerTextColor + '}';
    }
}
