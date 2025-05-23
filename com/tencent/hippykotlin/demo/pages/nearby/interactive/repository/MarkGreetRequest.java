package com.tencent.hippykotlin.demo.pages.nearby.interactive.repository;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import k35.k;
import k35.l;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MarkGreetRequest extends NearbyBasePbRequest<k, l> {

    /* renamed from: id, reason: collision with root package name */
    public final String f114225id;

    public MarkGreetRequest(String str) {
        this.f114225id = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        l lVar = new l();
        try {
            return (l) i.b(new l(), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("SendArgMsgRsp error: ", th5, KLog.INSTANCE, "SendArgMsgRsp");
            return lVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoMarkGreet";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new k(UserDataManager.INSTANCE.getCommonExtInfo(), this.f114225id);
    }
}
