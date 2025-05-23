package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l implements k {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<com.tencent.mvp.c> f178322d;

    public void c(com.tencent.mvp.c cVar) {
        this.f178322d = new WeakReference<>(cVar);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.k
    public boolean isNowThemeIsNight(AppRuntime appRuntime, boolean z16, String str) {
        return ThemeUtil.isNowThemeIsNight(appRuntime, z16, str);
    }
}
