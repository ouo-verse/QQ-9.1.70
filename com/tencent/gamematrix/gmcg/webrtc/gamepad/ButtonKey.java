package com.tencent.gamematrix.gmcg.webrtc.gamepad;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ButtonKey {
    private int mKeyCode;
    private String mName;
    private String mSimpleName;

    public ButtonKey(int i3, String str, String str2) {
        this.mKeyCode = i3;
        this.mName = str;
        this.mSimpleName = str2;
    }

    public int getKeyCode() {
        return this.mKeyCode;
    }

    public String getName() {
        return this.mName;
    }

    public String getSimpleName() {
        return this.mSimpleName;
    }

    public void setCode(int i3) {
        this.mKeyCode = i3;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSimpleName(String str) {
        this.mSimpleName = str;
    }
}
