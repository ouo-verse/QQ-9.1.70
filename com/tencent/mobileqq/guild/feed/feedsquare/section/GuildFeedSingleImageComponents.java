package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 /2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u000201B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b-\u0010.J&\u0010\f\u001a\u00020\u000b2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J,\u0010\u0017\u001a\u00020\u000b2\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b\u0019\u0010\"\"\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\u001d\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lqj1/l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IMediaDisplayable;", "stImage", "", "sameFeedIdentity", "", "isShareCard", "", "c", "", "f", "Landroid/view/View;", "containerView", tl.h.F, "data", "", "position", "", "payload", "g", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "depends", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "e", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "mSingleImageContainerLayout", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "j", "(Landroid/widget/ImageView;)V", "mImageView", "Landroid/view/View;", "mGifLabel", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "i", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "mediaSizeUtils", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSingleImageComponents extends a<qj1.h> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCornerLayout mSingleImageContainerLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public ImageView mImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View mGifLabel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaSizeUtils;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSingleImageComponents$b;", "", "Landroid/widget/ImageView;", "image", "", "c", "Landroid/view/View;", "imageView", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        @Nullable
        Object a();

        void b(@NotNull View imageView);

        void c(@NotNull ImageView image);
    }

    public GuildFeedSingleImageComponents(@NotNull b depends) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AbsGuildFeedMediaSizeUtils>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSingleImageComponents$mediaSizeUtils$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AbsGuildFeedMediaSizeUtils invoke() {
                RoundCornerLayout roundCornerLayout;
                roundCornerLayout = GuildFeedSingleImageComponents.this.mSingleImageContainerLayout;
                if (roundCornerLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSingleImageContainerLayout");
                    roundCornerLayout = null;
                }
                return com.tencent.mobileqq.guild.feed.feedsquare.utils.g.b(roundCornerLayout);
            }
        });
        this.mediaSizeUtils = lazy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0071, code lost:
    
        if (r5.getMeasuredHeight() != r3) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void c(qj1.l stImage, Object sameFeedIdentity, boolean isShareCard) {
        Pair<Integer, Integer> f16;
        String str;
        int i3;
        Pair pair = TuplesKt.to(Integer.valueOf(stImage.getWidth()), Integer.valueOf(stImage.getHeight()));
        if (isShareCard) {
            f16 = e().h();
        } else {
            f16 = e().f(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
        }
        int intValue = f16.component1().intValue();
        int intValue2 = f16.component2().intValue();
        RoundCornerLayout roundCornerLayout = this.mSingleImageContainerLayout;
        View view = null;
        if (roundCornerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleImageContainerLayout");
            roundCornerLayout = null;
        }
        if (roundCornerLayout.getMeasuredWidth() == intValue) {
            RoundCornerLayout roundCornerLayout2 = this.mSingleImageContainerLayout;
            if (roundCornerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSingleImageContainerLayout");
                roundCornerLayout2 = null;
            }
        }
        RoundCornerLayout roundCornerLayout3 = this.mSingleImageContainerLayout;
        if (roundCornerLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleImageContainerLayout");
            roundCornerLayout3 = null;
        }
        ViewGroup.LayoutParams layoutParams = roundCornerLayout3.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = intValue;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = intValue2;
            roundCornerLayout3.setLayoutParams(layoutParams2);
            if (QLog.isDebugVersion()) {
                QLog.d("GuildFeedSquareSingleImageSection", 4, "origin: " + pair + " adjust:" + intValue + "-" + intValue2 + " url:" + stImage.getPicUrl());
            }
            ImageView d16 = d();
            String picUrl = stImage.getPicUrl();
            Pair pair2 = TuplesKt.to(Integer.valueOf(intValue), Integer.valueOf(intValue2));
            if (sameFeedIdentity != null) {
                str = sameFeedIdentity + "_image";
            } else {
                str = null;
            }
            GuildFeedListImageExKt.g(d16, picUrl, pair2, str, GuildFeedListImageExKt.c(d()), null, false, false, true, null, 368, null);
            View view2 = this.mGifLabel;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGifLabel");
            } else {
                view = view2;
            }
            if (stImage.getType() == 3) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final AbsGuildFeedMediaSizeUtils e() {
        return (AbsGuildFeedMediaSizeUtils) this.mediaSizeUtils.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildFeedSingleImageComponents this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.depends.c(this$0.d());
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final ImageView d() {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        return null;
    }

    @NotNull
    public int[] f() {
        return new int[]{R.id.wb7};
    }

    public void g(@NotNull qj1.h data, int position, @Nullable List<Object> payload) {
        Object firstOrNull;
        String id5;
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) data.c());
        qj1.l lVar = (qj1.l) firstOrNull;
        RoundCornerLayout roundCornerLayout = null;
        if (lVar != null) {
            RoundCornerLayout roundCornerLayout2 = this.mSingleImageContainerLayout;
            if (roundCornerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSingleImageContainerLayout");
            } else {
                roundCornerLayout = roundCornerLayout2;
            }
            boolean z17 = false;
            roundCornerLayout.setVisibility(0);
            d().setContentDescription(QQGuildUIUtil.r(R.string.f146620uo));
            Object a16 = this.depends.a();
            GProThirdBar G = data.G();
            if (G != null && (id5 = G.f359315id) != null) {
                Intrinsics.checkNotNullExpressionValue(id5, "id");
                if (id5.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            c(lVar, a16, z17);
        } else {
            RoundCornerLayout roundCornerLayout3 = this.mSingleImageContainerLayout;
            if (roundCornerLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSingleImageContainerLayout");
            } else {
                roundCornerLayout = roundCornerLayout3;
            }
            roundCornerLayout.setVisibility(8);
        }
        this.depends.b(d());
    }

    public void h(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.wb6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026item_single_image_layout)");
        this.mSingleImageContainerLayout = (RoundCornerLayout) findViewById;
        float dpToPx = ViewUtils.dpToPx(6.0f);
        RoundCornerLayout roundCornerLayout = this.mSingleImageContainerLayout;
        if (roundCornerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleImageContainerLayout");
            roundCornerLayout = null;
        }
        roundCornerLayout.setRadius(dpToPx, dpToPx, dpToPx, dpToPx);
        View findViewById2 = containerView.findViewById(R.id.f165499wb4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026d_feed_item_single_image)");
        j((ImageView) findViewById2);
        View findViewById3 = containerView.findViewById(R.id.w9p);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026.id.guild_feed_gif_label)");
        this.mGifLabel = findViewById3;
        d().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildFeedSingleImageComponents.i(GuildFeedSingleImageComponents.this, view);
            }
        });
    }

    public final void j(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mImageView = imageView;
    }
}
