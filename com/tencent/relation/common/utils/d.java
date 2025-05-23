package com.tencent.relation.common.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 31 || (context.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_SCAN) == 0 && context.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0 && context.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE) == 0)) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context) {
        int i3;
        if (context == null) {
            return false;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            i3 = defaultAdapter.getProfileConnectionState(2);
            int profileConnectionState = defaultAdapter.getProfileConnectionState(1);
            int profileConnectionState2 = defaultAdapter.getProfileConnectionState(3);
            if (i3 != 2) {
                if (profileConnectionState == 2) {
                    i3 = profileConnectionState;
                } else if (profileConnectionState2 == 2) {
                    i3 = profileConnectionState2;
                }
            }
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (i3 != -1 && (audioManager == null || !audioManager.isBluetoothA2dpOn())) {
                return false;
            }
            return true;
        }
        i3 = -1;
        AudioManager audioManager2 = (AudioManager) context.getSystemService("audio");
        if (i3 != -1) {
        }
        return true;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return ((AudioManager) context.getSystemService("audio")).isWiredHeadsetOn();
    }
}
