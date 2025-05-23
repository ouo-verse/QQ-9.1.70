package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.v8rt.engine.JsRuntimeLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "name", "", "Companion", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface ScriptPackage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "baseDir", "Ljava/io/File;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }

        @NotNull
        public final ScriptPackage create(@NotNull final File baseDir) {
            Intrinsics.checkParameterIsNotNull(baseDir, "baseDir");
            return new ScriptPackage() { // from class: com.tencent.mobileqq.triton.filesystem.ScriptPackage$Companion$create$1
                @Override // com.tencent.mobileqq.triton.filesystem.ScriptPackage
                @NotNull
                public ScriptFile.Path getScript(@NotNull String name) {
                    Intrinsics.checkParameterIsNotNull(name, "name");
                    return new ScriptFile.Path(name, new File(baseDir, name), new File(baseDir, name + JsRuntimeLoader.CODE_CACHE_SUFFIX));
                }
            };
        }
    }

    @NotNull
    ScriptFile getScript(@NotNull String name) throws TritonException;
}
