package com.tencent.biz.qqcircle;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.j;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j {

    /* renamed from: d, reason: collision with root package name */
    private static volatile j f91355d;

    /* renamed from: a, reason: collision with root package name */
    private PopupWindow f91356a;

    /* renamed from: b, reason: collision with root package name */
    private BubblePopupWindow f91357b;

    /* renamed from: c, reason: collision with root package name */
    private CountDownTimer f91358c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements rb0.c {
        b() {
        }

        @Override // rb0.c
        public int a() {
            return 12;
        }

        @Override // rb0.c
        public int b(Context context) {
            return -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c implements rb0.b {
        c() {
        }

        @Override // rb0.b
        public int a() {
            return cx.a(80.0f);
        }

        @Override // rb0.b
        public int b() {
            return cx.a(40.0f);
        }

        @Override // rb0.b
        public int c() {
            return cx.a(8.0f);
        }

        @Override // rb0.b
        public View d(Context context) {
            View view = new View(context);
            view.setBackgroundColor(context.getResources().getColor(R.color.f157324c50));
            view.setLayoutParams(new LinearLayout.LayoutParams(cx.a(1.0f), -1));
            return view;
        }

        @Override // rb0.b
        public int e(Context context) {
            return context.getResources().getColor(R.color.c4v);
        }

        @Override // rb0.b
        public int f(Context context) {
            return context.getResources().getColor(R.color.c4w);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f91363d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QCircleReportBean f91364e;

        d(f fVar, QCircleReportBean qCircleReportBean) {
            this.f91363d = fVar;
            this.f91364e = qCircleReportBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f91363d != null) {
                int id5 = view.getId();
                if (id5 == R.id.f31700rr) {
                    this.f91363d.onClick(g.f91368a);
                } else if (id5 == R.id.f31600rh) {
                    this.f91363d.onClick(g.f91369b);
                } else if (id5 == R.id.f31610ri) {
                    this.f91363d.onClick(g.f91370c);
                } else if (id5 == R.id.f31680rp) {
                    this.f91363d.onClick(g.f91371d);
                } else if (id5 == R.id.f31620rj) {
                    this.f91363d.onClick(g.f91372e);
                }
            }
            QFSCommentReportHelper.i(view, this.f91364e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f91366d;

        e(f fVar) {
            this.f91366d = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f91366d != null && view.getId() == R.id.f31620rj) {
                this.f91366d.onClick(g.f91372e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface f {
        void onClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public static int f91368a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static int f91369b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static int f91370c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static int f91371d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static int f91372e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static int f91373f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static int f91374g = 8;
    }

    private com.tencent.biz.qqcircle.richframework.widget.menu.b d(int i3, int i16) {
        com.tencent.biz.qqcircle.richframework.widget.menu.b bVar = new com.tencent.biz.qqcircle.richframework.widget.menu.b(i3, com.tencent.biz.qqcircle.utils.h.a(i16), null);
        bVar.d(new b());
        return bVar;
    }

    public static j f() {
        if (f91355d == null) {
            synchronized (j.class) {
                if (f91355d == null) {
                    f91355d = new j();
                }
            }
        }
        return f91355d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(f fVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (fVar != null) {
            int id5 = view.getId();
            if (id5 == R.id.f31580rf) {
                fVar.onClick(g.f91373f);
            } else if (id5 == R.id.f31690rq) {
                fVar.onClick(g.f91374g);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void e() {
        BubblePopupWindow bubblePopupWindow = this.f91357b;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            this.f91357b.u();
        }
    }

    public void h() {
        QLog.d("QCirclePopupWindowHelper", 1, "release");
        CountDownTimer countDownTimer = this.f91358c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f91358c = null;
        }
        PopupWindow popupWindow = this.f91356a;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f91356a = null;
        }
        if (this.f91357b != null) {
            this.f91357b = null;
        }
        f91355d = null;
    }

    public void i(View view, final f fVar, BubblePopupWindow.c cVar, boolean z16) {
        this.f91357b = new BubblePopupWindow(-2, -2);
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar2 = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        if (z16) {
            cVar2.c(d(R.id.f31690rq, R.string.f183853ka));
        }
        cVar2.c(d(R.id.f31580rf, R.string.f183783k4));
        this.f91357b.E(com.tencent.biz.qqcircle.richframework.widget.menu.a.b(this.f91357b, view.getContext(), cVar2, new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                j.g(j.f.this, view2);
            }
        }, new c()));
        this.f91357b.H(cVar);
        this.f91357b.D(new ColorDrawable(0));
        this.f91357b.I(true);
        this.f91357b.F(true);
        this.f91357b.L(view);
    }

    public void j(View view, f fVar, BubblePopupWindow.c cVar) {
        this.f91357b = new BubblePopupWindow(-2, -2);
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar2 = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        cVar2.a(R.id.f31620rj, com.tencent.biz.qqcircle.utils.h.a(R.string.f183823k8));
        e eVar = new e(fVar);
        BubblePopupWindow bubblePopupWindow = this.f91357b;
        bubblePopupWindow.E(com.tencent.biz.qqcircle.richframework.widget.menu.a.a(bubblePopupWindow, view.getContext(), cVar2, eVar));
        this.f91357b.H(cVar);
        this.f91357b.D(new ColorDrawable(0));
        this.f91357b.I(true);
        this.f91357b.F(true);
        this.f91357b.L(view);
    }

    public void k(View view, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StReply feedCloudMeta$StReply, f fVar, BubblePopupWindow.c cVar, QCircleReportBean qCircleReportBean) {
        this.f91357b = new BubblePopupWindow(-2, -2);
        com.tencent.biz.qqcircle.richframework.widget.menu.c cVar2 = new com.tencent.biz.qqcircle.richframework.widget.menu.c();
        cVar2.a(R.id.f31610ri, com.tencent.biz.qqcircle.utils.h.a(R.string.f183813k7));
        if (af.F(feedCloudMeta$StFeed, feedCloudMeta$StReply)) {
            cVar2.a(R.id.f31620rj, com.tencent.biz.qqcircle.utils.h.a(R.string.f183823k8));
        }
        if (af.H(feedCloudMeta$StReply)) {
            cVar2.a(R.id.f31680rp, com.tencent.biz.qqcircle.utils.h.a(R.string.f183843k_));
        }
        d dVar = new d(fVar, qCircleReportBean);
        QFSCommentReportHelper.j(cVar2, qCircleReportBean);
        BubblePopupWindow bubblePopupWindow = this.f91357b;
        bubblePopupWindow.E(com.tencent.biz.qqcircle.richframework.widget.menu.a.a(bubblePopupWindow, view.getContext(), cVar2, dVar));
        this.f91357b.H(cVar);
        this.f91357b.D(new ColorDrawable(0));
        this.f91357b.I(true);
        this.f91357b.F(true);
        this.f91357b.L(view);
    }

    public void l(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            h();
            TextView textView = new TextView(context);
            textView.setTextColor(context.getResources().getColor(R.color.f158017al3));
            textView.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.kfs));
            textView.setPadding(cx.a(12.0f), cx.a(8.0f), cx.a(12.0f), cx.a(8.0f));
            textView.setText(str);
            PopupWindow popupWindow = new PopupWindow(textView, -2, -2);
            this.f91356a = popupWindow;
            popupWindow.setOutsideTouchable(true);
            this.f91356a.setTouchable(true);
            this.f91356a.showAtLocation(textView, 17, 0, 0);
            a aVar = new a(3000L, 3000L, context);
            this.f91358c = aVar;
            aVar.start();
        } catch (Exception e16) {
            QLog.e("QCirclePopupWindowHelper", 1, "showRecommendAnimation error" + e16.getMessage());
            e16.printStackTrace();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f91359a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j3, long j16, Context context) {
            super(j3, j16);
            this.f91359a = context;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (j.this.f91356a != null) {
                Context context = this.f91359a;
                if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                    j.this.f91356a.dismiss();
                    j.this.f91356a = null;
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
        }
    }
}
