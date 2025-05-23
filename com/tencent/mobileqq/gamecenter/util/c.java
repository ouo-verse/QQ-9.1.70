package com.tencent.mobileqq.gamecenter.util;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    @Deprecated
    public static void a(MessageRecord messageRecord) {
        b(MobileQQ.sMobileQQ.peekAppRuntime(), messageRecord, messageRecord.frienduin, messageRecord.istroop);
    }

    @Deprecated
    public static void b(AppRuntime appRuntime, MessageRecord messageRecord, String str, int i3) {
        boolean z16;
        if (appRuntime != null && messageRecord != null) {
            try {
                MessageRecord lastGameMsg = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getLastGameMsg(appRuntime, str);
                if (lastGameMsg != null) {
                    String extInfoFromExtStr = lastGameMsg.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO);
                    if (!lastGameMsg.isSend()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    messageRecord.saveExtInfoToExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO, new TinyInfo(extInfoFromExtStr, z16).toJsonStr());
                } else {
                    String msgExtraString = ((IGameQQPlayerUtilApi) QRoute.api(IGameQQPlayerUtilApi.class)).getMsgExtraString(appRuntime, str);
                    if (msgExtraString != null) {
                        messageRecord.saveExtInfoToExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO, msgExtraString);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Deprecated
    public static String c(MessageRecord messageRecord) {
        if (TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO))) {
            a(messageRecord);
        }
        TinyInfo tinyInfo = new TinyInfo();
        tinyInfo.parseFromMessageRecord(messageRecord);
        if (messageRecord.isSend()) {
            return tinyInfo.toRoleId;
        }
        return tinyInfo.fromRoleId;
    }

    @Deprecated
    public static String d(MessageRecord messageRecord) {
        if (TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr(TinyInfo.EXT_KEY_GAME_MSG_INFO))) {
            a(messageRecord);
        }
        TinyInfo tinyInfo = new TinyInfo();
        tinyInfo.parseFromMessageRecord(messageRecord);
        if (messageRecord.isSend()) {
            return tinyInfo.fromRoleId;
        }
        return tinyInfo.toRoleId;
    }
}
