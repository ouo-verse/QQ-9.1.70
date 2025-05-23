package com.tencent.mobileqq.aio.input.at.business;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0002\u001a\u00020\u0001H\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/m;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "a", "newItemData", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/a;", "b", "", "mUid", "<init>", "(Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class m extends com.tencent.mobileqq.aio.input.at.common.list.data.b {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull String mUid) {
        super(mUid);
        Intrinsics.checkNotNullParameter(mUid, "mUid");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mUid);
        }
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.list.data.b
    @NotNull
    public com.tencent.mobileqq.aio.input.at.common.list.data.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.at.common.list.data.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        m mVar = new m(c());
        mVar.i(d());
        mVar.h(d());
        return mVar;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.list.data.b
    @NotNull
    public List<com.tencent.mobileqq.aio.input.at.common.list.a> b(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b newItemData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) newItemData);
        }
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return super.b(newItemData);
    }
}
