package com.tencent.mobileqq.qwallet.home;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000b\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00030\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\u0003H\u0007J\u0006\u0010\u0010\u001a\u00020\u0003J\u0017\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R+\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001c0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "", "R1", "", "O1", "Lkotlin/Function2;", "Lcom/tencent/gdtad/aditem/GdtAd;", "", "callback", "M1", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Q1", "totalTickDuration", "P1", "(Ljava/lang/Long;)V", "Landroidx/lifecycle/SavedStateHandle;", "i", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isPreview", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "L1", "()Landroidx/lifecycle/MutableLiveData;", "adLiveData", "Lcom/tencent/mobileqq/qwallet/home/report/d;", "D", "Lcom/tencent/mobileqq/qwallet/home/report/d;", "N1", "()Lcom/tencent/mobileqq/qwallet/home/report/d;", "S1", "(Lcom/tencent/mobileqq/qwallet/home/report/d;)V", "techReporter", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "E", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletHomeAdViewModel extends ViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<GdtAd, Long>> adLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qwallet.home.report.d techReporter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SavedStateHandle stateHandle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isPreview;

    public QWalletHomeAdViewModel(@NotNull SavedStateHandle stateHandle) {
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.stateHandle = stateHandle;
        this.isPreview = QWalletHomePreviewController.f277969a.i(stateHandle);
        this.adLiveData = new MutableLiveData<>();
    }

    private final void M1(final Function2<? super GdtAd, ? super Long, Unit> callback) {
        QWalletHomeAdvIPCModule.f277953d.d(this.isPreview, new Function2<GdtAd, Long, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeAdViewModel$getAdvAsync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GdtAd gdtAd, Long l3) {
                invoke2(gdtAd, l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable GdtAd gdtAd, @Nullable final Long l3) {
                if (gdtAd != null) {
                    callback.invoke(gdtAd, l3);
                    return;
                }
                QLog.w("QWalletHome-AdViewModel", 1, "ipc get adv fail, start request again");
                com.tencent.mobileqq.qwallet.ad.q qVar = com.tencent.mobileqq.qwallet.ad.q.f277085a;
                final Function2<GdtAd, Long, Unit> function2 = callback;
                qVar.a("4091569797816435", new Function1<GdtAd, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeAdViewModel$getAdvAsync$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(GdtAd gdtAd2) {
                        invoke2(gdtAd2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable GdtAd gdtAd2) {
                        function2.invoke(gdtAd2, l3);
                    }
                });
            }
        });
    }

    private final boolean O1() {
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            ol2.a.c();
            return true;
        }
        return true;
    }

    private final void R1() {
        if (O1()) {
            return;
        }
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(MobileQQ.sMobileQQ, new InitGdtContextParams());
        com.tencent.mobileqq.qwallet.home.report.d dVar = this.techReporter;
        if (dVar != null) {
            dVar.h();
        }
        M1(new Function2<GdtAd, Long, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeAdViewModel$requestAd$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GdtAd gdtAd, Long l3) {
                invoke2(gdtAd, l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable GdtAd gdtAd, @Nullable Long l3) {
                QLog.i("QWalletHome-AdViewModel", 1, "get adv success, " + (gdtAd != null ? gdtAd.getTraceId() : null) + ", " + l3);
                com.tencent.mobileqq.qwallet.home.report.d techReporter = QWalletHomeAdViewModel.this.getTechReporter();
                if (techReporter != null) {
                    techReporter.g(gdtAd != null ? gdtAd.getTraceId() : null, gdtAd != null);
                }
                if (gdtAd != null) {
                    QWalletHomeAdViewModel.this.L1().postValue(new Pair<>(gdtAd, l3));
                }
            }
        });
    }

    @NotNull
    public final MutableLiveData<Pair<GdtAd, Long>> L1() {
        return this.adLiveData;
    }

    @Nullable
    /* renamed from: N1, reason: from getter */
    public final com.tencent.mobileqq.qwallet.home.report.d getTechReporter() {
        return this.techReporter;
    }

    public final void P1(@Nullable Long totalTickDuration) {
        GdtAd gdtAd;
        if (!this.isPreview) {
            return;
        }
        QWalletHomeAdvIPCModule qWalletHomeAdvIPCModule = QWalletHomeAdvIPCModule.f277953d;
        Pair<GdtAd, Long> value = this.adLiveData.getValue();
        if (value != null) {
            gdtAd = value.getFirst();
        } else {
            gdtAd = null;
        }
        qWalletHomeAdvIPCModule.m(gdtAd, totalTickDuration);
    }

    public final void Q1() {
        if (O1()) {
            return;
        }
        com.tencent.mobileqq.qwallet.ad.q.f277085a.a("4091569797816435", new Function1<GdtAd, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeAdViewModel$refreshAD$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GdtAd gdtAd) {
                invoke2(gdtAd);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable GdtAd gdtAd) {
                if (gdtAd != null) {
                    QWalletHomeAdViewModel.this.L1().postValue(new Pair<>(gdtAd, null));
                }
            }
        });
    }

    public final void S1(@Nullable com.tencent.mobileqq.qwallet.home.report.d dVar) {
        this.techReporter = dVar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        R1();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        if (!this.isPreview) {
            QWalletHomeAdvIPCModule.f277953d.clearCache();
        }
    }
}
