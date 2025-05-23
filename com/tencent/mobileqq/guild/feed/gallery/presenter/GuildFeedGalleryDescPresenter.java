package com.tencent.mobileqq.guild.feed.gallery.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quitagview.QUITagIcon;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryShowContentEvent;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryEllipsizeTextViewLayout;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedJoinChannelGuideBar;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.feed.util.FeedShareContentHelper;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00d1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001W\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0001bB\u000f\u0012\u0006\u0010^\u001a\u00020]\u00a2\u0006\u0004\b_\u0010`J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0003H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010 2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010.\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00112\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J*\u00103\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00112\u0006\u0010-\u001a\u00020,2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u000101H\u0016J\u000e\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020 J$\u00109\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070706j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000707`8H\u0016J\u0012\u0010<\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010>\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010XR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010[\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryDescPresenter;", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/b;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "requestView", "", "J", "", "data", "H", "", "M", "I", "O", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "L", "Ljk1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "E", HippyTKDListViewAdapter.X, "B", "K", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStUser;", QCircleAlphaUserReporter.KEY_USER, "y", "D", UserInfo.SEX_FEMALE, "", "time", "", "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "N", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "r", "onPreloadResult", "action", "g", "Lcom/tencent/mobileqq/guild/feed/manager/f;", "selectInfo", "p", "", "position", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "", "payloads", "l", "guildId", "P", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "view", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "mAvatarView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mNickName", "mTimeTv", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryEllipsizeTextViewLayout;", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryEllipsizeTextViewLayout;", "mFeedContentDescLayout", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mUserInfoLayout", "mPresenterRootView", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedJoinChannelGuideBar;", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedJoinChannelGuideBar;", "mGuildInfoRootView", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "mApprovalStatusTag", "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "Lcom/tencent/mobileqq/guild/feed/util/FeedShareContentHelper;", "mFeedShareContentHelper", "com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryDescPresenter$b", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryDescPresenter$b;", "feedGalleryParseConfig", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "serviceObserver", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "defaultBean", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryDescPresenter extends com.tencent.mobileqq.guild.feed.gallery.presenter.b implements View.OnClickListener {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryInitBean initBean;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GuildUserAvatarViewWithPendant mAvatarView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mNickName;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView mTimeTv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryEllipsizeTextViewLayout mFeedContentDescLayout;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mUserInfoLayout;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mPresenterRootView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private GuildFeedJoinChannelGuideBar mGuildInfoRootView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private QUITagView mApprovalStatusTag;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private FeedShareContentHelper mFeedShareContentHelper;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final b feedGalleryParseConfig;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver serviceObserver;

    @Metadata(d1 = {"\u0000U\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\t\u0010\r\u001a\u00020\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\fH\u0096\u0001J\t\u0010\u000f\u001a\u00020\fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\fH\u0096\u0001J\t\u0010\u0012\u001a\u00020\fH\u0096\u0001J\t\u0010\u0013\u001a\u00020\fH\u0096\u0001J\t\u0010\u0014\u001a\u00020\fH\u0096\u0001J\t\u0010\u0015\u001a\u00020\fH\u0096\u0001J\t\u0010\u0016\u001a\u00020\fH\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0017H\u0096\u0001J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019H\u0096\u0001J\b\u0010\u001b\u001a\u00020\u0005H\u0016J$\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001d`\u001eH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010&\u001a\u00020\u00058\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryDescPresenter$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "", "p", "t", "", "", "getHighlightWords", ReportConstant.COSTREPORT_PREFIX, "", "g", "i", "j", tl.h.F, "u", "k", "o", "e", "d", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", "getTraceID", "Landroid/graphics/drawable/Drawable;", "v", "w", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IParseRichTextConfig<GProStRichTextContent> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f219721b = IParseRichTextConfig.INSTANCE.a();

        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f219721b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            HashMap<String, Object> elementDtParams = GuildFeedGalleryDescPresenter.this.d();
            Intrinsics.checkNotNullExpressionValue(elementDtParams, "elementDtParams");
            return elementDtParams;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f219721b.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f219721b.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return this.f219721b.f();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f219721b.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f219721b.getHighlightWords();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221009e() {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = GuildFeedGalleryDescPresenter.this.initBean;
            if (guildFeedGalleryInitBean != null) {
                return guildFeedGalleryInitBean.getTraceId();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f219721b.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f219721b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f219721b.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return this.f219721b.k();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f219721b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f219721b.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return this.f219721b.o();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221008d() {
            return this.f219721b.getF221008d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return 21;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f219721b.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f219721b.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.f219721b.t();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f219721b.u();
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
            int i3 = t16.urlContent.type;
            if (i3 == 3 || i3 == 1) {
                return false;
            }
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryDescPresenter$c", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/p;", "Landroid/view/View;", "v", "", "a", "c", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.feed.gallery.widget.p {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.gallery.widget.p
        public void a(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (GuildFeedGalleryDescPresenter.this.M()) {
                GuildFeedGalleryDescPresenter.this.h(v3.getContext(), GuildFeedGalleryDescPresenter.this.initBean, 0, 6);
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(GuildFeedGalleryDescPresenter.this.mFeedContentDescLayout, "em_sgrp_forum_viewer_detail", "clck", GuildFeedGalleryDescPresenter.this.d());
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.gallery.widget.p
        public void b(@NotNull View v3) {
            Map<? extends String, ? extends Object> mapOf;
            Intrinsics.checkNotNullParameter(v3, "v");
            GuildFeedGalleryDescPresenter.this.f219733h.a("message_on_fold_desc_content_text", null);
            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
            HashMap<String, Object> d16 = GuildFeedGalleryDescPresenter.this.d();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 2));
            d16.putAll(mapOf);
            Unit unit = Unit.INSTANCE;
            iGuildDTReportApi.reportDtEventManual(v3, "em_sgrp_unfold_packup", "clck", d16);
        }

        @Override // com.tencent.mobileqq.guild.feed.gallery.widget.p
        public void c(@NotNull View v3) {
            Map<? extends String, ? extends Object> mapOf;
            Intrinsics.checkNotNullParameter(v3, "v");
            GuildFeedGalleryDescPresenter.this.f219733h.a("message_on_expand_desc_content_text", null);
            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
            HashMap<String, Object> d16 = GuildFeedGalleryDescPresenter.this.d();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 1));
            d16.putAll(mapOf);
            Unit unit = Unit.INSTANCE;
            iGuildDTReportApi.reportDtEventManual(v3, "em_sgrp_unfold_packup", "clck", d16);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryDescPresenter$d", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "", "onAddGuildWithInfo", "", "guildId", "onRemoveGuild", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends GPServiceObserver {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@NotNull IGProGuildInfo info, int sourceType) {
            String str;
            boolean z16;
            GProStFeed b16;
            GProStChannelInfo gProStChannelInfo;
            GProStChannelSign gProStChannelSign;
            Intrinsics.checkNotNullParameter(info, "info");
            jk1.a aVar = GuildFeedGalleryDescPresenter.this.f219730d;
            if (aVar != null && (b16 = aVar.b()) != null && (gProStChannelInfo = b16.channelInfo) != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
                str = Long.valueOf(gProStChannelSign.guildId).toString();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && Intrinsics.areEqual(info.getGuildID(), str)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild_Feed_GAL_GuildFeedGalleryDescPresenter", 2, "onAddGuildWithInfo guildId: " + str);
                }
                GuildFeedGalleryDescPresenter guildFeedGalleryDescPresenter = GuildFeedGalleryDescPresenter.this;
                String guildID = info.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "info.guildID");
                guildFeedGalleryDescPresenter.P(guildID);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            Long l3;
            boolean z16;
            GProStFeed b16;
            GProStChannelInfo gProStChannelInfo;
            GProStChannelSign gProStChannelSign;
            jk1.a aVar = GuildFeedGalleryDescPresenter.this.f219730d;
            if (aVar != null && (b16 = aVar.b()) != null && (gProStChannelInfo = b16.channelInfo) != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
                l3 = Long.valueOf(gProStChannelSign.guildId);
            } else {
                l3 = null;
            }
            String valueOf = String.valueOf(l3);
            if (valueOf.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && Intrinsics.areEqual(guildId, valueOf)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild_Feed_GAL_GuildFeedGalleryDescPresenter", 2, "onRemoveGuild guildId: " + valueOf);
                }
                GuildFeedGalleryDescPresenter.this.P(guildId);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryDescPresenter(@NotNull GuildFeedDefaultInitBean defaultBean) {
        super(defaultBean);
        Intrinsics.checkNotNullParameter(defaultBean, "defaultBean");
        this.feedGalleryParseConfig = new b();
        this.serviceObserver = new d();
    }

    private final void A(GProStFeed feed) {
        boolean z16;
        List listOf;
        Object firstOrNull;
        boolean z17;
        GuildFeedGalleryEllipsizeTextViewLayout guildFeedGalleryEllipsizeTextViewLayout = this.mFeedContentDescLayout;
        if (guildFeedGalleryEllipsizeTextViewLayout != null) {
            FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
            ArrayList<GProStRichTextContent> arrayList = feed.title.contents;
            Intrinsics.checkNotNullExpressionValue(arrayList, "feed.title.contents");
            Pair s16 = FeedRichTextContentParser.s(feedRichTextContentParser, arrayList, null, null, null, null, 15, null);
            ArrayList<GProStRichTextContent> arrayList2 = feed.contents.contents;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "feed.contents.contents");
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
            String str = feed.channelInfo.sign.joinGuildSig;
            Intrinsics.checkNotNullExpressionValue(str, "feed.channelInfo.sign.joinGuildSig");
            Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> r16 = feedRichTextContentParser.r(arrayList2, feedRichTextContentParser.d(guildFeedGalleryInitBean, str), this.feedGalleryParseConfig, String.valueOf(feed.channelInfo.sign.channelId), String.valueOf(feed.channelInfo.sign.guildId));
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) s16.getFirst();
            SpannableStringBuilder first = r16.getFirst();
            if (QLog.isColorLevel()) {
                QLog.d("Guild_Feed_GAL_GuildFeedGalleryDescPresenter", 1, "title: " + ((Object) spannableStringBuilder) + ", content: " + ((Object) first));
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (M()) {
                spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
                if (first.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    spannableStringBuilder2.append((CharSequence) "\n").append((CharSequence) first);
                }
            } else {
                spannableStringBuilder2.append((CharSequence) first);
            }
            if (spannableStringBuilder2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                GuildFeedGalleryEllipsizeTextViewLayout guildFeedGalleryEllipsizeTextViewLayout2 = this.mFeedContentDescLayout;
                if (guildFeedGalleryEllipsizeTextViewLayout2 != null) {
                    guildFeedGalleryEllipsizeTextViewLayout2.setVisibility(0);
                }
                String str2 = feed.idd + spannableStringBuilder2.length();
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{s16, r16});
                ArrayList arrayList3 = new ArrayList();
                Iterator it = listOf.iterator();
                while (it.hasNext()) {
                    com.tencent.aio.widget.textView.view.b bVar = (com.tencent.aio.widget.textView.view.b) ((Pair) it.next()).getSecond();
                    if (bVar != null) {
                        arrayList3.add(bVar);
                    }
                }
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList3);
                guildFeedGalleryEllipsizeTextViewLayout.setEnableExpand(!M());
                guildFeedGalleryEllipsizeTextViewLayout.setText(spannableStringBuilder2, str2, (com.tencent.aio.widget.textView.view.b) firstOrNull);
                return;
            }
            GuildFeedGalleryEllipsizeTextViewLayout guildFeedGalleryEllipsizeTextViewLayout3 = this.mFeedContentDescLayout;
            if (guildFeedGalleryEllipsizeTextViewLayout3 != null) {
                guildFeedGalleryEllipsizeTextViewLayout3.setVisibility(8);
            }
        }
    }

    private final void B(GuildFeedGalleryInitBean initBean) {
        Context context;
        int i3;
        if (K()) {
            return;
        }
        String valueOf = String.valueOf(initBean.getFeed().channelInfo.sign.guildId);
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam(String.valueOf(initBean.getFeed().channelInfo.sign.channelId), initBean.getFeed().channelInfo.sign.joinGuildSig, "immersive_feed", "others");
        if (initBean.getJoinInfoParam() != null && initBean.getJoinInfoParam().isValid()) {
            joinInfoParam = initBean.getJoinInfoParam();
            Intrinsics.checkNotNullExpressionValue(joinInfoParam, "initBean.joinInfoParam");
        }
        GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar = this.mGuildInfoRootView;
        if (guildFeedJoinChannelGuideBar != null) {
            context = guildFeedJoinChannelGuideBar.getContext();
        } else {
            context = null;
        }
        GuildFeedBaseInitBean q16 = ax.q(context);
        if (q16 != null) {
            i3 = q16.getBusinessType();
        } else {
            i3 = 0;
        }
        boolean h16 = mk1.e.f416895a.h(i3);
        GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar2 = this.mGuildInfoRootView;
        if (guildFeedJoinChannelGuideBar2 != null) {
            guildFeedJoinChannelGuideBar2.K(valueOf, joinInfoParam, h16);
        }
        GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar3 = this.mGuildInfoRootView;
        if (guildFeedJoinChannelGuideBar3 != null) {
            guildFeedJoinChannelGuideBar3.p(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildFeedGalleryDescPresenter.C(GuildFeedGalleryDescPresenter.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(GuildFeedGalleryDescPresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_join_channel_btn", "clck", this$0.d());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D(GProStUser user) {
        int i3;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean != null) {
            Intrinsics.checkNotNull(guildFeedGalleryInitBean);
            i3 = guildFeedGalleryInitBean.getBusinessType();
        } else {
            i3 = 6;
        }
        if (i3 == 7) {
            int i16 = user.nickFlag;
            String str = user.nick;
            Intrinsics.checkNotNullExpressionValue(str, "user.nick");
            if (i16 != 1) {
                if (i16 == 2) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                    String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(user.uin));
                    IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                    Intrinsics.checkNotNullExpressionValue(uid, "uid");
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uid, "Guild_Feed_GAL_GuildFeedGalleryDescPresenter");
                    if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B() && !TextUtils.isEmpty(friendsSimpleInfoWithUid.r())) {
                        TextView textView = this.mNickName;
                        if (textView != null) {
                            textView.setText(friendsSimpleInfoWithUid.r());
                            return;
                        }
                        return;
                    }
                    TextView textView2 = this.mNickName;
                    if (textView2 != null) {
                        textView2.setText(str);
                        return;
                    }
                    return;
                }
                return;
            }
            TextView textView3 = this.mNickName;
            if (textView3 != null) {
                textView3.setText(str);
                return;
            }
            return;
        }
        TextView textView4 = this.mNickName;
        if (textView4 != null) {
            textView4.setText(user.nick);
        }
    }

    private final void E(GProStFeed feed) {
        FeedShareContentHelper feedShareContentHelper;
        Object obj;
        GProThirdBar gProThirdBar = feed.thirdBar;
        if (gProThirdBar != null && (feedShareContentHelper = this.mFeedShareContentHelper) != null) {
            View view = this.f219734i;
            Activity activity = null;
            if (view != null) {
                obj = view.getContext();
            } else {
                obj = null;
            }
            if (obj instanceof Activity) {
                activity = (Activity) obj;
            }
            String id5 = gProThirdBar.f359315id;
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            String icon = gProThirdBar.icon;
            Intrinsics.checkNotNullExpressionValue(icon, "icon");
            String str = gProThirdBar.title + "\u00b7" + gProThirdBar.desc;
            String desc = gProThirdBar.desc;
            Intrinsics.checkNotNullExpressionValue(desc, "desc");
            String buttonScheme = gProThirdBar.buttonScheme;
            Intrinsics.checkNotNullExpressionValue(buttonScheme, "buttonScheme");
            String buttonText = gProThirdBar.buttonText;
            Intrinsics.checkNotNullExpressionValue(buttonText, "buttonText");
            String buttonScheme2 = gProThirdBar.buttonScheme;
            Intrinsics.checkNotNullExpressionValue(buttonScheme2, "buttonScheme");
            feedShareContentHelper.e(activity, new FeedShareContentHelper.ShareContentData(id5, icon, str, desc, buttonScheme, buttonText, buttonScheme2));
        }
    }

    private final void F(GProStFeed feed) {
        Pair pair = TuplesKt.to(Long.valueOf(feed.createTime), Long.valueOf(feed.meta.getLastModifiedTime()));
        String G = G(Math.max(((Number) pair.component1()).longValue(), ((Number) pair.component2()).longValue()));
        TextView textView = this.mTimeTv;
        if (textView != null) {
            textView.setText(G);
        }
    }

    private final String G(long time) {
        if (time == 0) {
            return "";
        }
        return ax.w(time * 1000);
    }

    private final void H(Object data) {
        GuildFeedGalleryEllipsizeTextViewLayout guildFeedGalleryEllipsizeTextViewLayout = this.mFeedContentDescLayout;
        if (guildFeedGalleryEllipsizeTextViewLayout != null) {
            guildFeedGalleryEllipsizeTextViewLayout.h();
        }
    }

    private final void I(View requestView) {
        String str;
        this.mGuildInfoRootView = (GuildFeedJoinChannelGuideBar) requestView.findViewById(R.id.wkx);
        GuildFeedDefaultInitBean guildFeedDefaultInitBean = this.f219735m;
        if (guildFeedDefaultInitBean != null) {
            String str2 = null;
            if (guildFeedDefaultInitBean != null) {
                str = guildFeedDefaultInitBean.getGuildId();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar = this.mGuildInfoRootView;
                if (guildFeedJoinChannelGuideBar != null) {
                    String guildId = this.f219735m.getGuildId();
                    Intrinsics.checkNotNullExpressionValue(guildId, "feedDefaultInitBean.guildId");
                    guildFeedJoinChannelGuideBar.x(guildId);
                }
                GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar2 = this.mGuildInfoRootView;
                if (guildFeedJoinChannelGuideBar2 != null) {
                    guildFeedJoinChannelGuideBar2.setOnClickListener(this);
                }
                GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar3 = this.mGuildInfoRootView;
                if (guildFeedJoinChannelGuideBar3 != null) {
                    guildFeedJoinChannelGuideBar3.q(new Function1<GuildFeedJoinChannelGuideBar.a, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryDescPresenter$initGuildJoinGuideBar$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GuildFeedJoinChannelGuideBar.a aVar) {
                            invoke2(aVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull GuildFeedJoinChannelGuideBar.a configStyle) {
                            Intrinsics.checkNotNullParameter(configStyle, "$this$configStyle");
                            configStyle.q(com.tencent.guild.aio.util.c.b(6));
                            configStyle.v(com.tencent.guild.aio.util.c.b(68));
                            configStyle.u(com.tencent.guild.aio.util.c.b(26));
                            configStyle.r(R.color.f156970gg);
                            configStyle.s(13);
                            configStyle.t(R.drawable.guild_top_join_button_bg);
                            configStyle.y(R.color.f156970gg);
                            configStyle.z(13);
                            configStyle.w(R.color.qui_common_text_allwhite_secondary);
                            configStyle.x(10);
                        }
                    });
                }
                GuildFeedDefaultInitBean guildFeedDefaultInitBean2 = this.f219735m;
                if (guildFeedDefaultInitBean2 != null) {
                    str2 = guildFeedDefaultInitBean2.getGuildId();
                }
                if (str2 == null) {
                    str2 = "";
                }
                P(str2);
                return;
            }
        }
        GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar4 = this.mGuildInfoRootView;
        if (guildFeedJoinChannelGuideBar4 != null) {
            guildFeedJoinChannelGuideBar4.setVisibility(8);
        }
        QLog.e("Guild_Feed_GAL_GuildFeedGalleryDescPresenter", 1, "initGuildJoinGuideBar feedDefaultInitBean?.guildId is empty");
    }

    private final void J(View requestView) {
        FeedShareContentHelper feedShareContentHelper = new FeedShareContentHelper();
        feedShareContentHelper.s(requestView.findViewById(R.id.we6));
        feedShareContentHelper.r((ImageView) requestView.findViewById(R.id.we5));
        feedShareContentHelper.o((ImageView) requestView.findViewById(R.id.f165514we4));
        ImageView mContentArrow = feedShareContentHelper.getMContentArrow();
        if (mContentArrow != null) {
            Context context = mContentArrow.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            mContentArrow.setImageDrawable(GuildUIUtils.w(context, R.drawable.qui_chevron_right, Integer.valueOf(R.color.qui_common_on_brand_primary)));
        }
        feedShareContentHelper.t((TextView) requestView.findViewById(R.id.we8));
        feedShareContentHelper.u(Integer.valueOf(requestView.getResources().getColor(R.color.qui_common_on_brand_primary)));
        this.mFeedShareContentHelper = feedShareContentHelper;
    }

    private final boolean K() {
        boolean z16;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean != null && guildFeedGalleryInitBean.getBusinessType() == 7) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && tl1.e.b(tl1.e.f436522a, false, 1, null)[2]) {
            return true;
        }
        return false;
    }

    private final boolean L(GuildFeedGalleryInitBean initBean) {
        if (initBean.getFeed() != null && (!initBean.getFeed().contents.contents.isEmpty() || !initBean.getFeed().title.contents.isEmpty())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M() {
        GProStFeed feed;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean == null || (feed = guildFeedGalleryInitBean.getFeed()) == null || feed.feedType != 2) {
            return false;
        }
        return true;
    }

    private final void N() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (this.initBean != null && qBaseActivity != null) {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
            Intrinsics.checkNotNull(guildFeedGalleryInitBean);
            String guildId = guildFeedGalleryInitBean.getGuildId();
            GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
            Intrinsics.checkNotNull(guildFeedGalleryInitBean2);
            GuildProfileData guildProfileData = new GuildProfileData(guildId, "", guildFeedGalleryInitBean2.getFeed().poster.idd, 0, 8);
            GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.initBean;
            Intrinsics.checkNotNull(guildFeedGalleryInitBean3);
            String str = guildFeedGalleryInitBean3.getFeed().idd;
            Intrinsics.checkNotNullExpressionValue(str, "initBean!!.feed.idd");
            guildProfileData.setFeedImpeachData(new FeedImpeachData(0, str, "", ""));
            GuildBaseProfileData guildBaseProfileData = guildProfileData.getGuildBaseProfileData();
            GuildFeedGalleryInitBean guildFeedGalleryInitBean4 = this.initBean;
            Intrinsics.checkNotNull(guildFeedGalleryInitBean4);
            guildBaseProfileData.r(guildFeedGalleryInitBean4.getChannelId());
            GuildProfileCard.Lh(qBaseActivity, guildProfileData);
        }
    }

    private final void O() {
        String str;
        GProStFeed b16;
        GProStChannelInfo gProStChannelInfo;
        GProStChannelSign gProStChannelSign;
        if (!at.c()) {
            QLog.e("Guild_Feed_GAL_GuildFeedGalleryDescPresenter", 1, "setDtReport fail, session == null");
            return;
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.mAvatarView, "em_sgrp_forum_avatar", "imp", d());
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.mFeedContentDescLayout, "em_sgrp_forum_viewer_detail", "imp", d());
        jk1.a aVar = this.f219730d;
        if (aVar != null && (b16 = aVar.b()) != null && (gProStChannelInfo = b16.channelInfo) != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
            str = Long.valueOf(gProStChannelSign.guildId).toString();
        } else {
            str = null;
        }
        if (str != null && ((IGPSService) ch.R0(IGPSService.class)).isGuest(str)) {
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.mGuildInfoRootView, "em_sgrp_guide_join_channel", "imp", d());
        }
    }

    private final void x(GProStFeed feed) {
        int i3 = feed.auditStatus;
        if (i3 != 1) {
            if (i3 != 2) {
                QUITagView qUITagView = this.mApprovalStatusTag;
                if (qUITagView != null) {
                    qUITagView.setVisibility(8);
                    return;
                }
                return;
            }
            QUITagView qUITagView2 = this.mApprovalStatusTag;
            if (qUITagView2 != null) {
                QUITagType qUITagType = QUITagType.COLOR_RED;
                QUITagSize qUITagSize = QUITagSize.MIDDLE;
                QUITagIcon qUITagIcon = new QUITagIcon(R.drawable.qui_caution_circle, null, false, 6, null);
                String string = qUITagView2.getResources().getString(R.string.zxv);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.\u2026string.feed_not_approved)");
                qUITagView2.setConfig(new QUITagViewConfig(qUITagType, qUITagSize, qUITagIcon, string));
                qUITagView2.setVisibility(0);
                return;
            }
            return;
        }
        QUITagView qUITagView3 = this.mApprovalStatusTag;
        if (qUITagView3 != null) {
            QUITagType qUITagType2 = QUITagType.COLOR_ORANGE;
            QUITagSize qUITagSize2 = QUITagSize.MIDDLE;
            QUITagIcon qUITagIcon2 = new QUITagIcon(R.drawable.qui_time, null, false, 6, null);
            String string2 = qUITagView3.getResources().getString(R.string.zxs);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(com.\u2026i.R.string.feed_in_audit)");
            qUITagView3.setConfig(new QUITagViewConfig(qUITagType2, qUITagSize2, qUITagIcon2, string2));
            qUITagView3.setVisibility(0);
        }
    }

    private final void y(GProStUser user) {
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = this.mAvatarView;
        if (guildUserAvatarViewWithPendant != null) {
            String str = user.icon.iconUrl;
            Intrinsics.checkNotNullExpressionValue(str, "user.icon.iconUrl");
            String str2 = user.avatarPendant;
            Intrinsics.checkNotNullExpressionValue(str2, "user.avatarPendant");
            guildUserAvatarViewWithPendant.setUrl(str, str2);
        }
    }

    private final void z(jk1.a data) {
        LinearLayout linearLayout = this.mPresenterRootView;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        GuildFeedGalleryInitBean initBean = data.getInitBean();
        this.initBean = initBean;
        Intrinsics.checkNotNull(initBean);
        GProStUser gProStUser = initBean.getFeed().poster;
        Intrinsics.checkNotNullExpressionValue(gProStUser, "initBean!!.feed.poster");
        y(gProStUser);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        GProStUser gProStUser2 = guildFeedGalleryInitBean.getFeed().poster;
        Intrinsics.checkNotNullExpressionValue(gProStUser2, "initBean!!.feed.poster");
        D(gProStUser2);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean2);
        GProStFeed feed = guildFeedGalleryInitBean2.getFeed();
        Intrinsics.checkNotNullExpressionValue(feed, "initBean!!.feed");
        F(feed);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean3);
        GProStFeed feed2 = guildFeedGalleryInitBean3.getFeed();
        Intrinsics.checkNotNullExpressionValue(feed2, "initBean!!.feed");
        A(feed2);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean4 = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean4);
        GProStFeed feed3 = guildFeedGalleryInitBean4.getFeed();
        Intrinsics.checkNotNullExpressionValue(feed3, "initBean!!.feed");
        E(feed3);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean5 = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean5);
        B(guildFeedGalleryInitBean5);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean6 = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean6);
        GProStFeed feed4 = guildFeedGalleryInitBean6.getFeed();
        Intrinsics.checkNotNullExpressionValue(feed4, "initBean!!.feed");
        x(feed4);
    }

    public final void P(@NotNull String guildId) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (K()) {
            GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar = this.mGuildInfoRootView;
            if (guildFeedJoinChannelGuideBar != null) {
                guildFeedJoinChannelGuideBar.setVisibility(8);
                return;
            }
            return;
        }
        if (ch.j0(guildId)) {
            GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar2 = this.mGuildInfoRootView;
            if (guildFeedJoinChannelGuideBar2 != null) {
                guildFeedJoinChannelGuideBar2.setVisibility(0);
                return;
            }
            return;
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        boolean z18 = true;
        if (guildFeedGalleryInitBean != null && guildFeedGalleryInitBean.getBusinessType() == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
            if (guildFeedGalleryInitBean2 != null && guildFeedGalleryInitBean2.getBusinessType() == 15) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.initBean;
                if (guildFeedGalleryInitBean3 == null || guildFeedGalleryInitBean3.getBusinessType() != 14) {
                    z18 = false;
                }
                if (!z18) {
                    GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar3 = this.mGuildInfoRootView;
                    if (guildFeedJoinChannelGuideBar3 != null) {
                        guildFeedJoinChannelGuideBar3.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
        }
        GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar4 = this.mGuildInfoRootView;
        if (guildFeedJoinChannelGuideBar4 != null) {
            guildFeedJoinChannelGuideBar4.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void g(@Nullable String action, @Nullable Object data) {
        if (Intrinsics.areEqual(action, "message_action_fold_desc_content_text")) {
            H(data);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(GuildFeedGalleryShowContentEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void j() {
        super.j();
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.serviceObserver);
        GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar = this.mGuildInfoRootView;
        if (guildFeedJoinChannelGuideBar != null) {
            guildFeedJoinChannelGuideBar.w();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void k(@Nullable jk1.a data, int position) {
        super.k(data, position);
        if (data == null) {
            return;
        }
        if (L(data.getInitBean())) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[onBindData] feed is invalid, position " + position;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryDescPresenter", 1, (String) it.next(), null);
            }
            LinearLayout linearLayout = this.mPresenterRootView;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
                return;
            }
            return;
        }
        z(data);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void l(@Nullable jk1.a data, int position, @Nullable List<Object> payloads) {
        super.l(data, position, payloads);
        if (data == null) {
            return;
        }
        z(data);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void m() {
        super.m();
        ((IGPSService) ch.R0(IGPSService.class)).deleteObserver(this.serviceObserver);
        GuildFeedJoinChannelGuideBar guildFeedJoinChannelGuideBar = this.mGuildInfoRootView;
        if (guildFeedJoinChannelGuideBar != null) {
            guildFeedJoinChannelGuideBar.y();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.wfe) {
                GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
                Intrinsics.checkNotNull(guildFeedGalleryInitBean);
                if (guildFeedGalleryInitBean.getBusinessType() == 7) {
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
                    Intrinsics.checkNotNull(guildFeedGalleryInitBean2);
                    String valueOf = String.valueOf(guildFeedGalleryInitBean2.getFeed().groupCode);
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.initBean;
                    Intrinsics.checkNotNull(guildFeedGalleryInitBean3);
                    ax.M(valueOf, String.valueOf(guildFeedGalleryInitBean3.getFeed().poster.uin));
                } else {
                    N();
                }
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.mAvatarView, "em_sgrp_forum_avatar", "clck", d());
            } else if (id5 == R.id.wkx) {
                GuildFeedGalleryInitBean guildFeedGalleryInitBean4 = this.initBean;
                Intrinsics.checkNotNull(guildFeedGalleryInitBean4);
                String valueOf2 = String.valueOf(guildFeedGalleryInitBean4.getFeed().channelInfo.sign.guildId);
                if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean5 = this.initBean;
                    Intrinsics.checkNotNull(guildFeedGalleryInitBean5);
                    JumpGuildParam jumpGuildParam = new JumpGuildParam(valueOf2, null, guildFeedGalleryInitBean5.getFeed().channelInfo.sign.joinGuildSig, "immersive_feed", "others");
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean6 = this.initBean;
                    Intrinsics.checkNotNull(guildFeedGalleryInitBean6);
                    if (guildFeedGalleryInitBean6.getJoinInfoParam() != null) {
                        GuildFeedGalleryInitBean guildFeedGalleryInitBean7 = this.initBean;
                        Intrinsics.checkNotNull(guildFeedGalleryInitBean7);
                        if (guildFeedGalleryInitBean7.getJoinInfoParam().isValid()) {
                            GuildFeedGalleryInitBean guildFeedGalleryInitBean8 = this.initBean;
                            Intrinsics.checkNotNull(guildFeedGalleryInitBean8);
                            String joinSignature = guildFeedGalleryInitBean8.getJoinInfoParam().getJoinSignature();
                            GuildFeedGalleryInitBean guildFeedGalleryInitBean9 = this.initBean;
                            Intrinsics.checkNotNull(guildFeedGalleryInitBean9);
                            String mainSource = guildFeedGalleryInitBean9.getJoinInfoParam().getMainSource();
                            GuildFeedGalleryInitBean guildFeedGalleryInitBean10 = this.initBean;
                            Intrinsics.checkNotNull(guildFeedGalleryInitBean10);
                            jumpGuildParam = new JumpGuildParam(valueOf2, null, joinSignature, mainSource, guildFeedGalleryInitBean10.getJoinInfoParam().getSubSource());
                        }
                    }
                    Bundle bundle = jumpGuildParam.extras;
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean11 = this.initBean;
                    Intrinsics.checkNotNull(guildFeedGalleryInitBean11);
                    String traceId = guildFeedGalleryInitBean11.getTraceId();
                    if (traceId == null) {
                        traceId = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(traceId, "initBean!!.traceId ?: \"\"");
                    }
                    bundle.putString(JumpGuildParam.EXTRA_KEY_TRACE_ID, traceId);
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "view.context");
                    GuildJumpUtil.n(context, jumpGuildParam);
                    ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.mGuildInfoRootView, "em_sgrp_guide_join_channel", "clck", d());
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(@NotNull View requestView) {
        Intrinsics.checkNotNullParameter(requestView, "requestView");
        super.onPreloadResult(requestView);
        ViewGroup.LayoutParams layoutParams = requestView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.bottomMargin = (int) requestView.getResources().getDimension(R.dimen.ce8);
        requestView.setLayoutParams(layoutParams2);
        this.mPresenterRootView = (LinearLayout) requestView.findViewById(R.id.w9i);
        this.mAvatarView = (GuildUserAvatarViewWithPendant) requestView.findViewById(R.id.wfd);
        this.mNickName = (TextView) requestView.findViewById(R.id.wff);
        this.mTimeTv = (TextView) requestView.findViewById(R.id.wd_);
        this.mFeedContentDescLayout = (GuildFeedGalleryEllipsizeTextViewLayout) requestView.findViewById(R.id.w8j);
        this.mApprovalStatusTag = (QUITagView) requestView.findViewById(R.id.wgd);
        LinearLayout linearLayout = (LinearLayout) requestView.findViewById(R.id.wfe);
        this.mUserInfoLayout = linearLayout;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        GuildFeedGalleryEllipsizeTextViewLayout guildFeedGalleryEllipsizeTextViewLayout = this.mFeedContentDescLayout;
        if (guildFeedGalleryEllipsizeTextViewLayout != null) {
            guildFeedGalleryEllipsizeTextViewLayout.setOnContentClickListener(new c());
        }
        J(requestView);
        I(requestView);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        String str;
        LinearLayout linearLayout;
        int i3;
        if (event instanceof GuildFeedGalleryShowContentEvent) {
            GuildFeedGalleryShowContentEvent guildFeedGalleryShowContentEvent = (GuildFeedGalleryShowContentEvent) event;
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryDescPresenter", 1, "onReceiveEvent[GuildFeedGalleryShowContentEvent], isShow: " + guildFeedGalleryShowContentEvent.getIsShow() + ",feedId: " + guildFeedGalleryShowContentEvent.getFeedId());
            String feedId = guildFeedGalleryShowContentEvent.getFeedId();
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
            if (guildFeedGalleryInitBean != null) {
                str = guildFeedGalleryInitBean.getFeedId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(feedId, str) && (linearLayout = this.mPresenterRootView) != null) {
                if (guildFeedGalleryShowContentEvent.getIsShow()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                linearLayout.setVisibility(i3);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void p(@Nullable com.tencent.mobileqq.guild.feed.manager.f selectInfo) {
        super.p(selectInfo);
        O();
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void r(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.r(rootView);
        RFWLayoutPreLoader e16 = gj1.a.a().e();
        View findViewById = rootView.findViewById(R.id.w9j);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        e16.requestPreloadViewForViewStub((ViewStub) findViewById, this);
    }
}
