package com.tencent.mobileqq.troop.troopidentity.parts;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityEmptyStatePart;", "Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityIconBasePart;", "", "L9", "", "isVisible", "O9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "emptyLayout", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "f", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityEmptyStatePart extends TroopIdentityIconBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout emptyLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIEmptyState emptyView;

    public TroopIdentityEmptyStatePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void J9() {
        this.emptyView = new QUIEmptyState.Builder(getContext()).setImageType(5).setTitle("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u70b9\u51fb\u5237\u65b0").setBackgroundColorType(2).setButton("\u5237\u65b0", new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopIdentityEmptyStatePart.K9(TroopIdentityEmptyStatePart.this, view);
            }
        }).build();
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = this.emptyLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
            relativeLayout = null;
        }
        if (relativeLayout instanceof ViewGroup) {
            relativeLayout2 = relativeLayout;
        }
        if (relativeLayout2 != null) {
            relativeLayout2.addView(this.emptyView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(TroopIdentityEmptyStatePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A9().U1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L9() {
        LiveData<GetIdentityListRsp> Z1 = A9().Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GetIdentityListRsp, Unit> function1 = new Function1<GetIdentityListRsp, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityEmptyStatePart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityEmptyStatePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GetIdentityListRsp getIdentityListRsp) {
                invoke2(getIdentityListRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GetIdentityListRsp getIdentityListRsp) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    TroopIdentityEmptyStatePart.this.O9(false);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) getIdentityListRsp);
                }
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityEmptyStatePart.M9(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> h26 = A9().h2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit> function12 = new Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityEmptyStatePart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityEmptyStatePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                } else if (cVar instanceof c.e) {
                    TroopIdentityEmptyStatePart.this.O9(((c.e) cVar).a());
                }
            }
        };
        h26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityEmptyStatePart.N9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(boolean isVisible) {
        int i3;
        RelativeLayout relativeLayout = this.emptyLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
            relativeLayout = null;
        }
        if (isVisible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        if (isVisible && this.emptyView == null) {
            J9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.bwi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.empty_layout)");
        this.emptyLayout = (RelativeLayout) findViewById;
        L9();
    }
}
