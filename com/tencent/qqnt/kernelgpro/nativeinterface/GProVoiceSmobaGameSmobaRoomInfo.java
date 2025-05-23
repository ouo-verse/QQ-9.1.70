package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameSmobaRoomInfo {
    public int gameMode;
    public ArrayList<Integer> gradeList;

    public GProVoiceSmobaGameSmobaRoomInfo() {
        this.gradeList = new ArrayList<>();
    }

    public int getGameMode() {
        return this.gameMode;
    }

    public ArrayList<Integer> getGradeList() {
        return this.gradeList;
    }

    public String toString() {
        return "GProVoiceSmobaGameSmobaRoomInfo{gameMode=" + this.gameMode + ",gradeList=" + this.gradeList + ",}";
    }

    public GProVoiceSmobaGameSmobaRoomInfo(int i3, ArrayList<Integer> arrayList) {
        new ArrayList();
        this.gameMode = i3;
        this.gradeList = arrayList;
    }
}
