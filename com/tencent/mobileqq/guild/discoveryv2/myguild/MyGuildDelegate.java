package com.tencent.mobileqq.guild.discoveryv2.myguild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildContactApi;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildAdapter;
import com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildRecommendItemDelegate;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import com.tencent.qqnt.widget.SwipeMenuLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.cb;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J&\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J,\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\fH\u0014R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/j;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildAdapter$b;", "Lvp1/cb;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", ReportConstant.COSTREPORT_PREFIX, "binding", "", "w", "", "items", "", "position", "r", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "v", "holder", "", "payloads", "t", "Lcom/tencent/mobileqq/guild/q;", "d", "Lcom/tencent/mobileqq/guild/q;", "iChangeTopCallback", "<init>", "(Lcom/tencent/mobileqq/guild/q;)V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MyGuildDelegate extends AbsListItemAdapterDelegate<MyGuildData, h, MyGuildAdapter.b<cb>> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.q iChangeTopCallback;

    public MyGuildDelegate(@NotNull com.tencent.mobileqq.guild.q iChangeTopCallback) {
        Intrinsics.checkNotNullParameter(iChangeTopCallback, "iChangeTopCallback");
        this.iChangeTopCallback = iChangeTopCallback;
    }

    private final boolean s(MyGuildData item) {
        if (com.tencent.mobileqq.guild.util.o.c("MyGuildDelegate")) {
            return false;
        }
        boolean j06 = ch.j0(item.getGuildId());
        QLog.i("MyGuildDelegate", 1, "jumpGuildOnFullStandalone, guildId:" + item.getGuildId() + ", isGuest:" + j06);
        if (!j06) {
            return true;
        }
        BaseApplication baseApplication = BaseApplication.context;
        QQToast.makeText(baseApplication, 1, baseApplication.getString(R.string.yv5), 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MyGuildDelegate this$0, MyGuildData item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (this$0.s(item)) {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(item.getGuildId(), "", "", "", "");
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            GuildJumpUtil.n(context, jumpGuildParam);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w(final MyGuildData item, cb binding) {
        LinearLayout linearLayout = binding.f442672e;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.listItem");
        Context context = linearLayout.getContext();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.qqnt.chats.core.report.a aVar = com.tencent.qqnt.chats.core.report.a.f354861a;
        linkedHashMap.put("menu_action_item", Integer.valueOf(aVar.d(R.id.eqe)));
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("menu_action_item", Integer.valueOf(aVar.d(R.id.epu)));
        TextView textView = binding.f442674g;
        DTChatsConst.d dVar = DTChatsConst.d.f354830b;
        VideoReport.setElementId(textView, dVar.a());
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(textView, clickPolicy);
        TextView textView2 = binding.f442673f;
        VideoReport.setElementId(textView2, dVar.a());
        VideoReport.setElementClickPolicy(textView2, clickPolicy);
        if (item.getIsTop()) {
            TextView textView3 = binding.f442674g;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.rightMenuPin");
            textView3.setVisibility(8);
            TextView textView4 = binding.f442673f;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.rightMenuCancelPin");
            textView4.setVisibility(0);
            binding.f442673f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyGuildDelegate.x(MyGuildData.this, this, linkedHashMap2, view);
                }
            });
            QUIListItemBackgroundType.Companion companion = QUIListItemBackgroundType.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            linearLayout.setBackground(companion.a(context, 1000, R.color.qui_common_overlay_light, 0.0f, 0.0f));
        } else {
            TextView textView5 = binding.f442674g;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.rightMenuPin");
            textView5.setVisibility(0);
            TextView textView6 = binding.f442673f;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.rightMenuCancelPin");
            textView6.setVisibility(8);
            binding.f442674g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyGuildDelegate.y(MyGuildData.this, this, linkedHashMap, view);
                }
            });
            QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.FullWidth;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            linearLayout.setBackground(qUIListItemBackgroundType.getBackground(context, 1000));
        }
        binding.getRoot().setSwipeListener(new b(item, binding, linkedHashMap2, linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(MyGuildData item, MyGuildDelegate this$0, Map cancelTopReportParam, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cancelTopReportParam, "$cancelTopReportParam");
        ((IGuildContactApi) QRoute.api(IGuildContactApi.class)).changeGuildTop(item.getGuildId(), false, this$0.iChangeTopCallback);
        VideoReport.reportEvent("clck", view, cancelTopReportParam);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(MyGuildData item, MyGuildDelegate this$0, Map topReportParam, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(topReportParam, "$topReportParam");
        ((IGuildContactApi) QRoute.api(IGuildContactApi.class)).changeGuildTop(item.getGuildId(), true, this$0.iChangeTopCallback);
        VideoReport.reportEvent("clck", view, topReportParam);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull h item, @NotNull List<h> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof MyGuildData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull final MyGuildData item, @NotNull MyGuildAdapter.b<cb> holder, @NotNull List<Object> payloads) {
        boolean z16;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        cb l3 = holder.l();
        LinearLayout linearLayout = l3.f442672e;
        linearLayout.setTag(item.getGuildId());
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyGuildDelegate.u(MyGuildDelegate.this, item, view);
            }
        });
        VideoReport.setElementReuseIdentifier(linearLayout, "MyGuildData" + item.hashCode());
        VideoReport.setElementId(linearLayout, "em_sgrp_channel_list");
        VideoReport.setElementClickPolicy(linearLayout, ClickPolicy.REPORT_ALL);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_channel_id", item.getGuildId());
        VideoReport.setElementParams(linearLayout, linkedHashMap);
        w(item, l3);
        l3.f442671d.setText(item.getTitle());
        com.tencent.mobileqq.guild.util.v vVar = com.tencent.mobileqq.guild.util.v.f235697a;
        String avatarUrl = item.getAvatarUrl();
        RoundImageView roundImageView = l3.f442669b;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildAvatar");
        vVar.j(avatarUrl, roundImageView, new Function1<Option, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildDelegate$onBindViewHolder$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Option option) {
                invoke2(option);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Option loadImage) {
                Intrinsics.checkNotNullParameter(loadImage, "$this$loadImage");
                loadImage.setFailedDrawableColor(0);
                loadImage.setLoadingDrawableColor(0);
            }
        });
        String description = item.getDescription();
        if (description != null && description.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            TextView textView = l3.f442670c;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.guildDescription");
            textView.setVisibility(8);
        } else {
            TextView textView2 = l3.f442670c;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.guildDescription");
            textView2.setVisibility(0);
            l3.f442670c.setText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(item.getDescription(), 16));
        }
        if (item.getIsCreatedByMe()) {
            MyGuildRecommendItemDelegate.Companion companion = MyGuildRecommendItemDelegate.INSTANCE;
            TextView textView3 = l3.f442671d;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.guildTitle");
            companion.d(R.drawable.guild_created_by_me_tag, textView3);
            return;
        }
        MyGuildRecommendItemDelegate.Companion companion2 = MyGuildRecommendItemDelegate.INSTANCE;
        String officialIconUrl = item.getOfficialIconUrl();
        String title = item.getTitle();
        TextView textView4 = l3.f442671d;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.guildTitle");
        companion2.e(officialIconUrl, title, textView4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public MyGuildAdapter.b<cb> d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        cb g16 = cb.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        TextView textView = g16.f442671d;
        textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_primary));
        TextView textView2 = g16.f442670c;
        textView2.setTextColor(textView2.getResources().getColorStateList(R.color.qui_common_text_secondary));
        return new MyGuildAdapter.b<>(g16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildDelegate$b", "Lcom/tencent/qqnt/widget/SwipeMenuLayout$e;", "", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements SwipeMenuLayout.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MyGuildData f217510a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cb f217511b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f217512c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f217513d;

        b(MyGuildData myGuildData, cb cbVar, Map<String, Object> map, Map<String, Object> map2) {
            this.f217510a = myGuildData;
            this.f217511b = cbVar;
            this.f217512c = map;
            this.f217513d = map2;
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void a() {
            TextView textView;
            Map<String, Object> map;
            if (this.f217510a.getIsTop()) {
                textView = this.f217511b.f442673f;
            } else {
                textView = this.f217511b.f442674g;
            }
            if (this.f217510a.getIsTop()) {
                map = this.f217512c;
            } else {
                map = this.f217513d;
            }
            VideoReport.reportEvent("imp", textView, map);
        }

        @Override // com.tencent.qqnt.widget.SwipeMenuLayout.e
        public void b() {
        }
    }
}
