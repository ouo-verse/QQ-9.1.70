package com.tencent.guild.aio.msglist.ark;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.ark.data.ArkAppConfig;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.api.ark.IGuildArkApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0002\u0014\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ.\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/g;", "", "", "appName", QQCustomArkDialogUtil.APP_VIEW, "c", "guildId", "channelId", "", "messageId", "messageSeq", "", "height", "", "f", "d", "g", "e", "Landroidx/collection/LruCache;", "Lsp0/a;", "a", "Landroidx/collection/LruCache;", "guildArkHeightLruCache", "", "b", "Ljava/util/Map;", "arkAppHeightMap", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static volatile g f111216d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, sp0.a> guildArkHeightLruCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Integer> arkAppHeightMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J4\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0007J>\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001c\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/g$a;", "", "", "dp", "scale", "", "a", "Lcom/tencent/ark/data/ArkAppConfig;", "arkConfig", "", "e", "width", "height", "maxWidthPx", "maxHeightPx", "Lcom/tencent/guild/aio/msglist/ark/g$b;", "f", NodeProps.MIN_WIDTH, NodeProps.MIN_HEIGHT, NodeProps.MAX_WIDTH, NodeProps.MAX_HEIGHT, "g", "Lcom/tencent/guild/aio/msglist/ark/g;", "d", "()Lcom/tencent/guild/aio/msglist/ark/g;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "c", "()I", "aioMaxHeight", "mInstance", "Lcom/tencent/guild/aio/msglist/ark/g;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.ark.g$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ int b(Companion companion, float f16, float f17, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                f17 = com.tencent.guild.aio.msglist.ark.b.b();
            }
            return companion.a(f16, f17);
        }

        @JvmOverloads
        public final int a(float dp5, float scale) {
            boolean z16;
            if (dp5 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return 0;
            }
            return (int) ((dp5 * scale) + 0.5f);
        }

        public final int c() {
            return b(this, ((IGuildArkApi) QRoute.api(IGuildArkApi.class)).getAioConfigMaxHeight(), 0.0f, 2, null);
        }

        @Nullable
        public final g d() {
            if (g.f111216d == null) {
                synchronized (g.class) {
                    if (g.f111216d == null) {
                        g.f111216d = new g(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return g.f111216d;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0049 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean e(@Nullable ArkAppConfig arkConfig) {
            boolean z16;
            boolean z17;
            boolean z18;
            if (arkConfig != null && (Intrinsics.areEqual("normal", arkConfig.type) || Intrinsics.areEqual("multiple", arkConfig.type))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intrinsics.checkNotNull(arkConfig);
                Integer num = arkConfig.width;
                if (num != null && (num == null || num.intValue() != 0)) {
                    z17 = true;
                    if (z16) {
                        Intrinsics.checkNotNull(arkConfig);
                        Integer num2 = arkConfig.height;
                        if (num2 != null && (num2 == null || num2.intValue() != 0)) {
                            z18 = true;
                            if (!z18 && z17) {
                                return true;
                            }
                            return false;
                        }
                    }
                    z18 = false;
                    if (!z18) {
                    }
                    return false;
                }
            }
            z17 = false;
            if (z16) {
            }
            z18 = false;
            if (!z18) {
            }
            return false;
        }

        @JvmOverloads
        @NotNull
        public final b f(float scale, int width, int height, int maxWidthPx, int maxHeightPx) {
            return g(scale, width, height, 30, 30, (int) (maxWidthPx / scale), (int) (maxHeightPx / scale));
        }

        @NotNull
        public final b g(float scale, int width, int height, int minWidth, int minHeight, int maxWidth, int maxHeight) {
            if (minWidth > 0 && width < minWidth) {
                width = minWidth;
            }
            if (minHeight > 0 && height < minHeight) {
                height = minHeight;
            }
            if (maxWidth <= 0 || width <= maxWidth) {
                maxWidth = width;
            }
            if (maxHeight <= 0 || height <= maxHeight) {
                maxHeight = height;
            }
            return new b(a(maxWidth, scale), a(maxHeight, scale));
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/aio/msglist/ark/g$b;", "", "", "a", "I", "b", "()I", "setWidth", "(I)V", "width", "setHeight", "height", "<init>", "(II)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int width;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int height;

        public b(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: b, reason: from getter */
        public final int getWidth() {
            return this.width;
        }
    }

    public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final String c(String appName, String appView) {
        if (!TextUtils.isEmpty(appName) && !TextUtils.isEmpty(appView)) {
            return appName + "_" + appView;
        }
        return "";
    }

    public final int d(@NotNull String guildId, @NotNull String channelId, long messageId, @NotNull String appName, @NotNull String appView) {
        int i3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appView, "appView");
        sp0.a aVar = this.guildArkHeightLruCache.get(guildId + "_" + channelId);
        int i16 = -1;
        if (aVar != null) {
            i3 = aVar.a(messageId);
        } else {
            i3 = -1;
        }
        if (i3 == -1) {
            Integer num = this.arkAppHeightMap.get(c(appName, appView));
            if (num != null) {
                i16 = num.intValue();
            }
            return i16;
        }
        return i3;
    }

    public final void e(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        String str = guildId + "_" + channelId;
        sp0.a aVar = this.guildArkHeightLruCache.get(str);
        if (aVar == null) {
            aVar = new sp0.a();
            this.guildArkHeightLruCache.put(str, aVar);
        }
        aVar.b(guildId, channelId);
    }

    public final void f(@NotNull String guildId, @NotNull String channelId, long messageId, long messageSeq, @NotNull String appName, @NotNull String appView, int height) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appView, "appView");
        String str = guildId + "_" + channelId;
        sp0.a aVar = this.guildArkHeightLruCache.get(str);
        if (aVar == null) {
            aVar = new sp0.a();
            this.guildArkHeightLruCache.put(str, aVar);
        }
        aVar.c(messageId, messageSeq, height);
        String c16 = c(appName, appView);
        if (!this.arkAppHeightMap.containsKey(c16)) {
            this.arkAppHeightMap.put(c16, Integer.valueOf(height));
        }
    }

    public final void g(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        sp0.a aVar = this.guildArkHeightLruCache.get(guildId + "_" + channelId);
        if (aVar == null) {
            return;
        }
        aVar.d(guildId, channelId);
    }

    g() {
        this.guildArkHeightLruCache = new LruCache<>(20);
        this.arkAppHeightMap = new HashMap();
    }
}
