package com.tencent.luggage.wxa.t7;

import android.content.Context;
import com.tencent.luggage.wxa.q7.r;
import com.tencent.luggage.wxa.uk.o;
import com.tencent.luggage.wxaapi.d;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxaapi.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.tencent.luggage.wxaapi.a f140884a = (com.tencent.luggage.wxaapi.a) o.a("WxaDebugApiDummyIMPL", com.tencent.luggage.wxaapi.a.class);

    @Override // com.tencent.luggage.wxaapi.a
    public void debugXWeb(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f140884a.debugXWeb(context, i3);
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void deleteLibFile() {
        this.f140884a.deleteLibFile();
    }

    @Override // com.tencent.luggage.wxaapi.a
    public String getDebugIP() {
        return this.f140884a.getDebugIP();
    }

    @Override // com.tencent.luggage.wxaapi.a
    public boolean getIsDebugIP() {
        if (r.f138048a.c()) {
            return b.f140885h.b();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxaapi.a
    public boolean isMultiTaskModeEnabledForWxaApp() {
        if (com.tencent.luggage.wxa.q7.o.a()) {
            return b.f140885h.d();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxaapi.a
    public boolean isRunningWithJSCoverageCollect() {
        return false;
    }

    @Override // com.tencent.luggage.wxaapi.a
    public long launchByQRRawData(Context context, String codeRawData, d dVar) {
        Intrinsics.checkNotNullParameter(codeRawData, "codeRawData");
        return this.f140884a.launchByQRRawData(context, codeRawData, dVar);
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void setDebugIP(String ip5) {
        Intrinsics.checkNotNullParameter(ip5, "ip");
        this.f140884a.setDebugIP(ip5);
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void setIsDebugIP(boolean z16) {
        if (r.f138048a.c()) {
            b.f140885h.a(z16);
        }
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void setIsRunningWithJSCoverageCollect(boolean z16) {
        this.f140884a.setIsRunningWithJSCoverageCollect(z16);
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void setMultiTaskModeEnabledForWxaApp(boolean z16) {
        if (com.tencent.luggage.wxa.q7.o.a()) {
            b.f140885h.b(z16);
        }
    }

    @Override // com.tencent.luggage.wxaapi.a
    public void testIlinkProcessRecreate() {
        this.f140884a.testIlinkProcessRecreate();
    }
}
