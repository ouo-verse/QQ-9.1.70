package com.tencent.mobileqq.guild.contentshare.template.content;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.contentshare.h;
import com.tencent.mobileqq.guild.feed.GuildFeedForegroundColorSpan;
import com.tencent.mobileqq.guild.feed.widget.u;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\"\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\u0019\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/template/content/b;", "Lcom/tencent/mobileqq/guild/contentshare/g;", "Landroid/view/ViewGroup;", "msgAreaViewGroup", "", "title", "", "g", "content", "", "hasTitleBefore", "f", "text", h.F, HippyNestedScrollComponent.PRIORITY_PARENT, "", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "mediaInfo", "e", "Landroid/view/View;", "contentView", "c", "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Lcom/tencent/mobileqq/guild/contentshare/h;", "style", "a", "Lcom/tencent/mobileqq/guild/contentshare/f;", "Lcom/tencent/mobileqq/guild/contentshare/f;", "layoutListener", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "Lcom/tencent/mobileqq/guild/contentshare/h$a;", "Lcom/tencent/mobileqq/guild/contentshare/h$a;", "getStyle", "()Lcom/tencent/mobileqq/guild/contentshare/h$a;", "setStyle", "(Lcom/tencent/mobileqq/guild/contentshare/h$a;)V", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "contentTv", "Lcom/tencent/mobileqq/guild/contentshare/template/content/SharePicMediaContentLayout;", "Lcom/tencent/mobileqq/guild/contentshare/template/content/SharePicMediaContentLayout;", "mediaView", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "layoutChangeListener", "<init>", "(Lcom/tencent/mobileqq/guild/contentshare/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements com.tencent.mobileqq.guild.contentshare.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.contentshare.f layoutListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h.MsgContentStyle style;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView contentTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SharePicMediaContentLayout mediaView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnLayoutChangeListener layoutChangeListener;

    public b(@NotNull com.tencent.mobileqq.guild.contentshare.f layoutListener) {
        Intrinsics.checkNotNullParameter(layoutListener, "layoutListener");
        this.layoutListener = layoutListener;
    }

    private final void c(final View contentView) {
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.contentshare.template.content.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                b.d(b.this, contentView, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
        this.layoutChangeListener = onLayoutChangeListener;
        contentView.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0, View contentView, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29;
        int coerceAtLeast;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        if (view.getMeasuredHeight() <= 3800 || this$0.contentTv == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this$0.layoutChangeListener);
        SharePicMediaContentLayout sharePicMediaContentLayout = this$0.mediaView;
        int i36 = 0;
        TextView textView = null;
        if (sharePicMediaContentLayout != null) {
            if (sharePicMediaContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaView");
                sharePicMediaContentLayout = null;
            }
            i29 = sharePicMediaContentLayout.getMeasuredHeight();
        } else {
            i29 = 0;
        }
        int i37 = 3800 - i29;
        SharePicMediaContentLayout sharePicMediaContentLayout2 = this$0.mediaView;
        if (sharePicMediaContentLayout2 != null) {
            if (sharePicMediaContentLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaView");
                sharePicMediaContentLayout2 = null;
            }
            ViewGroup.LayoutParams layoutParams = sharePicMediaContentLayout2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                i36 = marginLayoutParams.topMargin;
            }
        }
        int i38 = i37 - i36;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((int) (i38 / cw.a(21.63f)), 1);
        QLog.d("FeedContentComponent", 1, "maxHeight=3800, mediaContentHeight=" + i29 + ", maxTextHeight=" + i38 + ", maxLines=" + coerceAtLeast);
        TextView textView2 = this$0.contentTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTv");
            textView2 = null;
        }
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView3 = this$0.contentTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTv");
        } else {
            textView = textView3;
        }
        textView.setMaxLines(coerceAtLeast);
        QLog.d("FeedContentComponent", 1, "adjusted contentViewHeight=" + contentView.getMeasuredHeight());
        this$0.layoutListener.b();
    }

    private final void e(ViewGroup parent, List<IFeedDetailDataParser.MediaInfo> mediaInfo) {
        QLog.i("FeedContentComponent", 1, "initMediaAndBind size=" + mediaInfo.size());
        SharePicMediaContentLayout sharePicMediaContentLayout = new SharePicMediaContentLayout(this.context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (parent.getChildCount() > 0) {
            layoutParams.topMargin = ViewUtils.dpToPx(10.1f);
        }
        sharePicMediaContentLayout.setLayoutParams(layoutParams);
        this.mediaView = sharePicMediaContentLayout;
        sharePicMediaContentLayout.setOrientation(1);
        SharePicMediaContentLayout sharePicMediaContentLayout2 = this.mediaView;
        SharePicMediaContentLayout sharePicMediaContentLayout3 = null;
        if (sharePicMediaContentLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaView");
            sharePicMediaContentLayout2 = null;
        }
        parent.addView(sharePicMediaContentLayout2);
        SharePicMediaContentLayout sharePicMediaContentLayout4 = this.mediaView;
        if (sharePicMediaContentLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaView");
            sharePicMediaContentLayout4 = null;
        }
        sharePicMediaContentLayout4.measure(View.MeasureSpec.makeMeasureSpec(parent.getMeasuredWidth(), 1073741824), 0);
        SharePicMediaContentLayout sharePicMediaContentLayout5 = this.mediaView;
        if (sharePicMediaContentLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaView");
        } else {
            sharePicMediaContentLayout3 = sharePicMediaContentLayout5;
        }
        sharePicMediaContentLayout3.i(mediaInfo);
    }

    private final void f(ViewGroup msgAreaViewGroup, CharSequence content, boolean hasTitleBefore) {
        TextView textView = new TextView(msgAreaViewGroup.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!hasTitleBefore && msgAreaViewGroup.getChildCount() > 0) {
            layoutParams.topMargin = (int) cw.a(21.6f);
        } else if (hasTitleBefore) {
            layoutParams.topMargin = (int) cw.a(10.1f);
        }
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 11.53f);
        cw.i(textView, cw.a(21.63f));
        textView.setSpannableFactory(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getEmoSpanFactory());
        h.MsgContentStyle msgContentStyle = this.style;
        if (msgContentStyle != null) {
            textView.setTextColor(msgContentStyle.getTextColor());
        }
        msgAreaViewGroup.addView(textView);
        h(content);
        textView.setText(content);
        this.contentTv = textView;
    }

    private final void g(ViewGroup msgAreaViewGroup, CharSequence title) {
        TextView textView = new TextView(msgAreaViewGroup.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (msgAreaViewGroup.getChildCount() > 0) {
            layoutParams.topMargin = (int) cw.a(21.6f);
        }
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 13.2f);
        h.MsgContentStyle msgContentStyle = this.style;
        if (msgContentStyle != null) {
            textView.setTextColor(msgContentStyle.getTextColor());
        }
        cw.i(textView, cw.a(22.8f));
        textView.setText(title);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        msgAreaViewGroup.addView(textView);
    }

    private final void h(CharSequence text) {
        h.MsgContentStyle msgContentStyle = this.style;
        if (msgContentStyle != null && (text instanceof SpannableStringBuilder)) {
            GuildFeedForegroundColorSpan[] colorSpan = (GuildFeedForegroundColorSpan[]) ((SpannableStringBuilder) text).getSpans(0, text.length(), GuildFeedForegroundColorSpan.class);
            Intrinsics.checkNotNullExpressionValue(colorSpan, "colorSpan");
            for (GuildFeedForegroundColorSpan guildFeedForegroundColorSpan : colorSpan) {
                guildFeedForegroundColorSpan.a(msgContentStyle.getTextColor());
            }
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) text;
            com.tencent.mobileqq.guild.feed.a[] clickableSpan = (com.tencent.mobileqq.guild.feed.a[]) spannableStringBuilder.getSpans(0, text.length(), com.tencent.mobileqq.guild.feed.a.class);
            Intrinsics.checkNotNullExpressionValue(clickableSpan, "clickableSpan");
            for (com.tencent.mobileqq.guild.feed.a aVar : clickableSpan) {
                aVar.b(msgContentStyle.getTextColor());
            }
            u[] imageSpan = (u[]) spannableStringBuilder.getSpans(0, text.length(), u.class);
            Intrinsics.checkNotNullExpressionValue(imageSpan, "imageSpan");
            for (u uVar : imageSpan) {
                if (!(uVar.getDrawable() instanceof URLDrawable)) {
                    uVar.getDrawable().setColorFilter(new PorterDuffColorFilter(msgContentStyle.getTextColor(), PorterDuff.Mode.SRC_ATOP));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.contentshare.g
    public void a(@NotNull ViewGroup parent, @NotNull com.tencent.mobileqq.guild.contentshare.d shareData, @Nullable com.tencent.mobileqq.guild.contentshare.h style) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(shareData, "shareData");
        this.context = parent.getContext();
        Object data = shareData.getData();
        if ((data instanceof IFeedDetailDataParser) && (style instanceof h.MsgContentStyle)) {
            h.MsgContentStyle msgContentStyle = (h.MsgContentStyle) style;
            this.style = msgContentStyle;
            View inflate = LayoutInflater.from(parent.getContext()).inflate(msgContentStyle.getReplyLayoutResId(), parent);
            ViewGroup contentView = (ViewGroup) inflate.findViewById(R.id.zfp);
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            c(contentView);
            QLog.i("FeedContentComponent", 1, "setContent parentWidth=" + parent.getMeasuredWidth());
            boolean z18 = false;
            inflate.measure(View.MeasureSpec.makeMeasureSpec(parent.getMeasuredWidth(), 1073741824), 0);
            IFeedDetailDataParser iFeedDetailDataParser = (IFeedDetailDataParser) data;
            CharSequence titleData = iFeedDetailDataParser.getTitleData();
            if (titleData.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                g(contentView, titleData);
            }
            CharSequence contentData = iFeedDetailDataParser.getContentData();
            if (contentData.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (titleData.length() > 0) {
                    z18 = true;
                }
                f(contentView, contentData, z18);
            }
            List<IFeedDetailDataParser.MediaInfo> mediaInfoList = iFeedDetailDataParser.getMediaInfoList();
            if (!mediaInfoList.isEmpty()) {
                e(contentView, mediaInfoList);
            }
        }
    }
}
