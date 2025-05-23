package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProSpeakPermissionInfo {
    public Boolean sendAdvertise;
    public Boolean sendLink;
    public ArrayList<String> sendProhibiteWords;
    public Boolean sendQrCode;
    public Boolean sendRedPacket;

    public Boolean getSendAdvertise() {
        return this.sendAdvertise;
    }

    public Boolean getSendLink() {
        return this.sendLink;
    }

    public ArrayList<String> getSendProhibiteWords() {
        return this.sendProhibiteWords;
    }

    public Boolean getSendQrCode() {
        return this.sendQrCode;
    }

    public Boolean getSendRedPacket() {
        return this.sendRedPacket;
    }

    public String toString() {
        return "GProSpeakPermissionInfo{sendRedPacket=" + this.sendRedPacket + ",sendLink=" + this.sendLink + ",sendQrCode=" + this.sendQrCode + ",sendAdvertise=" + this.sendAdvertise + ",sendProhibiteWords=" + this.sendProhibiteWords + ",}";
    }
}
