package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.HTTP_METHOD;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.a;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.c;
import com.tencent.qqnt.http.api.d;
import com.tencent.qqnt.http.api.e;
import com.tencent.qqnt.http.api.f;
import com.tencent.qqnt.http.api.g;
import com.tencent.qqnt.http.api.j;
import com.tencent.qqnt.http.api.k;
import com.tencent.qqnt.http.api.l;
import com.tencent.qqnt.http.api.m;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0007*\u0002\u001b\u001e\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0004J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0004R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/transfile/api/impl/BaseNtHttpAdapter;", "", "Lcom/tencent/mobileqq/transfile/HttpNetReq;", "req", "Lcom/tencent/qqnt/http/api/a;", "buildDnsResolver", "Lcom/tencent/mobileqq/transfile/NetReq;", "", "sendReq", "cancelReq", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "Lcom/tencent/mobileqq/transfile/NetResp;", "fillResult", "buildTask", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "", "TASK_TIME_OUT", "J", "getTASK_TIME_OUT", "()J", "com/tencent/mobileqq/transfile/api/impl/BaseNtHttpAdapter$reqProgressListener$1", "reqProgressListener", "Lcom/tencent/mobileqq/transfile/api/impl/BaseNtHttpAdapter$reqProgressListener$1;", "com/tencent/mobileqq/transfile/api/impl/BaseNtHttpAdapter$reqTaskListener$1", "reqTaskListener", "Lcom/tencent/mobileqq/transfile/api/impl/BaseNtHttpAdapter$reqTaskListener$1;", "<init>", "()V", "Companion", "Transfile_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class BaseNtHttpAdapter {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String IPV6_PREFIX = "[";

    @NotNull
    private static final String IPV6_SUFFIX = "]";

    @NotNull
    private final String TAG;
    private final long TASK_TIME_OUT;

    @NotNull
    private final BaseNtHttpAdapter$reqProgressListener$1 reqProgressListener;

    @NotNull
    private final BaseNtHttpAdapter$reqTaskListener$1 reqTaskListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/transfile/api/impl/BaseNtHttpAdapter$Companion;", "", "()V", "IPV6_PREFIX", "", "IPV6_SUFFIX", "isIPv6Ip", "", "host", "replaceIpWithDomain", "tag", "originUrl", "domain", "Transfile_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final boolean isIPv6Ip(String host) {
            boolean startsWith$default;
            boolean endsWith$default;
            String removePrefix;
            String removeSuffix;
            if (!IPAddressUtil.isIPv6LiteralAddress(host)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(host, BaseNtHttpAdapter.IPV6_PREFIX, false, 2, null);
                if (startsWith$default) {
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(host, BaseNtHttpAdapter.IPV6_SUFFIX, false, 2, null);
                    if (endsWith$default) {
                        removePrefix = StringsKt__StringsKt.removePrefix(host, (CharSequence) BaseNtHttpAdapter.IPV6_PREFIX);
                        removeSuffix = StringsKt__StringsKt.removeSuffix(removePrefix, (CharSequence) BaseNtHttpAdapter.IPV6_SUFFIX);
                        if (IPAddressUtil.isIPv6LiteralAddress(removeSuffix)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        
            if (isIPv6Ip(r4) != false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00b1, code lost:
        
            return r11;
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String replaceIpWithDomain(@NotNull String tag, @NotNull String originUrl, @Nullable String domain) {
            boolean equals;
            String replaceFirst$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, this, tag, originUrl, domain);
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(originUrl, "originUrl");
            try {
                URL url = new URL(originUrl);
                equals = StringsKt__StringsJVMKt.equals(url.getProtocol(), "https", true);
                if (!equals) {
                    return originUrl;
                }
                String host = url.getHost();
                if (!IPAddressUtil.isIPv4LiteralAddress(host)) {
                    Intrinsics.checkNotNullExpressionValue(host, "host");
                }
                if (domain == null) {
                    QLog.d(tag, 2, "replaceIpWithDomain fail, domain is null originUrl=" + originUrl);
                    return originUrl;
                }
                Intrinsics.checkNotNullExpressionValue(host, "host");
                replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(originUrl, host, domain, false, 4, (Object) null);
                if (QLog.isColorLevel()) {
                    QLog.d(tag, 2, "replaceIpWithDomain originUrl=" + originUrl + " replaceUrl=" + replaceFirst$default);
                }
                return replaceFirst$default;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(tag, 2, "replaceIpWithDomain error originUrl=" + originUrl);
                }
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FIELD_ZPLAN_COVER_IMG);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter$reqProgressListener$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter$reqTaskListener$1] */
    public BaseNtHttpAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "NTHttp.BaseNtHttpAdapter";
        this.TASK_TIME_OUT = 480000L;
        this.reqProgressListener = new j() { // from class: com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter$reqProgressListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.http.api.j
            public void onProgress(@NotNull b task, long writeLength, long contentLength) {
                NetResp netResp;
                INetEngineListener iNetEngineListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, task, Long.valueOf(writeLength), Long.valueOf(contentLength));
                    return;
                }
                Intrinsics.checkNotNullParameter(task, "task");
                Object A = task.A(HttpNetReq.class);
                HttpNetReq httpNetReq = (HttpNetReq) A;
                if (httpNetReq != null && (iNetEngineListener = httpNetReq.mCallback) != null) {
                    iNetEngineListener.onUpdateProgeress((NetReq) A, writeLength, contentLength);
                }
                if (httpNetReq != null && (netResp = httpNetReq.mResp) != null) {
                    netResp.mTotalFileLen = task.s().d();
                    netResp.mTotalBlockLen = task.s().c();
                    netResp.mWrittenBlockLen = task.s().e();
                }
            }
        };
        this.reqTaskListener = new l() { // from class: com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter$reqTaskListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseNtHttpAdapter.this);
                }
            }

            @Override // com.tencent.qqnt.http.api.l
            public void onFailed(@NotNull b task, @NotNull m result) {
                INetEngineListener iNetEngineListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) task, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(result, "result");
                HttpNetReq httpNetReq = (HttpNetReq) task.A(HttpNetReq.class);
                if (httpNetReq != null && (iNetEngineListener = httpNetReq.mCallback) != null) {
                    iNetEngineListener.onResp(BaseNtHttpAdapter.this.fillResult(task, result, httpNetReq));
                }
            }

            @Override // com.tencent.qqnt.http.api.l
            public void onSuccess(@NotNull b task, @NotNull m result) {
                INetEngineListener iNetEngineListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) task, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(result, "result");
                HttpNetReq httpNetReq = (HttpNetReq) task.A(HttpNetReq.class);
                if (httpNetReq != null && (iNetEngineListener = httpNetReq.mCallback) != null) {
                    iNetEngineListener.onResp(BaseNtHttpAdapter.this.fillResult(task, result, httpNetReq));
                }
            }
        };
    }

    private final a buildDnsResolver(HttpNetReq req) {
        final String str = req.mReqUrl;
        final List<ServerAddr> list = req.mServerList;
        final NetReq.HostParseToIp hostParseToIp = req.mHostParseToIp;
        return new a(str, list, hostParseToIp, this) { // from class: com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter$buildDnsResolver$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ NetReq.HostParseToIp $hostParseToIp;
            final /* synthetic */ String $reqUrl;
            final /* synthetic */ List<ServerAddr> $serverList;
            final /* synthetic */ BaseNtHttpAdapter this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$reqUrl = str;
                this.$serverList = list;
                this.$hostParseToIp = hostParseToIp;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, list, hostParseToIp, this);
                }
            }

            @Override // com.tencent.qqnt.http.api.a
            @Nullable
            public List<InetAddress> lookup(@NotNull String hostname) {
                List<ServerAddr> ipByHost;
                int collectionSizeOrDefault;
                int collectionSizeOrDefault2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) hostname);
                }
                Intrinsics.checkNotNullParameter(hostname, "hostname");
                try {
                    if (hostname.equals(new URL(this.$reqUrl).getHost())) {
                        List<ServerAddr> list2 = this.$serverList;
                        if (list2 != null) {
                            List<ServerAddr> list3 = list2;
                            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                            for (ServerAddr serverAddr : list3) {
                                arrayList.add(new InetSocketAddress(serverAddr.mIp, serverAddr.port).getAddress());
                            }
                            return arrayList;
                        }
                    } else {
                        NetReq.HostParseToIp hostParseToIp2 = this.$hostParseToIp;
                        if (hostParseToIp2 != null && (ipByHost = hostParseToIp2.getIpByHost(hostname)) != null) {
                            List<ServerAddr> list4 = ipByHost;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                            for (ServerAddr serverAddr2 : list4) {
                                arrayList2.add(new InetSocketAddress(serverAddr2.mIp, serverAddr2.port).getAddress());
                            }
                            return arrayList2;
                        }
                    }
                } catch (MalformedURLException e16) {
                    QLog.e(this.this$0.getTAG(), 1, "lookup hostName failed", e16);
                }
                return a.C9631a.a(this, hostname);
            }

            @Override // com.tencent.qqnt.http.api.a
            public boolean useDefaultDns() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final b buildTask(@NotNull final HttpNetReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) req);
        }
        Intrinsics.checkNotNullParameter(req, "req");
        String str = getTAG() + req.mFileType;
        Companion companion = INSTANCE;
        String tag = getTAG();
        String str2 = req.mReqUrl;
        Intrinsics.checkNotNullExpressionValue(str2, "req.mReqUrl");
        b.a aVar = new b.a(str, companion.replaceIpWithDomain(tag, str2, req.mHostForHttpsVerify));
        req.mResp = new NetResp(req);
        aVar.S(HttpNetReq.class, req);
        aVar.e(buildDnsResolver(req));
        RichMediaStrategy.NetPolicy policy = RichMediaStrategy.getPolicy(NetworkCenter.getInstance().getNetType());
        aVar.d(policy.getConnectTimeout());
        aVar.L(policy.getReadTimeout());
        HashMap<String, String> hashMap = req.mReqProperties;
        if (hashMap != null) {
            aVar.a(hashMap);
        }
        if (req.mCallback != null) {
            aVar.K(this.reqProgressListener);
            aVar.T(this.reqTaskListener);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        aVar.i(new e(currentTimeMillis, req) { // from class: com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter$buildTask$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ HttpNetReq $req;
            final /* synthetic */ long $startTime;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$startTime = currentTimeMillis;
                this.$req = req;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BaseNtHttpAdapter.this, Long.valueOf(currentTimeMillis), req);
                }
            }

            @Override // com.tencent.qqnt.http.api.e
            public /* bridge */ /* synthetic */ void onBodyCompleted(b bVar) {
                d.a(this, bVar);
            }

            @Override // com.tencent.qqnt.http.api.e
            public void onDnsEnd(@Nullable b task) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) task);
                    return;
                }
                HttpNetReq.DnsParseCallback dnsParseCallback = this.$req.mDnsParseCallback;
                if (dnsParseCallback != null) {
                    dnsParseCallback.end();
                }
            }

            @Override // com.tencent.qqnt.http.api.e
            public void onDnsStart(@Nullable b task) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) task);
                    return;
                }
                HttpNetReq.DnsParseCallback dnsParseCallback = this.$req.mDnsParseCallback;
                if (dnsParseCallback != null) {
                    dnsParseCallback.start();
                }
            }

            @Override // com.tencent.qqnt.http.api.e
            public /* bridge */ /* synthetic */ void onGetHeader(b bVar, f fVar) {
                d.d(this, bVar, fVar);
            }

            @Override // com.tencent.qqnt.http.api.e
            public void onResponseURL(@Nullable URL responseUrl) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) responseUrl);
                    return;
                }
                HttpNetReq.ResponseURLCallback responseURLCallback = this.$req.onResponseURL;
                if (responseURLCallback != null) {
                    responseURLCallback.onResponseURL(responseUrl);
                }
            }

            @Override // com.tencent.qqnt.http.api.e
            public void onStart(@Nullable b task) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) task);
                    return;
                }
                QLog.i(BaseNtHttpAdapter.this.getTAG(), 1, "build to call start cost time: " + (System.currentTimeMillis() - this.$startTime));
            }
        });
        aVar.N(req.mContinuErrorLimit);
        if (req.mOutPath != null) {
            aVar.f(new File(req.mOutPath));
        } else {
            OutputStream outputStream = req.mOutStream;
            if (outputStream != null) {
                Intrinsics.checkNotNullExpressionValue(outputStream, "req.mOutStream");
                aVar.J(outputStream);
            }
        }
        String str3 = req.mTempPath;
        if (str3 != null) {
            aVar.g(new File(str3));
        }
        if (req.mSupportBreakResume) {
            final long j3 = req.mStartDownOffset;
            final long j16 = req.mEndDownOffset;
            aVar.b(new c(j3, j16) { // from class: com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter$buildTask$5
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $endDownOffset;
                final /* synthetic */ long $startDownOffset;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$startDownOffset = j3;
                    this.$endDownOffset = j16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
                    }
                }

                @Override // com.tencent.qqnt.http.api.c
                public long getEndDownOffset() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        return ((Long) iPatchRedirector2.redirect((short) 3, (Object) this)).longValue();
                    }
                    return this.$endDownOffset;
                }

                @Override // com.tencent.qqnt.http.api.c
                public long getStartDownOffset() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Long) iPatchRedirector2.redirect((short) 2, (Object) this)).longValue();
                    }
                    return this.$startDownOffset;
                }
            });
        }
        byte[] bArr = req.mSendData;
        if (bArr != null) {
            k kVar = new k();
            kVar.c(bArr);
            aVar.M(kVar);
        }
        if (req.mHttpMethod == 1) {
            aVar.I(HTTP_METHOD.POST);
        }
        aVar.U(this.TASK_TIME_OUT);
        b c16 = aVar.c();
        req.mPrivate = c16;
        return c16;
    }

    public void cancelReq(@Nullable NetReq req) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) req);
        } else if (req != null && (obj = req.mPrivate) != null && (obj instanceof b)) {
            ((IHttpService) QRoute.api(IHttpService.class)).cancel((b) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final NetResp fillResult(@NotNull b task, @NotNull m result, @NotNull HttpNetReq req) {
        Iterable<Pair<String, String>> headers;
        g d16;
        InputStream a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (NetResp) iPatchRedirector.redirect((short) 6, this, task, result, req);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(req, "req");
        NetResp resp = req.mResp;
        if (result.a() == -1103) {
            resp.mResult = 3;
            Intrinsics.checkNotNullExpressionValue(resp, "resp");
            return resp;
        }
        Integer c16 = result.c();
        if (c16 != null) {
            resp.mHttpCode = c16.intValue();
        }
        resp.mErrCode = result.a();
        if (result.e()) {
            if (req.mOutPath == null && req.mOutStream == null && (d16 = result.d()) != null && (a16 = d16.a()) != null) {
                try {
                    resp.mRespData = ByteStreamsKt.readBytes(a16);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(a16, null);
                } finally {
                }
            }
            g d17 = result.d();
            if (d17 != null && (headers = d17.headers()) != null) {
                for (Pair<String, String> pair : headers) {
                    resp.mRespProperties.put(pair.getFirst(), pair.getSecond());
                }
            }
            resp.mResult = 0;
        } else {
            resp.mResult = 1;
        }
        resp.mErrDesc = "";
        resp.mTotalFileLen = task.s().d();
        resp.mTotalBlockLen = task.s().c();
        resp.mWrittenBlockLen = task.s().e();
        resp.mTryTime = task.s().a();
        Intrinsics.checkNotNullExpressionValue(resp, "resp");
        return resp;
    }

    @NotNull
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.TAG;
    }

    public final long getTASK_TIME_OUT() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.TASK_TIME_OUT;
    }

    public void sendReq(@NotNull NetReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) req);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(buildTask((HttpNetReq) req));
    }
}
