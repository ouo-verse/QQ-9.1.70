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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.LongFeedVideoView;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.RichTextExpandStrSpanUtil;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView;
import com.tencent.mobileqq.guild.feed.widget.GuildRoundBubbleImageView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004tuv:B\u000f\u0012\u0006\u0010<\u001a\u000209\u00a2\u0006\u0004\br\u0010sJ\b\u0010\u0005\u001a\u00020\u0004H\u0003J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001aH\u0016J(\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-J\u000e\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020-J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\u0004J\u0006\u00106\u001a\u00020\u0004J\f\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u000107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010AR\u0016\u0010K\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010JR\u0016\u0010M\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010QR\u0016\u0010S\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00105R\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010U\u001a\u0004\bV\u0010WR2\u0010]\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001e0Zj\b\u0012\u0004\u0012\u00020\u001e`[0Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\\R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00105R\u001b\u0010a\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010U\u001a\u0004\b_\u0010`R\u001b\u0010e\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010U\u001a\u0004\bc\u0010dR!\u0010j\u001a\b\u0012\u0004\u0012\u00020g0f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010U\u001a\u0004\bh\u0010iR!\u0010l\u001a\b\u0012\u0004\u0012\u00020g0f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010U\u001a\u0004\bk\u0010iR\u0014\u0010o\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010q\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bp\u0010n\u00a8\u0006w"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lij1/g;", "Lcom/tencent/biz/richframework/animation/transition/TransitionHelper$TransitionBeanCreator;", "", "M", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", QCircleScheme.AttrDetail.FEED_INFO, "k", "N", "stFeed", "", "position", "j", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "stVideo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "cover", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L", "Lcom/tencent/mobileqq/guild/feed/widget/GuildRoundBubbleImageView;", "o", "", "url", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, DomainData.DOMAIN_NAME, "Landroid/view/View;", "view", "H", "", "Lcom/tencent/mobileqq/guild/feed/adapter/n;", "w", "u", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "containerView", UserInfo.SEX_FEMALE, "data", "", "", "payload", BdhLogUtil.LogTag.Tag_Conn, "currentPos", "Lcom/tencent/biz/richframework/animation/transition/TransitionBean;", "generateTransitionBean", "", NodeProps.VISIBLE, "G", "attached", "B", "D", "K", "J", "I", "E", "Lcom/tencent/mobileqq/guild/feed/video/GuildFeedListBaseVideoView;", "y", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "depends", "e", "Lij1/g;", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "titleContainerView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "titleView", "i", "mediaParentContainer", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "Lcom/tencent/mobileqq/guild/media/widget/RoundCornerLayout;", "mediaContainer", "Landroid/view/View;", "gifLabel", "Lcom/tencent/mobileqq/guild/feed/widget/GuildRoundBubbleImageView;", "contentBgIv", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "playView", "mTransitionBeanCreatorKey", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "Lkotlin/Lazy;", "v", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/AbsGuildFeedMediaSizeUtils;", "mediaSizeUtils", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/Pair;", "mMixedMediaDataPair", "Lwq0/l;", ReportConstant.COSTREPORT_PREFIX, "()Lwq0/l;", "contentTextView", "Landroid/text/SpannableString;", "t", "()Landroid/text/SpannableString;", "expandStringBuilder", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "titleParseConfig", "r", "contentParseConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", "containerWidth", "p", "containerHeight", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;)V", "a", "b", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildLongFeedContentComponents extends a<ij1.g> implements TransitionHelper.TransitionBeanCreator {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float P = qr0.a.a(8);
    private static int Q = qr0.a.a(178);

    /* renamed from: C, reason: from kotlin metadata */
    private View gifLabel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GuildRoundBubbleImageView contentBgIv;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LongFeedVideoView playView;

    /* renamed from: F, reason: from kotlin metadata */
    private int mTransitionBeanCreatorKey;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaSizeUtils;

    /* renamed from: H, reason: from kotlin metadata */
    private Pair<String, ? extends ArrayList<com.tencent.mobileqq.guild.feed.adapter.n>> mMixedMediaDataPair;

    /* renamed from: I, reason: from kotlin metadata */
    private int position;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentTextView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy expandStringBuilder;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy titleParseConfig;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentParseConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ij1.g data;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup titleContainerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView titleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mediaParentContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundCornerLayout mediaContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0007J\u0016\u0010\t\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006*\u00020\u0002H\u0007R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$a;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "", "d", "c", "", "Lqj1/u;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/ITroopContentDisplayable;", "b", "", "IMAGE_CONTAINER_HEIGHT_PX", "I", "a", "()I", "setIMAGE_CONTAINER_HEIGHT_PX", "(I)V", "", "CONTENT_TOP_MARGIN", UserInfo.SEX_FEMALE, "FONT_WEIGHT", "IMAGE_VIEW_RADIUS_DP", "LONG_FEED_MEDIA_RATIO", "MAX_LINES", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean d(GProStFeed gProStFeed) {
            Object obj;
            boolean z16;
            int i3;
            ArrayList<GProStRichTextContent> contentLi = gProStFeed.contents.contents;
            Intrinsics.checkNotNullExpressionValue(contentLi, "contentLi");
            Iterator<T> it = contentLi.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    GProStRichTextContent gProStRichTextContent = (GProStRichTextContent) obj;
                    if (gProStRichTextContent.type == 3 && ((i3 = gProStRichTextContent.urlContent.type) == 1 || i3 == 3)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((GProStRichTextContent) obj) == null) {
                return false;
            }
            return true;
        }

        public final int a() {
            return GuildLongFeedContentComponents.Q;
        }

        @JvmStatic
        @NotNull
        public final List<qj1.u> b(@NotNull GProStFeed gProStFeed) {
            Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
            return FeedMixedMediaDataCompatTool.f221103a.i(gProStFeed);
        }

        @JvmStatic
        public final boolean c(@NotNull GProStFeed gProStFeed) {
            boolean z16;
            Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
            if (!gProStFeed.images.isEmpty() || !gProStFeed.videos.isEmpty() || d(gProStFeed)) {
                return false;
            }
            GProStImage cover = gProStFeed.cover;
            Intrinsics.checkNotNullExpressionValue(cover, "cover");
            if (bm.h(cover).length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020'\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0013\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017H\u0096\u0001J\b\u0010\u0019\u001a\u00020\nH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010(R\u0014\u0010,\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "g", "i", "j", tl.h.F, "u", "e", "d", "b", "", "r", "p", "", "v", "t", HippyTKDListViewAdapter.X, "Landroid/graphics/drawable/Drawable;", "w", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "k", "o", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "depends", DomainData.DOMAIN_NAME, "()I", "linkColor", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static class b implements IParseRichTextConfig<GProStRichTextContent> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c depends;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f219138d;

        public b(@NotNull Context context, @NotNull c depends) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(depends, "depends");
            this.context = context;
            this.depends = depends;
            this.f219138d = IParseRichTextConfig.INSTANCE.a();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f219138d.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f219138d.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f219138d.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f219138d.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return TrimSpaceType.LeadingSpaceAndEmptyLine;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f219138d.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221023e() {
            return this.f219138d.getF221023e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f219138d.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f219138d.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f219138d.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f219138d.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f219138d.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221022d() {
            return 15;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f219138d.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f219138d.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f219138d.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.context.getResources().getColor(R.color.qui_common_brand_standard);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f219138d.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public List<String> getHighlightWords() {
            return this.depends.k();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c cVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c.f221632a;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c.c(cVar, t16, context, null, 4, null);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            if (t16.urlContent.type != 1) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u000bH&J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "", "Landroid/view/View;", "getRootView", "", "", "k", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "getInitBean", "Lxj1/f;", "j", "", "a", "view", "elementId", "", "c", "", "f", "g", tl.h.F, "i", "d", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "e", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a {
            public static float a(@NotNull c cVar) {
                return 26.0f;
            }

            @Nullable
            public static IParseRichTextConfig<GProStRichTextContent> b(@NotNull c cVar, @NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return null;
            }

            public static float c(@NotNull c cVar) {
                return 16.0f;
            }

            public static int d(@NotNull c cVar) {
                return 600;
            }

            public static float e(@NotNull c cVar) {
                return 26.0f;
            }

            @Nullable
            public static IParseRichTextConfig<GProStRichTextContent> f(@NotNull c cVar, @NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return null;
            }

            public static float g(@NotNull c cVar) {
                return 18.0f;
            }
        }

        int a();

        @Nullable
        IParseRichTextConfig<GProStRichTextContent> b(@NotNull Context context);

        void c(@Nullable View view, @NotNull String elementId);

        float d();

        @Nullable
        IParseRichTextConfig<GProStRichTextContent> e(@NotNull Context context);

        float f();

        float g();

        @NotNull
        GuildFeedBaseInitBean getInitBean();

        @NotNull
        View getRootView();

        int h();

        float i();

        @Nullable
        xj1.f j();

        @NotNull
        List<String> k();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010&\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020'\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001cH\u0096\u0001J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001eH\u0096\u0001J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010(R\u0014\u0010,\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "Landroid/graphics/drawable/Drawable;", "w", ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "g", "i", "j", tl.h.F, "u", "e", "d", HippyTKDListViewAdapter.X, "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", "o", "", "v", "k", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "depends", DomainData.DOMAIN_NAME, "()I", "linkColor", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static class d implements IParseRichTextConfig<GProStRichTextContent> {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Context context;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c depends;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f219141d;

        public d(@NotNull Context context, @NotNull c depends) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(depends, "depends");
            this.context = context;
            this.depends = depends;
            this.f219141d = IParseRichTextConfig.INSTANCE.a();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f219141d.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f219141d.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f219141d.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f219141d.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return this.f219141d.f();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f219141d.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221023e() {
            return this.f219141d.getF221023e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f219141d.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f219141d.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f219141d.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f219141d.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f219141d.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221022d() {
            return this.f219141d.getF221022d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f219141d.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f219141d.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f219141d.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.context.getResources().getColor(R.color.qui_common_brand_standard);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f219141d.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public List<String> getHighlightWords() {
            return this.depends.k();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f219141d.m(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f219141d.a(t16);
        }
    }

    public GuildLongFeedContentComponents(@NotNull c depends) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AbsGuildFeedMediaSizeUtils>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents$mediaSizeUtils$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AbsGuildFeedMediaSizeUtils invoke() {
                RoundCornerLayout roundCornerLayout;
                roundCornerLayout = GuildLongFeedContentComponents.this.mediaContainer;
                if (roundCornerLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                    roundCornerLayout = null;
                }
                return com.tencent.mobileqq.guild.feed.feedsquare.utils.g.b(roundCornerLayout);
            }
        });
        this.mediaSizeUtils = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<wq0.l>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents$contentTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final wq0.l invoke() {
                ViewGroup viewGroup;
                GuildLongFeedContentComponents.c cVar;
                GuildLongFeedContentComponents.c cVar2;
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.f221402a;
                viewGroup = GuildLongFeedContentComponents.this.titleContainerView;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleContainerView");
                    viewGroup = null;
                }
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "titleContainerView.context");
                cVar = GuildLongFeedContentComponents.this.depends;
                wq0.l d16 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.d(bVar, context, cVar.i(), 2, 0.0f, R.color.qui_common_text_primary, 8, null);
                GuildLongFeedContentComponents guildLongFeedContentComponents = GuildLongFeedContentComponents.this;
                d16.setFontWeight(300);
                cVar2 = guildLongFeedContentComponents.depends;
                ci1.a.h(d16, cVar2.d());
                return d16;
            }
        });
        this.contentTextView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SpannableString>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents$expandStringBuilder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SpannableString invoke() {
                RichTextExpandStrSpanUtil richTextExpandStrSpanUtil = RichTextExpandStrSpanUtil.f221634a;
                ViewGroup viewGroup = GuildLongFeedContentComponents.this.mediaParentContainer;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
                    viewGroup = null;
                }
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mediaParentContainer.context");
                return richTextExpandStrSpanUtil.j(context);
            }
        });
        this.expandStringBuilder = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IParseRichTextConfig<GProStRichTextContent>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents$titleParseConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IParseRichTextConfig<GProStRichTextContent> invoke() {
                GuildLongFeedContentComponents.c cVar;
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                GuildLongFeedContentComponents.c cVar2;
                cVar = GuildLongFeedContentComponents.this.depends;
                viewGroup = GuildLongFeedContentComponents.this.titleContainerView;
                ViewGroup viewGroup3 = null;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleContainerView");
                    viewGroup = null;
                }
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "titleContainerView.context");
                IParseRichTextConfig<GProStRichTextContent> e16 = cVar.e(context);
                if (e16 == null) {
                    viewGroup2 = GuildLongFeedContentComponents.this.titleContainerView;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleContainerView");
                    } else {
                        viewGroup3 = viewGroup2;
                    }
                    Context context2 = viewGroup3.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "titleContainerView.context");
                    cVar2 = GuildLongFeedContentComponents.this.depends;
                    e16 = new GuildLongFeedContentComponents.d(context2, cVar2);
                }
                return e16;
            }
        });
        this.titleParseConfig = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IParseRichTextConfig<GProStRichTextContent>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents$contentParseConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IParseRichTextConfig<GProStRichTextContent> invoke() {
                GuildLongFeedContentComponents.c cVar;
                GuildLongFeedContentComponents.c cVar2;
                cVar = GuildLongFeedContentComponents.this.depends;
                ViewGroup viewGroup = GuildLongFeedContentComponents.this.mediaParentContainer;
                ViewGroup viewGroup2 = null;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
                    viewGroup = null;
                }
                Context context = viewGroup.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mediaParentContainer.context");
                IParseRichTextConfig<GProStRichTextContent> b16 = cVar.b(context);
                if (b16 == null) {
                    ViewGroup viewGroup3 = GuildLongFeedContentComponents.this.mediaParentContainer;
                    if (viewGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
                    } else {
                        viewGroup2 = viewGroup3;
                    }
                    Context context2 = viewGroup2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "mediaParentContainer.context");
                    cVar2 = GuildLongFeedContentComponents.this.depends;
                    b16 = new GuildLongFeedContentComponents.b(context2, cVar2);
                }
                return b16;
            }
        });
        this.contentParseConfig = lazy5;
    }

    private final void A(String url) {
        String str;
        Drawable drawable;
        GuildRoundBubbleImageView guildRoundBubbleImageView = this.contentBgIv;
        if (guildRoundBubbleImageView != null) {
            Pair pair = TuplesKt.to(Integer.valueOf(q()), Integer.valueOf(p()));
            ij1.g gVar = this.data;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                gVar = null;
            }
            GuildTaskProgressState p16 = gVar.p();
            if (p16 != null) {
                str = p16.mTaskId;
            } else {
                str = null;
            }
            GuildRoundBubbleImageView guildRoundBubbleImageView2 = this.contentBgIv;
            if (guildRoundBubbleImageView2 != null) {
                drawable = GuildFeedListImageExKt.c(guildRoundBubbleImageView2);
            } else {
                drawable = null;
            }
            GuildFeedListImageExKt.g(guildRoundBubbleImageView, url, pair, str, drawable, null, false, false, false, null, com.tencent.luggage.wxa.ig.w.CTRL_INDEX, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(View view) {
        ImageView imageView;
        Drawable drawable;
        GProStFeed u16 = u();
        if (u16 == null) {
            return;
        }
        n();
        com.tencent.mobileqq.guild.feed.feedsquare.utils.j jVar = com.tencent.mobileqq.guild.feed.feedsquare.utils.j.f219338a;
        Pair<String, ? extends ArrayList<com.tencent.mobileqq.guild.feed.adapter.n>> pair = this.mMixedMediaDataPair;
        ViewGroup viewGroup = null;
        if (pair == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataPair");
            pair = null;
        }
        GuildFeedGalleryInitBean c16 = jVar.c(pair.getSecond(), 0, this.depends.getInitBean(), view);
        c16.setFeed(u16);
        c16.setTransitionBeanCreatorKey(this.mTransitionBeanCreatorKey);
        c16.setImmersiveSource(this.depends.a());
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            drawable = imageView.getDrawable();
        } else {
            drawable = null;
        }
        TransitionAnimUtil.saveCoverDrawable(drawable);
        ViewGroup viewGroup2 = this.mediaParentContainer;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
        } else {
            viewGroup = viewGroup2;
        }
        GuildFeedLauncher.z(viewGroup.getContext(), c16, view);
    }

    private final void L(GProStFeed stFeed) {
        int i3;
        if (this.contentBgIv == null) {
            this.contentBgIv = o();
        }
        RoundCornerLayout roundCornerLayout = this.mediaContainer;
        View view = null;
        if (roundCornerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
            roundCornerLayout = null;
        }
        roundCornerLayout.removeAllViews();
        GuildRoundBubbleImageView guildRoundBubbleImageView = this.contentBgIv;
        if (guildRoundBubbleImageView != null) {
            ViewExtKt.a(guildRoundBubbleImageView);
        }
        RoundCornerLayout roundCornerLayout2 = this.mediaContainer;
        if (roundCornerLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
            roundCornerLayout2 = null;
        }
        roundCornerLayout2.addView(this.contentBgIv);
        com.tencent.mobileqq.guild.feed.util.n c16 = com.tencent.mobileqq.guild.feed.util.m.c(stFeed);
        View view2 = this.gifLabel;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifLabel");
        } else {
            view = view2;
        }
        if (c16.getType() == 1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (!TextUtils.isEmpty(c16.getUrl())) {
            A(c16.getUrl());
        } else if (!TextUtils.isEmpty(stFeed.defaultBackgroundImg)) {
            A(stFeed.defaultBackgroundImg);
        }
    }

    @RequiresApi(api = 22)
    private final void M() {
        GuildRoundBubbleImageView guildRoundBubbleImageView = this.contentBgIv;
        if (guildRoundBubbleImageView != null) {
            guildRoundBubbleImageView.setAccessibilityTraversalBefore(R.id.wbi);
        }
        GuildRoundBubbleImageView guildRoundBubbleImageView2 = this.contentBgIv;
        if (guildRoundBubbleImageView2 != null) {
            guildRoundBubbleImageView2.setContentDescription(QQGuildUIUtil.r(R.string.f14867108));
        }
    }

    private final void N() {
        Logger logger = Logger.f235387a;
        ViewGroup viewGroup = null;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            ViewGroup viewGroup2 = this.mediaParentContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
                viewGroup2 = null;
            }
            int measuredWidth = viewGroup2.getMeasuredWidth();
            ViewGroup viewGroup3 = this.mediaParentContainer;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
                viewGroup3 = null;
            }
            d16.d("GuildLongFeedContentComponents", 1, "updateContainerSize from " + measuredWidth + HippyTKDListViewAdapter.X + viewGroup3.getMeasuredHeight() + " to " + q() + HippyTKDListViewAdapter.X + p());
        }
        ViewGroup viewGroup4 = this.mediaParentContainer;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
        } else {
            viewGroup = viewGroup4;
        }
        com.tencent.mobileqq.guild.feed.feedsquare.utils.o.a(viewGroup, q(), p());
    }

    private final void j(GProStFeed stFeed, int position) {
        N();
        if (bm.r(stFeed)) {
            GProStVideo gProStVideo = stFeed.videos.get(0);
            Intrinsics.checkNotNullExpressionValue(gProStVideo, "stFeed.videos[0]");
            GProStImage gProStImage = stFeed.cover;
            Intrinsics.checkNotNullExpressionValue(gProStImage, "stFeed.cover");
            m(gProStVideo, gProStImage, position);
            return;
        }
        L(stFeed);
    }

    private final void k(GProStFeed feedInfo) {
        wq0.l s16 = s();
        ViewGroup viewGroup = this.mediaParentContainer;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
            viewGroup = null;
        }
        ColorStateList colorStateList = viewGroup.getContext().getColorStateList(R.color.qui_common_text_primary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "mediaParentContainer.con\u2026.qui_common_text_primary)");
        s16.setTextColor(colorStateList);
        View view = s().getView();
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<GProStRichTextContent> arrayList = feedInfo.title.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "feedInfo.title.contents");
        textView.setText((CharSequence) FeedRichTextContentParser.s(feedRichTextContentParser, arrayList, null, x(), null, null, 13, null).getFirst());
        ArrayList<GProStRichTextContent> contents = feedInfo.contents.contents;
        GuildFeedBaseInitBean initBean = this.depends.getInitBean();
        String str = feedInfo.channelInfo.sign.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(str, "feedInfo.channelInfo.sign.joinGuildSig");
        JumpGuildParam.JoinInfoParam d16 = feedRichTextContentParser.d(initBean, str);
        String valueOf = String.valueOf(feedInfo.channelInfo.sign.channelId);
        String valueOf2 = String.valueOf(feedInfo.channelInfo.sign.guildId);
        IParseRichTextConfig<GProStRichTextContent> r16 = r();
        Intrinsics.checkNotNullExpressionValue(contents, "contents");
        Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> r17 = feedRichTextContentParser.r(contents, d16, r16, valueOf, valueOf2);
        SpannableStringBuilder first = r17.getFirst();
        String str2 = feedInfo.idd;
        if (str2 == null) {
            str2 = "";
        }
        int c16 = (((int) v().c()) - view.getPaddingLeft()) - view.getPaddingRight();
        if (!this.depends.k().isEmpty()) {
            str2 = str2 + "_" + hashCode();
        }
        String str3 = str2;
        com.tencent.aio.widget.textView.view.b second = r17.getSecond();
        if (second != null) {
            l.a.a(s(), second, false, 2, null);
        }
        if (!TextUtils.isEmpty(first)) {
            RichTextExpandStrSpanUtil.f221634a.p(s(), first, c16, 2, t(), str3, r());
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.at
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean l3;
                    l3 = GuildLongFeedContentComponents.l(view2, motionEvent);
                    return l3;
                }
            });
        } else {
            wq0.l s17 = s();
            ViewGroup viewGroup3 = this.mediaParentContainer;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
                viewGroup3 = null;
            }
            String string = viewGroup3.getResources().getString(R.string.f144650pc);
            Intrinsics.checkNotNullExpressionValue(string, "mediaParentContainer.res\u2026ng.guild_feed_no_content)");
            s17.f(string, str3);
        }
        if (s().getView().getParent() == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = ViewUtils.dip2px(4.0f);
            view.setLayoutParams(marginLayoutParams);
            ViewGroup viewGroup4 = this.titleContainerView;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainerView");
            } else {
                viewGroup2 = viewGroup4;
            }
            viewGroup2.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(View view, MotionEvent motionEvent) {
        return false;
    }

    private final void m(GProStVideo stVideo, GProStImage cover, int position) {
        View view = this.gifLabel;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifLabel");
            view = null;
        }
        view.setVisibility(8);
        boolean z16 = true;
        if (this.playView == null) {
            RoundCornerLayout roundCornerLayout = this.mediaContainer;
            if (roundCornerLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                roundCornerLayout = null;
            }
            roundCornerLayout.removeAllViews();
            RoundCornerLayout roundCornerLayout2 = this.mediaContainer;
            if (roundCornerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                roundCornerLayout2 = null;
            }
            Context context = roundCornerLayout2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mediaContainer.context");
            this.playView = new LongFeedVideoView(context);
        } else {
            RoundCornerLayout roundCornerLayout3 = this.mediaContainer;
            if (roundCornerLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                roundCornerLayout3 = null;
            }
            if (roundCornerLayout3.indexOfChild(this.playView) != -1) {
                z16 = false;
            } else {
                RoundCornerLayout roundCornerLayout4 = this.mediaContainer;
                if (roundCornerLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                    roundCornerLayout4 = null;
                }
                roundCornerLayout4.removeAllViews();
                LongFeedVideoView longFeedVideoView = this.playView;
                if (longFeedVideoView != null) {
                    ViewExtKt.a(longFeedVideoView);
                }
            }
        }
        LongFeedVideoView longFeedVideoView2 = this.playView;
        if (longFeedVideoView2 != null) {
            longFeedVideoView2.setCoverSize(GuildFeedMediaSizeUtils.f219296d.d());
        }
        LongFeedVideoView longFeedVideoView3 = this.playView;
        if (longFeedVideoView3 != null) {
            longFeedVideoView3.setData(stVideo, position);
        }
        LongFeedVideoView longFeedVideoView4 = this.playView;
        if (longFeedVideoView4 != null) {
            longFeedVideoView4.B0(stVideo, cover);
        }
        if (z16) {
            RoundCornerLayout roundCornerLayout5 = this.mediaContainer;
            if (roundCornerLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
                roundCornerLayout5 = null;
            }
            roundCornerLayout5.addView(this.playView);
        }
        LongFeedVideoView longFeedVideoView5 = this.playView;
        if (longFeedVideoView5 != null) {
            longFeedVideoView5.z0(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents$bindVideo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                    invoke2(view3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view3) {
                    Intrinsics.checkNotNullParameter(view3, "view");
                    GuildLongFeedContentComponents.this.H(view3);
                }
            });
        }
        c cVar = this.depends;
        LongFeedVideoView longFeedVideoView6 = this.playView;
        if (longFeedVideoView6 != null) {
            view2 = longFeedVideoView6.F0();
        }
        cVar.c(view2, "em_sgrp_forum_full_screen");
    }

    private final void n() {
        GProStFeed u16 = u();
        if (u16 == null) {
            return;
        }
        Pair<String, ? extends ArrayList<com.tencent.mobileqq.guild.feed.adapter.n>> pair = this.mMixedMediaDataPair;
        if (pair != null) {
            if (pair == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMixedMediaDataPair");
                pair = null;
            }
            if (Intrinsics.areEqual(pair.getFirst(), u16.idd)) {
                return;
            }
        }
        this.mMixedMediaDataPair = new Pair<>(u16.idd, com.tencent.mobileqq.guild.feed.adapter.n.m(u16));
    }

    private final GuildRoundBubbleImageView o() {
        RoundCornerLayout roundCornerLayout = this.mediaContainer;
        if (roundCornerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
            roundCornerLayout = null;
        }
        Context context = roundCornerLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mediaContainer.context");
        GuildRoundBubbleImageView guildRoundBubbleImageView = new GuildRoundBubbleImageView(context);
        guildRoundBubbleImageView.setId(R.id.waq);
        guildRoundBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int e16 = (int) cw.e(0.3f);
        guildRoundBubbleImageView.setPadding(e16, e16, e16, 0);
        guildRoundBubbleImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        float f16 = P;
        guildRoundBubbleImageView.setRadii(new float[]{f16, f16, f16, f16, f16, f16, f16, f16});
        return guildRoundBubbleImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int p() {
        return v().d().getSecond().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int q() {
        return (int) v().c();
    }

    private final IParseRichTextConfig<GProStRichTextContent> r() {
        return (IParseRichTextConfig) this.contentParseConfig.getValue();
    }

    private final wq0.l s() {
        return (wq0.l) this.contentTextView.getValue();
    }

    private final SpannableString t() {
        return (SpannableString) this.expandStringBuilder.getValue();
    }

    private final GProStFeed u() {
        ij1.g gVar = this.data;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            gVar = null;
        }
        return gVar.b();
    }

    private final AbsGuildFeedMediaSizeUtils v() {
        return (AbsGuildFeedMediaSizeUtils) this.mediaSizeUtils.getValue();
    }

    private final List<com.tencent.mobileqq.guild.feed.adapter.n> w() {
        ArrayList<com.tencent.mobileqq.guild.feed.adapter.n> arrayList;
        List<com.tencent.mobileqq.guild.feed.adapter.n> emptyList;
        GProStFeed u16 = u();
        if (u16 != null) {
            arrayList = com.tencent.mobileqq.guild.feed.adapter.n.m(u16);
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return arrayList;
    }

    private final IParseRichTextConfig<GProStRichTextContent> x() {
        return (IParseRichTextConfig) this.titleParseConfig.getValue();
    }

    public final void B(boolean attached) {
        LongFeedVideoView longFeedVideoView;
        QLog.i("GuildLongFeedContentComponents", 1, "onAttachedChanged attached=" + attached + " mPosition=" + this.position);
        if (!attached && (longFeedVideoView = this.playView) != null) {
            longFeedVideoView.a();
        }
    }

    public void C(@NotNull ij1.g data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        GProStFeed b16 = data.b();
        if (b16 == null) {
            return;
        }
        this.position = position;
        ViewGroup viewGroup = null;
        if (INSTANCE.c(b16)) {
            ViewGroup viewGroup2 = this.mediaParentContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(8);
        } else {
            ViewGroup viewGroup3 = this.mediaParentContainer;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaParentContainer");
            } else {
                viewGroup = viewGroup3;
            }
            viewGroup.setVisibility(0);
        }
        k(b16);
        j(b16, position);
        M();
    }

    public final void D() {
        LongFeedVideoView longFeedVideoView = this.playView;
        if (longFeedVideoView != null) {
            longFeedVideoView.a();
        }
    }

    public final void E() {
        QLog.d("GuildLongFeedContentComponents", 1, "[onDetachedFromWindow] release video, pos = ");
        LongFeedVideoView longFeedVideoView = this.playView;
        if (longFeedVideoView != null) {
            longFeedVideoView.a();
        }
    }

    public void F(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.wau);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026g_content_text_container)");
        this.titleContainerView = (ViewGroup) findViewById;
        View findViewById2 = containerView.findViewById(R.id.wbj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026eed_item_title_text_only)");
        TextView textView = (TextView) findViewById2;
        this.titleView = textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        textView.setTextSize(this.depends.f());
        TextView textView3 = this.titleView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView3 = null;
        }
        cw.i(textView3, ViewUtils.spToPx(this.depends.g()));
        TextView textView4 = this.titleView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        } else {
            textView2 = textView4;
        }
        kotlin.h.d(textView2, this.depends.h(), 1);
        View findViewById3 = containerView.findViewById(R.id.war);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026m_long_content_container)");
        this.mediaParentContainer = (ViewGroup) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.wav);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026tem_long_media_container)");
        this.mediaContainer = (RoundCornerLayout) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.w9p);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026.id.guild_feed_gif_label)");
        this.gifLabel = findViewById5;
        this.mTransitionBeanCreatorKey = TransitionHelper.g().registerTransitionBeanCreator(this);
    }

    public final void G(boolean visible) {
        yj1.e a16;
        yj1.e a17;
        QLog.i("GuildLongFeedContentComponents", 1, "onVisibleChanged visible=" + visible + " mPosition=" + this.position);
        if (visible && this.playView != null) {
            xj1.f j3 = this.depends.j();
            if (j3 != null && (a17 = j3.a()) != null) {
                int i3 = this.position;
                View rootView = this.depends.getRootView();
                LongFeedVideoView longFeedVideoView = this.playView;
                Intrinsics.checkNotNull(longFeedVideoView);
                a17.a(i3, rootView, longFeedVideoView);
                return;
            }
            return;
        }
        xj1.f j16 = this.depends.j();
        if (j16 != null && (a16 = j16.a()) != null) {
            a16.e(this.position);
        }
    }

    public final void I() {
        String str;
        GProStVideo data;
        LongFeedVideoView longFeedVideoView = this.playView;
        if (longFeedVideoView != null) {
            longFeedVideoView.pause();
        }
        LongFeedVideoView longFeedVideoView2 = this.playView;
        if (longFeedVideoView2 != null && (data = longFeedVideoView2.getData()) != null) {
            str = data.fileId;
        } else {
            str = null;
        }
        QLog.d("GuildLongFeedContentComponents", 1, "[pausePlayer] fileId = " + str);
    }

    public final void J() {
        String str;
        GProStVideo data;
        LongFeedVideoView longFeedVideoView = this.playView;
        if (longFeedVideoView != null) {
            longFeedVideoView.play();
        }
        LongFeedVideoView longFeedVideoView2 = this.playView;
        if (longFeedVideoView2 != null && (data = longFeedVideoView2.getData()) != null) {
            str = data.fileId;
        } else {
            str = null;
        }
        QLog.d("GuildLongFeedContentComponents", 1, "[playPlayer] fileId = " + str);
    }

    public final void K() {
        LongFeedVideoView longFeedVideoView = this.playView;
        if (longFeedVideoView != null) {
            longFeedVideoView.a();
        }
    }

    @Override // com.tencent.biz.richframework.animation.transition.TransitionHelper.TransitionBeanCreator
    @NotNull
    public TransitionBean generateTransitionBean(int currentPos) {
        TransitionBean transitionBean = new TransitionBean();
        transitionBean.setEnterViewRect(this.contentBgIv);
        GProStImage gProStImage = w().get(currentPos).d().cover;
        if (gProStImage != null) {
            transitionBean.setStImage(bm.f(w().get(currentPos)), gProStImage.width, gProStImage.height);
        }
        return transitionBean;
    }

    @Nullable
    public final GuildFeedListBaseVideoView<?> y() {
        LongFeedVideoView longFeedVideoView = this.playView;
        if (longFeedVideoView != null) {
            Intrinsics.checkNotNull(longFeedVideoView);
            return longFeedVideoView.d();
        }
        return null;
    }

    @NotNull
    public int[] z() {
        return new int[]{R.id.wat};
    }
}
