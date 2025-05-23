package com.tencent.biz.pubaccount.weishi.verticalvideo.vas;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB#\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\b\u0010\u0010\u001a\u00020\fH\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/d;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/f;", "", "type", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/b;", "y", "", "o", "LUserGrowth/stSimpleMetaFeed;", "itemInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "r", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/VasAdvWSVerticalItemView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/VasAdvWSVerticalItemView;", "vasItemView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "<init>", "(Landroid/view/ViewGroup;ILcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;)V", "D", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d extends f {

    /* renamed from: C, reason: from kotlin metadata */
    private VasAdvWSVerticalItemView vasItemView;

    public d(ViewGroup viewGroup, int i3, WSVerticalPageFragment wSVerticalPageFragment) {
        super(viewGroup, i3, wSVerticalPageFragment);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public int i() {
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public int m(stSimpleMetaFeed itemInfo) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean o() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    protected boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean q() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public void r() {
        VasAdvWSVerticalItemView vasAdvWSVerticalItemView = this.vasItemView;
        if (vasAdvWSVerticalItemView != null) {
            ((IVasAdvWeb) QRoute.api(IVasAdvWeb.class)).unsubscribeAll("ws_video_ad_h5_cover");
            vasAdvWSVerticalItemView.recycle();
        }
        ((IVasAdvWeb) QRoute.api(IVasAdvWeb.class)).removeWebView();
        x.i("VasAdWSVerticalViewHolder", "onDoDestroy: ");
        super.r();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public void t() {
        super.t();
        T t16 = this.f82129f;
        if (t16 != 0) {
            stSimpleMetaFeed e16 = ((j) t16).e();
            if (!(e16 instanceof stSimpleMetaFeed)) {
                e16 = null;
            }
            if (e16 != null && e16.gdt_ad_type == 1 && e16.gdt_ad_info != null) {
                ((j) this.f82129f).a().isGdtAdVidoReport = false;
            }
        }
        x.i("VasAdWSVerticalViewHolder", "onDoResume: ");
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b b(int type) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        VasAdvWSVerticalItemView vasAdvWSVerticalItemView = new VasAdvWSVerticalItemView(context, this);
        this.vasItemView = vasAdvWSVerticalItemView;
        return vasAdvWSVerticalItemView;
    }
}
