package com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AbsFallbackAdapterDelegate;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"", "T", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsFallbackAdapterDelegate;", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0000\u0005\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007J4\u0010\u0011\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0013\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/b$a", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsFallbackAdapterDelegate;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "com/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/b$a$a", "c", "(Landroid/view/ViewGroup;)Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/b$a$a;", "items", "", "position", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "", "payloads", "", "onBindViewHolder", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "b", "()Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "tv", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a<T> extends AbsFallbackAdapterDelegate<List<? extends T>> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public TextView tv;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/b$a$a", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7723a extends RecyclerView.ViewHolder {
            C7723a(TextView textView) {
                super(textView);
            }
        }

        a() {
        }

        @NotNull
        public final TextView b() {
            TextView textView = this.tv;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("tv");
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C7723a onCreateViewHolder(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            TextView textView = new TextView(parent.getContext());
            d(textView);
            return new C7723a(textView);
        }

        public final void d(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tv = textView;
        }

        @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
        public /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i3, RecyclerView.ViewHolder viewHolder, List list) {
            onBindViewHolder((List) obj, i3, viewHolder, (List<Object>) list);
        }

        protected void onBindViewHolder(@NotNull List<? extends T> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            TextView b16 = b();
            T t16 = items.get(position);
            b16.setText("unknown " + (t16 != null ? t16.getClass() : null));
        }
    }

    @NotNull
    public static final <T> AbsFallbackAdapterDelegate<List<T>> a() {
        return new a();
    }
}
