package com.tencent.localedit;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.localedit.fakenative.meta.ChunkConvertResult;
import com.tencent.localedit.nativeengine.FileLoadCallback;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JNI {
    public static native String ImportExport(int i3, int i16, int i17, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6);

    public static native ChunkConvertResult chunkImport(int i3, int i16, @NonNull String str);

    public static native void initChunkConverter(int i3, int i16, int i17, @NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5);

    public static native void initEditor(long j3, long j16, int i3, boolean z16, String str);

    public static native void loadLocalFile(String str, long j3, String str2, String str3, FileLoadCallback fileLoadCallback);

    public static native void releaseChunkConverter(@NonNull String str);

    public static native void releaseEditor(long j3, int i3);

    public static native void setFrame(long j3, RectF rectF);

    public static native void setScale(long j3, double d16, double d17, double d18);
}
