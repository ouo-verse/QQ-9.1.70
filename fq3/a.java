package fq3;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qconn.protofile.OpenSdkRecCommon$PromoteViewItem;
import gq3.b;
import gq3.d;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lfq3/a;", "", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/qconn/protofile/OpenSdkRecCommon$PromoteViewItem;", "data", "Landroid/view/View;", "a", "", "Lgq3/b;", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "b", "opensdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/OpenSdk/Inject_RecommendProcessor.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<b>> f400325c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> mProcessorList;

    static {
        ArrayList<Class<b>> arrayList = new ArrayList<>();
        f400325c = arrayList;
        arrayList.add(d.class);
        arrayList.add(gq3.a.class);
    }

    public a() {
        int collectionSizeOrDefault;
        Object first;
        ArrayList<Class<b>> arrayList = f400325c;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.open.recommend.processor.IRecProcessor");
            arrayList2.add((b) newInstance);
        }
        this.mProcessorList = arrayList2;
    }

    @NotNull
    public final View a(@NotNull ViewGroup viewGroup, @NotNull OpenSdkRecCommon$PromoteViewItem data) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(data, "data");
        for (b bVar : this.mProcessorList) {
            if (bVar.b(data.type.get())) {
                return bVar.a(viewGroup, data);
            }
        }
        return new gq3.a().a(viewGroup, data);
    }
}
