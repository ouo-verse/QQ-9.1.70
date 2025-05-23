package com.tencent.qqnt.chats.core.itempart;

import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "binding", "", "c", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", "holder", "", "f", "chats_view_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    public static final void c(@NotNull final g item, @NotNull RecentContactItemBinding binding) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(binding, "binding");
        binding.b().setTag(R.id.ucb, Long.valueOf(item.m()));
        final WeakReference weakReference = new WeakReference(binding.b());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.chats.core.itempart.a
            @Override // java.lang.Runnable
            public final void run() {
                c.d(g.this, weakReference);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final g item, final WeakReference viewRef) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(viewRef, "$viewRef");
        final String a16 = com.tencent.qqnt.chats.utils.c.f355544a.a(item);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.chats.core.itempart.b
            @Override // java.lang.Runnable
            public final void run() {
                c.e(viewRef, item, a16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WeakReference viewRef, g item, String contentDesc) {
        Intrinsics.checkNotNullParameter(viewRef, "$viewRef");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(contentDesc, "$contentDesc");
        RelativeLayout relativeLayout = (RelativeLayout) viewRef.get();
        if (relativeLayout != null && Intrinsics.areEqual(relativeLayout.getTag(R.id.ucb), Long.valueOf(item.m()))) {
            relativeLayout.setContentDescription(contentDesc);
        }
    }

    public static final boolean f(@NotNull g item, @NotNull RecentContactItemHolder holder) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder.y().b().getTag(R.id.f922457c) != null && item.A(LiteBusinessType.KLITEACTION)) {
            return true;
        }
        return false;
    }
}
