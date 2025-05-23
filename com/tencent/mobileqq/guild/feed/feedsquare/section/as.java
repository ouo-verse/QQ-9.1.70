package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 12\u0010\u0012\f\u0012\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0001:\u00022\u0006B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b/\u00100J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J0\u0010\u0017\u001a\u00020\u000b2\u000e\u0010\u0012\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010\"R\u0016\u0010.\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010&\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/as;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lqj1/r;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IThirdPartyMediaDisplayable;", "Lkotlin/Pair;", "", "b", "", "url", "measuredWidth", "measuredHeight", "", "c", "", "d", "Landroid/view/View;", "containerView", "g", "data", "position", "", "", "payload", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/as$b;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/as$b;", "getDepends", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/as$b;", "depends", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "mVideoContainerLayout", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mVideoTime", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mVideoCover", "i", "Landroid/view/View;", "mPlatform", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mPlatformName", BdhLogUtil.LogTag.Tag_Conn, "mPlatformIcon", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/as$b;)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class as extends a<qj1.r> {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mPlatformIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCornerLayout mVideoContainerLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mVideoTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mVideoCover;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mPlatform;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mPlatformName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/as$b;", "", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a();
    }

    public as(@NotNull b depends) {
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
    }

    private final Pair<Integer, Integer> b() {
        int roundToInt;
        GuildFeedMediaSizeUtils guildFeedMediaSizeUtils = GuildFeedMediaSizeUtils.f219296d;
        roundToInt = MathKt__MathJVMKt.roundToInt(guildFeedMediaSizeUtils.c());
        RoundCornerLayout roundCornerLayout = this.mVideoContainerLayout;
        if (roundCornerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoContainerLayout");
            roundCornerLayout = null;
        }
        return guildFeedMediaSizeUtils.a(roundCornerLayout, roundToInt, roundToInt);
    }

    private final void c(String url, int measuredWidth, int measuredHeight) {
        String str;
        QLog.i("GuildFeedSquareThirdVideoSection", 1, "bindVideoCover url=" + url + "measuredWidth=" + measuredWidth + "measuredHeight" + measuredHeight);
        String d16 = com.tencent.mobileqq.guild.picload.e.d(url);
        ImageView imageView = this.mVideoCover;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
            imageView = null;
        }
        Object tag = imageView.getTag(R.id.wbe);
        if (tag instanceof String) {
            str = (String) tag;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(d16) && !Intrinsics.areEqual(d16, str)) {
            ImageView imageView3 = this.mVideoCover;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
                imageView3 = null;
            }
            imageView3.setTag(R.id.wbe, d16);
            Option obtain = Option.obtain();
            ImageView imageView4 = this.mVideoCover;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
                imageView4 = null;
            }
            Option requestHeight = obtain.setTargetView(imageView4).setRequestWidth(measuredWidth).setRequestHeight(measuredHeight);
            ImageView imageView5 = this.mVideoCover;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
            } else {
                imageView2 = imageView5;
            }
            com.tencent.mobileqq.guild.picload.e.a().e(requestHeight.setLoadingDrawable(imageView2.getContext().getDrawable(R.drawable.f162601b70)).setUrl(url).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(as this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.depends.a();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public int[] d() {
        return new int[]{R.id.wbg};
    }

    public void e(@Nullable qj1.r data, int position, @Nullable List<Object> payload) {
        boolean isBlank;
        View view = null;
        if (data != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(data.getCover());
            if (!isBlank) {
                Pair<Integer, Integer> b16 = b();
                TextView textView = this.mVideoTime;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoTime");
                    textView = null;
                }
                textView.setText(ax.k(data.getDuration()));
                c(data.getCover(), b16.getFirst().intValue(), b16.getSecond().intValue());
                TextView textView2 = this.mPlatformName;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlatformName");
                    textView2 = null;
                }
                textView2.setText(data.getPlatformName());
                Option obtain = Option.obtain();
                ImageView imageView = this.mPlatformIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPlatformIcon");
                    imageView = null;
                }
                com.tencent.mobileqq.guild.picload.e.a().e(obtain.setTargetView(imageView).setUrl(data.getIcon()).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565));
                RoundCornerLayout roundCornerLayout = this.mVideoContainerLayout;
                if (roundCornerLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoContainerLayout");
                    roundCornerLayout = null;
                }
                roundCornerLayout.setVisibility(0);
                ImageView imageView2 = this.mVideoCover;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVideoCover");
                } else {
                    view = imageView2;
                }
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.ar
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        as.f(as.this, view2);
                    }
                });
                return;
            }
        }
        RoundCornerLayout roundCornerLayout2 = this.mVideoContainerLayout;
        if (roundCornerLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoContainerLayout");
        } else {
            view = roundCornerLayout2;
        }
        view.setVisibility(8);
        QLog.e("GuildFeedSquareThirdVideoSection", 1, "error data");
    }

    public void g(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.wbf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_item_third_video_layout)");
        this.mVideoContainerLayout = (RoundCornerLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.wbh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ed_item_third_video_time)");
        this.mVideoTime = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.wbe);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026d_item_third_video_cover)");
        this.mVideoCover = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f165518wf3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026_third_video_platform_ll)");
        this.mPlatform = findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f165519wf4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026_third_video_platform_tv)");
        this.mPlatformName = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.f165517wf2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026_third_video_platform_iv)");
        this.mPlatformIcon = (ImageView) findViewById6;
        b();
        float dpToPx = ViewUtils.dpToPx(6.0f);
        RoundCornerLayout roundCornerLayout = this.mVideoContainerLayout;
        if (roundCornerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoContainerLayout");
            roundCornerLayout = null;
        }
        roundCornerLayout.setRadius(dpToPx, dpToPx, dpToPx, dpToPx);
    }
}
