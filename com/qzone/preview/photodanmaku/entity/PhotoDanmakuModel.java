package com.qzone.preview.photodanmaku.entity;

import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import java.util.Objects;

/* loaded from: classes39.dex */
public class PhotoDanmakuModel {
    public QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo;
    public String content;
    public String fontId;
    public String fontType;
    public String fontUrl;
    public String nickName;
    public QzoneSuperPersonalFontData.SuperFontInfo superFontInfo;
    public long userUin;

    public PhotoDanmakuModel(String str, long j3, String str2, QzoneSuperPersonalFontData.SuperFontInfo superFontInfo, String str3, String str4, String str5, QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
        this.nickName = str;
        this.userUin = j3;
        this.content = str2;
        this.superFontInfo = superFontInfo;
        this.fontId = str3;
        this.fontType = str4;
        this.fontUrl = str5;
        this.barrageEffectInfo = barrageEffectInfo;
    }

    public int hashCode() {
        return Objects.hash(this.nickName, Long.valueOf(this.userUin), this.content, this.fontId, this.fontType, this.fontUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoDanmakuModel)) {
            return false;
        }
        PhotoDanmakuModel photoDanmakuModel = (PhotoDanmakuModel) obj;
        return this.userUin == photoDanmakuModel.userUin && Objects.equals(this.nickName, photoDanmakuModel.nickName) && Objects.equals(this.content, photoDanmakuModel.content) && Objects.equals(this.fontId, photoDanmakuModel.fontId) && Objects.equals(this.fontType, photoDanmakuModel.fontType) && Objects.equals(this.fontUrl, photoDanmakuModel.fontUrl);
    }
}
