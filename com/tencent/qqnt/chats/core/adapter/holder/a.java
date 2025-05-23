package com.tencent.qqnt.chats.core.adapter.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/a;", "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "Landroid/view/View;", "", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "l", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "bannerContainer", "<init>", "(Landroid/view/ViewGroup;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends b<com.tencent.qqnt.chats.core.adapter.itemdata.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ViewGroup bannerContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull ViewGroup bannerContainer) {
        super(bannerContainer);
        Intrinsics.checkNotNullParameter(bannerContainer, "bannerContainer");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bannerContainer);
        } else {
            this.bannerContainer = bannerContainer;
        }
    }

    private final void p(View view) {
        ViewGroup viewGroup;
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
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
        if (item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.a) {
            com.tencent.qqnt.chats.core.adapter.itemdata.a aVar = (com.tencent.qqnt.chats.core.adapter.itemdata.a) item;
            if (!Intrinsics.areEqual(aVar.f().getParent(), this.bannerContainer)) {
                this.bannerContainer.removeAllViews();
                p(aVar.f());
                this.bannerContainer.addView(aVar.f());
            }
            View f16 = aVar.f();
            f16.setClickable(true);
            if (aVar.g()) {
                ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
                Context context = f16.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                c16 = chatsColorCache.d(context);
            } else {
                ChatsColorCache chatsColorCache2 = ChatsColorCache.f355526a;
                Context context2 = f16.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                c16 = chatsColorCache2.c(context2);
            }
            f16.setBackground(c16);
            aVar.h(false);
        }
    }
}
