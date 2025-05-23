package com.tencent.qqnt.chats.core.itempart.avatar.provider;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/avatar/provider/c;", "Lcom/tencent/qqnt/chats/inject/avatar/c;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/widget/ImageView;", "view", "", "c", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c extends com.tencent.qqnt.chats.inject.avatar.c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    @Nullable
    public Drawable a(@NotNull g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Resources resources = BaseApplication.context.getResources();
        Integer e16 = item.g().e();
        if (e16 != null && e16.intValue() != 0) {
            return ResourcesCompat.getDrawable(resources, e16.intValue(), null);
        }
        return ResourcesCompat.getDrawable(resources, R.drawable.coo, null);
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    public boolean b(@NotNull g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.g().g() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.inject.avatar.c
    public void c(@NotNull g item, @NotNull ImageView view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.g().b() != null) {
            view.setImageDrawable(item.g().b());
            return;
        }
        g.a g16 = item.g();
        Drawable a16 = a(item);
        if (a16 != null) {
            view.setImageDrawable(a16);
        } else {
            a16 = null;
        }
        g16.h(a16);
    }
}
