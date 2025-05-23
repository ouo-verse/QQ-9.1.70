package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/GroupItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "manager", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "getManager", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "<init>", "(Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class GroupItem extends BaseItem {
    static IPatchRedirector $redirector_;

    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f manager;

    public GroupItem(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) manager);
        } else {
            this.manager = manager;
        }
    }

    @NotNull
    public final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f getManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.manager;
    }
}
