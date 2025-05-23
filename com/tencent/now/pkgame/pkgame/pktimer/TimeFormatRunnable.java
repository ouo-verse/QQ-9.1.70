package com.tencent.now.pkgame.pkgame.pktimer;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;

/* compiled from: P */
/* loaded from: classes22.dex */
class TimeFormatRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private MutableLiveData<c> f339033d;

    /* renamed from: e, reason: collision with root package name */
    private String f339034e;

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f339034e)) {
            return;
        }
        c cVar = new c();
        cVar.f339038a = false;
        this.f339033d.setValue(cVar);
    }
}
