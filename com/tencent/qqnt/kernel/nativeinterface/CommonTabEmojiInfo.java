package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CommonTabEmojiInfo {
    public int bottomEmojitabType;
    public int epId;
    public int expireTime;
    public int flags;
    public boolean isHide;
    public String tabName = "";
    public int wordingId;

    public int getBottomEmojitabType() {
        return this.bottomEmojitabType;
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

    public boolean getIsHide() {
        return this.isHide;
    }

    public String getTabName() {
        return this.tabName;
    }

    public int getWordingId() {
        return this.wordingId;
    }

    public String toString() {
        return "CommonTabEmojiInfo{epId=" + this.epId + ",expireTime=" + this.expireTime + ",flags=" + this.flags + ",wordingId=" + this.wordingId + ",bottomEmojitabType=" + this.bottomEmojitabType + ",tabName=" + this.tabName + ",isHide=" + this.isHide + ",}";
    }
}
