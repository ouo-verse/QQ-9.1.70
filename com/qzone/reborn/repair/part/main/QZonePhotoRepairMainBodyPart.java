package com.qzone.reborn.repair.part.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.base.k;
import com.qzone.reborn.repair.bean.QZonePhotoRepairMainInitBean;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.part.main.QZonePhotoRepairMainBodyPart;
import com.qzone.reborn.repair.utils.QZonePhotoRepairQNESingletonVM;
import com.qzone.reborn.repair.utils.QZonePhotoRepairTaskQueueManger;
import com.qzone.reborn.repair.viewmodel.l;
import com.qzone.reborn.util.m;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaMimeType;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import ho.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import qzone.SuperResolution$QueryPermissionsRsp;
import tl.h;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 W2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001XB\u0007\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J&\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\"\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u00109R\u0016\u0010H\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u00109R\u0016\u0010J\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u00109R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\u00a8\u0006Y"}, d2 = {"Lcom/qzone/reborn/repair/part/main/QZonePhotoRepairMainBodyPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View$OnClickListener;", "Lxn/d;", "", "F9", "K9", "initViewModel", "E9", "N9", "Lqzone/SuperResolution$QueryPermissionsRsp;", "permissionRsp", "J9", "I9", "H9", "", "selectAlbumId", "selectLloc", "selectUrl", "G9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "v", NodeProps.ON_CLICK, "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "taskBean", "B3", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/qzone/reborn/repair/viewmodel/l;", "d", "Lcom/qzone/reborn/repair/viewmodel/l;", "photoRepairViewModel", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "repairNumText", "f", "tvPayGuideYellowText", h.F, "tvPayGuideBlackText", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "ivYellowDiamondIcon", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundImageLayout", BdhLogUtil.LogTag.Tag_Conn, "imageIcon", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "D", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "selectPhotoBtn", "E", "ivImageQuality", UserInfo.SEX_FEMALE, "ivFillColor", "G", "ivImageRepair", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "userAgreementLayout", "", "I", "Lkotlin/Lazy;", "M9", "()Z", "isSupportOpr", "<init>", "()V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePhotoRepairMainBodyPart extends k implements View.OnClickListener, xn.d {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView imageIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private QUIButton selectPhotoBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView ivImageQuality;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView ivFillColor;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView ivImageRepair;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout userAgreementLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy isSupportOpr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private l photoRepairViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView repairNumText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvPayGuideYellowText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvPayGuideBlackText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivYellowDiamondIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout roundImageLayout;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/repair/part/main/QZonePhotoRepairMainBodyPart$b", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "", "isSuccess", "", "code", "", "msg", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IVasYellowDiamondPay.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QZonePhotoRepairMainBodyPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            l lVar = this$0.photoRepairViewModel;
            if (lVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoRepairViewModel");
                lVar = null;
            }
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            lVar.S1(context);
        }

        @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
        public void onResult(boolean isSuccess, int code, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d("QZonePhotoRepairMainBodyPart", 1, "onResult  isSuccess=" + isSuccess + ", code=" + code + ", msg=" + msg2);
            if (isSuccess) {
                Handler uIHandler = RFWThreadManager.getUIHandler();
                final QZonePhotoRepairMainBodyPart qZonePhotoRepairMainBodyPart = QZonePhotoRepairMainBodyPart.this;
                uIHandler.postDelayed(new Runnable() { // from class: com.qzone.reborn.repair.part.main.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZonePhotoRepairMainBodyPart.b.b(QZonePhotoRepairMainBodyPart.this);
                    }
                }, 1000L);
            }
        }
    }

    public QZonePhotoRepairMainBodyPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.qzone.reborn.repair.part.main.QZonePhotoRepairMainBodyPart$isSupportOpr$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(QZonePhotoRepairQNESingletonVM.f59266a.k());
            }
        });
        this.isSupportOpr = lazy;
    }

    private final void E9() {
        ImageView imageView = this.imageIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "imageIcon.layoutParams");
        int o16 = pl.a.f426446a.o(getContext()) - ImmersiveUtils.dpToPx(32.0f);
        layoutParams.width = o16;
        layoutParams.height = (int) (o16 / 1.3611112f);
        ImageView imageView3 = this.imageIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setLayoutParams(layoutParams);
    }

    private final void F9() {
        fo.b j3 = new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        QUIButton qUIButton = this.selectPhotoBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPhotoBtn");
            qUIButton = null;
        }
        fo.c.o(qUIButton, "em_qz_pic_choose", j3);
    }

    private final void G9(String selectAlbumId, String selectLloc, String selectUrl) {
        l lVar = null;
        QZoneRepairTaskStateBean qZoneRepairTaskStateBean = new QZoneRepairTaskStateBean(null, 1, null);
        if (selectAlbumId == null) {
            selectAlbumId = "";
        }
        qZoneRepairTaskStateBean.setAlbumId(selectAlbumId);
        if (selectLloc == null) {
            selectLloc = "";
        }
        qZoneRepairTaskStateBean.setLloc(selectLloc);
        if (selectUrl == null) {
            selectUrl = "";
        }
        qZoneRepairTaskStateBean.setSrOriginUrl(selectUrl);
        ArrayList<PhotoInfo> arrayList = new ArrayList<>();
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.albumId = qZoneRepairTaskStateBean.getAlbumId();
        photoInfo.lloc = qZoneRepairTaskStateBean.getLloc();
        photoInfo.currentUrl = qZoneRepairTaskStateBean.getSrOriginUrl();
        arrayList.add(photoInfo);
        PhotoParam photoParam = new PhotoParam();
        photoParam.albumid = qZoneRepairTaskStateBean.getAlbumId();
        photoParam.ownerUin = LoginData.getInstance().getUin();
        bo.b bVar = (bo.b) i.t(bo.b.class);
        Activity activity = getActivity();
        wn.c cVar = new wn.c();
        cVar.h(photoParam);
        cVar.n(qZoneRepairTaskStateBean);
        cVar.o(arrayList);
        l lVar2 = this.photoRepairViewModel;
        if (lVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoRepairViewModel");
        } else {
            lVar = lVar2;
        }
        QZonePhotoRepairMainInitBean initBean = lVar.getInitBean();
        cVar.m(initBean != null ? initBean.getFrom() : 0);
        Unit unit = Unit.INSTANCE;
        bVar.a(activity, cVar);
    }

    private final void H9() {
        List<? extends MediaMimeType> listOf;
        Intent intent = new Intent();
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        intent.putExtra(QCircleScheme.AttrQQPublish.QZONE_ALBUM_IMAGE_PICKER_TITLE, "\u9009\u62e9\u7167\u7247");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.j(1);
        TabType tabType = TabType.ONLY_IMAGE;
        aVar.m(tabType);
        aVar.i(tabType);
        MediaFilter.Companion companion2 = MediaFilter.INSTANCE;
        MediaFilter.a aVar2 = new MediaFilter.a();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MediaMimeType[]{MediaMimeType.IMAGE_JPEG, MediaMimeType.IMAGE_PNG, MediaMimeType.IMAGE_WEBP, MediaMimeType.IMAGE_HEIF});
        aVar2.f(listOf);
        aVar2.d(5000);
        aVar2.b(5000);
        aVar.o(aVar2.a());
        Unit unit = Unit.INSTANCE;
        intent.putExtra("WINK_MEDIA_PICKER_CONFIG", aVar.a());
        intent.putExtra("WINK_MEDIA_PICKER_INIT_BEAN", new QZoneInitBean(false, 0, 0, false, 0, 0, 0, false, null, false, false, true, false, 4983, null));
        IQQWinkLauncher iQQWinkLauncher = (IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iQQWinkLauncher.jumpToQZonePickerFragment(context, intent, 2000);
    }

    private final void I9() {
        PBEnumField pBEnumField;
        l lVar = this.photoRepairViewModel;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoRepairViewModel");
            lVar = null;
        }
        SuperResolution$QueryPermissionsRsp value = lVar.P1().getValue();
        if (value == null || (pBEnumField = value.rp_pay_type) == null) {
            return;
        }
        IVasYellowDiamondPay iVasYellowDiamondPay = (IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        iVasYellowDiamondPay.payFromQzonePhotoRepair(activity, pBEnumField.get(), new b());
    }

    private final void J9(SuperResolution$QueryPermissionsRsp permissionRsp) {
        Map<String, Object> mutableMapOf;
        l lVar = this.photoRepairViewModel;
        ImageView imageView = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoRepairViewModel");
            lVar = null;
        }
        if (lVar.Q1()) {
            QUIButton qUIButton = this.selectPhotoBtn;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectPhotoBtn");
                qUIButton = null;
            }
            qUIButton.o();
        } else {
            QUIButton qUIButton2 = this.selectPhotoBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectPhotoBtn");
                qUIButton2 = null;
            }
            qUIButton2.setBackgroundDisabled();
        }
        TextView textView = this.repairNumText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairNumText");
            textView = null;
        }
        textView.setText(permissionRsp.rp_middle_hint.get());
        TextView textView2 = this.tvPayGuideYellowText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPayGuideYellowText");
            textView2 = null;
        }
        textView2.setText(permissionRsp.rp_pay_guide_hint1.get());
        TextView textView3 = this.tvPayGuideBlackText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPayGuideBlackText");
            textView3 = null;
        }
        textView3.setText(permissionRsp.rp_pay_guide_hint2.get());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.FUNCTION_STATE, Integer.valueOf(permissionRsp.rp_pay_type.get())));
        fo.b k3 = new fo.b().l(mutableMapOf).k(ExposurePolicy.REPORT_NONE);
        TextView textView4 = this.tvPayGuideYellowText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPayGuideYellowText");
            textView4 = null;
        }
        fo.c.o(textView4, WinkDaTongReportConstant.ElementId.EM_QZ_OPEN_YELLOW_DIAMOND, k3);
        ImageView imageView2 = this.ivYellowDiamondIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivYellowDiamondIcon");
        } else {
            imageView = imageView2;
        }
        fo.c.o(imageView, WinkDaTongReportConstant.ElementId.EM_QZ_OPEN_YELLOW_DIAMOND, k3);
    }

    private final void K9() {
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView = this.ivImageQuality;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageQuality");
            imageView = null;
        }
        a16.m(imageView, getContext().getColor(R.color.qui_common_icon_secondary));
        com.tencent.mobileqq.qzone.picload.c a17 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView3 = this.ivFillColor;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivFillColor");
            imageView3 = null;
        }
        a17.m(imageView3, getContext().getColor(R.color.qui_common_icon_secondary));
        com.tencent.mobileqq.qzone.picload.c a18 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView4 = this.ivImageRepair;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivImageRepair");
        } else {
            imageView2 = imageView4;
        }
        a18.m(imageView2, getContext().getColor(R.color.qui_common_icon_secondary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QZonePhotoRepairMainBodyPart this$0, SuperResolution$QueryPermissionsRsp it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.J9(it);
    }

    private final boolean M9() {
        return ((Boolean) this.isSupportOpr.getValue()).booleanValue();
    }

    private final void N9() {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/retouch_photo@2x.png");
        ImageView imageView = this.imageIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
            imageView = null;
        }
        e16.setTargetView(imageView);
        ImageView imageView3 = this.imageIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
            imageView3 = null;
        }
        if (imageView3.getLayoutParams() != null) {
            ImageView imageView4 = this.imageIcon;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
                imageView4 = null;
            }
            e16.setRequestWidth(imageView4.getLayoutParams().width);
            ImageView imageView5 = this.imageIcon;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
                imageView5 = null;
            }
            e16.setRequestHeight(imageView5.getLayoutParams().height);
        }
        m mVar = m.f59551a;
        ImageView imageView6 = this.imageIcon;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
            imageView6 = null;
        }
        e16.setLoadingDrawable(mVar.b(imageView6.getContext()));
        ImageView imageView7 = this.imageIcon;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
        } else {
            imageView2 = imageView7;
        }
        e16.setFailedDrawable(mVar.a(imageView2.getContext()));
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(l.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026airViewModel::class.java)");
        l lVar = (l) viewModel;
        this.photoRepairViewModel = lVar;
        l lVar2 = null;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoRepairViewModel");
            lVar = null;
        }
        lVar.P1().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.repair.part.main.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePhotoRepairMainBodyPart.L9(QZonePhotoRepairMainBodyPart.this, (SuperResolution$QueryPermissionsRsp) obj);
            }
        });
        l lVar3 = this.photoRepairViewModel;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoRepairViewModel");
        } else {
            lVar2 = lVar3;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        lVar2.S1(context);
    }

    @Override // xn.d
    public void B3(QZoneRepairTaskStateBean taskBean) {
        Integer srStatus;
        Integer srStatus2;
        Intrinsics.checkNotNullParameter(taskBean, "taskBean");
        Integer srStatus3 = taskBean.getSrStatus();
        l lVar = null;
        if ((srStatus3 == null || srStatus3.intValue() != 0) && ((srStatus = taskBean.getSrStatus()) == null || srStatus.intValue() != 3)) {
            if (M9() && (srStatus2 = taskBean.getSrStatus()) != null && srStatus2.intValue() == 1) {
                l lVar2 = this.photoRepairViewModel;
                if (lVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photoRepairViewModel");
                } else {
                    lVar = lVar2;
                }
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                lVar.S1(context);
                return;
            }
            return;
        }
        l lVar3 = this.photoRepairViewModel;
        if (lVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoRepairViewModel");
        } else {
            lVar = lVar3;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        lVar.S1(context2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LocalMediaInfo localMediaInfo;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 2000) {
            ArrayList parcelableArrayListExtra = data != null ? data.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA) : null;
            if (bl.b(parcelableArrayListExtra)) {
                QLog.w("QZonePhotoRepairMainBodyPart", 1, "onActivityResult mediaInfoList == null");
                return;
            }
            if (((parcelableArrayListExtra == null || (localMediaInfo = (LocalMediaInfo) parcelableArrayListExtra.get(0)) == null) ? null : localMediaInfo.extData) == null) {
                QLog.w("QZonePhotoRepairMainBodyPart", 1, "onActivityResult extData !is HashMap");
                return;
            }
            HashMap<String, Serializable> hashMap = ((LocalMediaInfo) parcelableArrayListExtra.get(0)).extData;
            String str = (String) (hashMap != null ? hashMap.get("extAlbumId") : null);
            HashMap<String, Serializable> hashMap2 = ((LocalMediaInfo) parcelableArrayListExtra.get(0)).extData;
            String str2 = (String) (hashMap2 != null ? hashMap2.get("extQZonePhotoId") : null);
            HashMap<String, Serializable> hashMap3 = ((LocalMediaInfo) parcelableArrayListExtra.get(0)).extData;
            String str3 = (String) (hashMap3 != null ? hashMap3.get("extDownloadUrl") : null);
            QLog.w("QZonePhotoRepairMainBodyPart", 1, "onActivityResult albumId=" + str + ", lloc=" + str2 + ", srcUrl=" + str3);
            G9(str, str2, str3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        l lVar = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.njz) {
            l lVar2 = this.photoRepairViewModel;
            if (lVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoRepairViewModel");
            } else {
                lVar = lVar2;
            }
            if (lVar.Q1()) {
                H9();
            } else {
                I9();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.nkw) {
            i.q(getContext(), "https://rule.tencent.com/rule/202407050001");
        } else {
            boolean z16 = true;
            if ((valueOf == null || valueOf.intValue() != R.id.njk) && (valueOf == null || valueOf.intValue() != R.id.lwn)) {
                z16 = false;
            }
            if (z16) {
                I9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.i("QZonePhotoRepairMainBodyPart", 1, "[onConfigurationChanged] orientation=" + (configuration != null ? Integer.valueOf(configuration.orientation) : null));
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.njv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_repair_num)");
        this.repairNumText = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.njk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_pay_guide_yellow)");
        this.tvPayGuideYellowText = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.njj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_pay_guide_black)");
        this.tvPayGuideBlackText = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.lwn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.iv_yellow_diamond_icon)");
        this.ivYellowDiamondIcon = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.mg_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.ll_image_layout)");
        this.roundImageLayout = (RoundCorneredFrameLayout) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.l9u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.iv_image_icon)");
        this.imageIcon = (ImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.njz);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.tv_select_button)");
        this.selectPhotoBtn = (QUIButton) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.l_i);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.iv_image_quality)");
        this.ivImageQuality = (ImageView) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.l4p);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.id.iv_fill_color)");
        this.ivFillColor = (ImageView) findViewById9;
        View findViewById10 = rootView.findViewById(R.id.f162748la4);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.id.iv_image_repair)");
        this.ivImageRepair = (ImageView) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.nkw);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.id.user_agreement_layout)");
        this.userAgreementLayout = (LinearLayout) findViewById11;
        QUIButton qUIButton = this.selectPhotoBtn;
        RoundCorneredFrameLayout roundCorneredFrameLayout = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectPhotoBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(this);
        LinearLayout linearLayout = this.userAgreementLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAgreementLayout");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        TextView textView = this.tvPayGuideYellowText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPayGuideYellowText");
            textView = null;
        }
        textView.setOnClickListener(this);
        ImageView imageView = this.ivYellowDiamondIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivYellowDiamondIcon");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.roundImageLayout;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roundImageLayout");
        } else {
            roundCorneredFrameLayout = roundCorneredFrameLayout2;
        }
        roundCorneredFrameLayout.setRadius(ImmersiveUtils.dpToPx(8.0f));
        K9();
        initViewModel();
        E9();
        N9();
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().I(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZonePhotoRepairTaskQueueManger.INSTANCE.a().P(this);
    }
}
