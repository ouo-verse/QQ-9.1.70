package com.tencent.mobileqq.troop.troopidentity.parts;

import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconFragment;
import com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconVM;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\n\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004J\u0006\u0010\f\u001a\u00020\u000bJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0006R\u001b\u0010\u0017\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityIconBasePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconFragment;", "x9", "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "", "isVisible", "", "D9", "C9", "Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "z9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "E9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "B9", "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;", "d", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;", "vm", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class TroopIdentityIconBasePart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy vm;

    public TroopIdentityIconBasePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopIdentityIconVM>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityIconBasePart$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopIdentityIconBasePart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TroopIdentityIconVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (TroopIdentityIconVM) TroopIdentityIconBasePart.this.getViewModel(TroopIdentityIconVM.class) : (TroopIdentityIconVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final TroopIdentityIconVM A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopIdentityIconVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object value = this.vm.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-vm>(...)");
        return (TroopIdentityIconVM) value;
    }

    public final boolean B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return A9().k2();
    }

    public final void C9(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter adapter = getPartHost().ph().getAdapter();
        if (adapter != null) {
            adapter.l0(config);
        }
    }

    public final void D9(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config, boolean isVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, config, Boolean.valueOf(isVisible));
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter adapter = getPartHost().ph().getAdapter();
        if (adapter != null) {
            adapter.m0(config, isVisible);
        }
    }

    @NotNull
    public Group[] E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Group[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new Group[0];
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: x9, reason: merged with bridge method [inline-methods] */
    public TroopIdentityIconFragment getPartHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopIdentityIconFragment) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        IPartHost partHost = super.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconFragment");
        return (TroopIdentityIconFragment) partHost;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopidentity.util.a z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.troopidentity.util.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return A9().X1();
    }
}
