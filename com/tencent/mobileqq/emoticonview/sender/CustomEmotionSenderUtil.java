package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CustomEmotionSenderUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CustomEmotionSenderUtil";

    public CustomEmotionSenderUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void sendCustomEmotion(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, String str, boolean z16, String str2, Bundle bundle) {
        sendCustomEmotion(baseQQAppInterface, context, pVar, str, false, false, z16, null, null, str2, bundle);
    }

    public static void sendCustomEmotion(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, String str, boolean z16, boolean z17, String str2, StickerInfo stickerInfo) {
        sendCustomEmotion(baseQQAppInterface, context, pVar, str, z16, z17, false, str2, stickerInfo, null, null);
    }

    public static void sendCustomEmotion(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, String str, boolean z16, boolean z17, boolean z18, String str2, StickerInfo stickerInfo, String str3, Bundle bundle) {
        if (str == null) {
            QLog.e(TAG, 1, "sendCustomEmotion url == null");
            if (z16) {
                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "5", "", "", "", "", "", "", "");
                return;
            }
            return;
        }
        RichMediaUtil.logUI(pVar.f179555d, true, 1, String.valueOf(-1), "image_send_prepare", "ChatActivity.sendCustomEmotion");
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            QQToast.makeText(context, R.string.cwe, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            if (z16) {
                VasReportUtils.reportEmotionError(VasReportUtils.BUSINESS_TYPE_EMOTION, VasReportUtils.EMOTION_ACITON_SEND, "6", "", "", "", "", "", "", "");
            }
            QLog.e(TAG, 1, "sendCustomEmotion file not exist or problme: URL = " + str);
            return;
        }
        v.a aVar = new v.a();
        aVar.v(str);
        aVar.m(1006);
        aVar.x(pVar.f179557e);
        aVar.y(0);
        aVar.A(pVar.f179559f);
        aVar.B(baseQQAppInterface.getCurrentAccountUin());
        aVar.I(pVar.f179555d);
        aVar.H(pVar.S);
        com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, 1006);
        createPicReq.f(aVar.l());
        PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
        if (z18) {
            picMessageExtraData.imageBizType = 8;
            if (bundle != null) {
                picMessageExtraData.mTemplateId = bundle.getString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, "");
            }
        } else {
            picMessageExtraData.imageBizType = 1;
            picMessageExtraData.customFaceType = z17 ? 2 : 0;
            picMessageExtraData.emojiPkgId = z17 ? str2 : "";
            if (stickerInfo != null) {
                picMessageExtraData.stickerInfo = stickerInfo;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            picMessageExtraData.textSummary = "[" + str3 + "]";
        } else if (z18) {
            picMessageExtraData.textSummary = context.getResources().getString(R.string.imm);
        } else {
            picMessageExtraData.textSummary = context.getResources().getString(R.string.iml);
        }
        createPicReq.E = picMessageExtraData;
        ((IPicBus) QRoute.api(IPicBus.class)).launch(createPicReq);
        if (z16) {
            ThreadManagerV2.post(new Runnable(str, pVar, baseQQAppInterface) { // from class: com.tencent.mobileqq.emoticonview.sender.CustomEmotionSenderUtil.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ BaseQQAppInterface val$app;
                final /* synthetic */ p val$sessionInfo;
                final /* synthetic */ String val$url;

                {
                    this.val$url = str;
                    this.val$sessionInfo = pVar;
                    this.val$app = baseQQAppInterface;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, pVar, baseQQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        try {
                            ((IEmosmService) QRoute.api(IEmosmService.class)).reportSendPicSource(new String[]{this.val$url}, this.val$sessionInfo.f179555d, false, false, -1, this.val$app);
                        } catch (Exception unused) {
                        }
                    }
                }
            }, 5, null, false);
        }
    }
}
