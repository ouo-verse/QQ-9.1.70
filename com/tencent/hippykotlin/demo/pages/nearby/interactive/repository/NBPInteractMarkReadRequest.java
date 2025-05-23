package com.tencent.hippykotlin.demo.pages.nearby.interactive.repository;

import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import m25.c;
import u25.e;
import u25.f;

/* loaded from: classes31.dex */
public final class NBPInteractMarkReadRequest extends NearbyBasePbRequest<e, f> {
    public final List<Integer> redIds;

    public NBPInteractMarkReadRequest(List<Integer> list) {
        this.redIds = list;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.like_svr.Like.SsoMarkAsRead";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        List mutableList;
        c commonExtInfo = UserDataManager.INSTANCE.getCommonExtInfo();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.redIds);
        return new e(commonExtInfo, mutableList);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        try {
            return (f) i.b(new f(null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPInteractMarkReadRequest", "NBPInteractMarkReadRequest decode error: " + th5);
            return new f(null);
        }
    }
}
