package d10;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import tencent.gdt.access;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private static final int H = com.tencent.biz.pubaccount.weishi.util.r.H(8.0f);
    private RoundCornerImageView C;
    private TextView D;
    private TextView E;
    private GdtAd F;
    private stSimpleMetaFeed G;

    public d(Context context) {
        super(context);
        this.F = new GdtAd();
    }

    private boolean u() {
        return this.G.waterFallCardStyle.cardType == 13;
    }

    private void w() {
        if (u()) {
            this.f80410e.setVisibility(0);
        } else {
            this.f80410e.setVisibility(8);
        }
    }

    private void x() {
        String text = this.F.getText();
        TextView textView = this.E;
        if (TextUtils.isEmpty(text)) {
            text = this.F.getDescription();
        }
        textView.setText(text);
        WSPicLoader.g().j(this.f80409d, this.C, this.F.getAdvertiser_corporate_logo());
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
            w();
            x();
            v();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d28;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) this.f80410e.findViewById(R.id.p2m);
        this.C = roundCornerImageView;
        roundCornerImageView.setCorner(H, 0);
        this.D = (TextView) this.f80410e.findViewById(R.id.p2v);
        this.E = (TextView) this.f80410e.findViewById(R.id.p2o);
    }

    private void v() {
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
        this.D.setTextColor(isNowThemeIsNight ? -1 : com.tencent.biz.pubaccount.weishi.util.r.g(R.color.weishi_color_skin_comment_text));
        this.E.setTextColor(isNowThemeIsNight ? -1 : -16777216);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
