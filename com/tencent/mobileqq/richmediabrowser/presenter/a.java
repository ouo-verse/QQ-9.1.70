package com.tencent.mobileqq.richmediabrowser.presenter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BasePresenter implements c04.b {

    /* renamed from: d, reason: collision with root package name */
    private ImmersionHelper f281858d;

    /* renamed from: e, reason: collision with root package name */
    public AIOBrowserPresenter f281859e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.mobileqq.richmediabrowser.view.a f281860f;

    /* renamed from: h, reason: collision with root package name */
    public BrowserBasePresenter f281861h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<Long, Set<DanmuItemBean>> f281862i = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private final int f281863m = 0;

    public boolean A() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter == null || aIOBrowserPresenter.f281850e.f436601e.getBubbleShowTimes() <= 0) {
            return false;
        }
        return true;
    }

    public boolean B() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter == null || aIOBrowserPresenter.f281850e.f436601e.getSubtitleDialogShowTimes() <= 0) {
            return false;
        }
        return true;
    }

    public void F() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOBrowserBasePresenter", 2, "onDanmakuDrawFinish");
        }
        if (x() && !p().f281782d) {
            p().f();
            p().j();
        }
    }

    public void I(boolean z16) {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.B(z16);
        }
    }

    @RequiresApi(api = 11)
    public void J() {
        if (this.f281861h.getContentView() != null) {
            this.f281861h.getContentView().setAlpha(1.0f);
        }
    }

    public void K() {
        RelativeLayout relativeLayout;
        com.tencent.mobileqq.richmediabrowser.view.a aVar = this.f281860f;
        if (aVar != null && (relativeLayout = aVar.H) != null) {
            relativeLayout.setAlpha(1.0f);
        }
    }

    public boolean L() {
        tm2.a aVar;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null && aVar.o()) {
            return true;
        }
        return false;
    }

    public void M() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.H();
        }
    }

    public void N() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.W();
        }
    }

    public void O(AIOBrowserPresenter aIOBrowserPresenter) {
        this.f281859e = aIOBrowserPresenter;
    }

    public boolean P(RichMediaBrowserInfo richMediaBrowserInfo) {
        return com.tencent.mobileqq.richmediabrowser.d.h(richMediaBrowserInfo);
    }

    public void Q(boolean z16) {
        AIOBrowserScene aIOBrowserScene;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserScene = aIOBrowserPresenter.f281849d) != null) {
            aIOBrowserScene.u(z16);
        }
    }

    public void R(long j3, int i3, int i16) {
        tm2.a aVar;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null) {
            aVar.s(j3, i3, i16);
        }
    }

    @Override // c04.b
    public void a(f04.b bVar) {
        if (bVar instanceof BrowserBasePresenter) {
            this.f281861h = (BrowserBasePresenter) bVar;
        }
    }

    public void back() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.G();
        }
        BrowserBasePresenter browserBasePresenter = this.f281861h;
        if (browserBasePresenter != null) {
            browserBasePresenter.back();
        }
    }

    @Override // c04.b
    public void e(c04.c cVar) {
        if (cVar instanceof com.tencent.mobileqq.richmediabrowser.view.a) {
            this.f281860f = (com.tencent.mobileqq.richmediabrowser.view.a) cVar;
        }
    }

    @RequiresApi(api = 11)
    public void j() {
        if (this.f281861h.getContentView() != null) {
            this.f281861h.getContentView().setAlpha(0.3f);
        }
    }

    public void k() {
        RelativeLayout relativeLayout;
        com.tencent.mobileqq.richmediabrowser.view.a aVar = this.f281860f;
        if (aVar != null && (relativeLayout = aVar.H) != null) {
            relativeLayout.setAlpha(0.3f);
        }
    }

    public void l() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.f281850e.f436601e.d(0);
        }
    }

    public void m() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null) {
            aIOBrowserPresenter.f281850e.f436601e.f(0);
        }
    }

    public com.tencent.mobileqq.comment.danmaku.a n() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null) {
            return aIOBrowserPresenter.m();
        }
        return null;
    }

    public RichMediaBrowserInfo o() {
        tm2.a aVar;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null) {
            return aVar.f();
        }
        return null;
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mobileqq.richmediabrowser.view.a aVar = this.f281860f;
        if (aVar != null) {
            aVar.j(configuration);
        }
    }

    @Override // com.tencent.richmediabrowser.presenter.BasePresenter, e04.a
    public void onDestroy() {
        ConcurrentHashMap<Long, Set<DanmuItemBean>> concurrentHashMap = this.f281862i;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public ImmersionHelper p() {
        if (this.f281858d == null) {
            this.f281858d = new ImmersionHelper(this);
        }
        return this.f281858d;
    }

    public RichMediaBrowserInfo q(long j3) {
        tm2.a aVar;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null) {
            return aVar.g(j3);
        }
        return null;
    }

    public RichMediaBrowserInfo r(long j3, long j16) {
        tm2.a aVar;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null) {
            return aVar.h(j3, j16);
        }
        return null;
    }

    public long s() {
        return 0L;
    }

    @Override // c04.b
    public void setRelyPresenter(f04.b bVar) {
        if (bVar instanceof AIOBrowserPresenter) {
            O((AIOBrowserPresenter) bVar);
        }
    }

    public boolean t() {
        return false;
    }

    public int u(long j3, int i3, int i16, String str) {
        return v(j3, i3, i16, str, null);
    }

    public int v(long j3, int i3, int i16, String str, String str2) {
        tm2.a aVar;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aVar = aIOBrowserPresenter.f281850e) != null) {
            return aVar.k(j3, i3, i16, str, str2);
        }
        return -1;
    }

    public boolean w() {
        AIOBrowserScene aIOBrowserScene;
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null && (aIOBrowserScene = aIOBrowserPresenter.f281849d) != null) {
            return aIOBrowserScene.m();
        }
        return false;
    }

    public boolean x() {
        return false;
    }

    public boolean y() {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null) {
            return aIOBrowserPresenter.f281850e.f436601e.getIsMuteWhenOpen();
        }
        return false;
    }

    public boolean z(int i3) {
        AIOBrowserPresenter aIOBrowserPresenter = this.f281859e;
        if (aIOBrowserPresenter != null) {
            return aIOBrowserPresenter.v(i3);
        }
        return false;
    }

    public void G() {
    }

    public void H(int i3) {
    }

    @Override // c04.b
    public void d(c04.a aVar) {
    }

    public void E(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageRecord messageRecord, int i17, Bundle bundle) {
    }

    public void C(long j3, int i3, int i16, int i17, long j16, boolean z16) {
    }

    public void D(long j3, int i3, int i16, int i17, String str, boolean z16) {
    }
}
