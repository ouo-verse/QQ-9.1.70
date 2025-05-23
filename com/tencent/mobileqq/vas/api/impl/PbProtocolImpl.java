package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.api.IPbProtocolSSo;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.updatesystem.handler.VasUpdateHandler;
import com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v23.Node;
import v23.Status;
import v23.StatusNode;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ:\u0010\u0016\u001a\u00020\u0015\"\f\b\u0000\u0010\u000e*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J8\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010!\u001a\u00020 R\u0014\u0010$\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/PbProtocolImpl;", "Lcom/tencent/mobileqq/vas/api/IPbProtocol;", "Lx23/c;", "createReportChain", "Lcom/tencent/mobileqq/app/BusinessObserver;", "real", "chain", "createProxyObserver", "observer", "Leipc/EIPCCallback;", "getEipcCallback", "Lcom/tencent/mobileqq/vas/updatesystem/service/IVasUpdateHandler;", "getExtensionHandler", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "Lcom/tencent/mobileqq/vas/api/IPbProtocol$a;", "data", "Ljava/lang/Class;", "rspClass", "Lcom/tencent/mobileqq/vas/api/IPbProtocol$b;", "callback", "", Const.BUNDLE_KEY_REQUEST, "", "cmd", "req", "reqStr", "", "reqBytes", "Leipc/EIPCResult;", "result", "getDataAndCallback", "", "isMainProcess", "getManagerName", "()Ljava/lang/String;", "managerName", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PbProtocolImpl implements IPbProtocol {

    @NotNull
    private static final String TAG = "PbProtocol";

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/api/impl/PbProtocolImpl$b", "Leipc/EIPCCallback$Stub;", "Leipc/EIPCResult;", "result", "", "callback", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends EIPCCallback.Stub {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BusinessObserver f308476e;

        b(BusinessObserver businessObserver) {
            this.f308476e = businessObserver;
        }

        @Override // eipc.EIPCCallback
        public void callback(@NotNull EIPCResult result) throws RemoteException {
            Intrinsics.checkNotNullParameter(result, "result");
            PbProtocolImpl.this.getDataAndCallback(result, this.f308476e);
        }
    }

    private final BusinessObserver createProxyObserver(final BusinessObserver real, final x23.c chain) {
        return new BusinessObserver() { // from class: com.tencent.mobileqq.vas.api.impl.l
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                PbProtocolImpl.createProxyObserver$lambda$3(x23.c.this, real, i3, z16, obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createProxyObserver$lambda$3(x23.c chain, BusinessObserver businessObserver, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(chain, "$chain");
        chain.c(new StatusNode(1, new Status(!z16 ? 1 : 0, "", 0, 4, null))).end();
        if (businessObserver != null) {
            businessObserver.onUpdate(i3, z16, obj);
        }
    }

    private final x23.c createReportChain() {
        return com.tencent.mobileqq.vas.report.a.f310626a.a(new w23.c("vas_pb_req", y23.a.INSTANCE.a(), 0, true, 20000L));
    }

    private final EIPCCallback getEipcCallback(BusinessObserver observer) {
        return new b(observer);
    }

    private static final void request$lambda$0(x23.c chain, IPbProtocol.b callback, Class rspClass, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(chain, "$chain");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(rspClass, "$rspClass");
        chain.c(new StatusNode(1, new Status(!z16 ? 1 : 0, "", 0, 4, null))).end();
        try {
            MessageMicro messageMicro = (MessageMicro) rspClass.newInstance();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.ByteArray");
            MessageMicro mergeFrom = messageMicro.mergeFrom((byte[]) obj);
            Intrinsics.checkNotNull(mergeFrom, "null cannot be cast to non-null type T of com.tencent.mobileqq.vas.api.impl.PbProtocolImpl.request$lambda$0");
            callback.onReceived(z16, mergeFrom);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            callback.onReceived(false, null);
        }
    }

    private static final void request$lambda$1(PbProtocolImpl this$0, BusinessObserver proxyCallback, IPbProtocol.a data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(proxyCallback, "$proxyCallback");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.getEipcCallback(proxyCallback);
        Object proxy = RemoteProxy.getProxy(PbProtocolSSoImpl.class);
        Intrinsics.checkNotNull(proxy, "null cannot be cast to non-null type com.tencent.mobileqq.vas.api.IPbProtocolSSo");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void request$lambda$2(IPbProtocolSSo pbProtocolSS0Impl, String str, MessageMicro messageMicro, Class cls, EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(pbProtocolSS0Impl, "$pbProtocolSS0Impl");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        pbProtocolSS0Impl.request(str, (MessageMicro<?>) messageMicro, (Class<?>) cls, callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void getDataAndCallback(@NotNull EIPCResult result, @Nullable BusinessObserver observer) {
        byte[] byteArray;
        FileInputStream fileInputStream;
        Exception e16;
        Intrinsics.checkNotNullParameter(result, "result");
        Bundle bundle = result.data;
        if (bundle != null) {
            boolean z16 = bundle.getBoolean("isSuccess");
            int i3 = result.data.getInt("type");
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) result.data.getParcelable(PbProtocolSSoImpl.RESP_KEY_DESCRIPTOR);
            if (parcelFileDescriptor != null) {
                byteArray = new byte[result.data.getInt(PbProtocolSSoImpl.RESP_KEY_IS_DATA_LENGTH)];
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
                    } catch (Exception e17) {
                        fileInputStream = null;
                        e16 = e17;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileInputStream2 != null) {
                        }
                        parcelFileDescriptor.close();
                        throw th;
                    }
                } catch (IOException e18) {
                    QLog.e(PbProtocolSSoImpl.TAG, 1, e18.getMessage());
                }
                try {
                    try {
                        fileInputStream.read(byteArray);
                        fileInputStream.close();
                        fileInputStream.close();
                        parcelFileDescriptor.close();
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e19) {
                                QLog.e(PbProtocolSSoImpl.TAG, 1, e19.getMessage());
                                throw th;
                            }
                        }
                        parcelFileDescriptor.close();
                        throw th;
                    }
                } catch (Exception e26) {
                    e16 = e26;
                    QLog.e(PbProtocolSSoImpl.TAG, 1, e16.getMessage());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    parcelFileDescriptor.close();
                    if (byteArray == null) {
                    }
                    if (observer == null) {
                    }
                }
            } else {
                byteArray = result.data.getByteArray(PbProtocolSSoImpl.RESP_KEY_IS_DATA);
            }
            if (byteArray == null) {
                QLog.e(PbProtocolSSoImpl.TAG, 1, "respData is null");
                z16 = false;
                byteArray = new byte[0];
            }
            if (observer == null) {
                observer.onUpdate(i3, z16, byteArray);
            }
        }
    }

    @Nullable
    public final IVasUpdateHandler getExtensionHandler() {
        AppInterface appInterface;
        BusinessHandler businessHandler;
        AppRuntime app = VasCommonUtils.INSTANCE.getApp();
        if (app instanceof AppInterface) {
            appInterface = (AppInterface) app;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            businessHandler = appInterface.getBusinessHandler(VasUpdateHandler.f311201h);
        } else {
            businessHandler = null;
        }
        if (!(businessHandler instanceof IVasUpdateHandler)) {
            return null;
        }
        return (IVasUpdateHandler) businessHandler;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        String name = PbProtocolImpl.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.javaClass.name");
        return name;
    }

    public final boolean isMainProcess() {
        return Intrinsics.areEqual(BaseApplication.getContext().getPackageName(), MobileQQ.processName);
    }

    @Override // com.tencent.mobileqq.vas.api.IPbProtocol
    public <T extends MessageMicro<?>> void request(@NotNull IPbProtocol.a data, @NotNull Class<T> rspClass, @NotNull IPbProtocol.b<T> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(rspClass, "rspClass");
        Intrinsics.checkNotNullParameter(callback, "callback");
        createReportChain();
        isMainProcess();
        throw null;
    }

    @Override // com.tencent.mobileqq.vas.api.IPbProtocol
    public void request(@Nullable final String cmd, @Nullable final MessageMicro<?> req, @Nullable final Class<?> rspClass, @Nullable BusinessObserver observer) {
        x23.c createReportChain = createReportChain();
        boolean isMainProcess = isMainProcess();
        createReportChain.a("cmd", cmd == null ? "" : cmd);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(isMainProcess ? 1 : 0);
        createReportChain.a("mainProcess", sb5.toString());
        createReportChain.c(new Node(0));
        BusinessObserver createProxyObserver = createProxyObserver(observer, createReportChain);
        if (!isMainProcess) {
            final EIPCCallback eipcCallback = getEipcCallback(createProxyObserver);
            Object proxy = RemoteProxy.getProxy(PbProtocolSSoImpl.class);
            Intrinsics.checkNotNull(proxy, "null cannot be cast to non-null type com.tencent.mobileqq.vas.api.IPbProtocolSSo");
            final IPbProtocolSSo iPbProtocolSSo = (IPbProtocolSSo) proxy;
            y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.m
                @Override // java.lang.Runnable
                public final void run() {
                    PbProtocolImpl.request$lambda$2(IPbProtocolSSo.this, cmd, req, rspClass, eipcCallback);
                }
            });
            return;
        }
        IVasUpdateHandler extensionHandler = getExtensionHandler();
        if (extensionHandler != null) {
            extensionHandler.request(cmd, req, rspClass, createProxyObserver);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IPbProtocol
    public void request(@Nullable String cmd, @Nullable String reqStr, @Nullable BusinessObserver observer) {
        x23.c createReportChain = createReportChain();
        boolean isMainProcess = isMainProcess();
        createReportChain.a("cmd", cmd == null ? "" : cmd);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(isMainProcess ? 1 : 0);
        createReportChain.a("mainProcess", sb5.toString());
        createReportChain.c(new Node(0));
        BusinessObserver createProxyObserver = createProxyObserver(observer, createReportChain);
        if (!isMainProcess) {
            EIPCCallback eipcCallback = getEipcCallback(createProxyObserver);
            Object proxy = RemoteProxy.getProxy(PbProtocolSSoImpl.class);
            Intrinsics.checkNotNull(proxy, "null cannot be cast to non-null type com.tencent.mobileqq.vas.api.IPbProtocolSSo");
            ((IPbProtocolSSo) proxy).request(cmd, reqStr, eipcCallback);
            return;
        }
        IVasUpdateHandler extensionHandler = getExtensionHandler();
        if (extensionHandler != null) {
            extensionHandler.request(cmd, reqStr, createProxyObserver);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IPbProtocol
    public void request(@Nullable String cmd, @Nullable byte[] reqBytes, @Nullable BusinessObserver observer) {
        x23.c createReportChain = createReportChain();
        boolean isMainProcess = isMainProcess();
        createReportChain.a("cmd", cmd == null ? "" : cmd);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(isMainProcess ? 1 : 0);
        createReportChain.a("mainProcess", sb5.toString());
        createReportChain.c(new Node(0));
        BusinessObserver createProxyObserver = createProxyObserver(observer, createReportChain);
        if (!isMainProcess) {
            EIPCCallback eipcCallback = getEipcCallback(createProxyObserver);
            Object proxy = RemoteProxy.getProxy(PbProtocolSSoImpl.class);
            Intrinsics.checkNotNull(proxy, "null cannot be cast to non-null type com.tencent.mobileqq.vas.api.IPbProtocolSSo");
            ((IPbProtocolSSo) proxy).request(cmd, reqBytes, eipcCallback);
            return;
        }
        IVasUpdateHandler extensionHandler = getExtensionHandler();
        if (extensionHandler != null) {
            extensionHandler.request(cmd, reqBytes, createProxyObserver);
        }
    }
}
