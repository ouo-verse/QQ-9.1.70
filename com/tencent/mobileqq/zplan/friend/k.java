package com.tencent.mobileqq.zplan.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B+\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/k;", "Lcom/tencent/mobileqq/zplan/friend/b;", "Lcom/tencent/mobileqq/zplan/friend/k$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "p0", "holder", "position", "", "n0", "Landroid/content/Context;", "D", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "E", "Lkotlin/jvm/functions/Function1;", "itemClickListener", "Lcom/tencent/mobileqq/zplan/friend/e;", "friendItemBinder", "<init>", "(Lcom/tencent/mobileqq/zplan/friend/e;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k extends b<a> {

    /* renamed from: D, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: E, reason: from kotlin metadata */
    private final Function1<String, Unit> itemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/k$a;", "Lcom/tencent/mobileqq/zplan/friend/a;", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "avatar", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "name", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends com.tencent.mobileqq.zplan.friend.a {

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView avatar;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.avatar = (ImageView) itemView.findViewById(R.id.q49);
            this.name = (TextView) itemView.findViewById(R.id.qug);
        }

        @Override // com.tencent.mobileqq.zplan.friend.a
        /* renamed from: l, reason: from getter */
        public ImageView getAvatar() {
            return this.avatar;
        }

        @Override // com.tencent.mobileqq.zplan.friend.a
        /* renamed from: m, reason: from getter */
        public TextView getName() {
            return this.name;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public k(e friendItemBinder, Context context, Function1<? super String, Unit> itemClickListener) {
        super(friendItemBinder);
        Intrinsics.checkNotNullParameter(friendItemBinder, "friendItemBinder");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(k this$0, FriendInfo friendInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(friendInfo, "$friendInfo");
        this$0.itemClickListener.invoke(friendInfo.getUin());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.j0(holder, position);
        final FriendInfo friendInfo = i0().get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.friend.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.o0(k.this, friendInfo, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.dhg, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026iend_item, parent, false)");
        return new a(inflate);
    }
}
