package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameGameStaticInfo implements Serializable {
    public String coverUrl;
    public String gameMode;
    public String gameName;
    public ArrayList<String> gradeNames;
    public String iconUrl;
    public long maxNum;
    long serialVersionUID;

    public GProVoiceSmobaGameGameStaticInfo() {
        this.serialVersionUID = 1L;
        this.gameName = "";
        this.gameMode = "";
        this.iconUrl = "";
        this.coverUrl = "";
        this.gradeNames = new ArrayList<>();
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getGameMode() {
        return this.gameMode;
    }

    public String getGameName() {
        return this.gameName;
    }

    public ArrayList<String> getGradeNames() {
        return this.gradeNames;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public long getMaxNum() {
        return this.maxNum;
    }

    public String toString() {
        return "GProVoiceSmobaGameGameStaticInfo{gameName=" + this.gameName + ",gameMode=" + this.gameMode + ",iconUrl=" + this.iconUrl + ",coverUrl=" + this.coverUrl + ",maxNum=" + this.maxNum + ",gradeNames=" + this.gradeNames + ",}";
    }

    public GProVoiceSmobaGameGameStaticInfo(String str, String str2, String str3, String str4, long j3, ArrayList<String> arrayList) {
        this.serialVersionUID = 1L;
        this.gameName = "";
        this.gameMode = "";
        this.iconUrl = "";
        this.coverUrl = "";
        new ArrayList();
        this.gameName = str;
        this.gameMode = str2;
        this.iconUrl = str3;
        this.coverUrl = str4;
        this.maxNum = j3;
        this.gradeNames = arrayList;
    }
}
