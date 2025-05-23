package com.tencent.mobileqq.qqlive.widget.verify;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.business.QQLiveConfigConst;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ&\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/verify/l;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqlive/config/b;", "liveConfig", "", "uin", "", "e", "Lcom/tencent/mobileqq/qqlive/widget/verify/g;", "callback", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "code", "msg", "g", "Landroid/os/Bundle;", "bundle", tl.h.F, "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "callbackHolder", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f274086a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<g> callbackHolder;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38215);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f274086a = new l();
        }
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(Context context, final com.tencent.mobileqq.qqlive.config.b liveConfig, final String uin) {
        Bundle bundle = new Bundle();
        bundle.putInt("fragmentStyle", 7);
        bundle.putString("extra_web_verify_app_id", liveConfig.c());
        com.tencent.qqlive.common.webview.a.g(context, QQLiveConfigConst.KAIYANG_VERIFY_URL, bundle, QQBrowserActivity.class, new int[]{536870912, 67108864}, null, liveConfig.c());
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.verify.h
            @Override // java.lang.Runnable
            public final void run() {
                l.f(com.tencent.mobileqq.qqlive.config.b.this, uin);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(com.tencent.mobileqq.qqlive.config.b liveConfig, String uin) {
        Intrinsics.checkNotNullParameter(liveConfig, "$liveConfig");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        new d(liveConfig.c(), uin).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Context context, com.tencent.mobileqq.qqlive.config.b liveConfig, String uin, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(liveConfig, "$liveConfig");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        dialogInterface.dismiss();
        f274086a.e(context, liveConfig, uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DialogInterface dialogInterface, int i3) {
        g gVar;
        dialogInterface.dismiss();
        WeakReference<g> weakReference = callbackHolder;
        if (weakReference != null && (gVar = weakReference.get()) != null) {
            gVar.a(999, "\u53d6\u6d88\u8ba4\u8bc1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialogInterface) {
        g gVar;
        WeakReference<g> weakReference = callbackHolder;
        if (weakReference != null && (gVar = weakReference.get()) != null) {
            gVar.a(999, "\u53d6\u6d88\u8ba4\u8bc1");
        }
    }

    public final void g(int code, @NotNull String msg2) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, code, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        WeakReference<g> weakReference = callbackHolder;
        if (weakReference != null) {
            gVar = weakReference.get();
        } else {
            gVar = null;
        }
        if (gVar == null) {
            QIPCClientHelper qIPCClientHelper = QIPCClientHelper.getInstance();
            Bundle bundle = new Bundle();
            bundle.putInt("code", code);
            bundle.putString("msg", msg2);
            Unit unit = Unit.INSTANCE;
            qIPCClientHelper.callServer("QQLiveServerQIPCModule", QQLiveIPCConstants.Action.ACTION_QQLIVE_VERIFY_CALLBACK, bundle);
            return;
        }
        gVar.a(code, msg2);
    }

    public final void h(@Nullable Bundle bundle) {
        g gVar;
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        WeakReference<g> weakReference = callbackHolder;
        if (weakReference != null && (gVar = weakReference.get()) != null) {
            if (bundle != null) {
                i3 = bundle.getInt("code");
            } else {
                i3 = -1;
            }
            if (bundle == null || (str = bundle.getString("msg")) == null) {
                str = "";
            }
            gVar.a(i3, str);
        }
    }

    public final void i(@NotNull final Context context, @NotNull final com.tencent.mobileqq.qqlive.config.b liveConfig, @NotNull final String uin, @NotNull g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, liveConfig, uin, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(liveConfig, "liveConfig");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callbackHolder = new WeakReference<>(callback);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, "\u5b8c\u6210\u5b9e\u540d\u8ba4\u8bc1\u4e4b\u540e\u624d\u53ef\u4ee5\u8fdb\u884c\u76f4\u64ad", "\u53d6\u6d88", "\u53bb\u8ba4\u8bc1", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.verify.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                l.j(context, liveConfig, uin, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.verify.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                l.k(dialogInterface, i3);
            }
        });
        createCustomDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.qqlive.widget.verify.k
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                l.l(dialogInterface);
            }
        });
        createCustomDialog.show();
    }

    public final void m(@NotNull Context context, @NotNull com.tencent.mobileqq.qqlive.config.b liveConfig, @NotNull String uin, @NotNull g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, liveConfig, uin, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(liveConfig, "liveConfig");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callbackHolder = new WeakReference<>(callback);
        e(context, liveConfig, uin);
    }
}
