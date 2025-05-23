package d10;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterFallCardStyle;
import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.t;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import tencent.gdt.access;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private static final int H = com.tencent.biz.pubaccount.weishi.util.r.H(5.0f);
    private RoundCornerImageView C;
    private final View D;
    private t E;
    private GdtAd F;
    private stSimpleMetaFeed G;

    public a(Context context, View view, t tVar) {
        super(context);
        this.F = new GdtAd();
        this.D = view;
        this.E = tVar;
    }

    private void u() {
        this.C.setCorner(H, v() ? 1 : 0);
    }

    private boolean v() {
        stSimpleMetaFeed stsimplemetafeed = this.G;
        return stsimplemetafeed != null && stsimplemetafeed.waterFallCardStyle.cardType == 13;
    }

    private void w() {
        String str;
        stWaterFallCardStyle stwaterfallcardstyle = this.G.waterFallCardStyle;
        ((StaggeredGridLayoutManager.LayoutParams) this.D.getLayoutParams()).setFullSpan(stwaterfallcardstyle != null && stwaterfallcardstyle.isFullSpan);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.C.getLayoutParams();
        Pair<Integer, Integer> f16 = ba.f(this.F, this.G.waterAdStyle);
        layoutParams.width = -1;
        layoutParams.height = ((Integer) f16.second).intValue();
        this.C.setLayoutParams(layoutParams);
        this.C.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.C.setBackgroundResource(R.drawable.ggy);
        t tVar = this.E;
        if (tVar != null && !TextUtils.isEmpty(tVar.F)) {
            str = "feeds_" + this.E.F;
        } else {
            str = "feeds";
        }
        WSPicLoader.g().o(BaseApplicationImpl.getApplication(), new com.tencent.biz.pubaccount.weishi.image.c(this.C, this.F.getBasic_img()).j(ba.m(this.G)).k(str).i(d()));
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        stSimpleMetaFeed c16 = c();
        this.G = c16;
        access.AdGetRsp e16 = com.tencent.biz.pubaccount.weishi.util.d.f81760a.e(c16.waterAdItem);
        if (e16.qq_ad_get_rsp.pos_ads_info.isEmpty() || e16.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.isEmpty()) {
            return;
        }
        this.F = new GdtAd(e16.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0));
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        w();
        u();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fxf;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (RoundCornerImageView) p(R.id.xwv);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
