package d10;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class l extends com.tencent.biz.pubaccount.weishi.baseui.b<stSimpleMetaFeed> {
    private TextView C;
    private stSimpleMetaFeed D;

    public l(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        this.D = c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        String str = this.D.feed_desc;
        if (!TextUtils.isEmpty(str)) {
            this.C.setVisibility(0);
            this.C.setTextColor(u());
            this.C.setTextSize(2, v());
            this.C.setText(str);
            return;
        }
        this.C.setVisibility(8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fxm;
    }

    protected int u() {
        return -1;
    }

    protected int v() {
        return 14;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (TextView) p(R.id.xww);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
