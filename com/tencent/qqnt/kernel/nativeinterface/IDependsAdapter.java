package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IDependsAdapter {
    void getA2Ticket(long j3, IGetA2TicketCallback iGetA2TicketCallback);

    BatteryStatus getBatteryStatus();

    ServerAddress getBigDataCustomEnvIpList();

    ArrayList<ServerAddress> getBigDataIpList(boolean z16, IpType ipType);

    BigDataTicket getBigDataTicket();

    String getConfigFromUI(UIConfig uIConfig);

    Long getGroupCode();

    ArrayList<ServerAddress> getIpDirectList(String str, IpType ipType);

    SessionTicket getLoginTicket();

    byte[] getQFixConfigReqBodyBytes();

    RegisterInfo getRegisterProxyOnlineReqParam();

    void onRegisterProxyOnlineResp(int i3, String str, RegisterRes registerRes);

    void onSendNetRequest(long j3, String str, String str2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i3, int i16);

    void onSendOidbRequest(long j3, int i3, int i16, byte[] bArr, SendRequestParam sendRequestParam, String str, HashMap<String, byte[]> hashMap);

    void onSendSSORequest(long j3, String str, byte[] bArr, SendRequestParam sendRequestParam, String str2, HashMap<String, byte[]> hashMap, int i3);

    Integer registerABatchOfMSFPushCommands(ArrayList<String> arrayList);

    void registerMSFPushCmd(String str);
}
