package com.tencent.qqnt.contacts.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.base.BaseFragment;
import com.tencent.qqnt.base.data.a;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.base.utils.b;
import com.tencent.qqnt.contacts.data.d;
import com.tencent.qqnt.contacts.data.f;
import com.tencent.qqnt.contacts.logic.IContactsViewModelCreator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001dH\u0016R\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/contacts/ui/BuddyFragment;", "Lcom/tencent/qqnt/base/BaseFragment;", "Lmqq/app/IAccountCallback;", "", "yh", OcrConfig.CHINESE, "Lcom/tencent/qqnt/contacts/data/d;", "uiState", "xh", "", "showRefresh", "wh", "initViewModel", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "onDestroyView", "Lmqq/app/AppRuntime;", "p0", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "onLogout", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/contacts/data/e;", "E", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "contactsViewModel", "Lcom/tencent/qqnt/contacts/ui/x2k/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/contacts/ui/x2k/a;", "binding", "Lcom/tencent/qqnt/contacts/adapter/c;", "G", "Lcom/tencent/qqnt/contacts/adapter/c;", "mContactsAdapter", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class BuddyFragment extends BaseFragment implements IAccountCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    private BaseViewModel<com.tencent.qqnt.contacts.data.d, com.tencent.qqnt.contacts.data.e> contactsViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.qqnt.contacts.ui.x2k.a binding;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.contacts.adapter.c mContactsAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/contacts/ui/BuddyFragment$a", "Lcom/tencent/qqnt/base/utils/b$b;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "position", "Landroid/view/View;", "v", "", "a", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements b.InterfaceC9516b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BuddyFragment.this);
            }
        }

        @Override // com.tencent.qqnt.base.utils.b.InterfaceC9516b
        public void a(@Nullable RecyclerView recyclerView, int position, @Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(position), v3);
                return;
            }
            f fVar = (f) BuddyFragment.this.mContactsAdapter.getCurrentList().get(position);
            if (fVar instanceof com.tencent.qqnt.contacts.data.a) {
                IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                com.tencent.qqnt.contacts.data.a aVar = (com.tencent.qqnt.contacts.data.a) fVar;
                IAIOStarterApi.a.a(iAIOStarterApi, context, 1, aVar.f(), aVar.h(), aVar.g(), null, 32, null);
            }
        }
    }

    public BuddyFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mContactsAdapter = new com.tencent.qqnt.contacts.adapter.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(BuddyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new BuddyFragment$initSwipeRefresh$1$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void wh(boolean showRefresh) {
        com.tencent.qqnt.contacts.ui.x2k.a aVar = this.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.b().setRefreshing(showRefresh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xh(com.tencent.qqnt.contacts.data.d uiState) {
        if (uiState instanceof d.a) {
            this.mContactsAdapter.submitList(((d.a) uiState).a());
            return;
        }
        if (uiState instanceof d.b) {
            d.b bVar = (d.b) uiState;
            com.tencent.qqnt.base.data.a<List<f>> a16 = bVar.a();
            if (a16 instanceof a.c) {
                this.mContactsAdapter.submitList((List) ((a.c) bVar.a()).a());
                wh(false);
            } else if (a16 instanceof a.C9511a) {
                Toast.makeText(getActivity(), "\u5237\u65b0\u5217\u8868\u5931\u8d25", 0).show();
                wh(false);
            } else if (a16 instanceof a.b) {
                wh(true);
            }
        }
    }

    private final void yh() {
        com.tencent.qqnt.contacts.ui.x2k.a aVar = this.binding;
        com.tencent.qqnt.contacts.ui.x2k.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.a().setAdapter(this.mContactsAdapter);
        b.Companion companion = com.tencent.qqnt.base.utils.b.INSTANCE;
        com.tencent.qqnt.contacts.ui.x2k.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar3;
        }
        companion.a(aVar2.a()).f(new a());
    }

    private final void zh() {
        com.tencent.qqnt.contacts.ui.x2k.a aVar = this.binding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        aVar.b().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.tencent.qqnt.contacts.ui.b
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                BuddyFragment.Ah(BuddyFragment.this);
            }
        });
    }

    @Override // com.tencent.qqnt.base.BaseFragment
    public void initViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        BaseViewModel<com.tencent.qqnt.contacts.data.d, com.tencent.qqnt.contacts.data.e> createContactsViewModel = ((IContactsViewModelCreator) QRoute.api(IContactsViewModelCreator.class)).createContactsViewModel(this);
        this.contactsViewModel = createContactsViewModel;
        if (createContactsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsViewModel");
            createContactsViewModel = null;
        }
        MutableLiveData<com.tencent.qqnt.contacts.data.d> obtainUiState = createContactsViewModel.obtainUiState();
        final BuddyFragment$initViewModel$1 buddyFragment$initViewModel$1 = new BuddyFragment$initViewModel$1(this);
        obtainUiState.observe(this, new Observer() { // from class: com.tencent.qqnt.contacts.ui.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BuddyFragment.Bh(Function1.this, obj);
            }
        });
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) p06);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) p06);
        } else {
            getMViewModelStore().clear();
            initViewModel();
        }
    }

    @Override // com.tencent.qqnt.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            MobileQQ.sMobileQQ.registerAccountCallback(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            c16 = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            com.tencent.qqnt.contacts.ui.x2k.a aVar = null;
            this.binding = new com.tencent.qqnt.contacts.ui.x2k.a(requireContext, null, 2, null);
            yh();
            zh();
            com.tencent.qqnt.contacts.ui.x2k.a aVar2 = this.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar = aVar2;
            }
            c16 = aVar.c();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, c16);
        return c16;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            MobileQQ.sMobileQQ.unregisterAccountCallback(this);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroyView();
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) p06);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onResume();
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BuddyFragment$onResume$1(this, null), 3, null);
        }
    }
}
