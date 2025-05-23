package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\u0018\u0000 92\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0003:\u0013\rB\u000f\u0012\u0006\u0010'\u001a\u00020%\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0014\u0010\u0016\u001a\u00020\u0006*\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J,\u0010#\u001a\u00020\u00062\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u001f\u001a\u00020\b2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u0016\u0010)\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010(R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010,R*\u00101\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010.j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00100R$\u00102\u001a\u0012\u0012\u0004\u0012\u00020\f0.j\b\u0012\u0004\u0012\u00020\f`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u00100R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "newStFeed", "", "g", "", "index", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d$b;", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "f", tl.h.F, "Lwq0/l;", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "comment", DomainData.DOMAIN_NAME, "", "d", "", "e", "Landroid/view/View;", "containerView", "k", "data", "position", "", "", "payload", "i", "j", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d$c;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d$c;", "depends", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/ViewGroup;", "mCommentContainer", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "mLastStFeed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mLastExternalCommentList", "mCommentViews", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Map;", "mCommentItemReportMap", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d$c;)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends a<qj1.h> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<String, View> mCommentItemReportMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mCommentContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GProStFeed mLastStFeed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<GProStComment> mLastExternalCommentList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> mCommentViews;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d$b;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/au;", "d", "Lwq0/l;", "a", "Landroid/view/View;", "e", "", "c", "b", "nick", "", "g", "content", "f", "str", tl.h.F, "Lwq0/l;", "tv", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/au;", TtmlNode.TAG_SPAN, "Ljava/lang/CharSequence;", "<init>", "(Lwq0/l;Lcom/tencent/mobileqq/guild/feed/feedsquare/section/au;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final wq0.l tv;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final au span;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private CharSequence nick;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private CharSequence content;

        public b(@NotNull wq0.l tv5, @NotNull au span, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
            Intrinsics.checkNotNullParameter(tv5, "tv");
            Intrinsics.checkNotNullParameter(span, "span");
            this.tv = tv5;
            this.span = span;
            this.nick = charSequence;
            this.content = charSequence2;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final wq0.l getTv() {
            return this.tv;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final CharSequence getContent() {
            return this.content;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final CharSequence getNick() {
            return this.nick;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final au getSpan() {
            return this.span;
        }

        @NotNull
        public final View e() {
            return this.tv.getView();
        }

        public final void f(@NotNull CharSequence content) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
        }

        public final void g(@NotNull CharSequence nick) {
            Intrinsics.checkNotNullParameter(nick, "nick");
            this.nick = nick;
        }

        public final void h(@NotNull CharSequence str) {
            Intrinsics.checkNotNullParameter(str, "str");
            this.tv.f(str, "");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/d$c;", "", "Landroid/view/View;", "commentContainer", "", "", "commentItemReportMap", "", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c {
        void a(@NotNull View commentContainer, @NotNull Map<String, ? extends View> commentItemReportMap);

        void b(@NotNull GProStFeed stFeed);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Q\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\t\u0010\r\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0096\u0001J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\b\u0010\u001f\u001a\u00020\nH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\"H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/d$d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", "Landroid/graphics/drawable/Drawable;", "v", "", "g", "i", "j", tl.h.F, "u", "o", "e", "d", "w", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", ReportConstant.COSTREPORT_PREFIX, "getTraceID", "k", "", "r", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.section.d$d, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7739d implements IParseRichTextConfig<GProStRichTextContent> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f219211b = IParseRichTextConfig.INSTANCE.a();

        C7739d() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f219211b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f219211b.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f219211b.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f219211b.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return this.f219211b.f();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f219211b.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f219211b.getHighlightWords();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221009e() {
            return "";
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f219211b.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f219211b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f219211b.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f219211b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f219211b.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return this.f219211b.o();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221008d() {
            return this.f219211b.getF221008d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f219211b.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Set<Integer> r() {
            Set<Integer> of5;
            of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{1, 2, 5});
            return of5;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return 2;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.f219211b.t();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f219211b.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f219211b.m(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f219211b.a(t16);
        }
    }

    public d(@NotNull c depends) {
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
        this.mCommentViews = new ArrayList<>();
        this.mCommentItemReportMap = new LinkedHashMap();
    }

    private final wq0.l b() {
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.f221402a;
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        wq0.l b16 = bVar.b(context);
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        b16.setTextColor(ContextCompat.getColor(view2.getContext(), R.color.qui_common_text_primary));
        b16.setTextSize(14.0f);
        b16.setEllipsize(TextUtils.TruncateAt.END);
        b16.setGravity(16);
        b16.setFontWeight(400);
        b16.getView().setAlpha(0.8f);
        return b16;
    }

    private final b c(int index, ViewGroup container) {
        if (index >= this.mCommentViews.size()) {
            wq0.l b16 = b();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = ViewUtils.dpToPx(3.0f);
            layoutParams.bottomMargin = ViewUtils.dpToPx(3.0f);
            container.addView(b16.getView(), layoutParams);
            b bVar = new b(b16, new au(b16.j(), 0, null, 0, 14, null), null, null);
            this.mCommentViews.add(bVar);
            return bVar;
        }
        b bVar2 = this.mCommentViews.get(index);
        Intrinsics.checkNotNullExpressionValue(bVar2, "{\n            mCommentViews[index]\n        }");
        return bVar2;
    }

    private final boolean f(GProStFeed newStFeed) {
        boolean z16;
        int dip2px;
        LinearLayout.LayoutParams layoutParams;
        View view = null;
        if (newStFeed.externalCommentList.isEmpty()) {
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        gradientDrawable.setColor(view3.getContext().getColorStateList(R.color.qui_common_fill_standard_extra));
        float dip2px2 = ViewUtils.dip2px(8.0f);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, dip2px2, dip2px2, dip2px2, dip2px2};
        ArrayList<GProStUser> arrayList = newStFeed.externalLikeUserList;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && h.INSTANCE.c()) {
            dip2px = 0;
        } else {
            fArr = new float[]{dip2px2, dip2px2, dip2px2, dip2px2, dip2px2, dip2px2, dip2px2, dip2px2};
            dip2px = ViewUtils.dip2px(9.0f);
        }
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.topMargin = dip2px;
        }
        if (layoutParams != null) {
            View view5 = this.rootView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view5 = null;
            }
            view5.setLayoutParams(layoutParams);
        }
        gradientDrawable.setCornerRadii(fArr);
        View view6 = this.rootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view6 = null;
        }
        view6.setBackground(gradientDrawable);
        View view7 = this.rootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view7;
        }
        view.setVisibility(0);
        return true;
    }

    private final synchronized void g(GProStFeed newStFeed) {
        ViewGroup viewGroup;
        Map<String, ? extends View> map;
        if (!f(newStFeed)) {
            return;
        }
        if (!h(newStFeed)) {
            return;
        }
        this.mCommentItemReportMap.clear();
        Iterator<T> it = this.mCommentViews.iterator();
        while (it.hasNext()) {
            ((b) it.next()).e().setVisibility(8);
        }
        ArrayList<GProStComment> arrayList = newStFeed.externalCommentList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "newStFeed.externalCommentList");
        Iterator<T> it5 = arrayList.iterator();
        int i3 = 0;
        while (true) {
            viewGroup = null;
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GProStComment comment = (GProStComment) next;
            if (i3 < 30) {
                ViewGroup viewGroup2 = this.mCommentContainer;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCommentContainer");
                } else {
                    viewGroup = viewGroup2;
                }
                b c16 = c(i3, viewGroup);
                c16.e().setVisibility(0);
                Intrinsics.checkNotNullExpressionValue(comment, "comment");
                n(c16, comment);
                Map<String, View> map2 = this.mCommentItemReportMap;
                String str = comment.idd;
                Intrinsics.checkNotNullExpressionValue(str, "comment.idd");
                map2.put(str, c16.e());
            }
            i3 = i16;
        }
        m(newStFeed);
        c cVar = this.depends;
        ViewGroup viewGroup3 = this.mCommentContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContainer");
            viewGroup3 = null;
        }
        map = MapsKt__MapsKt.toMap(this.mCommentItemReportMap);
        cVar.a(viewGroup3, map);
        String d16 = d();
        int size = newStFeed.externalCommentList.size();
        ViewGroup viewGroup4 = this.mCommentContainer;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContainer");
        } else {
            viewGroup = viewGroup4;
        }
        QLog.d(d16, 4, "[initOrUpdateComment] externalCommentList.size=" + size + ",commentView.size:" + viewGroup.getChildCount());
    }

    private final boolean h(GProStFeed newStFeed) {
        ArrayList<GProStComment> arrayList = this.mLastExternalCommentList;
        if (arrayList == null) {
            QLog.d(d(), 4, "[isNeedToUpdate] mLastExternalCommentList == null, isNeedToUpdate = true");
            return true;
        }
        Intrinsics.checkNotNull(arrayList);
        if (arrayList.size() != newStFeed.externalCommentList.size()) {
            QLog.d(d(), 4, "[isNeedToUpdate] size is different, isNeedToUpdate = true");
            return true;
        }
        int size = newStFeed.externalCommentList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<GProStComment> arrayList2 = this.mLastExternalCommentList;
            Intrinsics.checkNotNull(arrayList2);
            if (!Intrinsics.areEqual(arrayList2.get(i3).idd, newStFeed.externalCommentList.get(i3).idd)) {
                QLog.d(d(), 4, "[isNeedToUpdate] comment idd is different, isNeedToUpdate = true");
                return true;
            }
        }
        QLog.d(d(), 4, "[isNeedToUpdate] isNeedToUpdate = false");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GProStFeed gProStFeed = this$0.mLastStFeed;
        if (gProStFeed != null) {
            this$0.depends.b(gProStFeed);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void m(GProStFeed newStFeed) {
        this.mLastStFeed = newStFeed;
        this.mLastExternalCommentList = newStFeed.externalCommentList;
    }

    private final void n(b bVar, GProStComment gProStComment) {
        int coerceAtMost;
        String nick = gProStComment.postUser.nick;
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<GProStRichTextContent> arrayList = gProStComment.richContents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "comment.richContents.contents");
        Pair s16 = FeedRichTextContentParser.s(feedRichTextContentParser, arrayList, null, new C7739d(), "", "", 1, null);
        if (TextUtils.equals(nick, bVar.getNick()) && TextUtils.equals((CharSequence) s16.getFirst(), bVar.getContent())) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        bVar.g(nick);
        bVar.f((CharSequence) s16.getFirst());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) nick);
        spannableStringBuilder.append((CharSequence) MsgSummary.STR_COLON);
        spannableStringBuilder.append((CharSequence) s16.getFirst());
        spannableStringBuilder.setSpan(bVar.getSpan(), 0, nick.length(), 33);
        wq0.l tv5 = bVar.getTv();
        int i3 = gProStComment.externalShowLine;
        if (i3 >= 1) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, 5);
            tv5.setMaxLines(coerceAtMost);
        } else {
            tv5.i();
        }
        bVar.h(spannableStringBuilder);
        Logger logger = Logger.f235387a;
        String d16 = d();
        if (QLog.isColorLevel()) {
            logger.d().d(d16, 1, "updateComment--lines:" + gProStComment.externalShowLine);
        }
    }

    @NotNull
    public final String d() {
        return "GuildFeedCommentComponents";
    }

    @NotNull
    public int[] e() {
        return new int[]{R.id.waz};
    }

    public void i(@NotNull qj1.h data, int position, @Nullable List<Object> payload) {
        GProStFeed gProStFeed;
        Intrinsics.checkNotNullParameter(data, "data");
        Object a16 = data.a();
        if (a16 instanceof GProStFeed) {
            gProStFeed = (GProStFeed) a16;
        } else {
            gProStFeed = null;
        }
        if (gProStFeed != null) {
            g(gProStFeed);
        }
    }

    public final void j(@NotNull GProStFeed newStFeed) {
        Intrinsics.checkNotNullParameter(newStFeed, "newStFeed");
        g(newStFeed);
    }

    public void k(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f165490wa0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026feed_item_comment_layout)");
        this.rootView = findViewById;
        View findViewById2 = containerView.findViewById(R.id.w_y);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026d_item_comment_container)");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.mCommentContainer = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCommentContainer");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.l(d.this, view);
            }
        });
    }
}
