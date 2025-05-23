package com.tenpay.sdk.net;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tenpay/sdk/net/PayGatewaySsoConfig;", "", "supportSsoList", "", "Lcom/tenpay/sdk/net/PayGatewaySsoConfig$Item;", "(Ljava/util/List;)V", "getSupportSsoList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "Item", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class PayGatewaySsoConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final PayGatewaySsoConfig defaultConfig;

    @SerializedName("gateway_sso")
    @Nullable
    private final List<Item> supportSsoList;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/net/PayGatewaySsoConfig$Companion;", "", "()V", "defaultConfig", "Lcom/tenpay/sdk/net/PayGatewaySsoConfig;", "getDefaultConfig", "()Lcom/tenpay/sdk/net/PayGatewaySsoConfig;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PayGatewaySsoConfig getDefaultConfig() {
            return PayGatewaySsoConfig.defaultConfig;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tenpay/sdk/net/PayGatewaySsoConfig$Item;", "", "cgiName", "", "service", "method", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCgiName", "()Ljava/lang/String;", "getMethod", "getService", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class Item {

        @SerializedName("cgi")
        @NotNull
        private final String cgiName;

        @SerializedName("method")
        @NotNull
        private final String method;

        @SerializedName("svr")
        @NotNull
        private final String service;

        public Item(@NotNull String cgiName, @NotNull String service, @NotNull String method) {
            Intrinsics.checkNotNullParameter(cgiName, "cgiName");
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(method, "method");
            this.cgiName = cgiName;
            this.service = service;
            this.method = method;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = item.cgiName;
            }
            if ((i3 & 2) != 0) {
                str2 = item.service;
            }
            if ((i3 & 4) != 0) {
                str3 = item.method;
            }
            return item.copy(str, str2, str3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getCgiName() {
            return this.cgiName;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getService() {
            return this.service;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        @NotNull
        public final Item copy(@NotNull String cgiName, @NotNull String service, @NotNull String method) {
            Intrinsics.checkNotNullParameter(cgiName, "cgiName");
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(method, "method");
            return new Item(cgiName, service, method);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            if (Intrinsics.areEqual(this.cgiName, item.cgiName) && Intrinsics.areEqual(this.service, item.service) && Intrinsics.areEqual(this.method, item.method)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCgiName() {
            return this.cgiName;
        }

        @NotNull
        public final String getMethod() {
            return this.method;
        }

        @NotNull
        public final String getService() {
            return this.service;
        }

        public int hashCode() {
            return (((this.cgiName.hashCode() * 31) + this.service.hashCode()) * 31) + this.method.hashCode();
        }

        @NotNull
        public String toString() {
            return "Item(cgiName=" + this.cgiName + ", service=" + this.service + ", method=" + this.method + ")";
        }
    }

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new Item("qpay_hb_na_detail", "trpc.qqhb.access.MobileHbCgi", "HBDetailCgi"));
        defaultConfig = new PayGatewaySsoConfig(listOf);
    }

    public PayGatewaySsoConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayGatewaySsoConfig copy$default(PayGatewaySsoConfig payGatewaySsoConfig, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = payGatewaySsoConfig.supportSsoList;
        }
        return payGatewaySsoConfig.copy(list);
    }

    @Nullable
    public final List<Item> component1() {
        return this.supportSsoList;
    }

    @NotNull
    public final PayGatewaySsoConfig copy(@Nullable List<Item> supportSsoList) {
        return new PayGatewaySsoConfig(supportSsoList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof PayGatewaySsoConfig) && Intrinsics.areEqual(this.supportSsoList, ((PayGatewaySsoConfig) other).supportSsoList)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<Item> getSupportSsoList() {
        return this.supportSsoList;
    }

    public int hashCode() {
        List<Item> list = this.supportSsoList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "PayGatewaySsoConfig(supportSsoList=" + this.supportSsoList + ")";
    }

    public PayGatewaySsoConfig(@Nullable List<Item> list) {
        this.supportSsoList = list;
    }

    public /* synthetic */ PayGatewaySsoConfig(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list);
    }
}
