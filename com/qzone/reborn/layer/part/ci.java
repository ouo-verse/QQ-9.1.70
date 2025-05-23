package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.common.business.service.media.QZoneQCircleMediaImpl;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.reborn.layer.route.QZoneLocalLayerExtraInfoBean;
import com.qzone.util.ToastUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import common.config.service.QzoneConfig;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/qzone/reborn/layer/part/ci;", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "Lcom/qzone/reborn/layer/route/QZoneLocalLayerExtraInfoBean;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "F9", "Lcooperation/qzone/model/PhotoInfo;", "photoInfo", "", "I9", "J9", "E9", "H9", "Landroid/os/Bundle;", "data", "initIntentData", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", tl.h.F, "Landroid/view/View;", "editRoot", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "editText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isShowEditBtn", "Lcom/tencent/mobileqq/widget/tip/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/tip/a;", "showGuidePopup", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ci extends com.qzone.reborn.albumx.common.layer.part.i<QZoneLocalLayerExtraInfoBean> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.tip.a showGuidePopup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View editRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView editText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isShowEditBtn = true;

    private final void E9() {
        if (!QZoneQCircleMediaImpl.w()) {
            ToastUtil.s("\u7f16\u8f91\u5668\u6682\u4e0d\u53ef\u7528", 4);
            return;
        }
        Bundle extras = getActivity().getIntent().getExtras();
        String string = extras != null ? extras.getString("RECEIVE_DATA_CLASS_NAME") : null;
        RFWLog.d("QZoneLocalLayerEditPart", RFWLog.USR, "editor result will back to " + string);
        com.qzone.common.business.service.b f16 = com.qzone.common.business.service.b.f();
        Activity activity = getActivity();
        QZoneLocalLayerExtraInfoBean x95 = x9();
        f16.k(activity, x95 != null ? x95.getPhotoInfo() : null, QZoneMediaBusiness.QZONE_ALBUM_PERVIEW, 1);
    }

    private final void F9(View rootView) {
        TextView textView = new TextView(rootView.getContext());
        textView.setText(HardCodeUtil.qqStr(R.string.w9p));
        textView.setTextSize(16.0f);
        textView.setTextColor(textView.getResources().getColorStateList(R.color.f158017al3));
        textView.setGravity(16);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.editText = textView;
        FrameLayout frameLayout = new FrameLayout(rootView.getContext());
        frameLayout.setBackground(null);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.ch
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ci.G9(ci.this, view);
            }
        });
        this.editRoot = frameLayout;
        fo.c.n(frameLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_EDIT);
        View view = this.editRoot;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) view).addView(this.editText);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388691;
        com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
        layoutParams.setMarginStart(rVar.e(16));
        layoutParams.bottomMargin = rVar.e(30);
        ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
        if (viewGroup != null) {
            viewGroup.addView(this.editRoot, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(ci this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void H9() {
        Boolean bool;
        PhotoInfo photoInfo;
        QZoneLocalLayerExtraInfoBean x95 = x9();
        boolean z16 = true;
        if (x95 == null || (photoInfo = x95.getPhotoInfo()) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf((photoInfo.isVideo() || I9(photoInfo)) ? false : true);
        }
        if (this.isShowEditBtn && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            int g16 = com.qzone.reborn.util.i.b().g("KEY_SHOW_GUIDE_POPUP_TIMES", 0);
            long h16 = com.qzone.reborn.util.i.b().h("KEY_SHOW_GUIDE_POPUP_TIMESTAMP", 0L);
            long j3 = 604800000 + h16;
            if (g16 >= 3 || (h16 > 0 && j3 > System.currentTimeMillis())) {
                z16 = false;
            } else {
                com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(getContext());
                this.showGuidePopup = r16;
                if (r16 != null) {
                    r16.n0(12);
                }
                com.tencent.mobileqq.widget.tip.a aVar = this.showGuidePopup;
                Intrinsics.checkNotNull(aVar);
                aVar.o0("AI\u6d88\u9664\u9080\u4f60\u4f53\u9a8c\uff5e").S(this.editText).k0(0).R(0).m0(4).s0();
                com.qzone.reborn.util.i.b().o("KEY_SHOW_GUIDE_POPUP_TIMES", g16 + 1);
                com.qzone.reborn.util.i.b().p("KEY_SHOW_GUIDE_POPUP_TIMESTAMP", System.currentTimeMillis());
            }
            com.qzone.reborn.util.i.b().l(QQWinkConstants.KEY_IS_SHOW_ELIMINATE_GUIDE_POPUP_FROM_QZONE, z16);
        }
    }

    private final boolean I9(PhotoInfo photoInfo) {
        if (!photoInfo.isVideo()) {
            float f16 = photoInfo.heightWeightProportion;
            if (!(0.4f <= f16 && f16 <= 2.6666667f) || photoInfo.photoType == 2) {
                return true;
            }
        }
        return false;
    }

    private final boolean J9(PhotoInfo photoInfo) {
        VideoInfo videoInfo = photoInfo.videodata;
        if (videoInfo == null || videoInfo.toast == null) {
            return false;
        }
        return photoInfo.videodata.toast.equals(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "Composing", "\u6b63\u5728\u5408\u6210..."));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        if (data == null || data.getInt(PictureConst.KEY_EDIT_BTN_TYPE, 0) != 1) {
            return;
        }
        this.isShowEditBtn = false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            F9(rootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        PhotoInfo photoInfo;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        if (x9() == null) {
            return;
        }
        if (!this.isShowEditBtn) {
            View view = this.editRoot;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        QZoneLocalLayerExtraInfoBean x95 = x9();
        if (x95 == null || (photoInfo = x95.getPhotoInfo()) == null) {
            return;
        }
        if (!J9(photoInfo) && !I9(photoInfo)) {
            View view2 = this.editRoot;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(0);
            return;
        }
        View view3 = this.editRoot;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        H9();
    }
}
