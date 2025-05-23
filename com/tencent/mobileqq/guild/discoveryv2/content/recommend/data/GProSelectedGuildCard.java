package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class GProSelectedGuildCard implements IGProSelectedGuildCard {
    private long guildId = 0;
    private String guildName = "";
    private String guildAvatar = "";
    private ArrayList<IGProGuildLabel> tagList = new ArrayList<>();
    private ArrayList<IGProMedalInfo> medals = new ArrayList<>();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public String getGuildAvatar() {
        return this.guildAvatar;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public long getGuildId() {
        return this.guildId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public String getGuildName() {
        return this.guildName;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public ArrayList<IGProMedalInfo> getMedals() {
        return this.medals;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard
    public ArrayList<IGProGuildLabel> getTagList() {
        return this.tagList;
    }

    public void setGuildAvatar(String str) {
        this.guildAvatar = str;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setGuildName(String str) {
        this.guildName = str;
    }

    public void setMedals(ArrayList<IGProMedalInfo> arrayList) {
        this.medals = arrayList;
    }

    public void setTagList(List<IGProRecommendLabel> list) {
        for (IGProRecommendLabel iGProRecommendLabel : list) {
            GProGuildLabel gProGuildLabel = new GProGuildLabel();
            gProGuildLabel.labelName = iGProRecommendLabel.getLabelName().getBytes();
            gProGuildLabel.labelType = iGProRecommendLabel.getLabelType();
            gProGuildLabel.bussiLabelType = iGProRecommendLabel.getBussiLabelType();
            gProGuildLabel.labelValue = iGProRecommendLabel.getLabelValue();
            gProGuildLabel.valueList.addAll(iGProRecommendLabel.getValueList());
            gProGuildLabel.value = iGProRecommendLabel.getValue();
            this.tagList.add(gProGuildLabel);
        }
    }
}
