package com.tencent.mobileqq.onlinestatus.observer;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.JumpActivity;
import mqq.app.MobileQQ;
import mqq.observer.BusinessObserver;
import zp3.d;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    public d f256099d;

    public c(d dVar) {
        this.f256099d = dVar;
    }

    public void a() {
        d dVar = this.f256099d;
        if (dVar != null && dVar.getContext() != null) {
            Context context = this.f256099d.getContext();
            if (context instanceof JumpActivity) {
                ((JumpActivity) context).finish();
            }
        }
        MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(this);
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        if (i3 == 1) {
            a();
        }
    }
}
