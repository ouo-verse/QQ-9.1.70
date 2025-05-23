package com.tencent.mobileqq.onlinestatus.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.zplan.statussquare.api.IZPlanStatusSquareApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.CommonMMKVUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusContainerFragment extends QPublicBaseFragment implements q45.b {
    private int C = 0;
    private View D;
    private ImageView E;
    private TextView F;
    private TextView G;
    private View H;
    private FrameLayout I;
    private Fragment J;
    private Fragment K;
    private List<q45.c> L;
    private OnLineStatusBlurBg M;
    private OnLineStatusBlurBg.a N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f256423d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f256424e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f256425f;

        b(float f16, int i3, int i16) {
            this.f256423d = f16;
            this.f256424e = i3;
            this.f256425f = i16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i3;
            OnlineStatusContainerFragment.this.G.setEnabled(true);
            OnlineStatusContainerFragment.this.Sh();
            OnlineStatusContainerFragment onlineStatusContainerFragment = OnlineStatusContainerFragment.this;
            Fragment fragment = onlineStatusContainerFragment.K;
            if (this.f256424e == 1) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            onlineStatusContainerFragment.Rh(fragment, i3);
            OnlineStatusContainerFragment.this.Oh(this.f256424e, 1);
            OnlineStatusContainerFragment.this.Oh(this.f256425f, 3);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            OnlineStatusContainerFragment.this.G.setEnabled(false);
            OnlineStatusContainerFragment.this.Uh(0);
            OnlineStatusContainerFragment onlineStatusContainerFragment = OnlineStatusContainerFragment.this;
            onlineStatusContainerFragment.Rh(onlineStatusContainerFragment.K, 0);
            OnlineStatusContainerFragment.this.Th(this.f256423d);
            OnlineStatusContainerFragment.this.C = this.f256424e;
            OnlineStatusContainerFragment.this.Oh(this.f256424e, 0);
            OnlineStatusContainerFragment.this.Oh(this.f256425f, 2);
        }
    }

    private void Dh() {
        int i3;
        if (this.M == null) {
            this.M = new OnLineStatusBlurBg();
        }
        if (this.N == null) {
            OnLineStatusBlurBg.a aVar = new OnLineStatusBlurBg.a();
            this.N = aVar;
            if (ThemeUtil.useNativeThemeVideoPlayer()) {
                i3 = 0;
            } else {
                i3 = R.id.b9o;
            }
            aVar.f255318g = i3;
            this.N.f255313b = getQBaseActivity();
        }
    }

    public static OnlineStatusContainerFragment Eh(OnLineStatusBlurBg onLineStatusBlurBg) {
        OnlineStatusContainerFragment onlineStatusContainerFragment = new OnlineStatusContainerFragment();
        if (onLineStatusBlurBg != null) {
            onlineStatusContainerFragment.M = onLineStatusBlurBg.f();
        }
        return onlineStatusContainerFragment;
    }

    private void Fh(final boolean z16) {
        Dh();
        this.M.i(this.N, new OnLineStatusBlurBg.b() { // from class: com.tencent.mobileqq.onlinestatus.view.ap
            @Override // com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.b
            public final void v3(boolean z17, Bitmap bitmap, int i3) {
                OnlineStatusContainerFragment.this.Kh(z16, z17, bitmap, i3);
            }
        });
    }

    private void Gh(int i3) {
        float f16;
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusContainerFragment", 1, "doSwitchPageAnim : toPageId = " + i3);
        }
        int i16 = this.C;
        float f17 = 1.0f;
        if (i3 == 1) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        if (i3 == 1) {
            f17 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.onlinestatus.view.aq
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OnlineStatusContainerFragment.this.Lh(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new b(f16, i3, i16));
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    private Fragment Hh() {
        if (!com.tencent.mobileqq.onlinestatus.aq.b()) {
            return null;
        }
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("tag_zplan_fragment");
        if (findFragmentByTag == null) {
            return ((IZPlanStatusSquareApi) QRoute.api(IZPlanStatusSquareApi.class)).createStatusSquareListFragment();
        }
        return findFragmentByTag;
    }

    private void Ih(Bundle bundle) {
        Fragment Hh = Hh();
        this.K = Hh;
        int i3 = 0;
        if (Hh != null) {
            i3 = CommonMMKVUtils.getInt("mmkv_key_page_id", 0, true);
        }
        this.C = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(boolean z16, boolean z17, final Bitmap bitmap, final int i3) {
        this.N.a();
        if (!z17 && z16) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            Jh(bitmap, i3);
        } else {
            this.H.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.ar
                @Override // java.lang.Runnable
                public final void run() {
                    OnlineStatusContainerFragment.this.Jh(bitmap, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(ValueAnimator valueAnimator) {
        Th(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusContainerFragment", 2, "click top back");
        }
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nh(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.C == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        Ch(i3, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(int i3, int i16) {
        List<q45.c> list = this.L;
        if (list != null && !list.isEmpty()) {
            Iterator<q45.c> it = this.L.iterator();
            while (it.hasNext()) {
                it.next().mo209if(i3, i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Ph, reason: merged with bridge method [inline-methods] */
    public void Jh(Bitmap bitmap, int i3) {
        Drawable bitmapDrawable;
        View view = this.H;
        if (bitmap == null) {
            bitmapDrawable = new ColorDrawable(i3);
        } else {
            bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        }
        view.setBackground(bitmapDrawable);
    }

    private void Qh() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(R.id.v8r);
        this.J = findFragmentById;
        if (findFragmentById == null) {
            OnlineStatusFriendListFragment onlineStatusFriendListFragment = new OnlineStatusFriendListFragment();
            this.J = onlineStatusFriendListFragment;
            beginTransaction.add(R.id.v8r, onlineStatusFriendListFragment);
        }
        beginTransaction.show(this.J);
        ActivityResultCaller activityResultCaller = this.J;
        if (activityResultCaller instanceof q45.a) {
            ((q45.a) activityResultCaller).ob(this);
        }
        if (this.K != null) {
            if (getChildFragmentManager().findFragmentByTag("tag_zplan_fragment") == null) {
                beginTransaction.add(R.id.v8z, this.K);
            }
            beginTransaction.show(this.K);
            ActivityResultCaller activityResultCaller2 = this.K;
            if (activityResultCaller2 instanceof q45.a) {
                ((q45.a) activityResultCaller2).ob(this);
            }
        }
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh(Fragment fragment, int i3) {
        View view;
        if (fragment != null && fragment.getView() != null && (view = fragment.getView()) != null && view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        if (this.C == 1) {
            this.G.setText(R.string.f201494uy);
            this.G.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.mym, 0, 0, 0);
            Uh(8);
        } else {
            this.G.setText(R.string.f201514v0);
            this.G.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.myl, 0, 0, 0);
            Uh(0);
            Th(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th(float f16) {
        Fragment fragment = this.J;
        if (fragment != null && fragment.getView() != null) {
            this.J.getView().setAlpha(f16);
        }
        this.H.setAlpha(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh(int i3) {
        Rh(this.J, i3);
        if (this.H.getVisibility() != i3) {
            this.H.setVisibility(i3);
        }
    }

    private void initUI() {
        int i3;
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineStatusContainerFragment.this.Mh(view);
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineStatusContainerFragment.this.Nh(view);
            }
        });
        ((TopGestureLayout) this.D).setOnFlingGesture(new a());
        if (this.K == null) {
            this.G.setVisibility(8);
            this.F.setVisibility(0);
            this.I.setVisibility(8);
        } else {
            this.G.setVisibility(0);
            this.F.setVisibility(8);
            this.I.setVisibility(0);
        }
        Fh(false);
        Qh();
        Sh();
        if (this.C == 0) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        com.tencent.mobileqq.onlinestatus.utils.z.s(i3);
        Oh(this.C, 1);
    }

    @Override // q45.b
    public boolean Bc(int i3) {
        if (this.C == i3) {
            return true;
        }
        return false;
    }

    public void Ch(int i3, boolean z16) {
        if ((this.K == null && i3 == 1) || this.C == i3) {
            return;
        }
        if (!z16) {
            this.C = i3;
            Sh();
        } else {
            Gh(i3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (ImmersiveUtils.isSupportImmersive()) {
            ImmersiveUtils.clearCoverForStatus(activity.getWindow(), true);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        CommonMMKVUtils.putInt("mmkv_key_page_id", this.C, true);
        getQBaseActivity().getSupportFragmentManager().popBackStack();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.D;
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.D.getParent()).removeView(this.D);
            }
        } else {
            View inflate = layoutInflater.inflate(R.layout.e_h, viewGroup, false);
            this.D = inflate;
            this.F = (TextView) inflate.findViewById(R.id.f111496ld);
            this.E = (ImageView) inflate.findViewById(R.id.y9f);
            this.G = (TextView) inflate.findViewById(R.id.th8);
            this.H = inflate.findViewById(R.id.f116236y7);
            this.I = (FrameLayout) inflate.findViewById(R.id.v8z);
        }
        View view2 = this.D;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Ih(getArguments());
        initUI();
    }

    @Override // q45.b
    public void sd(q45.c cVar) {
        if (this.L == null) {
            this.L = new ArrayList();
        }
        if (!this.L.contains(cVar)) {
            this.L.add(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements TopGestureLayout.OnGestureListener {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
        public void flingLToR() {
            OnlineStatusContainerFragment.this.onBackEvent();
        }

        @Override // com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
        public void flingRToL() {
        }
    }
}
