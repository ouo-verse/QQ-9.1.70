package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h implements C2CMessageManager.a {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void m(MessageRecord messageRecord, BaseMessageManager.a aVar, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("EcShopAssistantManager", 2, "ecshop new msg puin: " + messageRecord.senderuin + ", inter_num: " + messageRecord.getExtInfoFromExtStr("inter_num"));
        }
        String f16 = ao.f(str, i3);
        if (aVar.f116302g.containsKey(f16)) {
            aVar.f116302g.get(f16).add(messageRecord);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(messageRecord);
        aVar.f116302g.put(f16, arrayList);
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public void a(AppRuntime appRuntime, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) appRuntime, (Object) messageRecord);
        }
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public void b(AppRuntime appRuntime, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) messageRecord);
        } else {
            ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).tryAddTDFileMessageRecord((AppInterface) appRuntime, messageRecord);
        }
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public boolean c(AppRuntime appRuntime, MessageRecord messageRecord, int i3) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appRuntime, messageRecord, Integer.valueOf(i3))).booleanValue();
        }
        IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
        if (i3 == 1008 && iWeatherCommApi.isWeatherPA(messageRecord.frienduin)) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            if (messageRecord instanceof MessageForPubAccount) {
                return true;
            }
            if (messageRecord instanceof MessageForText) {
                ReportController.o(appRuntime, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_push", 0, 0, "", "", "", "");
                from.encodeLong("pa_list_send_time" + appRuntime.getAccount(), System.currentTimeMillis());
            } else if (messageRecord instanceof MessageForArkApp) {
                MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
                from.encodeBool("show_flag", true);
                try {
                    JSONObject optJSONObject3 = new JSONObject(messageForArkApp.ark_app_message.metaList).optJSONObject("weather");
                    if (optJSONObject3 != null && optJSONObject3.has("info") && (optJSONObject2 = (optJSONObject = optJSONObject3.optJSONObject("info")).optJSONObject("it1")) != null) {
                        String optString = optJSONObject2.optString("city");
                        String optString2 = optJSONObject2.optString(FaceUtil.IMG_TEMP);
                        String optString3 = optJSONObject2.optString("type");
                        if (!TextUtils.isEmpty(optString)) {
                            from.encodeString("cur_city", optString.split("-")[0]);
                        }
                        if (!TextUtils.isEmpty(optString2)) {
                            from.encodeString("cur_temp", optString2);
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            from.encodeString("cur_code", optString3);
                        }
                        from.encodeLong("pa_send_time" + appRuntime.getAccount(), System.currentTimeMillis());
                        if (0 != optJSONObject3.optLong("ts")) {
                            from.encodeLong("pa_time_stamp" + appRuntime.getAccount(), optJSONObject.optLong("ts"));
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.msg.BaseMessageManager", 2, "parse ark msg city: " + optString + ", temp: " + optString2 + ", code: " + optString3 + ", ts: " + optJSONObject.optLong("ts"));
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e("Q.msg.BaseMessageManager", 1, "addMessageForPAWeather get a Throwable: " + e16.getStackTrace());
                }
            }
        }
        return false;
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public boolean d(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        try {
            PublicAccountInfo publicAccountInfo = (PublicAccountInfo) ((IPublicAccountDataManager) appRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(str);
            if (publicAccountInfo == null) {
                return true;
            }
            return publicAccountInfo.isVisible();
        } catch (Throwable th5) {
            QLog.e("Q.msg.BaseMessageManager", 1, "needShowPublicAccount get a Throwable: " + th5.getStackTrace());
            return true;
        }
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public boolean dump() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public boolean e(AppRuntime appRuntime, MessageRecord messageRecord, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, appRuntime, messageRecord, str, Integer.valueOf(i3))).booleanValue();
        }
        if (i3 == 1008 && !yx.a.a(messageRecord) && (TroopBarAssistantManager.n().x((QQAppInterface) appRuntime, str, i3) || "1".equals(messageRecord.getExtInfoFromExtStr("inter_num")))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public void f(AppRuntime appRuntime, int i3) {
        AppletsHandler appletsHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime, i3);
        } else if (i3 == 1038 && (appletsHandler = (AppletsHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER)) != null) {
            appletsHandler.J2();
        }
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public boolean g(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return ConfessMsgUtil.f(messageRecord);
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public boolean h(AppRuntime appRuntime, MessageRecord messageRecord, String str, int i3, BaseMessageManager.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, appRuntime, messageRecord, str, Integer.valueOf(i3), aVar)).booleanValue();
        }
        if (i3 != 1008 || yx.a.a(messageRecord) || (!"2".equals(messageRecord.getExtInfoFromExtStr("inter_num")) && !ServiceAccountFolderManager.j((QQAppInterface) appRuntime, str))) {
            return false;
        }
        m(messageRecord, aVar, str, i3);
        return true;
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public int i(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) appRuntime)).intValue();
        }
        return ((QQAppInterface) appRuntime).getC2CRoamingSetting();
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public boolean isRedPacketMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return MessageForQQWalletMsg.isRedPacketMsg(messageRecord);
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public boolean j(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return ((QQAppInterface) appRuntime).getC2CRoamingSettingFromServerFlagFeature();
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public boolean k(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) appRuntime, (Object) str)).booleanValue();
        }
        return RecentUtil.b((QQAppInterface) appRuntime, str);
    }

    @Override // com.tencent.imcore.message.C2CMessageManager.a
    public void l(C2CMessageManager c2CMessageManager, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) c2CMessageManager, (Object) messageRecord);
        }
    }
}
