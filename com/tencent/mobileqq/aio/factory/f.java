package com.tencent.mobileqq.aio.factory;

import android.content.Context;
import com.tencent.aio.api.refreshLoad.HeadFooterViewHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/f;", "Lcom/tencent/aio/api/refreshLoad/e;", "", "b", "", "type", "Landroid/content/Context;", "context", "Lcom/tencent/aio/api/refreshLoad/HeadFooterViewHolder;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f implements com.tencent.aio.api.refreshLoad.e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f188791a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45908);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f188791a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_refresh_loading_icon_8973_113370123", true);
    }

    @Override // com.tencent.aio.api.refreshLoad.e
    @Nullable
    public HeadFooterViewHolder a(int type, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HeadFooterViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, type, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (b()) {
            return new c(type, context);
        }
        return new b(type, context);
    }
}
