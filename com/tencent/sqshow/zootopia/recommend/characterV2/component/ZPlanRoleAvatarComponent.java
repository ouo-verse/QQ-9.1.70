package com.tencent.sqshow.zootopia.recommend.characterV2.component;

import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.business.api.IBusinessScene;
import com.tencent.filament.zplan.business.api.SceneType;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.sharedengine.ZPlanShareEngineScene;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentNativeEngineApiImpl;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentTouchHelper;
import com.tencent.sqshow.zootopia.avatar.filament.IPortalBusiness;
import com.tencent.sqshow.zootopia.avatar.filament.PortalBusiness;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.recommend.characterV2.event.OnRoleTouchTapClickEvent;
import com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRoleMidTouchTap;
import com.tencent.sqshow.zootopia.scene.component.PageDataType;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nb4.a;
import org.json.JSONObject;
import r74.b;
import t74.l;
import uk0.c;
import vk0.b;

@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u008f\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002\u0090\u0001B\u001f\u0012\b\u0010N\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010O\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J,\u0010%\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u00020\f2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010'H\u0016J\b\u0010+\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\fH\u0016J\u0010\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020'H\u0016J\b\u0010/\u001a\u00020\fH\u0016J\b\u00101\u001a\u000200H\u0016J\u001a\u00105\u001a\u00020\n2\u0006\u00102\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0010\u00107\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0007H\u0016J\n\u00109\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0004H\u0016J\b\u0010;\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020\fH\u0016J\b\u0010>\u001a\u00020=H\u0016J\u0010\u0010@\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020?H\u0016J\u0018\u0010C\u001a\u00020\f2\u0006\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020'H\u0016J\b\u0010D\u001a\u00020\fH\u0016J\b\u0010E\u001a\u00020\fH\u0016J\b\u0010F\u001a\u00020\fH\u0016R$\u0010N\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010R\u001a\u0004\u0018\u00010O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010xR\u0018\u0010|\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010}R)\u0010\u0083\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0080\u00010\u007fj\n\u0012\u0005\u0012\u00030\u0080\u0001`\u0081\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\r\u0010\u0082\u0001R\u0017\u0010\u0086\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u000e\u0010\u0085\u0001R\u0017\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u000b\u0010\u0085\u0001R \u0010\u008c\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0005\bz\u0010\u008b\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleAvatarComponent;", "Lwb4/a;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/f;", "Lcom/tencent/sqshow/zootopia/avatar/filament/h;", "Lcom/tencent/sqshow/zootopia/scene/component/c;", "Lcom/tencent/sqshow/zootopia/avatar/filament/g;", "Luk0/e;", "Lbb4/h;", "Lvk0/d;", "", "V", "", "T", "U", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, ExifInterface.LATITUDE_SOUTH, "Landroid/widget/FrameLayout$LayoutParams;", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", com.tencent.luggage.wxa.c8.c.f123400v, "c0", "Lcom/tencent/filament/zplan/business/api/IBusinessScene;", "oldScene", "newScene", "C4", "y", "r", tl.h.F, "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lod3/b;", "portal", UserInfo.SEX_FEMALE, "G", "", "event", "data", "l", "d", "c", "errMsg", "e", "yd", "Lcom/tencent/sqshow/zootopia/scene/component/PageDataType;", "getType", "entry", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "params", "b0", "listener", "Z", "Lb94/a;", "m8", "a0", "Y", "N0", "Lqu4/a;", DomainData.DOMAIN_NAME, "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", "e9", "type", "eventData", "onEvent", NodeProps.ON_CLICK, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "Lcom/tencent/zplan/zplantracing/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/zplan/zplantracing/c;", "getZplanSpanContext", "()Lcom/tencent/zplan/zplantracing/c;", "setZplanSpanContext", "(Lcom/tencent/zplan/zplantracing/c;)V", "zplanSpanContext", "", "D", "Ljava/lang/Integer;", "nativeAppId", "Lwk0/a;", "E", "Lwk0/a;", "filamentEngine", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "Lcom/tencent/sqshow/zootopia/avatar/filament/anim/PortalAnimHelper;", "animHelper", "Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;", "Lcom/tencent/sqshow/zootopia/avatar/filament/IPortalBusiness;", "scene", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "H", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentTouchHelper;", "touchHelper", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeEngineApiImpl;", "I", "Lcom/tencent/sqshow/zootopia/avatar/filament/FilamentNativeEngineApiImpl;", "engineApi", "J", "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", "avatarInitDataContainer", "K", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "sceneInfo", "L", "Lqu4/a;", "savedAvatarCharacter", "M", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "N", "Landroid/view/ViewGroup;", "avatarContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "backgroundImageView", "Landroid/view/View;", "Landroid/view/View;", "avatarTextureView", BdhLogUtil.LogTag.Tag_Req, "Luk0/e;", "engineListener", "Lcom/tencent/sqshow/zootopia/avatar/filament/h;", "sceneRenderListener", "Ljava/util/HashSet;", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "errorObserver", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasForceRelease", "filamentInitStatus", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "W", "Lkotlin/Lazy;", "()Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "<init>", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/Integer;)V", "X", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRoleAvatarComponent extends wb4.a implements a, com.tencent.sqshow.zootopia.avatar.filament.anim.f, com.tencent.sqshow.zootopia.avatar.filament.h, com.tencent.sqshow.zootopia.scene.component.c, com.tencent.sqshow.zootopia.avatar.filament.g, uk0.e, bb4.h, vk0.d {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.zplan.zplantracing.c zplanSpanContext;

    /* renamed from: D, reason: from kotlin metadata */
    private final Integer nativeAppId;

    /* renamed from: E, reason: from kotlin metadata */
    private wk0.a filamentEngine;

    /* renamed from: F, reason: from kotlin metadata */
    private final PortalAnimHelper animHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private IPortalBusiness scene;

    /* renamed from: H, reason: from kotlin metadata */
    private FilamentTouchHelper touchHelper;

    /* renamed from: I, reason: from kotlin metadata */
    private FilamentNativeEngineApiImpl engineApi;

    /* renamed from: J, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.d avatarInitDataContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private SceneInfo sceneInfo;

    /* renamed from: L, reason: from kotlin metadata */
    private qu4.a savedAvatarCharacter;

    /* renamed from: M, reason: from kotlin metadata */
    private FragmentActivity fragmentActivity;

    /* renamed from: N, reason: from kotlin metadata */
    private ViewGroup avatarContainer;

    /* renamed from: P, reason: from kotlin metadata */
    private ImageView backgroundImageView;

    /* renamed from: Q, reason: from kotlin metadata */
    private View avatarTextureView;

    /* renamed from: R, reason: from kotlin metadata */
    private uk0.e engineListener;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.avatar.filament.h sceneRenderListener;

    /* renamed from: T, reason: from kotlin metadata */
    private final HashSet<com.tencent.sqshow.zootopia.scene.component.d> errorObserver;

    /* renamed from: U, reason: from kotlin metadata */
    private final AtomicBoolean hasForceRelease;

    /* renamed from: V, reason: from kotlin metadata */
    private final AtomicBoolean filamentInitStatus;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy reportHelper;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleAvatarComponent$b", "Lr74/b$a$a;", "", "oldState", "newState", "", "onStateChange", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements b.Companion.InterfaceC11119a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanShareEngineScene f372416b;

        b(ZPlanShareEngineScene zPlanShareEngineScene) {
            this.f372416b = zPlanShareEngineScene;
        }

        @Override // r74.b.Companion.InterfaceC11119a
        public void onStateChange(int oldState, int newState) {
            QLog.i("portal_ZPlanRoleAvatarComponent", 1, "oldState:" + oldState + ", newState:" + newState);
            if (newState != 1) {
                wk0.a aVar = ZPlanRoleAvatarComponent.this.filamentEngine;
                if (aVar != null) {
                    b.a.a(aVar, "onCostumeChange", null, null, 4, null);
                }
                this.f372416b.setAnimStateChangeListener(null);
            }
        }
    }

    public ZPlanRoleAvatarComponent(com.tencent.zplan.zplantracing.c cVar, Integer num) {
        Lazy lazy;
        this.zplanSpanContext = cVar;
        this.nativeAppId = num;
        PortalAnimHelper portalAnimHelper = new PortalAnimHelper();
        this.animHelper = portalAnimHelper;
        this.touchHelper = new FilamentTouchHelper(this.scene);
        this.errorObserver = new HashSet<>();
        this.hasForceRelease = new AtomicBoolean(false);
        this.filamentInitStatus = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZplanViewReportHelper>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleAvatarComponent$reportHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanViewReportHelper invoke() {
                return new ZplanViewReportHelper();
            }
        });
        this.reportHelper = lazy;
        T();
        U();
        IPortalBusiness iPortalBusiness = this.scene;
        if (iPortalBusiness != null) {
            iPortalBusiness.addListener("onTouchEvent", this);
        }
        IPortalBusiness iPortalBusiness2 = this.scene;
        if (iPortalBusiness2 != null) {
            iPortalBusiness2.setRenderListener(this);
        }
        portalAnimHelper.S(this);
        IPortalBusiness iPortalBusiness3 = this.scene;
        if (iPortalBusiness3 != null) {
            this.touchHelper.j(iPortalBusiness3);
            wk0.a aVar = this.filamentEngine;
            Intrinsics.checkNotNull(aVar);
            this.engineApi = new FilamentNativeEngineApiImpl(aVar, iPortalBusiness3, this.touchHelper);
        }
    }

    private final FrameLayout.LayoutParams P() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    private final void Q() {
        IPortalBusiness iPortalBusiness = this.scene;
        ZPlanShareEngineScene zPlanShareEngineScene = iPortalBusiness instanceof ZPlanShareEngineScene ? (ZPlanShareEngineScene) iPortalBusiness : null;
        if (zPlanShareEngineScene != null) {
            int animStateType = zPlanShareEngineScene.getAnimStateType();
            QLog.i("portal_ZPlanRoleAvatarComponent", 1, "startFilamentEngine isNativeAppReuse, animStateType:" + animStateType);
            if (animStateType != 1) {
                wk0.a aVar = this.filamentEngine;
                if (aVar != null) {
                    b.a.a(aVar, "onCostumeChange", null, null, 4, null);
                    return;
                }
                return;
            }
            zPlanShareEngineScene.setAnimStateChangeListener(new b(zPlanShareEngineScene));
        }
    }

    private final ZplanViewReportHelper R() {
        return (ZplanViewReportHelper) this.reportHelper.getValue();
    }

    private final void T() {
        if (this.filamentInitStatus.get()) {
            return;
        }
        wk0.a a16 = FilamentRenderFactory.f105773b.a(this.zplanSpanContext, FilamentApiImpl.f369933a.e(), Boolean.valueOf(V()), this.nativeAppId);
        a16.a(new uk0.c() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleAvatarComponent$initEngine$1$1
            @Override // uk0.c
            public void a(Surface surface, final int width, final int height) {
                Intrinsics.checkNotNullParameter(surface, "surface");
                c.a.a(this, surface, width, height);
                final ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = ZPlanRoleAvatarComponent.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleAvatarComponent$initEngine$1$1$onSurfaceChanged$1
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
                        FilamentTouchHelper filamentTouchHelper;
                        filamentTouchHelper = ZPlanRoleAvatarComponent.this.touchHelper;
                        filamentTouchHelper.k(width, height);
                    }
                });
            }

            @Override // uk0.c
            public void b(Surface surface, final int width, final int height) {
                Intrinsics.checkNotNullParameter(surface, "surface");
                c.a.b(this, surface, width, height);
                final ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = ZPlanRoleAvatarComponent.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleAvatarComponent$initEngine$1$1$onSurfaceCreate$1
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
                        FilamentTouchHelper filamentTouchHelper;
                        filamentTouchHelper = ZPlanRoleAvatarComponent.this.touchHelper;
                        filamentTouchHelper.k(width, height);
                    }
                });
            }

            @Override // uk0.c
            public void onSurfaceDestroyed(Surface surface) {
                c.a.c(this, surface);
            }
        });
        a16.c("onFilamentRenderFail", this);
        this.filamentInitStatus.set(true);
        this.filamentEngine = a16;
    }

    private final void U() {
        PortalBusiness portalBusiness = new PortalBusiness(this.animHelper, this.zplanSpanContext);
        if (!V()) {
            this.scene = portalBusiness;
            return;
        }
        wk0.a aVar = this.filamentEngine;
        PortalBusiness portalBusiness2 = portalBusiness;
        if (aVar != null) {
            Object scene = aVar.getScene();
            portalBusiness2 = portalBusiness;
            if (scene != null) {
                Object obj = portalBusiness;
                if (scene instanceof ZPlanShareEngineScene) {
                    ZPlanShareEngineScene zPlanShareEngineScene = (ZPlanShareEngineScene) scene;
                    zPlanShareEngineScene.initScene(portalBusiness);
                    zPlanShareEngineScene.addSceneChangeListener(this);
                    CameraParams b16 = b84.a.f28061a.b(new CameraKey(2000011, 0, 2, null), zPlanShareEngineScene.getBodyTypeName());
                    PortalAnimHelper portalAnimHelper = this.animHelper;
                    String json = new Gson().toJson(b16);
                    Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(cameraCfg)");
                    portalAnimHelper.h1(json);
                    obj = scene;
                }
                portalBusiness2 = (IPortalBusiness) obj;
            }
        }
        this.scene = portalBusiness2;
    }

    private final boolean V() {
        Integer num = this.nativeAppId;
        return num != null && num.intValue() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(ZPlanRoleAvatarComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IPortalBusiness iPortalBusiness = this$0.scene;
        if (iPortalBusiness != null) {
            iPortalBusiness.setPortalNeedFullReloadAfterFirstFrame(false);
        }
        wk0.a aVar = this$0.filamentEngine;
        if (aVar != null) {
            b.a.a(aVar, "onCostumeChange", null, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(String eventData) {
        qu4.h hVar;
        Intrinsics.checkNotNullParameter(eventData, "$eventData");
        JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(eventData);
        String optString = b16 != null ? b16.optString("imagePath") : null;
        if (optString == null) {
            return;
        }
        if (optString.length() == 0) {
            QLog.e("portal_ZPlanRoleAvatarComponent", 1, "pngPath empty");
            return;
        }
        dw4.b value = com.tencent.sqshow.dresskey.b.f369818a.l("portal_ZPlanRoleAvatarComponent_onEvent", true).getValue();
        if (value == null || (hVar = value.f395115b) == null || TextUtils.isEmpty(hVar.f429598b)) {
            return;
        }
        c84.e eVar = c84.e.f30458a;
        String str = value.f395115b.f429598b;
        Intrinsics.checkNotNullExpressionValue(str, "it.dressKey.dressKey");
        eVar.f(optString, str, QQTheme.isNowThemeIsNight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(float alpha) {
        View view = this.avatarTextureView;
        if (view == null) {
            return;
        }
        view.setAlpha(alpha);
    }

    @Override // vk0.d
    public void C4(IBusinessScene oldScene, IBusinessScene newScene) {
        Intrinsics.checkNotNullParameter(oldScene, "oldScene");
        Intrinsics.checkNotNullParameter(newScene, "newScene");
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, "onSceneChange, oldScene=" + oldScene + ", newScene=" + newScene);
        if (newScene.getSceneType() == SceneType.PORTAL) {
            return;
        }
        wk0.a aVar = this.filamentEngine;
        if (aVar != null) {
            aVar.t("onFirstFrameRenderEnd", this);
        }
        wk0.a aVar2 = this.filamentEngine;
        if (aVar2 != null) {
            aVar2.t("onFirstFrameImageReady", this);
        }
        wk0.a aVar3 = this.filamentEngine;
        if (aVar3 != null) {
            aVar3.t("onFilamentRenderFail", this);
        }
        IPortalBusiness iPortalBusiness = oldScene instanceof IPortalBusiness ? (IPortalBusiness) oldScene : null;
        if (iPortalBusiness != null) {
            iPortalBusiness.removeListener("onTouchEvent", this);
        }
    }

    @Override // wb4.a
    public void F(FragmentActivity activity, QBaseFragment fragment, od3.b portal, ViewGroup container) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, "onBindView");
        this.fragmentActivity = activity;
        this.avatarContainer = container;
        if (container instanceof ZPlanRoleMidTouchTap) {
            Intrinsics.checkNotNull(container, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRoleMidTouchTap");
            ((ZPlanRoleMidTouchTap) container).setListener(this);
        }
        S(activity, container);
        if (!V()) {
            c0(0.0f);
        }
        URLImageView uRLImageView = new URLImageView(activity);
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        uRLImageView.setLayoutParams(P());
        if (QQTheme.isNowThemeIsNight()) {
            str = "https://static-res.qq.com/static-res/zplan/background/zplan_bg_dark.png";
        } else {
            str = "https://static-res.qq.com/static-res/zplan/background/zplan_bg_light.png";
        }
        CommonExKt.v(uRLImageView, str, R.drawable.qui_common_bg_bottom_standard_bg, null, 4, null);
        this.backgroundImageView = uRLImageView;
        container.addView(uRLImageView, 0);
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.component.a
    public void N0() {
        ViewGroup viewGroup;
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, "forceReleaseFilamentEngine");
        if (V()) {
            QLog.i("portal_ZPlanRoleAvatarComponent", 1, "forceReleaseFilamentEngine disable, nativeApp is reused");
            return;
        }
        this.hasForceRelease.set(true);
        this.filamentInitStatus.set(false);
        wk0.a aVar = this.filamentEngine;
        if (aVar != null) {
            aVar.onDestroy();
        }
        View view = this.avatarTextureView;
        if (view != null && (viewGroup = this.avatarContainer) != null) {
            viewGroup.removeView(view);
        }
        this.avatarTextureView = null;
        this.filamentEngine = null;
        this.sceneInfo = null;
        IPortalBusiness iPortalBusiness = this.scene;
        this.savedAvatarCharacter = iPortalBusiness != null ? iPortalBusiness.getAvatarCharacter() : null;
    }

    public void Y() {
        ViewGroup viewGroup = this.avatarContainer;
        if (viewGroup != null) {
            R().g(viewGroup, "em_zplan_avatar_show", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    public void Z(uk0.e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.engineListener = listener;
    }

    public void a0(com.tencent.sqshow.zootopia.avatar.filament.h listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sceneRenderListener = listener;
    }

    public boolean b0(String entry, SceneInfo params) {
        boolean z16;
        IPortalBusiness iPortalBusiness;
        Intrinsics.checkNotNullParameter(entry, "entry");
        com.tencent.sqshow.zootopia.nativeui.data.d dVar = this.avatarInitDataContainer;
        qu4.a x06 = dVar != null ? dVar.x0() : null;
        if (x06 != null) {
            com.tencent.sqshow.zootopia.nativeui.data.d dVar2 = this.avatarInitDataContainer;
            if (dVar2 != null ? dVar2.getMInitDataReady() : false) {
                z16 = true;
                if (!z16 && x06 != null) {
                    com.tencent.sqshow.zootopia.nativeui.data.d dVar3 = this.avatarInitDataContainer;
                    CameraKey Y = dVar3 != null ? dVar3.Y() : null;
                    QLog.i("portal_ZPlanRoleAvatarComponent", 1, "initCameraId:" + Y);
                    if (Y != null && (iPortalBusiness = this.scene) != null) {
                        iPortalBusiness.updateInitCameraId(Y);
                    }
                    if (this.savedAvatarCharacter != null) {
                        m94.a b16 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b();
                        if (b16.d()) {
                            IPortalBusiness iPortalBusiness2 = this.scene;
                            if (iPortalBusiness2 != null) {
                                iPortalBusiness2.updateAvatarCharacter(b16.getAvatarCharacter());
                            }
                        } else {
                            IPortalBusiness iPortalBusiness3 = this.scene;
                            if (iPortalBusiness3 != null) {
                                qu4.a aVar = this.savedAvatarCharacter;
                                Intrinsics.checkNotNull(aVar);
                                iPortalBusiness3.updateAvatarCharacter(aVar);
                            }
                        }
                    } else {
                        IPortalBusiness iPortalBusiness4 = this.scene;
                        if (iPortalBusiness4 != null) {
                            iPortalBusiness4.updateAvatarCharacter(x06);
                        }
                    }
                    this.sceneInfo = params;
                    wk0.a aVar2 = this.filamentEngine;
                    if (aVar2 != null) {
                        aVar2.c("onFirstFrameRenderEnd", this);
                    }
                    if (V()) {
                        Q();
                    } else {
                        wk0.a aVar3 = this.filamentEngine;
                        if (aVar3 != null) {
                            aVar3.c("onFirstFrameImageReady", this);
                        }
                        wk0.a aVar4 = this.filamentEngine;
                        if (aVar4 != null) {
                            IPortalBusiness iPortalBusiness5 = this.scene;
                            Intrinsics.checkNotNull(iPortalBusiness5);
                            aVar4.y(entry, iPortalBusiness5);
                        }
                    }
                    return true;
                }
                QLog.e("portal_ZPlanRoleAvatarComponent", 1, "startWithEntry failed, avatarDataInit=" + z16 + ", avatarCharacter=" + x06 + ", return.");
                return false;
            }
        }
        z16 = false;
        if (!z16) {
        }
        QLog.e("portal_ZPlanRoleAvatarComponent", 1, "startWithEntry failed, avatarDataInit=" + z16 + ", avatarCharacter=" + x06 + ", return.");
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.anim.f
    public void e(String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, "onInitAnimLoadFailed " + errMsg);
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleAvatarComponent$onInitAnimLoadFailed$1
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
                HashSet hashSet;
                hashSet = ZPlanRoleAvatarComponent.this.errorObserver;
                ZPlanRoleAvatarComponent zPlanRoleAvatarComponent = ZPlanRoleAvatarComponent.this;
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((com.tencent.sqshow.zootopia.scene.component.d) it.next()).s(zPlanRoleAvatarComponent);
                }
            }
        });
    }

    public void e9(com.tencent.sqshow.zootopia.nativeui.data.d container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.avatarInitDataContainer = container;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.c
    public PageDataType getType() {
        return PageDataType.ANIM_RES;
    }

    @Override // wb4.a, od3.d
    public void h() {
        wk0.a aVar;
        super.h();
        wk0.a aVar2 = this.filamentEngine;
        if (aVar2 != null) {
            aVar2.a(null);
        }
        this.animHelper.f1(this);
        IPortalBusiness iPortalBusiness = this.scene;
        if (iPortalBusiness != null) {
            iPortalBusiness.setRenderListener(null);
        }
        IPortalBusiness iPortalBusiness2 = this.scene;
        ZPlanShareEngineScene zPlanShareEngineScene = iPortalBusiness2 instanceof ZPlanShareEngineScene ? (ZPlanShareEngineScene) iPortalBusiness2 : null;
        if (zPlanShareEngineScene != null) {
            zPlanShareEngineScene.removeSceneChangeListener(this);
        }
        IPortalBusiness iPortalBusiness3 = this.scene;
        ZPlanShareEngineScene zPlanShareEngineScene2 = iPortalBusiness3 instanceof ZPlanShareEngineScene ? (ZPlanShareEngineScene) iPortalBusiness3 : null;
        if (zPlanShareEngineScene2 != null) {
            zPlanShareEngineScene2.removeListener("onTouchEvent", this);
        }
        if (V() || (aVar = this.filamentEngine) == null) {
            return;
        }
        aVar.onDestroy();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.g
    public void l(String event, String data) {
        Intrinsics.checkNotNullParameter(event, "event");
        wk0.a aVar = this.filamentEngine;
        if (aVar != null) {
            b.a.a(aVar, event, data, null, 4, null);
        }
    }

    public b94.a m8() {
        return this.engineApi;
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.component.a
    public qu4.a n() {
        qu4.a avatarCharacter;
        IPortalBusiness iPortalBusiness = this.scene;
        return (iPortalBusiness == null || (avatarCharacter = iPortalBusiness.getAvatarCharacter()) == null) ? new qu4.a() : avatarCharacter;
    }

    @Override // bb4.h
    public void onClick() {
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, NodeProps.ON_CLICK);
        if (com.tencent.sqshow.zootopia.utils.h.a()) {
            QLog.w("portal_ZPlanRoleAvatarComponent", 1, "onClick DoubleClick!");
            return;
        }
        ViewGroup viewGroup = this.avatarContainer;
        if (viewGroup != null) {
            ZplanViewReportHelper.f(R(), viewGroup, "em_zplan_avatar_show", null, 4, null);
        }
        SimpleEventBus.getInstance().dispatchEvent(new OnRoleTouchTapClickEvent());
    }

    @Override // uk0.e
    public void onEvent(String type, final String eventData) {
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
                        QLog.e("portal_ZPlanRoleAvatarComponent", 1, "onEvent TOUCH_EVENT", e16);
                    }
                    if (touchEvent != null) {
                        this.touchHelper.g(touchEvent);
                    }
                }
            } else if (type.equals("onFirstFrameRenderEnd")) {
                QLog.i("portal_ZPlanRoleAvatarComponent", 1, "onEvent, " + type + ", " + eventData);
                a.Companion companion = nb4.a.INSTANCE;
                companion.b(new ConcurrentHashMap<>());
                Map<String, String> a17 = com.tencent.zplan.common.utils.h.f385294a.a(eventData);
                if (a17 != null && (a16 = companion.a()) != null) {
                    a16.putAll(a17);
                }
                wk0.a aVar = this.filamentEngine;
                if (aVar != null) {
                    aVar.t("onFirstFrameRenderEnd", this);
                }
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleAvatarComponent$onEvent$2
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
                        PortalAnimHelper portalAnimHelper;
                        ZPlanRoleAvatarComponent.this.c0(1.0f);
                        portalAnimHelper = ZPlanRoleAvatarComponent.this.animHelper;
                        portalAnimHelper.n1();
                    }
                });
                IPortalBusiness iPortalBusiness = this.scene;
                if (iPortalBusiness != null ? iPortalBusiness.getPortalNeedFullReloadAfterFirstFrame() : false) {
                    l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZPlanRoleAvatarComponent.W(ZPlanRoleAvatarComponent.this);
                        }
                    });
                }
            }
        } else if (type.equals("onFirstFrameImageReady")) {
            QLog.i("portal_ZPlanRoleAvatarComponent", 1, "onEvent FIRST_FRAME_IMAGE_READY, eventData=" + eventData);
            wk0.a aVar2 = this.filamentEngine;
            if (aVar2 != null) {
                aVar2.t("onFirstFrameImageReady", this);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.e
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanRoleAvatarComponent.X(eventData);
                }
            }, 16, null, false);
        }
        uk0.e eVar = this.engineListener;
        if (eVar != null) {
            eVar.onEvent(type, eventData);
        }
    }

    @Override // wb4.a, od3.d
    public void r() {
        super.r();
        wk0.a aVar = this.filamentEngine;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // wb4.a, od3.d
    public void y() {
        super.y();
        if (this.filamentEngine == null) {
            T();
            U();
            IPortalBusiness iPortalBusiness = this.scene;
            if (iPortalBusiness != null) {
                iPortalBusiness.addListener("onTouchEvent", this);
                iPortalBusiness.setRenderListener(this);
                this.touchHelper.j(iPortalBusiness);
                FilamentNativeEngineApiImpl filamentNativeEngineApiImpl = this.engineApi;
                if (filamentNativeEngineApiImpl != null) {
                    filamentNativeEngineApiImpl.z(iPortalBusiness);
                }
            }
            FilamentNativeEngineApiImpl filamentNativeEngineApiImpl2 = this.engineApi;
            if (filamentNativeEngineApiImpl2 != null) {
                wk0.a aVar = this.filamentEngine;
                Intrinsics.checkNotNull(aVar);
                filamentNativeEngineApiImpl2.y(aVar);
            }
        }
        if (this.avatarTextureView == null) {
            S(this.fragmentActivity, this.avatarContainer);
        }
        if (this.hasForceRelease.get()) {
            this.hasForceRelease.set(false);
            b0("", null);
        }
        wk0.a aVar2 = this.filamentEngine;
        if (aVar2 != null) {
            aVar2.onResume();
        }
    }

    @Override // wb4.a
    public void G() {
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        IPortalBusiness iPortalBusiness = this.scene;
        ZPlanShareEngineScene zPlanShareEngineScene = iPortalBusiness instanceof ZPlanShareEngineScene ? (ZPlanShareEngineScene) iPortalBusiness : null;
        if (zPlanShareEngineScene != null) {
            zPlanShareEngineScene.removeSceneChangeListener(this);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.anim.f
    public void c() {
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, "onInitAnimReady");
    }

    @Override // com.tencent.sqshow.zootopia.avatar.filament.h
    public void d() {
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, "onRenderComplete");
        com.tencent.sqshow.zootopia.avatar.filament.h hVar = this.sceneRenderListener;
        if (hVar != null) {
            hVar.d();
        }
    }

    @Override // bb4.h
    public void q() {
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, "onLeftFlip");
    }

    @Override // bb4.h
    public void w() {
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, "onRightFlip");
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.c
    public void yd() {
        final FilamentViewerV2 viewer;
        IPortalBusiness iPortalBusiness;
        QLog.i("portal_ZPlanRoleAvatarComponent", 1, "pageDataErrorRetry");
        IPortalBusiness iPortalBusiness2 = this.scene;
        if (iPortalBusiness2 == null || (viewer = iPortalBusiness2.getViewer()) == null || (iPortalBusiness = this.scene) == null) {
            return;
        }
        iPortalBusiness.runOnViewerThread("reloadInitAnim", new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleAvatarComponent$pageDataErrorRetry$1$1
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
                portalAnimHelper = ZPlanRoleAvatarComponent.this.animHelper;
                portalAnimHelper.e1(viewer);
            }
        });
    }

    private final void S(FragmentActivity activity, ViewGroup container) {
        wk0.a aVar;
        View z16;
        View view = null;
        if (activity != null && (aVar = this.filamentEngine) != null && (z16 = aVar.z(activity, Boolean.TRUE)) != null) {
            z16.setLayoutParams(P());
            z16.setTranslationY(0.0f);
            view = z16;
        }
        this.avatarTextureView = view;
        if (view == null || container == null) {
            return;
        }
        container.addView(view);
    }
}
