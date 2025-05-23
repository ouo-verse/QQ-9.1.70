package com.tencent.mobileqq.qqemoticon.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler;
import com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.IAppleEmojiManager;
import com.tencent.mobileqq.text.AppleEmojiManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AppleEmojiManagerImpl implements IAppleEmojiManager {
    static IPatchRedirector $redirector_;

    public AppleEmojiManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.IAppleEmojiManager
    public String getAppleEmojiSpName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new AppleEmojiData().getSharedPreferencesName();
    }

    @Override // com.tencent.mobileqq.qqemoticon.api.IAppleEmojiManager
    public void reDownloadAppleEmoji() {
        AppleEmojiHandler appleEmojiHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            IEarlyDownloadService iEarlyDownloadService = (IEarlyDownloadService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IEarlyDownloadService.class, "");
            if (iEarlyDownloadService != null && (appleEmojiHandler = (AppleEmojiHandler) iEarlyDownloadService.getEarlyHandler("qq.android.appleemoji")) != null) {
                appleEmojiHandler.I(true);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(AppleEmojiManager.TAG, 2, "reDownloadAppleEmoji e=" + e16);
            }
        }
    }
}
