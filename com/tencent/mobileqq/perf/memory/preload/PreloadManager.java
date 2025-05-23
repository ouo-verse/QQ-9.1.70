package com.tencent.mobileqq.perf.memory.preload;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/preload/PreloadManager;", "", "", TagName.ENTRY_NAME, "processName", "", "a", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/perf/memory/preload/b;", "Ljava/util/concurrent/ConcurrentHashMap;", "entryNameToSession", "<init>", "()V", "PreloadEntry", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PreloadManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PreloadManager f257781a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, b> entryNameToSession;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/preload/PreloadManager$PreloadEntry;", "", "(Ljava/lang/String;I)V", "GameCenterLeba", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class PreloadEntry {
        private static final /* synthetic */ PreloadEntry[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PreloadEntry GameCenterLeba;

        private static final /* synthetic */ PreloadEntry[] $values() {
            return new PreloadEntry[]{GameCenterLeba};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30416);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                GameCenterLeba = new PreloadEntry("GameCenterLeba", 0);
                $VALUES = $values();
            }
        }

        PreloadEntry(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static PreloadEntry valueOf(String str) {
            return (PreloadEntry) Enum.valueOf(PreloadEntry.class, str);
        }

        public static PreloadEntry[] values() {
            return (PreloadEntry[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30421);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f257781a = new PreloadManager();
            entryNameToSession = new ConcurrentHashMap<>();
        }
    }

    PreloadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String entryName, @NotNull String processName) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) entryName, (Object) processName);
            return;
        }
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        Intrinsics.checkNotNullParameter(processName, "processName");
        ConcurrentHashMap<String, b> concurrentHashMap = entryNameToSession;
        if (!concurrentHashMap.containsKey(entryName)) {
            concurrentHashMap.put(entryName, new b(entryName, processName));
        }
        b bVar = concurrentHashMap.get(entryName);
        if (bVar != null) {
            bool = Boolean.valueOf(bVar.a());
        } else {
            bool = null;
        }
        QLog.d("MemoryPreloadManager", 1, "addPreloadSession " + entryName + ", result:" + bool + ", " + processName);
    }

    public final void b(@NotNull String entryName) {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) entryName);
            return;
        }
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        b bVar = entryNameToSession.get(entryName);
        if (bVar != null) {
            bool = Boolean.valueOf(bVar.d());
        } else {
            bool = null;
        }
        QLog.d("MemoryPreloadManager", 1, "hitPreload " + entryName + ", result:" + bool);
    }
}
