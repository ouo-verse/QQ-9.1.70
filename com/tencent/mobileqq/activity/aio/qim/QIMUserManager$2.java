package com.tencent.mobileqq.activity.aio.qim;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
class QIMUserManager$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f179776d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f179777e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f179778f;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        int h16;
        int i3;
        boolean l3;
        h16 = this.this$0.h(this.f179776d, this.f179777e);
        if (h16 == 0) {
            l3 = this.this$0.l(this.f179777e);
            if (l3) {
                this.this$0.n();
                this.this$0.f179784a = 2;
            } else {
                this.this$0.f179784a = 4;
            }
        } else {
            this.this$0.f179784a = 3;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f179778f);
            sb5.append(" startDownLoadQimTheme QimIconsState ");
            i3 = this.this$0.f179784a;
            sb5.append(i3);
            QLog.i("QIMUserManager", 2, sb5.toString());
        }
    }
}
