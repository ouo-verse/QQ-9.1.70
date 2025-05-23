package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.SpanClickHandler;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0014J4\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/g;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "feedDetail", "", HippyTKDListViewAdapter.X, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "", "position", "", "", "payloads", "t", "Landroidx/constraintlayout/widget/ConstraintLayout;", "d", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "readingVolumeTv", "f", "publishTimeTv", tl.h.F, "channelNameTv", "i", "Landroid/view/View;", "channelInfoLayout", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "rightIcon", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends e {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private JumpGuildParam.JoinInfoParam joinInfoParam;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView readingVolumeTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView publishTimeTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView channelNameTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View channelInfoLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView rightIcon;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void w(g this$0, View view, View view2) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedDetailMainData feedDetailMainData = (FeedDetailMainData) this$0.mData;
        if (feedDetailMainData != null) {
            SpanClickHandler spanClickHandler = SpanClickHandler.f221406a;
            String valueOf = String.valueOf(feedDetailMainData.getFeedDetail().getGuildId());
            String valueOf2 = String.valueOf(feedDetailMainData.getFeedDetail().getChannelId());
            Boolean valueOf3 = Boolean.valueOf(feedDetailMainData.getFeedDetail().B());
            JumpGuildParam.JoinInfoParam joinInfoParam = this$0.joinInfoParam;
            Intrinsics.checkNotNullExpressionValue(view, "this");
            rl1.a p16 = this$0.p();
            if (p16 == null || (str = p16.getTraceId()) == null) {
                str = "";
            }
            SpanClickHandler.h(spanClickHandler, valueOf, valueOf2, valueOf3, joinInfoParam, view, str, false, 64, null);
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    private final boolean x(qj1.h feedDetail) {
        boolean z16;
        rl1.a p16;
        boolean z17;
        Integer businessType;
        String str;
        boolean z18;
        boolean B = feedDetail.B();
        if (ch.j0(String.valueOf(feedDetail.getGuildId()))) {
            JumpGuildParam.JoinInfoParam joinInfoParam = this.joinInfoParam;
            if (joinInfoParam != null) {
                str = joinInfoParam.getJoinSignature();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                z16 = true;
                p16 = p();
                if (p16 == null && (businessType = p16.getBusinessType()) != null && businessType.intValue() == 7) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!B || z16 || z17) {
                    return true;
                }
                return false;
            }
        }
        z16 = false;
        p16 = p();
        if (p16 == null) {
        }
        z17 = false;
        return !B ? true : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v1a};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.v1y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026il_main_bottom_container)");
        this.container = (ConstraintLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.ta8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026id.bottom_reading_volume)");
        this.readingVolumeTv = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.ta6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026R.id.bottom_publish_time)");
        this.publishTimeTv = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.wrw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.guild_name)");
        this.channelNameTv = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.vzu);
        ImageView imageView = (ImageView) findViewById5;
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_section_icon, Integer.valueOf(R.color.qui_common_text_primary)));
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026)\n            )\n        }");
        this.rightIcon = imageView;
        final View findViewById6 = containerView.findViewById(R.id.w_0);
        findViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.w(g.this, findViewById6, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026)\n            }\n        }");
        this.channelInfoLayout = findViewById6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    public boolean q(@NotNull FeedDetailMainData.c.C7755c payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (super.q(payload) || payload.getType() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View] */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        if (data == 0) {
            return;
        }
        this.mData = data;
        rl1.a p16 = p();
        TextView textView = null;
        if (p16 != null) {
            joinInfoParam = p16.b();
        } else {
            joinInfoParam = null;
        }
        this.joinInfoParam = joinInfoParam;
        TextView textView2 = this.readingVolumeTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("readingVolumeTv");
            textView2 = null;
        }
        textView2.setText(data.getFeedDetail().I());
        TextView textView3 = this.publishTimeTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishTimeTv");
            textView3 = null;
        }
        textView3.setText(data.getFeedDetail().J());
        if (!x(data.getFeedDetail()) && !MiscKt.f(data.getFeedDetail().q())) {
            View view = this.channelInfoLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelInfoLayout");
                view = null;
            }
            view.setVisibility(0);
            TextView textView4 = this.channelNameTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelNameTv");
            } else {
                textView = textView4;
            }
            textView.setText(data.getFeedDetail().q());
            return;
        }
        ?? r16 = this.channelInfoLayout;
        if (r16 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoLayout");
        } else {
            textView = r16;
        }
        textView.setVisibility(8);
    }
}
