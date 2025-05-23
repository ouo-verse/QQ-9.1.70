package com.tencent.qqnt.markdown;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J)\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/markdown/a;", "", "V", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/markdown/data/b;", "data", "Lcom/tencent/qqnt/rich/b;", "cacheManager", "Landroid/view/View;", "c", "cacheView", "a", "(Landroid/content/Context;Lcom/tencent/qqnt/markdown/data/b;Ljava/lang/Object;)Landroid/view/View;", "b", "(Landroid/content/Context;)Ljava/lang/Object;", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class a<V> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public abstract View a(@NotNull Context context, @NotNull com.tencent.qqnt.markdown.data.b data, @NotNull V cacheView);

    @NotNull
    public abstract V b(@NotNull Context context);

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final View c(@NotNull Context context, @NotNull com.tencent.qqnt.markdown.data.b data, @NotNull com.tencent.qqnt.rich.b cacheManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, data, cacheManager);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(cacheManager, "cacheManager");
        View b16 = cacheManager.b(data.d(), data.e());
        if (b16 != null) {
            return b16;
        }
        Object a16 = cacheManager.a(data.e());
        if (a16 == null) {
            a16 = null;
        }
        if (a16 == null) {
            a16 = b(context);
        }
        cacheManager.f(a16, data.e());
        View a17 = a(context, data, a16);
        if (a17 == null) {
            return null;
        }
        if (data.a()) {
            cacheManager.d(a17, data.d());
        }
        return a17;
    }
}
