package com.qzone.reborn.repair.part.layer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModel;
import com.qzone.business.share.ShareUtils;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/qzone/reborn/repair/part/layer/ah;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "C9", "view", "J9", "initViewModel", "E9", "N9", "", "which", "G9", "D9", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "P9", "", "", "F9", "I9", "arkContent", "Q9", "H9", "onInitView", "", "onBackEvent", "d", "Landroid/view/View;", "mTitleView", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mTitleContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mBackView", tl.h.F, "mMoreView", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "i", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ah extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mTitleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mTitleContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mBackView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mMoreView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    private final void C9(View rootView) {
        View view = null;
        View inflate = LayoutInflater.from(rootView.getContext()).inflate(R.layout.f167314cn3, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(rootView.context)\n \u2026layer_title_layout, null)");
        this.mTitleView = inflate;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 48;
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View view2 = this.mTitleView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
            view2 = null;
        }
        viewGroup.addView(view2, layoutParams);
        View view3 = this.mTitleView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
        } else {
            view = view3;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams2).topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
    }

    private final void D9(View rootView) {
        Intent intent;
        VideoReport.setPageId(rootView, "pg_qz_pic_preview");
        HashMap hashMap = new HashMap();
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(intent.getIntExtra(PictureConst.PARAM_FROM, 0)));
        }
        VideoReport.setPageParams(rootView, new fo.a().d("QZonePhotoRepairLayerTitlePart", hashMap));
    }

    private final void E9() {
        fo.b j3 = new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        ImageView imageView = this.mBackView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackView");
            imageView = null;
        }
        fo.c.o(imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, j3);
        ImageView imageView3 = this.mMoreView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
        } else {
            imageView2 = imageView3;
        }
        fo.c.o(imageView2, "em_qz_more", j3);
    }

    private final List<String> F9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_qz_more_share");
        arrayList.add("em_qz_more_report");
        return arrayList;
    }

    private final void H9() {
        vo.c.G(getActivity());
    }

    private final void I9() {
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this.mPhotoRepairViewModel;
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel2 = null;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        String value = qZonePhotoRepairLayerViewModel.o2().getValue();
        if (TextUtils.isEmpty(value)) {
            QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel3 = this.mPhotoRepairViewModel;
            if (qZonePhotoRepairLayerViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            } else {
                qZonePhotoRepairLayerViewModel2 = qZonePhotoRepairLayerViewModel3;
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            qZonePhotoRepairLayerViewModel2.p2(context);
            return;
        }
        Intrinsics.checkNotNull(value);
        Q9(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(ah this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(ah this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(ah this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this$0.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        if (qZonePhotoRepairLayerViewModel.getInitSrStatus() == null) {
            QQToastUtil.showQQToast(2, com.qzone.util.l.a(R.string.wac));
        }
    }

    private final void N9() {
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        qZonePhotoRepairLayerViewModel.p2(context);
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        final ActionSheet actionSheet = createDialog instanceof ActionSheet ? (ActionSheet) createDialog : null;
        if (actionSheet != null) {
            actionSheet.addButton(R.string.wal);
            actionSheet.addButton(R.string.wa6);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.repair.part.layer.ag
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    ah.O9(ActionSheet.this, this, view, i3);
                }
            });
            ef.d.f(actionSheet, getActivity());
            LinearLayout linearLayout = actionSheet.mContentContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "this.mContentContainer");
            D9(linearLayout);
            P9(actionSheet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(ActionSheet this_apply, ah this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_apply.dismiss();
        this$0.G9(i3);
    }

    private final void P9(ActionSheet actionSheet) {
        int size = F9().size();
        LinearLayout linearLayout = actionSheet.mContentContainer;
        if (linearLayout.getChildCount() < size) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            fo.c.o(linearLayout.getChildAt(i3), F9().get(i3), new fo.b().j(EndExposurePolicy.REPORT_NONE));
        }
    }

    private final void Q9(String arkContent) {
        ShareUtils.e eVar = new ShareUtils.e();
        eVar.f44740a = "https://ti.qq.com/open_qq/index.html?v=40517&hb=1&ac=1&url=mqzone%3A%2F%2Farouse%2Fphotorepair%2Fmainpage";
        eVar.f44711h = 2;
        eVar.f44743d = "https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/retouch_photo@2x.png";
        eVar.f44712i = QZoneShareManager.QQ_SHARE_APPID;
        eVar.f44713j = 1;
        eVar.f44714k = com.qzone.util.l.a(R.string.gg_);
        eVar.f44741b = com.qzone.util.l.a(R.string.waf);
        eVar.f44715l = true;
        eVar.b(arkContent, "", eVar.a(arkContent));
        ShareUtils.n(getActivity(), eVar, 0);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        this.mPhotoRepairViewModel = (QZonePhotoRepairLayerViewModel) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Integer status;
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this.mPhotoRepairViewModel;
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel2 = null;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        QZonePhotoRepairLayerViewModel.Companion.RepairStatusData value = qZonePhotoRepairLayerViewModel.n2().getValue();
        boolean z16 = false;
        if (value != null && (status = value.getStatus()) != null && status.intValue() == 0) {
            z16 = true;
        }
        if (z16) {
            QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel3 = this.mPhotoRepairViewModel;
            if (qZonePhotoRepairLayerViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
                qZonePhotoRepairLayerViewModel3 = null;
            }
            if (!qZonePhotoRepairLayerViewModel3.k2().getIsSilentRepair()) {
                QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel4 = this.mPhotoRepairViewModel;
                if (qZonePhotoRepairLayerViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
                } else {
                    qZonePhotoRepairLayerViewModel2 = qZonePhotoRepairLayerViewModel4;
                }
                qZonePhotoRepairLayerViewModel2.w2();
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.part.layer.af
                    @Override // java.lang.Runnable
                    public final void run() {
                        ah.M9(ah.this);
                    }
                });
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        C9(rootView);
        J9(rootView);
        initViewModel();
    }

    private final void J9(View view) {
        View findViewById = view.findViewById(R.id.naq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qzone_repair_layer_title)");
        this.mTitleContainer = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.n_v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.q\u2026e_repair_layer_back_icon)");
        this.mBackView = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.na9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.q\u2026e_repair_layer_more_icon)");
        this.mMoreView = (ImageView) findViewById3;
        ImageView imageView = this.mBackView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.part.layer.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ah.K9(ah.this, view2);
            }
        });
        ImageView imageView3 = this.mMoreView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoreView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.part.layer.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ah.L9(ah.this, view2);
            }
        });
        E9();
    }

    private final void G9(int which) {
        if (which == 0) {
            I9();
        } else {
            if (which != 1) {
                return;
            }
            H9();
        }
    }
}
