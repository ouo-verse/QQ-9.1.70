package com.tencent.filament.zplan.record;

import com.tencent.filament.zplanservice.util.log.FLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/filament/zplan/record/FilamentRecordNativeApp$loadSoListener$1", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentRecordNativeApp$loadSoListener$1 implements gl0.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FilamentRecordNativeApp f105807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilamentRecordNativeApp$loadSoListener$1(FilamentRecordNativeApp filamentRecordNativeApp) {
        this.f105807a = filamentRecordNativeApp;
    }

    @Override // gl0.b
    public void a(boolean isSuccess, boolean downloadSo, int errCode, @Nullable String errMsg) {
        al0.a aVar;
        al0.a aVar2;
        aVar = this.f105807a.loadSoStep;
        aVar.i(al0.a.INSTANCE.b());
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("load so. isSuccess: ");
        sb5.append(isSuccess);
        sb5.append(", errCode: ");
        sb5.append(errCode);
        sb5.append(", errMsg: ");
        sb5.append(errMsg);
        sb5.append(", costTime:");
        aVar2 = this.f105807a.loadSoStep;
        sb5.append(aVar2.f());
        fLog.i("[zplan][MemePlayer-SDK][FilamentRecordNativeApp]", sb5.toString());
        if (isSuccess) {
            this.f105807a.C("init", new Function0<Unit>() { // from class: com.tencent.filament.zplan.record.FilamentRecordNativeApp$loadSoListener$1$onComplete$1
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
                    AtomicBoolean atomicBoolean;
                    FilamentRecordNativeApp$loadSoListener$1.this.f105807a.U();
                    atomicBoolean = FilamentRecordNativeApp$loadSoListener$1.this.f105807a.appInitFinish;
                    atomicBoolean.set(true);
                    FilamentRecordNativeApp$loadSoListener$1.this.f105807a.D();
                }
            });
        }
    }
}
