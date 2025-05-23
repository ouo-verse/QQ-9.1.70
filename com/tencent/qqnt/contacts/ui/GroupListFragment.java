package com.tencent.qqnt.contacts.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.base.BaseFragment;
import com.tencent.qqnt.base.data.a;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.base.utils.b;
import com.tencent.qqnt.contacts.data.f;
import com.tencent.qqnt.contacts.data.g;
import com.tencent.qqnt.contacts.data.h;
import com.tencent.qqnt.contacts.data.i;
import com.tencent.qqnt.contacts.logic.IContactsViewModelCreator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/contacts/ui/GroupListFragment;", "Lcom/tencent/qqnt/base/BaseFragment;", "", "yh", OcrConfig.CHINESE, "Bh", "", "showRefresh", "wh", "initViewModel", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onDestroyView", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/contacts/data/h;", "Lcom/tencent/qqnt/contacts/data/i;", "E", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "mGroupListViewModel", "Lsw3/b;", UserInfo.SEX_FEMALE, "Lsw3/b;", "_binding", "Lcom/tencent/qqnt/contacts/adapter/h;", "G", "Lcom/tencent/qqnt/contacts/adapter/h;", "mGroupListAdapter", "xh", "()Lsw3/b;", "mBinding", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GroupListFragment extends BaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    private BaseViewModel<h, i> mGroupListViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private sw3.b _binding;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.contacts.adapter.h mGroupListAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/contacts/ui/GroupListFragment$a", "Lcom/tencent/qqnt/base/utils/b$b;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "position", "Landroid/view/View;", "v", "", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements b.InterfaceC9516b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupListFragment.this);
            }
        }

        @Override // com.tencent.qqnt.base.utils.b.InterfaceC9516b
        public void a(@Nullable RecyclerView recyclerView, int position, @Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(position), v3);
                return;
            }
            f fVar = (f) GroupListFragment.this.mGroupListAdapter.getCurrentList().get(position);
            if (fVar instanceof g) {
                IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
                MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
                g gVar = (g) fVar;
                IAIOStarterApi.a.a(iAIOStarterApi, sMobileQQ, 2, String.valueOf(gVar.f()), gVar.g(), 0L, null, 48, null);
            }
        }
    }

    public GroupListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mGroupListAdapter = new com.tencent.qqnt.contacts.adapter.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(GroupListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new GroupListFragment$initSwipeRefresh$1$1(this$0, null), 3, null);
    }

    private final void Bh() {
        BaseViewModel<h, i> baseViewModel = this.mGroupListViewModel;
        if (baseViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGroupListViewModel");
            baseViewModel = null;
        }
        MutableLiveData<h> obtainUiState = baseViewModel.obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<h, Unit> function1 = new Function1<h, Unit>() { // from class: com.tencent.qqnt.contacts.ui.GroupListFragment$subscribeObservers$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(h hVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar);
                    return;
                }
                if (hVar instanceof h.a) {
                    GroupListFragment.this.mGroupListAdapter.submitList(((h.a) hVar).a());
                    return;
                }
                if (hVar instanceof h.c) {
                    h.c cVar = (h.c) hVar;
                    com.tencent.qqnt.base.data.a<List<f>> a16 = cVar.a();
                    if (a16 instanceof a.c) {
                        GroupListFragment.this.mGroupListAdapter.submitList((List) ((a.c) cVar.a()).a());
                        GroupListFragment.this.wh(false);
                    } else if (a16 instanceof a.C9511a) {
                        GroupListFragment.this.wh(false);
                    } else if (a16 instanceof a.b) {
                        GroupListFragment.this.wh(true);
                    }
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.contacts.ui.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupListFragment.Ch(Function1.this, obj);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GroupListFragment$subscribeObservers$2(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh(boolean showRefresh) {
        xh().f434891c.setRefreshing(showRefresh);
    }

    private final sw3.b xh() {
        sw3.b bVar = this._binding;
        Intrinsics.checkNotNull(bVar);
        return bVar;
    }

    private final void yh() {
        xh().f434890b.setAdapter(this.mGroupListAdapter);
        b.Companion companion = com.tencent.qqnt.base.utils.b.INSTANCE;
        RecyclerView recyclerView = xh().f434890b;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBinding.groupList");
        companion.a(recyclerView).f(new a());
    }

    private final void zh() {
        xh().f434891c.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.tencent.qqnt.contacts.ui.e
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                GroupListFragment.Ah(GroupListFragment.this);
            }
        });
    }

    @Override // com.tencent.qqnt.base.BaseFragment
    public void initViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mGroupListViewModel = ((IContactsViewModelCreator) QRoute.api(IContactsViewModelCreator.class)).createGroupListViewModel(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            root = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            this._binding = sw3.b.g(inflater, container, false);
            yh();
            zh();
            Bh();
            root = xh().getRoot();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroyView();
            this._binding = null;
        }
    }
}
