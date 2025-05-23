package com.tencent.mobileqq.troop.qrcode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.qrcode.QRDisplayTroopCardRepo;
import com.tencent.protofile.source.QunJoinUrlSvrPB$ResetGroupQrCodeReq;
import com.tencent.protofile.source.QunJoinUrlSvrPB$ResetGroupQrCodeRsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u008a\u0001\u0010\u0014\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00120\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0006\u0010\u0017\u001a\u00020\u0005Jz\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00120\u000fJ$\u0010\u001b\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002JP\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000228\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00120\u001cJ;\u0010!\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00120 J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010#\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002J\u0016\u0010$\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010&\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardRepo;", "", "", "troopUin", "downloadUrl", "", "e", "filePath", "Landroid/graphics/Bitmap;", "f", "isSuccess", "", "style", "shortChain", "url", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "", "cb", "g", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "l", "i", "isUnsetAIGCStyle", "r", "channelId", "p", "Lkotlin/Function2;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "j", "sourceId", "Lkotlin/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "t", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", DomainData.DOMAIN_NAME, "()Landroid/os/Handler;", "handler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "o", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setDownloading", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isDownloading", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "downloadTimeoutRunnable", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QRDisplayTroopCardRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QRDisplayTroopCardRepo f298123a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicBoolean isDownloading;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable downloadTimeoutRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardRepo$a", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "", "isSuccess", "", "filePath", "", "onRspCallback", "", "percent", "", "downloadedLength", "totalLength", "onDownloadProgress", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements RFWDownloader.RFWDownloadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f298127d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, Bitmap, Unit> f298128e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f298129f;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Function2<? super Boolean, ? super Bitmap, Unit> function2, String str2) {
            this.f298127d = str;
            this.f298128e = function2;
            this.f298129f = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, function2, str2);
            }
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callEnd(Call call) {
            com.tencent.biz.richframework.download.v.a(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callFailed(Call call, IOException iOException) {
            com.tencent.biz.richframework.download.v.b(this, call, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callStart(Call call) {
            com.tencent.biz.richframework.download.v.c(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
            com.tencent.biz.richframework.download.v.d(this, call, inetSocketAddress, proxy, protocol2);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
            com.tencent.biz.richframework.download.v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            com.tencent.biz.richframework.download.v.f(this, call, inetSocketAddress, proxy);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
            com.tencent.biz.richframework.download.v.g(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionReleased(Call call, Connection connection) {
            com.tencent.biz.richframework.download.v.h(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            com.tencent.biz.richframework.download.v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            com.tencent.biz.richframework.download.v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float percent, long downloadedLength, long totalLength) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(percent), Long.valueOf(downloadedLength), Long.valueOf(totalLength));
            }
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean isSuccess, @Nullable String filePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), filePath);
                return;
            }
            QLog.i("QRDisplayTroopCardRepo", 1, "[getBitmapAsync] [onRspCallback] url = " + this.f298127d + ", isSuccess = " + isSuccess + ", filePath = " + filePath);
            QRDisplayTroopCardRepo qRDisplayTroopCardRepo = QRDisplayTroopCardRepo.f298123a;
            qRDisplayTroopCardRepo.o().set(false);
            qRDisplayTroopCardRepo.n().removeCallbacks(QRDisplayTroopCardRepo.downloadTimeoutRunnable);
            if (isSuccess) {
                QLog.i("QRDisplayTroopCardRepo", 1, "[getBitmapAsync][download]onRspCallback, filePath = " + filePath);
                if (filePath == null || filePath.length() == 0) {
                    z16 = true;
                }
                if (!z16) {
                    Bitmap f16 = qRDisplayTroopCardRepo.f(filePath);
                    if (f16 != null) {
                        qRDisplayTroopCardRepo.t(this.f298129f, this.f298127d);
                        qRDisplayTroopCardRepo.u(this.f298129f, filePath);
                        this.f298128e.invoke(Boolean.TRUE, f16);
                        return;
                    } else {
                        QLog.e("QRDisplayTroopCardRepo", 1, "[getBitmapAsync][download]onRspCallback, decodeFile failed.");
                        this.f298128e.invoke(Boolean.FALSE, null);
                        return;
                    }
                }
                this.f298128e.invoke(Boolean.FALSE, null);
                return;
            }
            if (qRDisplayTroopCardRepo.m(this.f298129f).length() > 0) {
                z16 = true;
            }
            if (z16) {
                Bitmap f17 = qRDisplayTroopCardRepo.f(qRDisplayTroopCardRepo.m(this.f298129f));
                QLog.i("QRDisplayTroopCardRepo", 1, "[getBitmapAsync][download]onRspCallback getFilePath(troopUin).isNotEmpty bitmap = " + f17);
                if (f17 != null) {
                    this.f298128e.invoke(Boolean.TRUE, f17);
                    return;
                } else {
                    this.f298128e.invoke(Boolean.FALSE, null);
                    return;
                }
            }
            QLog.e("QRDisplayTroopCardRepo", 1, "[getBitmapAsync][download]onRspCallback fail.");
            this.f298128e.invoke(Boolean.FALSE, null);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyEnd(Call call, long j3) {
            com.tencent.biz.richframework.download.v.k(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyStart(Call call) {
            com.tencent.biz.richframework.download.v.l(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
            com.tencent.biz.richframework.download.v.m(this, call, request);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersStart(Call call) {
            com.tencent.biz.richframework.download.v.n(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyEnd(Call call, long j3) {
            com.tencent.biz.richframework.download.v.o(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyStart(Call call) {
            com.tencent.biz.richframework.download.v.p(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
            com.tencent.biz.richframework.download.v.q(this, call, response);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersStart(Call call) {
            com.tencent.biz.richframework.download.v.r(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
            com.tencent.biz.richframework.download.v.s(this, call, handshake);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectStart(Call call) {
            com.tencent.biz.richframework.download.v.t(this, call);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardRepo$b", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "errorResponse", "", "a", "successResponse", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f298130a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f298130a = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(TroopTrpcRemoteResponse errorResponse) {
            Intrinsics.checkNotNullParameter(errorResponse, "$errorResponse");
            QLog.i("QRDisplayTroopCardRepo", 1, "[resetTroopQRData] onError, error = " + errorResponse);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(TroopTrpcRemoteResponse successResponse, Function1 cb5) {
            Intrinsics.checkNotNullParameter(successResponse, "$successResponse");
            Intrinsics.checkNotNullParameter(cb5, "$cb");
            try {
                if (successResponse.data != null) {
                    QunJoinUrlSvrPB$ResetGroupQrCodeRsp qunJoinUrlSvrPB$ResetGroupQrCodeRsp = new QunJoinUrlSvrPB$ResetGroupQrCodeRsp();
                    qunJoinUrlSvrPB$ResetGroupQrCodeRsp.mergeFrom(successResponse.data);
                    if (qunJoinUrlSvrPB$ResetGroupQrCodeRsp.is_success.get()) {
                        cb5.invoke(Boolean.TRUE);
                    }
                    QLog.i("QRDisplayTroopCardRepo", 1, "[resetTroopQRData] onSuccess, rsp = " + qunJoinUrlSvrPB$ResetGroupQrCodeRsp + ", is_success = " + qunJoinUrlSvrPB$ResetGroupQrCodeRsp.is_success.get());
                    return;
                }
                QLog.i("QRDisplayTroopCardRepo", 1, "[resetTroopQRData] onSuccess, data = null");
            } catch (Exception e16) {
                QLog.e("QRDisplayTroopCardRepo", 1, "[resetTroopQRData] onException = " + e16);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull final TroopTrpcRemoteResponse errorResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) errorResponse);
            } else {
                Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        QRDisplayTroopCardRepo.b.e(TroopTrpcRemoteResponse.this);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull final TroopTrpcRemoteResponse successResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) successResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Function1<Boolean, Unit> function1 = this.f298130a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.q
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayTroopCardRepo.b.f(TroopTrpcRemoteResponse.this, function1);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/qrcode/QRDisplayTroopCardRepo$c", "Lcom/tencent/mobileqq/qrscan/o;", "", "i", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.mobileqq.qrscan.o {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function4<Boolean, Integer, String, String, Unit> f298131d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f298132e;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function4<? super Boolean, ? super Integer, ? super String, ? super String, Unit> function4, String str) {
            this.f298131d = function4;
            this.f298132e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function4, (Object) str);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
        @Override // com.tencent.mobileqq.qrscan.o, mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean isSuccess, @Nullable Bundle bundle) {
            String str;
            Exception e16;
            String str2;
            String str3;
            String str4;
            JSONObject jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(isSuccess), bundle);
                return;
            }
            if (isSuccess && bundle != null && bundle.containsKey("result")) {
                String string = bundle.getString("result");
                if (string == null) {
                    return;
                }
                try {
                    jSONObject = new JSONObject(string);
                } catch (Exception e17) {
                    str = "";
                    e16 = e17;
                    str2 = str;
                }
                if (jSONObject.getInt("r") != 0) {
                    str3 = "";
                    str4 = str3;
                } else {
                    z16 = jSONObject.optBoolean("is_use_custom_qr_code", false);
                    str2 = jSONObject.getString("url");
                    Intrinsics.checkNotNullExpressionValue(str2, "json.getString(\"url\")");
                    if (z16) {
                        try {
                            str = jSONObject.optString("custom_qr_code_url");
                            Intrinsics.checkNotNullExpressionValue(str, "json.optString(\"custom_qr_code_url\")");
                            try {
                                QLog.i("QRDisplayTroopCardRepo", 1, "[sendEncodeRequest][onReceive]downloadUrl=" + str);
                            } catch (Exception e18) {
                                e16 = e18;
                                QLog.e("QRDisplayTroopCardRepo", 1, "QRCodeBusinessObserver onReceive error, ", e16);
                                str3 = str2;
                                str4 = str;
                                if (!TextUtils.isEmpty(str3)) {
                                }
                            }
                        } catch (Exception e19) {
                            e16 = e19;
                            str = "";
                        }
                        str3 = str2;
                        str4 = str;
                    } else {
                        str3 = str2;
                        str4 = "";
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    QLog.e("QRDisplayTroopCardRepo", 1, "[sendEncodeRequest][onReceive]shortChain is empty!");
                    QRDisplayTroopCardRepo.f298123a.g(false, 0, "", "", this.f298131d);
                    return;
                }
                QRDisplayTroopCardRepo qRDisplayTroopCardRepo = QRDisplayTroopCardRepo.f298123a;
                if (qRDisplayTroopCardRepo.i() && z16 && !TextUtils.isEmpty(str4)) {
                    qRDisplayTroopCardRepo.g(true, 2, str3, str4, this.f298131d);
                    return;
                }
                if (z16 && TextUtils.isEmpty(str4)) {
                    QLog.e("QRDisplayTroopCardRepo", 1, "[sendEncodeRequest][onReceive]now is aigc style, but downloadUrl is empty.");
                    qRDisplayTroopCardRepo.g(true, 1, str3, "", this.f298131d);
                    return;
                } else {
                    qRDisplayTroopCardRepo.v(str3, this.f298132e);
                    qRDisplayTroopCardRepo.g(true, 1, str3, "", this.f298131d);
                    return;
                }
            }
            QLog.e("QRDisplayTroopCardRepo", 1, "[sendEncodeRequest][onReceive]fail.");
            QRDisplayTroopCardRepo.f298123a.g(false, 0, "", "", this.f298131d);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62179);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        f298123a = new QRDisplayTroopCardRepo();
        handler = new Handler(Looper.getMainLooper());
        isDownloading = new AtomicBoolean(false);
        downloadTimeoutRunnable = new Runnable() { // from class: com.tencent.mobileqq.troop.qrcode.o
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayTroopCardRepo.h();
            }
        };
    }

    QRDisplayTroopCardRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e(String troopUin, String downloadUrl) {
        boolean z16;
        if (!Intrinsics.areEqual(k(troopUin), downloadUrl)) {
            return true;
        }
        if (m(troopUin).length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && new File(m(troopUin)).exists()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap f(String filePath) {
        try {
            if (!new File(filePath).exists()) {
                QLog.e("QRDisplayTroopCardRepo", 1, "decodeBitmapFromFile, but file not exist. filePath = " + filePath);
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            Bitmap decodeFile = BitmapFactory.decodeFile(filePath, options);
            QLog.i("QRDisplayTroopCardRepo", 1, "decodeBitmapFromFile cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            return decodeFile;
        } catch (Throwable th5) {
            QLog.e("QRDisplayTroopCardRepo", 1, "decodeBitmapFromFile error, ", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(boolean isSuccess, int style, String shortChain, String url, Function4<? super Boolean, ? super Integer, ? super String, ? super String, Unit> cb5) {
        QLog.i("QRDisplayTroopCardRepo", 1, "[doCallback] isSuccess = " + isSuccess + ", style = " + style + ", chain = " + shortChain + ", url = " + url);
        cb5.invoke(Boolean.valueOf(isSuccess), Integer.valueOf(style), shortChain, url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        QLog.i("QRDisplayTroopCardRepo", 1, "download time out.");
        isDownloading.set(false);
    }

    private final MMKVOptionEntity l() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from;
    }

    public static /* synthetic */ void s(QRDisplayTroopCardRepo qRDisplayTroopCardRepo, String str, boolean z16, Function4 function4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        qRDisplayTroopCardRepo.r(str, z16, function4);
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean b16 = com.tencent.mobileqq.troop.config.b.f294691a.b("qun_aigc_qrcode_card", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, false);
        QLog.i("QRDisplayTroopCardRepo", 1, "[enableAIGCStyle] rtn = " + b16);
        return b16;
    }

    public final void j(@NotNull String troopUin, @NotNull String url, @NotNull Function2<? super Boolean, ? super Bitmap, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, troopUin, url, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (!e(troopUin, url)) {
            QLog.i("QRDisplayTroopCardRepo", 1, "[getBitmapAsync]needn't download.");
            Bitmap f16 = f(m(troopUin));
            if (f16 != null) {
                cb5.invoke(Boolean.TRUE, f16);
                return;
            } else {
                QLog.e("QRDisplayTroopCardRepo", 1, "[getBitmapAsync]decode local file failed.");
                cb5.invoke(Boolean.FALSE, null);
                return;
            }
        }
        QLog.i("QRDisplayTroopCardRepo", 1, "[getBitmapAsync], url = " + url);
        u(troopUin, "");
        t(troopUin, "");
        if (isDownloading.compareAndSet(false, true)) {
            handler.postDelayed(downloadTimeoutRunnable, 10000L);
            RFWDownloaderFactory.getDownloader(com.tencent.mobileqq.troop.qrcode.a.f298164a).download(url, new a(url, cb5, troopUin));
        } else {
            QLog.e("QRDisplayTroopCardRepo", 1, "is downloading now, ignore.");
        }
    }

    @NotNull
    public final String k(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String decodeString = l().decodeString("troop_aigc_download_url_" + troopUin, "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getEntity().decodeString\u2026oad_url_${troopUin}\", \"\")");
        return decodeString;
    }

    @NotNull
    public final String m(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String decodeString = l().decodeString("troop_aigc_file_path_" + troopUin, "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "getEntity().decodeString\u2026le_path_${troopUin}\", \"\")");
        return decodeString;
    }

    @NotNull
    public final Handler n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Handler) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return handler;
    }

    @NotNull
    public final AtomicBoolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return isDownloading;
    }

    public final void p(@Nullable String troopUin, @Nullable String channelId, @Nullable String downloadUrl) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, channelId, downloadUrl);
            return;
        }
        boolean z18 = true;
        QLog.i("QRDisplayTroopCardRepo", 1, "[preloadAIGCImage] troopUin = " + troopUin + ", channelId = " + channelId + ", downloadUrl = " + downloadUrl);
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (channelId != null && channelId.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (downloadUrl != null && downloadUrl.length() != 0) {
                    z18 = false;
                }
                if (!z18) {
                    j(troopUin + "_" + channelId, downloadUrl, QRDisplayTroopCardRepo$preloadAIGCImage$1.INSTANCE);
                }
            }
        }
    }

    public final void q(@NotNull String troopUin, @Nullable String sourceId, @NotNull Function1<? super Boolean, Unit> cb5) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, troopUin, sourceId, cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i("QRDisplayTroopCardRepo", 1, "[resetTroopQRData] invoke");
        b bVar = new b(cb5);
        try {
            QunJoinUrlSvrPB$ResetGroupQrCodeReq qunJoinUrlSvrPB$ResetGroupQrCodeReq = new QunJoinUrlSvrPB$ResetGroupQrCodeReq();
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
            if (longOrNull != null) {
                qunJoinUrlSvrPB$ResetGroupQrCodeReq.group_id.set(longOrNull.longValue());
                if (sourceId != null) {
                    qunJoinUrlSvrPB$ResetGroupQrCodeReq.source_id.set(sourceId);
                }
                ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.qun_join_url_svr.QunJoinUrlSvr", "/trpc.iqun.qun_join_url_svr.QunJoinUrlSvr/ResetGroupQrCode", qunJoinUrlSvrPB$ResetGroupQrCodeReq.toByteArray(), 1, null, bVar);
            }
        } catch (Exception e16) {
            QLog.i("QRDisplayTroopCardRepo", 1, "[resetTroopQRData] exception = " + e16);
        }
    }

    public final void r(@NotNull String troopUin, boolean isUnsetAIGCStyle, @NotNull Function4<? super Boolean, ? super Integer, ? super String, ? super String, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, Boolean.valueOf(isUnsetAIGCStyle), cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i("QRDisplayTroopCardRepo", 1, "[sendEncodeRequest]start, isUnsetAIGCStyle=" + isUnsetAIGCStyle);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("QRDisplayTroopCardRepo", 1, "app is null");
            g(false, 0, "", "", cb5);
            return;
        }
        com.tencent.mobileqq.qrscan.m a16 = com.tencent.mobileqq.qrscan.m.a(2, troopUin);
        if (a16 == null) {
            QLog.e("QRDisplayTroopCardRepo", 2, "entity is null in getCardQRCode");
            g(false, 0, "", "", cb5);
            return;
        }
        String e16 = a16.e();
        Bundle bundle = new Bundle();
        if (isUnsetAIGCStyle) {
            bundle.putBoolean("is_unset_custom_qr_code", true);
        }
        ((IQRDataApi) QRoute.api(IQRDataApi.class)).requestUrlEncode(peekAppRuntime, e16, bundle, new c(cb5, troopUin));
    }

    public final void t(@NotNull String troopUin, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) troopUin, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(url, "url");
        l().encodeString("troop_aigc_download_url_" + troopUin, url);
    }

    public final void u(@NotNull String troopUin, @NotNull String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopUin, (Object) filePath);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        l().encodeString("troop_aigc_file_path_" + troopUin, filePath);
    }

    public final void v(@NotNull String shortChain, @NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) shortChain, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(shortChain, "shortChain");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        l().encodeString("key_troop_qrcode_short_chain_" + troopUin, shortChain);
    }
}
