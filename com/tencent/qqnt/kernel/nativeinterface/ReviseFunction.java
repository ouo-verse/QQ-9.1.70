package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ReviseFunction {
    public boolean revise;
    public String title = "";
    public String questionMarkUrl = "";
    public String questionMarkMsg = "";

    public String getQuestionMarkMsg() {
        return this.questionMarkMsg;
    }

    public String getQuestionMarkUrl() {
        return this.questionMarkUrl;
    }

    public boolean getRevise() {
        return this.revise;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "ReviseFunction{title=" + this.title + ",questionMarkUrl=" + this.questionMarkUrl + ",questionMarkMsg=" + this.questionMarkMsg + ",revise=" + this.revise + ",}";
    }
}
