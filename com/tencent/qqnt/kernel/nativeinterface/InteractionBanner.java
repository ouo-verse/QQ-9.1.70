package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InteractionBanner {
    public boolean isMulti;
    public long user;
    public String url = "";
    public String singleGroupText = "";
    public String multiGroupText = "";

    public boolean getIsMulti() {
        return this.isMulti;
    }

    public String getMultiGroupText() {
        return this.multiGroupText;
    }

    public String getSingleGroupText() {
        return this.singleGroupText;
    }

    public String getUrl() {
        return this.url;
    }

    public long getUser() {
        return this.user;
    }

    public String toString() {
        return "InteractionBanner{isMulti=" + this.isMulti + JefsClass.INDEX_URL + this.url + ",user=" + this.user + ",singleGroupText=" + this.singleGroupText + ",multiGroupText=" + this.multiGroupText + ",}";
    }
}
