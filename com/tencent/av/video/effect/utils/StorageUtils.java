package com.tencent.av.video.effect.utils;

import android.os.Environment;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StorageUtils {
    public static String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String VIDEO_EFFECT_PATH = SDCARD_ROOT + "/VideoEffectSDK/";
}
