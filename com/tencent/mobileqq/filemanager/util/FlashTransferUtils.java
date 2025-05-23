package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.R;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/FlashTransferUtils;", "", "", "type", "a", "", "b", "Lkotlin/Lazy;", "()Ljava/util/Map;", "mIconResMap", "<init>", "()V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlashTransferUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FlashTransferUtils f209184a = new FlashTransferUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mIconResMap;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<Integer, ? extends Integer>>() { // from class: com.tencent.mobileqq.filemanager.util.FlashTransferUtils$mIconResMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Integer, ? extends Integer> invoke() {
                Map<Integer, ? extends Integer> mapOf;
                Integer valueOf = Integer.valueOf(R.drawable.mtx);
                Integer valueOf2 = Integer.valueOf(R.drawable.mtj);
                Integer valueOf3 = Integer.valueOf(R.drawable.mtr);
                Integer valueOf4 = Integer.valueOf(R.drawable.mtv);
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, Integer.valueOf(R.drawable.mtq)), TuplesKt.to(1, Integer.valueOf(R.drawable.mth)), TuplesKt.to(2, Integer.valueOf(R.drawable.mtw)), TuplesKt.to(3, valueOf), TuplesKt.to(4, Integer.valueOf(R.drawable.mty)), TuplesKt.to(5, Integer.valueOf(R.drawable.mtg)), TuplesKt.to(6, valueOf2), TuplesKt.to(7, valueOf3), TuplesKt.to(8, Integer.valueOf(R.drawable.mtl)), TuplesKt.to(9, Integer.valueOf(R.drawable.mtp)), TuplesKt.to(10, Integer.valueOf(R.drawable.mtu)), TuplesKt.to(11, valueOf4), TuplesKt.to(12, Integer.valueOf(R.drawable.mts)), TuplesKt.to(13, valueOf), TuplesKt.to(14, Integer.valueOf(R.drawable.mtf)), TuplesKt.to(16, Integer.valueOf(R.drawable.mtm)), TuplesKt.to(17, valueOf3), TuplesKt.to(19, valueOf2), TuplesKt.to(20, valueOf), TuplesKt.to(21, Integer.valueOf(R.drawable.mtt)), TuplesKt.to(-1, valueOf4));
                return mapOf;
            }
        });
        mIconResMap = lazy;
    }

    FlashTransferUtils() {
    }

    private final Map<Integer, Integer> b() {
        return (Map) mIconResMap.getValue();
    }

    public final int a(int type) {
        int i3;
        Integer num = b().get(Integer.valueOf(type));
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return R.drawable.mtv;
        }
        return i3;
    }
}
