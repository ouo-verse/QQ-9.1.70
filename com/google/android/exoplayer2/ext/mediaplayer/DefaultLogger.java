package com.google.android.exoplayer2.ext.mediaplayer;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DefaultLogger implements ILogger {
    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARN = 5;
    public static final int LOG_TEXT_MAX_LENGTH = 1000;
    public static final String TAG = "OskPlayer";

    private static List<String> splitEqually(String str, int i3) {
        ArrayList arrayList = new ArrayList(((str.length() + i3) - 1) / i3);
        int i16 = 0;
        while (i16 < str.length()) {
            int i17 = i16 + i3;
            arrayList.add(str.substring(i16, Math.min(str.length(), i17)));
            i16 = i17;
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int d(String str, String str2) {
        if (str2.length() > 1000) {
            return log(3, str, splitEqually(str2, 1000));
        }
        return Log.d("OskPlayer/" + str, str2);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int e(String str, String str2) {
        if (str2.length() > 1000) {
            return log(6, str, splitEqually(str2, 1000));
        }
        return Log.e("OskPlayer/" + str, str2);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int i(String str, String str2) {
        if (str2.length() > 1000) {
            return log(4, str, splitEqually(str2, 1000));
        }
        return Log.i("OskPlayer/" + str, str2);
    }

    public int log(int i3, String str, List<String> list) {
        for (String str2 : list) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 == 6) {
                                e(str, str2);
                            }
                        } else {
                            w(str, str2);
                        }
                    } else {
                        i(str, str2);
                    }
                } else {
                    d(str, str2);
                }
            } else {
                v(str, str2);
            }
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int v(String str, String str2) {
        if (str2.length() > 1000) {
            return log(2, str, splitEqually(str2, 1000));
        }
        return Log.v("OskPlayer/" + str, str2);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int w(String str, String str2) {
        if (str2.length() > 1000) {
            return log(5, str, splitEqually(str2, 1000));
        }
        return Log.w("OskPlayer/" + str, str2);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int d(String str, String str2, Throwable th5) {
        if (str2.length() > 1000) {
            return log(3, str, splitEqually(str2, 1000));
        }
        return Log.d("OskPlayer/" + str, str2, th5);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int e(String str, String str2, Throwable th5) {
        if (str2.length() > 1000) {
            return log(6, str, splitEqually(str2, 1000));
        }
        return Log.e("OskPlayer/" + str, str2, th5);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int i(String str, String str2, Throwable th5) {
        if (str2.length() > 1000) {
            return log(4, str, splitEqually(str2, 1000));
        }
        return Log.i("OskPlayer/" + str, str2, th5);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int v(String str, String str2, Throwable th5) {
        if (str2.length() > 1000) {
            return log(2, str, splitEqually(str2, 1000));
        }
        return Log.v("OskPlayer/" + str, str2, th5);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int w(String str, String str2, Throwable th5) {
        if (str2.length() > 1000) {
            return log(5, str, splitEqually(str2, 1000));
        }
        return Log.w("OskPlayer/" + str, str2, th5);
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int w(String str, Throwable th5) {
        return Log.w("OskPlayer/" + str, th5);
    }
}
