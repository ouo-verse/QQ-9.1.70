package com.tencent.mobileqq.guild.feed.topic.part;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.feed.topic.mvi.MainState;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicReservePart;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicBasePart;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "Landroid/view/View;", "G9", "", "refresh", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicReservePart extends TopicBasePart {
    /* JADX INFO: Access modifiers changed from: private */
    public final View G9(int statusCode) {
        QLog.i("GTopic_TopicReservePart", 1, "createTipView err=" + statusCode);
        if (statusCode == 0) {
            return null;
        }
        if (statusCode != 10001) {
            if (statusCode != 2) {
                if (statusCode != 3) {
                    if (statusCode != 4) {
                        return null;
                    }
                    QUIEmptyState.Builder builder = new QUIEmptyState.Builder(getContext());
                    builder.setImageType(5);
                    String string = getContext().getString(R.string.f144180o3);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026allery_failed_toast_text)");
                    builder.setTitle(string);
                    builder.setAutoCenter(true);
                    String string2 = getContext().getString(R.string.f148270z5);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026tring.guild_live_refresh)");
                    builder.setButton(string2, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.topic.part.r
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TopicReservePart.I9(TopicReservePart.this, view);
                        }
                    });
                    return builder.build();
                }
                QUIEmptyState.Builder builder2 = new QUIEmptyState.Builder(getContext());
                builder2.setImageType(5);
                String string3 = getContext().getString(R.string.f144630pa);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026eed_net_unavailable_tips)");
                builder2.setTitle(string3);
                builder2.setAutoCenter(true);
                String string4 = getContext().getString(R.string.f148270z5);
                Intrinsics.checkNotNullExpressionValue(string4, "context.getString(com.te\u2026tring.guild_live_refresh)");
                builder2.setButton(string4, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.topic.part.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TopicReservePart.H9(TopicReservePart.this, view);
                    }
                });
                return builder2.build();
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ScanningLightView scanningLightView = new ScanningLightView(context, null, 2, null);
            scanningLightView.setImageResource(R.drawable.guild_feed_topic_skeleton);
            scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
            return scanningLightView;
        }
        QUIEmptyState.Builder builder3 = new QUIEmptyState.Builder(getContext());
        builder3.setImageType(16).setTitle("\u8bdd\u9898\u4e0d\u5b58\u5728\u4e86").setAutoCenter(true);
        return builder3.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(TopicReservePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refresh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(TopicReservePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refresh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(TopicReservePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, this$0.getPartHost().getHostActivity(), false, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void refresh() {
        A9().Z1(new com.tencent.mobileqq.guild.feed.topic.mvi.p());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        final View findViewById = rootView.findViewById(R.id.f100395sd);
        final FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.f100405se);
        rootView.findViewById(R.id.uwp).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.topic.part.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicReservePart.J9(TopicReservePart.this, view);
            }
        });
        LiveData<MainState> X1 = A9().X1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<MainState, Unit> function1 = new Function1<MainState, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicReservePart$onInitView$2
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
                View G9;
                G9 = TopicReservePart.this.G9(mainState.getStatusCode());
                if (G9 != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    View view = findViewById;
                    frameLayout2.removeAllViews();
                    frameLayout2.addView(G9);
                    view.setVisibility(0);
                    return;
                }
                findViewById.setVisibility(8);
            }
        };
        X1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicReservePart.K9(Function1.this, obj);
            }
        });
    }
}
