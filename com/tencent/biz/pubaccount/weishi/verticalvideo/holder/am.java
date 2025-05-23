package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/am;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/f;", "", "type", "Lcom/tencent/biz/pubaccount/weishi/baseui/c;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "b", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "LUserGrowth/stSimpleMetaFeed;", "itemInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "<init>", "(Landroid/view/ViewGroup;ILcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class am extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(ViewGroup parent, int i3, WSVerticalPageFragment fragment) {
        super(parent, i3, fragment);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e
    public com.tencent.biz.pubaccount.weishi.baseui.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> b(int type) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new aw(context, this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public int m(stSimpleMetaFeed itemInfo) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean o() {
        T mItemData = this.f82129f;
        Intrinsics.checkNotNullExpressionValue(mItemData, "mItemData");
        if (com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.q.a((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) mItemData)) {
            return true;
        }
        return super.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au
    public boolean q() {
        return false;
    }
}
