package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.api.IPbProtocolSSo;
import com.tencent.mobileqq.vas.updatesystem.handler.VasUpdateHandler;
import com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J.\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0018\u001a\u00020\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/PbProtocolSSoImpl;", "Lcom/tencent/mobileqq/vas/api/IPbProtocolSSo;", "", "data", "Landroid/os/ParcelFileDescriptor;", "d", "", "c", "", "cmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "req", "Ljava/lang/Class;", "rspClass", "Leipc/EIPCCallback;", "callback", "", Const.BUNDLE_KEY_REQUEST, "reqStr", "reqBytes", "traceId", "Lcom/tencent/mobileqq/vas/updatesystem/service/IVasUpdateHandler;", "getExtensionHandler", "Lcom/tencent/mobileqq/app/BusinessObserver;", "getBusinessObserver", "", "type", "isSuccess", "Ljava/lang/Object;", "Leipc/EIPCResult;", "bindObserverData", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PbProtocolSSoImpl implements IPbProtocolSSo {
    public static final int MAX_DATA_SIZE = 800;

    @NotNull
    public static final String RESP_KEY_DESCRIPTOR = "rspDescriptor";

    @NotNull
    public static final String RESP_KEY_IS_DATA = "rspBytes";

    @NotNull
    public static final String RESP_KEY_IS_DATA_LENGTH = "rspDataLength";

    @NotNull
    public static final String RESP_KEY_IS_SUCCESS = "isSuccess";

    @NotNull
    public static final String RESP_KEY_TYPE = "type";

    @NotNull
    public static final String TAG = "PbProtocolSSoImpl";

    @NotNull
    public static final String TOGGLE_MEMORY_FILE = "protocol_sso_memory_file";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EIPCCallback eIPCCallback, PbProtocolSSoImpl this$0, int i3, boolean z16, Object obj) {
        Boolean valueOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCCallback != null) {
            try {
                IBinder asBinder = eIPCCallback.asBinder();
                if (asBinder != null) {
                    valueOf = Boolean.valueOf(asBinder.isBinderAlive());
                    Intrinsics.checkNotNull(valueOf);
                    if (!valueOf.booleanValue() && eIPCCallback != null) {
                        eIPCCallback.callback(this$0.bindObserverData(i3, z16, obj));
                        return;
                    }
                }
            } catch (DeadObjectException e16) {
                QLog.e(TAG, 1, e16.getMessage());
                return;
            }
        }
        valueOf = null;
        Intrinsics.checkNotNull(valueOf);
        if (!valueOf.booleanValue()) {
        }
    }

    private final boolean c() {
        return new ToggleProxy(TOGGLE_MEMORY_FILE).onIsEnable(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ParcelFileDescriptor d(byte[] data) {
        MemoryFile memoryFile;
        MemoryFile memoryFile2 = null;
        if (!c()) {
            return null;
        }
        try {
            memoryFile = new MemoryFile(null, data.length);
        } catch (Exception e16) {
            e = e16;
            memoryFile = null;
        } catch (Throwable th5) {
            th = th5;
            if (memoryFile2 != null) {
            }
            throw th;
        }
        try {
            try {
                memoryFile.getOutputStream().write(data);
                Method declaredMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
                Intrinsics.checkNotNullExpressionValue(declaredMethod, "MemoryFile::class.java.g\u2026thod(\"getFileDescriptor\")");
                Object invoke = declaredMethod.invoke(memoryFile, new Object[0]);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type java.io.FileDescriptor");
                ParcelFileDescriptor dup = ParcelFileDescriptor.dup((FileDescriptor) invoke);
                try {
                    OutputStream outputStream = memoryFile.getOutputStream();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e17) {
                    QLog.e(TAG, 1, e17.getMessage());
                }
                return dup;
            } catch (Throwable th6) {
                th = th6;
                memoryFile2 = memoryFile;
                if (memoryFile2 != null) {
                    try {
                        OutputStream outputStream2 = memoryFile2.getOutputStream();
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                    } catch (IOException e18) {
                        QLog.e(TAG, 1, e18.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception e19) {
            e = e19;
            QLog.e(TAG, 1, e.getMessage());
            if (memoryFile != null) {
                try {
                    OutputStream outputStream3 = memoryFile.getOutputStream();
                    if (outputStream3 != null) {
                        outputStream3.close();
                    }
                } catch (IOException e26) {
                    QLog.e(TAG, 1, e26.getMessage());
                }
            }
            return null;
        }
    }

    @NotNull
    public final EIPCResult bindObserverData(int type, boolean isSuccess, @Nullable Object data) {
        boolean z16;
        EIPCResult eIPCResult = new EIPCResult();
        Bundle bundle = new Bundle();
        eIPCResult.data = bundle;
        bundle.putBoolean("isSuccess", isSuccess);
        eIPCResult.data.putInt("type", type);
        if (data != null) {
            byte[] bArr = (byte[]) data;
            if (bArr.length >= 800) {
                ParcelFileDescriptor d16 = d(bArr);
                int length = bArr.length;
                boolean c16 = c();
                if (d16 == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.w(TAG, 1, "size" + length + "isFeatureSwitchEnable : " + c16 + "descriptor == null : " + d16 + z16);
                if (d16 != null) {
                    eIPCResult.data.putParcelable(RESP_KEY_DESCRIPTOR, d16);
                    eIPCResult.data.putInt(RESP_KEY_IS_DATA_LENGTH, bArr.length);
                    return eIPCResult;
                }
            }
        }
        if (data != null) {
            byte[] bArr2 = (byte[]) data;
            QLog.w(TAG, 1, "data.size" + bArr2.length);
            eIPCResult.data.putByteArray(RESP_KEY_IS_DATA, bArr2);
        }
        return eIPCResult;
    }

    @NotNull
    public final BusinessObserver getBusinessObserver(@Nullable final EIPCCallback callback) {
        return new BusinessObserver() { // from class: com.tencent.mobileqq.vas.api.impl.n
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                PbProtocolSSoImpl.b(EIPCCallback.this, this, i3, z16, obj);
            }
        };
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

    @Override // com.tencent.mobileqq.vas.api.IPbProtocolSSo
    public void request(@Nullable String cmd, @Nullable MessageMicro<?> req, @Nullable Class<?> rspClass, @Nullable EIPCCallback callback) {
        IVasUpdateHandler extensionHandler = getExtensionHandler();
        if (extensionHandler != null) {
            extensionHandler.request(cmd, req, rspClass, getBusinessObserver(callback));
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IPbProtocolSSo
    public void request(@Nullable String cmd, @Nullable String reqStr, @Nullable EIPCCallback callback) {
        IVasUpdateHandler extensionHandler = getExtensionHandler();
        if (extensionHandler != null) {
            extensionHandler.request(cmd, reqStr, getBusinessObserver(callback));
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IPbProtocolSSo
    public void request(@Nullable String cmd, @Nullable byte[] reqBytes, @Nullable EIPCCallback callback) {
        IVasUpdateHandler extensionHandler = getExtensionHandler();
        if (extensionHandler != null) {
            extensionHandler.request(cmd, reqBytes, getBusinessObserver(callback));
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IPbProtocolSSo
    public void request(@Nullable String cmd, @Nullable String reqStr, @NotNull String traceId, @Nullable EIPCCallback callback) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        IVasUpdateHandler extensionHandler = getExtensionHandler();
        if (extensionHandler != null) {
            extensionHandler.request(cmd, reqStr, traceId, getBusinessObserver(callback));
        }
    }
}
