package com.tencent.filament.zplan.render.impl;

import android.os.Handler;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.engine.js.FilamentEventDispatcher;
import com.tencent.filament.zplan.util.CoroutineUtilKt;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/filament/zplan/render/impl/FilamentNativeApp$loadSoListener$1", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentNativeApp$loadSoListener$1 implements gl0.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FilamentNativeApp f105864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilamentNativeApp$loadSoListener$1(FilamentNativeApp filamentNativeApp) {
        this.f105864a = filamentNativeApp;
    }

    @Override // gl0.b
    public void a(boolean isSuccess, boolean downloadSo, int errCode, @Nullable String errMsg) {
        com.tencent.zplan.zplantracing.b bVar;
        com.tencent.zplan.zplantracing.b bVar2;
        com.tencent.zplan.zplantracing.b bVar3;
        if (isSuccess) {
            bVar2 = this.f105864a.loadSoSpan;
            if (bVar2 != null) {
                bVar2.e("download_so", String.valueOf(downloadSo));
            }
            bVar3 = this.f105864a.loadSoSpan;
            if (bVar3 != null) {
                bVar3.b();
            }
        } else {
            bVar = this.f105864a.loadSoSpan;
            if (bVar != null) {
                bVar.a("download_fail");
            }
        }
        this.f105864a.loadSoSpan = null;
        this.f105864a.startUpTrack.e(isSuccess, downloadSo);
        FLog fLog = FLog.INSTANCE;
        fLog.i("FilamentNativeApp", "load so. isSuccess: " + isSuccess + ", errCode: " + errCode + ", errMsg: " + errMsg);
        if (this.f105864a.appStatus.get() == 3) {
            fLog.i("FilamentNativeApp", "app already destroy");
            vk0.a.k(this.f105864a.startUpTrack, String.valueOf(this.f105864a.appStatus.get()), 201011, null, 4, null);
            return;
        }
        if (isSuccess) {
            this.f105864a.q0("init", new Function0<Unit>() { // from class: com.tencent.filament.zplan.render.impl.FilamentNativeApp$loadSoListener$1$onComplete$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Handler C0;
                    FilamentViewerV2 filamentViewerV2;
                    FilamentEventDispatcher t06;
                    String str;
                    FilamentNativeApp$recordFrameListener$1 filamentNativeApp$recordFrameListener$1;
                    Thread currentThread = Thread.currentThread();
                    Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                    long id5 = currentThread.getId();
                    FilamentNativeApp filamentNativeApp = FilamentNativeApp$loadSoListener$1.this.f105864a;
                    C0 = FilamentNativeApp$loadSoListener$1.this.f105864a.C0();
                    filamentNativeApp.viewer = new FilamentViewerV2(id5, CoroutineUtilKt.a(C0));
                    filamentViewerV2 = FilamentNativeApp$loadSoListener$1.this.f105864a.viewer;
                    if (filamentViewerV2 != null) {
                        filamentNativeApp$recordFrameListener$1 = FilamentNativeApp$loadSoListener$1.this.f105864a.recordFrameListener;
                        filamentViewerV2.recordFrame(filamentNativeApp$recordFrameListener$1);
                    }
                    FilamentNativeApp$loadSoListener$1.this.f105864a.appStatus.set(1);
                    t06 = FilamentNativeApp$loadSoListener$1.this.f105864a.t0();
                    JSONObject loadSoStatistic = FilamentNativeApp$loadSoListener$1.this.f105864a.startUpTrack.getLoadSoStatistic();
                    if (loadSoStatistic == null || (str = loadSoStatistic.toString()) == null) {
                        str = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "startUpTrack.getLoadSoStep()?.toString() ?: \"\"");
                    t06.onEvent("onSoLoadFinish", str);
                    FilamentNativeApp$loadSoListener$1.this.f105864a.s0();
                }
            });
            return;
        }
        this.f105864a.appStatus.set(2);
        this.f105864a.startUpTrack.j(String.valueOf(this.f105864a.appStatus.get()), 201012, errCode + '-' + errMsg);
    }
}
