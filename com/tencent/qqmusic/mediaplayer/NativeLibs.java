package com.tencent.qqmusic.mediaplayer;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public enum NativeLibs {
    nlog("NLog", 1),
    audioCommon("audio_common", 1),
    QmNativeDataSource("QmNativeDataSource", 1),
    formatDetector("FormatDetector", 1),
    codecFactory("codec_factory", 3),
    decoderJni("qqmusic_decoder_jni", 3),
    xFFmpeg("xffmpeg", 3),
    cppShared("c++_shared", 3),
    stlportShared("stlport_shared", 3),
    xlog("wechatxlog", 3);

    private static final SparseArray<String> SUFFIX;
    private static final String TAG = "NativeLibs";
    private boolean mHasLoadSoSuccess;
    private final String name;
    private final long supportedAbi;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        SUFFIX = sparseArray;
        sparseArray.put(1, "");
        sparseArray.put(2, "");
    }

    NativeLibs(String str, long j3) {
        this.name = str;
        this.supportedAbi = j3;
    }

    public static boolean loadAll(NativeLibs... nativeLibsArr) {
        return loadAll(Arrays.asList(nativeLibsArr));
    }

    private boolean loadLibrary(String str) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Logger.i(TAG, "[loadLibrary] loading: " + str);
            z16 = AudioPlayerConfigure.getSoLibraryLoader().load(str);
        } catch (Throwable th5) {
            Logger.e(TAG, "[loadLibrary] failed: " + str, th5);
        }
        if (z16) {
            Logger.i(TAG, "[loadLibrary] succeed: " + str);
        } else {
            Logger.e(TAG, "[loadLibrary] failed: " + str);
        }
        return z16;
    }

    public String getName() {
        return this.name;
    }

    public boolean load() {
        if (this.mHasLoadSoSuccess) {
            return true;
        }
        boolean loadLibrary = loadLibrary(getName());
        this.mHasLoadSoSuccess = loadLibrary;
        return loadLibrary;
    }

    public boolean supportAbi(int i3) {
        long j3 = i3;
        if ((this.supportedAbi & j3) == j3) {
            return true;
        }
        return false;
    }

    public static boolean loadAll(Iterable<NativeLibs> iterable) {
        Iterator<NativeLibs> it = iterable.iterator();
        while (it.hasNext()) {
            if (!it.next().load()) {
                return false;
            }
        }
        return true;
    }
}
