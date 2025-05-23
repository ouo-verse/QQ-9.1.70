package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader;
import com.tencent.mobileqq.emoticon.kernel.KernelQQSysAndEmojiResMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.PullMomentType;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQSysAndEmojiResMgr implements d {
    static IPatchRedirector $redirector_ = null;
    public static final boolean ENABLE_APK_RES = true;
    private static final String QQ_SYS_AND_EMOJI_SINKING_NT_KERNEL_SWITCH = "102294";
    public static final int REPORT_ENTRANCE_AIO = 1;
    public static final int REPORT_ENTRANCE_FAV_TEXT = 3;
    public static final int REPORT_ENTRANCE_FORWARD_INNER = 4;
    public static final int REPORT_ENTRANCE_FORWARD_OUTER = 5;
    public static final int REPORT_ENTRANCE_MINIAIO = 2;
    public static final String SP_QQ_EMOTICON = "qq_emoticon_sp";
    public static final String TAG = "QQSysAndEmojiResMgr";
    private final e mInnerQQSysAndEmojiMgr;
    private final boolean mSinkingNtKernelSwitch;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class DownloadResItem {
        static IPatchRedirector $redirector_ = null;
        public static final int TYPE_CONFIG_RES = 1;
        public static final int TYPE_EMOJI_RES = 3;
        public static final int TYPE_EXT_ANI_STICKER_CONFIG_RES = 6;
        public static final int TYPE_EXT_ANI_STICKER_LOTTIE_RES = 9;
        public static final int TYPE_EXT_ANI_STICKER_SVG_RES = 8;
        public static final int TYPE_EXT_ANI_STICKER_SYSFACE_RES = 7;
        public static final int TYPE_LOTTIE_RES = 5;
        public static final int TYPE_SVG_RES = 4;
        public static final int TYPE_SYSFACE_RES = 2;
        public String mMd5;
        public String mName;
        public int mType;
        public String mUrl;

        public DownloadResItem(String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3));
                return;
            }
            this.mUrl = str;
            this.mMd5 = str2;
            this.mName = str.substring(str.lastIndexOf("/") + 1);
            this.mType = i3;
        }

        public String getSignature() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mUrl + "_" + this.mMd5;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class QQSysAndEmojiResMgrHolder {
        static IPatchRedirector $redirector_;
        private static QQSysAndEmojiResMgr INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41322);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new QQSysAndEmojiResMgr();
            }
        }

        public QQSysAndEmojiResMgrHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static void setResMgr(QQSysAndEmojiResMgr qQSysAndEmojiResMgr) {
            INSTANCE = qQSysAndEmojiResMgr;
        }
    }

    public QQSysAndEmojiResMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn(QQ_SYS_AND_EMOJI_SINKING_NT_KERNEL_SWITCH, true);
        this.mSinkingNtKernelSwitch = isSwitchOn;
        if (isSwitchOn) {
            if (TextUtils.equals(MobileQQ.processName, BaseApplication.getContext().getPackageName())) {
                this.mInnerQQSysAndEmojiMgr = new KernelQQSysAndEmojiResMgr();
            } else {
                this.mInnerQQSysAndEmojiMgr = new com.tencent.mobileqq.emoticon.kernel.i();
            }
        } else {
            this.mInnerQQSysAndEmojiMgr = new m();
        }
        checkInitConfig();
    }

    public static final QQSysAndEmojiResMgr getInstance() {
        return QQSysAndEmojiResMgrHolder.INSTANCE;
    }

    public void checkInitConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            QLog.d(TAG, 1, "[checkInitConfig]");
            this.mInnerQQSysAndEmojiMgr.initConfig();
        }
    }

    public void downloadEmoticonRes(List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        } else {
            if (list == null) {
                return;
            }
            this.mInnerQQSysAndEmojiMgr.downloadEmoticonRes(list);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NonNull
    public String getAniStickerLoadingResPath(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        return this.mInnerQQSysAndEmojiMgr.getAniStickerLoadingResPath(i3);
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerRandomResultFullResPath(int i3, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), str, str2, str3);
        }
        return this.mInnerQQSysAndEmojiMgr.getAniStickerRandomResultFullResPath(i3, str, str2, str3);
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerResPath(int i3, @NotNull String str, @NotNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), str, str2);
        }
        return this.mInnerQQSysAndEmojiMgr.getAniStickerResPath(i3, str, str2);
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerSurpriseFullResPath(int i3, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), str, str2, str3, Boolean.valueOf(z16));
        }
        return this.mInnerQQSysAndEmojiMgr.getAniStickerSurpriseFullResPath(i3, str, str2, str3, z16);
    }

    @Override // com.tencent.mobileqq.emoticon.d
    public String getFullResPath(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return this.mInnerQQSysAndEmojiMgr.getFullResPath(i3, i16);
    }

    public synchronized QQSysAndEmojiResInfo getResImpl(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QQSysAndEmojiResInfo) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (i3 == 1) {
            return this.mInnerQQSysAndEmojiMgr.c();
        }
        if (i3 == 2) {
            return this.mInnerQQSysAndEmojiMgr.b();
        }
        throw new IllegalArgumentException("not support such type:" + i3);
    }

    @Override // com.tencent.mobileqq.emoticon.d
    public Pair<String, Boolean> getSysFaceFullResPath(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Pair) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return this.mInnerQQSysAndEmojiMgr.getSysFaceFullResPath(i3, i16);
    }

    public void refreshConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.d(TAG, 1, "[refreshConfig]");
            this.mInnerQQSysAndEmojiMgr.refreshConfig();
        }
    }

    public void setLottieResReloadListener(QQSysAndEmojiResReloader.IResReloadListener iResReloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iResReloadListener);
        } else {
            this.mInnerQQSysAndEmojiMgr.setLottieResReloadListener(iResReloadListener);
        }
    }

    public void refreshConfig(PullMomentType pullMomentType, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.mInnerQQSysAndEmojiMgr.refreshConfig(pullMomentType, z16, z17);
        } else {
            iPatchRedirector.redirect((short) 4, this, pullMomentType, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }
}
