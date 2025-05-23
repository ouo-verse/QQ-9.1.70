package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoLikeRsp;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RelativeFeedItemView extends BaseWidgetView<CertifiedAccountMeta$StFeed> implements SimpleEventReceiver {
    private AsyncRichTextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    public RoundCornerImageView I;
    private SquareImageView J;
    private int K;
    private Drawable L;
    private View M;
    private ImageView N;
    private volatile boolean P;
    private boolean Q;
    private boolean R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StFeed f96492d;

        /* compiled from: P */
        /* renamed from: com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class C0977a implements VSDispatchObserver.OnVSRspCallBack<CertifiedAccountWrite$StDoLikeRsp> {
            C0977a() {
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CertifiedAccountWrite$StDoLikeRsp certifiedAccountWrite$StDoLikeRsp) {
                int i3;
                String str2;
                RelativeFeedItemView.this.P = true;
                if (z16 && j3 == 0 && certifiedAccountWrite$StDoLikeRsp != null) {
                    if (certifiedAccountWrite$StDoLikeRsp.like.status.get() == 1) {
                        i3 = a.this.f96492d.likeInfo.count.get() + 1;
                    } else {
                        i3 = a.this.f96492d.likeInfo.count.get() - 1;
                    }
                    String str3 = a.this.f96492d.poster.f24929id.get();
                    if (certifiedAccountWrite$StDoLikeRsp.like.status.get() == 1) {
                        str2 = "like";
                    } else {
                        str2 = "cancel_like";
                    }
                    VSReporter.n(str3, "auth_feeds", str2, 0, 0, "", ((BaseWidgetView) RelativeFeedItemView.this).f95705f + "", a.this.f96492d.poster.nick.get(), a.this.f96492d.title.get());
                    SimpleEventBus.getInstance().dispatchEvent(new PraisedUpdateEvents(a.this.f96492d.f24925id.get(), certifiedAccountWrite$StDoLikeRsp.like.status.get(), i3));
                    return;
                }
                QQToast.makeText(RelativeFeedItemView.this.getContext(), 1, str, 0).show();
            }
        }

        a(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            this.f96492d = certifiedAccountMeta$StFeed;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (RelativeFeedItemView.this.Q && RelativeFeedItemView.this.f() != null && SubscribeUtils.r(RelativeFeedItemView.this.f().status.get())) {
                if (RelativeFeedItemView.this.P) {
                    RelativeFeedItemView.this.P = false;
                    VSNetworkHelper.getInstance().sendRequest(new DoLikeRequest(this.f96492d), new C0977a());
                } else {
                    QQToast.makeText(RelativeFeedItemView.this.getContext(), HardCodeUtil.qqStr(R.string.szn), 0).show();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CertifiedAccountMeta$StFeed f16 = RelativeFeedItemView.this.f();
            if (f16 != null) {
                com.tencent.biz.subscribe.d.q(RelativeFeedItemView.this.getContext(), f16, 0, af0.b.k(RelativeFeedItemView.this.I, f16.cover.width.get(), f16.cover.height.get()));
                ExtraTypeInfo g16 = RelativeFeedItemView.this.g();
                if (g16 != null) {
                    int i3 = g16.pageType;
                    if (i3 == 7003) {
                        VSReporter.n(f16.poster.f24929id.get(), "auth_follow", "new_c_clk", 0, 0, "", "", f16.f24925id.get(), f16.title.get());
                    } else if (i3 == 7004) {
                        VSReporter.n(f16.poster.f24929id.get(), "auth_discover", "clk_content", 0, 0, "", "", f16.f24925id.get(), f16.title.get());
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public RelativeFeedItemView(Context context) {
        super(context);
        this.K = ImmersiveUtils.getScreenWidth() / 2;
        this.L = getResources().getDrawable(R.drawable.f160830com);
        this.P = true;
    }

    private void y(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        int i3;
        int i16;
        if (certifiedAccountMeta$StFeed.likeInfo.count.get() == 0) {
            this.G.setVisibility(8);
        } else {
            this.G.setText(String.valueOf(certifiedAccountMeta$StFeed.likeInfo.count.get()));
            this.G.setVisibility(0);
        }
        if (this.R) {
            ImageView imageView = this.N;
            if (certifiedAccountMeta$StFeed.likeInfo.status.get() == 1) {
                i16 = R.drawable.hme;
            } else {
                i16 = R.drawable.hmd;
            }
            imageView.setImageResource(i16);
            return;
        }
        ImageView imageView2 = this.N;
        if (certifiedAccountMeta$StFeed.likeInfo.status.get() == 1) {
            i3 = R.drawable.ccd;
        } else {
            i3 = R.drawable.ccc;
        }
        imageView2.setImageResource(i3);
    }

    private void z(int i3) {
        String str;
        if (f() == null) {
            return;
        }
        String str2 = f().poster.f24929id.get();
        int i16 = 1;
        if (i3 == 1) {
            str = "like";
        } else {
            str = "cancel_like";
        }
        VSReporter.n(str2, "auth_feeds", str, 0, this.f95705f, "", "", f().poster.nick.get(), f().title.get());
        int i17 = f().likeInfo.count.get();
        if (i3 != 1) {
            i16 = -1;
        }
        f().likeInfo.count.set(i17 + i16);
        f().likeInfo.status.set(i3);
        y(f());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(PraisedUpdateEvents.class);
        return arrayList;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.c7d;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected View.OnClickListener k() {
        return new b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Q = true;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Q = false;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (f() != null && (simpleBaseEvent instanceof PraisedUpdateEvents)) {
            PraisedUpdateEvents praisedUpdateEvents = (PraisedUpdateEvents) simpleBaseEvent;
            if (f().f24925id.get().equals(praisedUpdateEvents.mTargetFeedId) && this.G != null) {
                z(praisedUpdateEvents.mPraisedStatus);
            }
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = (AsyncRichTextView) findViewById(R.id.mck);
        this.F = (TextView) findViewById(R.id.mbu);
        this.G = (TextView) findViewById(R.id.mch);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById(R.id.lnn);
        this.I = roundCornerImageView;
        roundCornerImageView.setCorner(ImmersiveUtils.dpToPx(4.0f));
        this.J = (SquareImageView) findViewById(R.id.ln7);
        this.H = (TextView) findViewById(R.id.mcf);
        this.M = findViewById(R.id.f166123lr2);
        this.N = (ImageView) findViewById(R.id.loa);
    }

    public void setIsInNightMode(boolean z16) {
        this.R = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    @RequiresApi(api = 8)
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        float f16;
        if (certifiedAccountMeta$StFeed == null) {
            return;
        }
        String str = certifiedAccountMeta$StFeed.title.get();
        if (TextUtils.isEmpty(str)) {
            str = certifiedAccountMeta$StFeed.content.get();
        }
        if (TextUtils.isEmpty(str)) {
            this.E.setVisibility(8);
        } else {
            this.E.setText(str);
            this.E.setVisibility(0);
        }
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = certifiedAccountMeta$StFeed.poster;
        if (certifiedAccountMeta$StUser != null) {
            this.F.setText(certifiedAccountMeta$StUser.nick.get());
        }
        if (certifiedAccountMeta$StFeed.likeInfo != null) {
            y(certifiedAccountMeta$StFeed);
        }
        if (com.tencent.biz.subscribe.d.h(certifiedAccountMeta$StFeed.type.get())) {
            this.H.setText(String.format("%02d:%02d", Integer.valueOf((certifiedAccountMeta$StFeed.video.duration.get() / 1000) / 60), Integer.valueOf((certifiedAccountMeta$StFeed.video.duration.get() / 1000) % 60)));
            if (certifiedAccountMeta$StFeed.video.width.get() >= certifiedAccountMeta$StFeed.video.height.get()) {
                f16 = 0.75f;
            } else {
                f16 = 1.3333334f;
            }
            this.I.getLayoutParams().height = (int) (this.K * f16);
            this.I.getLayoutParams().width = this.K;
            this.I.requestLayout();
            this.H.setVisibility(0);
        } else {
            this.I.getLayoutParams().height = (int) (this.K * x(certifiedAccountMeta$StFeed));
            this.I.getLayoutParams().width = this.K;
            this.I.requestLayout();
            this.H.setVisibility(8);
        }
        com.tencent.biz.subscribe.a.d(certifiedAccountMeta$StFeed.cover.url.get(), this.I, null, FileUtils.isLocalPath(certifiedAccountMeta$StFeed.cover.url.get()));
        this.J.getLayoutParams().width = ScreenUtil.dip2px(18.0f);
        this.J.getLayoutParams().height = ScreenUtil.dip2px(18.0f);
        com.tencent.biz.subscribe.a.e(certifiedAccountMeta$StFeed.poster.icon.get(), this.J);
        if (certifiedAccountMeta$StFeed.status.get() == 3 && BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(certifiedAccountMeta$StFeed.poster.f24929id.get())) {
            this.M.setVisibility(0);
        } else if (this.M.getVisibility() == 0) {
            this.M.setVisibility(8);
        }
        this.N.setOnClickListener(new a(certifiedAccountMeta$StFeed));
        if (this.R) {
            this.J.setFilterColor(1711276032);
            this.E.setTextColor(-5723992);
            this.I.setColorFilter(1711276032);
            this.F.setTextColor(-10132123);
            this.H.setTextColor(-5723992);
            this.G.setTextColor(-10132123);
        }
        ExtraTypeInfo g16 = g();
        if (g16 != null) {
            int i3 = g16.pageType;
            if (i3 == 7003) {
                VSReporter.n(certifiedAccountMeta$StFeed.poster.f24929id.get(), "auth_follow", "new_c_exp", 0, 0, "", "", certifiedAccountMeta$StFeed.f24925id.get(), certifiedAccountMeta$StFeed.title.get());
            } else if (i3 == 7004) {
                VSReporter.p(certifiedAccountMeta$StFeed.poster.f24929id.get(), "auth_discover", "exp_content", 0, 0, "", "", certifiedAccountMeta$StFeed.f24925id.get(), certifiedAccountMeta$StFeed.title.get());
            }
        }
    }

    public float x(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed.cover.width.get() != 0 && certifiedAccountMeta$StFeed.cover.height.get() != 0) {
            float f16 = certifiedAccountMeta$StFeed.cover.height.get() / certifiedAccountMeta$StFeed.cover.width.get();
            if (f16 > 1.3333334f) {
                f16 = 1.3333334f;
            }
            hd0.c.k("RelativeFeedItemView", "getImageScale()  feed.width:" + certifiedAccountMeta$StFeed.cover.width.get() + "  feed.height:" + certifiedAccountMeta$StFeed.cover.height.get() + "  realHeight=" + f16);
            return f16;
        }
        hd0.c.k("RelativeFeedItemView", "getImageScale()  return 3/4");
        return 0.75f;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected View r() {
        return this;
    }
}
