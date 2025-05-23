package com.qzone.reborn.albumx.qzonex.part.layer.batch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0004J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0014J\u0016\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0014J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0004J\u001c\u0010#\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020 H\u0014R$\u00100\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/batch/e;", "Lcom/qzone/reborn/albumx/common/layer/part/CommonLayerControlPart;", "Lcom/qzone/reborn/albumx/qzonex/bean/layer/QZAlbumxLayerExtraInfoBean;", "Lbb/d;", "Landroid/os/Bundle;", "data", "", "ha", "ia", "", "id", "da", "extraInfoBean", "", "ga", "initIntentData", "fetchLeft", "fetchRight", "X9", "U9", "Lbb/g;", "ca", "", "N9", "Lq9/a;", "L9", "Lcom/tencent/richframework/data/base/UIStateData;", "uiStateData", "Lo9/e;", "R9", "Loc/a;", "ea", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "preLayerState", "newLayerState", "H9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "layerState", "onLayerStateUpdate", "Loc/e;", "J", "Loc/e;", "getViewModel", "()Loc/e;", "setViewModel", "(Loc/e;)V", "viewModel", "", "K", "Ljava/util/List;", "initExtraInfoList", "<init>", "()V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends CommonLayerControlPart<QZAlbumxLayerExtraInfoBean, bb.d> {

    /* renamed from: J, reason: from kotlin metadata */
    private oc.e viewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private List<QZAlbumxLayerExtraInfoBean> initExtraInfoList;

    private final QZAlbumxLayerExtraInfoBean da(String id5) {
        List<QZAlbumxLayerExtraInfoBean> list = this.initExtraInfoList;
        if (list != null && !ArrayUtils.isOutOfArrayIndex(0, list)) {
            List<QZAlbumxLayerExtraInfoBean> list2 = this.initExtraInfoList;
            Intrinsics.checkNotNull(list2);
            for (QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean : list2) {
                if (ga(qZAlbumxLayerExtraInfoBean, id5)) {
                    return qZAlbumxLayerExtraInfoBean;
                }
            }
        }
        return null;
    }

    private final boolean ga(QZAlbumxLayerExtraInfoBean extraInfoBean, String id5) {
        return Intrinsics.areEqual(id5, extraInfoBean.getLLoc());
    }

    private final void ia() {
        Intent intent;
        RFWLayerState data;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        List<RFWLayerItemMediaInfo> richMediaDataList = (value == null || (data = value.getData()) == null) ? null : data.getRichMediaDataList();
        if (ArrayUtils.isOutOfArrayIndex(0, richMediaDataList)) {
            return;
        }
        Intrinsics.checkNotNull(richMediaDataList);
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
            String mediaId = rFWLayerItemMediaInfo.getMediaId();
            if (mediaId == null) {
                mediaId = "";
            }
            QZAlbumxLayerExtraInfoBean da5 = da(mediaId);
            if (da5 != null) {
                Activity activity = getActivity();
                da5.d0((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra("key_qzone_id"));
            }
            rFWLayerItemMediaInfo.setExtraData(da5);
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public q9.a<bb.d> L9() {
        ViewModel viewModel = getViewModel(oc.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxDet\u2026ataViewModel::class.java)");
        return (q9.a) viewModel;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected int N9() {
        return 3;
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

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    protected boolean U9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart
    public void X9(boolean fetchLeft, boolean fetchRight) {
        oc.a<bb.d> ea5 = ea();
        bb.g ca5 = ca();
        ca5.n(ea().getQzoneId());
        ca5.k(ea().getLinkId());
        ca5.g(fetchLeft);
        ca5.h(fetchRight);
        ca5.l(fetchLeft && fetchRight);
        ea5.U1(ca5);
    }

    protected final bb.g ca() {
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
        gVar.j(ea().getLeftAttachInfo());
        gVar.m(ea().getRightAttachInfo());
        return gVar;
    }

    protected final oc.a<bb.d> ea() {
        q9.a<bb.d> L9 = L9();
        Intrinsics.checkNotNull(L9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.layer.QZAlbumxBaseLayerDataViewModel<com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerListBean>");
        return (oc.a) L9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        oc.e eVar;
        super.initIntentData(data);
        Serializable serializable = data != null ? data.getSerializable("key_init_data_list") : null;
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean> }");
        this.initExtraInfoList = (ArrayList) serializable;
        ha(data);
        ia();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        RFWLog.d("QZAlbumxBatchLayerControlPart", RFWLog.USR, "onLayerStateUpdate, layerState.mediaSum:" + layerState.getMediaSum() + " mSelectedPosition:" + this.mSelectedPosition);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.CommonLayerControlPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        oc.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.removeListener();
        }
    }

    private final void ha(Bundle data) {
        if (data != null) {
            String str = "";
            if (data.containsKey("key_attach_info")) {
                oc.a<bb.d> ea5 = ea();
                String string = data.getString("key_attach_info");
                if (string == null) {
                    string = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string, "it.getString(QZAlbumxGal\u2026er.KEY_ATTACH_INFO) ?: \"\"");
                }
                ea5.Z1(string);
            }
            if (data.containsKey("key_qzone_id")) {
                oc.a<bb.d> ea6 = ea();
                String string2 = data.getString("key_qzone_id");
                if (string2 == null) {
                    string2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string2, "it.getString(QZAlbumxGal\u2026ncher.KEY_QZONE_ID) ?: \"\"");
                }
                ea6.X1(string2);
            }
            if (data.containsKey("key_link_id")) {
                oc.a<bb.d> ea7 = ea();
                String string3 = data.getString("key_link_id");
                if (string3 != null) {
                    Intrinsics.checkNotNullExpressionValue(string3, "it.getString(QZAlbumxGal\u2026uncher.KEY_LINK_ID) ?: \"\"");
                    str = string3;
                }
                ea7.W1(str);
            }
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
