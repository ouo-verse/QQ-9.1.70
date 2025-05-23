package com.tencent.thumbplayer.api.common;

/* loaded from: classes26.dex */
public class TPSubtitleText extends TPSubtitleData {
    private String mText;
    private int mTrackID;

    @Override // com.tencent.thumbplayer.api.common.TPSubtitleData
    public int getDataType() {
        return 0;
    }

    public String getText() {
        return this.mText;
    }

    public int getTrackID() {
        return this.mTrackID;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTrackID(int i3) {
        this.mTrackID = i3;
    }
}
