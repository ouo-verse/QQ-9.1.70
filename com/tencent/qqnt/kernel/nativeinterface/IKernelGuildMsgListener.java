package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelGuildMsgListener {
    void onChannelFreqLimitInfoUpdate(Contact contact, boolean z16, FreqLimitInfo freqLimitInfo);

    void onFirstViewGroupGuildMapping(ArrayList<FirstViewGroupGuildInfo> arrayList);

    void onGroupGuildUpdate(GroupGuildNotifyInfo groupGuildNotifyInfo);

    void onGuildMsgAbFlagChanged(GuildMsgAbFlag guildMsgAbFlag);

    void onMsgEventListUpdate(HashMap<String, ArrayList<Long>> hashMap);

    void onRecvGroupGuildFlag(int i3);

    void onRecvS2CMsg(ArrayList<Byte> arrayList);

    void onRecvUDCFlag(int i3);
}
