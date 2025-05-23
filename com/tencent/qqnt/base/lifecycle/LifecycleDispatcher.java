package com.tencent.qqnt.base.lifecycle;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 E2\u00020\u0001:\u0001FB1\u0012\u0006\u0010<\u001a\u00020;\u0012\b\b\u0002\u0010>\u001a\u00020=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010\u0015\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR \u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010%R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010 R\u0018\u00102\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006G"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/LifecycleDispatcher;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "q1", "g", "e", "Lcom/tencent/qqnt/base/lifecycle/b;", "observer", "b", h.F, "onCreate", "onStart", "onResume", "Ljava/lang/Runnable;", "d", "(Landroidx/lifecycle/LifecycleOwner;)Ljava/lang/Runnable;", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "i", "()V", "", "f", "I", "mCostThreshold", "", "J", "mShowFirstDelay", "Landroid/util/SparseArray;", "Lcom/tencent/qqnt/base/lifecycle/data/b;", "Landroid/util/SparseArray;", "getObserverCostDataArray$ntui_kit_release", "()Landroid/util/SparseArray;", "observerCostDataArray", "", "Z", "mHasShowFirst", "mOnShowFirstDone", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mHasDestroy", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Handler;", "mUIHandler", "D", "mObserverList", "E", "Ljava/lang/Runnable;", "mOnShowFirstTask", "Lcom/tencent/mobileqq/inject/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/inject/b;", "getSAppSetting", "()Lcom/tencent/mobileqq/inject/b;", "setSAppSetting", "(Lcom/tencent/mobileqq/inject/b;)V", "sAppSetting", "Lcom/tencent/qqnt/base/lifecycle/c;", "observerProvider", "Lcom/tencent/qqnt/base/lifecycle/a;", "configProvider", "Landroidx/fragment/app/Fragment;", "fragment", "", "param", "<init>", "(Lcom/tencent/qqnt/base/lifecycle/c;Lcom/tencent/qqnt/base/lifecycle/a;Landroidx/fragment/app/Fragment;Ljava/lang/Object;)V", "G", "a", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LifecycleDispatcher implements DefaultLifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static ArrayList H;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Handler mUIHandler;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final SparseArray<b> mObserverList;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Runnable mOnShowFirstTask;

    /* renamed from: F, reason: from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Service/QQNTUI/Inject_AppSetting.yml", version = 1)
    @Nullable
    private com.tencent.mobileqq.inject.b sAppSetting;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mCostThreshold;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long mShowFirstDelay;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<com.tencent.qqnt.base.lifecycle.data.b> observerCostDataArray;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mHasShowFirst;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mOnShowFirstDone;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mHasDestroy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/LifecycleDispatcher$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.base.lifecycle.LifecycleDispatcher$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40518);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
            return;
        }
        ArrayList arrayList = new ArrayList();
        H = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
        INSTANCE = new Companion(null);
    }

    public LifecycleDispatcher(@NotNull c observerProvider, @NotNull a configProvider, @Nullable Fragment fragment, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(observerProvider, "observerProvider");
        Intrinsics.checkNotNullParameter(configProvider, "configProvider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, observerProvider, configProvider, fragment, obj);
            return;
        }
        this.mCostThreshold = configProvider.get().a();
        this.mShowFirstDelay = configProvider.get().b();
        this.observerCostDataArray = new SparseArray<>();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        SparseArray<b> sparseArray = observerProvider.get();
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            sparseArray.valueAt(i3).v0(obj, fragment);
        }
        this.mObserverList = sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LifecycleDispatcher this$0, WeakReference ownerWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ownerWrapper, "$ownerWrapper");
        boolean z16 = this$0.mHasDestroy;
        if (!z16 && !this$0.mOnShowFirstDone) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) ownerWrapper.get();
            if (lifecycleOwner != null) {
                this$0.q1(lifecycleOwner);
                return;
            }
            return;
        }
        QLog.d("LifecycleDispatcher", 1, "mOnShowFirstTask run fail , mHasDestroy: " + z16 + ", mOnShowFirstDone: " + this$0.mOnShowFirstDone);
    }

    private final void q1(LifecycleOwner owner) {
        QLog.d("LifecycleDispatcher", 1, "doOnShowFirst " + this);
        this.mOnShowFirstDone = true;
        Runnable runnable = this.mOnShowFirstTask;
        if (runnable != null) {
            this.mUIHandler.removeCallbacks(runnable);
        }
        SparseArray<b> sparseArray = this.mObserverList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            b valueAt = sparseArray.valueAt(i3);
            valueAt.q1(owner);
            valueAt.H1(owner);
        }
    }

    public final void b(@NotNull b observer) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        int id5 = observer.getId();
        e();
        contains = this.mObserverList.contains(id5);
        if (contains) {
            com.tencent.mobileqq.inject.b bVar = this.sAppSetting;
            Intrinsics.checkNotNull(bVar);
            if (bVar.isDebugVersion()) {
                throw new IllegalArgumentException("[LifecycleDispatcher] : Duplicate observer id " + id5 + ", check and reassign observer id");
            }
        }
        this.mObserverList.append(id5, observer);
    }

    @NotNull
    public final Runnable d(@NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Runnable) iPatchRedirector.redirect((short) 13, (Object) this, (Object) owner);
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        final WeakReference weakReference = new WeakReference(owner);
        return new Runnable() { // from class: com.tencent.qqnt.base.lifecycle.e
            @Override // java.lang.Runnable
            public final void run() {
                LifecycleDispatcher.c(LifecycleDispatcher.this, weakReference);
            }
        };
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.sAppSetting == null) {
            g();
        }
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mObserverList.size();
    }

    @QAutoInitMethod
    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.sAppSetting = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(H);
        }
    }

    public final void h(@NotNull b observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.mObserverList.remove(observer.getId());
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        SparseArray<com.tencent.qqnt.base.lifecycle.data.b> sparseArray = this.observerCostDataArray;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            com.tencent.qqnt.base.lifecycle.data.b valueAt = sparseArray.valueAt(i3);
            if (valueAt.d() > this.mCostThreshold) {
                QLog.d("LifecycleDispatcher", 1, "checkAndReportCostData high cost business data " + valueAt);
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onCreate(@NotNull LifecycleOwner owner) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        androidx.lifecycle.b.a(this, owner);
        QLog.d("LifecycleDispatcher", 1, "onCreate " + this);
        QLog.d("LifecycleDispatcher", 1, "dispatchAndStaticsLifecycleEvent " + this);
        SparseArray<b> sparseArray = this.mObserverList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = sparseArray.keyAt(i3);
            b valueAt = sparseArray.valueAt(i3);
            long uptimeMillis = SystemClock.uptimeMillis();
            valueAt.onCreate(owner);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            com.tencent.qqnt.base.lifecycle.data.b bVar = this.observerCostDataArray.get(keyAt);
            if (bVar == null) {
                com.tencent.qqnt.base.lifecycle.data.b bVar2 = new com.tencent.qqnt.base.lifecycle.data.b(valueAt.getModule(), valueAt.getTag(), keyAt, 0L, 0L, 0L, 56, null);
                this.observerCostDataArray.put(keyAt, bVar2);
                bVar = bVar2;
                j3 = uptimeMillis2;
            } else {
                j3 = uptimeMillis2;
            }
            bVar.a(j3);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        androidx.lifecycle.b.b(this, owner);
        QLog.d("LifecycleDispatcher", 1, "onDestroy " + this);
        this.mHasDestroy = true;
        SparseArray<b> sparseArray = this.mObserverList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            sparseArray.valueAt(i3).onDestroy(owner);
        }
        Runnable runnable = this.mOnShowFirstTask;
        if (runnable != null) {
            this.mUIHandler.removeCallbacks(runnable);
        }
        owner.getLifecycle().removeObserver(this);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onPause(@NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        androidx.lifecycle.b.c(this, owner);
        QLog.d("LifecycleDispatcher", 1, "onPause " + this);
        SparseArray<b> sparseArray = this.mObserverList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            sparseArray.valueAt(i3).onPause(owner);
        }
        i();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        androidx.lifecycle.b.d(this, owner);
        QLog.d("LifecycleDispatcher", 1, "onResume " + this);
        QLog.d("LifecycleDispatcher", 1, "dispatchAndStaticsLifecycleEvent " + this);
        SparseArray<b> sparseArray = this.mObserverList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = sparseArray.keyAt(i3);
            b valueAt = sparseArray.valueAt(i3);
            long uptimeMillis = SystemClock.uptimeMillis();
            valueAt.onResume(owner);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            com.tencent.qqnt.base.lifecycle.data.b bVar = this.observerCostDataArray.get(keyAt);
            if (bVar == null) {
                com.tencent.qqnt.base.lifecycle.data.b bVar2 = new com.tencent.qqnt.base.lifecycle.data.b(valueAt.getModule(), valueAt.getTag(), keyAt, 0L, 0L, 0L, 56, null);
                this.observerCostDataArray.put(keyAt, bVar2);
                bVar = bVar2;
                j3 = uptimeMillis2;
            } else {
                j3 = uptimeMillis2;
            }
            bVar.b(j3);
        }
        if (!this.mHasShowFirst) {
            Runnable d16 = d(owner);
            this.mOnShowFirstTask = d16;
            Handler handler = this.mUIHandler;
            Intrinsics.checkNotNull(d16);
            handler.postDelayed(d16, this.mShowFirstDelay);
        } else {
            SparseArray<b> sparseArray2 = this.mObserverList;
            int size2 = sparseArray2.size();
            for (int i16 = 0; i16 < size2; i16++) {
                sparseArray2.keyAt(i16);
                sparseArray2.valueAt(i16).H1(owner);
            }
        }
        this.mHasShowFirst = true;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onStart(@NotNull LifecycleOwner owner) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        androidx.lifecycle.b.e(this, owner);
        QLog.d("LifecycleDispatcher", 1, "onStart " + this);
        QLog.d("LifecycleDispatcher", 1, "dispatchAndStaticsLifecycleEvent " + this);
        SparseArray<b> sparseArray = this.mObserverList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = sparseArray.keyAt(i3);
            b valueAt = sparseArray.valueAt(i3);
            long uptimeMillis = SystemClock.uptimeMillis();
            valueAt.onStart(owner);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            com.tencent.qqnt.base.lifecycle.data.b bVar = this.observerCostDataArray.get(keyAt);
            if (bVar == null) {
                com.tencent.qqnt.base.lifecycle.data.b bVar2 = new com.tencent.qqnt.base.lifecycle.data.b(valueAt.getModule(), valueAt.getTag(), keyAt, 0L, 0L, 0L, 56, null);
                this.observerCostDataArray.put(keyAt, bVar2);
                bVar = bVar2;
                j3 = uptimeMillis2;
            } else {
                j3 = uptimeMillis2;
            }
            bVar.c(j3);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        androidx.lifecycle.b.f(this, owner);
        QLog.d("LifecycleDispatcher", 1, "onStop " + this);
        SparseArray<b> sparseArray = this.mObserverList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            sparseArray.valueAt(i3).onStop(owner);
        }
    }

    public /* synthetic */ LifecycleDispatcher(c cVar, a aVar, Fragment fragment, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, (i3 & 2) != 0 ? a.INSTANCE.a() : aVar, (i3 & 4) != 0 ? null : fragment, (i3 & 8) == 0 ? obj : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, cVar, aVar, fragment, obj, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
