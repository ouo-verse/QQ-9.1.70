package com.tencent.mobileqq.triton.internal.engine.init;

import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.utils.Downloader;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J+\u0010.\u001a\u0002H/\"\u0004\b\u0000\u00100\"\b\b\u0001\u0010/*\u0002H02\f\u00101\u001a\b\u0012\u0004\u0012\u0002H00*H\u0016\u00a2\u0006\u0002\u00102J-\u00103\u001a\u0004\u0018\u0001H/\"\u0004\b\u0000\u00100\"\b\b\u0001\u0010/*\u0002H02\f\u00101\u001a\b\u0012\u0004\u0012\u0002H00*H\u0016\u00a2\u0006\u0002\u00102J\u0014\u00104\u001a\u00020\u001e2\n\u00101\u001a\u0006\u0012\u0002\b\u00030*H\u0016J)\u00105\u001a\u000206\"\u0004\b\u0000\u001002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H00*2\u0006\u00107\u001a\u0002H0H\u0016\u00a2\u0006\u0002\u00108R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R#\u0010(\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030*\u0012\u0006\u0012\u0004\u0018\u00010+0)\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/init/EngineDataImpl;", "Lcom/tencent/mobileqq/triton/engine/EngineData;", "contextImpl", "Lcom/tencent/mobileqq/triton/internal/engine/init/EngineContextImpl;", "(Lcom/tencent/mobileqq/triton/internal/engine/init/EngineContextImpl;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", QDLog.TAG_DOWNLOAD, "Lcom/tencent/mobileqq/triton/utils/Downloader;", "getDownloader", "()Lcom/tencent/mobileqq/triton/utils/Downloader;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "getEnginePackage", "()Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "inspectorAgent", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "getInspectorAgent", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "isMute", "", "()Z", "logDelegate", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "getLogDelegate", "()Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "getScriptPlugin", "()Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "userDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "", "getUserDataMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "get", BdhLogUtil.LogTag.Tag_Req, "T", "tag", "(Ljava/lang/Class;)Ljava/lang/Object;", "getOrNull", "has", "set", "", "data", "(Ljava/lang/Class;Ljava/lang/Object;)V", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EngineDataImpl implements EngineData {
    private final EngineContextImpl contextImpl;

    @NotNull
    private final ConcurrentHashMap<Class<?>, Object> userDataMap;

    public EngineDataImpl(@NotNull EngineContextImpl contextImpl) {
        Intrinsics.checkParameterIsNotNull(contextImpl, "contextImpl");
        this.contextImpl = contextImpl;
        this.userDataMap = new ConcurrentHashMap<>();
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    public <T, R extends T> R get(@NotNull Class<T> tag) throws NoSuchElementException {
        Object value;
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        value = MapsKt__MapsKt.getValue(this.userDataMap, tag);
        return (R) value;
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    @NotNull
    public Context getContext() {
        return this.contextImpl.getContext();
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    @NotNull
    public GameDataFileSystem getDataFileSystem() {
        return this.contextImpl.getDataFileSystem();
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    @NotNull
    public Downloader getDownloader() {
        return this.contextImpl.getDownloader();
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    @NotNull
    public EnginePackage getEnginePackage() {
        return this.contextImpl.getEnginePackage();
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    @NotNull
    public GamePackage getGamePackage() {
        return this.contextImpl.getGamePackage();
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    @Nullable
    public InspectorAgent getInspectorAgent() {
        return this.contextImpl.getInspectorAgent();
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    @NotNull
    public LogDelegate getLogDelegate() {
        return Logger.INSTANCE.getDelegate();
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    @Nullable
    public <T, R extends T> R getOrNull(@NotNull Class<T> tag) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        return (R) this.userDataMap.get(tag);
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    @NotNull
    public ScriptPlugin getScriptPlugin() {
        return this.contextImpl.getScriptPluginWrapper().getExternalPlugin();
    }

    @NotNull
    public final ConcurrentHashMap<Class<?>, Object> getUserDataMap() {
        return this.userDataMap;
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    public boolean has(@NotNull Class<?> tag) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        return this.userDataMap.containsKey(tag);
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    public boolean isMute() {
        return this.contextImpl.getIsMute();
    }

    @Override // com.tencent.mobileqq.triton.engine.EngineData
    public <T> void set(@NotNull Class<T> tag, T data) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        this.userDataMap.put(tag, data);
    }
}
