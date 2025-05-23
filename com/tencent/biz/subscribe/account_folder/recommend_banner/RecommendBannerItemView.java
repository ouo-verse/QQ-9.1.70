package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.d;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.biz.subscribe.utils.b;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RecommendBannerItemView extends RelativeLayout implements View.OnClickListener, SimpleEventReceiver {
    private boolean C;
    private com.tencent.biz.subscribe.account_folder.recommend_banner.a D;
    private boolean E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private SquareImageView f95632d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f95633e;

    /* renamed from: f, reason: collision with root package name */
    private FollowTextView f95634f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f95635h;

    /* renamed from: i, reason: collision with root package name */
    private CertifiedAccountMeta$StUser f95636i;

    /* renamed from: m, reason: collision with root package name */
    private int f95637m;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f95638d;
        final /* synthetic */ RecommendBannerItemView this$0;

        @Override // java.lang.Runnable
        public void run() {
            QQToast.makeText(this.this$0.getContext(), this.f95638d, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {

        /* compiled from: P */
        /* renamed from: com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class C0958a implements b.d {
            C0958a() {
            }

            @Override // com.tencent.biz.subscribe.utils.b.d
            public void onResult(boolean z16) {
                if (z16) {
                    SimpleEventBus.getInstance().dispatchEvent(new RecommendFeedbackEvent(RecommendBannerItemView.this.f95636i));
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class b implements b.c {
            b() {
            }

            @Override // com.tencent.biz.subscribe.utils.b.c
            public void a(boolean z16) {
                String str;
                String str2 = RecommendBannerItemView.this.f95636i.f24929id.get();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("recom_");
                String str3 = "cancel";
                if (z16) {
                    str = "cancel";
                } else {
                    str = QCircleDaTongConstant.ElementParamValue.DISLIKE;
                }
                sb5.append(str);
                VSReporter.n(str2, "auth_page", sb5.toString(), 0, 0, "", RecommendBannerItemView.this.f95637m + "", RecommendBannerItemView.this.f95636i.nick.get());
                if (RecommendBannerItemView.this.F) {
                    String str4 = RecommendBannerItemView.this.f95636i.f24929id.get();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("reco_");
                    if (!z16) {
                        str3 = QCircleDaTongConstant.ElementParamValue.DISLIKE;
                    }
                    sb6.append(str3);
                    VSReporter.n(str4, "auth_discover", sb6.toString(), 0, 0, "", String.valueOf(RecommendBannerItemView.this.f95637m), RecommendBannerItemView.this.f95636i.nick.get(), RecommendBannerItemView.this.f95636i.desc.get());
                }
            }
        }

        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            boolean z16 = false;
            if (RecommendBannerItemView.this.f95636i != null) {
                com.tencent.biz.subscribe.utils.b.c(RecommendBannerItemView.this.getContext(), RecommendBannerItemView.this.f95636i, new C0958a(), new b());
                if (RecommendBannerItemView.this.F) {
                    VSReporter.n(RecommendBannerItemView.this.f95636i.f24929id.get(), "auth_discover", "reco_press", 0, 0, "", String.valueOf(RecommendBannerItemView.this.f95637m), RecommendBannerItemView.this.f95636i.nick.get(), RecommendBannerItemView.this.f95636i.desc.get());
                } else {
                    VSReporter.n(RecommendBannerItemView.this.f95636i.f24929id.get(), "auth_page", "recom_remove", 0, 0, "", RecommendBannerItemView.this.f95637m + "", RecommendBannerItemView.this.f95636i.nick.get());
                }
                z16 = true;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements FollowTextView.e {
        b() {
        }

        @Override // com.tencent.biz.subscribe.widget.textview.FollowTextView.e
        public void a(boolean z16, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            if (RecommendBannerItemView.this.F) {
                if (RecommendBannerItemView.this.f95636i != null) {
                    VSReporter.n(RecommendBannerItemView.this.f95636i.f24929id.get(), "auth_discover", "reco_follow_clk", 0, 0, "", String.valueOf(RecommendBannerItemView.this.f95637m), RecommendBannerItemView.this.f95636i.nick.get(), RecommendBannerItemView.this.f95636i.desc.get());
                }
            } else if (z16) {
                RecommendBannerItemView recommendBannerItemView = RecommendBannerItemView.this;
                recommendBannerItemView.e("auth_page", "recom_follow", recommendBannerItemView.f95636i.f24929id.get(), "", "", String.valueOf(RecommendBannerItemView.this.f95637m), RecommendBannerItemView.this.f95636i.nick.get());
            } else {
                RecommendBannerItemView recommendBannerItemView2 = RecommendBannerItemView.this;
                recommendBannerItemView2.e("auth_page", "recom_unfollow", recommendBannerItemView2.f95636i.f24929id.get(), "", "", String.valueOf(RecommendBannerItemView.this.f95637m), RecommendBannerItemView.this.f95636i.nick.get());
            }
        }
    }

    public RecommendBannerItemView(Context context) {
        super(context);
        f(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        ReportController.o(null, "dc00898", "", str3, str, str2, 0, 0, str4, str5, str6, str7);
    }

    protected void f(Context context) {
        View.inflate(context, R.layout.f167707en, this);
        setMinimumHeight(x.c(context, 183.0f));
        setPadding(x.c(context, 6.0f), x.c(context, 10.0f), x.c(context, 6.0f), x.c(context, 20.0f));
        setWillNotDraw(false);
        setLayerType(1, null);
        this.f95632d = (SquareImageView) findViewById(R.id.a2o);
        this.f95635h = (TextView) findViewById(R.id.bg5);
        this.f95633e = (TextView) findViewById(R.id.f9d);
        this.f95634f = (FollowTextView) findViewById(R.id.f163918c6);
        setOnClickListener(this);
        setOnLongClickListener(new a());
    }

    protected void g() {
        if (this.f95636i != null) {
            d.t(getContext(), this.f95636i);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(FollowUpdateEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        SimpleEventBus.getInstance().registerReceiver(this);
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        g();
        if (this.F) {
            CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = this.f95636i;
            if (certifiedAccountMeta$StUser != null) {
                VSReporter.n(certifiedAccountMeta$StUser.f24929id.get(), "auth_discover", "reco_head_clk", 0, 0, "", String.valueOf(this.f95637m), this.f95636i.nick.get(), this.f95636i.desc.get());
            }
        } else {
            CertifiedAccountMeta$StUser certifiedAccountMeta$StUser2 = this.f95636i;
            if (certifiedAccountMeta$StUser2 != null) {
                e("auth_page", "recom_head", certifiedAccountMeta$StUser2.f24929id.get(), "", "", String.valueOf(this.f95637m), this.f95636i.nick.get());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        Paint paint = new Paint();
        if (this.C) {
            paint.setColor(-15263977);
        } else {
            paint.setColor(-1);
        }
        if (!this.E) {
            paint.setShadowLayer(x.c(getContext(), 15.0f), 0, x.c(getContext(), 5.0f), 436207616);
        }
        int c16 = x.c(getContext(), 6.0f);
        RectF rectF = new RectF(paddingLeft, paddingTop, width, height);
        float f16 = c16;
        canvas.drawRoundRect(rectF, f16, f16, paint);
        super.onDraw(canvas);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser;
        if ((simpleBaseEvent instanceof FollowUpdateEvent) && (certifiedAccountMeta$StUser = this.f95636i) != null) {
            FollowUpdateEvent followUpdateEvent = (FollowUpdateEvent) simpleBaseEvent;
            if (TextUtils.equals(followUpdateEvent.useId, certifiedAccountMeta$StUser.f24929id.get())) {
                this.f95636i.followState.set(followUpdateEvent.followStatus);
                com.tencent.biz.subscribe.account_folder.recommend_banner.a aVar = this.D;
                if (aVar != null) {
                    boolean z16 = true;
                    if (followUpdateEvent.followStatus != 1) {
                        z16 = false;
                    }
                    aVar.a(z16, this.f95637m);
                }
            }
        }
    }

    public void setData(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser, int i3) {
        this.f95636i = certifiedAccountMeta$StUser;
        this.f95637m = i3;
        if (certifiedAccountMeta$StUser != null) {
            this.f95633e.setText(certifiedAccountMeta$StUser.nick.get());
            this.f95635h.setText(certifiedAccountMeta$StUser.desc.get());
            e("auth_page", "recom_exp", certifiedAccountMeta$StUser.f24929id.get(), "", "", String.valueOf(this.f95637m), certifiedAccountMeta$StUser.nick.get());
            try {
                this.f95632d.setImageURL(certifiedAccountMeta$StUser.icon.get());
            } catch (Throwable th5) {
                QLog.e("RecommendBannerItemView", 2, "setData() set icon url error! url: " + certifiedAccountMeta$StUser.icon.get(), th5);
            }
        }
        this.f95634f.setUserData(this.f95636i);
        this.f95634f.setFollowStateChangeListener(new b());
    }

    public void setInNewFolderPage(boolean z16) {
        this.F = z16;
    }

    public void setInNightMode(boolean z16) {
        this.C = z16;
        if (z16) {
            this.f95632d.setFilterColor(1711276032);
            this.f95635h.setTextColor(-9079435);
            this.f95633e.setTextColor(-5723992);
            this.f95634f.setIsInNightMode(z16);
        }
    }

    public void setIsCloseShadow(boolean z16) {
        this.E = z16;
    }

    public void setRecommendBannerFolwListener(com.tencent.biz.subscribe.account_folder.recommend_banner.a aVar) {
        this.D = aVar;
    }

    public RecommendBannerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context);
    }

    public RecommendBannerItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        f(context);
    }
}
