package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProJoinGuildChoiceQuestionItem implements Serializable {
    public ArrayList<String> answers;
    public String correctAnswer;
    public String question;
    long serialVersionUID;

    public GProJoinGuildChoiceQuestionItem() {
        this.serialVersionUID = 1L;
        this.question = "";
        this.correctAnswer = "";
        this.answers = new ArrayList<>();
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setAnswers(ArrayList<String> arrayList) {
        this.answers = arrayList;
    }

    public void setCorrectAnswer(String str) {
        this.correctAnswer = str;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public String toString() {
        return "GProJoinGuildChoiceQuestionItem{question=" + this.question + ",correctAnswer=" + this.correctAnswer + ",answers=" + this.answers + ",}";
    }

    public GProJoinGuildChoiceQuestionItem(String str, String str2, ArrayList<String> arrayList) {
        this.serialVersionUID = 1L;
        this.question = "";
        this.correctAnswer = "";
        new ArrayList();
        this.question = str;
        this.correctAnswer = str2;
        this.answers = arrayList;
    }
}
