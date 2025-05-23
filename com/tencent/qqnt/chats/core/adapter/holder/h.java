package com.tencent.qqnt.chats.core.adapter.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/holder/h;", "", "Landroid/view/View;", "view", "", "c", "child", "Landroid/view/ViewGroup$LayoutParams;", "params", "a", "Landroid/content/Context;", "b", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class h {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(@Nullable View child, @Nullable ViewGroup.LayoutParams params);

    @Nullable
    public abstract Context b();

    public abstract void c(@Nullable View view);
}
