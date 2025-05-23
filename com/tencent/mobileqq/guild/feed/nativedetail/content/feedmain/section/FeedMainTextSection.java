package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0014J4\u0010\u0015\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0013H\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/FeedMainTextSection;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "feedDetail", "", "y", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "", "position", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/widget/TextView;", "e", "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Landroid/widget/TextView;", "txtView", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMainTextSection extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy txtView;

    public FeedMainTextSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedMainTextSection$txtView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                View view;
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.f221402a;
                view = ((Section) FeedMainTextSection.this).mRootView;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
                TextView f16 = bVar.f(context);
                GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
                if (guildSplitViewUtils.n(f16.getContext()) && com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
                    f16.getLayoutParams().width = guildSplitViewUtils.i(true, f16.getContext()) - ViewUtils.dpToPx(16.0f);
                }
                return f16;
            }
        });
        this.txtView = lazy;
    }

    private final TextView x() {
        return (TextView) this.txtView.getValue();
    }

    private final void y(qj1.h feedDetail) {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        List listOf;
        String str;
        rl1.a p16 = p();
        ViewGroup viewGroup = null;
        if (p16 != null) {
            joinInfoParam = p16.b();
        } else {
            joinInfoParam = null;
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{6, 7, 8, 9});
        rl1.a aVar = (rl1.a) SectionIOCKt.getIocInterface(this, rl1.a.class);
        if (aVar == null || (str = aVar.getTraceId()) == null) {
            str = "";
        }
        Pair a16 = e.a.a(feedDetail, joinInfoParam, listOf, 0, str, 4, null);
        if (!TextUtils.isEmpty((CharSequence) a16.getFirst())) {
            ViewGroup viewGroup2 = this.container;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            x().setText((CharSequence) a16.getFirst());
            x().setMovementMethod(new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a());
            x().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedMainTextSection.z(view);
                }
            });
            if (x().getParent() == null) {
                ViewGroup viewGroup3 = this.container;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                } else {
                    viewGroup = viewGroup3;
                }
                viewGroup.addView(x());
                return;
            }
            return;
        }
        ViewGroup viewGroup4 = this.container;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            viewGroup = viewGroup4;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v1d};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f165166v22);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026tail_main_text_container)");
        this.container = (ViewGroup) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    public boolean q(@NotNull FeedDetailMainData.c.C7755c payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!super.q(payload) && payload.getType() != 4) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        if (data == 0) {
            return;
        }
        this.mData = data;
        y(data.getFeedDetail());
    }
}
