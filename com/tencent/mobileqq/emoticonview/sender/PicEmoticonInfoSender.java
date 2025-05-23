package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.magicface.drawable.d;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.view.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* loaded from: classes12.dex */
public class PicEmoticonInfoSender {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PicEmoticonInfoSender";

    public PicEmoticonInfoSender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void asyncStartH5MagicPlayActivity(Context context, BaseQQAppInterface baseQQAppInterface, Parcelable parcelable, Emoticon emoticon) {
        ThreadManagerV2.post(new Runnable(context, parcelable, emoticon) { // from class: com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context val$context;
            final /* synthetic */ Emoticon val$emoticon;
            final /* synthetic */ Parcelable val$sessionInfo;

            {
                this.val$context = context;
                this.val$sessionInfo = parcelable;
                this.val$emoticon = emoticon;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, BaseQQAppInterface.this, context, parcelable, emoticon);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                List<Emoticon> syncGetSubEmoticonsByPackageId;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (BaseQQAppInterface.this != null && this.val$context != null) {
                    Intent intent = new Intent(this.val$context, ((IEmosmService) QRoute.api(IEmosmService.class)).getH5MagicPlayerActivityClass());
                    intent.putExtra("clickTime", System.currentTimeMillis());
                    intent.putExtra("autoPlay", "1");
                    intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, BaseQQAppInterface.this.getCurrentAccountUin());
                    intent.putExtra("selfUin", BaseQQAppInterface.this.getCurrentAccountUin());
                    intent.putExtra("sessionInfo", this.val$sessionInfo);
                    intent.putExtra("emoticon", this.val$emoticon);
                    IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) BaseQQAppInterface.this.getRuntimeService(IEmoticonManagerService.class);
                    EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(this.val$emoticon.epId);
                    if (syncFindEmoticonPackageById != null && (syncGetSubEmoticonsByPackageId = iEmoticonManagerService.syncGetSubEmoticonsByPackageId(syncFindEmoticonPackageById.childEpId)) != null && syncGetSubEmoticonsByPackageId.size() > 0) {
                        intent.putExtra("childEmoticon", syncGetSubEmoticonsByPackageId.get(0));
                    }
                    this.val$context.startActivity(intent);
                }
            }
        }, 5, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void send(PicEmoticonInfo picEmoticonInfo, AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        if (picEmoticonInfo == null) {
            QLog.e(TAG, 1, "emoticonInfo is null");
        } else {
            send(appRuntime, context, (p) parcelable, picEmoticonInfo.emoticon, (StickerInfo) null);
        }
    }

    private static void sendH5MagicEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon, StickerInfo stickerInfo) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + baseQQAppInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(IEmoticonMainPanel.SP_KEY_SEND_H5_MAGIC_FACE_TIME, System.currentTimeMillis()).apply();
        }
        ReportController.o(baseQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, emoticon.epId, "", "", "");
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(emoticon.epId, 0, new QueryCallback<EmoticonPackage>(context, baseQQAppInterface, emoticon, (IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class), pVar) { // from class: com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseQQAppInterface val$app;
            final /* synthetic */ Context val$context;
            final /* synthetic */ Emoticon val$emoticon;
            final /* synthetic */ IEmojiManagerService val$pcm;
            final /* synthetic */ p val$sessionInfo;

            {
                this.val$context = context;
                this.val$app = baseQQAppInterface;
                this.val$emoticon = emoticon;
                this.val$pcm = r8;
                this.val$sessionInfo = pVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, context, baseQQAppInterface, emoticon, r8, pVar);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.QueryCallback
            public void postQuery(EmoticonPackage emoticonPackage) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                    return;
                }
                if (emoticonPackage != null && (2 != emoticonPackage.status || !emoticonPackage.valid)) {
                    ((IEmosmService) QRoute.api(IEmosmService.class)).openEmojiDetailPage(this.val$context, this.val$app.getAccount(), 8, this.val$emoticon.epId, false, emoticonPackage.jobType == 4);
                    ReportController.o(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
                    return;
                }
                if (this.val$pcm.getMagicFaceSendAccessControl()) {
                    if (this.val$pcm.isH5MagicFacePackageIntact(this.val$emoticon.epId, true, true)) {
                        if (this.val$pcm.isDPCSupportH5Magic()) {
                            PicEmoticonInfoSender.asyncStartH5MagicPlayActivity(this.val$context, this.val$app, (Parcelable) this.val$sessionInfo, this.val$emoticon);
                            ReportController.o(this.val$app, "CliOper", "", "", "MbFasong", "MbZidongBofang", 0, 0, "", "", "", "");
                            return;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d(PicEmoticonInfoSender.TAG, 2, "not support h5magic ");
                                return;
                            }
                            return;
                        }
                    }
                    EmotionUtils.f(this.val$context, R.string.f170270ku, 0);
                    MqqHandler chatActivityHander = ((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityHander(this.val$app);
                    if (chatActivityHander != null) {
                        chatActivityHander.obtainMessage(10).sendToTarget();
                        chatActivityHander.obtainMessage(21).sendToTarget();
                        return;
                    }
                    return;
                }
                EmotionUtils.c(this.val$context, R.string.f170281l6);
                ReportController.o(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
            }
        });
        sendStickerMsg(baseQQAppInterface, context, pVar, emoticon, stickerInfo);
    }

    private static void sendMagicEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon, StickerInfo stickerInfo) {
        IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
        ReportController.o(baseQQAppInterface, "CliOper", "", "", "MbFasong", "MbIDDianji", 0, 0, emoticon.epId, "", "", "");
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(emoticon.epId, -1, new QueryCallback<EmoticonPackage>(context, baseQQAppInterface, emoticon, iEmojiManagerService, pVar, stickerInfo) { // from class: com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseQQAppInterface val$app;
            final /* synthetic */ Context val$context;
            final /* synthetic */ Emoticon val$emoticon;
            final /* synthetic */ IEmojiManagerService val$pcm;
            final /* synthetic */ p val$sessionInfo;
            final /* synthetic */ StickerInfo val$stickerInfo;

            {
                this.val$context = context;
                this.val$app = baseQQAppInterface;
                this.val$emoticon = emoticon;
                this.val$pcm = iEmojiManagerService;
                this.val$sessionInfo = pVar;
                this.val$stickerInfo = stickerInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, context, baseQQAppInterface, emoticon, iEmojiManagerService, pVar, stickerInfo);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mobileqq.emoticonview.QueryCallback
            public void postQuery(EmoticonPackage emoticonPackage) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                    return;
                }
                if (emoticonPackage != null && (2 != emoticonPackage.status || !emoticonPackage.valid)) {
                    ((IEmosmService) QRoute.api(IEmosmService.class)).openEmojiDetailPage(this.val$context, this.val$app.getAccount(), 8, this.val$emoticon.epId, false, emoticonPackage.jobType == 4 ? 1 : 0);
                    ReportController.o(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
                    return;
                }
                if (this.val$pcm.getMagicFaceSendAccessControl()) {
                    if (!this.val$pcm.isMagicFacePackageIntact(this.val$emoticon.epId, Boolean.FALSE)) {
                        EmotionUtils.f(this.val$context, R.string.f170270ku, 0);
                        MqqHandler chatActivityHander = ((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityHander(this.val$app);
                        if (chatActivityHander != null) {
                            chatActivityHander.obtainMessage(10).sendToTarget();
                            chatActivityHander.obtainMessage(21).sendToTarget();
                            return;
                        }
                        return;
                    }
                    ActionGlobalData hasAction = ((IEmosmService) QRoute.api(IEmosmService.class)).hasAction(this.val$emoticon, 0);
                    if (hasAction != null && hasAction.f243349b) {
                        if (((IEmosmService) QRoute.api(IEmosmService.class)).isSupportMagicface()) {
                            ((IEmosmService) QRoute.api(IEmosmService.class)).setPicEmoticonTag(this.val$context, this.val$emoticon);
                            return;
                        }
                        this.val$emoticon.magicValue = "value=1";
                    } else {
                        int d16 = d.d(((IEmosmService) QRoute.api(IEmosmService.class)).getRandomMaxValue(this.val$emoticon, 0));
                        String str = "rscType?" + (emoticonPackage != null ? emoticonPackage.rscType : 0) + ";value=" + d16;
                        this.val$emoticon.magicValue = str;
                        if (QLog.isColorLevel()) {
                            QLog.d(PicEmoticonInfoSender.TAG, 2, "before play,magicvalue:" + this.val$emoticon.magicValue);
                        }
                        if (hasAction != null && !hasAction.f243352e) {
                            ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmosmMsg(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon);
                            ReportController.o(this.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, this.val$emoticon.epId, "", "", "");
                            return;
                        } else if (((IEmosmService) QRoute.api(IEmosmService.class)).magicfaceAutoPlay(this.val$context, this.val$emoticon, new c(str) { // from class: com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.3.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ String val$magicValueCopy;

                            {
                                this.val$magicValueCopy = str;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) str);
                                }
                            }

                            @Override // com.tencent.mobileqq.magicface.view.c
                            public void onPlayEnd() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(PicEmoticonInfoSender.TAG, 2, "[play back] ready to send msg,magicvalue:" + AnonymousClass3.this.val$emoticon.magicValue);
                                }
                                AnonymousClass3.this.val$emoticon.magicValue = this.val$magicValueCopy;
                                IEmosmService iEmosmService = (IEmosmService) QRoute.api(IEmosmService.class);
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                iEmosmService.sendEmosmMsg(anonymousClass3.val$app, anonymousClass3.val$context, anonymousClass3.val$sessionInfo, anonymousClass3.val$emoticon);
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                ReportController.o(anonymousClass32.val$app, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, anonymousClass32.val$emoticon.epId, "", "", "");
                            }
                        })) {
                            return;
                        }
                    }
                    PicEmoticonInfoSender.sendStickerMsg(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon, this.val$stickerInfo);
                    return;
                }
                EmotionUtils.c(this.val$context, R.string.f170281l6);
                ReportController.o(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
            }
        });
    }

    private static void sendMagicMarketEmoticon(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon, StickerInfo stickerInfo) {
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(emoticon.epId, -1, new QueryCallback<EmoticonPackage>(context, baseQQAppInterface, emoticon, (IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class), pVar) { // from class: com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseQQAppInterface val$app;
            final /* synthetic */ Context val$context;
            final /* synthetic */ Emoticon val$emoticon;
            final /* synthetic */ IEmojiManagerService val$pcm;
            final /* synthetic */ p val$sessionInfo;

            {
                this.val$context = context;
                this.val$app = baseQQAppInterface;
                this.val$emoticon = emoticon;
                this.val$pcm = r8;
                this.val$sessionInfo = pVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, context, baseQQAppInterface, emoticon, r8, pVar);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mobileqq.emoticonview.QueryCallback
            public void postQuery(EmoticonPackage emoticonPackage) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("sendMarketEmoticon :");
                sb5.append(emoticonPackage != null ? emoticonPackage.toString() : "null");
                QLog.d(PicEmoticonInfoSender.TAG, 2, sb5.toString());
                if (emoticonPackage != null && (2 != emoticonPackage.status || !emoticonPackage.valid)) {
                    ((IEmosmService) QRoute.api(IEmosmService.class)).openEmojiDetailPage(this.val$context, this.val$app.getAccount(), 8, this.val$emoticon.epId, false, emoticonPackage.jobType == 4 ? 1 : 0);
                    ReportController.o(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
                    return;
                }
                if (!this.val$pcm.getMagicFaceSendAccessControl()) {
                    EmotionUtils.c(this.val$context, R.string.f170281l6);
                    ReportController.o(this.val$app, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
                    return;
                }
                if (!this.val$pcm.isMagicFacePackageIntact(this.val$emoticon.epId, Boolean.FALSE)) {
                    EmotionUtils.f(this.val$context, R.string.f170270ku, 0);
                    return;
                }
                int d16 = d.d(((IEmosmService) QRoute.api(IEmosmService.class)).getRandomMaxValue(this.val$emoticon, 0));
                String str = "rscType?" + (emoticonPackage != null ? emoticonPackage.rscType : 0) + ";value=" + d16;
                this.val$emoticon.magicValue = str;
                if (QLog.isColorLevel()) {
                    QLog.d(PicEmoticonInfoSender.TAG, 2, "before play,magicvalue:" + this.val$emoticon.magicValue);
                }
                this.val$emoticon.magicValue = str;
                ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmosmMsg(this.val$app, this.val$context, this.val$sessionInfo, this.val$emoticon);
            }
        });
    }

    public static void sendMarketFace(AppRuntime appRuntime, Context context, p pVar, Emoticon emoticon, StickerInfo stickerInfo) {
        if (emoticon == null) {
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "1", "", "", "", "", "", "", "");
            QLog.e(TAG, 1, "send emotion + 1:emotion == null");
            return;
        }
        if (appRuntime != null && pVar != null) {
            if (!(appRuntime instanceof BaseQQAppInterface)) {
                return;
            }
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "emotion mall,epid=" + emoticon.epId + ";jobtype=" + emoticon.jobType);
            }
            if (emoticon.isNewSoundEmoticon()) {
                EmoticonOperateReport.reportNewSoundEvent(baseQQAppInterface, "0X800A932", pVar.f179555d, emoticon.epId);
            }
            if (emoticon.jobType == 2) {
                sendMagicMarketEmoticon(baseQQAppInterface, context, pVar, emoticon, stickerInfo);
                return;
            } else {
                sendStickerMsg(baseQQAppInterface, context, pVar, emoticon, stickerInfo);
                return;
            }
        }
        QLog.e(TAG, 1, "app or session is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendStickerMsg(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, Emoticon emoticon, StickerInfo stickerInfo) {
        ((IEmosmService) QRoute.api(IEmosmService.class)).sendStickerMsg(baseQQAppInterface, context, pVar, emoticon, stickerInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void send(Emoticon emoticon, AppRuntime appRuntime, Context context, EditText editText, p pVar, boolean z16, int i3) {
        if (appRuntime == null) {
            QLog.e(TAG, 2, "app is null.");
            return;
        }
        if (appRuntime instanceof BaseQQAppInterface) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
            if (emoticon == null) {
                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "1", "", "", "", "", "", "", "");
                QLog.e(TAG, 1, "send isFroward emotion = null");
                return;
            }
            IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
            if (emoticon.jobType == 2 && z16 && ((IEmosmService) QRoute.api(IEmosmService.class)).isSplashChatContext(context) && ((IEmosmService) QRoute.api(IEmosmService.class)).isSupportMagicface()) {
                if (!iEmojiManagerService.isMagicFacePackageIntact(emoticon.epId, Boolean.FALSE)) {
                    QQToast.makeText(context, R.string.f170270ku, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    MqqHandler chatActivityHander = ((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityHander(baseQQAppInterface);
                    if (chatActivityHander != null) {
                        chatActivityHander.obtainMessage(10).sendToTarget();
                        chatActivityHander.obtainMessage(21).sendToTarget();
                        return;
                    }
                    return;
                }
                int randomMaxValue = ((IEmosmService) QRoute.api(IEmosmService.class)).getRandomMaxValue(emoticon, 0);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "forward,\u3010maxInt:\u3011" + randomMaxValue);
                }
                ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(emoticon.epId, new QueryCallback<EmoticonPackage>(baseQQAppInterface, d.d(randomMaxValue), context, pVar) { // from class: com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ BaseQQAppInterface val$app;
                    final /* synthetic */ Context val$context;
                    final /* synthetic */ int val$random;
                    final /* synthetic */ p val$sessionInfo;

                    {
                        this.val$app = baseQQAppInterface;
                        this.val$random = r7;
                        this.val$context = context;
                        this.val$sessionInfo = pVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, Emoticon.this, baseQQAppInterface, Integer.valueOf(r7), context, pVar);
                        }
                    }

                    @Override // com.tencent.mobileqq.emoticonview.QueryCallback
                    public void postQuery(EmoticonPackage emoticonPackage) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                            return;
                        }
                        int g16 = d.g(Emoticon.this.magicValue);
                        if (-1 != g16 && emoticonPackage != null) {
                            emoticonPackage.rscType = g16;
                            ((IEmoticonManagerService) this.val$app.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPackage(emoticonPackage);
                        }
                        String str = "rscType?" + g16 + ";value=" + this.val$random;
                        Emoticon.this.magicValue = str;
                        if (QLog.isColorLevel()) {
                            QLog.d(PicEmoticonInfoSender.TAG, 2, "before play,magicvalue:" + str);
                        }
                        ActionGlobalData hasAction = ((IEmosmService) QRoute.api(IEmosmService.class)).hasAction(Emoticon.this, 0);
                        if (hasAction != null && !hasAction.f243352e) {
                            ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmosmMsg(this.val$app, this.val$context, this.val$sessionInfo, Emoticon.this);
                        } else {
                            ((IEmosmService) QRoute.api(IEmosmService.class)).magicfaceAutoPlay(this.val$context, Emoticon.this, new c(str) { // from class: com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.1.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ String val$magicValueCopy;

                                {
                                    this.val$magicValueCopy = str;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) str);
                                    }
                                }

                                @Override // com.tencent.mobileqq.magicface.view.c
                                public void onPlayEnd() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    if (QLog.isColorLevel()) {
                                        QLog.d(PicEmoticonInfoSender.TAG, 2, "forward, [play back] ready to send msg,magicvalue:" + Emoticon.this.magicValue);
                                    }
                                    Emoticon.this.magicValue = this.val$magicValueCopy;
                                    IEmosmService iEmosmService = (IEmosmService) QRoute.api(IEmosmService.class);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    iEmosmService.sendEmosmMsg(anonymousClass1.val$app, anonymousClass1.val$context, anonymousClass1.val$sessionInfo, Emoticon.this);
                                }
                            });
                        }
                    }
                });
                return;
            }
            if (emoticon.jobType == 4 && z16 && ((IEmosmService) QRoute.api(IEmosmService.class)).isSplashChatContext(context)) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + baseQQAppInterface.getCurrentAccountUin(), 0);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(IEmoticonMainPanel.SP_KEY_SEND_H5_MAGIC_FACE_TIME, System.currentTimeMillis()).apply();
                }
                if (iEmojiManagerService.isH5MagicFacePackageIntact(emoticon.epId, true, true)) {
                    if (iEmojiManagerService.isDPCSupportH5Magic()) {
                        asyncStartH5MagicPlayActivity(context, baseQQAppInterface, (Parcelable) pVar, emoticon);
                    } else if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "forward not support h5magic");
                    }
                } else {
                    QQToast.makeText(context, R.string.f170270ku, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    MqqHandler chatActivityHander2 = ((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityHander(baseQQAppInterface);
                    if (chatActivityHander2 != null) {
                        chatActivityHander2.obtainMessage(10).sendToTarget();
                        chatActivityHander2.obtainMessage(21).sendToTarget();
                        return;
                    }
                    return;
                }
            }
            ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmosmMsg(baseQQAppInterface, context, pVar, emoticon, i3);
        }
    }

    public static void send(AppRuntime appRuntime, Context context, p pVar, Emoticon emoticon, StickerInfo stickerInfo) {
        if (emoticon == null) {
            VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "1", "", "", "", "", "", "", "");
            QLog.e(TAG, 1, "send emotion + 1:emotion == null");
            return;
        }
        if (appRuntime != null && pVar != null) {
            if (appRuntime instanceof BaseQQAppInterface) {
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "emotion mall,epid=" + emoticon.epId + ";jobtype=" + emoticon.jobType);
                }
                if (emoticon.isNewSoundEmoticon()) {
                    EmoticonOperateReport.reportNewSoundEvent(baseQQAppInterface, "0X800A932", pVar.f179555d, emoticon.epId);
                }
                if (emoticon.jobType == 2 && ((IEmosmService) QRoute.api(IEmosmService.class)).isSplashChatContext(context)) {
                    sendMagicEmoticon(baseQQAppInterface, context, pVar, emoticon, stickerInfo);
                    return;
                } else if (emoticon.jobType == 4 && ((IEmosmService) QRoute.api(IEmosmService.class)).isSplashChatContext(context)) {
                    sendH5MagicEmoticon(baseQQAppInterface, context, pVar, emoticon, stickerInfo);
                    return;
                } else {
                    sendStickerMsg(baseQQAppInterface, context, pVar, emoticon, stickerInfo);
                    return;
                }
            }
            return;
        }
        QLog.e(TAG, 1, "app or session is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void send(PicEmoticonInfo picEmoticonInfo, AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable, boolean z16, int i3) {
        if (appRuntime != null && picEmoticonInfo != null) {
            if (appRuntime instanceof BaseQQAppInterface) {
                Emoticon emoticon = picEmoticonInfo.emoticon;
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
                p pVar = (p) parcelable;
                if (emoticon == null) {
                    VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "1", "", "", "", "", "", "", "");
                    QLog.e(TAG, 1, "send isFroward emotion = null");
                    return;
                }
                IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) baseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
                if (emoticon.jobType == 2 && z16 && ((IEmosmService) QRoute.api(IEmosmService.class)).isSplashChatContext(context) && ((IEmosmService) QRoute.api(IEmosmService.class)).isSupportMagicface()) {
                    if (!iEmojiManagerService.isMagicFacePackageIntact(emoticon.epId, Boolean.FALSE)) {
                        EmotionUtils.f(context, R.string.f170270ku, 0);
                        MqqHandler chatActivityHander = ((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityHander(baseQQAppInterface);
                        if (chatActivityHander != null) {
                            chatActivityHander.obtainMessage(10).sendToTarget();
                            chatActivityHander.obtainMessage(21).sendToTarget();
                            return;
                        }
                        return;
                    }
                    int randomMaxValue = ((IEmosmService) QRoute.api(IEmosmService.class)).getRandomMaxValue(emoticon, 0);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "forward,\u3010maxInt:\u3011" + randomMaxValue);
                    }
                    ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(emoticon.epId, new QueryCallback<EmoticonPackage>(baseQQAppInterface, d.d(randomMaxValue), context, pVar) { // from class: com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.6
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ BaseQQAppInterface val$app;
                        final /* synthetic */ Context val$context;
                        final /* synthetic */ int val$random;
                        final /* synthetic */ p val$sessionInfo;

                        {
                            this.val$app = baseQQAppInterface;
                            this.val$random = r7;
                            this.val$context = context;
                            this.val$sessionInfo = pVar;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, Emoticon.this, baseQQAppInterface, Integer.valueOf(r7), context, pVar);
                            }
                        }

                        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
                        public void postQuery(EmoticonPackage emoticonPackage) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                                return;
                            }
                            int g16 = d.g(Emoticon.this.magicValue);
                            if (-1 != g16 && emoticonPackage != null) {
                                emoticonPackage.rscType = g16;
                                ((IEmoticonManagerService) this.val$app.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPackage(emoticonPackage);
                            }
                            String str = "rscType?" + g16 + ";value=" + this.val$random;
                            Emoticon.this.magicValue = str;
                            if (QLog.isColorLevel()) {
                                QLog.d(PicEmoticonInfoSender.TAG, 2, "before play,magicvalue:" + str);
                            }
                            ActionGlobalData hasAction = ((IEmosmService) QRoute.api(IEmosmService.class)).hasAction(Emoticon.this, 0);
                            if (hasAction != null && !hasAction.f243352e) {
                                ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmosmMsg(this.val$app, this.val$context, this.val$sessionInfo, Emoticon.this);
                            } else {
                                ((IEmosmService) QRoute.api(IEmosmService.class)).magicfaceAutoPlay(this.val$context, Emoticon.this, new c(str) { // from class: com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.6.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ String val$magicValueCopy;

                                    {
                                        this.val$magicValueCopy = str;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this, (Object) str);
                                        }
                                    }

                                    @Override // com.tencent.mobileqq.magicface.view.c
                                    public void onPlayEnd() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.d(PicEmoticonInfoSender.TAG, 2, "forward, [play back] ready to send msg,magicvalue:" + Emoticon.this.magicValue);
                                        }
                                        Emoticon.this.magicValue = this.val$magicValueCopy;
                                        IEmosmService iEmosmService = (IEmosmService) QRoute.api(IEmosmService.class);
                                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                        iEmosmService.sendEmosmMsg(anonymousClass6.val$app, anonymousClass6.val$context, anonymousClass6.val$sessionInfo, Emoticon.this);
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                if (emoticon.jobType == 4 && z16 && ((IEmosmService) QRoute.api(IEmosmService.class)).isSplashChatContext(context)) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + baseQQAppInterface.getCurrentAccountUin(), 0);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putLong(IEmoticonMainPanel.SP_KEY_SEND_H5_MAGIC_FACE_TIME, System.currentTimeMillis()).apply();
                    }
                    if (iEmojiManagerService.isH5MagicFacePackageIntact(emoticon.epId, true, true)) {
                        if (iEmojiManagerService.isDPCSupportH5Magic()) {
                            asyncStartH5MagicPlayActivity(context, baseQQAppInterface, (Parcelable) pVar, emoticon);
                        } else if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "forward not support h5magic");
                        }
                    } else {
                        EmotionUtils.f(context, R.string.f170270ku, 0);
                        MqqHandler chatActivityHander2 = ((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityHander(baseQQAppInterface);
                        if (chatActivityHander2 != null) {
                            chatActivityHander2.obtainMessage(10).sendToTarget();
                            chatActivityHander2.obtainMessage(21).sendToTarget();
                            return;
                        }
                        return;
                    }
                }
                ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmosmMsg(baseQQAppInterface, context, pVar, emoticon, i3);
                return;
            }
            return;
        }
        QLog.e(TAG, 2, "app is null.");
    }

    public static void send(AppRuntime appRuntime, Context context, p pVar, Emoticon emoticon, Serializable serializable) {
        send(appRuntime, context, pVar, emoticon, (StickerInfo) serializable);
    }
}
