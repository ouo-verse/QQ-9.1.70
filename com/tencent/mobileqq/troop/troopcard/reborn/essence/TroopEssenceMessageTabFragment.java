package com.tencent.mobileqq.troop.troopcard.reborn.essence;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopEssenceMsgViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopInfoCardEssenceViewModel;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 92\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceMessageTabFragment;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceTabBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/ClickMsgFeedEvent;", "", "initViewModel", "", WadlProxyConsts.KEY_JUMP_URL, "Dh", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel;", "D", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopEssenceMsgViewModel;", "vm", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "E", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "troopBasicInfoViewModel", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopInfoCardEssenceViewModel;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopInfoCardEssenceViewModel;", "troopInfoCardEssenceViewModel", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "loadMoreView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "loadMoreText", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/b;", "I", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/message/b;", "messageAdapter", "", "J", "Z", "isInitialized", "K", "Ljava/lang/String;", "url", "<init>", "()V", "L", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopEssenceMessageTabFragment extends TroopEssenceTabBaseFragment implements SimpleEventReceiver<ClickMsgFeedEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    private TroopEssenceMsgViewModel vm;

    /* renamed from: E, reason: from kotlin metadata */
    private TroopBasicInfoViewModel troopBasicInfoViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearLayout loadMoreView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView loadMoreText;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopcard.reborn.essence.message.b messageAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isInitialized;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String url;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceMessageTabFragment$a;", "", "", "isInitialized", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceMessageTabFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceMessageTabFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

        @NotNull
        public final TroopEssenceMessageTabFragment a(boolean isInitialized) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopEssenceMessageTabFragment) iPatchRedirector.redirect((short) 2, (Object) this, isInitialized);
            }
            TroopEssenceMessageTabFragment troopEssenceMessageTabFragment = new TroopEssenceMessageTabFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isInitialized", isInitialized);
            troopEssenceMessageTabFragment.setArguments(bundle);
            return troopEssenceMessageTabFragment;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopEssenceMessageTabFragment() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            z16 = arguments.getBoolean("isInitialized");
        } else {
            z16 = false;
        }
        this.isInitialized = z16;
        this.url = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Dh(String jumpUrl) {
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.troopBasicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        if (troopBasicInfoViewModel.Q2()) {
            Intent intent = new Intent(requireContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", jumpUrl);
            requireContext().startActivity(intent);
            return;
        }
        QQToast.makeText(requireContext(), R.string.f2329075t, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(TroopEssenceMessageTabFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Dh(this$0.url);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(TroopEssenceMsgViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopEssenceMsgViewModel::class.java)");
        this.vm = (TroopEssenceMsgViewModel) viewModel;
        ViewModel viewModel2 = getViewModel(TroopInfoCardEssenceViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(TroopInfoCa\u2026nceViewModel::class.java)");
        this.troopInfoCardEssenceViewModel = (TroopInfoCardEssenceViewModel) viewModel2;
        ViewModel viewModel3 = getViewModel(TroopBasicInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(TroopBasicInfoViewModel::class.java)");
        this.troopBasicInfoViewModel = (TroopBasicInfoViewModel) viewModel3;
        TroopEssenceMsgViewModel troopEssenceMsgViewModel = this.vm;
        TroopBasicInfoViewModel troopBasicInfoViewModel = null;
        if (troopEssenceMsgViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopEssenceMsgViewModel = null;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel2 = this.troopBasicInfoViewModel;
        if (troopBasicInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
            troopBasicInfoViewModel2 = null;
        }
        troopEssenceMsgViewModel.T1(troopBasicInfoViewModel2.K2());
        TroopEssenceMsgViewModel troopEssenceMsgViewModel2 = this.vm;
        if (troopEssenceMsgViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            troopEssenceMsgViewModel2 = null;
        }
        LiveData<TroopEssenceMsgViewModel.b> S1 = troopEssenceMsgViewModel2.S1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<TroopEssenceMsgViewModel.b, Unit> function1 = new Function1<TroopEssenceMsgViewModel.b, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceMessageTabFragment$initViewModel$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEssenceMessageTabFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopEssenceMsgViewModel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopEssenceMsgViewModel.b bVar) {
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel;
                com.tencent.mobileqq.troop.troopcard.reborn.essence.message.b bVar2;
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel2;
                LinearLayout linearLayout;
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel3;
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel5 = null;
                if (bVar instanceof TroopEssenceMsgViewModel.b.C8797b) {
                    TroopEssenceMsgViewModel.b.C8797b c8797b = (TroopEssenceMsgViewModel.b.C8797b) bVar;
                    if (!c8797b.a().isEmpty()) {
                        bVar2 = TroopEssenceMessageTabFragment.this.messageAdapter;
                        if (bVar2 != null) {
                            bVar2.setItems(c8797b.a());
                        }
                        troopInfoCardEssenceViewModel2 = TroopEssenceMessageTabFragment.this.troopInfoCardEssenceViewModel;
                        if (troopInfoCardEssenceViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("troopInfoCardEssenceViewModel");
                            troopInfoCardEssenceViewModel2 = null;
                        }
                        troopInfoCardEssenceViewModel2.g2();
                        TroopEssenceMessageTabFragment.this.url = c8797b.b();
                        if (!c8797b.c()) {
                            linearLayout = TroopEssenceMessageTabFragment.this.loadMoreView;
                            if (linearLayout == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("loadMoreView");
                                linearLayout = null;
                            }
                            linearLayout.setVisibility(0);
                        }
                    } else {
                        QLog.e("TroopEssenceMessageTabFragment", 1, "itemList is empty");
                        troopInfoCardEssenceViewModel4 = TroopEssenceMessageTabFragment.this.troopInfoCardEssenceViewModel;
                        if (troopInfoCardEssenceViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("troopInfoCardEssenceViewModel");
                            troopInfoCardEssenceViewModel4 = null;
                        }
                        troopInfoCardEssenceViewModel4.U1();
                    }
                    troopInfoCardEssenceViewModel3 = TroopEssenceMessageTabFragment.this.troopInfoCardEssenceViewModel;
                    if (troopInfoCardEssenceViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopInfoCardEssenceViewModel");
                    } else {
                        troopInfoCardEssenceViewModel5 = troopInfoCardEssenceViewModel3;
                    }
                    troopInfoCardEssenceViewModel5.b2();
                    return;
                }
                if (Intrinsics.areEqual(bVar, TroopEssenceMsgViewModel.b.a.f299822a)) {
                    troopInfoCardEssenceViewModel = TroopEssenceMessageTabFragment.this.troopInfoCardEssenceViewModel;
                    if (troopInfoCardEssenceViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopInfoCardEssenceViewModel");
                    } else {
                        troopInfoCardEssenceViewModel5 = troopInfoCardEssenceViewModel;
                    }
                    troopInfoCardEssenceViewModel5.U1();
                }
            }
        };
        S1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopEssenceMessageTabFragment.Bh(Function1.this, obj);
            }
        });
        TroopBasicInfoViewModel troopBasicInfoViewModel3 = this.troopBasicInfoViewModel;
        if (troopBasicInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
        } else {
            troopBasicInfoViewModel = troopBasicInfoViewModel3;
        }
        LiveData<Boolean> u26 = troopBasicInfoViewModel.u2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceMessageTabFragment$initViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEssenceMessageTabFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isNeedShow) {
                boolean z16;
                TroopEssenceMsgViewModel troopEssenceMsgViewModel3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) isNeedShow);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(isNeedShow, "isNeedShow");
                if (isNeedShow.booleanValue()) {
                    z16 = TroopEssenceMessageTabFragment.this.isInitialized;
                    if (z16) {
                        troopEssenceMsgViewModel3 = TroopEssenceMessageTabFragment.this.vm;
                        if (troopEssenceMsgViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("vm");
                            troopEssenceMsgViewModel3 = null;
                        }
                        troopEssenceMsgViewModel3.R1();
                    }
                }
            }
        };
        u26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopEssenceMessageTabFragment.Ch(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<ClickMsgFeedEvent>> getEventClass() {
        ArrayList<Class<ClickMsgFeedEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ClickMsgFeedEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
        } else if ((event instanceof ClickMsgFeedEvent) && this.isInitialized) {
            Dh(((ClickMsgFeedEvent) event).getJumpUrl());
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceTabBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        TextView textView;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.eey);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.load_more_layout)");
        this.loadMoreView = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.yrv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.load_more_layout_text)");
        TextView textView2 = (TextView) findViewById2;
        this.loadMoreText = textView2;
        LinearLayout linearLayout = null;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreText");
            textView = null;
        } else {
            textView = textView2;
        }
        TriggerRunnerKt.c(textView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopEssenceMessageTabFragment.Eh(TroopEssenceMessageTabFragment.this, view2);
            }
        }, 1, null);
        LinearLayout linearLayout2 = this.loadMoreView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreView");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(8);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z16 = arguments.getBoolean("isInitialized");
        } else {
            z16 = false;
        }
        this.isInitialized = z16;
        initViewModel();
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceTabBaseFragment
    @NotNull
    public RecyclerView.Adapter<?> ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.Adapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.troop.troopcard.reborn.essence.message.b bVar = new com.tencent.mobileqq.troop.troopcard.reborn.essence.message.b();
        bVar.setHasStableIds(true);
        this.messageAdapter = bVar;
        return new RFWConcatAdapter(bVar);
    }
}
