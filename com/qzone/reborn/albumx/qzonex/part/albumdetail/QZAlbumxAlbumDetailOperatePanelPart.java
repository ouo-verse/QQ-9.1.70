package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.util.Consumer;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsArea;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsAreaList;
import com.qzone.reborn.albumx.common.convert.bean.CommonRecommendMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxBatchLayerSelectedMediaInfoBean;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadSelectAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxModifyLocationEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxModifyTimeEvent;
import com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailOperatePanelPart;
import com.qzone.util.image.NetImageInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.QZonePermission;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Constants;
import n5.d;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 `2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001aB\u0007\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\r\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH\u0002J \u0010\u000f\u001a\u00020\u000e2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0002J \u0010\u0017\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0002J \u0010\u0018\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0002J*\u0010\u001a\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010\u001b\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0002J\"\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\nH\u0002J\"\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u001e\u0010$\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0!2\u0006\u0010#\u001a\u00020\nH\u0002J\u001a\u0010'\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010(\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010)\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010*\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\u0007H\u0002J\u0018\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0002J\b\u0010/\u001a\u00020\u000eH\u0002J \u00100\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0002J*\u00103\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000b2\b\u00102\u001a\u0004\u0018\u000101H\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u000204H\u0002J\u0010\u00107\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u00020\nH\u0014J\b\u0010:\u001a\u00020\u000eH\u0014J\b\u0010;\u001a\u00020\u000eH\u0014J\b\u0010<\u001a\u00020\u000eH\u0014J \u0010=\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0014J \u0010>\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0014J\u001c\u0010C\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010D\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010F\u001a\u00020\u00072\b\u0010E\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010H\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040G0\tj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040G`\u000bH\u0016J \u0010I\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0014J \u0010J\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0014J \u0010K\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\tj\b\u0012\u0004\u0012\u00020\u0015`\u000bH\u0014J\u0012\u0010M\u001a\u00020\u00072\b\u0010L\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010O\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR$\u0010Z\u001a\u00020T2\u0006\u0010U\u001a\u00020T8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006b"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxAlbumDetailOperatePanelPart;", "Lcom/qzone/reborn/albumx/common/part/i;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "qb", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "rightList", "wb", "", "pb", "Pa", "", "", "", "getReportParams", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "mediaList", "Ya", "Xa", QzoneIPCModule.RESULT_CODE, "Va", "fb", "emId", "view", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "vb", "ub", "", "typeList", "index", "Ua", "Landroid/content/Intent;", "data", UinConfigManager.KEY_HB, "kb", "nb", "ib", "Sa", "Ja", "Qa", "Ta", "ob", "Ma", "Landroid/content/DialogInterface;", "dialog", "Ia", "Lcom/qzone/reborn/albumx/common/viewmodel/a;", "info", "rb", "onInitView", "selectCount", "na", "V9", "U9", "W9", "Q9", "P9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "S9", "R9", "O9", "v", NodeProps.ON_CLICK, "requestCode", "onActivityResult", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "llSort", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "<set-?>", "K", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "Ra", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "initBean", "L", "Ljava/lang/String;", "activityResultCode", "<init>", "()V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumDetailOperatePanelPart extends com.qzone.reborn.albumx.common.part.i implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout llSort;

    /* renamed from: K, reason: from kotlin metadata */
    private QZAlbumxAlbumDetailInitBean initBean;

    /* renamed from: L, reason: from kotlin metadata */
    private String activityResultCode = "0";

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxAlbumDetailOperatePanelPart$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<CommonStMedia> f52860b;

        c(ArrayList<CommonStMedia> arrayList) {
            this.f52860b = arrayList;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QZAlbumxAlbumDetailOperatePanelPart.this.L9().m2(QZAlbumxAlbumDetailOperatePanelPart.this.Ra().getUin(), "0", this.f52860b);
        }
    }

    private final void Ia(ArrayList<CommonStMedia> mediaList, DialogInterface dialog) {
        if (ub.d.f438671a.d(mediaList)) {
            if (dialog != null) {
                dialog.dismiss();
            }
            L9().d2().postValue(Boolean.FALSE);
            L9().b2().clear();
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.stc, 0).show();
            return;
        }
        Ja();
    }

    private final void Ja() {
        String qqStr;
        MutableLiveData<CommonAlbumInfo> M1;
        CommonAlbumInfo value;
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
        boolean z16 = false;
        if (yVar != null && (M1 = yVar.M1()) != null && (value = M1.getValue()) != null && value.getIsShareAlbum()) {
            z16 = true;
        }
        if (z16) {
            qqStr = HardCodeUtil.qqStr(R.string.f134759o);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f134749n);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, HardCodeUtil.qqStr(R.string.ssh), qqStr, HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ac
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxAlbumDetailOperatePanelPart.Ka(QZAlbumxAlbumDetailOperatePanelPart.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ad
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxAlbumDetailOperatePanelPart.La(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nt -> dialog1.dismiss() }");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(QZAlbumxAlbumDetailOperatePanelPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    private final void Ma(final ArrayList<CommonStMedia> mediaList) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, HardCodeUtil.qqStr(R.string.sxp), HardCodeUtil.qqStr(R.string.stc), HardCodeUtil.qqStr(R.string.sqw), HardCodeUtil.qqStr(R.string.srk), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxAlbumDetailOperatePanelPart.Na(QZAlbumxAlbumDetailOperatePanelPart.this, mediaList, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.aa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QZAlbumxAlbumDetailOperatePanelPart.Oa(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026nt -> dialog1.dismiss() }");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(QZAlbumxAlbumDetailOperatePanelPart this$0, ArrayList mediaList, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        this$0.Ia(mediaList, dialogInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(DialogInterface dialog1, int i3) {
        Intrinsics.checkNotNullParameter(dialog1, "dialog1");
        dialog1.dismiss();
    }

    private final void Pa() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        fo.c.p("em_qz_batch_operation_download", "pg_qz_photo_list_new", I9(), linkedHashMap);
        fo.c.p("em_qz_batch_operation_del", "pg_qz_photo_list_new", H9(), linkedHashMap);
        fo.c.p("em_qz_batch_operation_copy", "pg_qz_photo_list_new", K9(), linkedHashMap);
        fo.c.p("em_qz_batch_operation_reprinted", "pg_qz_photo_list_new", getLlChangeAlbum(), linkedHashMap);
        fo.c.p("em_qz_batch_operation_more", "pg_qz_photo_list_new", getLlMore(), linkedHashMap);
        fo.c.p("em_qz_batch_operation_sort", "pg_qz_photo_list_new", this.llSort, linkedHashMap);
    }

    private final void Qa() {
        if (F9().M1().getValue() == null) {
            return;
        }
        wa.a aVar = new wa.a();
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        Intrinsics.checkNotNull(F9, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
        QZAlbumxAlbumDetailInitBean mInitBean = ((nc.y) F9).getMInitBean();
        aVar.f(mInitBean != null ? mInitBean.getUin() : null);
        CommonAlbumInfo value = F9().M1().getValue();
        aVar.e(value != null ? value.getAlbumId() : null);
        aVar.g(Ta());
        aVar.h(0);
        com.qzone.reborn.albumx.common.viewmodel.b F92 = F9();
        Intrinsics.checkNotNull(F92, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.viewmodel.QZAlbumxAlbumDetailViewModel");
        aVar.j(((nc.y) F92).getDataRepo());
        L9().T1(aVar);
        L9().Q1();
    }

    private final ArrayList<CommonStMedia> Sa() {
        if (Intrinsics.areEqual(this.activityResultCode, "6")) {
            com.qzone.reborn.albumx.common.viewmodel.e L9 = L9();
            nc.ap apVar = L9 instanceof nc.ap ? (nc.ap) L9 : null;
            List<CommonStMedia> p26 = apVar != null ? apVar.p2() : null;
            if (p26 == null) {
                return new ArrayList<>();
            }
            return new ArrayList<>(p26);
        }
        return L9().W1();
    }

    private final ArrayList<CommonStMedia> Ta() {
        if (ob()) {
            return L9().W1();
        }
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        for (CommonStMedia commonStMedia : L9().W1()) {
            ub.d dVar = ub.d.f438671a;
            String str = commonStMedia.getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String();
            if (str == null) {
                str = "";
            }
            if (dVar.f(str)) {
                arrayList.add(commonStMedia);
            }
        }
        return arrayList;
    }

    private final int Ua(List<Integer> typeList, int index) {
        if (typeList.isEmpty() || index < 0 || index >= typeList.size()) {
            return -1;
        }
        return typeList.get(index).intValue();
    }

    private final void Va(ArrayList<CommonStMedia> mediaList, String resultCode) {
        List<CommonStTimeLineEvent> value;
        ArrayList<CommonMediaLbsArea> a16;
        Intent l3 = com.qzone.common.activities.base.ak.l(getActivity(), QZoneHelper.MOOD_SELECT_LOCATION);
        l3.putExtra("show_nearby_poi", true);
        l3.putExtra("key_show_first_line", 0);
        l3.putExtra("key_from_album", true);
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
        if (yVar == null || (value = yVar.J2().getValue()) == null) {
            return;
        }
        if (value.size() > 0) {
            l3.putExtra("photo_list_start_shoot_time", value.get(0).getBeginTime());
        }
        ArrayList arrayList = new ArrayList();
        CommonMediaLbsAreaList mediaLbsAreaList = yVar.getMediaLbsAreaList();
        if (mediaLbsAreaList != null && (a16 = mediaLbsAreaList.a()) != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : a16) {
                if (((CommonMediaLbsArea) obj).getSceneryName().length() > 0) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(fb.a.M((CommonMediaLbsArea) it.next()));
            }
        }
        this.activityResultCode = resultCode;
        ParcelableWrapper.putArrayListToIntent(l3, "PHOTO_POI_AREA", arrayList);
        com.qzone.feed.utils.b.e(getActivity(), l3, 1208);
    }

    private final void Xa(ArrayList<CommonStMedia> mediaList) {
        if (mediaList.isEmpty()) {
            QLog.e(getTAG(), 1, "handleOnClickChangeMediaTime mediaList is empty");
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        com.tencent.mobileqq.widget.selectorview.e eVar = new com.tencent.mobileqq.widget.selectorview.e(activity);
        eVar.k("\u9009\u62e9\u65f6\u95f4");
        Calendar calendar = Calendar.getInstance();
        eVar.F(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        eVar.i(new b(eVar, this, mediaList));
        eVar.m();
    }

    private final void Ya(ArrayList<CommonStMedia> mediaList) {
        CommonRecommendMedia recommendMedia;
        CommonAlbumInfo value = F9().M1().getValue();
        if (value == null) {
            return;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        com.qzone.reborn.albumx.qzonex.view.u uVar = new com.qzone.reborn.albumx.qzonex.view.u(activity, value, mediaList);
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
        if (yVar != null && (recommendMedia = yVar.getRecommendMedia()) != null) {
            ArrayList<PhotoCacheData> arrayList = new ArrayList<>();
            Iterator<T> it = recommendMedia.a().iterator();
            while (it.hasNext()) {
                arrayList.add(fb.a.L((CommonStMedia) it.next()));
            }
            uVar.M(recommendMedia.getRecommendId(), arrayList);
        }
        uVar.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(QZAlbumxAlbumDetailOperatePanelPart this$0, ArrayList mediaList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        this$0.Ya(mediaList);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ab(QZAlbumxAlbumDetailOperatePanelPart this$0, ArrayList mediaList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        this$0.Xa(mediaList);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bb(QZAlbumxAlbumDetailOperatePanelPart this$0, ArrayList mediaList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        Wa(this$0, mediaList, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cb(QZAlbumxAlbumDetailOperatePanelPart this$0, ArrayList mediaList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        this$0.S9(mediaList);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eb(QZAlbumxAlbumDetailOperatePanelPart this$0, BusinessAlbumInfo businessAlbumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.activityResultCode = "3";
        vb.b bVar = (vb.b) ho.i.t(vb.b.class);
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String accountId = RFWApplication.getAccountId();
        if (accountId == null) {
            accountId = "";
        }
        BusinessAlbumInfo k3 = n5.d.l().k();
        String str = k3 != null ? k3.mAlbumId : null;
        if (str == null) {
            str = this$0.Ra().getAlbumId();
        }
        bVar.n(activity, QZoneContant.QZ_SELECT_ALBUM, new QZAlbumxUploadSelectAlbumInitBean(accountId, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.widget.ActionSheet, T] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.util.ArrayList] */
    private final void fb(ArrayList<CommonStMedia> mediaList) {
        MutableLiveData<CommonAlbumInfo> M1;
        CommonAlbumInfo value;
        final Map<Integer, Integer> q26;
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
        if (yVar == null || (M1 = yVar.M1()) == null || (value = M1.getValue()) == null) {
            return;
        }
        int sortType = value.getSortType();
        com.qzone.reborn.albumx.common.viewmodel.e L9 = L9();
        nc.ap apVar = L9 instanceof nc.ap ? (nc.ap) L9 : null;
        if (apVar == null || (q26 = apVar.q2()) == null) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        objectRef.element = (ActionSheet) createDialog;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = new ArrayList();
        Iterator<T> it = q26.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            Integer num = q26.get(Integer.valueOf(intValue));
            if (num != null) {
                int intValue2 = num.intValue();
                ((ActionSheet) objectRef.element).addRadioButton(intValue, intValue2 == sortType);
                if (intValue2 == sortType) {
                    i3 = ((List) objectRef2.element).size();
                }
                ((List) objectRef2.element).add(Integer.valueOf(intValue));
            }
        }
        ((ActionSheet) objectRef.element).setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ae
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                QZAlbumxAlbumDetailOperatePanelPart.gb(Ref.ObjectRef.this, q26, this, objectRef2, view, i16);
            }
        });
        ((ActionSheet) objectRef.element).addCancelButton(R.string.f134418r);
        ((ActionSheet) objectRef.element).show();
        vb("em_qz_batch_operation_sort_float", ((ActionSheet) objectRef.element).getActionContentView(), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void gb(Ref.ObjectRef actionSheetWithSelect, Map sortTypeMap, QZAlbumxAlbumDetailOperatePanelPart this$0, Ref.ObjectRef typeList, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheetWithSelect, "$actionSheetWithSelect");
        Intrinsics.checkNotNullParameter(sortTypeMap, "$sortTypeMap");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(typeList, "$typeList");
        ((ActionSheet) actionSheetWithSelect.element).dismiss();
        Integer num = (Integer) sortTypeMap.get(Integer.valueOf(this$0.Ua((List) typeList.element, i3)));
        if (num != null) {
            int intValue = num.intValue();
            com.qzone.reborn.albumx.common.viewmodel.b F9 = this$0.F9();
            nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
            if (yVar != null) {
                CommonAlbumInfo value = yVar.M1().getValue();
                yVar.w2(value != null ? value.getAlbumId() : null, intValue);
                this$0.L9().Q1();
            }
            this$0.ub("em_qz_batch_operation_sort_float", view, i3);
        }
    }

    private final Map<String, Object> getReportParams() {
        String str;
        CommonAlbumInfo value;
        CommonAlbumAccessPermission commonAlbumAccessPermission;
        String name;
        CommonAlbumInfo value2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        Integer num = null;
        nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
        if (yVar == null) {
            return linkedHashMap;
        }
        mc.d dVar = mc.d.f416543a;
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        MutableLiveData<CommonAlbumInfo> M1 = yVar.M1();
        linkedHashMap.put("topic_type", Integer.valueOf(dVar.a(cVar.c((M1 == null || (value2 = M1.getValue()) == null) ? null : Integer.valueOf(value2.getQzAlbumType())))));
        CommonAlbumInfo value3 = yVar.M1().getValue();
        String str2 = "";
        if (value3 == null || (str = value3.getAlbumId()) == null) {
            str = "";
        }
        linkedHashMap.put("albumid", str);
        CommonAlbumInfo value4 = yVar.M1().getValue();
        if (value4 != null && (name = value4.getName()) != null) {
            str2 = name;
        }
        linkedHashMap.put("album_name", str2);
        MutableLiveData<CommonAlbumInfo> M12 = yVar.M1();
        linkedHashMap.put("user_identity", Integer.valueOf(dVar.b(M12 != null ? M12.getValue() : null)));
        MutableLiveData<CommonAlbumInfo> M13 = yVar.M1();
        if (M13 != null && (value = M13.getValue()) != null && (commonAlbumAccessPermission = value.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String()) != null) {
            num = Integer.valueOf(commonAlbumAccessPermission.getPermissionType());
        }
        linkedHashMap.put(MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME, Integer.valueOf(dVar.c(num)));
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jb(QZAlbumxAlbumDetailOperatePanelPart this$0, Boolean result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        if (result.booleanValue()) {
            this$0.L9().h2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lb(String resultCode, QZAlbumxAlbumDetailOperatePanelPart this$0, Boolean result) {
        Intrinsics.checkNotNullParameter(resultCode, "$resultCode");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        if (result.booleanValue() && Intrinsics.areEqual(resultCode, "5")) {
            this$0.L9().h2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mb(String resultCode, QZAlbumxAlbumDetailOperatePanelPart this$0, Boolean result) {
        Intrinsics.checkNotNullParameter(resultCode, "$resultCode");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        if (result.booleanValue() && Intrinsics.areEqual(resultCode, "5")) {
            this$0.L9().h2();
        }
    }

    private final boolean ob() {
        MutableLiveData<CommonAlbumInfo> M1;
        com.qzone.reborn.albumx.qzonex.utils.c cVar = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        CommonAlbumInfo commonAlbumInfo = null;
        nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
        if (yVar != null && (M1 = yVar.M1()) != null) {
            commonAlbumInfo = M1.getValue();
        }
        return cVar.f(commonAlbumInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rb(com.qzone.reborn.albumx.common.viewmodel.a info) {
        if (info.c()) {
            QQToast.makeText(BaseApplication.getContext(), 5, R.string.slz, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.i
    public void O9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        super.O9(mediaList);
        this.activityResultCode = "4";
        vb.b bVar = (vb.b) ho.i.t(vb.b.class);
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        String accountId = RFWApplication.getAccountId();
        if (accountId == null) {
            accountId = "";
        }
        bVar.n(activity, QZoneContant.QZ_SELECT_ALBUM, new QZAlbumxUploadSelectAlbumInitBean(accountId, Ra().getAlbumId()));
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void P9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.to9, 0).show();
        } else if (!ub.d.f438671a.e(mediaList) && !ob()) {
            Ma(mediaList);
        } else {
            Ja();
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void Q9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.to9, 0).show();
        } else if (QZonePermission.requestStoragePermission(getActivity(), new c(mediaList), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            L9().m2(Ra().getUin(), "0", mediaList);
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void R9(final ArrayList<CommonStMedia> mediaList) {
        MutableLiveData<ArrayList<Integer>> E2;
        ArrayList<Integer> value;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        com.qzone.reborn.widget.f fVar = new com.qzone.reborn.widget.f(activity, new com.qzone.reborn.widget.a());
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
        if (yVar == null || (E2 = yVar.E2()) == null || (value = E2.getValue()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Map<String, Object> reportParams = getReportParams();
        if (pb(value) && value.contains(14)) {
            String string = getActivity().getResources().getString(R.string.rfw);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026ng.qzone_feedx_menu_copy)");
            com.qzone.reborn.widget.b bVar = new com.qzone.reborn.widget.b(R.drawable.qui_copy_light, string, new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxAlbumDetailOperatePanelPart.cb(QZAlbumxAlbumDetailOperatePanelPart.this, mediaList, view);
                }
            });
            bVar.g("em_qz_batch_operation_copy");
            bVar.h("pg_qz_photo_list_new");
            if (!reportParams.isEmpty()) {
                bVar.e().putAll(reportParams);
            }
            arrayList.add(bVar);
        }
        if (value.contains(16)) {
            String string2 = getActivity().getResources().getString(R.string.f169521jg3);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt\u2026.qzone_albumx_make_video)");
            com.qzone.reborn.widget.b bVar2 = new com.qzone.reborn.widget.b(R.drawable.qui_play_circle, string2, new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxAlbumDetailOperatePanelPart.Za(QZAlbumxAlbumDetailOperatePanelPart.this, mediaList, view);
                }
            });
            bVar2.g("em_qz_batch_operation_make_video");
            bVar2.h("pg_qz_photo_list_new");
            if (!reportParams.isEmpty()) {
                bVar2.e().putAll(reportParams);
            }
            arrayList.add(bVar2);
        }
        if (value.contains(17)) {
            String string3 = getActivity().getResources().getString(R.string.s27);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.resources.getSt\u2026.qqstr_qzoneper_eaf4d728)");
            com.qzone.reborn.widget.b bVar3 = new com.qzone.reborn.widget.b(R.drawable.qui_time, string3, new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxAlbumDetailOperatePanelPart.ab(QZAlbumxAlbumDetailOperatePanelPart.this, mediaList, view);
                }
            });
            bVar3.g("em_qz_batch_operation_change_time");
            bVar3.h("pg_qz_photo_list_new");
            if (!reportParams.isEmpty()) {
                bVar3.e().putAll(reportParams);
            }
            arrayList.add(bVar3);
        }
        if (value.contains(18)) {
            String string4 = getActivity().getResources().getString(R.string.s1q);
            Intrinsics.checkNotNullExpressionValue(string4, "activity.resources.getSt\u2026.qqstr_qzoneper_23bcc8d7)");
            com.qzone.reborn.widget.b bVar4 = new com.qzone.reborn.widget.b(R.drawable.qui_position, string4, new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZAlbumxAlbumDetailOperatePanelPart.bb(QZAlbumxAlbumDetailOperatePanelPart.this, mediaList, view);
                }
            });
            bVar4.g("em_qz_batch_operation_change_place");
            bVar4.h("pg_qz_photo_list_new");
            if (!reportParams.isEmpty()) {
                bVar4.e().putAll(reportParams);
            }
            arrayList.add(bVar4);
        }
        fVar.Y(arrayList);
        ef.d.f(fVar, getActivity());
    }

    public final QZAlbumxAlbumDetailInitBean Ra() {
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.initBean;
        if (qZAlbumxAlbumDetailInitBean != null) {
            return qZAlbumxAlbumDetailInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void S9(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (mediaList.size() > 100) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.tag, 0).show();
            return;
        }
        ArrayList<NetImageInfo> arrayList = new ArrayList<>();
        for (CommonStMedia commonStMedia : mediaList) {
            NetImageInfo netImageInfo = new NetImageInfo();
            netImageInfo.lloc = commonStMedia.k();
            netImageInfo.mAlbumId = Ra().getAlbumId();
            netImageInfo.mBigPath = commonStMedia.l();
            arrayList.add(netImageInfo);
        }
        n5.d.l().s(1);
        n5.d.l().r(new d.g() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.af
            @Override // n5.d.g
            public final void a(BusinessAlbumInfo businessAlbumInfo) {
                QZAlbumxAlbumDetailOperatePanelPart.eb(QZAlbumxAlbumDetailOperatePanelPart.this, businessAlbumInfo);
            }
        });
        n5.d.l().u(new hc.b());
        n5.d l3 = n5.d.l();
        Activity activity = getActivity();
        long k3 = ef.d.k(Ra().getUin());
        d.e eVar = new d.e();
        eVar.f418370c = "\u590d\u5236\u5230";
        eVar.f418369b = R.string.rfw;
        Unit unit = Unit.INSTANCE;
        BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(Ra().getAlbumId());
        businessAlbumInfo.mTitle = Ra().getAlbumName();
        l3.q(activity, arrayList, 4, k3, null, eVar, businessAlbumInfo);
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected boolean U9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected boolean V9() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected boolean W9() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        kb(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if (r2.equals("5") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if (r2.equals("6") == false) goto L24;
     */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1010) {
            hb(resultCode, data);
            return;
        }
        String str = this.activityResultCode;
        switch (str.hashCode()) {
            case 51:
                if (str.equals("3")) {
                    nb(data);
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    ib(data);
                    break;
                }
                break;
        }
        this.activityResultCode = "0";
    }

    @Override // com.qzone.reborn.albumx.common.part.i, android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!com.qzone.util.h.a()) {
            if (v3 != null && v3.getId() == R.id.mgh) {
                fb(L9().W1());
            } else if (L9().W1().size() == 0) {
                QQToast.makeText(getContext(), "\u8bf7\u5148\u9009\u62e9\u7167\u7247\u54e6", 0).show();
            } else if (L9().W1().size() > 50) {
                QQToast.makeText(getContext(), "\u6700\u591a\u9009\u62e950\u5f20", 0).show();
            } else {
                super.onClick(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.qzone.reborn.albumx.common.part.i, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Activity activity = getActivity();
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = serializableExtra instanceof QZAlbumxAlbumDetailInitBean ? (QZAlbumxAlbumDetailInitBean) serializableExtra : null;
        Intrinsics.checkNotNull(qZAlbumxAlbumDetailInitBean);
        this.initBean = qZAlbumxAlbumDetailInitBean;
        MutableLiveData<com.qzone.reborn.albumx.common.viewmodel.a> X1 = L9().X1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.qzone.reborn.albumx.common.viewmodel.a, Unit> function1 = new Function1<com.qzone.reborn.albumx.common.viewmodel.a, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailOperatePanelPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.qzone.reborn.albumx.common.viewmodel.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.qzone.reborn.albumx.common.viewmodel.a aVar) {
                if (aVar == null) {
                    return;
                }
                QZAlbumxAlbumDetailOperatePanelPart.this.rb(aVar);
            }
        };
        X1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumxAlbumDetailOperatePanelPart.sb(Function1.this, obj);
            }
        });
        qb(rootView);
        Pa();
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
        if (yVar != null) {
            MutableLiveData<ArrayList<Integer>> E2 = yVar.E2();
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            final Function1<ArrayList<Integer>, Unit> function12 = new Function1<ArrayList<Integer>, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxAlbumDetailOperatePanelPart$onInitView$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<Integer> arrayList) {
                    invoke2(arrayList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ArrayList<Integer> arrayList) {
                    QZAlbumxAlbumDetailOperatePanelPart.this.wb(arrayList);
                }
            };
            E2.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZAlbumxAlbumDetailOperatePanelPart.tb(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        n5.d.l().r(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZAlbumxModifyLocationEvent) {
            Va(((QZAlbumxModifyLocationEvent) event).getMediaList(), "6");
        } else if (event instanceof QZAlbumxModifyTimeEvent) {
            Xa(((QZAlbumxModifyTimeEvent) event).getMediaList());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZAlbumxModifyLocationEvent.class, QZAlbumxModifyTimeEvent.class);
        return arrayListOf;
    }

    private final void kb(Intent data) {
        List<com.qzone.reborn.albumx.common.bean.a> data2;
        if (data == null || data.getExtras() == null) {
            return;
        }
        SmartParcelable dataFromBudle = ParcelableWrapper.getDataFromBudle(data.getExtras(), "key_select_photo_list_poi");
        PhotoPoiArea photoPoiArea = dataFromBudle instanceof PhotoPoiArea ? (PhotoPoiArea) dataFromBudle : null;
        Bundle extras = data.getExtras();
        Intrinsics.checkNotNull(extras);
        Parcelable parcelable = extras.getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
        LbsDataV2.PoiInfo poiInfo = parcelable instanceof LbsDataV2.PoiInfo ? (LbsDataV2.PoiInfo) parcelable : null;
        com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
        nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
        if (yVar == null) {
            return;
        }
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> value = yVar.O1().getValue();
        if (value != null && (data2 = value.getData()) != null) {
            Intrinsics.checkNotNullExpressionValue(data2, "data");
            Iterator<T> it = data2.iterator();
            while (it.hasNext()) {
                arrayList.addAll(((com.qzone.reborn.albumx.common.bean.a) it.next()).getBatchInfo().j());
            }
        }
        final String str = this.activityResultCode;
        ArrayList<CommonStMedia> Sa = Sa();
        boolean areEqual = Intrinsics.areEqual(str, "6");
        if (photoPoiArea != null) {
            yVar.u2(Sa, yVar.getMediaLbsAreaList(), fb.a.x(photoPoiArea), true, arrayList, areEqual, new Consumer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ag
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    QZAlbumxAlbumDetailOperatePanelPart.lb(str, this, (Boolean) obj);
                }
            });
        } else if (poiInfo != null) {
            yVar.u2(Sa, yVar.getMediaLbsAreaList(), fb.a.y(poiInfo), true, arrayList, areEqual, new Consumer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ah
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    QZAlbumxAlbumDetailOperatePanelPart.mb(str, this, (Boolean) obj);
                }
            });
        }
    }

    private final boolean pb(ArrayList<Integer> rightList) {
        return rightList.contains(21);
    }

    private final void ib(Intent data) {
        Bundle extras;
        Object obj = (data == null || (extras = data.getExtras()) == null) ? null : extras.get("SELECTED_ALBUM_INFO");
        CommonAlbumInfo commonAlbumInfo = obj instanceof CommonAlbumInfo ? (CommonAlbumInfo) obj : null;
        if (commonAlbumInfo != null) {
            com.qzone.reborn.albumx.common.viewmodel.b F9 = F9();
            nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
            if (yVar != null) {
                yVar.T2(L9().W1(), commonAlbumInfo, new Consumer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.ab
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj2) {
                        QZAlbumxAlbumDetailOperatePanelPart.jb(QZAlbumxAlbumDetailOperatePanelPart.this, (Boolean) obj2);
                    }
                });
            }
        }
    }

    private final void nb(Intent data) {
        Bundle extras;
        Object obj = (data == null || (extras = data.getExtras()) == null) ? null : extras.get("SELECTED_ALBUM_INFO");
        CommonAlbumInfo commonAlbumInfo = obj instanceof CommonAlbumInfo ? (CommonAlbumInfo) obj : null;
        if (commonAlbumInfo != null) {
            n5.d l3 = n5.d.l();
            BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(commonAlbumInfo.getAlbumId());
            businessAlbumInfo.mTitle = commonAlbumInfo.getName();
            businessAlbumInfo.mPrivacy = commonAlbumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType();
            businessAlbumInfo.mCover = commonAlbumInfo.getCover().l();
            l3.v(businessAlbumInfo);
        }
    }

    private final void qb(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.mgh);
        this.llSort = linearLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
            rn.h.a((ImageView) rootView.findViewById(R.id.lvb), "qui_sort", R.color.qui_common_icon_primary);
        }
    }

    private final void ub(String emId, View view, int clickType) {
        if (view == null) {
            return;
        }
        Map<String, Object> reportParams = getReportParams();
        reportParams.put("click_type", Integer.valueOf(clickType));
        fo.c.e(emId, "pg_qz_photo_list_new", view, reportParams);
    }

    private final void vb(String emId, View view, int clickType) {
        if (view == null) {
            return;
        }
        Map<String, Object> reportParams = getReportParams();
        reportParams.put("click_type", Integer.valueOf(clickType));
        fo.c.g(emId, "pg_qz_photo_list_new", view, reportParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.View] */
    public final void wb(ArrayList<Integer> rightList) {
        if (rightList == null) {
            return;
        }
        LinearLayout I9 = I9();
        Boolean valueOf = Boolean.valueOf(rightList.contains(11));
        I9.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, I9)) == null) {
            I9.setVisibility(8);
        }
        LinearLayout H9 = H9();
        Boolean valueOf2 = Boolean.valueOf(rightList.contains(12));
        H9.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, H9)) == null) {
            H9.setVisibility(8);
        }
        LinearLayout llChangeAlbum = getLlChangeAlbum();
        if (llChangeAlbum != null) {
            Boolean valueOf3 = Boolean.valueOf(rightList.contains(15));
            llChangeAlbum.setVisibility(0);
            ?? r16 = (View) com.tencent.guild.aio.util.ex.g.a(valueOf3, llChangeAlbum);
            if (r16 == 0) {
                llChangeAlbum.setVisibility(8);
            } else {
                llChangeAlbum = r16;
            }
        }
        LinearLayout linearLayout = this.llSort;
        if (linearLayout != null) {
            Boolean valueOf4 = Boolean.valueOf(rightList.contains(21));
            linearLayout.setVisibility(0);
            ?? r17 = (View) com.tencent.guild.aio.util.ex.g.a(valueOf4, linearLayout);
            if (r17 == 0) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout = r17;
            }
        }
        LinearLayout llMore = getLlMore();
        if (llMore != null) {
            Boolean valueOf5 = Boolean.valueOf(rightList.contains(16) || rightList.contains(17) || rightList.contains(18) || (pb(rightList) && rightList.contains(14)));
            llMore.setVisibility(0);
            ?? r56 = (View) com.tencent.guild.aio.util.ex.g.a(valueOf5, llMore);
            if (r56 == 0) {
                llMore.setVisibility(8);
            } else {
                llMore = r56;
            }
        }
        LinearLayout K9 = K9();
        Boolean valueOf6 = Boolean.valueOf(!pb(rightList) && rightList.contains(14));
        K9.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf6, K9)) == null) {
            K9.setVisibility(8);
        }
    }

    static /* synthetic */ void Wa(QZAlbumxAlbumDetailOperatePanelPart qZAlbumxAlbumDetailOperatePanelPart, ArrayList arrayList, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "5";
        }
        qZAlbumxAlbumDetailOperatePanelPart.Va(arrayList, str);
    }

    private final void hb(int resultCode, Intent data) {
        if (resultCode != -1) {
            return;
        }
        if (Intrinsics.areEqual(L9().d2().getValue(), Boolean.FALSE)) {
            L9().d2().setValue(Boolean.TRUE);
        }
        Object a16 = com.qzone.reborn.feedx.util.m.a("extra_key_parcelable_selected_list_for_result_batch_layer");
        ArrayList<QZAlbumxBatchLayerSelectedMediaInfoBean> arrayList = a16 instanceof ArrayList ? (ArrayList) a16 : null;
        QZAlbumxBatchLayerSelectedMediaInfoBean qZAlbumxBatchLayerSelectedMediaInfoBean = data != null ? (QZAlbumxBatchLayerSelectedMediaInfoBean) data.getParcelableExtra("batch_selector_result_cur_media") : null;
        if (!(qZAlbumxBatchLayerSelectedMediaInfoBean instanceof QZAlbumxBatchLayerSelectedMediaInfoBean)) {
            qZAlbumxBatchLayerSelectedMediaInfoBean = null;
        }
        com.qzone.reborn.albumx.common.viewmodel.e L9 = L9();
        nc.ap apVar = L9 instanceof nc.ap ? (nc.ap) L9 : null;
        if (apVar != null) {
            apVar.r2(arrayList, qZAlbumxBatchLayerSelectedMediaInfoBean);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxAlbumDetailOperatePanelPart$b", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.e f52856d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZAlbumxAlbumDetailOperatePanelPart f52857e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList<CommonStMedia> f52858f;

        b(com.tencent.mobileqq.widget.selectorview.e eVar, QZAlbumxAlbumDetailOperatePanelPart qZAlbumxAlbumDetailOperatePanelPart, ArrayList<CommonStMedia> arrayList) {
            this.f52856d = eVar;
            this.f52857e = qZAlbumxAlbumDetailOperatePanelPart;
            this.f52858f = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QZAlbumxAlbumDetailOperatePanelPart this$0, Boolean result) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(result, "result");
            if (result.booleanValue()) {
                this$0.L9().h2();
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            long D = this.f52856d.D();
            com.qzone.reborn.albumx.common.viewmodel.b F9 = this.f52857e.F9();
            nc.y yVar = F9 instanceof nc.y ? (nc.y) F9 : null;
            if (yVar != null) {
                ArrayList<CommonStMedia> arrayList = this.f52858f;
                final QZAlbumxAlbumDetailOperatePanelPart qZAlbumxAlbumDetailOperatePanelPart = this.f52857e;
                yVar.s2(arrayList, D, new Consumer() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.aj
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        QZAlbumxAlbumDetailOperatePanelPart.b.b(QZAlbumxAlbumDetailOperatePanelPart.this, (Boolean) obj);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }

    @Override // com.qzone.reborn.albumx.common.part.i
    protected void na(int selectCount) {
    }
}
