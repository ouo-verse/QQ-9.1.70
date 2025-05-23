package com.tencent.mobileqq.guild.feed.topic.part;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.topic.mvi.MainState;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicInfoPart;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicBasePart;", "", "guildId", "Landroid/widget/TextView;", "guildName", "Landroid/widget/ImageView;", "guildAvatar", "", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicInfoPart extends TopicBasePart {
    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(String guildId, TextView guildName, ImageView guildAvatar) {
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(guildId);
        if (guildInfo == null) {
            return;
        }
        guildName.setText(getContext().getResources().getString(R.string.f158021oh) + guildInfo.getGuildName());
        String url = guildInfo.getAvatarUrl(100);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        com.tencent.mobileqq.guild.util.v.l(url, guildAvatar, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(TopicInfoPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, this$0.getPartHost().getHostActivity(), false, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.jua);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.topic_name)");
        final TextView textView = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f100305s5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.topic_feeds_count)");
        final TextView textView2 = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f100325s7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.topic_guild)");
        final TextView textView3 = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.vzu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.guild_avatar)");
        final ImageView imageView = (ImageView) findViewById4;
        LiveData<MainState> X1 = A9().X1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<MainState, Unit> function1 = new Function1<MainState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicInfoPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MainState mainState) {
                invoke2(mainState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MainState mainState) {
                TextView textView4;
                textView.setText(mainState.getTopicName());
                if (!Intrinsics.areEqual(mainState.getTotalFeedNum(), "0") && (textView4 = textView2) != null) {
                    textView4.setText(this.getContext().getResources().getString(R.string.f158001of, mainState.getTotalFeedNum()));
                }
                this.E9(mainState.getGuildId(), textView3, imageView);
            }
        };
        X1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicInfoPart.F9(Function1.this, obj);
            }
        });
        rootView.findViewById(R.id.t2o).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.topic.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicInfoPart.G9(TopicInfoPart.this, view);
            }
        });
        if1.a.b(textView, "em_sgrp_source", null, null, ExposurePolicy.REPORT_ALL, ClickPolicy.REPORT_ALL, null, null, null, 230, null);
    }
}
