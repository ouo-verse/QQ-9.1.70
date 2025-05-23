package com.tencent.qqnt.chats.core.ui.third.creator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqnt.chats.core.ui.third.b;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/third/creator/a;", "Lcom/tencent/qqnt/chats/core/ui/third/b;", "Landroid/content/Context;", "context", "", "", "", "extra", "Landroid/view/View;", "a", "view", "", "b", ViewStickEventHelper.IS_SHOW, "", "f", "Lcom/tencent/qqnt/chats/core/ui/third/const/ThirdViewEnum;", "d", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    @NotNull
    public View a(@NotNull Context context, @Nullable Map<String, ? extends Object> extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) extra);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout root = pw3.a.h(LayoutInflater.from(context), null, false).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(LayoutInflater.f\u2026ntext), null, false).root");
        return root;
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    public boolean b(@NotNull View view, @Nullable Map<String, ? extends Object> extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) extra)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        return true;
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            b.a.a(this, z16);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    @NotNull
    public ThirdViewEnum d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ThirdViewEnum) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ThirdViewEnum.DEFAULT;
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    public void e(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            b.a.b(this, view);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.b
    public void f(@NotNull View view, boolean isShow) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Boolean.valueOf(isShow));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (isShow) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}
