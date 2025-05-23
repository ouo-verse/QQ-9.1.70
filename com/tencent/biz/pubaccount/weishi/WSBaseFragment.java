package com.tencent.biz.pubaccount.weishi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi.a;
import com.tencent.biz.pubaccount.weishi.d;
import com.tencent.biz.pubaccount.weishi.j;
import com.tencent.biz.pubaccount.weishi.main.WSTopEdgeGestureLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.util.cu;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class WSBaseFragment<V extends a, P extends d<V>> extends PublicBaseFragment implements b<V, P>, a, j.b {
    protected Context C;
    private c<V, P> D;
    protected P E;
    private rz.c F;
    protected WSTopEdgeGestureLayout G;
    private final j H = new j(this, this);
    private MiniMsgUser I;
    private boolean J;
    protected boolean K;
    public boolean L;

    private void rh() {
        List<QBaseFragment> vh5 = vh();
        if (vh5 == null) {
            return;
        }
        for (QBaseFragment qBaseFragment : vh5) {
            if (qBaseFragment instanceof PublicBaseFragment) {
                ((PublicBaseFragment) qBaseFragment).beforeFinish();
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.j.b
    public void Ag(boolean z16) {
        super.setUserVisibleHint(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bh(boolean z16) {
        WSTopEdgeGestureLayout wSTopEdgeGestureLayout = this.G;
        if (wSTopEdgeGestureLayout != null) {
            wSTopEdgeGestureLayout.setIsIntercept(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ch(Activity activity) {
        if (activity.getWindow() != null && (activity instanceof PublicTransFragmentActivity)) {
            activity.setTheme(R.style.f173279zo);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.j.b
    public boolean M7() {
        return this.H.e();
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    public void X3(P p16) {
        this.E = p16;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        com.tencent.biz.pubaccount.weishi.util.x.m("WSLifecycleLog", "[WSBaseFragment.java][beforeFinish] mIsUserVisibleHint:" + this.K + ", this:" + this);
        rh();
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    public P getPresenter() {
        return this.E;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment
    public void initSideFling(Context context, FlingHandler flingHandler) {
        super.initSideFling(context, flingHandler);
        WSTopEdgeGestureLayout wSTopEdgeGestureLayout = new WSTopEdgeGestureLayout(context);
        this.G = wSTopEdgeGestureLayout;
        if (flingHandler == null || !(flingHandler instanceof FlingGestureHandler)) {
            return;
        }
        FlingGestureHandler flingGestureHandler = (FlingGestureHandler) flingHandler;
        flingGestureHandler.setTopLayout(wSTopEdgeGestureLayout);
        flingGestureHandler.mTopLayout.setInterceptScrollLRFlag(true);
    }

    @Override // com.tencent.biz.pubaccount.weishi.j.b
    public void o0(boolean z16, boolean z17) {
        com.tencent.biz.pubaccount.weishi.util.x.j("WSLifecycleLog", "[WSBaseFragment.java][onVisibleToUserChanged] isVisibleToUser:" + z16 + ", invokeInResumeOrPause:" + z17 + ", this:" + this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.H.a();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.biz.pubaccount.weishi.util.x.j("WSLifecycleLog", "[WSBaseFragment.java][onCreate] mIsUserVisibleHint:" + this.K + ", this:" + this);
        this.C = getContext();
        this.L = xh();
        uh().onCreate(bundle);
        if (yh()) {
            this.I = new MiniMsgUser(getBaseActivity(), th());
        }
        rz.c cVar = new rz.c();
        this.F = cVar;
        cVar.h();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MiniMsgUser miniMsgUser;
        super.onDestroy();
        uh().onDestroy();
        if (yh() && (miniMsgUser = this.I) != null) {
            miniMsgUser.destroy();
        }
        this.F.onPageDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        uh().onDestroyView();
        this.F.k();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        MiniMsgUser miniMsgUser;
        super.onPause();
        this.H.f();
        com.tencent.biz.pubaccount.weishi.util.x.j("WSLifecycleLog", "[WSBaseFragment.java][onPause] mIsUserVisibleHint:" + this.K + ", this:" + this);
        if (yh() && (miniMsgUser = this.I) != null) {
            miniMsgUser.onBackground();
        }
        this.F.onPagePause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        MiniMsgUser miniMsgUser;
        super.onResume();
        this.H.g();
        com.tencent.biz.pubaccount.weishi.util.x.j("WSLifecycleLog", "[WSBaseFragment.java][onResume] mIsUserVisibleHint:" + this.K + ", this:" + this);
        if (yh() && (miniMsgUser = this.I) != null) {
            miniMsgUser.onForeground();
        }
        Ah();
        this.F.e();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        uh().a(view, bundle);
        this.F.a(qh());
        this.F.j();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        MiniMsgUser miniMsgUser;
        super.onWindowFocusChanged(z16);
        if (!z16 || this.J) {
            return;
        }
        if (yh() && (miniMsgUser = this.I) != null) {
            miniMsgUser.showOnFirst();
        }
        this.J = true;
    }

    public boolean ph(boolean z16) {
        if (getBaseActivity() == null) {
            return false;
        }
        if (!cu.f() && !cu.g()) {
            getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(z16 ? 9216 : 1280);
            return z16;
        }
        if (!ImmersiveUtils.supportStatusBarDarkMode()) {
            return false;
        }
        ImmersiveUtils.setStatusBarDarkMode(getBaseActivity().getWindow(), z16);
        if (!cu.g()) {
            return z16;
        }
        getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(z16 ? 9216 : 1280);
        return z16;
    }

    public HashSet<rz.a> qh() {
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.j.b
    public void re(boolean z16) {
        this.H.i(z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        this.H.h(z16);
        this.K = getUserVisibleHint();
        com.tencent.biz.pubaccount.weishi.util.x.m("WSLifecycleLog", "[WSBaseFragment.java][setUserVisibleHint] mIsUserVisibleHint:" + this.K + ", this:" + this);
    }

    public MiniMsgUser sh() {
        return this.I;
    }

    protected MiniMsgUserParam th() {
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 6;
        miniMsgUserParam.accessType = 2;
        miniMsgUserParam.filterMsgType = 0;
        miniMsgUserParam.entryType = 0;
        miniMsgUserParam.positionX = -1;
        miniMsgUserParam.positionY = -1;
        miniMsgUserParam.colorType = 0;
        return miniMsgUserParam;
    }

    protected c<V, P> uh() {
        if (this.D == null) {
            this.D = new i(this);
        }
        return this.D;
    }

    protected List<QBaseFragment> vh() {
        return null;
    }

    public void wh() {
        SystemBarCompact systemBarComp;
        FragmentActivity activity = getActivity();
        if ((activity instanceof PublicFragmentActivity) && (systemBarComp = SystemBarActivityModule.getSystemBarComp((PublicFragmentActivity) activity)) != null) {
            systemBarComp.setStatusBarVisible(2, 0);
            systemBarComp.setStatusBarColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean xh() {
        return e00.b.b();
    }

    protected boolean yh() {
        return false;
    }

    public boolean zh() {
        boolean d16 = this.H.d();
        com.tencent.biz.pubaccount.weishi.util.x.j("WSLifecycleLog", "[WSBaseFragment.java][isVisibleToUser] isVisibleToUser:" + d16 + ", this:" + this);
        return d16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    public V A8() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ah() {
    }
}
