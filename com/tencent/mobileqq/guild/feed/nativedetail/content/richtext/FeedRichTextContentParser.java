package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.guild.aio.input.at.hashtag.ui.k;
import com.tencent.guild.aio.msglist.markdown.LinkSpanEntity;
import com.tencent.guild.aio.util.j;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.a;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.SpanClickHandler;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.g;
import com.tencent.mobileqq.guild.feed.widget.u;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.temp.api.IGuildAIOLinkSpanUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.ISpanRefreshCallback;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yn1.a;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0002\t\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJZ\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0018\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0007JO\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0018*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00192\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014J$\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00192\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014J\u0018\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\u0019J0\u0010+\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0019J@\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00192\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018Js\u00102\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u001b2\b\u00100\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u00101\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010!\u001a\u00020\u00192\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018\u00a2\u0006\u0004\b2\u00103Jl\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00192\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018J4\u0010@\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u001b2\b\b\u0002\u0010=\u001a\u00020\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>J_\u0010E\u001a\u0004\u0018\u00010\u00042\b\u0010B\u001a\u0004\u0018\u00010A2\b\u0010C\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010D\u001a\u0004\u0018\u00010\u001b2\u0006\u0010!\u001a\u00020\u00192\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018\u00a2\u0006\u0004\bE\u0010FJV\u0010K\u001a\u0004\u0018\u00010\u00042\u0006\u0010G\u001a\u00020A2\b\u0010H\u001a\u0004\u0018\u00010\u00062\b\u0010I\u001a\u0004\u0018\u00010\u00062\b\u0010J\u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\u00192\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018J\u001a\u0010O\u001a\u0004\u0018\u00010\u00122\b\u0010M\u001a\u0004\u0018\u00010L2\u0006\u0010N\u001a\u00020\u0006J\u000e\u0010Q\u001a\u00020&2\u0006\u0010P\u001a\u00020\u0019R\u0014\u0010T\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010V\u001a\u00020\u001b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010X\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010W\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/FeedRichTextContentParser;", "", "", "needDoubleTap", "Lcom/tencent/aio/widget/textView/view/b;", "e", "", "guildNumber", "needSelectable", "com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/FeedRichTextContentParser$a", "f", "(Ljava/lang/String;Z)Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/FeedRichTextContentParser$a;", "url", "com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/FeedRichTextContentParser$b", "g", "(Ljava/lang/String;Z)Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/FeedRichTextContentParser$b;", "T", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "parseConfig", "channelId", "guildId", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "r", "", "linkColor", "", "unMatchTypes", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/text/SpannableStringBuilder;IZZLjava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "j", "content", "l", "iconUrl", "", "k", "isShowLinkText", "Landroid/graphics/drawable/Drawable;", "icon", HippyTKDListViewAdapter.X, "displayText", "checkAdjacentContentWhitespace", "w", "channelType", "channelName", "isSquare", "i", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;Landroid/text/SpannableStringBuilder;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;Lkotlin/Pair;)Lcom/tencent/aio/widget/textView/view/b;", "type", "nick", "userId", "roleGroupName", "guildName", h.F, "serverId", "emojiType", "emoSize", "isAnim", "Lcom/tencent/mobileqq/text/ISpanRefreshCallback;", "callback", DomainData.DOMAIN_NAME, "", "topicId", "topicName", "showStatus", "u", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/text/SpannableStringBuilder;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;Lkotlin/Pair;)Lcom/tencent/aio/widget/textView/view/b;", "groupCode", "groupName", "groupAvatar", "groupJoinAuth", "v", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "feedJoinSign", "d", "builder", "t", "b", "I", "IMAGE_SPAN_RIGHT_PADDING", "c", "IMAGE_SPAN_BOUNDS", "Landroid/graphics/drawable/Drawable;", "TRANSPARENT", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedRichTextContentParser {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FeedRichTextContentParser f221393a = new FeedRichTextContentParser();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int IMAGE_SPAN_RIGHT_PADDING = ViewUtils.dpToPx(4.0f);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int IMAGE_SPAN_BOUNDS = ViewUtils.dpToPx(18.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public static final Drawable TRANSPARENT = ContextCompat.getDrawable(MobileQQ.sMobileQQ, R.drawable.f162601b70);

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/FeedRichTextContentParser$a", "Lcom/tencent/mobileqq/guild/feed/a$a;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/text/style/ClickableSpan;", TtmlNode.TAG_SPAN, "", "a", "", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements a.InterfaceC7734a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f221397a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f221398b;

        a(String str, boolean z16) {
            this.f221397a = str;
            this.f221398b = z16;
        }

        @Override // com.tencent.mobileqq.guild.feed.a.InterfaceC7734a
        public void a(@NotNull View widget, @NotNull ClickableSpan span) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intrinsics.checkNotNullParameter(span, "span");
            String str = this.f221397a;
            if (!o.c("fastClickGuard")) {
                SpanClickHandler.f221406a.d(widget, str);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.a.InterfaceC7734a
        public boolean b(@NotNull View widget, @NotNull ClickableSpan span) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intrinsics.checkNotNullParameter(span, "span");
            if (this.f221398b) {
                return false;
            }
            a(widget, span);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/richtext/FeedRichTextContentParser$b", "Lcom/tencent/mobileqq/guild/feed/a$a;", "Landroid/view/View;", "view", "", "c", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "Landroid/text/style/ClickableSpan;", TtmlNode.TAG_SPAN, "a", "", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements a.InterfaceC7734a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f221399a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f221400b;

        b(String str, boolean z16) {
            this.f221399a = str;
            this.f221400b = z16;
        }

        private final void c(View view) {
            Map<String, Object> paramsForView = VideoReport.paramsForView("clck", view);
            if (paramsForView != null) {
                String str = this.f221399a;
                paramsForView.put("eid", "em_sgrp_forum_editor_url");
                paramsForView.put("sgrp_url", str);
                VideoReport.reportEvent("clck", paramsForView);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.a.InterfaceC7734a
        public void a(@NotNull View widget, @NotNull ClickableSpan span) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intrinsics.checkNotNullParameter(span, "span");
            ((IGuildAIOLinkSpanUtilsApi) QRoute.api(IGuildAIOLinkSpanUtilsApi.class)).onClick(this.f221399a, "biz_src_jc_feed", widget);
            c(widget);
        }

        @Override // com.tencent.mobileqq.guild.feed.a.InterfaceC7734a
        public boolean b(@NotNull View widget, @NotNull ClickableSpan span) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Intrinsics.checkNotNullParameter(span, "span");
            if (this.f221400b) {
                return false;
            }
            com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.c.f221652a.e(widget, span, this.f221399a);
            c(widget);
            return true;
        }
    }

    FeedRichTextContentParser() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.aio.widget.textView.view.b e(boolean needDoubleTap) {
        if (needDoubleTap) {
            return new com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.click.a();
        }
        return new k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a f(String guildNumber, boolean needSelectable) {
        return new a(guildNumber, needSelectable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b g(String url, boolean needSelectable) {
        return new b(url, needSelectable);
    }

    public static /* synthetic */ SpannableStringBuilder o(FeedRichTextContentParser feedRichTextContentParser, String str, String str2, int i3, boolean z16, ISpanRefreshCallback iSpanRefreshCallback, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i16 & 16) != 0) {
            iSpanRefreshCallback = null;
        }
        return feedRichTextContentParser.n(str, str2, i3, z17, iSpanRefreshCallback);
    }

    public static /* synthetic */ Pair s(FeedRichTextContentParser feedRichTextContentParser, List list, JumpGuildParam.JoinInfoParam joinInfoParam, IParseRichTextConfig iParseRichTextConfig, String str, String str2, int i3, Object obj) {
        JumpGuildParam.JoinInfoParam joinInfoParam2;
        String str3;
        String str4;
        if ((i3 & 1) != 0) {
            joinInfoParam2 = null;
        } else {
            joinInfoParam2 = joinInfoParam;
        }
        if ((i3 & 2) != 0) {
            iParseRichTextConfig = IParseRichTextConfig.INSTANCE.a();
        }
        IParseRichTextConfig iParseRichTextConfig2 = iParseRichTextConfig;
        if ((i3 & 4) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        if ((i3 & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        return feedRichTextContentParser.r(list, joinInfoParam2, iParseRichTextConfig2, str3, str4);
    }

    @Nullable
    public final JumpGuildParam.JoinInfoParam d(@Nullable GuildFeedBaseInitBean initBean, @NotNull String feedJoinSign) {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        Intrinsics.checkNotNullParameter(feedJoinSign, "feedJoinSign");
        if (initBean == null) {
            return null;
        }
        int businessType = initBean.getBusinessType();
        if (businessType != 3 && businessType != 4) {
            if (businessType != 7) {
                if (businessType != 10) {
                    if (businessType != 19) {
                        return initBean.getJoinInfoParam();
                    }
                    joinInfoParam = initBean.getJoinInfoParam();
                    if (joinInfoParam == null) {
                        return null;
                    }
                    joinInfoParam.setJoinSignature(feedJoinSign);
                    return joinInfoParam;
                }
            } else {
                JumpGuildParam.JoinInfoParam joinInfoParam2 = new JumpGuildParam.JoinInfoParam();
                joinInfoParam2.setJoinSignature(feedJoinSign);
                return joinInfoParam2;
            }
        }
        joinInfoParam = initBean.getJoinInfoParam();
        if (joinInfoParam == null) {
            return null;
        }
        joinInfoParam.setJoinSignature(feedJoinSign);
        if (Intrinsics.areEqual(joinInfoParam.getMainSource(), "profile_card")) {
            joinInfoParam.setMainSource("mine");
        }
        if (Intrinsics.areEqual(joinInfoParam.getSubSource(), "channel_profile_card")) {
            joinInfoParam.setSubSource("mine_like");
        }
        return joinInfoParam;
    }

    @Nullable
    public final com.tencent.aio.widget.textView.view.b h(@Nullable final String channelId, @Nullable final String guildId, int type, @NotNull String nick, @NotNull final String userId, @NotNull String roleGroupName, @NotNull String guildName, @NotNull SpannableStringBuilder result, @NotNull IParseRichTextConfig<?> parseConfig, @NotNull Pair<Boolean, Boolean> checkAdjacentContentWhitespace) {
        String str;
        String str2;
        boolean z16;
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(roleGroupName, "roleGroupName");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        Intrinsics.checkNotNullParameter(checkAdjacentContentWhitespace, "checkAdjacentContentWhitespace");
        int n3 = parseConfig.n();
        boolean z17 = false;
        String str3 = "";
        if (type != 1) {
            if (type != 2) {
                if (type == 3 || type == 4) {
                    if (guildName.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        str = "@" + guildName;
                    }
                }
                str = "";
            } else {
                str = "@" + roleGroupName;
            }
        } else {
            str = "@" + nick;
        }
        if (str.length() > 0) {
            z17 = true;
        }
        if (z17) {
            if (checkAdjacentContentWhitespace.getFirst().booleanValue()) {
                str2 = "";
            } else {
                str2 = " ";
            }
            if (!checkAdjacentContentWhitespace.getSecond().booleanValue()) {
                str3 = " ";
            }
            String str4 = str2 + str + str3;
            int length = result.length();
            if (type == 1) {
                final int s16 = parseConfig.s();
                final HashMap<String, Object> c16 = parseConfig.c();
                d.c(result, length, str4, Integer.valueOf(n3), false, new Function2<View, ClickableSpan, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser$parseAtContent$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, ClickableSpan clickableSpan) {
                        invoke2(view, clickableSpan);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View widget, @NotNull ClickableSpan clickableSpan) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        Intrinsics.checkNotNullParameter(clickableSpan, "<anonymous parameter 1>");
                        SpanClickHandler.f221406a.b(widget, channelId, guildId, userId, s16, c16);
                    }
                }, 8, null);
                if (parseConfig.u()) {
                    d.f(str4, length, result, parseConfig.t(), parseConfig.getHighlightWords());
                }
                return e(parseConfig.j());
            }
            d.d(result, str4, Integer.valueOf(n3));
            if (parseConfig.u()) {
                d.f(str4, length, result, parseConfig.t(), parseConfig.getHighlightWords());
                return null;
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final com.tencent.aio.widget.textView.view.b i(@Nullable Integer channelType, @Nullable String channelName, @Nullable final String channelId, @Nullable final String guildId, @Nullable final Boolean isSquare, @Nullable final JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull SpannableStringBuilder result, @NotNull IParseRichTextConfig<?> parseConfig, @NotNull Pair<Boolean, Boolean> checkAdjacentContentWhitespace) {
        int i3;
        String str;
        Drawable h16;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        Intrinsics.checkNotNullParameter(checkAdjacentContentWhitespace, "checkAdjacentContentWhitespace");
        boolean z16 = false;
        if (channelName != null) {
            i3 = channelName.length();
        } else {
            i3 = 0;
        }
        if (i3 >= 1) {
            if (channelId == null || channelId.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                int n3 = parseConfig.n();
                boolean g16 = parseConfig.g();
                boolean booleanValue = checkAdjacentContentWhitespace.getFirst().booleanValue();
                String str2 = " ";
                if (!booleanValue) {
                    str = " ";
                } else {
                    str = "";
                }
                if (checkAdjacentContentWhitespace.getSecond().booleanValue()) {
                    str2 = "";
                }
                String str3 = str + channelName + str2;
                int length = result.length();
                final String f221023e = parseConfig.getF221023e();
                final HashMap<String, Object> c16 = parseConfig.c();
                final int q16 = parseConfig.q();
                d.c(result, length, str3, Integer.valueOf(n3), false, new Function2<View, ClickableSpan, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser$parseChannelInfoContent$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(View view, ClickableSpan clickableSpan) {
                        invoke2(view, clickableSpan);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View widget, @NotNull ClickableSpan span) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        Intrinsics.checkNotNullParameter(span, "span");
                        String str4 = guildId;
                        if (str4 != null) {
                            SpanClickHandler.f221406a.c(str4, channelId, isSquare, joinInfoParam, c16, widget, f221023e, q16 == 22);
                        }
                    }
                }, 8, null);
                if (parseConfig.u()) {
                    d.f(str3, length, result, parseConfig.t(), parseConfig.getHighlightWords());
                }
                if (g16 && (h16 = d.h(channelId, channelType, isSquare, n3, parseConfig.l())) != null) {
                    if (!booleanValue) {
                        length++;
                    }
                    d.k(result, length, h16);
                }
                return e(parseConfig.j());
            }
        }
        return null;
    }

    @Nullable
    public final com.tencent.aio.widget.textView.view.b j(@NotNull SpannableStringBuilder result, @NotNull IParseRichTextConfig<?> parseConfig) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        if (parseConfig.k()) {
            long currentTimeMillis = System.currentTimeMillis();
            g.Companion companion = g.INSTANCE;
            String spannableStringBuilder = result.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "result.toString()");
            int i3 = 0;
            for (a.GuildJumpEntity guildJumpEntity : companion.b(spannableStringBuilder, new IntRange(0, result.length()))) {
                long currentTimeMillis2 = System.currentTimeMillis();
                com.tencent.mobileqq.guild.feed.a[] existingSpans = (com.tencent.mobileqq.guild.feed.a[]) result.getSpans(guildJumpEntity.getStartIndex(), guildJumpEntity.getEndIndex(), com.tencent.mobileqq.guild.feed.a.class);
                Intrinsics.checkNotNullExpressionValue(existingSpans, "existingSpans");
                int length = existingSpans.length;
                for (int i16 = i3; i16 < length; i16++) {
                    result.removeSpan(existingSpans[i16]);
                }
                result.setSpan(new com.tencent.mobileqq.guild.feed.a(Integer.valueOf(parseConfig.n()), true, f221393a.f(guildJumpEntity.getGuildNumber(), parseConfig.e())), guildJumpEntity.getStartIndex(), guildJumpEntity.getEndIndex(), 33);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (currentTimeMillis3 > 10) {
                    QLog.wAsync("FeedRichTextContentParser", 1, "parseGuildJumpHashtag takes too long, forEach cost: " + currentTimeMillis3 + ", strLen: " + result.length());
                }
                i3 = 0;
            }
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis4 > 10) {
                QLog.wAsync("FeedRichTextContentParser", 4, "parseGuildJumpHashtag takes too long, cost: " + currentTimeMillis4 + ", strLen: " + result.length());
            }
            return e(parseConfig.j());
        }
        return null;
    }

    public final void k(@Nullable String iconUrl, @NotNull SpannableStringBuilder result) {
        boolean z16;
        Intrinsics.checkNotNullParameter(result, "result");
        if (iconUrl != null && iconUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = TRANSPARENT;
            obtain.mRetryCount = 3;
            URLDrawable drawable = URLDrawable.getDrawable(iconUrl, obtain);
            drawable.setBounds(0, 0, ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f));
            com.tencent.mobileqq.guild.feed.util.d dVar = new com.tencent.mobileqq.guild.feed.util.d(drawable);
            result.append("\u200b");
            result.setSpan(dVar, result.length() - 1, result.length(), 33);
        }
    }

    @Nullable
    public final com.tencent.aio.widget.textView.view.b l(@NotNull String content, @NotNull SpannableStringBuilder result, @NotNull IParseRichTextConfig<?> parseConfig) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        int length = result.length();
        result.append((CharSequence) new QQText(content, 3, parseConfig.getF221022d()));
        d.f(content, length, result, parseConfig.t(), parseConfig.getHighlightWords());
        if (content.length() < 1000 && parseConfig.o()) {
            List<LinkSpanEntity> b16 = j.b(j.f112409a, content, false, parseConfig.r(), 2, null);
            if (!b16.isEmpty()) {
                for (LinkSpanEntity linkSpanEntity : b16) {
                    result.setSpan(new com.tencent.mobileqq.guild.feed.a(Integer.valueOf(parseConfig.n()), false, f221393a.g(linkSpanEntity.getContent(), parseConfig.e())), linkSpanEntity.getStart() + length, linkSpanEntity.getEnd() + length, 33);
                }
            }
            return e(parseConfig.j());
        }
        return null;
    }

    @Nullable
    public final Object m(@NotNull SpannableStringBuilder spannableStringBuilder, int i3, boolean z16, boolean z17, @Nullable Set<Integer> set, @NotNull Continuation<? super Pair<? extends SpannableStringBuilder, ? extends com.tencent.aio.widget.textView.view.b>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FeedRichTextContentParser$parseLinkSpanAsync$2(spannableStringBuilder, set, i3, z17, z16, null), continuation);
    }

    @NotNull
    public final SpannableStringBuilder n(@NotNull String serverId, @NotNull String emojiType, int emoSize, boolean isAnim, @Nullable ISpanRefreshCallback callback) {
        Integer intOrNull;
        Integer intOrNull2;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(serverId, "serverId");
        Intrinsics.checkNotNullParameter(emojiType, "emojiType");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(serverId);
        if (intOrNull != null) {
            int intValue = intOrNull.intValue();
            intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(emojiType);
            if (intOrNull2 != null) {
                i3 = intOrNull2.intValue();
            } else {
                i3 = 1;
            }
            String convertEmoServerIdToEmoCode = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).convertEmoServerIdToEmoCode(intValue, i3);
            if (isAnim) {
                i16 = 5;
            } else {
                i16 = 3;
            }
            spannableStringBuilder.append(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(convertEmoServerIdToEmoCode, emoSize, i16, null, callback));
        }
        return spannableStringBuilder;
    }

    @JvmOverloads
    @NotNull
    public final <T> Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> p(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return s(this, list, null, null, null, null, 15, null);
    }

    @JvmOverloads
    @NotNull
    public final <T> Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> q(@NotNull List<? extends T> list, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull IParseRichTextConfig<T> parseConfig) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        return s(this, list, joinInfoParam, parseConfig, null, null, 12, null);
    }

    @JvmOverloads
    @NotNull
    public final <T> Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> r(@NotNull List<? extends T> list, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull IParseRichTextConfig<T> parseConfig, @Nullable String str, @Nullable String str2) {
        Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> a16;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        if (list.isEmpty()) {
            return new Pair<>(new SpannableStringBuilder(), null);
        }
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.b a17 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.a.a(list);
        if (a17 == null || (a16 = a17.a(list, joinInfoParam, parseConfig, str, str2)) == null) {
            return new Pair<>(new SpannableStringBuilder(), null);
        }
        return a16;
    }

    public final void t(@NotNull SpannableStringBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object[] spans = builder.getSpans(0, builder.length(), com.tencent.mobileqq.guild.feed.a.class);
        Intrinsics.checkNotNullExpressionValue(spans, "builder.getSpans(0, buil\u2026lickableSpan::class.java)");
        for (Object obj : spans) {
            builder.removeSpan((com.tencent.mobileqq.guild.feed.a) obj);
        }
        Object[] spans2 = builder.getSpans(0, builder.length(), ForegroundColorSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans2, "builder.getSpans(0, buil\u2026undColorSpan::class.java)");
        for (Object obj2 : spans2) {
            builder.removeSpan((ForegroundColorSpan) obj2);
        }
    }

    @Nullable
    public final com.tencent.aio.widget.textView.view.b u(@Nullable final Long topicId, @Nullable String topicName, @Nullable final String guildId, @Nullable Integer showStatus, @NotNull SpannableStringBuilder result, @NotNull IParseRichTextConfig<?> parseConfig, @NotNull Pair<Boolean, Boolean> checkAdjacentContentWhitespace) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        Intrinsics.checkNotNullParameter(checkAdjacentContentWhitespace, "checkAdjacentContentWhitespace");
        if (topicName != null && topicName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        int length = result.length();
        if (showStatus != null && showStatus.intValue() == 1) {
            String str2 = " ";
            if (!checkAdjacentContentWhitespace.getFirst().booleanValue()) {
                str = " ";
            } else {
                str = "";
            }
            if (checkAdjacentContentWhitespace.getSecond().booleanValue()) {
                str2 = "";
            }
            final String str3 = str + topicName + str2;
            final String f221023e = parseConfig.getF221023e();
            final HashMap<String, Object> c16 = parseConfig.c();
            final int q16 = parseConfig.q();
            d.c(result, length, str3, Integer.valueOf(parseConfig.n()), false, new Function2<View, ClickableSpan, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser$parseTopicContent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, ClickableSpan clickableSpan) {
                    invoke2(view, clickableSpan);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View widget, @NotNull ClickableSpan clickableSpan) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    Intrinsics.checkNotNullParameter(clickableSpan, "<anonymous parameter 1>");
                    SpanClickHandler.f221406a.e(topicId, guildId, widget, str3, f221023e, c16, q16);
                }
            }, 8, null);
            if (parseConfig.u()) {
                d.f(str3, length, result, parseConfig.t(), parseConfig.getHighlightWords());
            }
            return e(parseConfig.j());
        }
        if (showStatus == null || showStatus.intValue() != 2) {
            return null;
        }
        result.append((CharSequence) topicName);
        if (!parseConfig.u()) {
            return null;
        }
        d.f(topicName, length, result, parseConfig.t(), parseConfig.getHighlightWords());
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x009a, code lost:
    
        if (r13 != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d2  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.tencent.aio.widget.textView.view.b v(final long groupCode, @Nullable String groupName, @Nullable String groupAvatar, @Nullable final String groupJoinAuth, @NotNull SpannableStringBuilder result, @NotNull IParseRichTextConfig<?> parseConfig, @NotNull Pair<Boolean, Boolean> checkAdjacentContentWhitespace) {
        boolean z16;
        boolean z17;
        CharSequence charSequence;
        boolean z18;
        boolean z19;
        CharSequence trim;
        boolean z26;
        boolean z27;
        boolean isBlank;
        boolean isBlank2;
        boolean startsWith$default;
        boolean isBlank3;
        Integer num;
        String str = groupAvatar;
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        Intrinsics.checkNotNullParameter(checkAdjacentContentWhitespace, "checkAdjacentContentWhitespace");
        final int q16 = parseConfig.q();
        int n3 = parseConfig.n();
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            Logger.a d16 = logger.d();
            if (groupJoinAuth != null) {
                num = Integer.valueOf(groupJoinAuth.length());
            } else {
                num = null;
            }
            d16.d("FeedRichTextContentParser", 1, "[parseTroopContent] fromBusinessType: " + q16 + ", groupCode " + groupCode + ", groupName " + groupName + ", groupAvatar " + str + ", groupJoinAuth " + num);
        }
        if (q16 == 21) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (str != null) {
            isBlank3 = StringsKt__StringsJVMKt.isBlank(groupAvatar);
            if (!isBlank3) {
                z17 = false;
                if (!z17) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null);
                }
                str = ITroopAvatarUtilApi.REGEXP_URL_STRING + groupCode + "/" + groupCode + "/100";
                String str2 = "";
                if (!checkAdjacentContentWhitespace.getFirst().booleanValue()) {
                    charSequence = "";
                } else {
                    charSequence = " ";
                }
                result.append(charSequence);
                int dpToPx = ViewUtils.dpToPx(18.0f);
                int dpToPx2 = ViewUtils.dpToPx(2.0f);
                URLDrawable icon = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
                icon.setBounds(0, 0, dpToPx, dpToPx);
                icon.setDecodeHandler(d.i(dpToPx, dpToPx, dpToPx2));
                int length = result.length();
                result.insert(length, " ");
                Intrinsics.checkNotNullExpressionValue(icon, "icon");
                u uVar = new u(icon, 1);
                uVar.a(0, IMAGE_SPAN_RIGHT_PADDING);
                result.setSpan(uVar, length, length + 1, 33);
                if (groupName != null) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(groupName);
                    if (!isBlank2) {
                        z18 = false;
                        if (!z18) {
                            if (!checkAdjacentContentWhitespace.getSecond().booleanValue()) {
                                str2 = " ";
                            }
                            trim = StringsKt__StringsKt.trim((CharSequence) groupName);
                            String str3 = trim.toString() + str2;
                            int length2 = result.length();
                            if (groupJoinAuth != null) {
                                isBlank = StringsKt__StringsJVMKt.isBlank(groupJoinAuth);
                                if (!isBlank) {
                                    z26 = false;
                                    if (z26) {
                                        final HashMap<String, Object> c16 = parseConfig.c();
                                        Integer valueOf = Integer.valueOf(n3);
                                        final boolean z28 = z16;
                                        d.c(result, length2, str3, valueOf, false, new Function2<View, ClickableSpan, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser$parseTroopContent$2
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(View view, ClickableSpan clickableSpan) {
                                                invoke2(view, clickableSpan);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@NotNull View widget, @NotNull ClickableSpan span) {
                                                Intrinsics.checkNotNullParameter(widget, "widget");
                                                Intrinsics.checkNotNullParameter(span, "span");
                                                SpanClickHandler.f221406a.f(String.valueOf(groupCode), groupJoinAuth, widget, z28);
                                                HashMap hashMap = new HashMap();
                                                HashMap<String, Object> hashMap2 = c16;
                                                long j3 = groupCode;
                                                hashMap.putAll(hashMap2);
                                                hashMap.put("group_id", Long.valueOf(j3));
                                                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(widget, q16 == 22 ? "em_sgrp_forum_editor_layer_group" : "em_sgrp_forum_editor_group", "clck", hashMap);
                                            }
                                        }, 8, null);
                                        z27 = true;
                                    } else {
                                        d.d(result, str3, Integer.valueOf(n3));
                                        z27 = false;
                                    }
                                    if (parseConfig.u()) {
                                        d.f(str3, length2, result, parseConfig.t(), parseConfig.getHighlightWords());
                                    }
                                    z19 = z27;
                                }
                            }
                            z26 = true;
                            if (z26) {
                            }
                            if (parseConfig.u()) {
                            }
                            z19 = z27;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            return e(parseConfig.j());
                        }
                        return null;
                    }
                }
                z18 = true;
                if (!z18) {
                }
                if (z19) {
                }
            }
        }
        z17 = true;
        if (!z17) {
        }
        str = ITroopAvatarUtilApi.REGEXP_URL_STRING + groupCode + "/" + groupCode + "/100";
        String str22 = "";
        if (!checkAdjacentContentWhitespace.getFirst().booleanValue()) {
        }
        result.append(charSequence);
        int dpToPx3 = ViewUtils.dpToPx(18.0f);
        int dpToPx22 = ViewUtils.dpToPx(2.0f);
        URLDrawable icon2 = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
        icon2.setBounds(0, 0, dpToPx3, dpToPx3);
        icon2.setDecodeHandler(d.i(dpToPx3, dpToPx3, dpToPx22));
        int length3 = result.length();
        result.insert(length3, " ");
        Intrinsics.checkNotNullExpressionValue(icon2, "icon");
        u uVar2 = new u(icon2, 1);
        uVar2.a(0, IMAGE_SPAN_RIGHT_PADDING);
        result.setSpan(uVar2, length3, length3 + 1, 33);
        if (groupName != null) {
        }
        z18 = true;
        if (!z18) {
        }
        if (z19) {
        }
    }

    @Nullable
    public final com.tencent.aio.widget.textView.view.b w(@NotNull String url, @NotNull String displayText, @NotNull SpannableStringBuilder result, @NotNull IParseRichTextConfig<?> parseConfig, @NotNull Pair<Boolean, Boolean> checkAdjacentContentWhitespace) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        Intrinsics.checkNotNullParameter(checkAdjacentContentWhitespace, "checkAdjacentContentWhitespace");
        boolean z17 = true;
        if (displayText.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            displayText = url;
        }
        if (!checkAdjacentContentWhitespace.getSecond().booleanValue()) {
            str = " ";
        } else {
            str = "";
        }
        String str2 = displayText + str;
        if (str2.length() <= 0) {
            z17 = false;
        }
        if (!z17) {
            return null;
        }
        int length = result.length();
        Boolean first = checkAdjacentContentWhitespace.getFirst();
        if (first.booleanValue()) {
            first = null;
        }
        Boolean bool = first;
        if (bool != null) {
            bool.booleanValue();
            result.append(" ");
        }
        result.append((CharSequence) str2);
        if (parseConfig.b()) {
            return null;
        }
        result.setSpan(new com.tencent.mobileqq.guild.feed.a(Integer.valueOf(parseConfig.n()), false, g(url, parseConfig.e())), length, result.length(), 33);
        if (parseConfig.u()) {
            d.f(str2, length, result, parseConfig.t(), parseConfig.getHighlightWords());
        }
        return e(parseConfig.j());
    }

    public final void x(boolean needSelectable, boolean isShowLinkText, @Nullable Drawable icon, @NotNull String url, @NotNull SpannableStringBuilder result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        if (isShowLinkText) {
            result.append((CharSequence) BaseApplication.getContext().getString(R.string.f145740sa));
            result.append(" ");
        } else {
            if (icon == null) {
                return;
            }
            icon.setBounds(0, 0, ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f));
            result.append("\u200b");
            result.setSpan(new com.tencent.mobileqq.guild.feed.util.d(icon, 2), result.length() - 1, result.length(), 33);
            result.setSpan(new com.tencent.mobileqq.guild.feed.a(null, false, g(url, needSelectable)), result.length() - 1, result.length(), 33);
            result.append(" ");
        }
    }
}
