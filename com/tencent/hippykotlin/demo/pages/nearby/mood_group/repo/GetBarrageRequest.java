package com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import java.util.Collection;
import java.util.List;
import k35.d;
import k35.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import m25.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GetBarrageRequest extends NearbyBasePbRequest<d, e> {
    public final List<Long> list;
    public final int mid;

    public GetBarrageRequest(int i3, List<Long> list) {
        this.mid = i3;
        this.list = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        return (e) i.b(new e(null, 0L, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoGetBarrage";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        List mutableList;
        c commonExtInfo = UserDataManager.INSTANCE.getCommonExtInfo();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.list);
        return new d(commonExtInfo, mutableList, this.mid);
    }
}
