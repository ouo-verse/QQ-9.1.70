package h61;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.MainIntimateTitlePart;
import com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout;
import com.tencent.mobileqq.activity.aio.intimate.reborn.IntimatePartManager;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.DoLIAAnimViewEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.GetLoverValueEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.MutualMarkCardUpdateEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.PartnerUpdateEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.RequestQZoneIntimateSpaceEntranceEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.ShareItemClickEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.UpdateQZoneIntimateSpaceEntranceInfoEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.UpdateTitlePartCurrentTypeLevelEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.part.IntimateContentListPart;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import com.tencent.util.k;
import cooperation.qzone.api.IQZoneIntimateSpaceApi;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qzone.QZIntimateSpaceRedDotReader$EntranceInfo;
import qzone.QZIntimateSpaceRedDotReader$GetRedPointsRsp;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b5\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0001q\u0018\u0000 w2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002xyB\u001f\u0012\u0006\u0010;\u001a\u000206\u0012\u0006\u0010@\u001a\u00020\u000e\u0012\u0006\u0010F\u001a\u00020A\u00a2\u0006\u0004\bu\u0010vJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J)\u0010\u0016\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0014H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\u0010\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0006\u0010#\u001a\u00020\"J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$J\u0006\u0010'\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0005J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\fH\u0016J\u0012\u00101\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0016J$\u00105\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040302j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000403`4H\u0016R\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0017\u0010@\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010F\u001a\u00020A8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010HR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010NR\u0014\u0010Q\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010a\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010h\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010cR\u0016\u0010j\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010cR\u0016\u0010l\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010cR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010s\u00a8\u0006z"}, d2 = {"Lh61/d;", "", "Landroid/os/Handler$Callback;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/data/IntimateInfo;", "intimateInfo", "E", DomainData.DOMAIN_NAME, "y", "", "isSuccess", "", "friendUin", "isPush", "i", h.F, "j", "", "objects", "k", "(Z[Ljava/lang/Object;)V", "B", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lcom/tencent/biz/richframework/part/Part;", "g", "Landroid/os/Message;", "msg", "handleMessage", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/frame/api/e;", "controller", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", "u", "t", HippyTKDListViewAdapter.X, "w", MosaicConstants$JsFunction.FUNC_ON_DESTROY, ReportConstant.COSTREPORT_PREFIX, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/app/QBaseActivity;", "d", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "e", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "mFriendUin", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/os/Handler;", "Landroid/os/Handler;", "mUIHandler", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/IntimatePartManager;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/IntimatePartManager;", "partManager", "Lj61/c;", "Lj61/c;", "viewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "mLIAAnimView", "Lcom/tencent/aio/frame/api/e;", "mFrameDrawerController", "Lcom/tencent/mobileqq/activity/aio/intimate/MainIntimateTitlePart;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/aio/intimate/MainIntimateTitlePart;", "mTitlePart", "Lcom/tencent/mobileqq/activity/aio/intimate/flingappbar/FlingAppBarLayout;", "G", "Lcom/tencent/mobileqq/activity/aio/intimate/flingappbar/FlingAppBarLayout;", "flingAppbarLayout", "H", "Lcom/tencent/mobileqq/data/IntimateInfo;", "mIntimateInfo", "I", "Z", "hasAddObserver", "J", "mNeedReqIntimateInfo", "K", "mHasPreloadWeb", "L", "mIsOpened", "M", "hasInitDataFromDB", "Lh61/d$b;", "N", "Lh61/d$b;", "mIntimateInfoObserver", "h61/d$c", "P", "Lh61/d$c;", "mOnOffsetChangedListener", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d implements Handler.Callback, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LIAAnimView mLIAAnimView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.frame.api.e mFrameDrawerController;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private MainIntimateTitlePart mTitlePart;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private FlingAppBarLayout flingAppbarLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private IntimateInfo mIntimateInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean hasAddObserver;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mNeedReqIntimateInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mHasPreloadWeb;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsOpened;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean hasInitDataFromDB;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final b mIntimateInfoObserver;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final c mOnOffsetChangedListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mFriendUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler mUIHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IntimatePartManager partManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j61.c viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\"\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0014J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J)\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0014\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lh61/d$b;", "Lcom/tencent/mobileqq/friends/intimate/d;", "", "isSuccess", "", "friendUin", "", "onBandIntimateRelationship", "isPush", "onDisbandIntimateRelationship", "Lcom/tencent/mobileqq/data/IntimateInfo;", "intimateInfo", "onGetUpgradeIntimateInfo", "", "", "objects", "onHandleGetLoverIntimateInfo", "(Z[Ljava/lang/Object;)V", "", "changedCardIndex", "isWear", "onMutualMarkCardUpdate", "Lmqq/util/WeakReference;", "Lh61/d;", "d", "Lmqq/util/WeakReference;", "partRef", "intimateAIOPart", "<init>", "(Lh61/d;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends com.tencent.mobileqq.friends.intimate.d {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<d> partRef;

        public b(@NotNull d intimateAIOPart) {
            Intrinsics.checkNotNullParameter(intimateAIOPart, "intimateAIOPart");
            this.partRef = new WeakReference<>(intimateAIOPart);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onBandIntimateRelationship(boolean isSuccess, @Nullable String friendUin) {
            d dVar = this.partRef.get();
            if (dVar != null) {
                dVar.h(isSuccess, friendUin);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friends.intimate.d
        public void onDisbandIntimateRelationship(boolean isSuccess, @Nullable String friendUin, boolean isPush) {
            d dVar = this.partRef.get();
            if (dVar != null) {
                dVar.i(isSuccess, friendUin, isPush);
            }
        }

        @Override // com.tencent.mobileqq.friends.intimate.d
        protected void onGetUpgradeIntimateInfo(boolean isSuccess, @Nullable String friendUin, @Nullable IntimateInfo intimateInfo) {
            d dVar = this.partRef.get();
            if (dVar != null) {
                dVar.j(isSuccess, friendUin, intimateInfo);
            }
        }

        @Override // com.tencent.mobileqq.friends.intimate.d
        protected void onHandleGetLoverIntimateInfo(boolean isSuccess, @Nullable Object[] objects) {
            d dVar = this.partRef.get();
            if (dVar != null) {
                dVar.k(isSuccess, objects);
            }
        }

        @Override // com.tencent.mobileqq.friends.intimate.d
        protected void onMutualMarkCardUpdate(long changedCardIndex, boolean isWear) {
            SimpleEventBus.getInstance().dispatchEvent(new MutualMarkCardUpdateEvent(changedCardIndex, isWear));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"h61/d$c", "Lcom/tencent/mobileqq/activity/aio/intimate/flingappbar/FlingAppBarLayout$c;", "Lcom/tencent/mobileqq/activity/aio/intimate/flingappbar/FlingAppBarLayout;", "appBarLayout", "", "verticalOffset", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements FlingAppBarLayout.c {
        c() {
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.b
        public void a(@Nullable FlingAppBarLayout appBarLayout, int verticalOffset) {
            boolean z16;
            MainIntimateTitlePart mainIntimateTitlePart = d.this.mTitlePart;
            if (mainIntimateTitlePart != null) {
                if (verticalOffset > (-ViewUtils.dpToPx(12.0f))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                mainIntimateTitlePart.va(z16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"h61/d$d", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZIntimateSpaceRedDotReader$GetRedPointsRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: h61.d$d, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C10416d implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceRedDotReader$GetRedPointsRsp> {
        C10416d() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable QZIntimateSpaceRedDotReader$GetRedPointsRsp rsp) {
            String str;
            if (request != null) {
                str = request.getTraceId();
            } else {
                str = null;
            }
            QLog.d("IntimateAIOPart", 1, "[requestQZoneIntimateSpaceInfo] onReceive error, isSuccess=" + isSuccess + ", retCode=" + retCode + ", errMsg=" + errMsg + ", traceId=" + str + ", friendUin=" + d.this.getMFriendUin());
            if (isSuccess && rsp != null) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo = rsp.entrance_info.get();
                Intrinsics.checkNotNullExpressionValue(qZIntimateSpaceRedDotReader$EntranceInfo, "rsp.entrance_info.get()");
                simpleEventBus.dispatchEvent(new UpdateQZoneIntimateSpaceEntranceInfoEvent(qZIntimateSpaceRedDotReader$EntranceInfo));
                MainIntimateTitlePart mainIntimateTitlePart = d.this.mTitlePart;
                if (mainIntimateTitlePart != null) {
                    mainIntimateTitlePart.Ta(rsp.entrance_info.get());
                    return;
                }
                return;
            }
            QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo2 = new QZIntimateSpaceRedDotReader$EntranceInfo();
            qZIntimateSpaceRedDotReader$EntranceInfo2.lst_publish_time.set(Long.MIN_VALUE);
            MainIntimateTitlePart mainIntimateTitlePart2 = d.this.mTitlePart;
            if (mainIntimateTitlePart2 != null) {
                mainIntimateTitlePart2.Ta(qZIntimateSpaceRedDotReader$EntranceInfo2);
            }
        }
    }

    public d(@NotNull QBaseActivity activity, @NotNull String mFriendUin, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mFriendUin, "mFriendUin");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.activity = activity;
        this.mFriendUin = mFriendUin;
        this.lifecycleOwner = lifecycleOwner;
        this.mNeedReqIntimateInfo = true;
        this.mIntimateInfoObserver = new b(this);
        c cVar = new c();
        this.mOnOffsetChangedListener = cVar;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.fco, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity).inflate(R\u2026container_refactor, null)");
        View findViewById = inflate.findViewById(R.id.if5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootViewTmp.findViewById(R.id.root_view)");
        this.rootView = findViewById;
        View findViewById2 = inflate.findViewById(R.id.xpt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootViewTmp.findViewById\u2026ntimate_bind_liaanimView)");
        this.mLIAAnimView = (LIAAnimView) findViewById2;
        IntimatePartManager intimatePartManager = new IntimatePartManager(findViewById, activity, lifecycleOwner);
        this.partManager = intimatePartManager;
        intimatePartManager.b(g());
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.b(intimatePartManager, j61.c.INSTANCE.a()).get(j61.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(\n   \u2026monViewModel::class.java)");
        this.viewModel = (j61.c) viewModel;
        j61.d.f409515a.g(mFriendUin);
        MainIntimateTitlePart mainIntimateTitlePart = new MainIntimateTitlePart(activity, findViewById);
        this.mTitlePart = mainIntimateTitlePart;
        mainIntimateTitlePart.za(mFriendUin);
        MainIntimateTitlePart mainIntimateTitlePart2 = this.mTitlePart;
        if (mainIntimateTitlePart2 != null) {
            mainIntimateTitlePart2.Ba(false, null);
        }
        MainIntimateTitlePart mainIntimateTitlePart3 = this.mTitlePart;
        if (mainIntimateTitlePart3 != null) {
            mainIntimateTitlePart3.Ea(false);
        }
        FlingAppBarLayout flingAppBarLayout = (FlingAppBarLayout) inflate.findViewById(R.id.vao);
        this.flingAppbarLayout = flingAppBarLayout;
        if (flingAppBarLayout != null) {
            flingAppBarLayout.b(cVar);
        }
    }

    private final void B() {
        VSNetworkHelper.getInstance().sendRequest(((IQZoneIntimateSpaceApi) QRoute.api(IQZoneIntimateSpaceApi.class)).getRedDotReaderRequest(System.currentTimeMillis(), true, 3, this.mFriendUin), new C10416d());
    }

    private final void C() {
        long j3;
        if (!TextUtils.isEmpty(this.mFriendUin)) {
            if (NetworkUtil.isNetworkAvailable(this.activity)) {
                try {
                    j3 = Long.parseLong(this.mFriendUin);
                } catch (NumberFormatException unused) {
                    if (QLog.isColorLevel()) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("requestTroopListWithCommonFriends, friendUin: %s", Arrays.copyOf(new Object[]{this.mFriendUin}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        QLog.d("IntimateAIOPart", 2, format);
                    }
                    j3 = 0;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                com.tencent.mobileqq.activity.contact.troop.h.f(j3, 1, (QQAppInterface) peekAppRuntime);
            } else {
                Handler handler = this.mUIHandler;
                if (handler != null) {
                    Intrinsics.checkNotNull(handler);
                    Message obtainMessage = handler.obtainMessage();
                    Intrinsics.checkNotNullExpressionValue(obtainMessage, "mUIHandler!!.obtainMessage()");
                    obtainMessage.what = 1;
                    obtainMessage.obj = this.activity.getResources().getString(R.string.hpk);
                    Handler handler2 = this.mUIHandler;
                    Intrinsics.checkNotNull(handler2);
                    handler2.sendMessage(obtainMessage);
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format("requestTroopListWithCommonFriends network is not available, uin: %s", Arrays.copyOf(new Object[]{this.mFriendUin}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    QLog.d("IntimateAIOPart", 1, format2);
                }
            }
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("requestTroopListWithCommonFriends, friendUin: %s", Arrays.copyOf(new Object[]{this.mFriendUin}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            QLog.d("IntimateAIOPart", 2, format3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void E(IntimateInfo intimateInfo) {
        List listOf;
        boolean z16;
        MainIntimateTitlePart mainIntimateTitlePart;
        MainIntimateTitlePart mainIntimateTitlePart2;
        f61.h hVar;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"buttonDescribe", "levelDescribe", "addFriendWording", "title", "typeDescribe"});
        QLog.i("IntimateAIOPart", 1, "updateIntimateInfo: " + k.f(intimateInfo, listOf));
        if (intimateInfo == null) {
            return;
        }
        this.mIntimateInfo = intimateInfo;
        int i3 = intimateInfo.maskType;
        MainIntimateTitlePart mainIntimateTitlePart3 = this.mTitlePart;
        if (mainIntimateTitlePart3 != null) {
            mainIntimateTitlePart3.Aa(intimateInfo);
        }
        MainIntimateTitlePart mainIntimateTitlePart4 = this.mTitlePart;
        if (mainIntimateTitlePart4 != null) {
            mainIntimateTitlePart4.xa(i3);
        }
        IntimateInfo intimateInfo2 = this.mIntimateInfo;
        if (intimateInfo2 != null && (hVar = intimateInfo2.mutualMarkList) != null) {
            com.tencent.mobileqq.activity.aio.intimate.header.a.f179009a.a(this.mFriendUin, hVar);
        }
        if (intimateInfo.beFriendDays >= -1) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 26) {
                            j61.d.f409515a.h(1);
                            z16 = false;
                            mainIntimateTitlePart = this.mTitlePart;
                            if (mainIntimateTitlePart != null) {
                                mainIntimateTitlePart.Ca(z16);
                            }
                            mainIntimateTitlePart2 = this.mTitlePart;
                            if (mainIntimateTitlePart2 != null) {
                                mainIntimateTitlePart2.Fa(true);
                            }
                        } else {
                            j61.d.f409515a.h(5);
                        }
                    } else {
                        j61.d.f409515a.h(4);
                    }
                } else {
                    j61.d.f409515a.h(3);
                }
            } else {
                n();
            }
            z16 = true;
            mainIntimateTitlePart = this.mTitlePart;
            if (mainIntimateTitlePart != null) {
            }
            mainIntimateTitlePart2 = this.mTitlePart;
            if (mainIntimateTitlePart2 != null) {
            }
        } else {
            MainIntimateTitlePart mainIntimateTitlePart5 = this.mTitlePart;
            if (mainIntimateTitlePart5 != null) {
                mainIntimateTitlePart5.xa(0);
            }
            i3 = 0;
        }
        MainIntimateTitlePart mainIntimateTitlePart6 = this.mTitlePart;
        if (mainIntimateTitlePart6 != null) {
            mainIntimateTitlePart6.Ha(j61.d.f409515a.e());
        }
        MainIntimateTitlePart mainIntimateTitlePart7 = this.mTitlePart;
        if (mainIntimateTitlePart7 != null) {
            mainIntimateTitlePart7.Ua(intimateInfo, false);
        }
        this.viewModel.M1().postValue(new IntimateBaseModel(intimateInfo, this.mFriendUin, i3));
        j61.d dVar = j61.d.f409515a;
        ReportController.o(null, "dc00898", "", "", "0X8009F4D", "0X8009F4D", dVar.e(), 0, "", "", "", "");
        if (dVar.e() == 2) {
            ReportController.o(null, "dc00898", "", "", "0X800A05F", "0X800A05F", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(boolean isSuccess, String friendUin) {
        boolean equals;
        QLog.d("IntimateAIOPart", 2, "onBandIntimateRelationship");
        if (!TextUtils.isEmpty(friendUin)) {
            equals = StringsKt__StringsJVMKt.equals(friendUin, this.mFriendUin, true);
            if (equals && isSuccess) {
                A();
                return;
            }
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onBandIntimateRelationship return, friendUin: %s", Arrays.copyOf(new Object[]{friendUin}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("IntimateAIOPart", 1, format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean isSuccess, String friendUin, boolean isPush) {
        boolean equals;
        if (QLog.isColorLevel()) {
            QLog.d("IntimateAIOPart", 2, "onDisbandIntimateRelationship");
        }
        if (!TextUtils.isEmpty(friendUin)) {
            equals = StringsKt__StringsJVMKt.equals(friendUin, this.mFriendUin, true);
            if (equals) {
                Handler handler = this.mUIHandler;
                if (handler != null) {
                    Message obtainMessage = handler.obtainMessage();
                    Intrinsics.checkNotNullExpressionValue(obtainMessage, "it.obtainMessage()");
                    if (!isSuccess) {
                        obtainMessage.what = 5;
                        handler.sendMessage(obtainMessage);
                        return;
                    } else {
                        if (isPush) {
                            A();
                            return;
                        }
                        obtainMessage.what = 6;
                        obtainMessage.obj = friendUin;
                        handler.sendMessage(obtainMessage);
                        return;
                    }
                }
                return;
            }
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onDisbandIntimateRelationship return, friendUin: %s", Arrays.copyOf(new Object[]{friendUin}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("IntimateAIOPart", 1, format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(boolean isSuccess, String friendUin, IntimateInfo intimateInfo) {
        boolean equals;
        if (QLog.isColorLevel()) {
            QLog.d("IntimateAIOPart", 2, "doOnGetUpgradeIntimateInfo, isSuccess=" + isSuccess + ", intimateInfo=" + intimateInfo);
        }
        if (!TextUtils.isEmpty(friendUin)) {
            equals = StringsKt__StringsJVMKt.equals(friendUin, this.mFriendUin, true);
            if (equals) {
                if (isSuccess) {
                    Handler handler = this.mUIHandler;
                    Intrinsics.checkNotNull(handler);
                    Message obtainMessage = handler.obtainMessage();
                    Intrinsics.checkNotNullExpressionValue(obtainMessage, "mUIHandler!!.obtainMessage()");
                    obtainMessage.what = 0;
                    obtainMessage.obj = intimateInfo;
                    Handler handler2 = this.mUIHandler;
                    Intrinsics.checkNotNull(handler2);
                    handler2.removeMessages(0);
                    Handler handler3 = this.mUIHandler;
                    Intrinsics.checkNotNull(handler3);
                    handler3.sendMessage(obtainMessage);
                    return;
                }
                Handler handler4 = this.mUIHandler;
                Intrinsics.checkNotNull(handler4);
                Message obtainMessage2 = handler4.obtainMessage();
                Intrinsics.checkNotNullExpressionValue(obtainMessage2, "mUIHandler!!.obtainMessage()");
                obtainMessage2.what = 1;
                obtainMessage2.obj = this.activity.getResources().getString(R.string.byt);
                Handler handler5 = this.mUIHandler;
                Intrinsics.checkNotNull(handler5);
                handler5.sendMessage(obtainMessage2);
                return;
            }
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onGetIntimateInfo return, friendUin: %s", Arrays.copyOf(new Object[]{friendUin}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("IntimateAIOPart", 1, format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(boolean isSuccess, Object[] objects) {
        if (QLog.isColorLevel()) {
            QLog.d("IntimateAIOPart", 2, "onHandleGetLoverIntimateInfo isSuccess = " + isSuccess + " data = " + objects);
        }
        if (isSuccess && objects != null && objects.length > 2) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            Object obj = objects[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            Object obj2 = objects[1];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = objects[2];
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            simpleEventBus.dispatchEvent(new GetLoverValueEvent(false, (String) obj, (String) obj2, (String) obj3));
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new GetLoverValueEvent(false, "", "", ""));
    }

    private final void n() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.e("IntimateAIOPart", 1, "handleLoverIntimateInfo fail, app is null");
            return;
        }
        j61.d dVar = j61.d.f409515a;
        dVar.h(2);
        MainIntimateTitlePart mainIntimateTitlePart = this.mTitlePart;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Fa(true);
        }
        com.tencent.mobileqq.loverzone.a.a("6", "2", "1", LpReportInfo_dc03950.getReportUserType(qQAppInterface));
        MainIntimateTitlePart mainIntimateTitlePart2 = this.mTitlePart;
        if (mainIntimateTitlePart2 != null) {
            mainIntimateTitlePart2.Ca(true);
        }
        MainIntimateTitlePart mainIntimateTitlePart3 = this.mTitlePart;
        if (mainIntimateTitlePart3 != null) {
            mainIntimateTitlePart3.Ha(dVar.e());
        }
        if (!this.mHasPreloadWeb && this.mIsOpened) {
            this.mHasPreloadWeb = true;
            y();
        }
    }

    private final void o() {
        boolean z16;
        IntimateInfo intimateInfo = this.mIntimateInfo;
        if (intimateInfo == null) {
            return;
        }
        String f16 = FriendIntimateRelationshipHelper.f(intimateInfo.maskType, intimateInfo.maskLevel);
        if (f16 != null && f16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            MainIntimateTitlePart mainIntimateTitlePart = this.mTitlePart;
            if (mainIntimateTitlePart != null) {
                mainIntimateTitlePart.Ja(f16);
                return;
            }
            return;
        }
        QQToast.makeText(this.activity, 1, HardCodeUtil.qqStr(R.string.ngg), 1).show();
    }

    private final void p() {
        HashMap<String, Object> d16 = j61.d.f409515a.d();
        d16.put("touin", this.mFriendUin);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportPageEvent("dt_pgin", "pg_aio_swipleft", d16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(d this$0) {
        QQAppInterface qQAppInterface;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TextUtils.isEmpty(this$0.mFriendUin)) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            Manager manager = qQAppInterface.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.friends.intimate.IntimateInfoManager");
            com.tencent.mobileqq.friends.intimate.c cVar = (com.tencent.mobileqq.friends.intimate.c) manager;
            IntimateInfo m3 = cVar.m(this$0.mFriendUin);
            if (!this$0.hasInitDataFromDB && m3 != null) {
                Handler handler = this$0.mUIHandler;
                Intrinsics.checkNotNull(handler);
                Message obtainMessage = handler.obtainMessage();
                Intrinsics.checkNotNullExpressionValue(obtainMessage, "mUIHandler!!.obtainMessage()");
                this$0.mIntimateInfo = m3;
                Intrinsics.checkNotNull(m3);
                if (m3.mutualMarkList == null) {
                    IntimateInfo intimateInfo = this$0.mIntimateInfo;
                    Intrinsics.checkNotNull(intimateInfo);
                    intimateInfo.mutualMarkList = com.tencent.mobileqq.activity.aio.intimate.header.a.f179009a.c(this$0.mFriendUin);
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("init cache friendUin: %s", Arrays.copyOf(new Object[]{StringUtil.getSimpleUinForPrint(this$0.mFriendUin)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.d("IntimateAIOPart", 1, format);
                IntimateInfo intimateInfo2 = this$0.mIntimateInfo;
                Intrinsics.checkNotNull(intimateInfo2);
                if (intimateInfo2.mutualMarkList == null) {
                    QLog.d("IntimateAIOPart", 1, "cache is not complet.");
                    return;
                }
                MainIntimateTitlePart mainIntimateTitlePart = this$0.mTitlePart;
                if (mainIntimateTitlePart != null) {
                    mainIntimateTitlePart.Aa(this$0.mIntimateInfo);
                }
                obtainMessage.what = 0;
                obtainMessage.obj = m3;
                Handler handler2 = this$0.mUIHandler;
                Intrinsics.checkNotNull(handler2);
                handler2.sendMessage(obtainMessage);
                this$0.hasInitDataFromDB = true;
            }
            cVar.h(FriendIntimateRelationshipConfProcessor.a().f202719o0, FriendIntimateRelationshipConfProcessor.a().f202720p0);
        }
    }

    private final void y() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(IWe\u2026va, ProcessConstant.MAIN)");
            ((IWebProcessManagerService) runtimeService).startWebProcessUnderStrategy(21, null);
        }
    }

    private final void z() {
        HashMap<String, Object> d16 = j61.d.f409515a.d();
        d16.put("touin", this.mFriendUin);
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportPageEvent("dt_pgout", "pg_aio_swipleft", d16);
    }

    public final void A() {
        QQAppInterface qQAppInterface;
        BaseBusinessHandler baseBusinessHandler;
        if (!TextUtils.isEmpty(this.mFriendUin)) {
            if (NetworkUtil.isNetworkAvailable(this.activity)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                IntimateInfoHandler intimateInfoHandler = null;
                if (peekAppRuntime instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) peekAppRuntime;
                } else {
                    qQAppInterface = null;
                }
                if (qQAppInterface != null) {
                    baseBusinessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
                } else {
                    baseBusinessHandler = null;
                }
                if (baseBusinessHandler instanceof IntimateInfoHandler) {
                    intimateInfoHandler = (IntimateInfoHandler) baseBusinessHandler;
                }
                if (intimateInfoHandler == null) {
                    QLog.e("IntimateAIOPart", 1, "requestIntimateInfo fail, IntimateInfoHandler is null");
                    return;
                }
                boolean z16 = FriendIntimateRelationshipConfProcessor.a().f202727w0;
                if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion()) {
                    intimateInfoHandler.I2(this.mFriendUin, z16);
                } else {
                    intimateInfoHandler.G2(this.mFriendUin, z16);
                }
            } else {
                Handler handler = this.mUIHandler;
                if (handler != null) {
                    Intrinsics.checkNotNull(handler);
                    Message obtainMessage = handler.obtainMessage();
                    Intrinsics.checkNotNullExpressionValue(obtainMessage, "mUIHandler!!.obtainMessage()");
                    obtainMessage.what = 1;
                    obtainMessage.obj = this.activity.getResources().getString(R.string.hpk);
                    Handler handler2 = this.mUIHandler;
                    Intrinsics.checkNotNull(handler2);
                    handler2.sendMessage(obtainMessage);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("requestIntimateInfo network is not available, uin: %s", Arrays.copyOf(new Object[]{this.mFriendUin}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    QLog.d("IntimateAIOPart", 1, format);
                }
            }
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("requestIntimateInfo, friendUin: %s", Arrays.copyOf(new Object[]{this.mFriendUin}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            QLog.d("IntimateAIOPart", 2, format2);
        }
    }

    public final void D(@NotNull com.tencent.aio.frame.api.e controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.mFrameDrawerController = controller;
    }

    @NotNull
    public final List<Part> g() {
        Long longOrNull;
        List<Part> mutableListOf;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.mFriendUin);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.activity.aio.intimate.reborn.part.e(longOrNull), new IntimateContentListPart(), new com.tencent.mobileqq.activity.aio.intimate.reborn.part.b());
        return mutableListOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ShareItemClickEvent.class, PartnerUpdateEvent.class, DoLIAAnimViewEvent.class, UpdateTitlePartCurrentTypeLevelEvent.class, RequestQZoneIntimateSpaceEntranceEvent.class);
        return arrayListOf;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        IntimateInfo intimateInfo = null;
        String str = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 6) {
                    if (i3 == 9) {
                        B();
                    }
                } else {
                    A();
                    B();
                    QQToast.makeText(this.activity, 2, R.string.byp, 1).show();
                }
            } else {
                Object obj = msg2.obj;
                if (obj instanceof String) {
                    str = (String) obj;
                }
                if (str != null) {
                    QQToast.makeText(this.activity, 1, str, 1).show();
                }
            }
        } else {
            Object obj2 = msg2.obj;
            if (obj2 instanceof IntimateInfo) {
                intimateInfo = (IntimateInfo) obj2;
            }
            E(intimateInfo);
        }
        return true;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getMFriendUin() {
        return this.mFriendUin;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final View getRootView() {
        return this.rootView;
    }

    public void onDestroy() {
        QQAppInterface qQAppInterface;
        QLog.i("IntimateAIOPart", 1, "onDestroy.");
        FlingAppBarLayout flingAppBarLayout = this.flingAppbarLayout;
        if (flingAppBarLayout != null) {
            flingAppBarLayout.r(this.mOnOffsetChangedListener);
        }
        j61.d.f409515a.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.mIntimateInfoObserver);
            this.hasAddObserver = false;
        }
        this.mFrameDrawerController = null;
        MainIntimateTitlePart mainIntimateTitlePart = this.mTitlePart;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.onDestroy();
        }
        e.f404453a.a();
        View view = this.rootView;
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
        }
        this.partManager.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof ShareItemClickEvent) {
            o();
            return;
        }
        if (event instanceof PartnerUpdateEvent) {
            MainIntimateTitlePart mainIntimateTitlePart = this.mTitlePart;
            if (mainIntimateTitlePart != null) {
                mainIntimateTitlePart.Da(((PartnerUpdateEvent) event).getIsPartner());
                return;
            }
            return;
        }
        if (event instanceof UpdateTitlePartCurrentTypeLevelEvent) {
            MainIntimateTitlePart mainIntimateTitlePart2 = this.mTitlePart;
            if (mainIntimateTitlePart2 != null) {
                UpdateTitlePartCurrentTypeLevelEvent updateTitlePartCurrentTypeLevelEvent = (UpdateTitlePartCurrentTypeLevelEvent) event;
                mainIntimateTitlePart2.Ra(updateTitlePartCurrentTypeLevelEvent.getType(), updateTitlePartCurrentTypeLevelEvent.getLevel(), updateTitlePartCurrentTypeLevelEvent.getFlag());
                return;
            }
            return;
        }
        if (event instanceof DoLIAAnimViewEvent) {
            LIAAnimView lIAAnimView = this.mLIAAnimView;
            if (lIAAnimView.r()) {
                lIAAnimView.v();
            }
            DoLIAAnimViewEvent doLIAAnimViewEvent = (DoLIAAnimViewEvent) event;
            lIAAnimView.setOnAnimActionListener(doLIAAnimViewEvent.getAniListener());
            lIAAnimView.b(doLIAAnimViewEvent.getView());
            lIAAnimView.a(doLIAAnimViewEvent.getBitmap());
            lIAAnimView.t();
            return;
        }
        if (event instanceof RequestQZoneIntimateSpaceEntranceEvent) {
            B();
        }
    }

    public final void q() {
        QQAppInterface qQAppInterface;
        if (this.mUIHandler == null) {
            this.mUIHandler = new Handler(Looper.getMainLooper(), this);
        }
        MainIntimateTitlePart mainIntimateTitlePart = this.mTitlePart;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.Ia(this.mUIHandler);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.mIntimateInfoObserver);
            this.hasAddObserver = true;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: h61.c
            @Override // java.lang.Runnable
            public final void run() {
                d.r(d.this);
            }
        }, 16, null, false);
    }

    public boolean s() {
        return e.f404453a.d();
    }

    public void t() {
        QQAppInterface qQAppInterface;
        QLog.i("IntimateAIOPart", 1, "onDrawerClosed.");
        this.mNeedReqIntimateInfo = true;
        this.partManager.e();
        e.f404453a.b();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.mIntimateInfoObserver);
            this.hasAddObserver = false;
        }
        com.tencent.mobileqq.activity.aio.intimate.b.f178912a.c();
        MainIntimateTitlePart mainIntimateTitlePart = this.mTitlePart;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.oa();
        }
        z();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void u() {
        QQAppInterface qQAppInterface;
        QLog.i("IntimateAIOPart", 1, "onDrawerOpened.");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null && !this.hasAddObserver) {
            qQAppInterface.addObserver(this.mIntimateInfoObserver);
            this.hasAddObserver = true;
        }
        this.partManager.f();
        e.f404453a.c();
        p();
    }

    public void v() {
        q();
        this.mIsOpened = true;
        this.partManager.g();
        if (!this.mNeedReqIntimateInfo) {
            return;
        }
        this.mNeedReqIntimateInfo = false;
        com.tencent.mobileqq.activity.aio.intimate.b.f178912a.d();
        A();
        C();
        B();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void w() {
        QLog.i("IntimateAIOPart", 1, "onPaused.");
        MainIntimateTitlePart mainIntimateTitlePart = this.mTitlePart;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.onPause();
        }
        this.partManager.onPause();
    }

    public void x() {
        QLog.i("IntimateAIOPart", 1, "onResumed.");
        A();
        B();
        MainIntimateTitlePart mainIntimateTitlePart = this.mTitlePart;
        if (mainIntimateTitlePart != null) {
            mainIntimateTitlePart.onResume();
        }
        this.partManager.onResume();
    }
}
