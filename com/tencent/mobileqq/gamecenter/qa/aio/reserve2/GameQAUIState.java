package com.tencent.mobileqq.gamecenter.qa.aio.reserve2;

import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "()V", "AioFoldFinish", "AioFoldStart", "AioUnFoldFinish", "InitState", "KeyboardStatusChange", "MultiSelectModeChange", "OnPauseState", "OnResumeState", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$AioFoldFinish;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$AioFoldStart;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$AioUnFoldFinish;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$InitState;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$KeyboardStatusChange;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$MultiSelectModeChange;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$OnPauseState;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$OnResumeState;", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public abstract class GameQAUIState implements GuildReserve2UIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$AioFoldFinish;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class AioFoldFinish extends GameQAUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AioFoldFinish f212380d = new AioFoldFinish();

        AioFoldFinish() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$AioFoldStart;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class AioFoldStart extends GameQAUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AioFoldStart f212381d = new AioFoldStart();

        AioFoldStart() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$AioUnFoldFinish;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class AioUnFoldFinish extends GameQAUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AioUnFoldFinish f212382d = new AioUnFoldFinish();

        AioUnFoldFinish() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$InitState;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "Lvd1/b;", "d", "Lvd1/b;", "a", "()Lvd1/b;", "gameSessionInfo", "<init>", "(Lvd1/b;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class InitState extends GameQAUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final vd1.b gameSessionInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InitState(@NotNull vd1.b gameSessionInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(gameSessionInfo, "gameSessionInfo");
            this.gameSessionInfo = gameSessionInfo;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final vd1.b getGameSessionInfo() {
            return this.gameSessionInfo;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$KeyboardStatusChange;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "", "d", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "show", "<init>", "(Ljava/lang/Boolean;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class KeyboardStatusChange extends GameQAUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Boolean show;

        public KeyboardStatusChange(@Nullable Boolean bool) {
            super(null);
            this.show = bool;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Boolean getShow() {
            return this.show;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$MultiSelectModeChange;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "", "d", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "isMutliSelect", "<init>", "(Ljava/lang/Boolean;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class MultiSelectModeChange extends GameQAUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Boolean isMutliSelect;

        public MultiSelectModeChange(@Nullable Boolean bool) {
            super(null);
            this.isMutliSelect = bool;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Boolean getIsMutliSelect() {
            return this.isMutliSelect;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$OnPauseState;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class OnPauseState extends GameQAUIState {
        public OnPauseState() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState$OnResumeState;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/reserve2/GameQAUIState;", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class OnResumeState extends GameQAUIState {
        public OnResumeState() {
            super(null);
        }
    }

    public /* synthetic */ GameQAUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GameQAUIState() {
    }
}
