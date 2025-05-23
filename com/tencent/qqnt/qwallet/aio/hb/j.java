package com.tencent.qqnt.qwallet.aio.hb;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/j;", "Lcom/tencent/qqnt/qwallet/aio/hb/c;", "", "O1", "Landroidx/lifecycle/MutableLiveData;", "", "D", "Landroidx/lifecycle/MutableLiveData;", "X1", "()Landroidx/lifecycle/MutableLiveData;", "titleLiveData", "", "Z1", "()Z", "isAnonymousChat", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class j extends c {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> titleLiveData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.c, com.tencent.qqnt.qwallet.aio.c
    public void O1() {
        boolean z16;
        super.O1();
        String title = M1().getTitle();
        if (title.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.titleLiveData.postValue(title);
        }
    }

    @NotNull
    public final MutableLiveData<String> X1() {
        return this.titleLiveData;
    }

    public final boolean Z1() {
        return ((IAnonymousChatApi) QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(M1().i());
    }
}
