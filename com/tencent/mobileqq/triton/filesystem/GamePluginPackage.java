package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.v8rt.engine.JsRuntimeLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "version", "getVersion", "Companion", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface GamePluginPackage extends ScriptPackage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "name", "", "id", "version", "packageDir", "Ljava/io/File;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        @NotNull
        public final GamePluginPackage create(@NotNull final String name, @NotNull final String id5, @NotNull final String version, @NotNull final File packageDir) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(id5, "id");
            Intrinsics.checkParameterIsNotNull(version, "version");
            Intrinsics.checkParameterIsNotNull(packageDir, "packageDir");
            return new GamePluginPackage(packageDir, name, id5, version) { // from class: com.tencent.mobileqq.triton.filesystem.GamePluginPackage$Companion$create$1
                final /* synthetic */ String $id;
                final /* synthetic */ String $name;
                final /* synthetic */ File $packageDir;
                final /* synthetic */ String $version;

                @NotNull
                private final String id;

                @NotNull
                private final String name;

                @NotNull
                private final String version;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$name = name;
                    this.$id = id5;
                    this.$version = version;
                    this.id = id5;
                    this.name = name;
                    this.version = version;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePluginPackage
                @NotNull
                public String getId() {
                    return this.id;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePluginPackage
                @NotNull
                public String getName() {
                    return this.name;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePluginPackage
                @NotNull
                public String getVersion() {
                    return this.version;
                }

                @NotNull
                public String toString() {
                    return "GamePluginPackage{ " + this.$name + TokenParser.SP + this.$id + TokenParser.SP + this.$version + " }";
                }

                @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
                @NotNull
                public ScriptFile.Path getScript(@NotNull String name2) {
                    Intrinsics.checkParameterIsNotNull(name2, "name");
                    return new ScriptFile.Path(name2, new File(this.$packageDir, name2), new File(this.$packageDir, name2 + JsRuntimeLoader.CODE_CACHE_SUFFIX));
                }
            };
        }
    }

    @NotNull
    String getId();

    @NotNull
    String getName();

    @NotNull
    String getVersion();
}
