package com.tencent.mobileqq.cardcontainer.framework;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi;
import com.tencent.mobileqq.cardcontainer.data.CardContainerSwitchState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bB\t\b\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001cJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardsViewModelImpl;", "Lcom/tencent/mobileqq/cardcontainer/g;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "cardDataList", "", "X1", "", "fromCache", "P1", "", "position", "M1", "", ZPlanPublishSource.FROM_SCHEME, "N1", "O1", "Lcom/tencent/mobileqq/cardcontainer/framework/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/cardcontainer/framework/i;", "repo", "", BdhLogUtil.LogTag.Tag_Conn, "J", "dataRequestCookie", "<init>", "(Lcom/tencent/mobileqq/cardcontainer/framework/i;)V", "()V", "D", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardsViewModelImpl extends com.tencent.mobileqq.cardcontainer.g {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<Boolean> E;

    /* renamed from: C, reason: from kotlin metadata */
    private long dataRequestCookie;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i repo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/framework/CardsViewModelImpl$a;", "", "", "scene", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "cardDataList", "", "c", "", "allowCommittingEmptyRemoteData$delegate", "Lkotlin/Lazy;", "b", "()Z", "allowCommittingEmptyRemoteData", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.framework.CardsViewModelImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) CardsViewModelImpl.E.getValue()).booleanValue();
        }

        public final void c(@NotNull String scene, @NotNull List<? extends com.tencent.mobileqq.cardcontainer.data.a> cardDataList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) scene, (Object) cardDataList);
                return;
            }
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(cardDataList, "cardDataList");
            if (QLog.isDevelopLevel()) {
                int i3 = 0;
                for (Object obj : cardDataList) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    QLog.i("CardContainer.ViewModel", 1, "[" + scene + "] cardDataList[" + i3 + "]: " + ((com.tencent.mobileqq.cardcontainer.data.a) obj));
                    i3 = i16;
                }
            }
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
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40569);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(CardsViewModelImpl$Companion$allowCommittingEmptyRemoteData$2.INSTANCE);
        E = lazy;
    }

    public CardsViewModelImpl(@NotNull i repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.repo = repo;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void X1(final List<? extends com.tencent.mobileqq.cardcontainer.data.a> cardDataList) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.framework.n
                @Override // java.lang.Runnable
                public final void run() {
                    CardsViewModelImpl.Z1(CardsViewModelImpl.this, cardDataList);
                }
            });
        } else {
            L1().setValue(cardDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(CardsViewModelImpl this$0, List cardDataList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cardDataList, "$cardDataList");
        this$0.X1(cardDataList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.cardcontainer.data.a> a2() {
        List<com.tencent.mobileqq.cardcontainer.data.a> emptyList;
        List<com.tencent.mobileqq.cardcontainer.data.a> value = L1().getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return value;
    }

    @Override // com.tencent.mobileqq.cardcontainer.g
    public void M1(int position) {
        List<com.tencent.mobileqq.cardcontainer.data.a> list;
        IntRange indices;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, position);
            return;
        }
        List<com.tencent.mobileqq.cardcontainer.data.a> value = L1().getValue();
        if (value != null) {
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) value);
        } else {
            list = null;
        }
        if (list == null) {
            QLog.e("CardContainer.ViewModel", 1, "[onCloseCard] error cards.value is null, delete interrupt");
            return;
        }
        boolean z16 = false;
        if (position >= 0 && position < list.size()) {
            z16 = true;
        }
        if (!z16) {
            indices = CollectionsKt__CollectionsKt.getIndices(list);
            QLog.e("CardContainer.ViewModel", 1, "[onCloseCard] error position(" + position + ") not in " + indices);
            return;
        }
        com.tencent.mobileqq.cardcontainer.data.a remove = list.remove(position);
        L1().setValue(list);
        this.repo.b(remove, position);
    }

    @Override // com.tencent.mobileqq.cardcontainer.g
    public void N1(int position, @NotNull String scheme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, position, (Object) scheme);
        } else {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            M1(position);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.g
    public void O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            X1(this.repo.c());
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.g
    public void P1(boolean fromCache) {
        List<? extends com.tencent.mobileqq.cardcontainer.data.a> emptyList;
        List<com.tencent.mobileqq.cardcontainer.data.a> emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, fromCache);
            return;
        }
        if (((ICardContainerSwitchApi) QRoute.api(ICardContainerSwitchApi.class)).getRemoteCardContainerSwitchState() == CardContainerSwitchState.OFF) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            X1(emptyList);
            MutableLiveData<List<com.tencent.mobileqq.cardcontainer.data.a>> L1 = L1();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            L1.setValue(emptyList2);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        this.dataRequestCookie = currentTimeMillis;
        QLog.i("CardContainer.ViewModel", 1, "[initData] start fetch card data, cookie=" + currentTimeMillis + " fromCache=" + fromCache);
        if (fromCache) {
            this.repo.d(new Function1<List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit>(currentTimeMillis) { // from class: com.tencent.mobileqq.cardcontainer.framework.CardsViewModelImpl$updateData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $startTime;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$startTime = currentTimeMillis;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, CardsViewModelImpl.this, Long.valueOf(currentTimeMillis));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.cardcontainer.data.a> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull List<? extends com.tencent.mobileqq.cardcontainer.data.a> it) {
                    long j3;
                    long j16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    j3 = CardsViewModelImpl.this.dataRequestCookie;
                    long j17 = this.$startTime;
                    if (j3 != j17) {
                        j16 = CardsViewModelImpl.this.dataRequestCookie;
                        QLog.i("CardContainer.ViewModel", 1, "[initData] cache data received, but outdated, cookie=" + j17 + "!=" + j16);
                        return;
                    }
                    QLog.i("CardContainer.ViewModel", 1, "[initData] cache data received, card count: " + it.size() + " cost: " + (System.currentTimeMillis() - this.$startTime) + "ms");
                    CardsViewModelImpl.this.X1(it);
                }
            });
        }
        this.repo.a(new Function1<List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit>(currentTimeMillis) { // from class: com.tencent.mobileqq.cardcontainer.framework.CardsViewModelImpl$updateData$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $startTime;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$startTime = currentTimeMillis;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, CardsViewModelImpl.this, Long.valueOf(currentTimeMillis));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.cardcontainer.data.a> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<? extends com.tencent.mobileqq.cardcontainer.data.a> it) {
                long j3;
                List a26;
                boolean b16;
                long j16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                j3 = CardsViewModelImpl.this.dataRequestCookie;
                long j17 = this.$startTime;
                if (j3 != j17) {
                    j16 = CardsViewModelImpl.this.dataRequestCookie;
                    QLog.i("CardContainer.ViewModel", 1, "[initData] remote data received, but outdated, cookie=" + j17 + "!=" + j16);
                    return;
                }
                QLog.i("CardContainer.ViewModel", 1, "[initData] remote data received, card count: " + it.size() + " cost: " + (System.currentTimeMillis() - this.$startTime) + "ms");
                a26 = CardsViewModelImpl.this.a2();
                if ((!a26.isEmpty()) && it.isEmpty()) {
                    b16 = CardsViewModelImpl.INSTANCE.b();
                    if (!b16) {
                        QLog.i("CardContainer.ViewModel", 1, "remote data is empty while local data is not, ignore it ");
                        CardsViewModelImpl.this.dataRequestCookie = 0L;
                    }
                }
                CardsViewModelImpl.this.X1(it);
                CardsViewModelImpl.this.dataRequestCookie = 0L;
            }
        });
    }

    public CardsViewModelImpl() {
        this(new o());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
