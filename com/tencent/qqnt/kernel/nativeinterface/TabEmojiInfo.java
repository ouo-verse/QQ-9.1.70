package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TabEmojiInfo {
    public int epId;
    public int expireTime;
    public int flags;
    public String tabName;
    public int tabType;
    public int wordingId;

    public TabEmojiInfo() {
        this.tabName = "";
    }

    public int getEpId() {
        return this.epId;
    }

    public int getExpireTime() {
        return this.expireTime;
    }

    public int getFlags() {
        return this.flags;
    }

    public String getTabName() {
        return this.tabName;
    }

    public int getTabType() {
        return this.tabType;
    }

    public int getWordingId() {
        return this.wordingId;
    }

    public String toString() {
        return "TabEmojiInfo{epId=" + this.epId + ",expireTime=" + this.expireTime + ",flags=" + this.flags + ",wordingId=" + this.wordingId + ",tabType=" + this.tabType + ",tabName=" + this.tabName + ",}";
    }

    public TabEmojiInfo(int i3, int i16, int i17, int i18, int i19, String str) {
        this.epId = i3;
        this.expireTime = i16;
        this.flags = i17;
        this.wordingId = i18;
        this.tabType = i19;
        this.tabName = str;
    }
}
