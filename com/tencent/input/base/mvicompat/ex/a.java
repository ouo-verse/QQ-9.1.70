package com.tencent.input.base.mvicompat.ex;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0012\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/input/base/mvicompat/ex/a;", "", "", "", "J2", "f0", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "", "E", "Lcom/tencent/mvi/base/route/k;", "I", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.tencent.input.base.mvicompat.ex.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5857a {
        @Nullable
        public static List<String> a(@NotNull a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "this");
            return null;
        }

        @Nullable
        public static List<String> b(@NotNull a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "this");
            return null;
        }

        public static void c(@NotNull a aVar, @NotNull MsgIntent event) {
            Intrinsics.checkNotNullParameter(aVar, "this");
            Intrinsics.checkNotNullParameter(event, "event");
        }

        @NotNull
        public static k d(@NotNull a aVar, @NotNull MsgIntent event) {
            Intrinsics.checkNotNullParameter(aVar, "this");
            Intrinsics.checkNotNullParameter(event, "event");
            return new com.tencent.input.base.utils.a();
        }
    }

    void E(@NotNull MsgIntent event);

    @NotNull
    k I(@NotNull MsgIntent event);

    @Nullable
    List<String> J2();

    @Nullable
    List<String> f0();
}
