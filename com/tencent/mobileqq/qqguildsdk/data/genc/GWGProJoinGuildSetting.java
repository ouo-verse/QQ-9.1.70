package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public class GWGProJoinGuildSetting implements Serializable {
    protected int mOptionType;
    protected GWGProJoinGuildWordQuestion mWordQuestion = new GWGProJoinGuildWordQuestion();
    protected GWGProJoinGuildChoiceQuestion mChoiceQuestion = new GWGProJoinGuildChoiceQuestion();

    public GWGProJoinGuildChoiceQuestion getChoiceQuestion() {
        return this.mChoiceQuestion;
    }

    public int getOptionType() {
        return this.mOptionType;
    }

    public GWGProJoinGuildWordQuestion getWordQuestion() {
        return this.mWordQuestion;
    }

    public void setChoiceQuestion(GWGProJoinGuildChoiceQuestion gWGProJoinGuildChoiceQuestion) {
        this.mChoiceQuestion = gWGProJoinGuildChoiceQuestion;
    }

    public void setOptionType(int i3) {
        this.mOptionType = i3;
    }

    public void setWordQuestion(GWGProJoinGuildWordQuestion gWGProJoinGuildWordQuestion) {
        this.mWordQuestion = gWGProJoinGuildWordQuestion;
    }

    public String toString() {
        return "GWGProJoinGuildSetting{mOptionType=" + this.mOptionType + "mWordQuestion=" + this.mWordQuestion + "mChoiceQuestion=" + this.mChoiceQuestion + "}";
    }
}
