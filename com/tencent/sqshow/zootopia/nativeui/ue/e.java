package com.tencent.sqshow.zootopia.nativeui.ue;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.ue.e;
import com.tencent.zplan.luabridge.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.am;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0018B\u0013\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b.\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\"\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\"\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u0006/"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/e;", "", "", "o", "u", "g", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "cameraId", "", "from", "w", "j", "k", tl.h.F, "i", "", "withoutBlend", "withDelay", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "bodyItemId", "l", "p", "Lb94/a;", "a", "Lb94/a;", "getEngineApi", "()Lb94/a;", "t", "(Lb94/a;)V", "engineApi", "Lcom/tencent/sqshow/zootopia/utils/j;", "b", "Lcom/tencent/sqshow/zootopia/utils/j;", "currentTargetCameraId", "c", "currentSetSucceedCameraId", "d", "Z", "setCameraIsRunning", "e", "disableCameraUpdate", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "setCameraPendingTask", "<init>", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private b94.a engineApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.utils.j<CameraKey> currentTargetCameraId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.utils.j<CameraKey> currentSetSucceedCameraId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean setCameraIsRunning;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean disableCameraUpdate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Runnable setCameraPendingTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/e$b", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CameraKey f371350d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f371351e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f371352f;

        b(CameraKey cameraKey, String str, e eVar) {
            this.f371350d = cameraKey;
            this.f371351e = str;
            this.f371352f = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(e this$0, CameraKey cameraId) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(cameraId, "$cameraId");
            this$0.currentSetSucceedCameraId.e(cameraId);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            QLog.i("AvatarCameraController_", 1, "setCameraId-onLuaResult cameraId:" + this.f371350d + ", success:" + success + ", result:" + result + ", from:" + this.f371351e);
            this.f371352f.o();
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final e eVar = this.f371352f;
            final CameraKey cameraKey = this.f371350d;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.f
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.b(e.this, cameraKey);
                }
            });
        }
    }

    public e(b94.a aVar) {
        this.engineApi = aVar;
        this.currentTargetCameraId = new com.tencent.sqshow.zootopia.utils.j<>(null, new CameraKey(0, 0, 2, null), null, 5, null);
        this.currentSetSucceedCameraId = new com.tencent.sqshow.zootopia.utils.j<>(null, new CameraKey(0, 0, 2, null), null, 5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(e this$0, CameraKey currentCameraId, String from, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentCameraId, "$currentCameraId");
        Intrinsics.checkNotNullParameter(from, "$from");
        CameraKey j3 = this$0.j();
        QLog.i("AvatarCameraController_", 1, "refreshCurrentCameraId currentCameraId:" + currentCameraId + ", currentCameraIdNow:" + j3);
        if (Intrinsics.areEqual(j3, currentCameraId)) {
            this$0.p(currentCameraId, "refreshCurrentCameraId-" + from, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(e this$0, CameraKey cameraId, String from) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cameraId, "$cameraId");
        Intrinsics.checkNotNullParameter(from, "$from");
        q(this$0, cameraId, from, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    private final void u() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.d
            @Override // java.lang.Runnable
            public final void run() {
                e.v(e.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Runnable runnable = this$0.setCameraPendingTask;
        this$0.g();
        if (runnable != null) {
            runnable.run();
        }
    }

    public final CameraKey j() {
        CameraKey b16 = this.currentTargetCameraId.b();
        QLog.i("AvatarCameraController_", 1, "getCurrentCameraId cameraId:" + b16);
        return b16;
    }

    public final CameraKey k() {
        CameraKey b16 = this.currentSetSucceedCameraId.b();
        QLog.i("AvatarCameraController_", 1, "getCurrentSetSucceedCameraId cameraId:" + b16);
        return b16;
    }

    public final void l(int bodyItemId) {
        int bodyItemId2 = this.currentTargetCameraId.b().getBodyItemId();
        QLog.i("AvatarCameraController_", 1, "onBodyIdUpdate currentBodyItemId:" + bodyItemId2 + ", bodyItemId:" + bodyItemId);
        if (bodyItemId2 == bodyItemId) {
            return;
        }
        q(this, new CameraKey(this.currentTargetCameraId.b().getCameraId(), bodyItemId), "onBodyIdUpdate", false, 4, null);
    }

    public final void m(final String from, final boolean withoutBlend, boolean withDelay) {
        Intrinsics.checkNotNullParameter(from, "from");
        final CameraKey j3 = j();
        QLog.i("AvatarCameraController_", 1, "refreshCurrentCameraId currentCameraId:" + j3 + ", withDelay:" + withDelay + ", withoutBlend:" + withoutBlend);
        if (withDelay) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.n(e.this, j3, from, withoutBlend);
                }
            }, 450L);
            return;
        }
        p(j3, "refreshCurrentCameraId-" + from, withoutBlend);
    }

    public final void p(final CameraKey cameraId, final String from, boolean withoutBlend) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(from, "from");
        am b16 = j94.a.f409675a.b(cameraId);
        if (b16 == null) {
            QLog.e("AvatarCameraController_", 1, "setCameraId cameraConfig of cameraId(" + cameraId + ") is null!");
            return;
        }
        QLog.i("AvatarCameraController_", 1, "setCameraId cameraId:" + cameraId + ", from:" + from);
        this.currentTargetCameraId.e(cameraId);
        boolean z16 = this.setCameraIsRunning;
        if (!z16 && !this.disableCameraUpdate) {
            QLog.i("AvatarCameraController_", 1, "setCameraId cameraId:" + cameraId + ", setCameraIsRunning:" + z16 + ", from:" + from);
            if (withoutBlend) {
                b16 = bj3.a.k(b16);
                b16.f440168l = 0.0f;
            }
            this.setCameraIsRunning = true;
            String jSONObject = r94.c.u(b16).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "cameraConfig.toJson().toString()");
            QLog.i("AvatarCameraController_", 1, "setCameraId params:" + jSONObject);
            b94.a aVar = this.engineApi;
            if (aVar != null) {
                aVar.l(jSONObject, new b(cameraId, from, this));
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.s(e.this);
                }
            }, 5000L);
            return;
        }
        QLog.w("AvatarCameraController_", 1, "setCameraId setCameraIsRunning || disableCameraUpdate, cache to pending task. cameraId:" + cameraId + ", from:" + from);
        this.setCameraPendingTask = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.a
            @Override // java.lang.Runnable
            public final void run() {
                e.r(e.this, cameraId, from);
            }
        };
    }

    public final void t(b94.a aVar) {
        this.engineApi = aVar;
    }

    public final void w(CameraKey cameraId, String from) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i("AvatarCameraController_", 1, "updateCamaraId cameraId:" + cameraId + ", from:" + from);
        this.currentTargetCameraId.e(cameraId);
        this.currentSetSucceedCameraId.e(cameraId);
        g();
    }

    private final void g() {
        this.setCameraPendingTask = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.setCameraIsRunning = false;
        u();
    }

    public final void h() {
        this.disableCameraUpdate = true;
    }

    public final void i() {
        this.disableCameraUpdate = false;
        u();
    }

    public /* synthetic */ e(b94.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar);
    }

    public static /* synthetic */ void q(e eVar, CameraKey cameraKey, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        eVar.p(cameraKey, str, z16);
    }
}
