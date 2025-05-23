package com.tencent.mobileqq.wink.editor.tts.source;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes21.dex */
public class TTSAudioInfo implements Serializable {
    public static int TYPE_TEMPLATE_TYPE_PLACEHOLDER = -999;
    private TTSAudioItem[] audioItems;
    private String displayName;
    private int downloadStatus;
    private String stickerId;
    private int templateType;
    private String[] texts;
    private float volume;

    public TTSAudioInfo(String[] strArr) {
        this.templateType = TYPE_TEMPLATE_TYPE_PLACEHOLDER;
        this.volume = 1.0f;
        this.texts = strArr;
    }

    public TTSAudioInfo copy(int i3, String str, TTSAudioItem[] tTSAudioItemArr, float f16, String str2) {
        this.templateType = i3;
        this.displayName = str;
        this.audioItems = tTSAudioItemArr;
        this.volume = f16;
        this.stickerId = str2;
        return this;
    }

    public TTSAudioItem[] getAudioItems() {
        return this.audioItems;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public String getStickerId() {
        return this.stickerId;
    }

    public int getTemplateType() {
        return this.templateType;
    }

    public String[] getTexts() {
        return this.texts;
    }

    public float getVolume() {
        return this.volume;
    }

    public boolean isAudioAvailable() {
        TTSAudioItem[] tTSAudioItemArr = this.audioItems;
        if (tTSAudioItemArr == null || tTSAudioItemArr.length <= 0) {
            return false;
        }
        for (TTSAudioItem tTSAudioItem : tTSAudioItemArr) {
            if (tTSAudioItem.getDownloadStatus() != 2) {
                return false;
            }
        }
        return true;
    }

    public void setAudioItems(TTSAudioItem[] tTSAudioItemArr) {
        this.audioItems = tTSAudioItemArr;
        if (tTSAudioItemArr != null && tTSAudioItemArr.length > 0) {
            for (TTSAudioItem tTSAudioItem : tTSAudioItemArr) {
                tTSAudioItem.setVolume(this.volume);
            }
        }
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setDownloadStatus(int i3) {
        this.downloadStatus = i3;
    }

    public void setStickerId(String str) {
        this.stickerId = str;
    }

    public void setTemplateType(int i3) {
        this.templateType = i3;
    }

    public void setVolume(float f16) {
        this.volume = f16;
        TTSAudioItem[] tTSAudioItemArr = this.audioItems;
        if (tTSAudioItemArr != null) {
            for (TTSAudioItem tTSAudioItem : tTSAudioItemArr) {
                tTSAudioItem.setVolume(f16);
            }
        }
    }

    public TTSAudioInfo(String[] strArr, int i3) {
        this(strArr);
        this.templateType = i3;
    }

    public TTSAudioInfo(String[] strArr, int i3, float f16) {
        this(strArr, i3);
        this.volume = f16;
    }

    public TTSAudioInfo(String[] strArr, int i3, float f16, String str) {
        this(strArr, i3, f16);
        this.stickerId = str;
    }
}
