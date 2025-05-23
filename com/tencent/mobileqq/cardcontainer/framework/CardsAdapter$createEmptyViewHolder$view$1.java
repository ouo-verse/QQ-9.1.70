package com.tencent.mobileqq.cardcontainer.framework;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.cardcontainer.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0001H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/cardcontainer/framework/CardsAdapter$createEmptyViewHolder$view$1", "Landroid/view/View;", "Lcom/tencent/mobileqq/cardcontainer/d;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "data", "Lcom/tencent/mobileqq/cardcontainer/e;", "host", "", "d", "getView", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardsAdapter$createEmptyViewHolder$view$1 extends View implements com.tencent.mobileqq.cardcontainer.d {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CardsAdapter$createEmptyViewHolder$view$1(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            d.a.a(this);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    public void d(@NotNull com.tencent.mobileqq.cardcontainer.data.a data, @NotNull com.tencent.mobileqq.cardcontainer.e host) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, (Object) host);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(host, "host");
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    @NotNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this;
    }
}
