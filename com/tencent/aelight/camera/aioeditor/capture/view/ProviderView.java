package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

/* loaded from: classes32.dex */
public abstract class ProviderView extends FrameLayout {
    protected QIMSlidingTabView C;
    protected View D;
    protected View E;
    protected ViewGroup F;
    protected DoodleLayout.r G;
    protected Handler H;
    public boolean I;
    protected int J;
    public int K;
    public int L;
    protected a M;

    /* renamed from: d, reason: collision with root package name */
    public Context f67276d;

    /* renamed from: e, reason: collision with root package name */
    protected AppInterface f67277e;

    /* renamed from: f, reason: collision with root package name */
    protected int f67278f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f67279h;

    /* renamed from: i, reason: collision with root package name */
    private QIMSlidingTabView f67280i;

    /* renamed from: m, reason: collision with root package name */
    private QIMSlidingTabView f67281m;

    /* loaded from: classes32.dex */
    public interface a {
        void E(int i3);

        void H(boolean z16);

        void J(boolean z16);

        void R(int i3, Object... objArr);

        void b0(int i3, QIMFilterCategoryItem qIMFilterCategoryItem);

        int getVideoDuration();

        void j(boolean z16);

        void n(int i3);

        void p();
    }

    public ProviderView(Context context) {
        super(context);
        this.f67279h = true;
        this.I = false;
        this.J = 206;
        this.K = 0;
        this.L = 2;
        this.f67276d = context;
        this.H = new Handler(ThreadManagerV2.getSubThreadLooper());
    }

    public boolean B() {
        return false;
    }

    public void C(Bundle bundle) {
        if (this.D == null) {
            try {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.anj, (ViewGroup) this, false);
                addView(inflate);
                if (this.E == null) {
                    this.E = inflate;
                    this.f67280i = (QIMSlidingTabView) inflate.findViewById(R.id.f166548g30);
                    this.f67281m = (QIMSlidingTabView) this.E.findViewById(R.id.g2v);
                    this.F = (ViewGroup) this.E.findViewById(R.id.g2x);
                }
                View inflate2 = LayoutInflater.from(getContext()).inflate(p(), (ViewGroup) this, false);
                if (this.D == null) {
                    this.D = inflate2;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("ProviderView", 2, "preInflate failed " + e16.toString());
                }
            }
        }
    }

    public void l(View view) {
        ViewGroup viewGroup = this.F;
        if (viewGroup != null) {
            viewGroup.addView(view);
            return;
        }
        throw new IllegalStateException("no content layout");
    }

    public void m(int i3) {
        this.J = i3;
    }

    public boolean n(MotionEvent motionEvent) {
        return false;
    }

    public int o() {
        return this.J;
    }

    protected abstract int p();

    public boolean q() {
        return this.f67279h;
    }

    public QIMSlidingTabView r() {
        return this.f67281m;
    }

    public boolean s() {
        return this.I;
    }

    public void setCaptureScene(int i3) {
        this.K = i3;
    }

    public void setDoodleEventListener(DoodleLayout.r rVar) {
        this.G = rVar;
    }

    public void setNeedTabBar(boolean z16) {
        this.f67279h = z16;
    }

    public void setProviderViewListener(a aVar) {
        this.M = aVar;
    }

    public void setTabBarPosition(int i3) {
        this.f67278f = i3;
    }

    public void v(Bundle bundle) {
        QIMSlidingTabView qIMSlidingTabView;
        this.f67277e = fr.b.a();
        if (this.E == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.anj, (ViewGroup) this, false);
            addView(inflate);
            this.f67280i = (QIMSlidingTabView) inflate.findViewById(R.id.f166548g30);
            this.f67281m = (QIMSlidingTabView) inflate.findViewById(R.id.g2v);
            this.F = (ViewGroup) inflate.findViewById(R.id.g2x);
        }
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        layoutParams.height = UIUtils.b(getContext(), this.J);
        this.F.setLayoutParams(layoutParams);
        if (this.f67278f == 1) {
            qIMSlidingTabView = this.f67280i;
        } else {
            qIMSlidingTabView = this.f67281m;
        }
        this.C = qIMSlidingTabView;
        if (this.f67279h) {
            qIMSlidingTabView.setVisibility(0);
            if (this.f67278f == 1) {
                findViewById(R.id.f166549g31).setVisibility(0);
            }
        }
        this.I = true;
        if (QLog.isColorLevel()) {
            QLog.i("ProviderView", 2, "onCreate");
        }
    }

    public void x() {
        if (QLog.isColorLevel()) {
            QLog.d("ProviderView", 2, "[cc]onProviderDismiss " + getClass().getSimpleName());
        }
    }

    public void y() {
        if (QLog.isColorLevel()) {
            QLog.d("ProviderView", 2, "[cc]onProviderShow " + getClass().getSimpleName());
        }
    }

    public void w() {
        this.f67277e = null;
    }

    public ProviderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67279h = true;
        this.I = false;
        this.J = 206;
        this.K = 0;
        this.L = 2;
    }

    public ProviderView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f67279h = true;
        this.I = false;
        this.J = 206;
        this.K = 0;
        this.L = 2;
    }

    public void A() {
    }

    public void u() {
    }

    public void z() {
    }

    public void D(int i3, String str, String str2) {
    }

    public void t(int i3, int i16, Intent intent) {
    }
}
