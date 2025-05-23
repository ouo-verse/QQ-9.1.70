package com.tencent.qqnt.chats.core.adapter.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/d;", "Lcom/tencent/qqnt/chats/core/adapter/holder/h;", "Landroid/view/View;", "view", "", "c", "child", "Landroid/view/ViewGroup$LayoutParams;", "params", "a", "Landroid/content/Context;", "b", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "getChatContent", "()Landroid/widget/RelativeLayout;", "chatContent", "<init>", "(Landroid/widget/RelativeLayout;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout chatContent;

    public d(@NotNull RelativeLayout chatContent) {
        Intrinsics.checkNotNullParameter(chatContent, "chatContent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatContent);
        } else {
            this.chatContent = chatContent;
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.h
    public void a(@Nullable View child, @Nullable ViewGroup.LayoutParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) child, (Object) params);
        } else {
            this.chatContent.addView(child, params);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.h
    @Nullable
    public Context b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.chatContent.getContext();
    }

    @Override // com.tencent.qqnt.chats.core.adapter.holder.h
    public void c(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            this.chatContent.removeView(view);
        }
    }
}
