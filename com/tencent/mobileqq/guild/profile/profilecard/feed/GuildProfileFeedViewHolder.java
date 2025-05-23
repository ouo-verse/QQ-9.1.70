package com.tencent.mobileqq.guild.profile.profilecard.feed;

import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildCustomUnderlinedTextView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0007J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "url", "", "o", "u", "t", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/g;", "feedItem", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function0;", NodeProps.ON_CLICK, "p", "", "width", "height", DomainData.DOMAIN_NAME, "position", "count", "r", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "E", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "feedItemContainer", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "feedImageIV", "Lcom/tencent/mobileqq/guild/widget/GuildCustomUnderlinedTextView;", "G", "Lcom/tencent/mobileqq/guild/widget/GuildCustomUnderlinedTextView;", "feedContentTV", "H", "feedVideoPlayIconIV", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileFeedViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int J = R.id.wu5;

    @NotNull
    private static final Lazy<Float> K;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RoundCornerLayout feedItemContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ImageView feedImageIV;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GuildCustomUnderlinedTextView feedContentTV;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ImageView feedVideoPlayIconIV;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedViewHolder$a;", "", "", "imageRadius$delegate", "Lkotlin/Lazy;", "a", "()F", "imageRadius", "FEED_ITEM_RADIUS_DP", UserInfo.SEX_FEMALE, "", "IMAGE_ID", "I", "PROFILE_FEED_EMOJI_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedViewHolder$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return ((Number) GuildProfileFeedViewHolder.K.getValue()).floatValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Float> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedViewHolder$Companion$imageRadius$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Float invoke() {
                return Float.valueOf(ViewUtils.dpToPx(8.0f));
            }
        });
        K = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileFeedViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.f165594wu4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.guild_profile_feed_item)");
        this.feedItemContainer = (RoundCornerLayout) findViewById;
        View findViewById2 = itemView.findViewById(J);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(IMAGE_ID)");
        this.feedImageIV = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.wu6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026d_profile_feed_item_text)");
        this.feedContentTV = (GuildCustomUnderlinedTextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.wu7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026d_profile_feed_play_icon)");
        this.feedVideoPlayIconIV = (ImageView) findViewById4;
    }

    private final void o(String url) {
        String str;
        String d16 = com.tencent.mobileqq.guild.picload.e.d(url);
        Object tag = this.feedImageIV.getTag(R.id.wu5);
        if (tag instanceof String) {
            str = (String) tag;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (Intrinsics.areEqual(d16, str)) {
            return;
        }
        this.feedImageIV.setTag(J, d16);
        this.feedImageIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawable = ContextCompat.getDrawable(this.feedImageIV.getContext(), R.drawable.f162601b70);
        this.feedImageIV.setImageDrawable(drawable);
        ViewGroup.LayoutParams layoutParams = this.feedImageIV.getLayoutParams();
        Logger.f235387a.d().d("Guild.profile.GuildProfileFeedViewHolder", 1, "[loadPic] url " + url);
        com.tencent.mobileqq.guild.picload.e.a().e(Option.obtain().setTargetView(this.feedImageIV).setLoadingDrawable(drawable).setUrl(url).setRequestHeight(layoutParams.height).setRequestWidth(layoutParams.width).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565));
        ImageView imageView = this.feedImageIV;
        imageView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(imageView.getContext(), R.animator.f155134n));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 onClick, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        Logger.f235387a.d().d("Guild.profile.GuildProfileFeedViewHolder", 1, "[setItemClickListener] feedItemContainer onClick");
        onClick.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void n(int width, int height) {
        Logger.f235387a.d().d("Guild.profile.GuildProfileFeedViewHolder", 1, "[adjustItemSize] width " + width + ", height " + height);
        ViewGroup.LayoutParams layoutParams = this.feedItemContainer.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(width, height);
        }
        layoutParams.width = width;
        layoutParams.height = height;
        this.feedItemContainer.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.feedImageIV.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(width, height);
        }
        layoutParams2.width = width;
        layoutParams2.height = height;
        this.feedImageIV.setLayoutParams(layoutParams2);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void p(@NotNull final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.feedItemContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildProfileFeedViewHolder.q(Function0.this, view);
            }
        });
    }

    public final void r(int position, int count) {
        boolean z16;
        float f16;
        float f17;
        float f18;
        boolean z17 = false;
        if (position == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (position == count - 1) {
            z17 = true;
        }
        float f19 = 0.0f;
        if (z16) {
            f16 = INSTANCE.a();
        } else {
            f16 = 0.0f;
        }
        if (z16) {
            f17 = INSTANCE.a();
        } else {
            f17 = 0.0f;
        }
        if (z17) {
            f18 = INSTANCE.a();
        } else {
            f18 = 0.0f;
        }
        if (z17) {
            f19 = INSTANCE.a();
        }
        this.feedItemContainer.setRadius(f16, f18, f19, f17);
    }

    public final void s(@NotNull ProfileFeedItem feedItem) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(feedItem, "feedItem");
        this.feedVideoPlayIconIV.setVisibility(8);
        this.feedContentTV.setVisibility(0);
        this.feedImageIV.setTag(J, "");
        this.feedImageIV.setStateListAnimator(null);
        this.feedImageIV.setBackgroundResource(R.drawable.guild_profile_list_item_text_place);
        ArrayList<GProStRichTextContent> arrayList = feedItem.getFeed().contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "feedItem.feed.contents.contents");
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                z16 = true;
                if (((GProStRichTextContent) it.next()).type == 4) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            this.feedContentTV.setPadding(0, 0, 0, ScreenUtil.dip2px(2.0f));
            this.feedContentTV.setText(new QQText(feedItem.getFeedText(), 3, 14));
        } else {
            this.feedContentTV.setPadding(0, 0, 0, 0);
            this.feedContentTV.setText(feedItem.getFeedText().toString());
        }
    }

    public final void t(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        o(url);
        this.feedContentTV.setVisibility(8);
        this.feedVideoPlayIconIV.setVisibility(8);
    }

    public final void u(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        o(url);
        this.feedVideoPlayIconIV.setVisibility(0);
        this.feedContentTV.setVisibility(8);
    }
}
