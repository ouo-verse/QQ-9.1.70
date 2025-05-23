package com.tencent.mobileqq.vas.lovechat;

import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.h;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/lovechat/c;", "Lcom/tencent/qqnt/chats/inject/content/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/adapter/holder/h;", "view", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "binging", "", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c extends com.tencent.qqnt.chats.inject.content.a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RecentContactItemBinding binging, g item) {
        Intrinsics.checkNotNullParameter(binging, "$binging");
        Intrinsics.checkNotNullParameter(item, "$item");
        Drawable drawable = null;
        binging.b().setBackground(null);
        RelativeLayout b16 = binging.b();
        Function1<Integer, Drawable> a16 = item.y().a();
        if (a16 != null) {
            drawable = a16.invoke(Integer.valueOf(item.y().b()));
        }
        b16.setBackground(drawable);
    }

    @Override // com.tencent.qqnt.chats.inject.content.a
    public void a(@NotNull final g item, @NotNull h view, @NotNull final RecentContactItemBinding binging) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(binging, "binging");
        if (SimpleUIUtil.isNowSimpleMode() || !item.y().n()) {
            return;
        }
        binging.b().setTag(R.id.ybf, -1);
        if (VasNtToggle.VAS_BUG_119216554.isEnable(true)) {
            binging.b().post(new Runnable() { // from class: com.tencent.mobileqq.vas.lovechat.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.c(RecentContactItemBinding.this, item);
                }
            });
            return;
        }
        Drawable drawable = null;
        binging.b().setBackground(null);
        RelativeLayout b16 = binging.b();
        Function1<Integer, Drawable> a16 = item.y().a();
        if (a16 != null) {
            drawable = a16.invoke(Integer.valueOf(item.y().b()));
        }
        b16.setBackground(drawable);
    }
}
