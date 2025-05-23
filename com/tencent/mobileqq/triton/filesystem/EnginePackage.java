package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.model.Version;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.v8rt.engine.JsRuntimeLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "engineJar", "Ljava/io/File;", "getEngineJar", "()Ljava/io/File;", "globalConfig", "", "getGlobalConfig", "()Ljava/lang/String;", "version", "Lcom/tencent/mobileqq/triton/model/Version;", "getVersion", "()Lcom/tencent/mobileqq/triton/model/Version;", "getEngineNativeLibrary", "name", "Companion", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface EnginePackage extends ScriptPackage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/EnginePackage$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "baseLibDir", "Ljava/io/File;", "version", "Lcom/tencent/mobileqq/triton/model/Version;", "soDir", "jarFile", "globalConfig", "", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        public static /* synthetic */ EnginePackage create$default(Companion companion, File file, Version version, File file2, File file3, String str, int i3, Object obj) {
            File file4;
            File file5;
            String str2;
            if ((i3 & 4) != 0) {
                file4 = null;
            } else {
                file4 = file2;
            }
            if ((i3 & 8) != 0) {
                file5 = null;
            } else {
                file5 = file3;
            }
            if ((i3 & 16) != 0) {
                str2 = null;
            } else {
                str2 = str;
            }
            return companion.create(file, version, file4, file5, str2);
        }

        @NotNull
        public final EnginePackage create(@NotNull final File baseLibDir, @NotNull final Version version, @Nullable final File soDir, @Nullable final File jarFile, @Nullable final String globalConfig) {
            Intrinsics.checkParameterIsNotNull(baseLibDir, "baseLibDir");
            Intrinsics.checkParameterIsNotNull(version, "version");
            return new EnginePackage(soDir, baseLibDir, jarFile, version, globalConfig) { // from class: com.tencent.mobileqq.triton.filesystem.EnginePackage$Companion$create$1
                final /* synthetic */ File $baseLibDir;
                final /* synthetic */ String $globalConfig;
                final /* synthetic */ File $jarFile;
                final /* synthetic */ File $soDir;
                final /* synthetic */ Version $version;

                @Nullable
                private final File engineJar;

                @Nullable
                private final String globalConfig;

                @NotNull
                private final Version version;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$jarFile = jarFile;
                    this.$version = version;
                    this.$globalConfig = globalConfig;
                    this.engineJar = jarFile;
                    this.version = version;
                    this.globalConfig = globalConfig;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
                @Nullable
                public File getEngineJar() {
                    return this.engineJar;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
                @Nullable
                public File getEngineNativeLibrary(@NotNull String name) {
                    Intrinsics.checkParameterIsNotNull(name, "name");
                    if (this.$soDir == null) {
                        return null;
                    }
                    File file = new File(this.$soDir, System.mapLibraryName(name));
                    if (!file.exists()) {
                        return null;
                    }
                    return file;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
                @Nullable
                public String getGlobalConfig() {
                    return this.globalConfig;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
                @NotNull
                public ScriptFile getScript(@NotNull String name) {
                    Intrinsics.checkParameterIsNotNull(name, "name");
                    return new ScriptFile.Path(name, new File(this.$baseLibDir, name), new File(this.$baseLibDir, name + JsRuntimeLoader.CODE_CACHE_SUFFIX));
                }

                @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
                @NotNull
                public Version getVersion() {
                    return this.version;
                }
            };
        }
    }

    @Nullable
    File getEngineJar();

    @Nullable
    File getEngineNativeLibrary(@NotNull String name);

    @Nullable
    String getGlobalConfig();

    @NotNull
    Version getVersion();
}
