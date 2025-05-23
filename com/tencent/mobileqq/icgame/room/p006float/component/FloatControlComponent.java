package com.tencent.mobileqq.icgame.room.p006float.component;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowLogic;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowManager;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.a;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.icgame.room.displayview.component.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import rt0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/float/component/FloatControlComponent;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", ReportConstant.COSTREPORT_PREFIX, "p", "k", "i", DomainData.DOMAIN_NAME, "c", "o", "w", "", "isPageClosed", "shouldExitRoom", HippyTKDListViewAdapter.X, "v", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lcom/tencent/mobileqq/icgame/room/displayview/component/a;", "liveRoomDisplayService", "Lcom/tencent/mobileqq/icgame/room/displayview/component/a;", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic;", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic;", "floatWindowLogic", "f", "Z", "getEnterFloatWindowWhenActivityStop", "()Z", "y", "(Z)V", "enterFloatWindowWhenActivityStop", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/a;", h.F, "Lkotlin/Lazy;", "r", "()Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/a;", "floatWindowChanceDetector", "Lf32/a;", "cc", "<init>", "(Lf32/a;)V", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FloatControlComponent extends com.tencent.mobileqq.icgame.framework.component.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQLiveFloatWindowLogic floatWindowLogic;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean enterFloatWindowWhenActivityStop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy floatWindowChanceDetector;

    @InjectService(key = a.class)
    private a liveRoomDisplayService;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/icgame/room/float/component/FloatControlComponent$b", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/a$b;", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements a.b {
        b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatControlComponent(@NotNull f32.a cc5) {
        super(cc5);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(cc5, "cc");
        this.floatWindowLogic = new QQLiveFloatWindowLogic(cc5.getContext());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.icgame.game.liveroom.impl.room.floatwindow.a>() { // from class: com.tencent.mobileqq.icgame.room.float.component.FloatControlComponent$floatWindowChanceDetector$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.icgame.game.liveroom.impl.room.floatwindow.a invoke() {
                return new com.tencent.icgame.game.liveroom.impl.room.floatwindow.a();
            }
        });
        this.floatWindowChanceDetector = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        rt0.a.INSTANCE.j("ICGameAudience|ICGameFloatControlComponent", "audienceExitRoom");
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        QQLiveFloatWindowManager.f115256a.k(aVar.getRoomId());
    }

    private final com.tencent.icgame.game.liveroom.impl.room.floatwindow.a r() {
        return (com.tencent.icgame.game.liveroom.impl.room.floatwindow.a) this.floatWindowChanceDetector.getValue();
    }

    private final void s() {
        QQLiveFloatWindowLogic qQLiveFloatWindowLogic = this.floatWindowLogic;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        qQLiveFloatWindowLogic.d(aVar, new c());
    }

    public final void c() {
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar3;
        }
        boolean p16 = aVar2.p();
        rt0.a.INSTANCE.k("ICGameAudience|ICGameFloatControlComponent", "activityPause", "roomId:" + roomId + ", isPageIn:" + p16);
        if (!p16) {
            return;
        }
        r().d(new b());
    }

    public final void n() {
        a.Companion companion = rt0.a.INSTANCE;
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        companion.k("ICGameAudience|ICGameFloatControlComponent", "activityResume", "roomId:" + aVar.getRoomId());
        r().e();
    }

    public final void o() {
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar3;
        }
        boolean p16 = aVar2.p();
        rt0.a.INSTANCE.k("ICGameAudience|ICGameFloatControlComponent", "activityStop", "roomId:" + roomId + ", isPageIn:" + p16 + ", enterFloatWindow " + this.enterFloatWindowWhenActivityStop);
        if (p16 && this.enterFloatWindowWhenActivityStop) {
            s();
        }
    }

    public final void q() {
        rt0.a.INSTANCE.j("ICGameAudience|ICGameFloatControlComponent", "floatClosed");
        QQLiveFloatWindowManager qQLiveFloatWindowManager = QQLiveFloatWindowManager.f115256a;
        qQLiveFloatWindowManager.p();
        h22.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        qQLiveFloatWindowManager.l(aVar.getRoomId(), false);
    }

    /* renamed from: t, reason: from getter */
    public final boolean getEnterFloatWindowWhenActivityStop() {
        return this.enterFloatWindowWhenActivityStop;
    }

    public final void u() {
        rt0.a.INSTANCE.j("ICGameAudience|ICGameFloatControlComponent", "onExitFloatWindow");
        this.enterFloatWindowWhenActivityStop = false;
    }

    public final void v() {
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar3;
        }
        boolean p16 = aVar2.p();
        rt0.a.INSTANCE.k("ICGameAudience|ICGameFloatControlComponent", "pageDestroy", "roomId:" + roomId + ", isPageIn:" + p16);
        r().e();
    }

    public final void w() {
        com.tencent.icgame.game.liveroom.impl.room.floatwindow.a r16 = r();
        String className = Foreground.getTopActivity().getComponentName().getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "getTopActivity().componentName.className");
        r16.f(className);
    }

    public final void x(boolean isPageClosed, boolean shouldExitRoom) {
        h22.a aVar = this.qqLiveRoomService;
        h22.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        if (!aVar.p()) {
            return;
        }
        if (shouldExitRoom || this.floatWindowLogic.e()) {
            p();
        }
        a.Companion companion = rt0.a.INSTANCE;
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar3;
        }
        companion.k("ICGameAudience|ICGameFloatControlComponent", "pageOut", "roomId:" + aVar2.getRoomId());
        r().e();
    }

    public final void y(boolean z16) {
        this.enterFloatWindowWhenActivityStop = z16;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/room/float/component/FloatControlComponent$c", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic$c;", "", "onSuccess", "", "reason", "", "shouldExitRoom", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements QQLiveFloatWindowLogic.c {
        c() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowLogic.c
        public void a(int reason, boolean shouldExitRoom) {
            if (shouldExitRoom) {
                FloatControlComponent.this.p();
            }
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowLogic.c
        public void onSuccess() {
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
