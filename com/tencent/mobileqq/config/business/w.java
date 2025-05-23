package com.tencent.mobileqq.config.business;

import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0003\b\u0006\u000eB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R6\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005`\u000b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/config/business/w;", "Lcom/tencent/freesia/IConfigData;", "", EmojiManagerServiceProxy.EPID, "eId", "Lcom/tencent/mobileqq/config/business/w$b;", "b", "", "a", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/config/business/w$c;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", "marketEmotionConfig", "<init>", "()V", "e", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class w implements IConfigData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<MarketEmoticonId, b> marketEmotionConfig = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/config/business/w$a;", "", "Lcom/tencent/mobileqq/config/business/w;", "a", "", "CONFIG_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.w$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final w a() {
            return x.f202849a.a();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/config/business/w$b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "b", "getName", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String jumpUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String name;

        public b(@Nullable String str, @Nullable String str2) {
            this.jumpUrl = str;
            this.name = str2;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0084\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/config/business/w$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getEpId", "()Ljava/lang/String;", EmojiManagerServiceProxy.EPID, "b", "getEId", "eId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.w$c, reason: from toString */
    /* loaded from: classes10.dex */
    protected static final /* data */ class MarketEmoticonId {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String epId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String eId;

        public MarketEmoticonId(@NotNull String epId, @NotNull String eId) {
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(eId, "eId");
            this.epId = epId;
            this.eId = eId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MarketEmoticonId)) {
                return false;
            }
            MarketEmoticonId marketEmoticonId = (MarketEmoticonId) other;
            if (Intrinsics.areEqual(this.epId, marketEmoticonId.epId) && Intrinsics.areEqual(this.eId, marketEmoticonId.eId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.epId.hashCode() * 31) + this.eId.hashCode();
        }

        @NotNull
        public String toString() {
            return "MarketEmoticonId(epId=" + this.epId + ", eId=" + this.eId + ')';
        }
    }

    public final boolean a(@NotNull String epId, @NotNull String eId) {
        Intrinsics.checkNotNullParameter(epId, "epId");
        Intrinsics.checkNotNullParameter(eId, "eId");
        return this.marketEmotionConfig.containsKey(new MarketEmoticonId(epId, eId));
    }

    @Nullable
    public final b b(@NotNull String epId, @NotNull String eId) {
        Intrinsics.checkNotNullParameter(epId, "epId");
        Intrinsics.checkNotNullParameter(eId, "eId");
        return this.marketEmotionConfig.get(new MarketEmoticonId(epId, eId));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final HashMap<MarketEmoticonId, b> c() {
        return this.marketEmotionConfig;
    }
}
