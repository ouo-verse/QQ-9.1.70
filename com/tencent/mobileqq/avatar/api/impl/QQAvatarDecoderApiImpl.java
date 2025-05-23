package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.DecodeCompletionListener;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarDecoderApiImpl implements IQQAvatarDecoderApi {
    static IPatchRedirector $redirector_;

    public QQAvatarDecoderApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi
    public void closeFaceDecodeThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            FaceDecodeTask.closeFaceDecodeThread();
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi
    public void executeTask(AppInterface appInterface, FaceInfo faceInfo, DecodeCompletionListener decodeCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, faceInfo, decodeCompletionListener);
        } else {
            FaceDecodeTask.executeTask(appInterface, faceInfo, decodeCompletionListener);
        }
    }
}
