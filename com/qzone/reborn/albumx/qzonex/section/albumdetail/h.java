package com.qzone.reborn.albumx.qzonex.section.albumdetail;

import android.view.View;
import android.widget.ImageView;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.qzonex.widget.QZAlbumxAlbumDetailSinglePicView;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u0011\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/section/albumdetail/h;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "Lcom/qzone/reborn/albumx/qzonex/widget/QZAlbumxAlbumDetailSinglePicView;", "e", "Lcom/qzone/reborn/albumx/qzonex/widget/QZAlbumxAlbumDetailSinglePicView;", "picView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends com.qzone.reborn.base.l<CommonGridItemData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxAlbumDetailSinglePicView picView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailSinglePicSection";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f20077e);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d.common_pic_widget_view)");
        this.picView = (QZAlbumxAlbumDetailSinglePicView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f162796mo4};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonGridItemData data, int position, List<Object> payload) {
        if (data != null) {
            QZAlbumxAlbumDetailSinglePicView qZAlbumxAlbumDetailSinglePicView = this.picView;
            QZAlbumxAlbumDetailSinglePicView qZAlbumxAlbumDetailSinglePicView2 = null;
            if (qZAlbumxAlbumDetailSinglePicView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picView");
                qZAlbumxAlbumDetailSinglePicView = null;
            }
            qZAlbumxAlbumDetailSinglePicView.setData(data, data.getMediaPos());
            QZAlbumxAlbumDetailSinglePicView qZAlbumxAlbumDetailSinglePicView3 = this.picView;
            if (qZAlbumxAlbumDetailSinglePicView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picView");
            } else {
                qZAlbumxAlbumDetailSinglePicView2 = qZAlbumxAlbumDetailSinglePicView3;
            }
            ImageView ivPicImage = qZAlbumxAlbumDetailSinglePicView2.getIvPicImage();
            if (ivPicImage == null) {
                return;
            }
            ivPicImage.setContentDescription("\u7b2c" + (data.getBatchPos() + 1) + "\u6279\u6b21\uff0c\u7b2c" + (data.getMediaPos() + 1) + "\u4e2a");
        }
    }
}
