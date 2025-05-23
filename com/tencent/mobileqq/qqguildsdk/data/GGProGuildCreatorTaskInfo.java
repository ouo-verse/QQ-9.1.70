package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProTaskInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildCreatorTaskInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildCreatorTaskInfo implements IGProGuildCreatorTaskInfo {
    public final GProGuildCreatorTaskInfo mInfo;

    public GGProGuildCreatorTaskInfo(GProGuildCreatorTaskInfo gProGuildCreatorTaskInfo) {
        this.mInfo = gProGuildCreatorTaskInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildCreatorTaskInfo
    public int getFinishedCnt() {
        GProGuildCreatorTaskInfo gProGuildCreatorTaskInfo = this.mInfo;
        if (gProGuildCreatorTaskInfo != null) {
            return gProGuildCreatorTaskInfo.getFinishedCnt();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildCreatorTaskInfo
    public boolean getIsAllFinished() {
        GProGuildCreatorTaskInfo gProGuildCreatorTaskInfo = this.mInfo;
        if (gProGuildCreatorTaskInfo != null && gProGuildCreatorTaskInfo.getIsAllFinished()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildCreatorTaskInfo
    public int getSkipStatus() {
        GProGuildCreatorTaskInfo gProGuildCreatorTaskInfo = this.mInfo;
        if (gProGuildCreatorTaskInfo != null) {
            return gProGuildCreatorTaskInfo.getSkipStatus();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildCreatorTaskInfo
    public ArrayList<IGProTaskInfo> getTasks() {
        GProGuildCreatorTaskInfo gProGuildCreatorTaskInfo = this.mInfo;
        if (gProGuildCreatorTaskInfo == null) {
            return new ArrayList<>();
        }
        ArrayList<GProTaskInfo> tasks = gProGuildCreatorTaskInfo.getTasks();
        ArrayList<IGProTaskInfo> arrayList = new ArrayList<>();
        Iterator<GProTaskInfo> it = tasks.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProTaskInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildCreatorTaskInfo
    public int getTotalCnt() {
        GProGuildCreatorTaskInfo gProGuildCreatorTaskInfo = this.mInfo;
        if (gProGuildCreatorTaskInfo != null) {
            return gProGuildCreatorTaskInfo.getTotalCnt();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGuildCreatorTaskInfo
    public String toString() {
        GProGuildCreatorTaskInfo gProGuildCreatorTaskInfo = this.mInfo;
        if (gProGuildCreatorTaskInfo != null) {
            return gProGuildCreatorTaskInfo.toString();
        }
        return "null";
    }
}
