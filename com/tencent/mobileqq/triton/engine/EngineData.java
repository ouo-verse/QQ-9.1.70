package com.tencent.mobileqq.triton.engine;

import android.content.Context;
import androidx.annotation.AnyThread;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@AnyThread
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010'\"\b\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)H&\u00a2\u0006\u0002\u0010*J-\u0010+\u001a\u0004\u0018\u0001H'\"\u0004\b\u0000\u0010'\"\b\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)H&\u00a2\u0006\u0002\u0010*J\u0014\u0010,\u001a\u00020\u001b2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)H&J)\u0010-\u001a\u00020.\"\u0004\b\u0000\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010/\u001a\u0002H'H&\u00a2\u0006\u0002\u00100R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/triton/engine/EngineData;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", QDLog.TAG_DOWNLOAD, "Lcom/tencent/mobileqq/triton/utils/Downloader;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "inspectorAgent", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "getInspectorAgent", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "isMute", "", "()Z", "logDelegate", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "getLogDelegate", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "getScriptPlugin", "()Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "get", BdhLogUtil.LogTag.Tag_Req, "T", "tag", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getOrNull", "has", "set", "", "data", "(Ljava/lang/Class;Ljava/lang/Object;)V", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface EngineData {
    <T, R extends T> R get(@NotNull Class<T> tag) throws NoSuchElementException;

    @NotNull
    Context getContext();

    @NotNull
    GameDataFileSystem getDataFileSystem();

    @NotNull
    Downloader getDownloader();

    @NotNull
    EnginePackage getEnginePackage();

    @NotNull
    GamePackage getGamePackage();

    @Nullable
    InspectorAgent getInspectorAgent();

    @NotNull
    LogDelegate getLogDelegate();

    @Nullable
    <T, R extends T> T getOrNull(@NotNull Class<T> tag);

    @NotNull
    ScriptPlugin getScriptPlugin();

    boolean has(@NotNull Class<?> tag);

    boolean isMute();

    <T> void set(@NotNull Class<T> tag, T data);
}
