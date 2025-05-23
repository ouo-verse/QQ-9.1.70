package com.tencent.tavcut.core.render.video;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/core/render/video/OnReverseVideoListener;", "", "onCancel", "", "onFailure", "errCode", "", "errMsg", "", "onProgress", "progress", "onSuccess", "outputPath", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface OnReverseVideoListener {
    void onCancel();

    void onFailure(int errCode, @NotNull String errMsg);

    void onProgress(int progress);

    void onSuccess(@NotNull String outputPath);
}
