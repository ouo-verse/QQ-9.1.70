package com.tencent.mobileqq.guild.feed.topic.part;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.topic.mvi.MainState;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicVisitorJoinPart;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicBasePart;", "", "guildId", "Landroid/view/View;", "joinLayout", "channelSign", "", "K9", "", "isTopicVisitorVisible", "L9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", tl.h.F, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "joinParam", "i", "Landroid/view/View;", "feedContainer", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicVisitorJoinPart extends TopicBasePart {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JumpGuildParam joinParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View feedContainer;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(final TopicVisitorJoinPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        yl1.n.i(null, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicVisitorJoinPart$onInitView$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                JumpGuildParam jumpGuildParam;
                jumpGuildParam = TopicVisitorJoinPart.this.joinParam;
                if (jumpGuildParam != null) {
                    Context context = TopicVisitorJoinPart.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    com.tencent.mobileqq.guild.channel.joinchannel.q.c(context, jumpGuildParam, false, 1, null);
                }
            }
        }, 3, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(String guildId, View joinLayout, String channelSign) {
        boolean z16;
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(guildId);
        int i3 = 0;
        if (guildInfo != null && !guildInfo.isMember() && !guildInfo.getIsBanned() && guildInfo.isVisibleForVisitor()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        joinLayout.setVisibility(i3);
        L9(z16);
        this.joinParam = new JumpGuildParam(guildId, "", channelSign, "topic", "topic_page");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(boolean isTopicVisitorVisible) {
        int b16;
        if (isTopicVisitorVisible) {
            b16 = com.tencent.guild.aio.util.c.b(36);
        } else {
            b16 = com.tencent.guild.aio.util.c.b(70);
        }
        View view = this.feedContainer;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = b16;
                view.setLayoutParams(marginLayoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        final View findViewById = rootView.findViewById(R.id.yac);
        this.feedContainer = rootView.findViewById(R.id.f75513z6);
        LiveData<MainState> X1 = A9().X1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<MainState, Unit> function1 = new Function1<MainState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicVisitorJoinPart$onInitView$1
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
                TopicVisitorJoinPart topicVisitorJoinPart = TopicVisitorJoinPart.this;
                String guildId = mainState.getGuildId();
                View joinLayout = findViewById;
                Intrinsics.checkNotNullExpressionValue(joinLayout, "joinLayout");
                topicVisitorJoinPart.K9(guildId, joinLayout, mainState.getChannelSign());
            }
        };
        X1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicVisitorJoinPart.H9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> q26 = A9().q2();
        LifecycleOwner c17 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicVisitorJoinPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
                this.L9(!it.booleanValue());
            }
        };
        q26.observe(c17, new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicVisitorJoinPart.I9(Function1.this, obj);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.topic.part.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicVisitorJoinPart.J9(TopicVisitorJoinPart.this, view);
            }
        });
        ch.Y0(findViewById, "em_sgrp_bottom_join_channel", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }
}
