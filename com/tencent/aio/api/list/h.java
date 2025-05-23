package com.tencent.aio.api.list;

import android.view.ViewGroup;
import com.tencent.aio.api.list.f;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "IMessageCellFactoryV2", imports = {}))
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/api/list/h;", "Lcom/tencent/aio/api/list/f;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/aio/api/list/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "d", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface h extends f {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        @Nullable
        public static k a(@NotNull h hVar) {
            return f.a.b(hVar);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "createCellVB(parent: ViewGroup, viewType: Int,subViewType: Int)", imports = {}))
    @NotNull
    com.tencent.aio.api.list.a<? extends ol3.b, ? extends MviUIState> d(@NotNull ViewGroup parent, int viewType);
}
