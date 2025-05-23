package com.tencent.qqnt.chats.core.itempart.avatar.processor;

import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.view.widget.DefaultRecentAvatarView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nw3.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/avatar/processor/a;", "Lcom/tencent/qqnt/chats/inject/avatar/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lnw3/c;", "view", "", "c", "Landroid/widget/ImageView;", "b", "Lnw3/a;", "a", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends com.tencent.qqnt.chats.inject.avatar.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(g item, ImageView view) {
        Integer f16 = item.g().f();
        if (f16 != null) {
            view.setImageResource(f16.intValue());
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    private final void c(g item, c view) {
        ImageView d16;
        if ((!view.f() && item.g().f() == null) || (d16 = view.d()) == null) {
            return;
        }
        b(item, d16);
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.a
    public void a(@NotNull g item, @NotNull nw3.a view) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).isRevealEnable()) {
            if (view instanceof c) {
                c(item, (c) view);
                return;
            } else {
                if (view instanceof DefaultRecentAvatarView) {
                    b(item, ((DefaultRecentAvatarView) view).h());
                    return;
                }
                return;
            }
        }
        if (view instanceof c) {
            imageView = ((c) view).d();
        } else if (view instanceof DefaultRecentAvatarView) {
            imageView = ((DefaultRecentAvatarView) view).h();
        } else {
            imageView = null;
        }
        if (imageView != null) {
            Integer f16 = item.g().f();
            if (f16 != null) {
                imageView.setImageResource(f16.intValue());
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }
}
