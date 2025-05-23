package com.tencent.mvi.base.route;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.runtime.wrapper.LifeCycleAction1Wrapper;
import com.tencent.mvi.runtime.wrapper.LifeCycleActionR1Wrapper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001'B\u001d\u0012\b\b\u0002\u00108\u001a\u00020\u0012\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b>\u0010?J<\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H\u0002J\"\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J.\u0010\u0011\u001a\u00020\f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u001a\u0010\u001e\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u001a\u0010\u001f\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010#\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010&\u001a\u0004\u0018\u00010$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010'\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010*\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016J\"\u0010+\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020(H\u0016R\u0014\u0010-\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010,R\u0016\u0010.\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010,R,\u00100\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010/R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010/R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010/R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u00104R\u0017\u00108\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b6\u00107R\u0019\u0010=\u001a\u0004\u0018\u0001098\u0006\u00a2\u0006\f\n\u0004\b \u0010:\u001a\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mvi/base/route/VMMessenger;", "Lcom/tencent/mvi/base/route/j;", "", QQBrowserActivity.KEY_MSG_TYPE, "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mvi/base/route/a;", "map", "u", "action", "actionKey", "", "v", "", "Lcom/tencent/mvi/base/route/MsgIntent;", "message", "w", "", ReportConstant.COSTREPORT_PREFIX, "nextTimeSlice", "Lkotlin/Function0;", HippyTKDListViewAdapter.X, "Lcom/tencent/mvi/base/route/g;", "subscribe", "f", "Lcom/tencent/mvi/base/route/b;", "l", "e", "i", "d", "j", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, AdMetricTag.EVENT_NAME, "b", "Lcom/tencent/mvi/base/route/k;", "k", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "c", "g", "Z", "debug", "isDispatching", "Ljava/util/concurrent/ConcurrentHashMap;", "mActionMap", "mActionRMap", "mStickyEvents", "Landroid/os/Handler;", "Landroid/os/Handler;", "handle", "getUseOpt", "()Z", "useOpt", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mvi/api/runtime/b;", "t", "()Lcom/tencent/mvi/api/runtime/b;", "context", "<init>", "(ZLcom/tencent/mvi/api/runtime/b;)V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class VMMessenger implements j {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean debug;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isDispatching;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, a>> mActionMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, b> mActionRMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, MsgIntent> mStickyEvents;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Handler handle;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean useOpt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mvi.api.runtime.b context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mvi/base/route/VMMessenger$a;", "", "", "TAG", "Ljava/lang/String;", "", "THRESHOLD_STATE", "I", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mvi.base.route.VMMessenger$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8711);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VMMessenger(boolean z16, @Nullable com.tencent.mvi.api.runtime.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(z16), bVar);
            return;
        }
        this.useOpt = z16;
        this.context = bVar;
        this.debug = com.tencent.mvi.a.f337742b.a();
        this.mActionMap = new ConcurrentHashMap<>();
        this.mActionRMap = new ConcurrentHashMap<>();
        this.mStickyEvents = new ConcurrentHashMap<>();
        this.handle = new Handler(Looper.getMainLooper());
    }

    private final boolean s() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConcurrentHashMap<Integer, a> u(String msgType, Map<String, ConcurrentHashMap<Integer, a>> map) {
        if (!map.containsKey(msgType)) {
            ConcurrentHashMap<Integer, a> concurrentHashMap = new ConcurrentHashMap<>();
            map.put(msgType, concurrentHashMap);
            return concurrentHashMap;
        }
        ConcurrentHashMap<Integer, a> concurrentHashMap2 = map.get(msgType);
        Intrinsics.checkNotNull(concurrentHashMap2);
        return concurrentHashMap2;
    }

    private final void v(final String msgType, final a action, final int actionKey) {
        x(this.isDispatching, new Function0<Unit>(msgType, action, actionKey) { // from class: com.tencent.mvi.base.route.VMMessenger$innerRegister$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ a $action;
            final /* synthetic */ int $actionKey;
            final /* synthetic */ String $msgType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$msgType = msgType;
                this.$action = action;
                this.$actionKey = actionKey;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, VMMessenger.this, msgType, action, Integer.valueOf(actionKey));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap u16;
                ConcurrentHashMap concurrentHashMap2;
                ConcurrentHashMap concurrentHashMap3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                String str = this.$msgType;
                if (str == null) {
                    return;
                }
                VMMessenger vMMessenger = VMMessenger.this;
                concurrentHashMap = vMMessenger.mActionMap;
                u16 = vMMessenger.u(str, concurrentHashMap);
                u16.put(Integer.valueOf(this.$actionKey), this.$action);
                if (this.$action.sticky()) {
                    concurrentHashMap2 = VMMessenger.this.mStickyEvents;
                    if (concurrentHashMap2.containsKey(this.$msgType)) {
                        concurrentHashMap3 = VMMessenger.this.mStickyEvents;
                        MsgIntent it = (MsgIntent) concurrentHashMap3.get(this.$msgType);
                        if (it != null) {
                            a aVar = this.$action;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            aVar.call(it);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Map.Entry<Integer, ? extends a> action, MsgIntent message, String msgType) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (action.getValue() != null) {
            action.getValue().call(message);
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (uptimeMillis2 > 5 && this.debug) {
            com.tencent.mvi.log.c.f337783b.c("VMMessenger", "\u8b66\u544a\u26a0\ufe0f \u6d88\u606f msgType=" + msgType + ", cost=" + uptimeMillis2 + " it=" + action.getValue() + TokenParser.SP, new Throwable());
        }
    }

    private final void x(boolean nextTimeSlice, final Function0<Unit> action) {
        if (s() && !nextTimeSlice) {
            action.invoke();
        } else {
            this.handle.post(new Runnable() { // from class: com.tencent.mvi.base.route.VMMessenger$runInMainThread$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) Function0.this);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    } else {
                        Function0.this.invoke();
                    }
                }
            });
        }
    }

    static /* synthetic */ void y(VMMessenger vMMessenger, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        vMMessenger.x(z16, function0);
    }

    @Nullable
    public k A(@NotNull String msgType, @NotNull MsgIntent message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (k) iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgType, (Object) message);
        }
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!s() && this.debug) {
            throw new IllegalStateException("sendR must be access at Main Thread");
        }
        k kVar = null;
        if (!this.mActionRMap.containsKey(msgType)) {
            return null;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        b bVar = this.mActionRMap.get(msgType);
        if (bVar != null) {
            kVar = bVar.call(message);
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (uptimeMillis2 > 5 && this.debug) {
            com.tencent.mvi.log.c.f337783b.c("VMMessenger", "\u8b66\u544a\u26a0\ufe0f \u6d88\u606f msgType=" + msgType + ", cost=" + uptimeMillis2 + TokenParser.SP, new Throwable());
        }
        return kVar;
    }

    @Override // com.tencent.mvi.base.route.e
    public void a(@Nullable final String msgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) msgType);
        } else {
            y(this, false, new Function0<Unit>(msgType) { // from class: com.tencent.mvi.base.route.VMMessenger$unregisterR$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $msgType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$msgType = msgType;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) VMMessenger.this, (Object) msgType);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConcurrentHashMap concurrentHashMap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    com.tencent.mvi.a.f337742b.a();
                    concurrentHashMap = VMMessenger.this.mActionRMap;
                    String str = this.$msgType;
                    if (concurrentHashMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                    }
                    m.a(TypeIntrinsics.asMutableMap(concurrentHashMap).remove(str));
                }
            }, 1, null);
        }
    }

    @Override // com.tencent.mvi.base.route.d
    public void b(@Nullable final String eventName, @NotNull final a action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) eventName, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            x(this.isDispatching, new Function0<Unit>(eventName, action) { // from class: com.tencent.mvi.base.route.VMMessenger$unregister$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ a $action;
                final /* synthetic */ String $eventName;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$eventName = eventName;
                    this.$action = action;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, VMMessenger.this, eventName, action);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConcurrentHashMap concurrentHashMap;
                    ConcurrentHashMap concurrentHashMap2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    concurrentHashMap = VMMessenger.this.mActionMap;
                    String str = this.$eventName;
                    if (concurrentHashMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                    }
                    if (concurrentHashMap.containsKey(str)) {
                        concurrentHashMap2 = VMMessenger.this.mActionMap;
                        Object obj = concurrentHashMap2.get(this.$eventName);
                        Intrinsics.checkNotNull(obj);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mvi.base.route.d
    public void c(@Nullable String msgType, @NotNull a action, @NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, msgType, action, lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (msgType == null) {
            return;
        }
        LifeCycleAction1Wrapper lifeCycleAction1Wrapper = new LifeCycleAction1Wrapper(action, msgType, lifecycleOwner, this);
        if (!lifeCycleAction1Wrapper.a()) {
            com.tencent.mvi.log.c.f337783b.b("VMMessenger", "register in destroy state, please check!! " + action);
            return;
        }
        v(msgType, lifeCycleAction1Wrapper, lifeCycleAction1Wrapper.d());
        lifecycleOwner.getLifecycle().addObserver(lifeCycleAction1Wrapper);
    }

    @Override // com.tencent.mvi.base.route.d
    public void d(@Nullable String msgType, @NotNull a action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgType, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            v(msgType, action, action.hashCode());
        }
    }

    @Override // com.tencent.mvi.base.route.e
    public void e(@NotNull g subscribe) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) subscribe);
            return;
        }
        Intrinsics.checkNotNullParameter(subscribe, "subscribe");
        Set<String> subscribeEventRNames = subscribe.getSubscribeEventRNames();
        if (subscribeEventRNames != null) {
            Iterator<T> it = subscribeEventRNames.iterator();
            while (it.hasNext()) {
                a((String) it.next());
            }
        }
    }

    @Override // com.tencent.mvi.base.route.d
    public void f(@NotNull g subscribe, @NotNull a action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) subscribe, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(subscribe, "subscribe");
        Intrinsics.checkNotNullParameter(action, "action");
        Set<String> subscribeEventNames = subscribe.getSubscribeEventNames();
        if (subscribeEventNames != null) {
            Iterator<T> it = subscribeEventNames.iterator();
            while (it.hasNext()) {
                d((String) it.next(), action);
            }
        }
    }

    @Override // com.tencent.mvi.base.route.e
    public void g(@Nullable String msgType, @NotNull b action, @NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, msgType, action, lifecycleOwner);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifeCycleActionR1Wrapper lifeCycleActionR1Wrapper = new LifeCycleActionR1Wrapper(action, msgType, lifecycleOwner, this);
        if (!lifeCycleActionR1Wrapper.a()) {
            com.tencent.mvi.log.c.f337783b.b("VMMessenger", "register in destroy state, please check!! " + action);
            return;
        }
        j(msgType, lifeCycleActionR1Wrapper);
        lifecycleOwner.getLifecycle().addObserver(lifeCycleActionR1Wrapper);
    }

    @Override // com.tencent.mvi.base.route.d
    public void h(@NotNull MsgIntent message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) message);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.useOpt && ((AutoEventName) message.getClass().getAnnotation(AutoEventName.class)) != null) {
            String eventName = message.eventName();
            Intrinsics.checkNotNull(eventName);
            z(eventName, message);
        } else {
            String b16 = c.b(message.getClass());
            Intrinsics.checkNotNullExpressionValue(b16, "ClassUtil.get(message::class.java)");
            z(b16, message);
        }
    }

    @Override // com.tencent.mvi.base.route.d
    public void i(@NotNull g subscribe, @NotNull a action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) subscribe, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(subscribe, "subscribe");
        Intrinsics.checkNotNullParameter(action, "action");
        Set<String> subscribeEventNames = subscribe.getSubscribeEventNames();
        if (subscribeEventNames != null) {
            Iterator<T> it = subscribeEventNames.iterator();
            while (it.hasNext()) {
                b((String) it.next(), action);
            }
        }
    }

    @Override // com.tencent.mvi.base.route.e
    public void j(@Nullable final String msgType, @NotNull final b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgType, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            y(this, false, new Function0<Unit>(msgType, action) { // from class: com.tencent.mvi.base.route.VMMessenger$registerR$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ b $action;
                final /* synthetic */ String $msgType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$msgType = msgType;
                    this.$action = action;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, VMMessenger.this, msgType, action);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ConcurrentHashMap concurrentHashMap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this);
                        return;
                    }
                    if (this.$msgType == null) {
                        return;
                    }
                    concurrentHashMap = VMMessenger.this.mActionRMap;
                    b bVar = (b) concurrentHashMap.put(this.$msgType, this.$action);
                    if (bVar == null || !com.tencent.mvi.a.f337742b.a()) {
                        return;
                    }
                    com.tencent.mvi.log.c.f337783b.a("VMMessenger", "registerR error duplicate msgType " + bVar);
                }
            }, 1, null);
        }
    }

    @Override // com.tencent.mvi.base.route.e
    @Nullable
    public k k(@NotNull MsgIntent message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (k) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message);
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.useOpt) {
            String eventName = message.eventName();
            if (!TextUtils.isEmpty(eventName)) {
                Intrinsics.checkNotNull(eventName);
                return A(eventName, message);
            }
        }
        String qualifiedName = Reflection.getOrCreateKotlinClass(message.getClass()).getQualifiedName();
        Intrinsics.checkNotNull(qualifiedName);
        return A(qualifiedName, message);
    }

    @Override // com.tencent.mvi.base.route.e
    public void l(@NotNull g subscribe, @NotNull b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) subscribe, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(subscribe, "subscribe");
        Intrinsics.checkNotNullParameter(action, "action");
        Set<String> subscribeEventRNames = subscribe.getSubscribeEventRNames();
        if (subscribeEventRNames != null) {
            Iterator<T> it = subscribeEventRNames.iterator();
            while (it.hasNext()) {
                j((String) it.next(), action);
            }
        }
    }

    @Nullable
    public final com.tencent.mvi.api.runtime.b t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.mvi.api.runtime.b) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.context;
    }

    public void z(@NotNull final String msgType, @NotNull final MsgIntent message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgType, (Object) message);
            return;
        }
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(message, "message");
        y(this, false, new Function0<Unit>(msgType, message) { // from class: com.tencent.mvi.base.route.VMMessenger$send$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MsgIntent $message;
            final /* synthetic */ String $msgType;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$msgType = msgType;
                this.$message = message;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, VMMessenger.this, msgType, message);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                ConcurrentHashMap concurrentHashMap3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                VMMessenger.this.isDispatching = true;
                if (this.$message.isSticky() && this.$msgType != null) {
                    concurrentHashMap3 = VMMessenger.this.mStickyEvents;
                    concurrentHashMap3.put(this.$msgType, this.$message);
                }
                concurrentHashMap = VMMessenger.this.mActionMap;
                if (!concurrentHashMap.containsKey(this.$msgType)) {
                    VMMessenger.this.isDispatching = false;
                    return;
                }
                concurrentHashMap2 = VMMessenger.this.mActionMap;
                ConcurrentHashMap concurrentHashMap4 = (ConcurrentHashMap) concurrentHashMap2.get(this.$msgType);
                if (concurrentHashMap4 == null) {
                    VMMessenger.this.isDispatching = false;
                    return;
                }
                com.tencent.mvi.api.runtime.b t16 = VMMessenger.this.t();
                if ((t16 != null ? t16.a() : null) != null) {
                    com.tencent.mvi.api.runtime.a a16 = VMMessenger.this.t().a();
                    Intrinsics.checkNotNullExpressionValue(a16, "context.aioPoster");
                    if (!a16.e()) {
                        VMMessenger.this.t().a().f(new Runnable(concurrentHashMap4) { // from class: com.tencent.mvi.base.route.VMMessenger$send$1.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ ConcurrentHashMap f337759d;

                            {
                                this.f337759d = concurrentHashMap4;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this, (Object) VMMessenger$send$1.this, (Object) concurrentHashMap4);
                                }
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this);
                                    return;
                                }
                                for (Map.Entry entry : this.f337759d.entrySet()) {
                                    VMMessenger$send$1 vMMessenger$send$1 = VMMessenger$send$1.this;
                                    VMMessenger.this.w(entry, vMMessenger$send$1.$message, vMMessenger$send$1.$msgType);
                                }
                            }
                        });
                        VMMessenger.this.isDispatching = false;
                    }
                }
                Iterator it = concurrentHashMap4.entrySet().iterator();
                while (it.hasNext()) {
                    VMMessenger.this.w((Map.Entry) it.next(), this.$message, this.$msgType);
                }
                VMMessenger.this.isDispatching = false;
            }
        }, 1, null);
    }

    public /* synthetic */ VMMessenger(boolean z16, com.tencent.mvi.api.runtime.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), bVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
