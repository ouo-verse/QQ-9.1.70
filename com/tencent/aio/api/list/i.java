package com.tencent.aio.api.list;

import android.view.ViewGroup;
import com.tencent.aio.api.list.f;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\b\u0012\u0006\b\u0001\u0012\u00020\t0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/api/list/i;", "Lcom/tencent/aio/api/list/f;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "subViewType", "Lcom/tencent/aio/api/list/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface i extends f {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        public static int a(@NotNull i iVar) {
            return f.a.a(iVar);
        }
    }

    @NotNull
    com.tencent.aio.api.list.a<? extends ol3.b, ? extends MviUIState> a(@NotNull ViewGroup parent, int viewType, int subViewType);
}
