package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FeedBackDataForMsg {
    public int button;
    public boolean checked;
    public String data;

    public FeedBackDataForMsg() {
        this.data = "";
    }

    public int getButton() {
        return this.button;
    }

    public boolean getChecked() {
        return this.checked;
    }

    public String getData() {
        return this.data;
    }

    public String toString() {
        return "FeedBackDataForMsg{button=" + this.button + ",checked=" + this.checked + ",data=" + this.data + ",}";
    }

    public FeedBackDataForMsg(int i3, boolean z16, String str) {
        this.button = i3;
        this.checked = z16;
        this.data = str;
    }
}
