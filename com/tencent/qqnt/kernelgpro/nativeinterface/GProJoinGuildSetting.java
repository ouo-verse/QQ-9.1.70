package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProJoinGuildSetting implements Serializable {
    public GProJoinGuildChoiceQuestion choiceQuestion;
    public int optionType;
    long serialVersionUID;
    public GProJoinGuildWordQuestion wordQuestion;

    public GProJoinGuildSetting() {
        this.serialVersionUID = 1L;
        this.wordQuestion = new GProJoinGuildWordQuestion();
        this.choiceQuestion = new GProJoinGuildChoiceQuestion();
    }

    public GProJoinGuildChoiceQuestion getChoiceQuestion() {
        return this.choiceQuestion;
    }

    public int getOptionType() {
        return this.optionType;
    }

    public GProJoinGuildWordQuestion getWordQuestion() {
        return this.wordQuestion;
    }

    public void setChoiceQuestion(GProJoinGuildChoiceQuestion gProJoinGuildChoiceQuestion) {
        this.choiceQuestion = gProJoinGuildChoiceQuestion;
    }

    public void setOptionType(int i3) {
        this.optionType = i3;
    }

    public void setWordQuestion(GProJoinGuildWordQuestion gProJoinGuildWordQuestion) {
        this.wordQuestion = gProJoinGuildWordQuestion;
    }

    public String toString() {
        return "GProJoinGuildSetting{optionType=" + this.optionType + ",wordQuestion=" + this.wordQuestion + ",choiceQuestion=" + this.choiceQuestion + ",}";
    }

    public GProJoinGuildSetting(int i3, GProJoinGuildWordQuestion gProJoinGuildWordQuestion, GProJoinGuildChoiceQuestion gProJoinGuildChoiceQuestion) {
        this.serialVersionUID = 1L;
        this.wordQuestion = new GProJoinGuildWordQuestion();
        new GProJoinGuildChoiceQuestion();
        this.optionType = i3;
        this.wordQuestion = gProJoinGuildWordQuestion;
        this.choiceQuestion = gProJoinGuildChoiceQuestion;
    }
}
