package com.tenpay.sdk.net.core.statistic;

import androidx.fragment.app.a;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 =2\u00020\u0001:\u0005=>?@AB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010:\u001a\u0004\u0018\u000103J\u0006\u0010;\u001a\u00020\u000eJ\u0006\u0010<\u001a\u000203R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010#\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u001a\u0010.\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R!\u00101\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012\u00a8\u0006B"}, d2 = {"Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "", "()V", "concurrentCount", "", "getConcurrentCount", "()I", "setConcurrentCount", "(I)V", "encryptUnit", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$EncryptUnit;", "getEncryptUnit", "()Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$EncryptUnit;", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "exception", "", "getException", "()Ljava/lang/Throwable;", "setException", "(Ljava/lang/Throwable;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID, "getFlowId", "setFlowId", "isBizSucceed", "", "()Z", "setBizSucceed", "(Z)V", "isCanceled", "setCanceled", "isConnectSucceed", "setConnectSucceed", "key", "", "getKey", "()Ljava/lang/String;", VasCommonJsbProxy.JSON_KEY_SET_KEY, "(Ljava/lang/String;)V", "receiveTime", "getReceiveTime", "setReceiveTime", "startTime", "getStartTime", "setStartTime", "statisticUnitList", "Ljava/util/ArrayList;", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$StatisticUnit;", "Lkotlin/collections/ArrayList;", "getStatisticUnitList", "()Ljava/util/ArrayList;", "waitThreadTime", "getWaitThreadTime", "setWaitThreadTime", "getLastUnit", "getTotalTime", "newStatisticUnit", "Companion", "ConnectUnit", "EncryptUnit", "ResponseUnit", "StatisticUnit", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class StatisticInfo implements Cloneable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int concurrentCount;
    private long endTime;

    @Nullable
    private Throwable exception;
    private int flowId;
    private boolean isBizSucceed;
    private boolean isCanceled;
    private boolean isConnectSucceed;

    @Nullable
    private String key;
    private long receiveTime;
    private long startTime;
    private long waitThreadTime;

    @NotNull
    private final EncryptUnit encryptUnit = new EncryptUnit(null, 0, 0, 0, 0, 31, null);

    @NotNull
    private final ArrayList<StatisticUnit> statisticUnitList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$Companion;", "", "()V", "safeValue", "", "value", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long safeValue(long value) {
            if (value < 0) {
                return -1L;
            }
            return value;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00a9\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0002\u0010\u0015J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\bH\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0011H\u00c6\u0003J\t\u0010?\u001a\u00020\u0011H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\bH\u00c6\u0003J\t\u0010E\u001a\u00020\bH\u00c6\u0003J\t\u0010F\u001a\u00020\bH\u00c6\u0003J\t\u0010G\u001a\u00020\bH\u00c6\u0003J\t\u0010H\u001a\u00020\bH\u00c6\u0003J\u00ad\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00c6\u0001J\u0013\u0010J\u001a\u00020\u00112\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010L\u001a\u00020MH\u00d6\u0001J\t\u0010N\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001a\u0010\u0012\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010*\"\u0004\b-\u0010,R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u0010#R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010!\"\u0004\b3\u0010#R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010!\"\u0004\b9\u0010#\u00a8\u0006O"}, d2 = {"Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ConnectUnit;", "", "dns", "", "routeAddress", "host", "proxy", "dnsStartTime", "", "dnsEndTime", "connectStartTime", "tlsStartTime", "tlsEndTime", "tlsVersion", "connectEndTime", AudienceReportConst.PROTOCOL, "isConnectSucceed", "", "is0RTT", "body", "Lokhttp3/RequestBody;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJJLjava/lang/String;JLjava/lang/String;ZZLokhttp3/RequestBody;)V", "getBody", "()Lokhttp3/RequestBody;", "setBody", "(Lokhttp3/RequestBody;)V", "getConnectEndTime", "()J", "setConnectEndTime", "(J)V", "getConnectStartTime", "setConnectStartTime", "getDns", "()Ljava/lang/String;", "setDns", "(Ljava/lang/String;)V", "getDnsEndTime", "setDnsEndTime", "getDnsStartTime", "setDnsStartTime", "getHost", "setHost", "()Z", "set0RTT", "(Z)V", "setConnectSucceed", "getProtocol", "setProtocol", "getProxy", "setProxy", "getRouteAddress", "setRouteAddress", "getTlsEndTime", "setTlsEndTime", "getTlsStartTime", "setTlsStartTime", "getTlsVersion", "setTlsVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class ConnectUnit {

        @Nullable
        private RequestBody body;
        private long connectEndTime;
        private long connectStartTime;

        @Nullable
        private String dns;
        private long dnsEndTime;
        private long dnsStartTime;

        @Nullable
        private String host;
        private boolean is0RTT;
        private boolean isConnectSucceed;

        @Nullable
        private String protocol;

        @Nullable
        private String proxy;

        @Nullable
        private String routeAddress;
        private long tlsEndTime;
        private long tlsStartTime;

        @Nullable
        private String tlsVersion;

        public ConnectUnit() {
            this(null, null, null, null, 0L, 0L, 0L, 0L, 0L, null, 0L, null, false, false, null, 32767, null);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getDns() {
            return this.dns;
        }

        @Nullable
        /* renamed from: component10, reason: from getter */
        public final String getTlsVersion() {
            return this.tlsVersion;
        }

        /* renamed from: component11, reason: from getter */
        public final long getConnectEndTime() {
            return this.connectEndTime;
        }

        @Nullable
        /* renamed from: component12, reason: from getter */
        public final String getProtocol() {
            return this.protocol;
        }

        /* renamed from: component13, reason: from getter */
        public final boolean getIsConnectSucceed() {
            return this.isConnectSucceed;
        }

        /* renamed from: component14, reason: from getter */
        public final boolean getIs0RTT() {
            return this.is0RTT;
        }

        @Nullable
        /* renamed from: component15, reason: from getter */
        public final RequestBody getBody() {
            return this.body;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getRouteAddress() {
            return this.routeAddress;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getHost() {
            return this.host;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getProxy() {
            return this.proxy;
        }

        /* renamed from: component5, reason: from getter */
        public final long getDnsStartTime() {
            return this.dnsStartTime;
        }

        /* renamed from: component6, reason: from getter */
        public final long getDnsEndTime() {
            return this.dnsEndTime;
        }

        /* renamed from: component7, reason: from getter */
        public final long getConnectStartTime() {
            return this.connectStartTime;
        }

        /* renamed from: component8, reason: from getter */
        public final long getTlsStartTime() {
            return this.tlsStartTime;
        }

        /* renamed from: component9, reason: from getter */
        public final long getTlsEndTime() {
            return this.tlsEndTime;
        }

        @NotNull
        public final ConnectUnit copy(@Nullable String dns, @Nullable String routeAddress, @Nullable String host, @Nullable String proxy, long dnsStartTime, long dnsEndTime, long connectStartTime, long tlsStartTime, long tlsEndTime, @Nullable String tlsVersion, long connectEndTime, @Nullable String protocol2, boolean isConnectSucceed, boolean is0RTT, @Nullable RequestBody body) {
            return new ConnectUnit(dns, routeAddress, host, proxy, dnsStartTime, dnsEndTime, connectStartTime, tlsStartTime, tlsEndTime, tlsVersion, connectEndTime, protocol2, isConnectSucceed, is0RTT, body);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectUnit)) {
                return false;
            }
            ConnectUnit connectUnit = (ConnectUnit) other;
            if (Intrinsics.areEqual(this.dns, connectUnit.dns) && Intrinsics.areEqual(this.routeAddress, connectUnit.routeAddress) && Intrinsics.areEqual(this.host, connectUnit.host) && Intrinsics.areEqual(this.proxy, connectUnit.proxy) && this.dnsStartTime == connectUnit.dnsStartTime && this.dnsEndTime == connectUnit.dnsEndTime && this.connectStartTime == connectUnit.connectStartTime && this.tlsStartTime == connectUnit.tlsStartTime && this.tlsEndTime == connectUnit.tlsEndTime && Intrinsics.areEqual(this.tlsVersion, connectUnit.tlsVersion) && this.connectEndTime == connectUnit.connectEndTime && Intrinsics.areEqual(this.protocol, connectUnit.protocol) && this.isConnectSucceed == connectUnit.isConnectSucceed && this.is0RTT == connectUnit.is0RTT && Intrinsics.areEqual(this.body, connectUnit.body)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final RequestBody getBody() {
            return this.body;
        }

        public final long getConnectEndTime() {
            return this.connectEndTime;
        }

        public final long getConnectStartTime() {
            return this.connectStartTime;
        }

        @Nullable
        public final String getDns() {
            return this.dns;
        }

        public final long getDnsEndTime() {
            return this.dnsEndTime;
        }

        public final long getDnsStartTime() {
            return this.dnsStartTime;
        }

        @Nullable
        public final String getHost() {
            return this.host;
        }

        @Nullable
        public final String getProtocol() {
            return this.protocol;
        }

        @Nullable
        public final String getProxy() {
            return this.proxy;
        }

        @Nullable
        public final String getRouteAddress() {
            return this.routeAddress;
        }

        public final long getTlsEndTime() {
            return this.tlsEndTime;
        }

        public final long getTlsStartTime() {
            return this.tlsStartTime;
        }

        @Nullable
        public final String getTlsVersion() {
            return this.tlsVersion;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            String str = this.dns;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.routeAddress;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.host;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.proxy;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int a16 = (((((((((((i18 + hashCode4) * 31) + a.a(this.dnsStartTime)) * 31) + a.a(this.dnsEndTime)) * 31) + a.a(this.connectStartTime)) * 31) + a.a(this.tlsStartTime)) * 31) + a.a(this.tlsEndTime)) * 31;
            String str5 = this.tlsVersion;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int a17 = (((a16 + hashCode5) * 31) + a.a(this.connectEndTime)) * 31;
            String str6 = this.protocol;
            if (str6 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str6.hashCode();
            }
            int i19 = (a17 + hashCode6) * 31;
            boolean z16 = this.isConnectSucceed;
            int i26 = 1;
            int i27 = z16;
            if (z16 != 0) {
                i27 = 1;
            }
            int i28 = (i19 + i27) * 31;
            boolean z17 = this.is0RTT;
            if (!z17) {
                i26 = z17 ? 1 : 0;
            }
            int i29 = (i28 + i26) * 31;
            RequestBody requestBody = this.body;
            if (requestBody != null) {
                i3 = requestBody.hashCode();
            }
            return i29 + i3;
        }

        public final boolean is0RTT() {
            return this.is0RTT;
        }

        public final boolean isConnectSucceed() {
            return this.isConnectSucceed;
        }

        public final void set0RTT(boolean z16) {
            this.is0RTT = z16;
        }

        public final void setBody(@Nullable RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setConnectEndTime(long j3) {
            this.connectEndTime = j3;
        }

        public final void setConnectStartTime(long j3) {
            this.connectStartTime = j3;
        }

        public final void setConnectSucceed(boolean z16) {
            this.isConnectSucceed = z16;
        }

        public final void setDns(@Nullable String str) {
            this.dns = str;
        }

        public final void setDnsEndTime(long j3) {
            this.dnsEndTime = j3;
        }

        public final void setDnsStartTime(long j3) {
            this.dnsStartTime = j3;
        }

        public final void setHost(@Nullable String str) {
            this.host = str;
        }

        public final void setProtocol(@Nullable String str) {
            this.protocol = str;
        }

        public final void setProxy(@Nullable String str) {
            this.proxy = str;
        }

        public final void setRouteAddress(@Nullable String str) {
            this.routeAddress = str;
        }

        public final void setTlsEndTime(long j3) {
            this.tlsEndTime = j3;
        }

        public final void setTlsStartTime(long j3) {
            this.tlsStartTime = j3;
        }

        public final void setTlsVersion(@Nullable String str) {
            this.tlsVersion = str;
        }

        @NotNull
        public String toString() {
            return "ConnectUnit(dns=" + this.dns + ", routeAddress=" + this.routeAddress + ", host=" + this.host + ", proxy=" + this.proxy + ", dnsStartTime=" + this.dnsStartTime + ", dnsEndTime=" + this.dnsEndTime + ", connectStartTime=" + this.connectStartTime + ", tlsStartTime=" + this.tlsStartTime + ", tlsEndTime=" + this.tlsEndTime + ", tlsVersion=" + this.tlsVersion + ", connectEndTime=" + this.connectEndTime + ", protocol=" + this.protocol + ", isConnectSucceed=" + this.isConnectSucceed + ", is0RTT=" + this.is0RTT + ", body=" + this.body + ")";
        }

        public ConnectUnit(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j3, long j16, long j17, long j18, long j19, @Nullable String str5, long j26, @Nullable String str6, boolean z16, boolean z17, @Nullable RequestBody requestBody) {
            this.dns = str;
            this.routeAddress = str2;
            this.host = str3;
            this.proxy = str4;
            this.dnsStartTime = j3;
            this.dnsEndTime = j16;
            this.connectStartTime = j17;
            this.tlsStartTime = j18;
            this.tlsEndTime = j19;
            this.tlsVersion = str5;
            this.connectEndTime = j26;
            this.protocol = str6;
            this.isConnectSucceed = z16;
            this.is0RTT = z17;
            this.body = requestBody;
        }

        public /* synthetic */ ConnectUnit(String str, String str2, String str3, String str4, long j3, long j16, long j17, long j18, long j19, String str5, long j26, String str6, boolean z16, boolean z17, RequestBody requestBody, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? 0L : j3, (i3 & 32) != 0 ? 0L : j16, (i3 & 64) != 0 ? 0L : j17, (i3 & 128) != 0 ? 0L : j18, (i3 & 256) != 0 ? 0L : j19, (i3 & 512) != 0 ? null : str5, (i3 & 1024) == 0 ? j26 : 0L, (i3 & 2048) != 0 ? null : str6, (i3 & 4096) != 0 ? false : z16, (i3 & 8192) == 0 ? z17 : false, (i3 & 16384) != 0 ? null : requestBody);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\tH\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e\u00a8\u0006&"}, d2 = {"Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$EncryptUnit;", "", "encryptAlgorithm", "", "dhCostTime", "", "encryptTime", "decryptTime", "dhCtrlCode", "", "(Ljava/lang/String;JJJI)V", "getDecryptTime", "()J", "setDecryptTime", "(J)V", "getDhCostTime", "setDhCostTime", "getDhCtrlCode", "()I", "setDhCtrlCode", "(I)V", "getEncryptAlgorithm", "()Ljava/lang/String;", "setEncryptAlgorithm", "(Ljava/lang/String;)V", "getEncryptTime", "setEncryptTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class EncryptUnit {
        private long decryptTime;
        private long dhCostTime;
        private int dhCtrlCode;

        @NotNull
        private String encryptAlgorithm;
        private long encryptTime;

        public EncryptUnit() {
            this(null, 0L, 0L, 0L, 0, 31, null);
        }

        public static /* synthetic */ EncryptUnit copy$default(EncryptUnit encryptUnit, String str, long j3, long j16, long j17, int i3, int i16, Object obj) {
            String str2;
            long j18;
            long j19;
            long j26;
            int i17;
            if ((i16 & 1) != 0) {
                str2 = encryptUnit.encryptAlgorithm;
            } else {
                str2 = str;
            }
            if ((i16 & 2) != 0) {
                j18 = encryptUnit.dhCostTime;
            } else {
                j18 = j3;
            }
            if ((i16 & 4) != 0) {
                j19 = encryptUnit.encryptTime;
            } else {
                j19 = j16;
            }
            if ((i16 & 8) != 0) {
                j26 = encryptUnit.decryptTime;
            } else {
                j26 = j17;
            }
            if ((i16 & 16) != 0) {
                i17 = encryptUnit.dhCtrlCode;
            } else {
                i17 = i3;
            }
            return encryptUnit.copy(str2, j18, j19, j26, i17);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getEncryptAlgorithm() {
            return this.encryptAlgorithm;
        }

        /* renamed from: component2, reason: from getter */
        public final long getDhCostTime() {
            return this.dhCostTime;
        }

        /* renamed from: component3, reason: from getter */
        public final long getEncryptTime() {
            return this.encryptTime;
        }

        /* renamed from: component4, reason: from getter */
        public final long getDecryptTime() {
            return this.decryptTime;
        }

        /* renamed from: component5, reason: from getter */
        public final int getDhCtrlCode() {
            return this.dhCtrlCode;
        }

        @NotNull
        public final EncryptUnit copy(@NotNull String encryptAlgorithm, long dhCostTime, long encryptTime, long decryptTime, int dhCtrlCode) {
            Intrinsics.checkNotNullParameter(encryptAlgorithm, "encryptAlgorithm");
            return new EncryptUnit(encryptAlgorithm, dhCostTime, encryptTime, decryptTime, dhCtrlCode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EncryptUnit)) {
                return false;
            }
            EncryptUnit encryptUnit = (EncryptUnit) other;
            if (Intrinsics.areEqual(this.encryptAlgorithm, encryptUnit.encryptAlgorithm) && this.dhCostTime == encryptUnit.dhCostTime && this.encryptTime == encryptUnit.encryptTime && this.decryptTime == encryptUnit.decryptTime && this.dhCtrlCode == encryptUnit.dhCtrlCode) {
                return true;
            }
            return false;
        }

        public final long getDecryptTime() {
            return this.decryptTime;
        }

        public final long getDhCostTime() {
            return this.dhCostTime;
        }

        public final int getDhCtrlCode() {
            return this.dhCtrlCode;
        }

        @NotNull
        public final String getEncryptAlgorithm() {
            return this.encryptAlgorithm;
        }

        public final long getEncryptTime() {
            return this.encryptTime;
        }

        public int hashCode() {
            return (((((((this.encryptAlgorithm.hashCode() * 31) + a.a(this.dhCostTime)) * 31) + a.a(this.encryptTime)) * 31) + a.a(this.decryptTime)) * 31) + this.dhCtrlCode;
        }

        public final void setDecryptTime(long j3) {
            this.decryptTime = j3;
        }

        public final void setDhCostTime(long j3) {
            this.dhCostTime = j3;
        }

        public final void setDhCtrlCode(int i3) {
            this.dhCtrlCode = i3;
        }

        public final void setEncryptAlgorithm(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encryptAlgorithm = str;
        }

        public final void setEncryptTime(long j3) {
            this.encryptTime = j3;
        }

        @NotNull
        public String toString() {
            return "EncryptUnit(encryptAlgorithm=" + this.encryptAlgorithm + ", dhCostTime=" + this.dhCostTime + ", encryptTime=" + this.encryptTime + ", decryptTime=" + this.decryptTime + ", dhCtrlCode=" + this.dhCtrlCode + ")";
        }

        public EncryptUnit(@NotNull String encryptAlgorithm, long j3, long j16, long j17, int i3) {
            Intrinsics.checkNotNullParameter(encryptAlgorithm, "encryptAlgorithm");
            this.encryptAlgorithm = encryptAlgorithm;
            this.dhCostTime = j3;
            this.encryptTime = j16;
            this.decryptTime = j17;
            this.dhCtrlCode = i3;
        }

        public /* synthetic */ EncryptUnit(String str, long j3, long j16, long j17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? 0L : j16, (i16 & 8) == 0 ? j17 : 0L, (i16 & 16) != 0 ? 0 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\rH\u00c6\u0003J_\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u00c6\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\tH\u00d6\u0001J\t\u00104\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012\u00a8\u00065"}, d2 = {"Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ResponseUnit;", "", "fromPosition", "", "contentLength", "totalSize", "contentType", "", "httpStatus", "", "httpResponseTime", "lastModifyTime", "okResponse", "Lokhttp3/Response;", "(JJJLjava/lang/String;IJLjava/lang/String;Lokhttp3/Response;)V", "getContentLength", "()J", "setContentLength", "(J)V", "getContentType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "getFromPosition", "setFromPosition", "getHttpResponseTime", "setHttpResponseTime", "getHttpStatus", "()I", "setHttpStatus", "(I)V", "getLastModifyTime", "setLastModifyTime", "getOkResponse", "()Lokhttp3/Response;", "setOkResponse", "(Lokhttp3/Response;)V", "getTotalSize", "setTotalSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class ResponseUnit {
        private long contentLength;

        @Nullable
        private String contentType;
        private long fromPosition;
        private long httpResponseTime;
        private int httpStatus;

        @Nullable
        private String lastModifyTime;

        @Nullable
        private Response okResponse;
        private long totalSize;

        public ResponseUnit() {
            this(0L, 0L, 0L, null, 0, 0L, null, null, 255, null);
        }

        public static /* synthetic */ ResponseUnit copy$default(ResponseUnit responseUnit, long j3, long j16, long j17, String str, int i3, long j18, String str2, Response response, int i16, Object obj) {
            long j19;
            long j26;
            long j27;
            String str3;
            int i17;
            long j28;
            String str4;
            Response response2;
            if ((i16 & 1) != 0) {
                j19 = responseUnit.fromPosition;
            } else {
                j19 = j3;
            }
            if ((i16 & 2) != 0) {
                j26 = responseUnit.contentLength;
            } else {
                j26 = j16;
            }
            if ((i16 & 4) != 0) {
                j27 = responseUnit.totalSize;
            } else {
                j27 = j17;
            }
            if ((i16 & 8) != 0) {
                str3 = responseUnit.contentType;
            } else {
                str3 = str;
            }
            if ((i16 & 16) != 0) {
                i17 = responseUnit.httpStatus;
            } else {
                i17 = i3;
            }
            if ((i16 & 32) != 0) {
                j28 = responseUnit.httpResponseTime;
            } else {
                j28 = j18;
            }
            if ((i16 & 64) != 0) {
                str4 = responseUnit.lastModifyTime;
            } else {
                str4 = str2;
            }
            if ((i16 & 128) != 0) {
                response2 = responseUnit.okResponse;
            } else {
                response2 = response;
            }
            return responseUnit.copy(j19, j26, j27, str3, i17, j28, str4, response2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getFromPosition() {
            return this.fromPosition;
        }

        /* renamed from: component2, reason: from getter */
        public final long getContentLength() {
            return this.contentLength;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTotalSize() {
            return this.totalSize;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getContentType() {
            return this.contentType;
        }

        /* renamed from: component5, reason: from getter */
        public final int getHttpStatus() {
            return this.httpStatus;
        }

        /* renamed from: component6, reason: from getter */
        public final long getHttpResponseTime() {
            return this.httpResponseTime;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final String getLastModifyTime() {
            return this.lastModifyTime;
        }

        @Nullable
        /* renamed from: component8, reason: from getter */
        public final Response getOkResponse() {
            return this.okResponse;
        }

        @NotNull
        public final ResponseUnit copy(long fromPosition, long contentLength, long totalSize, @Nullable String contentType, int httpStatus, long httpResponseTime, @Nullable String lastModifyTime, @Nullable Response okResponse) {
            return new ResponseUnit(fromPosition, contentLength, totalSize, contentType, httpStatus, httpResponseTime, lastModifyTime, okResponse);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResponseUnit)) {
                return false;
            }
            ResponseUnit responseUnit = (ResponseUnit) other;
            if (this.fromPosition == responseUnit.fromPosition && this.contentLength == responseUnit.contentLength && this.totalSize == responseUnit.totalSize && Intrinsics.areEqual(this.contentType, responseUnit.contentType) && this.httpStatus == responseUnit.httpStatus && this.httpResponseTime == responseUnit.httpResponseTime && Intrinsics.areEqual(this.lastModifyTime, responseUnit.lastModifyTime) && Intrinsics.areEqual(this.okResponse, responseUnit.okResponse)) {
                return true;
            }
            return false;
        }

        public final long getContentLength() {
            return this.contentLength;
        }

        @Nullable
        public final String getContentType() {
            return this.contentType;
        }

        public final long getFromPosition() {
            return this.fromPosition;
        }

        public final long getHttpResponseTime() {
            return this.httpResponseTime;
        }

        public final int getHttpStatus() {
            return this.httpStatus;
        }

        @Nullable
        public final String getLastModifyTime() {
            return this.lastModifyTime;
        }

        @Nullable
        public final Response getOkResponse() {
            return this.okResponse;
        }

        public final long getTotalSize() {
            return this.totalSize;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int a16 = ((((a.a(this.fromPosition) * 31) + a.a(this.contentLength)) * 31) + a.a(this.totalSize)) * 31;
            String str = this.contentType;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int a17 = (((((a16 + hashCode) * 31) + this.httpStatus) * 31) + a.a(this.httpResponseTime)) * 31;
            String str2 = this.lastModifyTime;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i16 = (a17 + hashCode2) * 31;
            Response response = this.okResponse;
            if (response != null) {
                i3 = response.hashCode();
            }
            return i16 + i3;
        }

        public final void setContentLength(long j3) {
            this.contentLength = j3;
        }

        public final void setContentType(@Nullable String str) {
            this.contentType = str;
        }

        public final void setFromPosition(long j3) {
            this.fromPosition = j3;
        }

        public final void setHttpResponseTime(long j3) {
            this.httpResponseTime = j3;
        }

        public final void setHttpStatus(int i3) {
            this.httpStatus = i3;
        }

        public final void setLastModifyTime(@Nullable String str) {
            this.lastModifyTime = str;
        }

        public final void setOkResponse(@Nullable Response response) {
            this.okResponse = response;
        }

        public final void setTotalSize(long j3) {
            this.totalSize = j3;
        }

        @NotNull
        public String toString() {
            return "ResponseUnit(fromPosition=" + this.fromPosition + ", contentLength=" + this.contentLength + ", totalSize=" + this.totalSize + ", contentType=" + this.contentType + ", httpStatus=" + this.httpStatus + ", httpResponseTime=" + this.httpResponseTime + ", lastModifyTime=" + this.lastModifyTime + ", okResponse=" + this.okResponse + ")";
        }

        public ResponseUnit(long j3, long j16, long j17, @Nullable String str, int i3, long j18, @Nullable String str2, @Nullable Response response) {
            this.fromPosition = j3;
            this.contentLength = j16;
            this.totalSize = j17;
            this.contentType = str;
            this.httpStatus = i3;
            this.httpResponseTime = j18;
            this.lastModifyTime = str2;
            this.okResponse = response;
        }

        public /* synthetic */ ResponseUnit(long j3, long j16, long j17, String str, int i3, long j18, String str2, Response response, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? 0L : j16, (i16 & 4) != 0 ? 0L : j17, (i16 & 8) != 0 ? null : str, (i16 & 16) != 0 ? 0 : i3, (i16 & 32) == 0 ? j18 : 0L, (i16 & 64) != 0 ? null : str2, (i16 & 128) == 0 ? response : null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\t\u0010)\u001a\u00020\fH\u00c6\u0003JG\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\b\u00100\u001a\u0004\u0018\u000101J\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020\u0005J\u0006\u00104\u001a\u00020\u0005J\t\u00105\u001a\u00020\u0003H\u00d6\u0001J\t\u00106\u001a\u000207H\u00d6\u0001R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!\u00a8\u00068"}, d2 = {"Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$StatisticUnit;", "", "retryTimes", "", "unitStartTime", "", "unitEndTime", "exception", "", "connectUnit", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ConnectUnit;", "responseUnit", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ResponseUnit;", "(IJJLjava/lang/Throwable;Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ConnectUnit;Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ResponseUnit;)V", "getConnectUnit", "()Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ConnectUnit;", "setConnectUnit", "(Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ConnectUnit;)V", "getException", "()Ljava/lang/Throwable;", "setException", "(Ljava/lang/Throwable;)V", "getResponseUnit", "()Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ResponseUnit;", "setResponseUnit", "(Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$ResponseUnit;)V", "getRetryTimes", "()I", "setRetryTimes", "(I)V", "getUnitEndTime", "()J", "setUnitEndTime", "(J)V", "getUnitStartTime", "setUnitStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "getDnsTime", "getHttpConnectTime", "getResponse", "Lokhttp3/Response;", "getTcpConnectTime", "getTlsTime", "getUnitTotalTime", "hashCode", "toString", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class StatisticUnit {

        @NotNull
        private ConnectUnit connectUnit;

        @Nullable
        private Throwable exception;

        @NotNull
        private ResponseUnit responseUnit;
        private int retryTimes;
        private long unitEndTime;
        private long unitStartTime;

        public StatisticUnit() {
            this(0, 0L, 0L, null, null, null, 63, null);
        }

        public static /* synthetic */ StatisticUnit copy$default(StatisticUnit statisticUnit, int i3, long j3, long j16, Throwable th5, ConnectUnit connectUnit, ResponseUnit responseUnit, int i16, Object obj) {
            int i17;
            long j17;
            long j18;
            Throwable th6;
            ConnectUnit connectUnit2;
            ResponseUnit responseUnit2;
            if ((i16 & 1) != 0) {
                i17 = statisticUnit.retryTimes;
            } else {
                i17 = i3;
            }
            if ((i16 & 2) != 0) {
                j17 = statisticUnit.unitStartTime;
            } else {
                j17 = j3;
            }
            if ((i16 & 4) != 0) {
                j18 = statisticUnit.unitEndTime;
            } else {
                j18 = j16;
            }
            if ((i16 & 8) != 0) {
                th6 = statisticUnit.exception;
            } else {
                th6 = th5;
            }
            if ((i16 & 16) != 0) {
                connectUnit2 = statisticUnit.connectUnit;
            } else {
                connectUnit2 = connectUnit;
            }
            if ((i16 & 32) != 0) {
                responseUnit2 = statisticUnit.responseUnit;
            } else {
                responseUnit2 = responseUnit;
            }
            return statisticUnit.copy(i17, j17, j18, th6, connectUnit2, responseUnit2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getRetryTimes() {
            return this.retryTimes;
        }

        /* renamed from: component2, reason: from getter */
        public final long getUnitStartTime() {
            return this.unitStartTime;
        }

        /* renamed from: component3, reason: from getter */
        public final long getUnitEndTime() {
            return this.unitEndTime;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final Throwable getException() {
            return this.exception;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final ConnectUnit getConnectUnit() {
            return this.connectUnit;
        }

        @NotNull
        /* renamed from: component6, reason: from getter */
        public final ResponseUnit getResponseUnit() {
            return this.responseUnit;
        }

        @NotNull
        public final StatisticUnit copy(int retryTimes, long unitStartTime, long unitEndTime, @Nullable Throwable exception, @NotNull ConnectUnit connectUnit, @NotNull ResponseUnit responseUnit) {
            Intrinsics.checkNotNullParameter(connectUnit, "connectUnit");
            Intrinsics.checkNotNullParameter(responseUnit, "responseUnit");
            return new StatisticUnit(retryTimes, unitStartTime, unitEndTime, exception, connectUnit, responseUnit);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StatisticUnit)) {
                return false;
            }
            StatisticUnit statisticUnit = (StatisticUnit) other;
            if (this.retryTimes == statisticUnit.retryTimes && this.unitStartTime == statisticUnit.unitStartTime && this.unitEndTime == statisticUnit.unitEndTime && Intrinsics.areEqual(this.exception, statisticUnit.exception) && Intrinsics.areEqual(this.connectUnit, statisticUnit.connectUnit) && Intrinsics.areEqual(this.responseUnit, statisticUnit.responseUnit)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final ConnectUnit getConnectUnit() {
            return this.connectUnit;
        }

        public final long getDnsTime() {
            return StatisticInfo.INSTANCE.safeValue(this.connectUnit.getDnsEndTime() - this.connectUnit.getDnsStartTime());
        }

        @Nullable
        public final Throwable getException() {
            return this.exception;
        }

        public final long getHttpConnectTime() {
            return StatisticInfo.INSTANCE.safeValue(this.responseUnit.getHttpResponseTime() - this.connectUnit.getConnectStartTime());
        }

        @Nullable
        public final Response getResponse() {
            return this.responseUnit.getOkResponse();
        }

        @NotNull
        public final ResponseUnit getResponseUnit() {
            return this.responseUnit;
        }

        public final int getRetryTimes() {
            return this.retryTimes;
        }

        public final long getTcpConnectTime() {
            return StatisticInfo.INSTANCE.safeValue(this.connectUnit.getConnectEndTime() - this.connectUnit.getConnectStartTime());
        }

        public final long getTlsTime() {
            return StatisticInfo.INSTANCE.safeValue(this.connectUnit.getTlsEndTime() - this.connectUnit.getTlsStartTime());
        }

        public final long getUnitEndTime() {
            return this.unitEndTime;
        }

        public final long getUnitStartTime() {
            return this.unitStartTime;
        }

        public final long getUnitTotalTime() {
            return StatisticInfo.INSTANCE.safeValue(this.unitEndTime - this.unitStartTime);
        }

        public int hashCode() {
            int hashCode;
            int a16 = ((((this.retryTimes * 31) + a.a(this.unitStartTime)) * 31) + a.a(this.unitEndTime)) * 31;
            Throwable th5 = this.exception;
            if (th5 == null) {
                hashCode = 0;
            } else {
                hashCode = th5.hashCode();
            }
            return ((((a16 + hashCode) * 31) + this.connectUnit.hashCode()) * 31) + this.responseUnit.hashCode();
        }

        public final void setConnectUnit(@NotNull ConnectUnit connectUnit) {
            Intrinsics.checkNotNullParameter(connectUnit, "<set-?>");
            this.connectUnit = connectUnit;
        }

        public final void setException(@Nullable Throwable th5) {
            this.exception = th5;
        }

        public final void setResponseUnit(@NotNull ResponseUnit responseUnit) {
            Intrinsics.checkNotNullParameter(responseUnit, "<set-?>");
            this.responseUnit = responseUnit;
        }

        public final void setRetryTimes(int i3) {
            this.retryTimes = i3;
        }

        public final void setUnitEndTime(long j3) {
            this.unitEndTime = j3;
        }

        public final void setUnitStartTime(long j3) {
            this.unitStartTime = j3;
        }

        @NotNull
        public String toString() {
            return "StatisticUnit(retryTimes=" + this.retryTimes + ", unitStartTime=" + this.unitStartTime + ", unitEndTime=" + this.unitEndTime + ", exception=" + this.exception + ", connectUnit=" + this.connectUnit + ", responseUnit=" + this.responseUnit + ")";
        }

        public StatisticUnit(int i3, long j3, long j16, @Nullable Throwable th5, @NotNull ConnectUnit connectUnit, @NotNull ResponseUnit responseUnit) {
            Intrinsics.checkNotNullParameter(connectUnit, "connectUnit");
            Intrinsics.checkNotNullParameter(responseUnit, "responseUnit");
            this.retryTimes = i3;
            this.unitStartTime = j3;
            this.unitEndTime = j16;
            this.exception = th5;
            this.connectUnit = connectUnit;
            this.responseUnit = responseUnit;
        }

        public /* synthetic */ StatisticUnit(int i3, long j3, long j16, Throwable th5, ConnectUnit connectUnit, ResponseUnit responseUnit, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) == 0 ? j16 : 0L, (i16 & 8) != 0 ? null : th5, (i16 & 16) != 0 ? new ConnectUnit(null, null, null, null, 0L, 0L, 0L, 0L, 0L, null, 0L, null, false, false, null, 32767, null) : connectUnit, (i16 & 32) != 0 ? new ResponseUnit(0L, 0L, 0L, null, 0, 0L, null, null, 255, null) : responseUnit);
        }
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    public final int getConcurrentCount() {
        return this.concurrentCount;
    }

    @NotNull
    public final EncryptUnit getEncryptUnit() {
        return this.encryptUnit;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @Nullable
    public final Throwable getException() {
        return this.exception;
    }

    public final int getFlowId() {
        return this.flowId;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final StatisticUnit getLastUnit() {
        Object lastOrNull;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.statisticUnitList);
        return (StatisticUnit) lastOrNull;
    }

    public final long getReceiveTime() {
        return this.receiveTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @NotNull
    public final ArrayList<StatisticUnit> getStatisticUnitList() {
        return this.statisticUnitList;
    }

    public final long getTotalTime() {
        return INSTANCE.safeValue(this.endTime - this.startTime);
    }

    public final long getWaitThreadTime() {
        return this.waitThreadTime;
    }

    /* renamed from: isBizSucceed, reason: from getter */
    public final boolean getIsBizSucceed() {
        return this.isBizSucceed;
    }

    /* renamed from: isCanceled, reason: from getter */
    public final boolean getIsCanceled() {
        return this.isCanceled;
    }

    /* renamed from: isConnectSucceed, reason: from getter */
    public final boolean getIsConnectSucceed() {
        return this.isConnectSucceed;
    }

    @NotNull
    public final StatisticUnit newStatisticUnit() {
        StatisticUnit statisticUnit = new StatisticUnit(0, 0L, 0L, null, null, null, 63, null);
        this.statisticUnitList.add(statisticUnit);
        return statisticUnit;
    }

    public final void setBizSucceed(boolean z16) {
        this.isBizSucceed = z16;
    }

    public final void setCanceled(boolean z16) {
        this.isCanceled = z16;
    }

    public final void setConcurrentCount(int i3) {
        this.concurrentCount = i3;
    }

    public final void setConnectSucceed(boolean z16) {
        this.isConnectSucceed = z16;
    }

    public final void setEndTime(long j3) {
        this.endTime = j3;
    }

    public final void setException(@Nullable Throwable th5) {
        this.exception = th5;
    }

    public final void setFlowId(int i3) {
        this.flowId = i3;
    }

    public final void setKey(@Nullable String str) {
        this.key = str;
    }

    public final void setReceiveTime(long j3) {
        this.receiveTime = j3;
    }

    public final void setStartTime(long j3) {
        this.startTime = j3;
    }

    public final void setWaitThreadTime(long j3) {
        this.waitThreadTime = j3;
    }
}
