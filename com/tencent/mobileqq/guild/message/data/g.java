package com.tencent.mobileqq.guild.message.data;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@Deprecated
/* loaded from: classes33.dex */
public class g extends com.tencent.mobileqq.guild.message.base.l {
    @Deprecated
    public static void d(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("GuildRecentMsgRecorder", 2, "added recent talked channel record id:" + str);
        }
        t02.c cVar = new t02.c(((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getRecentTalkedChannelsWithTime());
        cVar.a(str);
        ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setRecentTalkedChannelsWithTime(cVar.toString());
        if (QLog.isColorLevel()) {
            QLog.i("GuildRecentMsgRecorder", 2, "Recent channels after add:" + cVar.toString());
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.l
    public void b(MessageRecord messageRecord) {
        if (su1.c.c(messageRecord)) {
            return;
        }
        d(messageRecord.frienduin);
    }
}
