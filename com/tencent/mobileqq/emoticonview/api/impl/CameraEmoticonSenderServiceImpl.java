package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ICameraEmoticonSenderService;
import com.tencent.mobileqq.emoticonview.sender.CameraEmoticonInfoSender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CameraEmoticonSenderServiceImpl implements ICameraEmoticonSenderService {
    static IPatchRedirector $redirector_;

    public CameraEmoticonSenderServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.ICameraEmoticonSenderService
    public void send(CameraEmoticonInfo cameraEmoticonInfo, AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, cameraEmoticonInfo, appRuntime, context, editText, parcelable);
        } else {
            CameraEmoticonInfoSender.send(cameraEmoticonInfo, appRuntime, context, editText, parcelable);
        }
    }
}
