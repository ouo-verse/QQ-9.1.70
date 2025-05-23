package com.tencent.qui.quilistitem;

import android.widget.Button;
import android.widget.CompoundButton;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u000bR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qui/quilistitem/Delegates;", "", "Ltd0/m;", "a", "Lkotlin/Lazy;", "c", "()Ltd0/m;", "urlDrawableDelegate", "Lcom/tencent/qui/quilistitem/d;", "Landroid/widget/Button;", "b", "()Lcom/tencent/qui/quilistitem/d;", "rightButtonDelegate", "Lcom/tencent/qui/quilistitem/e;", "Landroid/widget/CompoundButton;", "()Lcom/tencent/qui/quilistitem/e;", "rightSwitchButtonDelegate", "<init>", "()V", "QUIListItem_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes25.dex */
public final class Delegates {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Lazy urlDrawableDelegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy rightButtonDelegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy rightSwitchButtonDelegate;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Delegates f363724d;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(BaseConstants.ERR_SDK_NET_PKG_SIZE_LIMIT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f363724d = new Delegates();
        lazy = LazyKt__LazyJVMKt.lazy(Delegates$urlDrawableDelegate$2.INSTANCE);
        urlDrawableDelegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(Delegates$rightButtonDelegate$2.INSTANCE);
        rightButtonDelegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(Delegates$rightSwitchButtonDelegate$2.INSTANCE);
        rightSwitchButtonDelegate = lazy3;
    }

    Delegates() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @NotNull
    public final d<Button> a() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            value = iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            value = rightButtonDelegate.getValue();
        }
        return (d) value;
    }

    @NotNull
    public final e<CompoundButton> b() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            value = iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            value = rightSwitchButtonDelegate.getValue();
        }
        return (e) value;
    }

    @Nullable
    public final td0.m c() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            value = iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            value = urlDrawableDelegate.getValue();
        }
        return (td0.m) value;
    }
}
