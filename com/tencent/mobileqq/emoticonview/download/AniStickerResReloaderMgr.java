package com.tencent.mobileqq.emoticonview.download;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView;
import com.tencent.mobileqq.emoticonview.download.EmoLottieResReloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AniStickerResReloaderMgr extends BaseLottieResReloaderMgr implements EmoLottieResReloader.IResReloadListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AniStickerResReloaderMgr";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class AniStickerResReloaderMgrHolder {
        static IPatchRedirector $redirector_;
        private static AniStickerResReloaderMgr INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42233);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new AniStickerResReloaderMgr();
            }
        }

        public AniStickerResReloaderMgrHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static void setResMgr(AniStickerResReloaderMgr aniStickerResReloaderMgr) {
            INSTANCE = aniStickerResReloaderMgr;
        }
    }

    public AniStickerResReloaderMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final AniStickerResReloaderMgr getInstance() {
        return AniStickerResReloaderMgrHolder.INSTANCE;
    }

    @Override // com.tencent.mobileqq.emoticonview.download.BaseLottieResReloaderMgr
    public EmoLottieResReloader createLottieResReloader(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EmoLottieResReloader) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        if (i3 == 1) {
            return new EmoLottieResReloader(this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.download.EmoLottieResReloader.IResReloadListener
    public void startReloadDrawable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            AniStickerLottieView.startReloadDrawable(str);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.download.EmoLottieResReloader.IResReloadListener
    public void triggerDownloadRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.download.AniStickerResReloaderMgr.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AniStickerResReloaderMgr.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (QQSysAndEmojiResMgr.getInstance() != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(AniStickerResReloaderMgr.TAG, 2, "trigger downloadEmoticonRes");
                        }
                        QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes(Arrays.asList(5, 9));
                    }
                }
            }, 128, null, false);
        }
    }
}
