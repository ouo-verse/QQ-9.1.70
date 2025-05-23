package fd2;

import android.util.LruCache;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lfd2/b;", "Lfd2/a;", "", "", "str", "", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "", QCircleLpReportDc05507.KEY_CLEAR, "", "b", "tag", "msg", "putString", "", "a", "Ljava/util/List;", "whiteList", "I", "maintainCount", "threshold", "Landroid/util/LruCache;", "Lfd2/b$a;", "Landroid/util/LruCache;", "map", "e", "J", "count", "<init>", "(II)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements fd2.a<String, Integer> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> whiteList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int maintainCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int threshold;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, a> map;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long count;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lfd2/b$a;", "Lcom/tencent/commonsdk/pool/RecyclablePool$Recyclable;", "", "str", "", "c", "b", "recycle", "Landroid/util/LruCache;", "", h.F, "Landroid/util/LruCache;", "getMsgs", "()Landroid/util/LruCache;", "msgs", "i", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "tag", "j", "I", "a", "()I", "setCount", "(I)V", "count", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends RecyclablePool.Recyclable {

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LruCache<String, Integer> msgs = new LruCache<>(10);

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String tag = "";

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int count;

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        @NotNull
        public final String b() {
            Map<String, Integer> snapshot = this.msgs.snapshot();
            Intrinsics.checkNotNullExpressionValue(snapshot, "msgs.snapshot()");
            Iterator<Map.Entry<String, Integer>> it = snapshot.entrySet().iterator();
            if (!it.hasNext()) {
                return "{}";
            }
            StringBuilder sb5 = new StringBuilder();
            while (true) {
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int intValue = next.getValue().intValue();
                sb5.append(key);
                sb5.append(',');
                sb5.append(intValue);
                if (!it.hasNext()) {
                    String sb6 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                    return sb6;
                }
                sb5.append("\u3001");
            }
        }

        public final void c(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            this.count++;
            synchronized (this.msgs) {
                if (this.msgs.get(str) != null) {
                    LruCache<String, Integer> lruCache = this.msgs;
                    lruCache.put(str, Integer.valueOf(lruCache.get(str).intValue() + 1));
                } else {
                    this.msgs.put(str, 1);
                }
            }
        }

        public final void d(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tag = str;
        }

        @Override // com.tencent.commonsdk.pool.RecyclablePool.Recyclable
        public void recycle() {
            super.recycle();
            this.tag = "";
            this.msgs.evictAll();
            this.count = 0;
        }
    }

    public b(int i3, int i16) {
        this.maintainCount = i3;
        this.threshold = i16;
        this.map = new LruCache<>(i3);
    }

    private final boolean d(String str) {
        boolean contains$default;
        List<String> list = this.whiteList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) it.next(), false, 2, (Object) null);
                if (contains$default) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // fd2.a
    public void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
    }

    @Override // fd2.a
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public HashMap<String, Integer> a() {
        Map<String, a> snapshot;
        synchronized (this.map) {
            snapshot = this.map.snapshot();
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        Intrinsics.checkNotNullExpressionValue(snapshot, "snapshot");
        for (Map.Entry<String, a> entry : snapshot.entrySet()) {
            String tag = entry.getKey();
            a value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(tag, "tag");
            if (!d(tag) && value.getCount() >= this.threshold) {
                hashMap.put(tag + QbAddrData.DATA_SPLITER + value.b(), Integer.valueOf(value.getCount()));
            }
        }
        return hashMap;
    }

    @Override // fd2.a
    public long clear() {
        synchronized (this.map) {
            this.map.evictAll();
            Unit unit = Unit.INSTANCE;
        }
        return this.count;
    }

    @Override // fd2.a
    public void putString(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.count++;
        synchronized (this.map) {
            a aVar = this.map.get(tag);
            if (aVar != null) {
                aVar.c(msg2);
                Unit unit = Unit.INSTANCE;
            } else {
                a aVar2 = new a();
                aVar2.d(tag);
                aVar2.c(msg2);
                this.map.put(tag, aVar2);
            }
        }
    }
}
