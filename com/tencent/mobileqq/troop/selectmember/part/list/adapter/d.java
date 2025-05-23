package com.tencent.mobileqq.troop.selectmember.part.list.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.selectmember.adapter.AbsTroopSelectMemberDelegate;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/list/adapter/d;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "vmOperator", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "launchConfig", "Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate$a;", "itemClickListener", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "delegatesManager", "<init>", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;Lcom/tencent/mobileqq/troop/selectmember/adapter/AbsTroopSelectMemberDelegate$a;Lcom/tencent/mobileqq/troop/selectmember/vm/a;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends AsyncListDifferDelegationAdapter<com.tencent.mobileqq.troop.selectmember.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.selectmember.vm.a vmOperator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/selectmember/part/list/adapter/d$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "p0", "p1", "", "b", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.troop.selectmember.bean.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a p06, @NotNull com.tencent.mobileqq.troop.selectmember.bean.a p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06, (Object) p16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return p06.d(p16);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.troop.selectmember.bean.a p06, @NotNull com.tencent.mobileqq.troop.selectmember.bean.a p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06, (Object) p16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return p06.f(p16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/troop/selectmember/part/list/adapter/d$b", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends AdapterDelegatesManager<List<? extends com.tencent.mobileqq.troop.selectmember.bean.a>> {
        static IPatchRedirector $redirector_;

        b(com.tencent.mobileqq.troop.selectmember.vm.a aVar, TroopSelectMemberConfig troopSelectMemberConfig, AbsTroopSelectMemberDelegate.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, troopSelectMemberConfig, aVar2);
                return;
            }
            ArrayList<AbsTroopSelectMemberDelegate> arrayList = new ArrayList();
            arrayList.addAll(aVar.T0().e());
            arrayList.add(new TroopMemberDelegate());
            arrayList.add(new c());
            arrayList.add(new com.tencent.mobileqq.troop.selectmember.part.list.adapter.b());
            for (AbsTroopSelectMemberDelegate absTroopSelectMemberDelegate : arrayList) {
                absTroopSelectMemberDelegate.j(aVar);
                absTroopSelectMemberDelegate.i(troopSelectMemberConfig);
                absTroopSelectMemberDelegate.h(aVar2);
                addDelegate(absTroopSelectMemberDelegate);
            }
        }
    }

    public /* synthetic */ d(TroopSelectMemberConfig troopSelectMemberConfig, AbsTroopSelectMemberDelegate.a aVar, com.tencent.mobileqq.troop.selectmember.vm.a aVar2, DiffUtil.ItemCallback itemCallback, AdapterDelegatesManager adapterDelegatesManager, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(troopSelectMemberConfig, aVar, aVar2, (i3 & 8) != 0 ? new a() : itemCallback, (i3 & 16) != 0 ? new b(aVar2, troopSelectMemberConfig, aVar) : adapterDelegatesManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, troopSelectMemberConfig, aVar, aVar2, itemCallback, adapterDelegatesManager, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@Nullable TroopSelectMemberConfig troopSelectMemberConfig, @NotNull AbsTroopSelectMemberDelegate.a itemClickListener, @NotNull com.tencent.mobileqq.troop.selectmember.vm.a vmOperator, @NotNull DiffUtil.ItemCallback<com.tencent.mobileqq.troop.selectmember.bean.a> diffCallback, @NotNull AdapterDelegatesManager<List<com.tencent.mobileqq.troop.selectmember.bean.a>> delegatesManager) {
        super(diffCallback, delegatesManager);
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        Intrinsics.checkNotNullParameter(vmOperator, "vmOperator");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(delegatesManager, "delegatesManager");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.vmOperator = vmOperator;
        } else {
            iPatchRedirector.redirect((short) 1, this, troopSelectMemberConfig, itemClickListener, vmOperator, diffCallback, delegatesManager);
        }
    }
}
