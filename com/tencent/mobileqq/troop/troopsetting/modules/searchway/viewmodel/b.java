package com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.model.TroopSearchWay;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.ui.c;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR*\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RF\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00182\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00188\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b;", "", "", "b", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/model/TroopSearchWay;", "newOption", "g", "", "troopUin", "c", "Lcom/tencent/common/app/AppInterface;", "a", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/ui/c;", "value", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/ui/c;", "getState", "()Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/ui/c;", "e", "(Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/ui/c;)V", "state", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getStateObserver", "()Lkotlin/jvm/functions/Function1;", "f", "(Lkotlin/jvm/functions/Function1;)V", "stateObserver", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c state;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super c, Unit> stateObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25298);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        } else {
            this.app = app;
            this.state = new c(false, TroopSearchWay.PRIVATE, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TroopSearchWay newOption, b this$0, boolean z16, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(newOption, "$newOption");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("TroopSearchWayViewModel", 1, "[requestUpdateSearchWay], errCode = " + i3 + ", errMsg = " + errMsg + " newOption = " + newOption.getValue());
        if (z16) {
            this$0.e(new c(false, newOption));
            SimpleEventBus.getInstance().dispatchEvent(new TroopSearchWayToastEvent(true, R.string.f235497bt));
        } else {
            this$0.e(c.d(this$0.state, false, null, 2, null));
            SimpleEventBus.getInstance().dispatchEvent(new TroopSearchWayToastEvent(false, R.string.f235407bk));
        }
    }

    private final void e(c cVar) {
        this.state = cVar;
        Function1<? super c, Unit> function1 = this.stateObserver;
        if (function1 != null) {
            function1.invoke(cVar);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            f(null);
        }
    }

    public final void c(@NotNull String troopUin, @NotNull final TroopSearchWay newOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopUin, (Object) newOption);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(newOption, "newOption");
        if (this.state.e() == newOption) {
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f171139ci4, 0).show();
            return;
        }
        e(c.d(this.state, true, null, 2, null));
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopSearchType(null, troopUin, newOption.getValue(), new e() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.a
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i3, String str) {
                b.d(TroopSearchWay.this, this, z16, i3, str);
            }
        });
    }

    public final void f(@Nullable Function1<? super c, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function1);
            return;
        }
        this.stateObserver = function1;
        if (function1 != null) {
            function1.invoke(this.state);
        }
    }

    public final void g(@NotNull TroopSearchWay newOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newOption);
        } else {
            Intrinsics.checkNotNullParameter(newOption, "newOption");
            e(c.d(this.state, false, newOption, 1, null));
        }
    }
}
