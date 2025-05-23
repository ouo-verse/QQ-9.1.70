package d10;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private KandianUrlImageView C;
    protected stSimpleMetaFeed D;

    public c(Context context) {
        super(context);
    }

    private boolean u() {
        return this.D.cardInfo.cardType != 13;
    }

    private void v() {
        if (u()) {
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        this.D = c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        v();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1g;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (KandianUrlImageView) p(R.id.p2x);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
