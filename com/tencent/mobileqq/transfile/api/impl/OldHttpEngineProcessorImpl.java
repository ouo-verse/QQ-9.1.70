package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.HTTP_METHOD;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.d;
import com.tencent.qqnt.http.api.e;
import com.tencent.qqnt.http.api.f;
import com.tencent.qqnt.http.api.k;
import com.tencent.qqnt.http.api.l;
import com.tencent.qqnt.http.api.m;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0006*\u0002\u0018\u001b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/transfile/api/impl/OldHttpEngineProcessorImpl;", "Lcom/tencent/mobileqq/transfile/api/IOldHttpEngineProcessor;", "Lcom/tencent/mobileqq/transfile/api/impl/BaseNtHttpAdapter;", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "sendReq", "cancelReq", "Lcom/tencent/mobileqq/utils/httputils/HttpMsg;", "msg", "", SmsPlugin.API_SEND_SMS, "Lcom/tencent/qqnt/http/api/b;", "buildTask", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "fillResult", "cancelMsg", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "com/tencent/mobileqq/transfile/api/impl/OldHttpEngineProcessorImpl$msgTaskListener$1", "msgTaskListener", "Lcom/tencent/mobileqq/transfile/api/impl/OldHttpEngineProcessorImpl$msgTaskListener$1;", "com/tencent/mobileqq/transfile/api/impl/OldHttpEngineProcessorImpl$msgEventListener$1", "msgEventListener", "Lcom/tencent/mobileqq/transfile/api/impl/OldHttpEngineProcessorImpl$msgEventListener$1;", "<init>", "()V", "Transfile_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class OldHttpEngineProcessorImpl extends BaseNtHttpAdapter implements IOldHttpEngineProcessor {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    @NotNull
    private final OldHttpEngineProcessorImpl$msgEventListener$1 msgEventListener;

    @NotNull
    private final OldHttpEngineProcessorImpl$msgTaskListener$1 msgTaskListener;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mobileqq.transfile.api.impl.OldHttpEngineProcessorImpl$msgTaskListener$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.transfile.api.impl.OldHttpEngineProcessorImpl$msgEventListener$1] */
    public OldHttpEngineProcessorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "NTHttp.OldHttpEngineProcessorImpl";
        this.msgTaskListener = new l() { // from class: com.tencent.mobileqq.transfile.api.impl.OldHttpEngineProcessorImpl$msgTaskListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OldHttpEngineProcessorImpl.this);
                }
            }

            @Override // com.tencent.qqnt.http.api.l
            public void onFailed(@NotNull b task, @NotNull m result) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) task, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(result, "result");
                HttpMsg httpMsg = (HttpMsg) task.A(HttpMsg.class);
                if (httpMsg != null) {
                    OldHttpEngineProcessorImpl.this.fillResult(task, result, httpMsg);
                    IHttpCommunicatorListener processor = httpMsg.getProcessor();
                    if (processor != null) {
                        processor.handleError(httpMsg, httpMsg);
                    }
                }
            }

            @Override // com.tencent.qqnt.http.api.l
            public void onSuccess(@NotNull b task, @NotNull m result) {
                OutputStream k3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) task, (Object) result);
                    return;
                }
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(result, "result");
                HttpMsg httpMsg = (HttpMsg) task.A(HttpMsg.class);
                if (httpMsg != null) {
                    OldHttpEngineProcessorImpl oldHttpEngineProcessorImpl = OldHttpEngineProcessorImpl.this;
                    if (httpMsg.isDataSlice() && (k3 = task.k()) != null && (k3 instanceof SliceByteArrayOutputStream)) {
                        SliceByteArrayOutputStream sliceByteArrayOutputStream = (SliceByteArrayOutputStream) k3;
                        if (sliceByteArrayOutputStream.size() > 0) {
                            httpMsg.setRecvData(sliceByteArrayOutputStream.toByteArray());
                            sliceByteArrayOutputStream.reset();
                            IHttpCommunicatorListener processor = httpMsg.getProcessor();
                            if (processor != null) {
                                processor.decode(httpMsg, httpMsg);
                            }
                        }
                    }
                    oldHttpEngineProcessorImpl.fillResult(task, result, httpMsg);
                    IHttpCommunicatorListener processor2 = httpMsg.getProcessor();
                    if (processor2 != null) {
                        processor2.statusChanged(httpMsg, httpMsg, 5);
                    }
                }
            }
        };
        this.msgEventListener = new e() { // from class: com.tencent.mobileqq.transfile.api.impl.OldHttpEngineProcessorImpl$msgEventListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OldHttpEngineProcessorImpl.this);
                }
            }

            @Override // com.tencent.qqnt.http.api.e
            public void onBodyCompleted(@NotNull b task) {
                IHttpCommunicatorListener processor;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) task);
                    return;
                }
                Intrinsics.checkNotNullParameter(task, "task");
                HttpMsg httpMsg = (HttpMsg) task.A(HttpMsg.class);
                if (httpMsg != null && (processor = httpMsg.getProcessor()) != null) {
                    processor.statusChanged(httpMsg, httpMsg, 4);
                }
            }

            @Override // com.tencent.qqnt.http.api.e
            public /* bridge */ /* synthetic */ void onDnsEnd(b bVar) {
                d.b(this, bVar);
            }

            @Override // com.tencent.qqnt.http.api.e
            public /* bridge */ /* synthetic */ void onDnsStart(b bVar) {
                d.c(this, bVar);
            }

            @Override // com.tencent.qqnt.http.api.e
            public void onGetHeader(@NotNull b task, @NotNull f headerResponse) {
                int lastIndexOf$default;
                List list;
                String joinToString$default;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) task, (Object) headerResponse);
                    return;
                }
                Intrinsics.checkNotNullParameter(task, "task");
                Intrinsics.checkNotNullParameter(headerResponse, "headerResponse");
                Object A = task.A(HttpMsg.class);
                if (A == null) {
                    return;
                }
                HttpMsg httpMsg = (HttpMsg) A;
                httpMsg.setResponseCode(headerResponse.a());
                Map<String, String> headers = headerResponse.headers();
                if (headers != null) {
                    httpMsg.responsePropertys.putAll(headers);
                    list = MapsKt___MapsKt.toList(headers);
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, null, 63, null);
                    httpMsg.rawRespHeader = joinToString$default;
                }
                String str = httpMsg.responsePropertys.get(HttpMsg.CONTENTRANGE);
                long j3 = 0;
                if (str != null) {
                    lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "/", 0, false, 6, (Object) null);
                    try {
                        String substring = str.substring(lastIndexOf$default + 1);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        ((HttpMsg) A).totalLen = Long.parseLong(substring);
                    } catch (Exception e16) {
                        QLog.e(OldHttpEngineProcessorImpl.this.getTAG(), 1, "fillResult", e16);
                    }
                    Long contentLength = headerResponse.contentLength();
                    if (contentLength != null) {
                        j3 = contentLength.longValue();
                    }
                    httpMsg.totalBlockLen = j3;
                } else {
                    Long contentLength2 = headerResponse.contentLength();
                    if (contentLength2 != null) {
                        j3 = contentLength2.longValue();
                    }
                    httpMsg.totalLen = j3;
                    httpMsg.totalBlockLen = j3;
                }
                IHttpCommunicatorListener processor = httpMsg.getProcessor();
                if (processor != null) {
                    processor.statusChanged(httpMsg, httpMsg, 3);
                }
            }

            @Override // com.tencent.qqnt.http.api.e
            public /* bridge */ /* synthetic */ void onResponseURL(URL url) {
                d.e(this, url);
            }

            @Override // com.tencent.qqnt.http.api.e
            public void onStart(@NotNull b task) {
                IHttpCommunicatorListener processor;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) task);
                    return;
                }
                Intrinsics.checkNotNullParameter(task, "task");
                HttpMsg httpMsg = (HttpMsg) task.A(HttpMsg.class);
                if (httpMsg != null && (processor = httpMsg.getProcessor()) != null) {
                    processor.statusChanged(httpMsg, httpMsg, 0);
                }
            }
        };
    }

    @NotNull
    public final b buildTask(@NotNull final HttpMsg msg2) {
        Function1<byte[], Unit> function1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msg2);
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        String str = getTAG() + msg2.fileType;
        BaseNtHttpAdapter.Companion companion = BaseNtHttpAdapter.INSTANCE;
        String tag = getTAG();
        String url = msg2.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "msg.url");
        b.a aVar = new b.a(str, companion.replaceIpWithDomain(tag, url, msg2.mReqHost));
        aVar.S(HttpMsg.class, msg2);
        HashMap<String, String> it = msg2.requestPropertys;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar.a(it);
        int netType = NetworkCenter.getInstance().getNetType();
        RichMediaStrategy.NetPolicy policy = RichMediaStrategy.getPolicy(netType);
        aVar.d(policy.getConnectTimeout());
        aVar.L(policy.getReadTimeout());
        aVar.U(getTASK_TIME_OUT());
        TimeoutParam timeoutParam = msg2.timeoutParam;
        if (timeoutParam != null) {
            aVar.d(timeoutParam.getConnectTimeout(netType));
            aVar.L(timeoutParam.getReadTimeout(netType));
        }
        if (msg2.getProcessor() != null) {
            aVar.T(this.msgTaskListener);
            aVar.i(this.msgEventListener);
        }
        if (msg2.isDataSlice()) {
            function1 = new Function1<byte[], Unit>() { // from class: com.tencent.mobileqq.transfile.api.impl.OldHttpEngineProcessorImpl$buildTask$bytesProcessor$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HttpMsg.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
                    invoke2(bArr);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull byte[] bytes) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bytes);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(bytes, "bytes");
                    HttpMsg.this.setRecvData(bytes);
                    IHttpCommunicatorListener processor = HttpMsg.this.getProcessor();
                    if (processor != null) {
                        HttpMsg httpMsg = HttpMsg.this;
                        processor.decode(httpMsg, httpMsg);
                    }
                }
            };
        } else {
            function1 = null;
        }
        aVar.J(new SliceByteArrayOutputStream(10240, function1));
        byte[] sendData = msg2.getSendData();
        if (sendData != null) {
            k kVar = new k();
            kVar.c(sendData);
            aVar.M(kVar);
        }
        if (Intrinsics.areEqual(msg2.getRequestMethod(), "POST")) {
            aVar.I(HTTP_METHOD.POST);
        }
        b c16 = aVar.c();
        msg2.lockForSyncSend = c16;
        return c16;
    }

    @Override // com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor
    public void cancelMsg(@Nullable HttpMsg msg2) {
        AtomicBoolean atomicBoolean;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msg2);
            return;
        }
        if (msg2 != null && (obj = msg2.lockForSyncSend) != null && (obj instanceof b)) {
            ((IHttpService) QRoute.api(IHttpService.class)).cancel((b) obj);
        }
        if (msg2 != null && (atomicBoolean = msg2.mIsCancel) != null) {
            atomicBoolean.set(true);
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter, com.tencent.mobileqq.transfile.api.IHttpEngineService
    public void cancelReq(@Nullable NetReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) req);
        } else {
            super.cancelReq(req);
        }
    }

    public final void fillResult(@NotNull b task, @NotNull m result, @NotNull HttpMsg msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, task, result, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Integer c16 = result.c();
        if (c16 != null) {
            msg2.setResponseCode(c16.intValue());
        }
        msg2.errCode = result.a();
        msg2.errString = String.valueOf(result.a());
    }

    @Override // com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter
    @NotNull
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor
    public int sendMsg(@NotNull HttpMsg msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msg2)).intValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        b buildTask = buildTask(msg2);
        ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(buildTask);
        return buildTask.u();
    }

    @Override // com.tencent.mobileqq.transfile.api.impl.BaseNtHttpAdapter, com.tencent.mobileqq.transfile.api.IHttpEngineService
    public void sendReq(@NotNull NetReq req) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) req);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            super.sendReq(req);
        }
    }
}
