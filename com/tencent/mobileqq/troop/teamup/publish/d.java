package com.tencent.mobileqq.troop.teamup.publish;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/d;", "Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$a;", "", "onDismiss", "", "", "selectItems", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d implements a.InterfaceC8733a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MutableLiveData<Object> f299117a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List<Object> f299118b;

    public d(MutableLiveData<Object> mutableLiveData, List<Object> list) {
        this.f299117a = mutableLiveData;
        this.f299118b = list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mutableLiveData, (Object) list);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a.InterfaceC8733a
    public void a(@NotNull List<Integer> selectItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) selectItems);
        } else {
            Intrinsics.checkNotNullParameter(selectItems, "selectItems");
            this.f299117a.postValue(this.f299118b.get(selectItems.get(0).intValue()));
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a.InterfaceC8733a
    public void onDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
