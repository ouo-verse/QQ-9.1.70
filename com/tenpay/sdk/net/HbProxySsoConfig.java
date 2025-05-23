package com.tenpay.sdk.net;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u00d6\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/net/HbProxySsoConfig;", "", "supportSsoList", "", "", "(Ljava/util/List;)V", "getSupportSsoList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class HbProxySsoConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final HbProxySsoConfig defaultConfig;

    @SerializedName("support_sso")
    @Nullable
    private final List<String> supportSsoList;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/net/HbProxySsoConfig$Companion;", "", "()V", "defaultConfig", "Lcom/tenpay/sdk/net/HbProxySsoConfig;", "getDefaultConfig", "()Lcom/tenpay/sdk/net/HbProxySsoConfig;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HbProxySsoConfig getDefaultConfig() {
            return HbProxySsoConfig.defaultConfig;
        }

        Companion() {
        }
    }

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qpay_hb_na_grap", "qpay_hb_pack", "qpay_hb_pack_confirm", "qpay_hb_na_detail", "qpay_hb_qr_list", "qpay_hb_qr_grab", "qpay_hb_qr_callback"});
        defaultConfig = new HbProxySsoConfig(listOf);
    }

    public HbProxySsoConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HbProxySsoConfig copy$default(HbProxySsoConfig hbProxySsoConfig, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = hbProxySsoConfig.supportSsoList;
        }
        return hbProxySsoConfig.copy(list);
    }

    @Nullable
    public final List<String> component1() {
        return this.supportSsoList;
    }

    @NotNull
    public final HbProxySsoConfig copy(@Nullable List<String> supportSsoList) {
        return new HbProxySsoConfig(supportSsoList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof HbProxySsoConfig) && Intrinsics.areEqual(this.supportSsoList, ((HbProxySsoConfig) other).supportSsoList)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<String> getSupportSsoList() {
        return this.supportSsoList;
    }

    public int hashCode() {
        List<String> list = this.supportSsoList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "HbProxySsoConfig(supportSsoList=" + this.supportSsoList + ")";
    }

    public HbProxySsoConfig(@Nullable List<String> list) {
        this.supportSsoList = list;
    }

    public /* synthetic */ HbProxySsoConfig(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list);
    }
}
