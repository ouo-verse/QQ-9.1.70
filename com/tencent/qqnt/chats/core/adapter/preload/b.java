package com.tencent.qqnt.chats.core.adapter.preload;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.adapter.menu.creator.c;
import com.tencent.qqnt.chats.utils.preload.LayoutPreLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u00020\f*\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/preload/b;", "Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$c;", "Landroid/view/View;", "Lcom/tencent/qqnt/chats/utils/preload/LayoutPreLoader$b;", "param", "d", "Lcom/tencent/qqnt/chats/core/adapter/menu/a;", "a", "Lcom/tencent/qqnt/chats/core/adapter/menu/a;", "getItem", "()Lcom/tencent/qqnt/chats/core/adapter/menu/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "(I)I", "dp", "<init>", "(Lcom/tencent/qqnt/chats/core/adapter/menu/a;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements LayoutPreLoader.c<View> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.adapter.menu.a item;

    public b(@NotNull com.tencent.qqnt.chats.core.adapter.menu.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) item);
        } else {
            this.item = item;
        }
    }

    private final int c(int i3) {
        return (int) TypedValue.applyDimension(1, i3, Resources.getSystem().getDisplayMetrics());
    }

    @Override // com.tencent.qqnt.chats.utils.preload.LayoutPreLoader.c
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return LayoutPreLoader.c.a.a(this);
    }

    @Override // com.tencent.qqnt.chats.utils.preload.LayoutPreLoader.c
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public View a(@NotNull LayoutPreLoader.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        Context context = param.a().get();
        if (context == null) {
            return null;
        }
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(this.item.g(), this.item.b()));
        textView.setGravity(17);
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        textView.setPadding(c(20), 0, c(20), 0);
        int c16 = this.item.c();
        int a16 = this.item.a();
        Integer e16 = this.item.e();
        if (this.item.f() != -1) {
            int f16 = this.item.f();
            c.Companion companion = com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE;
            if (f16 < companion.k().length) {
                c16 = companion.k()[this.item.f()];
                a16 = companion.j()[this.item.f()];
                e16 = Integer.valueOf(companion.l()[this.item.f()]);
            }
        }
        textView.setId(c16);
        textView.setBackgroundResource(a16);
        if (e16 != null) {
            textView.setText(e16.intValue());
        } else {
            textView.setText(this.item.d());
        }
        return textView;
    }
}
