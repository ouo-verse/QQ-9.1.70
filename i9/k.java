package i9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"Li9/k;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Li9/m;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "p0", "holder", "position", "", "l0", "getItemCount", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class k extends RecyclerView.Adapter<m> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        RFWIocAbilityProvider.g().getIoc(l9.j.class).originView(view).done(new OnPromiseResolved() { // from class: i9.i
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                k.n0((l9.j) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: i9.j
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                k.o0(str);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(l9.j jVar) {
        jVar.Q1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(m holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: i9.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.m0(view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public m onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cko, parent, false);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return new m(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(String str) {
    }
}
