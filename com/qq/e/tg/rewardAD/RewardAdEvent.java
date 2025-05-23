package com.qq.e.tg.rewardAD;

import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.pi.IEGRVADI;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardAdEvent extends ADEvent {

    /* renamed from: a, reason: collision with root package name */
    private IEGRVADI f40606a;

    public RewardAdEvent(int i3) {
        super(i3);
    }

    public IEGRVADI getDelegate() {
        return this.f40606a;
    }

    public RewardAdEvent(int i3, IEGRVADI iegrvadi, Object[] objArr) {
        super(i3, objArr);
        this.f40606a = iegrvadi;
    }
}
