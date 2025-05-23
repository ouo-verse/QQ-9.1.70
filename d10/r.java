package d10;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.WSNumUtil;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class r extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private ImageView C;
    private TextView D;
    protected stSimpleMetaFeed E;

    public r(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        this.E = c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        int w3 = w();
        if (w3 > 0) {
            this.C.setVisibility(0);
            this.C.setImageResource(u());
            this.D.setVisibility(0);
            this.D.setTextColor(v());
            WSNumUtil.d(this.D, w3, "0");
            return;
        }
        this.C.setVisibility(8);
        this.D.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fxj;
    }

    protected abstract int u();

    protected abstract int v();

    protected abstract int w();

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (ImageView) p(R.id.f165870xx2);
        this.D = (TextView) p(R.id.f165869xx1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
