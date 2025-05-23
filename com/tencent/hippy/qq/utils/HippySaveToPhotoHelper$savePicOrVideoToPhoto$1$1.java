package com.tencent.hippy.qq.utils;

import androidx.core.util.Consumer;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.v;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/hippy/qq/utils/HippySaveToPhotoHelper$savePicOrVideoToPhoto$1$1", "Lcom/tencent/biz/richframework/download/RFWDownloader$RFWDownloadListener;", "onDownloadProgress", "", "percent", "", "downloadedLength", "", "totalLength", "onRspCallback", "isSuccess", "", "filePath", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HippySaveToPhotoHelper$savePicOrVideoToPhoto$1$1 implements RFWDownloader.RFWDownloadListener {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ Function2<String, Float, Unit> $receiver;
    final /* synthetic */ String $url;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public HippySaveToPhotoHelper$savePicOrVideoToPhoto$1$1(Promise promise, Function2<? super String, ? super Float, Unit> function2, String str) {
        this.$promise = promise;
        this.$receiver = function2;
        this.$url = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRspCallback$lambda$0(Promise promise, String str, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        QLog.i("HippySaveToPhotoHelper", 1, "[saveVideoToPhoto] insertMedia,success:" + rFWSaveMediaResultBean.isSuccess);
        if (rFWSaveMediaResultBean.isSuccess) {
            HippySaveToPhotoHelper.INSTANCE.callbackSaveToPhoto(promise, 0, "success");
        } else {
            HippySaveToPhotoHelper.INSTANCE.callbackSaveToPhoto(promise, -3, "insert media failed");
        }
        FileUtils.deleteFile(str);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void callEnd(Call call) {
        v.a(this, call);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void callFailed(Call call, IOException iOException) {
        v.b(this, call, iOException);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void callStart(Call call) {
        v.c(this, call);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
        v.d(this, call, inetSocketAddress, proxy, protocol2);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
        v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        v.f(this, call, inetSocketAddress, proxy);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
        v.g(this, call, connection);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void connectionReleased(Call call, Connection connection) {
        v.h(this, call, connection);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void dnsEnd(Call call, String str, List list) {
        v.i(this, call, str, list);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void dnsStart(Call call, String str) {
        v.j(this, call, str);
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
    public void onDownloadProgress(float percent, long downloadedLength, long totalLength) {
        float f16 = 100 * percent;
        if (QLog.isColorLevel()) {
            QLog.i("HippySaveToPhotoHelper", 2, "[saveVideoToPhoto] percent:" + percent + ",progress:" + f16);
        }
        Function2<String, Float, Unit> function2 = this.$receiver;
        if (function2 != null) {
            function2.invoke(this.$url, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
    public void onRspCallback(boolean isSuccess, @Nullable final String filePath) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("HippySaveToPhotoHelper", 2, "[saveVideoToPhoto] onRspCallback isSuccess:" + isSuccess + ",filePath:" + filePath);
        }
        if (!isSuccess) {
            HippySaveToPhotoHelper.INSTANCE.callbackSaveToPhoto(this.$promise, -2, "downloaded failed");
            return;
        }
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || !new File(filePath).exists()) {
            HippySaveToPhotoHelper.INSTANCE.callbackSaveToPhoto(this.$promise, -2, "downloaded filePath is empty or not exists");
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        final Promise promise = this.$promise;
        RFWSaveUtil.insertMedia(mobileQQ, filePath, new Consumer() { // from class: com.tencent.hippy.qq.utils.i
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                HippySaveToPhotoHelper$savePicOrVideoToPhoto$1$1.onRspCallback$lambda$0(Promise.this, filePath, (RFWSaveMediaResultBean) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void requestBodyEnd(Call call, long j3) {
        v.k(this, call, j3);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void requestBodyStart(Call call) {
        v.l(this, call);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
        v.m(this, call, request);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void requestHeadersStart(Call call) {
        v.n(this, call);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void responseBodyEnd(Call call, long j3) {
        v.o(this, call, j3);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void responseBodyStart(Call call) {
        v.p(this, call);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
        v.q(this, call, response);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void responseHeadersStart(Call call) {
        v.r(this, call);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
        v.s(this, call, handshake);
    }

    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
    public /* synthetic */ void secureConnectStart(Call call) {
        v.t(this, call);
    }
}
