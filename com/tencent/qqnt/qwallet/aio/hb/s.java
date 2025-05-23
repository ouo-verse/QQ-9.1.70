package com.tencent.qqnt.qwallet.aio.hb;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/s;", "Lcom/tencent/qqnt/qwallet/aio/c;", "Lrx3/b;", "aioModel", "", "L1", "Landroidx/lifecycle/MutableLiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "isBound", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class s extends com.tencent.qqnt.qwallet.aio.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isBound = new MutableLiveData<>();

    @Override // com.tencent.qqnt.qwallet.aio.c
    public void L1(@NotNull rx3.b aioModel) {
        Intrinsics.checkNotNullParameter(aioModel, "aioModel");
        P1(aioModel);
        this.isBound.postValue(Boolean.TRUE);
        QLog.d(getTAG(), 1, "bindMsg: msgType " + aioModel.getMsgType());
    }

    @NotNull
    public final MutableLiveData<Boolean> Q1() {
        return this.isBound;
    }
}
