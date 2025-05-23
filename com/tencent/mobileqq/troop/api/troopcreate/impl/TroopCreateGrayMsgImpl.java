package com.tencent.mobileqq.troop.api.troopcreate.impl;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCreateGrayMsgImpl implements ITroopCreateGrayMsg {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "TroopCreateLogic";
    QQAppInterface app;
    protected TroopCreateInfo createInfo;

    public TroopCreateGrayMsgImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg
    public void addCreateNewTroopGrayTips(String str, boolean z16, String str2) {
        String qqStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), str2);
            return;
        }
        if (z16) {
            String qqStr2 = HardCodeUtil.qqStr(R.string.f214565t9);
            StringBuilder sb5 = new StringBuilder();
            for (TroopCreateInfo.a aVar : this.createInfo.inviteMembers) {
                if (!aVar.f294787a.equals(this.app.getCurrentAccountUin()) && (TextUtils.isEmpty(aVar.f294788b) || !aVar.f294788b.equals(this.app.getCurrentUid()))) {
                    String g16 = com.tencent.mobileqq.troop.troopcreate.a.g(this.app, aVar, str);
                    if (!TextUtils.isEmpty(g16)) {
                        sb5.append(g16);
                        sb5.append("\u3001");
                    }
                }
            }
            if (sb5.length() > 0) {
                sb5.delete(sb5.length() - 1, sb5.length());
            }
            qqStr = String.format(qqStr2, sb5.toString());
        } else if (!TextUtils.isEmpty(str2)) {
            qqStr = String.format(HardCodeUtil.qqStr(R.string.f214555t8), str2);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f214575t_);
        }
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(str, 2, 1009L, 1, true, true, null);
        localGrayTipBuilder.g(qqStr, 1);
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(this.app, localGrayTipBuilder.m(), null);
    }

    @Override // com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg
    public void addTroopCreatedGrayTipsMr(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && (qQAppInterface instanceof QQAppInterface)) {
            TroopCreateInfo troopCreateInfo = this.createInfo;
            if (troopCreateInfo != null && str.equals(troopCreateInfo.troopUin)) {
                return;
            }
            MessageForGrayTips messageForGrayTips = (MessageForGrayTips) q.d(MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS);
            messageForGrayTips.frienduin = str;
            Resources resources = BaseApplicationImpl.getApplication().getResources();
            String string = resources.getString(R.string.ejz);
            String string2 = resources.getString(R.string.ejx);
            String string3 = resources.getString(R.string.ejy);
            messageForGrayTips.init(this.app.getCurrentAccountUin(), str, str, string, NetConnInfoCenter.getServerTime(), MessageRecord.MSG_TYPE_TEXT_GROUP_CREATED, 1, 0L);
            messageForGrayTips.setTextGravity(17);
            Bundle bundle = new Bundle();
            bundle.putInt("key_action", 7);
            int indexOf = string.indexOf(string2);
            messageForGrayTips.addHightlightItem(indexOf, string2.length() + indexOf, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("key_action", 6);
            int indexOf2 = string.indexOf(string3);
            messageForGrayTips.addHightlightItem(indexOf2, string3.length() + indexOf2, bundle2);
            if (!MessageHandlerUtils.msgFilter(this.app, messageForGrayTips, false)) {
                this.app.getMessageFacade().c(messageForGrayTips, this.app.getCurrentAccountUin());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addTroopCreatedGrayTipsMr");
            if (this.app == null) {
                str2 = "app is null";
            } else {
                str2 = "app error";
            }
            sb5.append(str2);
            QLog.d(TAG, 1, sb5.toString());
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        } else {
            this.app = (QQAppInterface) appRuntime;
            this.createInfo = ((ITroopCreateInfoService) appRuntime.getRuntimeService(ITroopCreateInfoService.class, "")).getTroopCreateInfo();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
