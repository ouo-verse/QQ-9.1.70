package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProJoinGuildChoiceQuestion implements Serializable {
    public ArrayList<GProJoinGuildChoiceQuestionItem> items;
    public int needAnswerNum;
    public int passCorrectNum;
    long serialVersionUID;

    public GProJoinGuildChoiceQuestion() {
        this.serialVersionUID = 1L;
        this.items = new ArrayList<>();
    }

    public ArrayList<GProJoinGuildChoiceQuestionItem> getItems() {
        return this.items;
    }

    public int getNeedAnswerNum() {
        return this.needAnswerNum;
    }

    public int getPassCorrectNum() {
        return this.passCorrectNum;
    }

    public void setItems(ArrayList<GProJoinGuildChoiceQuestionItem> arrayList) {
        this.items = arrayList;
    }

    public void setNeedAnswerNum(int i3) {
        this.needAnswerNum = i3;
    }

    public void setPassCorrectNum(int i3) {
        this.passCorrectNum = i3;
    }

    public String toString() {
        return "GProJoinGuildChoiceQuestion{needAnswerNum=" + this.needAnswerNum + ",passCorrectNum=" + this.passCorrectNum + ",items=" + this.items + ",}";
    }

    public GProJoinGuildChoiceQuestion(int i3, int i16, ArrayList<GProJoinGuildChoiceQuestionItem> arrayList) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.needAnswerNum = i3;
        this.passCorrectNum = i16;
        this.items = arrayList;
    }
}
