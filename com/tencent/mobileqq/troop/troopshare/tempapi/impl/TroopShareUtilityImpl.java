package com.tencent.mobileqq.troop.troopshare.tempapi.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.share.b;
import com.tencent.mobileqq.troop.troopsetting.share.qrcode.QRCodeShareManager;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopshare.e;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopShareUtilityImpl implements ITroopShareUtility {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopShareUtilityImpl";
    private e mTroopShare;

    public TroopShareUtilityImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public String getTroopShareDescDefaultWording() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("102746", new byte[0]);
        String str = "\u5728\u8fd9\u91cc\uff0c\u53d1\u73b0\u66f4\u591a~";
        if (loadRawConfig.length == 0) {
            QLog.d(TAG, 1, "getTroopShareDescDefaultWording configBytes is empty!");
            return "\u5728\u8fd9\u91cc\uff0c\u53d1\u73b0\u66f4\u591a~";
        }
        String str2 = new String(loadRawConfig, StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str2)) {
            return "\u5728\u8fd9\u91cc\uff0c\u53d1\u73b0\u66f4\u591a~";
        }
        try {
            str = new JSONObject(str2).optString("troopShareDescDefaultWording", "\u5728\u8fd9\u91cc\uff0c\u53d1\u73b0\u66f4\u591a~");
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "getTroopShareDescDefaultWording JSONException: " + e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getTroopShareDescDefaultWording config:" + str2 + ", remoteValue:" + str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public void handleTroopLinkShare(TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopInfoData);
            return;
        }
        e eVar = this.mTroopShare;
        if (eVar != null) {
            eVar.H(troopInfoData, Boolean.FALSE);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public void initTroopShareUtility(Activity activity, TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) troopInfoData);
            return;
        }
        if (this.mTroopShare != null) {
            onDestroy();
        }
        if (activity instanceof QBaseActivity) {
            this.mTroopShare = new e((QBaseActivity) activity, troopInfoData);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public void newTroopShareUtility(Activity activity, TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) troopInfoData);
        } else {
            this.mTroopShare = new e((QBaseActivity) activity, troopInfoData);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        e eVar = this.mTroopShare;
        if (eVar == null) {
            return;
        }
        eVar.O();
        this.mTroopShare = null;
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public void showQRCodeSharePanel(QBaseActivity qBaseActivity, TroopInfoData troopInfoData, Bitmap bitmap, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, qBaseActivity, troopInfoData, bitmap, str);
        } else {
            QRCodeShareManager.INSTANCE.a().d(new b(qBaseActivity, troopInfoData, bitmap, str));
        }
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public void showTroopIDCardSharePanel(QBaseActivity qBaseActivity, TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qBaseActivity, (Object) troopInfoData);
        } else {
            TroopSettingShareManager.INSTANCE.a().F(new b(qBaseActivity, troopInfoData), "group_idcard");
        }
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public void startTroop2DCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        e eVar = this.mTroopShare;
        if (eVar != null) {
            eVar.b0();
        }
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public void troopUtils_shareTroop(Activity activity, TroopInfoData troopInfoData, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, troopInfoData, appInterface);
        } else {
            this.mTroopShare = TroopUtils.Q((QBaseActivity) activity, troopInfoData, (QQAppInterface) appInterface, Boolean.FALSE);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility
    public void troopUtils_shareTroopFromAIO(Activity activity, TroopInfoData troopInfoData, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, activity, troopInfoData, appInterface);
        } else {
            this.mTroopShare = TroopUtils.Q((QBaseActivity) activity, troopInfoData, (QQAppInterface) appInterface, Boolean.TRUE);
        }
    }
}
