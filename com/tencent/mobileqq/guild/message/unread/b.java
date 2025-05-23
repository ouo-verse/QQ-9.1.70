package com.tencent.mobileqq.guild.message.unread;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.j;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {
    private static j a(String str, IGuildMsgSeqTimeService.a aVar) {
        j jVar = new j();
        jVar.f266711a = str;
        jVar.f266714d = aVar.f230120e;
        long j3 = aVar.f230121f;
        jVar.f266715e = j3;
        jVar.f266712b = aVar.f230119d;
        jVar.f266713c = j3;
        if (aVar.c() != null) {
            jVar.f266716f = aVar.c();
        }
        return jVar;
    }

    private static void b(AppInterface appInterface, boolean z16, int i3, List<j> list, Set<String> set, String str, String str2) {
        if (!g(appInterface, str, str2, i3, z16)) {
            return;
        }
        list.add(a(str, c.b(appInterface, str2, c.c(i3))));
        set.add(str2);
    }

    public static void c(AppInterface appInterface, String str, String str2, IGuildMsgSeqTimeService.a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) appInterface.getRuntimeService(IGuildMsgSeqTimeService.class, "");
            if (!iGuildMsgSeqTimeService.setReadedMsgSeq(str, str2, aVar, true)) {
                QLog.i("GuildDirectMessageReadReportUtil", 1, "sendMsgReadReport setReadedMsgSeq return false, seqTimeItem: " + aVar);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("GuildDirectMessageReadReportUtil", 2, "sendMsgReadReport guildid:" + str + " channelid:" + str2 + " oldReadedMsgSeq:" + iGuildMsgSeqTimeService.getReadedMsgSeq(str2).toString() + " newReadedMsgSeq:" + aVar.toString());
            }
            j a16 = a(str, aVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a16);
            f(appInterface, arrayList);
            return;
        }
        QLog.w("GuildDirectMessageReadReportUtil", 1, "guildId: " + str + ", seqTimeItem: " + aVar);
    }

    public static void d(AppInterface appInterface, String str, ArrayList<String> arrayList, boolean z16, int i3) {
        if (arrayList != null && arrayList.size() == 1) {
            String str2 = arrayList.get(0);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                ArrayList arrayList2 = new ArrayList();
                HashSet hashSet = new HashSet();
                b(appInterface, z16, i3, arrayList2, hashSet, str, str2);
                if (arrayList2.size() == 0) {
                    QLog.w("GuildDirectMessageReadReportUtil", 1, "reportData size is zero.");
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("GuildDirectMessageReadReportUtil", 2, "sendMsgReadReport guildid:" + str + " channelid:" + str2 + " reportData:" + arrayList2.toString() + " channelIdList:" + hashSet.toString());
                }
                f(appInterface, arrayList2);
                return;
            }
            QLog.w("GuildDirectMessageReadReportUtil", 1, "guildId: " + str + ", channelId: " + str2);
            return;
        }
        QLog.w("GuildDirectMessageReadReportUtil", 1, "sendMsgReadReport failed channelId : " + arrayList);
    }

    public static void e(AppInterface appInterface, LinkedHashMap<String, ArrayList<String>> linkedHashMap, boolean z16, int i3) {
        String str;
        if (linkedHashMap != null && linkedHashMap.size() != 0) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            for (String str2 : linkedHashMap.keySet()) {
                ArrayList<String> arrayList2 = linkedHashMap.get(str2);
                if (arrayList2.size() > 0) {
                    str = arrayList2.get(0);
                } else {
                    str = "";
                }
                String str3 = str;
                if (!TextUtils.isEmpty(str3)) {
                    b(appInterface, z16, i3, arrayList, hashSet, str2, str3);
                }
            }
            if (arrayList.size() == 0) {
                QLog.w("GuildDirectMessageReadReportUtil", 1, "reportData size is zero.");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("GuildDirectMessageReadReportUtil", 2, "sendMsgReadReport guildData:" + linkedHashMap + " force:" + z16 + " reportData:" + arrayList.toString() + " channelIdList:" + hashSet.toString());
            }
            f(appInterface, arrayList);
            return;
        }
        QLog.w("GuildDirectMessageReadReportUtil", 1, "guildData: " + linkedHashMap + ", from: " + i3);
    }

    private static void f(AppInterface appInterface, List<j> list) {
        ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).sendDirectMsgReadReport(list);
    }

    private static boolean g(AppInterface appInterface, String str, String str2, int i3, boolean z16) {
        IGuildMsgSeqTimeService iGuildMsgSeqTimeService = (IGuildMsgSeqTimeService) appInterface.getRuntimeService(IGuildMsgSeqTimeService.class, "");
        IGuildMsgSeqTimeService.a b16 = c.b(appInterface, str2, c.c(i3));
        if (b16 != null && b16.d()) {
            if (!iGuildMsgSeqTimeService.setReadedMsgSeq(str, str2, b16, true) && !z16) {
                QLog.i("GuildDirectMessageReadReportUtil", 1, "updateMsgReadUI, setReadedMsgSeq return false; from: " + i3 + ", lastSeq: " + b16);
                return false;
            }
            QLog.i("GuildDirectMessageReadReportUtil", 1, "sendMsgReadedReport force:" + z16 + " guildid:" + str + " channelid:" + str2 + " oldReadedMsgSeq:" + iGuildMsgSeqTimeService.getReadedMsgSeq(str2).toString() + " newReadedMsgSeq:" + b16.toString() + ", from:" + i3);
            return true;
        }
        QLog.i("GuildDirectMessageReadReportUtil", 1, "sendMsgReadedReport, lastSeq == null || !lastSeq.isValid()");
        return false;
    }
}
