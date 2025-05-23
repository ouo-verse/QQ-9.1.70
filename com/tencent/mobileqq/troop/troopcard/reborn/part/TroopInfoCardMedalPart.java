package com.tencent.mobileqq.troop.troopcard.reborn.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.ui.medal.TroopInfoCardMedalAdapter;
import com.tencent.mobileqq.troop.troopcard.ui.medal.TroopMedalRecyclerView;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMedalInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardMedalPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "N9", "Landroid/view/View$OnClickListener;", "G9", "K9", "", "J9", "I9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "()Lcom/tencent/common/app/AppInterface;", "appInterface", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "troopMedalRootView", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "troopMedalTitle", "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/TroopMedalRecyclerView;", tl.h.F, "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/TroopMedalRecyclerView;", "medalRecyclerView", "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/d;", "i", "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/d;", "layoutManager", "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/TroopInfoCardMedalAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/TroopInfoCardMedalAdapter;", "adapter", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "basicInfoViewModel", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/v;", "D", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/v;", "viewModel", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardMedalPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private TroopBasicInfoViewModel basicInfoViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopcard.reborn.vm.v viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface appInterface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout troopMedalRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout troopMedalTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TroopMedalRecyclerView medalRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopcard.ui.medal.d layoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TroopInfoCardMedalAdapter adapter;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardMedalPart$a", "Lcom/tencent/mobileqq/troop/troopcard/ui/medal/c;", "", "value", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements com.tencent.mobileqq.troop.troopcard.ui.medal.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardMedalPart.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopcard.ui.medal.c
        public void a(boolean value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                com.tencent.mobileqq.troop.troopcard.ui.medal.d dVar = TroopInfoCardMedalPart.this.layoutManager;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                    dVar = null;
                }
                dVar.a(value);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, value);
        }
    }

    public TroopInfoCardMedalPart(@NotNull AppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.appInterface = appInterface;
        }
    }

    private final View.OnClickListener G9() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.bd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopInfoCardMedalPart.H9(TroopInfoCardMedalPart.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(TroopInfoCardMedalPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this$0.J9());
        this$0.getContext().startActivity(intent);
        TroopCardDtHelper.B(TroopCardDtHelper.f299952a, null, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String I9() {
        String replace$default;
        com.tencent.mobileqq.troop.troopcard.reborn.vm.v vVar = this.viewModel;
        TroopBasicInfoViewModel troopBasicInfoViewModel = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vVar = null;
        }
        String str = vVar.P1().medalDetailUrl;
        Intrinsics.checkNotNullExpressionValue(str, "viewModel.medalListRsp.medalDetailUrl");
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
        } else {
            troopBasicInfoViewModel = troopBasicInfoViewModel2;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(str, "$GCODE$", troopBasicInfoViewModel.K2(), false, 4, (Object) null);
        return replace$default;
    }

    private final String J9() {
        String replace$default;
        String str;
        String replace$default2;
        TroopInfo i3;
        com.tencent.mobileqq.troop.troopcard.reborn.vm.v vVar = this.viewModel;
        String str2 = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vVar = null;
        }
        String str3 = vVar.P1().medalListUrl;
        Intrinsics.checkNotNullExpressionValue(str3, "viewModel.medalListRsp.medalListUrl");
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(str3, "$GCODE$", troopBasicInfoViewModel.K2(), false, 4, (Object) null);
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
            troopBasicInfoViewModel2 = null;
        }
        com.tencent.mobileqq.troop.data.v D2 = troopBasicInfoViewModel2.D2();
        if (D2 != null && (i3 = D2.i()) != null) {
            str2 = i3.getTroopDisplayName();
        }
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$GNAME$", str, false, 4, (Object) null);
        return replace$default2;
    }

    private final void K9() {
        com.tencent.mobileqq.troop.troopcard.reborn.vm.v vVar = this.viewModel;
        com.tencent.mobileqq.troop.troopcard.reborn.vm.v vVar2 = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vVar = null;
        }
        LiveData<Boolean> M1 = vVar.M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardMedalPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardMedalPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                LinearLayout linearLayout;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                linearLayout = TroopInfoCardMedalPart.this.troopMedalRootView;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopMedalRootView");
                    linearLayout = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                linearLayout.setVisibility(it.booleanValue() ? 0 : 8);
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.be
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardMedalPart.L9(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.troop.troopcard.reborn.vm.v vVar3 = this.viewModel;
        if (vVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            vVar2 = vVar3;
        }
        LiveData<List<GroupMedalInfo>> Q1 = vVar2.Q1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<List<GroupMedalInfo>, Unit> function12 = new Function1<List<GroupMedalInfo>, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardMedalPart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopInfoCardMedalPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<GroupMedalInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<GroupMedalInfo> it) {
                TroopMedalRecyclerView troopMedalRecyclerView;
                TroopInfoCardMedalAdapter troopInfoCardMedalAdapter;
                TroopInfoCardMedalAdapter troopInfoCardMedalAdapter2;
                String I9;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                troopMedalRecyclerView = TroopInfoCardMedalPart.this.medalRecyclerView;
                TroopInfoCardMedalAdapter troopInfoCardMedalAdapter3 = null;
                if (troopMedalRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("medalRecyclerView");
                    troopMedalRecyclerView = null;
                }
                troopMedalRecyclerView.setVisibility(0);
                troopInfoCardMedalAdapter = TroopInfoCardMedalPart.this.adapter;
                if (troopInfoCardMedalAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    troopInfoCardMedalAdapter = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopInfoCardMedalAdapter.t0(it);
                troopInfoCardMedalAdapter2 = TroopInfoCardMedalPart.this.adapter;
                if (troopInfoCardMedalAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    troopInfoCardMedalAdapter3 = troopInfoCardMedalAdapter2;
                }
                I9 = TroopInfoCardMedalPart.this.I9();
                troopInfoCardMedalAdapter3.s0(I9);
            }
        };
        Q1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.part.bf
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopInfoCardMedalPart.M9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void N9() {
        View findViewById = getPartRootView().findViewById(R.id.yz6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.medal_card)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.troopMedalRootView = linearLayout;
        TroopInfoCardMedalAdapter troopInfoCardMedalAdapter = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMedalRootView");
            linearLayout = null;
        }
        View findViewById2 = linearLayout.findViewById(R.id.f102585ya);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "troopMedalRootView.findV\u2026d(R.id.troop_medal_title)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById2;
        this.troopMedalTitle = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMedalTitle");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(G9());
        LinearLayout linearLayout2 = this.troopMedalRootView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopMedalRootView");
            linearLayout2 = null;
        }
        View findViewById3 = linearLayout2.findViewById(R.id.yz_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "troopMedalRootView.findV\u2026l_recyclerview_container)");
        this.medalRecyclerView = (TroopMedalRecyclerView) findViewById3;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.layoutManager = new com.tencent.mobileqq.troop.troopcard.ui.medal.d(context);
        TroopMedalRecyclerView troopMedalRecyclerView = this.medalRecyclerView;
        if (troopMedalRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("medalRecyclerView");
            troopMedalRecyclerView = null;
        }
        com.tencent.mobileqq.troop.troopcard.ui.medal.d dVar = this.layoutManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            dVar = null;
        }
        troopMedalRecyclerView.setLayoutManager(dVar);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.adapter = new TroopInfoCardMedalAdapter(context2, new a());
        TroopMedalRecyclerView troopMedalRecyclerView2 = this.medalRecyclerView;
        if (troopMedalRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("medalRecyclerView");
            troopMedalRecyclerView2 = null;
        }
        TroopInfoCardMedalAdapter troopInfoCardMedalAdapter2 = this.adapter;
        if (troopInfoCardMedalAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            troopInfoCardMedalAdapter = troopInfoCardMedalAdapter2;
        }
        troopMedalRecyclerView2.setAdapter(troopInfoCardMedalAdapter);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        N9();
        K9();
        com.tencent.mobileqq.troop.troopcard.reborn.vm.v vVar = this.viewModel;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vVar = null;
        }
        vVar.N1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        ViewModel viewModel = getViewModel(TroopBasicInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopBasicInfoViewModel::class.java)");
        this.basicInfoViewModel = (TroopBasicInfoViewModel) viewModel;
        ViewModel viewModel2 = getViewModel(com.tencent.mobileqq.troop.troopcard.reborn.vm.v.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(TroopInfoCa\u2026dalViewModel::class.java)");
        com.tencent.mobileqq.troop.troopcard.reborn.vm.v vVar = (com.tencent.mobileqq.troop.troopcard.reborn.vm.v) viewModel2;
        this.viewModel = vVar;
        TroopBasicInfoViewModel troopBasicInfoViewModel = null;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vVar = null;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.basicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("basicInfoViewModel");
        } else {
            troopBasicInfoViewModel = troopBasicInfoViewModel2;
        }
        vVar.R1(troopBasicInfoViewModel.K2());
    }
}
