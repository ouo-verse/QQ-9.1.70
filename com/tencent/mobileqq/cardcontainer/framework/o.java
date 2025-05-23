package com.tencent.mobileqq.cardcontainer.framework;

import com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi;
import com.tencent.mobileqq.cardcontainer.data.ContainerData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J\"\u0010\b\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/o;", "Lcom/tencent/mobileqq/cardcontainer/framework/i;", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "", "callback", "d", "a", "cardData", "", "position", "b", "c", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class o implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/o$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.framework.o$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/cardcontainer/framework/o$b", "Lcom/tencent/mobileqq/cardcontainer/api/b;", "", "isSuccess", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lkotlin/collections/ArrayList;", "dataList", "", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mobileqq.cardcontainer.api.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> f201139a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> function1) {
            this.f201139a = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.util.List] */
        @Override // com.tencent.mobileqq.cardcontainer.api.b
        public void a(boolean isSuccess, @Nullable ArrayList<com.tencent.mobileqq.cardcontainer.data.a> dataList) {
            List<? extends com.tencent.mobileqq.cardcontainer.data.a> emptyList;
            ?? emptyList2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), dataList);
                return;
            }
            if (isSuccess) {
                Function1<List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> function1 = this.f201139a;
                ArrayList<com.tencent.mobileqq.cardcontainer.data.a> arrayList = dataList;
                if (dataList == null) {
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    arrayList = emptyList2;
                }
                function1.invoke(arrayList);
                return;
            }
            QLog.w("CardContainer.CardsRepo", 1, "[fetchFromCache] failed to get data from MMKV");
            Function1<List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> function12 = this.f201139a;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            function12.invoke(emptyList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/cardcontainer/framework/o$c", "Lcom/tencent/mobileqq/cardcontainer/api/c;", "", "isSuccess", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "Lkotlin/collections/ArrayList;", "dataList", "", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.mobileqq.cardcontainer.api.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> f201140a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> function1) {
            this.f201140a = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List] */
        @Override // com.tencent.mobileqq.cardcontainer.api.c
        public void a(boolean isSuccess, @Nullable ArrayList<com.tencent.mobileqq.cardcontainer.data.a> dataList) {
            ?? emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), dataList);
                return;
            }
            if (isSuccess) {
                Function1<List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> function1 = this.f201140a;
                ArrayList<com.tencent.mobileqq.cardcontainer.data.a> arrayList = dataList;
                if (dataList == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    arrayList = emptyList;
                }
                function1.invoke(arrayList);
                return;
            }
            QLog.w("CardContainer.CardsRepo", 1, "[fetchFromRemote] failed to get data from net");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40621);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.i
    public void a(@NotNull Function1<? super List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class)).getCardDataFromNet(new c(callback));
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.i
    public void b(@NotNull com.tencent.mobileqq.cardcontainer.data.a cardData, int position) {
        ContainerData containerData;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cardData, position);
            return;
        }
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        QLog.d("CardContainer.CardsRepo", 1, "[onCardDeleted] " + cardData + ", position: " + position);
        Unit unit = null;
        if (cardData instanceof ContainerData) {
            containerData = (ContainerData) cardData;
        } else {
            containerData = null;
        }
        if (containerData == null) {
            QLog.w("CardContainer.CardsRepo", 1, "[onCardDeleted] invalid card data: " + cardData);
            return;
        }
        ArrayList<com.tencent.mobileqq.cardcontainer.data.b> h16 = containerData.h();
        if (h16 != null) {
            if (h16.isEmpty()) {
                QLog.w("CardContainer.CardsRepo", 1, "[onCardDeleted] item list is empty: " + cardData);
                return;
            }
            int n3 = containerData.n();
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) h16);
            String c16 = ((com.tencent.mobileqq.cardcontainer.data.b) first).c();
            QLog.i("CardContainer.CardsRepo", 1, "[onCardDeleted] dataId: " + n3 + ", itemId: " + c16);
            ((ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class)).deleteCardData(n3, c16, containerData.s());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.w("CardContainer.CardsRepo", 1, "[onCardDeleted] item list is null: " + cardData);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.i
    @NotNull
    public List<com.tencent.mobileqq.cardcontainer.data.a> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ((ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class)).getCardDataFromCache();
    }

    @Override // com.tencent.mobileqq.cardcontainer.framework.i
    public void d(@NotNull Function1<? super List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class)).getCardDataFromMMKV(new b(callback));
        }
    }
}
