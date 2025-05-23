package com.qzone.reborn.albumx.qzonex.part.layer;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.widget.RFWGalleryViewPager;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001nB\u0015\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0A\u00a2\u0006\u0004\bl\u0010mJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J0\u0010\u0014\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u001a\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u001f\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J$\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020!`\"H\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\b\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0016J\u0012\u0010*\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010+\u001a\u00020\u0005J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0014J&\u00102\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010/\u001a\u0004\u0018\u00010\u00112\b\u00101\u001a\u0004\u0018\u000100H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000eH\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000eH\u0016J\u0010\u00106\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000eH\u0016J\"\u0010;\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0006\u0010<\u001a\u00020\u0005J\u0006\u0010=\u001a\u00020\u0005J\u0010\u0010@\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010>R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0A8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001a\u0010V\u001a\u00020\u000e8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R#\u0010h\u001a\n c*\u0004\u0018\u00010b0b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u001b\u0010k\u001a\u0002008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010e\u001a\u0004\bi\u0010j\u00a8\u0006o"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/QZAlbumxLayerMorePart;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/b;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "", "N9", "", DTConstants.TAG.ELEMENT, "Landroid/view/View;", "view", "H9", "Lic/c;", "shareContext", "", "action", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "list", "E9", "", "Q9", "O9", "actionId", "J9", "itemName", "G9", "text", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "T9", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "K9", "P9", "M9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "onPartDestroy", "R9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "w6", "position", "onItemLongClick", "onItemLongClickCancel", "onItemLongClickUp", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "U9", "F9", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskState", "onStateChange", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", tl.h.F, "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "getMShareManager", "()Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "mShareManager", "i", "Ljava/lang/String;", "TAG", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mMoreBtn", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "mViewPagerRoot", "D", "I", "getREQUEST_TO_QZONE", "()I", "REQUEST_TO_QZONE", "Landroid/app/Dialog;", "E", "Landroid/app/Dialog;", "waitingDialog", UserInfo.SEX_FEMALE, "Z", "isDestory", "Lcom/qzone/reborn/albumx/qzonex/part/layer/QZAlbumxLayerMorePart$a;", "G", "Lcom/qzone/reborn/albumx/qzonex/part/layer/QZAlbumxLayerMorePart$a;", "dowloadListener", "Loc/e;", "kotlin.jvm.PlatformType", "H", "Lkotlin/Lazy;", "I9", "()Loc/e;", "albumxViewModel", "L9", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "mSASBuilder", "<init>", "(Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxLayerMorePart extends b implements View.OnClickListener, ShareActionSheet.c, RFWGalleryViewPager.OnItemLongClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private RFWGalleryViewPager mViewPagerRoot;

    /* renamed from: D, reason: from kotlin metadata */
    private final int REQUEST_TO_QZONE;

    /* renamed from: E, reason: from kotlin metadata */
    private Dialog waitingDialog;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isDestory;

    /* renamed from: G, reason: from kotlin metadata */
    private final a dowloadListener;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy albumxViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy mSASBuilder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final QQShareActionManager<ic.c> mShareManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String TAG;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mMoreBtn;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/layer/QZAlbumxLayerMorePart$a;", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskState", "", "onStateChange", "Lmqq/util/WeakReference;", "Lcom/qzone/reborn/albumx/qzonex/part/layer/QZAlbumxLayerMorePart;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "partWeakReference", "part", "<init>", "(Lcom/qzone/reborn/albumx/qzonex/part/layer/QZAlbumxLayerMorePart;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    private static final class a implements RFWDownloadQueueResultListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<QZAlbumxLayerMorePart> partWeakReference;

        public a(QZAlbumxLayerMorePart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.partWeakReference = new WeakReference<>(part);
        }

        @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
        public void onStateChange(RFWDownloadTaskStateData taskState) {
            QZAlbumxLayerMorePart qZAlbumxLayerMorePart = this.partWeakReference.get();
            if (qZAlbumxLayerMorePart != null) {
                qZAlbumxLayerMorePart.onStateChange(taskState);
            }
        }
    }

    public QZAlbumxLayerMorePart(QQShareActionManager<ic.c> mShareManager) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mShareManager, "mShareManager");
        this.mShareManager = mShareManager;
        this.TAG = "GroupAlbumLayerMorePart";
        this.REQUEST_TO_QZONE = 10001;
        this.dowloadListener = new a(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<oc.e>() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.QZAlbumxLayerMorePart$albumxViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oc.e invoke() {
                return (oc.e) QZAlbumxLayerMorePart.this.getViewModel(oc.e.class);
            }
        });
        this.albumxViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ShareActionSheet>() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.QZAlbumxLayerMorePart$mSASBuilder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShareActionSheet invoke() {
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = QZAlbumxLayerMorePart.this.getActivity();
                return ShareActionSheetFactory.create(param);
            }
        });
        this.mSASBuilder = lazy2;
    }

    private final void E9(ic.c shareContext, int action, ArrayList<ShareActionSheetBuilder.ActionSheetItem> list) {
        com.qzone.reborn.albumx.common.share.a<ic.c> c16 = this.mShareManager.c(action);
        if (c16 == null) {
            return;
        }
        boolean f16 = c16.f(shareContext);
        if (action == 40) {
            f16 = Q9();
        }
        if (action == 11) {
            QZAlbumxLayerExtraInfoBean x95 = x9();
            if (TextUtils.isEmpty(x95 != null ? x95.getUploadUid() : null)) {
                String str = this.TAG;
                QZAlbumxLayerExtraInfoBean x96 = x9();
                QLog.d(str, 1, "currentSelectedMedia?.uploadUid is empty from " + (x96 != null ? x96.getLLoc() : null));
            }
            QZAlbumxLayerExtraInfoBean x97 = x9();
            if (!TextUtils.isEmpty(x97 != null ? x97.getUploadUid() : null)) {
                QZAlbumxLayerExtraInfoBean x98 = x9();
                if (!Intrinsics.areEqual(x98 != null ? x98.getUploadUid() : null, LoginData.getInstance().getUinString())) {
                    f16 = true;
                }
            }
            f16 = false;
        }
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(action);
        if (f16) {
            build.visibility = c16.e() ? 0 : 8;
        } else {
            build.visibility = 8;
        }
        list.add(build);
    }

    private final void G9(String itemName, View view) {
        fo.c.l(view, getPartRootView());
        HashMap<String, Object> K9 = K9();
        K9.put(WinkDaTongReportConstant.ElementParamKey.SHARING_DITCH, itemName);
        fo.c.e(WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, "pg_qz_dynamic_floating_layer", view, K9);
    }

    private final void H9(String element, View view) {
        HashMap<String, Object> K9 = K9();
        K9.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0MWZXR4U3RVU");
        K9.put("pgid", "pg_qz_dynamic_floating_layer");
        HashMap<String, Object> K92 = K9();
        K92.put(WinkDaTongReportConstant.ElementParamKey.SHARING_DITCH, element);
        K92.put("cur_pg", K9);
        K92.put("eid", element);
        K92.put("qq_eid", element);
        K92.put("qq_pgid", "pg_qz_dynamic_floating_layer");
        VideoReport.setPageId(view, "pg_qz_dynamic_floating_layer");
        VideoReport.setElementId(view, element);
        VideoReport.setElementParams(view, K92);
        VideoReport.reportEvent("dt_imp", view, K92);
    }

    private final oc.e I9() {
        return (oc.e) this.albumxViewModel.getValue();
    }

    private final HashMap<String, Object> K9() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (x9() == null) {
            return hashMap;
        }
        hashMap.put("open_visit_state", Integer.valueOf(P9()));
        QZAlbumxLayerExtraInfoBean x95 = x9();
        String uin = x95 != null ? x95.getUin() : null;
        Intrinsics.checkNotNull(uin);
        hashMap.put("group_uin", uin);
        QZAlbumxLayerExtraInfoBean x96 = x9();
        String albumId = x96 != null ? x96.getAlbumId() : null;
        Intrinsics.checkNotNull(albumId);
        hashMap.put("albumid", albumId);
        hashMap.put("floating_layer_type", Integer.valueOf(M9()));
        return hashMap;
    }

    private final int M9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        Boolean valueOf = x95 != null ? Boolean.valueOf(x95.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) : null;
        Intrinsics.checkNotNull(valueOf);
        return valueOf.booleanValue() ? 1 : 0;
    }

    private final void N9() {
        this.mShareManager.k(23, getViewModel(q9.c.class));
        this.mShareManager.k(56, getViewModel(q9.c.class));
    }

    private final boolean O9() {
        ii.a E;
        ai.c cVar = (ai.c) RFWIocAbilityProvider.g().getIocInterface(ai.c.class, getPartRootView(), null);
        if (cVar == null || (E = cVar.E()) == null) {
            return false;
        }
        return E.W1();
    }

    private final int P9() {
        QZAlbumxLayerExtraInfoBean x95 = x9();
        return !Intrinsics.areEqual(String.valueOf(x95 != null ? x95.getUploadUid() : null), LoginData.getInstance().getUinString()) ? 1 : 0;
    }

    private final boolean Q9() {
        ii.a E;
        ai.c cVar = (ai.c) RFWIocAbilityProvider.g().getIocInterface(ai.c.class, getPartRootView(), null);
        if ((cVar == null || (E = cVar.E()) == null) ? false : E.U1()) {
            return true;
        }
        QZAlbumxLayerExtraInfoBean x95 = x9();
        if (!Intrinsics.areEqual(x95 != null ? x95.getUploadUid() : null, LoginData.getInstance().getUinString())) {
            QZAlbumxLayerExtraInfoBean x96 = x9();
            if (!Intrinsics.areEqual(x96 != null ? x96.getUploadUid() : null, LoginData.getInstance().getUid())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(QZAlbumxLayerMorePart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = this$0.L9().findViewById(R.id.f163935cx);
        if (findViewById != null) {
            fo.c.l(findViewById, this$0.getPartRootView());
            fo.c.g(WinkDaTongReportConstant.ElementId.EM_QZ_MORE_OPERATION_PANEL, "pg_qz_dynamic_floating_layer", findViewById, this$0.K9());
            this$0.H9(WinkDaTongReportConstant.ElementId.EM_QZ_MORE_OPERATION_PANEL, findViewById);
        }
    }

    public final ShareActionSheet L9() {
        Object value = this.mSASBuilder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mSASBuilder>(...)");
        return (ShareActionSheet) value;
    }

    public final void R9() {
        if (this.mCurrentSelectedItem == null) {
            return;
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        L9().setActionSheetTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.ipr));
        this.mShareManager.i(L9());
        N9();
        L9().setRowVisibility(0, 0, 0);
        QZAlbumxLayerExtraInfoBean x95 = x9();
        if (x95 != null && x95.getShareInfo() == null) {
            I9().h2(x95);
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QQShareActionManager<ic.c> qQShareActionManager = this.mShareManager;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        ic.c cVar = new ic.c(activity, qQShareActionManager, rFWLayerItemMediaInfo, O9(), x95);
        for (Map.Entry<Integer, com.qzone.reborn.albumx.common.share.a<ic.c>> entry : this.mShareManager.e().entrySet()) {
            if (entry.getValue().b() == QQShareActionManager.ShareLine.FIRST) {
                E9(cVar, entry.getKey().intValue(), arrayList);
            } else if (entry.getValue().b() == QQShareActionManager.ShareLine.SECOND) {
                E9(cVar, entry.getKey().intValue(), arrayList2);
            }
        }
        L9().setIntentForStartForwardRecentActivity(new Intent());
        this.mShareManager.h(arrayList, arrayList2);
        L9().setItemClickListenerV3(this);
        U9();
        this.mShareManager.l(cVar);
        L9().setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.qzone.reborn.albumx.qzonex.part.layer.y
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                QZAlbumxLayerMorePart.S9(QZAlbumxLayerMorePart.this, dialogInterface);
            }
        });
    }

    public final void U9() {
        IVideoPlayerProvider mLayerVideoControlProvider;
        IVideoPlayerProvider mLayerVideoControlProvider2 = getMLayerVideoControlProvider();
        if (mLayerVideoControlProvider2 != null && mLayerVideoControlProvider2.isPlaying()) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            if (!(rFWLayerItemMediaInfo != null && rFWLayerItemMediaInfo.isVideo()) || (mLayerVideoControlProvider = getMLayerVideoControlProvider()) == null) {
                return;
            }
            mLayerVideoControlProvider.stop();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 19005 && L9().isShowing()) {
            L9().dismiss();
        }
        this.mShareManager.f(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == this.REQUEST_TO_QZONE) {
            QQToast.makeText(getActivity(), R.string.hky, 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f20057c) {
            R9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mMoreBtn = (ImageView) rootView.findViewById(R.id.f20057c);
        this.mViewPagerRoot = (RFWGalleryViewPager) rootView.findViewById(R.id.f73943ux);
        ImageView imageView = this.mMoreBtn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.mMoreBtn;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        if (getActivity().getIntent() != null) {
            getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_photo");
        }
        ImageView imageView3 = this.mMoreBtn;
        if (imageView3 != null) {
            fo.c.n(imageView3, "em_qz_more");
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClick(int position) {
        R9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        RFWGalleryViewPager rFWGalleryViewPager = this.mViewPagerRoot;
        if (rFWGalleryViewPager != null) {
            rFWGalleryViewPager.setOnItemLongClickListener(this);
        }
        if (this.isDestory) {
            return;
        }
        zh.b l3 = zh.b.l();
        QZAlbumxLayerExtraInfoBean x95 = x9();
        l3.r(String.valueOf(x95 != null ? x95.getUin() : null), this.dowloadListener);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.isDestory = true;
        zh.b l3 = zh.b.l();
        QZAlbumxLayerExtraInfoBean x95 = x9();
        l3.s(String.valueOf(x95 != null ? x95.getUin() : null), this.dowloadListener);
        n5.d.l().r(null);
    }

    private final String J9(int actionId) {
        if (actionId == 2) {
            return "1";
        }
        if (actionId != 3) {
            if (actionId != 6) {
                if (actionId == 48) {
                    return "16";
                }
                if (actionId == 52) {
                    return "18";
                }
                if (actionId != 84) {
                    if (actionId == 100) {
                        return "5";
                    }
                    if (actionId == 107) {
                        return "17";
                    }
                    if (actionId == 184) {
                        return "2";
                    }
                    if (actionId == 39) {
                        return "7";
                    }
                    if (actionId == 40) {
                        return "11";
                    }
                    if (actionId == 72 || actionId == 73) {
                        return "1";
                    }
                    switch (actionId) {
                        case 9:
                            return "3";
                        case 10:
                            return "4";
                        case 11:
                            return "6";
                        default:
                            return null;
                    }
                }
            }
            return "15";
        }
        return "14";
    }

    private final void T9(String text, Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.waitingDialog == null) {
            ReportDialog reportDialog = new ReportDialog(activity, R.style.f174269ui);
            this.waitingDialog = reportDialog;
            reportDialog.setContentView(R.layout.bqd);
            Dialog dialog = this.waitingDialog;
            View findViewById = dialog != null ? dialog.findViewById(R.id.kja) : null;
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            Dialog dialog2 = this.waitingDialog;
            View findViewById2 = dialog2 != null ? dialog2.findViewById(R.id.cib) : null;
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        Dialog dialog3 = this.waitingDialog;
        View findViewById3 = dialog3 != null ? dialog3.findViewById(R.id.dialogText) : null;
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById3).setText(text);
        Dialog dialog4 = this.waitingDialog;
        if (dialog4 != null) {
            dialog4.show();
        }
    }

    public final void F9() {
        Dialog dialog;
        try {
            Dialog dialog2 = this.waitingDialog;
            if (!(dialog2 != null && dialog2.isShowing()) || (dialog = this.waitingDialog) == null) {
                return;
            }
            dialog.dismiss();
        } catch (Exception e16) {
            RFWLog.e(this.TAG, RFWLog.USR, "exception is " + e16);
        }
    }

    public final void onStateChange(RFWDownloadTaskStateData taskState) {
        if ((taskState != null ? taskState.getState() : null) == DownloadState.STATE_START_RUN) {
            T9("", getActivity());
            return;
        }
        if ((taskState != null ? taskState.getState() : null) == DownloadState.STATE_SUCCESS) {
            Uri fromFile = Uri.fromFile(new File(taskState.getFilePath()));
            Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(file)");
            BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
            F9();
            RFWLog.i(this.TAG, RFWLog.USR, "download success");
            QQToast.makeText(BaseApplication.getContext(), 5, R.string.slz, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
    public void w6(View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        if (view == null || item == null || shareActionSheet == null || this.mCurrentSelectedItem == null) {
            return;
        }
        int i3 = item.action;
        L9().dismiss();
        com.qzone.reborn.albumx.common.share.a<ic.c> c16 = this.mShareManager.c(i3);
        if (c16 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            QQShareActionManager<ic.c> qQShareActionManager = this.mShareManager;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            c16.a(new ic.c(activity, qQShareActionManager, rFWLayerItemMediaInfo, O9(), x9()), item);
        }
        String J9 = J9(i3);
        if (J9 != null) {
            G9(J9, view);
        }
        View findViewById = L9().findViewById(R.id.f163935cx);
        if (findViewById != null) {
            fo.c.l(findViewById, getPartRootView());
            fo.c.d(WinkDaTongReportConstant.ElementId.EM_QZ_MORE_OPERATION_PANEL, "pg_qz_dynamic_floating_layer", findViewById);
        }
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickCancel(int position) {
    }

    @Override // com.tencent.richframework.gallery.widget.RFWGalleryViewPager.OnItemLongClickListener
    public void onItemLongClickUp(int position) {
    }
}
