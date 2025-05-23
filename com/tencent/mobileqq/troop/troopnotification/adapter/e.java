package com.tencent.mobileqq.troop.troopnotification.adapter;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListSubFragment;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/adapter/e;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "category", "Lcom/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationListSubFragment;", "i0", "getItemCount", "position", "", "getItemId", "Landroidx/fragment/app/Fragment;", "createFragment", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "parentFragment", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "vm", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends FragmentStateAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TroopNotificationListVM vm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment parentFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Fragment parentFragment, @NotNull TroopNotificationListVM vm5) {
        super(parentFragment);
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parentFragment, (Object) vm5);
        } else {
            this.parentFragment = parentFragment;
            this.vm = vm5;
        }
    }

    private final TroopNotificationListSubFragment i0(int category) {
        return TroopNotificationListSubFragment.INSTANCE.a(category);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Fragment) iPatchRedirector.redirect((short) 4, (Object) this, position);
        }
        return i0(this.vm.n2(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.vm.s2();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, position)).longValue();
        }
        return this.vm.n2(position);
    }
}
