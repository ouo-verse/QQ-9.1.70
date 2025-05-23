package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.gpkg.g;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.v8rt.engine.JsRuntimeLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "subPkgName", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "invoke"}, k = 3, mv = {1, 1, 16})
/* loaded from: classes23.dex */
final class MiniGamePackageManager$createGamePackage$gamePackage$1 extends Lambda implements Function2<String, GamePackage.SubpackageListener, Unit> {
    final /* synthetic */ MiniGamePkg $pkg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniGamePackageManager$createGamePackage$gamePackage$1(MiniGamePkg miniGamePkg) {
        super(2);
        this.$pkg = miniGamePkg;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, GamePackage.SubpackageListener subpackageListener) {
        invoke2(str, subpackageListener);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final String subPkgName, @NotNull final GamePackage.SubpackageListener callback) {
        Intrinsics.checkParameterIsNotNull(subPkgName, "subPkgName");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        final long currentTimeMillis = System.currentTimeMillis();
        this.$pkg.loadGameSubPackage(subPkgName, new g() { // from class: com.tencent.qqmini.minigame.api.MiniGamePackageManager$createGamePackage$gamePackage$1.1

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/qqmini/minigame/api/MiniGamePackageManager$createGamePackage$gamePackage$1$1$onSuccess$1$1", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "", "name", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "getScript", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
            /* renamed from: com.tencent.qqmini.minigame.api.MiniGamePackageManager$createGamePackage$gamePackage$1$1$a */
            /* loaded from: classes23.dex */
            public static final class a implements ScriptPackage {
                a() {
                }

                @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
                @NotNull
                public ScriptFile getScript(@NotNull String name) {
                    Intrinsics.checkParameterIsNotNull(name, "name");
                    String apkgFolderPath = MiniGamePackageManager$createGamePackage$gamePackage$1.this.$pkg.getApkgFolderPath();
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    File file = new File(apkgFolderPath, MiniGamePackageManager$createGamePackage$gamePackage$1.this.$pkg.getRootPath(subPkgName));
                    if (file.exists() && file.isDirectory()) {
                        file = new File(file, name);
                    }
                    QMLog.i("MiniGamePackageManager", subPkgName + " load success, name=" + name + ",cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", pkgFile=" + file.getAbsolutePath());
                    return new ScriptFile.Path(name, file, new File(file.getAbsolutePath() + JsRuntimeLoader.CODE_CACHE_SUFFIX));
                }
            }

            @Override // com.tencent.qqmini.minigame.gpkg.g
            public void onFail(@NotNull String errorMsg) {
                Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
                GamePackage.SubpackageListener subpackageListener = callback;
                Result.Companion companion = Result.INSTANCE;
                try {
                    throw new RuntimeException("load " + subPkgName + " failed, reason=" + errorMsg);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    subpackageListener.onComplete(Result.m476constructorimpl(ResultKt.createFailure(th5)));
                }
            }

            @Override // com.tencent.qqmini.minigame.gpkg.g
            public void onProgress(float progress, long totalSize) {
                callback.onProgress(totalSize, progress * ((float) totalSize));
            }

            @Override // com.tencent.qqmini.minigame.gpkg.g
            public void onSuccess(@NotNull String subPkgPath) {
                Object m476constructorimpl;
                Intrinsics.checkParameterIsNotNull(subPkgPath, "subPkgPath");
                GamePackage.SubpackageListener subpackageListener = callback;
                Result.Companion companion = Result.INSTANCE;
                try {
                    m476constructorimpl = Result.m476constructorimpl(new a());
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                subpackageListener.onComplete(m476constructorimpl);
            }
        });
    }
}
