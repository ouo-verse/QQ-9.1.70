package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GWGProJoinGuildChoiceQuestion implements Serializable {
    protected ArrayList<GWGProJoinGuildChoiceQuestionItem> mItems = new ArrayList<>();
    protected int mNeedAnswerNum;
    protected int mPassCorrectNum;

    public ArrayList<GWGProJoinGuildChoiceQuestionItem> getItems() {
        return this.mItems;
    }

    public int getNeedAnswerNum() {
        return this.mNeedAnswerNum;
    }

    public int getPassCorrectNum() {
        return this.mPassCorrectNum;
    }

    public void setItems(ArrayList<GWGProJoinGuildChoiceQuestionItem> arrayList) {
        this.mItems = arrayList;
    }

    public void setNeedAnswerNum(int i3) {
        this.mNeedAnswerNum = i3;
    }

    public void setPassCorrectNum(int i3) {
        this.mPassCorrectNum = i3;
    }

    public String toString() {
        return "GWGProJoinGuildChoiceQuestion{mNeedAnswerNum=" + this.mNeedAnswerNum + "mPassCorrectNum=" + this.mPassCorrectNum + "mItems=" + this.mItems + "}";
    }
}
