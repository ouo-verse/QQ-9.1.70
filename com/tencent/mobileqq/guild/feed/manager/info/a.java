package com.tencent.mobileqq.guild.feed.manager.info;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f220185a;

    /* renamed from: b, reason: collision with root package name */
    private String f220186b;

    /* renamed from: c, reason: collision with root package name */
    private String f220187c;

    /* renamed from: d, reason: collision with root package name */
    private int f220188d;

    public static a a(IGProChannelInfo iGProChannelInfo) {
        a aVar = new a();
        aVar.f(iGProChannelInfo.getChannelUin());
        aVar.h(iGProChannelInfo.getGuildId());
        aVar.g(iGProChannelInfo.getChannelName());
        aVar.i(iGProChannelInfo.getVisibleType());
        return aVar;
    }

    public String b() {
        return this.f220186b;
    }

    public String c() {
        return this.f220187c;
    }

    public String d() {
        return this.f220185a;
    }

    public int e() {
        return this.f220188d;
    }

    public void f(String str) {
        this.f220186b = str;
    }

    public void g(String str) {
        this.f220187c = str;
    }

    public void h(String str) {
        this.f220185a = str;
    }

    public void i(int i3) {
        this.f220188d = i3;
    }
}
