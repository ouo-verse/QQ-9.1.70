package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.TopFeedCommentApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.fragment.CommentItemOptionFragment;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.highlight.CommentHighlightAbility;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart$commentRequestCallback$2;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart$replyRequestCallback$2;
import com.tencent.mobileqq.guild.feed.util.GuildFeedNoticeEvent;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetTopCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetTopCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoLikeReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoLikeRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStEmojiReaction;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStEmotionReactionInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStLike;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoLikeCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

@Metadata(d1 = {"\u0000\u00f3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\u0005\u0007\u0088\u0001\u008d\u0001\u0018\u0000 \u0099\u00012\u00020\u00012\u00020\u0002:\u0002\u009a\u0001B\u0011\u0012\u0006\u0010q\u001a\u00020n\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J@\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010!\u001a\u00020 H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0016\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H\u0002J\n\u0010,\u001a\u0004\u0018\u00010+H\u0002J\b\u0010.\u001a\u00020-H\u0002J\u0018\u0010/\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u00102\u001a\u0004\u0018\u0001012\u0006\u00100\u001a\u00020\u0013H\u0002J\b\u00103\u001a\u00020\u0005H\u0002J \u00107\u001a\u0002062\u0006\u00105\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u000209082\u0006\u00105\u001a\u000204H\u0002J\u0012\u0010<\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010=\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u001cH\u0002J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u001cH\u0002J\u0010\u0010B\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\fH\u0002J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\fH\u0002J\u0012\u0010F\u001a\u00020\n2\b\u0010E\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010I\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010L\u001a\u00020\n2\u0006\u0010K\u001a\u00020JH\u0016J\u001a\u0010O\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00162\b\u0010N\u001a\u0004\u0018\u00010'H\u0016J@\u0010V\u001a\u00020\n2\u0006\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u0013H\u0016J \u0010W\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010Y\u001a\u00020\n2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010Z\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010[\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\\\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J(\u0010]\u001a\u00020\n2\u0006\u00105\u001a\u0002042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010^\u001a\u00020\u001cH\u0016J\b\u0010_\u001a\u00020\u001cH\u0016J\b\u0010`\u001a\u00020\u001cH\u0016J\b\u0010a\u001a\u00020\u001cH\u0016J\u0010\u0010c\u001a\u00020\n2\u0006\u0010b\u001a\u00020\u001cH\u0016J\u0010\u0010d\u001a\u00020\n2\u0006\u0010b\u001a\u00020\u001cH\u0016J\u0012\u0010f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010e\u001a\u00020\u0013H\u0016J\u0016\u0010g\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010h\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010i\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013J\u001c\u0010k\u001a\u00020\n2\b\u0010j\u001a\u0004\u0018\u00010\u001c2\b\u0010;\u001a\u0004\u0018\u00010'H\u0016J\u0006\u0010l\u001a\u00020RJ\b\u0010m\u001a\u00020\u0013H\u0016R\u0014\u0010q\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010t\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010sR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020\u001c0w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\u001c0w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010yR\u001e\u0010\u0082\u0001\u001a\u00020}8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0087\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0084\u0001\u0010\u007f\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R \u0010\u008c\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0089\u0001\u0010\u007f\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R \u0010\u0091\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008e\u0001\u0010\u007f\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R \u0010\u0096\u0001\u001a\u00030\u0092\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0093\u0001\u0010\u007f\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\u00a8\u0006\u009b\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lvl1/a;", "Ljl1/b;", "commentItemData", "", "topOrUntop", "com/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$b", "Aa", "(Ljl1/b;Z)Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$b;", "", "initData", "Lhl1/g;", "contentData", "Landroid/content/Context;", "context", "S9", "V9", "O9", "", "position", "X9", "Ljl1/h;", "replyItemData", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStLike;", "oldLikeInfo", "W9", "N9", "", WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID, "status", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoLikeCallback;", "qa", "isReply", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoLikeReq;", "da", "", "extData", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "ba", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "ia", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStEmotionReactionInfo;", "L9", "ua", "itemGroupPos", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "ea", "oa", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "gproStImage", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "pa", "", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "K9", "args", "la", "ma", "commentPosterId", "M9", "xa", "comment", "za", "Ba", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "commentMeta", "H1", "reply", "payload", "O4", "view", "tinyId", "", "uin", "type", "groupPos", "U8", Constants.DEVICE_BOOT_TIME, "needFold", ICustomDataEditor.STRING_ARRAY_PARAM_3, ICustomDataEditor.NUMBER_PARAM_4, "A6", "q6", "N6", "getFeedId", "r", "getChannelId", "getGuildId", "id", "G0", "v3", "itemGroupPosition", "S3", "R9", "Q9", "P9", "action", "handleBroadcastMessage", "Z9", "z3", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$a$a;", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$a$a;", "initArgs", "e", "J", "lastShowTimeMills", "f", "commentListShowTimeMills", "", tl.h.F, "Ljava/util/Set;", "allVisibleCommentIds", "i", "allVisibleReplyIds", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "ga", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/b;", "replyCommentRequestSender", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/TopFeedCommentApi;", BdhLogUtil.LogTag.Tag_Conn, LocaleUtils.L_JAPANESE, "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/TopFeedCommentApi;", "topFeedCommentApi", "com/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$replyRequestCallback$2$a", "D", "ha", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$replyRequestCallback$2$a;", "replyRequestCallback", "com/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$commentRequestCallback$2$a", "E", "aa", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$commentRequestCallback$2$a;", "commentRequestCallback", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/b;", UserInfo.SEX_FEMALE, "Y9", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/b;", "commentFeedRequestSender", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$a$a;)V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CommentFunctionPart extends Part implements vl1.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy topFeedCommentApi;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy replyRequestCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentRequestCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentFeedRequestSender;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Companion.CommentInitArgs initArgs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastShowTimeMills;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long commentListShowTimeMills;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> allVisibleCommentIds;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> allVisibleReplyIds;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy replyCommentRequestSender;

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0014\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProSetTopCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProSetTopCommentRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/TopFeedRequestCallback;", "", "code", "", "msg", "", "k", "i", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "task", "result", "errMsg", "req", "rsp", tl.h.F, "j", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RequestSenderCallback<GProSetTopCommentReq, GProSetTopCommentRsp> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ jl1.b f221280c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f221281d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(jl1.b bVar, boolean z16) {
            super(false, 1, null);
            this.f221280c = bVar;
            this.f221281d = z16;
        }

        private final void i(int code, String msg2) {
            boolean isBlank;
            boolean z16;
            QLog.e("CommentFunctionPart", 1, "setTopComment code: " + code + ", err: " + msg2 + " top:" + this.f221281d);
            isBlank = StringsKt__StringsJVMKt.isBlank(msg2);
            boolean z17 = false;
            if (!isBlank) {
                if (10000 <= code && code < 20001) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (!z17) {
                msg2 = null;
            }
            if (msg2 == null) {
                msg2 = HardCodeUtil.qqStr(R.string.ci7);
            }
            Intrinsics.checkNotNullExpressionValue(msg2, "msg.takeIf { it.isNotBla\u2026.qqui.R.string.net_error)");
            yl1.n.A(1, msg2);
        }

        private final void k(int code, String msg2) {
            boolean z16;
            String str;
            CommentFunctionPart.this.broadcastMessage("message_top_comment_list_item", new g.TopCommentItemMessage(this.f221280c, this.f221281d));
            boolean z17 = this.f221281d;
            if (msg2.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (z17) {
                    str = "\u7f6e\u9876\u6210\u529f";
                } else {
                    str = "\u7f6e\u9876\u5df2\u53d6\u6d88";
                }
                msg2 = str;
            }
            yl1.n.A(2, msg2);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void b(@NotNull ICommentTask task, int result, @NotNull String errMsg, @NotNull GProSetTopCommentReq req, @NotNull GProSetTopCommentRsp rsp) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            if (result == 0) {
                k(result, errMsg);
            } else {
                i(result, errMsg);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(@NotNull GProSetTopCommentReq req, @NotNull GProSetTopCommentRsp rsp) {
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(rsp, "rsp");
        }
    }

    public CommentFunctionPart(@NotNull Companion.CommentInitArgs initArgs) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(initArgs, "initArgs");
        this.initArgs = initArgs;
        this.allVisibleCommentIds = new LinkedHashSet();
        this.allVisibleReplyIds = new LinkedHashSet();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.b>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart$replyCommentRequestSender$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.b invoke() {
                return new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.b();
            }
        });
        this.replyCommentRequestSender = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TopFeedCommentApi>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart$topFeedCommentApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TopFeedCommentApi invoke() {
                return new TopFeedCommentApi();
            }
        });
        this.topFeedCommentApi = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CommentFunctionPart$replyRequestCallback$2.a>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart$replyRequestCallback$2

            @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0014J*\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$replyRequestCallback$2$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/ReplyCommentRequestCallback2;", "req", "rsp", "", "i", "", "result", "", "errMsg", tl.h.F, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a extends RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp> {

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ CommentFunctionPart f221283b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(CommentFunctionPart commentFunctionPart) {
                    super(true);
                    this.f221283b = commentFunctionPart;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
                /* renamed from: h, reason: merged with bridge method [inline-methods] */
                public void f(int result, @NotNull String errMsg, @NotNull GProStDoReplyReq req, @Nullable GProStDoReplyRsp rsp) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(req, "req");
                    QQToast.makeText(this.f221283b.getPartRootView().getContext(), errMsg, 0).show();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public void g(@NotNull GProStDoReplyReq req, @NotNull GProStDoReplyRsp rsp) {
                    Intrinsics.checkNotNullParameter(req, "req");
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    QQToast.makeText(this.f221283b.getPartRootView().getContext(), 2, "\u5220\u9664\u6210\u529f", 0).show();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(CommentFunctionPart.this);
            }
        });
        this.replyRequestCallback = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CommentFunctionPart$commentRequestCallback$2.a>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart$commentRequestCallback$2

            @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0014J*\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$commentRequestCallback$2$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/CommentFeedRequestCallback;", "req", "rsp", "", "i", "", "result", "", "errMsg", tl.h.F, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a extends RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp> {

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ CommentFunctionPart f221282b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(CommentFunctionPart commentFunctionPart) {
                    super(true);
                    this.f221282b = commentFunctionPart;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
                /* renamed from: h, reason: merged with bridge method [inline-methods] */
                public void f(int result, @NotNull String errMsg, @NotNull GProStDoCommentReq req, @Nullable GProStDoCommentRsp rsp) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(req, "req");
                    QQToast.makeText(this.f221282b.getPartRootView().getContext(), errMsg, 0).show();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
                /* renamed from: i, reason: merged with bridge method [inline-methods] */
                public void g(@NotNull GProStDoCommentReq req, @NotNull GProStDoCommentRsp rsp) {
                    Intrinsics.checkNotNullParameter(req, "req");
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    QQToast.makeText(this.f221282b.getPartRootView().getContext(), 2, "\u5220\u9664\u6210\u529f", 0).show();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(CommentFunctionPart.this);
            }
        });
        this.commentRequestCallback = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.b>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart$commentFeedRequestSender$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.b invoke() {
                return new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.b();
            }
        });
        this.commentFeedRequestSender = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b Aa(jl1.b commentItemData, boolean topOrUntop) {
        return new b(commentItemData, topOrUntop);
    }

    private final boolean Ba(hl1.g comment) {
        boolean z16;
        jl1.b bVar;
        if (!this.initArgs.getSupportsTop()) {
            return false;
        }
        vl1.b bVar2 = (vl1.b) PartIOCKt.getIocInterface(this, vl1.b.class);
        if (bVar2 != null && bVar2.y0() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (comment instanceof jl1.b) {
            bVar = (jl1.b) comment;
        } else {
            bVar = null;
        }
        if (bVar == null || !jl1.c.b(bVar)) {
            return false;
        }
        if (!ch.m0(getGuildId()) && !Intrinsics.areEqual(r(), ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId())) {
            return false;
        }
        return true;
    }

    private final List<GuildFeedRichMediaData> K9(GProStImage gproStImage) {
        ArrayList arrayList = new ArrayList();
        GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
        guildFeedRichMediaData.setImage(gproStImage);
        arrayList.add(guildFeedRichMediaData);
        return arrayList;
    }

    private final GProStEmotionReactionInfo L9() {
        GProStEmotionReactionInfo gProStEmotionReactionInfo = new GProStEmotionReactionInfo();
        ArrayList<GProStEmojiReaction> arrayList = gProStEmotionReactionInfo.emojiReactionList;
        GProStEmojiReaction gProStEmojiReaction = new GProStEmojiReaction();
        gProStEmojiReaction.emojiId = "271";
        gProStEmojiReaction.emojiType = 1L;
        arrayList.add(gProStEmojiReaction);
        return gProStEmotionReactionInfo;
    }

    private final boolean M9(String commentPosterId) {
        String selfTinyId = ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId();
        if (!nl1.b.f420422a.d(this.initArgs.getGuildId(), this.initArgs.getChannelId()) && !Intrinsics.areEqual(commentPosterId, selfTinyId) && !Intrinsics.areEqual(r(), selfTinyId)) {
            return false;
        }
        return true;
    }

    private final void N9(int position, jl1.b commentItemData, GProStLike oldLikeInfo) {
        GProStDoLikeReq da5 = da(oldLikeInfo, false);
        if (da5 == null) {
            return;
        }
        GProStComment gProStComment = new GProStComment();
        gProStComment.idd = commentItemData.getCommentData().idd;
        gProStComment.postUser.idd = commentItemData.getCommentData().postUser.idd;
        GProStLike gProStLike = new GProStLike();
        gProStLike.idd = commentItemData.getCommentData().idd;
        gProStLike.status = commentItemData.getCommentData().likeInfo.status;
        gProStComment.likeInfo = gProStLike;
        da5.comment = gProStComment;
        GProStLike gProStLike2 = new GProStLike();
        gProStLike2.idd = commentItemData.getCommentData().idd;
        gProStLike2.status = commentItemData.getCommentData().likeInfo.status;
        da5.like = gProStLike2;
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        String str = commentItemData.getCommentData().idd;
        Intrinsics.checkNotNullExpressionValue(str, "commentItemData.commentData.idd");
        IPerformanceReportTask e16 = cVar.e(da5, false, str);
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            String str2 = commentItemData.getCommentData().idd;
            Intrinsics.checkNotNullExpressionValue(str2, "commentItemData.commentData.idd");
            c16.doLike(da5, qa(position, oldLikeInfo, commentItemData, str2, "", commentItemData.getCommentData().likeInfo.status, e16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(hl1.g contentData) {
        if (contentData instanceof jl1.h) {
            String str = ((jl1.h) contentData).getReplyData().idd;
            Intrinsics.checkNotNullExpressionValue(str, "contentData.replyData.idd");
            broadcastMessage("message_reply_request_operation", new a.ReplyRequestOperation(1, str, contentData));
        } else if (contentData instanceof jl1.b) {
            String str2 = ((jl1.b) contentData).getCommentData().idd;
            Intrinsics.checkNotNullExpressionValue(str2, "contentData.commentData.idd");
            broadcastMessage("message_comment_request_operation", new a.CommentRequestOperation(1, str2, contentData));
        }
    }

    private final void S9(hl1.g contentData, Context context) {
        jl1.b bVar;
        LifecycleCoroutineScope e16;
        final Job launch$default;
        QLog.i("CommentFunctionPart", 1, "doItemOptionTop " + contentData);
        a.CommentMainFeedData ca5 = ca(this, null, 1, null);
        if (ca5 == null) {
            return;
        }
        if (contentData instanceof jl1.b) {
            bVar = (jl1.b) contentData;
        } else {
            bVar = null;
        }
        if (bVar != null && (e16 = com.tencent.mobileqq.guild.feed.part.a.e(this)) != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(e16, null, CoroutineStart.LAZY, new CommentFunctionPart$doItemOptionTop$job$1(this, ca5, bVar, null), 1, null);
            if (oa()) {
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230);
                createCustomDialog.setMessage("\u5df2\u6709\u7f6e\u9876\uff0c\u7ee7\u7eed\u64cd\u4f5c\u5c06\u66ff\u6362\u7f6e\u9876\uff0c\u786e\u5b9a\u7ee7\u7eed\u5417\uff1f");
                createCustomDialog.adjustMessageLayout(true);
                createCustomDialog.setNegativeButton("\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.g
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        CommentFunctionPart.T9(dialogInterface, i3);
                    }
                });
                createCustomDialog.setPositiveButton("\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.h
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        CommentFunctionPart.U9(Job.this, dialogInterface, i3);
                    }
                });
                createCustomDialog.show();
                return;
            }
            launch$default.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Job job, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(job, "$job");
        job.start();
        dialogInterface.dismiss();
    }

    private final void V9(hl1.g contentData, Context context) {
        jl1.b bVar;
        LifecycleCoroutineScope e16;
        QLog.i("CommentFunctionPart", 1, "doItemOptionUnTop " + contentData);
        a.CommentMainFeedData ca5 = ca(this, null, 1, null);
        if (ca5 == null) {
            return;
        }
        if (contentData instanceof jl1.b) {
            bVar = (jl1.b) contentData;
        } else {
            bVar = null;
        }
        if (bVar != null && (e16 = com.tencent.mobileqq.guild.feed.part.a.e(this)) != null) {
            BuildersKt__Builders_commonKt.launch$default(e16, null, null, new CommentFunctionPart$doItemOptionUnTop$1(this, ca5, bVar, null), 3, null);
        }
    }

    private final void W9(int position, jl1.h replyItemData, GProStLike oldLikeInfo) {
        GProStComment ea5;
        GProStDoLikeReq da5 = da(oldLikeInfo, true);
        if (da5 == null || (ea5 = ea(replyItemData.getCommonInfo().getItemGroupPosition())) == null) {
            return;
        }
        GProStComment gProStComment = new GProStComment();
        gProStComment.idd = ea5.idd;
        gProStComment.postUser.idd = ea5.postUser.idd;
        da5.comment = gProStComment;
        GProStReply gProStReply = new GProStReply();
        gProStReply.idd = replyItemData.getReplyData().idd;
        gProStReply.postUser.idd = replyItemData.getReplyData().postUser.idd;
        GProStLike gProStLike = new GProStLike();
        gProStLike.idd = replyItemData.getReplyData().idd;
        gProStLike.status = replyItemData.getReplyData().likeInfo.status;
        gProStReply.likeInfo = gProStLike;
        da5.reply = gProStReply;
        GProStLike gProStLike2 = new GProStLike();
        gProStLike2.idd = replyItemData.getReplyData().idd;
        gProStLike2.status = replyItemData.getReplyData().likeInfo.status;
        da5.like = gProStLike2;
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        String str = replyItemData.getReplyData().idd;
        Intrinsics.checkNotNullExpressionValue(str, "replyItemData.replyData.idd");
        IPerformanceReportTask e16 = cVar.e(da5, true, str);
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            String str2 = ea5.idd;
            Intrinsics.checkNotNullExpressionValue(str2, "hostComment.idd");
            String str3 = replyItemData.getReplyData().idd;
            Intrinsics.checkNotNullExpressionValue(str3, "replyItemData.replyData.idd");
            c16.doLike(da5, qa(position, oldLikeInfo, replyItemData, str2, str3, replyItemData.getReplyData().likeInfo.status, e16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(hl1.g contentData, int position) {
        if (contentData instanceof jl1.h) {
            jl1.h hVar = (jl1.h) contentData;
            broadcastMessage("message_resend_reply_item", new g.OnResendReplyItem(hVar));
            String str = hVar.getReplyData().idd;
            Intrinsics.checkNotNullExpressionValue(str, "contentData.replyData.idd");
            broadcastMessage("message_reply_request_operation", new a.ReplyRequestOperation(2, str, contentData));
            return;
        }
        if (contentData instanceof jl1.b) {
            jl1.b bVar = (jl1.b) contentData;
            broadcastMessage("message_resend_comment_item", new g.OnResendCommentItem(bVar));
            String str2 = bVar.getCommentData().idd;
            Intrinsics.checkNotNullExpressionValue(str2, "contentData.commentData.idd");
            broadcastMessage("message_comment_request_operation", new a.CommentRequestOperation(2, str2, contentData));
        }
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.b Y9() {
        return (com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.b) this.commentFeedRequestSender.getValue();
    }

    private final CommentFunctionPart$commentRequestCallback$2.a aa() {
        return (CommentFunctionPart$commentRequestCallback$2.a) this.commentRequestCallback.getValue();
    }

    private final a.CommentMainFeedData ba(Object extData) {
        a.OnCommentMainFeedDataResult onCommentMainFeedDataResult;
        Object broadcastGetMessage = broadcastGetMessage("message_get_comment_feed_data", extData);
        if (broadcastGetMessage instanceof a.OnCommentMainFeedDataResult) {
            onCommentMainFeedDataResult = (a.OnCommentMainFeedDataResult) broadcastGetMessage;
        } else {
            onCommentMainFeedDataResult = null;
        }
        if (onCommentMainFeedDataResult == null) {
            return null;
        }
        return onCommentMainFeedDataResult.getMainFeedData();
    }

    static /* synthetic */ a.CommentMainFeedData ca(CommentFunctionPart commentFunctionPart, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = null;
        }
        return commentFunctionPart.ba(obj);
    }

    private final GProStDoLikeReq da(GProStLike oldLikeInfo, boolean isReply) {
        GProStFeed ia5 = ia();
        if (ia5 == null) {
            return null;
        }
        GProStDoLikeReq gProStDoLikeReq = new GProStDoLikeReq();
        gProStDoLikeReq.feed = ia5;
        gProStDoLikeReq.likeType = ol1.a.f423087a.a(1 - oldLikeInfo.status, isReply);
        gProStDoLikeReq.emotionReaction = L9();
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        gProStCommonExt.mapInfoList.addAll(yl1.i.f450608a.f());
        gProStDoLikeReq.extInfo = gProStCommonExt;
        return gProStDoLikeReq;
    }

    private final GProStComment ea(int itemGroupPos) {
        Object broadcastGetMessage = broadcastGetMessage("action_get_comment_struct", new g.GetCommentStructArgs(itemGroupPos));
        if (broadcastGetMessage instanceof GProStComment) {
            return (GProStComment) broadcastGetMessage;
        }
        return null;
    }

    private final com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.b ga() {
        return (com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.b) this.replyCommentRequestSender.getValue();
    }

    private final CommentFunctionPart$replyRequestCallback$2.a ha() {
        return (CommentFunctionPart$replyRequestCallback$2.a) this.replyRequestCallback.getValue();
    }

    private final GProStFeed ia() {
        a.CommentMainFeedData ca5 = ca(this, null, 1, null);
        if (ca5 == null) {
            return null;
        }
        GProStFeed gProStFeed = new GProStFeed();
        gProStFeed.idd = ca5.getFeedId();
        gProStFeed.poster.idd = ca5.getPosterId();
        gProStFeed.createTime = ca5.getCreateTime();
        return gProStFeed;
    }

    private final void initData() {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (this.initArgs.getGuildId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.initArgs.getChannelId().length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (this.initArgs.getFeedId().length() == 0) {
                    z18 = true;
                }
                if (!z18) {
                    return;
                }
            }
        }
        QLog.e("CommentFunctionPart", 1, "initData error guildId:" + this.initArgs.getGuildId() + " channelId:" + this.initArgs.getChannelId() + " feedId:" + this.initArgs.getFeedId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TopFeedCommentApi ja() {
        return (TopFeedCommentApi) this.topFeedCommentApi.getValue();
    }

    private final void la(Object args) {
        if (!(args instanceof g.CommentListVisibilityChangeMessage)) {
            QLog.i("CommentFunctionPart", 1, "handleMessageCommentListVisibilityChange args error!");
            return;
        }
        if (((g.CommentListVisibilityChangeMessage) args).getIsVisible()) {
            if (this.lastShowTimeMills != 0) {
                this.commentListShowTimeMills += System.currentTimeMillis() - this.lastShowTimeMills;
            }
            this.lastShowTimeMills = System.currentTimeMillis();
        } else if (this.lastShowTimeMills != 0) {
            this.commentListShowTimeMills += System.currentTimeMillis() - this.lastShowTimeMills;
            this.lastShowTimeMills = 0L;
        }
    }

    private final void ma(Object args) {
        Integer num;
        if (!(args instanceof g.OnDataChangedRenderOnScreenMessage)) {
            QLog.i("CommentFunctionPart", 1, "handleMessageDataChangedRenderOnScreen args error!");
            return;
        }
        Iterator<T> it = ((g.OnDataChangedRenderOnScreenMessage) args).a().iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (((Number) pair.getFirst()).intValue() == 6 || ((Number) pair.getFirst()).intValue() == 2) {
                QLog.i("CommentFunctionPart", 1, "handleMessageDataChangedRenderOnScreen");
                Object second = pair.getSecond();
                if (second instanceof Integer) {
                    num = (Integer) second;
                } else {
                    num = null;
                }
                if (num != null) {
                    final int intValue = num.intValue();
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            CommentFunctionPart.na(CommentFunctionPart.this, intValue);
                        }
                    }, 500L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(CommentFunctionPart this$0, int i3) {
        g.GetCommentItemOffsetMessage getCommentItemOffsetMessage;
        int i16;
        View a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object broadcastGetMessage = this$0.broadcastGetMessage("action_get_comment_item_offset", null);
        if (broadcastGetMessage instanceof g.GetCommentItemOffsetMessage) {
            getCommentItemOffsetMessage = (g.GetCommentItemOffsetMessage) broadcastGetMessage;
        } else {
            getCommentItemOffsetMessage = null;
        }
        if (getCommentItemOffsetMessage != null) {
            i16 = getCommentItemOffsetMessage.getOffset();
        } else {
            i16 = 0;
        }
        vi1.g gVar = (vi1.g) RFWIocAbilityProvider.g().getIocInterface(vi1.g.class, this$0.getPartRootView(), null);
        if (gVar != null && (a16 = gVar.a(i3 + i16)) != null) {
            CommentHighlightAbility.f220918a.b(a16, R.drawable.guild_comment_item_bg_selector);
        }
    }

    private final boolean oa() {
        Boolean bool = null;
        Object broadcastGetMessage = broadcastGetMessage("action_get_has_top_comment", null);
        if (broadcastGetMessage instanceof Boolean) {
            bool = (Boolean) broadcastGetMessage;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final GuildFeedGalleryInitBean pa(GProStImage gproStImage, String commentId, String replyId) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        guildFeedGalleryInitBean.setRichMediaDataList(K9(gproStImage));
        guildFeedGalleryInitBean.setEnterPos(0);
        guildFeedGalleryInitBean.setFromPage(0);
        guildFeedGalleryInitBean.setGuildId(this.initArgs.getGuildId());
        guildFeedGalleryInitBean.setChannelId(this.initArgs.getChannelId());
        guildFeedGalleryInitBean.setCommentId(commentId);
        guildFeedGalleryInitBean.setReplyId(replyId);
        guildFeedGalleryInitBean.setFeedId(getFeedId());
        guildFeedGalleryInitBean.setOpenType(2);
        guildFeedGalleryInitBean.setPosterId(((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId());
        guildFeedGalleryInitBean.setLongPresPopMoreDialog(true);
        return guildFeedGalleryInitBean;
    }

    private final IGProDoLikeCallback qa(final int position, final GProStLike oldLikeInfo, final hl1.g contentData, final String commentId, final String replyId, final int status, final IPerformanceReportTask reportTask) {
        return new IGProDoLikeCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.c
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoLikeCallback
            public final void onResult(int i3, String str, boolean z16, GProStDoLikeRsp gProStDoLikeRsp) {
                CommentFunctionPart.ra(IPerformanceReportTask.this, this, position, oldLikeInfo, contentData, commentId, replyId, status, i3, str, z16, gProStDoLikeRsp);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(IPerformanceReportTask reportTask, final CommentFunctionPart this$0, final int i3, final GProStLike oldLikeInfo, final hl1.g contentData, final String commentId, final String replyId, final int i16, final int i17, final String str, boolean z16, GProStDoLikeRsp gProStDoLikeRsp) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(oldLikeInfo, "$oldLikeInfo");
        Intrinsics.checkNotNullParameter(contentData, "$contentData");
        Intrinsics.checkNotNullParameter(commentId, "$commentId");
        Intrinsics.checkNotNullParameter(replyId, "$replyId");
        com.tencent.mobileqq.guild.feed.report.c.E(com.tencent.mobileqq.guild.feed.report.c.f223280a, reportTask, i17, str, false, 8, null);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.d
            @Override // java.lang.Runnable
            public final void run() {
                CommentFunctionPart.sa(i17, str, this$0, i3, oldLikeInfo, contentData, commentId, replyId, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(int i3, String str, CommentFunctionPart this$0, int i16, GProStLike oldLikeInfo, hl1.g contentData, String commentId, String replyId, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(oldLikeInfo, "$oldLikeInfo");
        Intrinsics.checkNotNullParameter(contentData, "$contentData");
        Intrinsics.checkNotNullParameter(commentId, "$commentId");
        Intrinsics.checkNotNullParameter(replyId, "$replyId");
        QLog.d("CommentFunctionPart", 1, "result = " + i3 + ", msg = " + str);
        if (i3 != 0) {
            this$0.broadcastMessage("message_update_comment_list_like_status", new g.UpdateCommentListPreferStatusMessage(i16, false, oldLikeInfo, contentData));
            QQToast.makeText(BaseApplication.context, 1, str, 0).show();
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedNoticeEvent(commentId, replyId, i17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(int i3, CommentFunctionPart this$0, hl1.g contentData, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contentData, "$contentData");
        QLog.d("CommentFunctionPart", 1, "doOption, pos=" + i3 + ", optionType=" + i16);
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 == 5) {
                                Context context = this$0.getPartRootView().getContext();
                                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                                this$0.V9(contentData, context);
                                return;
                            }
                            return;
                        }
                        Context context2 = this$0.getPartRootView().getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
                        this$0.S9(contentData, context2);
                        return;
                    }
                    nl1.b bVar = nl1.b.f420422a;
                    Context context3 = this$0.getPartRootView().getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "rootView.context");
                    bVar.b(contentData, context3, this$0.initArgs.getChannelId(), this$0.initArgs.getGuildId());
                    return;
                }
                Context context4 = this$0.getPartRootView().getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "rootView.context");
                this$0.R9(contentData, context4);
                return;
            }
            this$0.Q9(contentData, i3);
            return;
        }
        this$0.ua(contentData, i3);
    }

    private final void ua(final hl1.g contentData, final int position) {
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, "\u786e\u8ba4\u5220\u9664\u8be5\u8bc4\u8bba", getContext().getString(R.string.cancel), getContext().getString(R.string.a8j), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                CommentFunctionPart.va(CommentFunctionPart.this, contentData, position, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                CommentFunctionPart.wa(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(CommentFunctionPart this$0, hl1.g contentData, int i3, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contentData, "$contentData");
        this$0.P9(contentData, i3);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final boolean xa(String commentPosterId) {
        return !Intrinsics.areEqual(((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId(), commentPosterId);
    }

    private final boolean za(hl1.g comment) {
        boolean z16;
        jl1.b bVar;
        if (!this.initArgs.getSupportsTop()) {
            return false;
        }
        vl1.b bVar2 = (vl1.b) PartIOCKt.getIocInterface(this, vl1.b.class);
        if (bVar2 != null && bVar2.y0() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (comment instanceof jl1.b) {
            bVar = (jl1.b) comment;
        } else {
            bVar = null;
        }
        if (bVar == null || jl1.c.b(bVar)) {
            return false;
        }
        if (!ch.m0(getGuildId()) && !Intrinsics.areEqual(r(), ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId())) {
            return false;
        }
        return true;
    }

    @Override // vl1.a
    public void A6(@NotNull final hl1.g contentData, final int position) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        if (contentData instanceof jl1.h) {
            jl1.h hVar = (jl1.h) contentData;
            str = hVar.getReplyData().postUser.idd;
            Intrinsics.checkNotNullExpressionValue(str, "contentData.replyData.postUser.idd");
            str2 = hVar.getReplyData().idd;
            Intrinsics.checkNotNullExpressionValue(str2, "contentData.replyData.idd");
        } else if (contentData instanceof jl1.b) {
            jl1.b bVar = (jl1.b) contentData;
            str = bVar.getCommentData().postUser.idd;
            Intrinsics.checkNotNullExpressionValue(str, "contentData.commentData.postUser.idd");
            str2 = bVar.getCommentData().idd;
            Intrinsics.checkNotNullExpressionValue(str2, "contentData.commentData.idd");
        } else {
            QLog.e("CommentFunctionPart", 1, "openBottomDialog error, invalid type");
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sgrp_comment_id", str2);
        linkedHashMap.put("sgrp_channel_id", getGuildId());
        linkedHashMap.put("sgrp_sub_channel_id", getChannelId());
        linkedHashMap.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(getGuildId())));
        linkedHashMap.put("sgrp_feed_id", getFeedId());
        linkedHashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        FragmentManager fragmentManager = getHostFragment().getFragmentManager();
        if (fragmentManager != null) {
            CommentItemOptionFragment.INSTANCE.a(TuplesKt.to("pg_sgrp_comment_operate_float", new PageParams(linkedHashMap)), fragmentManager, za(contentData), Ba(contentData), M9(str), xa(str), new ml1.a() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.a
                @Override // ml1.a
                public final void a(int i3) {
                    CommentFunctionPart.ta(position, this, contentData, i3);
                }
            });
        }
    }

    @Override // vl1.a
    public void G0(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.allVisibleCommentIds.add(id5);
    }

    @Override // vl1.a
    public void G7(int position, @NotNull hl1.g contentData, @NotNull GProStLike oldLikeInfo) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(oldLikeInfo, "oldLikeInfo");
        if (contentData instanceof jl1.h) {
            W9(position, (jl1.h) contentData, oldLikeInfo);
        } else if (contentData instanceof jl1.b) {
            N9(position, (jl1.b) contentData, oldLikeInfo);
        }
    }

    @Override // vl1.a
    public void H1(@NotNull ReplyCommentArgs commentMeta) {
        Intrinsics.checkNotNullParameter(commentMeta, "commentMeta");
        broadcastMessage("message_reply_comment", new a.ReplyCommentMessage("commentFunctionPart", new ShowInputComponentArgs(InputFunctionType.FUNCTION_TYPE_REPLY_COMMENT, commentMeta, 0, (short) 3, null, 16, null)));
    }

    @Override // vl1.a
    public void N6(@NotNull GProStImage gproStImage, @NotNull String commentId, @NotNull String replyId, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(gproStImage, "gproStImage");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyId, "replyId");
        Intrinsics.checkNotNullParameter(context, "context");
        GuildFeedLauncher.G(context, pa(gproStImage, commentId, replyId));
    }

    @Override // vl1.a
    public void O4(@NotNull jl1.h reply, @Nullable Object payload) {
        Intrinsics.checkNotNullParameter(reply, "reply");
        GProStComment ea5 = ea(reply.getCommonInfo().getItemGroupPosition());
        if (ea5 != null) {
            broadcastMessage("message_reply_comment", new a.ReplyCommentMessage("commentFunctionPart", new ShowInputComponentArgs(InputFunctionType.FUNCTION_TYPE_REPLY_COMMENT, new ReplyCommentArgs(2, ea5, reply.getReplyData(), payload, false, 16, null), 0, (short) 3, null, 16, null)));
        }
    }

    public final void P9(@NotNull hl1.g contentData, int position) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        broadcastMessage("message_delete_comment_list_item", new g.DeleteCommentListItemMessage(contentData, position));
        a.CommentMainFeedData ca5 = ca(this, null, 1, null);
        if (ca5 == null) {
            return;
        }
        if (contentData instanceof jl1.h) {
            jl1.h hVar = (jl1.h) contentData;
            GProStComment ea5 = ea(hVar.getCommonInfo().getItemGroupPosition());
            if (ea5 == null) {
                return;
            }
            ga().c(ca5, hVar.getReplyData(), ea5, Intrinsics.areEqual(r(), ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId()), ha());
            return;
        }
        if (contentData instanceof jl1.b) {
            Y9().c(ca5, ((jl1.b) contentData).getCommentData(), Intrinsics.areEqual(r(), ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId()), aa());
        }
    }

    public final void Q9(@NotNull hl1.g contentData, int position) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        if (contentData instanceof jl1.h) {
            QLog.d("CommentFunctionPart", 1, "doItemOptionReply to ReplyItemData, position=" + position);
            O4((jl1.h) contentData, Integer.valueOf(position));
            return;
        }
        if (contentData instanceof jl1.b) {
            QLog.d("CommentFunctionPart", 1, "doItemOptionReply to CommentItemData, position=" + position);
            H1(new ReplyCommentArgs(1, ((jl1.b) contentData).getCommentData(), null, Integer.valueOf(position), false, 16, null));
        }
    }

    public final void R9(@NotNull hl1.g contentData, @NotNull Context context) {
        String str;
        String str2;
        String str3;
        boolean z16;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(context, "context");
        String guildId = getGuildId();
        String channelId = getChannelId();
        String feedId = getFeedId();
        String str4 = null;
        if (contentData instanceof jl1.b) {
            jl1.b bVar = (jl1.b) contentData;
            String str5 = bVar.getCommentData().idd;
            Intrinsics.checkNotNullExpressionValue(str5, "contentData.commentData.idd");
            String str6 = bVar.getCommentData().postUser.idd;
            Intrinsics.checkNotNullExpressionValue(str6, "contentData.commentData.postUser.idd");
            str2 = str6;
            str3 = str5;
            str = null;
        } else {
            String str7 = "";
            if (contentData instanceof jl1.h) {
                jl1.h hVar = (jl1.h) contentData;
                String str8 = hVar.getReplyData().idd;
                GProStComment ea5 = ea(hVar.getCommonInfo().getItemGroupPosition());
                if (ea5 != null) {
                    str4 = ea5.idd;
                }
                if (str4 != null) {
                    str7 = str4;
                }
                String str9 = hVar.getReplyData().postUser.idd;
                Intrinsics.checkNotNullExpressionValue(str9, "contentData.replyData.postUser.idd");
                str2 = str9;
                str = str8;
                str3 = str7;
            } else {
                str = null;
                str2 = "";
                str3 = str2;
            }
        }
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("CommentFunctionPart", 1, "comment/reply report error: evilUin is empty!");
        } else {
            nl1.b.f420422a.c(context, guildId, channelId, feedId, str2, str3, str);
        }
    }

    @Override // vl1.a
    @Nullable
    public String S3(int itemGroupPosition) {
        GProStComment ea5 = ea(itemGroupPosition);
        if (ea5 != null) {
            return ea5.idd;
        }
        return null;
    }

    @Override // vl1.a
    public void U8(@NotNull View view, @NotNull String tinyId, long uin, int type, @NotNull String commentId, @NotNull String replyId, int groupPos) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(commentId, "commentId");
        Intrinsics.checkNotNullParameter(replyId, "replyId");
        QLog.d("CommentFunctionPart", 1, "open profileCard guildId:" + this.initArgs.getGuildId() + ", feedId:" + this.initArgs.getFeedId() + ", tinyId:" + tinyId + ", channelId:" + this.initArgs.getChannelId() + ", troopUin: " + this.initArgs.getTroopUin());
        if (!TextUtils.isEmpty(this.initArgs.getTroopUin()) && uin != 0) {
            ax.M(this.initArgs.getTroopUin(), String.valueOf(uin));
            return;
        }
        if (getPartHost().getHostActivity() != null) {
            if (tinyId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (type != 1) {
                    GProStComment ea5 = ea(groupPos);
                    if (ea5 != null) {
                        str = ea5.idd;
                    } else {
                        str = null;
                    }
                    commentId = str;
                    if (commentId == null) {
                        commentId = "";
                    }
                }
                GuildProfileData guildProfileData = new GuildProfileData(this.initArgs.getGuildId(), "", tinyId, 0, 8);
                guildProfileData.getGuildBaseProfileData().r(this.initArgs.getChannelId());
                guildProfileData.setFeedImpeachData(new FeedImpeachData(type, getFeedId(), commentId, replyId));
                GuildProfileCard.Lh(getPartHost().getHostActivity(), guildProfileData);
            }
        }
    }

    public final long Z9() {
        if (this.lastShowTimeMills != 0) {
            return this.commentListShowTimeMills + (System.currentTimeMillis() - this.lastShowTimeMills);
        }
        return this.commentListShowTimeMills;
    }

    @Override // vl1.a
    public void a3(boolean needFold, @NotNull jl1.h replyItemData) {
        Intrinsics.checkNotNullParameter(replyItemData, "replyItemData");
        if (needFold) {
            broadcastMessage("message_fold_reply_list", new g.FoldReplyListMessage(replyItemData));
        } else {
            broadcastMessage("message_expand_reply_list", new g.ExpandReplyListMessage(replyItemData));
        }
        QLog.d("CommentFunctionPart", 4, "doFold");
    }

    @Override // vl1.a
    @NotNull
    public String getChannelId() {
        return this.initArgs.getChannelId();
    }

    @NotNull
    public String getFeedId() {
        return this.initArgs.getFeedId();
    }

    @Override // vl1.a
    @NotNull
    public String getGuildId() {
        return this.initArgs.getGuildId();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_data_changed_render_on_screen")) {
            ma(args);
        } else if (Intrinsics.areEqual(action, "message_comment_list_visibility_change")) {
            la(args);
        }
    }

    @Override // vl1.a
    public void n4(@NotNull jl1.b commentItemData) {
        Intrinsics.checkNotNullParameter(commentItemData, "commentItemData");
        broadcastMessage("message_expand_comment_item", new g.ExpandCommentItemMessage(commentItemData));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initData();
        RFWIocAbilityProvider.g().registerIoc(rootView, this, vl1.a.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), vl1.a.class);
    }

    @Override // vl1.a
    public void q6(@NotNull final hl1.g contentData, final int position) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        nl1.b bVar = nl1.b.f420422a;
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        bVar.e(rootView, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart$openFailActionSheet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                if (i3 == 0) {
                    CommentFunctionPart.this.X9(contentData, position);
                } else {
                    if (i3 != 1) {
                        return;
                    }
                    CommentFunctionPart.this.O9(contentData);
                }
            }
        });
    }

    @Override // vl1.a
    @NotNull
    public String r() {
        String posterId;
        a.CommentMainFeedData ca5 = ca(this, null, 1, null);
        if (ca5 != null && (posterId = ca5.getPosterId()) != null) {
            return posterId;
        }
        return "";
    }

    @Override // vl1.a
    public void v3(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.allVisibleReplyIds.add(id5);
    }

    @Override // vl1.a
    public int z3() {
        return this.allVisibleCommentIds.size() + this.allVisibleReplyIds.size();
    }
}
