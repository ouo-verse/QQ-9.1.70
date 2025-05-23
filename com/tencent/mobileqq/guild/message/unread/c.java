package com.tencent.mobileqq.guild.message.unread;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f230879a = "GuildMsgReadedUtils";

    private static IGuildMsgSeqTimeService.a a(AppInterface appInterface, String str, IGuildMsgSeqTimeService iGuildMsgSeqTimeService, IGuildMsgSeqTimeService.a aVar) {
        IGuildMsgSeqTimeService.a latestHasSeenMsg = iGuildMsgSeqTimeService.getLatestHasSeenMsg(str);
        List<MessageRecord> l3 = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) appInterface).F(10014).y(10014).l(str, 10014);
        QLog.d(f230879a, 1, "getLatestHasSeenMsgItem, channel = " + str + ", lastSeq = " + latestHasSeenMsg + ", lastSvrSeq = " + aVar);
        if (l3 == null) {
            QLog.d(f230879a, 1, "getLatestHasSeenMsgItem, aioList == null");
            return latestHasSeenMsg;
        }
        Iterator<MessageRecord> it = l3.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MessageRecord next = it.next();
            if (next != null && (latestHasSeenMsg == null || next.shmsgseq > latestHasSeenMsg.f230119d)) {
                if (aVar == null || next.shmsgseq <= aVar.f230119d) {
                    if ((!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(next) && (next instanceof ChatMessage) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildChatPieFilterMsg(appInterface, (ChatMessage) next)) || next.msgtype == -2006) {
                        try {
                            long cntSeqFromMR = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getCntSeqFromMR(next);
                            if (latestHasSeenMsg == null) {
                                latestHasSeenMsg = new IGuildMsgSeqTimeService.a();
                            }
                            latestHasSeenMsg.f230119d = next.shmsgseq;
                            latestHasSeenMsg.f230121f = next.time;
                            latestHasSeenMsg.f(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getMsgMetaFromMr(next));
                            latestHasSeenMsg.f230120e = cntSeqFromMR;
                            QLog.d(f230879a, 1, "getLatestHasSeenMsgItem, msg = " + next.getBaseInfoString() + ", lastSeq = " + latestHasSeenMsg);
                        } catch (NumberFormatException e16) {
                            QLog.d(f230879a, 1, "getLatestHasSeenMsgItem, e = " + e16);
                        }
                    } else if (!((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg(next)) {
                        QLog.d(f230879a, 1, "getLatestHasSeenMsgItem, other msg = " + next.getBaseInfoString());
                        break;
                    }
                }
            }
        }
        return latestHasSeenMsg;
    }

    @NonNull
    public static IGuildMsgSeqTimeService.a b(AppInterface appInterface, String str, boolean z16) {
        IGuildMsgSeqTimeService.a aVar;
        if (TextUtils.isEmpty(str)) {
            return new IGuildMsgSeqTimeService.a();
        }
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) appInterface.getRuntimeService(IGuildMsgSeqTimeService.class, "");
        IGuildFocusChannelService iGuildFocusChannelService = (IGuildFocusChannelService) appInterface.getRuntimeService(IGuildFocusChannelService.class, "");
        IGuildMsgSeqTimeService.a lastSvrMsgSeq = iGuildMsgSeqTimeService.getLastSvrMsgSeq(str);
        String curActiveChannelId = iGuildFocusChannelService.getCurActiveChannelId();
        if (!z16 && str.equals(curActiveChannelId)) {
            aVar = a(appInterface, str, iGuildMsgSeqTimeService, lastSvrMsgSeq);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar;
        }
        return lastSvrMsgSeq;
    }

    public static boolean c(int i3) {
        if (i3 != 9 && i3 != 10 && i3 != 11) {
            return true;
        }
        return false;
    }
}
