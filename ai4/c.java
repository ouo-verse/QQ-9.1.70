package ai4;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002#\u0011B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fR\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001f\u00a8\u0006$"}, d2 = {"Lai4/c;", "", "", h.F, "()Ljava/lang/Boolean;", "", "Lai4/a;", "f", "e", "", "uid", "", "j", "d", "i", "Lai4/c$a;", "observer", "b", "c", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "mapGiftReceiver", "Ljava/util/HashSet;", "Ljava/util/HashSet;", "lsObserver", "J", "defaultSelectUid", "Lai4/a;", "hostReceiver", "Ljava/lang/ref/WeakReference;", "Lai4/c$b;", "Ljava/lang/ref/WeakReference;", "multiAvChatCallbackRef", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f26122a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<Long, GiftReceiver> mapGiftReceiver = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashSet<a> lsObserver = new HashSet<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long defaultSelectUid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static GiftReceiver hostReceiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<b> multiAvChatCallbackRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lai4/c$a;", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lai4/c$b;", "", "", "isStarted", "()Ljava/lang/Boolean;", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        @Nullable
        Boolean a();

        @Nullable
        Boolean isStarted();
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(GiftReceiver giftReceiver, GiftReceiver giftReceiver2) {
        return Intrinsics.compare(giftReceiver.getSeatNo(), giftReceiver2.getSeatNo());
    }

    private final Boolean h() {
        b bVar;
        WeakReference<b> weakReference = multiAvChatCallbackRef;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            return bVar.a();
        }
        return null;
    }

    public final void b(@NotNull a observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        lsObserver.add(observer);
    }

    public final void c(@NotNull a observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        lsObserver.remove(observer);
    }

    public final long d() {
        if (mapGiftReceiver.get(Long.valueOf(defaultSelectUid)) == null) {
            return 0L;
        }
        return defaultSelectUid;
    }

    @Nullable
    public final GiftReceiver e() {
        return hostReceiver;
    }

    @NotNull
    public final List<GiftReceiver> f() {
        if (Intrinsics.areEqual(h(), Boolean.FALSE)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(mapGiftReceiver.values());
        if (hostReceiver == null) {
            return arrayList;
        }
        if (arrayList.isEmpty()) {
            GiftReceiver giftReceiver = hostReceiver;
            Intrinsics.checkNotNull(giftReceiver);
            arrayList.add(giftReceiver);
        } else {
            GiftReceiver giftReceiver2 = hostReceiver;
            Intrinsics.checkNotNull(giftReceiver2);
            arrayList.add(0, giftReceiver2);
        }
        Collections.sort(arrayList, new Comparator() { // from class: ai4.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int g16;
                g16 = c.g((GiftReceiver) obj, (GiftReceiver) obj2);
                return g16;
            }
        });
        return arrayList;
    }

    @Nullable
    public final Boolean i() {
        b bVar;
        WeakReference<b> weakReference = multiAvChatCallbackRef;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            return bVar.isStarted();
        }
        return null;
    }

    public final void j(long uid) {
        defaultSelectUid = uid;
    }
}
