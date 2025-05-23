package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SecurityButton {
    public JumpType jumpType;
    public String url;
    public String wording;

    public SecurityButton() {
        this.wording = "";
        this.url = "";
        this.jumpType = JumpType.values()[0];
    }

    public JumpType getJumpType() {
        return this.jumpType;
    }

    public String getUrl() {
        return this.url;
    }

    public String getWording() {
        return this.wording;
    }

    public SecurityButton(String str, String str2, JumpType jumpType) {
        this.wording = "";
        this.url = "";
        JumpType jumpType2 = JumpType.values()[0];
        this.wording = str;
        this.url = str2;
        this.jumpType = jumpType;
    }
}
