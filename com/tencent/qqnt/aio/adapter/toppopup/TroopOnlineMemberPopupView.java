package com.tencent.qqnt.aio.adapter.toppopup;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.x;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/toppopup/TroopOnlineMemberPopupView;", "Lcom/tencent/qqnt/aio/toppopup/a;", "Landroid/content/Context;", "context", "", "uid", "", "param", "", "a", "", "getHeight", "Landroid/widget/FrameLayout;", "e", "Landroid/content/Context;", "mContext", "Landroid/view/View;", "b", "Landroid/view/View;", "mPrompt", "c", "Lkotlin/Lazy;", "d", "()Landroid/widget/FrameLayout;", "mContent", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TroopOnlineMemberPopupView implements com.tencent.qqnt.aio.toppopup.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View mPrompt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContent;

    public TroopOnlineMemberPopupView() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new TroopOnlineMemberPopupView$mContent$2(this));
            this.mContent = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final FrameLayout d() {
        return (FrameLayout) this.mContent.getValue();
    }

    @Override // com.tencent.qqnt.aio.toppopup.a
    public void a(@NotNull Context context, @NotNull String uid, @Nullable Object param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, uid, param);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        this.mContext = context;
        Intrinsics.checkNotNull(param, "null cannot be cast to non-null type android.view.View");
        this.mPrompt = (View) param;
    }

    @Override // com.tencent.qqnt.aio.toppopup.a
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public FrameLayout getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return d();
    }

    @Override // com.tencent.qqnt.aio.toppopup.a
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return x.a(112.0f);
    }
}
