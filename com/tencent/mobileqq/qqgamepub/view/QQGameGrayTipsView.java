package com.tencent.mobileqq.qqgamepub.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$AppSubscribeInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGameSubscribeBusEvent;
import com.tencent.mobileqq.qqgamepub.utils.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameGrayTipsView extends FrameLayout implements View.OnClickListener, SimpleEventReceiver {
    static IPatchRedirector $redirector_;
    private QQGameMsgInfo C;
    private boolean D;
    private boolean E;
    private boolean F;
    private long G;

    /* renamed from: d, reason: collision with root package name */
    private TextView f264773d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f264774e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f264775f;

    /* renamed from: h, reason: collision with root package name */
    LinearLayout f264776h;

    /* renamed from: i, reason: collision with root package name */
    LinearLayout f264777i;

    /* renamed from: m, reason: collision with root package name */
    LinearLayout f264778m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameGrayTipsView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            if (!((IQQGameHelper) QRoute.api(IQQGameHelper.class)).isInValidGameAppId(QQGameGrayTipsView.this.C.gameAppId)) {
                QQGameSubscribeBusEvent qQGameSubscribeBusEvent = new QQGameSubscribeBusEvent(5);
                QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo = new QQGamePubSubscribe$AppSubscribeInfo();
                qQGamePubSubscribe$AppSubscribeInfo.appid.set(Integer.parseInt(QQGameGrayTipsView.this.C.gameAppId));
                qQGameSubscribeBusEvent.subscribeInfo = qQGamePubSubscribe$AppSubscribeInfo;
                SimpleEventBus.getInstance().dispatchEvent(qQGameSubscribeBusEvent);
            }
        }
    }

    public QQGameGrayTipsView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void e(Context context) {
        View.inflate(context, R.layout.ebj, this);
        this.f264778m = (LinearLayout) findViewById(R.id.yoe);
        this.f264773d = (TextView) findViewById(R.id.f111656lt);
        this.f264774e = (ImageView) findViewById(R.id.y9l);
        this.f264775f = (ImageView) findViewById(R.id.y9k);
        this.f264776h = (LinearLayout) findViewById(R.id.yqo);
        this.f264777i = (LinearLayout) findViewById(R.id.yqt);
        this.f264776h.setOnClickListener(this);
        this.f264777i.setOnClickListener(this);
        setId(R.id.f630632i);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private boolean f(QQGameSubscribeBusEvent qQGameSubscribeBusEvent) {
        return this.C.gameAppId.equals(qQGameSubscribeBusEvent.subscribeInfo.appid.get() + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f264774e, PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.5f, 1.0f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.5f, 1.0f));
        ofPropertyValuesHolder.addListener(new a());
        ofPropertyValuesHolder.setDuration(300L);
        ofPropertyValuesHolder.start();
    }

    private void h() {
        post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.view.QQGameGrayTipsView.1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.qqgamepub.view.QQGameGrayTipsView$1$a */
            /* loaded from: classes16.dex */
            class a implements ValueAnimator.AnimatorUpdateListener {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f264779d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f264780e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f264781f;

                a(int i3, int i16, int i17) {
                    this.f264779d = i3;
                    this.f264780e = i16;
                    this.f264781f = i17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AnonymousClass1.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                    }
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        QQGameGrayTipsView.this.E = true;
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        float f16 = this.f264779d;
                        int i3 = this.f264780e;
                        int i16 = (int) (f16 + (i3 * animatedFraction));
                        int i17 = (int) (this.f264781f - (i3 * animatedFraction));
                        if (QLog.isColorLevel()) {
                            QLog.i("QQGamePub_GameGrayTipsView", 2, "onAnimationUpdate...newLeft:" + i16 + ",newRight:" + i17 + ",l:" + this.f264779d + ",r:" + this.f264781f);
                        }
                        LinearLayout linearLayout = QQGameGrayTipsView.this.f264778m;
                        linearLayout.layout(i16, linearLayout.getTop(), i17, QQGameGrayTipsView.this.f264778m.getBottom());
                        if (animatedFraction >= 1.0f) {
                            QQGameGrayTipsView.this.E = false;
                            QQGameGrayTipsView.this.g();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameGrayTipsView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int width = QQGameGrayTipsView.this.f264778m.getWidth();
                int width2 = QQGameGrayTipsView.this.f264776h.getWidth() - g.a(20.0f, QQGameGrayTipsView.this.getResources());
                if (width > 0 && width2 > 0) {
                    QQGameGrayTipsView.this.f264774e.setBackgroundDrawable(QQGameGrayTipsView.this.getContext().getResources().getDrawable(R.drawable.mvl));
                    int i3 = (width - width2) / 2;
                    int left = QQGameGrayTipsView.this.f264778m.getLeft();
                    int right = QQGameGrayTipsView.this.f264778m.getRight();
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.setDuration(200L);
                    ofFloat.addUpdateListener(new a(left, i3, right));
                    ofFloat.start();
                }
            }
        });
    }

    private void i(boolean z16) {
        int i3;
        this.D = z16;
        if (z16) {
            this.f264777i.setVisibility(8);
            this.f264774e.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.mvl));
            this.f264776h.setPadding(g.a(8.0f, getResources()), g.a(3.0f, getResources()), g.a(8.0f, getResources()), g.a(3.0f, getResources()));
        } else {
            this.f264777i.setVisibility(0);
            if (this.F) {
                i3 = R.drawable.mvj;
            } else {
                i3 = R.drawable.mvi;
            }
            this.f264774e.setBackgroundDrawable(getContext().getResources().getDrawable(i3));
            this.f264776h.setPadding(g.a(8.0f, getResources()), g.a(3.0f, getResources()), g.a(28.0f, getResources()), g.a(3.0f, getResources()));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QQGameSubscribeBusEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            IQQGameSubscribeService iQQGameSubscribeService = (IQQGameSubscribeService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all");
            if (R.id.yqo == view.getId()) {
                QQGameMsgInfo qQGameMsgInfo = this.C;
                String str = qQGameMsgInfo.gameAppId;
                iQQGameSubscribeService.putToGameInfoMap(str, new IQQGameSubscribeService.a(str, qQGameMsgInfo.desc, this.D));
                iQQGameSubscribeService.enterSingleGameMsgPage(MobileQQ.sMobileQQ, this.C.gameAppId, 1);
            } else if (R.id.yqt == view.getId()) {
                if (!this.D && !this.E) {
                    if (Math.abs(System.currentTimeMillis() - this.G) >= 1000) {
                        if (!AppNetConnInfo.isNetSupport()) {
                            QQToast.makeText(getContext(), 1, getResources().getString(R.string.f17640316), 0).show();
                        } else {
                            this.G = iQQGameSubscribeService.reqSetSubscribeStatus(this.C.gameAppId, 1, 1);
                        }
                    }
                } else {
                    QLog.i("QQGamePub_GameGrayTipsView", 1, "onClick:" + this.C + ",mGameInfo:" + this.D + ",isAnimating:" + this.E + ",can not click");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDetachedFromWindow();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        try {
            if (simpleBaseEvent instanceof QQGameSubscribeBusEvent) {
                QQGameSubscribeBusEvent qQGameSubscribeBusEvent = (QQGameSubscribeBusEvent) simpleBaseEvent;
                int i3 = qQGameSubscribeBusEvent.eventType;
                if (i3 == 4) {
                    if (f(qQGameSubscribeBusEvent) && qQGameSubscribeBusEvent.seq == this.G && !this.D) {
                        h();
                    }
                } else if (i3 == 5 && f(qQGameSubscribeBusEvent) && !this.D) {
                    i(true);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQGamePub_GameGrayTipsView", 2, "onReceiveEvent..." + simpleBaseEvent);
            }
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GameGrayTipsView", 1, th5, new Object[0]);
        }
    }

    public QQGameGrayTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QQGameGrayTipsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.C = new QQGameMsgInfo();
            e(context);
        }
    }
}
