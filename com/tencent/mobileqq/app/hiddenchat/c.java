package com.tencent.mobileqq.app.hiddenchat;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, TroopInfo troopInfo) {
        QLog.d(LogTag.TAG_HIDDEN_CHAT, 1, "updateHiddenChat single");
        FriendsStatusUtil.z(qQAppInterface, troopInfo.troopuin, 1, TroopInfo.isCmdUinFlagEx2Open(troopInfo.cmdUinFlagEx2, 512) ? 1 : 0);
    }
}
