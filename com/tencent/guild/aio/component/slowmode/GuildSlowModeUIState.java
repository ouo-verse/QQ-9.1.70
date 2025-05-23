package com.tencent.guild.aio.component.slowmode;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "CancelTimer", "GuildFreqLimitInfo", "SlowModeTipVisible", "StartTimer", "UpdateSlowModeTipText", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$CancelTimer;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$GuildFreqLimitInfo;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$SlowModeTipVisible;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$StartTimer;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$UpdateSlowModeTipText;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildSlowModeUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$CancelTimer;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class CancelTimer extends GuildSlowModeUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final CancelTimer f110321d = new CancelTimer();

        CancelTimer() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$GuildFreqLimitInfo;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState;", "Lcom/tencent/qqnt/msg/data/b;", "d", "Lcom/tencent/qqnt/msg/data/b;", "a", "()Lcom/tencent/qqnt/msg/data/b;", "limitInfoData", "<init>", "(Lcom/tencent/qqnt/msg/data/b;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class GuildFreqLimitInfo extends GuildSlowModeUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.msg.data.b limitInfoData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildFreqLimitInfo(@NotNull com.tencent.qqnt.msg.data.b limitInfoData) {
            super(null);
            Intrinsics.checkNotNullParameter(limitInfoData, "limitInfoData");
            this.limitInfoData = limitInfoData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.qqnt.msg.data.b getLimitInfoData() {
            return this.limitInfoData;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$SlowModeTipVisible;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState;", "", "d", "Z", "a", "()Z", ViewStickEventHelper.IS_SHOW, "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class SlowModeTipVisible extends GuildSlowModeUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isShow;

        public SlowModeTipVisible(boolean z16) {
            super(null);
            this.isShow = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsShow() {
            return this.isShow;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$StartTimer;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState;", "", "d", "J", "a", "()J", "millisRemain", "<init>", "(J)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class StartTimer extends GuildSlowModeUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long millisRemain;

        public StartTimer(long j3) {
            super(null);
            this.millisRemain = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getMillisRemain() {
            return this.millisRemain;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState$UpdateSlowModeTipText;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState;", "Lcom/tencent/guild/aio/component/slowmode/f;", "d", "Lcom/tencent/guild/aio/component/slowmode/f;", "a", "()Lcom/tencent/guild/aio/component/slowmode/f;", "uiData", "<init>", "(Lcom/tencent/guild/aio/component/slowmode/f;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class UpdateSlowModeTipText extends GuildSlowModeUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SlowModeUIData uiData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateSlowModeTipText(@NotNull SlowModeUIData uiData) {
            super(null);
            Intrinsics.checkNotNullParameter(uiData, "uiData");
            this.uiData = uiData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final SlowModeUIData getUiData() {
            return this.uiData;
        }
    }

    public /* synthetic */ GuildSlowModeUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildSlowModeUIState() {
    }
}
