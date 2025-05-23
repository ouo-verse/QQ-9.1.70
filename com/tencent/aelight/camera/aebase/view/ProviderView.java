package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* loaded from: classes32.dex */
public abstract class ProviderView extends FrameLayout {
    protected int C;

    /* renamed from: d, reason: collision with root package name */
    Context f66046d;

    /* renamed from: e, reason: collision with root package name */
    protected AppInterface f66047e;

    /* renamed from: f, reason: collision with root package name */
    protected int f66048f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f66049h;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f66050i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f66051m;

    /* loaded from: classes32.dex */
    public interface a {
    }

    public ProviderView(Context context) {
        super(context);
        this.f66049h = true;
        this.f66051m = false;
        this.C = 206;
        this.f66046d = context;
        this.f66050i = new Handler(ThreadManagerV2.getSubThreadLooper());
    }

    public void setAppInterface(AppInterface appInterface) {
        this.f66047e = appInterface;
    }

    public void setNeedTabBar(boolean z16) {
        this.f66049h = z16;
    }

    public void setTabBarPosition(int i3) {
        this.f66048f = i3;
    }

    public void setProviderViewListener(a aVar) {
    }
}
