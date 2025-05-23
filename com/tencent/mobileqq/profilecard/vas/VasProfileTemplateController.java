package com.tencent.mobileqq.profilecard.vas;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.diy.a;
import com.tencent.mobileqq.profile.p;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplateCheckUtils;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.profilecard.IProfileTemplateController;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class VasProfileTemplateController implements IProfileTemplateController {
    public static final boolean DELETE_WZRY = ar.b("kenaiyu", "2024-03-18", "vas_feature_delete_wzry_card").isEnable(true);
    private static final int MAX_TRY_DOWNLOAD_TIMES = 3;
    private static final String TAG = "ProfileTemplateCheckController";
    private final Context mContext;
    private boolean mHasDownloadWZRYTemplate;
    private final Function0<Unit> mUpdateCallback;
    public boolean updateBG;
    public boolean updateDiyText;
    public boolean updateStyle;
    private boolean mFirstCheckTemplate = true;
    private int mDownloadProfileResTimes = 0;
    private AtomicBoolean mIsDownloadTemplateRunning = new AtomicBoolean(false);
    private final QQAppInterface mApp = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class DownloadTemplateRunnable implements Runnable {
        private Runnable endCallback;
        private long mBackgroundId;
        private String mBackgroundUrl;
        private WeakReference<ProfileCardTemplate> mCardTemplateRef;
        private AtomicBoolean mIsRunning;

        DownloadTemplateRunnable(ProfileCardTemplate profileCardTemplate, AtomicBoolean atomicBoolean, String str, long j3, Runnable runnable) {
            this.mCardTemplateRef = new WeakReference<>(profileCardTemplate);
            this.mIsRunning = atomicBoolean;
            this.mBackgroundUrl = str;
            this.mBackgroundId = j3;
            this.endCallback = runnable;
        }

        private boolean isExistsTemplateDir(AppRuntime appRuntime, boolean z16) {
            String e16;
            boolean z17;
            if (!z16 && (e16 = ProfileCardTemplateUtil.e(-1L)) != null) {
                File file = new File(e16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(e16);
                String str = File.separator;
                sb5.append(str);
                sb5.append("config_black.json");
                File file2 = new File(sb5.toString());
                if (file.isDirectory() && file2.exists()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(VasProfileTemplateController.TAG, 2, "DownloadTemplateRunnable template already exists");
                    }
                    return true;
                }
                File file3 = new File(e16 + ".zip");
                if (file3.exists()) {
                    file3.delete();
                }
                g gVar = new g("https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip", file3);
                gVar.S = "profileCardDownload";
                gVar.R = "VIP_profilecard";
                int o16 = DownloaderFactory.o(gVar, appRuntime);
                if (o16 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    try {
                        FileUtils.uncompressZip(file3.getAbsolutePath(), e16 + str, false);
                        if (ProfileCardTemplateUtil.j()) {
                            file3.delete();
                            z16 = true;
                        }
                    } catch (Throwable th5) {
                        QLog.e(VasProfileTemplateController.TAG, 1, "DownloadTemplateRunnable unzip fail.", th5);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(VasProfileTemplateController.TAG, 2, String.format("DownloadTemplateRunnable download template resultCode=%s isExistsTemplateDir=%s", Integer.valueOf(o16), Boolean.valueOf(z16)));
                    return z16;
                }
                return z16;
            }
            return z16;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004c A[Catch: all -> 0x00f6, TryCatch #0 {all -> 0x00f6, blocks: (B:3:0x0005, B:5:0x000e, B:7:0x0012, B:9:0x001a, B:11:0x0025, B:12:0x002b, B:18:0x0046, B:20:0x004c, B:22:0x0066, B:24:0x0088, B:27:0x0093, B:29:0x0099, B:32:0x00b2, B:34:0x00bc, B:35:0x00eb, B:36:0x0040, B:37:0x00f0), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[Catch: all -> 0x00f6, TryCatch #0 {all -> 0x00f6, blocks: (B:3:0x0005, B:5:0x000e, B:7:0x0012, B:9:0x001a, B:11:0x0025, B:12:0x002b, B:18:0x0046, B:20:0x004c, B:22:0x0066, B:24:0x0088, B:27:0x0093, B:29:0x0099, B:32:0x00b2, B:34:0x00bc, B:35:0x00eb, B:36:0x0040, B:37:0x00f0), top: B:2:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00bc A[Catch: all -> 0x00f6, TryCatch #0 {all -> 0x00f6, blocks: (B:3:0x0005, B:5:0x000e, B:7:0x0012, B:9:0x001a, B:11:0x0025, B:12:0x002b, B:18:0x0046, B:20:0x004c, B:22:0x0066, B:24:0x0088, B:27:0x0093, B:29:0x0099, B:32:0x00b2, B:34:0x00bc, B:35:0x00eb, B:36:0x0040, B:37:0x00f0), top: B:2:0x0005 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            WeakReference<ProfileCardTemplate> weakReference;
            boolean M;
            boolean z16;
            try {
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                if (waitAppRuntime != null && (weakReference = this.mCardTemplateRef) != null && weakReference.get() != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.d(VasProfileTemplateController.TAG, 2, "DownloadTemplateRunnable start");
                    }
                    boolean j3 = ProfileCardTemplateUtil.j();
                    long j16 = this.mBackgroundId;
                    if (j16 != 160 && j16 != 1600) {
                        M = true;
                        if (QLog.isColorLevel()) {
                            QLog.d(VasProfileTemplateController.TAG, 2, String.format("DownloadTemplateRunnable start isExistsTemplateDir=%s isExistBgResource=%s", Boolean.valueOf(j3), Boolean.valueOf(M)));
                        }
                        if (!M) {
                            g gVar = new g(this.mBackgroundUrl, new File(ProfileCardUtil.u(this.mBackgroundUrl)));
                            gVar.S = "profileCardDownload";
                            gVar.R = "VIP_profilecard";
                            int o16 = DownloaderFactory.o(gVar, waitAppRuntime);
                            if (o16 == 0 && ProfileCardUtil.M(this.mBackgroundUrl)) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(VasProfileTemplateController.TAG, 2, String.format("DownloadTemplateRunnable download bg resultBgCode=%s isExistBgResource=%s", Integer.valueOf(o16), Boolean.valueOf(z16)));
                            }
                            M = z16;
                        }
                        boolean isExistsTemplateDir = isExistsTemplateDir(waitAppRuntime, j3);
                        if (QLog.isColorLevel()) {
                            QLog.d(VasProfileTemplateController.TAG, 2, String.format("DownloadTemplateRunnable end isExistsTemplateDir=%s isExistBgResource=%s", Boolean.valueOf(isExistsTemplateDir), Boolean.valueOf(M)));
                            QLog.d(VasProfileTemplateController.TAG, 2, String.format("DownloadTemplateRunnable end timeCost=%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                        }
                        this.endCallback.run();
                    }
                    M = ProfileCardUtil.M(this.mBackgroundUrl);
                    if (QLog.isColorLevel()) {
                    }
                    if (!M) {
                    }
                    boolean isExistsTemplateDir2 = isExistsTemplateDir(waitAppRuntime, j3);
                    if (QLog.isColorLevel()) {
                    }
                    this.endCallback.run();
                }
                this.mIsRunning.set(false);
            } catch (Throwable th5) {
                QLog.e(VasProfileTemplateController.TAG, 1, "DownloadTemplateRunnable fail.", th5);
                this.mIsRunning.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class WeakCallBacker extends CallBacker {
        private final WeakReference<VasProfileTemplateController> weakController;

        public WeakCallBacker(VasProfileTemplateController vasProfileTemplateController) {
            this.weakController = new WeakReference<>(vasProfileTemplateController);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
            QLog.e(VasProfileTemplateController.TAG, 1, "downloadProfileCardRes " + j3 + " scid:" + str);
            VasProfileTemplateController vasProfileTemplateController = this.weakController.get();
            if (vasProfileTemplateController != null) {
                vasProfileTemplateController.onUpdateCard();
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((IVasQuickUpdateService) peekAppRuntime.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this);
            }
        }
    }

    public VasProfileTemplateController(Activity activity, Function0<Unit> function0) {
        this.mUpdateCallback = function0;
        this.mContext = activity;
    }

    private void checkDynamicRes(Card card, ProfileCardTemplate profileCardTemplate) {
        String str = card.backgroundUrl;
        int i3 = card.dynamicCardFlag;
        long j3 = card.lCurrentBgId;
        if (i3 == 1) {
            boolean w3 = ProfileCardManager.w(this.mContext, j3, ".dynamic");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("onCardUpdate dynamicBackgroundExist=%s", Boolean.valueOf(w3)));
            }
            if (!w3 && tryDownload()) {
                downloadProfileCardRes(str, j3, profileCardTemplate);
            }
        }
    }

    private void checkSimpleRes(Card card) {
        if (card.lCurrentStyleId != ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) {
            return;
        }
        final int i3 = card.diyTextFontId;
        if (!isFontDownloaded(i3)) {
            final IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) this.mApp.getRuntimeService(IVasQuickUpdateService.class, "");
            iVasQuickUpdateService.addCallBacker(new CallBacker() { // from class: com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController.1
                @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
                public void callback(long j3, String str, String str2, String str3, int i16, int i17) {
                    if (VasProfileTemplateController.this.isThisFont(j3, str, i3)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(VasProfileTemplateController.TAG, 2, String.format("onCardUpdate DIY text font download,  errorCode=%s httpCode=%s", Integer.valueOf(i16), Integer.valueOf(i17)));
                        }
                        if (i16 == 0) {
                            VasProfileTemplateController.this.onUpdateCard();
                        }
                        iVasQuickUpdateService.removeCallBacker(this);
                    }
                }
            });
            iVasQuickUpdateService.downloadItem(5L, VasUpdateConstants.SCID_DIY_CARD_FONT_PREFIX + i3, TAG);
        }
    }

    private void checkWzryRes(Card card, ProfileCardTemplate profileCardTemplate) {
        String str = card.backgroundUrl;
        long j3 = card.lCurrentBgId;
        if (card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) {
            boolean w3 = ProfileCardManager.w(this.mContext, j3, "wzMainImage.png");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("onCardUpdate heroFileExist=%s", Boolean.valueOf(w3)));
            }
            if (!w3 && tryDownload()) {
                downloadProfileCardRes(str, j3, profileCardTemplate);
            }
        }
        long j16 = card.lCurrentStyleId;
        if (j16 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC || j16 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) {
            boolean d16 = p.d(VasUpdateConstants.SCID_WZRY_TEMPLATE);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("onCardUpdate heroTemplateExist=%s", Boolean.valueOf(d16)));
            }
            if (!this.mHasDownloadWZRYTemplate && !d16) {
                p.a(new CallBacker() { // from class: com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController.2
                    @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
                    public void callback(long j17, String str2, String str3, String str4, int i3, int i16) {
                        if (j17 == 15 && VasUpdateConstants.SCID_WZRY_TEMPLATE.equals(str2)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(VasProfileTemplateController.TAG, 2, String.format("onCardUpdate WZRY template download,  errorCode=%s httpCode=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
                            }
                            VasProfileTemplateController.this.onUpdateCard();
                            ((IVasQuickUpdateService) VasProfileTemplateController.this.mApp.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this);
                        }
                    }
                });
                this.mHasDownloadWZRYTemplate = true;
            }
        }
    }

    private void downloadProfileCardRes(String str, long j3, ProfileCardTemplate profileCardTemplate) {
        WeakCallBacker weakCallBacker;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("downloadProfileCardRes bgUrl=%s bgId=%s mIsDownloadTemplateRunning=%s", str, Long.valueOf(j3), this.mIsDownloadTemplateRunning));
        }
        if (j3 != 160 && j3 != 1600) {
            ProfileCardManager profileCardManager = ((ao) this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i;
            if (VasNormalToggle.VAS_BUG_PROFILE_CARD_FIRST.isEnable(true)) {
                weakCallBacker = new WeakCallBacker(this);
            } else {
                weakCallBacker = null;
            }
            profileCardManager.k(this.mApp, VasUpdateConstants.SCID_CARD_PREFIX + j3, weakCallBacker);
        }
        if (!this.mIsDownloadTemplateRunning.get()) {
            this.mIsDownloadTemplateRunning.set(true);
            ThreadManagerV2.excute(new DownloadTemplateRunnable(profileCardTemplate, this.mIsDownloadTemplateRunning, str, j3, new Runnable() { // from class: com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController.3
                @Override // java.lang.Runnable
                public void run() {
                    VasProfileTemplateController.this.onUpdateCard();
                }
            }), 128, null, true);
        }
    }

    private boolean isBackgroundResExist(Card card) {
        boolean M;
        long j3 = card.lCurrentStyleId;
        String str = card.backgroundUrl;
        int i3 = card.dynamicCardFlag;
        long j16 = card.lCurrentBgId;
        boolean j17 = ProfileCardTemplateUtil.j();
        if (j16 != 160 && j16 != 1600) {
            if (i3 == 1) {
                M = ProfileCardManager.w(this.mContext, j16, "dynamicBottom.jpg");
                if (!M) {
                    M = new File(ProfileCardManager.n(this.mContext, j3, j16)).exists();
                }
            } else {
                M = new File(ProfileCardManager.n(this.mContext, j3, j16)).exists();
            }
        } else {
            M = ProfileCardUtil.M(str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("onCardUpdate commonDirExist=%s backgroundImageExist=%s", Boolean.valueOf(j17), Boolean.valueOf(M)));
        }
        if (j17 && M) {
            return true;
        }
        return false;
    }

    private boolean isFontDownloaded(int i3) {
        String[] strArr;
        File file = new File(a.f260152a + i3);
        if (file.exists() && file.isDirectory()) {
            strArr = file.list();
        } else {
            strArr = null;
        }
        if (file.exists() && strArr != null && strArr.length > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isThisFont(long j3, String str, int i3) {
        if (5 == j3 && str.startsWith(VasUpdateConstants.SCID_DIY_CARD_FONT_PREFIX)) {
            return String.valueOf(i3).equals(str.substring(21, str.length()));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateCard() {
        this.mUpdateCallback.invoke();
    }

    private void setUpdateParams(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo, Card card) {
        Card card2 = profileCardInfo.card;
        if (card2 != null) {
            if (TextUtils.isEmpty(card2.backgroundUrl)) {
                if (!TextUtils.isEmpty(card.backgroundUrl)) {
                    this.updateBG = true;
                }
            } else if (!profileCardInfo.card.backgroundUrl.equals(card.backgroundUrl)) {
                this.updateBG = true;
            }
            if (profileCardInfo.curUseStyleId != card.lCurrentStyleId || profileCardInfo.curUseTemplateVersion != ProfileTemplateApi.getTemplateManager(iComponentCenter).getDiyTemplateVersion(card)) {
                this.updateStyle = true;
            }
            if (profileCardInfo.card.lCurrentStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE && !TextUtils.isEmpty(card.diyText)) {
                this.updateDiyText = true;
            }
        }
    }

    private boolean tryDownload() {
        int i3 = this.mDownloadProfileResTimes;
        if (i3 > 3) {
            return false;
        }
        this.mDownloadProfileResTimes = i3 + 1;
        return true;
    }

    private void updateTemplateInfo(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo, Card card) {
        long j3 = card.lCurrentStyleId;
        int i3 = card.templateRet;
        String str = card.backgroundUrl;
        long j16 = card.backgroundColor;
        long j17 = card.lCurrentBgId;
        ProfileCardTemplate i16 = ProfileCardTemplateUtil.i(j3, true);
        if (j3 > 0 && i16 != null && !TextUtils.isEmpty(str) && i3 == 0) {
            if (isBackgroundResExist(card)) {
                if (ProfileTemplateApi.getTemplateUtils(iComponentCenter).initTemplateConfig(i16, j16, j3)) {
                    profileCardInfo.currentTemplate = i16;
                    checkDynamicRes(card, i16);
                    checkWzryRes(card, i16);
                    return;
                }
                profileCardInfo.currentTemplate = null;
                return;
            }
            if (tryDownload()) {
                downloadProfileCardRes(str, j17, i16);
                return;
            } else {
                profileCardInfo.currentTemplate = null;
                return;
            }
        }
        profileCardInfo.currentTemplate = null;
    }

    @Override // com.tencent.mobileqq.vas.profilecard.IProfileTemplateController
    public boolean onCardUpdate(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        Card card = profileCardInfo.card;
        this.updateBG = false;
        this.updateStyle = false;
        this.updateDiyText = false;
        if (DELETE_WZRY) {
            long j3 = card.lCurrentStyleId;
            if (j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC || j3 == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC) {
                VasCommonReporter.getHistoryFeature("card_wzry").setValue2("show").setNum1(card.lCurrentBgId).report(false);
                card.lCurrentStyleId = ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE;
            }
        }
        setUpdateParams(iComponentCenter, profileCardInfo, card);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("onCardUpdate updateBG=%s updateStyle=%s updateDiyText=%s", Boolean.valueOf(this.updateBG), Boolean.valueOf(this.updateStyle), Boolean.valueOf(this.updateDiyText)));
        }
        profileCardInfo.card = card;
        if (this.mFirstCheckTemplate || this.updateBG || this.updateStyle) {
            this.mFirstCheckTemplate = false;
            try {
                updateTemplateInfo(iComponentCenter, profileCardInfo, card);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "onCardUpdate fail.", th5);
                profileCardInfo.currentTemplate = null;
            }
        }
        if (this.updateDiyText) {
            checkSimpleRes(card);
        }
        VasProfileTemplateCheckUtils.checkCurrentUseTemplate(iComponentCenter, profileCardInfo);
        QLog.i(TAG, 1, "updateBG:" + this.updateBG + " updateStyle:" + this.updateStyle + " updateDiyText:" + this.updateDiyText);
        if (!this.updateBG && !this.updateStyle && !this.updateDiyText) {
            return false;
        }
        return true;
    }
}
