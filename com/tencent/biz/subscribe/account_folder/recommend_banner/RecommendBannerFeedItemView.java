package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.d;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.biz.subscribe.utils.b;
import com.tencent.biz.subscribe.utils.f;
import com.tencent.biz.subscribe.widget.textview.AddFollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RecommendBannerFeedItemView extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener, SimpleEventReceiver {
    private boolean C;
    private boolean D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private RoundCornerImageView f95623d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCornerImageView f95624e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f95625f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f95626h;

    /* renamed from: i, reason: collision with root package name */
    private AddFollowTextView f95627i;

    /* renamed from: m, reason: collision with root package name */
    private CertifiedAccountMeta$StFeed f95628m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements BaseWidgetView.c {
        a() {
        }

        @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView.c
        public void beforeClick() {
            if (RecommendBannerFeedItemView.this.f95628m == null) {
                return;
            }
            VSReporter.n(RecommendBannerFeedItemView.this.f95628m.poster.f24929id.get(), "auth_page", "recom_follow_b", 0, 0, "", RecommendBannerFeedItemView.this.E + "", RecommendBannerFeedItemView.this.f95628m.poster.nick.get(), RecommendBannerFeedItemView.this.f95628m.title.get());
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements b.d {
        b() {
        }

        @Override // com.tencent.biz.subscribe.utils.b.d
        public void onResult(boolean z16) {
            if (z16) {
                SimpleEventBus.getInstance().dispatchEvent(new RecommendFeedbackEvent(RecommendBannerFeedItemView.this.f95628m));
            } else {
                QQToast.makeText(RecommendBannerFeedItemView.this.getContext(), R.string.vsi, 0).show();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements b.c {
        c() {
        }

        @Override // com.tencent.biz.subscribe.utils.b.c
        public void a(boolean z16) {
            String str;
            String str2 = RecommendBannerFeedItemView.this.f95628m.poster.f24929id.get();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("recom_");
            if (z16) {
                str = "cancel";
            } else {
                str = QCircleDaTongConstant.ElementParamValue.DISLIKE;
            }
            sb5.append(str);
            VSReporter.n(str2, "auth_page", sb5.toString(), 0, 0, "", RecommendBannerFeedItemView.this.E + "", RecommendBannerFeedItemView.this.f95628m.poster.nick.get(), RecommendBannerFeedItemView.this.f95628m.title.get());
        }
    }

    public RecommendBannerFeedItemView(Context context) {
        super(context);
        c(context);
    }

    protected void c(Context context) {
        View.inflate(context, R.layout.c79, this);
        setId(R.id.lcf);
        setMinimumHeight(x.c(context, 213.0f));
        setPadding(x.c(context, 6.0f), x.c(context, 10.0f), x.c(context, 6.0f), x.c(context, 20.0f));
        setWillNotDraw(false);
        setLayerType(1, null);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById(R.id.bat);
        this.f95623d = roundCornerImageView;
        roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(6.0f));
        RoundCornerImageView roundCornerImageView2 = (RoundCornerImageView) findViewById(R.id.a2o);
        this.f95624e = roundCornerImageView2;
        roundCornerImageView2.setCorner(ImmersiveUtils.dpToPx(24.0f));
        this.f95624e.setBorder(true);
        this.f95624e.setColor(-1);
        this.f95624e.setBorderWidth(ImmersiveUtils.dpToPx(2.0f));
        this.f95624e.getLayoutParams().width = ScreenUtil.dip2px(26.0f);
        this.f95624e.getLayoutParams().height = ScreenUtil.dip2px(26.0f);
        this.f95625f = (TextView) findViewById(R.id.f5e);
        this.f95626h = (TextView) findViewById(R.id.bg6);
        AddFollowTextView addFollowTextView = (AddFollowTextView) findViewById(R.id.lid);
        this.f95627i = addFollowTextView;
        addFollowTextView.setItemPreClickListener(new a());
        setOnClickListener(this);
        setOnLongClickListener(this);
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
        if (view.getId() == R.id.lcf) {
            d.o(null, this.f95628m);
            VSReporter.n(this.f95628m.poster.f24929id.get(), "auth_page", "recom_head_b", 0, 0, "", this.E + "", this.f95628m.poster.nick.get(), this.f95628m.title.get());
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
        if (!this.D) {
            paint.setShadowLayer(x.c(getContext(), 15.0f), 0, x.c(getContext(), 5.0f), 436207616);
        }
        int c16 = x.c(getContext(), 6.0f);
        RectF rectF = new RectF(paddingLeft, paddingTop, width, height);
        float f16 = c16;
        canvas.drawRoundRect(rectF, f16, f16, paint);
        super.onDraw(canvas);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        boolean z16 = false;
        if (view.getId() == R.id.lcf && this.f95628m != null) {
            com.tencent.biz.subscribe.utils.b.a(getContext(), this.f95628m, new b(), new c());
            z16 = true;
            VSReporter.n(this.f95628m.poster.f24929id.get(), "auth_page", "recom_remove", 0, 0, "", this.E + "", this.f95628m.poster.nick.get(), this.f95628m.title.get());
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        if ((simpleBaseEvent instanceof FollowUpdateEvent) && (certifiedAccountMeta$StFeed = this.f95628m) != null) {
            FollowUpdateEvent followUpdateEvent = (FollowUpdateEvent) simpleBaseEvent;
            if (TextUtils.equals(followUpdateEvent.useId, certifiedAccountMeta$StFeed.poster.f24929id.get())) {
                this.f95628m.poster.followState.set(followUpdateEvent.followStatus);
            }
        }
    }

    public void setData(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, int i3) {
        if (certifiedAccountMeta$StFeed != null && certifiedAccountMeta$StFeed.has()) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed2 = this.f95628m;
            if (certifiedAccountMeta$StFeed2 != null && TextUtils.equals(certifiedAccountMeta$StFeed2.f24925id.get(), certifiedAccountMeta$StFeed.f24925id.get())) {
                return;
            }
            this.f95628m = certifiedAccountMeta$StFeed;
            this.E = i3;
            com.tencent.biz.subscribe.a.e(certifiedAccountMeta$StFeed.poster.icon.get(), this.f95624e);
            this.f95625f.setText(this.f95628m.poster.nick.get());
            this.f95626h.setText(this.f95628m.title.get());
            if (this.f95628m.cover.width.get() > this.f95628m.cover.height.get()) {
                f.e(this.f95628m.cover.url.get(), this.f95623d);
            } else {
                com.tencent.biz.subscribe.a.e(this.f95628m.cover.url.get(), this.f95623d);
            }
            if (this.f95628m.poster.followState.get() == 1) {
                this.f95627i.setVisibility(8);
            } else {
                this.f95627i.setVisibility(0);
                this.f95627i.setUserData(this.f95628m.poster.get());
            }
            VSReporter.n(this.f95628m.poster.f24929id.get(), "auth_page", "recom_exp_b", 0, 0, "", this.E + "", this.f95628m.poster.nick.get(), this.f95628m.title.get());
        }
    }

    public void setInNightMode(boolean z16) {
        this.C = z16;
    }

    public void setIsCloseShadow(boolean z16) {
        this.D = z16;
    }

    public RecommendBannerFeedItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public RecommendBannerFeedItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        c(context);
    }
}
