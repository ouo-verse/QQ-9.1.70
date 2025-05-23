package com.tencent.mobileqq.richmediabrowser.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmediabrowser.f;
import com.tencent.mobileqq.richmediabrowser.g;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import d04.a;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IBrowserDepend extends QRouteApi {
    public static final int DETECT_MODE_MINI = 2;
    public static final int DETECT_MODE_QR = 1;

    void addMsgRevokerListener(g gVar);

    void buildMessageRevokeUI(Activity activity, RelativeLayout relativeLayout);

    Parcelable convertAIORichMediaData(Parcelable parcelable);

    void dealAddFavorite(Activity activity, Intent intent, String str, String str2);

    void dealAddToEmotion(Parcelable parcelable, Activity activity);

    void dealPicForwardToGroupAlbum(AIOPictureData aIOPictureData, Context context, f fVar);

    void dealSendToWeiYun(Parcelable parcelable);

    void forwardPicToFriend(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity, int i3, String str, int i16, int i17, String str2);

    void forwardToChannel(Activity activity, Intent intent, boolean z16, int i3, String str);

    void forwardToChannel(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity, int i3, int i16, String str);

    void forwardToFriend(Activity activity, Intent intent, boolean z16, int i3, String str);

    void fowardToQzoneAlbum(Activity activity, String str, String str2, int i3, Parcelable parcelable, boolean z16, String str3);

    String getExtraGroupCode();

    String getExtraGroupUin();

    String getExtraGuildId();

    String getExtraMutilMsg();

    String getExtraSeekPos();

    Intent getForwardPicToFriendIntent(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity);

    Intent getForwardToFriendIntent(Activity activity, Intent intent, boolean z16);

    Intent getFriendPickerForForwardIntent(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity);

    String getMsgId();

    int getSharePanelType();

    String getShowDataLine();

    void gotoChatHistoryActivity(Context context, String str, int i3, Parcelable parcelable);

    boolean isFileSizeEnable(File file);

    boolean isPicShareToWXEnable();

    boolean isShortVideoType(int i3);

    boolean isSoftInputPanel(int i3);

    void onQRDecodeSucceed(Context context, String str, int i3, boolean z16, String str2, String str3, String str4, String str5, int i16, String str6, String str7, Intent intent);

    void openMiniAioForDanmaku(Activity activity, int i3, String str, boolean z16, long j3, long j16);

    void removeMsgRevokerListener(g gVar);

    void reportCommercialDrainage(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i18, int i19, int i26, int i27);

    boolean saveImageNeedBlock();

    void savePic(Activity activity, File file, String str);

    boolean saveVideoToAlbum(Context context, String str, String str2);

    boolean scanQrCodeNeedBlock();

    void sharePicToWXFromPeak(String str, Context context);

    void showFriendPickerForForward(File file, boolean z16, Parcelable parcelable, Bundle bundle, Activity activity, int i3);

    void startChatAndSendMsg(Activity activity, Bundle bundle);

    void startEditPicActivity(Activity activity, int i3, boolean z16, boolean z17, int i16, String str, int i17);

    boolean supportCapture();

    void updateMsgStatus(int i3, long j3, MessageRecord messageRecord, int i16, a aVar);
}
