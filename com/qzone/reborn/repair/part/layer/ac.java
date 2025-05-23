package com.qzone.reborn.repair.part.layer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.detail.ui.component.g;
import com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart;
import com.qzone.reborn.repair.viewmodel.QZonePhotoRepairLayerViewModel;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.util.QQToastUtil;
import com.tenpay.sdk.util.UinConfigManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.model.PhotoInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J+\u0010\u0018\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u001fH\u0014J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0014J\b\u0010$\u001a\u00020#H\u0014J\u0012\u0010'\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010(\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010)\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010*\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010+\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010,\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0014J\u0012\u0010-\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010%H\u0014J\"\u00102\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u000100H\u0016J\b\u00104\u001a\u000203H\u0014J\b\u00105\u001a\u000203H\u0014J\b\u00106\u001a\u000203H\u0014J\b\u00107\u001a\u000203H\u0014J\u001c\u0010;\u001a\u0002032\b\u00109\u001a\u0004\u0018\u0001082\b\u0010:\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010=\u001a\u0002032\u0006\u0010<\u001a\u000203H\u0014J\b\u0010>\u001a\u000203H\u0014J\b\u0010?\u001a\u000203H\u0014J\b\u0010@\u001a\u000203H\u0014R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0018\u0010P\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010JR\u0018\u0010T\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u0018\u0010V\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010OR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010OR\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010d\u00a8\u0006j"}, d2 = {"Lcom/qzone/reborn/repair/part/layer/ac;", "Lcom/qzone/reborn/layer/part/QZoneFeedxLayerSharePart;", "Lxn/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "ib", "initViewModel", "gb", "containerView", UinConfigManager.KEY_HB, "eb", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$RFWPicInfo;", "picInfo", "lb", "Landroid/widget/ImageView;", "preview", "", "url", "bb", "view", "", "realWidth", "realHeight", "jb", "(Landroid/view/View;ILjava/lang/Integer;)V", "Landroid/graphics/Bitmap;", "fb", "onInitView", "v", NodeProps.ON_CLICK, "Lcom/qzone/detail/ui/component/g;", "ma", "j4", "w1", "Lcom/qzone/reborn/layer/share/f;", "ta", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Aa", "Fa", "Ga", "za", "Da", "Ea", "Ca", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "X9", "Ka", "ca", "da", "Lcom/tencent/mobileqq/ocr/api/IOCRService;", "iocrService", "uin", "Z9", QzoneConfig.SECONDARY_PHOTOVIEW_CAN_SHOW_DELETE_BUTTON, "V9", "aa", "W9", "Y9", "Landroid/widget/LinearLayout;", "d0", "Landroid/widget/LinearLayout;", "mShareBtn", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "e0", "Lcom/qzone/reborn/repair/viewmodel/QZonePhotoRepairLayerViewModel;", "mPhotoRepairViewModel", "f0", "Landroid/view/View;", "mPreviewView", "g0", "mPreviewContainerView", "h0", "Landroid/widget/ImageView;", "mPreviewBigPicView", "i0", "mPreviewSmallAreaView", "j0", "mPreviewSmallPicView", "k0", "mPreviewLogoView", "Landroid/view/ViewGroup;", "l0", "Landroid/view/ViewGroup;", "mPreviewPicArea", "m0", "mPreviewBottomArea", "n0", "mPreviewQRCodeBg", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "o0", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "mPreviewQRCodeView", "p0", "Landroid/graphics/Bitmap;", "mShotViewBitmap", "<init>", "()V", "q0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ac extends QZoneFeedxLayerSharePart implements xn.b {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mShareBtn;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private QZonePhotoRepairLayerViewModel mPhotoRepairViewModel;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private View mPreviewView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private View mPreviewContainerView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private ImageView mPreviewBigPicView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private View mPreviewSmallAreaView;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private ImageView mPreviewSmallPicView;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private ImageView mPreviewLogoView;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mPreviewPicArea;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mPreviewBottomArea;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private ImageView mPreviewQRCodeBg;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private QUIColorfulQRCodeView mPreviewQRCodeView;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private Bitmap mShotViewBitmap;

    private final void bb(final ImageView preview, String url) {
        if (!TextUtils.isEmpty(url) && preview != null) {
            Option url2 = Option.obtain().setUrl(url);
            url2.setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(url2));
            url2.setTargetView(preview);
            com.qzone.reborn.util.m mVar = com.qzone.reborn.util.m.f59551a;
            url2.setLoadingDrawable(mVar.b(getContext()));
            url2.setFailDrawable(mVar.a(getContext()));
            if (preview.getLayoutParams() != null) {
                url2.setRequestWidth(preview.getLayoutParams().width);
                url2.setRequestHeight(preview.getLayoutParams().height);
            }
            com.tencent.mobileqq.qzone.picload.c.a().i(url2, new IPicLoadStateListener() { // from class: com.qzone.reborn.repair.part.layer.ab
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    ac.cb(preview, loadState, option);
                }
            });
            return;
        }
        QLog.e("QZonePhotoRepairLayerSharePart", 1, "[bindPreviewView] url:" + url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cb(ImageView imageView, LoadState state, Option option) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!state.isFinishSuccess() || option == null) {
            QLog.e("QZonePhotoRepairLayerSharePart", 1, "[loadImage] fail:" + state + " url:" + (option != null ? option.getUrl() : null));
        }
        Intrinsics.checkNotNull(option);
        imageView.setImageBitmap(option.getResultBitMap());
    }

    private final void eb() {
        fo.b j3 = new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE);
        LinearLayout linearLayout = this.mShareBtn;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            linearLayout = null;
        }
        fo.c.o(linearLayout, WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, j3);
    }

    private final Bitmap fb() {
        if (this.mShotViewBitmap == null) {
            this.mShotViewBitmap = ar.u(this.mPreviewView);
        }
        return this.mShotViewBitmap;
    }

    private final void gb() {
        if (this.mPreviewView == null) {
            View containerView = LayoutInflater.from(getContext()).inflate(R.layout.f167313cn2, (ViewGroup) null);
            this.mPreviewView = containerView;
            Intrinsics.checkNotNullExpressionValue(containerView, "containerView");
            hb(containerView);
        }
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZonePhotoRepairLayerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZonePhotoR\u2026yerViewModel::class.java)");
        this.mPhotoRepairViewModel = (QZonePhotoRepairLayerViewModel) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kb(int i3) {
        QLog.i("QZonePhotoRepairLayerSharePart", 1, "setQRCodeUrl result=" + i3);
    }

    private final void lb(RFWLayerPicInfo.RFWPicInfo picInfo) {
        com.qzone.reborn.repair.utils.o oVar = com.qzone.reborn.repair.utils.o.f59329a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Pair<Integer, Integer> n3 = oVar.n(context, picInfo.getWidth(), picInfo.getHeight());
        jb(this.mPreviewView, n3.getFirst().intValue(), Integer.valueOf(n3.getSecond().intValue() + oVar.q()));
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = null;
        jb(this.mPreviewPicArea, n3.getFirst().intValue(), null);
        jb(this.mPreviewBottomArea, n3.getFirst().intValue(), null);
        jb(this.mPreviewBigPicView, n3.getFirst().intValue(), n3.getSecond());
        jb(this.mPreviewSmallPicView, (int) (n3.getFirst().floatValue() * 0.22508039f), Integer.valueOf((int) (n3.getSecond().floatValue() * 0.22508039f)));
        bb(this.mPreviewLogoView, com.qzone.reborn.configx.g.f53821a.b().h1());
        bb(this.mPreviewQRCodeBg, "https://qzonestyle.gtimg.cn/qzone/client/mqq/qzone-icon/Code_background.png");
        ImageView imageView = this.mPreviewBigPicView;
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel2 = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel2 = null;
        }
        bb(imageView, qZonePhotoRepairLayerViewModel2.k2().getSrUrl());
        ImageView imageView2 = this.mPreviewSmallPicView;
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel3 = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
        } else {
            qZonePhotoRepairLayerViewModel = qZonePhotoRepairLayerViewModel3;
        }
        bb(imageView2, qZonePhotoRepairLayerViewModel.k2().getSrOriginUrl());
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    public void Aa(ShareActionSheetBuilder.ActionSheetItem item) {
        com.qzone.reborn.repair.utils.o.f59329a.t(getActivity(), fb());
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Ca(ShareActionSheetBuilder.ActionSheetItem item) {
        com.qzone.reborn.repair.utils.o.f59329a.w(getActivity(), ta(), fb());
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Da(ShareActionSheetBuilder.ActionSheetItem item) {
        com.qzone.reborn.repair.utils.o.f59329a.z(getActivity(), fb());
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Fa(ShareActionSheetBuilder.ActionSheetItem item) {
        com.qzone.reborn.repair.utils.o.f59329a.C(getActivity(), fb(), 9);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Ga(ShareActionSheetBuilder.ActionSheetItem item) {
        com.qzone.reborn.repair.utils.o.f59329a.C(getActivity(), fb(), 10);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean Ka() {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean V9(boolean showDeleteButton) {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean W9() {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean X9() {
        return true;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean Y9() {
        return true;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean Z9(IOCRService iocrService, String uin) {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean aa() {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean ca() {
        return false;
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected boolean da() {
        return false;
    }

    @Override // xn.b
    public void j4() {
        w1();
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected com.qzone.detail.ui.component.g ma() {
        g.a aVar = new g.a();
        aVar.context = getContext();
        return new com.qzone.detail.ui.component.k(aVar);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20232 && resultCode == -1) {
            QQToastUtil.showQQToast(5, R.string.d7r);
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart, android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        super.onClick(v3);
        if (v3.getId() == R.id.nad) {
            QLog.d("QZonePhotoRepairLayerSharePart", 1, "click showMoreActionMenu");
            w1();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ib(rootView);
        initViewModel();
        PartIOCKt.registerIoc(this, this, xn.b.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    public com.qzone.reborn.layer.share.f ta() {
        QZonePhotoRepairLayerViewModel qZonePhotoRepairLayerViewModel = this.mPhotoRepairViewModel;
        if (qZonePhotoRepairLayerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoRepairViewModel");
            qZonePhotoRepairLayerViewModel = null;
        }
        String srUrl = qZonePhotoRepairLayerViewModel.k2().getSrUrl();
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo != null) {
            photoInfo.currentUrl = srUrl;
            photoInfo.downloadUrl = srUrl;
            photoInfo.bigUrl = srUrl;
            photoInfo.sharePhotoUrl = srUrl;
            photoInfo.isSrUrl = true;
        }
        com.qzone.reborn.layer.share.f ta5 = super.ta();
        Intrinsics.checkNotNullExpressionValue(ta5, "super.getShareContext()");
        return ta5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    public void w1() {
        RFWLayerPicInfo layerPicInfo;
        super.w1();
        gb();
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo = (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null) ? null : layerPicInfo.getCurrentPicInfo();
        if (currentPicInfo != null && (this.L instanceof com.qzone.detail.ui.component.k)) {
            lb(currentPicInfo);
            com.qzone.reborn.repair.utils.o.f59329a.o(this.mPreviewQRCodeView, new com.tencent.mobileqq.component.qrcode.g() { // from class: com.qzone.reborn.repair.part.layer.aa
                @Override // com.tencent.mobileqq.component.qrcode.g
                public final void onResult(int i3) {
                    ac.kb(i3);
                }
            });
            com.qzone.detail.ui.component.g gVar = this.L;
            Intrinsics.checkNotNull(gVar, "null cannot be cast to non-null type com.qzone.detail.ui.component.QZoneSharePreviewActionSheet");
            ((com.qzone.detail.ui.component.k) gVar).y0(this.mPreviewView);
            com.qzone.reborn.util.i.b().l("auto_show_share_action", false);
            return;
        }
        QLog.e("QZonePhotoRepairLayerSharePart", 1, "[showMoreActionMenu] originPicInfo is null");
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void za(ShareActionSheetBuilder.ActionSheetItem item) {
        Bitmap fb5 = fb();
        xn.a aVar = (xn.a) PartIOCKt.getIocInterface(this, xn.a.class);
        if (aVar != null) {
            aVar.Q7(fb5);
        }
    }

    @Override // com.qzone.reborn.layer.part.QZoneFeedxLayerSharePart
    protected void Ea(ShareActionSheetBuilder.ActionSheetItem item) {
        za(null);
        com.qzone.reborn.repair.utils.o.f59329a.G(getActivity(), fb());
    }

    private final void jb(View view, int realWidth, Integer realHeight) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams == null) {
            QLog.e("QZonePhotoRepairLayerSharePart", 1, "[setViewLayoutParams] view:" + view);
            return;
        }
        layoutParams.width = realWidth;
        if (realHeight != null) {
            layoutParams.height = realHeight.intValue();
        }
        view.setLayoutParams(layoutParams);
    }

    private final void hb(View containerView) {
        this.mPreviewContainerView = containerView.findViewById(R.id.nal);
        this.mPreviewBigPicView = (ImageView) containerView.findViewById(R.id.nai);
        this.mPreviewSmallAreaView = containerView.findViewById(R.id.nak);
        this.mPreviewSmallPicView = (ImageView) containerView.findViewById(R.id.naj);
        this.mPreviewQRCodeView = (QUIColorfulQRCodeView) containerView.findViewById(R.id.nam);
        this.mPreviewQRCodeBg = (ImageView) containerView.findViewById(R.id.nan);
        this.mPreviewPicArea = (ViewGroup) containerView.findViewById(R.id.nah);
        this.mPreviewBottomArea = (ViewGroup) containerView.findViewById(R.id.nae);
        this.mPreviewLogoView = (ImageView) containerView.findViewById(R.id.nao);
        ((TextView) containerView.findViewById(R.id.nag)).setText(com.qzone.reborn.configx.g.f53821a.b().g1());
        com.tencent.mobileqq.qzone.picload.c.a().m((ImageView) containerView.findViewById(R.id.naf), getContext().getColor(R.color.qui_common_text_allwhite_primary));
    }

    private final void ib(View rootView) {
        View findViewById = rootView.findViewById(R.id.nad);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026qzone_repair_layer_share)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.mShareBtn = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareBtn");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        eb();
    }
}
