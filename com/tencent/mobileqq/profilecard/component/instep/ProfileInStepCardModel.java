package com.tencent.mobileqq.profilecard.component.instep;

import com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel;
import java.util.List;

/* loaded from: classes35.dex */
public class ProfileInStepCardModel extends RFWCardModel {
    public String iconUrl;
    public List<String> subTitles;
    public String title;

    public ProfileInStepCardModel(String str, String str2, List<String> list) {
        this.iconUrl = str;
        this.title = str2;
        this.subTitles = list;
    }

    @Override // com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel
    public ProfileInStepCardModel deepClone() {
        return new ProfileInStepCardModel(this.iconUrl, this.title, this.subTitles);
    }
}
