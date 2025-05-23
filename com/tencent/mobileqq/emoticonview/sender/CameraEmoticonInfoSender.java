package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CameraEmoticonInfoSender {
    static IPatchRedirector $redirector_ = null;
    static final long ONE_SEC = 1000;
    static long lastTime;

    public CameraEmoticonInfoSender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void send(CameraEmoticonInfo cameraEmoticonInfo, AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        Bundle bundle;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastTime < 1000) {
            if (QLog.isColorLevel()) {
                QLog.e(CameraEmoticonInfo.TAG, 2, "send to offen,please try it later");
                return;
            }
            return;
        }
        if (appRuntime == null || context == null || parcelable == 0 || !(appRuntime instanceof BaseQQAppInterface)) {
            return;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        p pVar = (p) parcelable;
        String str = cameraEmoticonInfo.templateId;
        String str2 = cameraEmoticonInfo.eId;
        String str3 = cameraEmoticonInfo.path;
        String str4 = cameraEmoticonInfo.contextKey;
        lastTime = currentTimeMillis;
        if (!TextUtils.isEmpty(str)) {
            bundle = new Bundle();
            bundle.putString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, str);
        } else {
            bundle = null;
        }
        CustomEmotionSenderUtil.sendCustomEmotion(baseQQAppInterface, context, pVar, str3, true, str4, bundle);
        if (!TextUtils.isEmpty(str2)) {
            ReportController.o(baseQQAppInterface, "dc00898", "", "", "0X800A371", "0X800A371", 0, 0, "", "", str2, "");
        }
    }
}
