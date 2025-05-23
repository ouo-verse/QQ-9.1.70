package com.tencent.mobileqq.activity.richmedia.state;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d extends e {
    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void a() {
        RMVideoStateMgr.u().f(2);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.e
    public void b() {
        g gVar = RMVideoStateMgr.u().Q;
        if (gVar != null) {
            gVar.V();
        }
    }
}
