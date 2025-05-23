package com.qzone.personalize.festival;

import NS_QZONE_FESTIVAL.FestivalGetReqItem;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FestivalReqItemInfo implements SmartParcelable {

    @NeedParcel
    public int mDays;

    @NeedParcel
    public int month;

    @NeedParcel
    public long time;

    @NeedParcel
    public int type;

    @NeedParcel
    public int year;

    public FestivalReqItemInfo(long j3) {
        this.year = 0;
        this.month = 0;
        this.mDays = 0;
        this.type = 0;
        this.time = j3;
    }

    public static FestivalGetReqItem convertToProtoReqItem(FestivalReqItemInfo festivalReqItemInfo) {
        FestivalGetReqItem festivalGetReqItem = new FestivalGetReqItem();
        festivalGetReqItem.time = festivalReqItemInfo.time;
        festivalGetReqItem.year = festivalReqItemInfo.year;
        festivalGetReqItem.month = festivalReqItemInfo.month;
        festivalGetReqItem.mdays = festivalReqItemInfo.mDays;
        return festivalGetReqItem;
    }

    public FestivalReqItemInfo(int i3, int i16, int i17, int i18) {
        this.year = i3;
        this.month = i16;
        this.mDays = i17;
        this.type = i18;
    }
}
