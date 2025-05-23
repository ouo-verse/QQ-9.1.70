package com.tencent.qqnt.photopanel.api.impl;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.dataline.activities.LiteActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.aiocomment.b;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.api.IAlbumApi;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.localactivity.AIOLocalActivity;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.qbasealbum.ktx.b;
import cooperation.peak.PeakConstants;
import dov.com.qq.im.ae.current.SessionWrap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J&\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/photopanel/api/impl/PhotoPanelApiImpl;", "Lcom/tencent/qqnt/photopanel/api/IPhotoPanelApi;", "", "isReceiptMode", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "isHighQuality", "", "enterVideoEditPage", "Landroid/app/Activity;", "Landroid/content/Intent;", "intent", "fillInitActivityClass", TtmlNode.ATTR_TTS_ORIGIN, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "convertMediaInfo", "", "comment", "Lcom/tencent/qqnt/qbasealbum/preview/fragment/a;", "listener", "onUp", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "selectMedias", "onEditBtnClicked", "fillIntentForJumpAlbum", "fillIntentForJumpPreview", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PhotoPanelApiImpl implements IPhotoPanelApi {
    private static final String TAG = "PhotoPanelApiImpl";

    private final LocalMediaInfo convertMediaInfo(com.tencent.qqnt.qbasealbum.model.LocalMediaInfo origin) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo._id = origin.get_id();
        localMediaInfo.path = origin.getPath();
        localMediaInfo.fileSize = origin.getFileSize();
        localMediaInfo.addedDate = origin.getAddedDate();
        localMediaInfo.modifiedDate = origin.getModifiedDate();
        localMediaInfo.orientation = origin.getOrientation();
        localMediaInfo.mDuration = b.f(origin);
        localMediaInfo.mChecked = origin.getMChecked();
        localMediaInfo.isSegment = origin.isSegment();
        localMediaInfo.selectStatus = origin.getSelectStatus();
        localMediaInfo.rotation = origin.getRotation();
        localMediaInfo.thumbWidth = origin.getThumbWidth();
        localMediaInfo.thumbHeight = origin.getThumbHeight();
        localMediaInfo.index = origin.getIndex();
        localMediaInfo.position = Integer.valueOf(origin.getPosition());
        localMediaInfo.mMimeType = origin.getMMimeType();
        localMediaInfo.mediaWidth = origin.getMediaWidth();
        localMediaInfo.mediaHeight = origin.getMediaHeight();
        localMediaInfo.mediaBitrate = origin.getMediaBitrate();
        localMediaInfo.isSystemMeidaStore = origin.isSystemMeidaStore();
        localMediaInfo.isRegionThumbUseNewDecoder = origin.isRegionThumbUseNewDecoder();
        localMediaInfo.panoramaPhotoType = origin.getPanoramaPhotoType();
        localMediaInfo.mMediaType = origin.getMMediaType();
        localMediaInfo.isVideoReady = origin.isVideoReady();
        localMediaInfo.materialID = origin.getMaterialID();
        localMediaInfo.materialName = origin.getMaterialName();
        localMediaInfo.filterID = origin.getFilterID();
        localMediaInfo.scheme = origin.getScheme();
        localMediaInfo.showCircleTakeSame = origin.getShowCircleTakeSame();
        localMediaInfo.missionID = origin.getMissionID();
        localMediaInfo.thumbnailProgress = origin.getThumbnailProgress();
        localMediaInfo.mediaOriginWidth = origin.getMediaOriginWidth();
        localMediaInfo.mediaOriginHeight = origin.getMediaOriginHeight();
        localMediaInfo.mediaOriginSize = origin.getMediaOriginSize();
        localMediaInfo.mediaOriginBitrate = origin.getMediaOriginBitrate();
        localMediaInfo.mOriginPath = origin.getMOriginPath();
        localMediaInfo.mKuolieId = origin.getMKuolieId();
        localMediaInfo.mKuolieCenterX = origin.getMKuolieCenterX();
        localMediaInfo.mKuolieCenterY = origin.getMKuolieCenterY();
        localMediaInfo.mKuolieRotate = origin.getMKuolieRotate();
        localMediaInfo.mKuolieWidthScale = origin.getMKuolieWidthScale();
        localMediaInfo.mKuolieHeightScale = origin.getMKuolieHeightScale();
        localMediaInfo.picPathBeforeEdit = origin.getPicPathBeforeEdit();
        localMediaInfo.videoMimeType = origin.getVideoMimeType();
        localMediaInfo.isHDRVideo = origin.isHDRVideo();
        return localMediaInfo;
    }

    private final void enterVideoEditPage(QBaseActivity activity, com.tencent.qqnt.qbasealbum.model.LocalMediaInfo mediaInfo, boolean isHighQuality) {
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady("qq_aio")) {
            QQToast.makeText(activity, activity.getResources().getString(R.string.f237737hv), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(activity.getIntent());
        intent.putExtra(PeakConstants.USE_NEW_ALBUM, true);
        SessionWrap sessionWrap = (SessionWrap) intent.getParcelableExtra(AECameraConstants.ARG_SESSION_INFO);
        String str = sessionWrap != null ? sessionWrap.f394452m : null;
        if (str == null) {
            str = "";
        }
        intent.putExtra(AppConstants.Key.NT_UID, str);
        intent.putExtra(AppConstants.Key.NT_CHAT_TYPE, sessionWrap != null ? sessionWrap.f394451i : -1);
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, isHighQuality ? 2 : 0);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", activity.getPackageName());
        fillInitActivityClass(activity, intent);
        intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, activity.getPackageName());
        intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationAIO.T);
        intent.putExtra(IPhotoLogicFactory.KEY_ALBUM_LIST_CLASS_NAME, ((IAlbumApi) QRoute.api(IAlbumApi.class)).getAlbumListCustomizationAIOClassName());
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAIO.R);
        intent.putExtra(PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, false);
        intent.putExtra(PeakConstants.IS_SEND_TO_AIO, true);
        QLog.d(TAG, 2, "enterVideoEditPage peeruid=" + intent.getStringExtra("key_peerId") + " type=" + intent.getIntExtra("key_chat_type", -1) + " thisActivity:" + activity.getClass().getName());
        ((IQQVideoEditApi) QRoute.api(IQQVideoEditApi.class)).jumpToVideoEditPage(activity, intent, convertMediaInfo(mediaInfo));
    }

    private final void fillInitActivityClass(Activity activity, Intent intent) {
        if (activity instanceof AIOLocalActivity ? true : activity instanceof SplashActivity) {
            intent.putExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 1);
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
            intent.putExtra("open_chatfragment", true);
        } else if (activity instanceof LiteActivity) {
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
        } else if (activity instanceof ChatActivity) {
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        } else {
            intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        }
    }

    private final boolean isReceiptMode() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUp$lambda$0(com.tencent.qqnt.qbasealbum.preview.fragment.a listener, String str) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.a(str);
    }

    @Override // com.tencent.qqnt.photopanel.api.IPhotoPanelApi
    public void fillIntentForJumpAlbum(Intent intent, com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        intent.putExtra(PeakConstants.MY_UIN, peekAppRuntime != null ? peekAppRuntime.getAccount() : null);
        intent.putExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false);
        intent.putExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 1);
        intent.putExtra("open_chatfragment", true);
        intent.putExtra(PeakConstants.KEY_BACK_TO_INIT_CLASS, true);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", MobileQQ.sMobileQQ.getPackageName());
        FragmentActivity requireActivity = aioContext.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "aioContext.fragment.requireActivity()");
        fillInitActivityClass(requireActivity, intent);
        intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, MobileQQ.sMobileQQ.getPackageName());
        intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        aioContext.g().l().getBoolean("key_is_scale_chat");
        SessionWrap a16 = dov.com.qq.im.ae.current.a.a(aioContext);
        intent.putExtra(AECameraConstants.ARG_SESSION_INFO, a16);
        QLog.d(TAG, 2, "fillIntentForJumpAlbum sessionWrap:" + a16 + " from: " + aioContext.c().requireActivity().getClass().getName());
    }

    @Override // com.tencent.qqnt.photopanel.api.IPhotoPanelApi
    public void fillIntentForJumpPreview(Intent intent, com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        QLog.d(TAG, 1, "fillIntentForJumpPreview");
        fillIntentForJumpAlbum(intent, aioContext);
    }

    @Override // com.tencent.qqnt.photopanel.api.IPhotoPanelApi
    public void onUp(Activity activity, String comment, final com.tencent.qqnt.qbasealbum.preview.fragment.a listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(listener, "listener");
        new com.tencent.mobileqq.activity.photo.aiocomment.b(activity, MobileQQ.sMobileQQ.peekAppRuntime(), new b.c() { // from class: com.tencent.qqnt.photopanel.api.impl.a
            @Override // com.tencent.mobileqq.activity.photo.aiocomment.b.c
            public final void a(String str) {
                PhotoPanelApiImpl.onUp$lambda$0(com.tencent.qqnt.qbasealbum.preview.fragment.a.this, str);
            }
        }).j(comment);
    }

    @Override // com.tencent.qqnt.photopanel.api.IPhotoPanelApi
    public void onEditBtnClicked(com.tencent.aio.api.runtime.a aioContext, List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> selectMedias, boolean isHighQuality) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(selectMedias, "selectMedias");
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            QLog.e(TAG, 1, "onEditBtnClicked, QBaseActivity.sTopActivity is null");
            return;
        }
        if (qBaseActivity.isInMultiWindow()) {
            QQToast.makeText(qBaseActivity, R.string.lwl, 0).show();
            return;
        }
        if (!hf0.a.b(TAG, 500L) && (!selectMedias.isEmpty())) {
            SessionWrap a16 = dov.com.qq.im.ae.current.a.a(aioContext);
            qBaseActivity.getIntent().putExtra(AECameraConstants.ARG_SESSION_INFO, a16);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "editPicIntent sessionWrap:" + a16);
            }
            if (selectMedias.get(0).getMMediaType() == 1) {
                enterVideoEditPage(qBaseActivity, selectMedias.get(0), isHighQuality);
                return;
            }
            Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(qBaseActivity, selectMedias.get(0).getPath(), true, true, true, true, true, 2, 140, 5);
            startEditPic.putExtra(PeakConstants.USE_NEW_ALBUM, true);
            startEditPic.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, isHighQuality ? 2 : 0);
            startEditPic.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", isReceiptMode());
            startEditPic.putExtra(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
            qBaseActivity.startActivity(startEditPic);
        }
    }
}
