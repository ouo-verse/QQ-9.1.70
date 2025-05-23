package jq1;

import android.util.SparseArray;
import com.tencent.mobileqq.guild.live.danmu.item.GLiveDanmuPriority;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002R'\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Ljq1/a;", "", "", "viewType", "Ljq1/e;", "kotlin.jvm.PlatformType", "b", "Lcom/tencent/mobileqq/guild/live/danmu/item/GLiveDanmuPriority;", "a", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getHIGH_PRIORITY_MSG_TYPE", "()Ljava/util/ArrayList;", "HIGH_PRIORITY_MSG_TYPE", "c", "getLOW_PRIORITY_MSG_TYPE", "LOW_PRIORITY_MSG_TYPE", "Landroid/util/SparseArray;", "d", "Landroid/util/SparseArray;", "itemFactoryArray", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f410847a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<Integer> HIGH_PRIORITY_MSG_TYPE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<Integer> LOW_PRIORITY_MSG_TYPE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<e> itemFactoryArray;

    static {
        ArrayList<Integer> arrayListOf;
        ArrayList<Integer> arrayListOf2;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(27, 28, 43, 42);
        HIGH_PRIORITY_MSG_TYPE = arrayListOf;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(30);
        LOW_PRIORITY_MSG_TYPE = arrayListOf2;
        SparseArray<e> sparseArray = new SparseArray<>();
        d dVar = new d();
        sparseArray.put(7, dVar);
        sparseArray.put(6, dVar);
        sparseArray.put(24, dVar);
        sparseArray.put(23, dVar);
        b bVar = new b();
        sparseArray.put(30, bVar);
        sparseArray.put(31, bVar);
        c cVar = new c();
        sparseArray.put(27, cVar);
        sparseArray.put(28, cVar);
        sparseArray.put(43, cVar);
        sparseArray.put(42, cVar);
        itemFactoryArray = sparseArray;
    }

    a() {
    }

    @NotNull
    public final GLiveDanmuPriority a(int viewType) {
        if (HIGH_PRIORITY_MSG_TYPE.contains(Integer.valueOf(viewType))) {
            return GLiveDanmuPriority.HIGH;
        }
        if (LOW_PRIORITY_MSG_TYPE.contains(Integer.valueOf(viewType))) {
            return GLiveDanmuPriority.LOW;
        }
        return GLiveDanmuPriority.NORMAL;
    }

    public final e b(int viewType) {
        return itemFactoryArray.get(viewType);
    }
}
