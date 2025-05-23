package com.tencent.qqnt.aio.helper;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.filament.zplan.scene.couple.CoupleAvatarScene;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.aio.IZPlanAIOHelper;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarLayoutEvent;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSubScene;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanQQMC;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.SplashAIOFragment;
import com.tencent.qqnt.aio.helper.ZPlanCoupleAvatarHelper$whiteListListener$2;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import wk3.CoupleAvatarDestroyConfig;

@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001I\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001UB\u0007\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0019H\u0016J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u001a\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00105R\u0016\u00109\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010BR\u0016\u0010E\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010GR\u001b\u0010L\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010=\u001a\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010Q\u00a8\u0006V"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ZPlanCoupleAvatarHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mobileqq/zplan/aio/couple/g;", "", "isHideMode", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "p", UserInfo.SEX_FEMALE, "B", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", ReportConstant.COSTREPORT_PREFIX, "G", "", "data", "t", "w", "Lcom/tencent/filament/zplan/scene/couple/CoupleAvatarScene$AvatarTarget;", "avatarTarget", "v", "u", "D", BdhLogUtil.LogTag.Tag_Conn, "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "E", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarLayoutEvent;", "event", tl.h.F, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "Lcom/tencent/aio/main/businesshelper/b;", "mParam", "Lcom/tencent/mobileqq/zplan/aio/couple/i;", "f", "Lcom/tencent/mobileqq/zplan/aio/couple/i;", "mViewController", "Lcom/tencent/mobileqq/zplan/couple/manager/a;", "Lcom/tencent/mobileqq/zplan/couple/manager/a;", "bubblePlayManager", "i", "Z", "coupleAvatarSwitch", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hasRegistered", "Lwk3/a;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lwk3/a;", "destroyWhenPauseConfig", "", "J", "startTimeMillis", "I", "pauseCount", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isAIOHideMode", "com/tencent/qqnt/aio/helper/ZPlanCoupleAvatarHelper$whiteListListener$2$a", "r", "()Lcom/tencent/qqnt/aio/helper/ZPlanCoupleAvatarHelper$whiteListListener$2$a;", "whiteListListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "destroyRunnable", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/a;", "mAction1", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanCoupleAvatarHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mobileqq.zplan.aio.couple.g {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy destroyWhenPauseConfig;

    /* renamed from: D, reason: from kotlin metadata */
    private long startTimeMillis;

    /* renamed from: E, reason: from kotlin metadata */
    private int pauseCount;

    /* renamed from: F, reason: from kotlin metadata */
    private final AtomicBoolean isAIOHideMode;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy whiteListListener;

    /* renamed from: H, reason: from kotlin metadata */
    private final Runnable destroyRunnable;

    /* renamed from: I, reason: from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.aio.couple.i mViewController;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.couple.manager.a bubblePlayManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean coupleAvatarSwitch = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasRegistered;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f350421a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f350422b;

        static {
            int[] iArr = new int[CoupleAvatarLayoutEvent.values().length];
            try {
                iArr[CoupleAvatarLayoutEvent.FIRST_RENDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoupleAvatarLayoutEvent.TOUCH_EVENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoupleAvatarLayoutEvent.GET_NODE_POINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoupleAvatarLayoutEvent.RENDER_FAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f350421a = iArr;
            int[] iArr2 = new int[CoupleAvatarScene.AvatarTarget.values().length];
            try {
                iArr2[CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f350422b = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/ZPlanCoupleAvatarHelper$c", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
                ZPlanCoupleAvatarHelper.this.A(((AIOMsgListEvent.MultiSelectModeChangeEvent) i3).b());
            } else if (i3 instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
                ZPlanCoupleAvatarHelper.this.A(((AIOMsgListEvent.LongShotModeChangeEvent) i3).b());
            } else if (i3 instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
                ZPlanCoupleAvatarHelper.this.A(((FullScreenMsgIntent.OnFullScreenModeChanged) i3).a());
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    public ZPlanCoupleAvatarHelper() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoupleAvatarDestroyConfig>() { // from class: com.tencent.qqnt.aio.helper.ZPlanCoupleAvatarHelper$destroyWhenPauseConfig$2
            @Override // kotlin.jvm.functions.Function0
            public final CoupleAvatarDestroyConfig invoke() {
                return ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getCoupleAvatarDestroyConfig();
            }
        });
        this.destroyWhenPauseConfig = lazy;
        this.isAIOHideMode = new AtomicBoolean(false);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanCoupleAvatarHelper$whiteListListener$2.a>() { // from class: com.tencent.qqnt.aio.helper.ZPlanCoupleAvatarHelper$whiteListListener$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ZPlanCoupleAvatarHelper$whiteListListener$2$a", "Lcom/tencent/mobileqq/zplan/api/b;", "", "enable", "", "onResult", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements com.tencent.mobileqq.zplan.api.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ZPlanCoupleAvatarHelper f350424a;

                a(ZPlanCoupleAvatarHelper zPlanCoupleAvatarHelper) {
                    this.f350424a = zPlanCoupleAvatarHelper;
                }

                @Override // com.tencent.mobileqq.zplan.api.b
                public void onResult(boolean enable) {
                    if (((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature()) {
                        this.f350424a.F();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(ZPlanCoupleAvatarHelper.this);
            }
        });
        this.whiteListListener = lazy2;
        this.destroyRunnable = new Runnable() { // from class: com.tencent.qqnt.aio.helper.fq
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanCoupleAvatarHelper.o(ZPlanCoupleAvatarHelper.this);
            }
        };
        this.mAction1 = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(boolean isHideMode) {
        this.isAIOHideMode.getAndSet(isHideMode);
        if (isHideMode) {
            x();
        } else {
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        if (this.hasRegistered) {
            return;
        }
        this.hasRegistered = true;
        ((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).registerAIOWhiteListListener(r());
        QLog.i("ZPlanCoupleAvatarHelper", 1, "registerListener");
    }

    private final void C() {
        HashMap hashMap = new HashMap();
        hashMap.put("timeCost", String.valueOf(System.currentTimeMillis() - this.startTimeMillis));
        com.tencent.mobileqq.zplan.aio.couple.i iVar = this.mViewController;
        hashMap.put("hasShownFirstFrame", String.valueOf(iVar != null ? iVar.isInitFinished() : false));
        hashMap.put("hasPaused", String.valueOf(this.pauseCount > 1));
        com.tencent.mobileqq.zplan.aio.couple.i iVar2 = this.mViewController;
        hashMap.put("hasNetProcess", String.valueOf(iVar2 != null ? iVar2.getHasNetProcess() : false));
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportToBeacon("0AND0YAG6R40RLM6", "zplanCoupleAvatarExit", hashMap);
    }

    private final void D() {
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        String b16;
        if (!((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature() || (aVar = this.mAIOContext) == null || (g16 = aVar.g()) == null || (b16 = su3.c.b(g16)) == null || ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(b16)) {
            return;
        }
        ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).requestZPlanSettingBubbles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        CoroutineScope f16;
        z();
        com.tencent.mobileqq.zplan.aio.couple.i iVar = this.mViewController;
        if ((iVar != null ? iVar.getSubScene() : null) == CoupleAvatarSubScene.AIO && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e)) != null) {
            CorountineFunKt.e(f16, "ZPlanCoupleAvatarHelper_showOrHideCoupleScene", null, null, null, new ZPlanCoupleAvatarHelper$showOrHideCoupleScene$1(this, null), 14, null);
        }
    }

    private final void G() {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "ZPlanCoupleAvatarHelper_tryShowBubble", null, null, null, new ZPlanCoupleAvatarHelper$tryShowBubble$1(this, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        ((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).unRegisterAIOWhiteListListener(r());
        QLog.i("ZPlanCoupleAvatarHelper", 1, "unRegisterListener");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ZPlanCoupleAvatarHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.zplan.aio.couple.i iVar = this$0.mViewController;
        if (iVar != null) {
            iVar.onMoveToState(12);
        }
        com.tencent.mobileqq.zplan.aio.couple.i iVar2 = this$0.mViewController;
        if (iVar2 != null) {
            iVar2.onMoveToState(15);
        }
        this$0.startTimeMillis = 0L;
        this$0.pauseCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        D();
    }

    private final CoupleAvatarDestroyConfig q() {
        return (CoupleAvatarDestroyConfig) this.destroyWhenPauseConfig.getValue();
    }

    private final ZPlanCoupleAvatarHelper$whiteListListener$2.a r() {
        return (ZPlanCoupleAvatarHelper$whiteListListener$2.a) this.whiteListListener.getValue();
    }

    private final void s() {
        G();
    }

    private final void t(String data) {
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "zplan_ZPlanCoupleAvatarHelper", null, null, null, new ZPlanCoupleAvatarHelper$handleGetNodePoint$1(data, this, null), 14, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u(CoupleAvatarScene.AvatarTarget avatarTarget) {
        Fragment c16;
        Context context;
        AIOParam g16;
        Long longOrNull;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (c16 = aVar.c()) == null || (context = c16.getContext()) == null) {
            return;
        }
        int i3 = b.f350422b[avatarTarget.ordinal()];
        if (i3 == 1) {
            com.tencent.mobileqq.zplan.aio.couple.i.INSTANCE.b(context, "em_zplan_portal_entrance_aio_longpress_image");
            return;
        }
        if (i3 != 2) {
            QLog.i("ZPlanCoupleAvatarHelper", 1, "handleLongPressEvent avatarTarget:" + avatarTarget + " do nothing");
            return;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null || (g16 = aVar2.g()) == null || (r6 = su3.c.b(g16)) == null || longOrNull == null) {
            return;
        }
        com.tencent.mobileqq.zplan.aio.couple.i.INSTANCE.a(context, longOrNull.longValue(), 1);
    }

    private final void v(CoupleAvatarScene.AvatarTarget avatarTarget) {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            return;
        }
        if (avatarTarget != CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_LEFT && avatarTarget != CoupleAvatarScene.AvatarTarget.AVATAR_TARGET_RIGHT) {
            aVar.e().h(AIOMsgListEvent.HideKeyBoardAndPanel.f188311d);
            return;
        }
        QRouteApi api = QRoute.api(IZPlanAIOHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanAIOHelper::class.java)");
        IZPlanAIOHelper.a.b((IZPlanAIOHelper) api, aVar, null, 2, null);
    }

    private final void w(String data) {
        QLog.i("ZPlanCoupleAvatarHelper", 1, "handleTouchEvent eventData: " + data);
        JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(data);
        if (b16 == null) {
            return;
        }
        String optString = b16.optString("touchEventType");
        CoupleAvatarScene.AvatarTarget q16 = CoupleAvatarScene.INSTANCE.q(b16.optString("touchEventTarget"));
        if (Intrinsics.areEqual(optString, TouchEventType.LongPress.toString())) {
            u(q16);
        } else if (Intrinsics.areEqual(optString, TouchEventType.TapUp.toString())) {
            v(q16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        this.bubblePlayManager = ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).createBubblePlayManager(CoupleAvatarSubScene.AIO);
    }

    private final void z() {
        AIOParam g16;
        String b16;
        com.tencent.mobileqq.zplan.aio.couple.i iVar = this.mViewController;
        if (iVar != null) {
            if (iVar != null) {
                iVar.f(CoupleAvatarSubScene.AIO, this);
                return;
            }
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (b16 = su3.c.b(g16)) == null) {
            return;
        }
        IZPlanCoupleSceneHelper iZPlanCoupleSceneHelper = (IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class);
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        com.tencent.mobileqq.zplan.aio.couple.i coupleAvatarViewController = iZPlanCoupleSceneHelper.getCoupleAvatarViewController(b16, bVar.a());
        this.mViewController = coupleAvatarViewController;
        if (coupleAvatarViewController != null) {
            coupleAvatarViewController.d(CoupleAvatarSubScene.AIO);
        }
        com.tencent.mobileqq.zplan.aio.couple.i iVar2 = this.mViewController;
        if (iVar2 != null) {
            iVar2.f(CoupleAvatarSubScene.AIO, this);
        }
    }

    public final void E() {
        if (this.isAIOHideMode.get()) {
            QLog.i("ZPlanCoupleAvatarHelper", 1, "isAIOHideMode true");
            return;
        }
        com.tencent.mobileqq.zplan.aio.couple.i iVar = this.mViewController;
        if (iVar != null) {
            iVar.j();
        }
        if (this.startTimeMillis == 0) {
            this.startTimeMillis = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.U0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "ZPlanCoupleAvatarHelper";
    }

    @Override // com.tencent.mobileqq.zplan.aio.couple.g
    public void h(CoupleAvatarLayoutEvent event, String data) {
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = b.f350421a[event.ordinal()];
        if (i3 == 1) {
            s();
        } else if (i3 == 2) {
            w(data);
        } else {
            if (i3 != 3) {
                return;
            }
            t(data);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.i("ZPlanCoupleAvatarHelper", 1, "onCreate " + this);
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            return;
        }
        this.mParam = param;
        boolean enable = ((IZPlanQQMC) QRoute.api(IZPlanQQMC.class)).getCoupleAvatarSwitchConfig().getEnable();
        this.coupleAvatarSwitch = enable;
        if (enable) {
            a16.e().d(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction1);
            a16.e().d(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LongShotModeChangeEvent.class).getQualifiedName(), this.mAction1);
            a16.e().d(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class).getQualifiedName(), this.mAction1);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        AIOParam g16;
        String b16;
        QLog.i("ZPlanCoupleAvatarHelper", 1, "onDestroy " + this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            return;
        }
        if (this.coupleAvatarSwitch) {
            aVar.e().b(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction1);
            aVar.e().b(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LongShotModeChangeEvent.class).getQualifiedName(), this.mAction1);
            aVar.e().b(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class).getQualifiedName(), this.mAction1);
        }
        com.tencent.mobileqq.zplan.couple.manager.a aVar2 = this.bubblePlayManager;
        if (aVar2 != null) {
            aVar2.b();
        }
        if (this.startTimeMillis != 0) {
            C();
        }
        this.mViewController = null;
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null || (g16 = aVar3.g()) == null || (b16 = su3.c.b(g16)) == null) {
            return;
        }
        ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).clearCurrentCoupleAvatarViewController(b16, aVar);
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (!this.coupleAvatarSwitch || MiniChatActivity.M2() || SplashAIOFragment.INSTANCE.a()) {
            return;
        }
        if (state == 1) {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "ZPlanCoupleAvatarHelper_doOnStart", null, null, null, new ZPlanCoupleAvatarHelper$onMoveToState$1(this, null), 14, null);
                return;
            }
            return;
        }
        if (state == 3) {
            if (q().getEnableDestroyWhenPause()) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.destroyRunnable);
            }
            F();
            com.tencent.mobileqq.zplan.aio.couple.i iVar = this.mViewController;
            if (iVar != null) {
                iVar.onMoveToState(7);
                return;
            }
            return;
        }
        if (state == 8) {
            this.pauseCount++;
            com.tencent.mobileqq.zplan.aio.couple.i iVar2 = this.mViewController;
            if (iVar2 != null) {
                iVar2.onMoveToState(11);
            }
            if (q().getEnableDestroyWhenPause()) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.destroyRunnable, q().getDestroyInterval());
                return;
            }
            return;
        }
        if (state != 12) {
            return;
        }
        if (q().getEnableDestroyWhenPause()) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.destroyRunnable);
        }
        com.tencent.mobileqq.zplan.aio.couple.i iVar3 = this.mViewController;
        if (iVar3 != null) {
            iVar3.onMoveToState(12);
        }
        com.tencent.mobileqq.zplan.aio.couple.i iVar4 = this.mViewController;
        if (iVar4 != null) {
            iVar4.onMoveToState(15);
        }
        H();
    }

    public final void x() {
        com.tencent.mobileqq.zplan.aio.couple.i iVar = this.mViewController;
        if (iVar != null) {
            iVar.g();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 1, 3, 8, 9, 12};
    }
}
