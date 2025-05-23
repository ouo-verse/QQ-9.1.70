package com.tencent.mobileqq.guild.message.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.startup.task.ce;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes33.dex */
public class f extends com.tencent.mobileqq.guild.message.base.h {

    /* renamed from: a, reason: collision with root package name */
    private static String f230370a = "GuildPushMessageProcessorCallback";

    @Override // com.tencent.mobileqq.guild.message.base.h
    public void a(AppInterface appInterface, ArrayList<MessageRecord> arrayList) {
        QLog.i("MessageRecordForAppChannel", 1, "AfterOnlinePushProcessed size:" + arrayList.size());
        if (arrayList.size() > 0) {
            Iterator<MessageRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (appInterface.isLogin()) {
            ((IAppBadgeService) appInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.h
    public boolean c() {
        return ce.INSTANCE.d();
    }

    @Override // com.tencent.mobileqq.guild.message.base.h
    public void b(AppInterface appInterface, ArrayList<MessageRecord> arrayList, com.tencent.mobileqq.troop.data.c cVar) {
        if (cVar == null) {
            return;
        }
        String str = arrayList.get(arrayList.size() - 1).frienduin;
        if (QLog.isColorLevel()) {
            QLog.d(f230370a, 2, "[beforeSaveMsg] messageInfo.getShmsgseq = " + cVar.g() + "\nmessageInfo.uinType = " + cVar.f294892b + "\nmessageInfo.getBizType = " + cVar.c(false) + "\nchannelId = " + str);
        }
        com.tencent.mobileqq.troop.navigatebar.c cVar2 = (com.tencent.mobileqq.troop.navigatebar.c) appInterface.getManager(QQManagerFactory.GUILDINFO_MANAGER);
        if (!cVar.h()) {
            cVar = new com.tencent.mobileqq.troop.data.c();
        }
        cVar2.c(str, cVar);
    }
}
