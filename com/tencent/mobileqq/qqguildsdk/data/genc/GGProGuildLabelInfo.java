package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildLabel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildLabelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendGuildState;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildLabelInfo implements IGProGuildLabelInfo {
    public final GProGuildLabelInfo mInfo;

    public GGProGuildLabelInfo(GProGuildLabelInfo gProGuildLabelInfo) {
        this.mInfo = gProGuildLabelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo
    public String getGuildCover() {
        return this.mInfo.getGuildCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo
    public String getGuildIcon() {
        return this.mInfo.getGuildIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo
    public ArrayList<IGProGuildLabel> getLabels() {
        ArrayList<GProGuildLabel> labels = this.mInfo.getLabels();
        ArrayList<IGProGuildLabel> arrayList = new ArrayList<>();
        Iterator<GProGuildLabel> it = labels.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildLabel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo
    public ArrayList<IGProMedalInfo> getMedals() {
        ArrayList<GProMedalInfo> medals = this.mInfo.getMedals();
        ArrayList<IGProMedalInfo> arrayList = new ArrayList<>();
        Iterator<GProMedalInfo> it = medals.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMedalInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo
    public String getProfile() {
        return this.mInfo.getProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo
    public ArrayList<IGProRecommendGuildState> getStateList() {
        ArrayList<GProRecommendGuildState> stateList = this.mInfo.getStateList();
        ArrayList<IGProRecommendGuildState> arrayList = new ArrayList<>();
        Iterator<GProRecommendGuildState> it = stateList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendGuildState(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
