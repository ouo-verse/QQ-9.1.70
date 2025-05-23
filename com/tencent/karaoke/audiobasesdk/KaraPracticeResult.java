package com.tencent.karaoke.audiobasesdk;

/* loaded from: classes7.dex */
public class KaraPracticeResult {
    public int qrcLineNo;
    public int scoreType;
    public int[] wordResultType;

    public int getQrcLineNo() {
        return this.qrcLineNo;
    }

    public int getScoreType() {
        return this.scoreType;
    }

    public int[] getWordResultType() {
        return this.wordResultType;
    }

    public void setQrcLineNo(int i3) {
        this.qrcLineNo = i3;
    }

    public void setScoreType(int i3) {
        this.scoreType = i3;
    }

    public void setWordResultType(int[] iArr) {
        this.wordResultType = iArr;
    }

    public String toString() {
        int length;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("qrcLineNo: " + this.qrcLineNo + "\n");
        sb5.append("scoreType : " + this.scoreType + "\n");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("wordResultType:");
        int[] iArr = this.wordResultType;
        if (iArr == null) {
            length = -1;
        } else {
            length = iArr.length;
        }
        sb6.append(length);
        sb5.append(sb6.toString());
        return sb5.toString();
    }
}
