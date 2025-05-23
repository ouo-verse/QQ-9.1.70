package com.tencent.mvi.mvvm;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mvi/mvvm/b;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface b<I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> {
    @NotNull
    View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes21.dex */
    public static final class a {
        @Nullable
        public static <I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> BaseVM<I, S, C> b(@NotNull b<I, S, C> bVar) {
            return null;
        }

        @NotNull
        public static <I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> List<Class<? extends S>> c(@NotNull b<I, S, C> bVar) {
            List<Class<? extends S>> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        public static <I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> void e(@NotNull b<I, S, C> bVar, @NotNull com.tencent.mvi.api.help.b reuseParam) {
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        }

        public static <I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> void a(@NotNull b<I, S, C> bVar) {
        }

        public static <I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> void d(@NotNull b<I, S, C> bVar) {
        }
    }
}
