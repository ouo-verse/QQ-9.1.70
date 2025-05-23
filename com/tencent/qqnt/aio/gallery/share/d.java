package com.tencent.qqnt.aio.gallery.share;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import cooperation.peak.PeakConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J(\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/d;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "", "c", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "mediaType", "filePath", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "i", "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "editFilePath", "curType", "type", "j", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class d extends a {
    private final void m(NTShareContext shareContext) {
        Activity activity = shareContext.getActivity();
        if (!RFWFileUtils.fileExists(shareContext.getExistSaveOrEditPath())) {
            QQToast.makeText(activity, activity.getResources().getString(R.string.f237747hw), 0).show();
            return;
        }
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio")) {
            QQToast.makeText(activity, activity.getResources().getString(R.string.f237737hv), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(activity.getIntent());
        intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, activity.getPackageName());
        intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        MsgRecord msgRecord = shareContext.getMsgRecord();
        String str = msgRecord != null ? msgRecord.peerUid : null;
        if (str == null) {
            str = "";
        }
        intent.putExtra(AppConstants.Key.NT_UID, str);
        MsgRecord msgRecord2 = shareContext.getMsgRecord();
        int i3 = msgRecord2 != null ? msgRecord2.chatType : 0;
        intent.putExtra(AppConstants.Key.NT_CHAT_TYPE, i3);
        intent.putExtra(PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, true);
        intent.putExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 4);
        QLog.d("NTEditShareAction", 1, "enterVideoEditPage uid:" + str + " chatType:" + i3);
        ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToVideoEditPage(activity, intent, i(1, shareContext.getExistSaveOrEditPath()));
    }

    private final void n(NTShareContext shareContext) {
        if (shareContext.getLayerItemInfo().isVideo()) {
            m(shareContext);
        } else {
            k(shareContext);
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        n(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        n(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("edit");
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.SECOND;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return !TextUtils.isEmpty(shareContext.getExistSaveOrEditPath());
    }

    public final LocalMediaInfo i(int mediaType, String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.mMediaType = mediaType;
        localMediaInfo.path = filePath;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(filePath);
                localMediaInfo.mMimeType = mediaMetadataRetriever.extractMetadata(12);
                Intrinsics.checkNotNull(mediaMetadataRetriever.extractMetadata(9));
                localMediaInfo.mDuration = Integer.parseInt(r1);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                Intrinsics.checkNotNull(extractMetadata);
                localMediaInfo.mediaWidth = Integer.parseInt(extractMetadata);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                Intrinsics.checkNotNull(extractMetadata2);
                localMediaInfo.mediaHeight = Integer.parseInt(extractMetadata2);
            } catch (Exception e16) {
                QLog.e("NTEditShareAction", 1, "getMimeType error, filePath=", filePath, ", error=", e16);
            }
            return localMediaInfo;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public final void j(Activity activity, String editFilePath, int curType, int type) {
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        int i17;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(editFilePath, "editFilePath");
        QLog.d("NTEditShareAction", 1, "enterPicEditPage");
        switch (type) {
            case 1:
                i3 = 126;
                i16 = 19000;
                z17 = true;
                z16 = true;
                i17 = i3;
                break;
            case 2:
                i3 = 127;
                i16 = 19000;
                z17 = true;
                z16 = true;
                i17 = i3;
                break;
            case 3:
                i3 = 128;
                i16 = 19000;
                z17 = true;
                z16 = true;
                i17 = i3;
                break;
            case 4:
                z16 = false;
                i16 = 19002;
                z17 = true;
                i17 = 125;
                break;
            case 5:
                i3 = 129;
                i16 = 19000;
                z17 = true;
                z16 = true;
                i17 = i3;
                break;
            case 6:
                i16 = 19000;
                z16 = false;
                z17 = true;
                i17 = 130;
                break;
            case 7:
                i3 = 134;
                i16 = 19000;
                z17 = true;
                z16 = true;
                i17 = i3;
                break;
            default:
                i17 = 99;
                z17 = false;
                z16 = false;
                i16 = 0;
                break;
        }
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).startEditPicActivity(activity, i17, z17, z16, i16, editFilePath, curType);
        ReportController.o(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
    }

    public final void k(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        String existSaveOrEditPath = shareContext.getExistSaveOrEditPath();
        if (existSaveOrEditPath != null) {
            l(this, shareContext.getActivity(), existSaveOrEditPath, com.tencent.mobileqq.richmediabrowser.h.a().f(), 0, 8, null);
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(94);
        return listOf;
    }

    public static /* synthetic */ void l(d dVar, Activity activity, String str, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 8) != 0) {
                i16 = 1;
            }
            dVar.j(activity, str, i3, i16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterPicEditPage");
    }
}
