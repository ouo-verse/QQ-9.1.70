package com.tencent.mobileqq.troop.troopmanager.modules.searchway;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.activity.c;
import com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.TroopModifyBaseInfoFragment;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.model.TroopSearchWay;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.g;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u000bB)\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/searchway/TroopSearchWayConfig;", "", "", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", h.F, "a", "Landroid/app/Activity;", "e", "()Landroid/app/Activity;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "b", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "f", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "c", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "g", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "d", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "searchWayViewModel", "Lcom/tencent/mobileqq/widget/listitem/x;", "troopSearchWayConfig", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Lcom/tencent/mobileqq/data/troop/TroopInfo;Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSearchWayConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIListItemAdapter adapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopInfo troopInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b searchWayViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private x<x.b.d, x.c.g> troopSearchWayConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmanager/modules/searchway/TroopSearchWayConfig$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopmanager.modules.searchway.TroopSearchWayConfig$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58391);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSearchWayConfig(@NotNull Activity activity, @NotNull QUIListItemAdapter adapter, @NotNull TroopInfo troopInfo, @Nullable com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b bVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, adapter, troopInfo, bVar);
            return;
        }
        this.activity = activity;
        this.adapter = adapter;
        this.troopInfo = troopInfo;
        this.searchWayViewModel = bVar;
    }

    private final void i(final Activity activity) {
        final TroopSearchWay d16 = com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(this.troopInfo);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TroopInfoData troopInfoData = new TroopInfoData();
        troopInfoData.updateForTroopInfo(this.troopInfo, peekAppRuntime.getCurrentAccountUin());
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.b.e(activity, d16, c.f(troopInfoData), new Function1<TroopSearchWay, Unit>(this, activity) { // from class: com.tencent.mobileqq.troop.troopmanager.modules.searchway.TroopSearchWayConfig$handleTroopSearchWayItemClk$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity $activity;
            final /* synthetic */ TroopSearchWayConfig this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
                this.$activity = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopSearchWay.this, this, activity);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopSearchWay troopSearchWay) {
                invoke2(troopSearchWay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TroopSearchWay newOption) {
                com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) newOption);
                    return;
                }
                Intrinsics.checkNotNullParameter(newOption, "newOption");
                if (TroopSearchWay.this == newOption) {
                    return;
                }
                if (this.this$0.g().hasSetNewTroopHead && this.this$0.g().hasSetNewTroopName) {
                    bVar = this.this$0.searchWayViewModel;
                    if (bVar != null) {
                        String str = this.this$0.g().troopuin;
                        Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
                        bVar.c(str, newOption);
                        return;
                    }
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_new_search_way", newOption.name());
                TroopModifyBaseInfoFragment.Companion companion = TroopModifyBaseInfoFragment.INSTANCE;
                Activity activity2 = this.$activity;
                String troopUin = this.this$0.g().getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin, "troopInfo.troopUin");
                companion.a(activity2, 22, troopUin, bundle);
            }
        });
    }

    private final void j() {
        if (this.troopInfo.isQidianPrivateTroop()) {
            return;
        }
        TroopSearchWay d16 = com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(this.troopInfo);
        String string = this.activity.getString(R.string.f235507bu);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026g.troop_search_way_title)");
        x.b.d dVar = new x.b.d(string);
        String string2 = this.activity.getString(com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.b.f301224a.g(d16));
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(troopSearchWay.wordingResId())");
        x<x.b.d, x.c.g> xVar = new x<>(dVar, new x.c.g(string2, false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.searchway.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopSearchWayConfig.k(TroopSearchWayConfig.this, view);
            }
        });
        xVar.w(new g() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.searchway.b
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopSearchWayConfig.l(view);
            }
        });
        this.troopSearchWayConfig = xVar;
        QLog.i("TroopSearchWayConfig", 1, "[initTroopSearchWayItem] troopSearchWay = " + d16);
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b bVar = this.searchWayViewModel;
        if (bVar != null) {
            bVar.g(d16);
        }
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b bVar2 = this.searchWayViewModel;
        if (bVar2 != null) {
            bVar2.f(new Function1<com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c, Unit>() { // from class: com.tencent.mobileqq.troop.troopmanager.modules.searchway.TroopSearchWayConfig$initTroopSearchWayItem$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSearchWayConfig.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c cVar) {
                    invoke2(cVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c cVar) {
                    x xVar2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(cVar, "<name for destructuring parameter 0>");
                    boolean a16 = cVar.a();
                    TroopSearchWay b16 = cVar.b();
                    QLog.i("TroopSearchWayConfig", 1, "[searchWayUpdate] value = " + com.tencent.mobileqq.troop.troopsetting.modules.base.b.d(TroopSearchWayConfig.this.g()).getValue() + " newValue = " + b16.getValue());
                    xVar2 = TroopSearchWayConfig.this.troopSearchWayConfig;
                    if (xVar2 != null) {
                        TroopSearchWayConfig troopSearchWayConfig = TroopSearchWayConfig.this;
                        x.c.g gVar = (x.c.g) xVar2.O();
                        String string3 = troopSearchWayConfig.e().getResources().getString(com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.b.f301224a.g(b16));
                        Intrinsics.checkNotNullExpressionValue(string3, "activity.resources.getSt\u2026ng(option.wordingResId())");
                        gVar.h(string3);
                        troopSearchWayConfig.f().l0(xVar2);
                    }
                    if (a16) {
                        com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                        Activity e16 = TroopSearchWayConfig.this.e();
                        String string4 = TroopSearchWayConfig.this.e().getString(R.string.f235417bl);
                        Intrinsics.checkNotNullExpressionValue(string4, "activity.getString(R.str\u2026troop_search_way_loading)");
                        aVar.j(e16, 0, string4, 0);
                        return;
                    }
                    com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TroopSearchWayConfig this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i(this$0.activity);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        c.d(view);
    }

    @NotNull
    public final Activity e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.activity;
    }

    @NotNull
    public final QUIListItemAdapter f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QUIListItemAdapter) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.adapter;
    }

    @NotNull
    public final TroopInfo g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopInfo;
    }

    @Nullable
    public final x<x.b.d, x.c.g> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (x) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.troopSearchWayConfig == null) {
            j();
        }
        return this.troopSearchWayConfig;
    }
}
