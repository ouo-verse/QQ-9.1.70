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

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b`\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u00020\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mvi/mvvm/a;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface a<I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.mvi.mvvm.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9236a {
        @NotNull
        public static <I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> a(@NotNull a<I, S, C> aVar) {
            List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }

        @NotNull
        public static <I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> b(@NotNull a<I, S, C> aVar, @NotNull View hostView) {
            List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> emptyList;
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }
}
