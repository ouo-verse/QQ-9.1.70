package com.tencent.mobileqq.troop.troopmanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopblacklist.TroopBlackListFragment;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerComponentApi;
import com.tencent.mobileqq.troop.troopmanager.modules.searchway.TroopSearchWayConfig;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J8\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/api/impl/TroopManagerComponentApiImpl;", "Lcom/tencent/mobileqq/troop/troopmanager/api/ITroopManagerComponentApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "searchWayViewModel", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "getTroopSearchWayConfig", "", "isTroopBlackListEnable", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "startTroopBlackListFragment", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopManagerComponentApiImpl implements ITroopManagerComponentApi {
    static IPatchRedirector $redirector_;

    public TroopManagerComponentApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerComponentApi
    @Nullable
    public x<x.b.d, x.c.g> getTroopSearchWayConfig(@NotNull Activity activity, @NotNull QUIListItemAdapter adapter, @NotNull TroopInfo troopInfo, @Nullable b searchWayViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (x) iPatchRedirector.redirect((short) 2, this, activity, adapter, troopInfo, searchWayViewModel);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        return new TroopSearchWayConfig(activity, adapter, troopInfo, searchWayViewModel).h();
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerComponentApi
    public boolean isTroopBlackListEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.troop.troopblacklist.a.f299449a.c();
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerComponentApi
    public void startTroopBlackListFragment(@NotNull Context context, @NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QPublicFragmentActivity.start(context, intent, TroopBlackListFragment.class);
    }
}
