package com.tencent.mobileqq.guild.channel.manage;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public String f215082b;

    /* renamed from: c, reason: collision with root package name */
    public IGProChannelInfo f215083c;

    /* renamed from: d, reason: collision with root package name */
    public IGProChannel f215084d;

    /* renamed from: e, reason: collision with root package name */
    public int f215085e;

    /* renamed from: f, reason: collision with root package name */
    public long f215086f;

    /* renamed from: g, reason: collision with root package name */
    public int f215087g = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f215088h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f215089i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f215090j = false;

    /* renamed from: a, reason: collision with root package name */
    public int f215081a = 0;

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("GuildChannelInfoUIData{mType=");
        sb5.append(this.f215081a);
        sb5.append(", mTitleName='");
        sb5.append(this.f215082b);
        sb5.append('\'');
        sb5.append(", mChannelSize=");
        sb5.append(this.f215085e);
        sb5.append(", mCategoryId=");
        sb5.append(this.f215086f);
        sb5.append(", mChannelInfo=");
        IGProChannelInfo iGProChannelInfo = this.f215083c;
        if (iGProChannelInfo != null) {
            str = iGProChannelInfo.getChannelName();
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }
}
