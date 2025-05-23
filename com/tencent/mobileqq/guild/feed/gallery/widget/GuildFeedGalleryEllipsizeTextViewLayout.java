package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.EdgeTransparentView;
import com.tencent.mobileqq.guild.widget.MaxHeightScrollView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002IJB\u001d\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\f\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0002J\u001e\u0010\u0015\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010J\u0010\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J \u0010\u001f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010 \u001a\u00020\u0005J\u0012\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016R\u001b\u0010'\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010(R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010,\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010+R\u0014\u0010.\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010-R\u001b\u00101\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b\u0019\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryEllipsizeTextViewLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "", DomainData.DOMAIN_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "text", "maxLine", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryEllipsizeTextViewLayout$b;", "i", "j", "f", "e", "Lcom/tencent/mobileqq/guild/widget/MaxHeightScrollView;", "", "d", "Lcom/tencent/mobileqq/guild/widget/EdgeTransparentView;", "show", "position", "o", "enable", "setEnableExpand", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/p;", "l", "setOnContentClickListener", "", "key", "Lcom/tencent/aio/widget/textView/view/b;", "movement", IECSearchBar.METHOD_SET_TEXT, tl.h.F, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lkotlin/Lazy;", "k", "()Ljava/lang/CharSequence;", "enableExpandSpan", "Ljava/lang/CharSequence;", "sourceText", "ellipsizeText", "Lcom/tencent/mobileqq/guild/widget/EdgeTransparentView;", "edgeContainer", "Lcom/tencent/mobileqq/guild/widget/MaxHeightScrollView;", "contentScrollView", "Lwq0/l;", "()Lwq0/l;", "txtView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "foldBtn", "D", "Z", "enableExpand", "E", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/p;", "eventListener", UserInfo.SEX_FEMALE, "I", "contentStatus", "G", "Ljava/lang/String;", "txtViewKey", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryEllipsizeTextViewLayout extends FrameLayout implements View.OnClickListener {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TextView foldBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean enableExpand;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private p eventListener;

    /* renamed from: F, reason: from kotlin metadata */
    private int contentStatus;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String txtViewKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy enableExpandSpan;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence sourceText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence ellipsizeText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EdgeTransparentView edgeContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MaxHeightScrollView contentScrollView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy txtView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryEllipsizeTextViewLayout$a;", "", "", "text", "", "start", "end", "a", "Landroid/content/Context;", "context", "b", "", "EDGE_WIDTH", UserInfo.SEX_FEMALE, "", "EXPAND_TEXT_COLOR", "Ljava/lang/String;", "ICON_SIZE", "MAX_HEIGHT_EXPAND", "MAX_LINE_NORMAL", "I", "STATUS_EXPAND", "STATUS_FOLD", "STATUS_NONE", "TAG", "TEXT_SIZE", "WIDTH_SPACE", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryEllipsizeTextViewLayout$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CharSequence a(@NotNull CharSequence text, int start, int end) {
            Intrinsics.checkNotNullParameter(text, "text");
            SpannableString spannableString = new SpannableString(text);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#8CFFFFFF")), start, end, 33);
            spannableString.setSpan(new StyleSpan(1), start, end, 17);
            return spannableString;
        }

        @NotNull
        public final CharSequence b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getResources().getString(R.string.f144170o2);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ayout_normal_middle_text)");
            Drawable drawable = context.getResources().getDrawable(R.drawable.guild_feed_gallery_ellipsize_layout_middle_icon);
            drawable.setBounds(0, 0, ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
            SpannableString spannableString = new SpannableString(" ");
            spannableString.setSpan(new com.tencent.mobileqq.guild.feed.util.d(drawable, 2), 0, 1, 33);
            SpannableStringBuilder append = new SpannableStringBuilder("  ").append(a(string, 0, string.length())).append((CharSequence) spannableString);
            Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder(\"\u2026n).append(middleIconSpan)");
            return append;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryEllipsizeTextViewLayout$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "text", "Z", "()Z", "hasEllipsize", "<init>", "(Ljava/lang/CharSequence;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryEllipsizeTextViewLayout$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class EllipsizeInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CharSequence text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean hasEllipsize;

        public EllipsizeInfo(@NotNull CharSequence text, boolean z16) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.hasEllipsize = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasEllipsize() {
            return this.hasEllipsize;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EllipsizeInfo)) {
                return false;
            }
            EllipsizeInfo ellipsizeInfo = (EllipsizeInfo) other;
            if (Intrinsics.areEqual(this.text, ellipsizeInfo.text) && this.hasEllipsize == ellipsizeInfo.hasEllipsize) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.text.hashCode() * 31;
            boolean z16 = this.hasEllipsize;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            CharSequence charSequence = this.text;
            return "EllipsizeInfo(text=" + ((Object) charSequence) + ", hasEllipsize=" + this.hasEllipsize + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryEllipsizeTextViewLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuildFeedGalleryEllipsizeTextViewLayout this$0, NestedScrollView nestedScrollView, int i3, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
    }

    private final boolean d(MaxHeightScrollView maxHeightScrollView) {
        if (maxHeightScrollView.getChildCount() <= 0) {
            return false;
        }
        View childAt = maxHeightScrollView.getChildAt(0);
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (childAt.getHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin <= (maxHeightScrollView.getHeight() - maxHeightScrollView.getPaddingTop()) - maxHeightScrollView.getPaddingBottom()) {
            return false;
        }
        return true;
    }

    private final void e() {
        if (d(this.contentScrollView)) {
            int i3 = 0;
            if (this.contentScrollView.canScrollVertically(-1)) {
                i3 = 0 | EdgeTransparentView.G;
            }
            if (this.contentScrollView.canScrollVertically(1)) {
                i3 |= EdgeTransparentView.H;
            }
            if (i3 == 0) {
                i3 = EdgeTransparentView.H | EdgeTransparentView.G;
            }
            o(this.edgeContainer, true, i3);
            return;
        }
        p(this, this.edgeContainer, false, 0, 2, null);
    }

    private final void f() {
        if (this.contentStatus == 2) {
            return;
        }
        this.contentStatus = 2;
        wq0.l l3 = l();
        l3.f(this.sourceText, this.txtViewKey);
        l3.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
        this.foldBtn.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
        }
        l().getView().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryEllipsizeTextViewLayout.g(GuildFeedGalleryEllipsizeTextViewLayout.this);
            }
        });
        p pVar = this.eventListener;
        if (pVar != null) {
            pVar.c(this.foldBtn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuildFeedGalleryEllipsizeTextViewLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
    }

    private final EllipsizeInfo i(CharSequence text, int maxLine) {
        int dpToPx = getResources().getDisplayMetrics().widthPixels - ViewUtils.dpToPx(30.0f);
        StaticLayout staticLayout = new StaticLayout(text, l().j(), dpToPx, Layout.Alignment.ALIGN_NORMAL, l().e(), l().h(), true);
        if (staticLayout.getLineCount() <= maxLine) {
            return new EllipsizeInfo(text, false);
        }
        float desiredWidth = Layout.getDesiredWidth(k(), l().j());
        int i3 = maxLine - 1;
        float lineWidth = staticLayout.getLineWidth(i3);
        int lineEnd = staticLayout.getLineEnd(i3);
        float f16 = dpToPx - desiredWidth;
        if (lineWidth > f16) {
            lineEnd = staticLayout.getOffsetForHorizontal(i3, f16) - 1;
        }
        if (lineEnd > 1 && text.charAt(lineEnd - 1) == '\n') {
            lineEnd--;
        }
        SpannableStringBuilder append = new SpannableStringBuilder().append(text.subSequence(0, lineEnd)).append(k());
        Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder()\u2026.append(enableExpandSpan)");
        return new EllipsizeInfo(append, true);
    }

    private final EllipsizeInfo j(CharSequence text) {
        SpannableStringBuilder spannableStringBuilder;
        int dpToPx = getResources().getDisplayMetrics().widthPixels - ViewUtils.dpToPx(30.0f);
        StaticLayout staticLayout = new StaticLayout(text, l().j(), dpToPx, Layout.Alignment.ALIGN_NORMAL, l().e(), l().h(), true);
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryExpandTextViewLayout", 1, "getEllipsizedContent: " + staticLayout.getLineCount());
        }
        int lineEnd = staticLayout.getLineEnd(1);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (staticLayout.getLineCount() > 1) {
            int lineEnd2 = staticLayout.getLineEnd(0);
            spannableStringBuilder2.append(text.subSequence(0, lineEnd2));
            if (text.charAt(lineEnd2 - 1) != '\n') {
                spannableStringBuilder2.append((CharSequence) "\n");
            }
            int i3 = lineEnd - 1;
            if (text.charAt(i3) == '\n') {
                if (lineEnd2 < i3) {
                    spannableStringBuilder2.append(text.subSequence(lineEnd2, i3));
                }
            } else {
                spannableStringBuilder2.append(text.subSequence(lineEnd2, lineEnd));
            }
        } else {
            spannableStringBuilder2.append(text);
        }
        Companion companion = INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        CharSequence b16 = companion.b(context);
        StaticLayout staticLayout2 = new StaticLayout(new SpannableStringBuilder().append((CharSequence) spannableStringBuilder2).append(b16), l().j(), dpToPx, Layout.Alignment.ALIGN_NORMAL, l().e(), l().h(), true);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
        if ((staticLayout.getLineCount() == 1 && staticLayout2.getLineCount() == 1) || (staticLayout.getLineCount() == 2 && staticLayout2.getLineCount() == 2)) {
            spannableStringBuilder3.append((CharSequence) spannableStringBuilder2).append(b16);
        } else if (staticLayout.getLineCount() == 1 && staticLayout2.getLineCount() > 1) {
            spannableStringBuilder3.append((CharSequence) spannableStringBuilder2).append((CharSequence) "\n").append(b16);
        } else {
            spannableStringBuilder = spannableStringBuilder3;
            StaticLayout staticLayout3 = new StaticLayout(spannableStringBuilder2, l().j(), dpToPx, Layout.Alignment.ALIGN_NORMAL, l().e(), l().h(), true);
            SpannableStringBuilder append = new SpannableStringBuilder(MiniBoxNoticeInfo.APPNAME_SUFFIX).append(b16);
            float desiredWidth = dpToPx - Layout.getDesiredWidth(append, l().j());
            if (staticLayout3.getLineWidth(1) > desiredWidth) {
                spannableStringBuilder.append(spannableStringBuilder2.subSequence(0, staticLayout3.getOffsetForHorizontal(1, desiredWidth) - 1)).append((CharSequence) append);
            } else {
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2).append((CharSequence) append);
            }
            return new EllipsizeInfo(spannableStringBuilder, z16);
        }
        spannableStringBuilder = spannableStringBuilder3;
        z16 = false;
        return new EllipsizeInfo(spannableStringBuilder, z16);
    }

    private final CharSequence k() {
        return (CharSequence) this.enableExpandSpan.getValue();
    }

    private final wq0.l l() {
        return (wq0.l) this.txtView.getValue();
    }

    private final void m() {
        if (this.enableExpand) {
            this.contentScrollView.setMaxHeight(n());
        } else {
            this.contentScrollView.setMaxHeight(0);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -2;
            setLayoutParams(layoutParams);
        }
        this.sourceText = "";
        this.ellipsizeText = "";
        this.foldBtn.setVisibility(8);
        this.contentStatus = 0;
        p(this, this.edgeContainer, false, 0, 2, null);
    }

    private final int n() {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(ViewUtils.dpToPx(495.0f), (DisplayUtil.getScreenHeight() - ViewUtils.dpToPx(247.0f)) - QQGuildUIUtil.t());
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryExpandTextViewLayout", 1, "scrollMaxHeight: " + coerceAtMost);
        return coerceAtMost;
    }

    private final void o(EdgeTransparentView edgeTransparentView, boolean z16, int i3) {
        int i16;
        if (z16) {
            edgeTransparentView.setEdgePosition(i3);
        }
        if (z16) {
            i16 = ViewUtils.dpToPx(24.0f);
        } else {
            i16 = 0;
        }
        edgeTransparentView.setEdgeWidth(i16);
    }

    static /* synthetic */ void p(GuildFeedGalleryEllipsizeTextViewLayout guildFeedGalleryEllipsizeTextViewLayout, EdgeTransparentView edgeTransparentView, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        guildFeedGalleryEllipsizeTextViewLayout.o(edgeTransparentView, z16, i3);
    }

    public final void h() {
        if (this.contentStatus == 1) {
            return;
        }
        this.contentStatus = 1;
        wq0.l l3 = l();
        l3.f(this.ellipsizeText, this.txtViewKey);
        l3.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_secondary));
        this.foldBtn.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -2;
            setLayoutParams(layoutParams);
        }
        p(this, this.edgeContainer, false, 0, 2, null);
        p pVar = this.eventListener;
        if (pVar != null) {
            pVar.b(this.foldBtn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            if (Intrinsics.areEqual(v3, l().getView())) {
                if (!this.enableExpand) {
                    p pVar = this.eventListener;
                    if (pVar != null) {
                        pVar.a(v3);
                    }
                } else {
                    int i3 = this.contentStatus;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                h();
                            }
                        } else {
                            f();
                        }
                    } else {
                        p pVar2 = this.eventListener;
                        if (pVar2 != null) {
                            pVar2.a(v3);
                        }
                    }
                }
            } else if (Intrinsics.areEqual(v3, this.foldBtn)) {
                h();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setEnableExpand(boolean enable) {
        this.enableExpand = enable;
    }

    public final void setOnContentClickListener(@Nullable p l3) {
        this.eventListener = l3;
    }

    public final void setText(@NotNull CharSequence text, @NotNull String key, @Nullable com.tencent.aio.widget.textView.view.b movement) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(key, "key");
        this.txtViewKey = key;
        m();
        boolean z16 = true;
        if (this.enableExpand) {
            this.sourceText = text;
            EllipsizeInfo i3 = i(text, 2);
            this.ellipsizeText = i3.getText();
            l().f(this.ellipsizeText, this.txtViewKey);
            l().setTextColor(getContext().getResources().getColor(R.color.qui_common_text_allwhite_secondary));
            if (i3.getHasEllipsize()) {
                this.contentStatus = 1;
            }
        } else {
            l().f(j(text).getText(), this.txtViewKey);
        }
        View view = l().getView();
        if (view.getParent() != null) {
            z16 = false;
        }
        if (!z16) {
            view = null;
        }
        if (view != null) {
            this.contentScrollView.addView(view);
            view.setOnClickListener(this);
        }
        l.a.a(l(), movement, false, 2, null);
    }

    public /* synthetic */ GuildFeedGalleryEllipsizeTextViewLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryEllipsizeTextViewLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CharSequence>() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryEllipsizeTextViewLayout$enableExpandSpan$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CharSequence invoke() {
                String string = context.getResources().getString(R.string.f144150o0);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026_ellipszie_layout_expand)");
                return GuildFeedGalleryEllipsizeTextViewLayout.INSTANCE.a(string, 4, string.length());
            }
        });
        this.enableExpandSpan = lazy;
        this.sourceText = "";
        this.ellipsizeText = "";
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<wq0.l>() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryEllipsizeTextViewLayout$txtView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final wq0.l invoke() {
                return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.d(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.f221402a, context, 15.0f, Integer.MAX_VALUE, 0.0f, R.color.qui_common_text_allwhite_secondary, 8, null);
            }
        });
        this.txtView = lazy2;
        this.txtViewKey = "";
        View.inflate(context, R.layout.f168075eo2, this);
        View findViewById = findViewById(R.id.upi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.edge_transparent_container)");
        EdgeTransparentView edgeTransparentView = (EdgeTransparentView) findViewById;
        this.edgeContainer = edgeTransparentView;
        p(this, edgeTransparentView, false, 0, 2, null);
        View findViewById2 = findViewById(R.id.u8i);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.content_scroll)");
        MaxHeightScrollView maxHeightScrollView = (MaxHeightScrollView) findViewById2;
        this.contentScrollView = maxHeightScrollView;
        maxHeightScrollView.setNestedScrollingEnabled(false);
        maxHeightScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.e
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i3, int i16, int i17, int i18) {
                GuildFeedGalleryEllipsizeTextViewLayout.c(GuildFeedGalleryEllipsizeTextViewLayout.this, nestedScrollView, i3, i16, i17, i18);
            }
        });
        View findViewById3 = findViewById(R.id.vc_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.fold_btn)");
        TextView textView = (TextView) findViewById3;
        this.foldBtn = textView;
        String string = context.getResources().getString(R.string.f144160o1);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ry_ellipszie_layout_fold)");
        textView.setText(INSTANCE.a(string, 0, string.length()));
        textView.setOnClickListener(this);
    }
}
