package com.tencent.qqmini.minigame.api;

import android.content.Context;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPluginFactory;
import com.tencent.qqmini.minigame.GameJsPluginEngine;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqmini/minigame/api/MiniScriptPluginFactory;", "Lcom/tencent/mobileqq/triton/script/ScriptPluginFactory;", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "context", "Landroid/content/Context;", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class MiniScriptPluginFactory implements ScriptPluginFactory {
    public static final MiniScriptPluginFactory INSTANCE = new MiniScriptPluginFactory();

    MiniScriptPluginFactory() {
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPluginFactory
    @NotNull
    public ScriptPlugin create(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new GameJsPluginEngine(context);
    }
}
