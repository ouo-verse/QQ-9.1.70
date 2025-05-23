package com.tencent.av.compat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.os.Vibrator;
import com.tencent.av.utils.AVUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    @SuppressLint({"NewApi"})
    public static AudioAttributes a() {
        if (AVUtil.p()) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setUsage(6);
            builder.setContentType(0);
            return builder.build();
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static void b(Context context, long j3) {
        Vibrator vibrator;
        AudioAttributes audioAttributes = null;
        if (context == null) {
            vibrator = null;
        } else {
            vibrator = (Vibrator) context.getSystemService("vibrator");
        }
        if (vibrator != null) {
            audioAttributes = a();
            if (audioAttributes == null) {
                vibrator.vibrate(j3);
            } else {
                vibrator.vibrate(j3, audioAttributes);
            }
            if (!vibrator.hasVibrator()) {
                QLog.e("VibratorCompactUtil", 1, "vibrate failed: has no Vibrator");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("VibratorCompactUtil", 2, "vibrate, audioAttributes[" + audioAttributes + "], vibrate[" + vibrator + "], milliseconds[" + j3 + "]");
        }
    }

    @SuppressLint({"NewApi"})
    public static void c(Context context, long[] jArr, int i3) {
        Vibrator vibrator;
        AudioAttributes audioAttributes = null;
        if (context == null) {
            vibrator = null;
        } else {
            vibrator = (Vibrator) context.getSystemService("vibrator");
        }
        if (vibrator != null) {
            audioAttributes = a();
            if (audioAttributes == null) {
                vibrator.vibrate(jArr, i3);
            } else {
                vibrator.vibrate(jArr, i3, audioAttributes);
            }
            if (!vibrator.hasVibrator()) {
                QLog.e("VibratorCompactUtil", 1, "vibrate failed: has no Vibrator");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("VibratorCompactUtil", 2, "vibrate, audioAttributes[" + audioAttributes + "], vibrate[" + vibrator + "]");
        }
    }
}
