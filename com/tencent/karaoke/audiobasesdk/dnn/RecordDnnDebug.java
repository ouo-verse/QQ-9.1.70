package com.tencent.karaoke.audiobasesdk.dnn;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003R\u0014\u0010\u0005\u001a\u00020\u0003X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/karaoke/audiobasesdk/dnn/RecordDnnDebug;", "", "savePath", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "enableDebug", "", "getEnableDebug", "()Z", "setEnableDebug", "(Z)V", "logFile", "Ljava/io/RandomAccessFile;", "getSavePath", "", "enable", "release", "writeLog", "log", "lib_audiobasesdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class RecordDnnDebug {

    @NotNull
    private final String TAG;
    private boolean enableDebug;
    private RandomAccessFile logFile;

    @NotNull
    private final String savePath;

    public RecordDnnDebug(@NotNull String savePath) {
        Intrinsics.checkParameterIsNotNull(savePath, "savePath");
        this.savePath = savePath;
        this.TAG = "RecordDnnDebug";
    }

    public final void enableDebug(boolean enable) {
        this.enableDebug = enable;
        if (enable) {
            this.logFile = new RandomAccessFile(this.savePath, "rw");
        }
    }

    public final boolean getEnableDebug() {
        return this.enableDebug;
    }

    @NotNull
    public final String getSavePath() {
        return this.savePath;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    public final void release() {
        try {
            if (this.enableDebug) {
                RandomAccessFile randomAccessFile = this.logFile;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.logFile = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void setEnableDebug(boolean z16) {
        this.enableDebug = z16;
    }

    public final void writeLog(@Nullable String log) {
        byte[] bArr;
        try {
            if (this.enableDebug) {
                RandomAccessFile randomAccessFile = this.logFile;
                if (randomAccessFile != null) {
                    if (log != null) {
                        bArr = log.getBytes(Charsets.UTF_8);
                        Intrinsics.checkExpressionValueIsNotNull(bArr, "(this as java.lang.String).getBytes(charset)");
                    } else {
                        bArr = null;
                    }
                    randomAccessFile.write(bArr);
                }
                RandomAccessFile randomAccessFile2 = this.logFile;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.writeChars("\n");
                }
            }
        } catch (Exception unused) {
        }
    }
}
