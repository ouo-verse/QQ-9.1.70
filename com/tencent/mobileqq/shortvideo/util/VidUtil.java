package com.tencent.mobileqq.shortvideo.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VidUtil {
    private static final SimpleDateFormat sVidSimpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINESE);

    public static String generateVid() {
        String str;
        SimpleDateFormat simpleDateFormat = sVidSimpleDateFormat;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(new Date()) + "_" + new Random().nextInt(10000);
        }
        return str;
    }

    public static String getVidFromSourceDirFile(File file) {
        if (file == null) {
            return null;
        }
        return file.getName();
    }
}
