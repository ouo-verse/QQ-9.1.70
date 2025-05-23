package com.tencent.mobileqq.activity.aio.qim;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
class QIMUserManager$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f179772d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f179773e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ QQAppInterface f179774f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f179775h;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        int h16;
        int i3;
        boolean l3;
        boolean z16;
        h16 = this.this$0.h(this.f179772d, this.f179773e);
        if (h16 == 0) {
            l3 = this.this$0.l(this.f179773e);
            if (l3) {
                this.this$0.n();
                this.this$0.f179794k = false;
                this.this$0.f179784a = 2;
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f179774f.getApp()).edit();
                z16 = this.this$0.f179794k;
                edit.putBoolean(AppConstants.Preferences.QIM_USER_SPECIAL_FORCE_DOWDLORD, z16);
                edit.commit();
            } else {
                this.this$0.f179784a = 4;
            }
        } else {
            this.this$0.f179784a = 3;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f179775h);
            sb5.append(" startDownLoadQimTheme QimIconsState ");
            i3 = this.this$0.f179784a;
            sb5.append(i3);
            QLog.i("QIMUserManager", 2, sb5.toString());
        }
    }
}
