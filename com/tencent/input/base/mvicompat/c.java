package com.tencent.input.base.mvicompat;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.tencent.input.base.mvicompat.b;
import com.tencent.input.base.mvicompat.d;
import com.tencent.mvi.api.ability.c;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\b\u0002\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0005*\b\b\u0003\u0010\b*\u00020\u00072\b\u0012\u0004\u0012\u00028\u00030\t2\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n2\u00020\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0011\u0018\u00010\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/input/base/mvicompat/c;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/input/base/mvicompat/b;", "H", "Landroidx/viewbinding/ViewBinding;", "V", "Lcom/tencent/input/base/mvicompat/d;", "Lcom/tencent/input/base/mvicompat/a;", "Lcom/tencent/mvi/api/ability/c;", "state", "", "handleUIState", "(Lcom/tencent/mvi/base/mvi/MviUIState;)V", "", "Ljava/lang/Class;", "getObserverStates", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface c<I extends ol3.b, S extends MviUIState, H extends b<I>, V extends ViewBinding> extends d<V>, com.tencent.input.base.mvicompat.a<I, S, H>, com.tencent.mvi.api.ability.c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class a {
        public static <I extends ol3.b, S extends MviUIState, H extends b<I>, V extends ViewBinding> void a(@NotNull c<I, S, H, V> cVar, @NotNull S state) {
            Intrinsics.checkNotNullParameter(cVar, "this");
            Intrinsics.checkNotNullParameter(state, "state");
            cVar.handleUIState(state);
        }

        public static <I extends ol3.b, S extends MviUIState, H extends b<I>, V extends ViewBinding> void b(@NotNull c<I, S, H, V> cVar) {
            Intrinsics.checkNotNullParameter(cVar, "this");
            d.a.a(cVar);
        }

        @MainThread
        @Nullable
        public static <I extends ol3.b, S extends MviUIState, H extends b<I>, V extends ViewBinding> Bundle c(@NotNull c<I, S, H, V> cVar, @NotNull com.tencent.mvi.api.ability.d stateCmd) {
            Intrinsics.checkNotNullParameter(cVar, "this");
            Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
            return c.a.a(cVar, stateCmd);
        }

        public static <I extends ol3.b, S extends MviUIState, H extends b<I>, V extends ViewBinding> void d(@NotNull c<I, S, H, V> cVar) {
            Intrinsics.checkNotNullParameter(cVar, "this");
            d.a.b(cVar);
        }

        public static <I extends ol3.b, S extends MviUIState, H extends b<I>, V extends ViewBinding> void e(@NotNull c<I, S, H, V> cVar, @NotNull com.tencent.mvi.api.help.b reuseParam) {
            Intrinsics.checkNotNullParameter(cVar, "this");
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
            d.a.c(cVar, reuseParam);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.core.util.Consumer, com.tencent.input.base.mvicompat.b] */
        public static <I extends ol3.b, S extends MviUIState, H extends b<I>, V extends ViewBinding> void f(@NotNull c<I, S, H, V> cVar, @NotNull I intent) {
            Intrinsics.checkNotNullParameter(cVar, "this");
            Intrinsics.checkNotNullParameter(intent, "intent");
            cVar.M().accept(intent);
        }
    }

    @Nullable
    List<Class<? extends S>> getObserverStates();

    void handleUIState(@NotNull S state);
}
