package com.tencent.mobileqq.zplan.room.impl.trtc;

import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u0001\u001a\u0018\u0000  2\u00020\u0001:\u0002\u000e\bB\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager;", "", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager$b;", "listener", "", h.F, "", "k", "b", "i", "Lcom/tencent/avbiz/IModule$FocusChangeListener;", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSoInited", "isSoLoading", "c", "isAudioFocusSuccess", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listListener", "e", "focusChangeListenerList", "com/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager$c", "f", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager$c;", "audioFocusListener", "<init>", "()V", "g", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanTRTCEnvManager {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy<ZplanTRTCEnvManager> f335294h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isSoInited;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isSoLoading;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isAudioFocusSuccess;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<b> listListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<IModule.FocusChangeListener> focusChangeListenerList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final c audioFocusListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager$a;", "", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.room.impl.trtc.ZplanTRTCEnvManager$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZplanTRTCEnvManager a() {
            return (ZplanTRTCEnvManager) ZplanTRTCEnvManager.f335294h.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager$c", "Lcom/tencent/avbiz/IModule$FocusChangeListener;", "", "onFocusLoss", "onFocusGain", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements IModule.FocusChangeListener {
        c() {
        }

        @Override // com.tencent.avbiz.IModule.FocusChangeListener
        public void onFocusGain() {
            QLog.i("ZplanTRTCLoder", 1, "audio onFocusGain");
            Iterator it = ZplanTRTCEnvManager.this.focusChangeListenerList.iterator();
            while (it.hasNext()) {
                ((IModule.FocusChangeListener) it.next()).onFocusGain();
            }
        }

        @Override // com.tencent.avbiz.IModule.FocusChangeListener
        public void onFocusLoss() {
            QLog.i("ZplanTRTCLoder", 1, "audio onFocusLoss");
            Iterator it = ZplanTRTCEnvManager.this.focusChangeListenerList.iterator();
            while (it.hasNext()) {
                ((IModule.FocusChangeListener) it.next()).onFocusLoss();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager$d", "Lcom/tencent/mobileqq/soload/api/SoLoad$LoadCallback;", "", "succeeded", "", "errMsg", "soPath", "", "onLoad", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements SoLoad.LoadCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f335302a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZplanTRTCEnvManager f335303b;

        d(long j3, ZplanTRTCEnvManager zplanTRTCEnvManager) {
            this.f335302a = j3;
            this.f335303b = zplanTRTCEnvManager;
        }

        @Override // com.tencent.mobileqq.soload.api.SoLoad.LoadCallback
        public void onLoad(boolean succeeded, String errMsg, String soPath) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.i("ZplanTRTCLoder", 1, "load trtc cost " + (currentTimeMillis - this.f335302a) + " res=> " + succeeded + ", " + errMsg + ", " + soPath);
            this.f335303b.isSoLoading.set(false);
            if (!succeeded) {
                Iterator it = this.f335303b.listListener.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a(false, ZplanTRTCError.LOAD_SO_FAILED.convertToErrorMessage());
                }
                this.f335303b.listListener.clear();
                return;
            }
            TXLiveBase.setLibraryPath(soPath);
            QLog.i("ZplanTRTCLoder", 1, "load jni cost -> " + (System.currentTimeMillis() - currentTimeMillis));
            this.f335303b.isSoInited.set(true);
            for (b it5 : this.f335303b.listListener) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                b.a.a(it5, true, null, 2, null);
            }
            this.f335303b.listListener.clear();
        }
    }

    static {
        Lazy<ZplanTRTCEnvManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ZplanTRTCEnvManager>() { // from class: com.tencent.mobileqq.zplan.room.impl.trtc.ZplanTRTCEnvManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZplanTRTCEnvManager invoke() {
                return new ZplanTRTCEnvManager(null);
            }
        });
        f335294h = lazy;
    }

    public /* synthetic */ ZplanTRTCEnvManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String str) {
        QQToast.makeText(MobileQQ.sMobileQQ, 1, "\u8bf7\u9000\u51fa" + str + "\u540e\u91cd\u8bd5~", 1).show();
    }

    public final void h(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!k()) {
            listener.a(false, ZplanTRTCError.REQUEST_AV_FOCUS_FAILED.convertToErrorMessage());
        } else {
            i(listener);
        }
    }

    public final void i(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.isSoInited.get()) {
            QLog.i("ZplanTRTCLoder", 1, "load trtc success before");
            b.a.a(listener, true, null, 2, null);
            return;
        }
        this.listListener.add(listener);
        if (this.isSoLoading.get()) {
            return;
        }
        this.isSoLoading.set(true);
        SoLoad.load("QQ\u5c0f\u7a9d", SoLoadConstants.SONAME_TRTC, new d(System.currentTimeMillis(), this));
    }

    public final void j(IModule.FocusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.focusChangeListenerList.add(listener);
    }

    public final boolean k() {
        if (this.isAudioFocusSuccess.get()) {
            return true;
        }
        IModule moduleByName = AVBizModuleFactory.getModuleByName("QQ\u5c0f\u7a9d");
        final String requestAVFocus = moduleByName.requestAVFocus();
        if (!Intrinsics.areEqual("true", requestAVFocus)) {
            QLog.e("ZplanTRTCLoder", 1, "\u83b7\u53d6\u97f3\u9891\u4e1a\u52a1\u6743\u9650\u5931\u8d25\uff0c\u5360\u7528\u4e1a\u52a1: " + requestAVFocus);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.room.impl.trtc.b
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanTRTCEnvManager.l(requestAVFocus);
                }
            });
            this.isAudioFocusSuccess.set(false);
            return false;
        }
        QLog.i("ZplanTRTCLoder", 1, "\u83b7\u53d6\u97f3\u9891\u4e1a\u52a1\u6743\u9650\u6210\u529f\uff0c");
        moduleByName.setListener(this.audioFocusListener);
        this.isAudioFocusSuccess.set(true);
        return true;
    }

    public final void m(IModule.FocusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.focusChangeListenerList.remove(listener);
    }

    ZplanTRTCEnvManager() {
        this.isSoInited = new AtomicBoolean(false);
        this.isSoLoading = new AtomicBoolean(false);
        this.isAudioFocusSuccess = new AtomicBoolean(false);
        this.listListener = new CopyOnWriteArrayList<>();
        this.focusChangeListenerList = new CopyOnWriteArrayList<>();
        this.audioFocusListener = new c();
    }

    public final void b() {
        QLog.i("ZplanTRTCLoder", 1, "abandonQQAudion Evn");
        AVBizModuleFactory.getModuleByName("QQ\u5c0f\u7a9d").abandonAVFocus();
        AVBizModuleFactory.removeModuleByName("QQ\u5c0f\u7a9d");
        this.isAudioFocusSuccess.set(false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager$b;", "", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(boolean isSuccess, ErrorMessage errorMessage);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        public static final class a {
            public static /* synthetic */ void a(b bVar, boolean z16, ErrorMessage errorMessage, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 2) != 0) {
                        errorMessage = null;
                    }
                    bVar.a(z16, errorMessage);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onComplete");
            }
        }
    }
}
