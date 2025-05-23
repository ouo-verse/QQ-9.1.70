package com.tencent.mobileqq.cardcontainer.api.impl;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerApi;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi;
import com.tencent.mobileqq.cardcontainer.data.CardContainerSwitchState;
import com.tencent.mobileqq.cardcontainer.framework.CardContainerView;
import com.tencent.mobileqq.cardcontainer.framework.CardsViewModelImpl;
import com.tencent.mobileqq.cardcontainer.i;
import com.tencent.mobileqq.cardcontainer.j;
import com.tencent.mobileqq.cardcontainer.k;
import com.tencent.mobileqq.cardcontainer.template.demo.DemoFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ:\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerApiImpl;", "Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerApi;", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/cardcontainer/g;", "viewModel", "Lcom/tencent/mobileqq/cardcontainer/j;", "daTongReportDelegate", "Lcom/tencent/mobileqq/cardcontainer/k;", "parentScrollHelper", "Lcom/tencent/mobileqq/cardcontainer/h;", "listener", "Lcom/tencent/mobileqq/cardcontainer/i;", "createCardContainerView", "Landroidx/lifecycle/ViewModelStoreOwner;", "store", "getViewModel", "", "preloadCardContainerData", "startDemoActivity", "Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerApiImpl$a;", "preloadCardData", "Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerApiImpl$a;", "<init>", "()V", "Companion", "a", "b", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardContainerApiImpl implements ICardContainerApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "CardContainer.Api";

    @Nullable
    private a preloadCardData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerApiImpl$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "uin", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "cardData", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<com.tencent.mobileqq.cardcontainer.data.a> cardData;

        public a(@NotNull String uin, @NotNull ArrayList<com.tencent.mobileqq.cardcontainer.data.a> cardData) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(cardData, "cardData");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uin, (Object) cardData);
            } else {
                this.uin = uin;
                this.cardData = cardData;
            }
        }

        @NotNull
        public final ArrayList<com.tencent.mobileqq.cardcontainer.data.a> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.cardData;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.uin, aVar.uin) && Intrinsics.areEqual(this.cardData, aVar.cardData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.uin.hashCode() * 31) + this.cardData.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "CacheCardData(uin=" + this.uin + ", cardData=" + this.cardData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerApiImpl$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.api.impl.CardContainerApiImpl$b, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/cardcontainer/api/impl/CardContainerApiImpl$c", "Lcom/tencent/mobileqq/cardcontainer/api/b;", "", "isSuccess", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lkotlin/collections/ArrayList;", "dataList", "", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.mobileqq.cardcontainer.api.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f201037a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f201038b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CardContainerApiImpl f201039c;

        c(long j3, String str, CardContainerApiImpl cardContainerApiImpl) {
            this.f201037a = j3;
            this.f201038b = str;
            this.f201039c = cardContainerApiImpl;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), str, cardContainerApiImpl);
            }
        }

        @Override // com.tencent.mobileqq.cardcontainer.api.b
        public void a(boolean isSuccess, @Nullable ArrayList<com.tencent.mobileqq.cardcontainer.data.a> dataList) {
            Integer num;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), dataList);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f201037a;
            String str = this.f201038b;
            if (dataList != null) {
                num = Integer.valueOf(dataList.size());
            } else {
                num = null;
            }
            QLog.i(CardContainerApiImpl.TAG, 1, "[preloadCardContainerData] uin=" + str + " success=" + isSuccess + " time=" + currentTimeMillis + " dataList=" + num);
            if (dataList == null || dataList.isEmpty()) {
                z16 = true;
            }
            if (!z16) {
                CardContainerApiImpl cardContainerApiImpl = this.f201039c;
                String uin = this.f201038b;
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                cardContainerApiImpl.preloadCardData = new a(uin, dataList);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39431);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CardContainerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerApi
    @NotNull
    public i createCardContainerView(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull com.tencent.mobileqq.cardcontainer.g viewModel, @NotNull j daTongReportDelegate, @Nullable k parentScrollHelper, @NotNull com.tencent.mobileqq.cardcontainer.h listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, this, context, lifecycleOwner, viewModel, daTongReportDelegate, parentScrollHelper, listener);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(daTongReportDelegate, "daTongReportDelegate");
        Intrinsics.checkNotNullParameter(listener, "listener");
        CardContainerView cardContainerView = new CardContainerView(context, viewModel, lifecycleOwner, daTongReportDelegate);
        cardContainerView.setListener(listener);
        cardContainerView.setParentScrollHelper(parentScrollHelper);
        return cardContainerView;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerApi
    @NotNull
    public com.tencent.mobileqq.cardcontainer.g getViewModel(@NotNull ViewModelStoreOwner store) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.cardcontainer.g) iPatchRedirector.redirect((short) 3, (Object) this, (Object) store);
        }
        Intrinsics.checkNotNullParameter(store, "store");
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        ViewModel viewModel = new ViewModelProvider(store).get(CardsViewModelImpl.class);
        CardsViewModelImpl cardsViewModelImpl = (CardsViewModelImpl) viewModel;
        a aVar = this.preloadCardData;
        Unit unit = null;
        if (aVar != null) {
            if (Intrinsics.areEqual(currentAccountUin, aVar.b())) {
                QLog.i(TAG, 1, "[getViewModel] preload data exists, uin:" + aVar.b() + " count:" + aVar.a().size());
                cardsViewModelImpl.L1().setValue(aVar.a());
            } else {
                QLog.i(TAG, 1, "[getViewModel] preload data exists, but uin not match, uin:" + currentAccountUin + " preloadUin:" + aVar.b());
            }
            this.preloadCardData = null;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.i(TAG, 1, "[getViewModel] no preload data exists, uin:" + currentAccountUin);
        }
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(store)\u2026sts, uin:$uin\")\n        }");
        return (com.tencent.mobileqq.cardcontainer.g) viewModel;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerApi
    public void preloadCardContainerData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!com.tencent.mobileqq.cardcontainer.config.a.INSTANCE.a().e()) {
            QLog.i(TAG, 1, "[preloadCardContainerData], main switch is off");
            return;
        }
        CardContainerSwitchState remoteCardContainerSwitchState = ((ICardContainerSwitchApi) QRoute.api(ICardContainerSwitchApi.class)).getRemoteCardContainerSwitchState();
        QLog.i(TAG, 1, "[preloadCardContainerData], remoteCardContainerSwitchState:" + remoteCardContainerSwitchState);
        if (remoteCardContainerSwitchState == CardContainerSwitchState.OFF) {
            return;
        }
        ((ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class)).getCardDataFromMMKV(new c(System.currentTimeMillis(), MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), this));
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerApi
    public void startDemoActivity(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            DemoFragment.INSTANCE.a(context);
        }
    }
}
