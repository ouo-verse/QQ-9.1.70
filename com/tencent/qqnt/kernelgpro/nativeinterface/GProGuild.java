package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuild implements Serializable {
    public GProCmdUinInfo cmdUinInfo;
    public String errMsg;
    public long guildId;
    public GProGuildInfo guildInfo;
    public int memberCode;
    public int privateChannelMemberMaxNum;
    public int result;
    long serialVersionUID;

    public GProGuild() {
        this.serialVersionUID = 1L;
        this.errMsg = "";
        this.guildInfo = new GProGuildInfo();
        this.cmdUinInfo = new GProCmdUinInfo();
    }

    public GProCmdUinInfo getCmdUinInfo() {
        return this.cmdUinInfo;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public int getMemberCode() {
        return this.memberCode;
    }

    public int getPrivateChannelMemberMaxNum() {
        return this.privateChannelMemberMaxNum;
    }

    public int getResult() {
        return this.result;
    }

    public void setCmdUinInfo(GProCmdUinInfo gProCmdUinInfo) {
        this.cmdUinInfo = gProCmdUinInfo;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setGuildInfo(GProGuildInfo gProGuildInfo) {
        this.guildInfo = gProGuildInfo;
    }

    public void setMemberCode(int i3) {
        this.memberCode = i3;
    }

    public void setPrivateChannelMemberMaxNum(int i3) {
        this.privateChannelMemberMaxNum = i3;
    }

    public void setResult(int i3) {
        this.result = i3;
    }

    public String toString() {
        return "GProGuild{result=" + this.result + ",errMsg=" + this.errMsg + ",guildId=" + this.guildId + ",guildInfo=" + this.guildInfo + ",cmdUinInfo=" + this.cmdUinInfo + ",privateChannelMemberMaxNum=" + this.privateChannelMemberMaxNum + ",memberCode=" + this.memberCode + ",}";
    }

    public GProGuild(int i3, String str, long j3, GProGuildInfo gProGuildInfo, GProCmdUinInfo gProCmdUinInfo, int i16) {
        this.serialVersionUID = 1L;
        this.errMsg = "";
        this.guildInfo = new GProGuildInfo();
        new GProCmdUinInfo();
        this.result = i3;
        this.errMsg = str;
        this.guildId = j3;
        this.guildInfo = gProGuildInfo;
        this.cmdUinInfo = gProCmdUinInfo;
        this.privateChannelMemberMaxNum = i16;
    }
}
