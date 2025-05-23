package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.config.GuildFeedTextLineNumberConfigParser;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ComputedKt;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareFeedItemView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.RichTextExpandStrSpanUtil;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedMetaData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004BCD\u001fB\u000f\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\u000b\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J(\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u0016\u0010(\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00102\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b*\u00101R\u001b\u00106\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010+\u001a\u0004\b4\u00105R!\u0010<\u001a\b\u0012\u0004\u0012\u000208078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b:\u0010;R!\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0018078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010+\u001a\u0004\b0\u0010;\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lij1/g;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", QCircleScheme.AttrDetail.FEED_INFO, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "key", ReportConstant.COSTREPORT_PREFIX, "Landroid/text/SpannableStringBuilder;", "e", "Lkotlin/Pair;", "Lcom/tencent/aio/widget/textView/view/b;", "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "containerView", "o", "data", "", "position", "", "", "payload", DomainData.DOMAIN_NAME, "", NodeProps.VISIBLE, "p", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "g", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "depends", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "feedItemView", "Lwq0/l;", tl.h.F, "Lkotlin/Lazy;", "l", "()Lwq0/l;", "txtView", "Landroid/text/SpannableString;", "i", "()Landroid/text/SpannableString;", "expandStringBuilder", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/m;", "j", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/m;", "longClickProcessor", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", BdhLogUtil.LogTag.Tag_Conn, "k", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "parseConfig", "D", "legacyParseConfig", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;)V", "E", "a", "b", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareFeedDescComponents extends a<ij1.g> {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final com.tencent.mobileqq.guild.feed.feedsquare.utils.a<GuildFeedTextLineNumberConfigParser.Data, Integer> F = new com.tencent.mobileqq.guild.feed.feedsquare.utils.a<>(new GuildFeedSquareFeedDescComponents$Companion$MAX_LINES$2(GuildFeedTextLineNumberConfigParser.INSTANCE.a()), ComputedKt.a(), new Function1<GuildFeedTextLineNumberConfigParser.Data, Integer>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents$Companion$MAX_LINES$3
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Integer invoke(@Nullable GuildFeedTextLineNumberConfigParser.Data data) {
            Integer valueOf = Integer.valueOf(data != null ? RangesKt___RangesKt.coerceAtLeast(data.getMaxTextLines(), 1) : 6);
            int intValue = valueOf.intValue();
            Logger.f235387a.d().d("GuildFeedSquareFeedDescComponents", 1, "obtained feedMaxTextLines: " + intValue);
            return valueOf;
        }
    });

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy parseConfig;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy legacyParseConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View feedItemView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy txtView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy expandStringBuilder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy longClickProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$a;", "", "", "MAX_LINES$delegate", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "a", "()I", "MAX_LINES", "", "SPACE_ADD", UserInfo.SEX_FEMALE, "SPACE_MULTI", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f219100a = {Reflection.property1(new PropertyReference1Impl(Companion.class, "MAX_LINES", "getMAX_LINES()I", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ((Number) GuildFeedSquareFeedDescComponents.F.getValue(this, f219100a[0])).intValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020'\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\t\u0010\b\u001a\u00020\u0005H\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\t\u0010\u000b\u001a\u00020\tH\u0096\u0001J\t\u0010\f\u001a\u00020\tH\u0096\u0001J\t\u0010\r\u001a\u00020\tH\u0096\u0001J\t\u0010\u000e\u001a\u00020\tH\u0096\u0001J\t\u0010\u000f\u001a\u00020\tH\u0096\u0001J\t\u0010\u0010\u001a\u00020\tH\u0096\u0001J\t\u0010\u0011\u001a\u00020\tH\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014H\u0096\u0001J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J$\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c0\u001bj\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c`\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010(R\u0014\u0010,\u001a\u00020\u00058\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "", "g", "i", "j", tl.h.F, "u", "e", "d", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", "", "getTraceID", "t", "Landroid/graphics/drawable/Drawable;", "v", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", "w", "", "getHighlightWords", "o", "k", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "depends", DomainData.DOMAIN_NAME, "()I", "linkColor", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static class b implements IParseRichTextConfig<GProStRichTextContent> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c depends;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f219103d;

        public b(@NotNull Context context, @NotNull c depends) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(depends, "depends");
            this.context = context;
            this.depends = depends;
            this.f219103d = IParseRichTextConfig.INSTANCE.a();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f219103d.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.depends.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f219103d.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f219103d.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return this.f219103d.f();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f219103d.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.depends.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221023e() {
            String traceID = this.depends.getTraceID();
            if (traceID == null) {
                return IParseRichTextConfig.a.i(this);
            }
            return traceID;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f219103d.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f219103d.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f219103d.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f219103d.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f219103d.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221022d() {
            return this.f219103d.getF221022d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f219103d.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f219103d.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f219103d.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.context.getResources().getColor(R.color.qui_common_brand_standard);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f219103d.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c cVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c.f221632a;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c.c(cVar, t16, context, null, 4, null);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            GProStRichTextURLContent gProStRichTextURLContent = t16.urlContent;
            switch (gProStRichTextURLContent.type) {
                case 7:
                case 8:
                case 9:
                    String str = gProStRichTextURLContent.thirdVideoInfo.cover;
                    if (str == null || str.length() == 0) {
                        return true;
                    }
                    break;
                case 6:
                    return false;
                default:
                    return true;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0004H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "e", "getTraceID", "", "g", "", "getTextSize", "f", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "b", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a {
            @Nullable
            public static IParseRichTextConfig<GProStRichTextContent> a(@NotNull c cVar, @NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return null;
            }

            @NotNull
            public static Collection<String> b(@NotNull c cVar) {
                List emptyList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }

            @Nullable
            public static IParseRichTextConfig<Object> c(@NotNull c cVar, @NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return null;
            }

            public static float d(@NotNull c cVar) {
                return 26.0f;
            }

            public static float e(@NotNull c cVar) {
                return 18.0f;
            }

            @Nullable
            public static String f(@NotNull c cVar) {
                return null;
            }
        }

        @Nullable
        IParseRichTextConfig<GProStRichTextContent> b(@NotNull Context context);

        @NotNull
        HashMap<String, Object> c();

        @Nullable
        IParseRichTextConfig<Object> d(@NotNull Context context);

        @Nullable
        JumpGuildParam.JoinInfoParam e(@NotNull GProStFeed stFeed);

        float f();

        @NotNull
        Collection<String> g();

        float getTextSize();

        @Nullable
        String getTraceID();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010(\u001a\u00020&\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002`\u0007H\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\t\u0010\u000b\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u000f\u001a\u00020\tH\u0096\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fH\u0096\u0001J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010'R\u0014\u0010+\u001a\u00020\t8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "", "", "l", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "g", "i", "j", tl.h.F, "u", "k", "o", "e", "d", "a", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", "", "getHighlightWords", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "depends", DomainData.DOMAIN_NAME, "()I", "linkColor", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static class d implements IParseRichTextConfig<Object> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c depends;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<Object> f219106d;

        public d(@NotNull Context context, @NotNull c depends) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(depends, "depends");
            this.context = context;
            this.depends = depends;
            this.f219106d = IParseRichTextConfig.INSTANCE.a();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean a(@NotNull Object t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f219106d.a(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f219106d.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f219106d.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f219106d.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f219106d.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return this.f219106d.f();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f219106d.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.depends.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221023e() {
            return this.f219106d.getF221023e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f219106d.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f219106d.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f219106d.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return this.f219106d.k();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f219106d.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Drawable m(@NotNull Object t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f219106d.m(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f219106d.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return this.f219106d.o();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221022d() {
            return this.f219106d.getF221022d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f219106d.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f219106d.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f219106d.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.context.getResources().getColor(R.color.qui_common_brand_standard);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f219106d.u();
        }
    }

    public GuildFeedSquareFeedDescComponents(@NotNull c depends) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<wq0.l>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents$txtView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final wq0.l invoke() {
                ViewGroup viewGroup;
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.f221402a;
                viewGroup = GuildFeedSquareFeedDescComponents.this.container;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    viewGroup = null;
                }
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "container.context");
                wq0.l d16 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.d(bVar, context, GuildFeedSquareFeedDescComponents.this.getDepends().getTextSize(), GuildFeedSquareFeedDescComponents.INSTANCE.a(), 0.0f, 0, 24, null);
                ci1.a.h(d16, GuildFeedSquareFeedDescComponents.this.getDepends().f());
                return d16;
            }
        });
        this.txtView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SpannableString>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents$expandStringBuilder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SpannableString invoke() {
                ViewGroup viewGroup;
                RichTextExpandStrSpanUtil richTextExpandStrSpanUtil = RichTextExpandStrSpanUtil.f221634a;
                viewGroup = GuildFeedSquareFeedDescComponents.this.container;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    viewGroup = null;
                }
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "container.context");
                return richTextExpandStrSpanUtil.j(context);
            }
        });
        this.expandStringBuilder = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.mobileqq.guild.feed.feedsquare.widget.m>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents$longClickProcessor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.feedsquare.widget.m invoke() {
                wq0.l l3;
                l3 = GuildFeedSquareFeedDescComponents.this.l();
                return com.tencent.mobileqq.guild.feed.feedsquare.widget.i.b(l3);
            }
        });
        this.longClickProcessor = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IParseRichTextConfig<GProStRichTextContent>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents$parseConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IParseRichTextConfig<GProStRichTextContent> invoke() {
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                GuildFeedSquareFeedDescComponents.c depends2 = GuildFeedSquareFeedDescComponents.this.getDepends();
                viewGroup = GuildFeedSquareFeedDescComponents.this.container;
                ViewGroup viewGroup3 = null;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    viewGroup = null;
                }
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "container.context");
                IParseRichTextConfig<GProStRichTextContent> b16 = depends2.b(context);
                if (b16 == null) {
                    viewGroup2 = GuildFeedSquareFeedDescComponents.this.container;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    } else {
                        viewGroup3 = viewGroup2;
                    }
                    Context context2 = viewGroup3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "container.context");
                    b16 = new GuildFeedSquareFeedDescComponents.b(context2, GuildFeedSquareFeedDescComponents.this.getDepends());
                }
                return b16;
            }
        });
        this.parseConfig = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IParseRichTextConfig<Object>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents$legacyParseConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IParseRichTextConfig<Object> invoke() {
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                GuildFeedSquareFeedDescComponents.c depends2 = GuildFeedSquareFeedDescComponents.this.getDepends();
                viewGroup = GuildFeedSquareFeedDescComponents.this.container;
                ViewGroup viewGroup3 = null;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    viewGroup = null;
                }
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "container.context");
                IParseRichTextConfig<Object> d16 = depends2.d(context);
                if (d16 == null) {
                    viewGroup2 = GuildFeedSquareFeedDescComponents.this.container;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    } else {
                        viewGroup3 = viewGroup2;
                    }
                    Context context2 = viewGroup3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "container.context");
                    d16 = new GuildFeedSquareFeedDescComponents.d(context2, GuildFeedSquareFeedDescComponents.this.getDepends());
                }
                return d16;
            }
        });
        this.legacyParseConfig = lazy5;
    }

    private final void e(SpannableStringBuilder spannableStringBuilder, GProStFeed gProStFeed) {
        if (av.f223852a.h(gProStFeed)) {
            FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
            ArrayList<GProStRichTextContent> arrayList = gProStFeed.title.contents;
            Intrinsics.checkNotNullExpressionValue(arrayList, "feedInfo.title.contents");
            Pair s16 = FeedRichTextContentParser.s(feedRichTextContentParser, arrayList, null, i(), null, null, 13, null);
            spannableStringBuilder.append((CharSequence) s16.getFirst()).append("\n");
            l().d((com.tencent.aio.widget.textView.view.b) s16.getSecond(), false);
        }
    }

    private final Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> f(GProStFeed feedInfo) {
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<GProStRichTextContent> arrayList = feedInfo.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "feedInfo.contents.contents");
        return feedRichTextContentParser.r(arrayList, this.depends.e(feedInfo), k(), String.valueOf(feedInfo.channelInfo.sign.channelId), String.valueOf(feedInfo.channelInfo.sign.guildId));
    }

    private final SpannableString h() {
        return (SpannableString) this.expandStringBuilder.getValue();
    }

    private final IParseRichTextConfig<Object> i() {
        return (IParseRichTextConfig) this.legacyParseConfig.getValue();
    }

    private final com.tencent.mobileqq.guild.feed.feedsquare.widget.m j() {
        return (com.tencent.mobileqq.guild.feed.feedsquare.widget.m) this.longClickProcessor.getValue();
    }

    private final IParseRichTextConfig<GProStRichTextContent> k() {
        return (IParseRichTextConfig) this.parseConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final wq0.l l() {
        return (wq0.l) this.txtView.getValue();
    }

    private final void q(GProStFeed feedInfo) {
        Long l3;
        Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> f16 = f(feedInfo);
        SpannableStringBuilder component1 = f16.component1();
        com.tencent.aio.widget.textView.view.b component2 = f16.component2();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        e(spannableStringBuilder, feedInfo);
        spannableStringBuilder.append((CharSequence) component1);
        ViewGroup viewGroup = null;
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            ViewGroup viewGroup2 = this.container;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            View view = l().getView();
            if (view.getParent() == null) {
                ViewGroup viewGroup3 = this.container;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    viewGroup3 = null;
                }
                viewGroup3.addView(view);
            }
            String str = feedInfo.idd;
            GProFeedMetaData gProFeedMetaData = feedInfo.meta;
            if (gProFeedMetaData != null) {
                l3 = Long.valueOf(gProFeedMetaData.lastModifiedTime);
            } else {
                l3 = null;
            }
            String s16 = s(feedInfo, str + "_" + l3);
            if (!this.depends.g().isEmpty()) {
                s16 = s16 + "_" + hashCode();
            }
            String str2 = s16;
            RichTextExpandStrSpanUtil richTextExpandStrSpanUtil = RichTextExpandStrSpanUtil.f221634a;
            View view2 = this.feedItemView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
                view2 = null;
            }
            richTextExpandStrSpanUtil.p(l(), spannableStringBuilder, (richTextExpandStrSpanUtil.h(view2) - view.getPaddingLeft()) - view.getPaddingRight(), INSTANCE.a(), h(), str2, k());
            l.a.a(l(), component2, false, 2, null);
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.v
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean r16;
                    r16 = GuildFeedSquareFeedDescComponents.r(view3, motionEvent);
                    return r16;
                }
            });
            view.setContentDescription(spannableStringBuilder);
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
    public static final boolean r(View view, MotionEvent motionEvent) {
        return false;
    }

    private final String s(GProStFeed feedInfo, String key) {
        List<qj1.u> b16 = GuildLongFeedContentComponents.INSTANCE.b(feedInfo);
        if (!b16.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            for (qj1.u uVar : b16) {
                sb5.append(uVar.getGroupName());
                sb5.append(uVar.getGroupAvatar());
                sb5.append(uVar.getGroupJoinAuth());
            }
            return key + sb5.toString().hashCode();
        }
        return key;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final c getDepends() {
        return this.depends;
    }

    @NotNull
    public int[] m() {
        return new int[]{R.id.x0u};
    }

    public void n(@NotNull ij1.g data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        GProStFeed b16 = data.b();
        if (b16 == null) {
            return;
        }
        wq0.l l3 = l();
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        ColorStateList colorStateList = viewGroup.getContext().getColorStateList(R.color.qui_common_text_primary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "container.context.getCol\u2026.qui_common_text_primary)");
        l3.setTextColor(colorStateList);
        q(b16);
    }

    public void o(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.feedItemView = containerView;
        View findViewById = containerView.findViewById(R.id.x0t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026feed_item_desc_container)");
        this.container = (ViewGroup) findViewById;
    }

    public final void p(boolean visible) {
        View view = null;
        if (visible) {
            View view2 = this.feedItemView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
                view2 = null;
            }
            if (view2 instanceof GuildFeedSquareFeedItemView) {
                view = view2;
            }
            GuildFeedSquareFeedItemView guildFeedSquareFeedItemView = (GuildFeedSquareFeedItemView) view;
            if (guildFeedSquareFeedItemView != null) {
                guildFeedSquareFeedItemView.j(j());
                return;
            }
            return;
        }
        View view3 = this.feedItemView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
            view3 = null;
        }
        if (view3 instanceof GuildFeedSquareFeedItemView) {
            view = view3;
        }
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView2 = (GuildFeedSquareFeedItemView) view;
        if (guildFeedSquareFeedItemView2 != null) {
            guildFeedSquareFeedItemView2.w(j());
        }
    }
}
