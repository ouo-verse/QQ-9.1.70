package com.tencent.guild.aio.background;

import android.view.View;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "GuildRemoveAIOBackgroundView", "GuildUpdateAIOBackgroundPlayEvent", "GuildUpdateAIOBackgroundView", "Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState$GuildRemoveAIOBackgroundView;", "Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState$GuildUpdateAIOBackgroundPlayEvent;", "Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState$GuildUpdateAIOBackgroundView;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildFullBackgroundUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState$GuildRemoveAIOBackgroundView;", "Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GuildRemoveAIOBackgroundView extends GuildFullBackgroundUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GuildRemoveAIOBackgroundView f110074d = new GuildRemoveAIOBackgroundView();

        GuildRemoveAIOBackgroundView() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState$GuildUpdateAIOBackgroundPlayEvent;", "Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "stop", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildUpdateAIOBackgroundPlayEvent extends GuildFullBackgroundUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean stop;

        public GuildUpdateAIOBackgroundPlayEvent(boolean z16) {
            super(null);
            this.stop = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getStop() {
            return this.stop;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GuildUpdateAIOBackgroundPlayEvent) && this.stop == ((GuildUpdateAIOBackgroundPlayEvent) other).stop) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.stop;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "GuildUpdateAIOBackgroundPlayEvent(stop=" + this.stop + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState$GuildUpdateAIOBackgroundView;", "Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Landroid/view/View;", "d", "Landroid/view/View;", "b", "()Landroid/view/View;", "view", "e", "Z", "a", "()Z", "toRemove", "<init>", "(Landroid/view/View;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class GuildUpdateAIOBackgroundView extends GuildFullBackgroundUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final View view;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean toRemove;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildUpdateAIOBackgroundView(@NotNull View view, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.toRemove = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getToRemove() {
            return this.toRemove;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final View getView() {
            return this.view;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildUpdateAIOBackgroundView)) {
                return false;
            }
            GuildUpdateAIOBackgroundView guildUpdateAIOBackgroundView = (GuildUpdateAIOBackgroundView) other;
            if (Intrinsics.areEqual(this.view, guildUpdateAIOBackgroundView.view) && this.toRemove == guildUpdateAIOBackgroundView.toRemove) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.view.hashCode() * 31;
            boolean z16 = this.toRemove;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "GuildUpdateAIOBackgroundView(view=" + this.view + ", toRemove=" + this.toRemove + ")";
        }
    }

    public /* synthetic */ GuildFullBackgroundUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildFullBackgroundUIState() {
    }
}
