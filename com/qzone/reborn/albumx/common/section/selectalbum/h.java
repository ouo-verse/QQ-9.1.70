package com.qzone.reborn.albumx.common.section.selectalbum;

import android.view.View;
import android.widget.ImageView;
import com.qzone.reborn.base.l;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J*\u0010\u0011\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/albumx/common/section/selectalbum/h;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "v", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivSelectIcon", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends l<com.qzone.reborn.albumx.common.bean.h> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivSelectIcon;

    private final void u(com.qzone.reborn.albumx.common.bean.h item) {
        ImageView imageView = null;
        if (item.getIsSelect()) {
            ImageView imageView2 = this.ivSelectIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivSelectIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.ivSelectIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivSelectIcon");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f162972nm2};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.albumx.common.bean.h data, int position, List<Object> payload) {
        if (data == null) {
            return;
        }
        u(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.lrm);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_select_icon)");
            this.ivSelectIcon = (ImageView) findViewById;
        }
    }
}
