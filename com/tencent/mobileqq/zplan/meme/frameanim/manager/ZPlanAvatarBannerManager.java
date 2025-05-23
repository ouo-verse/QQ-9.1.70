package com.tencent.mobileqq.zplan.meme.frameanim.manager;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.meme.frameanim.ZPlanAvatarBannerParams;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li3.BubbleReportData;
import t74.l;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\u001fB/\u0012\u0006\u0010A\u001a\u00020.\u0012\u0006\u0010B\u001a\u000202\u0012\u0006\u0010C\u001a\u000204\u0012\u0006\u0010D\u001a\u000202\u0012\u0006\u0010,\u001a\u00020(\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016R\u0017\u0010,\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010)\u001a\u0004\b*\u0010+R$\u00101\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010.0.0-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00100R$\u00103\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u000102020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00100R$\u00105\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u000104040-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u00100R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010?\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/manager/ZPlanAvatarBannerManager;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "exitFilament", BdhLogUtil.LogTag.Tag_Conn, "G", UserInfo.SEX_FEMALE, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "onTabQzone", "k", DomainData.DOMAIN_NAME, "g", "j", "f", "l", "", "d", "c", "Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "avatarOverlayViewWiringHelper", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "Lcom/tencent/mobileqq/zplan/meme/frameanim/f;", "listener", "r", "t", "Lli3/a;", "a", "Landroid/content/res/Configuration;", "newConfig", "i", "", "type", tl.h.F, "b", "p", "Lcom/tencent/mobileqq/zplan/meme/frameanim/i;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/i;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/zplan/meme/frameanim/i;", "param", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "contextWeak", "Landroid/widget/FrameLayout;", "zPlanBannerLayoutWeak", "Landroid/widget/ImageView;", "avatarIVWeak", "Lcom/tencent/mobileqq/zplan/meme/frameanim/b;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/b;", "backgroundManager", "Lcom/tencent/mobileqq/zplan/meme/frameanim/f;", "eventListener", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "sessionId", "Lcom/tencent/mobileqq/zplan/meme/frameanim/g;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/g;", "filamentAvatarManager", "context", "zPlanBannerLayout", "avatarIV", "backgroundContainer", "<init>", "(Landroid/content/Context;Landroid/widget/FrameLayout;Landroid/widget/ImageView;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/zplan/meme/frameanim/i;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAvatarBannerManager extends com.tencent.mobileqq.zplan.meme.frameanim.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZPlanAvatarBannerParams param;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Context> contextWeak;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WeakReference<FrameLayout> zPlanBannerLayoutWeak;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<ImageView> avatarIVWeak;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.meme.frameanim.b backgroundManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.meme.frameanim.f eventListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private AtomicLong sessionId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.meme.frameanim.g filamentAvatarManager;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/meme/frameanim/manager/ZPlanAvatarBannerManager$b", "Lcom/tencent/mobileqq/zplan/meme/frameanim/d;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.meme.frameanim.d {
        b() {
        }

        @Override // com.tencent.mobileqq.zplan.meme.frameanim.d
        public void a() {
            ZPlanAvatarBannerManager.this.C(true);
        }
    }

    public ZPlanAvatarBannerManager(Context context, FrameLayout zPlanBannerLayout, ImageView avatarIV, FrameLayout backgroundContainer, ZPlanAvatarBannerParams param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(zPlanBannerLayout, "zPlanBannerLayout");
        Intrinsics.checkNotNullParameter(avatarIV, "avatarIV");
        Intrinsics.checkNotNullParameter(backgroundContainer, "backgroundContainer");
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.contextWeak = new WeakReference<>(context);
        this.zPlanBannerLayoutWeak = new WeakReference<>(zPlanBannerLayout);
        this.avatarIVWeak = new WeakReference<>(avatarIV);
        this.backgroundManager = new ZPlanBannerBackgroundManager(context, backgroundContainer, param);
        this.sessionId = new AtomicLong(System.currentTimeMillis());
        if (com.tencent.mobileqq.zplan.lite.util.e.f333809a.l(param.getScene())) {
            z();
        } else {
            QLog.w("ZPlanAvatarBannerManager", 1, "createDynamicAvatarManager, need to confirm the reason.");
            bb.f335811a.s(param.getBusinessId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ZPlanAvatarBannerManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F();
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this$0.filamentAvatarManager;
        if (gVar != null) {
            gVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(final boolean exitFilament) {
        l lVar = l.f435563a;
        lVar.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanAvatarBannerManager$updateAvatar$1
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
                com.tencent.mobileqq.zplan.meme.frameanim.g gVar;
                WeakReference weakReference;
                com.tencent.mobileqq.zplan.meme.frameanim.g gVar2;
                gVar = ZPlanAvatarBannerManager.this.filamentAvatarManager;
                boolean z16 = (gVar != null ? gVar.g(ZPlanAvatarBannerManager.this.getParam().getScene()) : false) && !exitFilament;
                QZLog.i("ZPlanAvatarBannerManager", 1, "updateAvatar filamentEnable : " + z16);
                weakReference = ZPlanAvatarBannerManager.this.avatarIVWeak;
                ImageView imageView = (ImageView) weakReference.get();
                if (imageView != null) {
                    imageView.setVisibility(z16 ? 4 : 0);
                }
                gVar2 = ZPlanAvatarBannerManager.this.filamentAvatarManager;
                if (gVar2 != null) {
                    gVar2.f(z16);
                }
            }
        });
        lVar.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarBannerManager.E(ZPlanAvatarBannerManager.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(ZPlanAvatarBannerManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.zplan.meme.frameanim.f fVar = this$0.eventListener;
        if (fVar != null) {
            fVar.onManagerResume();
        }
    }

    private final void F() {
        this.sessionId.getAndSet(System.currentTimeMillis());
    }

    private final void G() {
        String uin = this.param.getUin();
        ArrayList arrayList = new ArrayList();
        arrayList.add(uin);
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).requireUserZPlanInfo(arrayList, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.ZPlanAvatarBannerManager$updateUserZPlanInfo$1
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
                ZPlanAvatarBannerManager.D(ZPlanAvatarBannerManager.this, false, 1, null);
            }
        });
    }

    private final void z() {
        FrameLayout frameLayout;
        ZPlanFilamentAvatarNativeManager zPlanFilamentAvatarNativeManager;
        com.tencent.mobileqq.zplan.lite.util.e eVar = com.tencent.mobileqq.zplan.lite.util.e.f333809a;
        boolean m3 = eVar.m(this.param.getScene());
        boolean n3 = eVar.n(this.param.getScene());
        QLog.i("ZPlanAvatarBannerManager", 1, "jsFilamentEnable: " + m3 + ", nativeFilamentEnable: " + n3);
        Context context = this.contextWeak.get();
        if (context == null || (frameLayout = this.zPlanBannerLayoutWeak.get()) == null) {
            return;
        }
        ZPlanFilamentAvatarNativeManager zPlanFilamentAvatarNativeManager2 = null;
        if (n3) {
            zPlanFilamentAvatarNativeManager = new ZPlanFilamentAvatarNativeManager(context, frameLayout, this.param.getUin(), this.param.getScene());
        } else {
            QLog.e("ZPlanAvatarBannerManager", 1, "filament switch config error.");
            zPlanFilamentAvatarNativeManager = null;
        }
        if (zPlanFilamentAvatarNativeManager != null) {
            zPlanFilamentAvatarNativeManager.f(true);
            zPlanFilamentAvatarNativeManager2 = zPlanFilamentAvatarNativeManager;
        }
        this.filamentAvatarManager = zPlanFilamentAvatarNativeManager2;
        if (zPlanFilamentAvatarNativeManager2 != null) {
            zPlanFilamentAvatarNativeManager2.k(new b());
        }
    }

    /* renamed from: A, reason: from getter */
    public final ZPlanAvatarBannerParams getParam() {
        return this.param;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public BubbleReportData a() {
        return new BubbleReportData(this.param.getUin(), this.param.getBusinessId(), this.sessionId.get());
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public int b() {
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            return gVar.e();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public Object c() {
        Object j3;
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null && (j3 = gVar.j()) != null) {
            arrayList.add(j3);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public Object d() {
        Object h16;
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null && (h16 = gVar.h()) != null) {
            arrayList.add(h16);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public boolean e() {
        return this.filamentAvatarManager != null;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void h(int type) {
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.c(type);
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void i(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Context context = this.contextWeak.get();
        if (context == null) {
            return;
        }
        if (AppSetting.t(context)) {
            D(this, false, 1, null);
            t();
        }
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.onConfigurationChanged(newConfig);
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void k(boolean onTabQzone) {
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.d(onTabQzone);
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void l() {
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.onThemeChange();
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void m() {
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.pause();
        }
        com.tencent.mobileqq.zplan.meme.frameanim.b bVar = this.backgroundManager;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void o() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return;
        }
        QZLog.i("ZPlanAvatarBannerManager", 1, "resume " + AppSetting.t(context));
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.f(gVar != null ? gVar.g(this.param.getScene()) : false);
        }
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar2 = this.filamentAvatarManager;
        if (gVar2 != null) {
            gVar2.resume();
        }
        D(this, false, 1, null);
        t();
        com.tencent.mobileqq.zplan.meme.frameanim.b bVar = this.backgroundManager;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void p() {
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void q(com.tencent.mobileqq.zplan.meme.frameanim.e avatarOverlayViewWiringHelper) {
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.i(avatarOverlayViewWiringHelper);
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void r(com.tencent.mobileqq.zplan.meme.frameanim.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.eventListener = listener;
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void s() {
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.stop();
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void t() {
        com.tencent.mobileqq.zplan.meme.frameanim.b bVar = this.backgroundManager;
        if (bVar != null) {
            bVar.d(this.param.getUin());
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void f() {
        QZLog.i("ZPlanAvatarBannerManager", 1, "onAccountChanged");
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.onAccountChanged();
        }
        G();
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void g() {
        QZLog.i("ZPlanAvatarBannerManager", 1, "onAppearanceKeyChanged");
        l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.frameanim.manager.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarBannerManager.B(ZPlanAvatarBannerManager.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void j() {
        QZLog.i("ZPlanAvatarBannerManager", 1, "onNewStaticImageFromLua");
    }

    @Override // com.tencent.mobileqq.zplan.meme.frameanim.a
    public void n() {
        QZLog.i("ZPlanAvatarBannerManager", 1, "release");
        this.eventListener = null;
        com.tencent.mobileqq.zplan.meme.frameanim.g gVar = this.filamentAvatarManager;
        if (gVar != null) {
            gVar.release();
        }
        com.tencent.mobileqq.zplan.meme.frameanim.b bVar = this.backgroundManager;
        if (bVar != null) {
            bVar.a();
        }
        this.backgroundManager = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void D(ZPlanAvatarBannerManager zPlanAvatarBannerManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        zPlanAvatarBannerManager.C(z16);
    }
}
