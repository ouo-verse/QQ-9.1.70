package com.tencent.mobileqq.guild.home.schedule.delegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.home.schedule.models.Empty;
import com.tencent.mobileqq.guild.home.schedule.models.d;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u001b\u001cB\u001d\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J4\u0010\u0012\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014R%\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00110\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/EmptyPageDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "items", "", "position", "", "j", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", "", "k", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getAction", "()Lkotlin/jvm/functions/Function1;", "action", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class EmptyPageDelegate extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends d>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<d, Unit> action;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001f\u0010\u001c\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/EmptyPageDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "E", "Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "o", "()Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;", "normalEmptyView", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "newStyleGuideView", "Lcom/tencent/mobileqq/guild/home/schedule/models/b;", "G", "Lcom/tencent/mobileqq/guild/home/schedule/models/b;", "getItem", "()Lcom/tencent/mobileqq/guild/home/schedule/models/b;", "p", "(Lcom/tencent/mobileqq/guild/home/schedule/models/b;)V", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "H", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "imagePlaceHolder", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/guild/component/GuildQUIEmptyState;Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final GuildQUIEmptyState normalEmptyView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final View newStyleGuideView;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private Empty item;

        /* renamed from: H, reason: from kotlin metadata */
        private final ImageView imagePlaceHolder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView, @NotNull GuildQUIEmptyState normalEmptyView, @NotNull View newStyleGuideView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(normalEmptyView, "normalEmptyView");
            Intrinsics.checkNotNullParameter(newStyleGuideView, "newStyleGuideView");
            this.normalEmptyView = normalEmptyView;
            this.newStyleGuideView = newStyleGuideView;
            this.imagePlaceHolder = (ImageView) newStyleGuideView.findViewById(R.id.wyn);
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getImagePlaceHolder() {
            return this.imagePlaceHolder;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final View getNewStyleGuideView() {
            return this.newStyleGuideView;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final GuildQUIEmptyState getNormalEmptyView() {
            return this.normalEmptyView;
        }

        public final void p(@Nullable Empty empty) {
            this.item = empty;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmptyPageDelegate(@NotNull Function1<? super d, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(parent.getContext()).s(3).u("\u6682\u65e0\u65e5\u7a0b").r(false).n(false).o(0).a();
        a16.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        a16.setId(R.id.f165092uv0);
        a16.setGravity(17);
        View emptyView3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.f7f, (ViewGroup) null, false);
        View findViewById = emptyView3.findViewById(R.id.wyn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "emptyView3.findViewById(\u2026ild_schedule_guide_image)");
        v.i("https://downv6.qq.com/innovate/guild/guild_schedule/guild_schedule_admin_empty_light.png", (ImageView) findViewById);
        LinearLayout linearLayout = new LinearLayout(parent.getContext());
        linearLayout.setId(R.id.uuy);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(a16);
        linearLayout.addView(emptyView3, new LinearLayout.LayoutParams(-1, -2));
        Intrinsics.checkNotNullExpressionValue(emptyView3, "emptyView3");
        return new b(linearLayout, a16, emptyView3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends d> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        return items.get(position) instanceof Empty;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends d> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder instanceof b) {
            d dVar = items.get(position);
            Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.home.schedule.models.Empty");
            Empty empty = (Empty) dVar;
            ((b) holder).p(empty);
            int i3 = 0;
            if (empty.getNewStyle()) {
                View view = holder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                ViewExtKt.f(view, ViewUtils.dpToPx(40.0f));
                b bVar = (b) holder;
                bVar.getNormalEmptyView().setVisibility(8);
                bVar.getNewStyleGuideView().setVisibility(0);
                if (QQTheme.isNowThemeIsNight()) {
                    ImageView imagePlaceHolder = bVar.getImagePlaceHolder();
                    Intrinsics.checkNotNullExpressionValue(imagePlaceHolder, "holder.imagePlaceHolder");
                    v.i("https://downv6.qq.com/innovate/guild/guild_schedule/guild_schedule_admin_empty_dark.png", imagePlaceHolder);
                    return;
                } else {
                    ImageView imagePlaceHolder2 = bVar.getImagePlaceHolder();
                    Intrinsics.checkNotNullExpressionValue(imagePlaceHolder2, "holder.imagePlaceHolder");
                    v.i("https://downv6.qq.com/innovate/guild/guild_schedule/guild_schedule_admin_empty_light.png", imagePlaceHolder2);
                    return;
                }
            }
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            ViewExtKt.f(view2, ViewUtils.getScreenHeight() / 3);
            b bVar2 = (b) holder;
            GuildQUIEmptyState normalEmptyView = bVar2.getNormalEmptyView();
            if (!(!empty.getIsAdmin())) {
                i3 = 8;
            }
            normalEmptyView.setVisibility(i3);
            bVar2.getNewStyleGuideView().setVisibility(8);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
