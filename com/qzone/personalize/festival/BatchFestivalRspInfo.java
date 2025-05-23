package com.qzone.personalize.festival;

import NS_QZONE_FESTIVAL.FestivalGetRspItem;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BatchFestivalRspInfo implements SmartParcelable {

    @NeedParcel
    public long days;

    @NeedParcel
    public long month;

    @NeedParcel
    public String name;

    @NeedParcel
    public int result;

    @NeedParcel
    public long type;

    @NeedParcel
    public long year = 0;

    public BatchFestivalRspInfo(String str, long j3, long j16, long j17, long j18, int i3) {
        this.name = str;
        this.type = j3;
        this.month = j17;
        this.days = j18;
        this.result = i3;
    }

    public static BatchFestivalRspInfo parseFromProto(FestivalGetRspItem festivalGetRspItem) {
        return new BatchFestivalRspInfo(festivalGetRspItem.festival_name, festivalGetRspItem.festival_type, festivalGetRspItem.festival_year, festivalGetRspItem.festival_month, festivalGetRspItem.festival_mdays, festivalGetRspItem.result_code);
    }

    public boolean isFestival() {
        return this.result == 0;
    }
}
