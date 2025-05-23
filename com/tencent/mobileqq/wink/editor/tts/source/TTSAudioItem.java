package com.tencent.mobileqq.wink.editor.tts.source;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.AudioInfo;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes21.dex */
public class TTSAudioItem implements Serializable {
    public static final int STATUS_DEFAULT = 0;
    public static final int STATUS_DOWNLOADED = 2;
    public static final int STATUS_DOWNLOADING = 1;
    private AudioInfo audioInfo;
    private long duration;
    private String localPath;
    private float volume;
    private long startTime = -1;
    private int downloadStatus = 0;

    public TTSAudioItem(AudioInfo audioInfo) {
        this.audioInfo = audioInfo;
    }

    public AudioInfo getAudioInfo() {
        return this.audioInfo;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public float getVolume() {
        return this.volume;
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        this.audioInfo = audioInfo;
    }

    public void setDownloadStatus(int i3) {
        this.downloadStatus = i3;
    }

    public void setDuration(long j3) {
        this.duration = j3;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setStartTime(long j3) {
        this.startTime = j3;
    }

    public void setVolume(float f16) {
        this.volume = f16;
    }
}
