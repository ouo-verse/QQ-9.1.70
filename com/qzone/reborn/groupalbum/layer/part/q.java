package com.qzone.reborn.groupalbum.layer.part;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.part.layer.CommonLayerCommentPanelPart;
import com.qzone.reborn.albumx.common.viewmodel.CommonCommentBusinessViewModel;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0003H\u0014J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/q;", "Lcom/qzone/reborn/albumx/common/part/layer/CommonLayerCommentPanelPart;", "Lcom/qzone/reborn/groupalbum/layer/bean/GroupAlbumLayerExtraInfoBean;", "", "getLogTag", "Lcom/qzone/reborn/albumx/common/viewmodel/CommonCommentBusinessViewModel;", "L9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "", "onLayerStateUpdate", "O9", "Landroid/content/Context;", "context", "Luc/a;", "M9", "<init>", "()V", "T", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q extends CommonLayerCommentPanelPart<GroupAlbumLayerExtraInfoBean> {
    @Override // com.qzone.reborn.albumx.common.part.layer.CommonLayerCommentPanelPart
    protected CommonCommentBusinessViewModel L9() {
        ViewModel viewModel = getViewModel(com.qzone.reborn.groupalbum.viewmodel.ad.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumL\u2026entViewModel::class.java)");
        return (CommonCommentBusinessViewModel) viewModel;
    }

    @Override // com.qzone.reborn.albumx.common.part.layer.CommonLayerCommentPanelPart
    protected String O9() {
        String lLoc;
        GroupAlbumLayerExtraInfoBean x95 = x9();
        return (x95 == null || (lLoc = x95.getLLoc()) == null) ? "" : lLoc;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumLayerCommentPanelPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        com.qzone.reborn.groupalbum.viewmodel.ad adVar = (com.qzone.reborn.groupalbum.viewmodel.ad) N9();
        if (adVar == null) {
            return;
        }
        adVar.i3(x9());
    }

    @Override // com.qzone.reborn.albumx.common.part.layer.CommonLayerCommentPanelPart
    protected uc.a M9(Context context) {
        if (context == null) {
            return null;
        }
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(context);
        String qqStr = HardCodeUtil.qqStr(R.string.c2w);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobileqq.R.string.list_empty)");
        QUIEmptyState.Builder backgroundColorType = builder.setDesc(qqStr).setImageType(8).setThemeType(2).setAutoCenter(true).setHalfScreenState(true).setBackgroundColorType(0);
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(context).setThemeType(2).setImageType(13);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f133596j);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qzm_folder_page_error_state_text)");
        return new uc.a().d(backgroundColorType).f(imageType.setTitle(qqStr2).setAutoCenter(true).setHalfScreenState(true).setBackgroundColorType(0));
    }
}
