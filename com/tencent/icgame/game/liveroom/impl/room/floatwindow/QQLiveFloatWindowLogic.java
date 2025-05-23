package com.tencent.icgame.game.liveroom.impl.room.floatwindow;

import android.content.Context;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.liveroom.impl.room.floatwindow.q;
import com.tencent.mobileqq.icgame.base.room.service.lifecycle.PageLifecycle;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \r2\u00020\u0001:\u0003\u0011\u0005\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u001b\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic;", "", "Lh22/a;", "qqLiveRoomService", "", "b", "", "f", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic$b;", "permissionReqCallback", "g", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic$c;", "callback", "d", "", "e", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lfu0/c;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "c", "()Lfu0/c;", "liveRoomService", "I", "checkResult", "<init>", "(Landroid/content/Context;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class QQLiveFloatWindowLogic {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int checkResult;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic$b;", "", "", "grant", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface b {
        void a(boolean grant);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic$c;", "", "", "onSuccess", "", "reason", "", "shouldExitRoom", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface c {
        void a(int reason, boolean shouldExitRoom);

        void onSuccess();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic$d", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic$b;", "", "grant", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f115250a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h22.a f115251b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQLiveFloatWindowLogic f115252c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f115253d;

        d(long j3, h22.a aVar, QQLiveFloatWindowLogic qQLiveFloatWindowLogic, c cVar) {
            this.f115250a = j3;
            this.f115251b = aVar;
            this.f115252c = qQLiveFloatWindowLogic;
            this.f115253d = cVar;
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowLogic.b
        public void a(boolean grant) {
            a.Companion companion = rt0.a.INSTANCE;
            companion.k("ICGameAudience|ICGameFloatWindowLogic", "onRequestPermission", "roomId:" + this.f115250a + ", grant:" + grant);
            PageLifecycle curPageLifecycle = this.f115251b.getCurPageLifecycle();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pageLifecycle:");
            sb5.append(curPageLifecycle);
            companion.k("ICGameAudience|ICGameFloatWindowLogic", "onRequestPermission", sb5.toString());
            if (curPageLifecycle == PageLifecycle.PAGE_RESUME) {
                companion.k("ICGameAudience|ICGameFloatWindowLogic", "onRequestPermission", "page resume do nothing.");
                return;
            }
            if (grant) {
                this.f115252c.f(this.f115251b);
                this.f115253d.onSuccess();
            } else if (curPageLifecycle != PageLifecycle.PAGE_DESTROY && curPageLifecycle != PageLifecycle.DESTROY) {
                this.f115253d.a(1, false);
            } else {
                this.f115253d.a(1, true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/floatwindow/QQLiveFloatWindowLogic$e", "Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/q$b;", "", "from", "", "grant", "", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class e implements q.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<q> f115254a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f115255b;

        e(Ref.ObjectRef<q> objectRef, b bVar) {
            this.f115254a = objectRef;
            this.f115255b = bVar;
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.floatwindow.q.b
        public void a(@NotNull String from, boolean grant) {
            Intrinsics.checkNotNullParameter(from, "from");
            rt0.a.INSTANCE.k("ICGameAudience|ICGameFloatWindowLogic", "showPermissionRequestDialog", "onRequestPermission grant:" + grant);
            this.f115254a.element.f();
            this.f115255b.a(grant);
        }
    }

    public QQLiveFloatWindowLogic(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<fu0.c>() { // from class: com.tencent.icgame.game.liveroom.impl.room.floatwindow.QQLiveFloatWindowLogic$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fu0.c invoke() {
                return (fu0.c) qx0.a.b(fu0.c.class);
            }
        });
        this.liveRoomService = lazy;
        this.checkResult = -1;
    }

    private final int b(h22.a qqLiveRoomService) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean p16 = qqLiveRoomService.p();
        if (((fu0.c) qx0.a.b(fu0.c.class)).b3() == qqLiveRoomService.getRoomId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (p16 && z16) {
            boolean showFloatWindow = qqLiveRoomService.getShowFloatWindow();
            boolean t16 = qqLiveRoomService.t();
            if (c().N(qqLiveRoomService.getRoomId()) != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            boolean s16 = qqLiveRoomService.s();
            if (showFloatWindow && !t16 && z17 && !s16) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                rt0.a.INSTANCE.h("ICGameAudience|ICGameFloatWindowLogic", "checkShowFloatWindowCondition", "logicReady:" + z18 + ", showFloatWindow:" + showFloatWindow + ", shouldExitRoom:" + t16 + ", audienceRoomNotNull:" + z17 + ", liveClose:" + s16);
                this.checkResult = 2;
                return 2;
            }
            boolean b16 = com.tencent.icgame.game.utils.e.b(this.context);
            if (!b16) {
                rt0.a.INSTANCE.h("ICGameAudience|ICGameFloatWindowLogic", "checkShowFloatWindowCondition", "hasPermission:" + b16);
                this.checkResult = 1;
                return 1;
            }
            this.checkResult = 0;
            return 0;
        }
        rt0.a.INSTANCE.h("ICGameAudience|ICGameFloatWindowLogic", "checkShowFloatWindowCondition", "pageIn:" + p16 + ", featureOpen:true, isCurRoom:" + z16);
        this.checkResult = 2;
        return 2;
    }

    private final fu0.c c() {
        return (fu0.c) this.liveRoomService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(h22.a qqLiveRoomService) {
        boolean z16;
        String str;
        LiveRoomInfo liveRoomInfo;
        rt0.a.INSTANCE.j("ICGameAudience|ICGameFloatWindowLogic", "showFloatWindow");
        LiveRoomExtraInfo extraInfo = qqLiveRoomService.getExtraInfo();
        if (extraInfo != null) {
            z16 = extraInfo.c();
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        QQLiveFloatWindowManager qQLiveFloatWindowManager = QQLiveFloatWindowManager.f115256a;
        long roomId = qqLiveRoomService.getRoomId();
        LiveInfo curLiveInfo = qqLiveRoomService.getCurLiveInfo();
        if (curLiveInfo != null && (liveRoomInfo = curLiveInfo.roomInfo) != null) {
            str = liveRoomInfo.roomLogo;
        } else {
            str = null;
        }
        qQLiveFloatWindowManager.y(new QQLiveFloatWindowParams(roomId, str, qqLiveRoomService.getIntent(), z17));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.icgame.game.liveroom.impl.room.floatwindow.q, T] */
    private final void g(b permissionReqCallback) {
        rt0.a.INSTANCE.j("ICGameAudience|ICGameFloatWindowLogic", "showPermissionRequestDialog");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? qVar = new q();
        objectRef.element = qVar;
        qVar.i(new e(objectRef, permissionReqCallback));
        ((q) objectRef.element).h();
    }

    public final void d(@NotNull h22.a qqLiveRoomService, @NotNull c callback) {
        String str;
        LiveAnchorInfo liveAnchorInfo;
        Intrinsics.checkNotNullParameter(qqLiveRoomService, "qqLiveRoomService");
        Intrinsics.checkNotNullParameter(callback, "callback");
        long roomId = qqLiveRoomService.getRoomId();
        LiveInfo curLiveInfo = qqLiveRoomService.getCurLiveInfo();
        if (curLiveInfo != null && (liveAnchorInfo = curLiveInfo.anchorInfo) != null) {
            str = liveAnchorInfo.nickName;
        } else {
            str = null;
        }
        int b16 = b(qqLiveRoomService);
        rt0.a.INSTANCE.k("ICGameAudience|ICGameFloatWindowLogic", "handleFloatWindowLogic", "roomId:" + roomId + ", anchorNick:" + str + ", checkResult:" + b16);
        if (b16 != 0) {
            if (b16 != 1) {
                callback.a(b16, false);
                return;
            } else {
                g(new d(roomId, qqLiveRoomService, this, callback));
                return;
            }
        }
        f(qqLiveRoomService);
        callback.onSuccess();
    }

    public final boolean e() {
        int i3 = this.checkResult;
        if (i3 != -1 && i3 != 2) {
            return false;
        }
        return true;
    }
}
