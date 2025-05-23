package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GWGProJoinGuildChoiceQuestionItem implements Serializable {
    protected String mQuestion = "";
    protected String mCorrectAnswer = "";
    protected ArrayList<String> mAnswers = new ArrayList<>();

    public ArrayList<String> getAnswers() {
        return this.mAnswers;
    }

    public String getCorrectAnswer() {
        return this.mCorrectAnswer;
    }

    public String getQuestion() {
        return this.mQuestion;
    }

    public void setAnswers(ArrayList<String> arrayList) {
        this.mAnswers = arrayList;
    }

    public void setCorrectAnswer(String str) {
        this.mCorrectAnswer = str;
    }

    public void setQuestion(String str) {
        this.mQuestion = str;
    }

    public String toString() {
        return "GWGProJoinGuildChoiceQuestionItem{mQuestion=" + this.mQuestion + "mCorrectAnswer=" + this.mCorrectAnswer + "mAnswers=" + this.mAnswers + "}";
    }
}
