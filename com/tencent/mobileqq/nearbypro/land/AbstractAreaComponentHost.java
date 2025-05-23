package com.tencent.mobileqq.nearbypro.land;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import bb2.d;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.utils.u;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 =2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001>B'\u0012\u0006\u0010:\u001a\u00020\u001d\u0012\u0006\u0010#\u001a\u00020\u001f\u0012\u0006\u0010)\u001a\u00020$\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u0014\u0010#\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010)\u001a\u00020$8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\u0012\u001a\u00020\u00118\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010,R \u00101\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u00106\u001a\u0004\b7\u00108\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/AbstractAreaComponentHost;", "Landroid/widget/FrameLayout;", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "Lbb2/d;", "Leb2/a;", "", "t", "r", ReportConstant.COSTREPORT_PREFIX, "l", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "Landroidx/lifecycle/LifecycleObserver;", "observer", "w", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "f", "", "Lcom/tencent/mobileqq/nearbypro/land/i;", "u", "k", "v", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Landroid/app/Activity;", "getHostActivity", "Landroid/content/Context;", "getHostContext", "Landroidx/lifecycle/LifecycleOwner;", "getHostLifecycleOwner", "d", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/nearbypro/land/h;", "e", "Lcom/tencent/mobileqq/nearbypro/land/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/nearbypro/land/h;", "areaParam", "Lcom/tencent/mobileqq/nearbypro/part/a;", "p", "()Lcom/tencent/mobileqq/nearbypro/part/a;", tl.h.F, "Ljava/util/List;", "o", "()Ljava/util/List;", "componentList", "i", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "Lcom/tencent/biz/richframework/part/PartManager;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/biz/richframework/part/PartManager;", "partManager", "context", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/nearbypro/land/h;Lcom/tencent/mobileqq/nearbypro/part/a;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class AbstractAreaComponentHost extends FrameLayout implements IPartHost, bb2.d<eb2.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AreaParam areaParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.nearbypro.part.a host;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<i> componentList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelStore viewModelStore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy partManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractAreaComponentHost(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull AreaParam areaParam, @NotNull com.tencent.mobileqq.nearbypro.part.a host) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(areaParam, "areaParam");
        Intrinsics.checkNotNullParameter(host, "host");
        this.lifecycleOwner = lifecycleOwner;
        this.areaParam = areaParam;
        this.host = host;
        this.componentList = new ArrayList();
        this.viewModelStore = new ViewModelStore();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PartManager>() { // from class: com.tencent.mobileqq.nearbypro.land.AbstractAreaComponentHost$partManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PartManager invoke() {
                AbstractAreaComponentHost abstractAreaComponentHost = AbstractAreaComponentHost.this;
                return new PartManager(abstractAreaComponentHost, abstractAreaComponentHost);
            }
        });
        this.partManager = lazy;
        t();
        r();
        s();
    }

    private final void l() {
        q().onPartCreate(getHostActivity(), null);
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPause() {
        q().onPartPause(getHostActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onResume() {
        q().onPartResume(getHostActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStart() {
        q().onPartStart(getHostActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStop() {
        q().onPartStop(getHostActivity());
    }

    private final PartManager q() {
        return (PartManager) this.partManager.getValue();
    }

    private final void r() {
        List<i> u16 = u();
        Iterator<T> it = u16.iterator();
        while (it.hasNext()) {
            ((i) it.next()).C9(this.areaParam);
        }
        this.componentList.addAll(u16);
        q().registerPart(u16);
        l();
    }

    private final void s() {
        this.lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.nearbypro.land.AbstractAreaComponentHost$initLifecycleListener$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes15.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f253359a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_STOP.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f253359a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                int i3 = a.f253359a[event.ordinal()];
                if (i3 == 1) {
                    AbstractAreaComponentHost.this.onStart();
                    return;
                }
                if (i3 == 2) {
                    AbstractAreaComponentHost.this.onResume();
                    return;
                }
                if (i3 == 3) {
                    AbstractAreaComponentHost.this.onPause();
                } else if (i3 == 4) {
                    AbstractAreaComponentHost.this.onStop();
                } else if (i3 == 5) {
                    AbstractAreaComponentHost.this.w(this);
                }
            }
        });
    }

    private final void t() {
        View b16 = u.f253961a.b(this.host, R.layout.fnc);
        if (b16 == null) {
            b16 = LayoutInflater.from(getContext()).inflate(R.layout.fnc, (ViewGroup) this, false);
        }
        addView(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(LifecycleObserver observer) {
        q().onPartDestroy(getHostActivity());
        this.lifecycleOwner.getLifecycle().removeObserver(observer);
        this.viewModelStore.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bb2.d
    public void f(@NotNull com.tencent.mobileqq.nearbypro.part.a host) {
        QPublicBaseFragment qPublicBaseFragment;
        PartManager partManager;
        Intrinsics.checkNotNullParameter(host, "host");
        d.a.a(this, host);
        if (host instanceof QPublicBaseFragment) {
            qPublicBaseFragment = (QPublicBaseFragment) host;
        } else {
            qPublicBaseFragment = null;
        }
        if (qPublicBaseFragment != null && (partManager = qPublicBaseFragment.getPartManager()) != null) {
            partManager.setPartManagerObservers(q());
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    @NotNull
    public Activity getHostActivity() {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) context;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public Context getHostContext() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return context;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    /* renamed from: getHostLifecycleOwner, reason: from getter */
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore, reason: from getter */
    public ViewModelStore get_viewModelStore() {
        return this.viewModelStore;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Object getViewTagData() {
        return ne0.a.d(this);
    }

    @Override // bb2.d
    public void h() {
        d.a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: m, reason: from getter */
    public final AreaParam getAreaParam() {
        return this.areaParam;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<i> o() {
        return this.componentList;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: p, reason: from getter */
    public final com.tencent.mobileqq.nearbypro.part.a getHost() {
        return this.host;
    }

    @NotNull
    public List<i> u() {
        return new ArrayList();
    }

    @Override // bb2.d
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void e(@NotNull eb2.a aVar, @NotNull com.tencent.mobileqq.nearbypro.part.a aVar2, @NotNull MotionEvent motionEvent) {
        d.a.c(this, aVar, aVar2, motionEvent);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // bb2.d
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public AbstractAreaComponentHost d() {
        return this;
    }

    public void v() {
    }
}
