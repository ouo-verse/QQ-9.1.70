package com.tenpay.sdk.net.http.statisitc;

import android.net.http.Headers;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.statistic.ConnectStep;
import com.tenpay.sdk.net.core.statistic.ContentRange;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.http.common.HttpConst;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.TlsVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J2\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J+\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 2\u0011\u0010!\u001a\r\u0012\t\u0012\u00070#\u00a2\u0006\u0002\b$0\"H\u0016J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0014\u0010&\u001a\u0004\u0018\u00010 2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010)\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010-\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u00101\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u00103\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u00107\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2 = {"Lcom/tenpay/sdk/net/http/statisitc/HttpStatisticMonitor;", "Lokhttp3/EventListener;", "()V", "mCurrentStep", "Lcom/tenpay/sdk/net/core/statistic/ConnectStep;", "mStatisticInfo", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "mStatisticUnit", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo$StatisticUnit;", "callEnd", "", "call", "Lokhttp3/Call;", "callFailed", "ioe", "Ljava/io/IOException;", "callStart", "connectEnd", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "Ljava/net/Proxy;", AudienceReportConst.PROTOCOL, "Lokhttp3/Protocol;", "connectFailed", "connectStart", "connectionAcquired", Headers.CONN_DIRECTIVE, "Lokhttp3/Connection;", "connectionReleased", "dnsEnd", "domainName", "", "inetAddressList", "", "Ljava/net/InetAddress;", "Lkotlin/jvm/JvmSuppressWildcards;", "dnsStart", "getHeaderLogString", "headers", "Lokhttp3/Headers;", "requestBodyEnd", "byteCount", "", "requestBodyStart", "requestHeadersEnd", Const.BUNDLE_KEY_REQUEST, "Lokhttp3/Request;", "requestHeadersStart", "responseBodyEnd", "responseBodyStart", "responseHeadersEnd", "response", "Lokhttp3/Response;", "responseHeadersStart", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "secureConnectStart", "updateConnectStep", "methodStep", "Companion", "Factory", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HttpStatisticMonitor extends EventListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private ConnectStep mCurrentStep = ConnectStep.Init;
    private StatisticInfo mStatisticInfo;

    @Nullable
    private StatisticInfo.StatisticUnit mStatisticUnit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\t\u001a\u00020\nH\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/sdk/net/http/statisitc/HttpStatisticMonitor$Companion;", "", "()V", "onConnectFinish", "", "statisticInfo", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "response", "Lokhttp3/Response;", "tag", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String tag() {
            return "Statistic(" + Thread.currentThread().getName() + ")";
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
        
            if (r0 != null) goto L36;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onConnectFinish(@Nullable StatisticInfo statisticInfo, @Nullable Response response) {
            boolean z16;
            StatisticInfo.StatisticUnit lastUnit;
            StatisticInfo.ResponseUnit responseUnit;
            MediaType mediaType;
            long j3;
            ResponseBody body;
            ResponseBody body2;
            InputStream inputStream = null;
            if (statisticInfo != null && (lastUnit = statisticInfo.getLastUnit()) != null && (responseUnit = lastUnit.getResponseUnit()) != null) {
                responseUnit.setOkResponse(response);
                if (response != null && (body2 = response.body()) != null) {
                    mediaType = body2.get$contentType();
                } else {
                    mediaType = null;
                }
                responseUnit.setContentType(String.valueOf(mediaType));
                if (response != null && (body = response.body()) != null) {
                    j3 = body.getContentLength();
                } else {
                    j3 = 0;
                }
                responseUnit.setContentLength(j3);
            }
            if (statisticInfo != null) {
                boolean z17 = true;
                if (response != null && response.isSuccessful()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    ResponseBody body3 = response.body();
                    if (body3 != null) {
                        inputStream = body3.byteStream();
                    }
                }
                z17 = false;
                statisticInfo.setConnectSucceed(z17);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/net/http/statisitc/HttpStatisticMonitor$Factory;", "Lokhttp3/EventListener$Factory;", "()V", OperateCustomButton.OPERATE_CREATE, "Lokhttp3/EventListener;", "call", "Lokhttp3/Call;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Factory implements EventListener.Factory {
        @Override // okhttp3.EventListener.Factory
        @NotNull
        public EventListener create(@NotNull Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            HttpStatisticMonitor httpStatisticMonitor = new HttpStatisticMonitor();
            Object tag = call.request().tag(StatisticInfo.class);
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tenpay.sdk.net.core.statistic.StatisticInfo");
            httpStatisticMonitor.mStatisticInfo = (StatisticInfo) tag;
            return httpStatisticMonitor;
        }
    }

    private final String getHeaderLogString(okhttp3.Headers headers) {
        if (headers != null) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, List<String>> entry : headers.toMultimap().entrySet()) {
                String key = entry.getKey();
                sb5.append(((Object) key) + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue() + ";");
            }
            return sb5.toString();
        }
        return null;
    }

    private final StatisticInfo.StatisticUnit updateConnectStep(ConnectStep methodStep) {
        boolean z16;
        if (this.mCurrentStep.ordinal() >= methodStep.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || this.mStatisticUnit == null) {
            StatisticInfo statisticInfo = this.mStatisticInfo;
            if (statisticInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatisticInfo");
                statisticInfo = null;
            }
            this.mStatisticUnit = statisticInfo.newStatisticUnit();
        }
        this.mCurrentStep = methodStep;
        StatisticInfo.StatisticUnit statisticUnit = this.mStatisticUnit;
        Intrinsics.checkNotNull(statisticUnit);
        return statisticUnit;
    }

    @Override // okhttp3.EventListener
    public void callEnd(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "callEnd", null, 4, null);
        super.callEnd(call);
        updateConnectStep(ConnectStep.CallEnd).setUnitEndTime(System.currentTimeMillis());
        StatisticInfo statisticInfo = this.mStatisticInfo;
        if (statisticInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStatisticInfo");
            statisticInfo = null;
        }
        statisticInfo.setCanceled(call.getCanceled());
    }

    @Override // okhttp3.EventListener
    public void callFailed(@NotNull Call call, @NotNull IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "callFailed, [ioe=" + ioe, null, 4, null);
        super.callFailed(call, ioe);
        StatisticInfo.StatisticUnit updateConnectStep = updateConnectStep(ConnectStep.CallFailed);
        updateConnectStep.setException(ioe);
        updateConnectStep.setUnitEndTime(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void callStart(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        super.callStart(call);
        StatisticInfo.StatisticUnit updateConnectStep = updateConnectStep(ConnectStep.CallStart);
        if (updateConnectStep.getUnitStartTime() == 0) {
            updateConnectStep.setUnitStartTime(System.currentTimeMillis());
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol2) {
        String str;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "connectEnd", null, 4, null);
        super.connectEnd(call, inetSocketAddress, proxy, protocol2);
        StatisticInfo.StatisticUnit updateConnectStep = updateConnectStep(ConnectStep.ConnectEnd);
        updateConnectStep.getConnectUnit().setConnectEndTime(System.currentTimeMillis());
        StatisticInfo.ConnectUnit connectUnit = updateConnectStep.getConnectUnit();
        if (protocol2 != null) {
            str = protocol2.name();
        } else {
            str = null;
        }
        connectUnit.setProtocol(str);
        updateConnectStep.getConnectUnit().setConnectSucceed(true);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy, @Nullable Protocol protocol2, @NotNull IOException ioe) {
        String str;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        super.connectFailed(call, inetSocketAddress, proxy, protocol2, ioe);
        StatisticInfo.StatisticUnit updateConnectStep = updateConnectStep(ConnectStep.ConnectFailed);
        updateConnectStep.getConnectUnit().setConnectEndTime(System.currentTimeMillis());
        StatisticInfo.ConnectUnit connectUnit = updateConnectStep.getConnectUnit();
        if (protocol2 != null) {
            str = protocol2.name();
        } else {
            str = null;
        }
        connectUnit.setProtocol(str);
        updateConnectStep.getConnectUnit().setConnectSucceed(false);
        updateConnectStep.setException(ioe);
        updateConnectStep.setUnitEndTime(System.currentTimeMillis());
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "connectFailed, [inetSocketAddress=" + inetSocketAddress + "][proxy=" + proxy + "][protocol=" + protocol2 + "][ioe=" + ioe + "]", null, 4, null);
    }

    @Override // okhttp3.EventListener
    public void connectStart(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "connectStart, [inetSocketAddress=" + inetSocketAddress + "] [proxy=" + proxy + "]", null, 4, null);
        super.connectStart(call, inetSocketAddress, proxy);
        StatisticInfo.StatisticUnit updateConnectStep = updateConnectStep(ConnectStep.ConnectStart);
        updateConnectStep.getConnectUnit().setProxy(proxy.toString());
        updateConnectStep.getConnectUnit().setConnectStartTime(System.currentTimeMillis());
        updateConnectStep.getConnectUnit().setRouteAddress(inetSocketAddress.getAddress().toString());
        StatisticInfo statisticInfo = this.mStatisticInfo;
        if (statisticInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStatisticInfo");
            statisticInfo = null;
        }
        updateConnectStep.setRetryTimes(statisticInfo.getStatisticUnitList().size() - 1);
        if (updateConnectStep.getUnitStartTime() == 0) {
            updateConnectStep.setUnitStartTime(System.currentTimeMillis());
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(@NotNull Call call, @NotNull Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        super.connectionAcquired(call, connection);
        StatisticInfo.StatisticUnit updateConnectStep = updateConnectStep(ConnectStep.ConnectionAcquired);
        Object obj = null;
        if (updateConnectStep.getConnectUnit().isConnectSucceed()) {
            DLog dLog = DLog.INSTANCE;
            String tag = INSTANCE.tag();
            Handshake handshake = connection.getHandshake();
            if (handshake != null) {
                obj = handshake.cipherSuite();
            }
            ILogAgent.DefaultImpls.d$default(dLog, tag, "connectionAcquired, [cipherSuite=" + obj + "][protocol=" + connection.protocol() + "]]", null, 4, null);
            return;
        }
        StatisticInfo statisticInfo = this.mStatisticInfo;
        if (statisticInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStatisticInfo");
            statisticInfo = null;
        }
        updateConnectStep.setRetryTimes(statisticInfo.getStatisticUnitList().size() - 1);
        if (updateConnectStep.getUnitStartTime() == 0) {
            updateConnectStep.setUnitStartTime(System.currentTimeMillis());
        }
        StatisticInfo.ConnectUnit connectUnit = updateConnectStep.getConnectUnit();
        InetSocketAddress socketAddress = connection.getRoute().socketAddress();
        connectUnit.setRouteAddress(socketAddress.getAddress().toString());
        connectUnit.setHost(socketAddress.getAddress().getHostName());
        connectUnit.setProxy(connection.getRoute().proxy().toString());
        long currentTimeMillis = System.currentTimeMillis();
        connectUnit.setDnsStartTime(currentTimeMillis);
        connectUnit.setDnsEndTime(currentTimeMillis);
        connectUnit.setConnectStartTime(currentTimeMillis);
        connectUnit.setTlsStartTime(currentTimeMillis);
        connectUnit.setTlsEndTime(currentTimeMillis);
        Handshake handshake2 = connection.getHandshake();
        if (handshake2 != null) {
            obj = handshake2.tlsVersion();
        }
        connectUnit.setTlsVersion(String.valueOf(obj));
        connectUnit.setConnectEndTime(currentTimeMillis);
        connectUnit.setProtocol(connection.protocol().getProtocol());
        connectUnit.setConnectSucceed(true);
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "connectionAcquired, is reused, [connection=" + connection + "][tlsVersion=" + updateConnectStep.getConnectUnit().getTlsVersion() + "]", null, 4, null);
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(@NotNull Call call, @NotNull Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "connectionReleased, [connection=" + connection + "]", null, 4, null);
        super.connectionReleased(call, connection);
        updateConnectStep(ConnectStep.ConnectionReleased);
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(@NotNull Call call, @NotNull String domainName, @NotNull List<InetAddress> inetAddressList) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "dnsEnd, [domainName=" + domainName + "], [addressSize=" + inetAddressList.size() + "]", null, 4, null);
        super.dnsEnd(call, domainName, inetAddressList);
        updateConnectStep(ConnectStep.DnsEnd).getConnectUnit().setDnsEndTime(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void dnsStart(@NotNull Call call, @NotNull String domainName) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "dnsStart, [domainName=" + domainName + "]", null, 4, null);
        super.dnsStart(call, domainName);
        StatisticInfo.StatisticUnit updateConnectStep = updateConnectStep(ConnectStep.DnsStart);
        updateConnectStep.getConnectUnit().setHost(domainName);
        updateConnectStep.getConnectUnit().setDnsStartTime(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(@NotNull Call call, long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "requestBodyEnd, [byteCount=" + byteCount + "]", null, 4, null);
        super.requestBodyEnd(call, byteCount);
        updateConnectStep(ConnectStep.RequestBodyEnd);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "requestBodyStart", null, 4, null);
        super.requestBodyStart(call);
        updateConnectStep(ConnectStep.RequestBodyStart);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(@NotNull Call call, @NotNull Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "requestHeadersEnd, " + getHeaderLogString(request.headers()), null, 4, null);
        super.requestHeadersEnd(call, request);
        updateConnectStep(ConnectStep.RequestHeadersEnd).getConnectUnit().setBody(request.body());
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "requestHeadersStart", null, 4, null);
        super.requestHeadersStart(call);
        updateConnectStep(ConnectStep.RequestHeadersStart);
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(@NotNull Call call, long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "responseBodyEnd, [byteCount=" + byteCount + "]", null, 4, null);
        super.responseBodyEnd(call, byteCount);
        updateConnectStep(ConnectStep.ResponseBodyEnd);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "responseBodyStart", null, 4, null);
        super.responseBodyStart(call);
        updateConnectStep(ConnectStep.ResponseBodyStart);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(@NotNull Call call, @NotNull Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "responseHeadersEnd, [code=" + response.code() + "][protocol=" + response.protocol() + "][code=" + response.code() + "][message=" + response.message() + "]" + getHeaderLogString(response.headers()), null, 4, null);
        super.responseHeadersEnd(call, response);
        StatisticInfo.StatisticUnit updateConnectStep = updateConnectStep(ConnectStep.ResponseHeadersEnd);
        if (response.isSuccessful()) {
            updateConnectStep.getResponseUnit().setHttpResponseTime(System.currentTimeMillis());
            updateConnectStep.getResponseUnit().setHttpStatus(response.code());
            ContentRange parseContentRange = ContentRange.INSTANCE.parseContentRange(response.headers());
            if (parseContentRange.getTotalSize() != 0) {
                updateConnectStep.getResponseUnit().setTotalSize(parseContentRange.getTotalSize());
            }
            if (parseContentRange.getFromPosition() != 0) {
                updateConnectStep.getResponseUnit().setFromPosition(parseContentRange.getFromPosition());
            }
            updateConnectStep.getResponseUnit().setLastModifyTime(response.headers().get(HttpConst.HEADER.LAST_MODIFIED.getValue()));
        }
        updateConnectStep.getResponseUnit().setOkResponse(response);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "responseHeadersStart", null, 4, null);
        super.responseHeadersStart(call);
        updateConnectStep(ConnectStep.ResponseHeadersStart);
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(@NotNull Call call, @Nullable Handshake handshake) {
        TlsVersion tlsVersion;
        Intrinsics.checkNotNullParameter(call, "call");
        DLog dLog = DLog.INSTANCE;
        String tag = INSTANCE.tag();
        TlsVersion tlsVersion2 = null;
        if (handshake != null) {
            tlsVersion = handshake.tlsVersion();
        } else {
            tlsVersion = null;
        }
        ILogAgent.DefaultImpls.d$default(dLog, tag, "secureConnectEnd, [tls=" + tlsVersion + "]", null, 4, null);
        super.secureConnectEnd(call, handshake);
        StatisticInfo.StatisticUnit updateConnectStep = updateConnectStep(ConnectStep.SecureConnectEnd);
        updateConnectStep.getConnectUnit().setTlsEndTime(System.currentTimeMillis());
        StatisticInfo.ConnectUnit connectUnit = updateConnectStep.getConnectUnit();
        if (handshake != null) {
            tlsVersion2 = handshake.tlsVersion();
        }
        connectUnit.setTlsVersion(String.valueOf(tlsVersion2));
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        ILogAgent.DefaultImpls.d$default(DLog.INSTANCE, INSTANCE.tag(), "secureConnectStart", null, 4, null);
        super.secureConnectStart(call);
        updateConnectStep(ConnectStep.SecureConnectStart).getConnectUnit().setTlsStartTime(System.currentTimeMillis());
    }
}
