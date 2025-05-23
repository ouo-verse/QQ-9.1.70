package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSmobaArchiveTemplate {
    public int gradeLevel;
    public int starCnt;
    public String winNum = "";
    public String mvpNum = "";
    public String winRate = "";
    public String goodBranch = "";
    public ArrayList<String> goodHeroIconList = new ArrayList<>();

    public String getGoodBranch() {
        return this.goodBranch;
    }

    public ArrayList<String> getGoodHeroIconList() {
        return this.goodHeroIconList;
    }

    public int getGradeLevel() {
        return this.gradeLevel;
    }

    public String getMvpNum() {
        return this.mvpNum;
    }

    public int getStarCnt() {
        return this.starCnt;
    }

    public String getWinNum() {
        return this.winNum;
    }

    public String getWinRate() {
        return this.winRate;
    }

    public String toString() {
        return "GProSmobaArchiveTemplate{gradeLevel=" + this.gradeLevel + ",starCnt=" + this.starCnt + ",winNum=" + this.winNum + ",mvpNum=" + this.mvpNum + ",winRate=" + this.winRate + ",goodBranch=" + this.goodBranch + ",goodHeroIconList=" + this.goodHeroIconList + ",}";
    }
}
