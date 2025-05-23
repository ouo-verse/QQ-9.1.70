package com.tencent.mobileqq.zplan.minihome;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeDecorateComponent;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeStaticImageComponent;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010C\u001a\u00020?\u0012\u0006\u0010G\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u001a\u0010#\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020+H\u0016J \u00100\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020/H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J \u00103\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020+H\u0016J\u0018\u00104\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020+H\u0016J\u0018\u00105\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020/H\u0016J\u0018\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020/H\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u000208H\u0016J\u0016\u0010=\u001a\u00020\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:H\u0016J\u0016\u0010>\u001a\u00020\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:H\u0016R\u0017\u0010C\u001a\u00020?8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010G\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b9\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010H\u001a\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010HR\u0016\u0010M\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010LR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010ZR\u0014\u0010^\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010]R \u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0:0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010`\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/MiniHomeController;", "Lcom/tencent/mobileqq/zplan/minihome/y;", "", ReportConstant.COSTREPORT_PREFIX, "", "u", "", "v", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "scene", tl.h.F, "Landroid/view/View;", "getView", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "f", "roomJsonString", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeLoadCallback;", "callback", "c", "a", "l", OperateCustomButton.OPERATE_CREATE, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "resume", "pause", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "destroy", "Lcom/tencent/mobileqq/zplan/minihome/am;", "sceneEnum", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "imageUrlOrPath", "", "isNightTheme", "w", "p", "night", "e", "Lcom/tencent/filament/zplan/scene/minihome/MiniHomeScene$Companion$CAMERAMODE;", "mode", "o", "slot", "Lcom/tencent/filament/zplan/scene/minihome/a;", "k", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeMessageCallback;", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "decorateJson", "i", "d", "j", "needCompleteRoomData", DomainData.DOMAIN_NAME, "Lcom/tencent/filament/zplan/scene/minihome/b;", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/minihome/ac;", "callbackRef", "r", "t", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "getScene", "()Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "curScene", "Z", "hasInit", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "curReuseCount", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "textureView", "Lcom/tencent/mobileqq/zplan/minihome/view/a;", "Lcom/tencent/mobileqq/zplan/minihome/view/a;", "decorateComponent", "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeStaticImageComponent;", "Lcom/tencent/mobileqq/zplan/minihome/view/MiniHomeStaticImageComponent;", "staticImageComponent", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "eventCallbackLock", "", "Ljava/util/List;", "miniHomeSceneEventCallbackRefList", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeController implements y {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MiniHomeSceneEnum scene;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MiniHomeSceneEnum curScene;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasInit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AtomicInteger curReuseCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private FrameLayout rootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View textureView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.minihome.view.a decorateComponent;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private MiniHomeStaticImageComponent staticImageComponent;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock eventCallbackLock;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final List<WeakReference<ac>> miniHomeSceneEventCallbackRefList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/minihome/MiniHomeController$b", "Lcom/tencent/mobileqq/zplan/minihome/ac;", "Lcom/tencent/mobileqq/zplan/minihome/am;", "event", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "sceneEnum", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ac {
        b() {
        }

        @Override // com.tencent.mobileqq.zplan.minihome.ac
        public void a(am event, MiniHomeSceneEnum sceneEnum) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(sceneEnum, "sceneEnum");
            QLog.i("MiniHomeController", 1, "eventListener, event: " + event.getType().name());
            MiniHomeController.this.A(event, sceneEnum);
        }
    }

    public MiniHomeController(Context context, String uin, MiniHomeSceneEnum scene) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.context = context;
        this.uin = uin;
        this.scene = scene;
        this.curScene = MiniHomeSceneEnum.SCENE_PROFILE;
        this.curReuseCount = new AtomicInteger(0);
        this.eventCallbackLock = new ReentrantLock();
        this.miniHomeSceneEventCallbackRefList = new ArrayList();
    }

    public void A(final am event, final MiniHomeSceneEnum sceneEnum) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sceneEnum, "sceneEnum");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.minihome.MiniHomeController$dispatchEvent$1
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
                ReentrantLock reentrantLock;
                List list;
                List list2;
                View view;
                View view2;
                if (am.this instanceof EventPixelCallback) {
                    view = this.textureView;
                    if (view != null) {
                        view.setAlpha(1.0f);
                    }
                    view2 = this.textureView;
                    QLog.i("MiniHomeController", 1, "EventPixelCallback textureView set alpha 1, " + view2);
                }
                reentrantLock = this.eventCallbackLock;
                MiniHomeController miniHomeController = this;
                reentrantLock.lock();
                try {
                    list = miniHomeController.miniHomeSceneEventCallbackRefList;
                    list2 = CollectionsKt___CollectionsKt.toList(list);
                    reentrantLock.unlock();
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        ac acVar = (ac) ((WeakReference) it.next()).get();
                        QLog.i("MiniHomeController", 1, "before dispatchEvent " + acVar + ", " + sceneEnum.name() + ", " + am.this.getType().name());
                        if (acVar != null) {
                            acVar.a(am.this, sceneEnum);
                        }
                        QLog.i("MiniHomeController", 1, "after dispatchEvent " + acVar + ", " + sceneEnum.name() + ", " + am.this.getType().name());
                    }
                } catch (Throwable th5) {
                    reentrantLock.unlock();
                    throw th5;
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void b(com.tencent.filament.zplan.scene.minihome.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.b(callback);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.z
    public void create() {
        if (this.decorateComponent != null) {
            return;
        }
        QLog.i("MiniHomeController", 1, OperateCustomButton.OPERATE_CREATE);
        this.decorateComponent = new MiniHomeDecorateComponent(this.context, this.uin, this.scene);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.z
    public void createView() {
        FrameLayout frameLayout;
        if (this.rootView != null) {
            return;
        }
        QLog.i("MiniHomeController", 1, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
        this.rootView = new FrameLayout(this.context);
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        View view = aVar != null ? aVar.getView() : null;
        this.textureView = view;
        if (view != null) {
            view.setAlpha(0.0f);
        }
        View view2 = this.textureView;
        if (view2 != null && (frameLayout = this.rootView) != null) {
            frameLayout.addView(view2);
        }
        FrameLayout frameLayout2 = this.rootView;
        Intrinsics.checkNotNull(frameLayout2);
        this.staticImageComponent = new MiniHomeStaticImageComponent(frameLayout2);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void d(String slot, com.tencent.filament.zplan.scene.minihome.a callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.d(slot, callback);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void e(boolean night) {
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.e(night);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void f() {
        if (this.hasInit) {
            return;
        }
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.f();
        }
        this.hasInit = true;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void g(int x16, int y16, IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.g(x16, y16, callback);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public View getView() {
        FrameLayout frameLayout = this.rootView;
        if ((frameLayout != null ? frameLayout.getParent() : null) != null) {
            FrameLayout frameLayout2 = this.rootView;
            ViewParent parent = frameLayout2 != null ? frameLayout2.getParent() : null;
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this.rootView);
        }
        QLog.i("MiniHomeController", 1, "getView " + Log.getStackTraceString(new Throwable("\u8c03\u7528\u6808\u6253\u5370")));
        return this.rootView;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void h(MiniHomeSceneEnum scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.curScene = scene;
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.h(scene);
        }
        QLog.i("MiniHomeController", 1, "updateScene " + scene);
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void i(String slot, String decorateJson, com.tencent.filament.zplan.scene.minihome.a callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(decorateJson, "decorateJson");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.i(slot, decorateJson, callback);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void j(String slot, IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.j(slot, callback);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void k(String slot, com.tencent.filament.zplan.scene.minihome.a callback) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.k(slot, callback);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void m() {
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.m();
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void n(boolean needCompleteRoomData, IMiniHomeMessageCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.n(needCompleteRoomData, callback);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void o(MiniHomeScene.Companion.CAMERAMODE mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.o(mode);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.onTouchEvent(event);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void p() {
        MiniHomeStaticImageComponent miniHomeStaticImageComponent = this.staticImageComponent;
        if (miniHomeStaticImageComponent != null) {
            miniHomeStaticImageComponent.c();
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.z
    public void q() {
        FrameLayout frameLayout = this.rootView;
        if ((frameLayout != null ? frameLayout.getParent() : null) != null) {
            FrameLayout frameLayout2 = this.rootView;
            ViewParent parent = frameLayout2 != null ? frameLayout2.getParent() : null;
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this.rootView);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void r(WeakReference<ac> callbackRef) {
        Intrinsics.checkNotNullParameter(callbackRef, "callbackRef");
        ReentrantLock reentrantLock = this.eventCallbackLock;
        reentrantLock.lock();
        try {
            this.miniHomeSceneEventCallbackRefList.add(callbackRef);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    /* renamed from: s, reason: from getter */
    public String getUin() {
        return this.uin;
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void t(WeakReference<ac> callbackRef) {
        Intrinsics.checkNotNullParameter(callbackRef, "callbackRef");
        ReentrantLock reentrantLock = this.eventCallbackLock;
        reentrantLock.lock();
        try {
            if (this.miniHomeSceneEventCallbackRefList.contains(callbackRef)) {
                this.miniHomeSceneEventCallbackRefList.remove(callbackRef);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void u() {
        this.curReuseCount.getAndIncrement();
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public int v() {
        return this.curReuseCount.get();
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void w(String imageUrlOrPath, boolean isNightTheme) {
        MiniHomeStaticImageComponent miniHomeStaticImageComponent = this.staticImageComponent;
        if (miniHomeStaticImageComponent != null) {
            miniHomeStaticImageComponent.d(imageUrlOrPath, isNightTheme);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void a(IMiniHomeLoadCallback callback) {
        QLog.i("MiniHomeController", 1, "loadAvatar");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.a(callback);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void c(String roomJsonString, IMiniHomeLoadCallback callback) {
        QLog.i("MiniHomeController", 1, "loadRoom");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.c(roomJsonString, callback);
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.z
    public void destroy() {
        QLog.i("MiniHomeController", 1, "destroy");
        this.curReuseCount.decrementAndGet();
        if (this.curReuseCount.get() == 0) {
            ReentrantLock reentrantLock = this.eventCallbackLock;
            reentrantLock.lock();
            try {
                this.miniHomeSceneEventCallbackRefList.clear();
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
                if (aVar != null) {
                    aVar.release();
                }
                this.decorateComponent = null;
                this.staticImageComponent = null;
                this.curReuseCount = new AtomicInteger(0);
                this.hasInit = false;
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.y
    public void l() {
        QLog.i("MiniHomeController", 1, "resetRoomAndAvatar");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.p(new b());
        }
        com.tencent.mobileqq.zplan.minihome.view.a aVar2 = this.decorateComponent;
        if (aVar2 != null) {
            aVar2.l();
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.z
    public void pause() {
        QLog.i("MiniHomeController", 1, "pause");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.pause();
        }
    }

    @Override // com.tencent.mobileqq.zplan.minihome.z
    public void resume() {
        QLog.i("MiniHomeController", 1, "resume");
        com.tencent.mobileqq.zplan.minihome.view.a aVar = this.decorateComponent;
        if (aVar != null) {
            aVar.resume();
        }
    }
}
