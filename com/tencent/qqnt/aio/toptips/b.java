package com.tencent.qqnt.aio.toptips;

import android.view.View;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0002\"\u0004\u0018\u00010\u0001H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J7\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0002\"\u0004\u0018\u00010\u0001H&\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/toptips/b;", "", "", "params", "Landroid/view/View;", "a", "([Ljava/lang/Object;)Landroid/view/View;", "Lcom/tencent/qqnt/aio/toptips/c;", "topTipsManager", "", "eventType", "", "g", "(Lcom/tencent/qqnt/aio/toptips/c;I[Ljava/lang/Object;)V", "j", "()I", "barPriority", "getType", "type", "", "b", "()[I", "excludeTypes", "", "", "d", "()Ljava/util/Map;", "reportParam", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        @NotNull
        public static Map<String, String> a(@NotNull b bVar) {
            Map<String, String> emptyMap;
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
    }

    @Nullable
    View a(@NotNull Object... params);

    @Nullable
    int[] b();

    @NotNull
    Map<String, String> d();

    void g(@NotNull c topTipsManager, int eventType, @NotNull Object... params);

    int getType();

    int j();
}
