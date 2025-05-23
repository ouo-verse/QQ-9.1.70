package k61;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.activity.aio.intimate.header.QZoneIntimateSpaceEntranceView;
import com.tencent.mobileqq.activity.aio.intimate.headerv2.HeaderProgressBar;
import com.tencent.mobileqq.activity.aio.intimate.headerv2.f;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.PartnerUpdateEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.RequestQZoneIntimateSpaceEntranceEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.UpdateQZoneIntimateSpaceEntranceInfoEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.UpdateTitlePartCurrentTypeLevelEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.intimate.EdgeTransparentView;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qzone.QZIntimateSpaceRedDotReader$EntranceInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0002\u008a\u0001\u0018\u0000 \u008f\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0090\u0001B\t\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0002J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J(\u0010 \u001a\u00020\u001f2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u001bj\b\u0012\u0004\u0012\u00020\u0011`\u001c2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0012\u0010#\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014J\b\u0010$\u001a\u00020\rH\u0016J\u0016\u0010'\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0006J*\u0010-\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020\u00112\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010+H\u0014J\u0012\u0010/\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003000\u001bH\u0016J\b\u00102\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020\rH\u0016R\u001e\u00108\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R2\u0010?\u001a\u001e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;09j\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;`<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R$\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u001bj\b\u0012\u0004\u0012\u00020\u000f`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010IR\u0016\u0010L\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010VR\u0016\u0010X\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010DR\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ZR\u0016\u0010]\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010FR\u0016\u0010_\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010\\R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010bR\u0016\u0010h\u001a\u00020f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010oR\u0016\u0010t\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010oR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010~R\u001a\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0017\u0010\u008c\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bF\u0010\u008b\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lk61/o;", "Lk61/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "tag", "", "url", "", "y", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "isFriendIntimateType", "", "G", "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "targetModel", "", "level", "iconUrl", "N", BdhLogUtil.LogTag.Tag_Conn, "type", "lightUpDays", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "O", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "scores", LocalPhotoFaceInfo.SCORE, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "containerView", "onInitView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "updateType", "from", "H", "Lj61/a;", "data", "position", "", "payload", "D", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lf61/j;", "e", "Ljava/util/List;", "mPartnerInfos", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/mutualmark/model/MutualMarkModel;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "mMutualMarkModels", tl.h.F, "Ljava/util/ArrayList;", "mModels", "i", "I", "mIntimateRealDays", "Z", "mIsPartner", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/n;", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/n;", "mRecyclerViewDecoration", "Ljava/lang/String;", "friendUin", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f;", "E", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f;", "mCardAdapter", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/g;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/g;", "mCardTipsAdapter", "Lcom/tencent/mobileqq/data/IntimateInfo;", "Lcom/tencent/mobileqq/data/IntimateInfo;", "intimateInfo", "friendIntimateType", "Lqzone/QZIntimateSpaceRedDotReader$EntranceInfo;", "Lqzone/QZIntimateSpaceRedDotReader$EntranceInfo;", "mQZoneIntimateEntranceInfo", "J", "mIsInited", "K", "mSelectedType", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "L", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "mIvSelfHead", "M", "mIvFriendHead", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/HeaderProgressBar;", "P", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/HeaderProgressBar;", "mHeaderProgressBar", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/TextView;", "mTvRelationshipName", BdhLogUtil.LogTag.Tag_Req, "mTvLevel", ExifInterface.LATITUDE_SOUTH, "mTvRelationshipDay", "Lcom/tencent/mobileqq/activity/aio/intimate/header/QZoneIntimateSpaceEntranceView;", "T", "Lcom/tencent/mobileqq/activity/aio/intimate/header/QZoneIntimateSpaceEntranceView;", "mQZoneIntimateSpaceEntranceView", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerImageView;", "U", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerImageView;", "mIvIntimate", "V", "Landroid/view/View;", "mCardView", "W", "mViewNightCover", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "X", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "mDownToUpViewSwitcher", "Lcom/tencent/mobileqq/intimate/EdgeTransparentView;", "Y", "Lcom/tencent/mobileqq/intimate/EdgeTransparentView;", "mCoverView", "k61/o$b", "Lk61/o$b;", "mAnimationListener", "<init>", "()V", "a0", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class o extends k61.d implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.activity.aio.intimate.headerv2.n mRecyclerViewDecoration;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private IntimateInfo intimateInfo;

    /* renamed from: H, reason: from kotlin metadata */
    private int friendIntimateType;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QZIntimateSpaceRedDotReader$EntranceInfo mQZoneIntimateEntranceInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsInited;

    /* renamed from: L, reason: from kotlin metadata */
    private QQProAvatarView mIvSelfHead;

    /* renamed from: M, reason: from kotlin metadata */
    private QQProAvatarView mIvFriendHead;

    /* renamed from: N, reason: from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private HeaderProgressBar mHeaderProgressBar;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView mTvRelationshipName;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView mTvLevel;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView mTvRelationshipDay;

    /* renamed from: T, reason: from kotlin metadata */
    private QZoneIntimateSpaceEntranceView mQZoneIntimateSpaceEntranceView;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private QUIShimmerImageView mIvIntimate;

    /* renamed from: V, reason: from kotlin metadata */
    private View mCardView;

    /* renamed from: W, reason: from kotlin metadata */
    private View mViewNightCover;

    /* renamed from: X, reason: from kotlin metadata */
    private DownToUpViewSwitcher mDownToUpViewSwitcher;

    /* renamed from: Y, reason: from kotlin metadata */
    private EdgeTransparentView mCoverView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<f61.j> mPartnerInfos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mIntimateRealDays;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPartner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Long, MutualMarkModel> mMutualMarkModels = new HashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g> mModels = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String friendUin = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.aio.intimate.headerv2.f mCardAdapter = new com.tencent.mobileqq.activity.aio.intimate.headerv2.f();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.aio.intimate.headerv2.g mCardTipsAdapter = new com.tencent.mobileqq.activity.aio.intimate.headerv2.g();

    /* renamed from: K, reason: from kotlin metadata */
    private long mSelectedType = -1;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final b mAnimationListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.mobileqq.activity.aio.intimate.header.g) t16).getLightUpTime()), Long.valueOf(((com.tencent.mobileqq.activity.aio.intimate.header.g) t17).getLightUpTime()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"k61/o$d", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f$c;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "", "position", "", "type", "", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f411752a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o f411753b;

        d(View view, o oVar) {
            this.f411752a = view;
            this.f411753b = oVar;
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.headerv2.f.c
        public void a(@NotNull String clickType, int position, long type) {
            Map mutableMapOf;
            Map mutableMapOf2;
            Intrinsics.checkNotNullParameter(clickType, "clickType");
            int hashCode = clickType.hashCode();
            if (hashCode != -262788940) {
                if (hashCode != -262766713) {
                    if (hashCode == 446368399 && clickType.equals("CLICK_EMOJI")) {
                        IntimateHeaderCardUtil.a((int) type, this.f411753b.friendUin);
                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("relationship_type", Long.valueOf(type)), TuplesKt.to("interaction_type", "1"));
                        IntimateHeaderCardUtil.U("qq_clck", "pg_aio_swipleft", "em_bas_swipleft_card", new HashMap(mutableMapOf2));
                        return;
                    }
                    return;
                }
                if (clickType.equals("CLICK_CARD")) {
                    this.f411753b.H((int) type, "clickCard");
                    this.f411753b.mSelectedType = type;
                    return;
                }
                return;
            }
            if (clickType.equals("CLICK_BIND")) {
                com.tencent.mobileqq.activity.aio.intimate.e.g(this.f411752a.getContext(), this.f411753b.friendUin, type);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("relationship_type", Long.valueOf(type)), TuplesKt.to("interaction_type", "3"));
                IntimateHeaderCardUtil.U("qq_clck", "pg_aio_swipleft", "em_bas_swipleft_card", new HashMap(mutableMapOf));
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.headerv2.f.c
        public void b(long type) {
            this.f411753b.H((int) type, "onItemUpdate");
            this.f411753b.mSelectedType = type;
        }
    }

    private final float A(ArrayList<Integer> scores, int score) {
        List drop;
        String joinToString$default;
        if (score >= 6000) {
            return 1.0f;
        }
        if (scores.size() <= 3) {
            drop = CollectionsKt___CollectionsKt.drop(scores, 1);
        } else {
            List<Integer> subList = scores.subList(0, 3);
            Intrinsics.checkNotNullExpressionValue(subList, "scores.subList(0, 3)");
            drop = CollectionsKt___CollectionsKt.drop(subList, 1);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(drop);
        arrayList.add(6000);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
        QLog.i("IntimateHeaderSection", 1, "realscores " + joinToString$default);
        Object obj = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "realScores[0]");
        if (score < ((Number) obj).intValue()) {
            Intrinsics.checkNotNullExpressionValue(arrayList.get(0), "realScores[0]");
            return (score * 1.0f) / (((Number) r1).intValue() * 3);
        }
        Object obj2 = arrayList.get(1);
        Intrinsics.checkNotNullExpressionValue(obj2, "realScores[1]");
        if (score < ((Number) obj2).intValue()) {
            Intrinsics.checkNotNullExpressionValue(arrayList.get(0), "realScores[0]");
            float intValue = (score - ((Number) r0).intValue()) * 1.0f;
            int intValue2 = ((Number) arrayList.get(1)).intValue();
            Intrinsics.checkNotNullExpressionValue(arrayList.get(0), "realScores[0]");
            return (intValue / ((intValue2 - ((Number) r2).intValue()) * 3.0f)) + 0.33333334f;
        }
        Object obj3 = arrayList.get(2);
        Intrinsics.checkNotNullExpressionValue(obj3, "realScores[2]");
        if (score >= ((Number) obj3).intValue()) {
            return 1.0f;
        }
        Intrinsics.checkNotNullExpressionValue(arrayList.get(1), "realScores[1]");
        float intValue3 = (score - ((Number) r3).intValue()) * 1.0f;
        int intValue4 = ((Number) arrayList.get(2)).intValue();
        Intrinsics.checkNotNullExpressionValue(arrayList.get(1), "realScores[1]");
        return (intValue3 / ((intValue4 - ((Number) r2).intValue()) * 3.0f)) + 0.6666667f;
    }

    private final int B(int type, int lightUpDays) {
        IntimateInfo intimateInfo = this.intimateInfo;
        if (intimateInfo == null) {
            return lightUpDays;
        }
        if (type == 0) {
            Intrinsics.checkNotNull(intimateInfo);
            int i3 = intimateInfo.beFriendDays + 1;
            this.mIntimateRealDays = i3;
            return i3;
        }
        if (IntimateHeaderCardUtil.O(type)) {
            this.mIntimateRealDays = lightUpDays;
        }
        return lightUpDays;
    }

    private final void C() {
        if (this.intimateInfo == null) {
            return;
        }
        this.mModels.clear();
        this.mIsPartner = false;
        IntimateInfo intimateInfo = this.intimateInfo;
        Intrinsics.checkNotNull(intimateInfo);
        Iterator<MutualMarkModel> it = intimateInfo.mutualMarkList.f397922c.iterator();
        while (it.hasNext()) {
            MutualMarkModel next = it.next();
            if (next.N && (IntimateHeaderCardUtil.O((int) next.D) || (next.X & 64) != 0)) {
                long j3 = next.D;
                int i3 = (int) j3;
                int i16 = (int) next.H;
                int z16 = z((int) j3, (int) next.V);
                Iterator<MutualMarkModel> it5 = it;
                int B = B((int) next.D, (int) next.V);
                long j16 = next.W;
                int i17 = (int) next.L;
                long j17 = next.X;
                String str = next.f252155a0;
                if (str == null) {
                    str = "";
                }
                com.tencent.mobileqq.activity.aio.intimate.header.g gVar = new com.tencent.mobileqq.activity.aio.intimate.header.g(i3, i16, z16, B, j16, i17, j17, str);
                if ((next.X & 64) != 0) {
                    SimpleEventBus.getInstance().dispatchEvent(new PartnerUpdateEvent(true));
                    this.mIsPartner = true;
                }
                this.mModels.add(gVar);
                it = it5;
            }
        }
        if (this.mModels.isEmpty()) {
            IntimateInfo intimateInfo2 = this.intimateInfo;
            Intrinsics.checkNotNull(intimateInfo2);
            int i18 = intimateInfo2.maskType;
            IntimateInfo intimateInfo3 = this.intimateInfo;
            Intrinsics.checkNotNull(intimateInfo3);
            int i19 = intimateInfo3.maskLevel;
            IntimateInfo intimateInfo4 = this.intimateInfo;
            Intrinsics.checkNotNull(intimateInfo4);
            int z17 = z(intimateInfo4.maskType, 0);
            IntimateInfo intimateInfo5 = this.intimateInfo;
            Intrinsics.checkNotNull(intimateInfo5);
            int B2 = B(intimateInfo5.maskType, 0);
            IntimateInfo intimateInfo6 = this.intimateInfo;
            Intrinsics.checkNotNull(intimateInfo6);
            this.mModels.add(new com.tencent.mobileqq.activity.aio.intimate.header.g(i18, i19, z17, B2, 0L, intimateInfo6.scoreCardInfo.score, 0L, ""));
        }
        ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g> arrayList = this.mModels;
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new c());
        }
        com.tencent.mobileqq.activity.aio.intimate.header.a aVar = com.tencent.mobileqq.activity.aio.intimate.header.a.f179009a;
        LruCache<String, ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g>> d16 = aVar.d();
        IntimateInfo intimateInfo7 = this.intimateInfo;
        Intrinsics.checkNotNull(intimateInfo7);
        if (d16.get(intimateInfo7.friendUin) != null) {
            LruCache<String, ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g>> d17 = aVar.d();
            IntimateInfo intimateInfo8 = this.intimateInfo;
            Intrinsics.checkNotNull(intimateInfo8);
            d17.remove(intimateInfo8.friendUin);
        }
        ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g> g16 = com.tencent.mobileqq.activity.aio.intimate.header.a.g(this.mModels);
        LruCache<String, ArrayList<com.tencent.mobileqq.activity.aio.intimate.header.g>> d18 = aVar.d();
        IntimateInfo intimateInfo9 = this.intimateInfo;
        Intrinsics.checkNotNull(intimateInfo9);
        d18.put(intimateInfo9.friendUin, g16);
        Iterator<T> it6 = this.mModels.iterator();
        while (it6.hasNext()) {
            QLog.i("IntimateHeaderSection", 1, "obtainModelsFromIntimateInfo:" + ((com.tencent.mobileqq.activity.aio.intimate.header.g) it6.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCardAdapter.V0();
        this$0.mCardAdapter.S0(this$0.mSelectedType);
    }

    private final void G(Resources resources, boolean isFriendIntimateType) {
        ColorStateList colorStateList;
        if (isFriendIntimateType) {
            colorStateList = resources.getColorStateList(R.color.qui_common_text_allwhite_primary);
        } else {
            colorStateList = resources.getColorStateList(R.color.qui_common_text_primary);
        }
        Intrinsics.checkNotNullExpressionValue(colorStateList, "if (isFriendIntimateType\u2026n_text_primary)\n        }");
        TextView textView = this.mTvRelationshipName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationshipName");
            textView = null;
        }
        textView.setTextColor(colorStateList);
        TextView textView3 = this.mTvRelationshipDay;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationshipDay");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mCardAdapter.V0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void K(Ref.ObjectRef targetModel, o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(targetModel, "$targetModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        intimateHeaderCardUtil.J(context, ((com.tencent.mobileqq.activity.aio.intimate.header.g) targetModel.element).getType(), this$0.friendUin);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.activity.aio.intimate.e.h(str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.activity.aio.intimate.e.h(this$0.friendUin);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void N(com.tencent.mobileqq.activity.aio.intimate.header.g targetModel, int level, String iconUrl) {
        List<MutualMarkModel.Graded> list;
        MutualMarkModel.Graded graded;
        boolean z16;
        int i3;
        Integer n3;
        boolean z17;
        Object lastOrNull;
        MutualMarkModel mutualMarkModel = this.mMutualMarkModels.get(Long.valueOf(targetModel.getType()));
        TextView textView = null;
        if (mutualMarkModel != null) {
            list = mutualMarkModel.Y;
        } else {
            list = null;
        }
        if (list != null) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
            graded = (MutualMarkModel.Graded) lastOrNull;
        } else {
            graded = null;
        }
        int i16 = 0;
        if (graded != null && graded.f252170f == 1 && list.size() == 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && graded != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            int type = targetModel.getType();
            int size = list.size();
            int i17 = 0;
            for (MutualMarkModel.Graded graded2 : list) {
                arrayList2.add(Integer.valueOf(graded2.f252170f));
                arrayList.add(Float.valueOf((i17 * 1.0f) / size));
                arrayList3.add(IntimateHeaderCardUtil.c(type, graded2.f252168d));
                i17++;
            }
            TextView textView2 = this.mTvLevel;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLevel");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.mTvLevel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLevel");
            } else {
                textView = textView3;
            }
            textView.setText("Lv" + level);
            float A = A(arrayList2, targetModel.getScores());
            Pair<Integer, Integer> E = IntimateHeaderCardUtil.E(targetModel.getType());
            com.tencent.mobileqq.activity.aio.intimate.header.l lVar = com.tencent.mobileqq.activity.aio.intimate.header.l.f179061a;
            int g16 = lVar.g(this.friendUin, type);
            float A2 = A(arrayList2, g16);
            if (g16 != 0 && g16 != targetModel.getScores()) {
                if (A2 == A) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    if (g16 > targetModel.getScores()) {
                        i16 = 2;
                        i3 = i16;
                        float f16 = A2;
                        lVar.n(this.friendUin, type, targetModel.getScores());
                        QLog.i("IntimateHeaderSection", 1, "updateLevelAndProgress type " + targetModel.getType() + " level " + targetModel.getLevel() + " scores " + targetModel.getScores() + " oldScores " + g16 + " progress " + A + " oldRate " + f16);
                        n3 = IntimateHeaderCardUtil.n(targetModel.getType());
                        if (n3 != null) {
                            int intValue = n3.intValue();
                            HeaderProgressBar headerProgressBar = this.mHeaderProgressBar;
                            if (headerProgressBar != null) {
                                HeaderProgressBar.setData$default(headerProgressBar, targetModel.getType(), A, i3, f16, iconUrl, intValue, E, arrayList, arrayList3, false, 512, null);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    i3 = 1;
                    float f162 = A2;
                    lVar.n(this.friendUin, type, targetModel.getScores());
                    QLog.i("IntimateHeaderSection", 1, "updateLevelAndProgress type " + targetModel.getType() + " level " + targetModel.getLevel() + " scores " + targetModel.getScores() + " oldScores " + g16 + " progress " + A + " oldRate " + f162);
                    n3 = IntimateHeaderCardUtil.n(targetModel.getType());
                    if (n3 != null) {
                    }
                }
            }
            A2 = 0.0f;
            i3 = i16;
            float f1622 = A2;
            lVar.n(this.friendUin, type, targetModel.getScores());
            QLog.i("IntimateHeaderSection", 1, "updateLevelAndProgress type " + targetModel.getType() + " level " + targetModel.getLevel() + " scores " + targetModel.getScores() + " oldScores " + g16 + " progress " + A + " oldRate " + f1622);
            n3 = IntimateHeaderCardUtil.n(targetModel.getType());
            if (n3 != null) {
            }
        } else {
            TextView textView4 = this.mTvLevel;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLevel");
            } else {
                textView = textView4;
            }
            textView.setVisibility(4);
            HeaderProgressBar headerProgressBar2 = this.mHeaderProgressBar;
            if (headerProgressBar2 != null) {
                headerProgressBar2.setVisibility(4);
            }
            HeaderProgressBar headerProgressBar3 = this.mHeaderProgressBar;
            if (headerProgressBar3 != null) {
                headerProgressBar3.setType(-1);
            }
        }
    }

    private final void O() {
        QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo;
        if (!this.mIsInited || (qZIntimateSpaceRedDotReader$EntranceInfo = this.mQZoneIntimateEntranceInfo) == null) {
            return;
        }
        QZoneIntimateSpaceEntranceView qZoneIntimateSpaceEntranceView = this.mQZoneIntimateSpaceEntranceView;
        QZoneIntimateSpaceEntranceView qZoneIntimateSpaceEntranceView2 = null;
        if (qZoneIntimateSpaceEntranceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZoneIntimateSpaceEntranceView");
            qZoneIntimateSpaceEntranceView = null;
        }
        qZoneIntimateSpaceEntranceView.setUse8996UI(true);
        QZoneIntimateSpaceEntranceView qZoneIntimateSpaceEntranceView3 = this.mQZoneIntimateSpaceEntranceView;
        if (qZoneIntimateSpaceEntranceView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZoneIntimateSpaceEntranceView");
        } else {
            qZoneIntimateSpaceEntranceView2 = qZoneIntimateSpaceEntranceView3;
        }
        qZoneIntimateSpaceEntranceView2.setData(qZIntimateSpaceRedDotReader$EntranceInfo);
    }

    private final boolean y(Object tag, String url) {
        if (tag == null) {
            return true;
        }
        if ((tag instanceof String) && !Intrinsics.areEqual(tag, url)) {
            return true;
        }
        return false;
    }

    private final int z(int type, int lightUpDays) {
        int coerceAtLeast;
        if (this.intimateInfo == null) {
            return lightUpDays;
        }
        if (type == 0 || IntimateHeaderCardUtil.O(type)) {
            IntimateInfo intimateInfo = this.intimateInfo;
            Intrinsics.checkNotNull(intimateInfo);
            if (intimateInfo.beFriendDays > 0) {
                IntimateInfo intimateInfo2 = this.intimateInfo;
                Intrinsics.checkNotNull(intimateInfo2);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, intimateInfo2.lastAnimAfterFriendDays);
                return coerceAtLeast;
            }
        }
        return lightUpDays;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        List<f61.j> list;
        List<f61.j> list2;
        f61.h hVar;
        List<MutualMarkModel> list3;
        f61.h hVar2;
        if (data == null) {
            return;
        }
        this.friendUin = data.getFriendUin();
        this.intimateInfo = data.getIntimateInfo();
        this.friendIntimateType = data.getFriendIntimateType();
        IntimateInfo intimateInfo = this.intimateInfo;
        if (intimateInfo == null) {
            return;
        }
        Intrinsics.checkNotNull(intimateInfo);
        if (intimateInfo.beFriendDays < 0) {
            return;
        }
        IntimateInfo intimateInfo2 = this.intimateInfo;
        View view = null;
        if (intimateInfo2 != null && (hVar2 = intimateInfo2.mutualMarkList) != null) {
            list = hVar2.f397927h;
        } else {
            list = null;
        }
        this.mPartnerInfos = list;
        if (intimateInfo2 != null && (hVar = intimateInfo2.mutualMarkList) != null && (list3 = hVar.f397922c) != null) {
            for (MutualMarkModel model : list3) {
                HashMap<Long, MutualMarkModel> hashMap = this.mMutualMarkModels;
                Long valueOf = Long.valueOf(model.D);
                Intrinsics.checkNotNullExpressionValue(model, "model");
                hashMap.put(valueOf, model);
            }
        }
        IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
        IntimateInfo intimateInfo3 = this.intimateInfo;
        Intrinsics.checkNotNull(intimateInfo3);
        intimateHeaderCardUtil.V(intimateInfo3);
        C();
        if (this.mSelectedType == -1) {
            this.mSelectedType = com.tencent.mobileqq.activity.aio.intimate.header.a.f179009a.b(this.friendUin);
        }
        List<f61.j> list4 = this.mPartnerInfos;
        if (list4 != null) {
            this.mCardAdapter.Q0(this.friendUin);
            this.mCardAdapter.S0(this.mSelectedType);
            this.mCardAdapter.setData(list4);
            com.tencent.mobileqq.activity.aio.intimate.headerv2.n nVar = this.mRecyclerViewDecoration;
            if (nVar != null) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                    recyclerView = null;
                }
                recyclerView.removeItemDecoration(nVar);
            }
            com.tencent.mobileqq.activity.aio.intimate.headerv2.n nVar2 = new com.tencent.mobileqq.activity.aio.intimate.headerv2.n(ViewUtils.dpToPx(28.0f), ViewUtils.dpToPx(8.0f));
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                recyclerView2 = null;
            }
            recyclerView2.addItemDecoration(nVar2);
            this.mRecyclerViewDecoration = nVar2;
            if (!list4.isEmpty()) {
                int id5 = (int) list4.get(0).getId();
                if (this.mSelectedType != -1 && (list2 = this.mPartnerInfos) != null) {
                    for (f61.j jVar : list2) {
                        if (((int) jVar.getId()) == ((int) this.mSelectedType)) {
                            if (jVar.getIsBind()) {
                                id5 = (int) this.mSelectedType;
                            } else {
                                this.mSelectedType = id5;
                                RecyclerView recyclerView3 = this.mRecyclerView;
                                if (recyclerView3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                                    recyclerView3 = null;
                                }
                                recyclerView3.post(new Runnable() { // from class: k61.j
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        o.F(o.this);
                                    }
                                });
                            }
                        }
                    }
                }
                H(id5, "bindData");
            }
        }
        if (this.mCardView != null) {
            QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
            View view2 = this.mCardView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCardView");
            } else {
                view = view2;
            }
            qQProAvatarDrawable.q(view.getContext(), 1, this.friendUin);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v18, types: [com.tencent.mobileqq.activity.aio.intimate.header.g, T] */
    public final void H(int updateType, @NotNull String from) {
        int i3;
        int level;
        String str;
        final String str2;
        f61.j jVar;
        Intrinsics.checkNotNullParameter(from, "from");
        if (this.mModels.isEmpty()) {
            return;
        }
        QLog.d("IntimateHeaderSection", 1, "from " + from);
        List<f61.j> list = this.mPartnerInfos;
        QQProAvatarView qQProAvatarView = null;
        if (list != null) {
            i3 = updateType;
            int i16 = 0;
            for (Object obj : list) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                f61.j jVar2 = (f61.j) obj;
                if (((int) jVar2.getId()) == i3 && !jVar2.getIsBind()) {
                    List<f61.j> list2 = this.mPartnerInfos;
                    if (list2 != null && (jVar = list2.get(0)) != null) {
                        i3 = (int) jVar.getId();
                        RecyclerView recyclerView = this.mRecyclerView;
                        if (recyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                            recyclerView = null;
                        }
                        recyclerView.post(new Runnable() { // from class: k61.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                o.J(o.this);
                            }
                        });
                    } else {
                        return;
                    }
                }
                i16 = i17;
            }
        } else {
            i3 = updateType;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Iterator<com.tencent.mobileqq.activity.aio.intimate.header.g> it = this.mModels.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.activity.aio.intimate.header.g next = it.next();
            if (next.getType() == i3) {
                objectRef.element = next;
            }
        }
        if (objectRef.element == 0) {
            return;
        }
        boolean e16 = com.tencent.mobileqq.activity.aio.intimate.e.e(((com.tencent.mobileqq.activity.aio.intimate.header.g) r6).getType());
        TextView textView = this.mTvRelationshipName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationshipName");
            textView = null;
        }
        textView.setText(IntimateHeaderCardUtil.o(((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getType(), ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getLevel()));
        if (e16) {
            level = ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getLevel() + 1;
        } else {
            level = ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getLevel();
        }
        String str3 = HardCodeUtil.qqStr(R.string.f161071wq) + IntimateHeaderCardUtil.o(i3, level);
        TextView textView2 = this.mTvRelationshipDay;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationshipDay");
            textView2 = null;
        }
        if (((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getRealDays() >= 1) {
            str3 = "\u5df2\u7ed1\u5b9a" + ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getRealDays() + "\u5929";
        }
        textView2.setText(str3);
        QZoneIntimateSpaceEntranceView qZoneIntimateSpaceEntranceView = this.mQZoneIntimateSpaceEntranceView;
        if (qZoneIntimateSpaceEntranceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZoneIntimateSpaceEntranceView");
            qZoneIntimateSpaceEntranceView = null;
        }
        qZoneIntimateSpaceEntranceView.setIntimateHeaderType(((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getType());
        DownToUpViewSwitcher downToUpViewSwitcher = this.mDownToUpViewSwitcher;
        if (downToUpViewSwitcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDownToUpViewSwitcher");
            downToUpViewSwitcher = null;
        }
        downToUpViewSwitcher.setVisibility(4);
        ArrayList arrayList = new ArrayList();
        if (((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getScores() > 0) {
            arrayList.add("\u5bc6\u53cb\u503c" + ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getScores() + "\u5206");
            DownToUpViewSwitcher downToUpViewSwitcher2 = this.mDownToUpViewSwitcher;
            if (downToUpViewSwitcher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDownToUpViewSwitcher");
                downToUpViewSwitcher2 = null;
            }
            downToUpViewSwitcher2.setOnClickListener(new View.OnClickListener() { // from class: k61.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.K(Ref.ObjectRef.this, this, view);
                }
            });
            DownToUpViewSwitcher downToUpViewSwitcher3 = this.mDownToUpViewSwitcher;
            if (downToUpViewSwitcher3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDownToUpViewSwitcher");
                downToUpViewSwitcher3 = null;
            }
            downToUpViewSwitcher3.setVisibility(0);
        }
        List<f61.j> list3 = this.mPartnerInfos;
        if (list3 != null) {
            for (f61.j jVar3 : list3) {
                if (((int) jVar3.getId()) == i3 && !TextUtils.isEmpty(jVar3.getStatusIntro())) {
                    arrayList.add(jVar3.getStatusIntro());
                    DownToUpViewSwitcher downToUpViewSwitcher4 = this.mDownToUpViewSwitcher;
                    if (downToUpViewSwitcher4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDownToUpViewSwitcher");
                        downToUpViewSwitcher4 = null;
                    }
                    downToUpViewSwitcher4.setVisibility(0);
                }
            }
        }
        this.mCardTipsAdapter.l0(arrayList, e16);
        Triple<Integer, Integer, Integer> m3 = IntimateHeaderCardUtil.m(((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getType());
        View view = this.mCardView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardView");
            view = null;
        }
        int intValue = m3.getFirst().intValue();
        Integer second = m3.getSecond();
        int intValue2 = m3.getThird().intValue();
        IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
        view.setBackground(ViewUtils.createGradientDrawable(intValue, second, intValue2, intimateHeaderCardUtil.l(), intimateHeaderCardUtil.i(), 0, null));
        com.tencent.mobileqq.activity.aio.intimate.header.l lVar = com.tencent.mobileqq.activity.aio.intimate.header.l.f179061a;
        int f16 = lVar.f(this.friendUin, ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getType());
        if (f16 != -1 && f16 != ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getLevel()) {
            str = IntimateHeaderCardUtil.c(((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getType(), f16);
        } else {
            str = null;
        }
        String c16 = IntimateHeaderCardUtil.c(((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getType(), ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getLevel());
        QUIShimmerImageView qUIShimmerImageView = this.mIvIntimate;
        if (qUIShimmerImageView != null) {
            if (!TextUtils.isEmpty(str)) {
                if (y(qUIShimmerImageView.getTag(), str)) {
                    qUIShimmerImageView.setTag(str);
                    Intrinsics.checkNotNull(str);
                    IntimateHeaderCardUtil.X(qUIShimmerImageView, str, new ColorDrawable(0));
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                he0.b.l(alphaAnimation, R.anim.f154985us);
                this.mAnimationListener.b(c16);
                this.mAnimationListener.c(((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getType());
                alphaAnimation.setAnimationListener(this.mAnimationListener);
                qUIShimmerImageView.startAnimation(alphaAnimation);
            } else if (y(qUIShimmerImageView.getTag(), c16)) {
                qUIShimmerImageView.setTag(c16);
                IntimateHeaderCardUtil.X(qUIShimmerImageView, c16, new ColorDrawable(0));
            }
        }
        N((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element, level, c16);
        View view2 = this.mCardView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardView");
            view2 = null;
        }
        Resources resources = view2.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "mCardView.context.resources");
        G(resources, e16);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentAccountUin();
        } else {
            str2 = null;
        }
        QQProAvatarView qQProAvatarView2 = this.mIvSelfHead;
        if (qQProAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvSelfHead");
            qQProAvatarView2 = null;
        }
        qQProAvatarView2.w(1, str2);
        QQProAvatarView qQProAvatarView3 = this.mIvSelfHead;
        if (qQProAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvSelfHead");
            qQProAvatarView3 = null;
        }
        qQProAvatarView3.setOnClickListener(new View.OnClickListener() { // from class: k61.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                o.L(str2, view3);
            }
        });
        QQProAvatarView qQProAvatarView4 = this.mIvFriendHead;
        if (qQProAvatarView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvFriendHead");
            qQProAvatarView4 = null;
        }
        qQProAvatarView4.w(1, this.friendUin);
        QQProAvatarView qQProAvatarView5 = this.mIvFriendHead;
        if (qQProAvatarView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvFriendHead");
        } else {
            qQProAvatarView = qQProAvatarView5;
        }
        qQProAvatarView.setOnClickListener(new View.OnClickListener() { // from class: k61.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                o.M(o.this, view3);
            }
        });
        lVar.m(this.friendUin, ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getType(), ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getLevel());
        SimpleEventBus.getInstance().dispatchEvent(new UpdateTitlePartCurrentTypeLevelEvent(i3, ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getLevel(), ((com.tencent.mobileqq.activity.aio.intimate.header.g) objectRef.element).getFlag()));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UpdateQZoneIntimateSpaceEntranceInfoEvent.class);
        return arrayListOf;
    }

    @Override // k61.d, h61.a
    public void k() {
        super.k();
        QUIShimmerImageView qUIShimmerImageView = this.mIvIntimate;
        if (qUIShimmerImageView != null) {
            qUIShimmerImageView.startShimming(null);
        }
    }

    @Override // k61.d, h61.a
    public void m() {
        HeaderProgressBar headerProgressBar = this.mHeaderProgressBar;
        if (headerProgressBar != null) {
            headerProgressBar.N0();
        }
        super.m();
        com.tencent.mobileqq.activity.aio.intimate.header.a.f179009a.f(this.friendUin, this.mSelectedType);
        QZoneIntimateSpaceEntranceView qZoneIntimateSpaceEntranceView = this.mQZoneIntimateSpaceEntranceView;
        if (qZoneIntimateSpaceEntranceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZoneIntimateSpaceEntranceView");
            qZoneIntimateSpaceEntranceView = null;
        }
        qZoneIntimateSpaceEntranceView.r0();
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QZoneIntimateSpaceEntranceView qZoneIntimateSpaceEntranceView = this.mQZoneIntimateSpaceEntranceView;
        if (qZoneIntimateSpaceEntranceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZoneIntimateSpaceEntranceView");
            qZoneIntimateSpaceEntranceView = null;
        }
        qZoneIntimateSpaceEntranceView.r0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView == null) {
            return;
        }
        View findViewById = containerView.findViewById(R.id.tor);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.cardview)");
        this.mCardView = findViewById;
        View findViewById2 = containerView.findViewById(R.id.f11879754);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.view_night_cover)");
        this.mViewNightCover = findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f110636j2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026.id.tv_relationship_name)");
        this.mTvRelationshipName = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f109036eq);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.tv_level)");
        this.mTvLevel = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f110626j1);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026R.id.tv_relationship_day)");
        this.mTvRelationshipDay = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.xqw);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026ne_space_header_entrance)");
        this.mQZoneIntimateSpaceEntranceView = (QZoneIntimateSpaceEntranceView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.imu);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewById(R.id.self_head_iv)");
        this.mIvSelfHead = (QQProAvatarView) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.cnr);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewById(R.id.friend_head_iv)");
        this.mIvFriendHead = (QQProAvatarView) findViewById8;
        this.mHeaderProgressBar = (HeaderProgressBar) containerView.findViewById(R.id.x8p);
        QUIShimmerImageView qUIShimmerImageView = (QUIShimmerImageView) containerView.findViewById(R.id.f165937y51);
        this.mIvIntimate = qUIShimmerImageView;
        if (qUIShimmerImageView != null) {
            qUIShimmerImageView.updateRepeatCount(1);
        }
        View view = null;
        if (FontSettingManager.getFontLevel() > 17.0f) {
            FontSettingManager.resetViewSize2Normal(containerView.getContext(), this.mIvIntimate);
            Context context = containerView.getContext();
            TextView textView = this.mTvRelationshipName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvRelationshipName");
                textView = null;
            }
            FontSettingManager.resetViewSize2Normal(context, textView);
            Context context2 = containerView.getContext();
            TextView textView2 = this.mTvRelationshipDay;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvRelationshipDay");
                textView2 = null;
            }
            FontSettingManager.resetViewSize2Normal(context2, textView2);
            Context context3 = containerView.getContext();
            TextView textView3 = this.mTvLevel;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLevel");
                textView3 = null;
            }
            FontSettingManager.resetViewSize2Normal(context3, textView3);
        }
        View findViewById9 = containerView.findViewById(R.id.f107396aa);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewBy\u2026d.tv_down_to_up_switcher)");
        this.mDownToUpViewSwitcher = (DownToUpViewSwitcher) findViewById9;
        View findViewById10 = containerView.findViewById(R.id.f788948a);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewById(R.id.rv_cover_view)");
        EdgeTransparentView edgeTransparentView = (EdgeTransparentView) findViewById10;
        this.mCoverView = edgeTransparentView;
        if (edgeTransparentView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverView");
            edgeTransparentView = null;
        }
        edgeTransparentView.setPositionAndDrawSize(4, ViewUtils.dpToPx(40.0f));
        DownToUpViewSwitcher downToUpViewSwitcher = this.mDownToUpViewSwitcher;
        if (downToUpViewSwitcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDownToUpViewSwitcher");
            downToUpViewSwitcher = null;
        }
        downToUpViewSwitcher.setAdapter(this.mCardTipsAdapter);
        if (Build.VERSION.SDK_INT >= 28) {
            TextView textView4 = this.mTvRelationshipName;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvRelationshipName");
                textView4 = null;
            }
            textView4.setFirstBaselineToTopHeight(0);
        }
        View findViewById11 = containerView.findViewById(R.id.f7882484);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "containerView.findViewById(R.id.rv_card)");
        RecyclerView recyclerView = (RecyclerView) findViewById11;
        this.mRecyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(containerView.getContext(), 0, false));
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setAdapter(this.mCardAdapter);
        this.mCardAdapter.R0(new d(containerView, this));
        if (QQTheme.isNowThemeIsNight()) {
            View view2 = this.mViewNightCover;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewNightCover");
                view2 = null;
            }
            view2.setVisibility(0);
            View view3 = this.mViewNightCover;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewNightCover");
            } else {
                view = view3;
            }
            IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
            view.setBackground(intimateHeaderCardUtil.w(intimateHeaderCardUtil.i()));
        }
        SimpleEventBus.getInstance().registerReceiver(this);
        this.mIsInited = true;
        SimpleEventBus.getInstance().dispatchEvent(new RequestQZoneIntimateSpaceEntranceEvent());
        new QQProAvatarDrawable().q(containerView.getContext(), 1, this.friendUin);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof UpdateQZoneIntimateSpaceEntranceInfoEvent) {
            this.mQZoneIntimateEntranceInfo = ((UpdateQZoneIntimateSpaceEntranceInfoEvent) event).getInfo();
            O();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"k61/o$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "", "d", "Ljava/lang/String;", "getIconUrl", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "iconUrl", "", "e", "J", "a", "()J", "c", "(J)V", "type", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String iconUrl = "";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long type = -1;

        b() {
        }

        /* renamed from: a, reason: from getter */
        public final long getType() {
            return this.type;
        }

        public final void b(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iconUrl = str;
        }

        public final void c(long j3) {
            this.type = j3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (this.type == o.this.mSelectedType && o.this.mIvIntimate != null) {
                QUIShimmerImageView qUIShimmerImageView = o.this.mIvIntimate;
                Intrinsics.checkNotNull(qUIShimmerImageView);
                IntimateHeaderCardUtil.X(qUIShimmerImageView, this.iconUrl, new ColorDrawable(0));
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                he0.b.l(alphaAnimation, R.anim.f154985us);
                QUIShimmerImageView qUIShimmerImageView2 = o.this.mIvIntimate;
                Intrinsics.checkNotNull(qUIShimmerImageView2);
                qUIShimmerImageView2.startAnimation(alphaAnimation);
                alphaAnimation.setAnimationListener(new a(o.this, alphaAnimation));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"k61/o$b$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes10.dex */
        public static final class a implements Animation.AnimationListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ o f411750e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ AlphaAnimation f411751f;

            a(o oVar, AlphaAnimation alphaAnimation) {
                this.f411750e = oVar;
                this.f411751f = alphaAnimation;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(@Nullable Animation animation) {
                if (b.this.getType() == this.f411750e.mSelectedType && this.f411750e.mIvIntimate != null) {
                    this.f411751f.cancel();
                    QUIShimmerImageView qUIShimmerImageView = this.f411750e.mIvIntimate;
                    Intrinsics.checkNotNull(qUIShimmerImageView);
                    qUIShimmerImageView.clearAnimation();
                    QUIShimmerImageView qUIShimmerImageView2 = this.f411750e.mIvIntimate;
                    Intrinsics.checkNotNull(qUIShimmerImageView2);
                    qUIShimmerImageView2.startShimming(null);
                    new com.tencent.mobileqq.widget.annimation.scaleview.a().e(this.f411750e.mIvIntimate).d(1.0f, 1.2f, 1.0f, 1.2f).c(1).b(R.anim.f154985us, 3).f(null);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(@Nullable Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(@Nullable Animation animation) {
            }
        }
    }
}
