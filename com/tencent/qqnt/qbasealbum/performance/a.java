package com.tencent.qqnt.qbasealbum.performance;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.base.model.c;
import com.tencent.qqnt.qbasealbum.model.PageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/performance/a;", "Lcom/tencent/qqnt/qbasealbum/base/model/c;", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "", "newState", "", "a", "b", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.c
    public void a(@NotNull PageType pageType, int newState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pageType, newState);
        } else {
            Intrinsics.checkNotNullParameter(pageType, "pageType");
            QAlbumPerformanceHelper.INSTANCE.a().j(pageType.ordinal(), newState);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.model.c
    public void b(@NotNull PageType pageType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pageType);
        } else {
            Intrinsics.checkNotNullParameter(pageType, "pageType");
            QAlbumPerformanceHelper.INSTANCE.a().e(pageType.ordinal());
        }
    }
}
