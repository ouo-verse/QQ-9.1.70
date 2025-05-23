package com.tencent.qcircle.weseevideo.model.effect;

import android.text.TextUtils;
import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoEndModel extends VideoPagModel {
    private float compositionDuration;
    private String landscapePag;
    private String mEndName;
    private String mId;
    private int mLastPosition;
    private String mPackageUrl;
    private String mType;
    private String miniVersion;
    private String pag;

    public VideoEndModel() {
        this.effectType = VideoEffectType.TYPE_VIDEO_END.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VideoEndModel videoEndModel = (VideoEndModel) obj;
        if (!TextUtils.equals(this.mEndName, videoEndModel.mEndName) || !TextUtils.equals(this.mId, videoEndModel.mId)) {
            return false;
        }
        return TextUtils.equals(this.mType, videoEndModel.mType);
    }

    public float getCompositionDuration() {
        return this.compositionDuration;
    }

    public String getEndName() {
        return this.mEndName;
    }

    public String getId() {
        return this.mId;
    }

    public String getLandscapePag() {
        return this.landscapePag;
    }

    public int getLastPosition() {
        return this.mLastPosition;
    }

    public String getMiniVersion() {
        return this.miniVersion;
    }

    public String getPackageUrl() {
        return this.mPackageUrl;
    }

    public String getPag() {
        return this.pag;
    }

    public String getType() {
        return this.mType;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.mEndName;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        String str2 = this.mId;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        String str3 = this.mType;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    public void setCompositionDuration(float f16) {
        this.compositionDuration = f16;
    }

    public void setEndName(String str) {
        this.mEndName = str;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setLandscapePag(String str) {
        this.landscapePag = str;
    }

    public void setLastPosition(int i3) {
        this.mLastPosition = i3;
    }

    public void setMiniVersion(String str) {
        this.miniVersion = str;
    }

    public void setPackageUrl(String str) {
        this.mPackageUrl = str;
    }

    public void setPag(String str) {
        this.pag = str;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
