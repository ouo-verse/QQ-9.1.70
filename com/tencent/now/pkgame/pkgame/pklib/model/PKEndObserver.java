package com.tencent.now.pkgame.pkgame.pklib.model;

import com.tencent.component.core.event.EventCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qphone.base.util.QLog;
import hn3.PKEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rx.Observable;
import rx.functions.Action1;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/pklib/model/PKEndObserver;", "", "Lcom/tencent/now/pkgame/pkgame/pklib/time/a;", "pkTimer", "", "d", "", IOnlineStatusService.REMAIN_TIME, "c", "a", "Lcom/tencent/now/pkgame/pkgame/pklib/time/a;", "getPkTimer", "()Lcom/tencent/now/pkgame/pkgame/pklib/time/a;", "Lco3/d;", "b", "Lco3/d;", "pkEventInfoMode", "<init>", "(Lcom/tencent/now/pkgame/pkgame/pklib/time/a;Lco3/d;)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PKEndObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.now.pkgame.pkgame.pklib.time.a pkTimer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final co3.d pkEventInfoMode;

    public PKEndObserver(@NotNull com.tencent.now.pkgame.pkgame.pklib.time.a pkTimer, @NotNull co3.d pkEventInfoMode) {
        Intrinsics.checkNotNullParameter(pkTimer, "pkTimer");
        Intrinsics.checkNotNullParameter(pkEventInfoMode, "pkEventInfoMode");
        this.pkTimer = pkTimer;
        this.pkEventInfoMode = pkEventInfoMode;
        d(pkTimer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(long remainTime) {
        if (remainTime == 0) {
            EventCenter.post(new PKEvent(1, 6, null, 0L, 0, 28, null));
        }
        if (this.pkTimer.getPunishmentTimeSec() == 0 && remainTime == -1000) {
            QLog.i("PKEndObserver", 1, "No punishment, PKEnd");
            PKEvent curPKEvent = this.pkEventInfoMode.getCurPKEvent();
            if (curPKEvent != null) {
                this.pkEventInfoMode.h(new PKEvent(2, curPKEvent.getPkStatus(), curPKEvent.getAnchorInfo(), curPKEvent.getPkId(), curPKEvent.getPkType()));
                return;
            }
            return;
        }
        if (this.pkTimer.getPunishmentTimeSec() > 0 && remainTime + (this.pkTimer.getPunishmentTimeSec() * 1000) == 1000) {
            QLog.i("PKEndObserver", 1, "Punishment end, PKEnd.");
            PKEvent curPKEvent2 = this.pkEventInfoMode.getCurPKEvent();
            if (curPKEvent2 != null) {
                this.pkEventInfoMode.h(new PKEvent(2, curPKEvent2.getPkStatus(), curPKEvent2.getAnchorInfo(), curPKEvent2.getPkId(), curPKEvent2.getPkType()));
            }
        }
    }

    private final void d(com.tencent.now.pkgame.pkgame.pklib.time.a pkTimer) {
        Observable<Long> a16 = pkTimer.a();
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.now.pkgame.pkgame.pklib.model.PKEndObserver$observePKEnd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long count) {
                PKEndObserver pKEndObserver = PKEndObserver.this;
                Intrinsics.checkNotNullExpressionValue(count, "count");
                pKEndObserver.c(count.longValue());
            }
        };
        a16.subscribe(new Action1() { // from class: com.tencent.now.pkgame.pkgame.pklib.model.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PKEndObserver.e(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }
}
