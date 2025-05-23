package com.tencent.mobileqq.emoticonview.anisticker;

import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.download.AniStickerResReloaderMgr;
import com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader;
import com.tencent.mobileqq.emoticonview.download.LoadListener;
import com.tencent.mobileqq.emoticonview.download.LottieResDownloadFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;
import com.tencent.rlottie.OnLottieFrameListener;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AniStickerHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int LOTTIE_ANIM_SIZE;
    private static final String TAG = "AniStickerHelper";

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static final class Builder {
        static IPatchRedirector $redirector_;
        Runnable finishRunnable;
        AniStickerAnimationListener listener;
        int localId;
        AniStickerLottieView lottieView;

        @DrawableRes
        int placeholderDrawable;
        Long playLeastTime;
        boolean randomAniSticker;
        String randomKey;
        Integer repeatCount;
        int resultAnimRepeatCount;
        String resultId;
        public boolean showLastFrame;
        boolean showLoading;
        AniStickerInfo stickerInfo;
        String surpriseId;
        public int viewHeight;
        public int viewWidth;

        public Builder(@NotNull AniStickerLottieView aniStickerLottieView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aniStickerLottieView);
                return;
            }
            int i3 = AniStickerHelper.LOTTIE_ANIM_SIZE;
            this.viewWidth = i3;
            this.viewHeight = i3;
            this.showLoading = true;
            this.resultAnimRepeatCount = 1;
            this.lottieView = aniStickerLottieView;
        }

        public Builder build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this;
        }

        public void callFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this);
                return;
            }
            Runnable runnable = this.finishRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }

        public Builder configFinishRunnable(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) runnable);
            }
            this.finishRunnable = runnable;
            return this;
        }

        public Builder height(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            this.viewHeight = i3;
            return this;
        }

        public Builder listener(AniStickerAnimationListener aniStickerAnimationListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) aniStickerAnimationListener);
            }
            this.listener = aniStickerAnimationListener;
            return this;
        }

        public Builder localId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, i3);
            }
            this.localId = i3;
            return this;
        }

        public Builder placeholderDrawable(@DrawableRes int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, i3);
            }
            this.placeholderDrawable = i3;
            return this;
        }

        public Builder playLeastTime(Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) l3);
            }
            this.playLeastTime = l3;
            return this;
        }

        public Builder randomAniSticker(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
            this.randomAniSticker = z16;
            return this;
        }

        public Builder randomKey(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.randomKey = str;
            return this;
        }

        public Builder repeatCount(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) num);
            }
            this.repeatCount = num;
            return this;
        }

        public Builder resultAnimRepeatCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.resultAnimRepeatCount = i3;
            return this;
        }

        public Builder resultId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.resultId = str;
            return this;
        }

        public Builder showLastFrame(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.showLastFrame = z16;
            return this;
        }

        public Builder showLoading(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, z16);
            }
            this.showLoading = z16;
            return this;
        }

        public Builder stickerInfo(AniStickerInfo aniStickerInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) aniStickerInfo);
            }
            this.stickerInfo = aniStickerInfo;
            return this;
        }

        public Builder surpriseId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.surpriseId = str;
            return this;
        }

        public Builder width(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.viewWidth = i3;
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41382);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            LOTTIE_ANIM_SIZE = Utils.n(171.0f, BaseApplication.getContext().getResources());
        }
    }

    public AniStickerHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void clearAniStickerCache() {
        AniStickerLottieView.clearReloadCacheKey();
        AniStickerResReloaderMgr.getInstance().clearReloadList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isChangeAniSticker(AniStickerLottieView aniStickerLottieView, AniStickerInfo aniStickerInfo) {
        if (aniStickerInfo.localId != aniStickerLottieView.localId) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "localId change. lottieView is used.");
            }
            return true;
        }
        String str = aniStickerInfo.randomKey;
        if (str != null && !str.equals(aniStickerLottieView.randomKey)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "randomKey change. lottieView is used.");
            }
            return true;
        }
        if (aniStickerInfo.getSurpriseId() != null && !aniStickerInfo.getSurpriseId().equals(aniStickerLottieView.surpriseId)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "surpriseId change. lottieView is used.");
            }
            return true;
        }
        return false;
    }

    private static void runOnFileThread(boolean z16, Runnable runnable) {
        if (z16 && Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable(runnable) { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Runnable val$runnable;

                {
                    this.val$runnable = runnable;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.val$runnable.run();
                    }
                }
            }, 64, null, false);
        } else {
            runnable.run();
        }
    }

    private static void scheduleSetAniStickerRes(@NotNull Builder builder) {
        AniStickerLottieView aniStickerLottieView = builder.lottieView;
        int i3 = builder.placeholderDrawable;
        if (builder.showLoading) {
            aniStickerLottieView.stickerLoadingDrawable = aniStickerLottieView.getContext().getResources().getDrawable(i3);
        }
        aniStickerLottieView.postInvalidate();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Builder.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AniStickerHelper.setAxrLottieDrawableSync(Builder.this);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 64, null, false);
    }

    public static String setAniStickerRandomLastFrameResource(@NotNull Builder builder) {
        if (builder != null && builder.lottieView != null) {
            builder.showLoading(true).randomAniSticker(true).showLastFrame(true);
            setAniStickerResource(builder);
            return builder.lottieView.randomKey;
        }
        QLog.e(TAG, 2, "set AniStickerRandomLastFrameResource lottieView is null. ");
        return null;
    }

    public static String setAniStickerRandomResource(@NotNull Builder builder) {
        if (builder.lottieView == null) {
            QLog.e(TAG, 2, "set AniStickerRandomResource lottieView is null. ");
            return null;
        }
        builder.randomAniSticker(true).resultId(null).surpriseId(null).showLastFrame(false);
        setAniStickerResource(builder);
        return builder.lottieView.randomKey;
    }

    private static void setAniStickerRandomResourceSync(Builder builder, AniStickerInfo aniStickerInfo) {
        BaseLottieResDownloader baseLottieResDownloader = (BaseLottieResDownloader) LottieResDownloadFactory.createLottieResDownloader(1);
        if (baseLottieResDownloader == null) {
            QLog.e(TAG, 2, "sec lottieResDownloader is null.");
            return;
        }
        if (aniStickerInfo == null) {
            QLog.e(TAG, 2, "sec stickerInfo is null.");
            return;
        }
        AniStickerLottieView aniStickerLottieView = builder.lottieView;
        if (isChangeAniSticker(aniStickerLottieView, aniStickerInfo)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sec load after lottieView is used.");
                return;
            }
            return;
        }
        aniStickerLottieView.resutId = aniStickerInfo.getResultId();
        aniStickerLottieView.randomKey = aniStickerInfo.randomKey;
        baseLottieResDownloader.setOptions(aniStickerInfo);
        if (!AniStickerLottie.lottieEnabled()) {
            return;
        }
        baseLottieResDownloader.loadLottieRes(builder, new LoadListener(aniStickerInfo, builder) { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Builder val$builder;
            final /* synthetic */ AniStickerInfo val$stickerInfo;

            {
                this.val$stickerInfo = aniStickerInfo;
                this.val$builder = builder;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, AniStickerLottieView.this, aniStickerInfo, builder);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.download.LoadListener
            public void onFail(Throwable th5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) th5);
                    return;
                }
                QLog.e(AniStickerHelper.TAG, 2, th5, new Object[0]);
                if (AniStickerHelper.isChangeAniSticker(AniStickerLottieView.this, this.val$stickerInfo) && QLog.isColorLevel()) {
                    QLog.d(AniStickerHelper.TAG, 2, "sec onFail lottieView is used.");
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.download.LoadListener
            public void onLottieResLoading(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                    return;
                }
                if (AniStickerHelper.isChangeAniSticker(AniStickerLottieView.this, this.val$stickerInfo)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(AniStickerHelper.TAG, 2, "sec onLottieResLoading lottieView is used.");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(AniStickerHelper.TAG, 2, "sec lottie res downloading : " + str);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.download.LoadListener
            public void onSuccess(AXrLottieDrawable aXrLottieDrawable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aXrLottieDrawable);
                    return;
                }
                if (AniStickerHelper.isChangeAniSticker(AniStickerLottieView.this, this.val$stickerInfo)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(AniStickerHelper.TAG, 2, "sec onSuccess lottieView is used.");
                        return;
                    }
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                AniStickerLottieView.this.setSecondLottieDrawable(this.val$stickerInfo, aXrLottieDrawable, this.val$builder.resultAnimRepeatCount);
                if (QLog.isColorLevel()) {
                    QLog.d(AniStickerHelper.TAG, 2, "sec lottie view playAnimation. cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sec set lottie res. ");
        }
    }

    public static void setAniStickerRandomResultResource(@NotNull Builder builder) {
        AniStickerLottieView aniStickerLottieView;
        if (builder != null && (aniStickerLottieView = builder.lottieView) != null && !TextUtils.isEmpty(aniStickerLottieView.randomKey) && !TextUtils.isEmpty(builder.resultId)) {
            AniStickerLottieView.setAniStickerRandomResult(builder.lottieView, builder.resultId);
            AniStickerLottieView aniStickerLottieView2 = builder.lottieView;
            aniStickerLottieView2.secRandomResultPlayListener = builder.listener;
            builder.localId(aniStickerLottieView2.localId).randomKey(builder.lottieView.randomKey).resultId(builder.resultId).build();
            AniStickerInfo aniStickerInfo = QQSysFaceUtil.getAniStickerInfo(builder.localId, builder.resultId, null);
            if (aniStickerInfo == null) {
                QLog.e(TAG, 2, "sec randomResultResource aniStickerInfo is null.");
                return;
            } else {
                aniStickerInfo.randomKey = builder.randomKey;
                setAniStickerRandomResourceSync(builder, aniStickerInfo);
                return;
            }
        }
        QLog.e(TAG, 2, "randomKey or resultId is null.");
    }

    public static void setAniStickerRandomSurpriseResource(@NotNull Builder builder) {
        if (builder != null && builder.lottieView != null) {
            builder.showLoading(false).randomAniSticker(false).resultId(null).showLastFrame(false);
            setAniStickerResource(builder);
        } else {
            QLog.e(TAG, 2, "setAniStickerRandomSurpriseResource lottieView is null. ");
        }
    }

    public static void setAniStickerResource(@NotNull Builder builder) {
        boolean z16;
        if (builder == null) {
            QLog.e(TAG, 2, "setAniStickerResource builder is null. ");
            return;
        }
        AniStickerLottieView aniStickerLottieView = builder.lottieView;
        int i3 = builder.localId;
        int i16 = builder.placeholderDrawable;
        boolean z17 = builder.showLoading;
        boolean z18 = builder.randomAniSticker;
        String str = builder.resultId;
        boolean z19 = builder.showLastFrame;
        String str2 = builder.surpriseId;
        AniStickerAnimationListener aniStickerAnimationListener = builder.listener;
        if (aniStickerLottieView == null) {
            QLog.e(TAG, 2, "setAniStickerResource lottieView is null. ");
            return;
        }
        aniStickerLottieView.secRandomResultPlayListener = null;
        aniStickerLottieView.defRandomResultPlayListener = aniStickerAnimationListener;
        if ((aniStickerLottieView.isAnimating() || aniStickerLottieView.getDrawable() != null) && aniStickerLottieView.localId == i3 && i3 != -1 && str2 == null && !z18 && aniStickerLottieView.randomKey == null) {
            if (aniStickerLottieView.getIsEnable() && !aniStickerLottieView.isAnimating()) {
                aniStickerLottieView.reDraw();
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "same lottieView is running.");
                return;
            }
            return;
        }
        if (aniStickerLottieView.getDrawable() != null && z19 && aniStickerLottieView.localId == i3 && str != null && str.equals(aniStickerLottieView.resutId)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "resultId is same. reuse res. " + i3);
                return;
            }
            return;
        }
        aniStickerLottieView.clearLottieDrawable();
        aniStickerLottieView.clearSecondLottieDrawable();
        AniStickerInfo aniStickerInfo = QQSysFaceUtil.getAniStickerInfo(i3, str, str2);
        if (aniStickerInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "stickerInfo is null, show default loading icon.");
            }
            aniStickerLottieView.stickerLoadingDrawable = aniStickerLottieView.getContext().getResources().getDrawable(i16);
            aniStickerLottieView.postInvalidate();
            builder.callFinish();
            return;
        }
        aniStickerLottieView.defaultLoadingRes = i16;
        int i17 = aniStickerLottieView.localId;
        if ((i17 != i3 && z17) || (i3 == i17 && str != null && !str.equals(aniStickerLottieView.resutId) && z17)) {
            z16 = true;
        } else {
            z16 = false;
        }
        aniStickerLottieView.localId = i3;
        aniStickerLottieView.resutId = str;
        aniStickerLottieView.surpriseId = str2;
        aniStickerLottieView.showLastFrame = z19;
        aniStickerLottieView.playFrameFinish = false;
        aniStickerInfo.setResultId(str);
        aniStickerInfo.setSurpriseId(str2);
        if (z18) {
            aniStickerLottieView.randomKey = UUID.randomUUID().toString();
        } else {
            aniStickerLottieView.randomKey = null;
        }
        aniStickerInfo.randomKey = aniStickerLottieView.randomKey;
        builder.localId(i3).placeholderDrawable(i16).stickerInfo(aniStickerInfo).showLoading(z16);
        scheduleSetAniStickerRes(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setAxrLottieDrawableSync(Builder builder) {
        AniStickerLottieView aniStickerLottieView = builder.lottieView;
        AniStickerInfo aniStickerInfo = builder.stickerInfo;
        int i3 = builder.placeholderDrawable;
        BaseLottieResDownloader baseLottieResDownloader = (BaseLottieResDownloader) LottieResDownloadFactory.createLottieResDownloader(1);
        if (baseLottieResDownloader == null) {
            QLog.e(TAG, 2, "lottieResDownloader is null.");
            return;
        }
        if (aniStickerInfo == null) {
            QLog.e(TAG, 2, "stickerInfo is null.");
            return;
        }
        if (isChangeAniSticker(aniStickerLottieView, aniStickerInfo)) {
            return;
        }
        baseLottieResDownloader.setOptions(aniStickerInfo);
        if (!AniStickerLottie.lottieEnabled()) {
            return;
        }
        if (!AniStickerLottieView.isAddPauseCache(aniStickerLottieView, baseLottieResDownloader.getCacheKey())) {
            baseLottieResDownloader.loadLottieRes(builder, new LoadListener(aniStickerInfo, builder, i3) { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ Builder val$builder;
                final /* synthetic */ int val$resDrawable;
                final /* synthetic */ AniStickerInfo val$stickerInfo;

                {
                    this.val$stickerInfo = aniStickerInfo;
                    this.val$builder = builder;
                    this.val$resDrawable = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, AniStickerLottieView.this, aniStickerInfo, builder, Integer.valueOf(i3));
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.download.LoadListener
                public void onFail(Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) th5);
                        return;
                    }
                    QLog.e(AniStickerHelper.TAG, 2, th5, new Object[0]);
                    if (AniStickerHelper.isChangeAniSticker(AniStickerLottieView.this, this.val$stickerInfo)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(AniStickerHelper.TAG, 2, " onFail lottieView is used.");
                        }
                    } else {
                        AniStickerLottieView aniStickerLottieView2 = AniStickerLottieView.this;
                        aniStickerLottieView2.stickerLoadingDrawable = aniStickerLottieView2.getContext().getResources().getDrawable(this.val$resDrawable);
                        AniStickerLottieView.this.invalidate();
                        this.val$builder.callFinish();
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.download.LoadListener
                public void onLottieResLoading(String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                        return;
                    }
                    if (AniStickerHelper.isChangeAniSticker(AniStickerLottieView.this, this.val$stickerInfo)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(AniStickerHelper.TAG, 2, "onLottieResLoading lottieView is used.");
                            return;
                        }
                        return;
                    }
                    AniStickerLottieView aniStickerLottieView2 = AniStickerLottieView.this;
                    aniStickerLottieView2.cacheKey = str;
                    aniStickerLottieView2.addToPendingActions(aniStickerLottieView2);
                    if (QLog.isColorLevel()) {
                        QLog.d(AniStickerHelper.TAG, 2, "lottie res downloading : " + str);
                    }
                    AniStickerLottieView aniStickerLottieView3 = AniStickerLottieView.this;
                    if (aniStickerLottieView3.stickerLoadingDrawable == null) {
                        aniStickerLottieView3.stickerLoadingDrawable = aniStickerLottieView3.getContext().getResources().getDrawable(this.val$resDrawable);
                    }
                    AniStickerLottieView.this.invalidate();
                }

                @Override // com.tencent.mobileqq.emoticonview.download.LoadListener
                public void onSuccess(AXrLottieDrawable aXrLottieDrawable) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aXrLottieDrawable);
                        return;
                    }
                    if (AniStickerHelper.isChangeAniSticker(AniStickerLottieView.this, this.val$stickerInfo)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    AniStickerLottieView aniStickerLottieView2 = AniStickerLottieView.this;
                    if (!aniStickerLottieView2.showLastFrame && aniStickerLottieView2.surpriseId == null) {
                        Builder builder2 = this.val$builder;
                        if (builder2.playLeastTime != null) {
                            aXrLottieDrawable.p0((int) Math.ceil((((float) r3.longValue()) * 1.0f) / ((float) aXrLottieDrawable.Y())));
                        } else {
                            Integer num = builder2.repeatCount;
                            if (num != null) {
                                aXrLottieDrawable.p0(num.intValue());
                            } else {
                                aXrLottieDrawable.p0(-1);
                            }
                        }
                        aXrLottieDrawable.c(true);
                    } else {
                        aXrLottieDrawable.p0(1);
                    }
                    if (this.val$builder.finishRunnable != null) {
                        aXrLottieDrawable.y0(new OnLottieFrameListener() { // from class: com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.3.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                }
                            }

                            @Override // com.tencent.rlottie.OnLottieFrameListener
                            public void onStopOnUi(boolean z16) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                                } else {
                                    AnonymousClass3.this.val$builder.callFinish();
                                }
                            }
                        });
                    } else {
                        AniStickerLottieView.this.addPreAnimatorListener(aXrLottieDrawable);
                    }
                    AniStickerLottieView.this.playLottieAnimation(aXrLottieDrawable);
                    if (QLog.isDevelopLevel()) {
                        QLog.d(AniStickerHelper.TAG, 4, "lottie view playAnimation. cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            });
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addPauseCache no load res.");
        }
    }
}
