package com.tencent.mobileqq.guild.media.thirdapp.container.uistate;

import com.tencent.mobileqq.mini.api.MiniContainerHolder;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildMiniViewUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "RemoveLastMiniView", "UpdateMiniView", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildMiniViewUIState$RemoveLastMiniView;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildMiniViewUIState$UpdateMiniView;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public abstract class GuildMiniViewUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildMiniViewUIState$RemoveLastMiniView;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildMiniViewUIState;", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class RemoveLastMiniView extends GuildMiniViewUIState {
        public RemoveLastMiniView() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildMiniViewUIState$UpdateMiniView;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/uistate/GuildMiniViewUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/mini/api/MiniContainerHolder;", "d", "Lcom/tencent/mobileqq/mini/api/MiniContainerHolder;", "a", "()Lcom/tencent/mobileqq/mini/api/MiniContainerHolder;", "miniViewContainer", "e", "I", "b", "()I", "targetHeight", "<init>", "(Lcom/tencent/mobileqq/mini/api/MiniContainerHolder;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class UpdateMiniView extends GuildMiniViewUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MiniContainerHolder miniViewContainer;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int targetHeight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateMiniView(@NotNull MiniContainerHolder miniViewContainer, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(miniViewContainer, "miniViewContainer");
            this.miniViewContainer = miniViewContainer;
            this.targetHeight = i3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MiniContainerHolder getMiniViewContainer() {
            return this.miniViewContainer;
        }

        /* renamed from: b, reason: from getter */
        public final int getTargetHeight() {
            return this.targetHeight;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateMiniView)) {
                return false;
            }
            UpdateMiniView updateMiniView = (UpdateMiniView) other;
            if (Intrinsics.areEqual(this.miniViewContainer, updateMiniView.miniViewContainer) && this.targetHeight == updateMiniView.targetHeight) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.miniViewContainer.hashCode() * 31) + this.targetHeight;
        }

        @NotNull
        public String toString() {
            return "UpdateMiniView(miniViewContainer=" + this.miniViewContainer + ", targetHeight=" + this.targetHeight + ")";
        }
    }

    public /* synthetic */ GuildMiniViewUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildMiniViewUIState() {
    }
}
