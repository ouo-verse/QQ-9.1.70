package com.tencent.biz.qqcircle.comment.effect;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.tencent.biz.qqcircle.beans.QFSCommentOrReplyActionBean;
import com.tencent.biz.qqcircle.events.QFSCommentKeywordHighlightDismissEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.qqcircle.widgets.bc;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentKeywordHighlightViewController<T extends QFSCommentOrReplyActionBean> implements SimpleEventReceiver {
    private static final int F = cx.a(8.0f);
    private static final int G = cx.a(40.0f);
    private final Map<View, Integer> C = new ArrayMap();
    private d D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private final View f83551d;

    /* renamed from: e, reason: collision with root package name */
    private View f83552e;

    /* renamed from: f, reason: collision with root package name */
    private View f83553f;

    /* renamed from: h, reason: collision with root package name */
    private QFSPagAnimView f83554h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f83555i;

    /* renamed from: m, reason: collision with root package name */
    private c f83556m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QFSCommentKeywordHighlightViewController.this.q(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSCommentKeywordHighlightViewController.this.q(false);
            if (QFSCommentKeywordHighlightViewController.this.f83556m != null) {
                QFSCommentKeywordHighlightViewController.this.f83556m.onComplete();
            }
            QFSCommentKeywordHighlightViewController.this.o();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void onComplete();
    }

    public QFSCommentKeywordHighlightViewController(@NonNull View view) {
        this.f83551d = view;
    }

    private void i() {
        if (this.E) {
            t();
            this.E = false;
        }
    }

    private void j(View view, List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            View findViewById = view.findViewById(it.next().intValue());
            if (findViewById != null) {
                while (findViewById != view && (findViewById.getParent() instanceof View)) {
                    findViewById = (View) findViewById.getParent();
                    arrayList.add(findViewById);
                }
            }
        }
        k(view, list, arrayList);
    }

    private void k(View view, List<Integer> list, List<View> list2) {
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != this.f83552e && !list.contains(Integer.valueOf(childAt.getId()))) {
                if (list2.contains(childAt)) {
                    k(childAt, list, list2);
                } else if (childAt.getVisibility() != 8) {
                    this.C.put(childAt, Integer.valueOf(childAt.getVisibility()));
                    childAt.setVisibility(8);
                }
            }
        }
    }

    private void l() {
        View view = this.f83552e;
        if (view != null) {
            view.setVisibility(0);
            QLog.d("QFSCommentKeywordHighlightViewController", 1, "[initView] has init");
            return;
        }
        ViewStub viewStub = (ViewStub) this.f83551d.findViewById(R.id.f57392n7);
        if (viewStub == null) {
            QLog.e("QFSCommentKeywordHighlightViewController", 1, "[initView] mViewStub == null");
            return;
        }
        View inflate = viewStub.inflate();
        this.f83552e = inflate;
        this.f83553f = inflate.findViewById(R.id.f41811i3);
        this.f83554h = (QFSPagAnimView) this.f83552e.findViewById(R.id.f48101z3);
        this.f83555i = (TextView) this.f83552e.findViewById(R.id.f56292k8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        for (Map.Entry<View, Integer> entry : this.C.entrySet()) {
            entry.getKey().setVisibility(entry.getValue().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z16) {
        int i3;
        View view = this.f83552e;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private void r() {
        q(true);
        this.f83554h.setPagAnimListener(new QFSPagAnimView.c() { // from class: com.tencent.biz.qqcircle.comment.effect.QFSCommentKeywordHighlightViewController.1
            @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
            public /* synthetic */ void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
                bc.a(this, qFSPagAnimView);
            }

            @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
            public /* synthetic */ void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
                bc.b(this, qFSPagAnimView);
            }

            @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
            public /* synthetic */ void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
                bc.c(this, qFSPagAnimView);
            }

            @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
            public void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
                QFSCommentKeywordHighlightViewController.this.f83554h.post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.effect.QFSCommentKeywordHighlightViewController.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSCommentKeywordHighlightViewController qFSCommentKeywordHighlightViewController = QFSCommentKeywordHighlightViewController.this;
                        qFSCommentKeywordHighlightViewController.u(qFSCommentKeywordHighlightViewController.D);
                        QFSCommentKeywordHighlightViewController.this.s();
                    }
                });
            }

            @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
            public /* synthetic */ void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
                bc.e(this, qFSPagAnimView);
            }

            @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
            public /* synthetic */ void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
                bc.f(this, qFSPagAnimView, str);
            }
        });
        this.f83554h.V();
        this.f83554h.M(this.D.b().keywordHighlightResURL.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f83553f, "translationX", -G, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f83553f, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        if (uq3.c.v()) {
            animatorSet.addListener(new a());
        }
        animatorSet.start();
    }

    private void t() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f83553f, "translationX", 0.0f, G);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f83553f, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat2.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new b());
        this.f83554h.setPagAnimListener(null);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(d dVar) {
        this.f83555i.setWidth(cx.a(dVar.b().keywordHighlightTextAreaWidth.get()) - (F * 2));
        this.f83555i.setText(dVar.a());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSCommentKeywordHighlightDismissEvent.class);
        return arrayList;
    }

    public boolean h(@NonNull T t16, List<Integer> list) {
        d dVar = t16.mEffectBean;
        if (dVar != null && dVar.c()) {
            this.D = dVar;
            this.E = true;
            dVar.d(false);
            l();
            j(this.f83551d, list);
            r();
            return true;
        }
        q(false);
        return false;
    }

    public void m() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void n() {
        if (uq3.c.v()) {
            i();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSCommentKeywordHighlightDismissEvent) {
            i();
        }
    }

    public void p(c cVar) {
        this.f83556m = cVar;
    }
}
