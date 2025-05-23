package com.tencent.qqmini.minigame.task;

import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqmini/minigame/task/c;", "", "", "msg", "", "onTritonLoadFail", "Lcom/tencent/qqmini/minigame/api/MiniEnginePackage;", "enginePackage", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "tritonPlatform", "onTritonLoadSuccess", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public interface c {
    void onTritonLoadFail(@NotNull String msg2);

    void onTritonLoadSuccess(@NotNull MiniEnginePackage enginePackage, @NotNull TritonPlatform tritonPlatform);
}
