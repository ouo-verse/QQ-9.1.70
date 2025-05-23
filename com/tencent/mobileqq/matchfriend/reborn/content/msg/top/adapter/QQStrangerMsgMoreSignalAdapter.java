package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.utils.n;
import com.tencent.mobileqq.matchfriend.reborn.utils.r;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/adapter/QQStrangerMsgMoreSignalAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/adapter/QQStrangerMsgMoreSignalAdapter$b;", "Landroid/widget/ImageView;", "imageView", "", "avatar", "", "m0", "Landroid/graphics/drawable/Drawable;", "l0", "Landroid/content/Context;", "context", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "position", "o0", "getItemCount", "", "getItemId", "holder", "n0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "j0", "()Ljava/util/List;", "avatarValues", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgMoreSignalAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy avatarValues;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\u0017\u00a2\u0006\u0004\b$\u0010%R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\"\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/adapter/QQStrangerMsgMoreSignalAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/ImageView;", "fgIv", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "t", "()Landroid/widget/TextView;", "titleTv", "G", "l", "avatar1", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "avatar2", "I", "o", "avatar3", "Landroid/view/View;", "J", "Landroid/view/View;", "p", "()Landroid/view/View;", "border1", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "border2", "L", "r", "border3", "itemView", "<init>", "(Landroid/view/View;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView fgIv;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView titleTv;

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView avatar1;

        /* renamed from: H, reason: from kotlin metadata */
        private final ImageView avatar2;

        /* renamed from: I, reason: from kotlin metadata */
        private final ImageView avatar3;

        /* renamed from: J, reason: from kotlin metadata */
        private final View border1;

        /* renamed from: K, reason: from kotlin metadata */
        private final View border2;

        /* renamed from: L, reason: from kotlin metadata */
        private final View border3;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.okq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_fg)");
            this.fgIv = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.osa);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_title)");
            this.titleTv = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.oi6);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.avatar1)");
            this.avatar1 = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.oi7);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.avatar2)");
            this.avatar2 = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.oi8);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.avatar3)");
            this.avatar3 = (ImageView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.oim);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.border1)");
            this.border1 = findViewById6;
            View findViewById7 = itemView.findViewById(R.id.oin);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.border2)");
            this.border2 = findViewById7;
            View findViewById8 = itemView.findViewById(R.id.oio);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.border3)");
            this.border3 = findViewById8;
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getAvatar1() {
            return this.avatar1;
        }

        /* renamed from: m, reason: from getter */
        public final ImageView getAvatar2() {
            return this.avatar2;
        }

        /* renamed from: o, reason: from getter */
        public final ImageView getAvatar3() {
            return this.avatar3;
        }

        /* renamed from: p, reason: from getter */
        public final View getBorder1() {
            return this.border1;
        }

        /* renamed from: q, reason: from getter */
        public final View getBorder2() {
            return this.border2;
        }

        /* renamed from: r, reason: from getter */
        public final View getBorder3() {
            return this.border3;
        }

        /* renamed from: s, reason: from getter */
        public final ImageView getFgIv() {
            return this.fgIv;
        }

        /* renamed from: t, reason: from getter */
        public final TextView getTitleTv() {
            return this.titleTv;
        }
    }

    public QQStrangerMsgMoreSignalAdapter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<? extends String>>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.QQStrangerMsgMoreSignalAdapter$avatarValues$2
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends String> invoke() {
                List<Pair> zip;
                List drop;
                List plus;
                List drop2;
                List<? extends String> plus2;
                List listOf;
                com.tencent.mobileqq.matchfriend.reborn.config.c cVar = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a;
                List<String> e16 = cVar.c().e();
                List<String> c16 = cVar.c().c();
                List<String> list = e16;
                zip = CollectionsKt___CollectionsKt.zip(list, c16);
                ArrayList arrayList = new ArrayList();
                for (Pair pair : zip) {
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{(String) pair.component1(), (String) pair.component2()});
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, listOf);
                }
                drop = CollectionsKt___CollectionsKt.drop(list, c16.size());
                plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) drop);
                drop2 = CollectionsKt___CollectionsKt.drop(c16, e16.size());
                plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) drop2);
                return plus2;
            }
        });
        this.avatarValues = lazy;
    }

    private final List<String> j0() {
        return (List) this.avatarValues.getValue();
    }

    private final String k0(Context context) {
        if (n.f245488a.a(context)) {
            return "https://downv6.qq.com/extendfriend/kl_hobby_card_expand_dark.png";
        }
        return "https://downv6.qq.com/extendfriend/kl_hobby_card_expand_light.png";
    }

    private final Drawable l0() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(ViewUtils.dpToPx(1.0f), -1);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(View view, View view2) {
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterSignalSquare(view.getContext());
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.c(aVar, context, "em_kl_expansion_list_square", null, 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        List shuffled;
        List take;
        Object orNull;
        Object orNull2;
        Object orNull3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Option targetView = Option.obtain().setTargetView(holder.getFgIv());
        Context context = holder.getFgIv().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.fgIv.context");
        Option option = targetView.setUrl(k0(context)).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, null);
        Drawable drawable = ContextCompat.getDrawable(holder.getTitleTv().getContext(), R.drawable.qui_chevron_right);
        if (drawable != null) {
            drawable.setBounds(0, 0, ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        }
        holder.getTitleTv().setCompoundDrawables(null, null, drawable, null);
        shuffled = CollectionsKt__CollectionsJVMKt.shuffled(j0());
        take = CollectionsKt___CollectionsKt.take(shuffled, 3);
        ImageView avatar1 = holder.getAvatar1();
        orNull = CollectionsKt___CollectionsKt.getOrNull(take, 0);
        m0(avatar1, (String) orNull);
        ImageView avatar2 = holder.getAvatar2();
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(take, 1);
        m0(avatar2, (String) orNull2);
        ImageView avatar3 = holder.getAvatar3();
        orNull3 = CollectionsKt___CollectionsKt.getOrNull(take, 2);
        m0(avatar3, (String) orNull3);
        holder.getBorder1().setBackground(l0());
        holder.getBorder2().setBackground(l0());
        holder.getBorder3().setBackground(l0());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int position) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        final View onCreateViewHolder$lambda$1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.cxr, parent, false);
        n nVar = n.f245488a;
        Context context = onCreateViewHolder$lambda$1.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        onCreateViewHolder$lambda$1.setBackgroundResource(nVar.a(context) ? R.drawable.f8j : R.drawable.f8k);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder$lambda$1, "onCreateViewHolder$lambda$1");
        r.c(onCreateViewHolder$lambda$1, 0.0f, 1, null);
        onCreateViewHolder$lambda$1.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerMsgMoreSignalAdapter.p0(onCreateViewHolder$lambda$1, view);
            }
        });
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        Context context2 = onCreateViewHolder$lambda$1.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.e(aVar, context2, "em_kl_expansion_list_square", null, 4, null);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder$lambda$1, "from(parent.context).inf\u2026NT_MORE_SIGNAL)\n        }");
        return new b(onCreateViewHolder$lambda$1);
    }

    private final void m0(ImageView imageView, String avatar) {
        if (avatar == null || avatar.length() == 0) {
            imageView.setImageDrawable(null);
            return;
        }
        Option option = Option.obtain().setTargetView(imageView).setUrl(avatar).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, null);
    }
}
