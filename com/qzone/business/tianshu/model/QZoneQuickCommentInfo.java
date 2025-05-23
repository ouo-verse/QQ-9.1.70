package com.qzone.business.tianshu.model;

import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import q5.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneQuickCommentInfo extends TianShuInfo {
    public List<a> cardList;
    public String entrancePic;
    private TianShuAccess.AdItem mAdItem;
    private final TianShuAccess.AdItem originAdItem;
    public int showMax;

    public QZoneQuickCommentInfo(TianShuAccess.AdItem adItem) {
        this.originAdItem = adItem;
    }

    public TianShuAccess.AdItem getAdItem() {
        return this.mAdItem;
    }

    public List<a> getCardList() {
        return this.cardList;
    }

    public String getEntrancePic() {
        return this.entrancePic;
    }

    public TianShuAccess.AdItem getOriginAdItem() {
        return this.originAdItem;
    }

    public int getShowMax() {
        return this.showMax;
    }

    public void setAdItem(TianShuAccess.AdItem adItem) {
        this.mAdItem = adItem;
    }

    public void setCardList(List<a> list) {
        this.cardList = list;
    }

    public void setEntrancePic(String str) {
        this.entrancePic = str;
    }

    public void setShowMax(int i3) {
        this.showMax = i3;
    }
}
