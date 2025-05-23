package com.tencent.biz.map.poi;

import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.location.data.LocationRoom;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name */
    private LocationRoom.Venue f78761i;

    public LocationRoom.Venue L1() {
        return this.f78761i;
    }

    public void M1(LocationRoom.Venue venue) {
        this.f78761i = venue;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "PoiViewModel";
    }
}
