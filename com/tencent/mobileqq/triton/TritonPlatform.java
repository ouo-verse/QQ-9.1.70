package com.tencent.mobileqq.triton;

import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.exception.TritonPlatformInitTwiceException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.model.DebugConfig;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0002\b\tJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/triton/TritonPlatform;", "", "launchGame", "", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "gameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "Builder", "Companion", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface TritonPlatform {
    public static final long CODE_CACHE_DEFAULT_INTERVAL = 60000;
    public static final int CODE_CACHE_MODE_ALL = 3;
    public static final int CODE_CACHE_MODE_ENGINE = 1;
    public static final int CODE_CACHE_MODE_GAME = 2;
    public static final int CODE_CACHE_MODE_NONE = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001b\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020 H\u0082\bJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\"\u001a\u00020\u001bH\u0002J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/triton/TritonPlatform$Builder;", "", "()V", "codeCacheInterval", "", "codeCacheMode", "", "context", "Landroid/content/Context;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", QDLog.TAG_DOWNLOAD, "Lcom/tencent/mobileqq/triton/utils/Downloader;", "enableCodeCache", "", "enableOpenGlEs3", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "preloadEngine", "scriptPluginFactory", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "workerExecutor", "build", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "checkNonNull", "", "value", "name", "", "enablePreloadEngine", "performBuild", "Companion", "TritonClassLoader", "TritonPlatformFactory", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Builder {
        private static final String TRITON_PLATFORM_FACTORY_IMPL_CLASS_NAME = "com.tencent.mobileqq.triton.internal.engine.EnginePlatformFactory";
        private static Throwable previouslyBuildingStackTrace;
        private static TritonPlatform previouslyBuiltPlatform;
        private Context context;
        private DebugConfig debugConfig;
        private Downloader downloader;
        private EnginePackage enginePackage;
        private LogDelegate logger;
        private Executor mainThreadExecutor;
        private ScriptPluginFactory scriptPluginFactory;
        private Executor workerExecutor;
        private static final ReentrantLock buildLock = new ReentrantLock();
        private boolean enableCodeCache = true;
        private int codeCacheMode = 3;
        private long codeCacheInterval = 60000;
        private boolean preloadEngine = true;
        private boolean enableOpenGlEs3 = true;

        /* JADX INFO: Access modifiers changed from: private */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/TritonPlatform$Builder$TritonClassLoader;", "Ldalvik/system/PathClassLoader;", "dexFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "(Ljava/io/File;Landroid/content/Context;)V", "originClassLoader", "Ljava/lang/ClassLoader;", "findClass", "Ljava/lang/Class;", "name", "", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes19.dex */
        public static final class TritonClassLoader extends PathClassLoader {
            private final ClassLoader originClassLoader;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public TritonClassLoader(@NotNull File dexFile, @NotNull Context context) {
                super(r4, r0, r1.getParent());
                Intrinsics.checkParameterIsNotNull(dexFile, "dexFile");
                Intrinsics.checkParameterIsNotNull(context, "context");
                String absolutePath = dexFile.getAbsolutePath();
                String str = context.getApplicationInfo().nativeLibraryDir;
                ClassLoader classLoader = context.getClassLoader();
                Intrinsics.checkExpressionValueIsNotNull(classLoader, "context.classLoader");
                ClassLoader classLoader2 = context.getClassLoader();
                Intrinsics.checkExpressionValueIsNotNull(classLoader2, "context.classLoader");
                this.originClassLoader = classLoader2;
            }

            @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
            @NotNull
            protected Class<?> findClass(@NotNull String name) {
                Intrinsics.checkParameterIsNotNull(name, "name");
                try {
                    Class<?> findClass = super.findClass(name);
                    Intrinsics.checkExpressionValueIsNotNull(findClass, "super.findClass(name)");
                    return findClass;
                } catch (ClassNotFoundException unused) {
                    Class<?> loadClass = this.originClassLoader.loadClass(name);
                    Intrinsics.checkExpressionValueIsNotNull(loadClass, "originClassLoader.loadClass(name)");
                    return loadClass;
                }
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001Jp\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/triton/TritonPlatform$Builder$TritonPlatformFactory;", "", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/mobileqq/triton/TritonPlatform;", "context", "Landroid/content/Context;", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "debugConfig", "Lcom/tencent/mobileqq/triton/model/DebugConfig;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "enableCodeCache", "", "codeCacheMode", "", "codeCacheInterval", "", "enableOpenGlEs3", "enablePreloadEngine", "workerExecutor", "Ljava/util/concurrent/Executor;", "mainThreadExecutor", QDLog.TAG_DOWNLOAD, "Lcom/tencent/mobileqq/triton/utils/Downloader;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes19.dex */
        public interface TritonPlatformFactory {
            @NotNull
            TritonPlatform create(@NotNull Context context, @NotNull LogDelegate logger, @NotNull DebugConfig debugConfig, @NotNull ScriptPluginFactory scriptPlugin, @NotNull EnginePackage enginePackage, boolean enableCodeCache, int codeCacheMode, long codeCacheInterval, boolean enableOpenGlEs3, boolean enablePreloadEngine, @NotNull Executor workerExecutor, @NotNull Executor mainThreadExecutor, @NotNull Downloader downloader);
        }

        private final void checkNonNull(Object value, String name) {
            if (value != null) {
                return;
            }
            throw new TritonInitException(name + " is not set", null, null, 6, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x006a A[Catch: all -> 0x0065, TryCatch #0 {all -> 0x0065, blocks: (B:58:0x0057, B:60:0x0060, B:28:0x006a, B:30:0x0071, B:31:0x0074, B:33:0x0078, B:34:0x007b, B:36:0x007f, B:37:0x0082, B:39:0x0086, B:40:0x0089, B:42:0x008d, B:43:0x0090, B:45:0x009e, B:46:0x00a1, B:48:0x00a5, B:49:0x00a8, B:51:0x00ac, B:52:0x00af, B:55:0x00b6, B:56:0x00be), top: B:57:0x0057 }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b6 A[Catch: all -> 0x0065, TryCatch #0 {all -> 0x0065, blocks: (B:58:0x0057, B:60:0x0060, B:28:0x006a, B:30:0x0071, B:31:0x0074, B:33:0x0078, B:34:0x007b, B:36:0x007f, B:37:0x0082, B:39:0x0086, B:40:0x0089, B:42:0x008d, B:43:0x0090, B:45:0x009e, B:46:0x00a1, B:48:0x00a5, B:49:0x00a8, B:51:0x00ac, B:52:0x00af, B:55:0x00b6, B:56:0x00be), top: B:57:0x0057 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final TritonPlatform performBuild() {
            ClassLoader classLoader;
            Object newInstance;
            File engineJar;
            DebugConfig debugConfig = this.debugConfig;
            if (debugConfig == null) {
                debugConfig = new DebugConfig(false, 0L, 0L, 0, 0, false, false, 127, null);
            }
            this.debugConfig = debugConfig;
            if (this.context != null) {
                if (this.logger != null) {
                    if (this.scriptPluginFactory != null) {
                        EnginePackage enginePackage = this.enginePackage;
                        if (enginePackage != null) {
                            if (this.workerExecutor != null) {
                                if (this.mainThreadExecutor != null) {
                                    if (this.downloader != null) {
                                        if (enginePackage != null && (engineJar = enginePackage.getEngineJar()) != null) {
                                            Context context = this.context;
                                            if (context == null) {
                                                Intrinsics.throwNpe();
                                            }
                                            classLoader = new TritonClassLoader(engineJar, context);
                                        } else {
                                            classLoader = TritonPlatform.class.getClassLoader();
                                        }
                                        if (classLoader != null) {
                                            try {
                                                Class<?> loadClass = classLoader.loadClass(TRITON_PLATFORM_FACTORY_IMPL_CLASS_NAME);
                                                if (loadClass != null) {
                                                    newInstance = loadClass.newInstance();
                                                    if (newInstance == null) {
                                                        TritonPlatformFactory tritonPlatformFactory = (TritonPlatformFactory) newInstance;
                                                        Context context2 = this.context;
                                                        if (context2 == null) {
                                                            Intrinsics.throwNpe();
                                                        }
                                                        LogDelegate logDelegate = this.logger;
                                                        if (logDelegate == null) {
                                                            Intrinsics.throwNpe();
                                                        }
                                                        DebugConfig debugConfig2 = this.debugConfig;
                                                        if (debugConfig2 == null) {
                                                            Intrinsics.throwNpe();
                                                        }
                                                        ScriptPluginFactory scriptPluginFactory = this.scriptPluginFactory;
                                                        if (scriptPluginFactory == null) {
                                                            Intrinsics.throwNpe();
                                                        }
                                                        EnginePackage enginePackage2 = this.enginePackage;
                                                        if (enginePackage2 == null) {
                                                            Intrinsics.throwNpe();
                                                        }
                                                        boolean z16 = this.enableCodeCache;
                                                        int i3 = this.codeCacheMode;
                                                        long j3 = this.codeCacheInterval;
                                                        boolean z17 = this.enableOpenGlEs3;
                                                        boolean z18 = this.preloadEngine;
                                                        Executor executor = this.workerExecutor;
                                                        if (executor == null) {
                                                            Intrinsics.throwNpe();
                                                        }
                                                        Executor executor2 = this.mainThreadExecutor;
                                                        if (executor2 == null) {
                                                            Intrinsics.throwNpe();
                                                        }
                                                        Downloader downloader = this.downloader;
                                                        if (downloader == null) {
                                                            Intrinsics.throwNpe();
                                                        }
                                                        return tritonPlatformFactory.create(context2, logDelegate, debugConfig2, scriptPluginFactory, enginePackage2, z16, i3, j3, z17, z18, executor, executor2, downloader);
                                                    }
                                                    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.triton.TritonPlatform.Builder.TritonPlatformFactory");
                                                }
                                            } catch (Throwable th5) {
                                                throw new TritonInitException("failed to create TritonEngine", ErrorCodes.UNKNOWN, th5);
                                            }
                                        }
                                        newInstance = null;
                                        if (newInstance == null) {
                                        }
                                    } else {
                                        throw new TritonInitException(QDLog.TAG_DOWNLOAD + " is not set", null, null, 6, null);
                                    }
                                } else {
                                    throw new TritonInitException("mainThreadExecutor is not set", null, null, 6, null);
                                }
                            } else {
                                throw new TritonInitException("workerExecutor is not set", null, null, 6, null);
                            }
                        } else {
                            throw new TritonInitException("enginePackage is not set", null, null, 6, null);
                        }
                    } else {
                        throw new TritonInitException("scriptPluginFactory is not set", null, null, 6, null);
                    }
                } else {
                    throw new TritonInitException("logger is not set", null, null, 6, null);
                }
            } else {
                throw new TritonInitException("context is not set", null, null, 6, null);
            }
        }

        @NotNull
        public final TritonPlatform build() throws TritonInitException {
            ReentrantLock reentrantLock = buildLock;
            reentrantLock.lock();
            try {
                TritonPlatform tritonPlatform = previouslyBuiltPlatform;
                if (tritonPlatform != null) {
                    String str = "TritonPlatform is singleton, can't build twice. Previously built one is [" + tritonPlatform + ']';
                    Throwable th5 = previouslyBuildingStackTrace;
                    if (th5 == null) {
                        Intrinsics.throwNpe();
                    }
                    throw new TritonPlatformInitTwiceException(str, tritonPlatform, th5);
                }
                TritonPlatform performBuild = performBuild();
                previouslyBuiltPlatform = performBuild;
                previouslyBuildingStackTrace = new Throwable("previously building stacktrace");
                return performBuild;
            } finally {
                reentrantLock.unlock();
            }
        }

        @NotNull
        public final Builder codeCacheInterval(long codeCacheInterval) {
            this.codeCacheInterval = codeCacheInterval;
            return this;
        }

        @NotNull
        public final Builder codeCacheMode(int codeCacheMode) {
            this.codeCacheMode = codeCacheMode;
            return this;
        }

        @NotNull
        public final Builder context(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            this.context = context.getApplicationContext();
            return this;
        }

        @NotNull
        public final Builder debugConfig(@NotNull DebugConfig debugConfig) {
            Intrinsics.checkParameterIsNotNull(debugConfig, "debugConfig");
            this.debugConfig = debugConfig;
            return this;
        }

        @NotNull
        public final Builder downloader(@NotNull Downloader downloader) {
            Intrinsics.checkParameterIsNotNull(downloader, "downloader");
            this.downloader = downloader;
            return this;
        }

        @NotNull
        public final Builder enableCodeCache(boolean enableCodeCache) {
            this.enableCodeCache = enableCodeCache;
            return this;
        }

        @NotNull
        public final Builder enableOpenGlEs3(boolean enableOpenGlEs3) {
            this.enableOpenGlEs3 = enableOpenGlEs3;
            return this;
        }

        @NotNull
        public final Builder enablePreloadEngine(boolean enablePreloadEngine) {
            this.preloadEngine = enablePreloadEngine;
            return this;
        }

        @NotNull
        public final Builder enginePackage(@NotNull EnginePackage enginePackage) {
            Intrinsics.checkParameterIsNotNull(enginePackage, "enginePackage");
            this.enginePackage = enginePackage;
            return this;
        }

        @NotNull
        public final Builder logger(@NotNull LogDelegate logger) {
            Intrinsics.checkParameterIsNotNull(logger, "logger");
            this.logger = logger;
            return this;
        }

        @NotNull
        public final Builder mainThreadExecutor(@NotNull Executor mainThreadExecutor) {
            Intrinsics.checkParameterIsNotNull(mainThreadExecutor, "mainThreadExecutor");
            this.mainThreadExecutor = mainThreadExecutor;
            return this;
        }

        @NotNull
        public final Builder scriptPluginFactory(@NotNull ScriptPluginFactory scriptPluginFactory) {
            Intrinsics.checkParameterIsNotNull(scriptPluginFactory, "scriptPluginFactory");
            this.scriptPluginFactory = scriptPluginFactory;
            return this;
        }

        @NotNull
        public final Builder workerExecutor(@NotNull Executor workerExecutor) {
            Intrinsics.checkParameterIsNotNull(workerExecutor, "workerExecutor");
            this.workerExecutor = workerExecutor;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/triton/TritonPlatform$Companion;", "", "()V", "CODE_CACHE_DEFAULT_INTERVAL", "", "CODE_CACHE_MODE_ALL", "", "CODE_CACHE_MODE_ENGINE", "CODE_CACHE_MODE_GAME", "CODE_CACHE_MODE_NONE", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long CODE_CACHE_DEFAULT_INTERVAL = 60000;
        public static final int CODE_CACHE_MODE_ALL = 3;
        public static final int CODE_CACHE_MODE_ENGINE = 1;
        public static final int CODE_CACHE_MODE_GAME = 2;
        public static final int CODE_CACHE_MODE_NONE = 0;

        Companion() {
        }
    }

    void launchGame(@NotNull GameLaunchParam param, @NotNull GameLaunchCallback gameLaunchCallback);
}
