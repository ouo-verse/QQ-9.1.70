package h14;

import com.tencent.rmonitor.base.meta.InspectUUID;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements IMemoryLeakListener {
    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener
    public boolean onFilter(@NotNull Object obj) {
        return false;
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener
    public boolean onLeaked(@NotNull InspectUUID inspectUUID) {
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener
    @Nullable
    public List<String> onPrepareDump(@NotNull String str) {
        return new ArrayList();
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener
    public void onHprofDumped(@NotNull String str) {
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener
    public void onCheckingLeaked(int i3, @NotNull String str) {
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener
    public void onFinishDump(boolean z16, @NotNull String str, @NotNull String str2) {
    }
}
