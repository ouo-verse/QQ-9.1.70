package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedVideoPlayManager;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.FeedRichTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class LongFeedMainTextSection$textViewContainer$2 extends Lambda implements Function0<TextViewContainer> {
    final /* synthetic */ LongFeedMainTextSection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongFeedMainTextSection$textViewContainer$2(LongFeedMainTextSection longFeedMainTextSection) {
        super(0);
        this.this$0 = longFeedMainTextSection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(TextViewContainer this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        mk1.e eVar = mk1.e.f416895a;
        Context context = this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        eVar.l(50L, context);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LongFeedVideoPlayManager e(LongFeedMainTextSection this$0) {
        LongFeedVideoPlayManager H;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        H = this$0.H();
        return H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qj1.h f(LongFeedMainTextSection this$0) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        obj = ((Section) this$0).mData;
        return ((FeedDetailMainData) obj).getFeedDetail();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final TextViewContainer invoke() {
        View view;
        View view2;
        TransitionHelper.TransitionBeanCreator transitionBeanCreator;
        view = ((Section) this.this$0).mRootView;
        Context context = view.getContext();
        view2 = ((Section) this.this$0).mRootView;
        Context context2 = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "mRootView.context");
        final TextViewContainer textViewContainer = new TextViewContainer(context, null, 0, 0, new FeedRichTextView(context2));
        textViewContainer.s().setId(R.id.f165512we2);
        textViewContainer.s().setClickable(false);
        textViewContainer.s().setFocusable(false);
        textViewContainer.s().setTextIsSelectable(true);
        textViewContainer.s().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.r
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                boolean d16;
                d16 = LongFeedMainTextSection$textViewContainer$2.d(TextViewContainer.this, view3);
                return d16;
            }
        });
        textViewContainer.s().setLineSpacing(26.0f, 1.0f);
        textViewContainer.s().setTextSize(18.0f);
        textViewContainer.s().setLetterSpacing(0.01875f);
        textViewContainer.s().setBreakStrategy(0);
        textViewContainer.s().setTextColor(textViewContainer.getContext().getResources().getColorStateList(R.color.qui_common_text_primary));
        final LongFeedMainTextSection longFeedMainTextSection = this.this$0;
        RFWIocAbilityProvider.g().registerIoc(textViewContainer, new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.s
            @Override // androidx.core.util.Supplier
            public final LongFeedVideoPlayManager get() {
                LongFeedVideoPlayManager e16;
                e16 = LongFeedMainTextSection$textViewContainer$2.e(LongFeedMainTextSection.this);
                return e16;
            }
        }, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f.class);
        RFWIocAbilityProvider.g().registerIoc(textViewContainer, new qj1.i() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.t
            @Override // androidx.core.util.Supplier
            public final qj1.h get() {
                qj1.h f16;
                f16 = LongFeedMainTextSection$textViewContainer$2.f(LongFeedMainTextSection.this);
                return f16;
            }
        }, qj1.i.class);
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        transitionBeanCreator = longFeedMainTextSection.transitionBeanCreator;
        g16.registerIoc(textViewContainer, transitionBeanCreator, TransitionHelper.TransitionBeanCreator.class);
        return textViewContainer;
    }
}
