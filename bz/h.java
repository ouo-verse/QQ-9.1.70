package bz;

import UserGrowth.stMsgContent;
import UserGrowth.stNotifyMsg;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lbz/h;", "Lbz/d;", "Lyy/c;", "data", "", tl.h.F, "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "tvBtn", "Lcom/tencent/biz/pubaccount/weishi/view/RoundCornerImageView;", "H", "Lcom/tencent/biz/pubaccount/weishi/view/RoundCornerImageView;", "rivCover", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class h extends d {

    /* renamed from: G, reason: from kotlin metadata */
    private TextView tvBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private RoundCornerImageView rivCover;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ViewGroup parent) {
        super(parent, R.layout.f167385d14);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View findViewById = this.itemView.findViewById(R.id.p7i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_msg_btn)");
        this.tvBtn = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.p5u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.riv_msg_cover)");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById2;
        this.rivCover = roundCornerImageView;
        roundCornerImageView.setCorner(ba.f81748w, 0);
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: h */
    public void bindData(yy.c data) {
        stNotifyMsg a16;
        stMsgContent stmsgcontent;
        stNotifyMsg a17;
        stMsgContent stmsgcontent2;
        super.bindData(data);
        this.tvBtn.setVisibility(0);
        String str = null;
        this.tvBtn.setText((data == null || (a17 = data.a()) == null || (stmsgcontent2 = a17.content) == null) ? null : stmsgcontent2.btnWording);
        this.rivCover.setVisibility(0);
        WSPicLoader g16 = WSPicLoader.g();
        RoundCornerImageView roundCornerImageView = this.rivCover;
        if (data != null && (a16 = data.a()) != null && (stmsgcontent = a16.content) != null) {
            str = stmsgcontent.picURL;
        }
        g16.w(roundCornerImageView, str, r.i(R.color.f157202bw1));
    }
}
