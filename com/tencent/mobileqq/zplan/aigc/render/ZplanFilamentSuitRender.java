package com.tencent.mobileqq.zplan.aigc.render;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import mqq.util.WeakReference;
import t74.r;
import uv4.az;
import wc3.LocalUgcPath;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0003\u001b#LB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0019\u001a\u00020\u0007R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00108R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010BR$\u0010I\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010E\u001a\u0004\b?\u0010F\"\u0004\bG\u0010H\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;", "", "Landroid/content/Context;", "context", "Lmqq/util/WeakReference;", "Landroid/widget/FrameLayout;", "filamentContainer", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleCoroutineScope;", "lifecycleScope", "l", "", "from", ReportConstant.COSTREPORT_PREFIX, "o", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender$a;", ISchemeApi.KEY_SCENE_DATA, "g", DomainData.DOMAIN_NAME, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Luv4/az;", "storeItem", "f", "p", "Lwk0/a;", "a", "Lwk0/a;", "i", "()Lwk0/a;", "t", "(Lwk0/a;)V", "nativeApp", "Landroid/view/View;", "b", "Landroid/view/View;", "k", "()Landroid/view/View;", "u", "(Landroid/view/View;)V", "textureView", "Luk0/e;", "c", "Luk0/e;", "firstFrameListener", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "d", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "j", "()Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "setScene", "(Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;)V", "scene", "", "e", "Z", "filamentInitialized", "isFirstFrame", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mChangeAvatarDressLock", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender$ResetLockTask;", tl.h.F, "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender$ResetLockTask;", "mResetLockTask", "Lmqq/util/WeakReference;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/zplan/aigc/helper/AigcAnimHelper;", "Lcom/tencent/mobileqq/zplan/aigc/helper/AigcAnimHelper;", "()Lcom/tencent/mobileqq/zplan/aigc/helper/AigcAnimHelper;", "setAnimHelper", "(Lcom/tencent/mobileqq/zplan/aigc/helper/AigcAnimHelper;)V", "animHelper", "<init>", "()V", "ResetLockTask", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanFilamentSuitRender {

    /* renamed from: l, reason: collision with root package name */
    private static String f330449l = "ZplanFilamentSuitRender";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public wk0.a nativeApp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View textureView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private uk0.e firstFrameListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AigcPreviewBusinessScene scene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean filamentInitialized;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstFrame;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean mChangeAvatarDressLock = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ResetLockTask mResetLockTask = new ResetLockTask(new WeakReference(this));

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private WeakReference<FrameLayout> container;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private AigcAnimHelper animHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender$ResetLockTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender;", "d", "Lmqq/util/WeakReference;", "getRef", "()Lmqq/util/WeakReference;", "ref", "<init>", "(Lmqq/util/WeakReference;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class ResetLockTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZplanFilamentSuitRender> ref;

        public ResetLockTask(WeakReference<ZplanFilamentSuitRender> ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            this.ref = ref;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZplanFilamentSuitRender zplanFilamentSuitRender = this.ref.get();
            if (zplanFilamentSuitRender != null) {
                zplanFilamentSuitRender.s("time out");
            }
            r.e(null, "zplan_portal_change_avatar_dress_time_out", null, 5, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u0004\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010!\u001a\u0004\b\f\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender$a;", "", "", "Lwc3/c;", "a", "Ljava/util/Collection;", "e", "()Ljava/util/Collection;", "i", "(Ljava/util/Collection;)V", "localUgcPaths", "Lqu4/a;", "b", "Lqu4/a;", "c", "()Lqu4/a;", "setDefaultCharacter", "(Lqu4/a;)V", "defaultCharacter", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "d", "()Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", tl.h.F, "(Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;)V", "gender", "", "I", "()I", "f", "(I)V", "avatarType", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "()Lcom/tencent/filament/zplan/avatar/CameraParams;", "g", "(Lcom/tencent/filament/zplan/avatar/CameraParams;)V", "cameraParams", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Collection<LocalUgcPath> localUgcPaths;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private qu4.a defaultCharacter;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public UEAvatarGender gender;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int avatarType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private CameraParams cameraParams;

        public a() {
            List emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.localUgcPaths = emptyList;
        }

        /* renamed from: a, reason: from getter */
        public final int getAvatarType() {
            return this.avatarType;
        }

        /* renamed from: b, reason: from getter */
        public final CameraParams getCameraParams() {
            return this.cameraParams;
        }

        /* renamed from: c, reason: from getter */
        public final qu4.a getDefaultCharacter() {
            return this.defaultCharacter;
        }

        public final UEAvatarGender d() {
            UEAvatarGender uEAvatarGender = this.gender;
            if (uEAvatarGender != null) {
                return uEAvatarGender;
            }
            Intrinsics.throwUninitializedPropertyAccessException("gender");
            return null;
        }

        public final Collection<LocalUgcPath> e() {
            return this.localUgcPaths;
        }

        public final void f(int i3) {
            this.avatarType = i3;
        }

        public final void g(CameraParams cameraParams) {
            this.cameraParams = cameraParams;
        }

        public final void h(UEAvatarGender uEAvatarGender) {
            Intrinsics.checkNotNullParameter(uEAvatarGender, "<set-?>");
            this.gender = uEAvatarGender;
        }

        public final void i(Collection<LocalUgcPath> collection) {
            Intrinsics.checkNotNullParameter(collection, "<set-?>");
            this.localUgcPaths = collection;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/zplan/aigc/render/ZplanFilamentSuitRender$c", "Luk0/e;", "", "type", "eventData", "", "onEvent", "", "d", "Z", "a", "()Z", "setDone", "(Z)V", "done", "Lkotlinx/coroutines/CancellableContinuation;", "e", "Lkotlinx/coroutines/CancellableContinuation;", "getContRef", "()Lkotlinx/coroutines/CancellableContinuation;", "b", "(Lkotlinx/coroutines/CancellableContinuation;)V", "contRef", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements uk0.e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean done;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private CancellableContinuation<? super Unit> contRef;

        c() {
        }

        /* renamed from: a, reason: from getter */
        public final boolean getDone() {
            return this.done;
        }

        public final void b(CancellableContinuation<? super Unit> cancellableContinuation) {
            this.contRef = cancellableContinuation;
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            ZplanFilamentSuitRender.this.isFirstFrame = true;
            synchronized (this) {
                this.done = true;
                CancellableContinuation<? super Unit> cancellableContinuation = this.contRef;
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }
                this.contRef = null;
                Unit unit = Unit.INSTANCE;
            }
            QLog.i(ZplanFilamentSuitRender.f330449l, 1, "FIRST_FRAME");
        }
    }

    private final void l(LifecycleCoroutineScope lifecycleScope) {
        QLog.i(f330449l, 1, "initLoading");
        c cVar = new c();
        i().c("onFirstFrameRenderEnd", cVar);
        lifecycleScope.launchWhenCreated(new ZplanFilamentSuitRender$initEventListener$1(this, cVar, null));
    }

    private final void m(Context context, WeakReference<FrameLayout> filamentContainer) {
        if (this.filamentInitialized) {
            return;
        }
        this.filamentInitialized = true;
        t(FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, FilamentApiImpl.f369933a.e(), null, null, 12, null));
        View z16 = i().z(context, Boolean.TRUE);
        z16.setZ(-1.0f);
        u(z16);
        FrameLayout frameLayout = filamentContainer.get();
        if (frameLayout != null) {
            frameLayout.addView(k(), new FrameLayout.LayoutParams(-1, -1));
        }
        this.container = filamentContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String from) {
        QLog.i(f330449l, 1, "resetLock from:" + from);
        this.mChangeAvatarDressLock.set(false);
    }

    public final void g(a sceneData, LifecycleCoroutineScope lifecycleScope) {
        Intrinsics.checkNotNullParameter(sceneData, "sceneData");
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        if (this.filamentInitialized) {
            l(lifecycleScope);
            this.animHelper = new AigcAnimHelper(sceneData.d());
            this.scene = new AigcPreviewBusinessScene(sceneData.e(), sceneData.getAvatarType(), sceneData.getDefaultCharacter(), this.animHelper, sceneData.getCameraParams());
            wk0.a i3 = i();
            AigcPreviewBusinessScene aigcPreviewBusinessScene = this.scene;
            Intrinsics.checkNotNull(aigcPreviewBusinessScene);
            int y16 = i3.y("", aigcPreviewBusinessScene);
            QLog.i(f330449l, 1, " startWithEntry");
            if (y16 != 0) {
                QLog.e(f330449l, 1, "startWithEntry startRet " + y16 + " is not FIALMENT_APP_STATUS_CREATING");
            }
        }
    }

    /* renamed from: h, reason: from getter */
    public final AigcAnimHelper getAnimHelper() {
        return this.animHelper;
    }

    public final wk0.a i() {
        wk0.a aVar = this.nativeApp;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
        return null;
    }

    /* renamed from: j, reason: from getter */
    public final AigcPreviewBusinessScene getScene() {
        return this.scene;
    }

    public final View k() {
        View view = this.textureView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("textureView");
        return null;
    }

    public final void n() {
        FrameLayout frameLayout;
        QLog.d(f330449l, 1, "onReleaseScene");
        this.isFirstFrame = false;
        WeakReference<FrameLayout> weakReference = this.container;
        if (weakReference != null && (frameLayout = weakReference.get()) != null) {
            frameLayout.removeView(k());
        }
        if (this.nativeApp != null) {
            i().removeEventListener("onFirstFrameRenderEnd");
            i().onPause();
        }
    }

    public final void o(Context context, WeakReference<FrameLayout> filamentContainer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filamentContainer, "filamentContainer");
        QLog.d(f330449l, 1, "onCreateEngine");
        m(context, filamentContainer);
        i().onResume();
    }

    public final void p() {
        QLog.d(f330449l, 1, "onDestroyEngine");
        if (this.filamentInitialized) {
            i().onDestroy();
            this.filamentInitialized = false;
        }
    }

    public final void q() {
        if (this.filamentInitialized) {
            i().onPause();
        }
    }

    public final void r() {
        if (this.filamentInitialized) {
            i().onResume();
        }
    }

    public final void t(wk0.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.nativeApp = aVar;
    }

    public final void u(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.textureView = view;
    }

    public final void f(az storeItem) {
        List listOf;
        if (storeItem == null) {
            return;
        }
        LocalUgcPath localUgcPath = new LocalUgcPath("", storeItem);
        AigcPreviewBusinessScene aigcPreviewBusinessScene = this.scene;
        if (aigcPreviewBusinessScene != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(localUgcPath);
            aigcPreviewBusinessScene.setLocalUgcPaths(listOf);
        }
        if (this.mChangeAvatarDressLock.get()) {
            QLog.e(f330449l, 1, "changeAvatarDress mChangeAvatarDressLock is true");
            return;
        }
        this.mChangeAvatarDressLock.set(true);
        uk0.e eVar = this.firstFrameListener;
        if (eVar != null) {
            i().t("onFirstFrameRenderEnd", eVar);
        }
        uk0.e eVar2 = new uk0.e() { // from class: com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender$changeAvatarDress$listener$1
            @Override // uk0.e
            public void onEvent(String type, String eventData) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(eventData, "eventData");
                QLog.i(ZplanFilamentSuitRender.f330449l, 1, "changeAvatarDress onEvent type:" + type + ", eventData:" + eventData);
                if (Intrinsics.areEqual(type, "onFirstFrameRenderEnd")) {
                    ZplanFilamentSuitRender.this.i().removeEventListener("onFirstFrameRenderEnd");
                    final ZplanFilamentSuitRender zplanFilamentSuitRender = ZplanFilamentSuitRender.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentSuitRender$changeAvatarDress$listener$1$onEvent$1
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
                            ZplanFilamentSuitRender.ResetLockTask resetLockTask;
                            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                            resetLockTask = ZplanFilamentSuitRender.this.mResetLockTask;
                            uIHandlerV2.removeCallbacks(resetLockTask);
                            ZplanFilamentSuitRender.this.s("onFirstFrameRenderEnd");
                        }
                    });
                }
            }
        };
        this.firstFrameListener = eVar2;
        i().c("onFirstFrameRenderEnd", eVar2);
        i().c("onFilamentRenderFail", eVar2);
        i().k("onCostumeChange", "", null);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mResetLockTask);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mResetLockTask, 5000L);
    }
}
