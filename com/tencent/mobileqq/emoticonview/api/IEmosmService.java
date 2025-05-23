package com.tencent.mobileqq.emoticonview.api;

import a61.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.emogroupstore.n;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.favroaming.l;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.view.c;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmosmService extends QRouteApi {
    public static final String GAMECENTER_MANAGER = "GAMECENTER_MANAGER";
    public static final String MGR_MSG_FACADE = "MGR_MSG_FACADE";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface GIFCreatorCallback {
        void onGifCreateFail();

        void onGifCreateSuccess(String str);
    }

    int addEmotionToFavorite(Context context, BaseQQAppInterface baseQQAppInterface, Emoticon emoticon, Handler handler);

    void addToCustomEmotionForPic(Context context, String str, boolean z16, int i3);

    void addToDiyEmotionForPic(Context context, String str);

    int checkNewFlagByPath(BaseQQAppInterface baseQQAppInterface, String str);

    void clearFrameFilesGifCreator(Object obj);

    n createSDKEmotionSettingManager(Activity activity);

    Runnable createSendPhotoTask(Activity activity, Intent intent, Handler handler);

    void downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException;

    void enterEmotionPreview(Context context, EmoticonInfo emoticonInfo, Rect rect);

    void enterEmotionPreviewFromGuild(View view, MessageRecord messageRecord, String str, String str2, Boolean bool);

    void enterNewPhotoList(Activity activity);

    Card findFriendCardByUin(BaseQQAppInterface baseQQAppInterface, String str);

    Object gestureDetectorDestory(Object obj, IPanelInteractionListener iPanelInteractionListener);

    Class getChatActivityClass();

    MqqHandler getChatActivityHander(BaseQQAppInterface baseQQAppInterface);

    boolean getCurAnonymousState(String str);

    int getCurrChatType(BaseQQAppInterface baseQQAppInterface);

    String getCurrChatUin(BaseQQAppInterface baseQQAppInterface);

    File getDiskFile(HotPicData hotPicData);

    URLDrawable getDrawable(URL url, ColorDrawable colorDrawable, Drawable drawable);

    boolean getEmojiStickerSwitch(int i3);

    l getEmoticonFromGroupManager(BaseQQAppInterface baseQQAppInterface);

    String getErrorMsg(int i3);

    int getExternalPanelheight();

    Object getGIFCreator(String str);

    Class<?> getH5MagicPlayerActivityClass();

    Manager getIndividualRedPacketManager(AppInterface appInterface);

    int getManagerID(String str);

    <T> ImageView getMarketFaceItemBuilderHolderImage(T t16);

    Class<?> getMessengerServiceClass();

    int getRandomMaxValue(Emoticon emoticon, int i3);

    int getRichTextChatManagerEmoSearchConfig();

    String getSendCombineImg(Manager manager);

    String getTimeoutReason(FromServiceMsg fromServiceMsg);

    Object getVasEmojiManager(AppInterface appInterface);

    Rect getViewRect(View view);

    void gotoEmoMallPage(EmoticonCallback emoticonCallback);

    void handleComicStructMsg(BaseQQAppInterface baseQQAppInterface, Object obj, Object obj2);

    void handleResonpse(BaseQQAppInterface baseQQAppInterface, Intent intent, FromServiceMsg fromServiceMsg);

    ActionGlobalData hasAction(Emoticon emoticon, int i3);

    boolean hasReported(MessageRecord messageRecord, String str);

    Object initGestureDetector(Object obj, Context context, IPanelInteractionListener iPanelInteractionListener);

    boolean isComeFromComic(String str);

    boolean isFlashPicMsg(MessageRecord messageRecord);

    boolean isLiveChannelScene(int i3);

    boolean isSplashChatContext(Context context);

    boolean isSupportMagicface();

    boolean justShowSystemAndEmoji(int i3, boolean z16);

    void launchAECameraUnit(Context context, Object obj);

    void launchFriendPicker(Activity activity, List<EmoticonInfo> list);

    boolean magicfaceAutoPlay(Context context, Emoticon emoticon, c cVar);

    StringBuilder obtainStringBuilder();

    void openEmojiDetailPage(Activity activity, String str, int i3, String str2, boolean z16, Intent intent, boolean z17);

    void openEmojiDetailPage(Context context, String str, int i3, String str2, boolean z16, boolean z17);

    void openEmojiHomePage(Activity activity, String str, int i3);

    void openEmojiHomePage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, boolean z16, String str2, boolean z17);

    void openEmosmActivity(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, boolean z16, String str2);

    void parseJson(AppInterface appInterface);

    Object reparse(BaseQQAppInterface baseQQAppInterface, String str);

    void reportActionMobileReportManager(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3);

    void reportSendPicSource(String[] strArr, int i3, boolean z16, boolean z17, int i16, BaseQQAppInterface baseQQAppInterface);

    void sendEmoPic(Context context, Intent intent);

    void sendEmosmMsg(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon);

    void sendEmosmMsg(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon, int i3);

    void sendEmoticon(AppInterface appInterface, Context context, p pVar, Emoticon emoticon, boolean z16);

    void sendInfoFromPanelHelper(b bVar, EmoticonInfo emoticonInfo);

    void sendRecEmoPic(AppInterface appInterface, QBaseActivity qBaseActivity, b bVar, Editable editable, Intent intent, ArrayList<String> arrayList);

    void sendStickerMsg(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon, StickerInfo stickerInfo);

    void sendStructMsgForImage(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, p pVar);

    void setEmojiStickerMode(boolean z16);

    void setEmotionSearchPanelVisible(IPanelInteractionListener iPanelInteractionListener, boolean z16, int i3, boolean z17, String str, int i16);

    void setPicEmoticonTag(Context context, Emoticon emoticon);

    void showEmoticonPanel(IPanelInteractionListener iPanelInteractionListener, int i3);

    void showSearchEmoticonPanel(IPanelInteractionListener iPanelInteractionListener, String str, boolean z16);

    void startEmoticonGroupStoreFragment(Context context);

    void startGIFCreator(Object obj, GIFCreatorCallback gIFCreatorCallback);

    void toastFMDefault(int i3);

    <T extends IEmoticonMainPanel> T tryGetEmoticonMainPanel(IPanelInteractionListener iPanelInteractionListener);

    void updateMarketFaceItemBuilderEmoticonInfo(EmoticonInfo emoticonInfo);
}
