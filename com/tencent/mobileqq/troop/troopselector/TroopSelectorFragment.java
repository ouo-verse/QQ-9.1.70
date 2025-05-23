package com.tencent.mobileqq.troop.troopselector;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.troopbatch.event.TroopBatchListEvent;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi;
import com.tencent.mobileqq.troop.troopselector.part.TroopSelectorListPart;
import com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart;
import com.tencent.mobileqq.troop.troopselector.part.TroopSelectorTitlePart;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\bH\u0016J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R#\u00104\u001a\n /*\u0004\u0018\u00010.0.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001d\u00109\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "Mh", "Rh", "Sh", "Uh", "Gh", "", "isConfirm", "", "", "", "Jh", "Th", "Xh", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Hh", "", "getContentLayoutId", "useQUISecNavBar", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "Kh", "()Landroid/widget/FrameLayout;", "setListRootView", "(Landroid/widget/FrameLayout;)V", "listRootView", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "D", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "limitDialog", "E", "applyQRobotInstConfirmDialog", UserInfo.SEX_FEMALE, "robotCancelBindTroopDialog", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorVM;", "kotlin.jvm.PlatformType", "G", "Lkotlin/Lazy;", "Lh", "()Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorVM;", "vm", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "H", "Ih", "()Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", DownloadInfo.spKey_Config, "<init>", "()V", "I", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopSelectorFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout listRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private QQCustomDialog limitDialog;

    /* renamed from: E, reason: from kotlin metadata */
    private QQCustomDialog applyQRobotInstConfirmDialog;

    /* renamed from: F, reason: from kotlin metadata */
    private QQCustomDialog robotCancelBindTroopDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy config;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopselector/TroopSelectorFragment$b", "Lcom/tencent/mobileqq/troop/troopmanager/api/ITroopIntelligentManageApi$a;", "", "errorCode", "", "errorMsg", "", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements ITroopIntelligentManageApi.a {
        b() {
        }

        @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi.a
        public void a(int errorCode, String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            if (!TextUtils.isEmpty(errorMsg)) {
                QQToast.makeText(TroopSelectorFragment.this.getContext(), errorCode == 0 ? 2 : 1, errorMsg, 0).show();
            }
            if (errorCode == 0) {
                TroopSelectorFragment.this.Rh();
            }
        }
    }

    public TroopSelectorFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectorVM>() { // from class: com.tencent.mobileqq.troop.troopselector.TroopSelectorFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopSelectorVM invoke() {
                return (TroopSelectorVM) TroopSelectorFragment.this.getViewModel(TroopSelectorVM.class);
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectorConfig>() { // from class: com.tencent.mobileqq.troop.troopselector.TroopSelectorFragment$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopSelectorConfig invoke() {
                Bundle arguments = TroopSelectorFragment.this.getArguments();
                if (arguments != null) {
                    return (TroopSelectorConfig) arguments.getParcelable("selectorConfig");
                }
                return null;
            }
        });
        this.config = lazy2;
    }

    private final void Gh() {
        if (!NetworkUtil.isNetSupport(getContext())) {
            QQToast.makeText(getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
            return;
        }
        ArrayList<Integer> integerArrayList = requireArguments().getIntegerArrayList(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_INSTRUCTION_LIST);
        if (integerArrayList == null) {
            requireActivity().finish();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<SharedNode> value = Lh().S1().getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(((SharedNode) it.next()).getKey());
            }
        }
        ((ITroopIntelligentManageApi) QRoute.api(ITroopIntelligentManageApi.class)).applyInstructionCopy(requireArguments().getString(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN), integerArrayList, arrayList, new b());
    }

    private final QQAppInterface Hh() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return (QQAppInterface) peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSelectorConfig Ih() {
        return (TroopSelectorConfig) this.config.getValue();
    }

    private final Map<String, Object> Jh(boolean isConfirm) {
        String str;
        if (getArguments() == null) {
            return new HashMap();
        }
        Bundle arguments = getArguments();
        ArrayList<Integer> integerArrayList = arguments != null ? arguments.getIntegerArrayList(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_INSTRUCTION_LIST) : null;
        ArrayList arrayList = new ArrayList();
        ArrayList<SharedNode> value = Lh().S1().getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(((SharedNode) it.next()).getKey());
            }
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN)) == null) {
            str = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", str);
        String a16 = com.tencent.mobileqq.troop.dtreport.a.a(integerArrayList);
        Intrinsics.checkNotNullExpressionValue(a16, "listToString(instructionList)");
        hashMap.put("order_copy", a16);
        String a17 = com.tencent.mobileqq.troop.dtreport.a.a(arrayList);
        Intrinsics.checkNotNullExpressionValue(a17, "listToString(targetUinList)");
        hashMap.put("copy_group_id", a17);
        hashMap.put("click_pos", Integer.valueOf(isConfirm ? 1 : 2));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSelectorVM Lh() {
        return (TroopSelectorVM) this.vm.getValue();
    }

    private final void Mh() {
        LiveData<Boolean> W1 = Lh().W1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopselector.TroopSelectorFragment$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isFinishMultiMode) {
                TroopSelectorConfig Ih;
                Intrinsics.checkNotNullExpressionValue(isFinishMultiMode, "isFinishMultiMode");
                if (isFinishMultiMode.booleanValue()) {
                    Ih = TroopSelectorFragment.this.Ih();
                    Integer valueOf = Ih != null ? Integer.valueOf(Ih.a()) : null;
                    if (valueOf != null && valueOf.intValue() == 3) {
                        TroopSelectorFragment.this.Uh();
                    } else if (valueOf != null && valueOf.intValue() == 2) {
                        TroopSelectorFragment.this.Xh();
                    } else {
                        TroopSelectorFragment.this.Rh();
                    }
                }
            }
        };
        W1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopselector.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSelectorFragment.Nh(Function1.this, obj);
            }
        });
        LiveData<Boolean> X1 = Lh().X1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopselector.TroopSelectorFragment$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isFinishSingleMode) {
                TroopSelectorConfig Ih;
                Intrinsics.checkNotNullExpressionValue(isFinishSingleMode, "isFinishSingleMode");
                if (isFinishSingleMode.booleanValue()) {
                    Ih = TroopSelectorFragment.this.Ih();
                    Integer valueOf = Ih != null ? Integer.valueOf(Ih.a()) : null;
                    if (valueOf != null && valueOf.intValue() == 6) {
                        TroopSelectorFragment.this.Th();
                    } else {
                        TroopSelectorFragment.this.Sh();
                    }
                }
            }
        };
        X1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopselector.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSelectorFragment.Oh(Function1.this, obj);
            }
        });
        LiveData<Boolean> T1 = Lh().T1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final TroopSelectorFragment$initObserver$3 troopSelectorFragment$initObserver$3 = new TroopSelectorFragment$initObserver$3(this);
        T1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.troopselector.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSelectorFragment.Ph(Function1.this, obj);
            }
        });
        LiveData<SharedNode> Q1 = Lh().Q1();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<SharedNode, Unit> function13 = new Function1<SharedNode, Unit>() { // from class: com.tencent.mobileqq.troop.troopselector.TroopSelectorFragment$initObserver$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SharedNode sharedNode) {
                invoke2(sharedNode);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SharedNode sharedNode) {
                TroopSelectorConfig Ih;
                TroopSelectorVM Lh;
                if (sharedNode != null) {
                    Ih = TroopSelectorFragment.this.Ih();
                    boolean z16 = false;
                    if (Ih != null && Ih.a() == 2) {
                        z16 = true;
                    }
                    if (z16) {
                        Iterator<T> it = com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.f().iterator();
                        while (it.hasNext()) {
                            com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.c((SharedNode) it.next());
                        }
                        com.tencent.mobileqq.selectfriend.relationlist.e eVar = com.tencent.mobileqq.selectfriend.relationlist.e.f285562a;
                        eVar.c(sharedNode);
                        Lh = TroopSelectorFragment.this.Lh();
                        Lh.a2(eVar.f());
                    }
                }
            }
        };
        Q1.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.troopselector.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSelectorFragment.Qh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<SharedNode> value = Lh().S1().getValue();
            if (value != null) {
                Intrinsics.checkNotNullExpressionValue(value, "value");
                for (SharedNode sharedNode : value) {
                    arrayList2.add(sharedNode.getKey());
                    ResultRecord resultRecord = new ResultRecord();
                    resultRecord.init(sharedNode.getKey(), sharedNode.getTitle(), 1, "", "");
                    arrayList.add(resultRecord);
                }
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selected_target_list", arrayList2);
            intent.putParcelableArrayListExtra("selected_target_list", arrayList);
            activity.setResult(-1, intent);
            TroopSelectorConfig Ih = Ih();
            boolean z16 = false;
            if (Ih != null && Ih.a() == 5) {
                z16 = true;
            }
            if (z16) {
                SimpleEventBus.getInstance().dispatchEvent(new TroopBatchListEvent(arrayList2), true);
            }
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            SharedNode value = Lh().R1().getValue();
            intent.putExtra("selectedTroop", value != null ? value.getKey() : null);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th() {
        Intent intent = new Intent();
        intent.putExtra("call_by_forward", true);
        Bundle arguments = getArguments();
        if (arguments != null) {
            intent.putExtras(arguments);
        }
        ForwardBaseOption d16 = com.tencent.mobileqq.forward.k.d(intent, Hh(), requireActivity());
        if (d16 != null) {
            Bundle bundle = new Bundle();
            SharedNode value = Lh().R1().getValue();
            bundle.putString("uin", value != null ? value.getKey() : null);
            bundle.putInt("uintype", 1);
            SharedNode value2 = Lh().R1().getValue();
            bundle.putString("troop_uin", value2 != null ? value2.getKey() : null);
            SharedNode value3 = Lh().R1().getValue();
            bundle.putString("uinname", value3 != null ? value3.getTitle() : null);
            bundle.putBoolean("forward_report_confirm", true);
            bundle.putString("forward_report_confirm_action_name", "0X8005A11");
            Integer FORWARD_ABILITY_TYPE_TROOP = com.tencent.mobileqq.forward.e.P3;
            Intrinsics.checkNotNullExpressionValue(FORWARD_ABILITY_TYPE_TROOP, "FORWARD_ABILITY_TYPE_TROOP");
            d16.buildForwardDialog(FORWARD_ABILITY_TYPE_TROOP.intValue(), bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh() {
        QQCustomDialog qQCustomDialog;
        if (this.applyQRobotInstConfirmDialog == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(requireActivity(), 230);
            createCustomDialog.setMessage("\u5982\u9009\u4e2d\u7fa4\u804a\u5df2\u8bbe\u7f6e\u6307\u4ee4\uff0c\u5c06\u8986\u76d6\u539f\u6709\u8bbe\u7f6e\u3002\u5982\u65e0Q\u7fa4\u7ba1\u5bb6\uff0c\u5c06\u81ea\u52a8\u6dfb\u52a0Q\u7fa4\u7ba1\u5bb6\u8fdb\u7fa4\uff0c\u5e76\u8bbe\u4e3a\u7ba1\u7406\u5458\u3002");
            createCustomDialog.setPositiveButton(R.string.a8j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopselector.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopSelectorFragment.Wh(TroopSelectorFragment.this, dialogInterface, i3);
                }
            });
            createCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopselector.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopSelectorFragment.Vh(TroopSelectorFragment.this, dialogInterface, i3);
                }
            });
            this.applyQRobotInstConfirmDialog = createCustomDialog;
        }
        FragmentActivity activity = getActivity();
        if ((activity == null || activity.isFinishing()) ? false : true) {
            QQCustomDialog qQCustomDialog2 = this.applyQRobotInstConfirmDialog;
            if (((qQCustomDialog2 == null || qQCustomDialog2.isShowing()) ? false : true) && (qQCustomDialog = this.applyQRobotInstConfirmDialog) != null) {
                qQCustomDialog.show();
            }
        }
        com.tencent.mobileqq.troop.dtreport.a.c("imp", Jh(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(TroopSelectorFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog qQCustomDialog = this$0.applyQRobotInstConfirmDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        com.tencent.mobileqq.troop.dtreport.a.c("clck", this$0.Jh(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(TroopSelectorFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
        com.tencent.mobileqq.troop.dtreport.a.c("clck", this$0.Jh(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh() {
        QQCustomDialog qQCustomDialog;
        ArrayList<SharedNode> value = Lh().S1().getValue();
        if (value != null && (value.isEmpty() ^ true)) {
            Rh();
            return;
        }
        if (this.robotCancelBindTroopDialog == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(requireActivity(), 230);
            createCustomDialog.setMessage("\u667a\u80fd\u4f53\u8d44\u6599\u5361\u4e2d\u5c06\u4e0d\u518d\u663e\u793a\u7fa4\u804a");
            createCustomDialog.setPositiveButton(R.string.a8j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopselector.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopSelectorFragment.Yh(TroopSelectorFragment.this, dialogInterface, i3);
                }
            });
            createCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopselector.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopSelectorFragment.Zh(TroopSelectorFragment.this, dialogInterface, i3);
                }
            });
            this.robotCancelBindTroopDialog = createCustomDialog;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        QQCustomDialog qQCustomDialog2 = this.robotCancelBindTroopDialog;
        if (!((qQCustomDialog2 == null || qQCustomDialog2.isShowing()) ? false : true) || (qQCustomDialog = this.robotCancelBindTroopDialog) == null) {
            return;
        }
        qQCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(TroopSelectorFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(TroopSelectorFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQCustomDialog qQCustomDialog = this$0.robotCancelBindTroopDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
    }

    /* renamed from: Kh, reason: from getter */
    public final FrameLayout getListRootView() {
        return this.listRootView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TroopSelectorTitlePart(Ih()));
        arrayList.add(new TroopSelectorSearchPart(Ih()));
        arrayList.add(new TroopSelectorListPart(Ih()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i0x;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        TroopSelectorConfig Ih = Ih();
        boolean z16 = false;
        if (Ih != null && Ih.a() == 3) {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.troop.dtreport.a.e("pgout");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("open TroopSelectorFragment from: ");
            TroopSelectorConfig Ih = Ih();
            sb5.append(Ih != null ? Integer.valueOf(Ih.a()) : null);
            QLog.i("TroopSelectorFragment", 2, sb5.toString());
        }
        this.listRootView = (FrameLayout) view.findViewById(R.id.f102535y6);
        Lh().init();
        Mh();
        ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("TroopSelectorFragment-");
        TroopSelectorConfig Ih2 = Ih();
        sb6.append(Ih2 != null ? Integer.valueOf(Ih2.a()) : null);
        iTroopUtilsApi.reportTroopFeaturePageImp(sb6.toString());
        TroopSelectorConfig Ih3 = Ih();
        boolean z16 = false;
        if (Ih3 != null && Ih3.a() == 3) {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.troop.dtreport.a.e("pgin");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
