package com.tencent.qcircle.weseevideo.model.effect;

import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicModel extends BaseEffectModel {
    private int duration;
    private int filePath;
    private MusicMaterialMetaDataBean metaDataBean;
    private String musicId;
    private String musicPath;
    private int offset;
    private MusicMaterialMetaDataBean userMetaDataBean;
    private boolean closeLyric = false;
    private float bgmVolume = 0.8f;
    private float volume = 0.3f;
    private boolean manuallyChangedVolume = false;
    private boolean changeMusicByUser = false;

    public void clear() {
        this.musicId = "";
        this.metaDataBean = null;
        this.closeLyric = false;
        this.offset = 0;
        this.duration = 0;
        this.filePath = 0;
        this.bgmVolume = 0.8f;
        this.volume = 0.3f;
        this.source = 0;
    }

    public float getBgmVolume() {
        return this.bgmVolume;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFilePath() {
        return this.filePath;
    }

    public MusicMaterialMetaDataBean getMetaDataBean() {
        return this.metaDataBean;
    }

    public String getMusicId() {
        return this.musicId;
    }

    public String getMusicPath() {
        return this.musicPath;
    }

    public int getOffset() {
        return this.offset;
    }

    public MusicMaterialMetaDataBean getUserMetaDataBean() {
        return this.userMetaDataBean;
    }

    public float getVolume() {
        return this.volume;
    }

    public boolean isChangeMusicByUser() {
        return this.changeMusicByUser;
    }

    public boolean isCloseLyric() {
        return this.closeLyric;
    }

    public boolean isManuallyChangedVolume() {
        return this.manuallyChangedVolume;
    }

    public void setBgmVolume(float f16) {
        this.bgmVolume = f16;
    }

    public void setChangeMusicByUser(boolean z16) {
        this.changeMusicByUser = z16;
    }

    public void setCloseLyric(boolean z16) {
        this.closeLyric = z16;
    }

    public void setDuration(int i3) {
        this.duration = i3;
    }

    public void setFilePath(int i3) {
        this.filePath = i3;
    }

    public void setManuallyChangedVolume(boolean z16) {
        this.manuallyChangedVolume = z16;
    }

    public void setMetaDataBean(MusicMaterialMetaDataBean musicMaterialMetaDataBean) {
        this.metaDataBean = musicMaterialMetaDataBean;
    }

    public void setMusicId(String str) {
        this.musicId = str;
    }

    public void setMusicPath(String str) {
        this.musicPath = str;
    }

    public void setOffset(int i3) {
        this.offset = i3;
    }

    public void setUserMetaDataBean(MusicMaterialMetaDataBean musicMaterialMetaDataBean) {
        this.userMetaDataBean = musicMaterialMetaDataBean;
    }

    public void setVolume(float f16) {
        this.volume = f16;
    }
}
