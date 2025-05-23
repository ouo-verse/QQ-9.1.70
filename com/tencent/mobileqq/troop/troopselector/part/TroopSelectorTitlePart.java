package com.tencent.mobileqq.troop.troopselector.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorVM;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R#\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/part/TroopSelectorTitlePart;", "Lcom/tencent/mobileqq/troop/troopselector/part/a;", "", "F9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "d", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "quiSecNavBar", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorVM;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorVM;", "vm", "<init>", "(Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopSelectorTitlePart extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopSelectorConfig config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar quiSecNavBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    public TroopSelectorTitlePart(TroopSelectorConfig troopSelectorConfig) {
        Lazy lazy;
        this.config = troopSelectorConfig;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectorVM>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorTitlePart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopSelectorVM invoke() {
                return (TroopSelectorVM) TroopSelectorTitlePart.this.getViewModel(TroopSelectorVM.class);
            }
        });
        this.vm = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSelectorVM E9() {
        return (TroopSelectorVM) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F9() {
        TroopSelectorConfig troopSelectorConfig = this.config;
        if (troopSelectorConfig != null && troopSelectorConfig.a() == 2) {
            ArrayList<ResultRecord> c16 = this.config.c();
            if (c16 != null && (c16.isEmpty() ^ true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setCenterText(HardCodeUtil.qqStr(R.string.f20676597));
        qUISecNavBar.setRightType(1);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorTitlePart$onInitView$1$1

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes35.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f301050a;

                static {
                    int[] iArr = new int[BaseAction.values().length];
                    try {
                        iArr[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f301050a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, BaseAction action) {
                TroopSelectorConfig troopSelectorConfig;
                TroopSelectorVM E9;
                TroopSelectorVM E92;
                boolean F9;
                Activity activity;
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(action, "action");
                int i3 = a.f301050a[action.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2 && (activity = TroopSelectorTitlePart.this.getActivity()) != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                troopSelectorConfig = TroopSelectorTitlePart.this.config;
                if (troopSelectorConfig != null && troopSelectorConfig.e()) {
                    E9 = TroopSelectorTitlePart.this.E9();
                    ArrayList<SharedNode> value = E9.S1().getValue();
                    if (!(value != null && (value.isEmpty() ^ true))) {
                        F9 = TroopSelectorTitlePart.this.F9();
                        if (!F9) {
                            return;
                        }
                    }
                    E92 = TroopSelectorTitlePart.this.E9();
                    E92.N1();
                }
            }
        });
        LifecycleOwner viewLifecycleOwner = getPartHost().getViewLifecycleOwner();
        LiveData<ArrayList<SharedNode>> S1 = E9().S1();
        final Function1<ArrayList<SharedNode>, Unit> function1 = new Function1<ArrayList<SharedNode>, Unit>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorTitlePart$onInitView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SharedNode> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<SharedNode> arrayList) {
                TroopSelectorConfig troopSelectorConfig;
                QUISecNavBar qUISecNavBar2;
                QUISecNavBar qUISecNavBar3;
                QUISecNavBar qUISecNavBar4;
                QUISecNavBar qUISecNavBar5;
                boolean F9;
                troopSelectorConfig = TroopSelectorTitlePart.this.config;
                boolean z16 = false;
                if (troopSelectorConfig != null && troopSelectorConfig.e()) {
                    z16 = true;
                }
                if (z16) {
                    QUISecNavBar qUISecNavBar6 = null;
                    if (arrayList.isEmpty()) {
                        qUISecNavBar4 = TroopSelectorTitlePart.this.quiSecNavBar;
                        if (qUISecNavBar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
                            qUISecNavBar4 = null;
                        }
                        qUISecNavBar4.setRightText("\u786e\u5b9a");
                        qUISecNavBar5 = TroopSelectorTitlePart.this.quiSecNavBar;
                        if (qUISecNavBar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
                        } else {
                            qUISecNavBar6 = qUISecNavBar5;
                        }
                        BaseAction baseAction = BaseAction.ACTION_RIGHT_TEXT;
                        F9 = TroopSelectorTitlePart.this.F9();
                        qUISecNavBar6.setBaseViewEnabled(baseAction, F9);
                        return;
                    }
                    qUISecNavBar2 = TroopSelectorTitlePart.this.quiSecNavBar;
                    if (qUISecNavBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
                        qUISecNavBar2 = null;
                    }
                    qUISecNavBar2.setRightText("\u786e\u5b9a(" + arrayList.size() + ')');
                    qUISecNavBar3 = TroopSelectorTitlePart.this.quiSecNavBar;
                    if (qUISecNavBar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
                    } else {
                        qUISecNavBar6 = qUISecNavBar3;
                    }
                    qUISecNavBar6.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
                }
            }
        };
        S1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopselector.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSelectorTitlePart.G9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        QUISecNavBar qUISecNavBar = getPartHost().quiSecNavBar;
        Intrinsics.checkNotNullExpressionValue(qUISecNavBar, "partHost.quiSecNavBar");
        this.quiSecNavBar = qUISecNavBar;
    }
}
