package com.tencent.ecommerce.biz.showwindow.viewmodel;

import android.os.Bundle;
import ck0.Product;
import com.tencent.bugly.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tR0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/viewmodel/b;", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECShowWindowViewModel;", "Landroid/os/Bundle;", "argument", "", "Q2", "Lck0/c;", "product", "W2", "", "z3", "count", Constants.BASE_IN_APP_NAME, "A3", "Lkotlin/Function1;", "E0", "Lkotlin/jvm/functions/Function1;", "getOnProductAddCallback", "()Lkotlin/jvm/functions/Function1;", "C3", "(Lkotlin/jvm/functions/Function1;)V", "onProductAddCallback", "F0", "Landroid/os/Bundle;", "getArgs", "()Landroid/os/Bundle;", "setArgs", "(Landroid/os/Bundle;)V", "args", "<init>", "()V", "G0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class b extends ECShowWindowViewModel {

    /* renamed from: E0, reason: from kotlin metadata */
    private Function1<? super Product, Unit> onProductAddCallback;

    /* renamed from: F0, reason: from kotlin metadata */
    private Bundle args;

    public final int A3() {
        int i3 = super.get_maxSelectCount();
        Integer value = super.H2().getValue();
        if (value == null) {
            value = 0;
        }
        return i3 - value.intValue();
    }

    public final void C3(Function1<? super Product, Unit> function1) {
        this.onProductAddCallback = function1;
    }

    public final void D3(int count) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateMaxSelectCount count=");
        sb5.append(count);
        sb5.append(", ");
        sb5.append(getClass().getSimpleName());
        sb5.append(", tabName=");
        Bundle bundle = this.args;
        sb5.append(bundle != null ? bundle.getString("shop_name") : null);
        cg0.a.b("ECLiveShowWindowViewModel", sb5.toString());
        super.k3(count);
    }

    @Override // com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel
    public void Q2(Bundle argument) {
        super.Q2(argument);
        this.args = argument;
    }

    @Override // com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel
    protected void W2(Product product) {
        Function1<? super Product, Unit> function1 = this.onProductAddCallback;
        if (function1 != null) {
            function1.invoke(product);
        }
    }

    public final int z3() {
        return get_maxSelectCount();
    }
}
