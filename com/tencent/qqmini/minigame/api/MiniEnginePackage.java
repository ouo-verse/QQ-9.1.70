package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.qqmini.minigame.manager.EnginePackageUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.utils.AssetsUtil;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.v8rt.engine.JsRuntimeLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "jsLibDirPath", "", "jsLibVersion", "Lcom/tencent/mobileqq/triton/model/Version;", "soVersion", "soDirPath", "isConfigPkg", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/triton/model/Version;Lcom/tencent/mobileqq/triton/model/Version;Ljava/lang/String;Z)V", "engineJar", "Ljava/io/File;", "getEngineJar", "()Ljava/io/File;", "globalConfig", "getGlobalConfig", "()Ljava/lang/String;", "()Z", "getJsLibVersion", "()Lcom/tencent/mobileqq/triton/model/Version;", "version", "getVersion", "getEngineNativeLibrary", "name", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class MiniEnginePackage implements EnginePackage {

    @Nullable
    private final File engineJar;
    private final boolean isConfigPkg;
    private final String jsLibDirPath;

    @NotNull
    private final Version jsLibVersion;
    private final String soDirPath;
    private final Version soVersion;

    public MiniEnginePackage(@NotNull String jsLibDirPath, @NotNull Version jsLibVersion, @NotNull Version soVersion, @Nullable String str, boolean z16) {
        Intrinsics.checkParameterIsNotNull(jsLibDirPath, "jsLibDirPath");
        Intrinsics.checkParameterIsNotNull(jsLibVersion, "jsLibVersion");
        Intrinsics.checkParameterIsNotNull(soVersion, "soVersion");
        this.jsLibDirPath = jsLibDirPath;
        this.jsLibVersion = jsLibVersion;
        this.soVersion = soVersion;
        this.soDirPath = str;
        this.isConfigPkg = z16;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
    @Nullable
    public File getEngineJar() {
        return this.engineJar;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
    @Nullable
    public File getEngineNativeLibrary(@NotNull String name) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(name, "name");
        String str = this.soDirPath;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        File file = new File(this.soDirPath, System.mapLibraryName(name));
        if (!file.exists()) {
            return null;
        }
        return file;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
    @NotNull
    public String getGlobalConfig() {
        String globalConfig = GameWnsUtils.getGlobalConfig();
        Intrinsics.checkExpressionValueIsNotNull(globalConfig, "GameWnsUtils.getGlobalConfig()");
        return globalConfig;
    }

    @NotNull
    public final Version getJsLibVersion() {
        return this.jsLibVersion;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
    @NotNull
    public ScriptFile getScript(@NotNull String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        String str = this.jsLibDirPath;
        EnginePackageUtil enginePackageUtil = EnginePackageUtil.f346509e;
        if (Intrinsics.areEqual(str, enginePackageUtil.b())) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mini");
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append(name);
            String sb6 = sb5.toString();
            AppLoaderFactory g16 = AppLoaderFactory.g();
            Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
            String jsContent = AssetsUtil.readFile(g16.getContext(), sb6);
            File file = new File(enginePackageUtil.d(), getVersion().getVersion() + util.base64_pad_url + getVersion().getTimeStamp() + str2 + name + JsRuntimeLoader.CODE_CACHE_SUFFIX);
            Intrinsics.checkExpressionValueIsNotNull(jsContent, "jsContent");
            return new ScriptFile.Content(name, jsContent, file);
        }
        return new ScriptFile.Path(name, new File(this.jsLibDirPath, name), new File(this.jsLibDirPath, name + JsRuntimeLoader.CODE_CACHE_SUFFIX));
    }

    @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
    @NotNull
    public Version getVersion() {
        return this.soVersion;
    }

    /* renamed from: isConfigPkg, reason: from getter */
    public final boolean getIsConfigPkg() {
        return this.isConfigPkg;
    }

    public /* synthetic */ MiniEnginePackage(String str, Version version, Version version2, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, version, version2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? false : z16);
    }
}
