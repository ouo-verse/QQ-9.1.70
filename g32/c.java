package g32;

import android.text.TextUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.framework.exception.QQLiveException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\u0018\b\u0002\u0010\u001f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\u0018\u00010\u001d\u00a2\u0006\u0004\b2\u00103J7\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\t\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010H\u0002J!\u0010\u0014\u001a\u00020\n\"\b\b\u0000\u0010\u0004*\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0017\u001a\u00020\u00012\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00102\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007H\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010H\u0016R\u0014\u0010\u001c\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\"\u0010$\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b\u001a\u0010!\"\u0004\b\"\u0010#R\\\u0010*\u001aJ\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00070&0%j$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00070&`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)RP\u0010,\u001a>\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00100%j\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.\u00a8\u00064"}, d2 = {"Lg32/c;", "Lg32/g;", "Lg32/h;", "Lg32/b;", "E", "", "startTime", "Lg32/j;", "listener", "event", "", "f", "(JLg32/j;Lg32/b;)V", "", "fullName", "g", "Ljava/lang/Class;", "clazz", "", "c", "w0", "(Lg32/b;)V", "key", "b", "", "e", "d", "Ljava/lang/String;", "tag", "", "Ljava/util/List;", "eventList", "I", "()I", "setDefaultMaxListeners", "(I)V", "defaultMaxListeners", "Ljava/util/HashMap;", "Ljava/util/LinkedList;", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "eventToListenerMap", "i", "listenerToEventMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lg32/j;", "preTriggerEventListener", BdhLogUtil.LogTag.Tag_Conn, "afterTriggerEventListener", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c implements g, h {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private j<b> afterTriggerEventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<Class<? extends b>> eventList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int defaultMaxListeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Class<? extends b>, LinkedList<j<? extends b>>> eventToListenerMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<j<? extends b>, Class<? extends b>> listenerToEventMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j<b> preTriggerEventListener;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull String tag, @Nullable List<? extends Class<? extends b>> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.eventList = list;
        this.defaultMaxListeners = Integer.MAX_VALUE;
        this.eventToListenerMap = new HashMap<>();
        this.listenerToEventMap = new HashMap<>();
    }

    private final boolean c(Class<? extends b> clazz) {
        List<Class<? extends b>> list = this.eventList;
        if (list == null) {
            return true;
        }
        return list.contains(clazz);
    }

    private final <E extends b> void f(long startTime, j<E> listener, E event) {
        String str;
        if (j32.c.a()) {
            long currentTimeMillis = System.currentTimeMillis() - startTime;
            if (currentTimeMillis > e32.a.a()) {
                if (listener instanceof d) {
                    Function d16 = ((d) listener).d();
                    if (d16 instanceof FunctionReference) {
                        str = ((FunctionReference) d16).getBoundReceiver().getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(str, "{\n                      \u2026ame\n                    }");
                    } else {
                        String name = d16.getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name, "invoke::class.java.name");
                        str = g(name);
                    }
                } else if (listener instanceof a) {
                    Function c16 = ((a) listener).c();
                    if (c16 instanceof FunctionReference) {
                        str = ((FunctionReference) c16).getBoundReceiver().getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(str, "{\n                      \u2026ame\n                    }");
                    } else {
                        String name2 = c16.getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "invoke::class.java.name");
                        str = g(name2);
                    }
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    String name3 = listener.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name3, "listener::class.java.name");
                    str = g(name3);
                }
                j32.b.f409197a.i(e32.a.c(), "trigger " + event.getClass().getSimpleName() + " to " + str + " \u8017\u65f6:" + currentTimeMillis);
            }
        }
    }

    private final String g(String fullName) {
        int indexOf$default;
        int lastIndexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) fullName, "$", 0, false, 6, (Object) null);
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) fullName, ".", 0, false, 6, (Object) null);
        int i3 = lastIndexOf$default + 1;
        if (indexOf$default > 0 && indexOf$default > i3) {
            String substring = fullName.substring(i3, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring;
        }
        return "";
    }

    @Override // g32.g
    @NotNull
    public g b(@NotNull Class<? extends b> key, @NotNull j<? extends b> listener) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (getDefaultMaxListeners() == 0 || e(key) < getDefaultMaxListeners()) {
            if (!this.eventToListenerMap.containsKey(key)) {
                this.eventToListenerMap.put(key, new LinkedList<>());
            }
            LinkedList<j<? extends b>> linkedList = this.eventToListenerMap.get(key);
            if (linkedList != null) {
                linkedList.add(listener);
            }
            this.listenerToEventMap.put(listener, key);
        }
        return this;
    }

    /* renamed from: d, reason: from getter */
    public int getDefaultMaxListeners() {
        return this.defaultMaxListeners;
    }

    public int e(@NotNull Class<? extends b> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        LinkedList<j<? extends b>> linkedList = this.eventToListenerMap.get(key);
        if (linkedList != null) {
            return linkedList.size();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g32.h
    public <E extends b> void w0(@NotNull E event) {
        long j3;
        long j16;
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        Class<?> cls = event.getClass();
        if (!c(cls)) {
            e32.c.d(new QQLiveException("\u5f53\u524dEvent(" + cls.getSimpleName() + ")\u4e0d\u652f\u6301\u88abEventBroadcaster\u53d1\u9001"));
            return;
        }
        j<b> jVar = this.preTriggerEventListener;
        if (jVar != null) {
            jVar.a(event);
        }
        if (j32.c.a()) {
            j3 = System.currentTimeMillis();
            l tag = event.getTag();
            if (tag != null) {
                String simpleName = tag.a().getSimpleName();
                if (TextUtils.equals(simpleName, tag.getKey())) {
                    str = "";
                } else {
                    str = "_" + tag.getKey();
                }
                String str2 = simpleName + str;
                j32.b.f409197a.i(e32.a.c(), "start " + str2 + " start trigger " + event.getClass().getSimpleName());
            }
        } else {
            j3 = -1;
        }
        if (this.eventToListenerMap.containsKey(event.getClass())) {
            LinkedList linkedList = new LinkedList();
            LinkedList<j<? extends b>> linkedList2 = this.eventToListenerMap.get(cls);
            if (linkedList2 != null) {
                Iterator<T> it = linkedList2.iterator();
                while (it.hasNext()) {
                    j jVar2 = (j) it.next();
                    Intrinsics.checkNotNull(jVar2, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.framework.eventbroadcaster.Listener<E of com.tencent.mobileqq.icgame.framework.eventbroadcaster.EventBroadcaster.trigger$lambda$1>");
                    if (j32.c.a()) {
                        j16 = System.currentTimeMillis();
                    } else {
                        j16 = -1;
                    }
                    try {
                        try {
                            jVar2.a(event);
                        } catch (Exception e16) {
                            if (!e32.c.e(e16)) {
                                throw e16;
                            }
                        }
                        if (jVar2.getIsOnce()) {
                            linkedList.add(jVar2);
                        }
                    } finally {
                        f(j16, jVar2, event);
                    }
                }
            }
            if (j32.c.a()) {
                long currentTimeMillis = System.currentTimeMillis() - j3;
                if (currentTimeMillis > e32.a.b()) {
                    j32.b.f409197a.i(e32.a.c(), "trigger " + event.getClass().getSimpleName() + " \u603b\u8017\u65f6:" + currentTimeMillis);
                }
                j32.b.f409197a.i(e32.a.c(), "trigger " + event.getClass().getSimpleName() + " end!");
            }
            Iterator it5 = linkedList.iterator();
            while (it5.hasNext()) {
                j jVar3 = (j) it5.next();
                LinkedList<j<? extends b>> linkedList3 = this.eventToListenerMap.get(cls);
                if (linkedList3 != null) {
                    linkedList3.remove(jVar3);
                }
            }
        }
        j<b> jVar4 = this.afterTriggerEventListener;
        if (jVar4 != null) {
            jVar4.a(event);
        }
    }
}
