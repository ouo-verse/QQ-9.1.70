package com.tencent.biz.pubaccount.weishi.event;

import com.tencent.biz.pubaccount.weishi.config.experiment.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSExpEvent extends WSSimpleBaseEvent {
    private d mPolicyEntities;

    public WSExpEvent(d dVar) {
        this.mPolicyEntities = dVar;
    }

    public d getPolicyEntities() {
        return this.mPolicyEntities;
    }
}
