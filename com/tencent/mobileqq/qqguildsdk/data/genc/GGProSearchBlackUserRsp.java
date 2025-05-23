package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBlackUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSearchBlackUserRsp;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProSearchBlackUserRsp implements IGProSearchBlackUserRsp {
    public final GProSearchBlackUserRsp mInfo;

    public GGProSearchBlackUserRsp(GProSearchBlackUserRsp gProSearchBlackUserRsp) {
        this.mInfo = gProSearchBlackUserRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchBlackUserRsp
    public byte[] getBuf() {
        return this.mInfo.getBuf();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchBlackUserRsp
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchBlackUserRsp
    public String getKeyword() {
        return this.mInfo.getKeyword();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchBlackUserRsp
    public ArrayList<IGProBlackUserInfo> getMemberList() {
        ArrayList<GProBlackUserInfo> memberList = this.mInfo.getMemberList();
        ArrayList<IGProBlackUserInfo> arrayList = new ArrayList<>();
        Iterator<GProBlackUserInfo> it = memberList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBlackUserInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchBlackUserRsp
    public long getNextPos() {
        return this.mInfo.getNextPos();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchBlackUserRsp
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchBlackUserRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
