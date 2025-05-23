package d10;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private WSRoundedImageView C;
    private TextView D;
    private TextView E;
    private stSimpleMetaFeed F;

    public g(Context context) {
        super(context);
    }

    private void v() {
        stSimpleMetaPerson stsimplemetaperson = this.F.poster;
        WSPicLoader.g().j(this.f80409d, this.C, stsimplemetaperson.avatar);
        this.D.setTextColor(u());
        this.D.setText(com.tencent.biz.pubaccount.weishi.util.r.y(stsimplemetaperson.nick));
        com.tencent.biz.pubaccount.weishi.util.r.x(this.E, stsimplemetaperson.medal, false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        this.F = c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        v();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fxb;
    }

    protected int u() {
        return -1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (WSRoundedImageView) p(R.id.xws);
        this.D = (TextView) p(R.id.xwz);
        this.E = (TextView) p(R.id.xwy);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
