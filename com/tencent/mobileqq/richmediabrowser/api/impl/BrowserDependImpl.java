package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.f;
import com.tencent.mobileqq.richmediabrowser.g;
import com.tencent.mobileqq.richmediabrowser.h;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.richmediabrowser.utils.d;
import com.tencent.mobileqq.richmediabrowser.utils.e;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.dw;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import cooperation.peak.PeakConstants;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BrowserDependImpl implements IBrowserDepend {
    private static final String TAG = "BrowserDependImpl";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f281789d;

        a(Activity activity) {
            this.f281789d = activity;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (-102 == eIPCResult.code) {
                this.f281789d.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f281791d;

        b(Context context) {
            this.f281791d = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ((Activity) this.f281791d).setResult(8001);
        }
    }

    private boolean addOpenWithMiniAppMenuItemIfNeeded(@NonNull ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        if (((IMiniAppFileMaterialService) QRoute.api(IMiniAppFileMaterialService.class)).isMimeTypeSupported("image/*")) {
            dw.b(166, 64, arrayList);
            return true;
        }
        return false;
    }

    private boolean isNeedUpdateMsg(MessageForShortVideo messageForShortVideo, int i3, int i16, int i17) {
        int i18 = messageForShortVideo.videoFileStatus;
        if ((i18 == 1002 || i18 == 2002) && i18 == i3 && i16 - i17 < 10) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void addMsgRevokerListener(g gVar) {
        com.tencent.mobileqq.activity.aio.photo.b.d().a(gVar);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void buildMessageRevokeUI(Activity activity, RelativeLayout relativeLayout) {
        com.tencent.mobileqq.activity.aio.photo.b.b(activity, relativeLayout);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public Parcelable convertAIORichMediaData(Parcelable parcelable) {
        if (parcelable instanceof AIOBrowserBaseData) {
            return d.a((AIOBrowserBaseData) parcelable);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void dealAddFavorite(Activity activity, Intent intent, String str, String str2) {
        if (intent == null) {
            QfavBuilder.e0(str).h(activity, str2);
        } else {
            new QfavBuilder(intent).h(activity, str2);
        }
        cooperation.qqfav.d.e(null, 40, 3);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void dealAddToEmotion(Parcelable parcelable, Activity activity) {
        if (parcelable instanceof AIOPictureData) {
            Bundle bundle = new Bundle();
            bundle.putString("pic_md5", ((AIOPictureData) parcelable).md5);
            QIPCClientHelper.getInstance().callServer(IEmoticonPanelIpcService.EMOTICON_IPC_NAME, "action_group_emo_big_pic_add_fav", bundle, new a(activity));
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void dealPicForwardToGroupAlbum(AIOPictureData aIOPictureData, Context context, f fVar) {
        if (LocalMultiProcConfig.getInt4Uin(h.a().m() + "__qzone_pic_permission__" + h.a().i(), -1, Long.valueOf(h.a().m()).longValue()) == 0) {
            QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.f167856jn);
            qQCustomDialog.setTitle(context.getString(R.string.f235357bf));
            qQCustomDialog.setMessage(context.getString(R.string.f235337bd));
            qQCustomDialog.setNegativeButton(context.getString(R.string.f235347be), new b(context));
            qQCustomDialog.setCanceledOnTouchOutside(false);
            qQCustomDialog.setCancelable(false);
            qQCustomDialog.show();
            QZoneClickReport.startReportImediately(h.a().m(), "40", "1");
            return;
        }
        if (fVar != null) {
            fVar.b(RichMediaBrowserConstants.SINGLE_FORWARD_GRPALBUM, 0);
        }
        AIOGalleryUtils.h((Activity) context, h.a().m(), h.a().i(), h.a().h(), aIOPictureData.thumbImageFile, aIOPictureData.uuid, aIOPictureData.timestamp, -1);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void dealSendToWeiYun(Parcelable parcelable) {
        if (parcelable instanceof AIOPictureData) {
            Bundle bundle = new Bundle();
            bundle.putString("pic_md5", ((AIOPictureData) parcelable).md5);
            QIPCClientHelper.getInstance().callServer(IEmoticonPanelIpcService.EMOTICON_IPC_NAME, "action_group_emo_big_pic_upload_wy", bundle, null);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void forwardPicToFriend(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity, int i3, String str, int i16, int i17, String str2) {
        Intent forwardPicToFriendIntent = getForwardPicToFriendIntent(file, z16, parcelable, bundle, activity);
        if (forwardPicToFriendIntent != null) {
            if (i3 == 72) {
                forwardPicToFriendIntent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                forwardPicToFriendIntent.putExtra("key_direct_show_uin_type", i16);
                forwardPicToFriendIntent.putExtra("key_direct_show_uin", str);
                ForwardBaseOption.startForwardActivityForResult(activity, forwardPicToFriendIntent, (Class<?>) ForwardRecentTranslucentActivity.class, 19005, i17, str2);
                return;
            }
            ForwardBaseOption.startForwardActivityForResult(activity, forwardPicToFriendIntent, 19005, i17, str2);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void forwardToChannel(Activity activity, Intent intent, boolean z16, int i3, String str) {
        e.b(activity, intent, z16, i3, str);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void forwardToFriend(Activity activity, Intent intent, boolean z16, int i3, String str) {
        e.d(activity, intent, z16, i3, str);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void fowardToQzoneAlbum(Activity activity, String str, String str2, int i3, Parcelable parcelable, boolean z16, String str3) {
        AIOGalleryUtils.g(activity, str, str2, i3, parcelable, z16, str3);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public String getExtraGroupCode() {
        return "extra.GROUP_CODE";
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public String getExtraGroupUin() {
        return "extra.GROUP_UIN";
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public String getExtraGuildId() {
        return IGuildForwardUtilsApi.EXTRA_GUILD_ID;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public String getExtraMutilMsg() {
        return "extra.IS_FROM_MULTI_MSG";
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public String getExtraSeekPos() {
        return "extra.SEEK_POSITION";
    }

    public Intent getForwardFilePicToFriendIntent(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity) {
        boolean z17 = parcelable instanceof AIOPictureData;
        if (!z17 && !(parcelable instanceof AIOFilePictureData)) {
            return null;
        }
        try {
            if (file != null) {
                bundle.putString(AppConstants.Key.FORWARD_FILEPATH, file.getAbsolutePath());
                bundle.putInt("forward_type", 1);
                bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, activity.getIntent().getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1));
                if (z16) {
                    bundle.putInt(PeakConstants.SEND_SIZE_SPEC, 2);
                }
                bundle.putParcelable(AppConstants.Key.FORWARD_MSG_FOR_PIC, parcelable);
                bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                bundle.putBoolean("key_allow_multiple_forward_from_limit", false);
                if (z17) {
                    AIOPictureData aIOPictureData = (AIOPictureData) parcelable;
                    if (!TextUtils.isEmpty(aIOPictureData.templateId)) {
                        bundle.putBoolean(AppConstants.Key.FORWARD_SEND_TEMPLATE_PIC, true);
                        bundle.putString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, aIOPictureData.templateId);
                        bundle.putString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, aIOPictureData.templateName);
                    }
                }
                Intent intent = new Intent();
                intent.putExtras(bundle);
                return intent;
            }
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "showFriendPickerForForward ,cache path is null");
            return null;
        } catch (NullPointerException e16) {
            BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "showFriendPickerForForward ,NullPointerException: " + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public Intent getForwardPicToFriendIntent(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity) {
        if (parcelable instanceof AIOPictureData) {
            AIOPictureData aIOPictureData = (AIOPictureData) parcelable;
            try {
                if (file != null) {
                    bundle.putString(AppConstants.Key.FORWARD_FILEPATH, file.getAbsolutePath());
                    bundle.putInt("forward_type", 1);
                    bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, activity.getIntent().getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1));
                    if (z16) {
                        bundle.putInt(PeakConstants.SEND_SIZE_SPEC, 2);
                    }
                    bundle.putParcelable(AppConstants.Key.FORWARD_MSG_FOR_PIC, aIOPictureData);
                    bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                    bundle.putBoolean("key_allow_multiple_forward_from_limit", false);
                    if (!TextUtils.isEmpty(aIOPictureData.templateId)) {
                        bundle.putBoolean(AppConstants.Key.FORWARD_SEND_TEMPLATE_PIC, true);
                        bundle.putString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, aIOPictureData.templateId);
                        bundle.putString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, aIOPictureData.templateName);
                    }
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    return intent;
                }
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "showFriendPickerForForward ,cache path is null");
                return null;
            } catch (NullPointerException e16) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "showFriendPickerForForward ,NullPointerException: " + e16.getMessage());
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public Intent getForwardToFriendIntent(Activity activity, Intent intent, boolean z16) {
        return e.f(activity, intent, z16);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public Intent getFriendPickerForForwardIntent(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity) {
        if (parcelable instanceof AIOPictureData) {
            AIOPictureData aIOPictureData = (AIOPictureData) parcelable;
            try {
                if (file != null) {
                    bundle.putString("GALLERY.FORWORD_LOCAL_PATH", file.getAbsolutePath());
                    bundle.putInt("forward_type", 1);
                    bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, activity.getIntent().getIntExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1));
                    if (z16) {
                        bundle.putInt(PeakConstants.SEND_SIZE_SPEC, 2);
                    }
                    bundle.putParcelable(AppConstants.Key.FORWARD_MSG_FOR_PIC, d.h(aIOPictureData));
                    if (aIOPictureData.mBusinessType == 4) {
                        bundle.putBoolean(HotPicData.HOT_PIC_HAS_EXTRA, true);
                    }
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    return intent;
                }
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "showFriendPickerForForward ,cache path is null");
                return null;
            } catch (NullPointerException e16) {
                BrowserLogHelper.getInstance().getGalleryLog().d(TAG, 4, "showFriendPickerForForward ,NullPointerException: " + e16);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public String getMsgId() {
        return "extra.MSG_ID";
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public int getSharePanelType() {
        return BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public String getShowDataLine() {
        return "k_dataline";
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void gotoChatHistoryActivity(Context context, String str, int i3, Parcelable parcelable) {
        if (parcelable instanceof AIOBrowserBaseData) {
            com.tencent.mobileqq.richmediabrowser.utils.f.b(context, str, i3, (AIOBrowserBaseData) parcelable);
        } else if (parcelable instanceof AIORichMediaData) {
            com.tencent.mobileqq.richmediabrowser.utils.f.a(context, str, i3, (AIORichMediaData) parcelable);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public boolean isFileSizeEnable(File file) {
        if (PicShareToWX.f() != null && PicShareToWX.f().i(file)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public boolean isPicShareToWXEnable() {
        if (PicShareToWX.f() != null && PicShareToWX.f().h()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public boolean isShortVideoType(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public boolean isSoftInputPanel(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void onQRDecodeSucceed(Context context, String str, int i3, boolean z16, String str2, String str3, String str4, String str5, int i16, String str6, String str7, Intent intent) {
        if (i16 == 1) {
            com.tencent.mobileqq.richmediabrowser.utils.f.c(context, str, i3, z16, str2, str3, str4, str5, 1, str6, str7, intent);
        } else if (i16 == 2) {
            com.tencent.mobileqq.richmediabrowser.utils.f.c(context, str, i3, z16, str2, str3, str4, str5, 2, str6, str7, intent);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void openMiniAioForDanmaku(Activity activity, int i3, String str, boolean z16, long j3, long j16) {
        MiniChatActivity.U2(activity, i3, str, z16, 26, j3, j16);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void removeMsgRevokerListener(g gVar) {
        com.tencent.mobileqq.activity.aio.photo.b.d().f(gVar);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void reportCommercialDrainage(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i18, int i19, int i26, int i27) {
        VasWebviewUtil.reportCommercialDrainage(str2, str3, str4, i3, i16, i17, str5, str6, str7, str8, str9, str10, str11, i18, i19, i26, i27);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public boolean saveImageNeedBlock() {
        return ZhuoXusManager.instance().saveImageNeedBlock();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void savePic(Activity activity, File file, String str) {
        AIOGalleryUtils.o(activity, file, str);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public boolean saveVideoToAlbum(Context context, String str, String str2) {
        return com.tencent.biz.qqstory.utils.d.x(context, str, str2);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public boolean scanQrCodeNeedBlock() {
        return ZhuoXusManager.instance().scanQrCodeNeedBlock();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void sharePicToWXFromPeak(String str, Context context) {
        PicShareToWX.n(str, context, 1);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void showFriendPickerForForward(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity, int i3) {
        Intent friendPickerForForwardIntent = getFriendPickerForForwardIntent(file, z16, parcelable, bundle, activity);
        if (friendPickerForForwardIntent != null) {
            ForwardBaseOption.startForwardActivityForResult(activity, friendPickerForForwardIntent, i3);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void startChatAndSendMsg(Activity activity, Bundle bundle) {
        com.tencent.mobileqq.richmediabrowser.utils.f.d(activity, bundle);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void startEditPicActivity(Activity activity, int i3, boolean z16, boolean z17, int i16, String str, int i17) {
        Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(activity, str, true, true, true, true, true, 2, i3, 7);
        startEditPic.putExtra("uintype", i17);
        startEditPic.putExtra("open_chatfragment", true);
        startEditPic.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1041);
        startEditPic.putExtra(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
        if (z16) {
            startEditPic.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, z16);
        }
        if (z17) {
            startEditPic.putExtra("key_allow_multiple_forward_from_limit", false);
        }
        if (i16 != 0) {
            activity.startActivityForResult(startEditPic, i16);
        } else {
            activity.startActivity(startEditPic);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public boolean supportCapture() {
        return gm2.b.d();
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void updateMsgStatus(int i3, long j3, MessageRecord messageRecord, int i16, d04.a aVar) {
        MessageForShortVideo messageForShortVideo;
        int i17;
        int i18;
        if (messageRecord instanceof MessageForShortVideo) {
            messageForShortVideo = (MessageForShortVideo) messageRecord;
        } else {
            messageForShortVideo = null;
            i16 = -1;
        }
        if (messageForShortVideo != null && i3 != -1) {
            if (j3 > 0 && (i18 = messageForShortVideo.videoFileSize) > 0) {
                i17 = (int) ((100 * j3) / i18);
            } else {
                i17 = 0;
            }
            if (messageForShortVideo.videoFileProgress < 0) {
                messageForShortVideo.videoFileProgress = 0;
            }
            if (isNeedUpdateMsg(messageForShortVideo, i3, i17, messageForShortVideo.videoFileProgress)) {
                return;
            }
            if (i16 == 6 || i16 == 17 || i16 == 9 || i16 == 67 || i16 == 20) {
                if (i3 == 2002 && j3 > 0) {
                    messageForShortVideo.transferedSize = (int) j3;
                }
                if (i3 == 2003) {
                    messageForShortVideo.transferedSize = 0;
                    i17 = 100;
                }
            }
            int i19 = messageForShortVideo.videoFileStatus;
            if ((i19 != 2004 && i19 != 1004) || (i3 != 1002 && i3 != 2002)) {
                messageForShortVideo.videoFileStatus = i3;
                messageForShortVideo.fileType = i16;
                if (i17 > 0) {
                    messageForShortVideo.videoFileProgress = i17;
                }
                String findVideoPathIfExists = ShortVideoUtils.findVideoPathIfExists(messageForShortVideo);
                if (i3 == 2003 && !StringUtil.isEmpty(findVideoPathIfExists)) {
                    messageForShortVideo.lastModified = new File(findVideoPathIfExists).lastModified();
                }
                if (aVar instanceof com.tencent.mobileqq.richmediabrowser.e) {
                    ((com.tencent.mobileqq.richmediabrowser.e) aVar).e(messageForShortVideo);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend
    public void forwardToChannel(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity, int i3, int i16, String str) {
        e.c(activity, getForwardFilePicToFriendIntent(file, z16, parcelable, bundle, activity));
    }
}
