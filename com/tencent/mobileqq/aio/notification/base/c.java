package com.tencent.mobileqq.aio.notification.base;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.notification.base.AIONotificationEvent;
import com.tencent.mobileqq.aio.reserve2.notification.AIONotificationUIState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001c\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/aio/notification/base/c;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState;", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msg", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "call", "", "kotlin.jvm.PlatformType", "e", "Ljava/lang/String;", "TAG", "", "f", "J", "lastHandleEventTime", "", tl.h.F, "Ljava/util/List;", "pendingEvent", "i", "Z", "isHandlingPendingEvent", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public abstract class c extends com.tencent.qqnt.aio.baseVM.a<com.tencent.mobileqq.aio.reserve2.notification.a, AIONotificationUIState> implements com.tencent.mvi.base.route.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastHandleEventTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<MsgIntent> pendingEvent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isHandlingPendingEvent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/base/c$a;", "", "", "DEFAULT_UPDATE_UI_INTERVAL", "J", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.base.c$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = getClass().getSimpleName();
        this.pendingEvent = new ArrayList();
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final void m(MsgIntent msg2) {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "handleEvent: msg=" + msg2);
        }
        if (msg2 instanceof AIONotificationEvent.AddNotificationEvent) {
            updateUI(new AIONotificationUIState.AddNotificationUIState(((AIONotificationEvent.AddNotificationEvent) msg2).a()));
        } else if (msg2 instanceof AIONotificationEvent.UpdateNotificationEvent) {
            updateUI(new AIONotificationUIState.UpdateNotificationUIState(((AIONotificationEvent.UpdateNotificationEvent) msg2).a()));
        } else if (msg2 instanceof AIONotificationEvent.RemoveNotificationEvent) {
            updateUI(new AIONotificationUIState.RemoveNotificationUIState(((AIONotificationEvent.RemoveNotificationEvent) msg2).a()));
        }
        this.lastHandleEventTime = System.currentTimeMillis();
    }

    private final void n() {
        if (this.isHandlingPendingEvent) {
            return;
        }
        this.isHandlingPendingEvent = true;
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.notification.base.b
            @Override // java.lang.Runnable
            public final void run() {
                c.o(c.this);
            }
        }, 300 - (System.currentTimeMillis() - this.lastHandleEventTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(c this$0) {
        Object removeFirstOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(this$0.pendingEvent);
        MsgIntent msgIntent = (MsgIntent) removeFirstOrNull;
        if (msgIntent != null) {
            this$0.m(msgIntent);
        }
        this$0.isHandlingPendingEvent = false;
        if (!this$0.pendingEvent.isEmpty()) {
            this$0.n();
        }
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (this.isHandlingPendingEvent) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "call: handingPendingEvent msg=" + msg2);
            }
            this.pendingEvent.add(msg2);
            return;
        }
        if (System.currentTimeMillis() - this.lastHandleEventTime > 300) {
            m(msg2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "call: wait time interval, msg=" + msg2);
        }
        this.pendingEvent.add(msg2);
        n();
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        com.tencent.mvi.base.route.j e16 = context.e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        String a16 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.AddNotificationEvent.class));
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        e16.c(a16, this, d16);
        com.tencent.mvi.base.route.j e17 = context.e();
        String a17 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.RemoveNotificationEvent.class));
        LifecycleOwner d17 = context.d();
        Intrinsics.checkNotNullExpressionValue(d17, "context.lifecycleOwner");
        e17.c(a17, this, d17);
        com.tencent.mvi.base.route.j e18 = context.e();
        String a18 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateNotificationEvent.class));
        LifecycleOwner d18 = context.d();
        Intrinsics.checkNotNullExpressionValue(d18, "context.lifecycleOwner");
        e18.c(a18, this, d18);
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "onCreate: ");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.AddNotificationEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.RemoveNotificationEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateNotificationEvent.class)), this);
        this.handler.removeCallbacksAndMessages(null);
        this.isHandlingPendingEvent = false;
        this.pendingEvent.clear();
        this.lastHandleEventTime = 0L;
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return a.C9235a.a(this);
    }
}
