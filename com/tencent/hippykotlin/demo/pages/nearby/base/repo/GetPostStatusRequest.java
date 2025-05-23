package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import m25.c;
import n25.k;
import n25.m;
import n35.w;
import s25.e;
import s25.f;

/* loaded from: classes31.dex */
public final class GetPostStatusRequest extends NearbyBasePbRequest<e, f> {
    public final int feedType;
    public final List<w> images;
    public final int motionId;
    public final k poiInfo;
    public final int richStatus;
    public final int status;
    public final String textContent;
    public final List<String> themes;
    public final List<m> topics;

    public GetPostStatusRequest(int i3, int i16, int i17, String str, k kVar, List list, List list2, List list3, int i18) {
        this.status = i3;
        this.richStatus = i16;
        this.motionId = i17;
        this.textContent = str;
        this.poiInfo = kVar;
        this.images = list;
        this.topics = list2;
        this.themes = list3;
        this.feedType = i18;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        return (f) i.b(new f(null, null, null, 7, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.feed_svr.StatusWrite.SsoPostStatus";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        byte[] encodeToByteArray;
        List mutableList;
        List mutableList2;
        List mutableList3;
        int i3 = this.status;
        int i16 = this.richStatus;
        int i17 = this.motionId;
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(this.textContent);
        a aVar = new a(encodeToByteArray);
        k kVar = this.poiInfo;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.images);
        c commonExtInfo = UserDataManager.INSTANCE.getCommonExtInfo();
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) this.topics);
        mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) this.themes);
        return new e(i3, i16, i17, aVar, kVar, mutableList, null, commonExtInfo, mutableList2, this.feedType, null, mutableList3, 1024);
    }
}
