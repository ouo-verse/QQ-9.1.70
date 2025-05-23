package com.tencent.qqnt.chats.biz.guild;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemHolder;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemRightLayout;
import com.tencent.qqnt.chats.utils.preload.LayoutPreLoader;
import com.tencent.qqnt.chats.view.RollingTextView;
import com.tencent.qqnt.chats.view.widget.GuildSummaryLayout;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildRecentItemBuilder;", "Lcom/tencent/qqnt/chats/core/adapter/builder/CommonRecentItemBuilder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/qqnt/chats/core/itempart/d;", "itemPartCollect", "Lcom/tencent/mobileqq/quibadge/b;", "dragListener", "Lcom/tencent/qqnt/chats/core/adapter/h;", "operatorListener", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemHolder;", DomainData.DOMAIN_NAME, "Lpw3/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", "p", "<init>", "()V", "e", "a", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class GuildRecentItemBuilder extends CommonRecentItemBuilder {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildRecentItemBuilder> f354274f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildRecentItemBuilder$a;", "", "Lcom/tencent/qqnt/chats/biz/guild/GuildRecentItemBuilder;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/chats/biz/guild/GuildRecentItemBuilder;", "getINSTANCE$annotations", "()V", "INSTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.guild.GuildRecentItemBuilder$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildRecentItemBuilder a() {
            return (GuildRecentItemBuilder) GuildRecentItemBuilder.f354274f.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<GuildRecentItemBuilder> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildRecentItemBuilder>() { // from class: com.tencent.qqnt.chats.biz.guild.GuildRecentItemBuilder$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildRecentItemBuilder invoke() {
                return new GuildRecentItemBuilder();
            }
        });
        f354274f = lazy;
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public RecentContactItemHolder a(@NotNull ViewGroup parent, int viewType, @Nullable com.tencent.qqnt.chats.core.itempart.d itemPartCollect, @Nullable com.tencent.mobileqq.quibadge.b dragListener, @Nullable com.tencent.qqnt.chats.core.adapter.h operatorListener) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        pw3.e z16 = z(parent);
        if (z16 == null) {
            z16 = com.tencent.qqnt.chats.core.utils.b.f355092a.b(xv3.a.a(parent));
        }
        o(itemPartCollect);
        z16.f427823o.setOnModeChangeListener(dragListener);
        RollingTextView unread = z16.f427823o;
        ImageView summaryRightView = z16.f427819k;
        SingleLineTextView title = z16.f427820l;
        GuildSummaryLayout summary = z16.f427818j;
        RecentAvatarViewWrapper avatarLayout = z16.f427811c;
        ImageView imageView = z16.f427822n;
        SwipeMenuLayout root = z16.getRoot();
        SwipeMenuLayout chatSwipeLayout = z16.f427815g;
        RelativeLayout chatContent = z16.f427813e;
        ImageView diyMsgBg = z16.f427816h;
        RecentContactItemRightLayout rightLayout = z16.f427817i;
        LinearLayoutCompat chatMenu = z16.f427814f;
        RoundFrameLayout roundFrameLayout = z16.f427812d;
        pw3.e eVar = z16;
        Intrinsics.checkNotNullExpressionValue(unread, "unread");
        Intrinsics.checkNotNullExpressionValue(summaryRightView, "summaryRightView");
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Intrinsics.checkNotNullExpressionValue(summary, "summary");
        Intrinsics.checkNotNullExpressionValue(avatarLayout, "avatarLayout");
        Intrinsics.checkNotNullExpressionValue(root, "root");
        Intrinsics.checkNotNullExpressionValue(chatSwipeLayout, "chatSwipeLayout");
        Intrinsics.checkNotNullExpressionValue(chatContent, "chatContent");
        Intrinsics.checkNotNullExpressionValue(diyMsgBg, "diyMsgBg");
        Intrinsics.checkNotNullExpressionValue(rightLayout, "rightLayout");
        Intrinsics.checkNotNullExpressionValue(chatMenu, "chatMenu");
        RecentContactItemBinding recentContactItemBinding = new RecentContactItemBinding(unread, summaryRightView, title, imageView, summary, avatarLayout, root, chatSwipeLayout, chatContent, diyMsgBg, rightLayout, chatMenu, null, roundFrameLayout, 4096, null);
        eVar.f427812d.setRadius(ViewUtils.dip2px(10.0f));
        if (QLog.isColorLevel()) {
            QLog.d("GuildRecentItemBuilder", 1, "createViewHolder");
        }
        ViewParent parent2 = eVar.f427811c.getParent();
        Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.widget.FrameLayout");
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(R.id.f165598wv3);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        ((FrameLayout) parent2).addView(imageView2, 0, new FrameLayout.LayoutParams(-1, -1));
        return new RecentContactItemHolder(this, recentContactItemBinding, operatorListener);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.builder.CommonRecentItemBuilder, com.tencent.qqnt.chats.core.adapter.builder.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull RecentContactItemHolder holder) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.c(item, holder);
        holder.y().a().getAvatarView().setTag(R.id.f165439w04, item.w().e());
    }

    @Nullable
    public pw3.e z(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutPreLoader a16 = com.tencent.qqnt.chats.utils.preload.b.f355561a.a("chat_list");
        if (a16 != null) {
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return (pw3.e) a16.k("GUILD_Recent_Item", new LayoutPreLoader.b(context));
        }
        return null;
    }
}
