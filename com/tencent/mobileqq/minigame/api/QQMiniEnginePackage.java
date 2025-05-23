package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.model.Version;
import com.tencent.mobileqq.triton.script.ScriptFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\nH\u0096\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/QQMiniEnginePackage;", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "baseLibDir", "Ljava/io/File;", "version", "Lcom/tencent/mobileqq/triton/model/Version;", "jsVersion", "soDir", "jarFile", "globalConfig", "", "(Ljava/io/File;Lcom/tencent/mobileqq/triton/model/Version;Lcom/tencent/mobileqq/triton/model/Version;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "getBaseLibDir", "()Ljava/io/File;", "engineJar", "getEngineJar", "getGlobalConfig", "()Ljava/lang/String;", "getJsVersion", "()Lcom/tencent/mobileqq/triton/model/Version;", "getSoDir", "getVersion", "getEngineNativeLibrary", "name", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQMiniEnginePackage implements EnginePackage {
    private final /* synthetic */ EnginePackage $$delegate_0;
    private final File baseLibDir;
    private final Version jsVersion;
    private final File soDir;

    public QQMiniEnginePackage(File baseLibDir, Version version, Version jsVersion, File file, File file2, String str) {
        Intrinsics.checkNotNullParameter(baseLibDir, "baseLibDir");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(jsVersion, "jsVersion");
        this.baseLibDir = baseLibDir;
        this.jsVersion = jsVersion;
        this.soDir = file;
        this.$$delegate_0 = EnginePackage.INSTANCE.create(baseLibDir, version, file, file2, str);
    }

    public final File getBaseLibDir() {
        return this.baseLibDir;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
    public File getEngineJar() {
        return this.$$delegate_0.getEngineJar();
    }

    @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
    public File getEngineNativeLibrary(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.$$delegate_0.getEngineNativeLibrary(name);
    }

    @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
    public String getGlobalConfig() {
        return this.$$delegate_0.getGlobalConfig();
    }

    public final Version getJsVersion() {
        return this.jsVersion;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
    public ScriptFile getScript(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.$$delegate_0.getScript(name);
    }

    public final File getSoDir() {
        return this.soDir;
    }

    @Override // com.tencent.mobileqq.triton.filesystem.EnginePackage
    public Version getVersion() {
        return this.$$delegate_0.getVersion();
    }

    public /* synthetic */ QQMiniEnginePackage(File file, Version version, Version version2, File file2, File file3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, version, version2, (i3 & 8) != 0 ? null : file2, (i3 & 16) != 0 ? null : file3, (i3 & 32) != 0 ? null : str);
    }
}
