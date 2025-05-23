package com.qzone.component.banner;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.widget.AvatarImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import yo.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FootBanner extends Banner {
    private TextView C;
    private ImageView D;
    private Context E;
    private String F;
    private String G;
    private String H;
    private boolean I;
    private Animation J;
    private long K;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f46350h;

    /* renamed from: i, reason: collision with root package name */
    private AvatarImageView f46351i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f46352m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qzone.feed.business.model.a f46353d;

        a(com.qzone.feed.business.model.a aVar) {
            this.f46353d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FootBanner.this.g();
            com.qzone.component.banner.util.a.f(FootBanner.this.E, 4, this.f46353d.f47123g, true);
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClose(FootBanner.this.F, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.qzone.feed.business.model.a f46355d;

        b(com.qzone.feed.business.model.a aVar) {
            this.f46355d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FootBanner.this.I = true;
            g gVar = new g(FootBanner.this.H);
            if (!TextUtils.isEmpty(FootBanner.this.G)) {
                gVar.f450709b = FootBanner.this.G;
            } else if (TextUtils.isEmpty(gVar.f450709b)) {
                gVar.f450709b = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_DOWNLOAD_QZONE_CLIENT, "https://mobile.qzone.qq.com/l?g=1554");
            }
            int b16 = yo.d.b(FootBanner.this.E, gVar);
            if (b16 == 1) {
                com.qzone.component.banner.util.a.f(FootBanner.this.E, 2, this.f46355d.f47123g, true);
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(FootBanner.this.F, null);
            } else if (b16 == 2 || b16 == 3) {
                com.qzone.component.banner.util.a.f(FootBanner.this.E, 3, this.f46355d.f47123g, true);
                ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(FootBanner.this.F, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FootBanner(Context context) {
        super(context);
        this.I = false;
        this.E = context;
        this.J = AnimationUtils.loadAnimation(context, R.anim.f154785cl);
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 0;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 13;
    }

    @Override // com.qzone.component.banner.Banner
    public void g() {
        this.f46350h.setVisibility(8);
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46350h.isShown();
    }

    @Override // com.qzone.component.banner.Banner
    public void r() {
        if (this.I) {
            g();
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        BusinessADBannerData businessADBannerData;
        long uin;
        if (this.f46350h == null || aVar == null || (businessADBannerData = aVar.f47123g) == null) {
            return;
        }
        this.I = false;
        this.F = businessADBannerData.strTraceInfo;
        String str = businessADBannerData.schemeUrl;
        this.H = str;
        this.G = businessADBannerData.strJmpUrl;
        this.K = businessADBannerData.iAdID;
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("uin");
            if (TextUtils.isEmpty(queryParameter)) {
                uin = LoginData.getInstance().getUin();
            } else {
                uin = Long.parseLong(queryParameter);
            }
        } catch (Exception unused) {
            uin = LoginData.getInstance().getUin();
        }
        this.f46351i.j(uin);
        this.f46352m.setText(aVar.f47123g.description);
        this.C.setText(aVar.f47123g.btText);
        if (aVar.f47123g.hasCloseButton) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        this.D.setOnClickListener(new a(aVar));
        this.f46350h.setOnClickListener(new b(aVar));
        this.f46350h.setVisibility(0);
        this.f46350h.startAnimation(this.J);
        com.qzone.component.banner.util.a.f(this.E, 1, aVar.f47123g, true);
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(this.F, null);
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) viewStub.inflate();
        this.f46350h = relativeLayout;
        if (relativeLayout == null) {
            return;
        }
        this.f46351i = (AvatarImageView) relativeLayout.findViewById(R.id.cid);
        this.f46352m = (TextView) this.f46350h.findViewById(R.id.cif);
        this.C = (TextView) this.f46350h.findViewById(R.id.cig);
        this.D = (ImageView) this.f46350h.findViewById(R.id.cie);
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
    }
}
