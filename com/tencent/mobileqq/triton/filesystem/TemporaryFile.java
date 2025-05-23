package com.tencent.mobileqq.triton.filesystem;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/TemporaryFile;", "", "file", "Ljava/io/File;", "pathInGame", "", "(Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getPathInGame", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class TemporaryFile {

    @NotNull
    private final File file;

    @NotNull
    private final String pathInGame;

    public TemporaryFile(@NotNull File file, @NotNull String pathInGame) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        Intrinsics.checkParameterIsNotNull(pathInGame, "pathInGame");
        this.file = file;
        this.pathInGame = pathInGame;
    }

    public static /* synthetic */ TemporaryFile copy$default(TemporaryFile temporaryFile, File file, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            file = temporaryFile.file;
        }
        if ((i3 & 2) != 0) {
            str = temporaryFile.pathInGame;
        }
        return temporaryFile.copy(file, str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getPathInGame() {
        return this.pathInGame;
    }

    @NotNull
    public final TemporaryFile copy(@NotNull File file, @NotNull String pathInGame) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        Intrinsics.checkParameterIsNotNull(pathInGame, "pathInGame");
        return new TemporaryFile(file, pathInGame);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof TemporaryFile) {
                TemporaryFile temporaryFile = (TemporaryFile) other;
                if (!Intrinsics.areEqual(this.file, temporaryFile.file) || !Intrinsics.areEqual(this.pathInGame, temporaryFile.pathInGame)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @NotNull
    public final String getPathInGame() {
        return this.pathInGame;
    }

    public int hashCode() {
        int i3;
        File file = this.file;
        int i16 = 0;
        if (file != null) {
            i3 = file.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str = this.pathInGame;
        if (str != null) {
            i16 = str.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "TemporaryFile(file=" + this.file + ", pathInGame=" + this.pathInGame + ")";
    }
}
