package com.tencent.mobileqq.aio.msglist.holder;

import android.view.ViewGroup;
import com.tencent.mobileqq.aio.msglist.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000fH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/i;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "", "viewType", "subViewType", "Lcom/tencent/mobileqq/aio/msglist/x;", "factoryProvider", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "b", "Lcom/tencent/aio/api/list/b;", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface i {
    @NotNull
    com.tencent.aio.api.list.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> a();

    @NotNull
    com.tencent.aio.api.list.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> b(@NotNull ViewGroup parent, boolean isSelf, int viewType, int subViewType, @NotNull x factoryProvider);
}
