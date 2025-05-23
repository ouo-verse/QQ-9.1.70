package com.tencent.av.app;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InviteMemberObserverWithoutCache implements Observer {

    /* renamed from: d, reason: collision with root package name */
    Handler f72983d = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        Object[] objArr = (Object[]) obj;
        int intValue = ((Integer) objArr[0]).intValue();
        if (QLog.isColorLevel()) {
            QLog.d("qav.GAudioUIObserver", 2, "OnUpdate\uff0cmsgType = " + intValue);
        }
        if (objArr.length >= 4 && intValue == 709) {
            c(((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue(), (ArrayList) objArr[3]);
        }
    }

    protected void c(long j3, long j16, ArrayList<com.tencent.av.gaudio.a> arrayList) {
        throw null;
    }

    @Override // java.util.Observer
    public void update(Observable observable, final Object obj) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            if (this.f72983d == null) {
                this.f72983d = new Handler(mainLooper);
            }
            this.f72983d.post(new Runnable() { // from class: com.tencent.av.app.InviteMemberObserverWithoutCache.1
                @Override // java.lang.Runnable
                public void run() {
                    InviteMemberObserverWithoutCache.this.b(obj);
                }
            });
            return;
        }
        b(obj);
    }
}
