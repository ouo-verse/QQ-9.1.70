package com.qzone.reborn.groupalbum.layer.part;

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
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001kB\u0015\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050<\u00a2\u0006\u0004\bi\u0010jJ0\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u001c\u0010\u001a\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J$\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001c`\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0014H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0014H\u0016J\u0012\u0010%\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010&\u001a\u00020\rJ\u0010\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020'H\u0014J&\u0010-\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0007H\u0016J\u0010\u00100\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0007H\u0016J\u0010\u00101\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0007H\u0016J\"\u00106\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0006\u00107\u001a\u00020\rJ\u0006\u00108\u001a\u00020\rJ\u0010\u0010;\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u000109R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010Q\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0014\u0010S\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bR\u0010CR\u0014\u0010U\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bT\u0010CR\u0014\u0010W\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bV\u0010CR\u0014\u0010Y\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bX\u0010CR\u0018\u0010\\\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010[R\u0016\u0010_\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020+8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\u00a8\u0006l"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumLayerMorePart;", "Lcom/qzone/reborn/groupalbum/layer/part/b;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager$OnItemLongClickListener;", "Lgi/a;", "shareContext", "", "action", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lkotlin/collections/ArrayList;", "list", "", "E9", "", "M9", "K9", "", "itemName", "Landroid/view/View;", "view", "G9", "text", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "P9", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "H9", "L9", "J9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "onPartDestroy", "N9", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "w6", "position", "onItemLongClick", "onItemLongClickUp", "onItemLongClickCancel", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Q9", "F9", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskState", "onStateChange", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", tl.h.F, "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "getMShareManager", "()Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "mShareManager", "i", "Ljava/lang/String;", "TAG", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mMoreBtn", "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/richframework/gallery/widget/RFWGalleryViewPager;", "mViewPagerRoot", "D", "I", "getREQUEST_TO_QZONE", "()I", "REQUEST_TO_QZONE", "E", "SAVE", UserInfo.SEX_FEMALE, "REPORT", "G", "SHIP", "H", "DELETE", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "waitingDialog", "J", "Z", "isDestory", "Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumLayerMorePart$a;", "K", "Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumLayerMorePart$a;", "dowloadListener", "L", "Lkotlin/Lazy;", "I9", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "mSASBuilder", "<init>", "(Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumLayerMorePart extends b implements View.OnClickListener, ShareActionSheet.c, RFWGalleryViewPager.OnItemLongClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private RFWGalleryViewPager mViewPagerRoot;

    /* renamed from: D, reason: from kotlin metadata */
    private final int REQUEST_TO_QZONE;

    /* renamed from: E, reason: from kotlin metadata */
    private final String SAVE;

    /* renamed from: F, reason: from kotlin metadata */
    private final String REPORT;

    /* renamed from: G, reason: from kotlin metadata */
    private final String SHIP;

    /* renamed from: H, reason: from kotlin metadata */
    private final String DELETE;

    /* renamed from: I, reason: from kotlin metadata */
    private Dialog waitingDialog;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isDestory;

    /* renamed from: K, reason: from kotlin metadata */
    private final a dowloadListener;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy mSASBuilder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final QQShareActionManager<gi.a> mShareManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String TAG;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mMoreBtn;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumLayerMorePart$a;", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskState", "", "onStateChange", "Lmqq/util/WeakReference;", "Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumLayerMorePart;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "partWeakReference", "part", "<init>", "(Lcom/qzone/reborn/groupalbum/layer/part/GroupAlbumLayerMorePart;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    private static final class a implements RFWDownloadQueueResultListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<GroupAlbumLayerMorePart> partWeakReference;

        public a(GroupAlbumLayerMorePart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.partWeakReference = new WeakReference<>(part);
        }

        @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
        public void onStateChange(RFWDownloadTaskStateData taskState) {
            GroupAlbumLayerMorePart groupAlbumLayerMorePart = this.partWeakReference.get();
            if (groupAlbumLayerMorePart != null) {
                groupAlbumLayerMorePart.onStateChange(taskState);
            }
        }
    }

    public GroupAlbumLayerMorePart(QQShareActionManager<gi.a> mShareManager) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mShareManager, "mShareManager");
        this.mShareManager = mShareManager;
        this.TAG = "GroupAlbumLayerMorePart";
        this.REQUEST_TO_QZONE = 10001;
        this.SAVE = "7";
        this.REPORT = "6";
        this.SHIP = "5";
        this.DELETE = "11";
        this.dowloadListener = new a(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ShareActionSheet>() { // from class: com.qzone.reborn.groupalbum.layer.part.GroupAlbumLayerMorePart$mSASBuilder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShareActionSheet invoke() {
                ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
                param.context = GroupAlbumLayerMorePart.this.getActivity();
                return ShareActionSheetFactory.create(param);
            }
        });
        this.mSASBuilder = lazy;
    }

    private final void E9(gi.a shareContext, int action, ArrayList<ShareActionSheetBuilder.ActionSheetItem> list) {
        com.qzone.reborn.albumx.common.share.a<gi.a> c16 = this.mShareManager.c(action);
        if (c16 == null) {
            return;
        }
        boolean f16 = c16.f(shareContext);
        if (action == 40) {
            f16 = M9();
        }
        if (action == 11) {
            GroupAlbumLayerExtraInfoBean x95 = x9();
            if (TextUtils.isEmpty(x95 != null ? x95.getUploadUid() : null)) {
                String str = this.TAG;
                GroupAlbumLayerExtraInfoBean x96 = x9();
                QLog.d(str, 1, "currentSelectedMedia?.uploadUid is empty from " + (x96 != null ? x96.getLLoc() : null));
            }
            GroupAlbumLayerExtraInfoBean x97 = x9();
            if (!TextUtils.isEmpty(x97 != null ? x97.getUploadUid() : null)) {
                GroupAlbumLayerExtraInfoBean x98 = x9();
                if (!Intrinsics.areEqual(x98 != null ? x98.getUploadUid() : null, LoginData.getInstance().getUinString())) {
                    f16 = true;
                }
            }
            f16 = false;
        }
        if (f16) {
            ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(action);
            build.visibility = c16.e() ? 0 : 8;
            list.add(build);
        }
    }

    private final void G9(String itemName, View view) {
        fo.c.l(view, getPartRootView());
        HashMap<String, Object> H9 = H9();
        H9.put(WinkDaTongReportConstant.ElementParamKey.SHARING_DITCH, itemName);
        fo.c.e(WinkDaTongReportConstant.ElementId.EM_QZ_SHARE, "pg_qz_dynamic_floating_layer", view, H9);
    }

    private final HashMap<String, Object> H9() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (x9() == null) {
            return hashMap;
        }
        hashMap.put("open_visit_state", Integer.valueOf(L9()));
        GroupAlbumLayerExtraInfoBean x95 = x9();
        String groupId = x95 != null ? x95.getGroupId() : null;
        Intrinsics.checkNotNull(groupId);
        hashMap.put("group_uin", groupId);
        GroupAlbumLayerExtraInfoBean x96 = x9();
        String albumId = x96 != null ? x96.getAlbumId() : null;
        Intrinsics.checkNotNull(albumId);
        hashMap.put("albumid", albumId);
        hashMap.put("floating_layer_type", Integer.valueOf(J9()));
        return hashMap;
    }

    private final int J9() {
        GroupAlbumLayerExtraInfoBean x95 = x9();
        Boolean valueOf = x95 != null ? Boolean.valueOf(x95.getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String()) : null;
        Intrinsics.checkNotNull(valueOf);
        return valueOf.booleanValue() ? 1 : 0;
    }

    private final boolean K9() {
        ii.a E;
        ai.c cVar = (ai.c) RFWIocAbilityProvider.g().getIocInterface(ai.c.class, getPartRootView(), null);
        if (cVar == null || (E = cVar.E()) == null) {
            return false;
        }
        return E.W1();
    }

    private final int L9() {
        GroupAlbumLayerExtraInfoBean x95 = x9();
        return !Intrinsics.areEqual(String.valueOf(x95 != null ? x95.getUploadUid() : null), LoginData.getInstance().getUinString()) ? 1 : 0;
    }

    private final boolean M9() {
        ii.a E;
        ai.c cVar = (ai.c) RFWIocAbilityProvider.g().getIocInterface(ai.c.class, getPartRootView(), null);
        if ((cVar == null || (E = cVar.E()) == null) ? false : E.U1()) {
            return true;
        }
        GroupAlbumLayerExtraInfoBean x95 = x9();
        if (!Intrinsics.areEqual(x95 != null ? x95.getUploadUid() : null, LoginData.getInstance().getUinString())) {
            GroupAlbumLayerExtraInfoBean x96 = x9();
            if (!Intrinsics.areEqual(x96 != null ? x96.getUploadUid() : null, LoginData.getInstance().getUid())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(GroupAlbumLayerMorePart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = this$0.I9().findViewById(R.id.f163935cx);
        if (findViewById != null) {
            fo.c.l(findViewById, this$0.getPartRootView());
            fo.c.g(WinkDaTongReportConstant.ElementId.EM_QZ_MORE_OPERATION_PANEL, "pg_qz_dynamic_floating_layer", findViewById, this$0.H9());
        }
    }

    public final ShareActionSheet I9() {
        Object value = this.mSASBuilder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mSASBuilder>(...)");
        return (ShareActionSheet) value;
    }

    public final void N9() {
        if (this.mCurrentSelectedItem == null) {
            return;
        }
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList2 = new ArrayList<>();
        I9().setActionSheetTitle(com.tencent.biz.qqcircle.utils.h.a(R.string.ipr));
        this.mShareManager.i(I9());
        I9().setRowVisibility(0, 0, 0);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QQShareActionManager<gi.a> qQShareActionManager = this.mShareManager;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        gi.a aVar = new gi.a(activity, qQShareActionManager, rFWLayerItemMediaInfo, K9());
        for (Map.Entry<Integer, com.qzone.reborn.albumx.common.share.a<gi.a>> entry : this.mShareManager.e().entrySet()) {
            if (entry.getValue().b() == QQShareActionManager.ShareLine.FIRST) {
                E9(aVar, entry.getKey().intValue(), arrayList);
            } else if (entry.getValue().b() == QQShareActionManager.ShareLine.SECOND) {
                E9(aVar, entry.getKey().intValue(), arrayList2);
            }
        }
        this.mShareManager.h(arrayList, arrayList2);
        I9().setItemClickListenerV3(this);
        Q9();
        this.mShareManager.l(aVar);
        I9().setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.qzone.reborn.groupalbum.layer.part.x
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                GroupAlbumLayerMorePart.O9(GroupAlbumLayerMorePart.this, dialogInterface);
            }
        });
    }

    public final void Q9() {
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
        if (requestCode == 19005 && I9().isShowing()) {
            I9().dismiss();
        }
        if (resultCode == -1 && requestCode == this.REQUEST_TO_QZONE) {
            QQToast.makeText(getActivity(), R.string.hky, 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f20057c) {
            N9();
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
        N9();
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
        GroupAlbumLayerExtraInfoBean x95 = x9();
        l3.r(String.valueOf(x95 != null ? x95.getGroupId() : null), this.dowloadListener);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.isDestory = true;
        zh.b l3 = zh.b.l();
        GroupAlbumLayerExtraInfoBean x95 = x9();
        l3.s(String.valueOf(x95 != null ? x95.getGroupId() : null), this.dowloadListener);
    }

    private final void P9(String text, Activity activity) {
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
            RFWLog.e("GroupAlbumSaveAction", RFWLog.USR, "exception is " + e16);
        }
    }

    public final void onStateChange(RFWDownloadTaskStateData taskState) {
        if ((taskState != null ? taskState.getState() : null) == DownloadState.STATE_START_RUN) {
            P9("", getActivity());
            return;
        }
        if ((taskState != null ? taskState.getState() : null) == DownloadState.STATE_SUCCESS) {
            Uri fromFile = Uri.fromFile(new File(taskState.getFilePath()));
            Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(file)");
            BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
            F9();
            RFWLog.i("GroupAlbumSaveAction", RFWLog.USR, "download success");
            QQToast.makeText(BaseApplication.getContext(), 5, R.string.slz, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
    public void w6(View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        if (view == null || item == null || shareActionSheet == null || this.mCurrentSelectedItem == null) {
            return;
        }
        int i3 = item.action;
        if (i3 != 72) {
            I9().dismiss();
        }
        com.qzone.reborn.albumx.common.share.a<gi.a> c16 = this.mShareManager.c(i3);
        if (c16 != null) {
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            QQShareActionManager<gi.a> qQShareActionManager = this.mShareManager;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
            c16.a(new gi.a(activity, qQShareActionManager, rFWLayerItemMediaInfo, K9()), item);
        }
        if (i3 == 40) {
            G9(this.DELETE, view);
        }
        if (i3 == 11) {
            G9(this.REPORT, view);
        }
        if (i3 == 39) {
            G9(this.SAVE, view);
        }
        if (i3 == 100) {
            G9(this.SHIP, view);
        }
        View findViewById = I9().findViewById(R.id.f163935cx);
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
