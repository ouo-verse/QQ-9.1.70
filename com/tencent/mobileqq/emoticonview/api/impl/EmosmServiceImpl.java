package com.tencent.mobileqq.emoticonview.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.qqcircle.comment.emoji.u;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.galleryactivity.j;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.ab;
import com.tencent.mobileqq.activity.aio.helper.ac;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.aio.photo.c;
import com.tencent.mobileqq.activity.aio.w;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager;
import com.tencent.mobileqq.activity.emogroupstore.n;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationEmotion;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationEmotion;
import com.tencent.mobileqq.activity.photo.m;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ax;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.emocompat.IHostEmoticonMainApi;
import com.tencent.mobileqq.emosm.favroaming.l;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonCallbackWithShowPanel;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.searchemo.IAIOSearchEmotionExpandHelper;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.forward.EmotionBatchForwardOption;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.mixedmsg.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.servlet.e;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.widget.XPanelContainer;
import cooperation.qzone.mobilereport.MobileReportManager;
import dov.com.qq.im.ae.current.GIFCreator;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmosmServiceImpl implements IEmosmService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "EmosmServiceImpl";

    public EmosmServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void addCustomEmotion(Context context, File file, String str, int i3) {
        MessageForPic messageForPic = (MessageForPic) q.d(-2000);
        String absolutePath = file.getAbsolutePath();
        messageForPic.path = absolutePath;
        messageForPic.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(absolutePath));
        messageForPic.thumbMsgUrl = str;
        messageForPic.bigMsgUrl = str;
        messageForPic.imageType = 2000;
        if (messageForPic.picExtraData == null) {
            messageForPic.picExtraData = new PicMessageExtraData();
        }
        messageForPic.picExtraData.jumpId = i3;
        URLDrawable drawable = URLDrawableHelper.getDrawable(str);
        drawable.setTag(messageForPic);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            QLog.e(TAG, 2, "addToCustomEmotionForPic cannot get QQAppInterface");
        } else {
            c.e(context, (QQAppInterface) runtime, drawable, "", context.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.title_bar_height), null, messageForPic.picExtraData);
        }
    }

    private SessionInfo createSessionInfo(String str, String str2) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = 10014;
        sessionInfo.f179559f = str;
        sessionInfo.f179557e = str2;
        return sessionInfo;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public int addEmotionToFavorite(Context context, BaseQQAppInterface baseQQAppInterface, Emoticon emoticon, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, this, context, baseQQAppInterface, emoticon, handler)).intValue();
        }
        return MarketFaceItemBuilder.c(context, (QQAppInterface) baseQQAppInterface, emoticon, handler);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void addToCustomEmotionForPic(Context context, String str, boolean z16, int i3) {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, context, str, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            file = com.tencent.mobileqq.hotpic.b.getDiskFile(str);
            if (file == null || !file.exists()) {
                QLog.e(TAG, 4, " add custom fail file no exist");
                return;
            }
        } else {
            file = AbsDownloader.getFile(str);
            if (file == null || !file.exists()) {
                QLog.e(TAG, 4, " add custom fail file no exist");
                return;
            }
        }
        addCustomEmotion(context, file, str, i3);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void addToDiyEmotionForPic(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) context, (Object) str);
        } else {
            addCustomEmotion(context, new File(str), str, 0);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public int checkNewFlagByPath(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) baseQQAppInterface, (Object) str)).intValue();
        }
        return ((e) baseQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER)).a(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void clearFrameFilesGifCreator(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, obj);
        } else {
            ((GIFCreator) obj).h();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public n createSDKEmotionSettingManager(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (n) iPatchRedirector.redirect((short) 37, (Object) this, (Object) activity);
        }
        return new SDKEmotionSettingManager(activity);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Runnable createSendPhotoTask(Activity activity, Intent intent, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (Runnable) iPatchRedirector.redirect((short) 71, this, activity, intent, handler);
        }
        return new SendPhotoTask((BaseActivity) activity, intent, handler);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, outputStream, downloadParams, uRLDrawableHandler);
        } else {
            new HttpDownloader().downloadImage(outputStream, downloadParams, uRLDrawableHandler);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void enterEmotionPreview(Context context, EmoticonInfo emoticonInfo, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, context, emoticonInfo, rect);
        } else {
            AIOEmotionFragment.di(context, emoticonInfo, rect);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void enterEmotionPreviewFromGuild(View view, MessageRecord messageRecord, String str, String str2, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, view, messageRecord, str, str2, bool);
            return;
        }
        QLog.i(TAG, 4, "enterEmotionPreview");
        Rect d16 = j.d(view);
        SessionInfo createSessionInfo = createSessionInfo(str, str2);
        if (bool.booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
            createSessionInfo.f(bundle);
        }
        AIOEmotionFragment.ei(view.getContext(), messageRecord, createSessionInfo, d16);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void enterNewPhotoList(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) activity);
            return;
        }
        Config.a aVar = new Config.a();
        aVar.f(TabType.TAB_IMAGE);
        PickerInitBean.a aVar2 = new PickerInitBean.a();
        aVar2.b(activity.getString(com.tencent.mobileqq.R.string.cvf));
        activity.startActivityForResult(com.tencent.qqnt.qbasealbum.a.f360732a.d(activity, aVar.a(), aVar2.a(), PhotoListCustomizationEmotion.class, PhotoPreviewCustomizationEmotion.class), 10015);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Card findFriendCardByUin(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (Card) iPatchRedirector.redirect((short) 72, (Object) this, (Object) baseQQAppInterface, (Object) str);
        }
        FriendsManager friendsManager = (FriendsManager) baseQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (friendsManager != null) {
            return friendsManager.r(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Object gestureDetectorDestory(Object obj, IPanelInteractionListener iPanelInteractionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return iPatchRedirector.redirect((short) 28, (Object) this, obj, (Object) iPanelInteractionListener);
        }
        if (iPanelInteractionListener == null) {
            return null;
        }
        return iPanelInteractionListener.gestureDetectorDestroy(obj);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Class getChatActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (Class) iPatchRedirector.redirect((short) 69, (Object) this);
        }
        return ChatActivity.class;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public MqqHandler getChatActivityHander(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 34, (Object) this, (Object) baseQQAppInterface);
        }
        return baseQQAppInterface.getHandler(ChatActivity.class);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean getCurAnonymousState(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return ((Boolean) iPatchRedirector.redirect((short) 79, (Object) this, (Object) str)).booleanValue();
        }
        return com.tencent.biz.anonymous.a.h().d(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public int getCurrChatType(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) baseQQAppInterface)).intValue();
        }
        return ((QQMessageFacade) baseQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE)).r1();
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public String getCurrChatUin(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this, (Object) baseQQAppInterface);
        }
        return ((QQMessageFacade) baseQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE)).s1();
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public File getDiskFile(HotPicData hotPicData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (File) iPatchRedirector.redirect((short) 78, (Object) this, (Object) hotPicData);
        }
        return com.tencent.mobileqq.hotpic.b.getDiskFile(hotPicData.url);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public URLDrawable getDrawable(URL url, ColorDrawable colorDrawable, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 61, this, url, colorDrawable, drawable);
        }
        return URLDrawableHelper.getDrawable(url, colorDrawable, drawable);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean getEmojiStickerSwitch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, i3)).booleanValue();
        }
        if (i3 == 10014) {
            return false;
        }
        return EmojiStickerManager.f204583t;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public l getEmoticonFromGroupManager(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (l) iPatchRedirector.redirect((short) 59, (Object) this, (Object) baseQQAppInterface);
        }
        return ((ao) baseQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308430h;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public String getErrorMsg(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this, i3);
        }
        return com.tencent.mobileqq.multimsg.save.b.a(i3);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public int getExternalPanelheight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return ((Integer) iPatchRedirector.redirect((short) 60, (Object) this)).intValue();
        }
        return XPanelContainer.f384714h0;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Object getGIFCreator(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return iPatchRedirector.redirect((short) 73, (Object) this, (Object) str);
        }
        return new GIFCreator(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Class<?> getH5MagicPlayerActivityClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (Class) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return H5MagicPlayerActivity.class;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Manager getIndividualRedPacketManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (Manager) iPatchRedirector.redirect((short) 67, (Object) this, (Object) appInterface);
        }
        return appInterface.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public int getManagerID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).intValue();
        }
        if (IEmosmService.GAMECENTER_MANAGER.equals(str)) {
            return QQManagerFactory.GAMECENTER_MANAGER;
        }
        if (IEmosmService.MGR_MSG_FACADE.equals(str)) {
            return QQManagerFactory.MGR_MSG_FACADE;
        }
        QLog.e(TAG, 4, "name: " + str + " is ID -1.");
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public <T> ImageView getMarketFaceItemBuilderHolderImage(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (ImageView) iPatchRedirector.redirect((short) 70, (Object) this, (Object) t16);
        }
        return ((MarketFaceItemBuilder.c) t16).f179380h;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Class<?> getMessengerServiceClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (Class) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        return MessengerService.class;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public int getRandomMaxValue(Emoticon emoticon, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this, (Object) emoticon, i3)).intValue();
        }
        return MagicfaceActionManager.k(emoticon, i3);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public int getRichTextChatManagerEmoSearchConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return 5;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public String getSendCombineImg(Manager manager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return (String) iPatchRedirector.redirect((short) 68, (Object) this, (Object) manager);
        }
        return ((IndividualRedPacketManager) manager).C();
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public String getTimeoutReason(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fromServiceMsg);
        }
        return BaseMessageHandler.getTimeoutReason(fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Object getVasEmojiManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInterface);
        }
        return ((ao) appInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308428e;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Rect getViewRect(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (Rect) iPatchRedirector.redirect((short) 38, (Object) this, (Object) view);
        }
        if (view == null) {
            return null;
        }
        return j.d(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void gotoEmoMallPage(EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) emoticonCallback);
        } else if (emoticonCallback != null) {
            emoticonCallback.emoticonMall();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void handleComicStructMsg(BaseQQAppInterface baseQQAppInterface, Object obj, Object obj2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, baseQQAppInterface, obj, obj2);
        } else {
            c.j((QQAppInterface) baseQQAppInterface, (StructMsgForImageShare) obj, (CustomEmotionData) obj2);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void handleResonpse(BaseQQAppInterface baseQQAppInterface, Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, baseQQAppInterface, intent, fromServiceMsg);
        } else {
            HotPicManager.i((QQAppInterface) baseQQAppInterface).q(intent, fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public ActionGlobalData hasAction(Emoticon emoticon, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (ActionGlobalData) iPatchRedirector.redirect((short) 48, (Object) this, (Object) emoticon, i3);
        }
        return MagicfaceActionManager.n(emoticon, i3);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean hasReported(MessageRecord messageRecord, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageRecord, (Object) str)).booleanValue();
        }
        if (!com.tencent.mobileqq.utils.b.a().b(messageRecord, str)) {
            com.tencent.mobileqq.utils.b.a().c(messageRecord, str);
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Object initGestureDetector(Object obj, Context context, IPanelInteractionListener iPanelInteractionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return iPatchRedirector.redirect((short) 27, this, obj, context, iPanelInteractionListener);
        }
        if (iPanelInteractionListener == null) {
            return null;
        }
        return iPanelInteractionListener.initGestureDetector(obj);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean isComeFromComic(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this, (Object) str)).booleanValue();
        }
        return com.tencent.mobileqq.richmediabrowser.j.d(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean isFlashPicMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return ax.a(messageRecord);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean isLiveChannelScene(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return ((Boolean) iPatchRedirector.redirect((short) 77, (Object) this, i3)).booleanValue();
        }
        if (i3 != 2 && i3 != 10) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean isSplashChatContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this, (Object) context)).booleanValue();
        }
        if (!(context instanceof SplashActivity) && !(context instanceof ChatActivity)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean isSupportMagicface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return MagicfaceViewController.c();
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean justShowSystemAndEmoji(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            return ((Boolean) iPatchRedirector.redirect((short) 76, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        if (i3 == 1) {
            return !z16;
        }
        if (i3 != 3 && i3 != 2 && i3 != 10 && i3 != 6) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void launchAECameraUnit(Context context, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) context, obj);
            return;
        }
        if (obj != null && context != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(AECameraConstants.AECAMERA_MODE, 202);
            bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410912l.b());
            SessionInfo sessionInfo = ((a61.c) obj).f25589n;
            bundle.putParcelable(AECameraConstants.ARG_SESSION_INFO, new SessionWrap(sessionInfo.f179557e, sessionInfo.f179563i, sessionInfo.f179555d, sessionInfo.f179559f));
            ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).launchAECameraUnit((Activity) context, 120, bundle);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void launchFriendPicker(Activity activity, List<EmoticonInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) activity, (Object) list);
        } else {
            EmotionBatchForwardOption.U(activity, list);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public boolean magicfaceAutoPlay(Context context, Emoticon emoticon, com.tencent.mobileqq.magicface.view.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, this, context, emoticon, cVar)).booleanValue();
        }
        w.a("magicfaceAutoPlay");
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public StringBuilder obtainStringBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (StringBuilder) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return com.tencent.mobileqq.activity.aio.l.P();
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void openEmojiDetailPage(Context context, String str, int i3, String str2, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 53)) {
            EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity) context).getActivity(), str, i3, str2, z16, z17);
        } else {
            iPatchRedirector.redirect((short) 53, this, context, str, Integer.valueOf(i3), str2, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void openEmojiHomePage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, boolean z16, String str2, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            EmojiHomeUiPlugin.openEmojiHomePage(context, iEmoticonMainPanelApp, str, i3, z16, str2, z17);
        } else {
            iPatchRedirector.redirect((short) 23, this, context, iEmoticonMainPanelApp, str, Integer.valueOf(i3), Boolean.valueOf(z16), str2, Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void openEmosmActivity(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, boolean z16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, context, iEmoticonMainPanelApp, str, Integer.valueOf(i3), Boolean.valueOf(z16), str2);
        } else {
            EmojiHomeUiPlugin.openEmosmActivity(context, iEmoticonMainPanelApp, iEmoticonMainPanelApp.getAccount(), 1, false, "");
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void parseJson(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface);
        } else {
            if (!(appInterface instanceof QQAppInterface)) {
                return;
            }
            ((URLInterceptManager) appInterface.getManager(QQManagerFactory.URL_INTECEPT_MANAGER)).j((QQAppInterface) appInterface);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public Object reparse(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return iPatchRedirector.redirect((short) 13, (Object) this, (Object) baseQQAppInterface, (Object) str);
        }
        return ((PngFrameManager) baseQQAppInterface.getManager(QQManagerFactory.PNG_FRAME_DRAWABLE_MANAGER)).h(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void reportActionMobileReportManager(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
        } else {
            MobileReportManager.getInstance().reportAction(str, str2, str3, str4, str5, i3, i16, j3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void reportSendPicSource(String[] strArr, int i3, boolean z16, boolean z17, int i16, BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, strArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16), baseQQAppInterface);
        } else {
            m.k(strArr, i3, z16, z17, i16, (QQAppInterface) baseQQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void sendEmoPic(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) intent);
        } else if (context instanceof BaseActivity) {
            ThreadManagerV2.post(new SendPhotoTask((BaseActivity) context, intent, null), 8, null, false);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void sendEmosmMsg(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 49)) {
            ChatActivityFacade.H0((QQAppInterface) baseQQAppInterface, context, (SessionInfo) pVar, emoticon);
        } else {
            iPatchRedirector.redirect((short) 49, this, baseQQAppInterface, context, pVar, emoticon);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void sendEmoticon(AppInterface appInterface, Context context, p pVar, Emoticon emoticon, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInterface, context, pVar, emoticon, Boolean.valueOf(z16));
            return;
        }
        if (!(appInterface instanceof QQAppInterface)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        ChatActivityFacade.H0(qQAppInterface, context, pVar, emoticon);
        if (emoticon != null && emoticon.isNewSoundEmoticon()) {
            EmoticonOperateReport.reportNewSoundEvent(qQAppInterface, "0X800A932", ((SessionInfo) pVar).f179555d, emoticon.epId);
        }
        if (z16) {
            ((IEmoticonManagerService) qQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncIncreaseEmotionClickNum(emoticon);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void sendInfoFromPanelHelper(a61.b bVar, EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) bVar, (Object) emoticonInfo);
        } else {
            w.a("sendInfoFromPanelHelper");
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void sendRecEmoPic(AppInterface appInterface, QBaseActivity qBaseActivity, a61.b bVar, Editable editable, Intent intent, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInterface, qBaseActivity, bVar, editable, intent, arrayList);
            return;
        }
        ac acVar = (ac) bVar.b(41);
        if (acVar == null) {
            QLog.e(TAG, 1, "[sendRecEmoPic] error, specWordEmotionThinkHelper is null!");
            return;
        }
        if (acVar.c()) {
            ab abVar = (ab) bVar.b(119);
            if (abVar == null) {
                QLog.e(TAG, 1, "[sendRecEmoPic] error, replyHelper is null!");
                return;
            }
            MessageForReplyText.SourceMsgInfo c16 = abVar.c();
            Pair<String, ArrayList<AtTroopMemberInfo>> i3 = TroopUtils.i(editable);
            ((MixedMsgManager) appInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).A((QQAppInterface) appInterface, bVar.d().f179557e, bVar.d().f179555d, arrayList, false, (String) i3.first, (ArrayList) i3.second, c16, d.b(qBaseActivity));
            return;
        }
        sendEmoPic(qBaseActivity, intent);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void sendStickerMsg(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon, StickerInfo stickerInfo) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, baseQQAppInterface, context, pVar, emoticon, stickerInfo);
            return;
        }
        ChatActivityFacade.R0((QQAppInterface) baseQQAppInterface, context, (SessionInfo) pVar, emoticon, stickerInfo);
        IEmoticonMainPanel mainPanel = ((IHostEmoticonMainApi) QRoute.api(IHostEmoticonMainApi.class)).getMainPanel();
        if (mainPanel != null) {
            i3 = mainPanel.getEmoticonTab(emoticon.epId);
        } else {
            i3 = -1;
        }
        if (i3 >= 0) {
            str = Integer.toString(i3);
        } else {
            str = "";
        }
        ReportController.o(baseQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A9", 0, 0, emoticon.epId, "", str, emoticon.eId);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void sendStructMsgForImage(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, baseQQAppInterface, str, bundle, pVar);
            return;
        }
        StructMsgForImageShare.sendAndUploadImageShare((QQAppInterface) baseQQAppInterface, (StructMsgForImageShare) i.e(bundle), pVar.f179557e, pVar.f179555d, pVar.f179559f, 0);
        String[] a16 = com.tencent.mobileqq.richmediabrowser.j.a(str);
        if (a16 != null && a16.length >= 8) {
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(baseQQAppInterface, "100007", "2", "40051", a16[0], a16[2], a16[4], com.tencent.mobileqq.richmediabrowser.j.b(str));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void setEmojiStickerMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, z16);
        } else {
            EmojiStickerManager.f204578o = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void setEmotionSearchPanelVisible(IPanelInteractionListener iPanelInteractionListener, boolean z16, int i3, boolean z17, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, iPanelInteractionListener, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17), str, Integer.valueOf(i16));
            return;
        }
        IAIOEmoticonUIHelper iAIOEmoticonUIHelper = (IAIOEmoticonUIHelper) iPanelInteractionListener.getHelper(105);
        if (iAIOEmoticonUIHelper != null) {
            iAIOEmoticonUIHelper.setEmotionSearchPanelVisible(z16, i3, z17, str, i16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void setPicEmoticonTag(Context context, Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) context, (Object) emoticon);
        } else {
            QLog.w(TAG, 1, "setPicEmoticonTag not implemented");
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void showEmoticonPanel(IPanelInteractionListener iPanelInteractionListener, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) iPanelInteractionListener, i3);
            return;
        }
        EmoticonCallbackWithShowPanel emoticonCallbackWithShowPanel = (EmoticonCallbackWithShowPanel) iPanelInteractionListener.getHelper(104);
        if (emoticonCallbackWithShowPanel != null) {
            emoticonCallbackWithShowPanel.showEmoticonPanel(i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void showSearchEmoticonPanel(IPanelInteractionListener iPanelInteractionListener, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, this, iPanelInteractionListener, str, Boolean.valueOf(z16));
            return;
        }
        if (iPanelInteractionListener == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "showSearchEmoticonPanel: aioContext is null");
                return;
            }
            return;
        }
        IAIOSearchEmotionExpandHelper iAIOSearchEmotionExpandHelper = (IAIOSearchEmotionExpandHelper) iPanelInteractionListener.getHelper(185);
        if (iAIOSearchEmotionExpandHelper == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "showSearchEmoticonPanel: helper is null");
                return;
            }
            return;
        }
        iAIOSearchEmotionExpandHelper.showSearchEmotionPanel(str, z16);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void startEmoticonGroupStoreFragment(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) context);
        } else {
            QPublicFragmentActivity.start(context, EmoticonGroupStoreFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void startGIFCreator(Object obj, IEmosmService.GIFCreatorCallback gIFCreatorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, obj, (Object) gIFCreatorCallback);
        } else {
            ((GIFCreator) obj).l(new GIFCreator.b(gIFCreatorCallback) { // from class: com.tencent.mobileqq.emoticonview.api.impl.EmosmServiceImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IEmosmService.GIFCreatorCallback val$callback;

                {
                    this.val$callback = gIFCreatorCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmosmServiceImpl.this, (Object) gIFCreatorCallback);
                    }
                }

                @Override // dov.com.qq.im.ae.current.GIFCreator.b
                public void onGifCreateFail() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                        return;
                    }
                    IEmosmService.GIFCreatorCallback gIFCreatorCallback2 = this.val$callback;
                    if (gIFCreatorCallback2 != null) {
                        gIFCreatorCallback2.onGifCreateFail();
                    }
                }

                @Override // dov.com.qq.im.ae.current.GIFCreator.b
                public void onGifCreateSuccess(String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                        return;
                    }
                    IEmosmService.GIFCreatorCallback gIFCreatorCallback2 = this.val$callback;
                    if (gIFCreatorCallback2 != null) {
                        gIFCreatorCallback2.onGifCreateSuccess(str);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void toastFMDefault(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
        } else {
            com.tencent.mobileqq.filemanager.util.d.c(i3);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public <T extends IEmoticonMainPanel> T tryGetEmoticonMainPanel(IPanelInteractionListener iPanelInteractionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (T) iPatchRedirector.redirect((short) 22, (Object) this, (Object) iPanelInteractionListener);
        }
        if (iPanelInteractionListener == null) {
            return null;
        }
        if (iPanelInteractionListener instanceof CommonPanelInteractionListener) {
            return (T) ((CommonPanelInteractionListener) iPanelInteractionListener).getIEmoticonMainPanel();
        }
        if (iPanelInteractionListener instanceof u) {
            return (T) ((u) iPanelInteractionListener).a();
        }
        return (T) ((IAIOEmoticonUIHelper) iPanelInteractionListener.getHelper(105)).getMainPanel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void updateMarketFaceItemBuilderEmoticonInfo(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) emoticonInfo);
        } else {
            MarketFaceItemBuilder.f179359b = (IPicEmoticonInfo) emoticonInfo;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void openEmojiDetailPage(Activity activity, String str, int i3, String str2, boolean z16, Intent intent, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 65)) {
            EmojiHomeUiPlugin.openEmojiDetailPage(activity, str, i3, str2, z16, intent, z17);
        } else {
            iPatchRedirector.redirect((short) 65, this, activity, str, Integer.valueOf(i3), str2, Boolean.valueOf(z16), intent, Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void openEmojiHomePage(Activity activity, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 66)) {
            EmojiHomeUiPlugin.openEmojiHomePage(activity, str, i3);
        } else {
            iPatchRedirector.redirect((short) 66, this, activity, str, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmosmService
    public void sendEmosmMsg(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 51)) {
            ChatActivityFacade.I0((QQAppInterface) baseQQAppInterface, context, (SessionInfo) pVar, emoticon, i3);
        } else {
            iPatchRedirector.redirect((short) 51, this, baseQQAppInterface, context, pVar, emoticon, Integer.valueOf(i3));
        }
    }
}
