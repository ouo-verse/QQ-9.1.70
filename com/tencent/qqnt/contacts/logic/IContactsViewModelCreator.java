package com.tencent.qqnt.contacts.logic;

import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.contacts.data.d;
import com.tencent.qqnt.contacts.data.e;
import com.tencent.qqnt.contacts.data.h;
import com.tencent.qqnt.contacts.data.i;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/contacts/logic/IContactsViewModelCreator;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/qqnt/contacts/data/d;", "Lcom/tencent/qqnt/contacts/data/e;", "createContactsViewModel", "Lcom/tencent/qqnt/contacts/data/h;", "Lcom/tencent/qqnt/contacts/data/i;", "createGroupListViewModel", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IContactsViewModelCreator extends QRouteApi {
    @NotNull
    BaseViewModel<d, e> createContactsViewModel(@NotNull ViewModelStoreOwner owner);

    @NotNull
    BaseViewModel<h, i> createGroupListViewModel(@NotNull ViewModelStoreOwner owner);
}
