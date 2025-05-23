package com.tencent.biz.addContactTroopView;

import tencent.im.troop_view.troopviewInfo$RspBody;

/* compiled from: P */
/* loaded from: classes2.dex */
class AddContactTroopManage$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ troopviewInfo$RspBody f78349d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.this$0) {
            a aVar = this.this$0;
            troopviewInfo$RspBody troopviewinfo_rspbody = this.f78349d;
            aVar.f78351e = troopviewinfo_rspbody;
            aVar.b(troopviewinfo_rspbody);
        }
    }
}
