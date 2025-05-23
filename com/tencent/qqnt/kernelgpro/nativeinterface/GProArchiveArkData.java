package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProArchiveArkData {
    public GProArkArg arkArgs;
    public int clientId;
    public String icon;
    public String name;

    public GProArchiveArkData() {
        this.name = "";
        this.icon = "";
        this.arkArgs = new GProArkArg();
    }

    public GProArkArg getArkArgs() {
        return this.arkArgs;
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProArchiveArkData{clientId=" + this.clientId + ",name=" + this.name + ",icon=" + this.icon + ",arkArgs=" + this.arkArgs + ",}";
    }

    public GProArchiveArkData(int i3, String str, String str2, GProArkArg gProArkArg) {
        this.name = "";
        this.icon = "";
        new GProArkArg();
        this.clientId = i3;
        this.name = str;
        this.icon = str2;
        this.arkArgs = gProArkArg;
    }
}
