package com.tencent.ecommerce.biz.logistics;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.biz.logistics.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B\u0011\b\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/o;", "Lcom/tencent/ecommerce/biz/logistics/n;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "data", "", "l", "(Lcom/tencent/ecommerce/biz/logistics/n;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Lcom/tencent/ecommerce/biz/logistics/r;", "Lcom/tencent/ecommerce/biz/logistics/p;", "Lcom/tencent/ecommerce/biz/logistics/q;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class o<T extends n> extends RecyclerView.ViewHolder {
    public /* synthetic */ o(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    public abstract void l(T data);

    o(View view) {
        super(view);
    }
}
