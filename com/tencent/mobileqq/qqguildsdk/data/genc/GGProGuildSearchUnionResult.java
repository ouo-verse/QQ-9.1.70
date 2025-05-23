package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchFeedGroupInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGuildFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGuildMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchMsgGroupInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchUnionResult;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildSearchUnionResult implements IGProGuildSearchUnionResult {
    public final GProGuildSearchUnionResult mInfo;

    public GGProGuildSearchUnionResult(GProGuildSearchUnionResult gProGuildSearchUnionResult) {
        this.mInfo = gProGuildSearchUnionResult;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public byte[] getFeedCookie() {
        return this.mInfo.getFeedCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public ArrayList<IGProGuildSearchFeedGroupInfo> getFeedGroupList() {
        ArrayList<GProGuildSearchFeedGroupInfo> feedGroupList = this.mInfo.getFeedGroupList();
        ArrayList<IGProGuildSearchFeedGroupInfo> arrayList = new ArrayList<>();
        Iterator<GProGuildSearchFeedGroupInfo> it = feedGroupList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildSearchFeedGroupInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public boolean getFeedIsEnd() {
        return this.mInfo.getFeedIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public long getFeedTotal() {
        return this.mInfo.getFeedTotal();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public ArrayList<IGProGuildSearchMsgGroupInfo> getGroupList() {
        ArrayList<GProGuildSearchMsgGroupInfo> groupList = this.mInfo.getGroupList();
        ArrayList<IGProGuildSearchMsgGroupInfo> arrayList = new ArrayList<>();
        Iterator<GProGuildSearchMsgGroupInfo> it = groupList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildSearchMsgGroupInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public ArrayList<IGProGuildSearchGuildFeed> getGuildFeeds() {
        ArrayList<GProGuildSearchGuildFeed> guildFeeds = this.mInfo.getGuildFeeds();
        ArrayList<IGProGuildSearchGuildFeed> arrayList = new ArrayList<>();
        Iterator<GProGuildSearchGuildFeed> it = guildFeeds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildSearchGuildFeed(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public ArrayList<IGProGuildSearchGuildMsg> getGuildMsgs() {
        ArrayList<GProGuildSearchGuildMsg> guildMsgs = this.mInfo.getGuildMsgs();
        ArrayList<IGProGuildSearchGuildMsg> arrayList = new ArrayList<>();
        Iterator<GProGuildSearchGuildMsg> it = guildMsgs.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildSearchGuildMsg(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public String getGuildNumber() {
        return this.mInfo.getGuildNumber();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public byte[] getMsgCookie() {
        return this.mInfo.getMsgCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public boolean getMsgIsEnd() {
        return this.mInfo.getMsgIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public long getMsgTotal() {
        return this.mInfo.getMsgTotal();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchUnionResult
    public String toString() {
        return this.mInfo.toString();
    }
}
