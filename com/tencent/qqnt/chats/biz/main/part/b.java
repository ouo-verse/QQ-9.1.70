package com.tencent.qqnt.chats.biz.main.part;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.qqnt.chats.core.ui.n;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u0010\u001a\u00020\u000fH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/part/b;", "", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleCoroutineScope;", "M9", "Landroidx/lifecycle/ViewModelStoreOwner;", "y", "Lcom/tencent/qqnt/chats/core/ui/n;", "handler", "", Constants.DEBUG_INFO, "", "index", "Cg", "Landroid/content/Context;", "requireContext", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {
    void Cg(int index, @NotNull n handler);

    void G4(@NotNull n handler);

    @NotNull
    LifecycleCoroutineScope M9();

    @NotNull
    LifecycleOwner getLifecycleOwner();

    @NotNull
    Context requireContext();

    @NotNull
    ViewModelStoreOwner y();
}
