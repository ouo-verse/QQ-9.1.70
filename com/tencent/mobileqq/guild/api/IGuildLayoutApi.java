package com.tencent.mobileqq.guild.api;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0006\u0019\u001a\u001b\u001c\u001d\u001eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H&J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H&J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0016H&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$c;", "param", "", "avatarAreaWidth", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$a;", "initGuildNavigationBar", "navigationBarLayout", "", "removeNavigationBar", "Landroid/widget/FrameLayout;", "frameLayout", "initGuildLayout", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "guildContainer", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$b;", "initGuildReportController", "clearDiscoverPreloadView", "Landroid/view/View;", "target", "addInnerClippedShadowView", "GuildState", "a", "b", "c", "d", "e", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildLayoutApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$GuildState;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "displayDiscovery", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "displayGuildId", "<init>", "(ZLjava/lang/String;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class GuildState {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        private static final Lazy<GuildState> f214351d;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean displayDiscovery;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String displayGuildId;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$GuildState$a;", "", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$GuildState;", "EMPTY$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$GuildState;", PatternUtils.NO_MATCH, "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.api.IGuildLayoutApi$GuildState$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final GuildState a() {
                return (GuildState) GuildState.f214351d.getValue();
            }

            Companion() {
            }
        }

        static {
            Lazy<GuildState> lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildState>() { // from class: com.tencent.mobileqq.guild.api.IGuildLayoutApi$GuildState$Companion$EMPTY$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final IGuildLayoutApi.GuildState invoke() {
                    return new IGuildLayoutApi.GuildState(false, "");
                }
            });
            f214351d = lazy;
        }

        public GuildState(boolean z16, @NotNull String displayGuildId) {
            Intrinsics.checkNotNullParameter(displayGuildId, "displayGuildId");
            this.displayDiscovery = z16;
            this.displayGuildId = displayGuildId;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getDisplayDiscovery() {
            return this.displayDiscovery;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getDisplayGuildId() {
            return this.displayGuildId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildState)) {
                return false;
            }
            GuildState guildState = (GuildState) other;
            if (this.displayDiscovery == guildState.displayDiscovery && Intrinsics.areEqual(this.displayGuildId, guildState.displayGuildId)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.displayDiscovery;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.displayGuildId.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildState(displayDiscovery=" + this.displayDiscovery + ", displayGuildId=" + this.displayGuildId + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$a;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a extends d {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$b;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b extends d {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$c;", "", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "", "", "progress", "", "J", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface d {
        void J(float progress);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$e;", "", "", NodeProps.VISIBLE, "", "onVisibleChanged", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface e {
        void onVisibleChanged(boolean visible);
    }

    @Nullable
    View addInnerClippedShadowView(@NotNull View target);

    void clearDiscoverPreloadView(@NotNull Activity activity);

    void initGuildLayout(@NotNull FrameLayout frameLayout, @NotNull c param);

    @NotNull
    a initGuildNavigationBar(@NotNull ViewGroup rootView, @NotNull c param, int avatarAreaWidth);

    @NotNull
    b initGuildReportController(@NotNull Activity activity, @NotNull ViewGroup guildContainer);

    void removeNavigationBar(@NotNull ViewGroup navigationBarLayout);
}
