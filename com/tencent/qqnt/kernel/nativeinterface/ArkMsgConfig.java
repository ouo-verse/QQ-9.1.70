package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ArkMsgConfig {
    public int collect;
    public int entry;
    public int flag;
    public int reply;
    public int retCode;
    public int type;
    public int ver;
    public String icon = "";
    public String name = "";
    public ArrayList<String> fwdViews = new ArrayList<>();
    public String bizName = "";

    public String getBizName() {
        return this.bizName;
    }

    public int getCollect() {
        return this.collect;
    }

    public int getEntry() {
        return this.entry;
    }

    public int getFlag() {
        return this.flag;
    }

    public ArrayList<String> getFwdViews() {
        return this.fwdViews;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public int getReply() {
        return this.reply;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public int getType() {
        return this.type;
    }

    public int getVer() {
        return this.ver;
    }

    public String toString() {
        return "ArkMsgConfig{entry=" + this.entry + ",flag=" + this.flag + ",icon=" + this.icon + ",name=" + this.name + ",type=" + this.type + ",ver=" + this.ver + ",fwdViews=" + this.fwdViews + ",bizName=" + this.bizName + ",reply=" + this.reply + ",collect=" + this.collect + ",retCode=" + this.retCode + ",}";
    }
}
