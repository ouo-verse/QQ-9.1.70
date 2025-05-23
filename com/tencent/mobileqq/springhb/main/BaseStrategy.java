package com.tencent.mobileqq.springhb.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vaswebviewplugin.SpringHbJsPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\u0012\u001a\u00020\u0002H\u0004R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\u00020\u001f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b\u001a\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/BaseStrategy;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "e", "j", "i", "k", tl.h.F, "", NodeProps.VISIBLE, "showWebViewBg", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", DomainData.DOMAIN_NAME, "o", "l", "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "a", "Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "d", "()Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;", "viewModel", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "c", "()Landroid/os/Handler;", "mHandler", "", "J", "()J", "loadingTimeOut", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mReceiverRegistered", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mReceiver", "<init>", "(Lcom/tencent/mobileqq/springhb/main/BrowserViewModel;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class BaseStrategy {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BrowserViewModel viewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long loadingTimeOut;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean mReceiverRegistered;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BroadcastReceiver mReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/BaseStrategy$a;", "", "", "ACTION_HIDE_LOADING_VIDEO", "I", "", "MAX_LOADING_VIDEO_PLAY_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.main.BaseStrategy$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60727);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BaseStrategy(@NotNull BrowserViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewModel);
            return;
        }
        this.viewModel = viewModel;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.loadingTimeOut = 5000L;
        this.mReceiverRegistered = new AtomicBoolean(false);
        this.mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.springhb.main.BaseStrategy$mReceiver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseStrategy.this);
                }
            }

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
                if (action != null) {
                    int hashCode = action.hashCode();
                    if (hashCode != -1980698389) {
                        if (hashCode != -1328330049) {
                            if (hashCode == 1656959638 && action.equals(SpringHbJsPlugin.ACTION_SPRING_NOTIFY_READY)) {
                                BaseStrategy.this.e();
                            }
                        } else if (action.equals(SpringHbJsPlugin.ACTION_SPRING_GAME_READY)) {
                            BaseStrategy.this.e();
                        }
                    } else if (action.equals(SpringHbJsPlugin.ACTION_SPRING_CLOSE_VIDEO)) {
                        BaseStrategy.this.e();
                    }
                }
                QLog.i("DefaultStrategy", 2, "onReceive: action:" + intent.getAction());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BaseStrategy this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        QLog.i("DefaultStrategy", 2, "onInitTimeOut");
    }

    private final void m() {
        if (this.mReceiverRegistered.compareAndSet(true, false)) {
            MobileQQ.sMobileQQ.unregisterReceiver(this.mReceiver);
            QLog.i("DefaultStrategy", 2, "removeBroadcast");
        }
    }

    public static /* synthetic */ void s(BaseStrategy baseStrategy, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z17 = false;
            }
            baseStrategy.r(z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWebViewVisible");
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.loadingTimeOut;
    }

    @NotNull
    public final Handler c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Handler) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mHandler;
    }

    @NotNull
    public final BrowserViewModel d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BrowserViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.viewModel;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("DefaultStrategy", 2, "h5NotifyLoadFinished...time:" + System.currentTimeMillis());
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            l();
            this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.springhb.main.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseStrategy.g(BaseStrategy.this);
                }
            }, b());
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            q(false);
            m();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            QLog.d("DefaultStrategy", 2, "onPageFinished");
            s(this, true, false, 2, null);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            QLog.d("DefaultStrategy", 2, "onPageStart");
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            QLog.d("DefaultStrategy", 2, "onVideoPlayFinish");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (this.mReceiverRegistered.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(SpringHbJsPlugin.ACTION_SPRING_CLOSE_VIDEO);
            intentFilter.addAction(SpringHbJsPlugin.ACTION_SPRING_GAME_READY);
            intentFilter.addAction(SpringHbJsPlugin.ACTION_SPRING_NOTIFY_READY);
            MobileQQ.sMobileQQ.registerReceiver(this.mReceiver, intentFilter);
            QLog.i("DefaultStrategy", 2, "registerBroadcast");
        }
    }

    public final void n(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, visible);
        } else {
            this.viewModel.d2(visible);
        }
    }

    public final void o(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, visible);
        } else {
            this.viewModel.e2(visible);
        }
    }

    public final void p(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, visible);
        } else {
            this.viewModel.f2(visible);
        }
    }

    public final void q(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, visible);
        } else {
            this.viewModel.h2(visible);
        }
    }

    public final void r(boolean visible, boolean showWebViewBg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(visible), Boolean.valueOf(showWebViewBg));
        } else {
            this.viewModel.j2(visible, showWebViewBg);
        }
    }
}
