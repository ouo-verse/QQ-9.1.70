package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProJoinGuildWordQuestionItem implements Serializable {
    public String correctAnswer;
    public String question;
    long serialVersionUID;

    public GProJoinGuildWordQuestionItem() {
        this.serialVersionUID = 1L;
        this.question = "";
        this.correctAnswer = "";
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setCorrectAnswer(String str) {
        this.correctAnswer = str;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public String toString() {
        return "GProJoinGuildWordQuestionItem{question=" + this.question + ",correctAnswer=" + this.correctAnswer + ",}";
    }

    public GProJoinGuildWordQuestionItem(String str, String str2) {
        this.serialVersionUID = 1L;
        this.question = str;
        this.correctAnswer = str2;
    }
}
