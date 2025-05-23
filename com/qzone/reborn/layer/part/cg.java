package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.reborn.intimate.event.QZoneLayerPostDataEvent;
import com.qzone.reborn.layer.event.QZoneUploadDeleteMediaEvent;
import com.qzone.reborn.layer.route.QZoneLocalLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.util.ArrayUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/layer/part/cg;", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Lcom/qzone/reborn/layer/route/QZoneLocalLayerExtraInfoBean;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K9", "H9", "G9", "Landroid/os/Bundle;", "data", "initIntentData", "onInitView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "deleteIcon", "", "i", "Z", "isShowDelBtn", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class cg extends com.qzone.reborn.albumx.common.layer.part.i<QZoneLocalLayerExtraInfoBean> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView deleteIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isShowDelBtn = true;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void G9() {
        List<? extends RFWLayerItemMediaInfo> mutableList;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null) {
            if (rFWLayerItemMediaInfo.isVideo()) {
                RFWLayerVideoInfo layerVideoInfo = rFWLayerItemMediaInfo.getLayerVideoInfo();
                if (layerVideoInfo != null) {
                    url = layerVideoInfo.getCurrentVideoUrl();
                    if (url != null) {
                        return;
                    } else {
                        SimpleEventBus.getInstance().dispatchEvent(new QZoneUploadDeleteMediaEvent(url, this.mSelectedPosition), true);
                    }
                }
                url = null;
                if (url != null) {
                }
            } else {
                RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
                if (layerPicInfo != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null) {
                    url = currentPicInfo.getUrl();
                    if (url != null) {
                    }
                }
                url = null;
                if (url != null) {
                }
            }
        }
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        RFWLayerState data = value != null ? value.getData() : null;
        if (data == null || (r0 = data.getRichMediaDataList()) == null || mutableList == null) {
            return;
        }
        if (ArrayUtils.isOutOfArrayIndex(this.mSelectedPosition, mutableList)) {
            RFWLog.e("QZoneLocalLayerDeletePart", RFWLog.USR, "mSelectedPosition is out of bounds");
            return;
        }
        mutableList.remove(this.mSelectedPosition);
        if (mutableList.isEmpty()) {
            onBackEvent();
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setSelectedPosition(data.getSelectedPosition());
        rFWLayerState.setPositionOffset(data.getPositionOffset());
        rFWLayerState.setRichMediaDataList(mutableList);
        rFWLayerState.setMediaSum(mutableList.size());
        rFWLayerState.setSelectedPosition(rFWLayerState.getSelectedPosition() - 1);
        if (rFWLayerState.getSelectedPosition() < 0) {
            rFWLayerState.setSelectedPosition(0);
        }
        o9.e eVar = new o9.e();
        eVar.c(rFWLayerState);
        UIStateData<RFWLayerState> obtainSuccess = UIStateData.obtainSuccess(true);
        Intrinsics.checkNotNullExpressionValue(obtainSuccess, "obtainSuccess(true)");
        eVar.d(obtainSuccess);
        eVar.b().setDataList(rFWLayerState);
        QZoneLayerPostDataEvent qZoneLayerPostDataEvent = new QZoneLayerPostDataEvent(eVar);
        qZoneLayerPostDataEvent.setLayerDeleteEventTrigger(true);
        SimpleEventBus.getInstance().dispatchEvent(qZoneLayerPostDataEvent);
    }

    private final void H9() {
        String qqStr;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        boolean z16 = false;
        if (rFWLayerItemMediaInfo != null && rFWLayerItemMediaInfo.isVideo()) {
            z16 = true;
        }
        if (z16) {
            qqStr = HardCodeUtil.qqStr(R.string.w_6);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.w_5);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, qqStr, (CharSequence) null, HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.layer.part.ce
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                cg.I9(cg.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.layer.part.cf
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                cg.J9(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026)\n            }\n        )");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(cg this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    private final void K9(View rootView) {
        if (this.isShowDelBtn) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.n0k);
            this.deleteIcon = imageView;
            fo.c.n(imageView, WinkDaTongReportConstant.ElementId.EM_QZ_HISTORY_DELETE);
            ImageView imageView2 = this.deleteIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(R.drawable.f14452c);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.cd
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        cg.L9(cg.this, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(cg this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        if (data == null || data.getInt(PictureConst.KEY_DEL_TYPE, 1) != 0) {
            return;
        }
        this.isShowDelBtn = false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            K9(rootView);
        }
    }
}
