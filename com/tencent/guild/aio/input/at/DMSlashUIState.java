package com.tencent.guild.aio.input.at;

import com.tencent.aio.api.runtime.a;
import com.tencent.aio.data.AIOParam;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/input/at/DMSlashUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "AioHideUIState", "DismissSlashPanel", "InitSlashUIState", "RefreshBotBtnUIState", "SetSlashAbilityUIState", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public class DMSlashUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/input/at/DMSlashUIState$AioHideUIState;", "Lcom/tencent/guild/aio/input/at/DMSlashUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class AioHideUIState extends DMSlashUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AioHideUIState f110878d = new AioHideUIState();

        AioHideUIState() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/input/at/DMSlashUIState$DismissSlashPanel;", "Lcom/tencent/guild/aio/input/at/DMSlashUIState;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DismissSlashPanel extends DMSlashUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final DismissSlashPanel f110879d = new DismissSlashPanel();

        DismissSlashPanel() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/input/at/DMSlashUIState$InitSlashUIState;", "Lcom/tencent/guild/aio/input/at/DMSlashUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "a", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "(Lcom/tencent/aio/api/runtime/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class InitSlashUIState extends DMSlashUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final a aioContext;

        public InitSlashUIState(@NotNull a aioContext) {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            this.aioContext = aioContext;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final a getAioContext() {
            return this.aioContext;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof InitSlashUIState) && Intrinsics.areEqual(this.aioContext, ((InitSlashUIState) other).aioContext)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.aioContext.hashCode();
        }

        @NotNull
        public String toString() {
            return "InitSlashUIState(aioContext=" + this.aioContext + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/input/at/DMSlashUIState$RefreshBotBtnUIState;", "Lcom/tencent/guild/aio/input/at/DMSlashUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/aio/data/AIOParam;", "d", "Lcom/tencent/aio/data/AIOParam;", "a", "()Lcom/tencent/aio/data/AIOParam;", "aioParam", "<init>", "(Lcom/tencent/aio/data/AIOParam;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class RefreshBotBtnUIState extends DMSlashUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final AIOParam aioParam;

        public RefreshBotBtnUIState(@NotNull AIOParam aioParam) {
            Intrinsics.checkNotNullParameter(aioParam, "aioParam");
            this.aioParam = aioParam;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AIOParam getAioParam() {
            return this.aioParam;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RefreshBotBtnUIState) && Intrinsics.areEqual(this.aioParam, ((RefreshBotBtnUIState) other).aioParam)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.aioParam.hashCode();
        }

        @NotNull
        public String toString() {
            return "RefreshBotBtnUIState(aioParam=" + this.aioParam + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/aio/input/at/DMSlashUIState$SetSlashAbilityUIState;", "Lcom/tencent/guild/aio/input/at/DMSlashUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isEnable", "<init>", "(Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final /* data */ class SetSlashAbilityUIState extends DMSlashUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isEnable;

        public SetSlashAbilityUIState(boolean z16) {
            this.isEnable = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsEnable() {
            return this.isEnable;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SetSlashAbilityUIState) && this.isEnable == ((SetSlashAbilityUIState) other).isEnable) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isEnable;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "SetSlashAbilityUIState(isEnable=" + this.isEnable + ")";
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
