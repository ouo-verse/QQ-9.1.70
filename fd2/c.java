package fd2;

import android.util.LruCache;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\b\u0016\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lfd2/c;", "Lfd2/a;", "", "", "str", "", "c", "", "b", "tag", "msg", "putString", "", "a", "", QCircleLpReportDc05507.KEY_CLEAR, "", "Ljava/util/List;", "whiteList", "I", "maintainCount", "threshold", "Landroid/util/LruCache;", "d", "Landroid/util/LruCache;", "map", "e", "J", "count", "<init>", "(Ljava/util/List;II)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements a<String, Integer> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> whiteList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int maintainCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int threshold;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, Integer> map;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long count;

    public c(@NotNull List<String> whiteList, int i3, int i16) {
        Intrinsics.checkNotNullParameter(whiteList, "whiteList");
        this.whiteList = whiteList;
        this.maintainCount = i3;
        this.threshold = i16;
        this.map = new LruCache<>(i3 + whiteList.size());
    }

    private final boolean c(String str) {
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
    @NotNull
    public Map<String, Integer> a() {
        Map<String, Integer> snapshot;
        synchronized (this.map) {
            snapshot = this.map.snapshot();
        }
        HashMap hashMap = new HashMap();
        Intrinsics.checkNotNullExpressionValue(snapshot, "snapshot");
        for (Map.Entry<String, Integer> entry : snapshot.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (!c(key)) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                if (value.intValue() >= this.threshold) {
                    hashMap.put(key, value);
                }
            }
        }
        return hashMap;
    }

    @Override // fd2.a
    public void b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.count++;
        synchronized (this.map) {
            if (this.map.get(str) != null) {
                LruCache<String, Integer> lruCache = this.map;
                lruCache.put(str, Integer.valueOf(lruCache.get(str).intValue() + 1));
            } else {
                this.map.put(str, 1);
            }
        }
    }

    @Override // fd2.a
    public long clear() {
        synchronized (this.map) {
            this.map.evictAll();
            Unit unit = Unit.INSTANCE;
        }
        long j3 = this.count;
        this.count = 0L;
        return j3;
    }

    @Override // fd2.a
    public void putString(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        b(tag + QbAddrData.DATA_SPLITER + msg2);
    }
}
