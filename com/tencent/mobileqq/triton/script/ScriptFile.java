package com.tencent.mobileqq.triton.script;

import com.tencent.aelight.camera.constants.AECameraConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/script/ScriptFile;", "", "()V", "valid", "", "getValid", "()Z", AECameraConstants.REQ_FIELD_FONT_CONTENT, "Path", "Lcom/tencent/mobileqq/triton/script/ScriptFile$Path;", "Lcom/tencent/mobileqq/triton/script/ScriptFile$Content;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public abstract class ScriptFile {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/triton/script/ScriptFile$Content;", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "name", "", "content", "codeCache", "Ljava/io/File;", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V", "getCodeCache", "()Ljava/io/File;", "getContent", "()Ljava/lang/String;", "getName", "valid", "", "getValid", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final /* data */ class Content extends ScriptFile {

        @Nullable
        private final File codeCache;

        @NotNull
        private final String content;

        @NotNull
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Content(@NotNull String name, @NotNull String content, @Nullable File file) {
            super(null);
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(content, "content");
            this.name = name;
            this.content = content;
            this.codeCache = file;
        }

        public static /* synthetic */ Content copy$default(Content content, String str, String str2, File file, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = content.name;
            }
            if ((i3 & 2) != 0) {
                str2 = content.content;
            }
            if ((i3 & 4) != 0) {
                file = content.codeCache;
            }
            return content.copy(str, str2, file);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final File getCodeCache() {
            return this.codeCache;
        }

        @NotNull
        public final Content copy(@NotNull String name, @NotNull String content, @Nullable File codeCache) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(content, "content");
            return new Content(name, content, codeCache);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Content) {
                    Content content = (Content) other;
                    if (!Intrinsics.areEqual(this.name, content.name) || !Intrinsics.areEqual(this.content, content.content) || !Intrinsics.areEqual(this.codeCache, content.codeCache)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @Nullable
        public final File getCodeCache() {
            return this.codeCache;
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Override // com.tencent.mobileqq.triton.script.ScriptFile
        public boolean getValid() {
            if (this.content.length() > 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int i16;
            String str = this.name;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = i3 * 31;
            String str2 = this.content;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            File file = this.codeCache;
            if (file != null) {
                i17 = file.hashCode();
            }
            return i19 + i17;
        }

        @NotNull
        public String toString() {
            return "Content(name=" + this.name + ", content=" + this.content + ", codeCache=" + this.codeCache + ")";
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/triton/script/ScriptFile$Path;", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "name", "", "path", "Ljava/io/File;", "codeCache", "(Ljava/lang/String;Ljava/io/File;Ljava/io/File;)V", "getCodeCache", "()Ljava/io/File;", "getName", "()Ljava/lang/String;", "getPath", "valid", "", "getValid", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final /* data */ class Path extends ScriptFile {

        @Nullable
        private final File codeCache;

        @NotNull
        private final String name;

        @NotNull
        private final File path;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Path(@NotNull String name, @NotNull File path, @Nullable File file) {
            super(null);
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(path, "path");
            this.name = name;
            this.path = path;
            this.codeCache = file;
        }

        public static /* synthetic */ Path copy$default(Path path, String str, File file, File file2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = path.name;
            }
            if ((i3 & 2) != 0) {
                file = path.path;
            }
            if ((i3 & 4) != 0) {
                file2 = path.codeCache;
            }
            return path.copy(str, file, file2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final File getPath() {
            return this.path;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final File getCodeCache() {
            return this.codeCache;
        }

        @NotNull
        public final Path copy(@NotNull String name, @NotNull File path, @Nullable File codeCache) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(path, "path");
            return new Path(name, path, codeCache);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Path) {
                    Path path = (Path) other;
                    if (!Intrinsics.areEqual(this.name, path.name) || !Intrinsics.areEqual(this.path, path.path) || !Intrinsics.areEqual(this.codeCache, path.codeCache)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @Nullable
        public final File getCodeCache() {
            return this.codeCache;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final File getPath() {
            return this.path;
        }

        @Override // com.tencent.mobileqq.triton.script.ScriptFile
        public boolean getValid() {
            if (this.path.exists() && this.path.length() > 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int i16;
            String str = this.name;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = i3 * 31;
            File file = this.path;
            if (file != null) {
                i16 = file.hashCode();
            } else {
                i16 = 0;
            }
            int i19 = (i18 + i16) * 31;
            File file2 = this.codeCache;
            if (file2 != null) {
                i17 = file2.hashCode();
            }
            return i19 + i17;
        }

        @NotNull
        public String toString() {
            return "Path(name=" + this.name + ", path=" + this.path + ", codeCache=" + this.codeCache + ")";
        }
    }

    ScriptFile() {
    }

    public abstract boolean getValid();

    public /* synthetic */ ScriptFile(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
