package com.tencent.qqnt.chathistory.ui.file.c2c;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.b;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.viewmodel.ChatHistoryFileModel;
import com.tencent.qqnt.chathistory.ui.widget.loadMore.HistoryLoadMoreFooter;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.x2k.FragmentChatHistoryFileCategory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\bH\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/ChatHistoryFileCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;", "", "Ih", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b$a;", "state", "Jh", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/b$b;", "Kh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "E", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "tvTitle", "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", UserInfo.SEX_FEMALE, "Lcom/qqnt/widget/smartrefreshlayout/layout/SmartRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "H", "Landroid/view/ViewGroup;", "emptyViewContainer", "Ljava/util/ArrayList;", "", "I", "Ljava/util/ArrayList;", "subTypes", "", "J", "Z", "isLoadingMore", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/c;", "K", "Lkotlin/Lazy;", "Hh", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/c;", "chatCategoryAdapter", "Lcom/tencent/qqnt/chathistory/x2k/FragmentChatHistoryFileCategory;", "L", "Lcom/tencent/qqnt/chathistory/x2k/FragmentChatHistoryFileCategory;", "binding", "<init>", "()V", "M", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryFileCategoryFragment extends BaseHistoryFragment<ChatHistoryFileModel> {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    private QUISecNavBar tvTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: H, reason: from kotlin metadata */
    private ViewGroup emptyViewContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private ArrayList<Integer> subTypes;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isLoadingMore;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy chatCategoryAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private FragmentChatHistoryFileCategory binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/ChatHistoryFileCategoryFragment$a;", "", "", "EXTRA_SUB_TYPE", "Ljava/lang/String;", "EXTRA_TITLE", "TAG", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileCategoryFragment$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44376);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatHistoryFileCategoryFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.chathistory.ui.file.c2c.adapter.c>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileCategoryFragment$chatCategoryAdapter$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryFileCategoryFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.qqnt.chathistory.ui.file.c2c.adapter.c invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new com.tencent.qqnt.chathistory.ui.file.c2c.adapter.c(LifecycleOwnerKt.getLifecycleScope(ChatHistoryFileCategoryFragment.this), ChatHistoryFileCategoryFragment.this.rh()) : (com.tencent.qqnt.chathistory.ui.file.c2c.adapter.c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.chatCategoryAdapter = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.chathistory.ui.file.c2c.adapter.c Hh() {
        return (com.tencent.qqnt.chathistory.ui.file.c2c.adapter.c) this.chatCategoryAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih() {
        if (this.isLoadingMore) {
            return;
        }
        this.isLoadingMore = true;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatHistoryFileCategoryFragment$loadMore$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(b.a state) {
        boolean z16;
        List<FileItemModel> data = state.getData();
        List<FileItemModel> list = data;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        SmartRefreshLayout smartRefreshLayout = null;
        if (z16) {
            ViewGroup viewGroup = this.emptyViewContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyViewContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout2 = null;
            }
            smartRefreshLayout2.setVisibility(8);
        } else {
            ViewGroup viewGroup2 = this.emptyViewContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyViewContainer");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(8);
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.setVisibility(0);
            Hh().p0(data);
        }
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout4;
        }
        smartRefreshLayout.setEnableLoadMore(state.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(b.C9534b state) {
        List<FileItemModel> data = state.getData();
        com.tencent.qqnt.chathistory.util.d.f354054a.a("ChatHistoryFileCategoryFragment", "loadMore result " + data.size());
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.x();
        if (data.isEmpty()) {
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.setEnableLoadMore(false);
        } else {
            Hh().l0(data);
        }
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout2 = smartRefreshLayout4;
        }
        smartRefreshLayout2.setEnableLoadMore(state.a());
        this.isLoadingMore = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(ChatHistoryFileCategoryFragment this$0, q3.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.Ih();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentChatHistoryFileCategory fragmentChatHistoryFileCategory = this.binding;
        RecyclerView recyclerView = null;
        if (fragmentChatHistoryFileCategory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentChatHistoryFileCategory = null;
        }
        this.tvTitle = fragmentChatHistoryFileCategory.f();
        String string = requireArguments().getString("extra_title");
        ArrayList<Integer> integerArrayList = requireArguments().getIntegerArrayList("extra_sub_type");
        if (integerArrayList == null) {
            integerArrayList = new ArrayList<>();
        }
        this.subTypes = integerArrayList;
        QUISecNavBar qUISecNavBar = this.tvTitle;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            qUISecNavBar = null;
        }
        qUISecNavBar.setCenterText(string);
        QUISecNavBar qUISecNavBar2 = this.tvTitle;
        if (qUISecNavBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            qUISecNavBar2 = null;
        }
        qUISecNavBar2.S(this);
        View findViewById = view.findViewById(R.id.f86434rn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.smart_refresh_layout)");
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
        this.refreshLayout = smartRefreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        smartRefreshLayout.X(new HistoryLoadMoreFooter(requireContext));
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.S(false);
        View findViewById2 = view.findViewById(R.id.f792849c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.ry)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        this.recyclerView = recyclerView2;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setAdapter(Hh());
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.W(new r3.e() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.a
            @Override // r3.e
            public final void E6(q3.f fVar) {
                ChatHistoryFileCategoryFragment.Lh(ChatHistoryFileCategoryFragment.this, fVar);
            }
        });
        View findViewById3 = view.findViewById(R.id.v7b);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.flEmptyContainer)");
        this.emptyViewContainer = (ViewGroup) findViewById3;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(2);
        String string2 = getString(R.string.zkd);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.chat_history_no_file)");
        QUIEmptyState build = imageType.setTitle(string2).setBackgroundColorType(0).build();
        build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        build.setVisibility(0);
        ViewGroup viewGroup = this.emptyViewContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyViewContainer");
            viewGroup = null;
        }
        viewGroup.addView(build);
        LiveData obtainUiState = rh().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.chathistory.ui.file.c2c.data.b, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.file.c2c.data.b, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileCategoryFragment$onViewCreated$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryFileCategoryFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.file.c2c.data.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.file.c2c.data.b state) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) state);
                    return;
                }
                if (state instanceof b.a) {
                    ChatHistoryFileCategoryFragment chatHistoryFileCategoryFragment = ChatHistoryFileCategoryFragment.this;
                    Intrinsics.checkNotNullExpressionValue(state, "state");
                    chatHistoryFileCategoryFragment.Jh((b.a) state);
                } else if (state instanceof b.C9534b) {
                    ChatHistoryFileCategoryFragment chatHistoryFileCategoryFragment2 = ChatHistoryFileCategoryFragment.this;
                    Intrinsics.checkNotNullExpressionValue(state, "state");
                    chatHistoryFileCategoryFragment2.Kh((b.C9534b) state);
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatHistoryFileCategoryFragment.onViewCreated$lambda$3(Function1.this, obj);
            }
        });
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new ChatHistoryFileCategoryFragment$onViewCreated$4(this, null));
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView4;
        }
        ExtensionsKt.w(recyclerView, new Function0<Boolean>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileCategoryFragment$onViewCreated$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryFileCategoryFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                SmartRefreshLayout smartRefreshLayout4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                smartRefreshLayout4 = ChatHistoryFileCategoryFragment.this.refreshLayout;
                if (smartRefreshLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout4 = null;
                }
                return Boolean.valueOf(smartRefreshLayout4.w());
            }
        }, new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.ChatHistoryFileCategoryFragment$onViewCreated$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryFileCategoryFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ChatHistoryFileCategoryFragment.this.Ih();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        FragmentChatHistoryFileCategory fragmentChatHistoryFileCategory = new FragmentChatHistoryFileCategory(context, null, 2, null);
        this.binding = fragmentChatHistoryFileCategory;
        return fragmentChatHistoryFileCategory.getMRv();
    }
}
