package com.tencent.mobileqq.qqshop.publicaccount.title;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqshop.api.IQQShopApi;
import com.tencent.mobileqq.qqshop.publicaccount.b;
import com.tencent.mobileqq.qqshop.publicaccount.d;
import com.tencent.mobileqq.qqshop.publicaccount.menu.QQShopPAMenuIntent;
import com.tencent.mobileqq.qqshop.publicaccount.title.QQShopPATitleState;
import com.tencent.mobileqq.qqshop.publicaccount.title.a;
import com.tencent.mobileqq.qqshop.report.dev.KuiklyLaunchAction;
import com.tencent.mobileqq.qqshop.report.dev.KuiklyLaunchData;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0013\u001a\u00020\u0012*\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016R$\u0010 \u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/title/QQShopPATitleVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/mobileqq/qqshop/publicaccount/title/a;", "Lcom/tencent/mobileqq/qqshop/publicaccount/title/QQShopPATitleState;", "Landroidx/lifecycle/LifecycleObserver;", "", "isNeedExitReport", "", "w", "", "toTabIndex", "G", "u", "t", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "D", "", "Lorg/json/JSONObject;", "H", "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", "intent", "v", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "value", "d", "I", UserInfo.SEX_FEMALE, "(I)V", "currentTabIndex", "Lcom/tencent/mobileqq/qqshop/publicaccount/d$b;", "e", "Lcom/tencent/mobileqq/qqshop/publicaccount/d$b;", "dailyTitleStyle", "f", "coinsTitleStyle", tl.h.F, "paTitleStyle", "i", "Z", "isPageShowReported", "Lcom/tencent/mobileqq/qqshop/publicaccount/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqshop/publicaccount/b;", "adapter", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "reportTimeOutRunnable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mReceiverRegistered", "Lcom/tencent/mobileqq/qqshop/report/dev/KuiklyLaunchData;", "E", "Lcom/tencent/mobileqq/qqshop/report/dev/KuiklyLaunchData;", "kuiklyLaunchData", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mReceiver", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQShopPATitleVM extends com.tencent.aio.base.mvvm.b<com.tencent.mobileqq.qqshop.publicaccount.title.a, QQShopPATitleState> implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Runnable reportTimeOutRunnable;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean mReceiverRegistered;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private KuiklyLaunchData kuiklyLaunchData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final BroadcastReceiver mReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currentTabIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d.b dailyTitleStyle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d.b coinsTitleStyle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d.b paTitleStyle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPageShowReported;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqshop.publicaccount.b adapter;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/title/QQShopPATitleVM$a", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "onBackEvent", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements com.tencent.aio.api.runtime.emitter.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.runtime.emitter.a
        public boolean onBackEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    public QQShopPATitleVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.currentTabIndex = -1;
        com.tencent.mobileqq.qqshop.publicaccount.d dVar = com.tencent.mobileqq.qqshop.publicaccount.d.f274576a;
        this.dailyTitleStyle = dVar.h();
        this.coinsTitleStyle = dVar.h();
        this.paTitleStyle = dVar.h();
        this.mReceiverRegistered = new AtomicBoolean(false);
        this.mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.QQShopPATitleVM$mReceiver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQShopPATitleVM.this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null && action.hashCode() == -462174703 && action.equals(IQQShopApi.FINISH_QQ_SHOP_AIO)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("aio_disappear_type", "1");
                    ((com.tencent.aio.api.runtime.a) QQShopPATitleVM.this.getMContext()).e().h(new ExternalCommIntent("close_aio", bundle));
                }
                QLog.i(FrameworkVM.TAG, 2, "onReceive: action:" + intent.getAction());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void C() {
        if (this.mReceiverRegistered.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IQQShopApi.FINISH_QQ_SHOP_AIO);
            MobileQQ.sMobileQQ.registerReceiver(this.mReceiver, intentFilter);
            QLog.i(FrameworkVM.TAG, 2, "registerBroadcast");
        }
    }

    private final void D() {
        if (this.mReceiverRegistered.compareAndSet(true, false)) {
            MobileQQ.sMobileQQ.unregisterReceiver(this.mReceiver);
            QLog.i(FrameworkVM.TAG, 2, "removeBroadcast");
        }
    }

    private final void F(int i3) {
        this.currentTabIndex = i3;
        if (i3 == 0) {
            com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.i().postValue(0);
        } else if (i3 == com.tencent.mobileqq.qqshop.publicaccount.b.INSTANCE.b()) {
            com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.j().postValue(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G(int toTabIndex) {
        if (this.currentTabIndex == toTabIndex) {
            return;
        }
        F(toTabIndex);
        if (toTabIndex == 0) {
            updateUI(new QQShopPATitleState.UpdateTitleStyle(this.dailyTitleStyle));
        } else {
            b.Companion companion = com.tencent.mobileqq.qqshop.publicaccount.b.INSTANCE;
            if (toTabIndex == companion.a()) {
                updateUI(new QQShopPATitleState.UpdateTitleStyle(this.coinsTitleStyle));
                updateUI(new QQShopPATitleState.UpdateCoinsMsgRedDot(false));
            } else if (toTabIndex == companion.b()) {
                updateUI(new QQShopPATitleState.UpdateTitleStyle(this.paTitleStyle));
                if (!this.isPageShowReported) {
                    com.tencent.mobileqq.qqshop.report.beacon.b.f274709a.b("qgg_gzh_lifeselection_coupontab_page_show", new HashMap<>());
                    this.isPageShowReported = true;
                }
            }
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new QQShopPAMenuIntent.SwitchTabWithIndex(toTabIndex));
        updateUI(new QQShopPATitleState.SwitchTabWithIndex(toTabIndex));
    }

    private final JSONObject H(String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e16) {
            QLog.e(FrameworkVM.TAG, 2, "toJSON error: " + e16.getMessage());
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.c();
    }

    private final void w(boolean isNeedExitReport) {
        KuiklyLaunchData kuiklyLaunchData;
        String str;
        KuiklyLaunchData kuiklyLaunchData2 = this.kuiklyLaunchData;
        if (kuiklyLaunchData2 != null) {
            com.tencent.mobileqq.qqshop.publicaccount.b bVar = this.adapter;
            if (bVar != null) {
                str = bVar.k0();
            } else {
                str = null;
            }
            kuiklyLaunchData2.addActions(H(str));
        }
        if (isNeedExitReport && (kuiklyLaunchData = this.kuiklyLaunchData) != null) {
            KuiklyLaunchData.addNativeAction$default(kuiklyLaunchData, KuiklyLaunchAction.PAGE_EXIT, 0L, 2, null);
        }
        KuiklyLaunchData kuiklyLaunchData3 = this.kuiklyLaunchData;
        if (kuiklyLaunchData3 != null) {
            kuiklyLaunchData3.doReport();
        }
        this.kuiklyLaunchData = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        Bundle bundle = new Bundle();
        bundle.putString("aio_disappear_type", "1");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ExternalCommIntent("close_aio", bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(QQShopPATitleVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w(false);
        QLog.d(FrameworkVM.TAG, 1, "launch report time out");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull final com.tencent.aio.api.runtime.a context, boolean reuse) {
        KuiklyLaunchData kuiklyLaunchData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        Serializable serializable = context.g().l().getSerializable("qqshop_launch_data");
        HashMap hashMap = null;
        if (serializable instanceof KuiklyLaunchData) {
            kuiklyLaunchData = (KuiklyLaunchData) serializable;
        } else {
            kuiklyLaunchData = null;
        }
        this.kuiklyLaunchData = kuiklyLaunchData;
        com.tencent.mobileqq.qqshop.report.dev.b.f274713a.i(new WeakReference<>(this.kuiklyLaunchData));
        KuiklyLaunchData kuiklyLaunchData2 = this.kuiklyLaunchData;
        if (kuiklyLaunchData2 != null) {
            KuiklyLaunchData.addNativeAction$default(kuiklyLaunchData2, KuiklyLaunchAction.LOAD_VIEW_START, 0L, 2, null);
            this.reportTimeOutRunnable = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.g
                @Override // java.lang.Runnable
                public final void run() {
                    QQShopPATitleVM.y(QQShopPATitleVM.this);
                }
            }, 16, null, true, kuiklyLaunchData2.getReportTimeOut());
        }
        ml3.a a16 = context.b().a(com.tencent.aio.api.runtime.emitter.a.class);
        a aVar = new a();
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        a16.b(aVar, d16);
        com.tencent.mobileqq.qqshop.publicaccount.d dVar = com.tencent.mobileqq.qqshop.publicaccount.d.f274576a;
        MutableLiveData<d.b> f16 = dVar.f();
        LifecycleOwner d17 = context.d();
        final Function1<d.b, Unit> function1 = new Function1<d.b, Unit>(context) { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.QQShopPATitleVM$onCreate$3
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.aio.api.runtime.a $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQShopPATitleVM.this, (Object) context);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable d.b bVar) {
                int i3;
                d.b bVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                QQShopPATitleVM qQShopPATitleVM = QQShopPATitleVM.this;
                if (bVar == null) {
                    bVar = com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.h();
                }
                qQShopPATitleVM.dailyTitleStyle = bVar;
                i3 = QQShopPATitleVM.this.currentTabIndex;
                if (i3 == 0) {
                    QQShopPATitleVM qQShopPATitleVM2 = QQShopPATitleVM.this;
                    bVar2 = qQShopPATitleVM2.dailyTitleStyle;
                    qQShopPATitleVM2.updateUI(new QQShopPATitleState.UpdateTitleStyle(bVar2));
                    Context context2 = this.$context.c().getContext();
                    Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
                    if (activity != null) {
                        QUIImmersiveHelper.s(activity, true, false);
                    }
                }
            }
        };
        f16.observe(d17, new Observer() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQShopPATitleVM.z(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> i3 = dVar.i();
        LifecycleOwner d18 = context.d();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.QQShopPATitleVM$onCreate$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQShopPATitleVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                int i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                i16 = QQShopPATitleVM.this.currentTabIndex;
                if (i16 != 0) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.intValue() > 0) {
                        QQShopPATitleVM.this.updateUI(new QQShopPATitleState.UpdateUnreadDailyMsgCount(it.intValue()));
                        return;
                    }
                }
                QQShopPATitleVM.this.updateUI(new QQShopPATitleState.UpdateUnreadDailyMsgCount(0));
                QQShopPATitleVM.this.t();
            }
        };
        i3.observe(d18, new Observer() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQShopPATitleVM.A(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> j3 = dVar.j();
        LifecycleOwner d19 = context.d();
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.QQShopPATitleVM$onCreate$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQShopPATitleVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                int i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                i16 = QQShopPATitleVM.this.currentTabIndex;
                if (i16 != com.tencent.mobileqq.qqshop.publicaccount.b.INSTANCE.b()) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.intValue() > 0) {
                        QQShopPATitleVM.this.updateUI(new QQShopPATitleState.UpdateUnreadPaMsgCount(it.intValue()));
                        return;
                    }
                }
                QQShopPATitleVM.this.updateUI(new QQShopPATitleState.UpdateUnreadPaMsgCount(0));
                QQShopPATitleVM.this.u();
            }
        };
        j3.observe(d19, new Observer() { // from class: com.tencent.mobileqq.qqshop.publicaccount.title.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQShopPATitleVM.B(Function1.this, obj);
            }
        });
        Serializable serializable2 = context.g().l().getSerializable("qq_shop_kuikly_params");
        if (serializable2 instanceof HashMap) {
            hashMap = (HashMap) serializable2;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        Fragment c16 = context.c();
        Intrinsics.checkNotNullExpressionValue(c16, "context.fragment");
        com.tencent.mobileqq.qqshop.publicaccount.b bVar = new com.tencent.mobileqq.qqshop.publicaccount.b(c16, hashMap);
        this.adapter = bVar;
        updateUI(new QQShopPATitleState.SetFragmentAdapter(bVar));
        G(context.g().l().getInt("qq_shop_tab_index"));
        try {
            C();
        } catch (Exception e16) {
            QLog.e(FrameworkVM.TAG, 1, e16, new Object[0]);
        }
        KuiklyLaunchData kuiklyLaunchData3 = this.kuiklyLaunchData;
        if (kuiklyLaunchData3 != null) {
            KuiklyLaunchData.addNativeAction$default(kuiklyLaunchData3, KuiklyLaunchAction.LOAD_VIEW_END, 0L, 2, null);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        Runnable runnable = this.reportTimeOutRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        w(true);
        try {
            D();
        } catch (Exception e16) {
            QLog.e(FrameworkVM.TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.qqshop.publicaccount.title.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.handleIntent(intent);
        if (intent instanceof a.c) {
            G(0);
            return;
        }
        if (intent instanceof a.b) {
            G(com.tencent.mobileqq.qqshop.publicaccount.b.INSTANCE.a());
        } else if (intent instanceof a.d) {
            G(com.tencent.mobileqq.qqshop.publicaccount.b.INSTANCE.b());
        } else if (intent instanceof a.C8431a) {
            x();
        }
    }
}
