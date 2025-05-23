package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.y;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedUIData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCustomManageTag;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProInteraction;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPersonalMedal;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStBusinessCard;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextCardContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.h;
import qj1.l;
import qj1.q;
import qj1.r;
import qj1.t;
import qj1.u;
import qj1.w;
import tl.h;

@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\u0018\u0000 ;2\u00060\u0001j\u0002`\u0002:\u0001UB\u001b\u0012\u0006\u0010Y\u001a\u00020T\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\bx\u0010yJ\u0012\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u001a\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rH\u0016J\u001a\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J@\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J\u0012\u0010*\u001a\f\u0012\b\u0012\u00060(j\u0002`)0\u0003H\u0016J\f\u0010-\u001a\u00060+j\u0002`,H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016J\n\u00101\u001a\u0004\u0018\u000100H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\n\u00104\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u00105\u001a\u00020\u000eH\u0016J\b\u00106\u001a\u00020\u000eH\u0016J\b\u00107\u001a\u00020\u000eH\u0016J\b\u00108\u001a\u00020\u000eH\u0016J\u0011\u00109\u001a\u0004\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u0007H\u0016J\b\u0010<\u001a\u00020\u000eH\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\b\u0010>\u001a\u00020!H\u0016J\b\u0010?\u001a\u00020\u0010H\u0016J\b\u0010@\u001a\u00020\u0010H\u0016J\b\u0010A\u001a\u00020!H\u0016J\b\u0010B\u001a\u00020\u0007H\u0016J\b\u0010C\u001a\u00020\u0007H\u0016J\b\u0010D\u001a\u00020!H\u0016J\u0012\u0010G\u001a\f\u0012\b\u0012\u00060Ej\u0002`F0\u0003H\u0016J\u0012\u0010J\u001a\f\u0012\b\u0012\u00060Hj\u0002`I0\u0003H\u0016J\u0012\u0010M\u001a\f\u0012\b\u0012\u00060Kj\u0002`L0\u0003H\u0016J\u0012\u0010P\u001a\f\u0012\b\u0012\u00060Nj\u0002`O0\u0003H\u0016J\b\u0010Q\u001a\u00020!H\u0016J\u0010\u0010R\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003H\u0016J\b\u0010S\u001a\u00020\u000eH\u0016R\u0017\u0010Y\u001a\u00020T8\u0006\u00a2\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u0016\u0010[\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010ZR!\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\\\u001a\u0004\b]\u0010^R!\u0010a\u001a\b\u0012\u0004\u0012\u00020E0\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\\\u001a\u0004\b`\u0010^R!\u0010c\u001a\b\u0012\u0004\u0012\u00020#0\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010\\\u001a\u0004\bb\u0010^R!\u0010e\u001a\b\u0012\u0004\u0012\u00020N0\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\\\u001a\u0004\bd\u0010^R!\u0010h\u001a\b\u0012\u0004\u0012\u00020H0\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bf\u0010\\\u001a\u0004\bg\u0010^R!\u0010j\u001a\b\u0012\u0004\u0012\u00020K0\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010\\\u001a\u0004\bi\u0010^R\u0014\u0010l\u001a\u00020#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bU\u0010kR\u0014\u0010o\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010q\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bp\u0010nR\u0014\u0010t\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\br\u0010sR\u0014\u0010u\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bf\u0010sR\u0014\u0010w\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bv\u0010n\u00a8\u0006z"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/GProStFeedDetailRspWrapper;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "", "Lqj1/l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IMediaDisplayable;", "c", "", "L", "u", "t", "r", UserInfo.SEX_FEMALE, "Lkotlin/Triple;", "", "getRoleInfo", "", "getPersonalMedal", "getCreateTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProInteraction;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "O", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "hideUrlTypes", "emojiSize", "traceId", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "Lcom/tencent/aio/widget/textView/view/b;", "y", "", "k", "", "param", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "N", "v", "Lqj1/w;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/TencentDocInfo;", "f", "Lqj1/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/BusinessCardInfo;", "l", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextCardContent;", "D", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProThirdBar;", "G", "I", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "getCommentCount", "d", "getPreferStatus", "p", "()Ljava/lang/Integer;", "i", "E", "getFeedId", "w", "getChannelId", "getGuildId", "B", "getGuildName", "getGuildIcon", "K", "Lqj1/r;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IThirdPartyMediaDisplayable;", "H", "Lqj1/q;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/ISharedGraphicContentDisplayable;", "b", "Lqj1/t;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IThirdVideoContentDisplayable;", h.F, "Lqj1/u;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/ITroopContentDisplayable;", "getTroopList", HippyTKDListViewAdapter.X, "getFunctionList", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "M", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "galleryMediaData", "Lkotlin/Lazy;", "P", "()Ljava/util/List;", "mixedMediaData", ExifInterface.LATITUDE_SOUTH, "thirdPartyMediaData", "getTencentDocs", "tencentDocs", "T", "troopContents", "g", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "sharedGraphicContents", BdhLogUtil.LogTag.Tag_Req, "smallWorldVideoContents", "()Ljava/lang/Object;", "raw", "getFeedType", "()I", "feedType", "o", "layoutType", "getTopTimestamp", "()J", "topTimestamp", "channelTopTimestamp", "j", "feedAuditStatus", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GProStFeedDetailRspWrapper implements qj1.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProStFeed feed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GuildFeedRichMediaData galleryMediaData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mixedMediaData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy thirdPartyMediaData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tencentDocs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy troopContents;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sharedGraphicContents;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy smallWorldVideoContents;

    @Metadata(d1 = {"\u0000Q\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\t\u0010\r\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0096\u0001J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0012\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0014H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u001eH\u0096\u0001J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010 H\u0096\u0001J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/GProStFeedDetailRspWrapper$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", "Landroid/graphics/drawable/Drawable;", "v", ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "g", "i", "j", h.F, "u", "e", "d", "w", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", "o", "k", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IParseRichTextConfig<GProStRichTextContent> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f221019b = IParseRichTextConfig.INSTANCE.a();

        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f221019b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f221019b.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f221019b.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f221019b.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return this.f221019b.f();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f221019b.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f221019b.getHighlightWords();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221023e() {
            return this.f221019b.getF221023e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f221019b.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f221019b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f221019b.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f221019b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f221019b.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221022d() {
            return this.f221019b.getF221022d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f221019b.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f221019b.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f221019b.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.f221019b.t();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f221019b.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f221019b.m(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f221019b.a(t16);
        }
    }

    @Metadata(d1 = {"\u0000S\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0096\u0001J\t\u0010\u000f\u001a\u00020\nH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H\u0096\u0001J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/GProStFeedDetailRspWrapper$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", ReportConstant.COSTREPORT_PREFIX, "", "g", "i", h.F, "u", "k", "o", "d", "b", "", "r", "Landroid/graphics/drawable/Drawable;", "v", "w", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "j", "e", "p", "getTraceID", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements IParseRichTextConfig<GProStRichTextContent> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f221020b = IParseRichTextConfig.INSTANCE.a();

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Integer> f221021c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f221022d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f221023e;

        c(List<Integer> list, int i3, String str) {
            this.f221021c = list;
            this.f221022d = i3;
            this.f221023e = str;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f221020b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f221020b.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f221020b.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return TrimSpaceType.None;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f221020b.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f221020b.getHighlightWords();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID, reason: from getter */
        public String getF221023e() {
            return this.f221023e;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f221020b.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f221020b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return this.f221020b.k();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f221020b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f221020b.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return this.f221020b.o();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p, reason: from getter */
        public int getF221022d() {
            return this.f221022d;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f221020b.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f221020b.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f221020b.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.f221020b.t();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f221020b.u();
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

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return !this.f221021c.contains(Integer.valueOf(t16.urlContent.type));
        }
    }

    public GProStFeedDetailRspWrapper(@NotNull GProStFeed feed, @Nullable GuildFeedRichMediaData guildFeedRichMediaData) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
        this.galleryMediaData = guildFeedRichMediaData;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<? extends l>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper$mixedMediaData$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper$mixedMediaData$2$1, reason: invalid class name */
            /* loaded from: classes13.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GProStImage, l> {
                AnonymousClass1(Object obj) {
                    super(1, obj, FeedMixedMediaDataCompatTool.class, "newGProStImageMediaDataReader", "newGProStImageMediaDataReader(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;)Lcom/tencent/mobileqq/guild/feed/displayable/IMediaDisplayable;", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final l invoke(@NotNull GProStImage p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    return ((FeedMixedMediaDataCompatTool) this.receiver).d(p06);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper$mixedMediaData$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<GProStVideo, l> {
                AnonymousClass2(Object obj) {
                    super(1, obj, FeedMixedMediaDataCompatTool.class, "newGProStVideoMediaDataReader", "newGProStVideoMediaDataReader(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;)Lcom/tencent/mobileqq/guild/feed/displayable/IMediaDisplayable;", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final l invoke(@NotNull GProStVideo p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    return ((FeedMixedMediaDataCompatTool) this.receiver).j(p06);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends l> invoke() {
                FeedMixedMediaDataCompatTool feedMixedMediaDataCompatTool = FeedMixedMediaDataCompatTool.f221103a;
                return FeedMixedMediaDataCompatTool.c(feedMixedMediaDataCompatTool, new AnonymousClass1(feedMixedMediaDataCompatTool), new AnonymousClass2(feedMixedMediaDataCompatTool), GProStFeedDetailRspWrapper.this.getFeed().images, GProStFeedDetailRspWrapper.this.getFeed().videos, 0, 16, null);
            }
        });
        this.mixedMediaData = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends r>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper$thirdPartyMediaData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends r> invoke() {
                return FeedMixedMediaDataCompatTool.f221103a.h(GProStFeedDetailRspWrapper.this.getFeed());
            }
        });
        this.thirdPartyMediaData = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<List<Object>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper$tencentDocs$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<Object> invoke() {
                return FeedMixedMediaDataCompatTool.f221103a.g(GProStFeedDetailRspWrapper.this.getFeed());
            }
        });
        this.tencentDocs = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends u>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper$troopContents$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends u> invoke() {
                return FeedMixedMediaDataCompatTool.f221103a.i(GProStFeedDetailRspWrapper.this.getFeed());
            }
        });
        this.troopContents = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends q>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper$sharedGraphicContents$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends q> invoke() {
                return FeedMixedMediaDataCompatTool.f221103a.e(GProStFeedDetailRspWrapper.this.getFeed());
            }
        });
        this.sharedGraphicContents = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends t>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper$smallWorldVideoContents$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends t> invoke() {
                return FeedMixedMediaDataCompatTool.f221103a.f(GProStFeedDetailRspWrapper.this.getFeed());
            }
        });
        this.smallWorldVideoContents = lazy6;
    }

    private final List<l> P() {
        return (List) this.mixedMediaData.getValue();
    }

    private final List<q> Q() {
        return (List) this.sharedGraphicContents.getValue();
    }

    private final List<t> R() {
        return (List) this.smallWorldVideoContents.getValue();
    }

    private final List<r> S() {
        return (List) this.thirdPartyMediaData.getValue();
    }

    private final List<u> T() {
        return (List) this.troopContents.getValue();
    }

    @Override // qj1.b
    public boolean A() {
        return h.a.b(this);
    }

    @Override // qj1.c
    public boolean B() {
        IGProChannelInfo B = ch.B(String.valueOf(getChannelId()));
        if (B != null) {
            return B.isHiddenPostChannel();
        }
        return this.feed.channelInfo.isSquare;
    }

    @Override // qj1.e
    @Nullable
    public GProStRichTextCardContent D() {
        Iterator<GProStRichTextContent> it = this.feed.contents.contents.iterator();
        while (it.hasNext()) {
            GProStRichTextContent next = it.next();
            if (next.type == 3) {
                GProStRichTextURLContent gProStRichTextURLContent = next.urlContent;
                if (gProStRichTextURLContent.type == 5) {
                    return gProStRichTextURLContent.cardContent;
                }
            }
        }
        return null;
    }

    @Override // qj1.p
    public int E() {
        return this.feed.share.contentType;
    }

    @Override // qj1.n
    @NotNull
    public String F() {
        String valueOf = String.valueOf(this.feed.poster.uin);
        if (valueOf == null) {
            return "";
        }
        return valueOf;
    }

    @Override // qj1.s
    @Nullable
    public GProThirdBar G() {
        return this.feed.thirdBar;
    }

    @Override // qj1.e
    @NotNull
    public List<r> H() {
        return S();
    }

    @Override // qj1.b
    @NotNull
    public String I() {
        QRouteApi api = QRoute.api(IGuildFeedUtilsApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedUtilsApi::class.java)");
        String a16 = IGuildFeedUtilsApi.a.a((IGuildFeedUtilsApi) api, this.feed.visitorInfo.viewCount, null, y.b.f216487d, 2, null);
        return BaseApplication.context.getString(R.string.f22044695) + a16;
    }

    @Override // qj1.n
    @NotNull
    public String J() {
        GProStFeed gProStFeed = this.feed;
        Pair pair = TuplesKt.to(Long.valueOf(gProStFeed.createTime), Long.valueOf(gProStFeed.meta.getLastModifiedTime()));
        long longValue = ((Number) pair.component1()).longValue();
        long longValue2 = ((Number) pair.component2()).longValue();
        String w3 = ax.w(Math.max(longValue, longValue2) * 1000);
        if (longValue2 > longValue) {
            String string = BaseApplication.context.getString(R.string.ztr, w3);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            BaseApplic\u2026 formattedTime)\n        }");
            return string;
        }
        Intrinsics.checkNotNullExpressionValue(w3, "{\n            formattedTime\n        }");
        return w3;
    }

    @Override // qj1.c
    public boolean K() {
        boolean z16;
        IGProChannelInfo B = ch.B(String.valueOf(getChannelId()));
        if (B != null && !B.isHiddenPostChannel()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && B.getType() == 7) {
            return true;
        }
        return false;
    }

    @Override // qj1.n
    @Nullable
    public String L() {
        return this.feed.poster.nick;
    }

    @NotNull
    /* renamed from: M, reason: from getter */
    public final GProStFeed getFeed() {
        return this.feed;
    }

    @Override // qj1.e
    @NotNull
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public LongFeedUIData C(@NotNull Object param) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (param instanceof LongFeedParseParam) {
            return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a.l((LongFeedParseParam) param, this.feed);
        }
        throw new IllegalArgumentException("param must be LongFeedParseParam");
    }

    @Override // qj1.f
    @Nullable
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public GuildFeedRichMediaData n() {
        GuildFeedRichMediaData guildFeedRichMediaData = this.galleryMediaData;
        if (guildFeedRichMediaData != null) {
            return guildFeedRichMediaData;
        }
        for (GuildFeedRichMediaData guildFeedRichMediaData2 : com.tencent.mobileqq.guild.feed.gallery.b.d(this.feed)) {
            if (guildFeedRichMediaData2.getType() == 1) {
                Logger.f235387a.d().i("GProStFeedDetailRspWrapper", 1, "get (Video)MediaData from Feed");
                return guildFeedRichMediaData2;
            }
        }
        return null;
    }

    @Override // qj1.o
    @NotNull
    public Object a() {
        return this.feed;
    }

    @Override // qj1.e
    @NotNull
    public List<q> b() {
        return Q();
    }

    @Override // qj1.e
    @NotNull
    public List<l> c() {
        return P();
    }

    @Override // qj1.b
    public int d() {
        return this.feed.share.sharedCount;
    }

    @Override // qj1.b
    public int e() {
        return this.feed.totalPrefer.preferCountWithoutLike;
    }

    @Override // qj1.e
    @NotNull
    public List<w> f() {
        ArrayList arrayList = new ArrayList();
        Iterator<GProStRichTextContent> it = this.feed.contents.contents.iterator();
        while (it.hasNext()) {
            GProStRichTextContent content = it.next();
            if (content.type == 3 && content.urlContent.type == 3) {
                Intrinsics.checkNotNullExpressionValue(content, "content");
                arrayList.add(new w(content));
            }
        }
        return arrayList;
    }

    @Override // qj1.k
    public long g() {
        GProTopInfo gProTopInfo = this.feed.topInfo;
        if (gProTopInfo != null) {
            return gProTopInfo.channelTopTimestamp;
        }
        return 0L;
    }

    @Override // qj1.c
    public long getChannelId() {
        return this.feed.channelInfo.sign.channelId;
    }

    @Override // qj1.b
    public int getCommentCount() {
        return this.feed.commentCount;
    }

    @Override // qj1.k
    public long getCreateTime() {
        return this.feed.createTime;
    }

    @Override // qj1.g
    @NotNull
    public String getFeedId() {
        String str = this.feed.idd;
        Intrinsics.checkNotNullExpressionValue(str, "feed.idd");
        return str;
    }

    @Override // qj1.g
    public int getFeedType() {
        return this.feed.feedType;
    }

    @Override // qj1.j
    @Nullable
    public List<Integer> getFunctionList() {
        return this.feed.getFunctionList();
    }

    @Override // qj1.c
    @NotNull
    public String getGuildIcon() {
        String iconUrl = this.feed.channelInfo.getIconUrl();
        Intrinsics.checkNotNullExpressionValue(iconUrl, "feed.channelInfo.getIconUrl()");
        return iconUrl;
    }

    @Override // qj1.c
    public long getGuildId() {
        return this.feed.channelInfo.sign.guildId;
    }

    @Override // qj1.c
    @NotNull
    public String getGuildName() {
        String guildName = this.feed.channelInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "feed.channelInfo.getGuildName()");
        return guildName;
    }

    @Override // qj1.n
    @NotNull
    public Triple<Long, Long, String> getPersonalMedal() {
        GProPersonalMedal gProPersonalMedal = this.feed.poster.personalMedal;
        return new Triple<>(Long.valueOf(gProPersonalMedal.startTime), Long.valueOf(gProPersonalMedal.endTime), gProPersonalMedal.url);
    }

    @Override // qj1.b
    public int getPreferStatus() {
        return this.feed.totalPrefer.preferStatus;
    }

    @Override // qj1.n
    @NotNull
    public Triple<Integer, Integer, String> getRoleInfo() {
        GProCustomManageTag gProCustomManageTag = this.feed.poster.manageTag;
        return new Triple<>(Integer.valueOf(gProCustomManageTag.color), Integer.valueOf(gProCustomManageTag.wordColor), gProCustomManageTag.tagName);
    }

    @Override // qj1.k
    public long getTopTimestamp() {
        GProTopInfo gProTopInfo = this.feed.topInfo;
        if (gProTopInfo != null) {
            return gProTopInfo.topTimestamp;
        }
        return 0L;
    }

    @Override // qj1.e
    @NotNull
    public List<u> getTroopList() {
        return T();
    }

    @Override // qj1.e
    @NotNull
    public List<t> h() {
        return R();
    }

    @Override // qj1.p
    @NotNull
    public String i() {
        String str = this.feed.share.shareCardInfo;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // qj1.j
    public int j() {
        return this.feed.auditStatus;
    }

    @Override // qj1.e
    public boolean k() {
        Intrinsics.checkNotNullExpressionValue(this.feed.contentWithStyle.paragraphs, "feed.contentWithStyle.paragraphs");
        return !r0.isEmpty();
    }

    @Override // qj1.e
    @NotNull
    public qj1.a l() {
        GProStBusinessCard gProStBusinessCard = this.feed.businessCard;
        Intrinsics.checkNotNullExpressionValue(gProStBusinessCard, "feed.businessCard");
        return new qj1.a(gProStBusinessCard);
    }

    @Override // qj1.k
    public long m() {
        return this.feed.meta.getLastModifiedTime();
    }

    @Override // qj1.g
    public int o() {
        return this.feed.summary.layoutType;
    }

    @Override // qj1.b
    @Nullable
    public Integer p() {
        return Integer.valueOf(this.feed.visitorInfo.viewCount);
    }

    @Override // qj1.c
    @Nullable
    public String q() {
        GProStChannelInfo gProStChannelInfo = this.feed.channelInfo;
        if (gProStChannelInfo != null) {
            return gProStChannelInfo.name;
        }
        return null;
    }

    @Override // qj1.n
    @NotNull
    public String r() {
        String str = this.feed.poster.idd;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // qj1.n
    public int s() {
        return this.feed.allowFeedComment;
    }

    @Override // qj1.n
    @NotNull
    public String t() {
        String str = this.feed.poster.avatarPendant;
        Intrinsics.checkNotNullExpressionValue(str, "feed.poster.avatarPendant");
        return str;
    }

    @Override // qj1.n
    @Nullable
    public String u() {
        return this.feed.poster.icon.iconUrl;
    }

    @Override // qj1.e
    @NotNull
    public SpannableStringBuilder v() {
        GProStFeed gProStFeed = this.feed;
        if (gProStFeed.feedType == 1) {
            return new SpannableStringBuilder();
        }
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<GProStRichTextContent> arrayList = gProStFeed.title.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "feed.title.contents");
        return (SpannableStringBuilder) FeedRichTextContentParser.s(feedRichTextContentParser, arrayList, null, new b(), null, null, 13, null).getFirst();
    }

    @Override // qj1.g
    public boolean w() {
        return com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(this.feed);
    }

    @Override // qj1.j
    public boolean x() {
        return this.feed.needWebview;
    }

    @Override // qj1.e
    @NotNull
    public Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> y(@Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull List<Integer> hideUrlTypes, int emojiSize, @Nullable String traceId) {
        Intrinsics.checkNotNullParameter(hideUrlTypes, "hideUrlTypes");
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<GProStRichTextContent> arrayList = this.feed.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "feed.contents.contents");
        return feedRichTextContentParser.r(arrayList, joinInfoParam, new c(hideUrlTypes, emojiSize, traceId), String.valueOf(this.feed.channelInfo.sign.channelId), String.valueOf(this.feed.channelInfo.sign.guildId));
    }

    @Override // qj1.k
    @NotNull
    public GProInteraction z() {
        GProInteraction gProInteraction = this.feed.latestInteraction;
        Intrinsics.checkNotNullExpressionValue(gProInteraction, "feed.latestInteraction");
        return gProInteraction;
    }

    public /* synthetic */ GProStFeedDetailRspWrapper(GProStFeed gProStFeed, GuildFeedRichMediaData guildFeedRichMediaData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(gProStFeed, (i3 & 2) != 0 ? null : guildFeedRichMediaData);
    }
}
