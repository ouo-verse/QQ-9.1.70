package com.tencent.mobileqq.wink.picker.core.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.utils.as;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private final RelativeLayout f324762b;

    /* renamed from: c, reason: collision with root package name */
    private final TextView f324763c;

    /* renamed from: e, reason: collision with root package name */
    private float f324765e;

    /* renamed from: f, reason: collision with root package name */
    private float f324766f;

    /* renamed from: g, reason: collision with root package name */
    private final ImageView f324767g;

    /* renamed from: h, reason: collision with root package name */
    private final View f324768h;

    /* renamed from: j, reason: collision with root package name */
    private int f324770j;

    /* renamed from: k, reason: collision with root package name */
    private final RecyclerView f324771k;

    /* renamed from: m, reason: collision with root package name */
    private float f324773m;

    /* renamed from: n, reason: collision with root package name */
    private final WinkMediaListTimelineView f324774n;

    /* renamed from: o, reason: collision with root package name */
    private CountDownTimer f324775o;

    /* renamed from: q, reason: collision with root package name */
    private int f324777q;

    /* renamed from: a, reason: collision with root package name */
    private boolean f324761a = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f324764d = false;

    /* renamed from: i, reason: collision with root package name */
    private final List<LocalMediaInfo> f324769i = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private boolean f324772l = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f324776p = false;

    /* renamed from: r, reason: collision with root package name */
    private float f324778r = 0.0f;

    /* renamed from: s, reason: collision with root package name */
    private final int f324779s = ViewUtils.dpToPx(32.0f);

    /* renamed from: t, reason: collision with root package name */
    private final int f324780t = ViewUtils.dpToPx(45.0f);

    /* renamed from: u, reason: collision with root package name */
    private boolean f324781u = false;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (!d.this.f324764d && i16 != 0) {
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                float computeVerticalScrollRange = recyclerView.computeVerticalScrollRange() - d.this.f324770j;
                if (computeVerticalScrollRange != 0.0f) {
                    float f16 = computeVerticalScrollOffset / computeVerticalScrollRange;
                    if (d.this.f324773m != 0.0f) {
                        f16 = d.this.f324773m;
                        d.this.l(f16);
                        d.this.f324773m = 0.0f;
                    }
                    d.this.h(f16);
                }
            }
        }
    }

    public d(@Nullable View view, View view2, RecyclerView recyclerView) {
        this.f324762b = (RelativeLayout) view2.findViewById(R.id.f246109l);
        this.f324767g = (ImageView) view2.findViewById(R.id.f246309n);
        this.f324763c = (TextView) view2.findViewById(R.id.f246209m);
        this.f324774n = (WinkMediaListTimelineView) view2.findViewById(R.id.f246409o);
        this.f324771k = recyclerView;
        this.f324768h = view;
        recyclerView.addOnScrollListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float h(float f16) {
        RelativeLayout relativeLayout;
        LocalMediaInfo localMediaInfo;
        if (this.f324769i.size() != 0 && (relativeLayout = this.f324762b) != null) {
            float f17 = this.f324770j * f16;
            relativeLayout.setY(f17);
            int size = ((int) (this.f324769i.size() * f16)) / 3;
            long j3 = Long.MAX_VALUE;
            int i3 = 0;
            for (int i16 = 0; i16 < 3; i16++) {
                int i17 = (size * 3) + i3;
                i3++;
                if (!ArrayUtils.isOutOfArrayIndex(i17, this.f324769i) && (localMediaInfo = this.f324769i.get(i17)) != null) {
                    long j16 = localMediaInfo.modifiedDate;
                    if (j16 < j3) {
                        j3 = j16;
                    }
                }
            }
            if (j3 != Long.MAX_VALUE) {
                this.f324763c.setText(as.c(j3, true));
            }
            return f17;
        }
        return 0.0f;
    }

    private void i(Boolean bool) {
        if (this.f324769i.size() < 45) {
            return;
        }
        if (bool.booleanValue()) {
            t();
            return;
        }
        if (this.f324772l) {
            k();
        }
        this.f324774n.f(true);
    }

    private void j(boolean z16) {
        try {
            if (z16) {
                URLDrawable.resume();
            } else {
                URLDrawable.pause();
            }
        } catch (Throwable unused) {
            QLog.d("WinkMediaTimelineControlHelper", 1, "URLDrawable status error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f324772l = false;
        CountDownTimer countDownTimer = this.f324775o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(320L);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f324762b, "translationX", 0.0f, ViewUtils.dip2px(140.0f)));
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(float f16) {
        this.f324771k.scrollToPosition((int) (this.f324769i.size() * f16));
        if (f16 == 1.0f) {
            this.f324771k.scrollToPosition(this.f324769i.size() - 1);
        } else if (f16 == 0.0f) {
            this.f324771k.scrollToPosition(0);
        }
    }

    private void m() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(320L);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f324762b, "translationX", ViewUtils.dip2px(140.0f), 0.0f));
        animatorSet.playTogether(arrayList);
        animatorSet.start();
    }

    private float n(MotionEvent motionEvent) {
        float f16 = 0.0f;
        if (this.f324770j == 0) {
            QLog.d("WinkMediaTimelineControlHelper", 1, "photo list height is 0");
            return 0.0f;
        }
        float rawY = (motionEvent.getRawY() - this.f324765e) + this.f324766f;
        if (rawY >= 0.0f) {
            int i3 = this.f324770j;
            if (rawY > i3) {
                f16 = i3;
            } else {
                f16 = rawY;
            }
        }
        return f16 / this.f324770j;
    }

    private void o(MotionEvent motionEvent) {
        WinkMediaListTimelineView winkMediaListTimelineView = this.f324774n;
        if (winkMediaListTimelineView != null && this.f324770j != 0 && this.f324771k != null) {
            boolean z16 = true;
            if (!this.f324776p) {
                winkMediaListTimelineView.d();
                this.f324776p = true;
            }
            this.f324774n.g();
            float n3 = n(motionEvent);
            int computeVerticalScrollRange = this.f324771k.computeVerticalScrollRange() - this.f324770j;
            this.f324777q = (int) (this.f324777q + (computeVerticalScrollRange * (n3 - this.f324778r)));
            if (Math.abs(n3 - r4) >= 5.0E-4d) {
                z16 = false;
            }
            j(z16);
            if (this.f324769i.size() < 2000) {
                u(n3, computeVerticalScrollRange);
            } else {
                l(n3);
            }
            this.f324778r = n3;
            this.f324774n.b(h(n3) + (this.f324779s / 2.0f));
        }
    }

    private void t() {
        this.f324762b.setVisibility(0);
        if (!this.f324772l) {
            this.f324772l = true;
            m();
        }
        CountDownTimer countDownTimer = this.f324775o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        b bVar = new b(2000L, 1000L);
        this.f324775o = bVar;
        bVar.start();
    }

    private void u(float f16, int i3) {
        this.f324771k.scrollBy(0, (int) (i3 * (f16 - this.f324778r)));
        if (f16 == 1.0f) {
            this.f324771k.scrollBy(0, i3 - this.f324777q);
        } else if (f16 == 0.0f) {
            this.f324771k.scrollBy(0, -(i3 + this.f324777q));
        }
    }

    public boolean p(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f324768h == null) {
                        i(Boolean.TRUE);
                    } else {
                        i(Boolean.valueOf(!r3.getGlobalVisibleRect(new Rect())));
                    }
                    if (this.f324764d) {
                        if (!this.f324781u) {
                            this.f324781u = true;
                            com.tencent.mobileqq.wink.picker.report.a.q(WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_TIMELINE_BLOCK);
                        }
                        o(motionEvent);
                    }
                }
            } else {
                if (this.f324764d) {
                    this.f324764d = false;
                    this.f324773m = n(motionEvent);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f324767g.getLayoutParams();
                layoutParams.setMarginStart(ViewUtils.dpToPx(10.0f));
                this.f324767g.setLayoutParams(layoutParams);
                this.f324774n.f(false);
                j(true);
            }
        } else if (this.f324761a && view.getId() == this.f324762b.getId()) {
            this.f324764d = true;
            this.f324765e = motionEvent.getRawY();
            this.f324766f = this.f324762b.getY();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f324767g.getLayoutParams();
            layoutParams2.setMarginStart(this.f324780t);
            this.f324767g.setLayoutParams(layoutParams2);
            l(n(motionEvent));
        }
        return this.f324764d;
    }

    public void q(boolean z16) {
        this.f324761a = z16;
    }

    public void r(int i3) {
        if (i3 != this.f324770j) {
            i(Boolean.FALSE);
            this.f324776p = false;
        }
        this.f324770j = i3;
        WinkMediaListTimelineView winkMediaListTimelineView = this.f324774n;
        if (winkMediaListTimelineView != null) {
            winkMediaListTimelineView.setTimelineHeight(i3 + this.f324779s);
        }
    }

    public void s(UIStateData<List<LocalMediaInfo>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        if (uIStateData.getData().size() >= 10000 || uIStateData.getIsFinish()) {
            this.f324769i.clear();
            this.f324769i.addAll(uIStateData.getData());
            WinkMediaListTimelineView winkMediaListTimelineView = this.f324774n;
            if (winkMediaListTimelineView != null) {
                winkMediaListTimelineView.setPhotoList(this.f324769i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b extends CountDownTimer {
        b(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            d.this.k();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
        }
    }
}
