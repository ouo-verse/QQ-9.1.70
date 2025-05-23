package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.activities.base.QZoneFeedOperateLogic;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.EventSource;
import com.qzone.common.event.IObserver;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellToast;
import com.qzone.publish.business.publishqueue.common.CommonPublishVideoStatusInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001}B\u0007\u00a2\u0006\u0004\bz\u0010{J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J!\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001a\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020 H\u0002J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020(H\u0002J\u0012\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u00101\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010-2\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00102\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00103\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00104\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u00107\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010:\u001a\u00020\u00072\u0006\u00109\u001a\u000208H\u0016J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0005H\u0016J\u0018\u0010A\u001a\u00020\u00072\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?H\u0016J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010>\u001a\u00020=H\u0016J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0005H\u0016R\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010YR\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u001c\u0010o\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020=0t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010nR\u0016\u0010y\u001a\u00020w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010q\u00a8\u0006~"}, d2 = {"Lcom/qzone/reborn/feedx/part/bb;", "Lcom/qzone/reborn/feedx/part/g;", "Lcom/qzone/common/event/IObserver$post;", "Landroid/view/View$OnClickListener;", "Lsm/i;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "Y9", "H9", "", "S9", "", "", "validShareChannels", "da", "Z9", "K9", "Landroid/view/View;", "view", "O9", "T9", "shareChannel", "I9", "(ILcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)Ljava/lang/Boolean;", "firstTwoChannels", "aa", "ca", "L9", "M9", "N9", WadlProxyConsts.CHANNEL, "Lfo/b;", "J9", "trackingParam", "W9", "X9", "Q9", "V9", "ea", "Lcom/qzone/common/event/Event;", "event", "U9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "onPartDestroy", NodeProps.ON_CLICK, "qzoneEvent", "onEventPostThread", "Landroid/os/Message;", "msg", "onHandleMessage", "data", "i7", "", "clientKey", "Lcom/qzone/publish/business/publishqueue/common/g;", "videoStatusInfo", "z5", "v1", "I4", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "latestPostedFeedDataLiveData", "Landroidx/lifecycle/Observer;", "e", "Landroidx/lifecycle/Observer;", "feedDataObserver", "f", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", tl.h.F, "Landroid/view/View;", "publishShareRootView", "i", "publishShareContainerView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "publishShareImageView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "publishShareTitleView", "D", "publishShareContentView", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "publishShareIconLayout", "Lcom/qzone/common/activities/base/QZoneFeedOperateLogic;", UserInfo.SEX_FEMALE, "Lcom/qzone/common/activities/base/QZoneFeedOperateLogic;", "feedOperateLogic", "Landroid/os/Handler;", "G", "Landroid/os/Handler;", "handlerForFeedOperateLogic", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "H", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "rootViewLayoutParams", "I", "Ljava/util/List;", "validFirstTwoChannels", "Ljava/lang/Runnable;", "J", "Ljava/lang/Runnable;", "hidePublishShareBannerRunnable", "", "K", "deletedUgcKeyList", "", "L", "lastedFeedUploadSuccessTimeMs", "<init>", "()V", "M", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bb extends g implements IObserver.post, View.OnClickListener, sm.i {

    /* renamed from: M, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Integer, Integer> N;
    private static final Map<Integer, Integer> P;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView publishShareTitleView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView publishShareContentView;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout publishShareIconLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneFeedOperateLogic feedOperateLogic;

    /* renamed from: G, reason: from kotlin metadata */
    private Handler handlerForFeedOperateLogic = new b();

    /* renamed from: H, reason: from kotlin metadata */
    private final ConstraintLayout.LayoutParams rootViewLayoutParams = new ConstraintLayout.LayoutParams(-1, -2);

    /* renamed from: I, reason: from kotlin metadata */
    private List<Integer> validFirstTwoChannels;

    /* renamed from: J, reason: from kotlin metadata */
    private final Runnable hidePublishShareBannerRunnable;

    /* renamed from: K, reason: from kotlin metadata */
    private List<String> deletedUgcKeyList;

    /* renamed from: L, reason: from kotlin metadata */
    private long lastedFeedUploadSuccessTimeMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<BusinessFeedData> latestPostedFeedDataLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Observer<BusinessFeedData> feedDataObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData feedData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View publishShareRootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View publishShareContainerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView publishShareImageView;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/feedx/part/bb$a;", "", "", "a", "", "", "CHANNELS_TO_IMAGE_SRC", "Ljava/util/Map;", "CHANNELS_TO_OPERATE_MASK", "", "EVENT_TAG_SCENE_NAME", "Ljava/lang/String;", "LIB_TEMPLATE_SCENE_NAME", "MAGIC_STUDIO_SCENE_NAME", "MAX_SHARE_CHANNEL_COUNT", "I", "", "PUBLISH_SHARE_BANNER_AUTO_HIDE_DURATION_MS", "J", "PUBLISH_SHARE_FEED_COOL_DOWN_DURATION_MS", "TAG", "TOAST_SHARE_CHANNEL_QQ", "TOAST_SHARE_CHANNEL_WECHAT", "TOAST_SHARE_CHANNEL_WECHAT_MOMENTS", "", "VIEW_ELEVATION", UserInfo.SEX_FEMALE, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedx.part.bb$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return com.qzone.reborn.a.f52169a.d("exp_qzone_publishlink_leadtoshare", "_B");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/part/bb$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QZoneResult unpack = QZoneResult.unpack(msg2);
            QZoneFeedOperateLogic qZoneFeedOperateLogic = bb.this.feedOperateLogic;
            if (qZoneFeedOperateLogic != null) {
                qZoneFeedOperateLogic.handleGetShareUrl(unpack);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/part/bb$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f55037d;

        c(View view) {
            this.f55037d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f55037d.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    static {
        Map<Integer, Integer> mapOf;
        Map<Integer, Integer> mapOf2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, Integer.valueOf(R.drawable.oh9)), TuplesKt.to(2, Integer.valueOf(R.drawable.ohi)), TuplesKt.to(3, Integer.valueOf(R.drawable.oh7)));
        N = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(1, 14), TuplesKt.to(2, 13), TuplesKt.to(3, 13));
        P = mapOf2;
    }

    public bb() {
        List<Integer> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.validFirstTwoChannels = emptyList;
        this.hidePublishShareBannerRunnable = new Runnable() { // from class: com.qzone.reborn.feedx.part.az
            @Override // java.lang.Runnable
            public final void run() {
                bb.P9(bb.this);
            }
        };
        this.deletedUgcKeyList = new ArrayList();
    }

    private final void H9() {
        RFWThreadManager.getInstance().postMainDelay(this.hidePublishShareBannerRunnable, 5000L);
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "autoHidePublishShareBanner");
    }

    private final Boolean I9(int shareChannel, BusinessFeedData feedData) {
        Integer num = P.get(Integer.valueOf(shareChannel));
        if (num == null) {
            return null;
        }
        return Boolean.valueOf(com.qzone.proxy.feedcomponent.util.d.j(feedData.getFeedCommInfo().operatemask, num.intValue()));
    }

    private final fo.b J9(BusinessFeedData feedData, int channel) {
        int i3;
        String str = feedData.cellToast.scenes;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 278107808) {
                if (hashCode != 1096583651) {
                    if (hashCode == 2044886559 && str.equals("libTemplate")) {
                        i3 = 2;
                    }
                } else if (str.equals(WinkPublishMediaRecord.WINK_REPORT_TYPE_MAGIC_STUDIO)) {
                    i3 = 1;
                }
            } else if (str.equals("eventTag")) {
                i3 = 3;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("share_source", Integer.valueOf(channel));
            hashMap.put("scene_name", Integer.valueOf(i3));
            fo.b trackingParam = new fo.b().l(hashMap);
            Intrinsics.checkNotNullExpressionValue(trackingParam, "trackingParam");
            return trackingParam;
        }
        i3 = 0;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("share_source", Integer.valueOf(channel));
        hashMap2.put("scene_name", Integer.valueOf(i3));
        fo.b trackingParam2 = new fo.b().l(hashMap2);
        Intrinsics.checkNotNullExpressionValue(trackingParam2, "trackingParam");
        return trackingParam2;
    }

    private final List<Integer> K9(BusinessFeedData feedData) {
        List<Integer> take;
        ArrayList arrayList = new ArrayList();
        ArrayList<Integer> arrayList2 = feedData.cellToast.channels;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "feedData.cellToast.channels");
        for (Integer channel : arrayList2) {
            Intrinsics.checkNotNullExpressionValue(channel, "channel");
            if (Intrinsics.areEqual(I9(channel.intValue(), feedData), Boolean.TRUE)) {
                arrayList.add(channel);
            }
        }
        take = CollectionsKt___CollectionsKt.take(arrayList, 2);
        return take;
    }

    private final void L9() {
        QZoneFeedOperateLogic qZoneFeedOperateLogic = this.feedOperateLogic;
        if (qZoneFeedOperateLogic != null) {
            qZoneFeedOperateLogic.onShareToQQ();
        }
    }

    private final void M9() {
        QZoneFeedOperateLogic qZoneFeedOperateLogic = this.feedOperateLogic;
        if (qZoneFeedOperateLogic != null) {
            qZoneFeedOperateLogic.onShareToWeixin();
        }
    }

    private final void N9() {
        QZoneFeedOperateLogic qZoneFeedOperateLogic = this.feedOperateLogic;
        if (qZoneFeedOperateLogic != null) {
            qZoneFeedOperateLogic.onShareToWxMoments();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(bb this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9(this$0.publishShareRootView);
    }

    private final void Q9() {
        this.feedDataObserver = new Observer() { // from class: com.qzone.reborn.feedx.part.ay
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bb.R9(bb.this, (BusinessFeedData) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(bb this$0, BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (businessFeedData != null) {
            QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "initFeedDataObserver latestCellToast: " + businessFeedData.cellToast);
            this$0.feedData = businessFeedData;
            if (this$0.S9(businessFeedData)) {
                QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "start show publish share banner");
                this$0.da(businessFeedData, this$0.validFirstTwoChannels);
            } else {
                QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "this feed is not enabled to show");
            }
        }
    }

    private final boolean S9(BusinessFeedData feedData) {
        boolean contains;
        long h16 = com.qzone.reborn.util.i.b().h("qz_publish_share_latest_feed_update_time_ms", 0L);
        CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
        long j3 = cellFeedCommInfo != null ? cellFeedCommInfo.time : 0L;
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "new feedDataCommInfoTime:" + j3);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.lastedFeedUploadSuccessTimeMs;
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "postToShowTimeInterval:" + elapsedRealtime);
        contains = CollectionsKt___CollectionsKt.contains(this.deletedUgcKeyList, ef.b.a(feedData));
        if (h16 >= j3) {
            QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "feedDataUpdateTime:" + h16 + " is already new");
        } else if (contains) {
            QLog.e("QZoneFeedxPublishShareTopBannerPart", 1, "this feed has been deleted");
        } else if (elapsedRealtime > 10000) {
            QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "this feed has exceeded the cool_down_duration");
        } else {
            View view = this.publishShareRootView;
            if (view != null && view.getVisibility() == 0) {
                QLog.e("QZoneFeedxPublishShareTopBannerPart", 1, "there is another banner is showing");
            } else {
                List<Integer> K9 = K9(feedData);
                this.validFirstTwoChannels = K9;
                if (K9.isEmpty()) {
                    QLog.e("QZoneFeedxPublishShareTopBannerPart", 1, "share channels are empty");
                } else {
                    com.qzone.reborn.util.i.b().p("qz_publish_share_latest_feed_update_time_ms", j3);
                    return true;
                }
            }
        }
        return false;
    }

    private final void T9(BusinessFeedData feedData, View view) {
        ho.c e16 = ho.i.e();
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        e16.c((Activity) context, feedData, view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final BusinessFeedData U9(Event event) {
        BusinessFeedData businessFeedData;
        Object orNull;
        Object obj = event.params;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                orNull = ArraysKt___ArraysKt.getOrNull(objArr, 0);
                if (orNull instanceof BusinessFeedData) {
                    businessFeedData = (BusinessFeedData) orNull;
                    QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "parseFeedDataFromEvent cellToast: " + (businessFeedData != null ? businessFeedData.cellToast : null));
                    return businessFeedData;
                }
            }
        }
        businessFeedData = null;
        if (businessFeedData != null) {
        }
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "parseFeedDataFromEvent cellToast: " + (businessFeedData != null ? businessFeedData.cellToast : null));
        return businessFeedData;
    }

    private final void V9() {
        MutableLiveData<BusinessFeedData> mutableLiveData = this.latestPostedFeedDataLiveData;
        Observer<BusinessFeedData> observer = null;
        if (mutableLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("latestPostedFeedDataLiveData");
            mutableLiveData = null;
        }
        Fragment hostFragment = getHostFragment();
        Observer<BusinessFeedData> observer2 = this.feedDataObserver;
        if (observer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDataObserver");
        } else {
            observer = observer2;
        }
        mutableLiveData.observe(hostFragment, observer);
    }

    private final void W9(View view, fo.b trackingParam) {
        trackingParam.g(ClickPolicy.REPORT_NONE);
        fo.c.b("dt_clck", view, "em_qz_share_guide", trackingParam);
    }

    private final void X9(View view, fo.b trackingParam) {
        fo.c.b("dt_imp", view, "em_qz_share_guide", trackingParam);
    }

    private final void Y9(BusinessFeedData feedData) {
        QZoneFeedOperateLogic qZoneFeedOperateLogic = this.feedOperateLogic;
        if (qZoneFeedOperateLogic != null) {
            qZoneFeedOperateLogic.setFeedData(feedData);
        }
    }

    private final void Z9(BusinessFeedData feedData) {
        TextView textView = this.publishShareTitleView;
        if (textView != null) {
            textView.setText(feedData.cellToast.title);
        }
        TextView textView2 = this.publishShareContentView;
        if (textView2 != null) {
            textView2.setText(feedData.cellToast.content);
        }
        TextView textView3 = this.publishShareTitleView;
        ViewGroup.LayoutParams layoutParams = textView3 != null ? textView3.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        TextView textView4 = this.publishShareContentView;
        ViewGroup.LayoutParams layoutParams3 = textView4 != null ? textView4.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        if (URLUtil.isValidUrl(feedData.cellToast.cover)) {
            QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "image style");
            View view = this.publishShareContainerView;
            if (view != null) {
                ViewExtKt.d(view, com.qzone.util.ar.d(10.0f));
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = com.qzone.util.ar.d(10.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = com.qzone.util.ar.d(10.0f);
            RoundCornerImageView roundCornerImageView = this.publishShareImageView;
            if (roundCornerImageView != null) {
                roundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            RoundCornerImageView roundCornerImageView2 = this.publishShareImageView;
            if (roundCornerImageView2 != null) {
                roundCornerImageView2.setCorner(com.qzone.util.ar.d(4.0f));
            }
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setTargetView(this.publishShareImageView).setUrl(feedData.cellToast.cover).setFailedDrawableId(R.drawable.ohd));
        } else {
            QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "mood style");
            View view2 = this.publishShareContainerView;
            if (view2 != null) {
                ViewExtKt.d(view2, com.qzone.util.ar.d(2.0f));
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = com.qzone.util.ar.d(0.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = com.qzone.util.ar.d(0.0f);
            RoundCornerImageView roundCornerImageView3 = this.publishShareImageView;
            if (roundCornerImageView3 != null) {
                roundCornerImageView3.setImageResource(R.drawable.qui_tick_filled_feedback_success);
            }
            RoundCornerImageView roundCornerImageView4 = this.publishShareImageView;
            if (roundCornerImageView4 != null) {
                roundCornerImageView4.setScaleType(ImageView.ScaleType.CENTER);
            }
        }
        TextView textView5 = this.publishShareTitleView;
        if (textView5 != null) {
            textView5.setLayoutParams(layoutParams2);
        }
        TextView textView6 = this.publishShareContentView;
        if (textView6 == null) {
            return;
        }
        textView6.setLayoutParams(layoutParams4);
    }

    private final void aa(List<Integer> firstTwoChannels, BusinessFeedData feedData) {
        Y9(feedData);
        Iterator<T> it = firstTwoChannels.iterator();
        while (it.hasNext()) {
            final int intValue = ((Number) it.next()).intValue();
            final fo.b J9 = J9(feedData, intValue);
            final ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new LinearLayout.LayoutParams(com.qzone.util.ar.d(40.0f), com.qzone.util.ar.d(40.0f)));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(com.qzone.util.ar.d(8.0f), com.qzone.util.ar.d(8.0f), com.qzone.util.ar.d(8.0f), com.qzone.util.ar.d(8.0f));
            Integer num = N.get(Integer.valueOf(intValue));
            if (num != null) {
                imageView.setImageResource(num.intValue());
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.ba
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bb.ba(bb.this, imageView, J9, intValue, view);
                }
            });
            LinearLayout linearLayout = this.publishShareIconLayout;
            if (linearLayout != null) {
                linearLayout.addView(imageView);
            }
            X9(imageView, J9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(bb this$0, ImageView publishShareIcon, fo.b trackingParam, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(publishShareIcon, "$publishShareIcon");
        Intrinsics.checkNotNullParameter(trackingParam, "$trackingParam");
        this$0.W9(publishShareIcon, trackingParam);
        this$0.O9(this$0.publishShareRootView);
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "jump to channel:" + i3);
        this$0.ca(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void da(BusinessFeedData feedData, List<Integer> validShareChannels) {
        View view = this.publishShareRootView;
        if ((view != null ? view.getParent() : null) == null) {
            QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "init publish share banner view");
            View partRootView = getPartRootView();
            View inflate = LayoutInflater.from(partRootView != null ? partRootView.getContext() : null).inflate(R.layout.cgs, (ViewGroup) null, false);
            if (inflate == null) {
                return;
            }
            this.publishShareRootView = inflate;
            this.publishShareContainerView = inflate.findViewById(R.id.n19);
            View view2 = this.publishShareRootView;
            RoundCornerImageView roundCornerImageView = view2 != null ? (RoundCornerImageView) view2.findViewById(R.id.n1a) : null;
            this.publishShareImageView = roundCornerImageView;
            if (roundCornerImageView != null) {
                roundCornerImageView.setOnClickListener(this);
            }
            View view3 = this.publishShareRootView;
            this.publishShareTitleView = view3 != null ? (TextView) view3.findViewById(R.id.n1c) : null;
            View view4 = this.publishShareRootView;
            this.publishShareContentView = view4 != null ? (TextView) view4.findViewById(R.id.n1_) : null;
            View view5 = this.publishShareRootView;
            this.publishShareIconLayout = view5 != null ? (LinearLayout) view5.findViewById(R.id.n1b) : null;
            View partRootView2 = getPartRootView();
            if (partRootView2 instanceof ViewGroup) {
                ((ViewGroup) partRootView2).addView(this.publishShareRootView, this.rootViewLayoutParams);
            }
        }
        LinearLayout linearLayout = this.publishShareIconLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        View view6 = this.publishShareRootView;
        if (view6 != null) {
            view6.setVisibility(0);
        }
        aa(validShareChannels, feedData);
        Z9(feedData);
        View view7 = this.publishShareRootView;
        if (view7 != null) {
            view7.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154945ff));
        }
        H9();
        View view8 = this.publishShareContainerView;
        if (view8 == null) {
            return;
        }
        view8.setElevation(20.0f);
    }

    private final void ea() {
        MutableLiveData<BusinessFeedData> mutableLiveData = this.latestPostedFeedDataLiveData;
        Observer<BusinessFeedData> observer = null;
        if (mutableLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("latestPostedFeedDataLiveData");
            mutableLiveData = null;
        }
        Observer<BusinessFeedData> observer2 = this.feedDataObserver;
        if (observer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDataObserver");
        } else {
            observer = observer2;
        }
        mutableLiveData.removeObserver(observer);
    }

    @Override // sm.i
    public void I4(BusinessFeedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.cellToast != null) {
            MutableLiveData<BusinessFeedData> mutableLiveData = this.latestPostedFeedDataLiveData;
            if (mutableLiveData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("latestPostedFeedDataLiveData");
                mutableLiveData = null;
            }
            mutableLiveData.postValue(data);
            this.lastedFeedUploadSuccessTimeMs = SystemClock.elapsedRealtime();
        }
    }

    @Override // sm.i
    public void i7(BusinessFeedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CellToast cellToast;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.n1a) {
            BusinessFeedData businessFeedData = this.feedData;
            if (URLUtil.isValidUrl((businessFeedData == null || (cellToast = businessFeedData.cellToast) == null) ? null : cellToast.cover)) {
                O9(this.publishShareRootView);
                QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "jump to feeds detail");
                T9(this.feedData, view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message msg2) {
        boolean contains;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QZoneResult unpack = QZoneResult.unpack(msg2);
        Integer valueOf = unpack != null ? Integer.valueOf(unpack.what) : null;
        if (valueOf != null && valueOf.intValue() == 999909) {
            if (unpack.getUgcKey() != null) {
                List<String> list = this.deletedUgcKeyList;
                String ugcKey = unpack.getUgcKey();
                Intrinsics.checkNotNullExpressionValue(ugcKey, "result.ugcKey");
                list.add(ugcKey);
            }
            QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "needDeletedClientKeyList: " + this.deletedUgcKeyList + ", feedData.getFeedUniKey(): " + ef.b.a(this.feedData));
            contains = CollectionsKt___CollectionsKt.contains(this.deletedUgcKeyList, ef.b.a(this.feedData));
            if (contains) {
                O9(this.publishShareRootView);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.latestPostedFeedDataLiveData = ((com.qzone.reborn.feedx.viewmodel.m) getViewModel(com.qzone.reborn.feedx.viewmodel.m.class)).L1();
        EventCenter.getInstance().addObserver(this, "Feed", 10);
        Q9();
        this.feedOperateLogic = new QZoneFeedOperateLogic(this.handlerForFeedOperateLogic, getActivity(), "feed");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        if (lc.b.d()) {
            lc.i.f414345a.i(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "onPartDestroy");
        EventCenter.getInstance().removeObserver(this);
        this.feedOperateLogic = null;
        RFWThreadManager.getInstance().remove(this.hidePublishShareBannerRunnable);
        this.deletedUgcKeyList.clear();
        lc.i.f414345a.y(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "onPartPause");
        ea();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "onPartResume");
        V9();
    }

    @Override // sm.i
    public void v1(String clientKey) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
    }

    @Override // sm.i
    public void z5(String clientKey, CommonPublishVideoStatusInfo videoStatusInfo) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(videoStatusInfo, "videoStatusInfo");
    }

    @Override // com.qzone.common.event.IObserver.post
    public void onEventPostThread(Event qzoneEvent) {
        EventSource eventSource;
        BusinessFeedData U9;
        if (qzoneEvent == null || (eventSource = qzoneEvent.source) == null) {
            return;
        }
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "onEventBackgroundThread: name: " + eventSource.getName() + ", sender:" + eventSource.getSender());
        if (Intrinsics.areEqual(eventSource.getName(), "Feed") && qzoneEvent.what == 10 && (eventSource.getSender() instanceof QZoneFeedService) && (U9 = U9(qzoneEvent)) != null && U9.cellToast != null) {
            MutableLiveData<BusinessFeedData> mutableLiveData = this.latestPostedFeedDataLiveData;
            if (mutableLiveData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("latestPostedFeedDataLiveData");
                mutableLiveData = null;
            }
            mutableLiveData.postValue(U9);
            this.lastedFeedUploadSuccessTimeMs = SystemClock.elapsedRealtime();
        }
    }

    private final void O9(View view) {
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        QLog.i("QZoneFeedxPublishShareTopBannerPart", 1, "hidePublishShareBanner");
        if (getContext() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154946fg);
            loadAnimation.setAnimationListener(new c(view));
            view.startAnimation(loadAnimation);
        }
    }

    private final void ca(int shareChannel) {
        if (shareChannel == 1) {
            L9();
        } else if (shareChannel == 2) {
            M9();
        } else {
            if (shareChannel != 3) {
                return;
            }
            N9();
        }
    }
}
