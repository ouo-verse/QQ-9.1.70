package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFollowRcmd;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BlankRecommendItemView extends BaseWidgetView<CertifiedAccountMeta$StFollowRcmd> implements View.OnClickListener {
    private int E;
    private SquareImageView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private FollowTextView J;
    private View K;
    private boolean L;
    private ArrayList<b> M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements FollowTextView.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StUser f96483a;

        a(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser) {
            this.f96483a = certifiedAccountMeta$StUser;
        }

        @Override // com.tencent.biz.subscribe.widget.textview.FollowTextView.e
        public void a(boolean z16, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            String str;
            String str2 = this.f96483a.f24929id.get();
            if (z16) {
                str = "blank_content_follow";
            } else {
                str = "blank_content_unfollow";
            }
            VSReporter.p(str2, "auth_follow", str, 0, 0, "", BlankRecommendItemView.this.E + "", this.f96483a.nick.get(), "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private int f96485a;

        /* renamed from: b, reason: collision with root package name */
        private View f96486b;

        /* renamed from: c, reason: collision with root package name */
        private RoundCornerImageView f96487c;

        /* renamed from: d, reason: collision with root package name */
        private TextView f96488d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CertifiedAccountMeta$StFeed f96490d;

            a(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
                this.f96490d = certifiedAccountMeta$StFeed;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                com.tencent.biz.subscribe.d.q(BlankRecommendItemView.this.getContext(), this.f96490d, 0, af0.b.k(b.this.f96487c, this.f96490d.cover.width.get(), this.f96490d.cover.height.get()));
                VSReporter.p(this.f96490d.poster.f24929id.get(), "auth_follow", "blank_content_clk", 0, 0, "", b.this.f96485a + "", this.f96490d.poster.nick.get(), this.f96490d.title.get());
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(View view, int i3) {
            this.f96486b = view;
            this.f96485a = i3;
            this.f96487c = (RoundCornerImageView) view.findViewById(R.id.lnn);
            this.f96488d = (TextView) this.f96486b.findViewById(R.id.mcf);
        }

        public void c(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            if (certifiedAccountMeta$StFeed != null) {
                this.f96486b.setVisibility(0);
                if (certifiedAccountMeta$StFeed.cover.height.get() > certifiedAccountMeta$StFeed.cover.width.get()) {
                    this.f96487c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    this.f96487c.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                try {
                    this.f96487c.setImageURL(certifiedAccountMeta$StFeed.cover.url.get());
                } catch (Throwable th5) {
                    QLog.e("BlankRecommendItemView", 2, "setData() set image url error! url: " + certifiedAccountMeta$StFeed.cover.url.get(), th5);
                }
                if (certifiedAccountMeta$StFeed.video.duration.get() > 0) {
                    this.f96488d.setText(String.format("%02d:%02d", Integer.valueOf((certifiedAccountMeta$StFeed.video.duration.get() / 1000) / 60), Integer.valueOf((certifiedAccountMeta$StFeed.video.duration.get() / 1000) % 60)));
                    this.f96488d.setVisibility(0);
                } else {
                    this.f96488d.setVisibility(8);
                }
                this.f96486b.setOnClickListener(new a(certifiedAccountMeta$StFeed));
                return;
            }
            this.f96486b.setVisibility(4);
        }

        public void d() {
            this.f96487c.setBackgroundColor(Color.parseColor("#252525"));
            this.f96487c.invalidate();
            this.f96488d.setTextColor(-5723992);
        }
    }

    public BlankRecommendItemView(Context context) {
        super(context);
    }

    private String t(int i3) {
        if (i3 >= 10000) {
            return new DecimalFormat(".#").format(i3 / 10000.0d) + "W";
        }
        if (i3 >= 1000) {
            return new DecimalFormat(".#").format(i3 / 1000.0d) + "K";
        }
        return String.valueOf(i3);
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.f167692lk;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected View.OnClickListener k() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ln7 || id5 == R.id.mbu) {
            CertifiedAccountMeta$StFollowRcmd f16 = f();
            com.tencent.biz.subscribe.d.t(getContext(), f16.user.get());
            if (R.id.ln7 == view.getId()) {
                VSReporter.p(f16.user.f24929id.get(), "auth_follow", "blank_head_clk", 0, 0, "", "", f16.user.nick.get());
            } else if (R.id.mbu == view.getId()) {
                VSReporter.p(f16.user.f24929id.get(), "auth_follow", "blank_name_clk", 0, 0, "", "", f16.user.nick.get());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.F = (SquareImageView) findViewById(R.id.ln7);
        this.G = (TextView) findViewById(R.id.mbu);
        this.H = (TextView) findViewById(R.id.e7l);
        this.I = (TextView) findViewById(R.id.f167031e80);
        this.K = findViewById(R.id.f164999bn3);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J = (FollowTextView) findViewById(R.id.mcp);
        if (this.M == null) {
            this.M = new ArrayList<>();
        }
        this.M.add(new b(findViewById(R.id.dnu), 1));
        this.M.add(new b(findViewById(R.id.dny), 2));
        this.M.add(new b(findViewById(R.id.dnz), 3));
    }

    public void setIsInNightMode(boolean z16) {
        this.L = z16;
        if (z16) {
            this.F.setFilterColor(1711276032);
            this.G.setTextColor(-5723992);
            this.H.setTextColor(-10132123);
            this.I.setTextColor(-10132123);
            this.J.setIsInNightMode(this.L);
            this.K.setBackgroundColor(-9211021);
            Iterator<b> it = this.M.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    next.d();
                }
            }
        }
    }

    public void setPos(int i3) {
        this.E = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    @RequiresApi(api = 8)
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void c(CertifiedAccountMeta$StFollowRcmd certifiedAccountMeta$StFollowRcmd) {
        if (certifiedAccountMeta$StFollowRcmd != null && certifiedAccountMeta$StFollowRcmd.user.has()) {
            CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = certifiedAccountMeta$StFollowRcmd.user.get();
            this.F.getLayoutParams().width = ScreenUtil.dip2px(36.0f);
            this.F.getLayoutParams().height = ScreenUtil.dip2px(36.0f);
            com.tencent.biz.subscribe.a.e(certifiedAccountMeta$StUser.icon.get(), this.F);
            this.G.setText(certifiedAccountMeta$StUser.nick.get());
            TextView textView = this.H;
            textView.setText(String.format("%s%s", textView.getContext().getString(R.string.vye), t(certifiedAccountMeta$StFollowRcmd.fansCount.get())));
            String str = certifiedAccountMeta$StFollowRcmd.reason.get();
            if (TextUtils.isEmpty(str)) {
                str = certifiedAccountMeta$StUser.desc.get();
            }
            this.I.setText(str);
            this.J.setUserData(certifiedAccountMeta$StUser);
            this.J.setExtraTypeInfo(g());
            this.J.setFollowStateChangeListener(new a(certifiedAccountMeta$StUser));
            List<CertifiedAccountMeta$StFeed> list = certifiedAccountMeta$StFollowRcmd.feedList.get();
            for (int i3 = 0; i3 < 3; i3++) {
                if (ArrayUtils.isOutOfArrayIndex(i3, list)) {
                    this.M.get(i3).c(null);
                } else {
                    this.M.get(i3).c(list.get(i3));
                }
            }
            VSReporter.p(certifiedAccountMeta$StUser.f24929id.get(), "auth_follow", "blank_content_exp", 0, 0, "", this.E + "", certifiedAccountMeta$StUser.nick.get(), str);
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected View r() {
        return this;
    }
}
