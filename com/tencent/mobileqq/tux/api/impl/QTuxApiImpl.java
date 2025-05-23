package com.tencent.mobileqq.tux.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tux.api.IQTuxApi;
import com.tencent.mobileqq.tux.core.g;
import com.tencent.mobileqq.tux.jump.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/tux/api/impl/QTuxApiImpl;", "Lcom/tencent/mobileqq/tux/api/IQTuxApi;", "()V", "createTuxJumpParserClass", "Ljava/lang/Class;", "", "initTux", "", "triggerArkTux", "arkUid", "", "tuxType", "qqcareInfo", "qqtux-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class QTuxApiImpl implements IQTuxApi {
    static IPatchRedirector $redirector_;

    public QTuxApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tux.api.IQTuxApi
    @NotNull
    public Class<? extends Object> createTuxJumpParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.tux.api.IQTuxApi
    public void initTux() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            g.f303454a.m();
        }
    }

    @Override // com.tencent.mobileqq.tux.api.IQTuxApi
    public void triggerArkTux(@NotNull String arkUid, @NotNull String tuxType, @NotNull String qqcareInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, arkUid, tuxType, qqcareInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(arkUid, "arkUid");
        Intrinsics.checkNotNullParameter(tuxType, "tuxType");
        Intrinsics.checkNotNullParameter(qqcareInfo, "qqcareInfo");
        g.f303454a.q(arkUid, tuxType, qqcareInfo);
    }
}
