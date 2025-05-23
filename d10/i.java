package d10;

import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private KandianUrlImageView C;
    protected stSimpleMetaFeed D;

    public i(Context context) {
        super(context);
    }

    private boolean u() {
        stH5OpInfo sth5opinfo;
        return this.D.video_type == 1 && iz.a.g().q(1) == 2 && (sth5opinfo = this.D.h5_op_info) != null && !TextUtils.isEmpty(sth5opinfo.maskImgUrl);
    }

    private void v() {
        if (u()) {
            this.C.setVisibility(0);
            WSPicLoader.g().p(this.C, this.D.h5_op_info.maskImgUrl);
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
        return R.layout.fxh;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (KandianUrlImageView) p(R.id.xwx);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
