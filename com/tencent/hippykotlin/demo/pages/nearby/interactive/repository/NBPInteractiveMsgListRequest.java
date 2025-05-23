package com.tencent.hippykotlin.demo.pages.nearby.interactive.repository;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.MemoryCacheModule;
import j35.e;
import j35.f;

/* loaded from: classes31.dex */
public final class NBPInteractiveMsgListRequest extends NearbyBasePbRequest<e, f> {
    public final a fetchCookie;
    public final int fetchCount;

    public NBPInteractiveMsgListRequest(int i3, a aVar) {
        this.fetchCount = i3;
        this.fetchCookie = aVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e decodeResponse(byte[] bArr) {
        try {
            MemoryCacheModule memoryCacheModule = (MemoryCacheModule) c.f117352a.g().acquireModule("KRMemoryCacheModule");
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            memoryCacheModule.d("nearbypro", "interactive_msglist", bArr);
            return (f) i.b(new f(null, null, false, null, 15, null), bArr);
        } catch (Throwable th5) {
            KLog.INSTANCE.e("NBPInteractiveMsgListRequest", "interactive msg list decode error: " + th5);
            return new f(null, null, false, null, 15, null);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.interact_svr.Interact.SsoGetInteractMsgList";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final c45.e getRequest() {
        return new e(UserDataManager.INSTANCE.getCommonExtInfo(), this.fetchCount, this.fetchCookie);
    }
}
