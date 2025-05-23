package id2;

import com.tencent.rmonitor.base.plugin.listener.IMemoryCeilingListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lid2/a;", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryCeilingListener;", "", "isSuccess", "", "objInfo", "zipPath", "", "onFinishDump", "onHprofDumped", "", "memory", "onLowMemory", "", "onPrepareDump", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements IMemoryCeilingListener {
    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener
    public void onFinishDump(boolean isSuccess, @NotNull String objInfo, @NotNull String zipPath) {
        Intrinsics.checkNotNullParameter(objInfo, "objInfo");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        com.tencent.mobileqq.perf.log.a.a("QQRmonitorMemoryCellingListener", "QQRmonitorMemoryCellingListener.onFinishDump, objInfo : " + objInfo + " ,isSuccess : " + isSuccess + " ,zipPath : " + zipPath);
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener
    public void onHprofDumped(@NotNull String objInfo) {
        Intrinsics.checkNotNullParameter(objInfo, "objInfo");
        com.tencent.mobileqq.perf.log.a.a("QQRmonitorMemoryCellingListener", "QQRmonitorMemoryCellingListener.onHprofDumped, objInfo : " + objInfo);
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryCeilingListener
    public boolean onLowMemory(long memory) {
        com.tencent.mobileqq.perf.log.a.c("QQRmonitorMemoryCellingListener", "onLowMemory , onLowMemory = " + memory);
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener
    @Nullable
    public List<String> onPrepareDump(@NotNull String objInfo) {
        Intrinsics.checkNotNullParameter(objInfo, "objInfo");
        com.tencent.mobileqq.perf.log.a.a("QQRmonitorMemoryCellingListener", "QQRmonitorMemoryCellingListener.onDumpStart, objInfo : " + objInfo);
        return null;
    }
}
