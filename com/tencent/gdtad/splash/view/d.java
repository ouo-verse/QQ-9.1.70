package com.tencent.gdtad.splash.view;

import android.os.Bundle;
import android.view.View;
import com.qq.e.tg.splash.adapter.TGSplashInterPageAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/gdtad/splash/view/d;", "Lcom/qq/e/tg/splash/adapter/TGSplashInterPageAdapter;", "Landroid/view/View;", ParseCommon.CONTAINER, "", "startOlympicPage", "<init>", "()V", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d implements TGSplashInterPageAdapter {
    @Override // com.qq.e.tg.splash.adapter.TGSplashInterPageAdapter
    public void startOlympicPage(@Nullable View container) {
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication != null) {
            com.tencent.mobileqq.pad.b h16 = new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.standard);
            c.f109468a.c(container);
            i.e(baseApplication, new Bundle(), OlympicInterPageFragment.class, h16.a());
        }
    }
}
