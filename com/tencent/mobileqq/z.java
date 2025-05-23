package com.tencent.mobileqq;

import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;

/* compiled from: P */
/* loaded from: classes9.dex */
public final /* synthetic */ class z implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ QQSettingMeViewModel f327855d;

    public /* synthetic */ z(QQSettingMeViewModel qQSettingMeViewModel) {
        this.f327855d = qQSettingMeViewModel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f327855d.onResume();
    }
}
