package com.tencent.qqnt.qwallet.aio;

import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0014R\u001a\u0010\f\u001a\u00020\u00078\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR*\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@DX\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/c;", "Landroidx/lifecycle/ViewModel;", "Lrx3/b;", "aioModel", "", "L1", "O1", "", "i", "Ljava/lang/String;", "N1", "()Ljava/lang/String;", "TAG", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lrx3/b;", "M1", "()Lrx3/b;", "P1", "(Lrx3/b;)V", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class c extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "WalletNT-" + getClass().getSimpleName();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected rx3.b aioModel;

    public void L1(@NotNull rx3.b aioModel) {
        Intrinsics.checkNotNullParameter(aioModel, "aioModel");
        QLog.d(this.TAG, 1, "bindMsg: viewModel " + hashCode() + ", msgRecord " + aioModel);
        P1(aioModel);
        O1();
    }

    @NotNull
    public final rx3.b M1() {
        rx3.b bVar = this.aioModel;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aioModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: N1, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P1(@NotNull rx3.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.aioModel = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O1() {
    }
}
