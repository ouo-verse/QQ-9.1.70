package com.tencent.qqmini.minigame.floatview;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class a {

    /* renamed from: d, reason: collision with root package name */
    protected ViewGroup f346396d;

    /* renamed from: e, reason: collision with root package name */
    protected IMiniAppContext f346397e;

    /* renamed from: f, reason: collision with root package name */
    protected Activity f346398f;

    /* renamed from: h, reason: collision with root package name */
    protected TritonEngine f346399h;

    /* renamed from: i, reason: collision with root package name */
    protected MiniAppInfo f346400i;

    public abstract void b(String str);

    public abstract void c();

    @Nullable
    public IMiniGameEnv.IMiniGameFloatViewOperator d() {
        return null;
    }

    public void h(Activity activity) {
        this.f346398f = activity;
    }

    public void i(IMiniAppContext iMiniAppContext) {
        this.f346397e = iMiniAppContext;
    }

    public void j(TritonEngine tritonEngine) {
        this.f346399h = tritonEngine;
    }

    public void k(ViewGroup viewGroup) {
        this.f346396d = viewGroup;
    }

    public void l(MiniAppInfo miniAppInfo) {
        this.f346400i = miniAppInfo;
    }

    public void f() {
    }

    public void e(String str) {
    }

    public void g(int i3) {
    }
}
