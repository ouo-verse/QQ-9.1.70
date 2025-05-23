package com.tencent.thumbplayer.api.common;

import androidx.annotation.Nullable;

/* loaded from: classes26.dex */
public class TPTrackInfo {
    private String mLanguage;
    private String mName;
    private int mMediaType = -1;
    private boolean mIsSelected = false;
    private boolean mIsExclusive = true;
    private boolean mIsInternal = true;
    private ITPContainerInfo mContainerInfo = null;

    @Nullable
    public ITPContainerInfo getContainerInfo() {
        return this.mContainerInfo;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isExclusive() {
        return this.mIsExclusive;
    }

    public boolean isInternal() {
        return this.mIsInternal;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setContainerInfo(@Nullable ITPContainerInfo iTPContainerInfo) {
        this.mContainerInfo = iTPContainerInfo;
    }

    public void setExclusive(boolean z16) {
        this.mIsExclusive = z16;
    }

    public void setInternal(boolean z16) {
        this.mIsInternal = z16;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public void setMediaType(int i3) {
        this.mMediaType = i3;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSelected(boolean z16) {
        this.mIsSelected = z16;
    }
}
