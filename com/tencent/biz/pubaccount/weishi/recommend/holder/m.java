package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stDrama;
import UserGrowth.stDramaFall;
import UserGrowth.stDramaInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class m extends com.tencent.biz.pubaccount.weishi.baseui.a<stSimpleMetaFeed> implements View.OnClickListener {
    private static final int K = com.tencent.biz.pubaccount.weishi.util.r.H(5.0f);
    private RoundCornerImageView C;
    private RoundCornerImageView D;
    private RoundCornerImageView E;
    private RoundCornerImageView F;
    private com.tencent.biz.pubaccount.weishi.t G;
    private stSimpleMetaFeed H;
    private int I;
    private String J;

    /* renamed from: i, reason: collision with root package name */
    private TextView f81460i;

    /* renamed from: m, reason: collision with root package name */
    private KandianUrlImageView f81461m;

    public m(Context context, View view) {
        super(context, view);
    }

    private int h() {
        return (ba.o() - (com.tencent.biz.pubaccount.weishi.n.f80927d * 3)) / 2;
    }

    private void k(int i3) {
        ViewGroup.LayoutParams layoutParams = this.f80414d.getLayoutParams();
        layoutParams.height = (int) ((i3 * 1.7777778f) + com.tencent.biz.pubaccount.weishi.n.f80927d);
        this.f80414d.setLayoutParams(layoutParams);
    }

    private void l() {
        String str;
        String str2;
        String str3;
        stDramaInfo stdramainfo;
        stDramaFall stdramafall = this.H.dramaInfo;
        if (stdramafall == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.t tVar = this.G;
        if (tVar != null && !TextUtils.isEmpty(tVar.F)) {
            str = "feeds_" + this.G.F;
        } else {
            str = "feeds";
        }
        String str4 = str;
        stDrama stdrama = stdramafall.dramaInfo;
        if (stdrama != null && (stdramainfo = stdrama.dramaInfo) != null) {
            String str5 = stdramainfo.coverImg;
            str2 = stdramainfo.name;
            this.J = stdramainfo.f25116id;
            str3 = str5;
        } else {
            str2 = "";
            str3 = "";
        }
        this.f81460i.setText(str2);
        WSPicLoader.g().n(this.F, str3, com.tencent.biz.pubaccount.weishi.util.r.i(R.color.f157202bw1), str4, this.I);
        WSPicLoader.g().w(this.C, stdramafall.bgCover, com.tencent.biz.pubaccount.weishi.util.r.i(R.color.f158017al3));
        WSPicLoader.g().w(this.f81461m, stdramafall.titleCover, com.tencent.biz.pubaccount.weishi.util.r.i(R.color.ajr));
        ArrayList<String> arrayList = stdramafall.images;
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                WSPicLoader.g().w(this.E, stdramafall.images.get(0), com.tencent.biz.pubaccount.weishi.util.r.i(R.color.f157202bw1));
            }
            if (stdramafall.images.size() > 1) {
                WSPicLoader.g().w(this.D, stdramafall.images.get(1), com.tencent.biz.pubaccount.weishi.util.r.i(R.color.f157202bw1));
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        this.C = (RoundCornerImageView) this.f80414d.findViewById(R.id.f75113y3);
        this.f81460i = (TextView) this.f80414d.findViewById(R.id.f107926bq);
        this.f81461m = (KandianUrlImageView) this.f80414d.findViewById(R.id.f165925y31);
        this.D = (RoundCornerImageView) this.f80414d.findViewById(R.id.f75153y7);
        this.E = (RoundCornerImageView) this.f80414d.findViewById(R.id.f75143y6);
        this.F = (RoundCornerImageView) this.f80414d.findViewById(R.id.f75123y4);
        RoundCornerImageView roundCornerImageView = this.C;
        int i3 = K;
        roundCornerImageView.setCorner(i3, 0);
        this.F.setCorner(i3, 0);
        this.E.setCorner(i3, 1);
        this.D.setCorner(i3, 1);
        this.f80414d.setOnClickListener(this);
        k(h());
    }

    public void i(com.tencent.biz.pubaccount.weishi.t tVar) {
        this.G = tVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.a, com.tencent.biz.pubaccount.weishi.baseui.c
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void setData(stSimpleMetaFeed stsimplemetafeed) {
        this.H = stsimplemetafeed;
        l();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        com.tencent.biz.pubaccount.weishi.drama.e i3 = new com.tencent.biz.pubaccount.weishi.drama.e("grid_drama_card", this.f80416f).i(this.J);
        com.tencent.biz.pubaccount.weishi.t tVar = this.G;
        if (tVar != null) {
            str = tVar.F;
        } else {
            str = "";
        }
        WSDramaPageFragment.Vh(i3.k(str));
        stSimpleMetaFeed stsimplemetafeed = this.H;
        com.tencent.biz.pubaccount.weishi.recommend.a.c("gzh_click", stsimplemetafeed, com.tencent.biz.pubaccount.weishi.report.a.b(stsimplemetafeed, this.I), 1000001, this.G.F);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.a, com.tencent.biz.pubaccount.weishi.baseui.c
    public void setPosition(int i3) {
        this.I = i3;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void c() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void d() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.a, com.tencent.biz.pubaccount.weishi.baseui.c
    public void recycle() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int i3) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.a, com.tencent.biz.pubaccount.weishi.baseui.c
    public void onPageSelected(int i3) {
    }
}
