package com.tencent.aelight.camera.ae.flashshow.zshow;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.zshow.WinkZShowContext;
import com.tencent.aelight.camera.ae.flashshow.zshow.ZShowFilamentPreviewView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView;
import com.tencent.aelight.camera.filament.api.IZShowFilamentPreviewProvider;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.wink.WinkInitManager;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tav.ResourceLoadUtil;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tav.player.Player;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.Painting;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.LAKCutSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.SupervisorKt;
import mqq.util.WeakReference;
import org.json.JSONObject;
import org.light.LightConstants;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.components.TimeRange;
import org.light.listener.OnLoadAssetListener;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 d2\u00020\u0001:\u00023eB\u0011\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u00a2\u0006\u0004\b]\u0010^B\u001d\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u00a2\u0006\u0004\b]\u0010aB'\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u0012\b\b\u0002\u0010b\u001a\u00020\u0006\u00a2\u0006\u0004\b]\u0010cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0013\u0010\u0011\u001a\u00020\u0010H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J7\u0010 \u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\"\u001a\u00020\u0004H\u0002J0\u0010(\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0016J \u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0006\u00100\u001a\u00020\u0010J\u0010\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0002H\u0016J\b\u00103\u001a\u00020\u0004H\u0016R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0018\u0010G\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010HR\u0016\u0010J\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010LR\u0016\u0010O\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010NR\u0016\u0010P\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010NR\u0016\u0010R\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010NR\u0016\u0010S\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010NR\u0016\u0010T\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010NR\u001b\u0010Z\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006f"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/zshow/ZShowFilamentPreviewView;", "Lcom/tencent/aelight/camera/filament/api/BaseZShowFilamentPreviewView;", "", "templateFilePath", "", "r", "", "width", "height", UserInfo.SEX_FEMALE, "G", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "w", HippyTKDListViewAdapter.X, "y", "", "o", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "E", DomainData.DOMAIN_NAME, "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "D", "errorCode", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "isReady", "isBlackSlot", "", "moodDuration", "moodPath", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "changed", "left", "top", "right", "bottom", "onLayout", "Lcom/tencent/aelight/camera/filament/api/BaseZShowFilamentPreviewView$a;", "listener", "setOnStatusListener", "uin", "templateDirPath", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "setupBaseTemplate", ReportConstant.COSTREPORT_PREFIX, "localPath", "setMoodType", "a", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "playerContainer", "Lcom/tencent/aelight/camera/ae/flashshow/zshow/WinkZShowContext;", "e", "Lcom/tencent/aelight/camera/ae/flashshow/zshow/WinkZShowContext;", "zShowContext", "Lcom/tencent/tavcut/core/session/ICutSession;", "f", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCut", tl.h.F, "I", "renderWidth", "i", "renderHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/filament/api/BaseZShowFilamentPreviewView$a;", "filamentStatusListener", "Z", "isBaseMoodLoaded", "isTavCutLoad", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "player", "J", "loadSDKTime", "loadingStartTime", "H", "setupTime", "updateTemplateTime", "setMoodTime", "Lcom/tencent/aelight/camera/ae/flashshow/zshow/ZShowFilamentPreviewView$b;", "K", "Lkotlin/Lazy;", "p", "()Lcom/tencent/aelight/camera/ae/flashshow/zshow/ZShowFilamentPreviewView$b;", "loadAssetListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ZShowFilamentPreviewView extends BaseZShowFilamentPreviewView {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isBaseMoodLoaded;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isTavCutLoad;

    /* renamed from: E, reason: from kotlin metadata */
    private IPlayer player;

    /* renamed from: F, reason: from kotlin metadata */
    private long loadSDKTime;

    /* renamed from: G, reason: from kotlin metadata */
    private long loadingStartTime;

    /* renamed from: H, reason: from kotlin metadata */
    private long setupTime;

    /* renamed from: I, reason: from kotlin metadata */
    private long updateTemplateTime;

    /* renamed from: J, reason: from kotlin metadata */
    private long setMoodTime;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy loadAssetListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout playerContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WinkZShowContext zShowContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ICutSession tavCut;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int renderWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int renderHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private BaseZShowFilamentPreviewView.a filamentStatusListener;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016R\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/zshow/ZShowFilamentPreviewView$b;", "Lorg/light/listener/OnLoadAssetListener;", "", "p0", "", "OnLoadAssetError", "Ljava/util/HashMap;", "", "hashMap", "OnAssetProcessing", "", "OnAssetDurationChange", "Lmqq/util/WeakReference;", "Lcom/tencent/aelight/camera/ae/flashshow/zshow/ZShowFilamentPreviewView;", "kotlin.jvm.PlatformType", "a", "Lmqq/util/WeakReference;", "ref", "view", "<init>", "(Lcom/tencent/aelight/camera/ae/flashshow/zshow/ZShowFilamentPreviewView;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements OnLoadAssetListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZShowFilamentPreviewView> ref;

        public b(ZShowFilamentPreviewView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.ref = new WeakReference<>(view);
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetDurationChange(long p06) {
            ms.a.f("ZShowFilamentPreviewView", "OnAssetDurationChange ");
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnAssetProcessing(HashMap<String, String> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "hashMap");
            ms.a.f("ZShowFilamentPreviewView", "OnAssetProcessing " + hashMap);
            ZShowFilamentPreviewView zShowFilamentPreviewView = this.ref.get();
            if (zShowFilamentPreviewView == null) {
                return;
            }
            if (hashMap.containsKey(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_FIRSTFRAME)) {
                String str = hashMap.get(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_FIRSTFRAME);
                if (Intrinsics.areEqual(str, "0")) {
                    zShowFilamentPreviewView.B();
                    return;
                }
                ms.a.c("ZShowFilamentPreviewView", "onFirstFrame errorCode " + str);
                zShowFilamentPreviewView.A(5);
                return;
            }
            if (hashMap.containsKey(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY)) {
                try {
                    String str2 = hashMap.get(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY);
                    Integer valueOf = str2 != null ? Integer.valueOf(Integer.parseInt(str2)) : null;
                    String str3 = hashMap.get(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_MOODDURATION);
                    Long valueOf2 = str3 != null ? Long.valueOf(Long.parseLong(str3)) : null;
                    String str4 = hashMap.get(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_MOODPATH);
                    String str5 = hashMap.get(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_SETMOODTYPEREADY_BLACKSLOTSTATE);
                    zShowFilamentPreviewView.C(valueOf, str5 != null ? Integer.valueOf(Integer.parseInt(str5)) : null, valueOf2, str4);
                    return;
                } catch (Exception e16) {
                    ms.a.f("ZShowFilamentPreviewView", "OnAssetProcessing setMoodTypeReady error " + e16.getMessage());
                    return;
                }
            }
            if (hashMap.containsKey(LightConstants.ZPlanConfigKeys.ASSET_PROCESSING_ZPLAN_FILAMENT_ANIMATION_BEGIN)) {
                zShowFilamentPreviewView.z();
            }
        }

        @Override // org.light.listener.OnLoadAssetListener
        public void OnLoadAssetError(int p06) {
            ms.a.f("ZShowFilamentPreviewView", "OnLoadAssetError " + p06);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/ZShowFilamentPreviewView$c", "Lcom/tencent/tav/player/OnReadSnapShootListener;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/tav/coremedia/CMTime;", "position", "", "onSuccess", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements OnReadSnapShootListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f65213a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZShowFilamentPreviewView f65214b;

        c(long j3, ZShowFilamentPreviewView zShowFilamentPreviewView) {
            this.f65213a = j3;
            this.f65214b = zShowFilamentPreviewView;
        }

        @Override // com.tencent.tav.player.OnReadSnapShootListener
        public void onSuccess(Bitmap bitmap, CMTime position) {
            ms.a.f("ZShowFilamentPreviewView", "readSnapShootBitmap duration " + (System.currentTimeMillis() - this.f65213a));
            BaseZShowFilamentPreviewView.a aVar = this.f65214b.filamentStatusListener;
            if (aVar != null) {
                aVar.d(this.f65214b.zShowContext.f65188d, this.f65214b.zShowContext.f65189e, bitmap);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/ZShowFilamentPreviewView$d", "Lcom/tencent/tavcut/core/session/ICutStatusCallback;", "Lorg/light/lightAssetKit/Entity;", "rootEntity", "", "onLightEntityReload", "onRenderChainReady", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d implements ICutStatusCallback {
        d() {
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(Entity rootEntity) {
            ms.a.f("ZShowFilamentPreviewView", "onLightEntityReload ");
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
            ms.a.f("ZShowFilamentPreviewView", "onRenderChainReady ");
            ICutSession iCutSession = ZShowFilamentPreviewView.this.tavCut;
            if (iCutSession != null) {
                iCutSession.setBgColor(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZShowFilamentPreviewView(Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.zShowContext = new WinkZShowContext();
        this.renderWidth = 720;
        this.renderHeight = 720;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.ZShowFilamentPreviewView$loadAssetListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZShowFilamentPreviewView.b invoke() {
                return new ZShowFilamentPreviewView.b(ZShowFilamentPreviewView.this);
            }
        });
        this.loadAssetListener = lazy;
        ms.a.f("ZShowFilamentPreviewView", "init ");
        q();
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int errorCode) {
        ms.a.f("ZShowFilamentPreviewView", "onLoadingFailed " + errorCode);
        this.zShowContext.f65187c = WinkZShowContext.UEState.FAILED;
        BaseZShowFilamentPreviewView.a aVar = this.filamentStatusListener;
        if (aVar != null) {
            aVar.c(-1, errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        ms.a.f("ZShowFilamentPreviewView", "updateTemplate duration: " + (System.currentTimeMillis() - this.updateTemplateTime));
        this.zShowContext.f65187c = WinkZShowContext.UEState.SUCC;
        BaseZShowFilamentPreviewView.a aVar = this.filamentStatusListener;
        if (aVar != null) {
            aVar.a(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(Integer isReady, Integer isBlackSlot, Long moodDuration, String moodPath) {
        IPlayer player;
        IPlayer player2;
        ms.a.f("ZShowFilamentPreviewView", "onSetMoodReady " + isReady + " " + isBlackSlot + " " + moodDuration + " " + moodPath);
        if (isBlackSlot == null || isBlackSlot.intValue() != 0) {
            isReady = -1;
        }
        if (moodDuration != null) {
            ICutSession iCutSession = this.tavCut;
            if (iCutSession != null && (player2 = iCutSession.getPlayer()) != null) {
                player2.setPlayTimeRange(0L, moodDuration.longValue());
            }
            ICutSession iCutSession2 = this.tavCut;
            if (iCutSession2 != null && (player = iCutSession2.getPlayer()) != null) {
                player.seek(0L);
            }
        }
        if (isReady == null || moodPath == null) {
            return;
        }
        this.zShowContext.f65188d = isReady.intValue();
        this.zShowContext.f65189e = moodPath;
    }

    private final List<ClipSource> D() {
        String b16 = com.tencent.mobileqq.wink.utils.f.b(this.renderWidth, this.renderHeight, AEEditorConstants.AE_EDITOR_ZSHOW_TRANSPARENT_FILE_PREFIX);
        if (b16 == null) {
            b16 = "";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(rd4.c.f431135f.n().a(b16, new TimeRange(0L, 0L)));
        return arrayList;
    }

    private final boolean E() {
        ms.a.f("ZShowFilamentPreviewView", "realInitTavCut " + this.zShowContext.f65187c);
        long currentTimeMillis = System.currentTimeMillis();
        if (!xq.c.f448345a.isFilamentReady()) {
            ms.a.f("ZShowFilamentPreviewView", "realInitTavCut isFilamentReady false");
            return false;
        }
        this.zShowContext.f65187c = WinkZShowContext.UEState.LOADING;
        this.loadingStartTime = System.currentTimeMillis();
        Player.setPlayerStaticConfig(Player.PlayerStaticConfigKey.CONFIG_STATIC_VIDEO_AUDIO_SYNC, false);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        rd4.c.t(context, "", "lightsdk_qq", QQWinkConstants.ENTRY_QQ_ZPLAN);
        ICutSession iCutSession = this.tavCut;
        if (iCutSession != null) {
            iCutSession.release();
        }
        this.tavCut = null;
        ICutSession createLAKCutSession = LAKCutSession.INSTANCE.createLAKCutSession();
        this.tavCut = createLAKCutSession;
        if (createLAKCutSession != null) {
            createLAKCutSession.setLoadAssetListener(p());
        }
        ICutSession iCutSession2 = this.tavCut;
        if (iCutSession2 != null) {
            iCutSession2.setCutStatusListener(new d());
        }
        n();
        ms.a.f("ZShowFilamentPreviewView", "realInitTavCut duration " + (System.currentTimeMillis() - currentTimeMillis));
        return true;
    }

    private final void F(int width, int height) {
        ICutSession iCutSession = this.tavCut;
        LAKRenderModel allInputSourceRenderModel = iCutSession != null ? iCutSession.getAllInputSourceRenderModel() : null;
        if ((allInputSourceRenderModel != null ? allInputSourceRenderModel.getPainting() : null) != null) {
            ICutSession iCutSession2 = this.tavCut;
            LAKRenderModel allInputSourceRenderModel2 = iCutSession2 != null ? iCutSession2.getAllInputSourceRenderModel() : null;
            if (allInputSourceRenderModel2 == null) {
                return;
            }
            allInputSourceRenderModel2.setPainting(Painting.copy$default(allInputSourceRenderModel.getPainting(), null, null, new Size(width, height), null, null, 27, null));
        }
    }

    private final void G(final String templateFilePath) {
        ms.a.f("ZShowFilamentPreviewView", "updateTemplate " + templateFilePath);
        final WeakReference weakReference = new WeakReference(this);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.m
            @Override // java.lang.Runnable
            public final void run() {
                ZShowFilamentPreviewView.H(ZShowFilamentPreviewView.this, templateFilePath, weakReference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(ZShowFilamentPreviewView this$0, String templateFilePath, WeakReference ref) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(templateFilePath, "$templateFilePath");
        Intrinsics.checkNotNullParameter(ref, "$ref");
        if (this$0.E()) {
            ah.f326668a.h(templateFilePath, new e(ref, templateFilePath));
        } else {
            this$0.A(3);
        }
    }

    private final void n() {
        IPlayer player;
        IPlayer player2;
        IPlayer player3;
        IPlayer player4;
        ICutSession iCutSession = this.tavCut;
        if (iCutSession != null) {
            iCutSession.unbindCutPlayer(iCutSession != null ? iCutSession.getPlayer() : null);
        }
        IPlayer iPlayer = this.player;
        if (iPlayer != null) {
            iPlayer.release();
        }
        IPlayer g16 = rd4.c.f431135f.g((FrameLayout) findViewById(R.id.ryg));
        this.player = g16;
        ICutSession iCutSession2 = this.tavCut;
        if (iCutSession2 != null) {
            Intrinsics.checkNotNull(g16);
            iCutSession2.bindCutPlayer(g16);
        }
        ICutSession iCutSession3 = this.tavCut;
        if (iCutSession3 != null && (player4 = iCutSession3.getPlayer()) != null) {
            player4.setBgColor(0);
        }
        ICutSession iCutSession4 = this.tavCut;
        if (iCutSession4 != null && (player3 = iCutSession4.getPlayer()) != null) {
            player3.setAutoPlay(true);
        }
        ICutSession iCutSession5 = this.tavCut;
        if (iCutSession5 != null && (player2 = iCutSession5.getPlayer()) != null) {
            player2.setLoopPlay(true);
        }
        ICutSession iCutSession6 = this.tavCut;
        if (iCutSession6 == null || (player = iCutSession6.getPlayer()) == null) {
            return;
        }
        player.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o(Continuation<? super Boolean> continuation) {
        return SupervisorKt.supervisorScope(new ZShowFilamentPreviewView$fetchLightRes$2(null), continuation);
    }

    private final b p() {
        return (b) this.loadAssetListener.getValue();
    }

    private final void q() {
        ms.a.f("ZShowFilamentPreviewView", "initView");
        LayoutInflater.from(getContext()).inflate(R.layout.doz, this);
        View findViewById = findViewById(R.id.ryg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.player_container)");
        this.playerContainer = (FrameLayout) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String templateFilePath) {
        IPlayer player;
        this.updateTemplateTime = System.currentTimeMillis();
        ICutSession iCutSession = this.tavCut;
        if (iCutSession != null) {
            iCutSession.setTemplateDir(templateFilePath);
        }
        rd4.c cVar = rd4.c.f431135f;
        List<ClipSource> list = this.zShowContext.f65186b;
        Intrinsics.checkNotNullExpressionValue(list, "zShowContext.clipSource");
        LAKRenderModel y16 = cVar.y(list);
        ICutSession iCutSession2 = this.tavCut;
        if (iCutSession2 != null) {
            iCutSession2.setRenderModel(y16);
        }
        F(this.renderWidth, this.renderHeight);
        ICutSession iCutSession3 = this.tavCut;
        if (iCutSession3 != null) {
            iCutSession3.flushWithoutDelay();
        }
        ICutSession iCutSession4 = this.tavCut;
        if (iCutSession4 == null || (player = iCutSession4.getPlayer()) == null) {
            return;
        }
        player.play();
    }

    private final void t() {
        ms.a.f("ZShowFilamentPreviewView", "loadAndInitSDK ");
        this.loadSDKTime = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.l
            @Override // java.lang.Runnable
            public final void run() {
                ZShowFilamentPreviewView.u(ZShowFilamentPreviewView.this);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final ZShowFilamentPreviewView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.f("ZShowFilamentPreviewView", "loadAndInitSDK subThread");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new ZShowFilamentPreviewView$loadAndInitSDK$1$1(booleanRef, this$0, null), 1, null);
        this$0.zShowContext.f65186b = this$0.D();
        if (booleanRef.element) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.n
                @Override // java.lang.Runnable
                public final void run() {
                    ZShowFilamentPreviewView.v(ZShowFilamentPreviewView.this);
                }
            });
        } else {
            this$0.A(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ZShowFilamentPreviewView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x();
        this$0.y();
        this$0.w();
    }

    private final void w() {
        ms.a.f("ZShowFilamentPreviewView", "loadAndInitSDKFinish duration " + (System.currentTimeMillis() - this.loadSDKTime));
        if (!s()) {
            ms.a.c("ZShowFilamentPreviewView", "isSupportFilament false " + DeviceInfoMonitor.getModel());
            A(8);
            return;
        }
        this.isTavCutLoad = true;
        if (this.isBaseMoodLoaded) {
            String str = this.zShowContext.f65185a;
            Intrinsics.checkNotNullExpressionValue(str, "zShowContext.templatePath");
            G(str);
        }
    }

    private final void x() {
        ms.a.f("ZShowFilamentPreviewView", "loadLightRes ");
        com.tencent.aelight.camera.ae.d.h();
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadLightSdk();
        if (!com.tencent.aelight.camera.ae.d.t()) {
            ms.a.f("ZShowFilamentPreviewView", "loadLightRes lightSdkInitWithConfig " + com.tencent.aelight.camera.ae.d.s());
        }
        LSCameraGLSurfaceView.X0();
        ms.a.f("ZShowFilamentPreviewView", "loadLightRes loadLightSdkWithConfig " + com.tencent.aelight.camera.ae.d.v());
        WinkInitManager.INSTANCE.a().d();
    }

    private final void y() {
        ms.a.f("ZShowFilamentPreviewView", "loadTavCutRes ");
        try {
            ms.a.f("ZShowFilamentPreviewView", "loadTavCutRes " + ResourceLoadUtil.loadSoSync(((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath() + "libtav.so"));
        } catch (Throwable th5) {
            w53.b.d("WinkResManager", "loadTavCutRes error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        IPlayer player;
        ms.a.f("ZShowFilamentPreviewView", "onAnimationBegin setMoodDuration " + (System.currentTimeMillis() - this.setMoodTime) + " setupDuration " + (System.currentTimeMillis() - this.setupTime));
        long currentTimeMillis = System.currentTimeMillis();
        ICutSession iCutSession = this.tavCut;
        if (iCutSession != null && (player = iCutSession.getPlayer()) != null) {
            player.readSnapShootBitmap(new c(currentTimeMillis, this));
        }
        BaseZShowFilamentPreviewView.a aVar = this.filamentStatusListener;
        if (aVar != null) {
            WinkZShowContext winkZShowContext = this.zShowContext;
            aVar.b(winkZShowContext.f65188d, winkZShowContext.f65189e);
        }
    }

    @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView
    public void a() {
        ms.a.f("ZShowFilamentPreviewView", "release");
        Player.setPlayerStaticConfig(Player.PlayerStaticConfigKey.CONFIG_STATIC_VIDEO_AUDIO_SYNC, true);
        this.filamentStatusListener = null;
        ICutSession iCutSession = this.tavCut;
        if (iCutSession != null) {
            iCutSession.release();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    public final boolean s() {
        return ((IZShowFilamentPreviewProvider) QRoute.api(IZShowFilamentPreviewProvider.class)).isSupportFilament();
    }

    @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView
    public void setMoodType(String localPath) {
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        this.setMoodTime = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("moodType", 0);
        jSONObject.put("moodPath", localPath);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(LightConstants.EventKey.EVENT_SCRIPT_ZPLAN_FILAMENT_SETMOODTYPE, jSONObject.toString());
        ms.a.f("ZShowFilamentPreviewView", "setMoodType: " + jSONObject);
        ICutSession iCutSession = this.tavCut;
        if (iCutSession != null) {
            String str = this.zShowContext.f65185a;
            Intrinsics.checkNotNullExpressionValue(str, "zShowContext.templatePath");
            iCutSession.setAssetData(str, hashMap);
        }
    }

    @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView
    public void setOnStatusListener(BaseZShowFilamentPreviewView.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ms.a.f("ZShowFilamentPreviewView", "setOnStatusListener ");
        this.filamentStatusListener = listener;
    }

    @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView
    public void setupBaseTemplate(String uin, String templateDirPath, int requestId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(templateDirPath, "templateDirPath");
        ms.a.f("ZShowFilamentPreviewView", "setupBaseTemplate uni " + uin + " templateDirPath " + templateDirPath);
        this.setupTime = System.currentTimeMillis();
        this.zShowContext.f65185a = templateDirPath;
        this.isBaseMoodLoaded = true;
        if (this.isTavCutLoad) {
            Intrinsics.checkNotNullExpressionValue(templateDirPath, "zShowContext.templatePath");
            G(templateDirPath);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZShowFilamentPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.zShowContext = new WinkZShowContext();
        this.renderWidth = 720;
        this.renderHeight = 720;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.ZShowFilamentPreviewView$loadAssetListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZShowFilamentPreviewView.b invoke() {
                return new ZShowFilamentPreviewView.b(ZShowFilamentPreviewView.this);
            }
        });
        this.loadAssetListener = lazy;
        ms.a.f("ZShowFilamentPreviewView", "init ");
        q();
        t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZShowFilamentPreviewView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.zShowContext = new WinkZShowContext();
        this.renderWidth = 720;
        this.renderHeight = 720;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.aelight.camera.ae.flashshow.zshow.ZShowFilamentPreviewView$loadAssetListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZShowFilamentPreviewView.b invoke() {
                return new ZShowFilamentPreviewView.b(ZShowFilamentPreviewView.this);
            }
        });
        this.loadAssetListener = lazy;
        ms.a.f("ZShowFilamentPreviewView", "init ");
        q();
        t();
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J,\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/zshow/ZShowFilamentPreviewView$e", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "currentOffset", "totalLength", "", "onAEProgressUpdate", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "onAEDownloadFinish", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class e implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<ZShowFilamentPreviewView> f65216d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f65217e;

        e(WeakReference<ZShowFilamentPreviewView> weakReference, String str) {
            this.f65216d = weakReference;
            this.f65217e = str;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(AEResInfo aeResInfo, String localFilePath, boolean downloaded, int errorType) {
            ms.a.f("ZShowFilamentPreviewView", "registerFilamentAIPath downloaded " + downloaded + " errorType " + errorType);
            ZShowFilamentPreviewView zShowFilamentPreviewView = this.f65216d.get();
            if (zShowFilamentPreviewView == null) {
                return;
            }
            if (errorType == 0) {
                zShowFilamentPreviewView.r(this.f65217e);
                return;
            }
            ms.a.c("ZShowFilamentPreviewView", "updateTemplate registerAIPath failed" + this.f65217e);
            zShowFilamentPreviewView.A(4);
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }
}
