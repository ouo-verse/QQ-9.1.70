package com.tencent.qqnt.qwallet.aio.hb;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.db.HbStateEntity;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0006\u0010\u0004\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/c;", "Lcom/tencent/qqnt/qwallet/aio/c;", "", "O1", "U1", "Landroidx/lifecycle/MutableLiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "stateLiveData", "S1", "()Ljava/lang/String;", "stateText", "", "T1", "()Z", "isMsgExpired", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class c extends com.tencent.qqnt.qwallet.aio.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> stateLiveData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(c this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String S1 = this$0.S1();
        HbStateEntity y16 = QWalletDBManager.f361825a.y(this$0.M1().getBillNo(), com.tencent.mobileqq.base.a.c());
        if (y16 == null || (str = y16.getText()) == null) {
            str = "";
        }
        QLog.d(this$0.getTAG(), 1, "updateHbStateAsync: in sub thread oldState " + S1 + " newState " + str);
        if (!Intrinsics.areEqual(S1, str)) {
            this$0.stateLiveData.postValue(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.c
    public void O1() {
        U1();
    }

    @NotNull
    public final MutableLiveData<String> R1() {
        return this.stateLiveData;
    }

    @NotNull
    public final String S1() {
        String value = this.stateLiveData.getValue();
        if (value == null) {
            return "";
        }
        return value;
    }

    public final boolean T1() {
        if (M1().f() < NetConnInfoCenter.getServerTime()) {
            return true;
        }
        return false;
    }

    public final void U1() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.hb.b
            @Override // java.lang.Runnable
            public final void run() {
                c.W1(c.this);
            }
        }, 32, null, false);
    }
}
