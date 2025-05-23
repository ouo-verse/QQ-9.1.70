package com.tencent.mobileqq.guild.feed.publish.result;

import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;
import jn1.c;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final c f223175b;

    public a(c cVar) {
        this.f223175b = cVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223175b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.FONT_STYLE;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
