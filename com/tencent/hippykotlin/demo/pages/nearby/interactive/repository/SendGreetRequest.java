package com.tencent.hippykotlin.demo.pages.nearby.interactive.repository;

import c45.a;
import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.log.KLog;
import k35.q;
import k35.r;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SendGreetRequest extends NearbyBasePbRequest<q, r> {
    public final int mid;
    public final long peerTid;
    public final byte[] sign;

    public SendGreetRequest(long j3, byte[] bArr, int i3) {
        this.peerTid = j3;
        this.sign = bArr;
        this.mid = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        r rVar = new r();
        try {
            return (r) i.b(new r(), bArr);
        } catch (Throwable th5) {
            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("SendGreetRsp error: ", th5, KLog.INSTANCE, "SendGreetRsp");
            return rVar;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.lplan.mood_svr.MoodSvr.SsoSendGreet";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        return new q(UserDataManager.INSTANCE.getCommonExtInfo(), this.peerTid, new a(this.sign), this.mid);
    }
}
