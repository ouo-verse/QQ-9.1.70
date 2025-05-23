package p018do;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.qzone.reborn.repair.request.QZoneQueryPermissionsRequest;
import com.qzone.reborn.util.m;
import com.qzone.util.ar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasYellowDiamondPay;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import p018do.i;
import pl.a;
import qzone.SuperResolution$QueryPermissionsRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 M2\u00020\u0001:\u0001NB\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010+R\u0016\u0010/\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010+R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00102R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u00102R\u0016\u0010E\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u00102R\u0016\u0010G\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u00102R\u0018\u0010J\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Ldo/i;", "Landroid/app/Dialog;", "", "d0", "n0", "initView", "x0", "e0", "p0", "c0", "y0", "s0", "j0", "g0", "Lqzone/SuperResolution$QueryPermissionsRsp;", "rsp", "k0", "f0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lwn/b;", "D", "Lwn/b;", "dialogInitBean", "", "E", "I", "DIALOG_HEIGHT", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "halfScreenFloatingView", "Landroid/view/View;", "G", "Landroid/view/View;", "containerView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "repairNumText", "tvPayGuideYellowText", "J", "tvPayGuideBlackText", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "ivYellowDiamondIcon", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "L", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundImageLayout", "M", "imageIcon", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "N", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "repairPhotoBtn", "Landroid/widget/LinearLayout;", "P", "Landroid/widget/LinearLayout;", "llYellowDiamondLayout", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "ivImageQuality", BdhLogUtil.LogTag.Tag_Req, "ivFillColor", ExifInterface.LATITUDE_SOUTH, "ivImageRepair", "T", "Lqzone/SuperResolution$QueryPermissionsRsp;", "queryPermissionRsp", "<init>", "(Landroid/app/Activity;Lwn/b;)V", "U", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: D, reason: from kotlin metadata */
    private final wn.b dialogInitBean;

    /* renamed from: E, reason: from kotlin metadata */
    private final int DIALOG_HEIGHT;

    /* renamed from: F, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView halfScreenFloatingView;

    /* renamed from: G, reason: from kotlin metadata */
    private View containerView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView repairNumText;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView tvPayGuideYellowText;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView tvPayGuideBlackText;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView ivYellowDiamondIcon;

    /* renamed from: L, reason: from kotlin metadata */
    private RoundCorneredFrameLayout roundImageLayout;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView imageIcon;

    /* renamed from: N, reason: from kotlin metadata */
    private QUIButton repairPhotoBtn;

    /* renamed from: P, reason: from kotlin metadata */
    private LinearLayout llYellowDiamondLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView ivImageQuality;

    /* renamed from: R, reason: from kotlin metadata */
    private ImageView ivFillColor;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView ivImageRepair;

    /* renamed from: T, reason: from kotlin metadata */
    private SuperResolution$QueryPermissionsRsp queryPermissionRsp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"do/i$b", "Lcom/tencent/mobileqq/vas/api/IVasYellowDiamondPay$a;", "", "isSuccess", "", "code", "", "msg", "", "onResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements IVasYellowDiamondPay.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(i this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.s0();
        }

        @Override // com.tencent.mobileqq.vas.api.IVasYellowDiamondPay.a
        public void onResult(boolean isSuccess, int code, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d("QZonePhotoRepairHalfScreenDialog", 1, "onResult  isSuccess=" + isSuccess + ", code=" + code + ", msg=" + msg2);
            if (isSuccess) {
                Handler uIHandler = RFWThreadManager.getUIHandler();
                final i iVar = i.this;
                uIHandler.postDelayed(new Runnable() { // from class: do.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.b(i.this);
                    }
                }, 1000L);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"do/i$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c extends e {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF52508d() {
            i iVar = i.this;
            View inflate = LayoutInflater.from(iVar.getContext()).inflate(R.layout.cmv, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026een_content_layout, null)");
            iVar.containerView = inflate;
            i.this.initView();
            View view = i.this.containerView;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            return null;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            if (!a.f426446a.y()) {
                return i.this.DIALOG_HEIGHT;
            }
            return (int) ((ar.e(542.0f) / ar.e(812.0f)) * r0.n(i.this.getContext()));
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Activity activity, wn.b dialogInitBean) {
        super(activity, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dialogInitBean, "dialogInitBean");
        this.activity = activity;
        this.dialogInitBean = dialogInitBean;
        this.DIALOG_HEIGHT = ar.e(542.0f);
    }

    private final void c0() {
        ImageView imageView = this.imageIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "imageIcon.layoutParams");
        a aVar = a.f426446a;
        int o16 = aVar.o(getContext()) - ImmersiveUtils.dpToPx(32.0f);
        layoutParams.width = o16;
        layoutParams.height = (int) (o16 / 1.3611112f);
        if (aVar.y()) {
            int dpToPx = (int) ((ImmersiveUtils.dpToPx(252.0f) / ImmersiveUtils.dpToPx(812.0f)) * aVar.n(getContext()));
            layoutParams.height = dpToPx;
            layoutParams.width = (int) (dpToPx * 1.3611112f);
        }
        ImageView imageView3 = this.imageIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageIcon");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setLayoutParams(layoutParams);
    }

    private final void d0() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setSoftInputMode(19);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QZonePhotoRepairHalfScreenDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    private final void e0() {
        fo.b j3 = new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        QUIButton qUIButton = this.repairPhotoBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairPhotoBtn");
            qUIButton = null;
        }
        fo.c.o(qUIButton, "em_qz_repair_immediately", j3);
    }

    private final void g0() {
        QZoneRepairTaskStateBean qZoneRepairTaskStateBean = new QZoneRepairTaskStateBean(null, 1, null);
        String str = this.dialogInitBean.getCurrentInfo().albumId;
        Intrinsics.checkNotNullExpressionValue(str, "dialogInitBean.currentInfo.albumId");
        qZoneRepairTaskStateBean.setAlbumId(str);
        String str2 = this.dialogInitBean.getCurrentInfo().lloc;
        Intrinsics.checkNotNullExpressionValue(str2, "dialogInitBean.currentInfo.lloc");
        qZoneRepairTaskStateBean.setLloc(str2);
        String str3 = this.dialogInitBean.getCurrentInfo().bigUrl;
        Intrinsics.checkNotNullExpressionValue(str3, "dialogInitBean.currentInfo.bigUrl");
        qZoneRepairTaskStateBean.setSrOriginUrl(str3);
        qZoneRepairTaskStateBean.setSrStatus(0);
        qZoneRepairTaskStateBean.setNeedDoSRReq(Boolean.TRUE);
        ArrayList<PhotoInfo> arrayList = new ArrayList<>();
        arrayList.add(this.dialogInitBean.getCurrentInfo());
        bo.b bVar = (bo.b) ho.i.t(bo.b.class);
        Context context = getContext();
        wn.c cVar = new wn.c();
        cVar.h(this.dialogInitBean.getPhotoParam());
        cVar.n(qZoneRepairTaskStateBean);
        cVar.o(arrayList);
        cVar.m(this.dialogInitBean.getFrom());
        Unit unit = Unit.INSTANCE;
        bVar.a(context, cVar);
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: do.h
            @Override // java.lang.Runnable
            public final void run() {
                i.i0(i.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        View view = this.containerView;
        RoundCorneredFrameLayout roundCorneredFrameLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.njv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.tv_repair_num)");
        this.repairNumText = (TextView) findViewById;
        View view2 = this.containerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.njk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026R.id.tv_pay_guide_yellow)");
        this.tvPayGuideYellowText = (TextView) findViewById2;
        View view3 = this.containerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.njj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026(R.id.tv_pay_guide_black)");
        this.tvPayGuideBlackText = (TextView) findViewById3;
        View view4 = this.containerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.lwn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026d.iv_yellow_diamond_icon)");
        this.ivYellowDiamondIcon = (ImageView) findViewById4;
        View view5 = this.containerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.mg_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.ll_image_layout)");
        this.roundImageLayout = (RoundCorneredFrameLayout) findViewById5;
        View view6 = this.containerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.l9u);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewById(R.id.iv_image_icon)");
        this.imageIcon = (ImageView) findViewById6;
        View view7 = this.containerView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view7 = null;
        }
        View findViewById7 = view7.findViewById(R.id.njz);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewById(R.id.tv_select_button)");
        this.repairPhotoBtn = (QUIButton) findViewById7;
        View view8 = this.containerView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view8 = null;
        }
        View findViewById8 = view8.findViewById(R.id.mgn);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026ll_yellow_diamond_layout)");
        this.llYellowDiamondLayout = (LinearLayout) findViewById8;
        View view9 = this.containerView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view9 = null;
        }
        View findViewById9 = view9.findViewById(R.id.l_i);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewById(R.id.iv_image_quality)");
        this.ivImageQuality = (ImageView) findViewById9;
        View view10 = this.containerView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view10 = null;
        }
        View findViewById10 = view10.findViewById(R.id.l4p);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewById(R.id.iv_fill_color)");
        this.ivFillColor = (ImageView) findViewById10;
        View view11 = this.containerView;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            view11 = null;
        }
        View findViewById11 = view11.findViewById(R.id.f162748la4);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "containerView.findViewById(R.id.iv_image_repair)");
        this.ivImageRepair = (ImageView) findViewById11;
        TextView textView = this.tvPayGuideYellowText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPayGuideYellowText");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: do.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view12) {
                i.q0(i.this, view12);
            }
        });
        ImageView imageView = this.ivYellowDiamondIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivYellowDiamondIcon");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: do.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view12) {
                i.r0(i.this, view12);
            }
        });
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.roundImageLayout;
        if (roundCorneredFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roundImageLayout");
        } else {
            roundCorneredFrameLayout = roundCorneredFrameLayout2;
        }
        roundCorneredFrameLayout.setRadius(ImmersiveUtils.dpToPx(8.0f));
        p0();
        x0();
        e0();
    }

    private final void j0() {
        PBEnumField pBEnumField;
        SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp = this.queryPermissionRsp;
        if (superResolution$QueryPermissionsRsp == null || (pBEnumField = superResolution$QueryPermissionsRsp.pp_pay_type) == null) {
            return;
        }
        ((IVasYellowDiamondPay) QRoute.api(IVasYellowDiamondPay.class)).payFromQzonePhotoRepair(this.activity, pBEnumField.get(), new b());
    }

    private final void k0(SuperResolution$QueryPermissionsRsp rsp) {
        this.queryPermissionRsp = rsp;
        TextView textView = null;
        if (rsp.enable_sr.get()) {
            QUIButton qUIButton = this.repairPhotoBtn;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repairPhotoBtn");
                qUIButton = null;
            }
            qUIButton.o();
            QUIButton qUIButton2 = this.repairPhotoBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repairPhotoBtn");
                qUIButton2 = null;
            }
            qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: do.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.l0(i.this, view);
                }
            });
        } else {
            QUIButton qUIButton3 = this.repairPhotoBtn;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repairPhotoBtn");
                qUIButton3 = null;
            }
            qUIButton3.setBackgroundDisabled();
            QUIButton qUIButton4 = this.repairPhotoBtn;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repairPhotoBtn");
                qUIButton4 = null;
            }
            qUIButton4.setOnClickListener(new View.OnClickListener() { // from class: do.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.m0(i.this, view);
                }
            });
        }
        QUIButton qUIButton5 = this.repairPhotoBtn;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairPhotoBtn");
            qUIButton5 = null;
        }
        qUIButton5.setText(rsp.pp_button_hint.get());
        TextView textView2 = this.repairNumText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairNumText");
            textView2 = null;
        }
        textView2.setText(rsp.rp_middle_hint.get());
        TextView textView3 = this.tvPayGuideYellowText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPayGuideYellowText");
            textView3 = null;
        }
        textView3.setText(rsp.rp_pay_guide_hint1.get());
        TextView textView4 = this.tvPayGuideBlackText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPayGuideBlackText");
        } else {
            textView = textView4;
        }
        textView.setText(rsp.rp_pay_guide_hint2.get());
        f0(rsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n0() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.setDraggable(true);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setQUSDragFloatController(new c());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: do.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                i.o0(i.this);
            }
        });
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView5;
        }
        qUSHalfScreenFloatingView2.j(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void p0() {
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
    public static final void q0(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(i this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        VSNetworkHelper.getInstance().sendRequest(getContext(), new QZoneQueryPermissionsRequest(), new VSDispatchObserver.OnVSRspCallBack() { // from class: do.d
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                i.u0(i.this, baseRequest, z16, j3, str, (SuperResolution$QueryPermissionsRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(final i this$0, BaseRequest baseRequest, boolean z16, long j3, String str, final SuperResolution$QueryPermissionsRsp superResolution$QueryPermissionsRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QZonePhotoRepairHalfScreenDialog", 1, "queryPermissionRequest  | traceId=" + baseRequest.getTraceId() + " | isSuccess=" + z16 + " | retCode=" + j3 + " | errMsg=" + str + " | rsp=" + superResolution$QueryPermissionsRsp);
        if (z16 && j3 == 0 && superResolution$QueryPermissionsRsp != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: do.e
                @Override // java.lang.Runnable
                public final void run() {
                    i.w0(i.this, superResolution$QueryPermissionsRsp);
                }
            });
            QLog.i("QZonePhotoRepairHalfScreenDialog", 1, "queryPermissionRequest rsp data | rsp.enable_sr=" + superResolution$QueryPermissionsRsp.enable_sr.get() + " | rsp.pp_button_hint=" + superResolution$QueryPermissionsRsp.pp_button_hint.get() + " | rsp.pp_bottom_hint1=" + superResolution$QueryPermissionsRsp.pp_bottom_hint1.get() + " | rsp.pp_bottom_hint2=" + superResolution$QueryPermissionsRsp.pp_bottom_hint2.get() + " | rsp.rp_pay_type=" + superResolution$QueryPermissionsRsp.rp_pay_type.get() + " | rsp.pp_pay_type=" + superResolution$QueryPermissionsRsp.pp_pay_type.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(i this$0, SuperResolution$QueryPermissionsRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        this$0.k0(rsp);
    }

    private final void x0() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        VideoReport.setPageId(qUSHalfScreenFloatingView, "pg_qz_pic_repair_float");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, "2");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView3;
        }
        VideoReport.setPageParams(qUSHalfScreenFloatingView2, new fo.a().d("QZonePhotoRepairHalfScreenDialog", linkedHashMap));
    }

    private final void y0() {
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

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d0();
        setContentView(R.layout.cmw);
        View findViewById = findViewById(R.id.miy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qus_floating_half_screen)");
        this.halfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        n0();
        c0();
        y0();
    }

    private final void f0(SuperResolution$QueryPermissionsRsp rsp) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.FUNCTION_STATE, Integer.valueOf(rsp.pp_pay_type.get())));
        fo.b k3 = new fo.b().l(mutableMapOf).k(ExposurePolicy.REPORT_NONE);
        LinearLayout linearLayout = this.llYellowDiamondLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llYellowDiamondLayout");
            linearLayout = null;
        }
        fo.c.o(linearLayout, WinkDaTongReportConstant.ElementId.EM_QZ_OPEN_YELLOW_DIAMOND, k3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"do/i$d", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$p;", "", "onShowTotalStart", "onShowTotal", "onShowDefaultStart", "onShowDefault", "onShowMinStart", "onShowMin", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements QUSBaseHalfScreenFloatingView.p {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            i.this.s0();
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefaultStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMinStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
        }
    }
}
