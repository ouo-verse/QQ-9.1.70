package com.tencent.rmonitor.base.plugin.listener;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rmonitor/base/plugin/listener/IMemoryDumpListener;", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "onFinishDump", "", "isSuccess", "", "objInfo", "", "zipPath", "onHprofDumped", "onPrepareDump", "", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public interface IMemoryDumpListener extends IBaseListener {
    void onFinishDump(boolean isSuccess, @NotNull String objInfo, @NotNull String zipPath);

    void onHprofDumped(@NotNull String objInfo);

    @Nullable
    List<String> onPrepareDump(@NotNull String objInfo);
}
