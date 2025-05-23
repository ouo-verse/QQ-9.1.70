package com.tencent.mobileqq.guild.feed.gallery.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.event.GuildFeedChannelTopEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryCommonEleVisibleEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryImmersiveEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryItemTypeEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryRateEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGallerySeekbarShowEvent;
import com.tencent.mobileqq.guild.feed.gallery.part.f;
import com.tencent.mobileqq.guild.feed.gallery.vm.GuildFeedGalleryViewModel;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryGestureView;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryLoadingFooter;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryPageContentView;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildGalleryMixMediaItemView;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QFixToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelTopInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0002\u0095\u0001\u0018\u0000 \u009b\u00012\u00020\u0001:\u0002\u009c\u0001B\t\u00a2\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0016\u0010\u0015\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0012H\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0006H\u0002J\b\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\u0006H\u0002J\b\u00101\u001a\u00020\u0006H\u0002J\b\u00102\u001a\u00020\u0002H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u000203H\u0016J\u0012\u00108\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u001c\u0010=\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010>\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u000109H\u0016J$\u0010B\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0@0?j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0@`AH\u0016J\u0012\u0010E\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010CH\u0016J\u001a\u0010G\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001e\u0010H\u001a\u0004\u0018\u00010\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010I\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010J\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u000109H\u0016R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010mR\u0016\u0010s\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010xR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010\u007f\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0086\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0019\u0010\u0088\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0085\u0001R\u0018\u0010\u008a\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010rR\u0018\u0010\u008c\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010rR\u001a\u0010\u0090\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001c\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u00a8\u0006\u009d\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryListPart;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "", "feedId", "", "isTop", "", "Ra", "Lgh1/b;", "exposeHelper", "La", "", "args", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$h;", "ia", "va", "showGuide", "Ta", "", "Ljk1/a;", "list", "Ia", "qa", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", LocaleUtils.L_JAPANESE, "pa", "initPageBean", "Sa", "Ba", "Ha", "na", "initViewModel", "ra", "Lkk1/e;", "ma", "Llk1/a;", "la", "Oa", "Na", "", "stringId", "Pa", "Ga", "ta", "ua", "Ja", "Ma", "Qa", "Ea", "ga", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "onReceiveEvent", "action", "handleBroadcastMessage", "getMessage", "onPartResume", "onPartPause", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryLoadingFooter;", "d", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryLoadingFooter;", "refreshFooter", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "e", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryPageContentView;", "f", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryPageContentView;", "pageContentView", "Lfk1/b;", tl.h.F, "Lfk1/b;", "galleryAdapter", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryGestureView;", "i", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryGestureView;", "galleryGestureView", "Lcom/tencent/richframework/widget/drag/RFWDragLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/richframework/widget/drag/RFWDragLayout;", "dragFrameLayout", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "llRate", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "rateText", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mFirstImg", UserInfo.SEX_FEMALE, "mSecondImg", "G", "I", "beforeLoadMoreIndex", "H", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "galleryInitBean", "Lcom/tencent/mobileqq/guild/feed/gallery/vm/GuildFeedGalleryViewModel;", "Lcom/tencent/mobileqq/guild/feed/gallery/vm/GuildFeedGalleryViewModel;", "listViewModel", "J", "Lgh1/b;", "Llk1/d;", "K", "Llk1/d;", "verticalReportScroller", "Llk1/b;", "L", "Llk1/b;", "verticalSelectedDetector", "M", "Z", "noMoreData", "N", "isShowGuide", "P", "curSelectedPos", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "itemType", "Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Runnable;", "requestRecommendDataTask", "Landroid/animation/ValueAnimator;", ExifInterface.LATITUDE_SOUTH, "Landroid/animation/ValueAnimator;", "mVideoIconAnimator", "com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryListPart$f", "T", "Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryListPart$f;", "serviceObserver", "<init>", "()V", "U", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryListPart extends com.tencent.mobileqq.guild.feed.part.d {

    @NotNull
    private static final HashSet<String> V;

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout llRate;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView rateText;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mFirstImg;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mSecondImg;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryInitBean galleryInitBean;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryViewModel listViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private gh1.b exposeHelper;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private lk1.d verticalReportScroller;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean noMoreData;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isShowGuide;

    /* renamed from: P, reason: from kotlin metadata */
    private int curSelectedPos;

    /* renamed from: Q, reason: from kotlin metadata */
    private int itemType;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mVideoIconAnimator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildFeedGalleryLoadingFooter refreshFooter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildFeedGalleryPageContentView pageContentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private fk1.b galleryAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildFeedGalleryGestureView galleryGestureView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RFWDragLayout dragFrameLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private int beforeLoadMoreIndex = -1;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private lk1.b verticalSelectedDetector = new lk1.b();

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private Runnable requestRecommendDataTask = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.l
        @Override // java.lang.Runnable
        public final void run() {
            GuildFeedGalleryListPart.Ka(GuildFeedGalleryListPart.this);
        }
    };

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final f serviceObserver = new f();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryListPart$c", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryGestureView$b;", "Landroid/view/View;", "view", "", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements GuildFeedGalleryGestureView.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryGestureView.b
        public void a(@Nullable View view) {
            if (GuildFeedGalleryListPart.this.Ga()) {
                GuildFeedGalleryListPart.this.Ma();
                GuildFeedGalleryListPart.this.Ja();
                mk1.e eVar = mk1.e.f416895a;
                Context context = GuildFeedGalleryListPart.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                eVar.l(50L, context);
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryGestureView.b
        public void b(@Nullable View view) {
            if (GuildFeedGalleryListPart.this.Ga()) {
                GuildFeedGalleryListPart.this.Qa();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryListPart$d", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/q;", "", "onLoading", "a", "onCancel", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements com.tencent.mobileqq.guild.feed.gallery.widget.q {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.feed.gallery.widget.q
        public void a() {
            if (GuildFeedGalleryListPart.this.isShowGuide) {
                GuildFeedGalleryListPart.this.na();
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.gallery.widget.q
        public void onCancel() {
            GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = GuildFeedGalleryListPart.this.pageContentView;
            if (guildFeedGalleryPageContentView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
                guildFeedGalleryPageContentView = null;
            }
            guildFeedGalleryPageContentView.setPageMaskVisible(8);
        }

        @Override // com.tencent.mobileqq.guild.feed.gallery.widget.q
        public void onLoading() {
            GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = GuildFeedGalleryListPart.this.pageContentView;
            if (guildFeedGalleryPageContentView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
                guildFeedGalleryPageContentView = null;
            }
            guildFeedGalleryPageContentView.setPageMaskVisible(0);
            GuildFeedGalleryListPart.this.Ha();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryListPart$e", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "state", "onPageScrollStateChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends ViewPager2.OnPageChangeCallback {
        e() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            boolean z16;
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGallerySeekbarShowEvent(z16));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            boolean z16;
            boolean z17;
            Object orNull;
            boolean z18;
            Object orNull2;
            GuildFeedGalleryInitBean initBean;
            String feedId;
            GuildFeedGalleryViewModel guildFeedGalleryViewModel;
            super.onPageSelected(position);
            kk1.e ma5 = GuildFeedGalleryListPart.this.ma();
            if (ma5 != null) {
                ma5.j(position);
            }
            boolean z19 = true;
            Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[onPageSelected] position " + position);
            GuildFeedGalleryListPart.this.curSelectedPos = position;
            RFWDragLayout rFWDragLayout = GuildFeedGalleryListPart.this.dragFrameLayout;
            fk1.b bVar = null;
            if (rFWDragLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dragFrameLayout");
                rFWDragLayout = null;
            }
            if (position == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            rFWDragLayout.setFeatureEnable(z16);
            RFWDragLayout rFWDragLayout2 = GuildFeedGalleryListPart.this.dragFrameLayout;
            if (rFWDragLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dragFrameLayout");
                rFWDragLayout2 = null;
            }
            if (position == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            rFWDragLayout2.setEnableDragVertical(z17);
            GuildFeedGalleryListPart guildFeedGalleryListPart = GuildFeedGalleryListPart.this;
            fk1.b bVar2 = guildFeedGalleryListPart.galleryAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                bVar2 = null;
            }
            List<jk1.a> dataList = bVar2.getDataList();
            Intrinsics.checkNotNullExpressionValue(dataList, "galleryAdapter.dataList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(dataList, position);
            guildFeedGalleryListPart.broadcastMessage("message_on_page_select", orNull);
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = GuildFeedGalleryListPart.this.galleryInitBean;
            if (guildFeedGalleryInitBean != null && guildFeedGalleryInitBean.getBusinessType() == 7) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = GuildFeedGalleryListPart.this.galleryInitBean;
                if (guildFeedGalleryInitBean2 == null || guildFeedGalleryInitBean2.getImmersiveSource() != 22) {
                    z19 = false;
                }
                if (!z19) {
                    fk1.b bVar3 = GuildFeedGalleryListPart.this.galleryAdapter;
                    if (bVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                    } else {
                        bVar = bVar3;
                    }
                    List<jk1.a> dataList2 = bVar.getDataList();
                    Intrinsics.checkNotNullExpressionValue(dataList2, "galleryAdapter.dataList");
                    orNull2 = CollectionsKt___CollectionsKt.getOrNull(dataList2, position);
                    jk1.a aVar = (jk1.a) orNull2;
                    if (aVar != null && (initBean = aVar.getInitBean()) != null && (feedId = initBean.getFeedId()) != null && (guildFeedGalleryViewModel = GuildFeedGalleryListPart.this.listViewModel) != null) {
                        guildFeedGalleryViewModel.q2(feedId);
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryListPart$f", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onRemoveGuild", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f extends GPServiceObserver {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            if (GuildFeedGalleryListPart.this.galleryAdapter != null && info != null) {
                fk1.b bVar = GuildFeedGalleryListPart.this.galleryAdapter;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                    bVar = null;
                }
                bVar.j0("message_action_on_guild_member_state_changed", TuplesKt.to(info.getGuildID(), Boolean.TRUE));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (GuildFeedGalleryListPart.this.galleryAdapter != null) {
                fk1.b bVar = GuildFeedGalleryListPart.this.galleryAdapter;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                    bVar = null;
                }
                bVar.j0("message_action_on_guild_member_state_changed", TuplesKt.to(guildId, Boolean.FALSE));
            }
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("message_comment_panel_start_open_even");
        hashSet.add("message_comment_panel_height_change_even");
        hashSet.add("message_comment_panel_close_event");
        hashSet.add("message_on_do_execute_like");
        hashSet.add("message_on_comment_data_change");
        V = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ba() {
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        GuildFeedGalleryLoadingFooter guildFeedGalleryLoadingFooter = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableRefresh(false).setEnableLoadMore(true).setEnableOverScrollBounce(true).setEnableOverScrollDrag(true).setEnableAutoLoadMore(false);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.j
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener
            public final void onLoadMore(IRefreshLayout iRefreshLayout) {
                GuildFeedGalleryListPart.Ca(GuildFeedGalleryListPart.this, iRefreshLayout);
            }
        });
        GuildFeedGalleryLoadingFooter guildFeedGalleryLoadingFooter2 = this.refreshFooter;
        if (guildFeedGalleryLoadingFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshFooter");
            guildFeedGalleryLoadingFooter2 = null;
        }
        guildFeedGalleryLoadingFooter2.setOnLoadMoreFinishListener(new OnLoadMoreListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.k
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener
            public final void onLoadMore(IRefreshLayout iRefreshLayout) {
                GuildFeedGalleryListPart.Da(GuildFeedGalleryListPart.this, iRefreshLayout);
            }
        });
        GuildFeedGalleryLoadingFooter guildFeedGalleryLoadingFooter3 = this.refreshFooter;
        if (guildFeedGalleryLoadingFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshFooter");
        } else {
            guildFeedGalleryLoadingFooter = guildFeedGalleryLoadingFooter3;
        }
        guildFeedGalleryLoadingFooter.setOnLoadingListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(GuildFeedGalleryListPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[setOnLoadMoreListener] ");
        GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = this$0.pageContentView;
        if (guildFeedGalleryPageContentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
            guildFeedGalleryPageContentView = null;
        }
        this$0.beforeLoadMoreIndex = guildFeedGalleryPageContentView.d();
        GuildFeedGalleryViewModel guildFeedGalleryViewModel = this$0.listViewModel;
        if (guildFeedGalleryViewModel != null) {
            guildFeedGalleryViewModel.loadMore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(GuildFeedGalleryListPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.a d16 = Logger.f235387a.d();
        int i3 = this$0.beforeLoadMoreIndex;
        GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = this$0.pageContentView;
        MutableLiveData<Integer> mutableLiveData = null;
        if (guildFeedGalleryPageContentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
            guildFeedGalleryPageContentView = null;
        }
        d16.d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[refreshFooter.setOnLoadMoreListener] beforeLoadMoreIndex " + i3 + ", current: " + guildFeedGalleryPageContentView.d());
        int i16 = this$0.beforeLoadMoreIndex;
        GuildFeedGalleryPageContentView guildFeedGalleryPageContentView2 = this$0.pageContentView;
        if (guildFeedGalleryPageContentView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
            guildFeedGalleryPageContentView2 = null;
        }
        if (i16 == guildFeedGalleryPageContentView2.d() && !this$0.noMoreData && !this$0.isShowGuide) {
            GuildFeedGalleryPageContentView guildFeedGalleryPageContentView3 = this$0.pageContentView;
            if (guildFeedGalleryPageContentView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
                guildFeedGalleryPageContentView3 = null;
            }
            GuildFeedGalleryPageContentView guildFeedGalleryPageContentView4 = this$0.pageContentView;
            if (guildFeedGalleryPageContentView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
                guildFeedGalleryPageContentView4 = null;
            }
            GuildFeedGalleryPageContentView.setViewPagerCurrentItem$default(guildFeedGalleryPageContentView3, guildFeedGalleryPageContentView4.d() + 1, false, 2, null);
        }
        if (this$0.isShowGuide) {
            this$0.Ta(false);
            if (this$0.noMoreData) {
                GuildFeedGalleryViewModel guildFeedGalleryViewModel = this$0.listViewModel;
                if (guildFeedGalleryViewModel != null) {
                    mutableLiveData = guildFeedGalleryViewModel.f2();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(4);
                }
            } else {
                GuildFeedGalleryViewModel guildFeedGalleryViewModel2 = this$0.listViewModel;
                if (guildFeedGalleryViewModel2 != null) {
                    mutableLiveData = guildFeedGalleryViewModel2.f2();
                }
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(3);
                }
            }
        }
        this$0.beforeLoadMoreIndex = -1;
    }

    private final void Ea() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.8f, 0.2f).setDuration(500L);
        this.mVideoIconAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GuildFeedGalleryListPart.Fa(GuildFeedGalleryListPart.this, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.mVideoIconAnimator;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(-1);
        }
        ValueAnimator valueAnimator2 = this.mVideoIconAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.setRepeatMode(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(GuildFeedGalleryListPart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        if (this$0.mFirstImg == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFirstImg");
        }
        ImageView imageView = this$0.mFirstImg;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFirstImg");
            imageView = null;
        }
        imageView.setAlpha(floatValue);
        if (this$0.mSecondImg == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecondImg");
        }
        ImageView imageView3 = this$0.mSecondImg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecondImg");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setAlpha(1.0f - floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ga() {
        if (1 == this.itemType) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ha() {
        HashMap hashMap = new HashMap();
        hashMap.put("cur_pg", mk1.e.c(ja()));
        hashMap.put("dt_pgid", "pg_sgrp_forum_viewer_feeds");
        hashMap.put("eid", "em_sgrp_feeds_empty_guide");
        VideoReport.reportEvent("dt_imp", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ia(List<jk1.a> list) {
        String joinToString$default;
        boolean z16 = true;
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[notifyLoadSuccess] getFeedData size " + list.size());
        SmartRefreshLayout smartRefreshLayout = null;
        fk1.b bVar = null;
        if (!list.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<jk1.a, CharSequence>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryListPart$notifyLoadSuccess$2$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(@NotNull jk1.a it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return "feedId=" + it.getInitBean().getFeedId();
                    }
                }, 31, null);
                Log.d("Guild_Feed_GAL_GuildFeedGalleryListPart", "[notifyLoadSuccess] new list: " + joinToString$default);
            }
            fk1.b bVar2 = this.galleryAdapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
            } else {
                bVar = bVar2;
            }
            bVar.addAll(list);
            return;
        }
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout2;
        }
        if (smartRefreshLayout.getState() == RefreshState.Loading) {
            GuildFeedGalleryViewModel guildFeedGalleryViewModel = this.listViewModel;
            if (guildFeedGalleryViewModel == null || !guildFeedGalleryViewModel.j2()) {
                z16 = false;
            }
            if (z16) {
                Oa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja() {
        HashMap<String, Object> e16 = mk1.e.e(ja());
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        LinearLayout linearLayout = this.llRate;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRate");
            linearLayout = null;
        }
        iGuildDTReportApi.reportDtEventManual(linearLayout, "em_sgrp_hold_speed_play", "clck", e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(GuildFeedGalleryListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qa();
    }

    private final void La(gh1.b exposeHelper) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild_Feed_GAL_GuildFeedGalleryListPart", "[setExposeHelper] exposeHelper:" + exposeHelper);
        }
        this.exposeHelper = exposeHelper;
        lk1.d dVar = this.verticalReportScroller;
        if (dVar != null) {
            dVar.r(exposeHelper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma() {
        ua();
        LinearLayout linearLayout = this.llRate;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRate");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView2 = this.rateText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rateText");
        } else {
            textView = textView2;
        }
        textView.setText("2x\u5feb\u8fdb\u4e2d");
        ValueAnimator valueAnimator = this.mVideoIconAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryCommonEleVisibleEvent(false));
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryRateEvent(2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na() {
        Pa(R.string.f144180o3);
    }

    private final void Oa() {
        Pa(R.string.f144200o5);
    }

    private final void Pa(int stringId) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.f168076eo3, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.f107206_s)).setText(stringId);
        QFixToast qFixToast = new QFixToast(getContext());
        qFixToast.setDuration(0);
        qFixToast.setGravity(17, 0, 0);
        qFixToast.setView(inflate);
        qFixToast.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qa() {
        ua();
        LinearLayout linearLayout = this.llRate;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRate");
            linearLayout = null;
        }
        if (linearLayout.getVisibility() == 8) {
            return;
        }
        LinearLayout linearLayout3 = this.llRate;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llRate");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.setVisibility(8);
        ValueAnimator valueAnimator = this.mVideoIconAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryCommonEleVisibleEvent(true));
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryRateEvent(1.0f));
    }

    private final void Ra(final String feedId, final boolean isTop) {
        Function0.d(new kotlin.jvm.functions.Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryListPart$updateFeedChannelTopState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object obj;
                GProStFeed feed;
                GProStFeed feed2;
                fk1.b bVar = GuildFeedGalleryListPart.this.galleryAdapter;
                GProChannelTopInfo gProChannelTopInfo = null;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                    bVar = null;
                }
                List<jk1.a> dataList = bVar.getDataList();
                Intrinsics.checkNotNullExpressionValue(dataList, "galleryAdapter.dataList");
                String str = feedId;
                Iterator<T> it = dataList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (Intrinsics.areEqual(((jk1.a) obj).b().idd, str)) {
                            break;
                        }
                    }
                }
                jk1.a aVar = (jk1.a) obj;
                if (aVar != null) {
                    aVar.b().channelTopInfo.isTop = isTop;
                }
                String str2 = feedId;
                GuildFeedGalleryInitBean guildFeedGalleryInitBean = GuildFeedGalleryListPart.this.galleryInitBean;
                if (Intrinsics.areEqual(str2, (guildFeedGalleryInitBean == null || (feed2 = guildFeedGalleryInitBean.getFeed()) == null) ? null : feed2.idd)) {
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = GuildFeedGalleryListPart.this.galleryInitBean;
                    if (guildFeedGalleryInitBean2 != null && (feed = guildFeedGalleryInitBean2.getFeed()) != null) {
                        gProChannelTopInfo = feed.channelTopInfo;
                    }
                    if (gProChannelTopInfo == null) {
                        return;
                    }
                    gProChannelTopInfo.isTop = isTop;
                }
            }
        });
    }

    private final void Sa() {
        String str;
        initPageBean();
        GuildFeedGalleryViewModel guildFeedGalleryViewModel = this.listViewModel;
        if (guildFeedGalleryViewModel != null) {
            guildFeedGalleryViewModel.r2(ja());
            guildFeedGalleryViewModel.p2();
        }
        String tag = getTAG();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.galleryInitBean;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getFeedId();
        } else {
            str = null;
        }
        QLog.d(tag, 1, "[updateInitBean] initBean.feedId=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ta(boolean showGuide) {
        this.isShowGuide = showGuide;
        GuildFeedGalleryLoadingFooter guildFeedGalleryLoadingFooter = null;
        if (showGuide) {
            SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
            if (smartRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout = null;
            }
            smartRefreshLayout.setFooterMaxDragRate(1.5f);
            SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
            if (smartRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout2 = null;
            }
            smartRefreshLayout2.setFooterTriggerRate(0.8f);
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.setFooterHeight(148.0f);
        } else {
            SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
            if (smartRefreshLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout4 = null;
            }
            smartRefreshLayout4.setFooterMaxDragRate(2.5f);
            SmartRefreshLayout smartRefreshLayout5 = this.refreshLayout;
            if (smartRefreshLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout5 = null;
            }
            smartRefreshLayout5.setFooterTriggerRate(1.0f);
            SmartRefreshLayout smartRefreshLayout6 = this.refreshLayout;
            if (smartRefreshLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout6 = null;
            }
            smartRefreshLayout6.setFooterHeight(74.0f);
        }
        GuildFeedGalleryLoadingFooter guildFeedGalleryLoadingFooter2 = this.refreshFooter;
        if (guildFeedGalleryLoadingFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshFooter");
        } else {
            guildFeedGalleryLoadingFooter = guildFeedGalleryLoadingFooter2;
        }
        guildFeedGalleryLoadingFooter.l(showGuide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga() {
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[finishActivityWithoutAnim] ");
        getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.r
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryListPart.ha(GuildFeedGalleryListPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(GuildFeedGalleryListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        Activity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.overridePendingTransition(0, 0);
        }
    }

    private final a.OnCommentMainFeedDataResult ia(Object args) {
        f.SendInputContentExtData sendInputContentExtData;
        if (args instanceof f.SendInputContentExtData) {
            sendInputContentExtData = (f.SendInputContentExtData) args;
        } else {
            sendInputContentExtData = null;
        }
        GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = this.pageContentView;
        if (guildFeedGalleryPageContentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
            guildFeedGalleryPageContentView = null;
        }
        int d16 = guildFeedGalleryPageContentView.d();
        if (d16 >= 0) {
            fk1.b bVar = this.galleryAdapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                bVar = null;
            }
            if (d16 < bVar.getItemCount()) {
                fk1.b bVar2 = this.galleryAdapter;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                    bVar2 = null;
                }
                jk1.a aVar = bVar2.getDataList().get(d16);
                if (sendInputContentExtData != null) {
                    long j3 = aVar.b().channelInfo.sign.guildId;
                    long j16 = aVar.b().channelInfo.sign.channelId;
                    String str = aVar.b().idd;
                    if (!Intrinsics.areEqual(sendInputContentExtData.getGuildId(), String.valueOf(j3)) || !Intrinsics.areEqual(sendInputContentExtData.getChannelId(), String.valueOf(j16)) || !Intrinsics.areEqual(sendInputContentExtData.getFeedId(), str)) {
                        Logger logger = Logger.f235387a;
                        Logger.b bVar3 = new Logger.b();
                        String str2 = "getCommentFeedMainData sendExtData and curItem not match sendExtData:" + sendInputContentExtData + " curGuildId:" + j3 + " curChannelId:" + j16 + " curFeedId:" + str;
                        if (str2 instanceof String) {
                            bVar3.a().add(str2);
                        }
                        Iterator<T> it = bVar3.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, (String) it.next(), null);
                        }
                    }
                }
                mk1.e eVar = mk1.e.f416895a;
                a.OnCommentMainFeedDataResult onCommentMainFeedDataResult = new a.OnCommentMainFeedDataResult(null, 1, null);
                GProStFeed b16 = aVar.b();
                Intrinsics.checkNotNullExpressionValue(b16, "blockData.sourceData");
                return eVar.j(onCommentMainFeedDataResult, b16);
            }
        }
        return new a.OnCommentMainFeedDataResult(null, 1, null);
    }

    private final void initPageBean() {
        GuildFeedBaseInitBean o16 = ax.o(getHostFragment());
        if (o16 instanceof GuildFeedGalleryInitBean) {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = (GuildFeedGalleryInitBean) o16;
            this.galleryInitBean = guildFeedGalleryInitBean;
            mk1.e.f416895a.b(guildFeedGalleryInitBean);
            QLog.d(getTAG(), 1, "getInitBeanSuccess:" + this.galleryInitBean);
        }
    }

    private final void initViewModel() {
        GuildFeedGalleryViewModel guildFeedGalleryViewModel = (GuildFeedGalleryViewModel) getViewModel(GuildFeedGalleryViewModel.class);
        this.listViewModel = guildFeedGalleryViewModel;
        if (guildFeedGalleryViewModel != null) {
            guildFeedGalleryViewModel.r2(ja());
        }
        GuildFeedGalleryViewModel guildFeedGalleryViewModel2 = this.listViewModel;
        if (guildFeedGalleryViewModel2 != null) {
            com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
            guildFeedGalleryViewModel2.s2(cVar.h(partHost));
        }
    }

    private final GuildFeedGalleryInitBean ja() {
        if (this.galleryInitBean == null) {
            initPageBean();
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.galleryInitBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        return guildFeedGalleryInitBean;
    }

    private final List<lk1.a> la() {
        ArrayList arrayListOf;
        lk1.d dVar = new lk1.d();
        this.verticalReportScroller = dVar;
        dVar.r(this.exposeHelper);
        lk1.d dVar2 = this.verticalReportScroller;
        Intrinsics.checkNotNull(dVar2);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.verticalSelectedDetector, dVar2, new lk1.e(), new lk1.c());
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kk1.e ma() {
        fk1.b bVar = this.galleryAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
            bVar = null;
        }
        return bVar.getMScrollManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na() {
        List<jk1.a> list;
        MutableLiveData<UIStateData<List<jk1.a>>> j3;
        UIStateData<List<jk1.a>> value;
        GuildFeedGalleryViewModel guildFeedGalleryViewModel = this.listViewModel;
        SmartRefreshLayout smartRefreshLayout = null;
        if (guildFeedGalleryViewModel != null && (j3 = guildFeedGalleryViewModel.j()) != null && (value = j3.getValue()) != null) {
            list = value.getData();
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Ia(list);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout2;
        }
        smartRefreshLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryListPart.oa(GuildFeedGalleryListPart.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(final GuildFeedGalleryListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildFeedGalleryLoadingFooter guildFeedGalleryLoadingFooter = this$0.refreshFooter;
        if (guildFeedGalleryLoadingFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshFooter");
            guildFeedGalleryLoadingFooter = null;
        }
        guildFeedGalleryLoadingFooter.h(new kotlin.jvm.functions.Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryListPart$hideLoading$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SmartRefreshLayout smartRefreshLayout;
                GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = GuildFeedGalleryListPart.this.pageContentView;
                GuildFeedGalleryPageContentView guildFeedGalleryPageContentView2 = null;
                if (guildFeedGalleryPageContentView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
                    guildFeedGalleryPageContentView = null;
                }
                guildFeedGalleryPageContentView.setPageMaskVisible(8);
                smartRefreshLayout = GuildFeedGalleryListPart.this.refreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout = null;
                }
                smartRefreshLayout.finishLoadMore(false);
                GuildFeedGalleryPageContentView guildFeedGalleryPageContentView3 = GuildFeedGalleryListPart.this.pageContentView;
                if (guildFeedGalleryPageContentView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
                } else {
                    guildFeedGalleryPageContentView2 = guildFeedGalleryPageContentView3;
                }
                guildFeedGalleryPageContentView2.setViewPagerFakeCurrentItem();
            }
        });
        Vibrator vibrator = (Vibrator) this$0.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(400L);
        }
    }

    private final void pa() {
        ArrayList arrayListOf;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.galleryInitBean;
        if (guildFeedGalleryInitBean != null) {
            fk1.b bVar = new fk1.b(guildFeedGalleryInitBean);
            bVar.setHasStableIds(true);
            this.galleryAdapter = bVar;
            Iterator<T> it = la().iterator();
            while (true) {
                fk1.b bVar2 = null;
                if (!it.hasNext()) {
                    break;
                }
                lk1.a aVar = (lk1.a) it.next();
                fk1.b bVar3 = this.galleryAdapter;
                if (bVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                } else {
                    bVar2 = bVar3;
                }
                bVar2.s0(aVar);
            }
            GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = this.pageContentView;
            if (guildFeedGalleryPageContentView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
                guildFeedGalleryPageContentView = null;
            }
            fk1.b bVar4 = this.galleryAdapter;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                bVar4 = null;
            }
            guildFeedGalleryPageContentView.setViewPagerAdapter(bVar4);
            fk1.b bVar5 = this.galleryAdapter;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                bVar5 = null;
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new jk1.a(guildFeedGalleryInitBean, 0, 2, null));
            bVar5.setDatas(arrayListOf);
            Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[initAdapter] first feedID " + guildFeedGalleryInitBean.getFeedId());
        }
    }

    private final void qa() {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryListPart", 4, "initAdapterData");
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        cVar.h(partHost).setStageCode("stage_load_data").report();
        GuildFeedGalleryViewModel guildFeedGalleryViewModel = this.listViewModel;
        if (guildFeedGalleryViewModel != null) {
            guildFeedGalleryViewModel.p2();
        }
        GuildFeedGalleryViewModel guildFeedGalleryViewModel2 = this.listViewModel;
        if (guildFeedGalleryViewModel2 != null) {
            guildFeedGalleryViewModel2.loadMore();
        }
    }

    private final void ra() {
        RFWDragLayout rFWDragLayout = this.dragFrameLayout;
        RFWDragLayout rFWDragLayout2 = null;
        if (rFWDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragFrameLayout");
            rFWDragLayout = null;
        }
        rFWDragLayout.setEnableDragHorizontal(false);
        RFWDragLayout rFWDragLayout3 = this.dragFrameLayout;
        if (rFWDragLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragFrameLayout");
            rFWDragLayout3 = null;
        }
        rFWDragLayout3.setDragInterceptDelegate(new RFWDragLayout.DragInterceptDelegate() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.q
            @Override // com.tencent.richframework.widget.drag.RFWDragLayout.DragInterceptDelegate
            public final boolean needIntercept(MotionEvent motionEvent, float f16, float f17) {
                boolean sa5;
                sa5 = GuildFeedGalleryListPart.sa(motionEvent, f16, f17);
                return sa5;
            }
        });
        RFWDragLayout rFWDragLayout4 = this.dragFrameLayout;
        if (rFWDragLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragFrameLayout");
        } else {
            rFWDragLayout2 = rFWDragLayout4;
        }
        rFWDragLayout2.setOnDragListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sa(MotionEvent motionEvent, float f16, float f17) {
        if (Math.abs(f16) <= f17) {
            return true;
        }
        return false;
    }

    private final void ta() {
        Ea();
        GuildFeedGalleryGestureView guildFeedGalleryGestureView = this.galleryGestureView;
        if (guildFeedGalleryGestureView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryGestureView");
            guildFeedGalleryGestureView = null;
        }
        guildFeedGalleryGestureView.setRatePlayLongPressListener(new c());
    }

    private final void ua() {
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.w9b);
        if (viewStub != null) {
            viewStub.inflate();
            View findViewById = getPartRootView().findViewById(R.id.f70493ll);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rate_text)");
            this.rateText = (TextView) findViewById;
            View findViewById2 = getPartRootView().findViewById(R.id.yq8);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.ll_rate)");
            this.llRate = (LinearLayout) findViewById2;
            View findViewById3 = getPartRootView().findViewById(R.id.v76);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.first_video_img)");
            this.mFirstImg = (ImageView) findViewById3;
            View findViewById4 = getPartRootView().findViewById(R.id.f81704ew);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.second_video_img)");
            this.mSecondImg = (ImageView) findViewById4;
        }
    }

    private final void va() {
        MutableLiveData<jk1.a> h26;
        MutableLiveData<Integer> f26;
        MutableLiveData<Boolean> k26;
        MutableLiveData<UIStateData<List<jk1.a>>> j3;
        GuildFeedGalleryViewModel guildFeedGalleryViewModel = this.listViewModel;
        if (guildFeedGalleryViewModel != null && (j3 = guildFeedGalleryViewModel.j()) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<UIStateData<List<? extends jk1.a>>, Unit> function1 = new Function1<UIStateData<List<? extends jk1.a>>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryListPart$initObserver$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends jk1.a>> uIStateData) {
                    invoke2((UIStateData<List<jk1.a>>) uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<jk1.a>> uIStateData) {
                    SmartRefreshLayout smartRefreshLayout;
                    SmartRefreshLayout smartRefreshLayout2;
                    SmartRefreshLayout smartRefreshLayout3;
                    Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[initObserver] getFeedData state " + uIStateData.getState());
                    if (GuildFeedGalleryListPart.this.isShowGuide) {
                        return;
                    }
                    int state = uIStateData.getState();
                    SmartRefreshLayout smartRefreshLayout4 = null;
                    if (state == 3) {
                        GuildFeedGalleryListPart guildFeedGalleryListPart = GuildFeedGalleryListPart.this;
                        List<jk1.a> data = uIStateData.getData();
                        if (data == null) {
                            data = CollectionsKt__CollectionsKt.emptyList();
                        }
                        guildFeedGalleryListPart.Ia(data);
                    } else if (state == 4) {
                        smartRefreshLayout3 = GuildFeedGalleryListPart.this.refreshLayout;
                        if (smartRefreshLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                            smartRefreshLayout3 = null;
                        }
                        if (smartRefreshLayout3.getState() == RefreshState.Loading) {
                            GuildFeedGalleryListPart.this.Na();
                        }
                    }
                    smartRefreshLayout = GuildFeedGalleryListPart.this.refreshLayout;
                    if (smartRefreshLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                        smartRefreshLayout = null;
                    }
                    if (smartRefreshLayout.getState() == RefreshState.Loading) {
                        smartRefreshLayout2 = GuildFeedGalleryListPart.this.refreshLayout;
                        if (smartRefreshLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                        } else {
                            smartRefreshLayout4 = smartRefreshLayout2;
                        }
                        smartRefreshLayout4.finishLoadMore();
                    }
                }
            };
            j3.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedGalleryListPart.wa(Function1.this, obj);
                }
            });
        }
        GuildFeedGalleryViewModel guildFeedGalleryViewModel2 = this.listViewModel;
        if (guildFeedGalleryViewModel2 != null && (k26 = guildFeedGalleryViewModel2.k2()) != null) {
            Fragment hostFragment2 = getHostFragment();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryListPart$initObserver$2
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
                    Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[initObserver] LoadMoreIsFinish " + bool);
                    GuildFeedGalleryListPart.this.noMoreData = bool == null ? false : bool.booleanValue();
                }
            };
            k26.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedGalleryListPart.xa(Function1.this, obj);
                }
            });
        }
        GuildFeedGalleryViewModel guildFeedGalleryViewModel3 = this.listViewModel;
        if (guildFeedGalleryViewModel3 != null && (f26 = guildFeedGalleryViewModel3.f2()) != null) {
            Fragment hostFragment3 = getHostFragment();
            final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryListPart$initObserver$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    GuildFeedGalleryLoadingFooter guildFeedGalleryLoadingFooter;
                    if (num != null && num.intValue() == 2) {
                        GuildFeedGalleryListPart.this.Ta(true);
                        return;
                    }
                    if (num != null && num.intValue() == 4) {
                        guildFeedGalleryLoadingFooter = GuildFeedGalleryListPart.this.refreshFooter;
                        if (guildFeedGalleryLoadingFooter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("refreshFooter");
                            guildFeedGalleryLoadingFooter = null;
                        }
                        guildFeedGalleryLoadingFooter.f();
                    }
                }
            };
            f26.observe(hostFragment3, new Observer() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedGalleryListPart.za(Function1.this, obj);
                }
            });
        }
        GuildFeedGalleryViewModel guildFeedGalleryViewModel4 = this.listViewModel;
        if (guildFeedGalleryViewModel4 != null && (h26 = guildFeedGalleryViewModel4.h2()) != null) {
            Fragment hostFragment4 = getHostFragment();
            final Function1<jk1.a, Unit> function14 = new Function1<jk1.a, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryListPart$initObserver$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(jk1.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(jk1.a aVar) {
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean = GuildFeedGalleryListPart.this.galleryInitBean;
                    if (guildFeedGalleryInitBean != null) {
                        guildFeedGalleryInitBean.setFeed(aVar.b());
                    }
                    GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = GuildFeedGalleryListPart.this.galleryInitBean;
                    if (guildFeedGalleryInitBean2 != null) {
                        guildFeedGalleryInitBean2.setRichMediaDataList(aVar.getInitBean().getRichMediaDataList());
                    }
                    fk1.b bVar = GuildFeedGalleryListPart.this.galleryAdapter;
                    fk1.b bVar2 = null;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                        bVar = null;
                    }
                    jk1.a aVar2 = bVar.getDataList().get(0);
                    GProStFeed b16 = aVar.b();
                    Intrinsics.checkNotNullExpressionValue(b16, "it.sourceData");
                    aVar2.k(b16);
                    fk1.b bVar3 = GuildFeedGalleryListPart.this.galleryAdapter;
                    if (bVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                        bVar3 = null;
                    }
                    bVar3.getDataList().get(0).getInitBean().setFeed(aVar.b());
                    fk1.b bVar4 = GuildFeedGalleryListPart.this.galleryAdapter;
                    if (bVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                        bVar4 = null;
                    }
                    bVar4.getDataList().get(0).getInitBean().setRichMediaDataList(aVar.getInitBean().getRichMediaDataList());
                    mk1.e eVar = mk1.e.f416895a;
                    fk1.b bVar5 = GuildFeedGalleryListPart.this.galleryAdapter;
                    if (bVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                        bVar5 = null;
                    }
                    eVar.b(bVar5.getDataList().get(0).getInitBean());
                    fk1.b bVar6 = GuildFeedGalleryListPart.this.galleryAdapter;
                    if (bVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                    } else {
                        bVar2 = bVar6;
                    }
                    bVar2.notifyItemChanged(0, aVar);
                    ax.K(GuildFeedGalleryListPart.this.getActivity(), GuildFeedGalleryListPart.this.galleryInitBean);
                }
            };
            h26.observe(hostFragment4, new Observer() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.p
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedGalleryListPart.Aa(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(GuildFeedGalleryImmersiveEvent.PreloadFeedList.class);
        eventClass.add(GuildFeedGalleryItemTypeEvent.class);
        eventClass.add(GuildFeedChannelTopEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "Guild_Feed_GAL_GuildFeedGalleryListPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_get_comment_feed_data")) {
            return ia(args);
        }
        if (Intrinsics.areEqual(action, "message_get_feed_position_event")) {
            return Integer.valueOf(this.curSelectedPos);
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@NotNull String action, @Nullable Object args) {
        Intrinsics.checkNotNullParameter(action, "action");
        int hashCode = action.hashCode();
        if (hashCode != -1720828212) {
            if (hashCode != 987652232) {
                if (hashCode == 1074715091 && action.equals("init_expose")) {
                    Intrinsics.checkNotNull(args, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discovery.expose.ExposeHelper");
                    La((gh1.b) args);
                    return;
                }
            } else if (action.equals("message_on_gallery_open_anim_end_event")) {
                QLog.i("Guild_Feed_GAL_GuildFeedGalleryListPart", 4, "MESSAGE_ON_GALLERY_OPEN_ANIM_END_EVENT");
                com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
                IPartHost partHost = getPartHost();
                Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
                cVar.h(partHost).setStageCode("stage_finish").report();
                getMainHandler().removeCallbacks(this.requestRecommendDataTask);
                qa();
                return;
            }
        } else if (action.equals("message_on_init_bean_changed")) {
            Sa();
            return;
        }
        if (V.contains(action)) {
            fk1.b bVar = this.galleryAdapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                bVar = null;
            }
            GuildGalleryMixMediaItemView l06 = bVar.l0(this.curSelectedPos);
            if (l06 != null) {
                l06.l0(action, args);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        boolean z16;
        boolean z17;
        super.onConfigurationChanged(configuration);
        GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = this.pageContentView;
        RecyclerView recyclerView = null;
        if (guildFeedGalleryPageContentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
            guildFeedGalleryPageContentView = null;
        }
        int d16 = guildFeedGalleryPageContentView.d();
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "[onConfigurationChanged] pos= " + d16 + " ---------------- ";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (true) {
            z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, (String) it.next(), null);
        }
        fk1.b bVar2 = this.galleryAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
            bVar2 = null;
        }
        int itemCount = bVar2.getItemCount();
        Integer valueOf = Integer.valueOf(d16 + 1);
        if (valueOf.intValue() < itemCount) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            valueOf = null;
        }
        if (valueOf == null) {
            valueOf = Integer.valueOf(d16 - 1);
            if (valueOf.intValue() < 0 || d16 >= itemCount) {
                z16 = false;
            }
            if (!z16) {
                valueOf = null;
            }
            if (valueOf == null) {
                return;
            }
        }
        int intValue = valueOf.intValue();
        GuildFeedGalleryPageContentView guildFeedGalleryPageContentView2 = this.pageContentView;
        if (guildFeedGalleryPageContentView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
            guildFeedGalleryPageContentView2 = null;
        }
        View childAt = guildFeedGalleryPageContentView2.getViewPager2().getChildAt(0);
        if (childAt instanceof RecyclerView) {
            recyclerView = (RecyclerView) childAt;
        }
        if (recyclerView != null) {
            recyclerView.scrollToPosition(intValue);
            recyclerView.scrollToPosition(d16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[onInitView] ");
        View findViewById = rootView.findViewById(R.id.ulf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.drag_frame_layout)");
        this.dragFrameLayout = (RFWDragLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.w9a);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ild_feed_gallery_content)");
        this.pageContentView = (GuildFeedGalleryPageContentView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f72333qk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.refresh_layout)");
        this.refreshLayout = (SmartRefreshLayout) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f72283qf);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.refresh_footer)");
        this.refreshFooter = (GuildFeedGalleryLoadingFooter) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.w9c);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026eed_gallery_gesture_view)");
        GuildFeedGalleryGestureView guildFeedGalleryGestureView = (GuildFeedGalleryGestureView) findViewById5;
        this.galleryGestureView = guildFeedGalleryGestureView;
        IRuntimeService iRuntimeService = null;
        if (guildFeedGalleryGestureView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryGestureView");
            guildFeedGalleryGestureView = null;
        }
        guildFeedGalleryGestureView.setClickable(true);
        ra();
        GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = this.pageContentView;
        if (guildFeedGalleryPageContentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
            guildFeedGalleryPageContentView = null;
        }
        guildFeedGalleryPageContentView.e(new e());
        pa();
        Ba();
        ta();
        getMainHandler().removeCallbacks(this.requestRecommendDataTask);
        getMainHandler().postDelayed(this.requestRecommendDataTask, 800L);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProGlobalService.class, "");
        }
        IGProGlobalService iGProGlobalService = (IGProGlobalService) iRuntimeService;
        if (iGProGlobalService != null) {
            iGProGlobalService.addObserver(this.serviceObserver);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[onPartCreate] ");
        initPageBean();
        initViewModel();
        va();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        AppInterface appInterface;
        GuildFeedGalleryPageContentView guildFeedGalleryPageContentView = this.pageContentView;
        IRuntimeService iRuntimeService = null;
        if (guildFeedGalleryPageContentView != null) {
            if (guildFeedGalleryPageContentView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageContentView");
                guildFeedGalleryPageContentView = null;
            }
            guildFeedGalleryPageContentView.f(activity);
        }
        getMainHandler().removeCallbacks(this.requestRecommendDataTask);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProGlobalService.class, "");
        }
        IGProGlobalService iGProGlobalService = (IGProGlobalService) iRuntimeService;
        if (iGProGlobalService != null) {
            iGProGlobalService.deleteObserver(this.serviceObserver);
        }
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[onPartDestroy] ");
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        if (this.galleryAdapter != null) {
            Logger.f235387a.d().i("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[onPartPause] ");
            fk1.b bVar = this.galleryAdapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                bVar = null;
            }
            bVar.p0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        SmartRefreshLayout smartRefreshLayout = null;
        if (this.galleryAdapter != null) {
            Logger.f235387a.d().i("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[onPartResume] ");
            fk1.b bVar = this.galleryAdapter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryAdapter");
                bVar = null;
            }
            bVar.q0();
        }
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout2;
        }
        smartRefreshLayout.setBackgroundColor(getContext().getResources().getColor(R.color.black));
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        GuildFeedGalleryViewModel guildFeedGalleryViewModel;
        super.onReceiveEvent(simpleBaseEvent);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild_Feed_GAL_GuildFeedGalleryListPart", 1, "[onReceiveEvent] ");
        }
        if (simpleBaseEvent instanceof GuildFeedGalleryImmersiveEvent.PreloadFeedList) {
            if (!this.noMoreData && (guildFeedGalleryViewModel = this.listViewModel) != null) {
                guildFeedGalleryViewModel.loadMore();
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedGalleryItemTypeEvent) {
            this.itemType = ((GuildFeedGalleryItemTypeEvent) simpleBaseEvent).getType();
        } else if (simpleBaseEvent instanceof GuildFeedChannelTopEvent) {
            GuildFeedChannelTopEvent guildFeedChannelTopEvent = (GuildFeedChannelTopEvent) simpleBaseEvent;
            Ra(guildFeedChannelTopEvent.getFeedId(), guildFeedChannelTopEvent.getTopState());
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryListPart$b", "Lcom/tencent/richframework/widget/drag/RFWDragLayout$OnDragListener;", "", "onStartDrag", "", "factor", "onDragging", "", "isDragToClose", "onEndDrag", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements RFWDragLayout.OnDragListener {
        b() {
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
        public void onEndDrag(boolean isDragToClose) {
            if (isDragToClose) {
                GuildFeedGalleryListPart.this.ga();
            }
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
        public void onStartDrag() {
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
        public void onDragging(float factor) {
        }
    }
}
