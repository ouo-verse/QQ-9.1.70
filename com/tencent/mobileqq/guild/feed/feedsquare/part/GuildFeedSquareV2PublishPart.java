package com.tencent.mobileqq.guild.feed.feedsquare.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.core.util.Supplier;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.event.GuildHomeTabChangeEvent;
import com.tencent.mobileqq.guild.event.GuildJoinSuccessEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedPublishPartEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedDraftHelper;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildPublishV2Layout;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.nativepublish.launcher.compat.FeedPublishEditorLaunchCompat;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u008f\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0002\u0090\u0001B\u001b\u0012\u0006\u0010E\u001a\u000207\u0012\b\b\u0002\u0010G\u001a\u000207\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\u0012\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\n\u0010#\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020%0$j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020%`&H\u0002J\u001c\u0010,\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010-\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0003H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u000203H\u0016J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020706H\u0016J\u0016\u0010;\u001a\u00020\u00052\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001209H\u0016J\u0012\u0010<\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J(\u0010@\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030>\u0018\u00010=j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030>\u0018\u0001`?H\u0016R\u001a\u0010E\u001a\u0002078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0016\u0010G\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010BR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0018\u0010V\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010XR\u0016\u0010]\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010BR\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010PR\u0016\u0010d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010PR\u001e\u0010g\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR$\u0010l\u001a\u0010\u0012\f\u0012\n i*\u0004\u0018\u000107070h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010PR\u0016\u0010p\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010XR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010BR\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u001c\u0010\u0080\u0001\u001a\u00020{8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007fR\u001f\u0010\u0084\u0001\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0081\u0001\u0010}\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareV2PublishPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lxj1/b;", "", "va", "wa", "ga", "", ViewStickEventHelper.IS_SHOW, "za", "U9", "", "", "", "ea", LocaleUtils.L_JAPANESE, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "Aa", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "aa", NodeProps.VISIBLE, "ua", "X9", "ta", "V9", "ma", "currentId", "la", "sa", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedPublishPartEvent;", "event", "ia", "ba", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "Y9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "simpleBaseEvent", "onReceiveEvent", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "sectionInfo", "O5", "Landroidx/lifecycle/LiveData;", "", "C2", "Landroidx/core/util/Supplier;", "initBeanProvider", "x8", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "I", "getScene", "()I", "scene", "e", "curPageType", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "mContainer", tl.h.F, "Ljava/lang/Boolean;", "mIsMember", "i", "Z", "mIsMute", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCanPublish", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "mCurrentSectionInfoData", "D", "Ljava/lang/String;", "mGuildId", "E", "mChannelId", UserInfo.SEX_FEMALE, "mSectionType", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "G", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "mInfoManagerViewModel", "H", "mFeedPageVisible", "mIsTroopGuild", "J", "Landroidx/core/util/Supplier;", "mInitBeanProviderForStartEditor", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "K", "Landroidx/lifecycle/MutableLiveData;", "mDisplayHeight", "L", "isAniming", "M", "mPublishDefaultText", "", "N", "Ljava/lang/CharSequence;", "mDraftText", "P", "mDraftMediaSize", "Lkotlinx/coroutines/Job;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlinx/coroutines/Job;", "draftJob", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildPublishV2Layout;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Lazy;", "da", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildPublishV2Layout;", "mEditLayout", ExifInterface.LATITUDE_SOUTH, "ca", "()Landroid/os/Bundle;", "launchParams", "Lcom/tencent/mobileqq/guild/feed/api/impl/h;", "T", "Lcom/tencent/mobileqq/guild/feed/api/impl/h;", "backToThirdAppHelper", "Landroid/view/View$OnClickListener;", "U", "Landroid/view/View$OnClickListener;", "editLayoutOnClick", "<init>", "(II)V", "V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareV2PublishPart extends Part implements SimpleEventReceiver<SimpleBaseEvent>, xj1.b {
    private static int W = ViewUtils.dpToPx(10);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.data.l mCurrentSectionInfoData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mGuildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String mChannelId;

    /* renamed from: F, reason: from kotlin metadata */
    private int mSectionType;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.viewmodel.k mInfoManagerViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mFeedPageVisible;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsTroopGuild;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Supplier<GuildFeedBaseInitBean> mInitBeanProviderForStartEditor;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> mDisplayHeight;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isAniming;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String mPublishDefaultText;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private CharSequence mDraftText;

    /* renamed from: P, reason: from kotlin metadata */
    private int mDraftMediaSize;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Job draftJob;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy mEditLayout;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy launchParams;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.api.impl.h backToThirdAppHelper;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final View.OnClickListener editLayoutOnClick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int scene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int curPageType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean mIsMember;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMute;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mCanPublish;

    public /* synthetic */ GuildFeedSquareV2PublishPart(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i17 & 2) != 0 ? 1 : i16);
    }

    private final void Aa(GuildFeedBaseInitBean initBean) {
        HashMap<String, Serializable> Y9 = Y9();
        em1.a aVar = em1.a.f396585a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("launch_request_id", Integer.valueOf(getContext().hashCode())), TuplesKt.to(com.tencent.mobileqq.guild.feed.b.f218115a, initBean), TuplesKt.to(JumpGuildParam.KEY_JOIN_INFO_PARAM, aa()), TuplesKt.to("dt_report_page_param", Y9));
        FeedPublishEditorLaunchCompat feedPublishEditorLaunchCompat = FeedPublishEditorLaunchCompat.f222113a;
        aVar.h(context, 1, bundleOf, feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.e(feedPublishEditorLaunchCompat.d(this.mCurrentSectionInfoData), feedPublishEditorLaunchCompat.f("publish new feed")), feedPublishEditorLaunchCompat.c()));
    }

    private final void U9() {
        if1.a.b(da(), "em_sgrp_forum_editor", null, null, ExposurePolicy.REPORT_NONE, ClickPolicy.REPORT_NONE, null, null, null, 230, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9() {
        if (ca().getBoolean(JumpGuildParam.EXTRA_NEED_OPEN_PUBLISHER, false)) {
            da().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.q
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedSquareV2PublishPart.W9(GuildFeedSquareV2PublishPart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(GuildFeedSquareV2PublishPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.da().callOnClick()) {
            this$0.ca().remove(JumpGuildParam.EXTRA_NEED_OPEN_PUBLISHER);
        }
    }

    private final void X9() {
        Job job = this.draftJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.draftJob = null;
        this.mDraftText = "";
        this.mDraftMediaSize = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final HashMap<String, Serializable> Y9() {
        Map<String, Object> map;
        HashMap<String, Serializable> hashMap = new HashMap<>();
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null && (map = pageInfo.pageParams) != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Serializable) {
                    String key = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "it.key");
                    hashMap.put(key, value);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(GuildFeedSquareV2PublishPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick(this$0.da())) {
            if (this$0.mCanPublish) {
                this$0.ja();
            } else if (this$0.mIsTroopGuild) {
                av avVar = av.f223852a;
                Activity activity = this$0.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                com.tencent.mobileqq.guild.feed.viewmodel.k kVar = this$0.mInfoManagerViewModel;
                Intrinsics.checkNotNull(kVar);
                com.tencent.mobileqq.guild.util.qqui.g.f(-1, avVar.d(activity, kVar));
            } else {
                com.tencent.mobileqq.guild.feed.feedsquare.utils.j jVar = com.tencent.mobileqq.guild.feed.feedsquare.utils.j.f219338a;
                Activity activity2 = this$0.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                com.tencent.mobileqq.guild.feed.viewmodel.k kVar2 = this$0.mInfoManagerViewModel;
                Intrinsics.checkNotNull(kVar2);
                com.tencent.mobileqq.guild.util.qqui.g.f(-1, jVar.d(activity2, kVar2));
            }
            VideoReport.reportEvent("clck", this$0.da(), this$0.ea());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final JumpGuildParam.JoinInfoParam aa() {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        Bundle b16 = com.tencent.mobileqq.guild.feed.part.a.b(this);
        if (b16 != null) {
            joinInfoParam = (JumpGuildParam.JoinInfoParam) b16.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        } else {
            joinInfoParam = null;
        }
        if (joinInfoParam == null) {
            return new JumpGuildParam.JoinInfoParam();
        }
        return joinInfoParam;
    }

    private final GuildFeedBaseInitBean ba() {
        Supplier<GuildFeedBaseInitBean> supplier = this.mInitBeanProviderForStartEditor;
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    private final Bundle ca() {
        return (Bundle) this.launchParams.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildPublishV2Layout da() {
        return (GuildPublishV2Layout) this.mEditLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> ea() {
        short s16;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[3];
        int i3 = 0;
        pairArr[0] = TuplesKt.to("sgrp_user_type", com.tencent.mobileqq.guild.feed.report.f.j(this.mGuildId));
        if (this.mCanPublish) {
            s16 = 1;
        } else {
            s16 = 2;
        }
        pairArr[1] = TuplesKt.to("sgrp_btn_state", Short.valueOf(s16));
        if (!TextUtils.isEmpty(this.mDraftText) || this.mDraftMediaSize > 0) {
            i3 = 1;
        }
        pairArr[2] = TuplesKt.to("sgrp_forum_editor_type", Integer.valueOf(i3));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final void ga() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildFeedSquareV2PublishPart.ha(GuildFeedSquareV2PublishPart.this, valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(GuildFeedSquareV2PublishPart this$0, ValueAnimator valueAnimator) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        FrameLayout frameLayout = this$0.mContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout = null;
        }
        frameLayout.setAlpha(floatValue);
        if (floatValue == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            FrameLayout frameLayout3 = this$0.mContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            } else {
                frameLayout2 = frameLayout3;
            }
            frameLayout2.setVisibility(8);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildFeedSquareV2PublishPart", 4, "[setViewUI] valueAnimator progress = " + floatValue);
        }
    }

    private final void ia(GuildFeedPublishPartEvent event) {
        if (event != null && !TextUtils.isEmpty(event.getChannelId()) && Intrinsics.areEqual(event.getChannelId(), this.mChannelId)) {
            hj1.b.b("GuildFeedSquareV2PublishPart", "handFeedPublishPartEvent: mute[" + this.mIsMute + "]  isShow = " + event.isShowPublishIcon());
            za(event.isShowPublishIcon());
        }
    }

    private final void ja() {
        Context context = getContext();
        GuildFeedBaseInitBean ba5 = ba();
        if (context != null && ba5 != null) {
            Aa(ba5);
            return;
        }
        QLog.e("GuildFeedSquareV2PublishPart", 1, "[handlePublishLayoutClick]: bean=" + ba5 + " or context is null");
    }

    private final void la(String currentId) {
        if (Intrinsics.areEqual(currentId, this.mChannelId) || Intrinsics.areEqual(currentId, this.mGuildId)) {
            za(true);
        }
    }

    private final void ma() {
        hj1.b.b("GuildFeedSquareV2PublishPart", "initInfoViewModel mGuildId =  " + this.mGuildId + ", mChannelId=" + this.mChannelId + ", mSectionType=" + this.mSectionType);
        if (this.mInfoManagerViewModel == null) {
            this.mInfoManagerViewModel = (com.tencent.mobileqq.guild.feed.viewmodel.k) getViewModel(com.tencent.mobileqq.guild.feed.viewmodel.k.class);
        }
        if (sa() && !this.mIsTroopGuild) {
            com.tencent.mobileqq.guild.feed.viewmodel.k kVar = this.mInfoManagerViewModel;
            Intrinsics.checkNotNull(kVar);
            kVar.X1(this.mGuildId);
        } else {
            com.tencent.mobileqq.guild.feed.viewmodel.k kVar2 = this.mInfoManagerViewModel;
            Intrinsics.checkNotNull(kVar2);
            kVar2.Z1(this.mGuildId, this.mChannelId);
        }
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar3 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar3);
        kVar3.T1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedSquareV2PublishPart.qa(GuildFeedSquareV2PublishPart.this, (Long) obj);
            }
        });
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar4 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar4);
        kVar4.L1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedSquareV2PublishPart.ra(GuildFeedSquareV2PublishPart.this, (Long) obj);
            }
        });
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar5 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar5);
        kVar5.U1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedSquareV2PublishPart.na(GuildFeedSquareV2PublishPart.this, (Boolean) obj);
            }
        });
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar6 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar6);
        kVar6.O1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedSquareV2PublishPart.oa(GuildFeedSquareV2PublishPart.this, (Boolean) obj);
            }
        });
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar7 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar7);
        MutableLiveData<Boolean> Q1 = kVar7.Q1();
        if (Q1 != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareV2PublishPart$initInfoViewModel$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    com.tencent.mobileqq.guild.feed.viewmodel.k kVar8;
                    Boolean bool2;
                    QLog.d("GuildFeedSquareV2PublishPart", 4, "[isMemberStateChange] = " + bool);
                    kVar8 = GuildFeedSquareV2PublishPart.this.mInfoManagerViewModel;
                    Intrinsics.checkNotNull(kVar8);
                    boolean P1 = kVar8.P1();
                    bool2 = GuildFeedSquareV2PublishPart.this.mIsMember;
                    if (Intrinsics.areEqual(bool2, Boolean.valueOf(P1))) {
                        return;
                    }
                    GuildFeedSquareV2PublishPart.this.mIsMember = Boolean.valueOf(P1);
                    GuildFeedSquareV2PublishPart.this.za(true);
                }
            };
            Q1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedSquareV2PublishPart.pa(Function1.this, obj);
                }
            });
        }
        GuildInfoManager.q().R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(GuildFeedSquareV2PublishPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hj1.b.b("GuildFeedSquareV2PublishPart", "observe getsRestrictPostLiveData = " + bool);
        this$0.va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(GuildFeedSquareV2PublishPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(GuildFeedSquareV2PublishPart this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(GuildFeedSquareV2PublishPart this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.va();
    }

    private final boolean sa() {
        int i3 = this.mSectionType;
        if (i3 != 2 && i3 != 4 && i3 != 5) {
            return false;
        }
        return true;
    }

    private final void ta() {
        if (this.draftJob == null) {
            hj1.b.b("GuildFeedSquareV2PublishPart", "[observeFeedDraft] init mGuildId=" + this.mGuildId);
            this.draftJob = GuildFeedDraftHelper.d(GuildFeedDraftHelper.f219277a, com.tencent.mobileqq.guild.feed.part.a.d(this), this.mGuildId, this.mChannelId, null, 0, new Function2<CharSequence, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareV2PublishPart$observeFeedDraft$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                private static final void a(GuildFeedSquareV2PublishPart guildFeedSquareV2PublishPart, CharSequence charSequence, int i3) {
                    CharSequence charSequence2;
                    int i16;
                    GuildPublishV2Layout da5;
                    Map ea5;
                    guildFeedSquareV2PublishPart.mDraftText = charSequence;
                    guildFeedSquareV2PublishPart.mDraftMediaSize = i3;
                    guildFeedSquareV2PublishPart.V9();
                    guildFeedSquareV2PublishPart.za(true);
                    charSequence2 = guildFeedSquareV2PublishPart.mDraftText;
                    i16 = guildFeedSquareV2PublishPart.mDraftMediaSize;
                    hj1.b.b("GuildFeedSquareV2PublishPart", "[feedDraftFlow] mDraftText=" + ((Object) charSequence2) + ", mDraftMediaSize=" + i16);
                    da5 = guildFeedSquareV2PublishPart.da();
                    ea5 = guildFeedSquareV2PublishPart.ea();
                    VideoReport.reportEvent("imp", da5, ea5);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num) {
                    invoke(charSequence, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull CharSequence draft, int i3) {
                    CharSequence charSequence;
                    int i16;
                    Intrinsics.checkNotNullParameter(draft, "draft");
                    charSequence = GuildFeedSquareV2PublishPart.this.mDraftText;
                    if (Intrinsics.areEqual(draft, charSequence)) {
                        i16 = GuildFeedSquareV2PublishPart.this.mDraftMediaSize;
                        if (i3 == i16) {
                            return;
                        }
                    }
                    a(GuildFeedSquareV2PublishPart.this, draft, i3);
                }
            }, 24, null);
        }
    }

    private final void ua(boolean visible) {
        this.mFeedPageVisible = visible;
        wa();
    }

    private final void va() {
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar);
        boolean b26 = kVar.b2();
        if (this.mIsMute != b26) {
            this.mIsMute = b26;
            za(true);
        }
    }

    private final void wa() {
        boolean z16;
        Boolean bool = this.mIsMember;
        Boolean bool2 = Boolean.TRUE;
        boolean areEqual = Intrinsics.areEqual(bool, bool2);
        boolean z17 = this.mIsMute;
        boolean z18 = this.mFeedPageVisible;
        FrameLayout frameLayout = this.mContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout = null;
        }
        hj1.b.b("GuildFeedSquareV2PublishPart", "setViewUI isMember = " + areEqual + " mIsMute = " + z17 + " mFeedPageVisible = " + z18 + " mContainer.measuredHeight = " + frameLayout.getMeasuredHeight());
        boolean areEqual2 = Intrinsics.areEqual(this.mIsMember, bool2);
        boolean z19 = true;
        if (areEqual2 && this.mFeedPageVisible) {
            this.isAniming = false;
            FrameLayout frameLayout3 = this.mContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                frameLayout3 = null;
            }
            if (frameLayout3.getVisibility() != 0) {
                z19 = false;
            }
            if (!z19) {
                FrameLayout frameLayout4 = this.mContainer;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    frameLayout4 = null;
                }
                frameLayout4.setAlpha(1.0f);
                FrameLayout frameLayout5 = this.mContainer;
                if (frameLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    frameLayout5 = null;
                }
                frameLayout5.setVisibility(0);
                FrameLayout frameLayout6 = this.mContainer;
                if (frameLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                } else {
                    frameLayout2 = frameLayout6;
                }
                frameLayout2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedSquareV2PublishPart.xa(GuildFeedSquareV2PublishPart.this);
                    }
                });
                return;
            }
            return;
        }
        FrameLayout frameLayout7 = this.mContainer;
        if (frameLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        } else {
            frameLayout2 = frameLayout7;
        }
        if (frameLayout2.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !this.isAniming) {
            this.isAniming = true;
            ga();
            this.mDisplayHeight.setValue(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(GuildFeedSquareV2PublishPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MutableLiveData<Integer> mutableLiveData = this$0.mDisplayHeight;
        FrameLayout frameLayout = this$0.mContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout = null;
        }
        mutableLiveData.setValue(Integer.valueOf(frameLayout.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void za(boolean isShow) {
        if (Intrinsics.areEqual(this.mIsMember, Boolean.FALSE)) {
            wa();
            return;
        }
        boolean z16 = this.mIsMute;
        this.mCanPublish = !z16;
        if (z16) {
            GuildPublishV2Layout da5 = da();
            String string = getContext().getString(R.string.f1522719y);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026_new_feed_not_permission)");
            GuildPublishV2Layout.e(da5, string, getContext().getResources().getColor(R.color.qui_common_text_secondary_light), 0, 4, null);
            da().setBackgroundResource(R.drawable.guild_input_view_background_normal);
        } else {
            if (TextUtils.isEmpty(this.mDraftText)) {
                da().d(this.mPublishDefaultText, getContext().getResources().getColor(R.color.qui_common_text_secondary), this.mDraftMediaSize);
            } else {
                da().d(this.mDraftText, getContext().getResources().getColor(R.color.qui_common_text_primary), this.mDraftMediaSize);
            }
            da().setBackgroundResource(R.drawable.guild_input_view_background);
        }
        hj1.b.b("GuildFeedSquareV2PublishPart", "showPublishView channelId = " + this.mChannelId + " mCanPublish = " + this.mCanPublish + ", isShow = " + isShow + " isMember = " + Intrinsics.areEqual(this.mIsMember, Boolean.TRUE) + " mIsMute = " + this.mIsMute);
        wa();
    }

    @Override // xj1.b
    @NotNull
    public LiveData<Integer> C2() {
        return this.mDisplayHeight;
    }

    @Override // xj1.b
    public void O5(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.l sectionInfo) {
        boolean z16;
        String string;
        String str;
        Intrinsics.checkNotNullParameter(sectionInfo, "sectionInfo");
        this.mCurrentSectionInfoData = sectionInfo;
        if (!Intrinsics.areEqual(this.mGuildId, sectionInfo.getSectionInfo().getGuildId())) {
            this.mGuildId = sectionInfo.getSectionInfo().getGuildId();
            X9();
        }
        this.mChannelId = sectionInfo.getSectionInfo().getChannelId();
        this.mSectionType = sectionInfo.getSectionInfo().getType();
        this.mIsTroopGuild = ch.L(this.mGuildId).isGroupGuild();
        hj1.b.b("GuildFeedSquareV2PublishPart", "handleGuildFeedSquareTabSwitch mGuildId =  " + this.mGuildId + ", mChannelId=" + this.mChannelId + ", mSectionType=" + this.mSectionType);
        IGProChannelInfo B = ch.B(this.mChannelId);
        if (B != null && B.isHiddenPostChannel()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.mIsTroopGuild) {
            Context context = getContext();
            Object[] objArr = new Object[1];
            if (B != null) {
                str = B.getChannelName();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            string = context.getString(R.string.f1522819z, objArr);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026e ?: \"\"\n                )");
        } else {
            string = getContext().getString(R.string.f1522619x);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026sh_new_feed\n            )");
        }
        this.mPublishDefaultText = string;
        ma();
        ta();
        za(true);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Nullable
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildJoinSuccessEvent.class, GuildFeedPublishPartEvent.class, GuildHomeTabChangeEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f165506wd1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026uild_feed_publish_layout)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.mContainer = frameLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout = null;
        }
        frameLayout.setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
        FrameLayout frameLayout3 = this.mContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout3 = null;
        }
        View view = new View(getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.dpToPx((float) 0.5d)));
        view.setBackgroundResource(R.drawable.qui_divider_border_standard);
        frameLayout3.addView(view);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.dpToPx(40));
        float f16 = 16;
        layoutParams.leftMargin = ViewUtils.dpToPx(f16);
        layoutParams.rightMargin = ViewUtils.dpToPx(f16);
        layoutParams.topMargin = ViewUtils.dpToPx(10);
        layoutParams.bottomMargin = ViewUtils.dpToPx(20);
        FrameLayout frameLayout4 = this.mContainer;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        } else {
            frameLayout2 = frameLayout4;
        }
        frameLayout2.addView(da(), layoutParams);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, xj1.b.class);
        U9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), xj1.b.class);
        Job job = this.draftJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.draftJob = null;
        com.tencent.mobileqq.guild.feed.api.impl.h hVar = this.backToThirdAppHelper;
        if (hVar != null) {
            hVar.i();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        JumpGuildParam d16;
        Bundle bundle;
        Bundle bundle2;
        if (activity == null) {
            return;
        }
        Bundle b16 = com.tencent.mobileqq.guild.feed.part.a.b(this);
        Bundle bundle3 = null;
        if (b16 != null && (d16 = com.tencent.mobileqq.guild.base.extension.c.d(b16)) != null && (bundle = d16.extras) != null && (bundle2 = bundle.getBundle(JumpGuildParam.EXTRA_BACK_TO_THIRD_APP)) != null && !bundle2.isEmpty()) {
            bundle3 = bundle2;
        }
        if (bundle3 != null) {
            com.tencent.mobileqq.guild.feed.api.impl.h hVar = this.backToThirdAppHelper;
            boolean z16 = false;
            if (hVar != null && hVar.getHasShowDialog()) {
                z16 = true;
            }
            if (!z16) {
                com.tencent.mobileqq.guild.feed.api.impl.h hVar2 = new com.tencent.mobileqq.guild.feed.api.impl.h();
                this.backToThirdAppHelper = hVar2;
                Intrinsics.checkNotNull(hVar2);
                hVar2.j(this.mGuildId, activity, bundle3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(simpleBaseEvent, "simpleBaseEvent");
        if (simpleBaseEvent instanceof GuildJoinSuccessEvent) {
            la(((GuildJoinSuccessEvent) simpleBaseEvent).getCurrentId());
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedPublishPartEvent) {
            ia((GuildFeedPublishPartEvent) simpleBaseEvent);
            return;
        }
        if ((simpleBaseEvent instanceof GuildHomeTabChangeEvent) && simpleBaseEvent.mHashCode == getContext().hashCode()) {
            GuildHomeTabChangeEvent guildHomeTabChangeEvent = (GuildHomeTabChangeEvent) simpleBaseEvent;
            boolean z16 = true;
            if (guildHomeTabChangeEvent.getCurrentTabType() != 1 && guildHomeTabChangeEvent.getCurrentTabType() != 99) {
                z16 = false;
            }
            ua(z16);
        }
    }

    @Override // xj1.b
    public void x8(@NotNull Supplier<GuildFeedBaseInitBean> initBeanProvider) {
        Intrinsics.checkNotNullParameter(initBeanProvider, "initBeanProvider");
        this.mInitBeanProviderForStartEditor = initBeanProvider;
    }

    public GuildFeedSquareV2PublishPart(int i3, int i16) {
        Lazy lazy;
        Lazy lazy2;
        this.scene = i3;
        this.curPageType = i16;
        this.mCanPublish = true;
        this.mGuildId = "";
        this.mChannelId = "";
        this.mFeedPageVisible = true;
        this.mDisplayHeight = new MutableLiveData<>(0);
        this.mPublishDefaultText = "";
        this.mDraftText = "";
        this.mDraftMediaSize = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildPublishV2Layout>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareV2PublishPart$mEditLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildPublishV2Layout invoke() {
                int i17;
                int i18;
                View.OnClickListener onClickListener;
                Context context = GuildFeedSquareV2PublishPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GuildPublishV2Layout guildPublishV2Layout = new GuildPublishV2Layout(context, null, 0, 6, null);
                GuildFeedSquareV2PublishPart guildFeedSquareV2PublishPart = GuildFeedSquareV2PublishPart.this;
                i17 = GuildFeedSquareV2PublishPart.W;
                i18 = GuildFeedSquareV2PublishPart.W;
                guildPublishV2Layout.setPadding(i17, 0, i18, 0);
                guildPublishV2Layout.setGravity(16);
                onClickListener = guildFeedSquareV2PublishPart.editLayoutOnClick;
                guildPublishV2Layout.setOnClickListener(onClickListener);
                return guildPublishV2Layout;
            }
        });
        this.mEditLayout = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Bundle>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareV2PublishPart$launchParams$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Bundle invoke() {
                JumpGuildParam jumpGuildParam;
                Bundle b16 = com.tencent.mobileqq.guild.feed.part.a.b(GuildFeedSquareV2PublishPart.this);
                Bundle bundle = (b16 == null || (jumpGuildParam = (JumpGuildParam) b16.getParcelable(JumpGuildParam.KEY_JUMP_GUILD_PARAM)) == null) ? null : jumpGuildParam.extras;
                return bundle == null ? new Bundle() : bundle;
            }
        });
        this.launchParams = lazy2;
        this.editLayoutOnClick = new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildFeedSquareV2PublishPart.Z9(GuildFeedSquareV2PublishPart.this, view);
            }
        };
    }
}
