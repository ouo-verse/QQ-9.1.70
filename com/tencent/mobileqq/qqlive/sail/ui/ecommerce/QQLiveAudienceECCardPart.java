package com.tencent.mobileqq.qqlive.sail.ui.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.card.view.ECommerceCardWrapperView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/QQLiveAudienceECCardPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartResume", "onPartStop", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "U9", "V9", "Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/l;", "e", "Lkotlin/Lazy;", "la", "()Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/l;", "cardViewModel", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardWrapperView;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/card/view/ECommerceCardWrapperView;", "cardView", "<init>", "()V", tl.h.F, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAudienceECCardPart extends com.tencent.mobileqq.qqlive.sail.base.c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cardViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ECommerceCardWrapperView cardView;

    public QQLiveAudienceECCardPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAudienceECCardPart$cardViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final l invoke() {
                return (l) QQLiveAudienceECCardPart.this.getViewModel(l.class);
            }
        });
        this.cardViewModel = lazy;
    }

    private final l la() {
        Object value = this.cardViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cardViewModel>(...)");
        return (l) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        super.U9();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            la().R1(F9.b());
            ECommerceCardWrapperView eCommerceCardWrapperView = this.cardView;
            if (eCommerceCardWrapperView != null) {
                eCommerceCardWrapperView.onEnterRoom();
            }
            F9.p(167, la());
            F9.p(235, la());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Audience|QQLiveAudienceECCardPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        super.V9();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.e(la());
        }
        ECommerceCardWrapperView eCommerceCardWrapperView = this.cardView;
        if (eCommerceCardWrapperView != null) {
            eCommerceCardWrapperView.b();
        }
        la().S1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        ViewParent viewParent;
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            ECommerceCardWrapperView eCommerceCardWrapperView = this.cardView;
            ViewGroup viewGroup = null;
            if (eCommerceCardWrapperView != null) {
                viewParent = eCommerceCardWrapperView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewParent;
            }
            if (viewGroup != null) {
                if (configuration.orientation == 2) {
                    viewGroup.setVisibility(8);
                } else {
                    viewGroup.setVisibility(0);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        super.onInitView(rootView);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ECommerceCardWrapperView eCommerceCardWrapperView = new ECommerceCardWrapperView(context, null, 0, 6, null);
        this.cardView = eCommerceCardWrapperView;
        eCommerceCardWrapperView.setCardViewModel(la());
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f60512vm);
        } else {
            frameLayout = null;
        }
        ECommerceCardWrapperView eCommerceCardWrapperView2 = this.cardView;
        if (eCommerceCardWrapperView2 != null && frameLayout != null) {
            frameLayout.addView(eCommerceCardWrapperView2);
        }
        MutableLiveData<dj4.a> O1 = la().O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<dj4.a, Unit> function1 = new Function1<dj4.a, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAudienceECCardPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(dj4.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable dj4.a aVar) {
                ECommerceCardWrapperView eCommerceCardWrapperView3;
                eCommerceCardWrapperView3 = QQLiveAudienceECCardPart.this.cardView;
                if (eCommerceCardWrapperView3 != null) {
                    eCommerceCardWrapperView3.c(aVar);
                }
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceECCardPart.ma(Function1.this, obj);
            }
        });
        MutableLiveData<Pair<Integer, String>> P1 = la().P1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Pair<? extends Integer, ? extends String>, Unit> function12 = new Function1<Pair<? extends Integer, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAudienceECCardPart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Integer, ? extends String> pair) {
                invoke2((Pair<Integer, String>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Integer, String> pair) {
                ECommerceCardWrapperView eCommerceCardWrapperView3;
                eCommerceCardWrapperView3 = QQLiveAudienceECCardPart.this.cardView;
                if (eCommerceCardWrapperView3 != null) {
                    eCommerceCardWrapperView3.a(pair.getFirst().intValue(), pair.getSecond());
                }
            }
        };
        P1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAudienceECCardPart.na(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        ECommerceCardWrapperView eCommerceCardWrapperView = this.cardView;
        if (eCommerceCardWrapperView != null) {
            eCommerceCardWrapperView.onActivityCreate();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        ECommerceCardWrapperView eCommerceCardWrapperView = this.cardView;
        if (eCommerceCardWrapperView != null) {
            eCommerceCardWrapperView.onActivityDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        ECommerceCardWrapperView eCommerceCardWrapperView = this.cardView;
        if (eCommerceCardWrapperView != null) {
            eCommerceCardWrapperView.onActivityResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        ECommerceCardWrapperView eCommerceCardWrapperView = this.cardView;
        if (eCommerceCardWrapperView != null) {
            eCommerceCardWrapperView.onActivityStop();
        }
    }
}
