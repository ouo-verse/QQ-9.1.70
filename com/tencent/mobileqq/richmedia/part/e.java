package com.tencent.mobileqq.richmedia.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.richmedia.depend.RichMediaDownloadType;
import com.tencent.mobileqq.richmedia.event.FileVideoDownloadFinishEvent;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.event.RFWLayerFileStateChangeEvent;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.util.PermissionUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001IB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001a\u0010\u0019\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001a\u0010 \u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0014\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J\u001a\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0016\u0010.\u001a\u00020\u00062\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0016J\u000e\u00101\u001a\u00020\u00062\u0006\u0010\f\u001a\u000200J\u0012\u00103\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050504H\u0016J\u0018\u0010:\u001a\u00020\r2\u0006\u00107\u001a\u00020!2\u0006\u00109\u001a\u000208H\u0016J\u0010\u0010;\u001a\u00020\r2\u0006\u00107\u001a\u00020!H\u0016J\u0010\u0010<\u001a\u00020\u00062\u0006\u00107\u001a\u00020!H\u0016J*\u0010?\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010=\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010A\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0016JB\u0010E\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010=\u001a\u00020\r2\b\u0010B\u001a\u0004\u0018\u00010\b2\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\b04j\b\u0012\u0004\u0012\u00020\b`C2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/richmedia/part/e;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaProvider;", "Lcom/tencent/mobileqq/richmedia/depend/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "A9", "", "errorMsg", "F9", "Lcom/tencent/mobileqq/richmedia/depend/RichMediaDownloadType;", "type", "", "B9", "targetMediaId", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState$FileState;", "state", "", "percent", "", "totalSize", "H9", "mediaId", "path", "K9", "I9", "J9", "L9", "Lcom/tencent/richframework/data/base/UIStateData$ModifyListRecord;", "modifyRecord", "updateRichMediaList", "E9", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "findMediaInfoWithMediaId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "uiStateData", "onChanged", "onPartDestroy", "", "D9", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "mediaInfo", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$PicType;", "picType", "downloadPic", "getVideoUrl", "saveToAlbum", "isSuccess", "targetPath", "I7", "progress", "K8", "localPath", "Lkotlin/collections/ArrayList;", CoverDBCacheData.URLS, "p9", "<init>", "()V", "d", "a", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e extends RFWLayerBasePart implements IMediaProvider, com.tencent.mobileqq.richmedia.depend.b, SimpleEventReceiver<SimpleBaseEvent> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f281660a;

        static {
            int[] iArr = new int[RichMediaDownloadType.values().length];
            try {
                iArr[RichMediaDownloadType.TYPE_ORIGINAL_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RichMediaDownloadType.TYPE_SAVE_ORIGINAL_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RichMediaDownloadType.TYPE_SAVE_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RichMediaDownloadType.TYPE_LARGE_IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RichMediaDownloadType.TYPE_THUMB_IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f281660a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/richmedia/part/e$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f281662b;

        c(String str) {
            this.f281662b = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            dn2.c cVar = dn2.c.f394314a;
            Context context = e.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            cVar.e(context, this.f281662b, true, e.this.getActivity().getIntent().getBooleanExtra("save_use_origin_name", false));
        }
    }

    private final void A9() {
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = getMLayerViewModel().mRichMediaInfo;
        UIStateData obtainDelete = UIStateData.obtainDelete();
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        Intrinsics.checkNotNull(value);
        RFWLayerState data = value.getData();
        RFWLayerState rFWLayerState = data;
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        rFWLayerState.setRichMediaDataList(eVar.f());
        rFWLayerState.setSelectedPosition(eVar.c());
        Unit unit = Unit.INSTANCE;
        mutableLiveData.setValue(obtainDelete.setDataList(data));
    }

    private final boolean B9(RichMediaDownloadType type) {
        if (type != RichMediaDownloadType.TYPE_ORIGINAL_IMAGE && type != RichMediaDownloadType.TYPE_SAVE_ORIGINAL_IMAGE && type != RichMediaDownloadType.TYPE_SAVE_VIDEO) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(e this$0, String errorMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        this$0.F9(errorMsg);
    }

    private final void E9(String mediaId, String path) {
        QLog.i("CommonLayerControlPart", RFWLog.USR, "saveLocalFile mediaId:" + mediaId + ", path:" + path);
        if (FileUtils.fileExistsAndNotEmpty(path) && !TextUtils.isEmpty(mediaId)) {
            if (!PermissionUtil.isHasStoragePermission(getContext()) && (getContext() instanceof Activity)) {
                QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c(path));
                return;
            } else {
                dn2.c cVar = dn2.c.f394314a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                cVar.e(context, path, true, getActivity().getIntent().getBooleanExtra("save_use_origin_name", false));
                return;
            }
        }
        QLog.i("CommonLayerControlPart", RFWLog.USR, "saveLocalFile file not exist, mediaId:" + mediaId + ", path:" + path);
    }

    private final void F9(String errorMsg) {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, "", errorMsg, (String) null, getActivity().getString(R.string.zre), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.richmedia.part.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                e.G9(e.this, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(activ\u2026.onBackPressed() }, null)");
        if (!createCustomDialog.isShowing()) {
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(e this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().onBackPressed();
    }

    private final void H9(String targetMediaId, RFWLayerFileDownloadState.FileState state, float percent, long totalSize) {
        RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
        RFWLayerFileDownloadState rFWLayerFileDownloadState = new RFWLayerFileDownloadState(targetMediaId);
        rFWLayerFileDownloadState.setFileState(state);
        rFWLayerFileDownloadState.setProgressPercent(percent);
        rFWLayerFileDownloadState.setFileSize(totalSize);
        rFWLayerDataCenter.updateFileState(rFWLayerFileDownloadState);
    }

    private final void I9(String mediaId, String path) {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo2;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo3;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerItemMediaInfo findMediaInfoWithMediaId = findMediaInfoWithMediaId(mediaId);
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo4 = null;
        if (findMediaInfoWithMediaId != null && (layerPicInfo = findMediaInfoWithMediaId.getLayerPicInfo()) != null) {
            rFWPicInfo = layerPicInfo.getBigPicInfo();
        } else {
            rFWPicInfo = null;
        }
        if (rFWPicInfo != null) {
            RFWLayerPicInfo layerPicInfo2 = findMediaInfoWithMediaId.getLayerPicInfo();
            if (layerPicInfo2 != null) {
                rFWPicInfo2 = layerPicInfo2.getBigPicInfo();
            } else {
                rFWPicInfo2 = null;
            }
            if (rFWPicInfo2 != null) {
                rFWPicInfo2.setUrl(path);
            }
            RFWLayerPicInfo layerPicInfo3 = findMediaInfoWithMediaId.getLayerPicInfo();
            if (layerPicInfo3 != null) {
                rFWPicInfo3 = layerPicInfo3.getBigPicInfo();
            } else {
                rFWPicInfo3 = null;
            }
            if (rFWPicInfo3 != null) {
                rFWPicInfo3.setLocalPath(path);
            }
            RFWLayerPicInfo layerPicInfo4 = findMediaInfoWithMediaId.getLayerPicInfo();
            if (layerPicInfo4 != null) {
                RFWLayerPicInfo layerPicInfo5 = findMediaInfoWithMediaId.getLayerPicInfo();
                if (layerPicInfo5 != null) {
                    rFWPicInfo4 = layerPicInfo5.getBigPicInfo();
                }
                Intrinsics.checkNotNull(rFWPicInfo4);
                layerPicInfo4.setCurrentPicInfo(rFWPicInfo4);
            }
            UIStateData.ModifyListRecord obtainNotifyItemRangeChange = UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(this.mSelectedPosition, 1);
            Intrinsics.checkNotNullExpressionValue(obtainNotifyItemRangeChange, "obtainNotifyItemRangeChange(mSelectedPosition, 1)");
            updateRichMediaList(obtainNotifyItemRangeChange);
        }
    }

    private final void J9(String mediaId, String path) {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo2;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo3;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerItemMediaInfo findMediaInfoWithMediaId = findMediaInfoWithMediaId(mediaId);
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo4 = null;
        if (findMediaInfoWithMediaId != null && (layerPicInfo = findMediaInfoWithMediaId.getLayerPicInfo()) != null) {
            rFWPicInfo = layerPicInfo.getOriginPicInfo();
        } else {
            rFWPicInfo = null;
        }
        if (rFWPicInfo != null) {
            RFWLayerPicInfo layerPicInfo2 = findMediaInfoWithMediaId.getLayerPicInfo();
            if (layerPicInfo2 != null) {
                rFWPicInfo2 = layerPicInfo2.getOriginPicInfo();
            } else {
                rFWPicInfo2 = null;
            }
            if (rFWPicInfo2 != null) {
                rFWPicInfo2.setUrl(path);
            }
            RFWLayerPicInfo layerPicInfo3 = findMediaInfoWithMediaId.getLayerPicInfo();
            if (layerPicInfo3 != null) {
                rFWPicInfo3 = layerPicInfo3.getOriginPicInfo();
            } else {
                rFWPicInfo3 = null;
            }
            if (rFWPicInfo3 != null) {
                rFWPicInfo3.setLocalPath(path);
            }
            RFWLayerPicInfo layerPicInfo4 = findMediaInfoWithMediaId.getLayerPicInfo();
            if (layerPicInfo4 != null) {
                RFWLayerPicInfo layerPicInfo5 = findMediaInfoWithMediaId.getLayerPicInfo();
                if (layerPicInfo5 != null) {
                    rFWPicInfo4 = layerPicInfo5.getOriginPicInfo();
                }
                Intrinsics.checkNotNull(rFWPicInfo4);
                layerPicInfo4.setCurrentPicInfo(rFWPicInfo4);
            }
            UIStateData.ModifyListRecord obtainNotifyItemRangeChange = UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(this.mSelectedPosition, 1);
            Intrinsics.checkNotNullExpressionValue(obtainNotifyItemRangeChange, "obtainNotifyItemRangeChange(mSelectedPosition, 1)");
            updateRichMediaList(obtainNotifyItemRangeChange);
        }
    }

    private final void K9(String mediaId, String path) {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo2;
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo3;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerItemMediaInfo findMediaInfoWithMediaId = findMediaInfoWithMediaId(mediaId);
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo4 = null;
        if (findMediaInfoWithMediaId != null && (layerPicInfo = findMediaInfoWithMediaId.getLayerPicInfo()) != null) {
            rFWPicInfo = layerPicInfo.getSmallPicInfo();
        } else {
            rFWPicInfo = null;
        }
        if (rFWPicInfo != null) {
            RFWLayerPicInfo layerPicInfo2 = findMediaInfoWithMediaId.getLayerPicInfo();
            if (layerPicInfo2 != null) {
                rFWPicInfo2 = layerPicInfo2.getSmallPicInfo();
            } else {
                rFWPicInfo2 = null;
            }
            if (rFWPicInfo2 != null) {
                rFWPicInfo2.setUrl(path);
            }
            RFWLayerPicInfo layerPicInfo3 = findMediaInfoWithMediaId.getLayerPicInfo();
            if (layerPicInfo3 != null) {
                rFWPicInfo3 = layerPicInfo3.getSmallPicInfo();
            } else {
                rFWPicInfo3 = null;
            }
            if (rFWPicInfo3 != null) {
                rFWPicInfo3.setLocalPath(path);
            }
            RFWLayerPicInfo layerPicInfo4 = findMediaInfoWithMediaId.getLayerPicInfo();
            if (layerPicInfo4 != null) {
                RFWLayerPicInfo layerPicInfo5 = findMediaInfoWithMediaId.getLayerPicInfo();
                if (layerPicInfo5 != null) {
                    rFWPicInfo4 = layerPicInfo5.getSmallPicInfo();
                }
                Intrinsics.checkNotNull(rFWPicInfo4);
                layerPicInfo4.setCurrentPicInfo(rFWPicInfo4);
            }
            UIStateData.ModifyListRecord obtainNotifyItemRangeChange = UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(this.mSelectedPosition, 1);
            Intrinsics.checkNotNullExpressionValue(obtainNotifyItemRangeChange, "obtainNotifyItemRangeChange(mSelectedPosition, 1)");
            updateRichMediaList(obtainNotifyItemRangeChange);
        }
    }

    private final void L9(String mediaId, String path) {
        RFWLayerVideoInfo rFWLayerVideoInfo;
        RFWLayerItemMediaInfo findMediaInfoWithMediaId = findMediaInfoWithMediaId(mediaId);
        if (findMediaInfoWithMediaId != null) {
            rFWLayerVideoInfo = findMediaInfoWithMediaId.getLayerVideoInfo();
        } else {
            rFWLayerVideoInfo = null;
        }
        if (rFWLayerVideoInfo != null) {
            RFWLayerVideoInfo layerVideoInfo = findMediaInfoWithMediaId.getLayerVideoInfo();
            Intrinsics.checkNotNull(layerVideoInfo);
            layerVideoInfo.setLocalPath(path);
            if (FileUtils.fileExistsAndNotEmpty(path)) {
                RFWLayerVideoInfo layerVideoInfo2 = findMediaInfoWithMediaId.getLayerVideoInfo();
                Intrinsics.checkNotNull(layerVideoInfo2);
                layerVideoInfo2.setCurrentVideoUrl(path);
            }
            UIStateData.ModifyListRecord obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
            Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "obtainNotifyDataSetChanged()");
            updateRichMediaList(obtainNotifyDataSetChanged);
        }
    }

    private final RFWLayerItemMediaInfo findMediaInfoWithMediaId(String targetMediaId) {
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        Object obj = null;
        if (value == null || (data = value.getData()) == null || (richMediaDataList = data.getRichMediaDataList()) == null) {
            return null;
        }
        Iterator<T> it = richMediaDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((RFWLayerItemMediaInfo) next).getMediaId(), targetMediaId)) {
                obj = next;
                break;
            }
        }
        return (RFWLayerItemMediaInfo) obj;
    }

    private final void updateRichMediaList(UIStateData.ModifyListRecord modifyRecord) {
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        if (value != null) {
            value.setLatestModifyRecord(modifyRecord);
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    public final void D9(int type) {
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        String name = com.tencent.mobileqq.richmedia.depend.e.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IRichMediaShareDepend::class.java.name");
        com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
        if (d16 instanceof com.tencent.mobileqq.richmedia.depend.e) {
            ((com.tencent.mobileqq.richmedia.depend.e) d16).A1(type, this.mCurrentSelectedItem);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.b
    public void I7(@NotNull String mediaId, boolean isSuccess, @Nullable String targetPath, @NotNull RichMediaDownloadType type) {
        RFWLayerFileDownloadState.FileState fileState;
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(type, "type");
        QLog.i("CommonLayerControlPart", RFWLog.USR, "notifyMediaResult: mediaId:" + mediaId + ", isSuccess:" + isSuccess + ", targetPath: " + targetPath + ", type:" + type);
        if (!com.tencent.mobileqq.richmedia.e.f281568a.e().containsKey(mediaId)) {
            QLog.i("CommonLayerControlPart", RFWLog.USR, "notifyMediaResult: mediaId:" + mediaId + ", return");
            return;
        }
        if (B9(type)) {
            if (isSuccess) {
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS;
            } else {
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_FAILED;
            }
            H9(mediaId, fileState, 1.0f, 0L);
        }
        if (isSuccess && !TextUtils.isEmpty(targetPath)) {
            QLog.i("CommonLayerControlPart", RFWLog.USR, "notifyMediaResult updateMediaInfo: mediaId:" + mediaId + ", type:" + type);
            int i3 = b.f281660a[type.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                Intrinsics.checkNotNull(targetPath);
                                K9(mediaId, targetPath);
                                return;
                            }
                            return;
                        }
                        Intrinsics.checkNotNull(targetPath);
                        I9(mediaId, targetPath);
                        return;
                    }
                    Intrinsics.checkNotNull(targetPath);
                    E9(mediaId, targetPath);
                    L9(mediaId, targetPath);
                    return;
                }
                Intrinsics.checkNotNull(targetPath);
                E9(mediaId, targetPath);
                J9(mediaId, targetPath);
                return;
            }
            Intrinsics.checkNotNull(targetPath);
            J9(mediaId, targetPath);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.b
    public void K8(@NotNull String mediaId, float progress, long totalSize, @NotNull RichMediaDownloadType type) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(type, "type");
        QLog.i("CommonLayerControlPart", RFWLog.USR, "notifyMediaProgress: mediaId:" + mediaId + ", progress:" + progress + ", totalSize: " + totalSize + ", type:" + type);
        if (!com.tencent.mobileqq.richmedia.e.f281568a.e().containsKey(mediaId)) {
            QLog.i("CommonLayerControlPart", RFWLog.USR, "notifyMediaProgress: mediaId:" + mediaId + ", return");
            return;
        }
        if (B9(type)) {
            H9(mediaId, RFWLayerFileDownloadState.FileState.DOWNLOADING, progress, totalSize);
            return;
        }
        QLog.i("CommonLayerControlPart", RFWLog.USR, "notifyMediaProgress not need show progress: mediaId:" + mediaId + ", progress:" + progress + ", type:" + type);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaProvider
    public boolean downloadPic(@NotNull RFWLayerItemMediaInfo mediaInfo, @NotNull RFWLayerPicInfo.PicType picType) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(picType, "picType");
        String mediaId = mediaInfo.getMediaId();
        if (mediaId != null) {
            com.tencent.mobileqq.richmedia.depend.d dVar = null;
            if (picType == RFWLayerPicInfo.PicType.ORIGIN) {
                com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
                eVar.a(mediaId, mediaInfo);
                String name = com.tencent.mobileqq.richmedia.depend.d.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "IRichMediaDownloadDepend::class.java.name");
                com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
                if (d16 instanceof com.tencent.mobileqq.richmedia.depend.d) {
                    dVar = (com.tencent.mobileqq.richmedia.depend.d) d16;
                }
                if (dVar != null) {
                    dVar.L1(mediaId, RichMediaDownloadType.TYPE_ORIGINAL_IMAGE, getActivity());
                }
                H9(mediaId, RFWLayerFileDownloadState.FileState.DOWNLOADING, 0.0f, 0L);
                return true;
            }
            com.tencent.mobileqq.richmedia.e eVar2 = com.tencent.mobileqq.richmedia.e.f281568a;
            eVar2.a(mediaId, mediaInfo);
            String name2 = com.tencent.mobileqq.richmedia.depend.d.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "IRichMediaDownloadDepend::class.java.name");
            com.tencent.mobileqq.richmedia.depend.c d17 = eVar2.d(name2);
            if (d17 instanceof com.tencent.mobileqq.richmedia.depend.d) {
                dVar = (com.tencent.mobileqq.richmedia.depend.d) d17;
            }
            if (dVar != null) {
                dVar.L1(mediaId, RichMediaDownloadType.TYPE_LARGE_IMAGE, getActivity());
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(RFWLayerFileStateChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaProvider
    public boolean getVideoUrl(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        com.tencent.mobileqq.richmedia.depend.d dVar;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        String mediaId = mediaInfo.getMediaId();
        if (mediaId != null) {
            com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
            String name = com.tencent.mobileqq.richmedia.depend.d.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "IRichMediaDownloadDepend::class.java.name");
            com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
            if (d16 instanceof com.tencent.mobileqq.richmedia.depend.d) {
                dVar = (com.tencent.mobileqq.richmedia.depend.d) d16;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.s8(mediaId);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerPicLoader(rootView, QQPicLoader.f201806a.d());
        RFWLayerIOCUtil.registerMediaProvider(rootView, this);
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        String name = com.tencent.mobileqq.richmedia.depend.b.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IMediaDownloadCallBack::class.java.name");
        eVar.g(name, this);
        SimpleEventBus.getInstance().registerReceiver(this);
        A9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        D9(1);
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        String name = com.tencent.mobileqq.richmedia.depend.d.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IRichMediaDownloadDepend::class.java.name");
        com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
        if (d16 instanceof com.tencent.mobileqq.richmedia.depend.d) {
            com.tencent.mobileqq.richmedia.depend.d dVar = (com.tencent.mobileqq.richmedia.depend.d) d16;
            dVar.onDestroy();
            for (Map.Entry<String, RFWLayerItemMediaInfo> entry : eVar.e().entrySet()) {
                String key = entry.getKey();
                entry.getValue();
                dVar.cancelDownload(key);
            }
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.mobileqq.richmedia.e.f281568a.b();
        RFWLayerDataCenter.INSTANCE.clearAllData();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        RFWLayerFileDownloadState.FileState fileState;
        if (event instanceof RFWLayerFileStateChangeEvent) {
            RFWLayerFileStateChangeEvent rFWLayerFileStateChangeEvent = (RFWLayerFileStateChangeEvent) event;
            RFWLayerFileDownloadState rFWLayerFileDownloadState = rFWLayerFileStateChangeEvent.mState;
            com.tencent.mobileqq.richmedia.depend.d dVar = null;
            if (rFWLayerFileDownloadState != null) {
                fileState = rFWLayerFileDownloadState.getFileState();
            } else {
                fileState = null;
            }
            if (fileState == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                QLog.i("CommonLayerControlPart", 1, "downloadSuccess mediaId: " + rFWLayerFileStateChangeEvent.mState.getMediaId());
                com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
                if (eVar.e().get(rFWLayerFileStateChangeEvent.mState.getMediaId()) != null) {
                    String name = com.tencent.mobileqq.richmedia.depend.d.class.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "IRichMediaDownloadDepend::class.java.name");
                    com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
                    if (d16 instanceof com.tencent.mobileqq.richmedia.depend.d) {
                        dVar = (com.tencent.mobileqq.richmedia.depend.d) d16;
                    }
                    if (dVar != null) {
                        dVar.C0(rFWLayerFileStateChangeEvent.mState.getMediaId());
                    }
                }
                SimpleEventBus.getInstance().dispatchEvent(new FileVideoDownloadFinishEvent(rFWLayerFileStateChangeEvent.mState.getMediaId()));
            }
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.b
    public void p9(@NotNull String mediaId, boolean isSuccess, @Nullable String localPath, @NotNull ArrayList<String> urls, @NotNull final String errorMsg) {
        String joinToString$default;
        List mutableList;
        String str;
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        int i3 = RFWLog.USR;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(urls, " ", null, null, 0, null, null, 62, null);
        QLog.i("CommonLayerControlPart", i3, "notifyVideoUrl: mediaId:" + mediaId + ", isSuccess:" + isSuccess + ", localPath: " + localPath + ", urls:" + joinToString$default);
        if (!isSuccess) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                F9(errorMsg);
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.part.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.C9(e.this, errorMsg);
                    }
                });
                return;
            }
        }
        RFWLayerItemMediaInfo findMediaInfoWithMediaId = findMediaInfoWithMediaId(mediaId);
        if ((!urls.isEmpty()) && findMediaInfoWithMediaId != null) {
            RFWLayerVideoInfo layerVideoInfo = findMediaInfoWithMediaId.getLayerVideoInfo();
            if (layerVideoInfo != null) {
                layerVideoInfo.setVideoOriginUrl(urls.get(0));
            }
            RFWLayerVideoInfo layerVideoInfo2 = findMediaInfoWithMediaId.getLayerVideoInfo();
            if (layerVideoInfo2 != null) {
                RFWLayerVideoInfo layerVideoInfo3 = findMediaInfoWithMediaId.getLayerVideoInfo();
                if (layerVideoInfo3 == null || (str = layerVideoInfo3.getVideoOriginUrl()) == null) {
                    str = "";
                }
                layerVideoInfo2.setCurrentVideoUrl(str);
            }
            if (urls.size() > 1) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) urls);
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(mutableList.subList(0, mutableList.size()));
                RFWLayerVideoInfo layerVideoInfo4 = findMediaInfoWithMediaId.getLayerVideoInfo();
                if (layerVideoInfo4 != null) {
                    layerVideoInfo4.setVecVideoUrl(arrayList);
                }
            }
            RFWLayerVideoInfo layerVideoInfo5 = findMediaInfoWithMediaId.getLayerVideoInfo();
            if (layerVideoInfo5 != null) {
                layerVideoInfo5.setLocalPath(localPath);
            }
            UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value != null) {
                value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
            }
            getMLayerViewModel().mRichMediaInfo.postValue(getMLayerViewModel().mRichMediaInfo.getValue());
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaProvider
    public void saveToAlbum(@NotNull RFWLayerItemMediaInfo mediaInfo) {
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo;
        String maxsizeFile;
        String str;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        String str2;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        com.tencent.mobileqq.richmedia.depend.d dVar = null;
        String str3 = null;
        com.tencent.mobileqq.richmedia.depend.d dVar2 = null;
        if (mediaInfo.isVideo()) {
            RFWLayerVideoInfo layerVideoInfo = mediaInfo.getLayerVideoInfo();
            if (layerVideoInfo != null) {
                str2 = layerVideoInfo.getLocalPath();
            } else {
                str2 = null;
            }
            if (FileUtils.fileExistsAndNotEmpty(str2)) {
                String mediaId = mediaInfo.getMediaId();
                RFWLayerVideoInfo layerVideoInfo2 = mediaInfo.getLayerVideoInfo();
                if (layerVideoInfo2 != null) {
                    str3 = layerVideoInfo2.getLocalPath();
                }
                Intrinsics.checkNotNull(str3);
                E9(mediaId, str3);
                return;
            }
            String mediaId2 = mediaInfo.getMediaId();
            if (mediaId2 != null) {
                com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
                eVar.a(mediaId2, mediaInfo);
                QLog.i("CommonLayerControlPart", RFWLog.USR, "saveToAlbum: mediaId:" + mediaId2 + ", downloadMedia TYPE_SAVE_VIDEO");
                String name = com.tencent.mobileqq.richmedia.depend.d.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "IRichMediaDownloadDepend::class.java.name");
                com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
                if (d16 instanceof com.tencent.mobileqq.richmedia.depend.d) {
                    dVar2 = (com.tencent.mobileqq.richmedia.depend.d) d16;
                }
                if (dVar2 != null) {
                    dVar2.L1(mediaId2, RichMediaDownloadType.TYPE_SAVE_VIDEO, getActivity());
                }
                H9(mediaId2, RFWLayerFileDownloadState.FileState.DOWNLOADING, 0.0f, 0L);
                return;
            }
            return;
        }
        RFWLayerPicInfo layerPicInfo = mediaInfo.getLayerPicInfo();
        if (layerPicInfo != null) {
            rFWPicInfo = layerPicInfo.getOriginPicInfo();
        } else {
            rFWPicInfo = null;
        }
        if (rFWPicInfo != null) {
            RFWLayerPicInfo layerPicInfo2 = mediaInfo.getLayerPicInfo();
            if (layerPicInfo2 != null && (originPicInfo = layerPicInfo2.getOriginPicInfo()) != null) {
                str = originPicInfo.getLocalPath();
            } else {
                str = null;
            }
            if (!FileUtils.fileExistsAndNotEmpty(str)) {
                String mediaId3 = mediaInfo.getMediaId();
                if (mediaId3 != null) {
                    com.tencent.mobileqq.richmedia.e eVar2 = com.tencent.mobileqq.richmedia.e.f281568a;
                    eVar2.a(mediaId3, mediaInfo);
                    QLog.i("CommonLayerControlPart", RFWLog.USR, "saveToAlbum: mediaId:" + mediaId3 + ", downloadMedia TYPE_SAVE_ORIGINAL_IMAGE");
                    String name2 = com.tencent.mobileqq.richmedia.depend.d.class.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "IRichMediaDownloadDepend::class.java.name");
                    com.tencent.mobileqq.richmedia.depend.c d17 = eVar2.d(name2);
                    if (d17 instanceof com.tencent.mobileqq.richmedia.depend.d) {
                        dVar = (com.tencent.mobileqq.richmedia.depend.d) d17;
                    }
                    if (dVar != null) {
                        dVar.L1(mediaId3, RichMediaDownloadType.TYPE_SAVE_ORIGINAL_IMAGE, getActivity());
                    }
                    H9(mediaId3, RFWLayerFileDownloadState.FileState.DOWNLOADING, 0.0f, 0L);
                    return;
                }
                return;
            }
        }
        RFWLayerPicInfo layerPicInfo3 = mediaInfo.getLayerPicInfo();
        if (layerPicInfo3 != null && (maxsizeFile = layerPicInfo3.getMaxsizeFile()) != null) {
            E9(mediaInfo.getMediaId(), maxsizeFile);
        }
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, androidx.lifecycle.Observer
    public void onChanged(@NotNull UIStateData<RFWLayerState> uiStateData) {
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        super.onChanged(uiStateData);
        D9(0);
    }
}
