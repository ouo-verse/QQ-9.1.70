package com.tencent.mobileqq.qqaudio.audioplayer;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final List<Integer> f262172a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f262173b;

    /* renamed from: c, reason: collision with root package name */
    public static int f262174c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f262175d;

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f262176e;

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicBoolean f262177f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36898);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f262172a = Arrays.asList(1796);
        f262173b = true;
        f262174c = -1;
        f262175d = false;
        f262176e = new AtomicBoolean(false);
        f262177f = new AtomicBoolean(true);
    }

    public static boolean b(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return true;
        }
        if (f262177f.compareAndSet(true, false)) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
            f262176e.set(defaultSharedPreferences.getBoolean(BaseApplication.getContext().getString(R.string.cz6) + appRuntime.getCurrentAccountUin(), true));
        }
        return f262176e.get();
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) context.getSystemService("audio")).getDevices(2)) {
            if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                QLog.d("AudioDeviceHelper", 1, "bluetooth device:" + ((Object) audioDeviceInfo.getProductName()) + " type: " + audioDeviceInfo.getType());
                return true;
            }
        }
        return false;
    }

    public static boolean d(Context context) {
        boolean isBluetoothScoOn = ((AudioManager) context.getSystemService("audio")).isBluetoothScoOn();
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer", 2, "isBluetoothScoOn(), isSCOOn = " + isBluetoothScoOn);
        }
        return isBluetoothScoOn;
    }

    public static boolean e(Context context) {
        return ((AudioManager) context.getSystemService("audio")).isBluetoothScoOn();
    }

    public static boolean f(Context context) {
        try {
            AudioDeviceHelperKt audioDeviceHelperKt = AudioDeviceHelperKt.f262108a;
            if (audioDeviceHelperKt.c()) {
                return audioDeviceHelperKt.g();
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            return Boolean.parseBoolean(audioManager.getClass().getMethod("isWiredHeadsetOn", new Class[0]).invoke(audioManager, null).toString());
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(AppRuntime appRuntime, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putBoolean(BaseApplication.getContext().getString(R.string.cz6) + appRuntime.getCurrentAccountUin(), z16);
        edit.commit();
    }

    public static boolean h(AudioManager audioManager) {
        BluetoothAdapter defaultAdapter;
        if ((com.tencent.mobileqq.inject.a.f238063a.a() >= 31 && Build.VERSION.SDK_INT >= 31 && BaseApplication.getContext().checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) != 0) || !f262173b || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null || !defaultAdapter.isEnabled() || defaultAdapter.getProfileConnectionState(1) != 2 || defaultAdapter.getProfileConnectionState(2) == 2 || f262172a.contains(Integer.valueOf(f262174c)) || f262175d || audioManager.isBluetoothScoOn() || !audioManager.isBluetoothScoAvailableOffCall()) {
            return false;
        }
        return true;
    }

    public static void i(final boolean z16, final AppRuntime appRuntime) {
        if (appRuntime == null) {
            return;
        }
        f262176e.set(z16);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqaudio.audioplayer.b
            @Override // java.lang.Runnable
            public final void run() {
                c.g(AppRuntime.this, z16);
            }
        }, 16, null, false);
        if (QLog.isColorLevel()) {
            QLog.d("AudioDeviceHelper", 2, "setLoudSpeakerState:" + z16);
        }
    }
}
