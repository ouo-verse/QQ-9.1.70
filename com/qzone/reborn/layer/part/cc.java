package com.qzone.reborn.layer.part;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart;
import com.qzone.reborn.layer.route.QZoneLocalLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.model.PhotoInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0014J\u0016\u0010\u0019\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0014R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/layer/part/cc;", "Lcom/qzone/reborn/albumx/common/layer/part/CommonLayerControlPart;", "Lcom/qzone/reborn/layer/route/QZoneLocalLayerExtraInfoBean;", "Lrk/j;", "Landroid/os/Bundle;", "data", "", "ea", "", "id", "ca", "extraInfoBean", "", "da", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "initIntentData", "", "N9", "Lq9/a;", "L9", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "Lo9/e;", "R9", "", "J", "Ljava/util/List;", "initExtraInfoList", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class cc extends CommonLayerControlPart<QZoneLocalLayerExtraInfoBean, rk.j> {

    /* renamed from: J, reason: from kotlin metadata */
    private List<QZoneLocalLayerExtraInfoBean> initExtraInfoList;

    private final boolean da(QZoneLocalLayerExtraInfoBean extraInfoBean, String id5) {
        PhotoInfo photoInfo = extraInfoBean.getPhotoInfo();
        return Intrinsics.areEqual(id5, photoInfo != null ? photoInfo.getPicId() : null);
    }

    private final void ea(Bundle data) {
        RFWLayerState data2;
        Serializable serializable = data.getSerializable("key_init_data_list");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<com.qzone.reborn.layer.route.QZoneLocalLayerExtraInfoBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.qzone.reborn.layer.route.QZoneLocalLayerExtraInfoBean> }");
        this.initExtraInfoList = (ArrayList) serializable;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        List<RFWLayerItemMediaInfo> richMediaDataList = (value == null || (data2 = value.getData()) == null) ? null : data2.getRichMediaDataList();
        if (ArrayUtils.isOutOfArrayIndex(0, richMediaDataList)) {
            return;
        }
        if (richMediaDataList != null) {
            for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
                String mediaId = rFWLayerItemMediaInfo.getMediaId();
                if (mediaId == null) {
                    mediaId = "";
                }
                rFWLayerItemMediaInfo.setExtraData(ca(mediaId));
            }
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<rk.j> L9() {
        ViewModel viewModel = getViewModel(uk.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneLayerL\u2026diaViewModel::class.java)");
        return (q9.a) viewModel;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected int N9() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public o9.e R9(UIStateData<rk.j> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        Intrinsics.checkNotNull(value);
        UIStateData<RFWLayerState> uIStateData = value;
        o9.e eVar = new o9.e();
        RFWLayerState data = uIStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "curUIStateData.data");
        eVar.c(data);
        eVar.d(uIStateData);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        if (data != null) {
            ea(data);
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        Y9(true);
        aa(true);
    }

    private final QZoneLocalLayerExtraInfoBean ca(String id5) {
        if (ArrayUtils.isOutOfArrayIndex(0, this.initExtraInfoList)) {
            return null;
        }
        List<QZoneLocalLayerExtraInfoBean> list = this.initExtraInfoList;
        Intrinsics.checkNotNull(list);
        for (QZoneLocalLayerExtraInfoBean qZoneLocalLayerExtraInfoBean : list) {
            if (da(qZoneLocalLayerExtraInfoBean, id5)) {
                return qZoneLocalLayerExtraInfoBean;
            }
        }
        return null;
    }
}
