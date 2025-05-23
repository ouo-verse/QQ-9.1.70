package bz;

import UserGrowth.stMsgContent;
import UserGrowth.stNotifyMsg;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lbz/i;", "Lbz/d;", "Lyy/c;", "data", "", tl.h.F, "Lcom/tencent/biz/pubaccount/weishi/view/RoundCornerImageView;", "G", "Lcom/tencent/biz/pubaccount/weishi/view/RoundCornerImageView;", "rivCover", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class i extends d {

    /* renamed from: G, reason: from kotlin metadata */
    private RoundCornerImageView rivCover;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ViewGroup parent) {
        super(parent, R.layout.f167385d14);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View findViewById = this.itemView.findViewById(R.id.p5u);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.riv_msg_cover)");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById;
        this.rivCover = roundCornerImageView;
        roundCornerImageView.setCorner(ba.f81748w, 0);
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: h */
    public void bindData(yy.c data) {
        stNotifyMsg a16;
        stMsgContent stmsgcontent;
        super.bindData(data);
        this.rivCover.setVisibility(0);
        WSPicLoader.g().w(this.rivCover, (data == null || (a16 = data.a()) == null || (stmsgcontent = a16.content) == null) ? null : stmsgcontent.picURL, r.i(R.color.f157202bw1));
    }
}
