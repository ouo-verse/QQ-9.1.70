package com.tencent.mobileqq.guild.feed.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.widget.GuildFeedMessageItemView;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.x;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import ij1.v;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zm1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0004\u0018\u0000 .2\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003/01B\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\b,\u0010-J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J(\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00142\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/GuildVisitorFeedNoticeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lij1/v;", "Lcom/tencent/mobileqq/guild/feed/adapter/GuildVisitorFeedNoticeAdapter$c;", "com/tencent/mobileqq/guild/feed/adapter/GuildVisitorFeedNoticeAdapter$createVisitorFeedNoticeMenuListener$1", "k0", "()Lcom/tencent/mobileqq/guild/feed/adapter/GuildVisitorFeedNoticeAdapter$createVisitorFeedNoticeMenuListener$1;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/widget/FrameLayout;", "o0", "Landroid/view/View;", "n0", "l0", "Landroid/widget/RelativeLayout;", "m0", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/x;", "cb", "", "s0", "", "viewType", "r0", "holder", "position", "p0", "", "", "payloads", "q0", "getItemViewType", "Landroidx/fragment/app/Fragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "parentFragment", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "getBean", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "bean", "D", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/x;", "guildNoticeCallback", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;)V", "E", "a", "b", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildVisitorFeedNoticeAdapter extends ListAdapter<v<?>, c> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedBaseInitBean bean;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private x guildNoticeCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment parentFragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J \u0010\b\u001a\u00020\u00062\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J \u0010\t\u001a\u00020\u00062\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0017J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/GuildVisitorFeedNoticeAdapter$b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lij1/v;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStNotice;", "oldItem", "newItem", "", "b", "c", "a", "", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class b extends DiffUtil.ItemCallback<v<?>> {
        private final boolean b(GProStNotice oldItem, GProStNotice newItem) {
            if (oldItem.isCloseInteract == newItem.isCloseInteract) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull v<?> oldItem, @NotNull v<?> newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if ((oldItem instanceof ij1.a) && (newItem instanceof ij1.a)) {
                ij1.a aVar = (ij1.a) oldItem;
                ij1.a aVar2 = (ij1.a) newItem;
                if (Intrinsics.areEqual(aVar.b().pattonInfo.plainTxt.operation.schema, aVar2.b().pattonInfo.plainTxt.operation.schema) && aVar.b().psvFeed.totalLike.isClicked == aVar2.b().psvFeed.totalLike.isClicked) {
                    GProStNotice b16 = aVar.b();
                    Intrinsics.checkNotNullExpressionValue(b16, "oldItem.sourceData");
                    GProStNotice b17 = aVar2.b();
                    Intrinsics.checkNotNullExpressionValue(b17, "newItem.sourceData");
                    if (b(b16, b17)) {
                        return true;
                    }
                }
                return false;
            }
            if (Intrinsics.areEqual(oldItem.b(), newItem.b()) && oldItem.h() == newItem.h()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull v<?> oldItem, @NotNull v<?> newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if ((oldItem instanceof ij1.a) && (newItem instanceof ij1.a)) {
                return Intrinsics.areEqual(((ij1.a) oldItem).b().pattonInfo.plainTxt.operation.schema, ((ij1.a) newItem).b().pattonInfo.plainTxt.operation.schema);
            }
            if (Intrinsics.areEqual(oldItem.b(), newItem.b()) && oldItem.h() == newItem.h()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NotNull v<?> oldItem, @NotNull v<?> newItem) {
            boolean z16;
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!(oldItem instanceof ij1.a) || !(newItem instanceof ij1.a)) {
                return null;
            }
            ij1.a aVar = (ij1.a) oldItem;
            ij1.a aVar2 = (ij1.a) newItem;
            if (Intrinsics.areEqual(aVar.b().pattonInfo.plainTxt.operation.schema, aVar2.b().pattonInfo.plainTxt.operation.schema) && aVar.b().psvFeed.totalLike.isClicked == aVar2.b().psvFeed.totalLike.isClicked) {
                z16 = true;
            } else {
                z16 = false;
            }
            GProStNotice b16 = aVar.b();
            Intrinsics.checkNotNullExpressionValue(b16, "oldItem.sourceData");
            GProStNotice b17 = aVar2.b();
            Intrinsics.checkNotNullExpressionValue(b17, "newItem.sourceData");
            boolean b18 = b(b16, b17);
            if (!z16 || b18) {
                return null;
            }
            return a.C11698a.f452777a;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u00020\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/adapter/GuildVisitorFeedNoticeAdapter$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lij1/v;", "messageBlockData", "", "position", "Lzm1/a;", "payload", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public static /* synthetic */ void m(c cVar, v vVar, int i3, zm1.a aVar, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                aVar = null;
            }
            cVar.l(vVar, i3, aVar);
        }

        public final void l(@NotNull v<?> messageBlockData, int position, @Nullable zm1.a payload) {
            Intrinsics.checkNotNullParameter(messageBlockData, "messageBlockData");
            View view = this.itemView;
            if (view instanceof GuildFeedMessageItemView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.widget.GuildFeedMessageItemView");
                GuildFeedMessageItemView guildFeedMessageItemView = (GuildFeedMessageItemView) view;
                if (payload != null) {
                    guildFeedMessageItemView.setDataWithPayload((ij1.a) messageBlockData, position, payload);
                    return;
                } else {
                    guildFeedMessageItemView.setData((ij1.a) messageBlockData, position);
                    return;
                }
            }
            QLog.e("GuildVisitorFeedNoticeAdapter", 1, "setData  itemView != GuildBaseWidgetView");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildVisitorFeedNoticeAdapter(@NotNull Fragment parentFragment, @NotNull GuildFeedBaseInitBean bean) {
        super(new b());
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.parentFragment = parentFragment;
        this.bean = bean;
    }

    private final GuildVisitorFeedNoticeAdapter$createVisitorFeedNoticeMenuListener$1 k0() {
        return new GuildVisitorFeedNoticeAdapter$createVisitorFeedNoticeMenuListener$1(this);
    }

    private final FrameLayout l0(ViewGroup parent) {
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setBackgroundColor(parent.getContext().getResources().getColor(R.color.qui_common_bg_bottom_brand));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(12.0f)));
        ViewExtKt.f(frameLayout, ViewUtils.dip2px(12.0f));
        return frameLayout;
    }

    private final RelativeLayout m0(ViewGroup parent) {
        RelativeLayout relativeLayout = new RelativeLayout(parent.getContext());
        TextView textView = new TextView(parent.getContext());
        textView.setTextColor(parent.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary));
        textView.setTextSize(14.0f);
        textView.setText(HardCodeUtil.qqStr(R.string.f144680pf));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(1);
        layoutParams.addRule(13);
        int dip2px = ViewUtils.dip2px(16.0f);
        relativeLayout.setPadding(dip2px, dip2px, dip2px, dip2px);
        relativeLayout.addView(textView, layoutParams);
        return relativeLayout;
    }

    private final View n0(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f_e, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026tice_item, parent, false)");
        return inflate;
    }

    private final FrameLayout o0(ViewGroup parent) {
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        TextView textView = new TextView(parent.getContext());
        textView.setTextColor(parent.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary));
        textView.setTextSize(14.0f);
        textView.setText(parent.getContext().getString(R.string.f146790v5));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        frameLayout.setPadding(ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f), 0, ViewUtils.dip2px(6.0f));
        frameLayout.addView(textView, layoutParams);
        return frameLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        v<?> item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "item");
        c.m(holder, item, position, null, 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        a.C11698a c11698a = a.C11698a.f452777a;
        if (payloads.contains(c11698a)) {
            v<?> item = getItem(position);
            Intrinsics.checkNotNullExpressionValue(item, "item");
            holder.l(item, position, c11698a);
            return;
        }
        onBindViewHolder(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 2) {
            if (viewType != 3) {
                if (viewType != 4) {
                    if (viewType != 5) {
                        if (viewType != 6) {
                            view = l0(parent);
                            QLog.e("GuildVisitorFeedNoticeAdapter", 1, "viewType  " + viewType);
                        } else {
                            view = l0(parent);
                        }
                    } else {
                        view = n0(parent);
                    }
                } else {
                    view = o0(parent);
                }
            } else {
                view = m0(parent);
            }
        } else {
            GuildFeedMessageItemView guildFeedMessageItemView = new GuildFeedMessageItemView(parent.getContext(), Integer.valueOf(viewType), this.bean);
            guildFeedMessageItemView.A0((com.tencent.mobileqq.guild.feed.part.notice.f) yl1.n.s(parent, com.tencent.mobileqq.guild.feed.part.notice.f.class));
            guildFeedMessageItemView.y0(k0());
            guildFeedMessageItemView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            view = guildFeedMessageItemView;
        }
        return new c(view);
    }

    public final void s0(@Nullable x cb5) {
        this.guildNoticeCallback = cb5;
    }
}
