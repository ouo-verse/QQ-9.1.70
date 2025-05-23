package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.comic.api.IQQComicSoHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.VasEmojiManagerContstant;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasEngine;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.api.IXADownload;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class VasQuickUpdateManager implements Manager {
    private static final String TAG = "VasQuickUpdateManager";
    public WeakReference<QQAppInterface> appRef;
    private IVasEngine mEngineProxy;
    private BaseUpdateCallback defaultCallback = new DefaultUpdateCallback();
    ConcurrentHashMap<Integer, CallBacker> callBackers = new ConcurrentHashMap<>();
    AtomicInteger mKey = new AtomicInteger(0);

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class DefaultUpdateCallback extends BaseUpdateCallback {
        public DefaultUpdateCallback() {
        }

        private boolean deleteFiles2(long j3, String str, boolean z16) {
            if (j3 == 15) {
                return deleteProfileCard(str).booleanValue();
            }
            if (j3 == 33) {
                String substring = str.substring(12);
                boolean safeDeleteFile = VasUpdateUtil.safeDeleteFile(new File(ProfileCardManager.p(substring)));
                QLog.d(VasQuickUpdateManager.TAG, 2, "deleteFiles: Default Card Config id=" + substring + " ret=" + safeDeleteFile);
                return safeDeleteFile;
            }
            return z16;
        }

        @Nullable
        private Boolean deleteJsonFile(long j3, String str) {
            TagItemInfo itemInfo = getItemInfo(j3, str);
            if (itemInfo != null) {
                boolean safeDeleteFile = VasUpdateUtil.safeDeleteFile(new File(itemInfo.strSavePath));
                if (QLog.isColorLevel()) {
                    QLog.d(VasQuickUpdateManager.TAG, 2, "deleteFiles: bid=" + j3 + " scid=" + str + ", result=" + safeDeleteFile);
                }
                return Boolean.valueOf(safeDeleteFile);
            }
            return Boolean.FALSE;
        }

        @Nullable
        private Boolean deleteMatriel(String str) {
            if (str.equals(IXADownload.SCID)) {
                return Boolean.valueOf(VasUpdateUtil.safeDeleteFile(((IXADownload) QRoute.api(IXADownload.class)).getInstallRoot()));
            }
            if (str.startsWith(VasUpdateConstants.SCID_H5_MAGIC_ZIP)) {
                VasEmojiManagerContstant.delete(str);
                return Boolean.TRUE;
            }
            if (str.equals(VasUpdateConstants.SCID_COMIC_PLAYER_SO)) {
                return Boolean.valueOf(VasUpdateUtil.safeDeleteFile(new File(((IQQComicSoHelper) QRoute.api(IQQComicSoHelper.class)).getComicPlayerSoPath())));
            }
            if (str.equals(VasUpdateConstants.SCID_DEFAULT_FONT)) {
                return Boolean.valueOf(VasUpdateUtil.safeDeleteFile(new File(VasShieldFont.n())));
            }
            if (str.equals(VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS)) {
                String k3 = TroopEnterEffectController.k();
                if (!TextUtils.isEmpty(k3)) {
                    VasUpdateUtil.safeDeleteFile(new File(k3));
                }
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Nullable
        private Boolean deleteProfileCard(String str) {
            if (VasUpdateConstants.SCID_WZRY_TEMPLATE.equals(str)) {
                String c16 = com.tencent.mobileqq.profile.p.c();
                boolean safeDeleteFile = VasUpdateUtil.safeDeleteFile(new File(c16));
                if (QLog.isColorLevel()) {
                    QLog.d(VasQuickUpdateManager.TAG, 2, "deleteFiles: profile card path = " + c16 + " result = " + safeDeleteFile);
                }
                return Boolean.valueOf(safeDeleteFile);
            }
            if (str.startsWith(VasUpdateConstants.SCID_CARD_PREFIX)) {
                return Boolean.valueOf(((ao) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.h(VasQuickUpdateManager.this.getApp().getApp(), Integer.parseInt(str.substring(5, str.length()))));
            }
            return Boolean.FALSE;
        }

        @Nullable
        private Boolean deleteSignature(String str) {
            if (str.startsWith(VasUpdateConstants.SCID_SIGNATURE_STICKER_PREFIX)) {
                String substring = str.substring(18, str.length());
                boolean safeDeleteFile = VasUpdateUtil.safeDeleteFile(new File(VasConstant.SIGNATURE_STICKER_DIR + substring));
                if (QLog.isColorLevel()) {
                    QLog.d(VasQuickUpdateManager.TAG, 2, "deleteFiles: signature sticker path = " + substring + " result = " + safeDeleteFile);
                }
                return Boolean.valueOf(safeDeleteFile);
            }
            return Boolean.FALSE;
        }

        private void doOnCompleted2(long j3, String str, String str2, String str3, int i3, int i16) {
            if (j3 == 15) {
                onProfileCardCompleted(str, str3, i3);
            } else if (j3 == 21) {
                onPokeCompleted(str);
            } else if (j3 == 33) {
                onDefaultCardCompleted(str, i3);
            }
        }

        @NotNull
        private TagItemInfo getBIdJsonInfo(String str, TagItemInfo tagItemInfo) {
            tagItemInfo.bPreConfig = false;
            tagItemInfo.bSaveInDir = false;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(VasQuickUpdateManager.this.getApp().getApplication().getFilesDir());
            String str2 = File.separator;
            sb5.append(str2);
            String sb6 = sb5.toString();
            if (str.equals(VasUpdateConstants.SCID_PENDANT_MARKET_CONFIG)) {
                str = PendantConstant.MARKET_CONFIG_NAME;
            } else if (str.startsWith(VasUpdateConstants.SCID_SIGNATURE_TEMPLATE_CONFIG_PREFIX) && str.endsWith(Sticker.JSON_SUFFIX)) {
                String substring = str.substring(15, str.length() - 5);
                if (QLog.isColorLevel()) {
                    QLog.d(VasQuickUpdateManager.TAG, 2, "getItemInfo signature id = " + substring);
                }
                sb6 = VasConstant.SIGNATURE_TEMPLATE_DIR + str2 + substring + str2;
                str = "config.json";
            }
            tagItemInfo.strSavePath = sb6 + str;
            return tagItemInfo;
        }

        @NotNull
        private TagItemInfo getBidFlashChatInfo(String str, TagItemInfo tagItemInfo) {
            FlashChatManager flashChatManager = (FlashChatManager) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
            tagItemInfo.bPreConfig = false;
            tagItemInfo.bSaveInDir = false;
            tagItemInfo.strSavePath = flashChatManager.j(str);
            if (QLog.isColorLevel()) {
                QLog.d(VasQuickUpdateManager.TAG, 2, "getItemInfo:  result.strSavePath = " + tagItemInfo.strSavePath);
            }
            return tagItemInfo;
        }

        @Nullable
        private TagItemInfo getBidMaterialInfo(String str, TagItemInfo tagItemInfo) {
            tagItemInfo.bPreConfig = false;
            tagItemInfo.bSaveInDir = false;
            if (str.equals(VasUpdateConstants.SCID_STICKER_MATERIAL)) {
                tagItemInfo.strSavePath = EmojiStickerManager.i() + "emojiStickerGuideZip_v2.zip";
            } else if (str.equals(IXADownload.SCID)) {
                tagItemInfo.strSavePath = ((IXADownload) QRoute.api(IXADownload.class)).getDownloadPath().getAbsolutePath();
            } else if (str.startsWith(VasUpdateConstants.SCID_H5_MAGIC_ZIP)) {
                tagItemInfo.strSavePath = VasEmojiManagerContstant.getSavePath(str);
            } else if (str.equals(VasUpdateConstants.SCID_COMIC_PLAYER_SO)) {
                tagItemInfo.strSavePath = ((IQQComicSoHelper) QRoute.api(IQQComicSoHelper.class)).getComicPlayerSoZipPath();
            } else if (str.equals(VasUpdateConstants.SCID_DEFAULT_FONT)) {
                tagItemInfo.strSavePath = FontManagerConstants.FONT_DOWN_LOAD_PATH + File.separator + "default.zip";
            } else if (str.equals(VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS)) {
                String k3 = TroopEnterEffectController.k();
                if (TextUtils.isEmpty(k3)) {
                    QLog.e(VasQuickUpdateManager.TAG, 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS getItemInfo null zipPath");
                    return null;
                }
                tagItemInfo.strSavePath = k3;
            }
            return tagItemInfo;
        }

        @NotNull
        private TagItemInfo getBidPokeInfo(String str, TagItemInfo tagItemInfo) {
            tagItemInfo.bPreConfig = false;
            tagItemInfo.bSaveInDir = true;
            if (str.startsWith(VasUpdateConstants.SCID_POKE_PANEL_PREFIX)) {
                tagItemInfo.strSavePath = com.tencent.mobileqq.activity.aio.item.l.f179489i + str.substring(17, str.length());
            } else if (str.startsWith(VasUpdateConstants.SCID_POKE_EFFECT_PREFIX)) {
                tagItemInfo.strSavePath = com.tencent.mobileqq.activity.aio.item.l.f179489i + str.substring(14, str.length());
            } else if (VasUpdateConstants.SCID_POKE_EFFECT_LIST.equals(str)) {
                tagItemInfo.bSaveInDir = false;
                tagItemInfo.strSavePath = com.tencent.mobileqq.activity.aio.item.l.f179490j;
            }
            return tagItemInfo;
        }

        private boolean getBidProfileCard(String str, TagItemInfo tagItemInfo) {
            if (VasUpdateConstants.SCID_WZRY_TEMPLATE.equals(str)) {
                tagItemInfo.bPreConfig = false;
                tagItemInfo.bSaveInDir = true;
                tagItemInfo.strSavePath = com.tencent.mobileqq.profile.p.c();
                return true;
            }
            if (!str.startsWith(VasUpdateConstants.SCID_CARD_PREFIX)) {
                return false;
            }
            tagItemInfo.bPreConfig = false;
            tagItemInfo.bSaveInDir = false;
            int parseInt = Integer.parseInt(str.substring(5, str.length()));
            ProfileCardManager profileCardManager = ((ao) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i;
            tagItemInfo.strSavePath = ProfileCardManager.u(VasQuickUpdateManager.this.getApp().getApp(), parseInt);
            return true;
        }

        @NotNull
        private TagItemInfo getBidRedPacket(long j3, String str, TagItemInfo tagItemInfo) {
            tagItemInfo.bPreConfig = false;
            if (VasUpdateConstants.SCID_REDPACKET_CONFIG.equals(str) || VasUpdateConstants.SCID_REDPACKET_300CHAR.equals(str)) {
                tagItemInfo.bSaveInDir = false;
                tagItemInfo.strSavePath = VasQuickUpdateManager.this.getApp().getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + str;
            }
            if (VasUpdateConstants.SCID_REDPACKET_FONT_ZIP.equals(str)) {
                tagItemInfo.bSaveInDir = true;
                tagItemInfo.strSavePath = IndividualRedPacketManager.p(3);
            } else if (VasUpdateConstants.SCID_REDPACKET_SPECIAL_ZIP.equals(str)) {
                tagItemInfo.bSaveInDir = true;
                tagItemInfo.strSavePath = IndividualRedPacketManager.p(2);
            } else if (!TextUtils.isEmpty(str) && str.startsWith(VasUpdateConstants.SCID_REDPACKET_PACKETS_ZIP)) {
                tagItemInfo.bSaveInDir = true;
                String s16 = IndividualRedPacketManager.s(str);
                if (TextUtils.isEmpty(s16)) {
                    QLog.d(VasQuickUpdateManager.TAG, 2, "getItemInfo bid = " + j3 + " scid = " + str + " pid = " + s16);
                }
                tagItemInfo.strSavePath = IndividualRedPacketManager.p(1) + s16;
            }
            return tagItemInfo;
        }

        @Nullable
        private Boolean isBubbleExist(String str) {
            BubbleManager bubbleManager = (BubbleManager) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
            if (bubbleManager != null) {
                if (str.startsWith("bubble.android.")) {
                    return Boolean.valueOf(bubbleManager.W(str));
                }
                if (str.startsWith("bubble.paster.")) {
                    return Boolean.valueOf(bubbleManager.V(str));
                }
                return null;
            }
            return null;
        }

        @Nullable
        private Boolean isExist(long j3, String str) {
            if (j3 == 15) {
                return isProfileCardExist(str);
            }
            if (j3 == 21) {
                return isPokeExist(str);
            }
            if (j3 == 1004) {
                return isMaterialExist(str);
            }
            return null;
        }

        @Nullable
        private Boolean isMaterialExist(String str) {
            boolean z16;
            if (str.equals(IXADownload.SCID)) {
                return Boolean.valueOf(((IXADownload) QRoute.api(IXADownload.class)).isNoNeedDownload());
            }
            if (str.equals(VasUpdateConstants.SCID_STICKER_MATERIAL)) {
                return Boolean.valueOf(new File(EmojiStickerManager.i() + "emojiStickerGuideZip_v2.zip").exists());
            }
            if (str.startsWith(VasUpdateConstants.SCID_H5_MAGIC_ZIP)) {
                return Boolean.valueOf(new File(VasEmojiManagerContstant.getSavePath(str)).exists());
            }
            if (str.equals(VasUpdateConstants.SCID_COMIC_PLAYER_SO)) {
                return Boolean.valueOf(new File(((IQQComicSoHelper) QRoute.api(IQQComicSoHelper.class)).getComicPlayerSoPath()).exists());
            }
            if (str.equals(VasUpdateConstants.SCID_DEFAULT_FONT)) {
                File file = new File(VasConstant.INTERNAL_VAS_SO_DIR + VasShieldFont.f32668a);
                if (file.exists() && file.isDirectory()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }
            if (str.equals(VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS)) {
                return VasQuickUpdateManager.this.checkZipExsit();
            }
            return null;
        }

        @Nullable
        private Boolean isPokeExist(String str) {
            int i3;
            int i16;
            boolean z16 = false;
            if (str.startsWith(VasUpdateConstants.SCID_POKE_PANEL_PREFIX)) {
                try {
                    i16 = Integer.valueOf(str.substring(17, str.length())).intValue();
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d(VasQuickUpdateManager.TAG, 2, "id error");
                    }
                    i16 = -1;
                }
                if (i16 != -1) {
                    z16 = com.tencent.mobileqq.activity.aio.item.l.B("effect.gif", i16);
                }
                return Boolean.valueOf(z16);
            }
            if (str.startsWith(VasUpdateConstants.SCID_POKE_EFFECT_PREFIX)) {
                try {
                    i3 = Integer.valueOf(str.substring(14, str.length())).intValue();
                } catch (Exception unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.d(VasQuickUpdateManager.TAG, 2, "id error");
                    }
                    i3 = -1;
                }
                if (i3 != -1) {
                    z16 = com.tencent.mobileqq.activity.aio.item.l.B("bubble", i3);
                }
                return Boolean.valueOf(z16);
            }
            if (VasUpdateConstants.SCID_POKE_EFFECT_LIST.equals(str)) {
                return Boolean.valueOf(new File(com.tencent.mobileqq.activity.aio.item.l.f179490j).exists());
            }
            return null;
        }

        @Nullable
        private Boolean isProfileCardExist(String str) {
            if (VasUpdateConstants.SCID_WZRY_TEMPLATE.equals(str)) {
                return Boolean.valueOf(com.tencent.mobileqq.profile.p.d(str));
            }
            if (str.startsWith(VasUpdateConstants.SCID_CARD_PREFIX)) {
                int parseInt = Integer.parseInt(str.substring(5, str.length()));
                ProfileCardManager profileCardManager = ((ao) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i;
                return Boolean.valueOf(ProfileCardManager.v(VasQuickUpdateManager.this.getApp().getApp(), parseInt));
            }
            return null;
        }

        private boolean isRedPacketExist(String str) {
            String str2;
            File file = null;
            if (!VasUpdateConstants.SCID_REDPACKET_CONFIG.equals(str) && !VasUpdateConstants.SCID_REDPACKET_300CHAR.equals(str)) {
                if (VasUpdateConstants.SCID_REDPACKET_FONT_ZIP.equals(str)) {
                    str2 = IndividualRedPacketManager.x(null, null, 8, 0, 0);
                } else if (VasUpdateConstants.SCID_REDPACKET_SPECIAL_ZIP.equals(str)) {
                    str2 = IndividualRedPacketManager.x(null, null, 25, 0, 0);
                } else {
                    if (!TextUtils.isEmpty(str) && str.startsWith(VasUpdateConstants.SCID_REDPACKET_PACKETS_ZIP)) {
                        String s16 = IndividualRedPacketManager.s(str);
                        if (!TextUtils.isEmpty(s16)) {
                            return VasQuickUpdateManager.this.isResult(s16);
                        }
                    }
                    str2 = null;
                }
            } else {
                str2 = VasQuickUpdateManager.this.getApp().getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + str;
            }
            if (!TextUtils.isEmpty(str2)) {
                file = new File(str2);
            }
            if (file == null || !file.exists()) {
                return false;
            }
            return true;
        }

        @Nullable
        private Boolean isSignatureExist(String str) {
            if (str.startsWith(VasUpdateConstants.SCID_SIGNATURE_STICKER_PREFIX)) {
                return Boolean.valueOf(new File(VasConstant.SIGNATURE_STICKER_DIR + str.substring(18, str.length())).exists());
            }
            return null;
        }

        private void onBubbleCompleted(String str, String str2, String str3, int i3, int i16) {
            BubbleManager bubbleManager = (BubbleManager) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
            if (str.startsWith("bubble.android.")) {
                bubbleManager.h0(str, str2, str3, i3, i16);
            } else if (str.startsWith("bubble.paster.")) {
                bubbleManager.i0(str, str2, str3, i3, i16);
            }
        }

        private void onDefaultCardCompleted(String str, int i3) {
            if (str.startsWith(VasUpdateConstants.SCID_DEFAULT_CARD_CFG_PREFIX)) {
                ProfileCardManager profileCardManager = ((ao) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i;
                int parseInt = Integer.parseInt(str.substring(12));
                profileCardManager.f260001f.remove(Integer.valueOf(parseInt));
                if (i3 == 0) {
                    profileCardManager.q(parseInt, false);
                    return;
                }
                QLog.e(VasQuickUpdateManager.TAG, 2, "onCompleted: default card download error: " + i3 + " scid=" + str);
            }
        }

        private void onFlashChatCompleted(String str, int i3) {
            FlashChatManager flashChatManager = (FlashChatManager) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
            if (flashChatManager != null) {
                flashChatManager.y(str, i3);
            }
        }

        private void onJsonCompleted(String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(VasQuickUpdateManager.TAG, 2, "onCompleted emoji keyword errorCode = " + i3);
            }
            if (i3 == 0) {
                VasQuickUpdateManager.this.onJsonCompleted1(str, i3);
                VasQuickUpdateManager.this.onJsonCompleted2(str);
            }
        }

        private boolean onMaterialCompleted(String str, int i3) {
            boolean z16;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onCompleted sticker material ,errorCode = ");
                sb5.append(i3);
                sb5.append(", app=");
                if (VasQuickUpdateManager.this.getApp() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d(VasQuickUpdateManager.TAG, 2, sb5.toString());
            }
            if (i3 == 0 && str.equals(VasUpdateConstants.SCID_STICKER_MATERIAL)) {
                EmojiStickerManager.h();
            }
            if (str.startsWith(VasUpdateConstants.SCID_H5_MAGIC_ZIP)) {
                ((ao) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308428e.complete(str, i3);
            }
            if (VasQuickUpdateManager.this.onMaterialCompleted2(str, i3)) {
                return true;
            }
            return false;
        }

        private void onPokeCompleted(String str) {
            IEarlyDownloadService iEarlyDownloadService;
            PokeResHandler pokeResHandler;
            if (VasUpdateConstants.SCID_POKE_EFFECT_LIST.equals(str) && (iEarlyDownloadService = (IEarlyDownloadService) VasQuickUpdateManager.this.getApp().getRuntimeService(IEarlyDownloadService.class, "")) != null && (pokeResHandler = (PokeResHandler) iEarlyDownloadService.getEarlyHandler("qq.android.poke.res_0625")) != null) {
                pokeResHandler.M();
            }
        }

        private void onProfileCardCompleted(String str, String str2, int i3) {
            if (VasUpdateConstants.SCID_WZRY_TEMPLATE.equals(str)) {
                com.tencent.mobileqq.profile.p.g(str, str2, i3);
            } else if (str.startsWith(VasUpdateConstants.SCID_CARD_PREFIX)) {
                ((ao) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.x(VasQuickUpdateManager.this.getApp(), str, str2, i3);
            }
        }

        @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
        public boolean deleteFiles(long j3, String str) {
            boolean booleanValue;
            if (j3 != 1000 && j3 != 21 && j3 != 16) {
                if (j3 == 1004) {
                    booleanValue = deleteMatriel(str).booleanValue();
                } else {
                    booleanValue = false;
                }
            } else {
                booleanValue = deleteJsonFile(j3, str).booleanValue();
            }
            boolean deleteFiles2 = deleteFiles2(j3, str, booleanValue);
            QLog.e(VasQuickUpdateManager.TAG, 1, "deleteFiles : bid = " + j3 + " scid = " + str + " result:" + deleteFiles2);
            return deleteFiles2;
        }

        @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
        public void doOnCompleted(long j3, String str, String str2, String str3, int i3, int i16) {
            if (QLog.isColorLevel() || i3 != 0) {
                QLog.d(VasQuickUpdateManager.TAG, 2, "onCompleted bid = " + j3 + " scid = " + str + " from = " + str3 + " errorCode = " + i3 + " httpCode = " + i16);
            }
            if (j3 == 1000) {
                onJsonCompleted(str, i3);
            } else if (j3 == 1004 && onMaterialCompleted(str, i3)) {
                return;
            }
            doOnCompleted2(j3, str, str2, str3, i3, i16);
            VasQuickUpdateManager.this.callBackToAll(j3, str, str2, str3, i3, i16);
        }

        @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
        public void doOnProgress(long j3, String str, String str2, long j16, long j17) {
            if (j3 == 1004 && str.startsWith(VasUpdateConstants.SCID_H5_MAGIC_ZIP)) {
                ((ao) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308428e.onProgress(str, j16, j17);
            }
            if (j3 == 15 && str.startsWith(VasUpdateConstants.SCID_CARD_PREFIX)) {
                ((ao) VasQuickUpdateManager.this.getApp().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.y(Integer.parseInt(str.substring(5, str.length())), (int) ((100 * j16) / j17));
            }
            VasQuickUpdateManager.this.onProgressToAll(j3, str, str2, j16, j17);
        }

        @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
        public long getBID() {
            return 0L;
        }

        @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
        public TagItemInfo getItemInfo(long j3, String str) {
            TagItemInfo tagItemInfo = new TagItemInfo();
            if (j3 == 1000) {
                return getBIdJsonInfo(str, tagItemInfo);
            }
            if (j3 == 16) {
                return getBidRedPacket(j3, str, tagItemInfo);
            }
            if (j3 == 1004) {
                return getBidMaterialInfo(str, tagItemInfo);
            }
            if (j3 == 15) {
                if (getBidProfileCard(str, tagItemInfo)) {
                    return tagItemInfo;
                }
            } else if (j3 == 21) {
                return getBidPokeInfo(str, tagItemInfo);
            }
            if (VasQuickUpdateManager.this.getItemInfo1(j3, str, tagItemInfo)) {
                return tagItemInfo;
            }
            return null;
        }

        @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
        public boolean isFileExists(long j3, String str) {
            if (j3 == 1000) {
                return new File(VasQuickUpdateManager.this.getApp().getApplication().getFilesDir(), str).exists();
            }
            if (j3 == 16) {
                return isRedPacketExist(str);
            }
            if (j3 == 33) {
                return new File(ProfileCardManager.p(str.substring(12))).exists();
            }
            Boolean isExist = isExist(j3, str);
            if (isExist != null) {
                return isExist.booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class TimeoutWrapper implements QueryItemVersionCallback, Runnable {
        private QueryItemCallback callback;
        private AtomicBoolean isDone = new AtomicBoolean(false);
        private WeakReference<QueryItemCallback> weakReference;

        TimeoutWrapper(QueryItemCallback queryItemCallback, boolean z16) {
            if (z16) {
                this.weakReference = new WeakReference<>(queryItemCallback);
            } else {
                this.callback = queryItemCallback;
            }
        }

        private void onResult(int i3, String str, String str2) {
            if (this.isDone.compareAndSet(false, true)) {
                QueryItemCallback queryItemCallback = this.callback;
                if (queryItemCallback != null) {
                    queryItemCallback.onQueryItemVer(i3, str, str2);
                    return;
                }
                QueryItemCallback queryItemCallback2 = this.weakReference.get();
                if (queryItemCallback2 != null) {
                    queryItemCallback2.onQueryItemVer(i3, str, str2);
                }
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback
        public void onQueryItemVer(boolean z16, String str, String str2) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this);
            onResult(!z16 ? 1 : 0, str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            onResult(2, "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class WeakCallbacker extends CallBacker {
        private VasQuickUpdateManager mVasQuickUpdateManager;
        private WeakReference<CallBacker> weakReference;

        public WeakCallbacker(CallBacker callBacker, VasQuickUpdateManager vasQuickUpdateManager) {
            this.weakReference = new WeakReference<>(callBacker);
            this.mVasQuickUpdateManager = vasQuickUpdateManager;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
            CallBacker callBacker = this.weakReference.get();
            if (callBacker != null) {
                callBacker.callback(j3, str, str2, str3, i3, i16);
            } else {
                this.mVasQuickUpdateManager.removeCallBacker(this);
            }
        }

        public boolean isWrapOf(CallBacker callBacker) {
            if (this.weakReference.get() == callBacker) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void onProgress(long j3, String str, String str2, long j16, long j17) {
            CallBacker callBacker = this.weakReference.get();
            if (callBacker != null) {
                callBacker.onProgress(j3, str, str2, j16, j17);
            }
        }
    }

    public VasQuickUpdateManager(QQAppInterface qQAppInterface) {
        this.appRef = null;
        this.appRef = new WeakReference<>(qQAppInterface);
        initEngine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public Boolean checkZipExsit() {
        String k3 = TroopEnterEffectController.k();
        if (TextUtils.isEmpty(k3)) {
            QLog.e(TAG, 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS: get null zipPath");
            return Boolean.FALSE;
        }
        return Boolean.valueOf(new File(k3).exists());
    }

    public static synchronized void cleanCache() {
        synchronized (VasQuickUpdateManager.class) {
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                deleteJSON("VASBiz_FuncDev_webview.json");
                UpdateCallbackSelector.cleanCache(context);
            } else {
                QLog.e(TAG, 1, "cleanCache: null Context");
            }
        }
    }

    public static synchronized void deleteJSON(String str) {
        synchronized (VasQuickUpdateManager.class) {
            File file = new File(BaseApplicationImpl.getApplication().getFilesDir() + File.separator + str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface getApp() {
        WeakReference<QQAppInterface> weakReference = this.appRef;
        if (weakReference == null) {
            return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        QQAppInterface qQAppInterface = weakReference.get();
        if (qQAppInterface != null) {
            return qQAppInterface;
        }
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getItemInfo1(long j3, String str, TagItemInfo tagItemInfo) {
        if (j3 != 33) {
            return false;
        }
        String substring = str.substring(12);
        tagItemInfo.bSaveInDir = false;
        tagItemInfo.bPreConfig = false;
        tagItemInfo.strSavePath = ProfileCardManager.p(substring);
        return true;
    }

    private void initEngine() {
        QLog.e(TAG, 1, "initEngine: " + this);
        QRoute.api(IVasBusinessManager.class);
        this.mEngineProxy = (IVasEngine) getApp().getRuntimeService(IVasEngine.class, "");
        new WeakReference(getApp());
        UpdateCallbackSelector.setDefaultCallback(this.defaultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isResult(String str) {
        File file = null;
        boolean z16 = false;
        String x16 = IndividualRedPacketManager.x(str, null, 24, 0, 0);
        if (!TextUtils.isEmpty(x16)) {
            file = new File(x16);
        }
        if (file != null && file.exists() && file.isDirectory() && file.list() != null && file.list().length > 1) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isFileExists VasUpdateConstants.SCID_REDPACKET_PACKETS_ZIP result = " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onJsonCompleted1(String str, int i3) {
        if (str.equals(VasUpdateConstants.SCID_EMOJI_KEYWORD)) {
            IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) getApp().getRuntimeService(IEmoticonManagerService.class);
            if (iEmoticonManagerService != null) {
                iEmoticonManagerService.parseCloudKeywordsJson();
                return;
            }
            return;
        }
        if (str.startsWith(VasUpdateConstants.SCID_SIGNATURE_TEMPLATE_CONFIG_PREFIX)) {
            VasUtils.c(getApp());
            return;
        }
        if (VasUpdateConstants.SCID_CHANGEVOICE.equals(str)) {
            ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).preCheckData(null, null, getApp());
            return;
        }
        if (VasUpdateConstants.SCID_BLESS_VOICECHANGE.equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onCompleted blessVoiceChange ,errorCode = " + i3);
                return;
            }
            return;
        }
        if (VasUpdateConstants.SCID_PERSONAL_CONFIG.equals(str)) {
            VipGrayConfigHelper.getsInstance().parseJson(getApp(), true);
            ClubContentJsonTask.getPersonalCardUrlInfo(getApp());
            com.tencent.mobileqq.vip.b.c().i(getApp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onJsonCompleted2(String str) {
        if (VasUpdateConstants.SCID_PRAISE_CONFIG.equals(str)) {
            com.tencent.mobileqq.profile.like.c.a(getApp());
            return;
        }
        if (VasUpdateConstants.SCID_DIY_CARD_CONFIG.equals(str)) {
            com.tencent.mobileqq.profile.diy.b.a(getApp());
            return;
        }
        if ("VASBiz_FuncDev_webview.json".equals(str)) {
            AuthorizeConfig.y().c0();
            return;
        }
        if (VasUpdateConstants.SCID_KANDIAN_RECOMMENT_EMOTICON.equals(str)) {
            com.tencent.mobileqq.emosm.o oVar = (com.tencent.mobileqq.emosm.o) getApp().getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
            if (oVar != null) {
                oVar.k();
                return;
            }
            return;
        }
        if (VasUpdateConstants.SCID_ENTER_EFFECT_CONFIG.equals(str)) {
            ((ITroopEnterEffectService) getApp().getRuntimeService(ITroopEnterEffectService.class, "all")).readEffectConfigData(false);
        } else if (VasUpdateConstants.SCID_SYSTEM_EMOJI_WHITE_LIST.equals(str)) {
            SystemEmoticonInfo.parseWhiteList(getApp(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onMaterialCompleted2(String str, int i3) {
        if (str.equals(VasUpdateConstants.SCID_COMIC_PLAYER_SO)) {
            ((IQQComicSoHelper) QRoute.api(IQQComicSoHelper.class)).onSoDownloadCompleted(getApp(), i3);
        } else if (str.equals(IXADownload.SCID)) {
            ((IXADownload) QRoute.api(IXADownload.class)).onComplete(i3);
        } else if (str.equals(VasUpdateConstants.SCID_DEFAULT_FONT)) {
            VasShieldFont.u(getApp(), i3);
        } else if (str.equals(VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS) && i3 == 0) {
            String k3 = TroopEnterEffectController.k();
            String j3 = TroopEnterEffectController.j();
            if (!TextUtils.isEmpty(k3) && !TextUtils.isEmpty(j3)) {
                try {
                    FileUtils.uncompressZip(k3, j3, false);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS onCompleted error", e16);
                }
            } else {
                QLog.e(TAG, 1, "VasUpdateConstants.SCID_ENTER_EFFECT_VIP_ICONS onComplete null path: " + k3 + "," + j3);
                return true;
            }
        }
        return false;
    }

    public void addCallBacker(CallBacker callBacker) {
        if (callBacker != null && !this.callBackers.containsValue(callBacker)) {
            int addAndGet = this.mKey.addAndGet(1);
            this.callBackers.put(Integer.valueOf(addAndGet), callBacker);
            callBacker.key = addAndGet;
        }
    }

    public void addWeakCallback(CallBacker callBacker) {
        for (CallBacker callBacker2 : this.callBackers.values()) {
            if ((callBacker2 instanceof WeakCallbacker) && ((WeakCallbacker) callBacker2).isWrapOf(callBacker)) {
                return;
            }
        }
        WeakCallbacker weakCallbacker = new WeakCallbacker(callBacker, this);
        addCallBacker(weakCallbacker);
        callBacker.key = weakCallbacker.key;
    }

    public void callBackToAll(long j3, String str, String str2, String str3, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "callBackToAll Error bid = " + j3 + ", cfgScid=" + str2 + ",scid = " + str + ", from = " + str3 + ", errorCode = " + i3);
            return;
        }
        Iterator<CallBacker> it = this.callBackers.values().iterator();
        while (it.hasNext()) {
            it.next().callback(j3, str, str2, str3, i3, i16);
        }
    }

    public void cancelDwonloadItem(long j3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cancelDwonloadItem bid = " + j3 + " scid = " + str);
        }
        IVasEngine iVasEngine = this.mEngineProxy;
        if (iVasEngine != null) {
            iVasEngine.cancelDwonloadItem(j3, str);
        }
    }

    public void downloadGatherItem(long j3, String str, String[] strArr, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "downloadGatherItem bid = " + j3 + " scid = " + str + " scidList = " + TextUtils.join(",", strArr) + " from = " + str2);
        }
        IVasEngine iVasEngine = this.mEngineProxy;
        if (iVasEngine != null) {
            iVasEngine.downloadGatherItem(j3, str, strArr, str2);
        }
    }

    public void downloadItem(long j3, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "downloadItem bid = " + j3 + " scid = " + str + " from = " + str2);
        }
        IVasEngine iVasEngine = this.mEngineProxy;
        if (iVasEngine != null) {
            iVasEngine.downloadItem(j3, str, str2);
        }
    }

    public IVasEngine getVasEngine() {
        return this.mEngineProxy;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        QLog.e(TAG, 1, "onDestroy: " + this);
        UpdateCallbackSelector.unsetDefaultCallback(this.defaultCallback);
        this.callBackers.clear();
        this.appRef = null;
    }

    public void onProgressToAll(long j3, String str, String str2, long j16, long j17) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "callBackToAll Error bid = " + j3 + ", cfgScid=" + str2 + ",scid = " + str);
            return;
        }
        Iterator<CallBacker> it = this.callBackers.values().iterator();
        while (it.hasNext()) {
            it.next().onProgress(j3, str, str2, j16, j17);
        }
    }

    public void queryItemVersion(int i3, String str, boolean z16, boolean z17, long j3, QueryItemCallback queryItemCallback) {
        if (this.mEngineProxy != null) {
            TimeoutWrapper timeoutWrapper = new TimeoutWrapper(queryItemCallback, z17);
            if (j3 > 0) {
                ThreadManager.getSubThreadHandler().postDelayed(timeoutWrapper, j3);
            }
            this.mEngineProxy.queryItemVersion(i3, str, z16, timeoutWrapper);
            return;
        }
        queryItemCallback.onQueryItemVer(2, "", "");
    }

    public void removeCallBacker(CallBacker callBacker) {
        if (callBacker == null) {
            return;
        }
        this.callBackers.remove(Integer.valueOf(callBacker.key));
    }
}
