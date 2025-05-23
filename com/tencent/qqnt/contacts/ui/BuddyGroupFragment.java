package com.tencent.qqnt.contacts.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.base.BaseFragment;
import com.tencent.qqnt.base.data.a;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.contacts.data.b;
import com.tencent.qqnt.contacts.logic.BuddyGroupViewModel;
import java.util.Collection;
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
import sw3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\u0016R\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/contacts/ui/BuddyGroupFragment;", "Lcom/tencent/qqnt/base/BaseFragment;", "Lmqq/app/IAccountCallback;", "Lcom/tencent/qqnt/contacts/data/b;", "uiState", "", "uh", "initView", "initViewModel", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "Lmqq/app/AppRuntime;", "p0", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "onLogout", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/contacts/data/c;", "E", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "viewModel", "Lcom/tencent/qqnt/contacts/adapter/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/contacts/adapter/d;", "adapter", "Lsw3/g;", "G", "Lsw3/g;", "viewBinding", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class BuddyGroupFragment extends BaseFragment implements IAccountCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    private BaseViewModel<com.tencent.qqnt.contacts.data.b, com.tencent.qqnt.contacts.data.c> viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.contacts.adapter.d adapter;

    /* renamed from: G, reason: from kotlin metadata */
    private g viewBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/contacts/ui/BuddyGroupFragment$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new BuddyGroupViewModel(new com.tencent.qqnt.contacts.data.repository.a(new com.tencent.qqnt.contacts.data.datasource.c(), new com.tencent.qqnt.contacts.data.datasource.a()), new com.tencent.qqnt.base.dispatcher.a());
        }
    }

    public BuddyGroupFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.adapter = new com.tencent.qqnt.contacts.adapter.d();
        }
    }

    private final void initView() {
        g gVar = this.viewBinding;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            gVar = null;
        }
        gVar.f434904b.setAdapter(this.adapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh(com.tencent.qqnt.contacts.data.b uiState) {
        if (uiState instanceof b.a) {
            this.adapter.u0(((b.a) uiState).a());
            return;
        }
        if (uiState instanceof b.C9607b) {
            b.C9607b c9607b = (b.C9607b) uiState;
            com.tencent.qqnt.base.data.a<List<com.tencent.qqnt.contacts.data.item.a>> a16 = c9607b.a();
            if (a16 instanceof a.c) {
                this.adapter.u0((Collection) ((a.c) c9607b.a()).a());
            } else if (a16 instanceof a.C9511a) {
                Toast.makeText(getActivity(), "\u5237\u65b0\u5217\u8868\u5931\u8d25", 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.qqnt.base.BaseFragment
    public void initViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ViewModel viewModel = new ViewModelProvider(this, new a()).get(BuddyGroupViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026oupViewModel::class.java)");
        BaseViewModel<com.tencent.qqnt.contacts.data.b, com.tencent.qqnt.contacts.data.c> baseViewModel = (BaseViewModel) viewModel;
        this.viewModel = baseViewModel;
        if (baseViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            baseViewModel = null;
        }
        MutableLiveData<com.tencent.qqnt.contacts.data.b> obtainUiState = baseViewModel.obtainUiState();
        final BuddyGroupFragment$initViewModel$2 buddyGroupFragment$initViewModel$2 = new BuddyGroupFragment$initViewModel$2(this);
        obtainUiState.observe(this, new Observer() { // from class: com.tencent.qqnt.contacts.ui.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BuddyGroupFragment.vh(Function1.this, obj);
            }
        });
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) p06);
        }
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) p06);
        } else {
            getViewModelStore().clear();
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
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            root = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            g g16 = g.g(inflater);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater)");
            this.viewBinding = g16;
            initView();
            g gVar = this.viewBinding;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                gVar = null;
            }
            root = gVar.getRoot();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
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

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) p06);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onResume();
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BuddyGroupFragment$onResume$1(this, null), 3, null);
        }
    }
}
