package com.tencent.input.base.mvicompat;

import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0000*\u00020\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/input/base/mvicompat/d;", "Landroidx/viewbinding/ViewBinding;", "V", "", "binding", "", "c", "(Landroidx/viewbinding/ViewBinding;)V", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface d<V extends ViewBinding> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class a {
        public static <V extends ViewBinding> void a(@NotNull d<? super V> dVar) {
            Intrinsics.checkNotNullParameter(dVar, "this");
        }

        public static <V extends ViewBinding> void b(@NotNull d<? super V> dVar) {
            Intrinsics.checkNotNullParameter(dVar, "this");
        }

        public static <V extends ViewBinding> void c(@NotNull d<? super V> dVar, @NotNull com.tencent.mvi.api.help.b reuseParam) {
            Intrinsics.checkNotNullParameter(dVar, "this");
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        }
    }

    void a();

    void c(@NotNull V binding);

    void d(@NotNull com.tencent.mvi.api.help.b reuseParam);

    void onDestroy();
}
