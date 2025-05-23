package com.tencent.gdtad.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0016\u0010!\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/gdtad/downloader/AdAppInstallerReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "f", tl.h.F, "k", "Landroid/content/Intent;", "intent", "onReceive", "Lcom/tencent/ad/tangram/util/AdClickUtil$Params;", "params", "Lcom/tencent/ad/tangram/util/AdClickUtil$Result;", "result", "e", "", "b", "Z", "mIsRegistered", "Ljava/lang/ref/WeakReference;", "c", "Ljava/lang/ref/WeakReference;", "mContext", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "mBackGroundRunnable", "mIsForeground", "Landroid/content/BroadcastReceiver;", "mBroadcastReceiver", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class AdAppInstallerReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mIsRegistered;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<Context> mContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Runnable mBackGroundRunnable;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AdAppInstallerReceiver f109163a = new AdAppInstallerReceiver();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsForeground = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.gdtad.downloader.AdAppInstallerReceiver$mBroadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String str;
            String str2 = null;
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                if (intent != null) {
                    str2 = intent.getAction();
                }
                if (Intrinsics.areEqual(str2, GuardManager.ACTION_PLUGIN_STATE_CHANGE)) {
                    int intExtra = intent.getIntExtra(GuardManager.KEY_PLUGIN_STATE, 0);
                    if (intExtra == 0) {
                        AdAppInstallerReceiver.f109163a.f();
                    } else if (intExtra == 1) {
                        AdAppInstallerReceiver.f109163a.g();
                    }
                }
            }
        }
    };

    static {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(GuardManager.ACTION_PLUGIN_STATE_CHANGE);
        try {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                mobileQQ.registerReceiver(mBroadcastReceiver, intentFilter);
            }
        } catch (Throwable th5) {
            QLog.e("AdAppInstallerReceiver", 1, "state change register, error" + th5);
        }
    }

    AdAppInstallerReceiver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        mIsForeground = false;
        mBackGroundRunnable = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gdtad.downloader.AdAppInstallerReceiver$onBackground$1
            @Override // java.lang.Runnable
            public void run() {
                AdAppInstallerReceiver.f109163a.k();
            }
        }, 16, null, false, d.f109172a.d() * 60 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        mIsForeground = true;
        Runnable runnable = mBackGroundRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        d dVar = d.f109172a;
        if (dVar.g()) {
            return;
        }
        dVar.c();
        h(MobileQQ.sMobileQQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(WeakReference weakContext) {
        Intrinsics.checkNotNullParameter(weakContext, "$weakContext");
        f109163a.j((Context) weakContext.get());
    }

    private final void j(Context context) {
        if (context != null && !mIsRegistered) {
            synchronized (this) {
                if (mIsRegistered) {
                    return;
                }
                mIsRegistered = true;
                Unit unit = Unit.INSTANCE;
                QLog.i("AdAppInstallerReceiver", 1, "registerImpl");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                try {
                    context.registerReceiver(this, intentFilter);
                } catch (Throwable th5) {
                    QLog.e("AdAppInstallerReceiver", 1, "registerImpl, error" + th5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(WeakReference weakContext) {
        Intrinsics.checkNotNullParameter(weakContext, "$weakContext");
        f109163a.m((Context) weakContext.get());
    }

    private final void m(Context context) {
        if (context != null && mIsRegistered) {
            synchronized (this) {
                if (!mIsRegistered) {
                    return;
                }
                mIsRegistered = false;
                Unit unit = Unit.INSTANCE;
                QLog.i("AdAppInstallerReceiver", 1, "unregisterImpl");
                try {
                    context.unregisterReceiver(this);
                } catch (Throwable th5) {
                    QLog.e("AdAppInstallerReceiver", 1, "unregisterImpl , error" + th5);
                }
            }
        }
    }

    public final void e(@Nullable AdClickUtil.Params params, @Nullable AdClickUtil.Result result) {
        d.f109172a.b(params, result);
    }

    public final void h(@Nullable Context context) {
        if (context != null && !mIsRegistered && mIsForeground) {
            WeakReference<Context> weakReference = new WeakReference<>(context.getApplicationContext());
            mContext = weakReference;
            Context context2 = weakReference.get();
            if (context2 != null) {
                final WeakReference weakReference2 = new WeakReference(context2);
                AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.downloader.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdAppInstallerReceiver.i(weakReference2);
                    }
                }, 3);
            }
        }
    }

    public final void k() {
        WeakReference<Context> weakReference;
        Context context;
        if (mIsRegistered && (weakReference = mContext) != null && (context = weakReference.get()) != null) {
            final WeakReference weakReference2 = new WeakReference(context);
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.downloader.f
                @Override // java.lang.Runnable
                public final void run() {
                    AdAppInstallerReceiver.l(weakReference2);
                }
            }, 3);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        if (context != null && intent != null && TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED") && intent.getData() != null) {
            Uri data = intent.getData();
            String str2 = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Uri data2 = intent.getData();
                if (data2 != null) {
                    str2 = data2.getSchemeSpecificPart();
                }
                if (str2 == null) {
                    str2 = "";
                }
                ((IGdtAPI) QRoute.api(IGdtAPI.class)).notifyInstallSuccess(str2);
                if (d.f109172a.g()) {
                    k();
                    return;
                }
                return;
            }
        }
        QLog.i("AdAppInstallerReceiver", 1, "onReceivePackageAdded error");
    }
}
