package com.tencent.qqnt.contacts.logic.impl;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.contacts.data.d;
import com.tencent.qqnt.contacts.data.datasource.PlatformGroupListDataSource;
import com.tencent.qqnt.contacts.data.datasource.c;
import com.tencent.qqnt.contacts.data.e;
import com.tencent.qqnt.contacts.data.h;
import com.tencent.qqnt.contacts.data.i;
import com.tencent.qqnt.contacts.data.repository.GroupListRepository;
import com.tencent.qqnt.contacts.logic.BuddyViewModel;
import com.tencent.qqnt.contacts.logic.GroupListViewModel;
import com.tencent.qqnt.contacts.logic.IContactsViewModelCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/contacts/logic/impl/ContactsViewModelCreatorImpl;", "Lcom/tencent/qqnt/contacts/logic/IContactsViewModelCreator;", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/contacts/data/d;", "Lcom/tencent/qqnt/contacts/data/e;", "createContactsViewModel", "Lcom/tencent/qqnt/contacts/data/h;", "Lcom/tencent/qqnt/contacts/data/i;", "createGroupListViewModel", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ContactsViewModelCreatorImpl implements IContactsViewModelCreator {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/contacts/logic/impl/ContactsViewModelCreatorImpl$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
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
            return new BuddyViewModel(new com.tencent.qqnt.contacts.data.repository.b(new c(), new com.tencent.qqnt.contacts.data.datasource.b()), new com.tencent.qqnt.base.dispatcher.a());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/contacts/logic/impl/ContactsViewModelCreatorImpl$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        b() {
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
            return new GroupListViewModel(new GroupListRepository(new PlatformGroupListDataSource(), new com.tencent.qqnt.contacts.data.datasource.b()), new com.tencent.qqnt.base.dispatcher.a());
        }
    }

    public ContactsViewModelCreatorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.contacts.logic.IContactsViewModelCreator
    @NotNull
    public BaseViewModel<d, e> createContactsViewModel(@NotNull ViewModelStoreOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseViewModel) iPatchRedirector.redirect((short) 2, (Object) this, (Object) owner);
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        ViewModel viewModel = new ViewModelProvider(owner, new a()).get(BuddyViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner,\u2026ddyViewModel::class.java)");
        return (BaseViewModel) viewModel;
    }

    @Override // com.tencent.qqnt.contacts.logic.IContactsViewModelCreator
    @NotNull
    public BaseViewModel<h, i> createGroupListViewModel(@NotNull ViewModelStoreOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseViewModel) iPatchRedirector.redirect((short) 3, (Object) this, (Object) owner);
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        ViewModel viewModel = new ViewModelProvider(owner, new b()).get(GroupListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(owner,\u2026istViewModel::class.java)");
        return (BaseViewModel) viewModel;
    }
}
