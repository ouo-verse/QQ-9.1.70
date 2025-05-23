package com.tencent.mobileqq.perf.block;

import android.app.ActivityManager;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.os.Debug;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J)\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u001a\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u001cH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0004H\u0007\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/perf/block/SystemMethodProxy;", "", "()V", "getCallState", "", TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP, "Landroid/telephony/TelephonyManager;", "getIntProperty", "bm", "Landroid/os/BatteryManager;", "id", "getMemoryInfo", "", "memoryInfo", "Landroid/os/Debug$MemoryInfo;", "getProcessMemoryInfo", "", "am", "Landroid/app/ActivityManager;", "pids", "", "(Landroid/app/ActivityManager;[I)[Landroid/os/Debug$MemoryInfo;", "getPss", "", "getRunningAppProcesses", "", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "getStreamVolume", "Landroid/media/AudioManager;", "streamType", "isBluetoothScoOn", "", "killProcess", "pid", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class SystemMethodProxy {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final SystemMethodProxy INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28802);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new SystemMethodProxy();
        }
    }

    SystemMethodProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final int getCallState(@NotNull TelephonyManager tm5) {
        Intrinsics.checkNotNullParameter(tm5, "tm");
        MainBlockMethodMonitor.onMethodStart();
        int callState = tm5.getCallState();
        MainBlockMethodMonitor.onMethodEnd();
        return callState;
    }

    @JvmStatic
    public static final int getIntProperty(@NotNull BatteryManager bm5, int id5) {
        Intrinsics.checkNotNullParameter(bm5, "bm");
        MainBlockMethodMonitor.onMethodStart();
        int intProperty = bm5.getIntProperty(id5);
        MainBlockMethodMonitor.onMethodEnd();
        return intProperty;
    }

    @JvmStatic
    public static final void getMemoryInfo(@Nullable Debug.MemoryInfo memoryInfo) {
        MainBlockMethodMonitor.onMethodStart();
        Debug.getMemoryInfo(memoryInfo);
        Unit unit = Unit.INSTANCE;
        MainBlockMethodMonitor.onMethodEnd();
    }

    @JvmStatic
    @Nullable
    public static final Debug.MemoryInfo[] getProcessMemoryInfo(@NotNull ActivityManager am5, @Nullable int[] pids) {
        Intrinsics.checkNotNullParameter(am5, "am");
        MainBlockMethodMonitor.onMethodStart();
        Debug.MemoryInfo[] processMemoryInfo = am5.getProcessMemoryInfo(pids);
        MainBlockMethodMonitor.onMethodEnd();
        return processMemoryInfo;
    }

    @JvmStatic
    public static final long getPss() {
        MainBlockMethodMonitor.onMethodStart();
        long pss = Debug.getPss();
        MainBlockMethodMonitor.onMethodEnd();
        return pss;
    }

    @JvmStatic
    @Nullable
    public static final List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses(@NotNull ActivityManager am5) {
        Intrinsics.checkNotNullParameter(am5, "am");
        MainBlockMethodMonitor.onMethodStart();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = am5.getRunningAppProcesses();
        MainBlockMethodMonitor.onMethodEnd();
        return runningAppProcesses;
    }

    @JvmStatic
    public static final int getStreamVolume(@NotNull AudioManager am5, int streamType) {
        Intrinsics.checkNotNullParameter(am5, "am");
        MainBlockMethodMonitor.onMethodStart();
        int streamVolume = am5.getStreamVolume(streamType);
        MainBlockMethodMonitor.onMethodEnd();
        return streamVolume;
    }

    @JvmStatic
    public static final boolean isBluetoothScoOn(@NotNull AudioManager am5) {
        Intrinsics.checkNotNullParameter(am5, "am");
        MainBlockMethodMonitor.onMethodStart();
        boolean isBluetoothScoOn = am5.isBluetoothScoOn();
        MainBlockMethodMonitor.onMethodEnd();
        return isBluetoothScoOn;
    }

    @JvmStatic
    public static final void killProcess(int pid) {
        if (com.tencent.mobileqq.processkiller.a.a(pid)) {
            Process.killProcess(pid);
        }
    }
}
