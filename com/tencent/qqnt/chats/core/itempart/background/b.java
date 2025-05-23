package com.tencent.qqnt.chats.core.itempart.background;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/background/b;", "Lcom/tencent/qqnt/chats/inject/background/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "view", "", "a", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends com.tencent.qqnt.chats.inject.background.a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.inject.background.a
    public void a(@NotNull g item, @NotNull View view) {
        boolean z16;
        Drawable c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() == 104) {
            return;
        }
        if (item.H() && !GuildLayoutManager.f354256a.q()) {
            z16 = true;
        } else {
            z16 = false;
        }
        ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (z16) {
            c16 = chatsColorCache.d(context);
        } else {
            c16 = chatsColorCache.c(context);
        }
        view.setBackground(c16);
        if (Build.VERSION.SDK_INT >= 29) {
            ChatsColorCache chatsColorCache2 = ChatsColorCache.f355526a;
            if (chatsColorCache2.e() || QLog.isDebugVersion()) {
                String w3 = cq.w(item.w().e(), 3);
                Context context2 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                String f16 = chatsColorCache2.f(chatsColorCache2.l(context2));
                Context context3 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "view.context");
                QLog.d("[TopBackgroundProcessor]", 1, "[updateBackground] isChanged. isTop=" + z16 + ", title=" + w3 + ", pressColor=" + f16 + ", normalColor=" + chatsColorCache2.f(chatsColorCache2.k(context3)));
                chatsColorCache2.t(false);
            }
        }
    }
}
