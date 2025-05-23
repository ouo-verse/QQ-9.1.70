package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public class GWGProJoinGuildWordQuestionItem implements Serializable {
    protected String mQuestion = "";
    protected String mCorrectAnswer = "";

    public String getCorrectAnswer() {
        return this.mCorrectAnswer;
    }

    public String getQuestion() {
        return this.mQuestion;
    }

    public void setCorrectAnswer(String str) {
        this.mCorrectAnswer = str;
    }

    public void setQuestion(String str) {
        this.mQuestion = str;
    }

    public String toString() {
        return "GWGProJoinGuildWordQuestionItem{mQuestion=" + this.mQuestion + "mCorrectAnswer=" + this.mCorrectAnswer + "}";
    }
}
