package com.tencent.mobileqq.sharepanel.launcher.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/t;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "params", "", "c", "", "action", "", "callbackId", "Leipc/EIPCResult;", "onCall", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class t extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final t f287412d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39129);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f287412d = new t();
        }
    }

    t() {
        super(ISharePanelApi.IPC_MODULE_ID);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(final Bundle params) {
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.s
            @Override // java.lang.Runnable
            public final void run() {
                t.d(params);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Bundle bundle) {
        Activity activity;
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        Context topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            topActivity = BaseApplication.context;
        }
        boolean z16 = topActivity instanceof Activity;
        if (!z16) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.b.b(topActivity, intent, QPublicTransFragmentActivity.class, SharePanelIPCServerFragment.class);
        if (z16) {
            activity = (Activity) topActivity;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        if (params != null) {
            params.setClassLoader(t.class.getClassLoader());
        }
        if (params == null || (str = params.getString("process")) == null) {
            str = "";
        }
        if (params != null) {
            i3 = params.getInt("seq");
        }
        QLog.d("SharePanelIPCServerModule", 1, "onCall action: " + action + " clientProcess: " + str + " clientSeq: " + i3);
        if (Intrinsics.areEqual(action, "showPanel")) {
            c(params);
        } else if (action != null && params != null) {
            SimpleEventBus.getInstance().dispatchEvent(new SharePanelIPCServerEvent(action, params));
        }
        EIPCResult UNKNOW_RESULT = EIPCResult.UNKNOW_RESULT;
        Intrinsics.checkNotNullExpressionValue(UNKNOW_RESULT, "UNKNOW_RESULT");
        return UNKNOW_RESULT;
    }
}
