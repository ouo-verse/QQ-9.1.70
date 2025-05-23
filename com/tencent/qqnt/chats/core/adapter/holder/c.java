package com.tencent.qqnt.chats.core.adapter.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/c;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c extends b<com.tencent.qqnt.chats.core.adapter.itemdata.b> {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.b
    public void l(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item) {
        Drawable c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.c) {
            View view = this.itemView;
            com.tencent.qqnt.chats.core.adapter.itemdata.c cVar = (com.tencent.qqnt.chats.core.adapter.itemdata.c) item;
            if (cVar.f()) {
                ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                c16 = chatsColorCache.d(context);
            } else {
                ChatsColorCache chatsColorCache2 = ChatsColorCache.f355526a;
                Context context2 = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                c16 = chatsColorCache2.c(context2);
            }
            view.setBackground(c16);
            cVar.g(false);
        }
    }
}
