package com.tencent.sqshow.zootopia.avatar.filament;

import a84.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.api.IZPlanModComponentHelper;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zplan.resource.api.IZPlanAvatarInfoHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle;
import com.tencent.sqshow.zootopia.avatar.scene.IAvatarSceneApi;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.scene.component.PageDataType;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import com.tencent.zplan.zplantracing.ZPlanSpanFactory;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nb4.a;
import org.json.JSONObject;
import t74.l;
import uk0.c;
import vk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \n2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002\u009b\u0001B\u0012\u0012\b\u0010\\\u001a\u0004\u0018\u00010U\u00a2\u0006\u0005\b\u009a\u0001\u0010[J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J,\u0010!\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\u0018\u0010'\u001a\u00020\t2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\t2\u0006\u0010+\u001a\u00020-H\u0016J\u0010\u00100\u001a\u00020\t2\u0006\u0010+\u001a\u00020/H\u0016J\u0010\u00102\u001a\u00020\t2\u0006\u0010 \u001a\u000201H\u0016J\u0010\u00105\u001a\u00020\t2\u0006\u00104\u001a\u000203H\u0016J\b\u00106\u001a\u00020\tH\u0016J\b\u00107\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\tH\u0016J\b\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020#H\u0016J\n\u0010<\u001a\u0004\u0018\u00010;H\u0016J\b\u0010>\u001a\u00020=H\u0016J\b\u0010?\u001a\u00020%H\u0016J\b\u0010A\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020BH\u0016J\u0010\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020DH\u0016J\u001a\u0010J\u001a\u00020\t2\u0006\u0010H\u001a\u00020G2\b\u0010I\u001a\u0004\u0018\u00010GH\u0016J\u0018\u0010M\u001a\u00020\t2\u0006\u0010K\u001a\u00020G2\u0006\u0010L\u001a\u00020GH\u0016J\b\u0010N\u001a\u00020\tH\u0016J\u0010\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020GH\u0016J\b\u0010Q\u001a\u00020\tH\u0016J\b\u0010S\u001a\u00020RH\u0016J\b\u0010T\u001a\u00020\tH\u0016R$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u00104\u001a\u00020e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010fR\u0016\u0010i\u001a\u00020g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010s\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010_R\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010z\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010|R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u001b\u0010\u0083\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0086\u0001\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R(\u0010\u0090\u0001\u001a\u0014\u0012\u0004\u0012\u00020D0\u008d\u0001j\t\u0012\u0004\u0012\u00020D`\u008e\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0010\u0010\u008f\u0001R\u0018\u0010\u0092\u0001\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010_R\u001b\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0018\u0010\u0094\u0001R\u0017\u0010\u0096\u0001\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010_R\u0017\u0010\u0097\u0001\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010_R\u0015\u0010\u0098\u0001\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0099\u0001\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0012\u00a8\u0006\u009c\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeComponent;", "Lwb4/a;", "", "La84/a;", "Luk0/e;", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/f;", "Lcom/tencent/sqshow/zootopia/scene/component/c;", "Lcom/tencent/sqshow/zootopia/avatar/filament/g;", "Lcom/tencent/sqshow/zootopia/avatar/filament/h;", "", "a0", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "Lkotlin/Function0;", "cb", "T", "Y", "Z", "W", "X", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout$LayoutParams;", "V", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lod3/b;", "portal", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, UserInfo.SEX_FEMALE, "G", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "params", "", "needWaitEngineInit", "Q2", "Landroid/view/View;", "p4", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "listener", "B6", "Lpd3/a;", "Qf", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "W7", "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", "e9", "Lod3/a;", "scene", "gh", "y", "r", tl.h.F, "N0", "I9", "Landroid/graphics/Bitmap;", "v4", "Lb94/a;", "m8", "isEngineReady", "", "J7", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "g0", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "observer", "q0", "", "event", "data", "l", "type", "eventData", "onEvent", "c", "errMsg", "e", "yd", "Lcom/tencent/sqshow/zootopia/scene/component/PageDataType;", "getType", "d", "Lcom/tencent/zplan/zplantracing/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/zplan/zplantracing/c;", "getZplanSpanContext", "()Lcom/tencent/zplan/zplantracing/c;", "e0", "(Lcom/tencent/zplan/zplantracing/c;)V", "zplanSpanContext", "Ljava/util/concurrent/atomic/AtomicBoolean;", "D", "Ljava/util/concurrent/atomic/AtomicBoolean;", "engineInitStatus", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "E", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "animHelper", "Lcom/tencent/sqshow/zootopia/avatar/filament/PortalBusiness;", "Lcom/tencent/sqshow/zootopia/avatar/filament/PortalBusiness;", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "touchHelper", "Lwk0/a;", "H", "Lwk0/a;", "filamentNativeApp", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeEngineApiImpl;", "I", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeEngineApiImpl;", "engineApi", "J", "filamentInitStatus", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "bgView", "L", "Landroid/view/View;", "filamentTextureView", "M", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "proxyWorldStatusListener", "N", "Lpd3/a;", "proxySceneChangeCallback", "P", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "proxyEngineStatusListener", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", "avatarInitDataContainer", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "sceneInfo", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/zplan/world/model/FirstFrameResult;", "firstFrameResult", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "errorObserver", "U", "startWithEntryRunning", "Lqu4/a;", "Lqu4/a;", "savedAvatarCharacter", "isReleaseFilamentEngineScene", "hasReceivedFirstFrame", "enablePreloadUEAvatar", "enablePreloadUEXW", "<init>", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FilamentNativeComponent extends wb4.a implements a84.a, uk0.e, com.tencent.sqshow.zootopia.avatar.filament.anim.f, com.tencent.sqshow.zootopia.scene.component.c, g, h {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.zplan.zplantracing.c zplanSpanContext;

    /* renamed from: D, reason: from kotlin metadata */
    private AtomicBoolean engineInitStatus = new AtomicBoolean(true);

    /* renamed from: E, reason: from kotlin metadata */
    private final PortalAnimHelper animHelper;

    /* renamed from: F, reason: from kotlin metadata */
    private PortalBusiness scene;

    /* renamed from: G, reason: from kotlin metadata */
    private FilamentTouchHelper touchHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private wk0.a filamentNativeApp;

    /* renamed from: I, reason: from kotlin metadata */
    private FilamentNativeEngineApiImpl engineApi;

    /* renamed from: J, reason: from kotlin metadata */
    private final AtomicBoolean filamentInitStatus;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView bgView;

    /* renamed from: L, reason: from kotlin metadata */
    private View filamentTextureView;

    /* renamed from: M, reason: from kotlin metadata */
    private IZPlanWorldStatusListener proxyWorldStatusListener;

    /* renamed from: N, reason: from kotlin metadata */
    private pd3.a proxySceneChangeCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private ZPlanEngineStatusUpdateListener proxyEngineStatusListener;

    /* renamed from: Q, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.d avatarInitDataContainer;

    /* renamed from: R, reason: from kotlin metadata */
    private SceneInfo sceneInfo;

    /* renamed from: S, reason: from kotlin metadata */
    private FirstFrameResult firstFrameResult;

    /* renamed from: T, reason: from kotlin metadata */
    private final HashSet<com.tencent.sqshow.zootopia.scene.component.d> errorObserver;

    /* renamed from: U, reason: from kotlin metadata */
    private AtomicBoolean startWithEntryRunning;

    /* renamed from: V, reason: from kotlin metadata */
    private qu4.a savedAvatarCharacter;

    /* renamed from: W, reason: from kotlin metadata */
    private AtomicBoolean isReleaseFilamentEngineScene;

    /* renamed from: X, reason: from kotlin metadata */
    private AtomicBoolean hasReceivedFirstFrame;

    /* renamed from: Y, reason: from kotlin metadata */
    private final boolean enablePreloadUEAvatar;

    /* renamed from: Z, reason: from kotlin metadata */
    private final boolean enablePreloadUEXW;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/avatar/filament/FilamentNativeComponent$b", "Luk0/c;", "Landroid/view/Surface;", "surface", "", "width", "height", "", "b", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements uk0.c {
        b() {
        }

        @Override // uk0.c
        public void a(Surface surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            c.a.a(this, surface, width, height);
            QLog.i("FilamentNativeComponent", 1, "onSurfaceChanged");
        }

        @Override // uk0.c
        public void b(Surface surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            c.a.b(this, surface, width, height);
            QLog.i("FilamentNativeComponent", 1, "onSurfaceCreate");
        }

        @Override // uk0.c
        public void onSurfaceDestroyed(Surface surface) {
            c.a.c(this, surface);
        }
    }

    public FilamentNativeComponent(com.tencent.zplan.zplantracing.c cVar) {
        this.zplanSpanContext = cVar;
        PortalAnimHelper portalAnimHelper = new PortalAnimHelper();
        this.animHelper = portalAnimHelper;
        this.scene = new PortalBusiness(portalAnimHelper, this.zplanSpanContext);
        this.touchHelper = new FilamentTouchHelper(this.scene);
        this.filamentInitStatus = new AtomicBoolean(false);
        this.avatarInitDataContainer = com.tencent.sqshow.zootopia.nativeui.data.e.f370980d;
        this.errorObserver = new HashSet<>();
        this.startWithEntryRunning = new AtomicBoolean(false);
        this.isReleaseFilamentEngineScene = new AtomicBoolean(false);
        this.hasReceivedFirstFrame = new AtomicBoolean(false);
        ZPlanQQMC zPlanQQMC = ZPlanQQMC.INSTANCE;
        this.enablePreloadUEAvatar = zPlanQQMC.enablePreloadUEAvatarInPortal();
        this.enablePreloadUEXW = zPlanQQMC.enablePreloadUEXWInPortal();
        portalAnimHelper.S(this);
        this.filamentNativeApp = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, this.zplanSpanContext, FilamentApiImpl.f369933a.e(), null, null, 12, null);
        wk0.a aVar = this.filamentNativeApp;
        Intrinsics.checkNotNull(aVar);
        this.engineApi = new FilamentNativeEngineApiImpl(aVar, this.scene, this.touchHelper);
        this.scene.setRenderListener(this);
    }

    private final void T(final Function0<Unit> cb5) {
        QLog.i("FilamentNativeComponent", 1, "adjustViewPort view:" + this.filamentTextureView);
        final View view = this.filamentTextureView;
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.filament.e
            @Override // java.lang.Runnable
            public final void run() {
                FilamentNativeComponent.U(view, this, cb5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(View textureView, FilamentNativeComponent this$0, Function0 function0) {
        Intrinsics.checkNotNullParameter(textureView, "$textureView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int width = textureView.getWidth();
        int height = textureView.getHeight();
        QLog.i("FilamentNativeComponent", 1, "adjustViewPort width:" + width + ", height:" + height + " view:" + this$0.filamentTextureView);
        this$0.touchHelper.k(width, height);
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final FrameLayout.LayoutParams V(Context context) {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    private final void W() {
        View view = this.filamentTextureView;
        if (view == null) {
            return;
        }
        view.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        View view = this.filamentTextureView;
        if (view == null) {
            return;
        }
        view.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        wk0.a aVar;
        QLog.i("FilamentNativeComponent", 1, "initFilamentRender " + this.filamentInitStatus.get());
        if (this.filamentInitStatus.get()) {
            return;
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            aVar2.t("onFirstFrameRenderEnd", this);
        }
        wk0.a aVar3 = this.filamentNativeApp;
        if (aVar3 != null) {
            aVar3.c("onFirstFrameRenderEnd", this);
        }
        wk0.a aVar4 = this.filamentNativeApp;
        if (aVar4 != null) {
            aVar4.t("onFirstFrameImageReady", this);
        }
        if (!this.isReleaseFilamentEngineScene.get() && (aVar = this.filamentNativeApp) != null) {
            aVar.c("onFirstFrameImageReady", this);
        }
        wk0.a aVar5 = this.filamentNativeApp;
        if (aVar5 != null) {
            aVar5.a(new b());
        }
        this.scene.addListener("onTouchEvent", this);
        this.filamentInitStatus.set(true);
        Z();
    }

    private final void Z() {
        FragmentActivity attachedActivity;
        ViewGroup containerView;
        QLog.i("FilamentNativeComponent", 1, "initFilamentView " + this.filamentTextureView);
        if (this.filamentTextureView != null || (attachedActivity = getAttachedActivity()) == null || (containerView = getContainerView()) == null) {
            return;
        }
        wk0.a aVar = this.filamentNativeApp;
        this.filamentTextureView = aVar != null ? aVar.z(attachedActivity, Boolean.TRUE) : null;
        W();
        containerView.addView(this.filamentTextureView, V(attachedActivity));
    }

    private final void a0() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentNativeComponent$notifyEngineReady$1
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
                ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener;
                ZPlanEngineStatusUpdateListener zPlanEngineStatusUpdateListener2;
                FilamentNativeComponent.this.Y();
                zPlanEngineStatusUpdateListener = FilamentNativeComponent.this.proxyEngineStatusListener;
                if (zPlanEngineStatusUpdateListener != null) {
                    zPlanEngineStatusUpdateListener.serviceConnected(true);
                }
                zPlanEngineStatusUpdateListener2 = FilamentNativeComponent.this.proxyEngineStatusListener;
                if (zPlanEngineStatusUpdateListener2 != null) {
                    zPlanEngineStatusUpdateListener2.engineInitFinish(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(FilamentNativeComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.scene.setNeedFullReloadAfterFirstFrame(false);
        wk0.a aVar = this$0.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, "onCostumeChange", null, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(final FilamentNativeComponent this$0, final long j3, final FirstFrameResult result, final com.tencent.zplan.zplantracing.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.T(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentNativeComponent$onFirstFrame$2$1
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
                IZPlanWorldStatusListener iZPlanWorldStatusListener;
                pd3.a aVar;
                wk0.a aVar2;
                ConcurrentHashMap<String, String> a16 = nb4.a.INSTANCE.a();
                if (a16 != null) {
                    a16.put("post_to_ui_duration", String.valueOf(System.currentTimeMillis() - j3));
                }
                ((IAvatarSceneApi) QRoute.api(IAvatarSceneApi.class)).enterFirstFrame(result.getCurType());
                iZPlanWorldStatusListener = this$0.proxyWorldStatusListener;
                if (iZPlanWorldStatusListener != null) {
                    iZPlanWorldStatusListener.onFirstFrame(result);
                }
                aVar = this$0.proxySceneChangeCallback;
                if (aVar != null) {
                    aVar.a(result);
                }
                aVar2 = this$0.filamentNativeApp;
                if (aVar2 != null) {
                    aVar2.t("onFirstFrameRenderEnd", this$0);
                }
                this$0.X();
                com.tencent.zplan.zplantracing.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.b();
                }
                this$0.e0(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(FilamentNativeComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.errorObserver.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.scene.component.d) it.next()).s(this$0);
        }
    }

    private final void onFirstFrame(final FirstFrameResult result) {
        if (this.scene.getNeedFullReloadAfterFirstFrame()) {
            l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.filament.c
                @Override // java.lang.Runnable
                public final void run() {
                    FilamentNativeComponent.b0(FilamentNativeComponent.this);
                }
            });
        }
        final com.tencent.zplan.zplantracing.b startSpan = ZPlanSpanFactory.INSTANCE.startSpan("onFirstFrameRenderEnd", this.zplanSpanContext);
        this.firstFrameResult = result;
        boolean l06 = this.animHelper.l0();
        QLog.i("FilamentNativeComponent", 1, "onFirstFrame animResStatus:" + l06 + ", result:" + result + ", startWithEntryRunning:" + this.startWithEntryRunning.get());
        if (!l06) {
            if (startSpan != null) {
                startSpan.a("anim res not ready");
                return;
            }
            return;
        }
        boolean compareAndSet = this.hasReceivedFirstFrame.compareAndSet(false, true);
        ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).onFirstFrame(result);
        this.animHelper.n1();
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.filament.d
            @Override // java.lang.Runnable
            public final void run() {
                FilamentNativeComponent.c0(FilamentNativeComponent.this, currentTimeMillis, result, startSpan);
            }
        });
        if (compareAndSet) {
            if (this.enablePreloadUEAvatar) {
                ((IZPlanAvatarInfoHelper) QRoute.api(IZPlanAvatarInfoHelper.class)).preloadUEAvatarSuitInfo();
            }
            if (this.enablePreloadUEXW) {
                QRouteApi api = QRoute.api(IZPlanModComponentHelper.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanModComponentHelper::class.java)");
                IZPlanModComponentHelper.a.a((IZPlanModComponentHelper) api, true, false, 0, 4, null);
            }
        }
    }

    @Override // a84.a
    public void B6(ZPlanEngineStatusUpdateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.proxyEngineStatusListener = listener;
    }

    @Override // wb4.a
    public void F(FragmentActivity activity, QBaseFragment fragment, od3.b portal, ViewGroup container) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        if (LayoutInflater.from(activity).inflate(R.layout.d8q, container, true) == null) {
            return;
        }
        ImageView imageView = (ImageView) container.findViewById(R.id.f163605r12);
        this.bgView = imageView;
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        a0();
    }

    @Override // wb4.a
    public void G() {
        this.scene.setRenderListener(null);
        this.animHelper.f1(this);
        this.proxyWorldStatusListener = null;
    }

    @Override // a84.a
    public SceneInfo I9() {
        SceneInfo sceneInfo = this.sceneInfo;
        return sceneInfo == null ? SceneInfo.INSTANCE.c() : sceneInfo;
    }

    @Override // a84.a
    public int J7() {
        FirstFrameResult firstFrameResult = this.firstFrameResult;
        if (firstFrameResult != null) {
            return firstFrameResult.getCurType();
        }
        return 0;
    }

    @Override // a84.a
    public void N0() {
        ViewGroup containerView;
        a.C0021a.j(this);
        QLog.i("FilamentNativeComponent", 1, "forceReleaseFilamentEngine");
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onDestroy();
        }
        View view = this.filamentTextureView;
        if (view != null && (containerView = getContainerView()) != null) {
            containerView.removeView(view);
        }
        this.filamentTextureView = null;
        this.filamentNativeApp = null;
        this.filamentInitStatus.set(false);
        this.startWithEntryRunning.set(false);
        this.firstFrameResult = null;
        this.sceneInfo = null;
        this.savedAvatarCharacter = this.scene.getAvatarCharacter();
        this.isReleaseFilamentEngineScene.set(true);
    }

    @Override // a84.a
    public void Q2(SceneInfo params, boolean needWaitEngineInit) {
        Intrinsics.checkNotNullParameter(params, "params");
        qu4.a x06 = this.avatarInitDataContainer.x0();
        boolean z16 = x06 != null && this.avatarInitDataContainer.getMInitDataReady();
        boolean z17 = this.filamentInitStatus.get() || !needWaitEngineInit;
        QLog.i("FilamentNativeComponent", 1, "enterAvatarScene avatarDataInit:" + z16 + ", engineInit:" + z17 + ", needWaitEngineInit:" + needWaitEngineInit + ", params:" + params);
        if (z16 && z17 && x06 != null) {
            CameraKey Y = this.avatarInitDataContainer.Y();
            QLog.i("FilamentNativeComponent", 1, "initCameraId:" + Y);
            if (Y != null) {
                this.scene.updateInitCameraId(Y);
            }
            if (this.savedAvatarCharacter != null) {
                m94.a b16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b();
                if (b16.d()) {
                    this.scene.updateAvatarCharacter(b16.getAvatarCharacter());
                } else {
                    PortalBusiness portalBusiness = this.scene;
                    qu4.a aVar = this.savedAvatarCharacter;
                    Intrinsics.checkNotNull(aVar);
                    portalBusiness.updateAvatarCharacter(aVar);
                }
            } else {
                this.scene.updateAvatarCharacter(x06);
            }
            this.sceneInfo = params;
            FirstFrameResult firstFrameResult = this.firstFrameResult;
            ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).onRealEnterAvatar(false);
            if (firstFrameResult == null) {
                if (this.startWithEntryRunning.get()) {
                    QLog.i("FilamentNativeComponent", 1, "startWithEntry is running");
                    return;
                }
                this.startWithEntryRunning.set(true);
                wk0.a aVar2 = this.filamentNativeApp;
                QLog.i("FilamentNativeComponent", 1, "startWithEntry result:" + (aVar2 != null ? Integer.valueOf(aVar2.y("", this.scene)) : null));
                return;
            }
            QLog.i("FilamentNativeComponent", 1, "enterAvatarScene lastResult is ready.");
            ((ILoadingLifeCycle) QRoute.api(ILoadingLifeCycle.class)).markFilamentHotStart();
            int curType = firstFrameResult.getCurType();
            String params2 = firstFrameResult.getParams();
            if (new SceneInfo(curType, params2 != null ? params2 : "").m(params)) {
                QLog.i("FilamentNativeComponent", 1, "isSameScene onFirstFrame");
                onFirstFrame(firstFrameResult);
                return;
            }
            return;
        }
        QLog.i("FilamentNativeComponent", 1, "enterAvatarScene failed, avatarDataInit=" + z16 + ", engineInit=" + z17 + ", avatarCharacter=" + x06);
    }

    @Override // a84.a
    public void Qf(pd3.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.proxySceneChangeCallback = listener;
    }

    @Override // a84.a
    public void W7(IZPlanWorldStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.proxyWorldStatusListener = listener;
    }

    @Override // com.tencent.zplan.world.view.d
    public void a(Surface surface, int i3, int i16) {
        a.C0021a.m(this, surface, i3, i16);
    }

    @Override // com.tencent.zplan.world.view.d
    public void b(Surface surface, int i3, int i16) {
        a.C0021a.n(this, surface, i3, i16);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.anim.f
    public void c() {
        QLog.i("FilamentNativeComponent", 1, "onInitAnimReady " + this.firstFrameResult);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.h
    public void d() {
        pd3.a aVar = this.proxySceneChangeCallback;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.anim.f
    public void e(String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.filament.b
            @Override // java.lang.Runnable
            public final void run() {
                FilamentNativeComponent.d0(FilamentNativeComponent.this);
            }
        });
    }

    public final void e0(com.tencent.zplan.zplantracing.c cVar) {
        this.zplanSpanContext = cVar;
    }

    @Override // a84.a
    public void e9(com.tencent.sqshow.zootopia.nativeui.data.d container) {
        Intrinsics.checkNotNullParameter(container, "container");
        QLog.i("FilamentNativeComponent", 1, "setAvatarInitDataContainer " + container);
        this.avatarInitDataContainer = container;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        a.C0021a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        a.C0021a.c(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean z16) {
        a.C0021a.d(this, z16);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        a.C0021a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        a.C0021a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        a.C0021a.g(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        a.C0021a.h(this);
    }

    @Override // a84.a
    public AvatarEngineType g0() {
        return AvatarEngineType.FILAMENT;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.c
    public PageDataType getType() {
        return PageDataType.ANIM_RES;
    }

    @Override // a84.a
    public void gh(od3.a scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        QLog.i("FilamentNativeComponent", 1, "bindAvatarScene " + scene);
    }

    @Override // wb4.a, od3.d
    public void h() {
        super.h();
        QLog.i("FilamentNativeComponent", 1, "onFragmentDestroy");
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onDestroy();
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            aVar2.a(null);
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        a.C0021a.l(this, i3, str);
    }

    @Override // a84.a
    public boolean isEngineReady() {
        return this.engineInitStatus.get();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.g
    public void l(String event, String data) {
        Intrinsics.checkNotNullParameter(event, "event");
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            b.a.a(aVar, event, data, null, 4, null);
        }
    }

    @Override // a84.a
    public b94.a m8() {
        return this.engineApi;
    }

    @Override // uk0.e
    public void onEvent(String type, String eventData) {
        qu4.h hVar;
        SceneInfo sceneInfo;
        ConcurrentHashMap<String, String> a16;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        int hashCode = type.hashCode();
        TouchEvent touchEvent = null;
        if (hashCode != 361827844) {
            if (hashCode != 1621140201) {
                if (hashCode == 1719579098 && type.equals("onTouchEvent")) {
                    try {
                        touchEvent = (TouchEvent) new Gson().fromJson(eventData, TouchEvent.class);
                    } catch (Exception e16) {
                        QLog.e("FilamentNativeComponent", 1, "onEvent TOUCH_EVENT", e16);
                    }
                    if (touchEvent == null) {
                        return;
                    }
                    this.touchHelper.g(touchEvent);
                    return;
                }
                return;
            }
            if (!type.equals("onFirstFrameRenderEnd") || (sceneInfo = this.sceneInfo) == null) {
                return;
            }
            a.Companion companion = nb4.a.INSTANCE;
            companion.b(new ConcurrentHashMap<>());
            Map<String, String> a17 = com.tencent.zplan.common.utils.h.f385294a.a(eventData);
            if (a17 != null && (a16 = companion.a()) != null) {
                a16.putAll(a17);
            }
            QLog.i("FilamentNativeComponent", 1, "onEvent onFirstFrame");
            onFirstFrame(new FirstFrameResult(sceneInfo.getSceneType(), sceneInfo.getJsonStr()));
            return;
        }
        if (type.equals("onFirstFrameImageReady")) {
            QLog.i("FilamentNativeComponent", 1, "onEvent FIRST_FRAME_IMAGE_READY, eventData=" + eventData);
            wk0.a aVar = this.filamentNativeApp;
            if (aVar != null) {
                aVar.t("onFirstFrameImageReady", this);
            }
            SceneInfo sceneInfo2 = this.sceneInfo;
            if (sceneInfo2 == null) {
                return;
            }
            if (!sceneInfo2.l()) {
                QLog.w("FilamentNativeComponent", 1, "onEvent FIRST_FRAME_IMAGE_READY, not portal scene, no need save first frame");
                return;
            }
            JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(eventData);
            String optString = b16 != null ? b16.optString("imagePath") : null;
            if (optString == null) {
                return;
            }
            if (optString.length() == 0) {
                QLog.e("FilamentNativeComponent", 1, "pngPath empty");
                return;
            }
            dw4.b value = com.tencent.sqshow.dresskey.b.f369818a.l("FilamentNativeComponent_onEvent", true).getValue();
            if (value == null || (hVar = value.f395115b) == null || TextUtils.isEmpty(hVar.f429598b)) {
                return;
            }
            c84.e eVar = c84.e.f30458a;
            String str = value.f395115b.f429598b;
            Intrinsics.checkNotNullExpressionValue(str, "it.dressKey.dressKey");
            eVar.f(optString, str, QQTheme.isNowThemeIsNight());
        }
    }

    @Override // com.tencent.zplan.world.view.d
    public void onSurfaceDestroyed(Surface surface) {
        a.C0021a.o(this, surface);
    }

    @Override // a84.a
    /* renamed from: p4, reason: from getter */
    public View getZplanTextureView() {
        return this.filamentTextureView;
    }

    @Override // a84.a
    public void q0(com.tencent.sqshow.zootopia.scene.component.d observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.errorObserver.add(observer);
    }

    @Override // wb4.a, od3.d
    public void r() {
        super.r();
        QLog.i("FilamentNativeComponent", 1, "onFragmentPause");
        wk0.a aVar = this.filamentNativeApp;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean z16) {
        a.C0021a.p(this, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    @Override // a84.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap v4() {
        Bitmap bitmap;
        TextureView textureView;
        try {
            View zplanTextureView = getZplanTextureView();
            textureView = zplanTextureView instanceof TextureView ? (TextureView) zplanTextureView : null;
        } catch (OutOfMemoryError unused) {
            QLog.e("FilamentNativeComponent", 1, "captureFrame OutOfMemory!");
        }
        if (textureView != null) {
            bitmap = textureView.getBitmap();
            QLog.i("FilamentNativeComponent", 1, "captureFrame bitmap.width=" + (bitmap == null ? Integer.valueOf(bitmap.getWidth()) : null) + ", bitmap.height=" + (bitmap != null ? Integer.valueOf(bitmap.getHeight()) : null));
            return bitmap;
        }
        bitmap = null;
        if (bitmap == null) {
        }
        if (bitmap != null) {
        }
        QLog.i("FilamentNativeComponent", 1, "captureFrame bitmap.width=" + (bitmap == null ? Integer.valueOf(bitmap.getWidth()) : null) + ", bitmap.height=" + (bitmap != null ? Integer.valueOf(bitmap.getHeight()) : null));
        return bitmap;
    }

    @Override // wb4.a, od3.d
    public void y() {
        super.y();
        QLog.i("FilamentNativeComponent", 1, "onFragmentResume");
        if (this.filamentNativeApp == null && this.isReleaseFilamentEngineScene.get()) {
            QLog.i("FilamentNativeComponent", 1, "recover filamentNativeApp");
            this.filamentNativeApp = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, FilamentApiImpl.f369933a.e(), null, null, 12, null);
            PortalBusiness portalBusiness = new PortalBusiness(this.animHelper, this.zplanSpanContext);
            this.scene = portalBusiness;
            this.touchHelper.j(portalBusiness);
            this.engineApi.z(this.scene);
            FilamentNativeEngineApiImpl filamentNativeEngineApiImpl = this.engineApi;
            wk0.a aVar = this.filamentNativeApp;
            Intrinsics.checkNotNull(aVar);
            filamentNativeEngineApiImpl.y(aVar);
            Y();
        }
        wk0.a aVar2 = this.filamentNativeApp;
        if (aVar2 != null) {
            aVar2.onResume();
        }
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.c
    public void yd() {
        QLog.i("FilamentNativeComponent", 1, "pageDataErrorRetry");
        final FilamentViewerV2 viewerV2 = this.scene.getViewerV2();
        if (viewerV2 != null) {
            this.scene.doTask("reloadInitAnim", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.filament.FilamentNativeComponent$pageDataErrorRetry$1$1
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
                    PortalAnimHelper portalAnimHelper;
                    portalAnimHelper = FilamentNativeComponent.this.animHelper;
                    portalAnimHelper.e1(viewerV2);
                }
            });
        }
    }
}
