package com.tencent.aio.monitor.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010Rh\u0010\u0017\u001aV\u0012\u0004\u0012\u00020\u000b\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014`\u00150\u0013j*\u0012\u0004\u0012\u00020\u000b\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014`\u0015`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0099\u0001\u0010\u001a\u001a\u0086\u0001\u0012\u0004\u0012\u00020\u000b\u00128\u00126\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u00180\u0013j\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0018`\u00150\u0013jB\u0012\u0004\u0012\u00020\u000b\u00128\u00126\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u00180\u0013j\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0018`\u0015`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001bR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\b0\u001dj\b\u0012\u0004\u0012\u00020\b`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/aio/monitor/trace/TraceTimeReport;", "", "", "b", "Lcom/tencent/aio/api/runtime/a;", "context", "e", "g", "Lcom/tencent/aio/monitor/trace/a;", "callback", "a", "", "tag", "subTag", "f", "c", "", "isEnable", "d", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "startTimeMap", "Lkotlin/Pair;", "", "avgTimeCost", "Z", "isTraceEnable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "callbacks", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class TraceTimeReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, HashMap<String, Long>> startTimeMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, HashMap<String, Pair<Integer, Long>>> avgTimeCost;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isTraceEnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<a> callbacks;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final TraceTimeReport f69439e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45458);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f69439e = new TraceTimeReport();
        startTimeMap = new HashMap<>();
        avgTimeCost = new HashMap<>();
        callbacks = new ArrayList<>();
    }

    TraceTimeReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    private final void b() {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new TraceTimeReport$callbackTrace$1(new ArrayList(callbacks), new HashMap(avgTimeCost), null), 3, null);
    }

    public final void a(@NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            callbacks.add(callback);
        }
    }

    public final void c(@NotNull String tag, @NotNull String subTag) {
        Long valueOf;
        int i3;
        long j3;
        Long second;
        Integer first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tag, (Object) subTag);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        if (!isTraceEnable) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = startTimeMap.get(tag);
        if (hashMap == null || (valueOf = hashMap.get(subTag)) == null) {
            valueOf = Long.valueOf(currentTimeMillis);
        }
        Intrinsics.checkNotNullExpressionValue(valueOf, "startTimeMap[tag]?.get(subTag) ?: curTime");
        long longValue = currentTimeMillis - valueOf.longValue();
        HashMap<String, HashMap<String, Pair<Integer, Long>>> hashMap2 = avgTimeCost;
        HashMap<String, Pair<Integer, Long>> hashMap3 = hashMap2.get(tag);
        if (hashMap3 == null) {
            hashMap3 = new HashMap<>();
            hashMap2.put(tag, hashMap3);
        }
        HashMap<String, Pair<Integer, Long>> hashMap4 = hashMap3;
        Pair<Integer, Long> pair = hashMap4.get(subTag);
        if (pair != null && (first = pair.getFirst()) != null) {
            i3 = first.intValue();
        } else {
            i3 = 0;
        }
        Pair<Integer, Long> pair2 = hashMap4.get(subTag);
        if (pair2 != null && (second = pair2.getSecond()) != null) {
            j3 = second.longValue();
        } else {
            j3 = 0;
        }
        int i16 = i3 + 1;
        hashMap4.put(subTag, new Pair<>(Integer.valueOf(i16), Long.valueOf(((j3 * i3) + longValue) / i16)));
    }

    public final void d(boolean isEnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, isEnable);
        } else {
            isTraceEnable = isEnable;
        }
    }

    public final void e(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        startTimeMap.clear();
        avgTimeCost.clear();
    }

    public final void f(@NotNull String tag, @NotNull String subTag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) subTag);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        if (!isTraceEnable) {
            return;
        }
        HashMap<String, HashMap<String, Long>> hashMap = startTimeMap;
        HashMap<String, Long> hashMap2 = hashMap.get(tag);
        if (hashMap2 == null) {
            hashMap2 = new HashMap<>();
            hashMap.put(tag, hashMap2);
        }
        hashMap2.put(subTag, Long.valueOf(System.currentTimeMillis()));
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (isTraceEnable) {
            b();
            callbacks.clear();
        }
    }
}
