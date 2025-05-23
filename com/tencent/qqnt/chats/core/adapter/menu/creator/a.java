package com.tencent.qqnt.chats.core.adapter.menu.creator;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/menu/creator/a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/qqnt/chats/core/adapter/menu/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "b", "view", "", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {
    void a(@NotNull View view, @NotNull com.tencent.qqnt.chats.core.adapter.menu.a item);

    @NotNull
    View b(@NotNull ViewGroup parent, @NotNull com.tencent.qqnt.chats.core.adapter.menu.a item);
}
