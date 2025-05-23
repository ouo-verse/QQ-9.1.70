package com.tencent.mobileqq.emoticonview.download;

import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AniStickerLottieResDownloader extends BaseLottieResDownloader<AniStickerInfo> {
    static IPatchRedirector $redirector_;

    @NotNull
    protected AniStickerInfo mAniStickerInfo;

    public AniStickerLottieResDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader
    public void addReloadDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            AniStickerResReloaderMgr.getInstance().addReloadDrawable(1, getCacheKey());
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.download.IEmoticonLottieResDownloader
    public boolean checkFileExists() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return FileUtils.fileExists(getFilePath());
    }

    @Override // com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader
    public void downloadRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            AniStickerResReloaderMgr.getInstance().triggerDownloadRes();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader
    public String getCacheKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        AniStickerInfo aniStickerInfo = this.mAniStickerInfo;
        if (aniStickerInfo == null) {
            return "";
        }
        return aniStickerInfo.getCacheKey();
    }

    @Override // com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader
    public String getFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AniStickerInfo aniStickerInfo = this.mAniStickerInfo;
        if (aniStickerInfo == null) {
            return null;
        }
        return aniStickerInfo.getFinishStateResFilePath();
    }

    @Override // com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader
    public void setOptions(AniStickerInfo aniStickerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mAniStickerInfo = aniStickerInfo;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aniStickerInfo);
        }
    }
}
