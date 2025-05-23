package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.v8rt.engine.JsRuntimeLoader;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \"2\u00020\u0001:\u0004\"#$%J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "environment", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "getEnvironment", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "gameConfig", "", "getGameConfig", "()Ljava/lang/String;", "id", "getId", "name", "getName", "optionConfig", "", "", "getOptionConfig", "()Ljava/util/Map;", "orientation", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "getOrientation", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "plugins", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "getPlugins", "()Ljava/util/List;", "version", "getVersion", "getSubpackage", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "Companion", "Environment", "Orientation", "SubpackageListener", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface GamePackage extends ScriptPackage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0098\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u001326\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0017\u0012\b\b\u0007\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0017\u0012\b\b\u0007\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "id", "", "name", "packageDir", "Ljava/io/File;", "gameConfigContent", "orientation", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "version", "environment", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "optionConfig", "", "plugins", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "subPackageDownloader", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "callback", "", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        @NotNull
        public final GamePackage create(@NotNull final String id5, @NotNull final String name, @NotNull final File packageDir, @NotNull final String gameConfigContent, @NotNull final Orientation orientation, @NotNull final String version, @NotNull final Environment environment, @NotNull final Map<String, ? extends Object> optionConfig, @NotNull final List<? extends GamePluginPackage> plugins, @NotNull final Function2<? super String, ? super SubpackageListener, Unit> subPackageDownloader) {
            Intrinsics.checkParameterIsNotNull(id5, "id");
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(packageDir, "packageDir");
            Intrinsics.checkParameterIsNotNull(gameConfigContent, "gameConfigContent");
            Intrinsics.checkParameterIsNotNull(orientation, "orientation");
            Intrinsics.checkParameterIsNotNull(version, "version");
            Intrinsics.checkParameterIsNotNull(environment, "environment");
            Intrinsics.checkParameterIsNotNull(optionConfig, "optionConfig");
            Intrinsics.checkParameterIsNotNull(plugins, "plugins");
            Intrinsics.checkParameterIsNotNull(subPackageDownloader, "subPackageDownloader");
            return new GamePackage(packageDir, subPackageDownloader, name, id5, version, gameConfigContent, orientation, environment, optionConfig, plugins) { // from class: com.tencent.mobileqq.triton.filesystem.GamePackage$Companion$create$1
                final /* synthetic */ GamePackage.Environment $environment;
                final /* synthetic */ String $gameConfigContent;
                final /* synthetic */ String $id;
                final /* synthetic */ String $name;
                final /* synthetic */ Map $optionConfig;
                final /* synthetic */ GamePackage.Orientation $orientation;
                final /* synthetic */ File $packageDir;
                final /* synthetic */ List $plugins;
                final /* synthetic */ Function2 $subPackageDownloader;
                final /* synthetic */ String $version;

                @NotNull
                private final GamePackage.Environment environment;

                @NotNull
                private final String gameConfig;

                @NotNull
                private final String id;

                @NotNull
                private final String name;

                @NotNull
                private final Map<String, Object> optionConfig;

                @NotNull
                private final GamePackage.Orientation orientation;

                @NotNull
                private final List<GamePluginPackage> plugins;

                @NotNull
                private final String version;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$name = name;
                    this.$id = id5;
                    this.$version = version;
                    this.$gameConfigContent = gameConfigContent;
                    this.$orientation = orientation;
                    this.$environment = environment;
                    this.$optionConfig = optionConfig;
                    this.$plugins = plugins;
                    this.id = id5;
                    this.name = name;
                    this.gameConfig = gameConfigContent;
                    this.orientation = orientation;
                    this.environment = environment;
                    this.optionConfig = optionConfig;
                    this.version = version;
                    this.plugins = plugins;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
                @NotNull
                public GamePackage.Environment getEnvironment() {
                    return this.environment;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
                @NotNull
                public String getGameConfig() {
                    return this.gameConfig;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
                @NotNull
                public String getId() {
                    return this.id;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
                @NotNull
                public String getName() {
                    return this.name;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
                @NotNull
                public Map<String, Object> getOptionConfig() {
                    return this.optionConfig;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
                @NotNull
                public GamePackage.Orientation getOrientation() {
                    return this.orientation;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
                @NotNull
                public List<GamePluginPackage> getPlugins() {
                    return this.plugins;
                }

                @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
                @NotNull
                public ScriptFile getScript(@NotNull String name2) {
                    Intrinsics.checkParameterIsNotNull(name2, "name");
                    return new ScriptFile.Path(name2, new File(this.$packageDir, name2), new File(this.$packageDir, name2 + JsRuntimeLoader.CODE_CACHE_SUFFIX));
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
                public void getSubpackage(@NotNull String name2, @NotNull GamePackage.SubpackageListener callback) {
                    Intrinsics.checkParameterIsNotNull(name2, "name");
                    Intrinsics.checkParameterIsNotNull(callback, "callback");
                    this.$subPackageDownloader.invoke(name2, callback);
                }

                @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
                @NotNull
                public String getVersion() {
                    return this.version;
                }

                @NotNull
                public String toString() {
                    return "GamePackage{" + this.$name + TokenParser.SP + this.$id + TokenParser.SP + this.$version + '}';
                }
            };
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "", "environment", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEnvironment", "()Ljava/lang/String;", "DEVELOP", "TRIAL", "RELEASE", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public enum Environment {
        DEVELOP("develop"),
        TRIAL("trial"),
        RELEASE("release");


        @NotNull
        private final String environment;

        Environment(String str) {
            this.environment = str;
        }

        @NotNull
        public final String getEnvironment() {
            return this.environment;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "", "(Ljava/lang/String;I)V", "PORTRAIT", "LANDSCAPE", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public enum Orientation {
        PORTRAIT,
        LANDSCAPE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "", "onComplete", "", "result", "Lkotlin/Result;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "(Ljava/lang/Object;)V", "onProgress", "totalBytes", "", "currentBytes", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public interface SubpackageListener {
        void onComplete(@NotNull Object result);

        void onProgress(long totalBytes, long currentBytes);
    }

    @NotNull
    Environment getEnvironment();

    @NotNull
    String getGameConfig();

    @NotNull
    String getId();

    @NotNull
    String getName();

    @NotNull
    Map<String, Object> getOptionConfig();

    @NotNull
    Orientation getOrientation();

    @NotNull
    List<GamePluginPackage> getPlugins();

    void getSubpackage(@NotNull String name, @NotNull SubpackageListener callback);

    @NotNull
    String getVersion();
}
