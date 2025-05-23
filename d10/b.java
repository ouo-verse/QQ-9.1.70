package d10;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import tencent.gdt.access;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private static final int H = com.tencent.biz.pubaccount.weishi.util.r.H(8.0f);
    private RoundCornerImageView C;
    private TextView D;
    private TextView E;
    private GdtAd F;
    private stSimpleMetaFeed G;

    public b(Context context) {
        super(context);
        this.F = new GdtAd();
    }

    private boolean u() {
        return this.G.waterFallCardStyle.cardType != 13;
    }

    private void v() {
        if (u()) {
            this.f80410e.setVisibility(0);
        } else {
            this.f80410e.setVisibility(8);
        }
    }

    private void w() {
        WSPicLoader.g().j(this.f80409d, this.C, this.F.getAdvertiser_corporate_logo());
        String text = this.F.getText();
        TextView textView = this.E;
        if (TextUtils.isEmpty(text)) {
            text = this.F.getDescription();
        }
        textView.setText(text);
        this.D.setText(this.F.info.display_info.advertiser_info.corporate_image_name.get());
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
        if (this.F.isValid()) {
            v();
            w();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d27;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) this.f80410e.findViewById(R.id.p2m);
        this.C = roundCornerImageView;
        roundCornerImageView.setCorner(H, 0);
        this.D = (TextView) this.f80410e.findViewById(R.id.p2v);
        this.E = (TextView) this.f80410e.findViewById(R.id.p2o);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
