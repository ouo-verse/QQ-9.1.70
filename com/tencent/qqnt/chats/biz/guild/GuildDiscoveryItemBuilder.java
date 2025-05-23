package com.tencent.qqnt.chats.biz.guild;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chats.core.adapter.holder.GuildDiscoveryItemHolder;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.chats.view.widget.RecentAvatarViewWrapper;
import com.tencent.qqnt.chats.view.widget.RoundFrameLayout;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ6\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildDiscoveryItemBuilder;", "Lcom/tencent/qqnt/chats/core/adapter/builder/a;", "Lcom/tencent/qqnt/chats/core/adapter/holder/GuildDiscoveryItemHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/qqnt/chats/core/itempart/d;", "itemPartCollect", "Lcom/tencent/mobileqq/quibadge/b;", "dragListener", "Lcom/tencent/qqnt/chats/core/adapter/h;", "operatorListener", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View$OnClickListener;", "listener", "r", "p", "v", "t", ReportConstant.COSTREPORT_PREFIX, "u", "o", "<init>", "()V", "b", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildDiscoveryItemBuilder extends com.tencent.qqnt.chats.core.adapter.builder.a<GuildDiscoveryItemHolder> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildDiscoveryItemBuilder> f354255c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildDiscoveryItemBuilder$a;", "", "Lcom/tencent/qqnt/chats/biz/guild/GuildDiscoveryItemBuilder;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/chats/biz/guild/GuildDiscoveryItemBuilder;", "getINSTANCE$annotations", "()V", "INSTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.guild.GuildDiscoveryItemBuilder$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildDiscoveryItemBuilder a() {
            return (GuildDiscoveryItemBuilder) GuildDiscoveryItemBuilder.f354255c.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildDiscoveryItemBuilder> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildDiscoveryItemBuilder>() { // from class: com.tencent.qqnt.chats.biz.guild.GuildDiscoveryItemBuilder$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildDiscoveryItemBuilder invoke() {
                return new GuildDiscoveryItemBuilder();
            }
        });
        f354255c = lazy;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public GuildDiscoveryItemHolder a(@NotNull ViewGroup parent, int viewType, @Nullable com.tencent.qqnt.chats.core.itempart.d itemPartCollect, @Nullable com.tencent.mobileqq.quibadge.b dragListener, @Nullable com.tencent.qqnt.chats.core.adapter.h operatorListener) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        pw3.d c16 = com.tencent.qqnt.chats.core.utils.b.f355092a.c(xv3.a.a(parent));
        RelativeLayout root = c16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ab.c(root);
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        RollingTextView rollingTextView = new RollingTextView(context);
        rollingTextView.setOnModeChangeListener(dragListener);
        ImageView imageView = new ImageView(parent.getContext());
        SingleLineTextView singleLineTextView = new SingleLineTextView(parent.getContext());
        View view = new View(parent.getContext());
        RecentAvatarViewWrapper avatarLayout = c16.f427805c;
        SwipeMenuLayout swipeMenuLayout = new SwipeMenuLayout(parent.getContext());
        SwipeMenuLayout swipeMenuLayout2 = new SwipeMenuLayout(parent.getContext());
        RelativeLayout chatContent = c16.f427807e;
        ImageView diyMsgBg = c16.f427808f;
        RelativeLayout relativeLayout = new RelativeLayout(parent.getContext());
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(parent.getContext());
        RoundFrameLayout roundFrameLayout = c16.f427806d;
        Intrinsics.checkNotNullExpressionValue(avatarLayout, "avatarLayout");
        Intrinsics.checkNotNullExpressionValue(chatContent, "chatContent");
        Intrinsics.checkNotNullExpressionValue(diyMsgBg, "diyMsgBg");
        return new GuildDiscoveryItemHolder(this, new RecentContactItemBinding(rollingTextView, imageView, singleLineTextView, null, view, avatarLayout, swipeMenuLayout, swipeMenuLayout2, chatContent, diyMsgBg, relativeLayout, linearLayoutCompat, null, roundFrameLayout, 4096, null), operatorListener, c16);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull GuildDiscoveryItemHolder holder) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Drawable drawable = ContextCompat.getDrawable(holder.u().i().getContext(), R.drawable.jg7);
        if (drawable == null) {
            return;
        }
        holder.u().a().getAvatarView().setImageDrawable(drawable);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void d(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull GuildDiscoveryItemHolder holder) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (GuildLayoutManager.f354256a.s()) {
            RelativeLayout b16 = holder.u().b();
            ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
            b16.setBackground(chatsColorCache.b(context));
            return;
        }
        RelativeLayout b17 = holder.u().b();
        ChatsColorCache chatsColorCache2 = ChatsColorCache.f355526a;
        Context context2 = holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "holder.itemView.context");
        b17.setBackground(chatsColorCache2.c(context2));
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void e(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull GuildDiscoveryItemHolder holder) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull GuildDiscoveryItemHolder holder, @NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull GuildDiscoveryItemHolder holder) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void i(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull GuildDiscoveryItemHolder holder) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void j(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull GuildDiscoveryItemHolder holder) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull GuildDiscoveryItemHolder holder) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
    }
}
