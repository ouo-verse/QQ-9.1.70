package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class JoinGroupVerifyInfo {
    public JoinGroupVerifyType type = JoinGroupVerifyType.values()[0];
    public String url = "";

    public JoinGroupVerifyType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "JoinGroupVerifyInfo{type=" + this.type + JefsClass.INDEX_URL + this.url + ",}";
    }
}
