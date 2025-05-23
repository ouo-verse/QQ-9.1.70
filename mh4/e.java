package mh4;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mh4.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lmh4/e;", "", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout;", "worldScaleLayout", "", "e", tl.h.F, "", "notifyPageClose", "g", "Lgh4/e;", "a", "Lgh4/e;", "mHall", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "mRootView", "Lcom/tencent/mobileqq/app/QBaseActivity;", "c", "Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "d", "Z", "mNotifyRoomPageCloseAlreadyDone", "<init>", "(Lgh4/e;Landroid/view/ViewGroup;Lcom/tencent/mobileqq/app/QBaseActivity;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gh4.e mHall;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup mRootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity qBaseActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mNotifyRoomPageCloseAlreadyDone;

    public e(@NotNull gh4.e mHall, @NotNull ViewGroup mRootView, @NotNull QBaseActivity qBaseActivity) {
        Intrinsics.checkNotNullParameter(mHall, "mHall");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(qBaseActivity, "qBaseActivity");
        this.mHall = mHall;
        this.mRootView = mRootView;
        this.qBaseActivity = qBaseActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(WorldScaleLayout worldScaleLayout) {
        worldScaleLayout.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(@Nullable final WorldScaleLayout worldScaleLayout) {
        T t16;
        PBUInt64Field pBUInt64Field;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        YoloRoomOuterClass$YoloRoomInfo j06 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
        if (j06 != null && (pBUInt64Field = j06.room_id) != null) {
            t16 = Long.valueOf(pBUInt64Field.get());
        } else {
            t16 = 0;
        }
        objectRef.element = t16;
        if (worldScaleLayout != null) {
            worldScaleLayout.setMaxRoundRate(0.2f);
        }
        if (worldScaleLayout != null) {
            worldScaleLayout.setWorldScaleListener(new a(objectRef, worldScaleLayout, this));
        }
        if (this.mHall.O().E) {
            ViewGroup viewGroup = this.mRootView;
            if (viewGroup != null) {
                viewGroup.setVisibility(4);
            }
            if (worldScaleLayout != null) {
                worldScaleLayout.post(new Runnable() { // from class: mh4.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.f(WorldScaleLayout.this);
                    }
                });
                return;
            }
            return;
        }
        YoloRoomOuterClass$YoloRoomInfo j07 = ((fm4.g) mm4.b.b(fm4.g.class)).j0(5);
        if (j07 != null) {
            fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
            long j3 = j07.room_id.get();
            gh4.e eVar = this.mHall;
            Intrinsics.checkNotNull(eVar, "null cannot be cast to non-null type com.tencent.timi.game.room.api.IRoomPage");
            gVar.B1(j3, eVar);
        }
    }

    public final void g(boolean notifyPageClose) {
        this.mNotifyRoomPageCloseAlreadyDone = notifyPageClose;
    }

    public final void h() {
        QBaseActivity qBaseActivity = this.qBaseActivity;
        boolean b16 = this.mHall.O().b(2);
        boolean c16 = com.tencent.timi.game.utils.g.c(qBaseActivity);
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "tryNotifyPageClose isNotGuild:" + b16 + ", hasFloatingPermission:" + c16 + ",mNotifyRoomPageCloseAlreadyDone:" + this.mNotifyRoomPageCloseAlreadyDone);
        if (b16 && c16 && !this.mNotifyRoomPageCloseAlreadyDone) {
            fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
            long ue5 = this.mHall.ue();
            gh4.e eVar = this.mHall;
            Intrinsics.checkNotNull(eVar, "null cannot be cast to non-null type com.tencent.timi.game.room.api.IRoomPage");
            gVar.t1(ue5, eVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"mh4/e$a", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout$c;", "", "c", "d", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements WorldScaleLayout.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Long> f416802a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WorldScaleLayout f416803b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f416804c;

        a(Ref.ObjectRef<Long> objectRef, WorldScaleLayout worldScaleLayout, e eVar) {
            this.f416802a = objectRef;
            this.f416803b = worldScaleLayout;
            this.f416804c = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(WorldScaleLayout worldScaleLayout, final e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            worldScaleLayout.setVisibility(8);
            worldScaleLayout.post(new Runnable() { // from class: mh4.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.i(e.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QBaseActivity qBaseActivity = this$0.qBaseActivity;
            if (qBaseActivity != null) {
                qBaseActivity.overridePendingTransition(0, 0);
            }
            QBaseActivity qBaseActivity2 = this$0.qBaseActivity;
            if (qBaseActivity2 != null) {
                qBaseActivity2.finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void j(Ref.ObjectRef roomId, e this$0) {
            long j3;
            Intrinsics.checkNotNullParameter(roomId, "$roomId");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
            Long l3 = (Long) roomId.element;
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            gh4.e eVar = this$0.mHall;
            Intrinsics.checkNotNull(eVar, "null cannot be cast to non-null type com.tencent.timi.game.room.api.IRoomPage");
            gVar.B1(j3, eVar);
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.c
        public void a() {
            uh4.b c16 = uh4.a.INSTANCE.a().c(String.valueOf(this.f416802a.element));
            WorldScaleLayout worldScaleLayout = this.f416803b;
            if (worldScaleLayout != null) {
                worldScaleLayout.t(c16.getCenterX(), c16.getCenterY(), c16.getSize(), c16.getPreDrawBitmap());
            }
            ViewGroup viewGroup = this.f416804c.mRootView;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            WorldScaleLayout worldScaleLayout2 = this.f416803b;
            if (worldScaleLayout2 != null) {
                final Ref.ObjectRef<Long> objectRef = this.f416802a;
                final e eVar = this.f416804c;
                worldScaleLayout2.post(new Runnable() { // from class: mh4.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.j(Ref.ObjectRef.this, eVar);
                    }
                });
            }
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.c
        public void c() {
            uh4.b c16 = uh4.a.INSTANCE.a().c(String.valueOf(this.f416802a.element));
            WorldScaleLayout worldScaleLayout = this.f416803b;
            if (worldScaleLayout != null) {
                worldScaleLayout.t(c16.getCenterX(), c16.getCenterY(), c16.getSize(), c16.getPreDrawBitmap());
            }
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.c
        public void d() {
            QBaseActivity qBaseActivity = this.f416804c.qBaseActivity;
            if (qBaseActivity != null) {
                qBaseActivity.overridePendingTransition(0, 0);
            }
            fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
            long ue5 = this.f416804c.mHall.ue();
            gh4.e eVar = this.f416804c.mHall;
            Intrinsics.checkNotNull(eVar, "null cannot be cast to non-null type com.tencent.timi.game.room.api.IRoomPage");
            gVar.t1(ue5, eVar);
            this.f416804c.mHall.Ig(true);
            final WorldScaleLayout worldScaleLayout = this.f416803b;
            if (worldScaleLayout != null) {
                final e eVar2 = this.f416804c;
                worldScaleLayout.post(new Runnable() { // from class: mh4.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.h(WorldScaleLayout.this, eVar2);
                    }
                });
            }
        }

        @Override // com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout.c
        public void b() {
        }
    }
}
