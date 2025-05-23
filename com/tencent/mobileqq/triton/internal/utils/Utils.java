package com.tencent.mobileqq.triton.internal.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePluginPackage;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000_\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0012\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086\b\u001a\"\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\tH\u0086\b\u00a2\u0006\u0002\u0010\n\u001a\u0006\u0010\u000b\u001a\u00020\u0003\u001a\u0006\u0010\f\u001a\u00020\u0003\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010\r\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0019\u0010\r\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u00a2\u0006\u0002\u0010\u0014\u001a$\u0010\r\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001a\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0005\u001a\u0012\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0017\u0010\u001e\u001a\u00020\u001d*\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0086\b\u00a8\u0006\""}, d2 = {"initAssertNotNullptr", "", "pointer", "", "name", "", "jniCall", "T", "call", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "nanoTime", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "decorate", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "com/tencent/mobileqq/triton/internal/utils/Utils$decorate$3", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "(Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;Z)Lcom/tencent/mobileqq/triton/internal/utils/Utils$decorate$3;", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "prefix", "decorateSubPackage", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "subPackageName", "onError", "Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "toTritonException", "", "error", "Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", "Triton_release"}, k = 2, mv = {1, 1, 16})
@JvmName(name = "Utils")
/* loaded from: classes19.dex */
public final class Utils {
    @NotNull
    public static final EnginePackage decorate(@NotNull final EnginePackage decorate, final boolean z16) {
        Intrinsics.checkParameterIsNotNull(decorate, "$this$decorate");
        return new EnginePackage(z16) { // from class: com.tencent.mobileqq.triton.internal.utils.Utils$decorate$1
            private final /* synthetic */ EnginePackage $$delegate_0;
            final /* synthetic */ boolean $enableCodeCache;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$enableCodeCache = z16;
                this.$$delegate_0 = EnginePackage.this;
            }

            @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
            @Nullable
            public File getEngineJar() {
                return this.$$delegate_0.getEngineJar();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
            @Nullable
            public File getEngineNativeLibrary(@NotNull String name) {
                Intrinsics.checkParameterIsNotNull(name, "name");
                return this.$$delegate_0.getEngineNativeLibrary(name);
            }

            @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
            @Nullable
            public String getGlobalConfig() {
                return this.$$delegate_0.getGlobalConfig();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
            @NotNull
            public ScriptFile getScript(@NotNull String name) {
                ScriptFile decorate2;
                Intrinsics.checkParameterIsNotNull(name, "name");
                decorate2 = Utils.decorate(EnginePackage.this.getScript(name), this.$enableCodeCache, Consts.GAME_SCRIPT_PREFIX_ENGINE, name);
                return decorate2;
            }

            @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
            @NotNull
            public Version getVersion() {
                return this.$$delegate_0.getVersion();
            }
        };
    }

    @NotNull
    public static final ScriptPackage decorateSubPackage(@NotNull final ScriptPackage decorateSubPackage, final boolean z16, @NotNull final String subPackageName) {
        Intrinsics.checkParameterIsNotNull(decorateSubPackage, "$this$decorateSubPackage");
        Intrinsics.checkParameterIsNotNull(subPackageName, "subPackageName");
        return new ScriptPackage() { // from class: com.tencent.mobileqq.triton.internal.utils.Utils$decorateSubPackage$1
            @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
            @NotNull
            public ScriptFile getScript(@NotNull String name) {
                ScriptFile decorate;
                Intrinsics.checkParameterIsNotNull(name, "name");
                decorate = Utils.decorate(ScriptPackage.this.getScript(name), z16, Consts.GAME_SCRIPT_PREFIX_SUB_PACKAGE + subPackageName + '/', name);
                return decorate;
            }
        };
    }

    public static final void initAssertNotNullptr(long j3, @NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        if (j3 != 0) {
            return;
        }
        throw new TritonInitException("pointer " + name + " is nullptr", ErrorCodes.NATIVE_FUNCTION_CALL, null, 4, null);
    }

    public static final <T> T jniCall(@NotNull Function0<? extends T> call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        try {
            return call.invoke();
        } catch (UnsatisfiedLinkError unused) {
            return call.invoke();
        }
    }

    public static final long nanoTime() {
        return System.nanoTime();
    }

    public static final void onError(@NotNull ErrorCallback onError, @NotNull TritonException exception) {
        Intrinsics.checkParameterIsNotNull(onError, "$this$onError");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        onError.onError(exception.getMessage(), exception);
    }

    public static final long timeStamp() {
        return SystemClock.uptimeMillis();
    }

    @NotNull
    public static final TritonException toTritonException(@NotNull Throwable toTritonException, @NotNull ErrorCodes error) {
        Intrinsics.checkParameterIsNotNull(toTritonException, "$this$toTritonException");
        Intrinsics.checkParameterIsNotNull(error, "error");
        if (toTritonException instanceof TritonException) {
            return (TritonException) toTritonException;
        }
        String message = toTritonException.getMessage();
        if (message == null) {
            message = "";
        }
        return new TritonException(message, error, toTritonException);
    }

    public static /* synthetic */ TritonException toTritonException$default(Throwable toTritonException, ErrorCodes error, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            error = ErrorCodes.UNKNOWN;
        }
        Intrinsics.checkParameterIsNotNull(toTritonException, "$this$toTritonException");
        Intrinsics.checkParameterIsNotNull(error, "error");
        if (toTritonException instanceof TritonException) {
            return (TritonException) toTritonException;
        }
        String message = toTritonException.getMessage();
        if (message == null) {
            message = "";
        }
        return new TritonException(message, error, toTritonException);
    }

    @NotNull
    public static final GamePackage decorate(@NotNull final GamePackage decorate, final boolean z16) {
        Intrinsics.checkParameterIsNotNull(decorate, "$this$decorate");
        return new GamePackage(z16) { // from class: com.tencent.mobileqq.triton.internal.utils.Utils$decorate$2
            private final /* synthetic */ GamePackage $$delegate_0;
            final /* synthetic */ boolean $enableCodeCache;

            @NotNull
            private final List<GamePluginPackage> plugins;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                int collectionSizeOrDefault;
                Utils$decorate$3 decorate2;
                this.$enableCodeCache = z16;
                this.$$delegate_0 = GamePackage.this;
                List<GamePluginPackage> plugins = GamePackage.this.getPlugins();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(plugins, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = plugins.iterator();
                while (it.hasNext()) {
                    decorate2 = Utils.decorate((GamePluginPackage) it.next(), this.$enableCodeCache);
                    arrayList.add(decorate2);
                }
                this.plugins = arrayList;
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
            @NotNull
            public GamePackage.Environment getEnvironment() {
                return this.$$delegate_0.getEnvironment();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
            @NotNull
            public String getGameConfig() {
                return this.$$delegate_0.getGameConfig();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
            @NotNull
            public String getId() {
                return this.$$delegate_0.getId();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
            @NotNull
            public String getName() {
                return this.$$delegate_0.getName();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
            @NotNull
            public Map<String, Object> getOptionConfig() {
                return this.$$delegate_0.getOptionConfig();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
            @NotNull
            public GamePackage.Orientation getOrientation() {
                return this.$$delegate_0.getOrientation();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
            @NotNull
            public List<GamePluginPackage> getPlugins() {
                return this.plugins;
            }

            @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
            @NotNull
            public ScriptFile getScript(@NotNull String name) {
                ScriptFile decorate2;
                Intrinsics.checkParameterIsNotNull(name, "name");
                decorate2 = Utils.decorate(GamePackage.this.getScript(name), this.$enableCodeCache, Consts.GAME_SCRIPT_PREFIX_GAME, name);
                return decorate2;
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
            public void getSubpackage(@NotNull String name, @NotNull GamePackage.SubpackageListener callback) {
                Intrinsics.checkParameterIsNotNull(name, "name");
                Intrinsics.checkParameterIsNotNull(callback, "callback");
                this.$$delegate_0.getSubpackage(name, callback);
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePackage
            @NotNull
            public String getVersion() {
                return this.$$delegate_0.getVersion();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScriptFile decorate(@NotNull ScriptFile scriptFile, boolean z16, String str, String str2) {
        if (scriptFile instanceof ScriptFile.Path) {
            ScriptFile.Path path = (ScriptFile.Path) scriptFile;
            return ScriptFile.Path.copy$default(path, str + str2, null, z16 ? path.getCodeCache() : null, 2, null);
        }
        if (scriptFile != null) {
            ScriptFile.Content content = (ScriptFile.Content) scriptFile;
            return ScriptFile.Content.copy$default(content, str + str2, null, z16 ? content.getCodeCache() : null, 2, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.triton.script.ScriptFile.Content");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.triton.internal.utils.Utils$decorate$3] */
    public static final Utils$decorate$3 decorate(@NotNull final GamePluginPackage gamePluginPackage, final boolean z16) {
        return new GamePluginPackage(z16) { // from class: com.tencent.mobileqq.triton.internal.utils.Utils$decorate$3
            private final /* synthetic */ GamePluginPackage $$delegate_0;
            final /* synthetic */ boolean $enableCodeCache;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$enableCodeCache = z16;
                this.$$delegate_0 = GamePluginPackage.this;
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePluginPackage
            @NotNull
            public String getId() {
                return this.$$delegate_0.getId();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePluginPackage
            @NotNull
            public String getName() {
                return this.$$delegate_0.getName();
            }

            @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
            @NotNull
            public ScriptFile getScript(@NotNull String name) {
                ScriptFile decorate;
                Intrinsics.checkParameterIsNotNull(name, "name");
                decorate = Utils.decorate(GamePluginPackage.this.getScript(name), this.$enableCodeCache, Consts.GAME_SCRIPT_PREFIX_PLUGIN, name);
                return decorate;
            }

            @Override // com.tencent.mobileqq.triton.filesystem.GamePluginPackage
            @NotNull
            public String getVersion() {
                return this.$$delegate_0.getVersion();
            }
        };
    }
}
