package gd2;

import androidx.lifecycle.ReportFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.rmonitor.base.meta.InspectUUID;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import com.tencent.util.AppSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0018"}, d2 = {"Lgd2/e;", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryLeakListener;", "", "currentWaitSecond", "", "objInfo", "", "onCheckingLeaked", "", "willCheckedObj", "", "onFilter", "isSuccess", "zipPath", "onFinishDump", "onHprofDumped", "Lcom/tencent/rmonitor/base/meta/InspectUUID;", "uuid", "onLeaked", "", "onPrepareDump", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e implements IMemoryLeakListener {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String zipPath, String objInfo) {
        Intrinsics.checkNotNullParameter(zipPath, "$zipPath");
        Intrinsics.checkNotNullParameter(objInfo, "$objInfo");
        f.f401967a.a(zipPath, objInfo);
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener
    public void onCheckingLeaked(int currentWaitSecond, @NotNull String objInfo) {
        Intrinsics.checkNotNullParameter(objInfo, "objInfo");
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener
    public boolean onFilter(@NotNull Object willCheckedObj) {
        Intrinsics.checkNotNullParameter(willCheckedObj, "willCheckedObj");
        if (willCheckedObj instanceof ReportFragment) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener
    public void onFinishDump(boolean isSuccess, @NotNull final String objInfo, @NotNull final String zipPath) {
        String substringBefore$default;
        Intrinsics.checkNotNullParameter(objInfo, "objInfo");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        com.tencent.mobileqq.perf.log.a.a("LM", "onFinishDump, isSuccess : " + isSuccess + " ,objInfo " + objInfo + ", zipPath" + zipPath);
        if (isSuccess && !AppSetting.isPublicVersion() && !Intrinsics.areEqual(AppSetting.getBranchName(), "master")) {
            if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof AppInterface) {
                ThreadManagerV2.excute(new Runnable() { // from class: gd2.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.e(zipPath, objInfo);
                    }
                }, 128, null, false);
            }
            if (SceneTracker.j()) {
                c cVar = c.f401962a;
                if (cVar.c(objInfo)) {
                    substringBefore$default = StringsKt__StringsKt.substringBefore$default(objInfo, "@", (String) null, 2, (Object) null);
                    cVar.f(substringBefore$default, zipPath);
                }
            }
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener
    public void onHprofDumped(@NotNull String objInfo) {
        Intrinsics.checkNotNullParameter(objInfo, "objInfo");
        com.tencent.mobileqq.perf.log.a.a("LM", "onHprofDumped, objInfo : " + objInfo);
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener
    public boolean onLeaked(@NotNull InspectUUID uuid) {
        Object obj;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (AppSetting.isUiTest()) {
            return false;
        }
        WeakReference<Object> weakReference = uuid.weakObj;
        if (weakReference != null) {
            obj = weakReference.get();
        } else {
            obj = null;
        }
        if (obj != null && (obj instanceof AppInterface) && ((AppInterface) obj).isRunning()) {
            return false;
        }
        com.tencent.mobileqq.perf.log.a.d("LM", "onLeaked, uuid : " + uuid);
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener
    @NotNull
    public List<String> onPrepareDump(@NotNull String objInfo) {
        Intrinsics.checkNotNullParameter(objInfo, "objInfo");
        ArrayList arrayList = new ArrayList(2);
        com.tencent.mobileqq.perf.log.a.a("LM", "onPrepareDump, objInfo : " + objInfo);
        return arrayList;
    }
}
