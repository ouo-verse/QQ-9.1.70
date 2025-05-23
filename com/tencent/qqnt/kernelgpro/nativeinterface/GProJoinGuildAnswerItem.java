package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProJoinGuildAnswerItem {
    public String answer;
    public String question;

    public GProJoinGuildAnswerItem() {
        this.question = "";
        this.answer = "";
    }

    public String getAnswer() {
        return this.answer;
    }

    public String getQuestion() {
        return this.question;
    }

    public String toString() {
        return "GProJoinGuildAnswerItem{question=" + this.question + ",answer=" + this.answer + ",}";
    }

    public GProJoinGuildAnswerItem(String str, String str2) {
        this.question = str;
        this.answer = str2;
    }
}
