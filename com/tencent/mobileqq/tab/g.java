package com.tencent.mobileqq.tab;

import android.view.View;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/tab/g;", "Lcom/tencent/mobileqq/app/FrameFragment$e;", "", "getTag", "Landroid/view/View;", "a", "Lcom/tencent/mobileqq/activity/home/impl/c;", "Lcom/tencent/mobileqq/activity/home/impl/c;", "b", "()Lcom/tencent/mobileqq/activity/home/impl/c;", "setBean", "(Lcom/tencent/mobileqq/activity/home/impl/c;)V", "bean", "Landroid/view/View;", "getIndicator", "()Landroid/view/View;", "setIndicator", "(Landroid/view/View;)V", "indicator", "<init>", "(Lcom/tencent/mobileqq/activity/home/impl/c;Landroid/view/View;)V", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g implements FrameFragment.e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.activity.home.impl.c bean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View indicator;

    public g(@NotNull com.tencent.mobileqq.activity.home.impl.c bean, @NotNull View indicator) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bean, (Object) indicator);
        } else {
            this.bean = bean;
            this.indicator = indicator;
        }
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.e
    @NotNull
    public View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.indicator;
    }

    @NotNull
    public final com.tencent.mobileqq.activity.home.impl.c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.activity.home.impl.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bean;
    }

    @Override // com.tencent.mobileqq.app.FrameFragment.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String name = this.bean.k().getName();
        Intrinsics.checkNotNullExpressionValue(name, "bean.frameClass.name");
        return name;
    }
}
