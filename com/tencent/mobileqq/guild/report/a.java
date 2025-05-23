package com.tencent.mobileqq.guild.report;

import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements f {

    /* renamed from: a, reason: collision with root package name */
    private String f232000a;

    /* renamed from: b, reason: collision with root package name */
    private String f232001b;

    /* renamed from: c, reason: collision with root package name */
    private String f232002c;

    /* renamed from: d, reason: collision with root package name */
    private String f232003d;

    /* renamed from: e, reason: collision with root package name */
    private long f232004e;

    public a(String str, String str2) {
        this.f232000a = str;
        this.f232001b = str2;
    }

    @Override // com.tencent.mobileqq.guild.report.f
    public void a() {
        this.f232004e = System.currentTimeMillis();
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).reportPageInAttaData(this.f232000a, this.f232001b, this.f232002c, this.f232003d);
    }

    @Override // com.tencent.mobileqq.guild.report.f
    public void c() {
        long j3;
        long currentTimeMillis = System.currentTimeMillis() - this.f232004e;
        if (currentTimeMillis > 0) {
            j3 = currentTimeMillis;
        } else {
            j3 = 0;
        }
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).reportPageOutAttaData(this.f232000a, this.f232001b, this.f232002c, this.f232003d, j3);
    }

    @Override // com.tencent.mobileqq.guild.report.f
    public void b() {
    }

    @Override // com.tencent.mobileqq.guild.report.f
    public void d() {
    }
}
