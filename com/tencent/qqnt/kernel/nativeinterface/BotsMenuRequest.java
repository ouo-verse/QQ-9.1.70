package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BotsMenuRequest {
    public long c2cUin;
    public long channel;
    public long filter;
    public long groupCode;

    /* renamed from: guild, reason: collision with root package name */
    public long f359160guild;
    public int num;
    public int page;
    public ArrayList<Long> uins = new ArrayList<>();
    public GProNTBotClientInfo clientInfo = new GProNTBotClientInfo();
    public ArrayList<Long> tinyids = new ArrayList<>();
    public CommonBotScene scene = CommonBotScene.values()[0];
    public String bkn = "";

    public String getBkn() {
        return this.bkn;
    }

    public long getC2cUin() {
        return this.c2cUin;
    }

    public long getChannel() {
        return this.channel;
    }

    public GProNTBotClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public long getFilter() {
        return this.filter;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public long getGuild() {
        return this.f359160guild;
    }

    public int getNum() {
        return this.num;
    }

    public int getPage() {
        return this.page;
    }

    public CommonBotScene getScene() {
        return this.scene;
    }

    public ArrayList<Long> getTinyids() {
        return this.tinyids;
    }

    public ArrayList<Long> getUins() {
        return this.uins;
    }

    public void setBkn(String str) {
        this.bkn = str;
    }

    public void setC2cUin(long j3) {
        this.c2cUin = j3;
    }

    public void setChannel(long j3) {
        this.channel = j3;
    }

    public void setClientInfo(GProNTBotClientInfo gProNTBotClientInfo) {
        this.clientInfo = gProNTBotClientInfo;
    }

    public void setFilter(long j3) {
        this.filter = j3;
    }

    public void setGroupCode(long j3) {
        this.groupCode = j3;
    }

    public void setGuild(long j3) {
        this.f359160guild = j3;
    }

    public void setNum(int i3) {
        this.num = i3;
    }

    public void setPage(int i3) {
        this.page = i3;
    }

    public void setScene(CommonBotScene commonBotScene) {
        this.scene = commonBotScene;
    }

    public void setTinyids(ArrayList<Long> arrayList) {
        this.tinyids = arrayList;
    }

    public void setUins(ArrayList<Long> arrayList) {
        this.uins = arrayList;
    }

    public String toString() {
        return "BotsMenuRequest{uins=" + this.uins + ",num=" + this.num + ",guild=" + this.f359160guild + ",channel=" + this.channel + ",clientInfo=" + this.clientInfo + ",tinyids=" + this.tinyids + ",page=" + this.page + ",scene=" + this.scene + ",filter=" + this.filter + ",groupCode=" + this.groupCode + ",c2cUin=" + this.c2cUin + ",bkn=" + this.bkn + ",}";
    }
}
