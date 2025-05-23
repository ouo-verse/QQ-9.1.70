package com.tencent.mobileqq.activity.aio.tim;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
class TIMUserManager$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f179998d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f179999e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ QQAppInterface f180000f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f180001h;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        int h16;
        int i3;
        boolean l3;
        boolean z16;
        h16 = this.this$0.h(this.f179998d, this.f179999e);
        if (h16 == 0) {
            l3 = this.this$0.l(this.f179999e);
            if (l3) {
                this.this$0.n();
                this.this$0.f180020k = false;
                this.this$0.f180010a = 2;
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f180000f.getApp()).edit();
                z16 = this.this$0.f180020k;
                edit.putBoolean(AppConstants.Preferences.TIM_USER_SPECIAL_FORCE_DOWDLORD, z16);
                edit.commit();
            } else {
                this.this$0.f180010a = 4;
            }
        } else {
            this.this$0.f180010a = 3;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f180001h);
            sb5.append(" startDownLoadTimTheme TimIconsState ");
            i3 = this.this$0.f180010a;
            sb5.append(i3);
            QLog.i("TIMUserManager", 2, sb5.toString());
        }
    }
}
