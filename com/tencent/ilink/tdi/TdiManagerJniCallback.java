package com.tencent.ilink.tdi;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.ilink.network.ApiProto;
import com.tencent.ilink.tdi.TdiApiProto;
import com.tencent.ilink.tdi.manager.TdiManager;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u001b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J \u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J(\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J \u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0007J*\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0007J*\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0007J*\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0007J*\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0007J*\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0007J*\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0007J*\u0010#\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0007J2\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0007J \u0010&\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0007J\u001a\u0010'\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0014H\u0007J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0014H\u0007J*\u0010+\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0007J\u0018\u0010,\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0006H\u0007J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007R@\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006/"}, d2 = {"Lcom/tencent/ilink/tdi/TdiManagerJniCallback;", "", "()V", "instances", "Ljava/util/HashMap;", "", "Lcom/tencent/ilink/tdi/IlinktdiInterfaceManager;", "Lkotlin/collections/HashMap;", "getInstances$annotations", "getInstances", "()Ljava/util/HashMap;", "setInstances", "(Ljava/util/HashMap;)V", "onAppSessionTimeoutEvent", "", "handle", "onC2CDownloadComplete", "task_id", "", "result", "", "onC2CDownloadProgress", "completed_length", "total_length", "onC2CUploadComplete", "onC2CUploadProgress", "onCancelOAuthComplete", "error", "onCheckLoginQrCodeComplete", "resp", "onFaceExtVerifyComplete", "onFaceRecognizeComplete", "onFaceRecognizeConfigComplete", "onGetAppPushTokenComplete", "onGetLoginQrCodeComplete", "onGetOAuthCodeComplete", "onLoginComplete", MsfConstants.ATTRIBUTE_LOGIN_TYPE, "onLogoutComplete", "onReceiveAppMessageEvent", "msg", "onRequestUploadLogfilesEvent", "cmd", "onSendAppRequestComplete", "registerInstance", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "unregisterInstance", "tdi-android-lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes7.dex */
public final class TdiManagerJniCallback {
    public static final TdiManagerJniCallback INSTANCE = new TdiManagerJniCallback();

    @NotNull
    private static HashMap<Long, IlinktdiInterfaceManager> instances = new HashMap<>();

    TdiManagerJniCallback() {
    }

    @NotNull
    public static final HashMap<Long, IlinktdiInterfaceManager> getInstances() {
        return instances;
    }

    @JvmStatic
    public static final void onAppSessionTimeoutEvent(long handle) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        if (callback != null) {
            callback.onAppSessionTimeoutEvent();
        }
    }

    @JvmStatic
    public static final void onC2CDownloadComplete(long handle, int task_id, @NotNull byte[] result) {
        TdiManager.Callback callback;
        Intrinsics.checkNotNullParameter(result, "result");
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        ApiProto.IlinkC2CDownloadResult defaultInstance = ApiProto.IlinkC2CDownloadResult.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "IlinkC2CDownloadResult.getDefaultInstance()");
        try {
            ApiProto.IlinkC2CDownloadResult parseFrom = ApiProto.IlinkC2CDownloadResult.parseFrom(result);
            Intrinsics.checkNotNullExpressionValue(parseFrom, "IlinkC2CDownloadResult.parseFrom(result)");
            defaultInstance = parseFrom;
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
        }
        if (callback != null) {
            callback.onC2CDownloadComplete(task_id, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onC2CDownloadProgress(long handle, int task_id, long completed_length, long total_length) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiManager.Callback callback2 = callback;
        if (callback2 != null) {
            callback2.onC2CDownloadProgress(task_id, completed_length, total_length);
        }
    }

    @JvmStatic
    public static final void onC2CUploadComplete(long handle, int task_id, @NotNull byte[] result) {
        TdiManager.Callback callback;
        Intrinsics.checkNotNullParameter(result, "result");
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        ApiProto.IlinkC2CUploadResult defaultInstance = ApiProto.IlinkC2CUploadResult.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "IlinkC2CUploadResult.getDefaultInstance()");
        try {
            ApiProto.IlinkC2CUploadResult parseFrom = ApiProto.IlinkC2CUploadResult.parseFrom(result);
            Intrinsics.checkNotNullExpressionValue(parseFrom, "IlinkC2CUploadResult.parseFrom(result)");
            defaultInstance = parseFrom;
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
        }
        if (callback != null) {
            callback.onC2CUploadComplete(task_id, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onC2CUploadProgress(long handle, int task_id, long completed_length, long total_length) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiManager.Callback callback2 = callback;
        if (callback2 != null) {
            callback2.onC2CUploadProgress(task_id, completed_length, total_length);
        }
    }

    @JvmStatic
    public static final void onCancelOAuthComplete(long handle, int task_id, int error) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        if (callback != null) {
            callback.onCancelOAuthComplete(task_id, error);
        }
    }

    @JvmStatic
    public static final void onCheckLoginQrCodeComplete(long handle, int task_id, int error, @Nullable byte[] resp) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiCheckLoginQrCodeResponse defaultInstance = TdiApiProto.TdiCheckLoginQrCodeResponse.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiCheckLoginQrCodeResponse.getDefaultInstance()");
        if (resp != null) {
            try {
                TdiApiProto.TdiCheckLoginQrCodeResponse parseFrom = TdiApiProto.TdiCheckLoginQrCodeResponse.parseFrom(resp);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiCheckLoginQrCodeResponse.parseFrom(resp)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            callback.onCheckLoginQrCodeComplete(task_id, error, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onFaceExtVerifyComplete(long handle, int task_id, int error, @Nullable byte[] resp) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiFaceExtVerifyResponse defaultInstance = TdiApiProto.TdiFaceExtVerifyResponse.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiFaceExtVerifyResponse.getDefaultInstance()");
        if (resp != null) {
            try {
                TdiApiProto.TdiFaceExtVerifyResponse parseFrom = TdiApiProto.TdiFaceExtVerifyResponse.parseFrom(resp);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiFaceExtVerifyResponse.parseFrom(resp)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            callback.onFaceExtVerifyComplete(task_id, error, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onFaceRecognizeComplete(long handle, int task_id, int error, @Nullable byte[] resp) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiFaceRecognizeResponse defaultInstance = TdiApiProto.TdiFaceRecognizeResponse.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiFaceRecognizeResponse.getDefaultInstance()");
        if (resp != null) {
            try {
                TdiApiProto.TdiFaceRecognizeResponse parseFrom = TdiApiProto.TdiFaceRecognizeResponse.parseFrom(resp);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiFaceRecognizeResponse.parseFrom(resp)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            callback.onFaceRecognizeComplete(task_id, error, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onFaceRecognizeConfigComplete(long handle, int task_id, int error, @Nullable byte[] resp) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiFaceRecognizeConfigResponse defaultInstance = TdiApiProto.TdiFaceRecognizeConfigResponse.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiFaceRecognizeConfigRe\u2026onse.getDefaultInstance()");
        if (resp != null) {
            try {
                TdiApiProto.TdiFaceRecognizeConfigResponse parseFrom = TdiApiProto.TdiFaceRecognizeConfigResponse.parseFrom(resp);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiFaceRecognizeConfigResponse.parseFrom(resp)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            callback.onFaceRecognizeConfigComplete(task_id, error, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onGetAppPushTokenComplete(long handle, int task_id, int error, @Nullable byte[] resp) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiAppPushToken defaultInstance = TdiApiProto.TdiAppPushToken.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiAppPushToken.getDefaultInstance()");
        if (resp != null) {
            try {
                TdiApiProto.TdiAppPushToken parseFrom = TdiApiProto.TdiAppPushToken.parseFrom(resp);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiAppPushToken.parseFrom(resp)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            callback.onGetAppPushTokenComplete(task_id, error, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onGetLoginQrCodeComplete(long handle, int task_id, int error, @Nullable byte[] resp) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiGetLoginQrCodeResponse defaultInstance = TdiApiProto.TdiGetLoginQrCodeResponse.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiGetLoginQrCodeResponse.getDefaultInstance()");
        if (resp != null) {
            try {
                TdiApiProto.TdiGetLoginQrCodeResponse parseFrom = TdiApiProto.TdiGetLoginQrCodeResponse.parseFrom(resp);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiGetLoginQrCodeResponse.parseFrom(resp)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            callback.onGetLoginQrCodeComplete(task_id, error, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onGetOAuthCodeComplete(long handle, int task_id, int error, @Nullable byte[] resp) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiGetOAuthCodeResponse defaultInstance = TdiApiProto.TdiGetOAuthCodeResponse.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiGetOAuthCodeResponse.getDefaultInstance()");
        if (resp != null) {
            try {
                TdiApiProto.TdiGetOAuthCodeResponse parseFrom = TdiApiProto.TdiGetOAuthCodeResponse.parseFrom(resp);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiGetOAuthCodeResponse.parseFrom(resp)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            callback.onGetOAuthCodeComplete(task_id, error, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onLoginComplete(long handle, int task_id, int login_type, int error, @Nullable byte[] resp) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiLoginResponse defaultInstance = TdiApiProto.TdiLoginResponse.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiLoginResponse.getDefaultInstance()");
        if (resp != null) {
            try {
                TdiApiProto.TdiLoginResponse parseFrom = TdiApiProto.TdiLoginResponse.parseFrom(resp);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiLoginResponse.parseFrom(resp)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            TdiApiProto.TdiLoginType forNumber = TdiApiProto.TdiLoginType.forNumber(login_type);
            Intrinsics.checkNotNullExpressionValue(forNumber, "TdiLoginType.forNumber(login_type)");
            callback.onLoginComplete(task_id, forNumber, error, defaultInstance);
        }
    }

    @JvmStatic
    public static final void onLogoutComplete(long handle, int task_id, int error) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        if (callback != null) {
            callback.onLogoutComplete(task_id, error);
        }
    }

    @JvmStatic
    public static final void onReceiveAppMessageEvent(long handle, @Nullable byte[] msg2) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiAppMessage defaultInstance = TdiApiProto.TdiAppMessage.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiAppMessage.getDefaultInstance()");
        if (msg2 != null) {
            try {
                TdiApiProto.TdiAppMessage parseFrom = TdiApiProto.TdiAppMessage.parseFrom(msg2);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiAppMessage.parseFrom(msg)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            callback.onReceiveAppMessageEvent(defaultInstance);
        }
    }

    @JvmStatic
    public static final void onRequestUploadLogfilesEvent(long handle, @NotNull byte[] cmd) {
        TdiManager.Callback callback;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        if (callback != null) {
            callback.onRequestUploadLogfilesEvent(cmd);
        }
    }

    @JvmStatic
    public static final void onSendAppRequestComplete(long handle, int task_id, int error, @Nullable byte[] resp) {
        TdiManager.Callback callback;
        IlinktdiInterfaceManager ilinktdiInterfaceManager = instances.get(Long.valueOf(handle));
        if (ilinktdiInterfaceManager != null) {
            callback = ilinktdiInterfaceManager.getTdiManager().getCallback();
        } else {
            callback = null;
        }
        TdiApiProto.TdiAppResponse defaultInstance = TdiApiProto.TdiAppResponse.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "TdiAppResponse.getDefaultInstance()");
        if (resp != null) {
            try {
                TdiApiProto.TdiAppResponse parseFrom = TdiApiProto.TdiAppResponse.parseFrom(resp);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "TdiAppResponse.parseFrom(resp)");
                defaultInstance = parseFrom;
            } catch (InvalidProtocolBufferException e16) {
                e16.printStackTrace();
            }
        }
        if (callback != null) {
            callback.onSendAppRequestComplete(task_id, error, defaultInstance);
        }
    }

    @JvmStatic
    public static final void registerInstance(long handle, @NotNull IlinktdiInterfaceManager instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (!instances.containsKey(Long.valueOf(handle))) {
            instances.put(Long.valueOf(handle), instance);
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public static final void setInstances(@NotNull HashMap<Long, IlinktdiInterfaceManager> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        instances = hashMap;
    }

    @JvmStatic
    public static final void unregisterInstance(long handle) {
        instances.remove(Long.valueOf(handle));
    }

    @JvmStatic
    public static /* synthetic */ void getInstances$annotations() {
    }
}
