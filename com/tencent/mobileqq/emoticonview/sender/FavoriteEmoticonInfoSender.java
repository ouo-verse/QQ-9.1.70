package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.au;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FavoriteEmoticonInfoSender {
    static IPatchRedirector $redirector_ = null;
    static final long ONE_SEC = 1000;
    private static final String TAG = "FavoriteEmoticonInfoSender";
    static long lastTime;

    public FavoriteEmoticonInfoSender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void internalSendCustomEmotion(BaseQQAppInterface baseQQAppInterface, Context context, p pVar, String str, boolean z16, boolean z17, String str2, StickerInfo stickerInfo) {
        CustomEmotionSenderUtil.sendCustomEmotion(baseQQAppInterface, context, pVar, str, z16, z17, str2, stickerInfo);
        if (!TextUtils.isEmpty(str) && str.contains(FunnyPicHelperConstant.FUNYPIC_PREFIX)) {
            ReportController.o(baseQQAppInterface, "CliOper", "", "", "0X8005C74", "0X8005C74", 0, 0, String.valueOf(au.f(str2)), "", FunnyPicHelperConstant.getFunnyPicName(str), "");
        } else {
            ReportController.o(baseQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "1", "");
        }
    }

    private static boolean isNeedInterruptQrCode(final Context context, final BaseQQAppInterface baseQQAppInterface, final p pVar, final String str, final String str2) {
        if (pVar.f179555d != 10014 || !((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptQrCode(pVar.f179559f, pVar.f179557e)) {
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.sender.a
            @Override // java.lang.Runnable
            public final void run() {
                FavoriteEmoticonInfoSender.lambda$isNeedInterruptQrCode$1(str, baseQQAppInterface, context, pVar, str2);
            }
        }, 64, null, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isNeedInterruptQrCode$0(ScannerResult scannerResult, BaseQQAppInterface baseQQAppInterface, Context context, p pVar, String str, String str2) {
        if (scannerResult != null && (scannerResult.l() || scannerResult.j())) {
            ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptQrCodeSendToast();
        } else {
            internalSendCustomEmotion(baseQQAppInterface, context, pVar, str, true, !TextUtils.isEmpty(str2), str2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isNeedInterruptQrCode$1(final String str, final BaseQQAppInterface baseQQAppInterface, final Context context, final p pVar, final String str2) {
        final ScannerResult decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + new File(str).getAbsolutePath()), (Context) BaseApplication.getContext(), 3, false);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.sender.b
            @Override // java.lang.Runnable
            public final void run() {
                FavoriteEmoticonInfoSender.lambda$isNeedInterruptQrCode$0(ScannerResult.this, baseQQAppInterface, context, pVar, str, str2);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void send(FavoriteEmoticonInfo favoriteEmoticonInfo, AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        if (appRuntime != null && parcelable != 0) {
            if (!(appRuntime instanceof BaseQQAppInterface)) {
                return;
            }
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
            p pVar = (p) parcelable;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastTime < 1000) {
                if (QLog.isColorLevel()) {
                    QLog.e(FavoriteEmoticonInfo.TAG, 2, "send to offen,please try it later");
                    return;
                }
                return;
            }
            lastTime = currentTimeMillis;
            String str = favoriteEmoticonInfo.path;
            String str2 = favoriteEmoticonInfo.eId;
            String str3 = favoriteEmoticonInfo.actionData;
            if (((IEmosmService) QRoute.api(IEmosmService.class)).isComeFromComic(str3)) {
                sendStructMsgForImage(baseQQAppInterface, pVar, str, str3);
                return;
            } else {
                if (isNeedInterruptQrCode(context, baseQQAppInterface, pVar, str, str2)) {
                    return;
                }
                internalSendCustomEmotion(baseQQAppInterface, context, pVar, str, true, !TextUtils.isEmpty(str2), str2, null);
                return;
            }
        }
        QLog.e(TAG, 2, "app or sessionInfo is null.");
    }

    public static void sendStructMsgForImage(BaseQQAppInterface baseQQAppInterface, p pVar, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("image_url", str);
        bundle.putInt("forward_type", -3);
        bundle.putString("pkg_name", "com.tencent.mobileqq");
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 5);
        bundle.putString(AppConstants.Key.SHARE_BRIEF, HardCodeUtil.qqStr(R.string.f209365f8));
        bundle.putString("app_name", "QQ\u52a8\u6f2b");
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION_DATA, str2);
        ((IEmosmService) QRoute.api(IEmosmService.class)).sendStructMsgForImage(baseQQAppInterface, str2, bundle, pVar);
    }
}
