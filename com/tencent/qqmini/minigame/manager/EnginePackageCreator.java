package com.tencent.qqmini.minigame.manager;

import android.os.Bundle;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.utils.TritonEngineUtil;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.BaseLibManager;
import com.tencent.qqmini.sdk.utils.MiniAppUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00062\u00020\u0001:\u0002\u0015\tB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/EnginePackageCreator;", "", "Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "d", "e", "Lcom/tencent/qqmini/minigame/manager/EnginePackageCreator$a;", "f", "g", "", "a", "Ljava/lang/String;", "debugJsLibPath", "b", "debugTritonSoPath", "Lcom/tencent/mobileqq/triton/model/Version;", "c", "Lcom/tencent/mobileqq/triton/model/Version;", "innerJsLibVersion", "innerTritonVersion", "<init>", "()V", "Companion", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class EnginePackageCreator {

    /* renamed from: e, reason: collision with root package name */
    private static volatile MiniEnginePackage f346487e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String debugJsLibPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String debugTritonSoPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Version innerJsLibVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Version innerTritonVersion;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/EnginePackageCreator$Companion;", "", "", "isNewEngine", "", "b", "Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "a", "", "TAG", "Ljava/lang/String;", "sEnginePackage", "Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        private final void b(final boolean isNewEngine) {
            ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.EnginePackageCreator$Companion$notifyNewEngineUsage$1
                @Override // java.lang.Runnable
                public final void run() {
                    QMLog.i("EnginePackageCreator", "notifyNewEngineUsage: notify main process, isNewEngine=" + isNewEngine);
                    AppBrandCmdProxy g16 = AppBrandCmdProxy.g();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(IPCConst.KEY_GAME_NEW_ENGINE, isNewEngine);
                    g16.sendCmd(IPCConst.CMD_GAME_ENGINE_INFO, bundle, null);
                }
            });
        }

        @JvmStatic
        @NotNull
        public final MiniEnginePackage a() {
            if (EnginePackageCreator.f346487e == null) {
                synchronized (EnginePackageCreator.class) {
                    if (EnginePackageCreator.f346487e == null) {
                        EnginePackageCreator.f346487e = new EnginePackageCreator().d();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            MiniEnginePackage miniEnginePackage = EnginePackageCreator.f346487e;
            if (miniEnginePackage == null) {
                Intrinsics.throwNpe();
            }
            if (miniEnginePackage.getIsConfigPkg()) {
                TritonEngineUtil.f346833b.c("\u5f53\u524d\u4f7f\u7528\u65b0\u5f15\u64ce\uff0c\u53ef\u4ee5\u5f00\u59cb\u6d4b\u8bd5\uff01");
            }
            MiniEnginePackage miniEnginePackage2 = EnginePackageCreator.f346487e;
            if (miniEnginePackage2 == null) {
                Intrinsics.throwNpe();
            }
            b(miniEnginePackage2.getIsConfigPkg());
            MiniEnginePackage miniEnginePackage3 = EnginePackageCreator.f346487e;
            if (miniEnginePackage3 == null) {
                Intrinsics.throwNpe();
            }
            return miniEnginePackage3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqmini/minigame/manager/EnginePackageCreator$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "path", "Lcom/tencent/mobileqq/triton/model/Version;", "b", "Lcom/tencent/mobileqq/triton/model/Version;", "()Lcom/tencent/mobileqq/triton/model/Version;", "version", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/triton/model/Version;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.manager.EnginePackageCreator$a, reason: from toString */
    /* loaded from: classes23.dex */
    public static final /* data */ class LibInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String path;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Version version;

        public LibInfo(@NotNull String path, @NotNull Version version) {
            Intrinsics.checkParameterIsNotNull(path, "path");
            Intrinsics.checkParameterIsNotNull(version, "version");
            this.path = path;
            this.version = version;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Version getVersion() {
            return this.version;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof LibInfo) {
                    LibInfo libInfo = (LibInfo) other;
                    if (!Intrinsics.areEqual(this.path, libInfo.path) || !Intrinsics.areEqual(this.version, libInfo.version)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            String str = this.path;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            Version version = this.version;
            if (version != null) {
                i16 = version.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "LibInfo(path=" + this.path + ", version=" + this.version + ")";
        }
    }

    public EnginePackageCreator() {
        String str;
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            str = qQCustomizedProxy.getDebugJsPath();
        } else {
            str = null;
        }
        this.debugJsLibPath = str;
        this.debugTritonSoPath = qQCustomizedProxy != null ? qQCustomizedProxy.getDebugTritonPath() : null;
        this.innerJsLibVersion = new Version("1.74.3.00001", 0L);
        this.innerTritonVersion = new Version("3.0.0.486.6d09724f2", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniEnginePackage d() {
        long currentTimeMillis = System.currentTimeMillis();
        MiniEnginePackage e16 = e();
        if (e16 != null) {
            QMLog.i("EnginePackageCreator", "create cost=" + (System.currentTimeMillis() - currentTimeMillis));
            return e16;
        }
        LibInfo f16 = f();
        if (f16 == null) {
            f16 = new LibInfo(EnginePackageUtil.f346509e.b(), this.innerJsLibVersion);
            QMLog.i("EnginePackageCreator", "use inner JsLib.");
        }
        LibInfo g16 = g();
        if (g16 == null) {
            g16 = new LibInfo("", this.innerTritonVersion);
            QMLog.i("EnginePackageCreator", "use inner triton so.");
        }
        MiniEnginePackage miniEnginePackage = new MiniEnginePackage(f16.getPath(), f16.getVersion(), g16.getVersion(), g16.getPath(), false, 16, null);
        QMLog.i("EnginePackageCreator", "create cost=" + (System.currentTimeMillis() - currentTimeMillis));
        return miniEnginePackage;
    }

    private final MiniEnginePackage e() {
        String str;
        ju3.a a16 = EnginePackageUtil.f346509e.a();
        if (a16 == null) {
            QMLog.i("EnginePackageCreator", "createByConfig: updateConfig is null");
            return null;
        }
        MiniAppInfo miniAppInfo = MiniAppUtils.getMiniAppInfo();
        if (miniAppInfo != null) {
            str = miniAppInfo.appId;
        } else {
            str = null;
        }
        if (!a16.a(str)) {
            QMLog.i("EnginePackageCreator", "createByConfig: appId not valid, current=" + str);
            return null;
        }
        File d16 = a16.d();
        if (!a16.g(d16)) {
            QMLog.i("EnginePackageCreator", "createByConfig: config engine pkg is not saved.");
            return null;
        }
        QMLog.i("EnginePackageCreator", "use configEnginePackage, config=" + a16);
        String absolutePath = d16.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "saveDir.absolutePath");
        return new MiniEnginePackage(absolutePath, new Version(a16.getJsLibVersion(), a16.getTimestamp()), new Version(a16.getTritonVersion(), a16.getTimestamp()), d16.getAbsolutePath(), true);
    }

    private final LibInfo f() {
        boolean z16;
        if (this.debugJsLibPath != null) {
            QMLog.i("EnginePackageCreator", "use debug jsLib");
            return new LibInfo(this.debugJsLibPath, this.innerJsLibVersion);
        }
        if (QUAUtil.isDemoApp()) {
            return null;
        }
        String string = StorageUtil.getPreference().getString("downloadUrl", null);
        boolean z17 = false;
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        String string2 = StorageUtil.getPreference().getString("version", null);
        if (string2 == null || string2.length() == 0) {
            z17 = true;
        }
        if (z17) {
            return null;
        }
        Version version = new Version(string2, 0L);
        if (version.compareTo(this.innerJsLibVersion) < 0) {
            return null;
        }
        String baseLibPath = BaseLibManager.g().getBaseLibDir(string, string2);
        if (!EnginePackageUtil.f346509e.e(new File(baseLibPath))) {
            return null;
        }
        QMLog.i("EnginePackageCreator", "use local jsLib, version=" + string2);
        Intrinsics.checkExpressionValueIsNotNull(baseLibPath, "baseLibPath");
        return new LibInfo(baseLibPath, version);
    }

    private final LibInfo g() {
        String onlineTritonPathByVersion;
        if (this.debugTritonSoPath != null) {
            QMLog.i("EnginePackageCreator", "use debug triton so.");
            return new LibInfo(this.debugTritonSoPath, this.innerTritonVersion);
        }
        if (QUAUtil.isDemoApp()) {
            return null;
        }
        Version version = EnginePackageManager.getOnlineTritonVersion();
        if (version.compareTo(this.innerTritonVersion) <= 0 || (onlineTritonPathByVersion = EnginePackageManager.getOnlineTritonPathByVersion(version)) == null || !EnginePackageUtil.f346509e.f(new File(onlineTritonPathByVersion))) {
            return null;
        }
        QMLog.i("EnginePackageCreator", "use baseLib updated triton so, version=" + version);
        Intrinsics.checkExpressionValueIsNotNull(version, "version");
        return new LibInfo(onlineTritonPathByVersion, version);
    }
}
