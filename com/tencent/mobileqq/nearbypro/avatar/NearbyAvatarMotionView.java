package com.tencent.mobileqq.nearbypro.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.SquareInteractionEventData;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.avatar.PlayerSourceHelper;
import com.tencent.state.square.avatar.filament.AnimType;
import com.tencent.state.square.avatar.filament.AvatarType;
import com.tencent.state.square.avatar.filament.FilamentReportHelper;
import com.tencent.state.square.avatar.filament.MoodConfig;
import com.tencent.state.square.avatar.filament.RenderFailReason;
import com.tencent.state.square.avatar.filament.RenderResult;
import com.tencent.state.square.avatar.filament.SquareActionHelperKt;
import com.tencent.state.square.data.FilamentAvatarCoverUri;
import com.tencent.state.square.data.FilamentMapPlayableSource;
import com.tencent.state.square.data.MapResourceType;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.Size;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.resource.FilamentCoverRecordHelper;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import com.tencent.state.view.SquareImageView;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import dl0.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import mqq.util.WeakReference;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0002ghB'\b\u0007\u0012\u0006\u0010a\u001a\u00020`\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\b\b\u0002\u0010d\u001a\u00020%\u00a2\u0006\u0004\be\u0010fJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\b\u0010\r\u001a\u00020\u0007H\u0014J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J$\u0010\u0016\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J \u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J0\u0010*\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00172\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0002J\u0018\u0010/\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0002J\u001c\u00102\u001a\u00020\u00072\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00102\u0006\u00101\u001a\u00020-H\u0002J\b\u00103\u001a\u00020\u0010H\u0002J\u0010\u00105\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0010H\u0002R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010KR\u0016\u0010N\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010MR\u0016\u0010P\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010S\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010MR\u0014\u0010_\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010^\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarMotionView;", "Landroid/widget/FrameLayout;", "Lsk0/b;", "Lcom/tencent/mobileqq/nearbypro/avatar/b;", "data", "Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarMotionView$b;", "listener", "", "setData", ReportConstant.COSTREPORT_PREFIX, "r", HippyTKDListViewAdapter.X, "p", NodeProps.ON_DETACHED_FROM_WINDOW, "", "costTime", "", "errCode", "v", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "type", "handleEvent", "", ViewStickEventHelper.IS_SHOW, "Lcom/tencent/state/square/media/MapPlayableSource;", "source", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "o", "i", "curDataTag", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "l", "isMe", "", "actionId", "isRemoteCoverExist", "isRemoteCoverCorrect", "isLocalCacheExist", "t", "Lcom/tencent/state/square/avatar/filament/RenderResult;", "renderType", "Lcom/tencent/state/square/avatar/filament/RenderFailReason;", "renderFailReason", "u", "errMsg", "reason", DomainData.DOMAIN_NAME, "j", "preDataTag", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/state/view/SquareImageView;", "d", "Lcom/tencent/state/view/SquareImageView;", "staticView", "e", "Lcom/tencent/mobileqq/nearbypro/avatar/b;", "playData", "f", "Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarMotionView$b;", "playListener", "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", h.F, "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "filamentApp", "Lcom/tencent/zplan/zplantracing/b;", "Lcom/tencent/zplan/zplantracing/b;", "filamentSpan", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "Lcom/tencent/state/square/avatar/filament/MoodConfig;", "currentMoodConfig", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "Lcom/tencent/filament/zplan/scene/square/SquareAvatarData;", "currentAvatarData", "Z", "isRendered", "E", "isStarted", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "dataTag", "G", "J", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, "Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "H", "Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "recorder", "I", "needSaveFirstFrameAsLocalCache", "k", "()J", "timeAfterPlay", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyAvatarMotionView extends FrameLayout implements sk0.b {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<String> K;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private SquareAvatarData currentAvatarData;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isRendered;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isStarted;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String dataTag;

    /* renamed from: G, reason: from kotlin metadata */
    private long playTime;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final FilamentCoverRecorder recorder;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean needSaveFirstFrameAsLocalCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SquareImageView staticView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarData playData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b playListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IFilamentNativeAppV2305 filamentApp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.zplan.zplantracing.b filamentSpan;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MoodConfig currentMoodConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarMotionView$a;", "", "", "", "FILAMENT_EVENTS", "Ljava/util/List;", "", PreDownloadConstants.RPORT_KEY_FPS, "I", "REPORT_FILAMENT_PAGE_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/avatar/NearbyAvatarMotionView$b;", "", "", "onShow", "onStart", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void onShow();

        void onStart();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/nearbypro/avatar/NearbyAvatarMotionView$c", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "", "type", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", Const.BUNDLE_KEY_REQUEST, "errorCode", "", "onRecordError", "Lcom/tencent/state/square/data/RecordSource;", "cover", "onRecordSuccess", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements FilamentCoverRecorder.IRecordCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f253185a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NearbyAvatarMotionView f253186b;

        c(long j3, NearbyAvatarMotionView nearbyAvatarMotionView) {
            this.f253185a = j3;
            this.f253186b = nearbyAvatarMotionView;
        }

        @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
        public void onRecordError(int type, @NotNull FilamentCoverRecorder.RecordRequest request, int errorCode) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.f253186b.v(System.currentTimeMillis() - this.f253185a, String.valueOf(errorCode));
        }

        @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
        public void onRecordSuccess(@NotNull FilamentCoverRecorder.RecordRequest request, @NotNull RecordSource cover) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(cover, "cover");
            NearbyAvatarMotionView.w(this.f253186b, System.currentTimeMillis() - this.f253185a, null, 2, null);
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"onFilamentRenderFail", "SquareAvatarScene.EVENT_FIRST_FRAME_RENDERED_AFTER_LOAD", "SquareAvatarScene.DOUBLE_CLICK"});
        K = listOf;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NearbyAvatarMotionView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(boolean isShow, MapPlayableSource source) {
        int i3;
        float f16;
        if (isShow) {
            PlayerSourceHelper.setStaticImage$default(PlayerSourceHelper.INSTANCE, this.staticView, source, null, 4, null);
        }
        SquareImageView squareImageView = this.staticView;
        if (isShow) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        squareImageView.setVisibility(i3);
        SquareImageView squareImageView2 = this.staticView;
        if (isShow) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        squareImageView2.setAlpha(f16);
    }

    static /* synthetic */ void B(NearbyAvatarMotionView nearbyAvatarMotionView, boolean z16, MapPlayableSource mapPlayableSource, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            mapPlayableSource = null;
        }
        nearbyAvatarMotionView.A(z16, mapPlayableSource);
    }

    private final void C(boolean isShow) {
        TextureView view;
        float f16;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
        if (iFilamentNativeAppV2305 != null && (view = iFilamentNativeAppV2305.getView()) != null) {
            if (isShow) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            view.setAlpha(f16);
        }
    }

    private final void D(String curDataTag, AvatarData data, MapPlayableSource source) {
        boolean z16;
        Size size;
        boolean z17;
        boolean z18;
        Resource resource = data.getResource();
        FilamentAvatarCoverUri filamentCoverUrl = resource.getFilamentCoverUrl();
        boolean z19 = false;
        if (filamentCoverUrl.getRemoteUrl().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isRemoteCorrect = filamentCoverUrl.isRemoteCorrect();
        String tid = data.getTid();
        boolean areEqual = Intrinsics.areEqual(tid, String.valueOf(ab2.a.f25767a.m()));
        this.needSaveFirstFrameAsLocalCache = !areEqual;
        if (!isRemoteCorrect && !filamentCoverUrl.isLocalCacheExists()) {
            z17 = false;
        } else {
            this.needSaveFirstFrameAsLocalCache = false;
            boolean z26 = !isRemoteCorrect;
            if (q(curDataTag)) {
                return;
            }
            if (this.staticView.getWidth() == 0) {
                size = new Size(data.getResource().getShowSize().getWidth(), data.getResource().getShowSize().getHeight());
            } else {
                size = null;
            }
            A(true, new MapPlayableSource(source.getMediaSource(), 0, size, null, 10, null));
            synchronized (this) {
                if (!this.isRendered) {
                    this.isRendered = true;
                    b bVar = this.playListener;
                    if (bVar != null) {
                        bVar.onShow();
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            z17 = z26;
        }
        ga2.a c16 = j.c();
        int actionId = resource.getActionId();
        if (z16 && isRemoteCorrect) {
            z19 = true;
        }
        c16.e("NearbyAvatarMotionView", "tid=" + tid + " \u52a8\u4f5c=" + actionId + " \u8fdc\u7a0b\u56fe\u7247\u6b63\u786e=" + z19 + " \u672c\u5730\u7f13\u5b58\u5b58\u5728=" + z17 + " \u7f13\u5b58\u9996\u5e27=" + this.needSaveFirstFrameAsLocalCache);
        if (!filamentCoverUrl.isRemoteCorrect() && areEqual && resource.getActionId() > 0) {
            j.c().e("NearbyAvatarMotionView", "\u542f\u52a8\u4e3b\u6001\u5f62\u8c61\u5f55\u5236");
            long currentTimeMillis = System.currentTimeMillis();
            z18 = z17;
            FilamentCoverRecordHelper.INSTANCE.checkAndRecord(this.recorder, tid + "_" + resource.getActionId(), tid, null, resource, true, RecordType.FILAMENT_NEARBY, new c(currentTimeMillis, this));
        } else {
            z18 = z17;
        }
        t(areEqual, resource.getActionId(), z16, isRemoteCorrect, z18);
    }

    private final void i() {
        ImageService.INSTANCE.destroy();
        this.recorder.onDestroy();
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.destroy();
        }
        this.filamentApp = null;
    }

    private final String j() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    private final long k() {
        return System.currentTimeMillis() - this.playTime;
    }

    private final void l() {
        SquareAvatarData squareAvatarData;
        SquareAvatarData.AvatarAnim avatarAnim;
        String str;
        MoodConfig moodConfig = this.currentMoodConfig;
        if (moodConfig == null || (squareAvatarData = this.currentAvatarData) == null) {
            return;
        }
        EnumUserGender gender = squareAvatarData.getHost().getGender();
        AvatarType avatarType = AvatarType.HOST;
        AnimType animType = AnimType.CLICK;
        SquareAvatarData.AvatarAnim avatarAnim2 = moodConfig.getAvatarAnim(gender, avatarType, animType);
        SquareAvatarData.AvatarData guest = squareAvatarData.getGuest();
        com.tencent.zplan.zplantracing.c cVar = null;
        if (guest != null) {
            avatarAnim = moodConfig.getAvatarAnim(guest.getGender(), AvatarType.GUEST, animType);
        } else {
            avatarAnim = null;
        }
        SquareAvatarData.ExtraActorData extraActorData = moodConfig.getExtraActorData(animType, squareAvatarData.getHost().getGender());
        if (extraActorData != null) {
            str = extraActorData.getAnimGltf();
        } else {
            str = null;
        }
        if (avatarAnim2 != null) {
            SquareInteractionEventData squareInteractionEventData = new SquareInteractionEventData(avatarAnim2, avatarAnim, str);
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
            if (iFilamentNativeAppV2305 != null) {
                com.tencent.zplan.zplantracing.b bVar = this.filamentSpan;
                if (bVar != null) {
                    cVar = bVar.c();
                }
                iFilamentNativeAppV2305.dispatchEvent(cVar, "SquareAvatarScene.EVENT_INTERACTION", squareInteractionEventData.toJson());
            }
        }
    }

    private final synchronized void m() {
        j.c().e("NearbyAvatarMotionView", "handleFirstFrame, cost:" + k());
        if (!this.isRendered) {
            this.isRendered = true;
            b bVar = this.playListener;
            if (bVar != null) {
                bVar.onShow();
            }
        }
        if (!this.isStarted) {
            this.isStarted = true;
            b bVar2 = this.playListener;
            if (bVar2 != null) {
                bVar2.onStart();
            }
        }
        B(this, false, null, 2, null);
        C(true);
        y();
        u(RenderResult.SUCCESS, RenderFailReason.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String errMsg, RenderFailReason reason) {
        u(RenderResult.FAIL, reason);
    }

    private final void o() {
        com.tencent.zplan.zplantracing.c cVar;
        FilamentReportHelper.INSTANCE.markUsedFilament();
        FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        fl0.a aVar = fl0.a.f399763a;
        try {
            IFilamentNativeAppV2305 c16 = FilamentRenderFactory.f105773b.c(new sk0.a(F, true, context, 24, (k) aVar.a(k.class), (dl0.d) aVar.a(dl0.d.class), null, 64, null));
            this.filamentApp = c16;
            TextureView view = c16.getView();
            addView(view, new FrameLayout.LayoutParams(-1, -1));
            view.setAlpha(0.0f);
            Iterator<T> it = K.iterator();
            while (it.hasNext()) {
                c16.addEventListener((String) it.next(), this);
            }
            com.tencent.zplan.zplantracing.b bVar = this.filamentSpan;
            if (bVar != null) {
                cVar = bVar.c();
            } else {
                cVar = null;
            }
            c16.startWithEntry(cVar, "bundle/scenes/square_avatar/main.js");
        } catch (Throwable th5) {
            j.c().d("NearbyAvatarMotionView", "initFilament error=" + th5);
            n(th5.toString(), RenderFailReason.INIT_FAIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(String preDataTag) {
        return !Intrinsics.areEqual(preDataTag, this.dataTag);
    }

    public static /* synthetic */ void setData$default(NearbyAvatarMotionView nearbyAvatarMotionView, AvatarData avatarData, b bVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bVar = null;
        }
        nearbyAvatarMotionView.setData(avatarData, bVar);
    }

    private final void t(boolean isMe, int actionId, boolean isRemoteCoverExist, boolean isRemoteCoverCorrect, boolean isLocalCacheExist) {
        int i3;
        int i16;
        Map mapOf;
        if (actionId <= 0) {
            return;
        }
        if (!isRemoteCoverExist) {
            i3 = 0;
        } else if (!isRemoteCoverCorrect) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (isRemoteCoverCorrect) {
            i16 = 1;
        } else if (isLocalCacheExist) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"), TuplesKt.to("nearby_motion_id", Integer.valueOf(actionId)), TuplesKt.to("nearby_is_self", Boolean.valueOf(isMe)), TuplesKt.to("nearby_remote_cover_status", Integer.valueOf(i3)), TuplesKt.to("nearby_cover_display_mode", Integer.valueOf(i16)));
        VideoReport.reportEvent("ev_nearby_tech_cover_action_display", mapOf);
    }

    private final void u(RenderResult renderType, RenderFailReason renderFailReason) {
        String str;
        String str2;
        String str3;
        Map<String, Object> mutableMapOf;
        FilamentReportHelper filamentReportHelper = FilamentReportHelper.INSTANCE;
        boolean isFirstFilamentAfterInstall = filamentReportHelper.isFirstFilamentAfterInstall();
        AvatarData avatarData = this.playData;
        if (avatarData != null) {
            str = avatarData.getTid();
        } else {
            str = null;
        }
        boolean areEqual = Intrinsics.areEqual(str, String.valueOf(ab2.a.f25767a.m()));
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        Pair[] pairArr = new Pair[7];
        boolean z16 = false;
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IMP_STATE, renderType.getValue());
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_FAIL_REASON, renderFailReason.getValue());
        pairArr[2] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IMP_USE_TIMES, Long.valueOf(k()));
        MoodConfig moodConfig = this.currentMoodConfig;
        if (moodConfig != null && moodConfig.getFromCache()) {
            z16 = true;
        }
        if (z16) {
            str2 = "yes";
        } else {
            str2 = "no";
        }
        pairArr[3] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IS_READ_RENDER_DATA_FROM_CACHE, str2);
        if (areEqual) {
            str3 = "host";
        } else {
            str3 = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
        }
        pairArr[4] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_HOST_GUEST_LOAD_FIRST_FRAME, str3);
        pairArr[5] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PG_ID, "NearbyAvatarMotionView");
        pairArr[6] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_IS_INSTALL_FIRST_ACT, Integer.valueOf(isFirstFilamentAfterInstall ? 1 : 0));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_FILAMENT_FIRST_FRAME_IMP, mutableMapOf);
        j.c().f("NearbyAvatarMotionView", "report page init filament timeAfter: " + k());
        filamentReportHelper.setUsedFilamentAfterInstall();
    }

    public static /* synthetic */ void w(NearbyAvatarMotionView nearbyAvatarMotionView, long j3, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        nearbyAvatarMotionView.v(j3, str);
    }

    private final void y() {
        TextureView view;
        if (!this.needSaveFirstFrameAsLocalCache) {
            return;
        }
        this.needSaveFirstFrameAsLocalCache = false;
        AvatarData avatarData = this.playData;
        if (avatarData == null) {
            return;
        }
        Resource resource = avatarData.getResource();
        final FilamentAvatarCoverUri filamentCoverUrl = resource.getFilamentCoverUrl();
        j.c().e("NearbyAvatarMotionView", "saveFirstFrameAsLocalCache \u6267\u884c\u9996\u5e27\u7f13\u5b58 tid=" + avatarData.getTid() + " \u52a8\u4f5c=" + resource.getActionId() + " \u7f13\u5b58\u8def\u5f84=" + filamentCoverUrl.getCachePath());
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
        if (iFilamentNativeAppV2305 != null && (view = iFilamentNativeAppV2305.getView()) != null) {
            if (view.getWidth() > 0 && view.getHeight() > 0) {
                final Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
                view.getBitmap(createBitmap);
                if (createBitmap == null) {
                    j.c().d("NearbyAvatarMotionView", "saveFirstFrameAsLocalCache filament\u56fe\u7247\u63d0\u53d6\u5931\u8d25");
                    return;
                } else {
                    j.g().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView$saveFirstFrameAsLocalCache$1$1
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
                            NearbyAvatarMotionView.Companion companion = NearbyAvatarMotionView.INSTANCE;
                            Bitmap bm5 = createBitmap;
                            FilamentAvatarCoverUri filamentAvatarCoverUri = filamentCoverUrl;
                            synchronized (companion) {
                                com.tencent.mobileqq.nearbypro.utils.g gVar = com.tencent.mobileqq.nearbypro.utils.g.f253949a;
                                Intrinsics.checkNotNullExpressionValue(bm5, "bm");
                                gVar.e(bm5, filamentAvatarCoverUri.getCachePath());
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                    });
                    return;
                }
            }
            j.c().d("NearbyAvatarMotionView", "saveFirstFrameAsLocalCache filament\u753b\u9762\u9519\u8bef, width or height is 0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(NearbyAvatarMotionView this$0, String newDataTag, AvatarData data, MapPlayableSource playableSource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newDataTag, "$newDataTag");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(playableSource, "$playableSource");
        this$0.D(newDataTag, data, playableSource);
    }

    @Override // sk0.b
    public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
        Intrinsics.checkNotNullParameter(type, "type");
        int hashCode = type.hashCode();
        if (hashCode != -1565730423) {
            if (hashCode != -12447438) {
                if (hashCode == 1543387125 && type.equals("SquareAvatarScene.EVENT_FIRST_FRAME_RENDERED_AFTER_LOAD")) {
                    m();
                    return;
                }
                return;
            }
            if (type.equals("SquareAvatarScene.DOUBLE_CLICK")) {
                l();
                return;
            }
            return;
        }
        if (type.equals("onFilamentRenderFail")) {
            n(data, RenderFailReason.INIT_FAIL);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public final void p() {
        if (this.filamentApp == null) {
            return;
        }
        l();
    }

    public final void r() {
        String str;
        Integer num;
        Resource resource;
        Resource resource2;
        ga2.a c16 = j.c();
        AvatarData avatarData = this.playData;
        Boolean bool = null;
        if (avatarData != null) {
            str = avatarData.getTid();
        } else {
            str = null;
        }
        AvatarData avatarData2 = this.playData;
        if (avatarData2 != null && (resource2 = avatarData2.getResource()) != null) {
            num = Integer.valueOf(resource2.getActionId());
        } else {
            num = null;
        }
        AvatarData avatarData3 = this.playData;
        if (avatarData3 != null && (resource = avatarData3.getResource()) != null) {
            bool = Boolean.valueOf(resource.getFilamentReady());
        }
        c16.e("NearbyAvatarMotionView", "pause: tid=" + str + " motionId=" + num + " filamentReady=" + bool);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.pause();
        }
    }

    public final synchronized void s() {
        FilamentMapPlayableSource filamentMapPlayableSource;
        Long l3;
        if (this.isStarted) {
            x();
            return;
        }
        AvatarData avatarData = this.playData;
        if (avatarData == null) {
            return;
        }
        j.c().e("NearbyAvatarMotionView", "play: tid=" + avatarData.getTid() + " motionId=" + avatarData.getResource().getActionId() + " filamentReady=" + avatarData.getResource().getFilamentReady());
        long currentTimeMillis = System.currentTimeMillis();
        this.isRendered = false;
        this.isStarted = false;
        this.playTime = currentTimeMillis;
        String str = this.dataTag;
        final MapPlayableSource mapPlayableSource$default = SquareItemKt.toMapPlayableSource$default(avatarData.getResource(), MapResourceType.Filament, avatarData.getTid(), null, 4, null);
        long longOrDefault = Util.toLongOrDefault(avatarData.getTid(), 0L);
        if (mapPlayableSource$default instanceof FilamentMapPlayableSource) {
            filamentMapPlayableSource = (FilamentMapPlayableSource) mapPlayableSource$default;
        } else {
            filamentMapPlayableSource = null;
        }
        if (filamentMapPlayableSource != null) {
            l3 = filamentMapPlayableSource.guestUin();
        } else {
            l3 = null;
        }
        final WeakReference weakReference = new WeakReference(this);
        Function2<CoroutineContext, Throwable, Unit> function2 = new Function2<CoroutineContext, Throwable, Unit>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView$play$handleException$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(CoroutineContext coroutineContext, Throwable th5) {
                invoke2(coroutineContext, th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable CoroutineContext coroutineContext, @NotNull final Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                j.c().d("NearbyAvatarMotionView", "loadPlayParams failed, playableSource:" + MapPlayableSource.this + ", e:" + throwable);
                com.tencent.mobileqq.nearbypro.base.g g16 = j.g();
                final WeakReference<NearbyAvatarMotionView> weakReference2 = weakReference;
                g16.postOnUi(new Function0<Unit>() { // from class: com.tencent.mobileqq.nearbypro.avatar.NearbyAvatarMotionView$play$handleException$1.1
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
                        NearbyAvatarMotionView nearbyAvatarMotionView = weakReference2.get();
                        if (nearbyAvatarMotionView != null) {
                            nearbyAvatarMotionView.n(throwable.toString(), RenderFailReason.LOAD_FAIL);
                        }
                    }
                });
            }
        };
        SquareActionHelperKt.launchCoroutine(Dispatchers.getIO(), function2, new NearbyAvatarMotionView$play$1(longOrDefault, l3, mapPlayableSource$default, function2, this, str, null));
    }

    public final synchronized void setData(@NotNull final AvatarData data, @Nullable b listener) {
        Intrinsics.checkNotNullParameter(data, "data");
        j.c().e("NearbyAvatarMotionView", "setData: tid=" + data.getTid() + " motionId=" + data.getResource().getActionId() + " filamentReady=" + data.getResource().getFilamentReady());
        if (this.playData != null) {
            C(false);
            com.tencent.zplan.zplantracing.c cVar = null;
            B(this, false, null, 2, null);
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
            if (iFilamentNativeAppV2305 != null) {
                com.tencent.zplan.zplantracing.b bVar = this.filamentSpan;
                if (bVar != null) {
                    cVar = bVar.c();
                }
                iFilamentNativeAppV2305.dispatchEvent(cVar, "SquareAvatarScene.EVENT_CLEAN_ALL", "");
            }
        }
        final String j3 = j();
        this.isRendered = false;
        this.isStarted = false;
        this.playData = data;
        this.playListener = listener;
        this.dataTag = j3;
        final MapPlayableSource mapPlayableSource$default = SquareItemKt.toMapPlayableSource$default(data.getResource(), MapResourceType.Filament, data.getTid(), null, 4, null);
        post(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.avatar.f
            @Override // java.lang.Runnable
            public final void run() {
                NearbyAvatarMotionView.z(NearbyAvatarMotionView.this, j3, data, mapPlayableSource$default);
            }
        });
        if (data.getAutoPlay()) {
            s();
        }
    }

    public final void v(long costTime, @Nullable String errCode) {
        Map mapOf;
        Pair[] pairArr = new Pair[7];
        boolean z16 = false;
        pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        pairArr[1] = TuplesKt.to("nearby_page_id", "-");
        pairArr[2] = TuplesKt.to("nearby_api_type", "native");
        pairArr[3] = TuplesKt.to("nearby_api_name", "FilamentCoverRecorder.RecordRequest");
        pairArr[4] = TuplesKt.to("nearby_api_time_usage", Long.valueOf(costTime));
        if (errCode == null) {
            z16 = true;
        }
        pairArr[5] = TuplesKt.to("nearby_api_success", Boolean.valueOf(z16));
        pairArr[6] = TuplesKt.to("nearby_api_err_code", errCode);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("ev_nearby_tech_api_call", mapOf);
    }

    public final void x() {
        String str;
        Integer num;
        Resource resource;
        Resource resource2;
        ga2.a c16 = j.c();
        AvatarData avatarData = this.playData;
        Boolean bool = null;
        if (avatarData != null) {
            str = avatarData.getTid();
        } else {
            str = null;
        }
        AvatarData avatarData2 = this.playData;
        if (avatarData2 != null && (resource2 = avatarData2.getResource()) != null) {
            num = Integer.valueOf(resource2.getActionId());
        } else {
            num = null;
        }
        AvatarData avatarData3 = this.playData;
        if (avatarData3 != null && (resource = avatarData3.getResource()) != null) {
            bool = Boolean.valueOf(resource.getFilamentReady());
        }
        c16.e("NearbyAvatarMotionView", "resume: tid=" + str + " motionId=" + num + " filamentReady=" + bool);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.filamentApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.resume();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NearbyAvatarMotionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NearbyAvatarMotionView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NearbyAvatarMotionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        SquareImageView squareImageView = new SquareImageView(context);
        this.staticView = squareImageView;
        this.filamentSpan = ZPlanSpanFactory.INSTANCE.startRootSpan("NearbyAvatarMotionView");
        this.dataTag = "";
        this.recorder = new FilamentCoverRecorder();
        addView(squareImageView, new FrameLayout.LayoutParams(-1, -1));
        ImageService.INSTANCE.initImageLoader(context);
        o();
    }
}
