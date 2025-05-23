package com.tencent.mobileqq.guild.window;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.notify.am;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/window/GuildGameFloatWrapper;", "Lcom/tencent/mobileqq/guild/window/a;", "Lcom/tencent/mobileqq/guild/window/usecase/n;", "S0", "", "L0", "A0", "Q0", "com/tencent/mobileqq/guild/window/GuildGameFloatWrapper$b", "J", "Lcom/tencent/mobileqq/guild/window/GuildGameFloatWrapper$b;", "mJoinOrQuitRoomObserver", "com/tencent/mobileqq/guild/window/GuildGameFloatWrapper$c", "K", "Lcom/tencent/mobileqq/guild/window/GuildGameFloatWrapper$c;", "roomStatusObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class GuildGameFloatWrapper extends a {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b mJoinOrQuitRoomObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final c roomStatusObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/window/GuildGameFloatWrapper$a;", "", "Landroid/view/View;", "a", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.window.GuildGameFloatWrapper$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final View a() {
            View inflate = View.inflate(BaseApplication.getContext(), R.layout.egl, null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               \u2026       null\n            )");
            return inflate;
        }

        public final void b() {
            GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
            String name = GuildGameFloatWrapper.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "GuildGameFloatWrapper::class.java.name");
            guildFloatWindowManager.g(name);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/window/GuildGameFloatWrapper$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/r;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.r> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.r event) {
            int i3;
            long j3;
            IGProVoiceSmobaGameGameStaticInfo gameInfo;
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getGameInfo().getRoomInfo() == null) {
                Logger.f235387a.d().i(GuildGameFloatWrapper.this.getTag(), 1, "mJoinOrQuitRoomObserver | event.gameInfo.roomInfo is null");
            }
            Logger logger = Logger.f235387a;
            String tag = GuildGameFloatWrapper.this.getTag();
            logger.d().i(tag, 1, "mJoinOrQuitRoomObserver | event.gameInfo.newCurMember: " + event.getGameInfo().getNewCurMember());
            com.tencent.mobileqq.guild.window.usecase.n nVar = (com.tencent.mobileqq.guild.window.usecase.n) GuildGameFloatWrapper.this.N0();
            IGProVoiceSmobaGameRoomStateInfo roomInfo = event.getGameInfo().getRoomInfo();
            if (roomInfo != null) {
                i3 = roomInfo.getRoomState();
            } else {
                i3 = -1;
            }
            int i16 = i3;
            long j16 = 0;
            if (((int) event.getGameInfo().getNewCurMember()) != 0) {
                j3 = event.getGameInfo().getNewCurMember();
            } else {
                IGProVoiceSmobaGameRoomStateInfo roomInfo2 = event.getGameInfo().getRoomInfo();
                if (roomInfo2 != null) {
                    j3 = roomInfo2.getCurrentNum();
                } else {
                    j3 = 0;
                }
            }
            IGProVoiceSmobaGameRoomStateInfo roomInfo3 = event.getGameInfo().getRoomInfo();
            if (roomInfo3 != null && (gameInfo = roomInfo3.getGameInfo()) != null) {
                j16 = gameInfo.getMaxNum();
            }
            nVar.T(i16, j3, j16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/window/GuildGameFloatWrapper$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/am;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<am> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull am event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger logger = Logger.f235387a;
            String tag = GuildGameFloatWrapper.this.getTag();
            logger.d().i(tag, 1, "roomStatusObserver | event.roomInfo.roomState: " + event.getRoomInfo().getRoomState());
            ((com.tencent.mobileqq.guild.window.usecase.n) GuildGameFloatWrapper.this.N0()).T(event.getRoomInfo().getRoomState(), event.getRoomInfo().getCurrentNum(), event.getRoomInfo().getGameInfo().getMaxNum());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGameFloatWrapper(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mJoinOrQuitRoomObserver = new b();
        this.roomStatusObserver = new c();
        J0("GuildAudioChannelFloatWrapper");
        I0(true);
        H0(false);
    }

    @Override // com.tencent.mobileqq.guild.window.a, com.tencent.mobileqq.guild.window.c
    protected void A0() {
        super.A0();
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.r.class, this.mJoinOrQuitRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(am.class, this.roomStatusObserver);
    }

    @Override // com.tencent.mobileqq.guild.window.a
    protected void L0() {
        super.L0();
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.r.class, this.mJoinOrQuitRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(am.class, this.roomStatusObserver);
    }

    @Override // com.tencent.mobileqq.guild.window.a
    public void Q0() {
        INSTANCE.b();
    }

    @Override // com.tencent.mobileqq.guild.window.a
    @NotNull
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.guild.window.usecase.n O0() {
        return new com.tencent.mobileqq.guild.window.usecase.n(t0(), r0(), this);
    }
}
