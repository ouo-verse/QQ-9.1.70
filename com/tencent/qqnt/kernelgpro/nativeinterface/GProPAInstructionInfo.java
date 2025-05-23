package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPAInstructionInfo implements Serializable {
    public String data;
    public long logoutTime;
    public int logoutType;
    public int modal;

    /* renamed from: msg, reason: collision with root package name */
    public String f359306msg;
    public String ruleFamily;
    public String ruleName;
    long serialVersionUID;
    public String title;
    public int type;
    public String url;

    public GProPAInstructionInfo() {
        this.serialVersionUID = 1L;
        this.title = "";
        this.f359306msg = "";
        this.url = "";
        this.data = "";
        this.ruleName = "";
        this.ruleFamily = "";
    }

    public String getData() {
        return this.data;
    }

    public long getLogoutTime() {
        return this.logoutTime;
    }

    public int getLogoutType() {
        return this.logoutType;
    }

    public int getModal() {
        return this.modal;
    }

    public String getMsg() {
        return this.f359306msg;
    }

    public String getRuleFamily() {
        return this.ruleFamily;
    }

    public String getRuleName() {
        return this.ruleName;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProPAInstructionInfo{type=" + this.type + ",title=" + this.title + ",msg=" + this.f359306msg + JefsClass.INDEX_URL + this.url + ",modal=" + this.modal + ",data=" + this.data + ",logoutTime=" + this.logoutTime + ",ruleName=" + this.ruleName + ",ruleFamily=" + this.ruleFamily + ",logoutType=" + this.logoutType + ",}";
    }

    public GProPAInstructionInfo(int i3, String str, String str2, String str3, int i16, String str4, long j3, String str5, String str6, int i17) {
        this.serialVersionUID = 1L;
        this.type = i3;
        this.title = str;
        this.f359306msg = str2;
        this.url = str3;
        this.modal = i16;
        this.data = str4;
        this.logoutTime = j3;
        this.ruleName = str5;
        this.ruleFamily = str6;
        this.logoutType = i17;
    }
}
