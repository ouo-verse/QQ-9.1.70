package com.tencent.intimate_space.impl;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/intimate_space/impl/IntimateSpaceKuiklyExport;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/e;", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "", "registerExternalModule", "registerExternalRenderView", "registerViewExternalPropHandler", "registerTDFlModule", "<init>", "()V", "intimate_space_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class IntimateSpaceKuiklyExport implements e {
    static IPatchRedirector $redirector_;

    public IntimateSpaceKuiklyExport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerExternalModule(@NotNull b kuiklyRenderExport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) kuiklyRenderExport);
            return;
        }
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        kuiklyRenderExport.a("FilamentSceneMessageChannelModule", IntimateSpaceKuiklyExport$registerExternalModule$1$1.INSTANCE);
        kuiklyRenderExport.a("IntimateSpaceModule", IntimateSpaceKuiklyExport$registerExternalModule$1$2.INSTANCE);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerExternalRenderView(@NotNull b kuiklyRenderExport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) kuiklyRenderExport);
        } else {
            Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
            b.a.a(kuiklyRenderExport, "IntimateSpaceFilamentView", IntimateSpaceKuiklyExport$registerExternalRenderView$1$1.INSTANCE, null, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerTDFlModule(@NotNull b kuiklyRenderExport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) kuiklyRenderExport);
        } else {
            Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerViewExternalPropHandler(@NotNull b kuiklyRenderExport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) kuiklyRenderExport);
        } else {
            Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        }
    }
}
