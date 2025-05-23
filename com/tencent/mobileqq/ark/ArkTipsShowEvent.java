package com.tencent.mobileqq.ark;

import com.tencent.mvi.base.route.MsgIntent;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkTipsShowEvent implements MsgIntent {

    /* renamed from: d, reason: collision with root package name */
    private String f198876d;

    /* renamed from: e, reason: collision with root package name */
    private long f198877e;

    public ArkTipsShowEvent(String str, long j3) {
        this.f198876d = str;
        this.f198877e = j3;
    }

    public String a() {
        return this.f198876d;
    }

    public long b() {
        return this.f198877e;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return false;
    }
}
