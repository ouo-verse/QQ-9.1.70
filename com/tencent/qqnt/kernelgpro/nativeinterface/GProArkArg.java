package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProArkArg {
    public String app;
    public String config;
    public String desc;
    public String meta;
    public String prompt;
    public String ver;
    public String view;

    public GProArkArg() {
        this.app = "";
        this.view = "";
        this.ver = "";
        this.desc = "";
        this.prompt = "";
        this.meta = "";
        this.config = "";
    }

    public String getApp() {
        return this.app;
    }

    public String getConfig() {
        return this.config;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getMeta() {
        return this.meta;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public String getVer() {
        return this.ver;
    }

    public String getView() {
        return this.view;
    }

    public String toString() {
        return "GProArkArg{app=" + this.app + ",view=" + this.view + ",ver=" + this.ver + ",desc=" + this.desc + ",prompt=" + this.prompt + ",meta=" + this.meta + ",config=" + this.config + ",}";
    }

    public GProArkArg(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.app = str;
        this.view = str2;
        this.ver = str3;
        this.desc = str4;
        this.prompt = str5;
        this.meta = str6;
        this.config = str7;
    }
}
