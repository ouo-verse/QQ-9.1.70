package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserLiveRoomInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class fo implements ff {

    /* renamed from: a, reason: collision with root package name */
    private GProUserLiveRoomInfo f266066a;

    public fo(GProUserLiveRoomInfo gProUserLiveRoomInfo) {
        this.f266066a = gProUserLiveRoomInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ff
    public String a() {
        return this.f266066a.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ff
    public String getCoverUrl() {
        return this.f266066a.getCoverUrl();
    }
}
