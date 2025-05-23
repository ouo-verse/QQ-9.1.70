package com.tencent.mobileqq.profilecard.bussiness.achievement.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import tencent.im.oidb.cmd0xe5f.oidb_0xe5f$ReqBody;
import tencent.im.oidb.cmd0xe5f.oidb_0xe5f$RspBody;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LifeAchievementHandler extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String CMD_LIFE_ACHIEVEMENT_PRAISE = "OidbSvc.0xe5f_2";
    public static final int LIFE_ACHIEVEMENT_PRAISE = 1;
    public static final String LIFE_ACHIEVEMENT_PRAISE_ACTION_TYPE_KEY = "life_achievement_praise_action_type_key";
    public static final int LIFE_ACHIEVEMENT_PRAISE_CANCEL = 2;
    public static final String LIFE_ACHIEVEMENT_PRAISE_ID_KEY = "life_achievement_praise_id_key";
    public static final int MAX_LIFE_ACHIEVEMENT_INFO_COUNT = 10;
    private static final String TAG = "LifeAchievementHandler";
    public static final int TYPE_PRAISE_LIFE_ACHIEVEMENT = 10;
    private AppInterface mApp;

    protected LifeAchievementHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.mApp = appInterface;
        }
    }

    private void handlePraiseLifeAchievement(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<oidb_0xe5f$RspBody>() { // from class: tencent.im.oidb.cmd0xe5f.oidb_0xe5f$RspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xe5f$RspBody.class);
        });
        if (parseOIDBPkg == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Bundle bundle = new Bundle();
        if (toServiceMsg != null) {
            bundle = toServiceMsg.extraData;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handlePraiseLifeAchievement and isSuccess is " + z16 + " result is " + parseOIDBPkg);
        }
        notifyUI(10, z16, bundle);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(CMD_LIFE_ACHIEVEMENT_PRAISE);
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return LifeAchievementObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (!msgCmdFilter(serviceCmd) && TextUtils.equals(serviceCmd, CMD_LIFE_ACHIEVEMENT_PRAISE)) {
            handlePraiseLifeAchievement(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void praiseLifeAchievement(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format(Locale.getDefault(), "praiseLifeAchievement uin=%d achievementId=%d actionType=%d", Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        oidb_0xe5f$ReqBody oidb_0xe5f_reqbody = new oidb_0xe5f$ReqBody();
        oidb_0xe5f_reqbody.uint64_praiseuin.set(j3);
        oidb_0xe5f_reqbody.uint32_achievement_id.set(i3);
        oidb_0xe5f_reqbody.uint32_actiontype.set(i16);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(CMD_LIFE_ACHIEVEMENT_PRAISE, 3679, 2, oidb_0xe5f_reqbody.toByteArray());
        makeOIDBPkg.extraData.putInt(LIFE_ACHIEVEMENT_PRAISE_ID_KEY, i3);
        makeOIDBPkg.extraData.putInt(LIFE_ACHIEVEMENT_PRAISE_ACTION_TYPE_KEY, i16);
        sendPbReq(makeOIDBPkg);
    }
}
