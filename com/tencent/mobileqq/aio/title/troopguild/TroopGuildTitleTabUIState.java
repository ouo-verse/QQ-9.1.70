package com.tencent.mobileqq.aio.title.troopguild;

import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.mobileqq.aio.title.ab;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "()V", "MultiSelectModeChangeState", "SelectFeedTab", "SelectMsgTab", "SetVisibility", "UpdateGuildTroopState", "UpdateTroopGuildTab", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$MultiSelectModeChangeState;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$SelectFeedTab;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$SelectMsgTab;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$SetVisibility;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$UpdateGuildTroopState;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$UpdateTroopGuildTab;", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public abstract class TroopGuildTitleTabUIState implements TitleUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$MultiSelectModeChangeState;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "isSelectMode", "e", "b", "isTroopGuild", "<init>", "(ZZ)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class MultiSelectModeChangeState extends TroopGuildTitleTabUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSelectMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isTroopGuild;

        public MultiSelectModeChangeState(boolean z16, boolean z17) {
            super(null);
            this.isSelectMode = z16;
            this.isTroopGuild = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsSelectMode() {
            return this.isSelectMode;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsTroopGuild() {
            return this.isTroopGuild;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiSelectModeChangeState)) {
                return false;
            }
            MultiSelectModeChangeState multiSelectModeChangeState = (MultiSelectModeChangeState) other;
            if (this.isSelectMode == multiSelectModeChangeState.isSelectMode && this.isTroopGuild == multiSelectModeChangeState.isTroopGuild) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isSelectMode;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isTroopGuild;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "MultiSelectModeChangeState(isSelectMode=" + this.isSelectMode + ", isTroopGuild=" + this.isTroopGuild + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$SelectFeedTab;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "from", "e", "Z", "c", "()Z", "withAnim", "f", "a", "entryMode", "<init>", "(IZI)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class SelectFeedTab extends TroopGuildTitleTabUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int from;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean withAnim;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int entryMode;

        public SelectFeedTab(int i3, boolean z16, int i16) {
            super(null);
            this.from = i3;
            this.withAnim = z16;
            this.entryMode = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getEntryMode() {
            return this.entryMode;
        }

        /* renamed from: b, reason: from getter */
        public final int getFrom() {
            return this.from;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getWithAnim() {
            return this.withAnim;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectFeedTab)) {
                return false;
            }
            SelectFeedTab selectFeedTab = (SelectFeedTab) other;
            if (this.from == selectFeedTab.from && this.withAnim == selectFeedTab.withAnim && this.entryMode == selectFeedTab.entryMode) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.from * 31;
            boolean z16 = this.withAnim;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return ((i3 + i16) * 31) + this.entryMode;
        }

        @NotNull
        public String toString() {
            return "SelectFeedTab(from=" + this.from + ", withAnim=" + this.withAnim + ", entryMode=" + this.entryMode + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$SelectMsgTab;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class SelectMsgTab extends TroopGuildTitleTabUIState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final SelectMsgTab f194036d = new SelectMsgTab();

        SelectMsgTab() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$SetVisibility;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", NodeProps.VISIBLE, "<init>", "(Z)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class SetVisibility extends TroopGuildTitleTabUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean visible;

        public SetVisibility(boolean z16) {
            super(null);
            this.visible = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SetVisibility) && this.visible == ((SetVisibility) other).visible) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.visible;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "SetVisibility(visible=" + this.visible + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$UpdateGuildTroopState;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/aio/title/ab;", "d", "Lcom/tencent/mobileqq/aio/title/ab;", "a", "()Lcom/tencent/mobileqq/aio/title/ab;", "data", "<init>", "(Lcom/tencent/mobileqq/aio/title/ab;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class UpdateGuildTroopState extends TroopGuildTitleTabUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ab data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateGuildTroopState(@NotNull ab data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ab getData() {
            return this.data;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateGuildTroopState) && Intrinsics.areEqual(this.data, ((UpdateGuildTroopState) other).data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdateGuildTroopState(data=" + this.data + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState$UpdateTroopGuildTab;", "Lcom/tencent/mobileqq/aio/title/troopguild/TroopGuildTitleTabUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "type", "e", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "data", "<init>", "(ILjava/lang/Object;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class UpdateTroopGuildTab extends TroopGuildTitleTabUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object data;

        public UpdateTroopGuildTab(int i3, @Nullable Object obj) {
            super(null);
            this.type = i3;
            this.data = obj;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Object getData() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateTroopGuildTab)) {
                return false;
            }
            UpdateTroopGuildTab updateTroopGuildTab = (UpdateTroopGuildTab) other;
            if (this.type == updateTroopGuildTab.type && Intrinsics.areEqual(this.data, updateTroopGuildTab.data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3 = this.type * 31;
            Object obj = this.data;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "UpdateTroopGuildTab(type=" + this.type + ", data=" + this.data + ")";
        }
    }

    public /* synthetic */ TroopGuildTitleTabUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    TroopGuildTitleTabUIState() {
    }
}
