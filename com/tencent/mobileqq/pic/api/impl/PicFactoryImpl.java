package com.tencent.mobileqq.pic.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.app.asyncdb.BaseCache;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.asyncdb.cache.b;
import com.tencent.mobileqq.pic.api.IPicFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AIOPhotoImageDownloader;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CQzonePicUploadProcessor;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.GroupPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupQzonePicUploadProcessor;
import com.tencent.mobileqq.transfile.GuildPicDownloadProcessor;
import com.tencent.mobileqq.transfile.GuildPicUploadProcessor;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TroopEffectsPicUploadProcessor;
import com.tencent.mobileqq.transfile.ZPlanPicUploadProcessor;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes16.dex */
public class PicFactoryImpl implements IPicFactory {
    static IPatchRedirector $redirector_;

    public PicFactoryImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFactory
    public BaseCache getCache(AppInterface appInterface, DBDelayManager dBDelayManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseCache) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) dBDelayManager);
        }
        return new b(appInterface, dBDelayManager);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFactory
    public ProtocolDownloader getChatImageDownloader(BaseApplication baseApplication, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ProtocolDownloader) iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseApplication, (Object) str);
        }
        if (ProtocolDownloaderConstants.PROTOCOL_AIO_THUMB.equals(str)) {
            return new AIOPhotoImageDownloader(baseApplication);
        }
        if (!"chatthumb".equals(str) && !ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE.equals(str) && !ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW.equals(str)) {
            return null;
        }
        return new ChatImageDownloader(baseApplication);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFactory
    public BaseTransProcessor getProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
        int i3 = transferRequest.mUinType;
        if (i3 == 10014) {
            if (transferRequest.mIsUp) {
                if (transferRequest.mBusiType == 1045) {
                    return new GroupQzonePicUploadProcessor(baseTransFileController, transferRequest);
                }
                return new GuildPicUploadProcessor(baseTransFileController, transferRequest);
            }
            int i16 = transferRequest.mFileType;
            if (i16 == 1 || i16 == 65537 || i16 == 131075) {
                return new GuildPicDownloadProcessor(baseTransFileController, transferRequest);
            }
            return null;
        }
        if (i3 != 1 && i3 != 3000) {
            if (transferRequest.mIsUp) {
                int i17 = transferRequest.mBusiType;
                if (i17 == 1045) {
                    return new C2CQzonePicUploadProcessor(baseTransFileController, transferRequest);
                }
                if (i17 == 1059) {
                    return new ZPlanPicUploadProcessor(baseTransFileController, transferRequest);
                }
                return new C2CPicUploadProcessor(baseTransFileController, transferRequest);
            }
            int i18 = transferRequest.mFileType;
            if (i18 == 1 || i18 == 65537 || i18 == 131075) {
                return new C2CPicDownloadProcessor(baseTransFileController, transferRequest);
            }
            return null;
        }
        if (transferRequest.mIsUp) {
            if (transferRequest.mFileType == 55) {
                return new TroopEffectsPicUploadProcessor(baseTransFileController, transferRequest);
            }
            int i19 = transferRequest.mBusiType;
            if (i19 == 1045) {
                return new GroupQzonePicUploadProcessor(baseTransFileController, transferRequest);
            }
            if (i19 == 1059) {
                return new ZPlanPicUploadProcessor(baseTransFileController, transferRequest);
            }
            return new GroupPicUploadProcessor(baseTransFileController, transferRequest);
        }
        int i26 = transferRequest.mFileType;
        if (i26 != 1 && i26 != 65537 && i26 != 131075) {
            return null;
        }
        return new GroupPicDownloadProcessor(baseTransFileController, transferRequest);
    }
}
