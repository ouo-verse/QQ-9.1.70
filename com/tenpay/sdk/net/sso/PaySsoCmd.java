package com.tenpay.sdk.net.sso;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoCmd;", "", "()V", "Gateway", "HbProxy", "Lcom/tenpay/sdk/net/sso/PaySsoCmd$Gateway;", "Lcom/tenpay/sdk/net/sso/PaySsoCmd$HbProxy;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public abstract class PaySsoCmd {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoCmd$Gateway;", "Lcom/tenpay/sdk/net/sso/PaySsoCmd;", "cgiName", "", "service", "method", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCgiName", "()Ljava/lang/String;", "getMethod", "getService", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class Gateway extends PaySsoCmd {

        @NotNull
        private final String cgiName;

        @NotNull
        private final String method;

        @NotNull
        private final String service;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Gateway(@NotNull String cgiName, @NotNull String service, @NotNull String method) {
            super(null);
            Intrinsics.checkNotNullParameter(cgiName, "cgiName");
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(method, "method");
            this.cgiName = cgiName;
            this.service = service;
            this.method = method;
        }

        public static /* synthetic */ Gateway copy$default(Gateway gateway, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = gateway.cgiName;
            }
            if ((i3 & 2) != 0) {
                str2 = gateway.service;
            }
            if ((i3 & 4) != 0) {
                str3 = gateway.method;
            }
            return gateway.copy(str, str2, str3);
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
        public final Gateway copy(@NotNull String cgiName, @NotNull String service, @NotNull String method) {
            Intrinsics.checkNotNullParameter(cgiName, "cgiName");
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(method, "method");
            return new Gateway(cgiName, service, method);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Gateway)) {
                return false;
            }
            Gateway gateway = (Gateway) other;
            if (Intrinsics.areEqual(this.cgiName, gateway.cgiName) && Intrinsics.areEqual(this.service, gateway.service) && Intrinsics.areEqual(this.method, gateway.method)) {
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
            return "Gateway(cgiName=" + this.cgiName + ", service=" + this.service + ", method=" + this.method + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoCmd$HbProxy;", "Lcom/tenpay/sdk/net/sso/PaySsoCmd;", "cgiName", "", "cmd", "(Ljava/lang/String;Ljava/lang/String;)V", "getCgiName", "()Ljava/lang/String;", "getCmd", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class HbProxy extends PaySsoCmd {

        @NotNull
        private final String cgiName;

        @NotNull
        private final String cmd;

        public /* synthetic */ HbProxy(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? "trpc.qqhb.qqhb_proxy.Handler.sso_handle" : str2);
        }

        public static /* synthetic */ HbProxy copy$default(HbProxy hbProxy, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = hbProxy.cgiName;
            }
            if ((i3 & 2) != 0) {
                str2 = hbProxy.cmd;
            }
            return hbProxy.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getCgiName() {
            return this.cgiName;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getCmd() {
            return this.cmd;
        }

        @NotNull
        public final HbProxy copy(@NotNull String cgiName, @NotNull String cmd) {
            Intrinsics.checkNotNullParameter(cgiName, "cgiName");
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            return new HbProxy(cgiName, cmd);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HbProxy)) {
                return false;
            }
            HbProxy hbProxy = (HbProxy) other;
            if (Intrinsics.areEqual(this.cgiName, hbProxy.cgiName) && Intrinsics.areEqual(this.cmd, hbProxy.cmd)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCgiName() {
            return this.cgiName;
        }

        @NotNull
        public final String getCmd() {
            return this.cmd;
        }

        public int hashCode() {
            return (this.cgiName.hashCode() * 31) + this.cmd.hashCode();
        }

        @NotNull
        public String toString() {
            return "HbProxy(cgiName=" + this.cgiName + ", cmd=" + this.cmd + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HbProxy(@NotNull String cgiName, @NotNull String cmd) {
            super(null);
            Intrinsics.checkNotNullParameter(cgiName, "cgiName");
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            this.cgiName = cgiName;
            this.cmd = cmd;
        }
    }

    public /* synthetic */ PaySsoCmd(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    PaySsoCmd() {
    }
}
