package com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import androidx.collection.LruCache;
import com.tencent.cachedrawable.dynamicdrawable.f;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0006\u0010\u000f\u001a\u00020\u000eR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0018\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00070%j\b\u0012\u0004\u0012\u00020\u0007`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010'R\u0016\u0010*\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/c;", "Lcom/tencent/cachedrawable/dynamicdrawable/f;", "", "f", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameAnimData", "d", "", "key", "a", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "e", "", h.F, "I", "g", "()I", "j", "(I)V", "LRU_CACHE_MAX_SIZE", "c", "FRAME_MIN_SIZE", "FRAME_ADD_SIZE", "FRAME_MAX_SIZE", "", "J", "REMOVE_TIME", "CLEAR_TASK_INTERVAL_TIME", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/c$a;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/c$a;", "frameLruCache", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "workHandler", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "frameKeyList", "k", "lastExecuteClearTaskTime", "Ljava/lang/Runnable;", "l", "Ljava/lang/Runnable;", "runnable", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class c implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f98952a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int LRU_CACHE_MAX_SIZE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int FRAME_MIN_SIZE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int FRAME_ADD_SIZE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int FRAME_MAX_SIZE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long REMOVE_TIME;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long CLEAR_TASK_INTERVAL_TIME;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a<String, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b> frameLruCache;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Handler workHandler;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<String> frameKeyList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static long lastExecuteClearTaskTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable runnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0014\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/c$a;", "", "K", "V", "Landroidx/collection/LruCache;", "key", "value", "", "sizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "maxSize", "<init>", "(I)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public static final class a<K, V> extends LruCache<K, V> {
        static IPatchRedirector $redirector_;

        public a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.collection.LruCache
        public int sizeOf(@NotNull K key, @NotNull V value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, (Object) value)).intValue();
            }
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b) {
                return ((com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b) value).g();
            }
            return super.sizeOf(key, value);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10952);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f98952a = new c();
        FRAME_MIN_SIZE = 15728640;
        FRAME_ADD_SIZE = 10485760;
        FRAME_MAX_SIZE = 104857600;
        REMOVE_TIME = 10000L;
        CLEAR_TASK_INTERVAL_TIME = 5000L;
        frameLruCache = new a<>(15728640);
        workHandler = new Handler(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.h.f99037a.f().getLooper());
        frameKeyList = new ArrayList<>();
        runnable = new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache.b
            @Override // java.lang.Runnable
            public final void run() {
                c.i();
            }
        };
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameAnimData) {
        int coerceAtLeast;
        a<String, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b> aVar = frameLruCache;
        if (aVar.size() + frameAnimData.g() > aVar.maxSize()) {
            int maxSize = aVar.maxSize() + (FRAME_ADD_SIZE * ((frameAnimData.g() / FRAME_ADD_SIZE) + 1));
            if (maxSize >= FRAME_MAX_SIZE) {
                return;
            }
            aVar.resize(maxSize);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(LRU_CACHE_MAX_SIZE, maxSize);
            LRU_CACHE_MAX_SIZE = coerceAtLeast;
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.a("FrameLruCache", "saveFrame resize resetMaxSize : " + maxSize + " curSize : " + aVar.size());
        }
    }

    private final void f() {
        if (frameLruCache.size() < FRAME_MIN_SIZE) {
            return;
        }
        if (SystemClock.uptimeMillis() - lastExecuteClearTaskTime > CLEAR_TASK_INTERVAL_TIME) {
            runnable.run();
        }
        Handler handler = workHandler;
        Runnable runnable2 = runnable;
        handler.removeCallbacks(runnable2);
        workHandler.postDelayed(runnable2, REMOVE_TIME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        int coerceAtLeast;
        int coerceAtLeast2;
        synchronized (frameLruCache) {
            lastExecuteClearTaskTime = SystemClock.uptimeMillis();
            Ref.IntRef intRef = new Ref.IntRef();
            int size = frameKeyList.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i3 = size - 1;
                    String str = frameKeyList.get(size);
                    Intrinsics.checkNotNullExpressionValue(str, "frameKeyList[i]");
                    String str2 = str;
                    a<String, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b> aVar = frameLruCache;
                    com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar = aVar.get(str2);
                    if (bVar == null) {
                        frameKeyList.remove(size);
                    }
                    if (bVar != null) {
                        int g16 = intRef.element + bVar.g();
                        intRef.element = g16;
                        if (g16 >= FRAME_MIN_SIZE && SystemClock.uptimeMillis() - bVar.b() > REMOVE_TIME) {
                            aVar.remove(str2);
                            frameKeyList.remove(str2);
                        }
                    }
                    if (i3 < 0) {
                        break;
                    } else {
                        size = i3;
                    }
                }
            }
            a<String, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b> aVar2 = frameLruCache;
            int size2 = aVar2.size();
            int i16 = FRAME_MIN_SIZE;
            if (size2 > i16) {
                i16 = ((aVar2.size() - FRAME_MIN_SIZE) / FRAME_ADD_SIZE) + 1;
            }
            int i17 = FRAME_MIN_SIZE;
            int i18 = FRAME_ADD_SIZE;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i16, 0);
            int i19 = i17 + (i18 * coerceAtLeast);
            if (i19 >= FRAME_MAX_SIZE) {
                return;
            }
            if (i19 != aVar2.maxSize()) {
                aVar2.resize(i19);
                c cVar = f98952a;
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(cVar.g(), i19);
                cVar.j(coerceAtLeast2);
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.a("FrameLruCache", "getFrame resize resetMaxSize : " + i19 + " curSize : " + aVar2.size());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.f
    public void a(@NotNull String key, @NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameAnimData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) key, (Object) frameAnimData);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(frameAnimData, "frameAnimData");
        a<String, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b> aVar = frameLruCache;
        synchronized (aVar) {
            f98952a.d(frameAnimData);
            frameAnimData.j(SystemClock.uptimeMillis());
            aVar.put(key, frameAnimData);
            if (com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.l()) {
                frameKeyList.remove(key);
            }
            frameKeyList.add(0, key);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.f
    @Nullable
    public com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b b(@NotNull String key, @Nullable Bitmap bitmap) {
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) key, (Object) bitmap);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        a<String, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b> aVar = frameLruCache;
        synchronized (aVar) {
            bVar = aVar.get(key);
            if (bVar != null) {
                bVar.j(SystemClock.uptimeMillis());
                frameKeyList.remove(key);
                frameKeyList.add(0, key);
            }
            f98952a.f();
        }
        return bVar;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        a<String, com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b> aVar = frameLruCache;
        synchronized (aVar) {
            aVar.evictAll();
            frameKeyList.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return LRU_CACHE_MAX_SIZE;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return frameLruCache.maxSize();
    }

    public final void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            LRU_CACHE_MAX_SIZE = i3;
        }
    }
}
