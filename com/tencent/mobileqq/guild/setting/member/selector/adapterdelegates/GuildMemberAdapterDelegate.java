package com.tencent.mobileqq.guild.setting.member.selector.adapterdelegates;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.member.selector.MemberData;
import com.tencent.mobileqq.guild.setting.member.selector.adapterdelegates.GuildMemberAdapterDelegate;
import com.tencent.mobileqq.guild.setting.member.selector.q;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.ac;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.bz;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u0005:\u0002\u001f B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007H\u0014J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/adapterdelegates/GuildMemberAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/setting/member/selector/s;", "Lcom/tencent/mobileqq/guild/setting/member/selector/a;", "Lcom/tencent/mobileqq/guild/setting/member/selector/adapterdelegates/GuildMemberAdapterDelegate$MyViewHolder;", "Landroid/view/View$OnClickListener;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "r", "holder", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/setting/member/selector/q;", "d", "Lcom/tencent/mobileqq/guild/setting/member/selector/q;", "memberListCallback", "<init>", "(Lcom/tencent/mobileqq/guild/setting/member/selector/q;)V", "e", "a", "MyViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberAdapterDelegate extends AbsListItemAdapterDelegate<MemberData, com.tencent.mobileqq.guild.setting.member.selector.a, MyViewHolder> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q memberListCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/adapterdelegates/GuildMemberAdapterDelegate$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/setting/member/selector/s;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "Lvp1/bz;", "E", "Lvp1/bz;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lvp1/bz;", "binding", "<init>", "(Lvp1/bz;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class MyViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final bz binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyViewHolder(@NotNull bz binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x010f  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0152  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00f7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void l(@NotNull final MemberData item) {
            int i3;
            int nameColor;
            String medalUrl;
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(item, "item");
            this.binding.getRoot().setTag(item);
            this.binding.f442636d.setAvatarTinyId(item.getGuildId(), item.getTinyId());
            ImageView imageView = this.binding.f442635c;
            GradientDrawable gradientDrawable = new GradientDrawable();
            boolean z18 = true;
            gradientDrawable.setShape(1);
            gradientDrawable.setStroke(bi.a(0.5f), this.binding.getRoot().getResources().getColorStateList(R.color.qui_common_border_standard));
            imageView.setBackground(gradientDrawable);
            ImageView imageView2 = this.binding.f442644l;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.itemOnlineIcon");
            if (item.getIsOnline()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView2.setVisibility(i3);
            this.binding.f442641i.setText(item.getName());
            if (item.getNameColor() == 0) {
                nameColor = this.binding.getRoot().getResources().getColor(R.color.qui_common_text_primary);
            } else {
                nameColor = item.getNameColor();
            }
            this.binding.f442641i.setTextColor(nameColor);
            if (item.getPlateData() != null) {
                if (item.getPlateData().length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    byte[] plateData = item.getPlateData();
                    Resources resources = this.binding.getRoot().getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "binding.root.resources");
                    Drawable c16 = ig1.a.c("", plateData, resources);
                    if (c16 == null) {
                        this.binding.f442643k.setVisibility(8);
                    } else {
                        this.binding.f442643k.setVisibility(0);
                        this.binding.f442643k.setImageDrawable(c16);
                    }
                    medalUrl = item.getMedalUrl();
                    if (medalUrl == null && medalUrl.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        this.binding.f442642j.setVisibility(8);
                    } else {
                        this.binding.f442642j.setVisibility(0);
                        u.q(item.getMedalUrl(), this.binding.f442642j, true);
                    }
                    if (item.getIdentityInfo() == null) {
                        this.binding.f442640h.setVisibility(0);
                        this.binding.f442640h.a(item.getIdentityInfo());
                    } else {
                        String identityDes = item.getIdentityDes();
                        if (identityDes != null && identityDes.length() != 0) {
                            z18 = false;
                        }
                        if (!z18) {
                            this.binding.f442640h.setVisibility(0);
                            this.binding.f442640h.b(item.getIdentityDes());
                        } else {
                            this.binding.f442640h.setVisibility(8);
                        }
                    }
                    if (!item.getIsRobot()) {
                        this.binding.f442645m.setVisibility(0);
                        this.binding.f442638f.setVisibility(8);
                    } else {
                        this.binding.f442645m.setVisibility(8);
                        if (item.getRoleInfo() == null) {
                            this.binding.f442638f.setVisibility(8);
                        } else {
                            this.binding.f442638f.setTag(item.getTinyId());
                            GuildLevelRoleView.INSTANCE.b(item.getRoleInfo(), "GuildMemberAdapterDelegate", new Function1<GuildLevelRoleView.UIData, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.selector.adapterdelegates.GuildMemberAdapterDelegate$MyViewHolder$bind$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(GuildLevelRoleView.UIData uIData) {
                                    invoke2(uIData);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull GuildLevelRoleView.UIData uiData) {
                                    Intrinsics.checkNotNullParameter(uiData, "uiData");
                                    if (Intrinsics.areEqual(GuildMemberAdapterDelegate.MyViewHolder.this.getBinding().f442638f.getTag(), item.getTinyId())) {
                                        GuildMemberAdapterDelegate.MyViewHolder.this.getBinding().f442638f.s(uiData);
                                    }
                                }
                            });
                        }
                    }
                    ac.d(ch.m(), this.binding.f442637e, item.getManagementTag(), item.getIsRobot());
                }
            }
            this.binding.f442643k.setVisibility(8);
            medalUrl = item.getMedalUrl();
            if (medalUrl == null) {
            }
            z16 = true;
            if (!z16) {
            }
            if (item.getIdentityInfo() == null) {
            }
            if (!item.getIsRobot()) {
            }
            ac.d(ch.m(), this.binding.f442637e, item.getManagementTag(), item.getIsRobot());
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final bz getBinding() {
            return this.binding;
        }
    }

    public GuildMemberAdapterDelegate(@NotNull q memberListCallback) {
        Intrinsics.checkNotNullParameter(memberListCallback, "memberListCallback");
        this.memberListCallback = memberListCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(GuildMemberAdapterDelegate this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.onClick(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getTag() instanceof MemberData) {
            Object tag = v3.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.member.selector.MemberData");
            this.memberListCallback.W2((MemberData) tag);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull com.tencent.mobileqq.guild.setting.member.selector.a item, @NotNull List<? extends com.tencent.mobileqq.guild.setting.member.selector.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MemberData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull MemberData item, @NotNull MyViewHolder holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.l(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public MyViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bz g16 = bz.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        MyViewHolder myViewHolder = new MyViewHolder(g16);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.member.selector.adapterdelegates.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMemberAdapterDelegate.s(GuildMemberAdapterDelegate.this, view);
            }
        });
        return myViewHolder;
    }
}
