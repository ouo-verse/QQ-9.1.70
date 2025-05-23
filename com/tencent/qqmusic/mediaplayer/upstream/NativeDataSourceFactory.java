package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NativeDataSourceFactory {
    private static final String TAG = "NativeDataSourceFactory";
    private static final boolean soLoaded;

    static {
        boolean loadAll = NativeLibs.loadAll(Arrays.asList(NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni, NativeLibs.cppShared, NativeLibs.stlportShared, NativeLibs.xlog, NativeLibs.xFFmpeg));
        soLoaded = loadAll;
        if (!loadAll) {
            Logger.e(TAG, "[static initializer] failed to load so!");
        }
    }

    public static INativeDataSource fileDataSource(final String str) throws UnsatisfiedLinkError {
        return new INativeDataSource() { // from class: com.tencent.qqmusic.mediaplayer.upstream.NativeDataSourceFactory.1
            @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
            public AudioFormat.AudioType getAudioType() throws IOException {
                return null;
            }

            @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
            public long getNativeInstance() {
                if (NativeDataSourceFactory.soLoaded) {
                    try {
                        return NativeDataSourceFactory.localFile(str, 0);
                    } catch (Throwable th5) {
                        Logger.e(NativeDataSourceFactory.TAG, "[getNativeInstance] failed to create native data source!", th5);
                        return 0L;
                    }
                }
                Logger.w(NativeDataSourceFactory.TAG, "[getNativeInstance] so not loaded properly!");
                return 0L;
            }
        };
    }

    public static native long localFile(String str, int i3);

    public static INativeDataSource fileDataSource(final String str, final int i3) throws UnsatisfiedLinkError {
        return new INativeDataSource() { // from class: com.tencent.qqmusic.mediaplayer.upstream.NativeDataSourceFactory.2
            @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
            public AudioFormat.AudioType getAudioType() throws IOException {
                return null;
            }

            @Override // com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource
            public long getNativeInstance() {
                int i16;
                if (NativeDataSourceFactory.soLoaded) {
                    try {
                        String str2 = str;
                        if (i3 > 0) {
                            i16 = 1;
                        } else {
                            i16 = 0;
                        }
                        return NativeDataSourceFactory.localFile(str2, i16);
                    } catch (Throwable th5) {
                        Logger.e(NativeDataSourceFactory.TAG, "[getNativeInstance] failed to create native data source!", th5);
                        return 0L;
                    }
                }
                Logger.w(NativeDataSourceFactory.TAG, "[getNativeInstance] so not loaded properly!");
                return 0L;
            }
        };
    }
}
