package com.tencent.input.base.mvicompat;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.input.base.mvicompat.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u0005*\u000e\b\u0003\u0010\b*\b\u0012\u0004\u0012\u00028\u00010\u00072\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00030\t2\b\u0012\u0004\u0012\u00028\u00020\nJ\u0012\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u000bH&J\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/input/base/mvicompat/e;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/input/base/mvicompat/b;", "H", "Lcom/tencent/input/base/mvicompat/a;", "Lcom/tencent/input/base/mvicompat/f;", "Ljava/lang/Class;", "d0", "intent", "", "J", "(Lol3/b;)V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface e<I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b, H extends b<S>> extends com.tencent.input.base.mvicompat.a<S, I, H>, f<C> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class a {
        public static <I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b, H extends b<S>> void a(@NotNull e<I, S, C, H> eVar, @NotNull I intent) {
            Intrinsics.checkNotNullParameter(eVar, "this");
            Intrinsics.checkNotNullParameter(intent, "intent");
            eVar.J(intent);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.core.util.Consumer, com.tencent.input.base.mvicompat.b] */
        public static <I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b, H extends b<S>> void b(@NotNull e<I, S, C, H> eVar, @NotNull S state) {
            Intrinsics.checkNotNullParameter(eVar, "this");
            Intrinsics.checkNotNullParameter(state, "state");
            eVar.M().accept(state);
        }
    }

    void J(@NotNull I intent);

    @Nullable
    Class<? extends I> d0();
}
