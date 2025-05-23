package com.tencent.mobileqq.hermes.layer.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.hermes.easteregg.BrandEasterConfigBean;
import com.tencent.mobileqq.hermes.share.HermesAbsShareAction;
import com.tencent.mobileqq.hermes.share.HermesShareActionManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.delegate.INTLayerOperationListener;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001KB\u000f\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J0\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\tH\u0016J\"\u0010&\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/hermes/layer/part/HermesLayerMorePart;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "", "A9", "Lcom/tencent/mobileqq/hermes/share/k;", "shareContext", "", "action", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "list", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "onItemClick", "position", "onItemLongClick", "onItemLongClickCancel", "onItemLongClickUp", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager;", "d", "Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager;", "shareManager", "e", "I", "REQUEST_TO_QZONE", "Landroid/widget/ImageButton;", "f", "Landroid/widget/ImageButton;", "moreBtn", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", tl.h.F, "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "mViewPagerRoot", "", "i", "J", "ranking", "Lcom/tencent/mobileqq/hermes/easteregg/BrandEasterConfigBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/hermes/easteregg/BrandEasterConfigBean;", "easterConfig", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "configStr", "Lcom/tencent/mobileqq/hermes/share/j;", "D", "Lkotlin/Lazy;", "z9", "()Lcom/tencent/mobileqq/hermes/share/j;", "shareActionSheetBuilder", "<init>", "(Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager;)V", "E", "a", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class HermesLayerMorePart extends NTAIOLayerBasePart implements View.OnClickListener, ShareActionSheet.OnItemClickListener, RFWGalleryViewPager.OnItemLongClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String configStr;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy shareActionSheetBuilder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HermesShareActionManager shareManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int REQUEST_TO_QZONE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageButton moreBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWGalleryViewPager mViewPagerRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long ranking;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BrandEasterConfigBean easterConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/hermes/layer/part/HermesLayerMorePart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.hermes.layer.part.HermesLayerMorePart$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25112);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HermesLayerMorePart(@NotNull HermesShareActionManager shareManager) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(shareManager, "shareManager");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) shareManager);
            return;
        }
        this.shareManager = shareManager;
        this.REQUEST_TO_QZONE = 10001;
        this.ranking = -1L;
        this.configStr = com.tencent.mobileqq.hermes.util.a.f236827a.b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.hermes.share.j>() { // from class: com.tencent.mobileqq.hermes.layer.part.HermesLayerMorePart$shareActionSheetBuilder$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HermesLayerMorePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.hermes.share.j invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.hermes.share.j) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = HermesLayerMorePart.this.getActivity();
                return new com.tencent.mobileqq.hermes.share.j(param);
            }
        });
        this.shareActionSheetBuilder = lazy;
    }

    private final void A9() {
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        this.shareManager.g(z9());
        z9().setRowVisibility(0, 0, 0);
        if (getActivity().getIntent() != null) {
            getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_photo");
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        HermesShareActionManager hermesShareActionManager = this.shareManager;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        com.tencent.mobileqq.hermes.share.k kVar = new com.tencent.mobileqq.hermes.share.k(activity, (Fragment) partHost, hermesShareActionManager, rFWLayerItemMediaInfo, null, this.ranking, this.easterConfig);
        for (Map.Entry<Integer, HermesAbsShareAction> entry : this.shareManager.d().entrySet()) {
            if (entry.getValue().d() == HermesShareActionManager.ShareLine.FIRST) {
                x9(kVar, entry.getKey().intValue(), arrayList);
            } else if (entry.getValue().d() == HermesShareActionManager.ShareLine.SECOND) {
                x9(kVar, entry.getKey().intValue(), arrayList2);
            }
        }
        this.shareManager.f(arrayList, arrayList2);
        z9().setItemClickListenerV2(this);
        this.shareManager.h(kVar);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo2 != null && (layerPicInfo = rFWLayerItemMediaInfo2.getLayerPicInfo()) != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null && (url = currentPicInfo.getUrl()) != null) {
            com.tencent.mobileqq.hermes.util.a.f236827a.e(url);
        }
    }

    private final void x9(com.tencent.mobileqq.hermes.share.k shareContext, int action, ArrayList<ShareActionSheetBuilder.ActionSheetItem> list) {
        int i3;
        HermesAbsShareAction c16 = this.shareManager.c(action);
        if (c16 != null && c16.g(shareContext)) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(action);
            if (c16.f()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            build.visibility = i3;
            list.add(build);
        }
    }

    private final com.tencent.mobileqq.hermes.share.j z9() {
        return (com.tencent.mobileqq.hermes.share.j) this.shareActionSheetBuilder.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 19005 && z9().isShowing()) {
            z9().dismiss();
        }
        if (resultCode == -1 && requestCode == this.REQUEST_TO_QZONE) {
            QQToast.makeText(getActivity(), R.string.hky, 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3.getId() == R.id.x9p) {
                A9();
                INTLayerOperationListener mLayerOperateListener = getMLayerOperateListener();
                if (mLayerOperateListener != null) {
                    mLayerOperateListener.clickShowMoreBtn();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.moreBtn = (ImageButton) rootView.findViewById(R.id.x9p);
        this.mViewPagerRoot = (RFWGalleryViewPager) rootView.findViewById(R.id.f73943ux);
        ImageButton imageButton = this.moreBtn;
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        ImageButton imageButton2 = this.moreBtn;
        if (imageButton2 != null) {
            bindDtElement(imageButton2);
        }
        BrandEasterConfigBean brandEasterConfigBean = this.easterConfig;
        boolean z17 = true;
        if (brandEasterConfigBean != null && brandEasterConfigBean.isOpen()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            BrandEasterConfigBean brandEasterConfigBean2 = this.easterConfig;
            if (brandEasterConfigBean2 == null || !brandEasterConfigBean2.isEnableShare()) {
                z17 = false;
            }
            if (z17) {
                RFWGalleryViewPager rFWGalleryViewPager = this.mViewPagerRoot;
                if (rFWGalleryViewPager != null) {
                    rFWGalleryViewPager.setOnItemLongClickListener(this);
                }
                ImageButton imageButton3 = this.moreBtn;
                if (imageButton3 != null) {
                    imageButton3.setVisibility(0);
                    return;
                }
                return;
            }
        }
        ImageButton imageButton4 = this.moreBtn;
        if (imageButton4 != null) {
            imageButton4.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull ShareActionSheet shareActionSheet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) item, (Object) shareActionSheet);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        int i3 = item.action;
        if (i3 != 72) {
            z9().dismiss();
        }
        HermesAbsShareAction c16 = this.shareManager.c(i3);
        if (c16 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Object partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            HermesShareActionManager hermesShareActionManager = this.shareManager;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            c16.b(new com.tencent.mobileqq.hermes.share.k(activity, (Fragment) partHost, hermesShareActionManager, rFWLayerItemMediaInfo, null, this.ranking, this.easterConfig), item);
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClick(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, position);
            return;
        }
        A9();
        INTLayerOperationListener mLayerOperateListener = getMLayerOperateListener();
        if (mLayerOperateListener != null) {
            mLayerOperateListener.onLongPress();
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickCancel(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, position);
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickUp(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, position);
        }
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        if (!TextUtils.isEmpty(this.configStr)) {
            BrandEasterConfigBean brandEasterConfigBean = (BrandEasterConfigBean) new Gson().fromJson(this.configStr, BrandEasterConfigBean.class);
            this.easterConfig = brandEasterConfigBean;
            if (brandEasterConfigBean != null) {
                bool = Boolean.valueOf(brandEasterConfigBean.getEnableShare());
            } else {
                bool = null;
            }
            QLog.i("HermesLayerMorePart", 1, "enableShare: " + bool);
        }
        this.ranking = com.tencent.mobileqq.hermes.util.a.f236827a.c();
    }
}
