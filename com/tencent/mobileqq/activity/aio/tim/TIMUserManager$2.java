package com.tencent.mobileqq.activity.aio.tim;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
class TIMUserManager$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f180002d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f180003e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f180004f;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        int h16;
        int i3;
        boolean l3;
        h16 = this.this$0.h(this.f180002d, this.f180003e);
        if (h16 == 0) {
            l3 = this.this$0.l(this.f180003e);
            if (l3) {
                this.this$0.n();
                this.this$0.f180010a = 2;
            } else {
                this.this$0.f180010a = 4;
            }
        } else {
            this.this$0.f180010a = 3;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f180004f);
            sb5.append(" startDownLoadTimTheme TimIconsState ");
            i3 = this.this$0.f180010a;
            sb5.append(i3);
            QLog.i("TIMUserManager", 2, sb5.toString());
        }
    }
}
