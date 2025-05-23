package com.qzone.reborn.albumx.qzonex.part.layer;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0014J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0014J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0015\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/h;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/QZAlbumxBaseLayerControlPart;", "Lbb/d;", "Landroid/os/Bundle;", "data", "", "initIntentData", "Lbb/g;", "la", "Lq9/a;", "L9", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "Lo9/e;", "R9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "preLayerState", "newLayerState", "H9", "", "getRefer", "Loc/e;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Loc/e;", "getViewModel", "()Loc/e;", "setViewModel", "(Loc/e;)V", "viewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends QZAlbumxBaseLayerControlPart<bb.d> {

    /* renamed from: Q, reason: from kotlin metadata */
    private oc.e viewModel;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<bb.d> L9() {
        ViewModel viewModel = getViewModel(oc.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxDet\u2026ataViewModel::class.java)");
        return (q9.a) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public o9.e R9(UIStateData<bb.d> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        o9.e eVar = new o9.e();
        bb.d data = uiStateData.getData();
        if (data == null) {
            return eVar;
        }
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setMediaSum(data.getMediumSum());
        rFWLayerState.setRichMediaDataList(data.g());
        Y9(data.getIsLeftFinish());
        aa(data.getIsRightFinish());
        if (data.getIsRefresh()) {
            Z9(true);
        }
        UIStateData<RFWLayerState> rfwLayerInfoUIStateData = UIStateData.obtainSuccess(false);
        eVar.c(rFWLayerState);
        Intrinsics.checkNotNullExpressionValue(rfwLayerInfoUIStateData, "rfwLayerInfoUIStateData");
        eVar.d(rfwLayerInfoUIStateData);
        String tag = getTAG();
        int i3 = RFWLog.USR;
        List<RFWLayerItemMediaInfo> richMediaDataList = rFWLayerState.getRichMediaDataList();
        Integer valueOf = richMediaDataList != null ? Integer.valueOf(richMediaDataList.size()) : null;
        RFWLog.i(tag, i3, "media list size is " + valueOf + " is refresh " + data.getIsRefresh());
        return eVar;
    }

    @Override // com.qzone.reborn.albumx.qzonex.part.layer.QZAlbumxBaseLayerControlPart
    public int getRefer() {
        return 2;
    }

    @Override // com.qzone.reborn.albumx.qzonex.part.layer.QZAlbumxBaseLayerControlPart, com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    protected void initIntentData(Bundle data) {
        oc.e eVar;
        super.initIntentData(data);
        if (data != null) {
            this.viewModel = (oc.e) getViewModel(oc.e.class);
            if (!data.containsKey("key_album_detail_init_bean") || (eVar = this.viewModel) == null) {
                return;
            }
            Object obj = data.get("key_album_detail_init_bean");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean");
            eVar.l2((QZAlbumxAlbumDetailInitBean) obj);
        }
    }

    @Override // com.qzone.reborn.albumx.qzonex.part.layer.QZAlbumxBaseLayerControlPart
    protected bb.g la() {
        String str;
        String str2;
        String batchId;
        bb.g gVar = new bb.g();
        QZAlbumxLayerExtraInfoBean x95 = x9();
        String str3 = "";
        if (x95 == null || (str = x95.getLLoc()) == null) {
            str = "";
        }
        gVar.i(str);
        QZAlbumxLayerExtraInfoBean x96 = x9();
        if (x96 == null || (str2 = x96.getAlbumId()) == null) {
            str2 = "";
        }
        gVar.f(str2);
        QZAlbumxLayerExtraInfoBean x97 = x9();
        if (x97 != null && (batchId = x97.getBatchId()) != null) {
            str3 = batchId;
        }
        gVar.k(str3);
        gVar.j(oa().getLeftAttachInfo());
        gVar.m(oa().getRightAttachInfo());
        return gVar;
    }

    @Override // com.qzone.reborn.albumx.qzonex.part.layer.QZAlbumxBaseLayerControlPart, com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        oc.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.removeListener();
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected void H9(RFWLayerState preLayerState, RFWLayerState newLayerState) {
        if (preLayerState == null || newLayerState == null) {
            return;
        }
        if (preLayerState.getSelectedPosition() > 0) {
            newLayerState.setSelectedPosition(preLayerState.getSelectedPosition() - 1);
        } else {
            newLayerState.setSelectedPosition(0);
        }
    }
}
