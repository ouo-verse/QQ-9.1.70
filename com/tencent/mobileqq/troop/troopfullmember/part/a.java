package com.tencent.mobileqq.troop.troopfullmember.part;

import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopfullmember.TroopFullMemberChangeFragment;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/troop/troopfullmember/TroopFullMemberChangeFragment;", "z9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "A9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "x9", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class a extends Part {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public Group[] A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Group[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new Group[0];
    }

    @Nullable
    public final QUIListItemAdapter x9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getPartHost().sh().getAdapter();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: z9, reason: merged with bridge method [inline-methods] */
    public TroopFullMemberChangeFragment getPartHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopFullMemberChangeFragment) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        IPartHost partHost = super.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.troop.troopfullmember.TroopFullMemberChangeFragment");
        return (TroopFullMemberChangeFragment) partHost;
    }
}
