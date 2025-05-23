package com.tencent.mobileqq.wink.publish.viewmodel;

import android.os.CountDownTimer;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.publish.util.WinkPublishConfigUtil;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishBubbleViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "R1", "", "getLogTag", "Landroidx/lifecycle/MediatorLiveData;", "", "i", "Landroidx/lifecycle/MediatorLiveData;", "_syncQZoneBubble", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "syncQZoneBubble", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishBubbleViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<String> D;

    @NotNull
    private static final Lazy<String> E;

    @NotNull
    private static final Lazy<String> F;

    @NotNull
    private static final Lazy<String> G;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Boolean> _syncQZoneBubble;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> syncQZoneBubble;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001b\u0010\u0014\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001b\u0010\u0017\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/publish/viewmodel/PublishBubbleViewModel$a;", "", "", "i", "", tl.h.F, "j", "k", "", "kotlin.jvm.PlatformType", "account$delegate", "Lkotlin/Lazy;", "d", "()Ljava/lang/String;", "account", "SYNC_QZONE_BUBBLE_SHOWN$delegate", "e", "SYNC_QZONE_BUBBLE_SHOWN", "SYNC_QZONE_FROM_QZONE_BUBBLE_SHOWN$delegate", "f", "SYNC_QZONE_FROM_QZONE_BUBBLE_SHOWN", "TROOP_BUBBLE_STATUS$delegate", "g", "TROOP_BUBBLE_STATUS", "", "BUBBLE_NEED_SHOW", "I", "BUBBLE_SHOWN", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.viewmodel.PublishBubbleViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d() {
            return (String) PublishBubbleViewModel.D.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String e() {
            return (String) PublishBubbleViewModel.E.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f() {
            return (String) PublishBubbleViewModel.F.getValue();
        }

        private final String g() {
            return (String) PublishBubbleViewModel.G.getValue();
        }

        public final boolean h() {
            boolean isExperiment = ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_qqvideo_topicguid_1505");
            boolean g16 = WinkPublishConfigUtil.f325969a.g();
            if (isExperiment && !g16) {
                QLog.d("PublishBubbleViewModel", 1, "[isTroopBubbleNeedShow] hash tag tip need show first");
                return false;
            }
            if (ar.f326685a.e(g(), 0) == 1) {
                return true;
            }
            return false;
        }

        public final void i() {
            if (Intrinsics.areEqual("10", WinkContext.INSTANCE.d().p("up_source"))) {
                ar.f326685a.m(f(), true);
            } else {
                ar.f326685a.m(e(), true);
            }
        }

        public final void j() {
            ar arVar = ar.f326685a;
            if (arVar.e(g(), 0) == 2) {
                return;
            }
            arVar.o(g(), 1);
        }

        public final void k() {
            ar.f326685a.o(g(), 2);
        }

        Companion() {
        }
    }

    static {
        Lazy<String> lazy;
        Lazy<String> lazy2;
        Lazy<String> lazy3;
        Lazy<String> lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishBubbleViewModel$Companion$account$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return WinkCommonUtil.getCurrentAccount();
            }
        });
        D = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishBubbleViewModel$Companion$SYNC_QZONE_BUBBLE_SHOWN$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String d16;
                d16 = PublishBubbleViewModel.INSTANCE.d();
                return "syncQzoneBubbleShown-" + d16;
            }
        });
        E = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishBubbleViewModel$Companion$SYNC_QZONE_FROM_QZONE_BUBBLE_SHOWN$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String d16;
                d16 = PublishBubbleViewModel.INSTANCE.d();
                return "syncQzoneFromQzoneBubbleShown-" + d16;
            }
        });
        F = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishBubbleViewModel$Companion$TROOP_BUBBLE_STATUS$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String d16;
                d16 = PublishBubbleViewModel.INSTANCE.d();
                return "troopBubbleStatus-" + d16;
            }
        });
        G = lazy4;
    }

    public PublishBubbleViewModel() {
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this._syncQZoneBubble = mediatorLiveData;
        this.syncQZoneBubble = mediatorLiveData;
    }

    @NotNull
    public final LiveData<Boolean> Q1() {
        return this.syncQZoneBubble;
    }

    public final void R1() {
        new b().start();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PublishBubbleViewModel";
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/publish/viewmodel/PublishBubbleViewModel$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends CountDownTimer {
        b() {
            super(2000L, 2000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            boolean c16;
            Companion companion = PublishBubbleViewModel.INSTANCE;
            if (companion.h()) {
                return;
            }
            if (Intrinsics.areEqual("10", WinkContext.INSTANCE.d().p("up_source"))) {
                c16 = ar.f326685a.c(companion.f(), false);
            } else {
                c16 = ar.f326685a.c(companion.e(), false);
            }
            QLog.d("PublishBubbleViewModel", 1, "[tryShowQZoneBubble] " + c16);
            PublishBubbleViewModel.this._syncQZoneBubble.postValue(Boolean.valueOf(c16 ^ true));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
        }
    }
}
