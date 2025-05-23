package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;

/* loaded from: classes5.dex */
public class ProgressTracer {
    public static final int CANCEL = 1003;
    public static final int DECODE_FAIL = 1002;
    public static final int DOWNLOAD_FAIL = 1001;
    public static final int END = 5;
    public static final int END_CALLBACK_UI = 6;
    public static final int END_DECODE = 4;
    public static final int END_DOWNLOAD = 2;
    public static final int END_SUPER_RESOLUTION = 9;
    public static final int PUT_SUPER_RESOLUTION = 7;
    public static final String SEPARATOR = " : ";
    public static final int START = 0;
    public static final int START_DECODE = 3;
    public static final int START_DOWNLOAD = 1;
    public static final int START_SUPER_RESOLUTION = 8;
    public static final String TAG = "IProgress";

    public static void print(int i3, String str) {
        if (ImageManagerEnv.g().openProgressTracer()) {
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
                switch (i3) {
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        break;
                    default:
                        switch (i3) {
                            case 1001:
                            case 1002:
                                ImageManagerEnv.getLogger().e(TAG, Long.valueOf(System.currentTimeMillis()), SEPARATOR, Integer.valueOf(i3), SEPARATOR, str);
                                return;
                            case 1003:
                                ImageManagerEnv.getLogger().w(TAG, Long.valueOf(System.currentTimeMillis()), SEPARATOR, Integer.valueOf(i3), SEPARATOR, str);
                                return;
                            default:
                                ImageManagerEnv.getLogger().e(TAG, Long.valueOf(System.currentTimeMillis()), SEPARATOR, Integer.valueOf(i3), "error function call, please check");
                                return;
                        }
                }
            }
            ImageManagerEnv.getLogger().i(TAG, Long.valueOf(System.currentTimeMillis()), SEPARATOR, Integer.valueOf(i3), SEPARATOR, str);
        }
    }

    public static void printI(Object... objArr) {
        if (ImageManagerEnv.g().openProgressTracer()) {
            ImageManagerEnv.getLogger().i(TAG, objArr);
        }
    }
}
