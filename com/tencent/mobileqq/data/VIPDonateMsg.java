package com.tencent.mobileqq.data;

import java.io.Serializable;

/* loaded from: classes10.dex */
public class VIPDonateMsg implements Serializable {
    public static final long serialVersionUID = 1;
    public String brief;
    public String footer;
    public String jumpUrl;
    public String subTitle;
    public String title;

    public String toString() {
        return "VIPDonateMsg [title=" + this.title + ", subTitle=" + this.subTitle + ", footer=" + this.footer + ", jumpUrl=" + this.jumpUrl + ", brief=" + this.brief + "]";
    }
}
