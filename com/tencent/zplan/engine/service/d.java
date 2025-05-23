package com.tencent.zplan.engine.service;

import android.text.TextUtils;
import com.epicgames.ue4.GameActivityThunk;
import com.epicgames.ue4.UE4;
import com.tencent.zplan.utils.ZLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zx4.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/zplan/engine/service/d;", "", "", "i", h.F, "f", "g", "c", "Lcom/tencent/zplan/engine/service/c;", "a", "Lcom/tencent/zplan/engine/service/b;", "b", "d", "e", "j", "Lcom/tencent/zplan/engine/service/c;", "engineInitListener", "Lcom/tencent/zplan/engine/service/b;", "engineFirstFrameListener", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final d f385635c = new d();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.zplan.engine.service.c engineInitListener = new com.tencent.zplan.engine.service.c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.zplan.engine.service.b engineFirstFrameListener = new com.tencent.zplan.engine.service.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "pageCode", "", "kotlin.jvm.PlatformType", "modeCode", "eventCode", "ParamMap", "", "onCMShowReportListener"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements GameActivityThunk.CMShowReportListener {

        /* renamed from: a, reason: collision with root package name */
        public static final a f385636a = new a();

        a() {
        }

        @Override // com.epicgames.ue4.GameActivityThunk.CMShowReportListener
        public final boolean onCMShowReportListener(String pageCode, String modeCode, String eventCode, Object obj) {
            ZLog.f386189b.k("[zplan][ZPlanEngineHelper]", "setCMShowReportListenerListener pageCode: " + pageCode + ", modeCode: " + modeCode + ", eventCode: " + eventCode);
            lx4.b bVar = (lx4.b) mx4.a.f417748a.a(lx4.b.class);
            if (bVar != null) {
                Intrinsics.checkNotNullExpressionValue(pageCode, "pageCode");
                Intrinsics.checkNotNullExpressionValue(modeCode, "modeCode");
                Intrinsics.checkNotNullExpressionValue(eventCode, "eventCode");
                bVar.c(pageCode, modeCode, eventCode, (Map) obj);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onCMShowGetNetStatus"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements GameActivityThunk.CMShowGetNetStatusListener {

        /* renamed from: a, reason: collision with root package name */
        public static final b f385637a = new b();

        b() {
        }

        @Override // com.epicgames.ue4.GameActivityThunk.CMShowGetNetStatusListener
        public final int onCMShowGetNetStatus() {
            int netWorkType;
            lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
            if (aVar == null || (netWorkType = aVar.getNetWorkType()) == 0) {
                return 0;
            }
            if (netWorkType == 1) {
                return 1;
            }
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onCMShowGetProfile"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class c implements GameActivityThunk.CMShowProfileListener {

        /* renamed from: a, reason: collision with root package name */
        public static final c f385638a = new c();

        c() {
        }

        @Override // com.epicgames.ue4.GameActivityThunk.CMShowProfileListener
        public final int onCMShowGetProfile() {
            int i3;
            lx4.a aVar = (lx4.a) mx4.a.f417748a.a(lx4.a.class);
            if (aVar != null) {
                i3 = aVar.getGender();
            } else {
                i3 = 1;
            }
            ZLog.f386189b.k("[zplan][ZPlanEngineHelper]", "onCMShowGetProfile gender : " + i3);
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "level", "", "message", "", "kotlin.jvm.PlatformType", "onCMShowLog"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.engine.service.d$d, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10061d implements GameActivityThunk.CMShowLogListener {

        /* renamed from: a, reason: collision with root package name */
        public static final C10061d f385639a = new C10061d();

        C10061d() {
        }

        @Override // com.epicgames.ue4.GameActivityThunk.CMShowLogListener
        public final void onCMShowLog(int i3, String str) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            ZLog.f386189b.f("[zplan][ZPlanEngineHelper]", str);
                            return;
                        }
                        return;
                    }
                    ZLog.f386189b.o("[zplan][ZPlanEngineHelper]", str);
                    return;
                }
                ZLog.f386189b.k("[zplan][ZPlanEngineHelper]", str);
                return;
            }
            ZLog.f386189b.k("[zplan][ZPlanEngineHelper]", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "requireName", "", "kotlin.jvm.PlatformType", "requireBuffer", "", "onCMShowSend"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class e implements GameActivityThunk.CMShowSendListener {

        /* renamed from: a, reason: collision with root package name */
        public static final e f385640a = new e();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/zplan/engine/service/d$e$a", "Lzx4/n$a;", "", "success", "", "cmdName", "", "rspBuffer", "", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static final class a implements n.a {
            a() {
            }

            @Override // zx4.n.a
            public void a(boolean success, @NotNull String cmdName, @Nullable byte[] rspBuffer) {
                boolean z16;
                Intrinsics.checkNotNullParameter(cmdName, "cmdName");
                if (success && rspBuffer != null) {
                    if (rspBuffer.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        UE4.onCMShowReceiveData(cmdName, rspBuffer);
                        return;
                    }
                }
                ZLog.f386189b.f("[zplan][ZPlanEngineHelper]", "onCMShowReceive fail. messageName:" + cmdName);
                UE4.OnCMShowNetworkError(cmdName, -1);
            }
        }

        e() {
        }

        @Override // com.epicgames.ue4.GameActivityThunk.CMShowSendListener
        public final boolean onCMShowSend(String requireName, byte[] requireBuffer) {
            Integer num;
            ZLog zLog = ZLog.f386189b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onCMShowSend messageName: ");
            sb5.append(requireName);
            sb5.append(", require data size: ");
            if (requireBuffer != null) {
                num = Integer.valueOf(requireBuffer.length);
            } else {
                num = null;
            }
            sb5.append(num);
            zLog.k("[zplan][ZPlanEngineHelper]", sb5.toString());
            if (TextUtils.isEmpty(requireName)) {
                zLog.k("[zplan][ZPlanEngineHelper]", "onCMShowSend fail, invalid parameters");
                return false;
            }
            n nVar = (n) mx4.a.f417748a.a(n.class);
            if (nVar != null) {
                Intrinsics.checkNotNullExpressionValue(requireName, "requireName");
                Intrinsics.checkNotNullExpressionValue(requireBuffer, "requireBuffer");
                nVar.a(requireName, requireBuffer, new a());
                return true;
            }
            return true;
        }
    }

    d() {
    }

    private final void c() {
        UE4.setCMShowReportListenerListener(a.f385636a);
    }

    private final void f() {
        UE4.setCMShowGetNetStatusListener(b.f385637a);
    }

    private final void g() {
        UE4.setCMShowProfileListener(c.f385638a);
    }

    private final void h() {
        UE4.setCMShowLogListener(C10061d.f385639a);
    }

    private final void i() {
        UE4.setCMShowSendListener(e.f385640a);
    }

    @NotNull
    public final com.tencent.zplan.engine.service.c a() {
        return engineInitListener;
    }

    @NotNull
    public final com.tencent.zplan.engine.service.b b() {
        return engineFirstFrameListener;
    }

    public final void d() {
        UE4.setCMShowEngineInitFinishListener(engineInitListener);
    }

    public final void e() {
        UE4.setCMShowEngineFirstFrameListener(engineFirstFrameListener);
    }

    public final void j() {
        ZLog.f386189b.k("[zplan][ZPlanEngineHelper]", "initUEListener");
        i();
        c();
        f();
        h();
        g();
    }
}
