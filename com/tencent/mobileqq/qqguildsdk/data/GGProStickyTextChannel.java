package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgSummary;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStickyTextChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProStickyTextChannel implements IGProStickyTextChannel {
    public final GProStickyTextChannel mInfo;

    public GGProStickyTextChannel(GProStickyTextChannel gProStickyTextChannel) {
        this.mInfo = gProStickyTextChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel
    public String getActiveMemberCount() {
        return this.mInfo.getActiveMemberCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel
    public ArrayList<IGProUserInfo> getActiveMemberList() {
        ArrayList<GProUser> activeMemberList = this.mInfo.getActiveMemberList();
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = activeMemberList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel
    public ArrayList<fe> getMsgAbstracts() {
        ArrayList<MsgAbstract> msgAbstracts = this.mInfo.getMsgAbstracts();
        ArrayList<fe> arrayList = new ArrayList<>();
        Iterator<MsgAbstract> it = msgAbstracts.iterator();
        while (it.hasNext()) {
            arrayList.add(new s(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel
    public ArrayList<IGProMsgSummary> getMsgList() {
        ArrayList<GProMsgSummary> msgList = this.mInfo.getMsgList();
        ArrayList<IGProMsgSummary> arrayList = new ArrayList<>();
        Iterator<GProMsgSummary> it = msgList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMsgSummary(it.next()));
        }
        return arrayList;
    }
}
