package com.tencent.mobileqq.guild.message.unread.api;

import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes14.dex */
public interface IGuildMsgReadedService extends IRuntimeService {
    boolean clearMsgNavigateInfo(String str, List<String> list);

    void onMsgReadedNotify(String str, String str2, IGuildMsgSeqTimeService.a aVar);

    void onRegisterProxyMsgReaded(String str, List<String> list);

    void setChannelMsgReaded(String str, ArrayList<String> arrayList, int i3, boolean z16);

    void setChannelMsgReaded(LinkedHashMap<String, ArrayList<String>> linkedHashMap, int i3, boolean z16);

    void setGuildMsgReaded(String str, int i3, boolean z16);

    void setGuildMsgReaded(LinkedHashSet<String> linkedHashSet, int i3, boolean z16);

    void setMessageRecordReaded(String str, List<String> list);

    void setMsgReadedAndReport(String str, String str2, IGuildMsgSeqTimeService.a aVar, boolean z16);

    void setMsgReadedAndReport(String str, ArrayList<String> arrayList, int i3, boolean z16);

    void setMsgReadedAndReportForce(String str, ArrayList<String> arrayList, int i3, boolean z16, boolean z17);
}
