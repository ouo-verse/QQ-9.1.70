package com.tencent.gdtad.splash.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.gdtad.splash.IGdtSplashQQLiteAPI;
import com.tencent.gdtad.splash.v;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.splashad.g;
import com.tencent.mobileqq.splashad.q;

/* loaded from: classes6.dex */
public class GdtSplashQQLiteAPIImpl implements IGdtSplashQQLiteAPI {

    /* loaded from: classes6.dex */
    class a implements SplashActivity.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f109379a;

        a(v vVar) {
            this.f109379a = vVar;
        }

        @Override // com.tencent.mobileqq.activity.SplashActivity.e
        public void a(int i3, int i16, Intent intent) {
            v vVar = this.f109379a;
            if (vVar != null) {
                vVar.a(i3, i16, intent);
            }
        }
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashQQLiteAPI
    public boolean isStartFromLauncher(Activity activity) {
        return SplashADUtil.v(activity);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashQQLiteAPI
    public boolean startActivityForResult(Context context, int i3, Intent intent, v vVar) {
        if (context instanceof SplashActivity) {
            ((SplashActivity) context).startActivityForResult(intent, i3, new a(vVar));
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashQQLiteAPI
    public void updateGdtHotSplashData(Pair<Long, Long> pair) {
        q.f288880a.f(2, new g(2, ((Long) pair.first).longValue(), ((Long) pair.second).longValue()));
    }
}
