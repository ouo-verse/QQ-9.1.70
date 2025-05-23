package com.tencent.mobileqq.ai.main.feeds;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.ai.QuickLiveData;
import com.tencent.mobileqq.ai.main.AIAvatarFeedsTabInfo;
import com.tencent.mobileqq.ai.main.AIAvatarMainViewModel;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/ai/main/feeds/AIAvatarFeedsListFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "yh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "xh", "()Lcom/tencent/mobileqq/ai/main/AIAvatarMainViewModel;", "vm", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/ai/main/feeds/b;", "E", "Lcom/tencent/mobileqq/ai/main/feeds/b;", "feedsListAdapter", "Lcom/tencent/mobileqq/ai/main/feeds/j;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/ai/main/feeds/j;", "loadMoreAdapter", "Lcom/tencent/mobileqq/ai/main/feeds/i;", "G", "Lcom/tencent/mobileqq/ai/main/feeds/i;", "footerAdapter", "Lcom/tencent/mobileqq/ai/main/AIAvatarFeedsTabInfo;", "H", "Lcom/tencent/mobileqq/ai/main/AIAvatarFeedsTabInfo;", "tabInfo", "", "I", "J", "dataSeq", "<init>", "()V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIAvatarFeedsListFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b feedsListAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private j loadMoreAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private i footerAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private AIAvatarFeedsTabInfo tabInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private long dataSeq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/ai/main/feeds/AIAvatarFeedsListFragment$a;", "", "", "KEY_TAB_POS", "Ljava/lang/String;", "", "PRELOAD_ITEM_OFFSET_INDEX", "I", "TAG", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ai.main.feeds.AIAvatarFeedsListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22673);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIAvatarFeedsListFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIAvatarMainViewModel>() { // from class: com.tencent.mobileqq.ai.main.feeds.AIAvatarFeedsListFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarFeedsListFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIAvatarMainViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIAvatarMainViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIAvatarMainViewModel.Companion companion = AIAvatarMainViewModel.INSTANCE;
                    Fragment requireParentFragment = AIAvatarFeedsListFragment.this.requireParentFragment();
                    Intrinsics.checkNotNullExpressionValue(requireParentFragment, "requireParentFragment()");
                    return companion.a(requireParentFragment);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIAvatarMainViewModel xh() {
        return (AIAvatarMainViewModel) this.vm.getValue();
    }

    private final void yh() {
        AIAvatarMainViewModel xh5 = xh();
        AIAvatarFeedsTabInfo aIAvatarFeedsTabInfo = this.tabInfo;
        if (aIAvatarFeedsTabInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
            aIAvatarFeedsTabInfo = null;
        }
        b bVar = new b(xh5, aIAvatarFeedsTabInfo);
        this.feedsListAdapter = bVar;
        bVar.k0(new Function2<com.tencent.mobileqq.ai.b, Integer, Unit>() { // from class: com.tencent.mobileqq.ai.main.feeds.AIAvatarFeedsListFragment$initFeedsListAdapter$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIAvatarFeedsListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.ai.b bVar2, Integer num) {
                invoke(bVar2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.ai.b vh5, int i3) {
                b bVar2;
                AIAvatarMainViewModel xh6;
                AIAvatarFeedsTabInfo aIAvatarFeedsTabInfo2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) vh5, i3);
                    return;
                }
                Intrinsics.checkNotNullParameter(vh5, "vh");
                bVar2 = AIAvatarFeedsListFragment.this.feedsListAdapter;
                if ((bVar2 != null ? bVar2.getNUM_BACKGOURND_ICON() : 0) - i3 < 5) {
                    xh6 = AIAvatarFeedsListFragment.this.xh();
                    aIAvatarFeedsTabInfo2 = AIAvatarFeedsListFragment.this.tabInfo;
                    if (aIAvatarFeedsTabInfo2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
                        aIAvatarFeedsTabInfo2 = null;
                    }
                    xh6.h2(aIAvatarFeedsTabInfo2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (QLog.isColorLevel()) {
            QLog.d("AIAvatarFeedsListFragment", 2, "onConfigurationChanged: newConfig=" + newConfig);
        }
        b bVar = this.feedsListAdapter;
        if (bVar != null) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter");
            RFWConcatAdapter rFWConcatAdapter = (RFWConcatAdapter) adapter;
            rFWConcatAdapter.removeAdapter(bVar);
            yh();
            b bVar2 = this.feedsListAdapter;
            if (bVar2 != null) {
                rFWConcatAdapter.addAdapter(0, bVar2);
                bVar2.notifyDataSetChanged();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt("KEY_TAB_POS");
        } else {
            i3 = -1;
        }
        AIAvatarFeedsTabInfo Z1 = xh().Z1(i3);
        this.dataSeq = Z1.a();
        this.tabInfo = Z1;
        if (QLog.isColorLevel()) {
            QLog.d("AIAvatarFeedsListFragment", 2, "onCreate: tabPos=" + i3 + " tabInfo=" + Z1);
        }
        List<a> T1 = xh().T1(Z1);
        if (T1 != null && !T1.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            xh().h2(Z1);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Context context = getContext();
            if (context != null) {
                RecyclerView recyclerView = new RecyclerView(context);
                recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
                yh();
                this.loadMoreAdapter = new j();
                this.footerAdapter = new i();
                RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
                RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[3];
                adapterArr[0] = this.feedsListAdapter;
                j jVar = this.loadMoreAdapter;
                if (jVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                    jVar = null;
                }
                adapterArr[1] = jVar;
                i iVar = this.footerAdapter;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("footerAdapter");
                    iVar = null;
                }
                adapterArr[2] = iVar;
                recyclerView.setAdapter(new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr));
                this.recyclerView = recyclerView;
                MutableLiveData<Map<AIAvatarFeedsTabInfo, List<a>>> S1 = xh().S1();
                LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                final Function1<Map<AIAvatarFeedsTabInfo, ? extends List<? extends a>>, Unit> function1 = new Function1<Map<AIAvatarFeedsTabInfo, ? extends List<? extends a>>, Unit>() { // from class: com.tencent.mobileqq.ai.main.feeds.AIAvatarFeedsListFragment$onCreateView$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarFeedsListFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Map<AIAvatarFeedsTabInfo, ? extends List<? extends a>> map) {
                        invoke2((Map<AIAvatarFeedsTabInfo, ? extends List<a>>) map);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Map<AIAvatarFeedsTabInfo, ? extends List<a>> map) {
                        long j3;
                        AIAvatarFeedsTabInfo aIAvatarFeedsTabInfo;
                        AIAvatarFeedsTabInfo aIAvatarFeedsTabInfo2;
                        b bVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) map);
                            return;
                        }
                        j3 = AIAvatarFeedsListFragment.this.dataSeq;
                        aIAvatarFeedsTabInfo = AIAvatarFeedsListFragment.this.tabInfo;
                        AIAvatarFeedsTabInfo aIAvatarFeedsTabInfo3 = null;
                        if (aIAvatarFeedsTabInfo == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
                            aIAvatarFeedsTabInfo = null;
                        }
                        if (j3 != aIAvatarFeedsTabInfo.a()) {
                            AIAvatarFeedsListFragment aIAvatarFeedsListFragment = AIAvatarFeedsListFragment.this;
                            aIAvatarFeedsTabInfo2 = aIAvatarFeedsListFragment.tabInfo;
                            if (aIAvatarFeedsTabInfo2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
                            } else {
                                aIAvatarFeedsTabInfo3 = aIAvatarFeedsTabInfo2;
                            }
                            aIAvatarFeedsListFragment.dataSeq = aIAvatarFeedsTabInfo3.a();
                            bVar = AIAvatarFeedsListFragment.this.feedsListAdapter;
                            if (bVar != null) {
                                bVar.notifyDataSetChanged();
                            }
                        }
                    }
                };
                S1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.ai.main.feeds.c
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        AIAvatarFeedsListFragment.zh(Function1.this, obj);
                    }
                });
                QuickLiveData<Map<AIAvatarFeedsTabInfo, Boolean>> U1 = xh().U1();
                LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
                final Function1<Map<AIAvatarFeedsTabInfo, Boolean>, Unit> function12 = new Function1<Map<AIAvatarFeedsTabInfo, Boolean>, Unit>() { // from class: com.tencent.mobileqq.ai.main.feeds.AIAvatarFeedsListFragment$onCreateView$3
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIAvatarFeedsListFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Map<AIAvatarFeedsTabInfo, Boolean> map) {
                        invoke2(map);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Map<AIAvatarFeedsTabInfo, Boolean> map) {
                        AIAvatarMainViewModel xh5;
                        AIAvatarFeedsTabInfo aIAvatarFeedsTabInfo;
                        j jVar2;
                        j jVar3;
                        AIAvatarFeedsTabInfo aIAvatarFeedsTabInfo2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) map);
                            return;
                        }
                        xh5 = AIAvatarFeedsListFragment.this.xh();
                        aIAvatarFeedsTabInfo = AIAvatarFeedsListFragment.this.tabInfo;
                        j jVar4 = null;
                        if (aIAvatarFeedsTabInfo == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
                            aIAvatarFeedsTabInfo = null;
                        }
                        boolean c26 = xh5.c2(aIAvatarFeedsTabInfo);
                        if (QLog.isColorLevel()) {
                            aIAvatarFeedsTabInfo2 = AIAvatarFeedsListFragment.this.tabInfo;
                            if (aIAvatarFeedsTabInfo2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
                                aIAvatarFeedsTabInfo2 = null;
                            }
                            QLog.d("AIAvatarFeedsListFragment", 2, "hasMore: tab=" + aIAvatarFeedsTabInfo2 + ", hasMore=" + c26);
                        }
                        jVar2 = AIAvatarFeedsListFragment.this.loadMoreAdapter;
                        if (jVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                            jVar2 = null;
                        }
                        jVar2.setLoadState(c26, c26);
                        if (c26) {
                            return;
                        }
                        jVar3 = AIAvatarFeedsListFragment.this.loadMoreAdapter;
                        if (jVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                        } else {
                            jVar4 = jVar3;
                        }
                        jVar4.onLoadMoreEnd(false);
                    }
                };
                U1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.ai.main.feeds.d
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        AIAvatarFeedsListFragment.Ah(Function1.this, obj);
                    }
                });
                view = this.recyclerView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
            }
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
