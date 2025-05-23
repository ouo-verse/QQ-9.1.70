package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.ac;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.TroopGiftMsg;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bt {

    /* renamed from: a, reason: collision with root package name */
    private static long f307500a;

    /* renamed from: b, reason: collision with root package name */
    private static long f307501b;

    /* renamed from: c, reason: collision with root package name */
    private static int f307502c;

    /* renamed from: d, reason: collision with root package name */
    private static float f307503d;

    /* renamed from: e, reason: collision with root package name */
    private static float f307504e;

    /* renamed from: f, reason: collision with root package name */
    private static float f307505f;

    private static void a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, boolean z16, boolean z17, MsgSummary msgSummary) {
        if (msgSummary == null) {
            return;
        }
        msgSummary.strPrefix = charSequence;
        msgSummary.strContent = charSequence2;
        msgSummary.suffix = charSequence3;
        if (z16) {
            msgSummary.nState = 2;
        } else if (z17) {
            msgSummary.nState = 1;
        } else {
            msgSummary.nState = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:237:0x04fc, code lost:
    
        if (r14 == null) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x051a, code lost:
    
        if (r0 == 1004) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:729:0x0c55, code lost:
    
        if (((com.tencent.mobileqq.scribble.IScribbleMsgUtils) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.scribble.IScribbleMsgUtils.class)).getScribbleDataReadyState(r0) != com.tencent.mobileqq.scribble.e.f282560c) goto L502;
     */
    /* JADX WARN: Code restructure failed: missing block: B:864:0x13a5, code lost:
    
        if (r14 == null) goto L859;
     */
    /* JADX WARN: Code restructure failed: missing block: B:912:0x13c7, code lost:
    
        if (r0 == 1004) goto L859;
     */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0413 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x052c A[Catch: Exception -> 0x05c5, TryCatch #11 {Exception -> 0x05c5, blocks: (B:175:0x0413, B:177:0x0417, B:179:0x0421, B:205:0x046f, B:207:0x0475, B:209:0x0480, B:210:0x0486, B:212:0x048e, B:213:0x0493, B:216:0x049b, B:218:0x04a1, B:219:0x04a4, B:240:0x0528, B:242:0x052c, B:245:0x053b, B:247:0x0541, B:249:0x0545, B:250:0x054a, B:253:0x059d, B:255:0x05a7, B:257:0x05bc, B:259:0x05b5, B:263:0x0578, B:265:0x057e, B:280:0x0524), top: B:174:0x0413 }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x0d14  */
    /* JADX WARN: Removed duplicated region for block: B:798:0x122d  */
    /* JADX WARN: Removed duplicated region for block: B:802:0x1252  */
    /* JADX WARN: Removed duplicated region for block: B:808:0x1236  */
    /* JADX WARN: Removed duplicated region for block: B:869:0x13dc  */
    /* JADX WARN: Removed duplicated region for block: B:883:0x1450  */
    /* JADX WARN: Removed duplicated region for block: B:887:0x146b  */
    /* JADX WARN: Removed duplicated region for block: B:890:0x1481  */
    /* JADX WARN: Removed duplicated region for block: B:894:0x141f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context, AppInterface appInterface, Message message, int i3, MsgSummary msgSummary, String str, boolean z16, boolean z17) {
        MessageForPic messageForPic;
        IHttpCommunicatorListener iHttpCommunicatorListener;
        boolean z18;
        boolean z19;
        int i16;
        String string;
        String msgSummaryForAnimationPic;
        String str2;
        boolean z26;
        char c16;
        char c17;
        boolean z27;
        boolean z28;
        int i17;
        boolean z29;
        boolean z36;
        boolean z37;
        IHttpCommunicatorListener iHttpCommunicatorListener2;
        int i18;
        boolean z38;
        String string2;
        int i19;
        int i26;
        int i27;
        boolean z39;
        boolean z46;
        MessageForScribble messageForScribble;
        boolean z47;
        boolean z48;
        CharSequence spannableString;
        int i28;
        MessageRecord lastMsgForMsgTab;
        MessageForUniteGrayTip messageForUniteGrayTip;
        com.tencent.mobileqq.graytip.g gVar;
        com.tencent.mobileqq.graytip.g gVar2;
        boolean z49;
        boolean z55;
        CharSequence messageText;
        ITroopRobotService iTroopRobotService;
        CharSequence spannableString2;
        String str3;
        CharSequence charSequence;
        CharSequence charSequence2;
        Object obj;
        String str4;
        boolean z56;
        IHttpCommunicatorListener iHttpCommunicatorListener3;
        boolean z57;
        int i29;
        boolean z58;
        String str5;
        MessageForPic messageForPic2;
        boolean z59;
        CharSequence t16;
        String t17;
        boolean z65;
        if (message == null) {
            return;
        }
        String o16 = o(appInterface, message, str, z16);
        if (!TextUtils.isEmpty(message.prefixOfNickname) && !TextUtils.isEmpty(o16)) {
            o16 = ((Object) message.prefixOfNickname) + o16;
        }
        String str6 = o16;
        if (f(context, appInterface, message, i3, msgSummary, str6, z16, z17)) {
            return;
        }
        int i36 = message.msgtype;
        if (i36 == -2034) {
            msgSummary.strContent = MessageForGrayTips.getOrginMsg(message.f203106msg);
        } else {
            String str7 = "";
            if (i36 == -2011) {
                if (i36 == -2011 && message.extInt == 61) {
                    message.f203106msg = appInterface.getApp().getResources().getString(R.string.f171497fi4);
                }
                if (message.istroop == 1 && com.tencent.mobileqq.troop.utils.z.g(((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq))) {
                    a(null, null, message.f203106msg, false, false, msgSummary);
                    z65 = true;
                } else {
                    z65 = false;
                }
                if (!z65) {
                    a(str6, null, message.f203106msg, n(appInterface, message), m((QQAppInterface) appInterface, message), msgSummary);
                }
            } else if (i36 == -2000 || i36 == -5015) {
                try {
                    str2 = message.frienduin;
                    if (com.tencent.imcore.message.ao.z(str2, message.istroop)) {
                        str2 = message.senderuin;
                    }
                    messageForPic = (MessageForPic) ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(str2, message.istroop, message.uniseq);
                } catch (Exception e16) {
                    e = e16;
                    messageForPic = null;
                }
                try {
                    iHttpCommunicatorListener = ((ITransFileController) appInterface.getRuntimeService(ITransFileController.class, "")).findProcessor(str2, message.uniseq);
                    try {
                        if (!message.isSendFromLocal()) {
                            if (iHttpCommunicatorListener != null) {
                                if (iHttpCommunicatorListener instanceof BaseTransProcessor) {
                                    int fileStatus = (int) ((BaseTransProcessor) iHttpCommunicatorListener).getFileStatus();
                                    if (fileStatus != 1005) {
                                    }
                                    z26 = true;
                                }
                            }
                            z26 = false;
                        } else if (messageForPic == null || messageForPic.size > 0) {
                            if (messageForPic != null && messageForPic.extraflag == 32768) {
                                z26 = true;
                            }
                            z26 = false;
                        }
                        z18 = z26;
                    } catch (Exception e17) {
                        e = e17;
                        e.printStackTrace();
                        z18 = false;
                        if (iHttpCommunicatorListener instanceof BaseTransProcessor) {
                        }
                        i16 = R.string.aek;
                        string = context.getString(i16);
                        if (!com.tencent.mobileqq.app.ax.a(message)) {
                        }
                        string = context.getString(R.string.aeg);
                        if (message.msgtype == -5015) {
                        }
                        msgSummaryForAnimationPic = ((IPicHelper) QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic(messageForPic);
                        if (msgSummaryForAnimationPic == null) {
                        }
                        a(str6, msgSummaryForAnimationPic, null, z18, z19, msgSummary);
                        h(context, appInterface, message, msgSummary);
                    }
                } catch (Exception e18) {
                    e = e18;
                    iHttpCommunicatorListener = null;
                    e.printStackTrace();
                    z18 = false;
                    if (iHttpCommunicatorListener instanceof BaseTransProcessor) {
                    }
                    i16 = R.string.aek;
                    string = context.getString(i16);
                    if (!com.tencent.mobileqq.app.ax.a(message)) {
                    }
                    string = context.getString(R.string.aeg);
                    if (message.msgtype == -5015) {
                    }
                    msgSummaryForAnimationPic = ((IPicHelper) QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic(messageForPic);
                    if (msgSummaryForAnimationPic == null) {
                    }
                    a(str6, msgSummaryForAnimationPic, null, z18, z19, msgSummary);
                    h(context, appInterface, message, msgSummary);
                }
                if (iHttpCommunicatorListener instanceof BaseTransProcessor) {
                    BaseTransProcessor baseTransProcessor = (BaseTransProcessor) iHttpCommunicatorListener;
                    boolean z66 = baseTransProcessor.getFileStatus() != Constant.FROM_ID_START_ACTIVITY;
                    if (QLog.isColorLevel()) {
                        TransferRequest transferRequest = baseTransProcessor.mUiRequest;
                        QLog.d("sendingpic", 2, "uniseq:" + (transferRequest != null ? transferRequest.mUniseq : -1L) + ",key:" + baseTransProcessor.getKey());
                    }
                    z19 = z66;
                } else if (iHttpCommunicatorListener != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("sendingpic", 2, "processor:" + iHttpCommunicatorListener);
                    }
                    i16 = R.string.aek;
                    z19 = true;
                    string = context.getString(i16);
                    if (!com.tencent.mobileqq.app.ax.a(message) || ((IPicFlash) QRoute.api(IPicFlash.class)).isFlashPicMsg(message)) {
                        string = context.getString(R.string.aeg);
                    }
                    if (message.msgtype == -5015) {
                        string = context.getString(R.string.aee);
                    }
                    msgSummaryForAnimationPic = ((IPicHelper) QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic(messageForPic);
                    if (msgSummaryForAnimationPic == null) {
                        msgSummaryForAnimationPic = string;
                    }
                    a(str6, msgSummaryForAnimationPic, null, z18, z19, msgSummary);
                } else {
                    z19 = false;
                }
                i16 = R.string.aek;
                string = context.getString(i16);
                if (!com.tencent.mobileqq.app.ax.a(message)) {
                }
                string = context.getString(R.string.aeg);
                if (message.msgtype == -5015) {
                }
                msgSummaryForAnimationPic = ((IPicHelper) QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic(messageForPic);
                if (msgSummaryForAnimationPic == null) {
                }
                a(str6, msgSummaryForAnimationPic, null, z18, z19, msgSummary);
            } else if (i36 == -2002 || i36 == -1031) {
                String str8 = message.frienduin;
                if (com.tencent.imcore.message.ao.z(str8, message.istroop)) {
                    str8 = message.senderuin;
                }
                String string3 = context.getString(R.string.ael);
                MessageRecord queryMsgItemByUniseq = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(str8, message.istroop, message.uniseq);
                if (queryMsgItemByUniseq instanceof MessageForPtt) {
                    MessageForPtt messageForPtt = (MessageForPtt) queryMsgItemByUniseq;
                    string3 = messageForPtt.getSummaryMsg();
                    if (message.isSendFromLocal()) {
                        long j3 = messageForPtt.fileSize;
                        if (j3 == -1) {
                            z27 = true;
                            z28 = false;
                            i17 = 2;
                            c16 = 0;
                            c17 = 1;
                            Object[] objArr = new Object[i17];
                            objArr[c16] = Boolean.valueOf(z27);
                            objArr[c17] = Boolean.valueOf(z28);
                            com.tencent.mobileqq.dating.f.j("buildMsgSummaryForMsg", objArr);
                            a(str6, string3, null, z27, z28, msgSummary);
                        } else if (j3 <= 0) {
                            int findProcessorFileStatus = TransFileControllerBusHelper.findProcessorFileStatus(appInterface, str8, messageForPtt.url, messageForPtt.uniseq);
                            if (findProcessorFileStatus == 1005 || findProcessorFileStatus == 1004 || findProcessorFileStatus == -1) {
                                z29 = true;
                                z36 = false;
                            } else {
                                z29 = false;
                                z36 = true;
                            }
                            c16 = 0;
                            c17 = 1;
                            com.tencent.mobileqq.dating.f.j("buildMsgSummaryForMsg", Long.valueOf(messageForPtt.fileSize), Integer.valueOf(findProcessorFileStatus));
                            z27 = z29;
                            z28 = z36;
                            i17 = 2;
                            Object[] objArr2 = new Object[i17];
                            objArr2[c16] = Boolean.valueOf(z27);
                            objArr2[c17] = Boolean.valueOf(z28);
                            com.tencent.mobileqq.dating.f.j("buildMsgSummaryForMsg", objArr2);
                            a(str6, string3, null, z27, z28, msgSummary);
                        }
                    }
                }
                c16 = 0;
                c17 = 1;
                z27 = false;
                z28 = false;
                i17 = 2;
                Object[] objArr22 = new Object[i17];
                objArr22[c16] = Boolean.valueOf(z27);
                objArr22[c17] = Boolean.valueOf(z28);
                com.tencent.mobileqq.dating.f.j("buildMsgSummaryForMsg", objArr22);
                a(str6, string3, null, z27, z28, msgSummary);
            } else if (i36 == -3008) {
                msgSummary.strContent = context.getString(R.string.b6j) + "\"" + message.f203106msg + "\"";
            } else if (i36 != -2015 && i36 != -2060 && i36 != -2062 && i36 != -2065 && i36 != -7010 && i36 != -7009 && i36 != -7011 && i36 != -7012 && i36 != -4023 && i36 != -4024 && i36 != -4025 && i36 != -4026 && i36 != -4027 && i36 != -7013 && i36 != -7015) {
                if (c.h(i36)) {
                    QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
                    a(str6, e(context, qQAppInterface, message), null, n(appInterface, message), m(qQAppInterface, message), msgSummary);
                } else {
                    int i37 = message.msgtype;
                    if (i37 == -2017) {
                        String string4 = context.getString(R.string.drq);
                        String str9 = message.frienduin;
                        if (com.tencent.imcore.message.ao.z(str9, message.istroop)) {
                            str9 = message.senderuin;
                        }
                        MessageRecord queryMsgItemByUniseq2 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(str9, message.istroop, message.uniseq);
                        if (queryMsgItemByUniseq2 instanceof MessageForTroopFile) {
                            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) queryMsgItemByUniseq2;
                            if (com.tencent.mobileqq.filemanager.util.k.g(queryMsgItemByUniseq2)) {
                                if ("gif".equalsIgnoreCase(com.tencent.mobileqq.filemanager.util.q.j(messageForTroopFile.fileName))) {
                                    string4 = context.getString(R.string.iml);
                                } else {
                                    string4 = "[" + com.tencent.mobileqq.filemanager.util.ah.p0(com.tencent.mobileqq.filemanager.util.ah.o0(messageForTroopFile.fileName)) + "]";
                                }
                            } else {
                                string4 = messageForTroopFile.getSummaryMsg();
                            }
                        }
                        a(str6, string4, null, n(appInterface, message), m((QQAppInterface) appInterface, message), msgSummary);
                    } else if (c.i(i37)) {
                        String[] analysisTransFileProtocolData = TransfileUtile.analysisTransFileProtocolData(message.f203106msg);
                        if (analysisTransFileProtocolData != null) {
                            msgSummary.strContent = k(analysisTransFileProtocolData, context, com.tencent.mobileqq.service.message.remote.a.c(message.issend), z17);
                        }
                        ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).addNicknameToVideoMsg(i3, str6, msgSummary);
                    } else {
                        if (c.g(message.msgtype)) {
                            String[] analysisTransFileProtocolData2 = TransfileUtile.analysisTransFileProtocolData(message.f203106msg);
                            if (analysisTransFileProtocolData2 != null) {
                                msgSummary.strContent = j((QQAppInterface) appInterface, analysisTransFileProtocolData2, context, message.frienduin, message.senderuin, i3);
                                return;
                            }
                            return;
                        }
                        if (c.e(message.msgtype)) {
                            boolean n3 = n(appInterface, message);
                            boolean m3 = m((QQAppInterface) appInterface, message);
                            String extInfoFromExtStr = message.getExtInfoFromExtStr("sticker_info");
                            if (EmojiStickerManager.f204583t && !TextUtils.isEmpty(extInfoFromExtStr)) {
                                String t18 = com.tencent.mobileqq.emosm.e.t(context, message);
                                if (message.senderuin.equals(appInterface.getCurrentAccountUin())) {
                                    t17 = HardCodeUtil.qqStr(R.string.f172206ob4) + t18;
                                } else {
                                    t17 = HardCodeUtil.qqStr(R.string.oaz) + t18;
                                }
                            } else {
                                t17 = com.tencent.mobileqq.emosm.e.t(context, message);
                            }
                            a(str6, t17, null, n3, m3, msgSummary);
                        } else if (c.f(message.msgtype)) {
                            boolean n16 = n(appInterface, message);
                            boolean m16 = m(appInterface, message);
                            String format = String.format("[%s]", HardCodeUtil.qqStr(R.string.f230186yg));
                            byte[] bArr = message.msgData;
                            if (bArr != null && bArr.length > 0) {
                                MessageForAniSticker messageForAniSticker = new MessageForAniSticker();
                                messageForAniSticker.deserializeMsgData(message.msgData);
                                format = messageForAniSticker.getSummaryMsg();
                            } else if (QLog.isColorLevel()) {
                                QLog.d(MessageForAniSticker.TAG, 2, "MsgUtils#buildMsgSummaryForMsg when msgData null");
                            }
                            QQText qQText = new QQText(format, 7, 16);
                            StringBuilder sb5 = new StringBuilder();
                            if (!TextUtils.isEmpty(str6)) {
                                sb5.append(str6);
                                sb5.append(MsgSummary.STR_COLON);
                            }
                            if (!TextUtils.isEmpty(msgSummary.prefixOfContent)) {
                                sb5.append(msgSummary.prefixOfContent);
                            }
                            if (!com.tencent.biz.anonymous.a.m(message)) {
                                if (n16) {
                                    sb5.append(MsgSummary.STR_FAILED);
                                } else if (m16) {
                                    sb5.append(MsgSummary.STR_SENDING);
                                }
                            }
                            QQText append = qQText.append(sb5.toString(), true, new int[0]);
                            msgSummary.mEmojiFlag = 1;
                            a(str6, append, null, n16, m16, msgSummary);
                        } else {
                            int i38 = message.msgtype;
                            if (i38 == -5009) {
                                if (message.msgData != null) {
                                    TroopGiftMsg.msg msgVar = new TroopGiftMsg.msg();
                                    try {
                                        msgVar.mergeFrom(message.msgData);
                                        if (!TextUtils.isEmpty(TroopGiftMsg.a(msgVar))) {
                                            msgSummary.strContent = TroopGiftMsg.a(msgVar);
                                        }
                                    } catch (InvalidProtocolBufferMicroException e19) {
                                        e19.printStackTrace();
                                    } catch (NullPointerException e26) {
                                        QLog.e("buildMsgSummaryForMsg", 1, "msgData.mergeFrom", e26);
                                    }
                                }
                            } else if (i38 == -2058) {
                                boolean n17 = n(appInterface, message);
                                boolean m17 = m((QQAppInterface) appInterface, message);
                                try {
                                    String extInfoFromExtStr2 = message.getExtInfoFromExtStr("Emoji_Sticker_Info");
                                    CharSequence charSequence3 = str7;
                                    if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                                        int optInt = new JSONObject(extInfoFromExtStr2).optInt(QQBrowserActivity.KEY_MSG_TYPE);
                                        byte[] bArr2 = message.msgData;
                                        if (bArr2 == null) {
                                            obj = ITransFileController.class;
                                            str4 = "sendingpic";
                                        } else {
                                            str4 = "sendingpic";
                                            if (optInt != -2007 || !(MessagePkgUtils.getObjectFromBytes(bArr2) instanceof MarkFaceMessage)) {
                                                obj = ITransFileController.class;
                                            } else {
                                                if (!EmojiStickerManager.f204583t) {
                                                    obj = ITransFileController.class;
                                                    t16 = com.tencent.mobileqq.emosm.e.t(context, message);
                                                } else {
                                                    String t19 = com.tencent.mobileqq.emosm.e.t(context, message);
                                                    obj = ITransFileController.class;
                                                    if (message.senderuin.equals(appInterface.getCurrentAccountUin())) {
                                                        t16 = HardCodeUtil.qqStr(R.string.oax) + t19;
                                                    } else {
                                                        t16 = HardCodeUtil.qqStr(R.string.ob8) + t19;
                                                    }
                                                }
                                                charSequence = t16;
                                                z56 = true;
                                                if (!z56) {
                                                    try {
                                                        if (EmojiStickerManager.f204583t) {
                                                            if (!TextUtils.isEmpty(message.getExtInfoFromExtStr("sticker_info"))) {
                                                                QQText o17 = EmojiStickerManager.o((QQAppInterface) appInterface, message, msgSummary);
                                                                try {
                                                                    StringBuilder sb6 = new StringBuilder();
                                                                    if (!TextUtils.isEmpty(str6)) {
                                                                        sb6.append(str6);
                                                                        sb6.append(MsgSummary.STR_COLON);
                                                                    }
                                                                    if (!TextUtils.isEmpty(msgSummary.prefixOfContent)) {
                                                                        sb6.append(msgSummary.prefixOfContent);
                                                                    }
                                                                    if (!com.tencent.biz.anonymous.a.m(message)) {
                                                                        if (n17) {
                                                                            sb6.append(MsgSummary.STR_FAILED);
                                                                        } else if (m17) {
                                                                            sb6.append(MsgSummary.STR_SENDING);
                                                                        }
                                                                    }
                                                                    charSequence3 = o17.append(sb6.toString(), true, new int[0]);
                                                                } catch (Exception e27) {
                                                                    e = e27;
                                                                    charSequence = o17;
                                                                    if (QLog.isColorLevel()) {
                                                                        QLog.e("MsgUtils", 2, "", e);
                                                                    }
                                                                    charSequence2 = charSequence;
                                                                    a(str6, charSequence2, null, n17, m17, msgSummary);
                                                                    h(context, appInterface, message, msgSummary);
                                                                }
                                                            }
                                                        } else {
                                                            if (optInt == -1000) {
                                                                QQText p16 = EmojiStickerManager.p(message);
                                                                if (p16 != null) {
                                                                    StringBuilder sb7 = new StringBuilder();
                                                                    if (!TextUtils.isEmpty(str6)) {
                                                                        sb7.append(str6);
                                                                        sb7.append(MsgSummary.STR_COLON);
                                                                    }
                                                                    if (!TextUtils.isEmpty(msgSummary.prefixOfContent)) {
                                                                        sb7.append(msgSummary.prefixOfContent);
                                                                    }
                                                                    if (!com.tencent.biz.anonymous.a.m(message)) {
                                                                        if (n17) {
                                                                            sb7.append(MsgSummary.STR_FAILED);
                                                                        } else if (m17) {
                                                                            sb7.append(MsgSummary.STR_SENDING);
                                                                        }
                                                                    }
                                                                    QQText append2 = p16.append(sb7.toString(), true, new int[0]);
                                                                    msgSummary.mEmojiFlag = 1;
                                                                    a(str6, append2, null, n17, m17, msgSummary);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            if (optInt == -2000) {
                                                                try {
                                                                    str5 = message.frienduin;
                                                                    if (com.tencent.imcore.message.ao.z(str5, message.istroop)) {
                                                                        str5 = message.senderuin;
                                                                    }
                                                                    messageForPic2 = (MessageForPic) ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(str5, message.istroop, message.uniseq);
                                                                } catch (Exception e28) {
                                                                    e = e28;
                                                                    iHttpCommunicatorListener3 = null;
                                                                }
                                                                if (messageForPic2 == null) {
                                                                    return;
                                                                }
                                                                iHttpCommunicatorListener3 = ((ITransFileController) appInterface.getRuntimeService(obj, "")).findProcessor(str5, message.uniseq);
                                                                try {
                                                                    if (!message.isSendFromLocal()) {
                                                                        if (iHttpCommunicatorListener3 instanceof BaseTransProcessor) {
                                                                            int fileStatus2 = (int) ((BaseTransProcessor) iHttpCommunicatorListener3).getFileStatus();
                                                                            if (fileStatus2 != 1005) {
                                                                            }
                                                                        }
                                                                    } else if (messageForPic2.size > 0) {
                                                                        z59 = messageForPic2.extraflag == 32768;
                                                                    }
                                                                    z57 = z59;
                                                                } catch (Exception e29) {
                                                                    e = e29;
                                                                    e.printStackTrace();
                                                                    z57 = false;
                                                                    if (iHttpCommunicatorListener3 instanceof BaseTransProcessor) {
                                                                    }
                                                                    String string5 = context.getString(i29);
                                                                    if (!com.tencent.mobileqq.app.ax.a(message)) {
                                                                    }
                                                                    string5 = context.getString(R.string.aeg);
                                                                    a(str6, string5, null, z57, z58, msgSummary);
                                                                    return;
                                                                }
                                                                if (iHttpCommunicatorListener3 instanceof BaseTransProcessor) {
                                                                    String str10 = str4;
                                                                    if (iHttpCommunicatorListener3 != null) {
                                                                        if (QLog.isColorLevel()) {
                                                                            QLog.d(str10, 2, "processor:" + iHttpCommunicatorListener3);
                                                                        }
                                                                        i29 = R.string.aek;
                                                                        z58 = true;
                                                                    } else {
                                                                        i29 = R.string.aek;
                                                                        z58 = false;
                                                                    }
                                                                } else {
                                                                    BaseTransProcessor baseTransProcessor2 = (BaseTransProcessor) iHttpCommunicatorListener3;
                                                                    boolean z67 = baseTransProcessor2.getFileStatus() != Constant.FROM_ID_START_ACTIVITY;
                                                                    if (QLog.isColorLevel()) {
                                                                        TransferRequest transferRequest2 = baseTransProcessor2.mUiRequest;
                                                                        QLog.d(str4, 2, "uniseq:" + (transferRequest2 != null ? transferRequest2.mUniseq : -1L) + ",key:" + baseTransProcessor2.getKey());
                                                                    }
                                                                    z58 = z67;
                                                                    i29 = R.string.aek;
                                                                }
                                                                String string52 = context.getString(i29);
                                                                if (!com.tencent.mobileqq.app.ax.a(message) || ((IPicFlash) QRoute.api(IPicFlash.class)).isFlashPicMsg(message)) {
                                                                    string52 = context.getString(R.string.aeg);
                                                                }
                                                                a(str6, string52, null, z57, z58, msgSummary);
                                                                return;
                                                            }
                                                        }
                                                    } catch (Exception e36) {
                                                        e = e36;
                                                    }
                                                }
                                                charSequence3 = charSequence;
                                            }
                                        }
                                        charSequence = "";
                                        z56 = false;
                                        if (!z56) {
                                        }
                                        charSequence3 = charSequence;
                                    }
                                    charSequence2 = charSequence3;
                                } catch (Exception e37) {
                                    e = e37;
                                    charSequence = "";
                                }
                                a(str6, charSequence2, null, n17, m17, msgSummary);
                            } else if (i38 == -2039) {
                                a(str6, ((IApolloUtil) QRoute.api(IApolloUtil.class)).getApolloMessageDesc(message), null, n(appInterface, message), m((QQAppInterface) appInterface, message), msgSummary);
                            } else if (i38 == -1013 || i38 == -1047) {
                                a(null, null, MessageForGrayTips.getOrginMsg(message.f203106msg), false, false, msgSummary);
                            } else if (i38 == -2042 || i38 == -2043) {
                                a(null, MessageForGrayTips.getOrginMsg(message.f203106msg), null, false, false, msgSummary);
                            } else if (i38 == -2051) {
                                MessageRecord queryMsgItemByUniseq3 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                if (queryMsgItemByUniseq3 != null && (queryMsgItemByUniseq3 instanceof MessageForQQStory)) {
                                    MessageForQQStory messageForQQStory = (MessageForQQStory) queryMsgItemByUniseq3;
                                    messageForQQStory.parse();
                                    a(str6, null, messageForQQStory.getSummaryMsg(), n(appInterface, message), m((QQAppInterface) appInterface, message), msgSummary);
                                } else {
                                    String str11 = bt.class.getSimpleName() + LogTag.TAG_QQSTORY_MSG;
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append("!messageRecord instanceof MessageForQQStory, msg.uniseq");
                                    sb8.append(message.uniseq);
                                    sb8.append(", messageRecord msgType:");
                                    String str12 = str7;
                                    if (queryMsgItemByUniseq3 != null) {
                                        str12 = queryMsgItemByUniseq3.toString();
                                    }
                                    sb8.append(str12);
                                    QLog.e(str11, 1, sb8.toString());
                                }
                            } else if (i38 == -7002) {
                                MessageForTribeShortVideo messageForTribeShortVideo = (MessageForTribeShortVideo) ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                if (messageForTribeShortVideo != null) {
                                    messageForTribeShortVideo.parse();
                                    a(str6, null, messageForTribeShortVideo.getSummaryMsg(), n(appInterface, message), m((QQAppInterface) appInterface, message), msgSummary);
                                } else {
                                    QLog.e(bt.class.getSimpleName() + LogTag.TAG_QQSTORY_MSG, 1, "!messageRecord instanceof MessageForTribeShortVideo, msg.uniseq" + message.uniseq + ", messageRecord msgType:" + message.toString());
                                }
                            } else if (i38 == -2054) {
                                MessageRecord queryMsgItemByUniseq4 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                if (queryMsgItemByUniseq4 instanceof MessageForTroopSign) {
                                    MessageForTroopSign messageForTroopSign = (MessageForTroopSign) queryMsgItemByUniseq4;
                                    HardCodeUtil.qqStr(R.string.ob_);
                                    messageForTroopSign.parse();
                                    a(str6, null, messageForTroopSign.getSummaryMsg(), n(appInterface, message), m((QQAppInterface) appInterface, message), msgSummary);
                                } else {
                                    String str13 = bt.class.getSimpleName() + LogTag.TAG_TROOP_SIGN_IN;
                                    StringBuilder sb9 = new StringBuilder();
                                    sb9.append("!messageRecord instanceof MessageForTroopSign, msg.uniseq");
                                    sb9.append(message.uniseq);
                                    sb9.append(", messageRecord msgType:");
                                    Object obj2 = str7;
                                    if (queryMsgItemByUniseq4 != null) {
                                        obj2 = Integer.valueOf(queryMsgItemByUniseq4.msgtype);
                                    }
                                    sb9.append(obj2);
                                    QLog.e(str13, 1, sb9.toString());
                                }
                            } else if (i38 == -2035) {
                                a(null, MessageForGrayTips.getOrginMsg(message.f203106msg), null, false, false, msgSummary);
                            } else if (i38 == -2038) {
                                String str14 = message.frienduin;
                                String str15 = AppConstants.LBS_SAY_HELLO_LIST_UIN;
                                if (str15.equals(str14)) {
                                    str14 = message.senderuin;
                                }
                                if (AppConstants.LBS_HELLO_UIN.equals(str14)) {
                                    if (str15.equals(message.senderuin)) {
                                        MessageForTroopGift messageForTroopGift = (MessageForTroopGift) ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(str15, message.istroop, message.uniseq);
                                        if (messageForTroopGift != null) {
                                            messageForTroopGift.parse();
                                            str14 = messageForTroopGift.senderuin;
                                        }
                                    } else {
                                        str14 = message.senderuin;
                                    }
                                }
                                MessageRecord queryMsgItemByUniseq5 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(str14, message.istroop, message.uniseq);
                                if (queryMsgItemByUniseq5 instanceof MessageForTroopGift) {
                                    MessageForTroopGift messageForTroopGift2 = (MessageForTroopGift) queryMsgItemByUniseq5;
                                    messageForTroopGift2.parse();
                                    String str16 = messageForTroopGift2.f203106msg;
                                    a(null, str16 != null ? str16 : "", null, false, false, msgSummary);
                                } else if (queryMsgItemByUniseq5 != null && QLog.isColorLevel()) {
                                    QLog.e("MsgUtils", 2, "msgType is not MSG_TYPE_TROOP_DELIVER_GIFT_OBJ:" + queryMsgItemByUniseq5.toString());
                                }
                            } else if (i38 == -2036) {
                                MessageForTroopFee messageForTroopFee = (MessageForTroopFee) ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                if (messageForTroopFee != null) {
                                    messageForTroopFee.parse();
                                    a(null, messageForTroopFee.f203106msg, null, false, false, msgSummary);
                                }
                            } else if (i38 == -2069) {
                                MessageForStarLeague messageForStarLeague = (MessageForStarLeague) ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                if (messageForStarLeague != null) {
                                    messageForStarLeague.parse();
                                    a(null, messageForStarLeague.f203106msg, null, false, false, msgSummary);
                                }
                            } else if (i38 == -2048) {
                                MessageForTroopReward messageForTroopReward = (MessageForTroopReward) ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                if (messageForTroopReward != null) {
                                    messageForTroopReward.parse();
                                    a(str6, messageForTroopReward.f203106msg, null, false, false, msgSummary);
                                }
                            } else {
                                int i39 = message.istroop;
                                if (i39 == 1 && i38 == -3006) {
                                    MessageForPubAccount messageForPubAccount = (MessageForPubAccount) ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                    if (messageForPubAccount != null) {
                                        messageForPubAccount.parse();
                                        String msgSummary2 = MessageForPubAccount.getMsgSummary((QQAppInterface) appInterface, messageForPubAccount, false);
                                        String string6 = !messageForPubAccount.isTextMsg() ? null : appInterface.getApp().getString(R.string.etf);
                                        if (TextUtils.isEmpty(message.prefixOfNickname) || TextUtils.isEmpty(string6)) {
                                            str3 = string6;
                                        } else {
                                            str3 = ((Object) message.prefixOfNickname) + string6;
                                        }
                                        a(str3, msgSummary2, null, false, false, msgSummary);
                                    }
                                } else if (i38 == -1034) {
                                    MessageForRichState messageForRichState = new MessageForRichState();
                                    messageForRichState.f203106msg = message.f203106msg;
                                    messageForRichState.parse();
                                    StringBuilder sb10 = new StringBuilder();
                                    if (!TextUtils.isEmpty(messageForRichState.actionText)) {
                                        sb10.append(messageForRichState.actionText);
                                        if (!TextUtils.isEmpty(messageForRichState.dataText)) {
                                            sb10.append(messageForRichState.dataText);
                                        }
                                        sb10.append(TokenParser.SP);
                                    }
                                    sb10.append(messageForRichState.getPlainMsg());
                                    if (sb10.length() > 0) {
                                        a(null, sb10.toString(), null, false, false, msgSummary);
                                    }
                                } else if (i38 == -2074) {
                                    MessageForAIOStoryVideo messageForAIOStoryVideo = new MessageForAIOStoryVideo();
                                    messageForAIOStoryVideo.f203106msg = message.f203106msg;
                                    messageForAIOStoryVideo.parse();
                                    if (!TextUtils.isEmpty(messageForAIOStoryVideo.text)) {
                                        a(null, messageForAIOStoryVideo.text, null, false, false, msgSummary);
                                    }
                                } else if (i38 == -1019) {
                                    a(null, null, HardCodeUtil.qqStr(R.string.f172204ob0) + message.f203106msg + HardCodeUtil.qqStr(R.string.ob9), false, false, msgSummary);
                                } else if (i38 == -1018) {
                                    a(null, null, HardCodeUtil.qqStr(R.string.ob5) + message.f203106msg + HardCodeUtil.qqStr(R.string.obb), false, false, msgSummary);
                                } else if (i38 == -2019) {
                                    msgSummary.strContent = context.getString(R.string.hnd);
                                } else if (i38 == -7006) {
                                    msgSummary.strContent = context.getString(R.string.hnb);
                                } else if (i38 == -1026) {
                                    msgSummary.strContent = context.getString(R.string.f173241ia3);
                                } else if (i38 == -1027) {
                                    msgSummary.strContent = context.getString(R.string.f173239ia1);
                                } else if (i38 == -4028) {
                                    msgSummary.strContent = context.getString(R.string.f158481pq);
                                } else if (i38 == -4029) {
                                    msgSummary.strContent = context.getString(R.string.f158561py);
                                } else if (i38 == -4030) {
                                    msgSummary.strContent = context.getString(R.string.f158581q0);
                                } else if (i38 == -2005) {
                                    QQAppInterface qQAppInterface2 = (QQAppInterface) appInterface;
                                    String updateRecentListTxt = FileManagerUtil.updateRecentListTxt(qQAppInterface2, message);
                                    a(str6, context.getString(R.string.aef), null, n(appInterface, message), m(qQAppInterface2, message), msgSummary);
                                    if (updateRecentListTxt != null) {
                                        msgSummary.strContent = updateRecentListTxt;
                                    }
                                    msgSummary.nState = 0;
                                } else if (i38 == -3017) {
                                    MessageRecord queryMsgItemByUniseq6 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                    String str17 = str7;
                                    if (queryMsgItemByUniseq6 != null) {
                                        str17 = str7;
                                        if (queryMsgItemByUniseq6 instanceof MessageForDLFile) {
                                            MessageForDLFile messageForDLFile = (MessageForDLFile) queryMsgItemByUniseq6;
                                            str17 = "[" + FileManagerUtil.getFileType(FileManagerUtil.getFileType(messageForDLFile.fileName)) + "]" + messageForDLFile.fileName;
                                        }
                                    }
                                    a(str6, context.getString(R.string.aef), null, n(appInterface, message), m(appInterface, message), msgSummary);
                                    if (str17 != null) {
                                        msgSummary.strContent = str17;
                                    }
                                    msgSummary.nState = 0;
                                } else if (i38 == -2022 || i38 == -2071 || i38 == -2079) {
                                    MessageRecord queryMsgItemByUniseq7 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                    if (queryMsgItemByUniseq7 instanceof MessageForShortVideo) {
                                        if (QLog.isColorLevel()) {
                                            QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO _FAIL msg.uniseq=" + message.uniseq);
                                        }
                                        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) queryMsgItemByUniseq7;
                                        int i46 = messageForShortVideo.videoFileStatus;
                                        if (i46 == 1005 || message.extraflag == 32768 || (((i27 = messageForShortVideo.busiType) == 0 && i46 == 1004) || (i27 == 1 && i46 == 1004))) {
                                            if (QLog.isColorLevel()) {
                                                QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO STATUS_SEND_ERROR or EXTRA_FLAG_SEND_FAIL set failed=true");
                                            }
                                            z37 = true;
                                        } else {
                                            z37 = false;
                                        }
                                        try {
                                            String str18 = message.frienduin;
                                            if (com.tencent.imcore.message.ao.z(str18, message.istroop)) {
                                                str18 = message.senderuin;
                                            }
                                            iHttpCommunicatorListener2 = ((ITransFileController) appInterface.getRuntimeService(ITransFileController.class, "")).findProcessor(str18, message.uniseq);
                                            try {
                                                String str19 = messageForShortVideo.md5;
                                                if (str19 != null && !"".equals(str19) && message.isSendFromLocal() && iHttpCommunicatorListener2 == null && (i26 = messageForShortVideo.videoFileStatus) != 1003 && i26 != 1004 && i26 != 2003 && i26 != 2009 && i26 != 2002 && messageForShortVideo.isAllowAutoDown) {
                                                    if (QLog.isColorLevel()) {
                                                        QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO processor=null && NOT FINISHED set failed=true");
                                                    }
                                                    z37 = true;
                                                }
                                            } catch (Exception e38) {
                                                e = e38;
                                                e.printStackTrace();
                                                boolean z68 = z37;
                                                if (message.isSendFromLocal()) {
                                                }
                                                i18 = 2;
                                                z38 = false;
                                                if (messageForShortVideo.busiType != i18) {
                                                }
                                                String str20 = string2;
                                                if (QLog.isColorLevel()) {
                                                }
                                                a(str6, str20, null, z68, z38, msgSummary);
                                                h(context, appInterface, message, msgSummary);
                                            }
                                        } catch (Exception e39) {
                                            e = e39;
                                            iHttpCommunicatorListener2 = null;
                                        }
                                        boolean z682 = z37;
                                        if (message.isSendFromLocal() || !((i19 = messageForShortVideo.videoFileStatus) == 1001 || i19 == 1002 || i19 == 998 || i19 == 999 || i19 == 1000)) {
                                            i18 = 2;
                                            z38 = false;
                                        } else {
                                            if (QLog.isColorLevel()) {
                                                i18 = 2;
                                                QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO set sending=true");
                                            } else {
                                                i18 = 2;
                                            }
                                            z38 = true;
                                        }
                                        if (messageForShortVideo.busiType != i18) {
                                            string2 = context.getString(R.string.aen);
                                        } else if (message.msgtype == -2079) {
                                            string2 = context.getString(R.string.f209505fl);
                                        } else {
                                            string2 = context.getString(R.string.aem);
                                        }
                                        String str202 = string2;
                                        if (QLog.isColorLevel()) {
                                            QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO md5=" + messageForShortVideo.md5 + ", shortVideo.videoFileStatus=" + messageForShortVideo.videoFileStatus);
                                            if (iHttpCommunicatorListener2 == null) {
                                                QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO processor=null");
                                            } else {
                                                QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO processor!=null");
                                            }
                                            QLog.i("Q.recent", 2, "MSG_TYPE_MEDIA_SHORTVIDEO failed=" + z682 + ", sending=" + z38);
                                        }
                                        a(str6, str202, null, z682, z38, msgSummary);
                                    }
                                } else if (i38 == -5002) {
                                    MessageForIncompatibleGrayTips messageForIncompatibleGrayTips = new MessageForIncompatibleGrayTips();
                                    messageForIncompatibleGrayTips.msgData = message.msgData;
                                    messageForIncompatibleGrayTips.parse();
                                    String str21 = messageForIncompatibleGrayTips.f203106msg;
                                    if (str21 != null) {
                                        msgSummary.strContent = str21;
                                    }
                                } else if (i38 == -2029) {
                                    MessageRecord queryMsgItemByUniseq8 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                                    if (QLog.isColorLevel()) {
                                        QLog.i("Q.recent", 2, "MsgUtils.buildMsgSummaryForMsg MSG_TYPE_QQWALLET_TIPS mr=" + queryMsgItemByUniseq8);
                                    }
                                    if (queryMsgItemByUniseq8 instanceof MessageForQQWalletTips) {
                                        MessageForQQWalletTips messageForQQWalletTips = (MessageForQQWalletTips) queryMsgItemByUniseq8;
                                        messageForQQWalletTips.msgData = message.msgData;
                                        messageForQQWalletTips.parse();
                                        messageForQQWalletTips.buildQQWalletTips((QQAppInterface) appInterface, appInterface.getApp(), null);
                                        if (messageForQQWalletTips.summary != null) {
                                            if (messageForQQWalletTips.type == 1) {
                                                messageForQQWalletTips.summary = HardCodeUtil.qqStr(R.string.f172205ob2) + messageForQQWalletTips.summary;
                                            }
                                            msgSummary.strContent = messageForQQWalletTips.summary;
                                        }
                                    }
                                } else if (i38 == -2025 || i38 == -2072) {
                                    msgSummary.strContent = message.f203106msg;
                                } else if (i38 == -2076) {
                                    MessageForLocationShare messageForLocationShare = new MessageForLocationShare();
                                    messageForLocationShare.msgData = message.msgData;
                                    messageForLocationShare.parse();
                                    String str22 = messageForLocationShare.f203106msg;
                                    if (TextUtils.isEmpty(str22)) {
                                        str22 = context.getString(R.string.vs7);
                                    }
                                    a(str6, "", str22, false, false, msgSummary);
                                } else if (i38 == -2047) {
                                    MessageForVIPDonate messageForVIPDonate = new MessageForVIPDonate();
                                    messageForVIPDonate.msgData = message.msgData;
                                    messageForVIPDonate.parse();
                                    String summaryMsg = messageForVIPDonate.getSummaryMsg();
                                    if (!TextUtils.isEmpty(summaryMsg)) {
                                        msgSummary.strContent = summaryMsg;
                                    } else {
                                        msgSummary.strContent = MessageForVIPDonate.DEFAULT_SUMMARYMSG;
                                    }
                                } else if (i38 == -2040) {
                                    MessageForApproval messageForApproval = new MessageForApproval();
                                    messageForApproval.msgData = message.msgData;
                                    msgSummary.strContent = messageForApproval.getFullTitle();
                                } else if (i38 == -2041) {
                                    msgSummary.strContent = context.getString(R.string.f170422q2) + " " + context.getString(R.string.f170421pz);
                                } else if (i38 == -7001) {
                                    try {
                                        String str23 = message.frienduin;
                                        if (com.tencent.imcore.message.ao.z(str23, i39)) {
                                            str23 = message.senderuin;
                                        }
                                        messageForScribble = (MessageForScribble) ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(str23, message.istroop, message.uniseq);
                                    } catch (Exception e46) {
                                        e46.printStackTrace();
                                        z39 = false;
                                        z46 = false;
                                    }
                                    if (messageForScribble.isSendFromLocal()) {
                                        int i47 = messageForScribble.fileUploadStatus;
                                        if (i47 != 2) {
                                            if (i47 == 3) {
                                                z47 = false;
                                                z48 = true;
                                                z39 = z47;
                                                z46 = z48;
                                                a(str6, context.getString(R.string.cdl), null, z39, z46, msgSummary);
                                            }
                                            z47 = false;
                                        }
                                        z47 = true;
                                    } else {
                                        if (messageForScribble.fileDownloadStatus == 2) {
                                        }
                                        z47 = false;
                                    }
                                    z48 = false;
                                    z39 = z47;
                                    z46 = z48;
                                    a(str6, context.getString(R.string.cdl), null, z39, z46, msgSummary);
                                } else {
                                    QQAppInterface qQAppInterface3 = (QQAppInterface) appInterface;
                                    if (com.tencent.mobileqq.mutualmark.oldlogic.c.c(qQAppInterface3, message)) {
                                        a(str6, message.getMessageText(), null, false, false, msgSummary);
                                    } else {
                                        String str24 = message.f203106msg;
                                        if (str24 == null) {
                                            msgSummary.strContent = "";
                                        } else {
                                            int i48 = message.msgtype;
                                            if (i48 == -5003) {
                                                msgSummary.strContent = message.getMessageText();
                                            } else if (i48 == -7090) {
                                                msgSummary.strContent = message.getMessageText();
                                            } else if (i48 == -2033) {
                                                a(null, HardCodeUtil.qqStr(R.string.tea), null, false, false, msgSummary);
                                            } else if (i48 == -2049) {
                                                msgSummary.strContent = MessageForGrayTips.getOrginMsg(str24);
                                            } else if (i48 == -1035) {
                                                if (message.isSendFromLocal()) {
                                                    int i49 = message.extraflag;
                                                    if (i49 != 32772) {
                                                        z49 = i49 == 32768;
                                                    } else if (((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).t1(message)) {
                                                        z49 = false;
                                                        z55 = true;
                                                        messageText = message.getMessageText();
                                                        iTroopRobotService = (ITroopRobotService) appInterface.getRuntimeService(ITroopRobotService.class, "all");
                                                        if (iTroopRobotService.hasRobotNewsClassId(message)) {
                                                            if (!iTroopRobotService.hasProcessedMoreDetail(message)) {
                                                                iTroopRobotService.preProcessMessageMoreDetail(message);
                                                            }
                                                            String generateMoreDetailMsg = iTroopRobotService.generateMoreDetailMsg(message);
                                                            if (!TextUtils.isEmpty(generateMoreDetailMsg)) {
                                                                messageText = generateMoreDetailMsg;
                                                            }
                                                        }
                                                        if (message.emoRecentMsg == null && messageText != null) {
                                                            StringBuilder sb11 = new StringBuilder();
                                                            if (!TextUtils.isEmpty(str6)) {
                                                                sb11.append(str6);
                                                                sb11.append(MsgSummary.STR_COLON);
                                                            }
                                                            if (!TextUtils.isEmpty(msgSummary.prefixOfContent)) {
                                                                sb11.append(msgSummary.prefixOfContent);
                                                            }
                                                            if (!com.tencent.biz.anonymous.a.m(message)) {
                                                                if (z49) {
                                                                    sb11.append(MsgSummary.STR_FAILED);
                                                                } else if (z55) {
                                                                    sb11.append(MsgSummary.STR_SENDING);
                                                                }
                                                            }
                                                            if (messageText instanceof QQText) {
                                                                spannableString2 = ((QQText) messageText).append(sb11.toString(), true, new int[0]);
                                                                msgSummary.mEmojiFlag = 1;
                                                            } else {
                                                                sb11.append(messageText);
                                                                spannableString2 = new SpannableString(sb11.toString());
                                                                msgSummary.mEmojiFlag = 0;
                                                            }
                                                            a(str6, spannableString2, null, z49, z55, msgSummary);
                                                        } else {
                                                            a(str6, String.valueOf(messageText), null, z49, z55, msgSummary);
                                                        }
                                                    } else {
                                                        z49 = true;
                                                    }
                                                } else {
                                                    z49 = false;
                                                }
                                                z55 = false;
                                                messageText = message.getMessageText();
                                                iTroopRobotService = (ITroopRobotService) appInterface.getRuntimeService(ITroopRobotService.class, "all");
                                                if (iTroopRobotService.hasRobotNewsClassId(message)) {
                                                }
                                                if (message.emoRecentMsg == null) {
                                                }
                                                a(str6, String.valueOf(messageText), null, z49, z55, msgSummary);
                                            } else if (i48 == -2057) {
                                                a(str6, MessageForTroopStory.MSG_CONTENT, null, false, false, msgSummary);
                                            } else if (i48 == -1012) {
                                                CharSequence messageText2 = message.getMessageText();
                                                if (!TextUtils.isEmpty(messageText2)) {
                                                    String orginMsg = MessageForGrayTips.getOrginMsg(messageText2.toString());
                                                    int length = orginMsg.length() - 1;
                                                    if (length > 0) {
                                                        orginMsg = orginMsg.substring(0, length);
                                                    }
                                                    a(null, orginMsg, null, false, false, msgSummary);
                                                }
                                            } else if (i48 == -2059) {
                                                MessageForTroopPobing messageForTroopPobing = new MessageForTroopPobing();
                                                messageForTroopPobing.msgData = message.msgData;
                                                messageForTroopPobing.doParse();
                                                msgSummary.strContent = messageForTroopPobing.getSummaryMsg();
                                            } else if (i48 == -2066) {
                                                MessageForConfessCard messageForConfessCard = new MessageForConfessCard();
                                                messageForConfessCard.f203106msg = message.f203106msg;
                                                messageForConfessCard.doParse();
                                                if (message.istroop == 1032) {
                                                    a(str6, messageForConfessCard.strConfessorDesc, null, false, false, msgSummary);
                                                } else {
                                                    a("", str6 + "," + messageForConfessCard.strConfessorDesc, null, false, false, msgSummary);
                                                }
                                            } else if (i48 == -2067) {
                                                MessageForTroopConfess messageForTroopConfess = new MessageForTroopConfess();
                                                messageForTroopConfess.msgData = message.msgData;
                                                messageForTroopConfess.doParse();
                                                a(str6, messageForTroopConfess.f203106msg, null, false, false, msgSummary);
                                            } else if (i48 != -5008 && i48 != -5016 && i48 != -5017) {
                                                boolean n18 = n(appInterface, message);
                                                boolean m18 = m(appInterface, message);
                                                int i56 = message.fileType;
                                                if (i56 == 1) {
                                                    int i57 = message.istroop;
                                                    if ((i57 == 1001 || i57 == 10002) && message.msgtype == -3001) {
                                                        msgSummary.strContent = context.getString(R.string.cqu);
                                                    } else {
                                                        a(str6, context.getString(R.string.aek), null, n18, m18, msgSummary);
                                                    }
                                                } else if (i56 == 2 || i56 == 8) {
                                                    com.tencent.mobileqq.dating.f.j("buildMsgSummaryForMsg", Integer.valueOf(i3), Boolean.valueOf(n18), Boolean.valueOf(m18));
                                                    String string7 = context.getString(R.string.ael);
                                                    if (Utils.p(message.senderuin, appInterface.getCurrentAccountUin()) && i3 != 0) {
                                                        a(str6, string7, "", n18, m18, msgSummary);
                                                    } else {
                                                        a(str6, string7, "", false, false, msgSummary);
                                                    }
                                                } else if (i56 == 65536) {
                                                    a(str6, "", message.f203106msg, n18, m18, msgSummary);
                                                } else if (i56 != 65538) {
                                                    String extInfoFromExtStr3 = message.getExtInfoFromExtStr("sticker_info");
                                                    if (EmojiStickerManager.f204583t && !TextUtils.isEmpty(extInfoFromExtStr3)) {
                                                        QQText o18 = EmojiStickerManager.o(qQAppInterface3, message, msgSummary);
                                                        StringBuilder sb12 = new StringBuilder();
                                                        if (!TextUtils.isEmpty(str6)) {
                                                            sb12.append(str6);
                                                            sb12.append(MsgSummary.STR_COLON);
                                                        }
                                                        if (!TextUtils.isEmpty(msgSummary.prefixOfContent)) {
                                                            sb12.append(msgSummary.prefixOfContent);
                                                        }
                                                        if (!com.tencent.biz.anonymous.a.m(message)) {
                                                            if (n18) {
                                                                sb12.append(MsgSummary.STR_FAILED);
                                                            } else if (m18) {
                                                                sb12.append(MsgSummary.STR_SENDING);
                                                            }
                                                        }
                                                        a(str6, o18.append(sb12.toString(), true, new int[0]), null, n18, m18, msgSummary);
                                                        return;
                                                    }
                                                    CharSequence messageText3 = message.getMessageText();
                                                    ITroopRobotService iTroopRobotService2 = (ITroopRobotService) appInterface.getRuntimeService(ITroopRobotService.class, "all");
                                                    if (iTroopRobotService2.hasRobotNewsClassId(message)) {
                                                        if (!iTroopRobotService2.hasProcessedMoreDetail(message)) {
                                                            iTroopRobotService2.preProcessMessageMoreDetail(message);
                                                        }
                                                        String generateMoreDetailMsg2 = iTroopRobotService2.generateMoreDetailMsg(message);
                                                        if (!TextUtils.isEmpty(generateMoreDetailMsg2)) {
                                                            messageText3 = generateMoreDetailMsg2;
                                                        }
                                                    }
                                                    if (message.emoRecentMsg != null && messageText3 != null) {
                                                        StringBuilder sb13 = new StringBuilder();
                                                        if (!TextUtils.isEmpty(str6)) {
                                                            sb13.append(str6);
                                                            sb13.append(MsgSummary.STR_COLON);
                                                        }
                                                        if (!TextUtils.isEmpty(msgSummary.prefixOfContent)) {
                                                            sb13.append(msgSummary.prefixOfContent);
                                                        }
                                                        if (!com.tencent.biz.anonymous.a.m(message)) {
                                                            if (n18) {
                                                                sb13.append(MsgSummary.STR_FAILED);
                                                            } else if (m18) {
                                                                sb13.append(MsgSummary.STR_SENDING);
                                                            }
                                                        }
                                                        if (messageText3 instanceof QQText) {
                                                            spannableString = ((QQText) messageText3).append(sb13.toString(), true, 0, 16, 1);
                                                            msgSummary.mEmojiFlag = 1;
                                                        } else {
                                                            sb13.append(messageText3);
                                                            spannableString = new SpannableString(sb13.toString());
                                                            msgSummary.mEmojiFlag = 0;
                                                        }
                                                        if (message.msgtype == -5040) {
                                                            String str25 = " " + BaseApplicationImpl.getApplication().getString(R.string.cdi);
                                                            String charSequence4 = spannableString.toString();
                                                            if (charSequence4 != null && charSequence4.contains(str25)) {
                                                                spannableString = charSequence4.replace(str25, "");
                                                            }
                                                            i28 = i3;
                                                            if (i28 == 0) {
                                                                MessageRecord lastMsgForMsgTab2 = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab(message.frienduin, 0);
                                                                if ((lastMsgForMsgTab2 instanceof MessageForUniteGrayTip) && (gVar2 = ((MessageForUniteGrayTip) lastMsgForMsgTab2).tipParam) != null && com.tencent.mobileqq.mutualmark.g.m(gVar2.f213685h)) {
                                                                    spannableString = com.tencent.mobileqq.mutualmark.oldlogic.c.k(appInterface.getApp(), spannableString.toString());
                                                                }
                                                            }
                                                        } else {
                                                            i28 = i3;
                                                        }
                                                        if (com.tencent.imcore.message.ad.M(message.msgtype) && (lastMsgForMsgTab = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab(message.frienduin, i28)) != null && (lastMsgForMsgTab instanceof MessageForUniteGrayTip) && (gVar = (messageForUniteGrayTip = (MessageForUniteGrayTip) lastMsgForMsgTab).tipParam) != null && gVar.f213685h == 655397) {
                                                            spannableString = messageForUniteGrayTip.getSummaryMsg();
                                                        }
                                                        a(str6, spannableString, null, n18, m18, msgSummary);
                                                    } else {
                                                        String trim = messageText3 != null ? messageText3.toString().trim() : null;
                                                        a(str6, null, (!AppConstants.SYSTEM_MSG_UIN.equalsIgnoreCase(message.frienduin) || trim == null || trim.length() <= 0) ? trim : d(context, (QQAppInterface) appInterface, trim, message), n18, ((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).t1(message), msgSummary);
                                                        if (message.msgtype == -1000 && msgSummary.strContent != null) {
                                                            msgSummary.strContent = new QQText(msgSummary.strContent, 1, 16);
                                                            msgSummary.mEmojiFlag = 1;
                                                        } else {
                                                            msgSummary.mEmojiFlag = 0;
                                                        }
                                                    }
                                                } else {
                                                    a(str6, context.getString(R.string.aek), null, false, false, msgSummary);
                                                }
                                            } else {
                                                if (i48 == -5016) {
                                                    MessageForArkBabyqReply messageForArkBabyqReply = new MessageForArkBabyqReply();
                                                    messageForArkBabyqReply.msgData = message.msgData;
                                                    messageForArkBabyqReply.doParse();
                                                    msgSummary.strContent = messageForArkBabyqReply.getSummery();
                                                } else {
                                                    MessageForArkApp messageForArkApp = new MessageForArkApp();
                                                    messageForArkApp.msgData = message.msgData;
                                                    messageForArkApp.doParse();
                                                    msgSummary.strContent = messageForArkApp.getSummery();
                                                }
                                                a(str6, msgSummary.strContent, null, n(appInterface, message), m(appInterface, message), msgSummary);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                msgSummary.strContent = "";
            }
        }
        h(context, appInterface, message, msgSummary);
    }

    public static void c(Context context, BaseQQAppInterface baseQQAppInterface, Message message, int i3, MsgSummary msgSummary, boolean z16, boolean z17) {
        String str;
        QQAppInterface qQAppInterface = (QQAppInterface) baseQQAppInterface;
        p(message, qQAppInterface, i3);
        if (message != null) {
            str = message.nickName;
        } else {
            str = null;
        }
        b(context, qQAppInterface, message, i3, msgSummary, str, z16, z17);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String d(Context context, QQAppInterface qQAppInterface, String str, Message message) {
        String g16;
        String g17;
        String string;
        if (SystemMsg.isSystemMessage(message.msgtype)) {
            int i3 = message.msgtype;
            switch (i3) {
                case -1011:
                case -1006:
                    string = context.getString(R.string.f170058eb);
                    break;
                case -1010:
                    string = context.getString(R.string.f170082fd);
                    break;
                case -1009:
                    string = context.getString(R.string.h0f);
                    break;
                case -1008:
                    string = context.getString(R.string.f169981b3);
                    break;
                case -1007:
                    string = context.getString(R.string.f169982b4);
                    break;
                default:
                    switch (i3) {
                        case 187:
                            break;
                        case 188:
                            break;
                        case 189:
                            break;
                        case 190:
                            break;
                        case 191:
                            break;
                        default:
                            string = null;
                            break;
                    }
            }
            String e16 = com.tencent.mobileqq.util.cw.e(str);
            if (e16 != null && !"".equals(e16.trim()) && str.indexOf(e16) == 1) {
                String g18 = ac.g(qQAppInterface, message.senderuin, true);
                if (g18 != null && g18.trim().length() > 0 && !g18.equals(message.senderuin)) {
                    return g18 + string;
                }
                return message.senderuin + string;
            }
            return str;
        }
        if (SystemMsg.isTroopSystemMessage(message.msgtype)) {
            int i16 = message.msgtype;
            if (i16 != -1020 && i16 != 84 && i16 != 35 && i16 != -1023 && i16 != 87 && i16 != 46) {
                if (i16 == -1021 || i16 == -1022) {
                    String b16 = com.tencent.mobileqq.util.cw.b(str, qQAppInterface);
                    String c16 = com.tencent.mobileqq.util.cw.c(b16);
                    if (c16 != null && !"".equals(c16.trim()) && b16.indexOf(c16) == 1 && (g17 = ac.g(qQAppInterface, c16, true)) != "" && !g17.equals("")) {
                        b16 = com.tencent.mobileqq.util.cw.a(b16, c16, g17);
                    }
                    return b16;
                }
                return str;
            }
            String c17 = com.tencent.mobileqq.util.cw.c(str);
            if (c17 != null && !"".equals(c17.trim()) && str.indexOf(c17) == 1 && (g16 = ac.g(qQAppInterface, c17, true)) != "" && !g16.equals("")) {
                return com.tencent.mobileqq.util.cw.a(str, c17, g16);
            }
            return str;
        }
        return str;
    }

    private static String e(Context context, QQAppInterface qQAppInterface, Message message) {
        String str;
        String str2 = message.actMsgContentValue;
        if (str2 != null && !"".endsWith(str2)) {
            return message.actMsgContentValue;
        }
        AppShareID U2 = qQAppInterface.getMsgHandler().U2(h.g(message.shareAppID));
        if (U2 != null && (str = U2.messagetail) != null && !"".equals(str)) {
            return qQAppInterface.getApp().getString(R.string.f170387pe) + U2.messagetail + qQAppInterface.getApp().getString(R.string.f170388pf);
        }
        return qQAppInterface.getApp().getString(R.string.f170385pc);
    }

    public static boolean f(Context context, AppInterface appInterface, Message message, int i3, MsgSummary msgSummary, String str, boolean z16, boolean z17) {
        return false;
    }

    private static int g(QQAppInterface qQAppInterface, Message message) {
        if (message == null) {
            return 0;
        }
        int e16 = qQAppInterface.getFileManagerRSCenter().e(message.uniseq, message.frienduin, message.istroop, -1L);
        if (e16 != -1) {
            return e16;
        }
        FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(message.uniseq, message.frienduin, message.istroop);
        if (E != null) {
            if (E.fProgress == 1.0d) {
                return 1;
            }
            if (E.status == 0 && !E.isSend()) {
                return 1;
            }
            int i3 = E.status;
            if (i3 == 16 && E.bSend && !E.bOnceSuccess) {
                return 0;
            }
            return i3;
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        TransFileInfo transFileInfo = (TransFileInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) TransFileInfo.class, String.valueOf(message.time), String.valueOf(message.msgseq), qQAppInterface.getCurrentAccountUin(), message.frienduin);
        createEntityManager.close();
        if (transFileInfo == null) {
            return 0;
        }
        int status = FileManagerUtil.getStatus(transFileInfo.status);
        transFileInfo.status = status;
        if (status == 2) {
            transFileInfo.status = 0;
        }
        return transFileInfo.status;
    }

    private static void h(Context context, AppInterface appInterface, Message message, MsgSummary msgSummary) {
        if (t61.a.d() && appInterface != null) {
            MessageRecord queryMsgItemByUniseq = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
            if (t61.a.m(queryMsgItemByUniseq)) {
                String c16 = t61.a.c(queryMsgItemByUniseq, context);
                msgSummary.strContent = c16;
                if (!TextUtils.isEmpty(c16)) {
                    msgSummary.suffix = "";
                }
            }
        }
    }

    public static String i(String str) {
        String qqStr = HardCodeUtil.qqStr(R.string.oay);
        StringBuilder sb5 = new StringBuilder(40);
        if (str != null) {
            sb5.append(str + MsgSummary.STR_COLON);
        }
        sb5.append(qqStr);
        return sb5.toString();
    }

    public static String j(QQAppInterface qQAppInterface, String[] strArr, Context context, String str, String str2, int i3) {
        int i16;
        int i17;
        String string;
        int i18;
        int i19;
        String string2;
        if (strArr == null) {
            return "";
        }
        if (i3 != 1 && i3 != 5000) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        if (strArr.length <= 1) {
            return "";
        }
        int i26 = 0;
        try {
            i17 = Integer.parseInt(strArr[1]);
        } catch (NumberFormatException unused) {
            i17 = 0;
        }
        if (i17 != 13) {
            string = context.getResources().getString(R.string.dcg);
            if (i3 == 1 || i3 == 5000) {
                string = context.getResources().getString(R.string.dcy);
            }
        } else if (str2 != null) {
            String s16 = ac.s(qQAppInterface, str2, str, i16, 0);
            String string3 = context.getResources().getString(R.string.dcg);
            if (i3 == 1 || i3 == 5000) {
                string3 = context.getResources().getString(R.string.dcy);
            }
            if (s16.length() > 11) {
                s16 = s16.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            string = s16 + string3;
        } else if (i3 != 1 && i3 != 5000) {
            string = context.getResources().getString(R.string.dbb);
        } else {
            string = context.getResources().getString(R.string.dcv);
        }
        if (strArr.length > 5) {
            try {
                i18 = Integer.parseInt(strArr[4]);
                try {
                    i26 = Integer.parseInt(strArr[5]);
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                i18 = 0;
            }
            i19 = i26;
            i26 = i18;
        } else {
            i19 = 0;
        }
        if (i26 == 2) {
            if (i19 == 4) {
                string2 = qQAppInterface.getApp().getString(R.string.f171232w32);
            } else if (i19 == 5) {
                string2 = qQAppInterface.getApp().getString(R.string.f1781135s);
            } else {
                string2 = qQAppInterface.getApp().getString(R.string.dcv);
            }
            return string.replace(qQAppInterface.getApp().getString(R.string.dcy), MsgSummary.STR_COLON + string2);
        }
        return string;
    }

    public static String k(String[] strArr, Context context, boolean z16, boolean z17) {
        int i3;
        boolean z18;
        String str;
        String string;
        if (strArr == null || strArr.length <= 1) {
            return "";
        }
        try {
            i3 = Integer.parseInt(strArr[1]);
        } catch (NumberFormatException unused) {
            i3 = 0;
        }
        if (strArr.length > 3) {
            z18 = "1".equals(strArr[3]);
        } else {
            z18 = true;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 != 10) {
                                    if (i3 != 12) {
                                        if (i3 != 24) {
                                            if (i3 != 42) {
                                                switch (i3) {
                                                    case 46:
                                                    case 47:
                                                    case 48:
                                                        if (strArr[0] == null) {
                                                            return "";
                                                        }
                                                        return context.getResources().getString(R.string.f171214d92) + " " + strArr[0];
                                                    default:
                                                        if (z18) {
                                                            string = context.getResources().getString(R.string.dlu);
                                                        } else {
                                                            string = context.getResources().getString(R.string.f171214d92);
                                                        }
                                                        String str2 = string;
                                                        if (!TextUtils.isEmpty(strArr[0])) {
                                                            return str2 + " " + strArr[0];
                                                        }
                                                        return str2;
                                                }
                                            }
                                            if (strArr[0] == null) {
                                                return "";
                                            }
                                            if (context.getString(R.string.f173247id1).equals(strArr[0])) {
                                                if (z18) {
                                                    str = context.getResources().getString(R.string.dma);
                                                } else {
                                                    str = context.getResources().getString(R.string.d9f);
                                                }
                                            } else if (z18) {
                                                str = context.getResources().getString(R.string.dlu) + " " + strArr[0];
                                            } else {
                                                str = context.getResources().getString(R.string.f171214d92) + " " + strArr[0];
                                            }
                                        }
                                    } else {
                                        if (z18) {
                                            return context.getResources().getString(R.string.dm_);
                                        }
                                        return context.getResources().getString(R.string.d9e);
                                    }
                                } else {
                                    if (z18) {
                                        return context.getResources().getString(R.string.dlu);
                                    }
                                    return context.getResources().getString(R.string.f171214d92);
                                }
                            } else {
                                if (z18) {
                                    return context.getResources().getString(R.string.dlv);
                                }
                                return context.getResources().getString(R.string.f171215d94);
                            }
                        } else {
                            if (z18) {
                                if (z17) {
                                    return context.getResources().getString(R.string.dm7);
                                }
                                return context.getResources().getString(R.string.dm6);
                            }
                            if (z17) {
                                return context.getResources().getString(R.string.d9a);
                            }
                            return context.getResources().getString(R.string.d9_);
                        }
                    } else {
                        if (z18) {
                            return context.getResources().getString(R.string.dm8);
                        }
                        return context.getResources().getString(R.string.d9b);
                    }
                }
                if (strArr[0] == null) {
                    return "";
                }
                if (context.getString(R.string.id5).equals(strArr[0])) {
                    if (z18) {
                        if (z17) {
                            str = context.getResources().getString(R.string.dm7);
                        } else {
                            str = context.getResources().getString(R.string.dm6);
                        }
                    } else if (z17) {
                        str = context.getResources().getString(R.string.d9a);
                    } else {
                        str = context.getResources().getString(R.string.d9_);
                    }
                } else if (z18) {
                    str = context.getResources().getString(R.string.dlu) + " " + strArr[0];
                } else {
                    str = context.getResources().getString(R.string.f171214d92) + " " + strArr[0];
                }
            } else {
                if (z18) {
                    if (z17) {
                        return context.getResources().getString(R.string.dm7);
                    }
                    return context.getResources().getString(R.string.dm6);
                }
                if (z17) {
                    return context.getResources().getString(R.string.d9a);
                }
                return context.getResources().getString(R.string.d9_);
            }
        } else {
            if (strArr[0] == null) {
                return "";
            }
            if (context.getString(R.string.f173247id1).equals(strArr[0])) {
                if (z18) {
                    str = context.getResources().getString(R.string.dma);
                } else {
                    str = context.getResources().getString(R.string.d9f);
                }
            } else if (z18) {
                str = context.getResources().getString(R.string.dlu) + " " + strArr[0];
            } else {
                str = context.getResources().getString(R.string.f171214d92) + " " + strArr[0];
            }
        }
        return str;
    }

    public static String l(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = Pattern.compile("(|(\\d{2}):)(\\d{2}):(\\d{2})$").matcher(str);
        if (matcher.find() && matcher.groupCount() >= 4) {
            int i3 = 0;
            String group = matcher.group(0);
            String group2 = matcher.group(1);
            if (group2 != null && group2.length() > 0) {
                i3 = Integer.parseInt(matcher.group(2));
            }
            int parseInt = Integer.parseInt(matcher.group(3));
            int parseInt2 = Integer.parseInt(matcher.group(4));
            StringBuffer stringBuffer = new StringBuffer();
            if (i3 > 0) {
                stringBuffer.append(i3);
                stringBuffer.append(context.getString(R.string.brw));
            }
            if (parseInt > 0) {
                stringBuffer.append(parseInt);
                stringBuffer.append(context.getString(R.string.ca5));
            }
            stringBuffer.append(parseInt2);
            stringBuffer.append(context.getString(R.string.hay));
            return str.replace(group, stringBuffer.toString());
        }
        return str;
    }

    public static boolean m(AppInterface appInterface, Message message) {
        com.tencent.mobileqq.troop.data.t m3;
        int i3;
        String str;
        if (message == null) {
            return false;
        }
        if (com.tencent.imcore.message.ao.z(message.frienduin, message.istroop) && (str = message.senderuin) != null) {
            if (com.tencent.imcore.message.ao.F(str)) {
                return false;
            }
            int i16 = message.istroop;
            if (i16 == 1032) {
                if (message.isSelfConfessor()) {
                    i16 = 1033;
                } else {
                    i16 = 1034;
                }
            }
            message = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(message.senderuin, i16);
        }
        int i17 = message.msgtype;
        if (i17 == -2005) {
            if (2 != g((QQAppInterface) appInterface, message)) {
                return false;
            }
            return true;
        }
        if (i17 == -2017) {
            MessageRecord msgItemByUniseq = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
            if (msgItemByUniseq != null && (msgItemByUniseq instanceof MessageForTroopFile)) {
                MessageForTroopFile messageForTroopFile = (MessageForTroopFile) msgItemByUniseq;
                if (messageForTroopFile.frienduin != null && (m3 = TroopFileUtils.m((QQAppInterface) appInterface, messageForTroopFile)) != null && ((i3 = m3.f294972f) == 1 || i3 == 0)) {
                    return true;
                }
            }
            return false;
        }
        IHttpCommunicatorListener findProcessor = ((ITransFileController) appInterface.getRuntimeService(ITransFileController.class, "")).findProcessor(message.frienduin, message.uniseq);
        if ((findProcessor instanceof BuddyTransfileProcessor) && message.isSendFromLocal() && findProcessor != null) {
            BuddyTransfileProcessor buddyTransfileProcessor = (BuddyTransfileProcessor) findProcessor;
            if (buddyTransfileProcessor.getProgress() >= 0 && buddyTransfileProcessor.getProgress() != 100) {
                return true;
            }
        }
        return ((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).t1(message);
    }

    private static boolean n(AppInterface appInterface, Message message) {
        com.tencent.mobileqq.troop.data.t m3;
        String str;
        if (message == null) {
            return false;
        }
        if (com.tencent.imcore.message.ao.z(message.frienduin, message.istroop) && (str = message.senderuin) != null) {
            if (com.tencent.imcore.message.ao.F(str)) {
                return false;
            }
            int i3 = message.istroop;
            if (i3 == 1032) {
                if (message.isSelfConfessor()) {
                    i3 = 1033;
                } else {
                    i3 = 1034;
                }
            }
            message = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(message.senderuin, i3);
        }
        int i16 = message.msgtype;
        if (i16 == -2005) {
            if (g((QQAppInterface) appInterface, message) != 0) {
                return false;
            }
            return true;
        }
        if (message.fileType == 1) {
            int findProcessorFileStatus = TransFileControllerBusHelper.findProcessorFileStatus(appInterface, message.frienduin, null, message.uniseq);
            if (findProcessorFileStatus == 1005 || findProcessorFileStatus == 1004) {
                return true;
            }
        } else if (i16 == -2017) {
            MessageRecord msgItemByUniseq = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
            if (msgItemByUniseq instanceof MessageForTroopFile) {
                MessageForTroopFile messageForTroopFile = (MessageForTroopFile) msgItemByUniseq;
                if (messageForTroopFile == null || messageForTroopFile.frienduin == null || (m3 = TroopFileUtils.m((QQAppInterface) appInterface, messageForTroopFile)) == null || m3.f294972f != 3) {
                    return false;
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgTypeError", 2, "uniseq:" + message.uniseq + ",msgtype:" + message.msgtype);
            }
        }
        if (!message.isSendFromLocal() || message.extraflag != 32768) {
            return false;
        }
        return true;
    }

    @Nullable
    private static String o(AppInterface appInterface, Message message, String str, boolean z16) {
        String str2;
        if (com.tencent.biz.anonymous.a.m(message) && (TextUtils.isEmpty(str) || !str.equals(ac.g0(appInterface, message.frienduin, true)))) {
            MessageRecord queryMsgItemByUniseq = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).queryMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
            if (queryMsgItemByUniseq instanceof ChatMessage) {
                ((ChatMessage) queryMsgItemByUniseq).parse();
            }
            if (queryMsgItemByUniseq != null) {
                str = com.tencent.biz.anonymous.a.e(queryMsgItemByUniseq).f78367c;
            }
            if (TextUtils.isEmpty(str)) {
                str = com.tencent.biz.anonymous.a.e(message).f78367c;
            }
        }
        String str3 = null;
        if (!z16 && (message.isSendFromLocal() || ((str2 = message.selfuin) != null && str2.equals(message.senderuin)))) {
            str = null;
        }
        if (!com.tencent.imcore.message.ad.R(message.msgtype)) {
            str3 = str;
        }
        ac.a a16 = com.tencent.mobileqq.troop.utils.ac.a(message);
        if (a16 != null) {
            str3 = a16.f301997d;
        }
        return r(str3);
    }

    private static void p(Message message, QQAppInterface qQAppInterface, int i3) {
        String f06;
        if (message != null && 1 == i3 && (f06 = ac.f0(qQAppInterface, message.frienduin, message.senderuin)) != null && !TextUtils.equals(f06, message.nickName)) {
            message.nickName = f06;
            if (QLog.isColorLevel()) {
                QLog.i("Q.recent", 2, "processTroopNickName  nickname : " + f06);
            }
        }
    }

    public static String q(String str) {
        if (str != null && str.length() != 0) {
            char[] charArray = str.toCharArray();
            int length = str.length() - 1;
            int i3 = 0;
            while (i3 <= length) {
                char c16 = charArray[i3];
                if (c16 > ' ' || c16 == 20) {
                    break;
                }
                i3++;
            }
            if (i3 == 0) {
                return str;
            }
            String substring = str.substring(i3, length + 1);
            if (QLog.isDevelopLevel()) {
                QLog.i("MsgUtils", 4, "trimBegin source:" + str + ", temp:" + substring);
            }
            return substring;
        }
        return str;
    }

    public static String r(String str) {
        return s(str, 1.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String s(String str, float f16) {
        long j3;
        String str2;
        float f17;
        StringBuilder sb5;
        String qqStr;
        TextPaint textPaint;
        float min;
        if (str == null || str.length() == 0) {
            return str;
        }
        if (QLog.isDevelopLevel()) {
            j3 = SystemClock.elapsedRealtime();
        } else {
            j3 = 0;
        }
        float f18 = 0.0f;
        if (f307502c == 0) {
            try {
                try {
                    DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
                    qqStr = HardCodeUtil.qqStr(R.string.ob7);
                    textPaint = new TextPaint();
                    textPaint.setTextSize(displayMetrics.density * 14.0f);
                    min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) - (displayMetrics.density * 72.0f);
                } catch (Error e16) {
                    e16.printStackTrace();
                    f307502c = 14;
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder(120);
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    f307502c = 14;
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder(120);
                    }
                }
                if (min <= 0.0f) {
                    return str;
                }
                f307505f = 0.7f * min;
                f307503d = textPaint.measureText(qqStr);
                float measureText = textPaint.measureText("AaJjIiMm") / 8;
                f307504e = measureText;
                float f19 = f307503d;
                if (f19 > 1.0f) {
                    f307502c = (int) ((min * 0.8f) / f19);
                }
                if (measureText > 1.0f) {
                    f307502c = Math.min(f307502c, (int) (f307505f / measureText));
                }
                if (f307502c <= 0) {
                    f307502c = 14;
                }
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder(120);
                    sb5.append("trimName");
                    sb5.append(", sMaxWidth = ");
                    sb5.append(f307505f);
                    sb5.append(", sMinLen = ");
                    sb5.append(f307502c);
                    sb5.append(", sZhW = ");
                    sb5.append(f307503d);
                    sb5.append(", sEnW = ");
                    sb5.append(f307504e);
                    QLog.i("Q.recent", 2, sb5.toString());
                }
            } finally {
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder(120);
                    sb6.append("trimName");
                    sb6.append(", sMaxWidth = ");
                    sb6.append(f307505f);
                    sb6.append(", sMinLen = ");
                    sb6.append(f307502c);
                    sb6.append(", sZhW = ");
                    sb6.append(f307503d);
                    sb6.append(", sEnW = ");
                    sb6.append(f307504e);
                    QLog.i("Q.recent", 2, sb6.toString());
                }
            }
        }
        int length = str.length();
        if (length >= f307502c && f307504e >= 1.0f && f307503d >= 1.0f) {
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                char charAt = str.charAt(i16);
                if (charAt >= ' ' && charAt <= '~') {
                    f17 = f307504e;
                } else {
                    f17 = f307503d;
                }
                f18 += f17;
                if ((f307505f * f16) - f18 <= 1.0f) {
                    break;
                }
                i3++;
            }
            if (i3 < length && i3 > 0) {
                str2 = str.substring(0, i3 - 1) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                if (QLog.isDevelopLevel()) {
                    f307500a += SystemClock.elapsedRealtime() - j3;
                    long j16 = f307501b + 1;
                    f307501b = j16;
                    if (j16 % 10 == 1) {
                        QLog.i("Q.recent", 4, "trimName, cost = " + (f307500a / f307501b));
                    }
                }
                return str2;
            }
        }
        str2 = str;
        if (QLog.isDevelopLevel()) {
        }
        return str2;
    }
}
