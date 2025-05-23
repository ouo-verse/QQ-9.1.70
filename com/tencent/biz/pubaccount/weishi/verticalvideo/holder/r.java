package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stOpVideo;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> implements View.OnClickListener {
    private KandianUrlImageView C;
    private TextView D;
    private stSimpleMetaFeed E;
    private stOpVideo F;
    private WSVerticalPageFragment G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends h00.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f82151a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f82152b;

        a(String str, String str2) {
            this.f82151a = str;
            this.f82152b = str2;
        }

        @Override // h00.d, h00.b
        public void a() {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.I(1000004, r.this.E, this.f82151a, this.f82152b);
        }

        @Override // h00.d, h00.b
        public void b() {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.I(1000002, r.this.E, this.f82151a, this.f82152b);
        }

        @Override // h00.d, h00.b
        public void c() {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.I(1000007, r.this.E, this.f82151a, this.f82152b);
        }

        @Override // h00.d, h00.b
        public void d() {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.I(1000003, r.this.E, this.f82151a, this.f82152b);
        }
    }

    public r(Context context, au auVar) {
        super(context);
        if (auVar != null) {
            this.G = auVar.f82128e;
        }
    }

    private static WSDownloadParams v(WSVerticalPageFragment wSVerticalPageFragment, int i3, String str) {
        WSDownloadParams wSDownloadParams = new WSDownloadParams();
        wSDownloadParams.mScene = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.l(wSVerticalPageFragment.getFrom());
        wSDownloadParams.mLinkStrategyType = iz.a.g().p();
        wSDownloadParams.mEventId = i3;
        wSDownloadParams.mTestId = bb.x(wSDownloadParams.mScene);
        wSDownloadParams.mScheme = str;
        return wSDownloadParams;
    }

    private void w() {
        String str;
        if (this.F != null) {
            String from = this.G.getFrom();
            String playScene = this.G.getPlayScene();
            h00.j o16 = new h00.j(b()).o(this.F.jump);
            WSVerticalPageFragment wSVerticalPageFragment = this.G;
            stSchema stschema = this.F.jump;
            if (stschema != null) {
                str = stschema.schema;
            } else {
                str = "";
            }
            o16.i(v(wSVerticalPageFragment, 17, str)).m(new a(from, playScene)).h();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j c16 = c();
        if (c16 != null && (c16.e() instanceof stSimpleMetaFeed)) {
            stSimpleMetaFeed e16 = c16.e();
            this.E = e16;
            stOpVideo stopvideo = e16.opVideo;
            this.F = stopvideo;
            if (stopvideo != null) {
                if (!TextUtils.isEmpty(stopvideo.img_url)) {
                    WSPicLoader.g().w(this.C, this.F.img_url, BaseApplication.getContext().getResources().getDrawable(R.drawable.d7y));
                    com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.J(this.E, this.G.getFrom(), this.G.getPlayScene());
                }
                if (TextUtils.isEmpty(this.F.text)) {
                    return;
                }
                this.D.setText(this.F.text);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.y_q) {
            return;
        }
        w();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fwr;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (KandianUrlImageView) p(R.id.y_q);
        this.D = (TextView) p(R.id.f112626of);
        this.C.setOnClickListener(this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }
}
