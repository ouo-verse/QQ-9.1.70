package com.tencent.aelight.camera.ae.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.config.AppSetting;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {
    private static String[] a(String[] strArr, int i3) {
        return strArr.length > i3 ? (String[]) Arrays.copyOf(strArr, i3) : strArr;
    }

    public static boolean c(String str, String str2) {
        String str3 = AppSetting.f99551k;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            String[] split3 = str3.split("\\.");
            int min = Math.min(split.length, Math.min(split2.length, split3.length));
            String[] a16 = a(split, min);
            String[] a17 = a(split2, min);
            String[] a18 = a(split3, min);
            for (int i3 = 0; i3 < a18.length; i3++) {
                int h16 = h(a18[i3]);
                if (a16.length <= i3 || a17.length <= i3) {
                    break;
                }
                int h17 = h(a16[i3]);
                int h18 = h(a17[i3]);
                if (h16 < 0) {
                    break;
                }
                if ((h16 >= h17 && h16 < h18) || (h16 < h17 && h16 >= h18)) {
                    return true;
                }
                if (h16 != h17 && h16 != h18) {
                    break;
                }
                if (i3 == a18.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d() {
        e();
        return false;
    }

    private static boolean e() {
        String str = Build.MANUFACTURER;
        return str != null && "oppo".equals(str.toLowerCase());
    }

    private static int h(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return Integer.MIN_VALUE;
        }
    }

    public static boolean f(Context context, File file) {
        if (file == null || file.getAbsolutePath() == null || context == null) {
            return false;
        }
        return file.getAbsolutePath().contains(context.getPackageName());
    }

    public static boolean b(Intent intent, String str) {
        if (intent == null) {
            return true;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            ms.a.a(str, "getAudioEnable bundle == null");
            return true;
        }
        if (extras.containsKey(PeakConstants.ARG_AUDIO)) {
            ms.a.f(str, "getAudioEnable bundle has key");
            return intent.getExtras().getBoolean(PeakConstants.ARG_AUDIO, true);
        }
        HashMap hashMap = (HashMap) intent.getSerializableExtra("key_attrs");
        if (hashMap == null || !hashMap.containsKey(PeakConstants.USE_AUDIO)) {
            return true;
        }
        ms.a.f(str, "getAudioEnable mKeyAttrs has key");
        return "1".equals(hashMap.get(PeakConstants.USE_AUDIO));
    }

    public static boolean g(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return false;
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        return rawY >= ((float) i16) && rawY <= ((float) (view.getMeasuredHeight() + i16)) && rawX >= ((float) i3) && rawX <= ((float) (view.getMeasuredWidth() + i3));
    }
}
