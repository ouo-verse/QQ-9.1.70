package com.tencent.av.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/av/utils/ai;", "", "a", "qqrtc-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class ai {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static Boolean f76977b;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f76979d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static int f76978c = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007R*\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b8F@FX\u0087\u000e\u00a2\u0006\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006\""}, d2 = {"Lcom/tencent/av/utils/ai$a;", "", "Landroid/content/Context;", "context", "", "processName", "", "d", "", "e", "", "g", "c", "a", "audioMode", "f", "value", "b", "()Z", tl.h.F, "(Z)V", "getHasCheckBluetoothFlag$annotations", "()V", "hasCheckBluetoothFlag", "KEY_LAST_REQUEST_BLUETOOTH_PID", "Ljava/lang/String;", "TAG", "sHasCheckBluetoothFlag", "Z", "sHasRequestBluetoothPer", "Ljava/lang/Boolean;", "sMainProcessPid", "I", "<init>", "qqrtc-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.av.utils.ai$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        
            r1 = r3.pid;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final int d(Context context, String processName) {
            int i3 = -1;
            if (context != null && !TextUtils.isEmpty(processName)) {
                try {
                    Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                    Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (Intrinsics.areEqual(processName, next.processName)) {
                            break;
                        }
                    }
                } catch (Exception unused) {
                    QLog.e("QAVPermissionUtils", 1, "get getProcessPid info fail.");
                }
                QLog.d("QAVPermissionUtils", 1, "getProcessPid name: " + processName + " pid: " + i3);
            }
            return i3;
        }

        @JvmStatic
        public final boolean a(@Nullable Context context) {
            if (context == null) {
                return false;
            }
            Object systemService = context.getSystemService("audio");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            AudioDeviceInfo[] devices = ((AudioManager) systemService).getDevices(2);
            Intrinsics.checkNotNullExpressionValue(devices, "devices");
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 26) {
                    QLog.d("QAVPermissionUtils", 1, "checkHasBluetoothDeviceConnected device: " + ((Object) audioDeviceInfo.getProductName()) + " type: " + audioDeviceInfo.getType());
                    return true;
                }
            }
            return false;
        }

        public final boolean b() {
            return ai.f76979d;
        }

        public final int c(@Nullable Context context) {
            if (ai.f76978c != -1) {
                return ai.f76978c;
            }
            ai.f76978c = d(context, "com.tencent.mobileqq");
            return ai.f76978c;
        }

        @JvmStatic
        public final boolean e(@NotNull Context context) {
            boolean z16;
            Intrinsics.checkNotNullParameter(context, "context");
            if (AppSetting.m() < 31 || Build.VERSION.SDK_INT < 31) {
                return true;
            }
            if (ai.f76977b != null) {
                return false;
            }
            int c16 = c(context);
            int decodeInt = QMMKV.from(context, QMMKVFile.FILE_QAV).decodeInt("qav_last_request_bluetooth_pid", 0);
            if (decodeInt == c16) {
                z16 = true;
            } else {
                z16 = false;
            }
            ai.f76977b = Boolean.valueOf(z16);
            QLog.d("QAVPermissionUtils", 1, "hasRequestBluetoothPermission lastPid: " + decodeInt + " pid: " + c16);
            return false;
        }

        @JvmStatic
        public final boolean f(int audioMode) {
            if (Build.VERSION.SDK_INT < 31 || !ak.e("qav_phone_calling_switch", true) || audioMode != 2) {
                return false;
            }
            return true;
        }

        @JvmStatic
        public final void g(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AppSetting.m() >= 31 && Build.VERSION.SDK_INT >= 31) {
                Boolean bool = ai.f76977b;
                Boolean bool2 = Boolean.TRUE;
                if (!Intrinsics.areEqual(bool, bool2)) {
                    ai.f76977b = bool2;
                    QMMKV.from(context, QMMKVFile.FILE_QAV).encodeInt("qav_last_request_bluetooth_pid", c(context));
                }
            }
        }

        public final void h(boolean z16) {
            ai.f76979d = z16;
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final boolean g(@Nullable Context context) {
        return INSTANCE.a(context);
    }

    public static final boolean h() {
        return INSTANCE.b();
    }

    @JvmStatic
    public static final boolean i(@NotNull Context context) {
        return INSTANCE.e(context);
    }

    @JvmStatic
    public static final boolean j(int i3) {
        return INSTANCE.f(i3);
    }

    @JvmStatic
    public static final void k(@NotNull Context context) {
        INSTANCE.g(context);
    }

    public static final void l(boolean z16) {
        INSTANCE.h(z16);
    }
}
