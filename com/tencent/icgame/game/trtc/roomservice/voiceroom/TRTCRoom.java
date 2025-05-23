package com.tencent.icgame.game.trtc.roomservice.voiceroom;

import ay0.c;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.icgame.game.impl.TPRoom;
import com.tencent.icgame.game.trtc.TRTCInstance;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import yx0.a;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TRTCRoom extends TPRoom {

    /* renamed from: e, reason: collision with root package name */
    private TRTCInstance f115900e;

    /* renamed from: f, reason: collision with root package name */
    public final a f115901f;

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

    @Override // com.tencent.icgame.game.impl.TPRoom
    public void onCreate() {
        c.a("onCreate", new Object[0]);
        TRTCInstance tRTCInstance = new TRTCInstance();
        this.f115900e = tRTCInstance;
        tRTCInstance.b(this.f115901f);
        e();
        a();
        d();
    }

    @Override // com.tencent.icgame.game.impl.TPRoom
    public void onDestroy() {
        c.a(MosaicConstants$JsFunction.FUNC_ON_DESTROY, new Object[0]);
        this.f115900e.d();
        f();
    }

    @Override // com.tencent.icgame.game.impl.TPRoom
    public void onPause() {
        c.a(MiniSDKConst.NOTIFY_EVENT_ONPAUSE, new Object[0]);
    }

    @Override // com.tencent.icgame.game.impl.TPRoom
    public void onResume() {
        c.a("onResume", new Object[0]);
    }

    @Override // com.tencent.icgame.game.impl.TPRoom
    public void onStart() {
        c.a("onStart", new Object[0]);
        this.f115900e.e(this.f115901f);
    }

    @Override // com.tencent.icgame.game.impl.TPRoom
    public void onStop() {
        c.a(DKHippyEvent.EVENT_STOP, new Object[0]);
        this.f115900e.f();
    }
}
