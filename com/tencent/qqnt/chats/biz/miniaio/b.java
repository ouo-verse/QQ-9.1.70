package com.tencent.qqnt.chats.biz.miniaio;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/biz/miniaio/b;", "", "Landroidx/fragment/app/Fragment;", "getFragment", "Lcom/tencent/qqnt/chats/biz/miniaio/a;", "event", "", "Hb", "Lkotlinx/coroutines/flow/Flow;", "Va", "()Lkotlinx/coroutines/flow/Flow;", "uiEvent", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {
    void Hb(@NotNull a event);

    @NotNull
    Flow<a> Va();

    @NotNull
    Fragment getFragment();
}
