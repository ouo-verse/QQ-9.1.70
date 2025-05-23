package com.tencent.qmethod.monitor.base.util;

import android.app.Application;
import android.os.Handler;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.pandoraex.api.r;
import com.tencent.qmethod.pandoraex.api.s;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u001b\u0010$\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b\u001c\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/ProcessForegroundHelper;", "", "", tl.h.F, "", "state", "", "reason", "i", "j", "g", "f", "", "isForeground", "k", "", "Lcom/tencent/qmethod/pandoraex/api/s;", "e", "a", "Z", "isStart", "Ljava/util/LinkedList;", "b", "Ljava/util/LinkedList;", "recentStateList", "c", "Ljava/lang/Object;", "stateListLock", "d", "I", "lastState", "Ljava/lang/String;", "currentProcessName", "Landroid/os/Handler;", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "handler", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class ProcessForegroundHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean isStart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int lastState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Lazy handler;

    /* renamed from: g, reason: collision with root package name */
    public static final ProcessForegroundHelper f343520g = new ProcessForegroundHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final LinkedList<String> recentStateList = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Object stateListLock = new Object();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String currentProcessName = "";

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Handler>() { // from class: com.tencent.qmethod.monitor.base.util.ProcessForegroundHelper$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(ThreadManager.f343506c.b());
            }
        });
        handler = lazy;
    }

    ProcessForegroundHelper() {
    }

    private final Handler d() {
        return (Handler) handler.getValue();
    }

    private final void h() {
        boolean contains$default;
        if (isStart) {
            return;
        }
        isStart = true;
        String a16 = com.tencent.qmethod.pandoraex.core.collector.utils.a.a();
        Intrinsics.checkExpressionValueIsNotNull(a16, "AppUtil.getCurrentProcessName()");
        currentProcessName = a16;
        o.a("ProcessForegroundHelper", "recordStart,currentProcessName=" + currentProcessName);
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        String j3 = r.j(aVar.g().getContext(), "process_name");
        if (j3 != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) j3, (CharSequence) currentProcessName, false, 2, (Object) null);
            if (contains$default) {
                return;
            }
            r.p(aVar.g().getContext(), "process_name", j3 + ',' + currentProcessName);
            return;
        }
        r.p(aVar.g().getContext(), "process_name", currentProcessName);
    }

    private final void i(int state, String reason) {
        h();
        lastState = state;
        synchronized (stateListLock) {
            LinkedList<String> linkedList = recentStateList;
            linkedList.add(System.currentTimeMillis() + '#' + state + '#' + reason);
            if (linkedList.size() > 3) {
                linkedList.remove(0);
            }
            f343520g.j();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void j() {
        d().post(new Runnable() { // from class: com.tencent.qmethod.monitor.base.util.ProcessForegroundHelper$storageInfo$1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                LinkedList linkedList;
                ?? joinToString$default;
                String str;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ProcessForegroundHelper processForegroundHelper = ProcessForegroundHelper.f343520g;
                obj = ProcessForegroundHelper.stateListLock;
                synchronized (obj) {
                    linkedList = ProcessForegroundHelper.recentStateList;
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(linkedList, ",", null, null, 0, null, null, 62, null);
                    objectRef.element = joinToString$default;
                    Unit unit = Unit.INSTANCE;
                }
                Application context = com.tencent.qmethod.monitor.a.f343451h.g().getContext();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("process_");
                str = ProcessForegroundHelper.currentProcessName;
                sb5.append(str);
                r.p(context, sb5.toString(), (String) objectRef.element);
            }
        });
    }

    @NotNull
    public final List<s> e() {
        List<String> split$default;
        List<String> split$default2;
        List split$default3;
        ArrayList arrayList = new ArrayList();
        String j3 = r.j(com.tencent.qmethod.monitor.a.f343451h.g().getContext(), "process_name");
        if (j3 != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) j3, new String[]{","}, false, 0, 6, (Object) null);
            for (String str : split$default) {
                String result = r.j(com.tencent.qmethod.monitor.a.f343451h.g().getContext(), "process_" + str);
                Intrinsics.checkExpressionValueIsNotNull(result, "result");
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) result, new String[]{","}, false, 0, 6, (Object) null);
                for (String str2 : split$default2) {
                    split$default3 = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"#"}, false, 0, 6, (Object) null);
                    if (split$default3.size() == 3) {
                        arrayList.add(new s(str + '(' + ((String) split$default3.get(2)) + ')', Integer.parseInt((String) split$default3.get(1)), Long.parseLong((String) split$default3.get(0))));
                    } else {
                        o.a("ProcessForegroundHelper", "info=" + str2);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void f(@NotNull String reason) {
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        if (lastState == 2) {
            return;
        }
        i(2, reason);
    }

    public final void g(@NotNull String reason) {
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        if (lastState == 1) {
            return;
        }
        i(1, reason);
    }

    public final void k(boolean isForeground, @NotNull String reason) {
        Intrinsics.checkParameterIsNotNull(reason, "reason");
        if (isForeground) {
            g(reason);
        } else {
            f(reason);
        }
    }
}
