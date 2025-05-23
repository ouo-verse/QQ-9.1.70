package com.tencent.qqguild.directmessage.aio.title;

import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/title/UIState;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "<init>", "()V", "d", "AddFriendState", "CloseCurrentPage", "a", "NotifyTypeUpdate", "TitleMultiSelectState", "TitleState", "Lcom/tencent/qqguild/directmessage/aio/title/UIState$AddFriendState;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState$CloseCurrentPage;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState$NotifyTypeUpdate;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState$TitleMultiSelectState;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState$TitleState;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class UIState implements TitleUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final List<Class<? extends UIState>> f345134e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/title/UIState$AddFriendState;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Z", "b", "()Z", "show", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class AddFriendState extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean show;

        public AddFriendState(boolean z16) {
            super(null);
            this.show = z16;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShow() {
            return this.show;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof AddFriendState) && this.show == ((AddFriendState) other).show) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.show;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "AddFriendState(show=" + this.show + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/title/UIState$CloseCurrentPage;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState;", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class CloseCurrentPage extends UIState {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public static final CloseCurrentPage f345136f = new CloseCurrentPage();

        CloseCurrentPage() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/title/UIState$NotifyTypeUpdate;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "I", "b", "()I", "notifyType", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class NotifyTypeUpdate extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int notifyType;

        public NotifyTypeUpdate(int i3) {
            super(null);
            this.notifyType = i3;
        }

        /* renamed from: b, reason: from getter */
        public final int getNotifyType() {
            return this.notifyType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof NotifyTypeUpdate) && this.notifyType == ((NotifyTypeUpdate) other).notifyType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.notifyType;
        }

        @NotNull
        public String toString() {
            return "NotifyTypeUpdate(notifyType=" + this.notifyType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/title/UIState$TitleMultiSelectState;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Z", "b", "()Z", "enable", tl.h.F, "c", "fromJubao", "<init>", "(ZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class TitleMultiSelectState extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enable;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean fromJubao;

        public TitleMultiSelectState(boolean z16, boolean z17) {
            super(null);
            this.enable = z16;
            this.fromJubao = z17;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getFromJubao() {
            return this.fromJubao;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TitleMultiSelectState)) {
                return false;
            }
            TitleMultiSelectState titleMultiSelectState = (TitleMultiSelectState) other;
            if (this.enable == titleMultiSelectState.enable && this.fromJubao == titleMultiSelectState.fromJubao) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.enable;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.fromJubao;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "TitleMultiSelectState(enable=" + this.enable + ", fromJubao=" + this.fromJubao + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/title/UIState$TitleState;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "nickName", tl.h.F, "b", "channelName", "i", "I", "e", "()I", "notifyType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "nodeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class TitleState extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String nickName;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String channelName;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final int notifyType;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        private final int nodeType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleState(@NotNull String nickName, @NotNull String channelName, int i3, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Intrinsics.checkNotNullParameter(channelName, "channelName");
            this.nickName = nickName;
            this.channelName = channelName;
            this.notifyType = i3;
            this.nodeType = i16;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getNickName() {
            return this.nickName;
        }

        /* renamed from: d, reason: from getter */
        public final int getNodeType() {
            return this.nodeType;
        }

        /* renamed from: e, reason: from getter */
        public final int getNotifyType() {
            return this.notifyType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TitleState)) {
                return false;
            }
            TitleState titleState = (TitleState) other;
            if (Intrinsics.areEqual(this.nickName, titleState.nickName) && Intrinsics.areEqual(this.channelName, titleState.channelName) && this.notifyType == titleState.notifyType && this.nodeType == titleState.nodeType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.nickName.hashCode() * 31) + this.channelName.hashCode()) * 31) + this.notifyType) * 31) + this.nodeType;
        }

        @NotNull
        public String toString() {
            return "TitleState(nickName=" + this.nickName + ", channelName=" + this.channelName + ", notifyType=" + this.notifyType + ", nodeType=" + this.nodeType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR%\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/title/UIState$a;", "", "", "Ljava/lang/Class;", "Lcom/tencent/qqguild/directmessage/aio/title/UIState;", "subClasses", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqguild.directmessage.aio.title.UIState$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<Class<? extends UIState>> a() {
            return UIState.f345134e;
        }

        Companion() {
        }
    }

    static {
        List<Class<? extends UIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{TitleState.class, NotifyTypeUpdate.class, TitleMultiSelectState.class});
        f345134e = listOf;
    }

    public /* synthetic */ UIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    UIState() {
    }
}
