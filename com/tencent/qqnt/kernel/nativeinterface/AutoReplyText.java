package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AutoReplyText {
    public ArrayList<MsgElement> content;

    public AutoReplyText() {
        this.content = new ArrayList<>();
    }

    public ArrayList<MsgElement> getContent() {
        return this.content;
    }

    public String toString() {
        return "AutoReplyText{content=" + this.content + ",}";
    }

    public AutoReplyText(ArrayList<MsgElement> arrayList) {
        new ArrayList();
        this.content = arrayList;
    }
}
