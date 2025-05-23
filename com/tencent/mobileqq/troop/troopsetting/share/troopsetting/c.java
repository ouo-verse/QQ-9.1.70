package com.tencent.mobileqq.troop.troopsetting.share.troopsetting;

import android.content.Intent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/c;", "Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/e;", "", "", "d", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends e {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.troopsetting.e, com.tencent.mobileqq.troop.troopsetting.share.a
    public void a(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        com.tencent.mobileqq.troop.troopshare.a f16 = shareContext.f();
        if (f16 != null) {
            str = f16.f301557e;
        } else {
            str = null;
        }
        Intent f17 = f(str);
        f17.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(shareContext.b(), f17, 24);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.troopsetting.e, com.tencent.mobileqq.troop.troopsetting.share.a
    @NotNull
    public List<String> d() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf("qqfriend");
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
