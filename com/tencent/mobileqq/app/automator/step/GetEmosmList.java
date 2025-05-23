package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetEmosmList extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public GetEmosmList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("GetEmosmList", 2, "getEmosmList start int QQInitHandler...");
        }
        SharedPreferences sharedPreferences = ((Automator) this.mAutomator).E.getApp().getSharedPreferences(QVipStickerProcessor.PREF_STICKER_NAME, 0);
        String currentAccountUin = ((Automator) this.mAutomator).E.getCurrentAccountUin();
        QVipStickerProcessor.sEnableSticker = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt("is_sticker_enable_" + currentAccountUin, -1);
        if (sharedPreferences.getBoolean("sticker_switch_" + currentAccountUin, true) && EmojiStickerManager.g()) {
            z16 = true;
        } else {
            z16 = false;
        }
        EmojiStickerManager.f204583t = z16;
        QVipStickerProcessor.sStickerMaxSendNum = sharedPreferences.getInt("sticker_max_send_num_" + currentAccountUin, QVipStickerProcessor.STICKER_MAX_COUNT);
        QVipStickerProcessor.sStickerMaxShowNum = sharedPreferences.getInt("sticker_max_show_num_" + currentAccountUin, QVipStickerProcessor.STICKER_MAX_COUNT);
        EmojiStickerManager.A = ah.k0();
        EmojiStickerManager.G = sharedPreferences.getLong("sticker_update_version_time_" + currentAccountUin, 0L);
        QLog.i("GetEmosmList", 1, String.format("Sticker config, switch %b, maxSendNum: %d, isRubbishMachine: %b, updateVersionTime: %d", Boolean.valueOf(EmojiStickerManager.f204583t), Integer.valueOf(QVipStickerProcessor.sStickerMaxSendNum), Boolean.valueOf(EmojiStickerManager.A), Long.valueOf(EmojiStickerManager.G)));
        if (EmojiStickerManager.G == 0) {
            long serverTime = NetConnInfoCenter.getServerTime();
            sharedPreferences.edit().putLong("sticker_update_version_time_" + currentAccountUin, serverTime).apply();
            EmojiStickerManager.G = serverTime;
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) ((Automator) this.mAutomator).E.getRuntimeService(IEmoticonManagerService.class);
        SharedPreferences sharedPreferences2 = ((Automator) this.mAutomator).E.getApplication().getSharedPreferences("mobileQQ", 0);
        if (!Boolean.valueOf(sharedPreferences2.getBoolean("emosm_has_set_emosmpackage_valid_" + ((Automator) this.mAutomator).E.getCurrentAccountUin(), false)).booleanValue()) {
            List<EmoticonPackage> syncGetTabEmoticonPackages = iEmoticonManagerService.syncGetTabEmoticonPackages();
            if (syncGetTabEmoticonPackages != null) {
                Iterator<EmoticonPackage> it = syncGetTabEmoticonPackages.iterator();
                while (it.hasNext()) {
                    it.next().valid = true;
                }
                iEmoticonManagerService.saveEmoticonPackages(syncGetTabEmoticonPackages);
            }
            sharedPreferences2.edit().putBoolean("emosm_has_set_emosmpackage_valid_" + ((Automator) this.mAutomator).E.getCurrentAccountUin(), true).commit();
        }
        Boolean valueOf = Boolean.valueOf(sharedPreferences2.getBoolean("emosm_has_download_emosmpackage_tag_" + ((Automator) this.mAutomator).E.getCurrentAccountUin(), false));
        Boolean valueOf2 = Boolean.valueOf(sharedPreferences2.getBoolean("emosm_has_download_emosmpackage_kandian_tag_" + ((Automator) this.mAutomator).E.getCurrentAccountUin(), false));
        if (QLog.isColorLevel()) {
            QLog.d("GetEmosmList", 2, "kandianOidbFlag kandianOidbFlag int oidbFlag..." + valueOf);
        }
        if (QLog.isColorLevel()) {
            QLog.d("GetEmosmList", 2, "kandianOidbFlag kandianOidbFlag int kandianOidbFlag..." + valueOf2);
        }
        com.tencent.mobileqq.emosm.o oVar = (com.tencent.mobileqq.emosm.o) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
        if (valueOf.booleanValue()) {
            oVar.y1(0, 0);
        } else {
            oVar.H1(0);
        }
        if (valueOf2.booleanValue()) {
            oVar.c(0, 0, 1, 0);
            return 7;
        }
        oVar.H1(1);
        return 7;
    }
}
