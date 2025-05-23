package com.tencent.mobileqq.together.clockin;

import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends Observable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f293337a = false;

    public boolean a() {
        if (QLog.isColorLevel()) {
            QLog.d("ClockAnimController", 2, "isPlayAnim : isPlayAnim = " + this.f293337a);
        }
        return this.f293337a;
    }

    public void b(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ClockAnimController", 2, "notifyAnimChanged : nEventId = " + i3);
        }
        if (i3 == 1) {
            this.f293337a = true;
        }
        if (i3 == 4) {
            this.f293337a = false;
        }
        setChanged();
        notifyObservers(Integer.valueOf(i3));
    }
}
