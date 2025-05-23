package com.tencent.timi.game.trtc.roomservice.voiceroom;

import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.timi.game.impl.TPRoom;
import com.tencent.timi.game.trtc.TRTCInstance;
import rn4.a;
import tn4.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TRTCRoom extends TPRoom {

    /* renamed from: e, reason: collision with root package name */
    private TRTCInstance f380050e;

    /* renamed from: f, reason: collision with root package name */
    public final a f380051f;

    private void a() {
        throw null;
    }

    private void d() {
        throw null;
    }

    private void e() {
        throw null;
    }

    private void f() {
        throw null;
    }

    @Override // com.tencent.timi.game.impl.TPRoom
    public void onCreate() {
        c.a("onCreate", new Object[0]);
        TRTCInstance tRTCInstance = new TRTCInstance();
        this.f380050e = tRTCInstance;
        tRTCInstance.b(this.f380051f);
        e();
        a();
        d();
    }

    @Override // com.tencent.timi.game.impl.TPRoom
    public void onDestroy() {
        c.a(MosaicConstants$JsFunction.FUNC_ON_DESTROY, new Object[0]);
        this.f380050e.d();
        f();
    }

    @Override // com.tencent.timi.game.impl.TPRoom
    public void onPause() {
        c.a(MiniSDKConst.NOTIFY_EVENT_ONPAUSE, new Object[0]);
    }

    @Override // com.tencent.timi.game.impl.TPRoom
    public void onResume() {
        c.a("onResume", new Object[0]);
    }

    @Override // com.tencent.timi.game.impl.TPRoom
    public void onStart() {
        c.a("onStart", new Object[0]);
        this.f380050e.e(this.f380051f);
    }

    @Override // com.tencent.timi.game.impl.TPRoom
    public void onStop() {
        c.a(DKHippyEvent.EVENT_STOP, new Object[0]);
        this.f380050e.f();
    }
}
