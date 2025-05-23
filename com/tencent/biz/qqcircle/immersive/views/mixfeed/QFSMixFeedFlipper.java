package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedFlipper extends ViewFlipper {

    /* renamed from: d, reason: collision with root package name */
    private View f90857d;

    /* renamed from: e, reason: collision with root package name */
    private BaseWidgetView f90858e;

    /* renamed from: f, reason: collision with root package name */
    private int f90859f;

    /* renamed from: h, reason: collision with root package name */
    private final List<QQCircleDitto$StItemInfo> f90860h;

    /* renamed from: i, reason: collision with root package name */
    private j20.a f90861i;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements com.tencent.biz.qqcircle.immersive.views.mixfeed.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.a
        public void onPause() {
            QFSMixFeedFlipper.this.stopFlipping();
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.mixfeed.a
        public void onResume() {
            QFSMixFeedFlipper.this.g();
            QFSMixFeedFlipper.this.h();
        }
    }

    public QFSMixFeedFlipper(@NonNull Context context) {
        this(context, null);
    }

    private void b() {
        removeAllViews();
        int e16 = e();
        for (int i3 = 0; i3 < e16; i3++) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.removeAllViews();
            View view = this.f90857d;
            if (view instanceof QFSMixFeedBroadCastView) {
                this.f90858e = new QFSMixFeedBroadCastItemView(getContext());
                QLog.d("QFSMixFeedFlipper", 1, "[addItemView] create BroadCastItemView instance");
            } else if (view instanceof QFSMixFeedChannelView) {
                this.f90858e = new QFSMixFeedChannelItemView(getContext());
                QLog.d("QFSMixFeedFlipper", 1, "[addItemView] create ChannelItemView instance");
            }
            linearLayout.addView(this.f90858e);
            if (this.f90859f < e16) {
                c();
            }
            int i16 = this.f90859f + 1;
            this.f90859f = i16;
            this.f90859f = i16 % e16;
            addView(linearLayout);
        }
    }

    private void c() {
        BaseWidgetView baseWidgetView;
        QQCircleDitto$StItemInfo d16 = d();
        if (d16 != null && (baseWidgetView = this.f90858e) != null) {
            if (baseWidgetView instanceof QFSMixFeedBroadCastItemView) {
                ((QFSMixFeedBroadCastItemView) baseWidgetView).bindData(d16, this.f90859f);
            } else if (baseWidgetView instanceof QFSMixFeedChannelItemView) {
                ((QFSMixFeedChannelItemView) baseWidgetView).bindData(d16, this.f90859f);
            }
        }
    }

    private QQCircleDitto$StItemInfo d() {
        if (this.f90859f < e()) {
            return this.f90860h.get(this.f90859f);
        }
        return null;
    }

    private int e() {
        List<QQCircleDitto$StItemInfo> list = this.f90860h;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private void f() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154906tb);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154907tc);
        loadAnimation.setDuration(400L);
        loadAnimation2.setDuration(400L);
        setInAnimation(loadAnimation);
        setOutAnimation(loadAnimation2);
        setFlipInterval(4000);
        setMeasureAllChildren(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (e() >= 2 && !isFlipping()) {
            startFlipping();
            return;
        }
        QLog.d("QFSMixFeedFlipper", 1, "[start] size = " + e() + ", isFlipping = " + isFlipping());
    }

    public void g() {
        b();
        this.f90859f = 0;
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j20.a aVar = this.f90861i;
        if (aVar != null && aVar.isContainerOnScreen()) {
            h();
        } else {
            QLog.d("QFSMixFeedFlipper", 1, "[onAttachedToWindow] -> !mInteractor.isContainerOnScreen()");
        }
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopFlipping();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            stopFlipping();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setContentRootView(View view) {
        this.f90857d = view;
    }

    public void setData(List<QQCircleDitto$StItemInfo> list, int i3) {
        if (list != null && list.size() != 0) {
            this.f90860h.clear();
            this.f90860h.addAll(list);
        }
    }

    public void setInteractor(BaseWidgetView.IInteractor iInteractor) {
        j20.a aVar = (j20.a) iInteractor;
        this.f90861i = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(new a());
    }

    public QFSMixFeedFlipper(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f90859f = 0;
        this.f90860h = new ArrayList();
        f();
    }
}
