package com.tencent.qqnt.chathistory.ui.troopMember.history;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.troopMember.history.data.a;
import com.tencent.qqnt.chathistory.ui.troopMember.history.viewmodel.TroopMemberHistoryViewModel;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.g;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0096\u0001J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020-0\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010.\u00a8\u0006<"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/TroopMemberHistoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/viewmodel/TroopMemberHistoryViewModel;", "", "", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/data/model/a;", "data", "", "Nh", "Lh", "Ph", "Landroid/view/View;", "view", "Lkotlin/Function0;", "listener", "Jh", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "uh", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "th", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "ry", "Lcom/tencent/qqnt/chathistory/ui/troopMember/history/b;", "G", "Lkotlin/Lazy;", "Kh", "()Lcom/tencent/qqnt/chathistory/ui/troopMember/history/b;", "ryAdapter", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "H", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "qSearchBar", "I", "Landroid/view/View;", "viewEmpty", "", "J", "Ljava/util/List;", "senderUids", "", "K", "Z", "enableLoadMore", "", "L", "lastId", "<init>", "()V", "M", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TroopMemberHistoryFragment extends BaseHistoryFragment<TroopMemberHistoryViewModel> {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final /* synthetic */ g E;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView ry;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy ryAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QUISecNavBar qSearchBar;

    /* renamed from: I, reason: from kotlin metadata */
    private View viewEmpty;

    /* renamed from: J, reason: from kotlin metadata */
    private List<String> senderUids;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean enableLoadMore;

    /* renamed from: L, reason: from kotlin metadata */
    private long lastId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/history/TroopMemberHistoryFragment$a;", "", "", "KEY_TROOP_MEMBER_NICK", "Ljava/lang/String;", "KEY_TROOP_MEMBER_UIDS", "TAG", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopMemberHistoryFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.E = new g();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<b>() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment$ryAdapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopMemberHistoryFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new b(TroopMemberHistoryFragment.this.rh(), LifecycleOwnerKt.getLifecycleScope(TroopMemberHistoryFragment.this), new c() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment$ryAdapter$2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) TroopMemberHistoryFragment.this);
                        }
                    }

                    @Override // com.tencent.qqnt.chathistory.ui.troopMember.history.c
                    public void a(@NotNull com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a data) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, (Object) data);
                        } else {
                            Intrinsics.checkNotNullParameter(data, "data");
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(TroopMemberHistoryFragment.this), null, null, new TroopMemberHistoryFragment$ryAdapter$2$1$clickItem$1(TroopMemberHistoryFragment.this, data, null), 3, null);
                        }
                    }
                }) : (b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.ryAdapter = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b Kh() {
        return (b) this.ryAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> data) {
        if (data.isEmpty()) {
            Ph();
            this.enableLoadMore = false;
            return;
        }
        Kh().setData(data);
        View view = this.viewEmpty;
        RecyclerView recyclerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewEmpty");
            view = null;
        }
        view.setVisibility(8);
        RecyclerView recyclerView2 = this.ry;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ry");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.history.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberHistoryFragment.Mh(TroopMemberHistoryFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(TroopMemberHistoryFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.enableLoadMore = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(List<com.tencent.qqnt.chathistory.ui.troopMember.history.data.model.a> data) {
        if (!data.isEmpty()) {
            Kh().l0(data);
        } else {
            this.enableLoadMore = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ph() {
        View view = this.viewEmpty;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewEmpty");
            view = null;
        }
        view.setVisibility(0);
    }

    public void Jh(@NotNull View view, @NotNull Function0<Unit> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.E.a(view, listener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ArrayList<String> stringArrayList = requireArguments().getStringArrayList("key_troop_member_uids");
        Intrinsics.checkNotNull(stringArrayList);
        this.senderUids = stringArrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Jh(view, new Function0<Unit>() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopMemberHistoryFragment.this);
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
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                FragmentActivity activity = TroopMemberHistoryFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        RecyclerView recyclerView = null;
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new TroopMemberHistoryFragment$onViewCreated$2(this, null));
        RecyclerView recyclerView2 = this.ry;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ry");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment$onViewCreated$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopMemberHistoryFragment.this);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView3, int newState) {
                RecyclerView recyclerView4;
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recyclerView3, newState);
                    return;
                }
                Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                super.onScrollStateChanged(recyclerView3, newState);
                if (newState == 0) {
                    recyclerView4 = TroopMemberHistoryFragment.this.ry;
                    if (recyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ry");
                        recyclerView4 = null;
                    }
                    if (ExtensionsKt.v(recyclerView4)) {
                        z16 = TroopMemberHistoryFragment.this.enableLoadMore;
                        if (z16) {
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(TroopMemberHistoryFragment.this), null, null, new TroopMemberHistoryFragment$onViewCreated$3$onScrollStateChanged$1(TroopMemberHistoryFragment.this, null), 3, null);
                        }
                    }
                }
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("key_troop_member_nick")) != null) {
            com.tencent.qqnt.chathistory.util.d.f354054a.a("TroopMemberHistoryFragment", " title " + string);
            QUISecNavBar qUISecNavBar = this.qSearchBar;
            if (qUISecNavBar != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = getString(R.string.zl6);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.chat_\u2026oop_member_history_title)");
                String format = String.format(string2, Arrays.copyOf(new Object[]{string}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                qUISecNavBar.setCenterText(format);
            }
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    public void th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        LiveData obtainUiState = rh().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.chathistory.ui.troopMember.history.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.troopMember.history.data.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment$observerUISate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopMemberHistoryFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.troopMember.history.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.troopMember.history.data.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (aVar instanceof a.C9557a) {
                    TroopMemberHistoryFragment.this.Lh(((a.C9557a) aVar).a());
                }
                if (aVar instanceof a.b) {
                    TroopMemberHistoryFragment.this.Nh(((a.b) aVar).a());
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.history.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopMemberHistoryFragment.Oh(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout linearLayout;
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = getContext();
        if (context != null) {
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            linearLayout2.setOrientation(1);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            linearLayout2.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            Context context2 = inflater.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "inflater.context");
            QUISecNavBar qUISecNavBar = new QUISecNavBar(context2, null, 0, 6, null);
            qUISecNavBar.S(this);
            qUISecNavBar.setLeftType(2);
            qUISecNavBar.setCenterType(1);
            qUISecNavBar.setRightType(2);
            qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment$onCreateFragmentView$rootView$1$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopMemberHistoryFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view, @NotNull BaseAction motion) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) motion);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(motion, "motion");
                    if (motion == BaseAction.ACTION_LEFT_BUTTON) {
                        HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), view, "em_bas_back_button", null, 4, null);
                        FragmentActivity activity = TroopMemberHistoryFragment.this.getActivity();
                        if (activity != null) {
                            activity.onBackPressed();
                        }
                    }
                }
            });
            linearLayout2.addView(qUISecNavBar, new ViewGroup.LayoutParams(-1, -2));
            this.qSearchBar = qUISecNavBar;
            FrameLayout frameLayout = new FrameLayout(linearLayout2.getContext());
            Object invoke = LayoutBuilderKt.b().invoke(linearLayout2, new Object[0]);
            if (invoke != null) {
                frameLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(frameLayout.getContext());
                smartRefreshLayout.a(false);
                smartRefreshLayout.setEnableLoadMore(false);
                smartRefreshLayout.setEnableOverScrollDrag(true);
                RecyclerView recyclerView = new RecyclerView(frameLayout.getContext());
                Object invoke2 = LayoutBuilderKt.b().invoke(frameLayout, new Object[0]);
                if (invoke2 != null) {
                    recyclerView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                    this.ry = recyclerView;
                    recyclerView.setAdapter(Kh());
                    smartRefreshLayout.addView(recyclerView);
                    frameLayout.addView(smartRefreshLayout);
                    LinearLayout linearLayout3 = new LinearLayout(frameLayout.getContext());
                    Object invoke3 = LayoutBuilderKt.b().invoke(frameLayout, new Object[0]);
                    if (invoke3 != null) {
                        linearLayout3.setLayoutParams((ViewGroup.LayoutParams) invoke3);
                        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(linearLayout3.getContext()).setImageType(8);
                        String string = getString(R.string.zki);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_\u2026story_no_publish_content)");
                        QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).build();
                        build.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        build.setVisibility(0);
                        linearLayout3.addView(build);
                        frameLayout.addView(linearLayout3);
                        this.viewEmpty = linearLayout3;
                        linearLayout3.setVisibility(8);
                        linearLayout2.addView(frameLayout);
                        linearLayout = linearLayout2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        } else {
            linearLayout = null;
        }
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Intrinsics.checkNotNull(linearLayout);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, rh().N1()));
        a16.v(requireActivity, linearLayout, "pg_bas_members_speak_aggregate", mutableMapOf);
        return linearLayout;
    }
}
