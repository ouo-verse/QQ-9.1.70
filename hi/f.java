package hi;

import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean;
import com.qzone.util.l;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.queue.RFWDownloadQueueTaskInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import cooperation.qzone.util.QZonePermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lhi/f;", "Lcom/qzone/reborn/albumx/common/share/a;", "Lgi/a;", "shareContext", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "c", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "l", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends com.qzone.reborn.albumx.common.share.a<gi.a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"hi/f$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ gi.a f404940b;

        b(gi.a aVar) {
            this.f404940b = aVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            f.this.m(this.f404940b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(gi.a shareContext) {
        GroupAlbumLayerExtraInfoBean groupAlbumLayerExtraInfoBean;
        String str;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo;
        String fileId;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url;
        if (shareContext.getLayerItemInfo().getExtraData() == null || !(shareContext.getLayerItemInfo().getExtraData() instanceof GroupAlbumLayerExtraInfoBean)) {
            groupAlbumLayerExtraInfoBean = null;
        } else {
            Object extraData = shareContext.getLayerItemInfo().getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.layer.bean.GroupAlbumLayerExtraInfoBean");
            groupAlbumLayerExtraInfoBean = (GroupAlbumLayerExtraInfoBean) extraData;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (shareContext.getLayerItemInfo().isVideo()) {
            RFWLayerVideoInfo layerVideoInfo = shareContext.getLayerItemInfo().getLayerVideoInfo();
            RFWLayerPicInfo layerPicInfo = shareContext.getLayerItemInfo().getLayerPicInfo();
            r1 = layerVideoInfo != null ? layerVideoInfo.getCurrentVideoUrl() : null;
            hashMap.put("ext_key_is_video", "1");
            if (layerPicInfo != null && (currentPicInfo = layerPicInfo.getCurrentPicInfo()) != null && (url = currentPicInfo.getUrl()) != null) {
                hashMap.put("ext_key_video_url", url);
            }
            str = l.a(R.string.f169544uy4);
            Intrinsics.checkNotNullExpressionValue(str, "qqStr(R.string.qzone_int\u2026ad_list_media_video_type)");
            if (layerVideoInfo != null && (fileId = layerVideoInfo.getFileId()) != null) {
                hashMap.put("ext_key_video_id", fileId);
            }
        } else {
            RFWLayerPicInfo layerPicInfo2 = shareContext.getLayerItemInfo().getLayerPicInfo();
            if (layerPicInfo2 != null && (downloadPicInfo = layerPicInfo2.getDownloadPicInfo()) != null) {
                r1 = downloadPicInfo.getUrl();
            }
            hashMap.put("ext_key_is_video", "0");
            String a16 = l.a(R.string.uwv);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026load_list_media_pic_type)");
            String mediaId = shareContext.getLayerItemInfo().getMediaId();
            if (mediaId != null) {
                hashMap.put("ext_key_pic_id", mediaId);
            }
            str = a16;
        }
        if (r1 == null || r1.length() == 0) {
            QLog.d("GroupAlbumSaveAction", 1, "startDownload url is null");
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.sly, 0).show();
            return;
        }
        RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo = new RFWDownloadQueueTaskInfo(r1);
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        hashMap.put("ext_key_uin", uinString);
        if (groupAlbumLayerExtraInfoBean != null) {
            String uploadUid = groupAlbumLayerExtraInfoBean.getUploadUid();
            if (uploadUid != null) {
                hashMap.put("ext_key_uid", uploadUid);
            }
            hashMap.put("ext_key_task_desc", l.a(R.string.toe) + groupAlbumLayerExtraInfoBean.getAlbumName() + l.a(R.string.uwn) + ((Object) str));
            String groupId = groupAlbumLayerExtraInfoBean.getGroupId();
            if (groupId != null) {
                hashMap.put("ext_key_space_id", groupId);
            }
            hashMap.put("ext_key_space_type", "0");
        }
        rFWDownloadQueueTaskInfo.setExtMap(hashMap);
        zh.b.l().b(rFWDownloadQueueTaskInfo);
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public QQShareActionManager.ShareLine b() {
        return QQShareActionManager.ShareLine.SECOND;
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void a(gi.a shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (QZonePermission.requestStoragePermission(shareContext.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), new b(shareContext), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            m(shareContext);
        }
    }

    @Override // com.qzone.reborn.albumx.common.share.a
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(39);
        return arrayListOf;
    }
}
