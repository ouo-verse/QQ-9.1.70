package com.tencent.mobileqq.guild.window;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.notify.ax;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.window.usecase.PlayTogetherFloatWindowUseCase;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/window/GuildPlayTogetherFloatWrapper;", "Lcom/tencent/mobileqq/guild/window/a;", "", "Y0", "X0", "", "W0", "Lcom/tencent/mobileqq/guild/window/usecase/PlayTogetherFloatWindowUseCase;", "V0", "L0", "A0", "Q0", "initStatusReceiver", "com/tencent/mobileqq/guild/window/GuildPlayTogetherFloatWrapper$c", "J", "Lcom/tencent/mobileqq/guild/window/GuildPlayTogetherFloatWrapper$c;", "thirdAppInfoUpdateObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class GuildPlayTogetherFloatWrapper extends a {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final c thirdAppInfoUpdateObserver;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/window/GuildPlayTogetherFloatWrapper$a;", "", "Landroid/view/View;", "a", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.window.GuildPlayTogetherFloatWrapper$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final View a() {
            View inflate = View.inflate(BaseApplication.getContext(), R.layout.egi, null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               \u2026       null\n            )");
            return inflate;
        }

        public final void b() {
            GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
            String name = GuildPlayTogetherFloatWrapper.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "GuildPlayTogetherFloatWrapper::class.java.name");
            guildFloatWindowManager.g(name);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/window/GuildPlayTogetherFloatWrapper$b", "Lgh2/f;", "", "c", "a", "", "canPlay", "d", "b", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements gh2.f {
        b() {
        }

        @Override // gh2.f
        public void a() {
            Logger logger = Logger.f235387a;
            logger.d().d(GuildPlayTogetherFloatWrapper.this.getTag(), 1, "onWindowHide:");
            GuildPlayTogetherFloatWrapper.this.X0();
        }

        @Override // gh2.f
        public void b() {
            Logger logger = Logger.f235387a;
            logger.d().d(GuildPlayTogetherFloatWrapper.this.getTag(), 1, "onWindowDismiss:");
        }

        @Override // gh2.f
        public void c() {
            Logger logger = Logger.f235387a;
            logger.d().d(GuildPlayTogetherFloatWrapper.this.getTag(), 1, "onWindowPause:");
        }

        @Override // gh2.f
        public void d(boolean canPlay) {
            Logger logger = Logger.f235387a;
            logger.d().d(GuildPlayTogetherFloatWrapper.this.getTag(), 1, "onWindowShow:");
            GuildPlayTogetherFloatWrapper.this.Y0();
        }

        @Override // gh2.f
        public void e() {
            Logger logger = Logger.f235387a;
            logger.d().d(GuildPlayTogetherFloatWrapper.this.getTag(), 1, "onWindowResume:");
            GuildPlayTogetherFloatWrapper.this.Y0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/window/GuildPlayTogetherFloatWrapper$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ax;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<ax> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ax event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger logger = Logger.f235387a;
            logger.d().i(GuildPlayTogetherFloatWrapper.this.getTag(), 1, "thirdAppInfoUpdateObserver onEventReceive");
            if (GuildPlayTogetherFloatWrapper.this.W0()) {
                ((PlayTogetherFloatWindowUseCase) GuildPlayTogetherFloatWrapper.this.N0()).l0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildPlayTogetherFloatWrapper(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.thirdAppInfoUpdateObserver = new c();
        J0("QGMC.MediaThirdApp.GuildPlayTogetherFloatWrapper");
        I0(true);
        H0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W0() {
        if (!t() && u() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0() {
        if (W0()) {
            U(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0() {
        if (!W0()) {
            ((PlayTogetherFloatWindowUseCase) N0()).l0();
            U(true);
        }
    }

    @Override // com.tencent.mobileqq.guild.window.a, com.tencent.mobileqq.guild.window.c
    protected void A0() {
        super.A0();
        Logger logger = Logger.f235387a;
        logger.d().d(getTag(), 1, "[onQuit] ");
        com.tencent.mobileqq.guild.media.core.j.d().j(ax.class, this.thirdAppInfoUpdateObserver);
        ((PlayTogetherFloatWindowUseCase) N0()).a0();
    }

    @Override // com.tencent.mobileqq.guild.window.a
    protected void L0() {
        super.L0();
        com.tencent.mobileqq.guild.media.core.j.d().V(ax.class, this.thirdAppInfoUpdateObserver);
    }

    @Override // com.tencent.mobileqq.guild.window.a
    public void Q0() {
        Logger logger = Logger.f235387a;
        logger.d().d(getTag(), 1, "[quitSelf] ");
        INSTANCE.b();
    }

    @Override // com.tencent.mobileqq.guild.window.a
    @NotNull
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public PlayTogetherFloatWindowUseCase O0() {
        return new PlayTogetherFloatWindowUseCase(t0(), r0(), this);
    }

    @Override // com.tencent.mobileqq.guild.window.c, com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        g(-1, new b());
    }
}
