package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.DangerousPersonToastUtils;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.launch.MiniAppCmdServlet;
import com.tencent.mobileqq.mini.launch.MiniAppMainServiceApiManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.minigame.api.OnShareListenerForMiniBox;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ShareQQArkHelper {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a extends CmdCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MiniArkShareModel f347551d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f347552e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MiniProgramShareUtils.OnShareListener f347553f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QQProgressDialog f347554h;

        a(MiniArkShareModel miniArkShareModel, Activity activity, MiniProgramShareUtils.OnShareListener onShareListener, QQProgressDialog qQProgressDialog) {
            this.f347551d = miniArkShareModel;
            this.f347552e = activity;
            this.f347553f = onShareListener;
            this.f347554h = qQProgressDialog;
        }

        @Override // com.tencent.mobileqq.mini.launch.CmdCallback
        public void onCmdResult(boolean z16, Bundle bundle) throws RemoteException {
            QLog.i("ShareQQArkHelper", 1, "other process cmd callback: " + z16);
            if (z16) {
                this.f347551d.setPicUrl(bundle.getString("imageUrl"));
                ShareQQArkHelper.p(this.f347552e, this.f347551d, this.f347553f);
                ShareQQArkHelper.i(this.f347554h);
                return;
            }
            QLog.e("ShareQQArkHelper", 1, "dealWithShareImage error!");
            ShareQQArkHelper.i(this.f347554h);
            DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
            MiniProgramShareUtils.OnShareListener onShareListener = this.f347553f;
            if (onShareListener != null) {
                onShareListener.onShared(false, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c extends CmdCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MiniArkShareModel f347559d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ OnShareListenerForMiniBox f347560e;

        c(MiniArkShareModel miniArkShareModel, OnShareListenerForMiniBox onShareListenerForMiniBox) {
            this.f347559d = miniArkShareModel;
            this.f347560e = onShareListenerForMiniBox;
        }

        @Override // com.tencent.mobileqq.mini.launch.CmdCallback
        public void onCmdResult(boolean z16, Bundle bundle) throws RemoteException {
            QLog.i("ShareQQArkHelper", 1, "other process cmd callback: " + z16);
            if (z16) {
                this.f347559d.setPicUrl(bundle.getString("imageUrl"));
                ShareQQArkHelper.n(this.f347559d, this.f347560e);
            } else {
                QLog.e("ShareQQArkHelper", 1, "dealWithShareImage error!");
                DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
                OnShareListenerForMiniBox onShareListenerForMiniBox = this.f347560e;
                if (onShareListenerForMiniBox != null) {
                    onShareListenerForMiniBox.onShared(false, false);
                }
            }
        }
    }

    private static String g(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        FileUtils.deleteFilesInDirectory(str2);
        String substring = str.substring(str.lastIndexOf(File.separator));
        if (!FileUtils.copyFile(file, new File(str2 + substring), true)) {
            return null;
        }
        return str2 + substring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Activity activity, QQProgressDialog qQProgressDialog, MiniArkShareModel miniArkShareModel, MiniProgramShareUtils.OnShareListener onShareListener) {
        String str;
        String picUrl = miniArkShareModel.getPicUrl();
        boolean z16 = URLUtil.isHttpsUrl(picUrl) || URLUtil.isHttpUrl(picUrl);
        if (!z16) {
            picUrl = g(miniArkShareModel.getPicUrl(), activity.getApplication().getFilesDir().getPath() + "/mini_app/image");
            if (TextUtils.isEmpty(picUrl)) {
                i(qQProgressDialog);
                DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
                if (onShareListener != null) {
                    onShareListener.onShared(false, false);
                }
                QLog.e("ShareQQArkHelper", 1, "dealWithShareImage copy image failed!");
                return;
            }
        }
        a aVar = new a(miniArkShareModel, activity, onShareListener, qQProgressDialog);
        if (MobileQQ.sProcessId == 1) {
            MiniArkShareAsyncManager.performChangeArkShareImageUrl(picUrl, aVar);
            return;
        }
        QLog.i("ShareQQArkHelper", 1, "other process request");
        if (z16) {
            str = MiniAppCmdServlet.CMD_CHANGE_ARK_SHARE_URL;
        } else {
            str = "cmd_upload_ark_share_image";
        }
        Bundle bundle = new Bundle();
        bundle.putString(MiniAppCmdServlet.KEY_URI, picUrl);
        MiniAppMainServiceApiManager.INSTANCE.sendCmd(str, bundle, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(final QQProgressDialog qQProgressDialog) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShareQQArkHelper.6
            @Override // java.lang.Runnable
            public void run() {
                QQProgressDialog qQProgressDialog2 = QQProgressDialog.this;
                if (qQProgressDialog2 != null) {
                    qQProgressDialog2.dismiss();
                }
            }
        });
    }

    private static int j(MiniArkShareModel miniArkShareModel) {
        int i3 = (StringUtil.isEmpty(miniArkShareModel.getTemplateId()) || StringUtil.isEmpty(miniArkShareModel.getTemplateData())) ? 0 : 2;
        if (TextUtils.isEmpty(miniArkShareModel.getRcvOpenId())) {
            return i3;
        }
        return 5;
    }

    public static boolean l(Activity activity, MiniArkShareModel miniArkShareModel, JSONObject jSONObject, int i3) {
        boolean performShareAsArkMessage = MiniProgramShareUtils.performShareAsArkMessage(activity, MiniProgramShareUtils.getArkPrompt(activity, miniArkShareModel, jSONObject), miniArkShareModel, jSONObject, i3);
        if (performShareAsArkMessage) {
            QLog.d("ShareQQArkHelper", 1, "onCmdListener: share successful " + com.tencent.util.k.f(jSONObject, Arrays.asList("desc", "title", "nick")));
        }
        return performShareAsArkMessage;
    }

    public static void m(Context context, MiniArkShareModel miniArkShareModel, OnShareListenerForMiniBox onShareListenerForMiniBox) {
        String str;
        String picUrl = miniArkShareModel.getPicUrl();
        boolean z16 = URLUtil.isHttpsUrl(picUrl) || URLUtil.isHttpUrl(picUrl);
        if (!z16) {
            picUrl = g(miniArkShareModel.getPicUrl(), context.getFilesDir().getPath() + "/mini_app/image");
            if (TextUtils.isEmpty(picUrl)) {
                DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
                if (onShareListenerForMiniBox != null) {
                    onShareListenerForMiniBox.onShared(false, false);
                }
                QLog.e("ShareQQArkHelper", 1, "dealWithShareImage copy image failed!");
                return;
            }
        }
        c cVar = new c(miniArkShareModel, onShareListenerForMiniBox);
        if (MobileQQ.sProcessId == 1) {
            MiniArkShareAsyncManager.performChangeArkShareImageUrl(picUrl, cVar);
            return;
        }
        QLog.i("ShareQQArkHelper", 1, "other process request");
        if (z16) {
            str = MiniAppCmdServlet.CMD_CHANGE_ARK_SHARE_URL;
        } else {
            str = "cmd_upload_ark_share_image";
        }
        Bundle bundle = new Bundle();
        bundle.putString(MiniAppCmdServlet.KEY_URI, picUrl);
        MiniAppMainServiceApiManager.INSTANCE.sendCmd(str, bundle, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(MiniArkShareModel miniArkShareModel, OnShareListenerForMiniBox onShareListenerForMiniBox) {
        int j3 = j(miniArkShareModel);
        MiniAppCmdUtil.getInstance().getShareInfo(MiniProgramShareUtils.newShareInfoRequest(miniArkShareModel, (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), j3), new d(j3, onShareListenerForMiniBox, miniArkShareModel));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(final Activity activity, final MiniArkShareModel miniArkShareModel, final MiniProgramShareUtils.OnShareListener onShareListener) {
        if (k(activity)) {
            QLog.e("ShareQQArkHelper", 1, "[realStartShare] activity is invalid");
            DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, -1000710003L, HardCodeUtil.qqStr(R.string.hix), 0);
            if (onShareListener != null) {
                onShareListener.onShared(false, false);
                return;
            }
            return;
        }
        final QQProgressDialog r16 = r(activity);
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShareQQArkHelper.2
            @Override // java.lang.Runnable
            public void run() {
                ShareQQArkHelper.h(activity, r16, miniArkShareModel, onShareListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(Activity activity, MiniArkShareModel miniArkShareModel, MiniProgramShareUtils.OnShareListener onShareListener) {
        int j3 = j(miniArkShareModel);
        MiniAppCmdUtil.getInstance().getShareInfo(MiniProgramShareUtils.newShareInfoRequest(miniArkShareModel, (int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), j3), new b(j3, onShareListener, miniArkShareModel, activity));
    }

    private static QQProgressDialog r(Activity activity) {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        qQProgressDialog.setMessage(R.string.pe_);
        qQProgressDialog.show();
        return qQProgressDialog;
    }

    public static void s(final Activity activity, final MiniArkShareModel miniArkShareModel, final MiniProgramShareUtils.OnShareListener onShareListener) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            o(activity, miniArkShareModel, onShareListener);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShareQQArkHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    ShareQQArkHelper.o(activity, miniArkShareModel, onShareListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(final Context context, final boolean z16, JSONObject jSONObject, final MiniProgramShareUtils.OnShareListener onShareListener) {
        long j3;
        String str;
        boolean z17;
        if (jSONObject != null) {
            j3 = jSONObject.optLong("retCode");
            str = jSONObject.optString("errMsg");
            z17 = jSONObject.optBoolean("needShareCallBack");
        } else {
            j3 = -1;
            str = null;
            z17 = false;
        }
        final long j16 = j3;
        final String str2 = str;
        final Boolean valueOf = Boolean.valueOf(z17);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ShareQQArkHelper.5
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramShareUtils.OnShareListener onShareListener2;
                if (!z16 && (onShareListener2 = onShareListener) != null) {
                    onShareListener2.onShared(valueOf.booleanValue(), false);
                }
                long j17 = j16;
                if (j17 != -100070004) {
                    if (j17 == -100070016) {
                        DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, j17, str2, 0);
                        return;
                    } else {
                        DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, j17, HardCodeUtil.qqStr(R.string.hix), 0);
                        return;
                    }
                }
                MiniProgramShareUtils.OnShareListener onShareListener3 = onShareListener;
                if (onShareListener3 != null) {
                    onShareListener3.onShared(valueOf.booleanValue(), false);
                }
                Context context2 = context;
                if (context2 instanceof Activity) {
                    DialogUtil.createCustomDialog(context2, 233, context2.getString(R.string.hix), str2, new a(), null).show();
                } else {
                    DangerousPersonToastUtils.shareErrorToast(MobileQQ.sMobileQQ, j16, context2.getString(R.string.hix), 0);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.qqmini.proxyimpl.ShareQQArkHelper$5$a */
            /* loaded from: classes34.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class b implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f347555a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniProgramShareUtils.OnShareListener f347556b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MiniArkShareModel f347557c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f347558d;

        b(int i3, MiniProgramShareUtils.OnShareListener onShareListener, MiniArkShareModel miniArkShareModel, Activity activity) {
            this.f347555a = i3;
            this.f347556b = onShareListener;
            this.f347557c = miniArkShareModel;
            this.f347558d = activity;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            ShareState shareState;
            if (z16 && jSONObject != null) {
                if (this.f347555a == 5) {
                    BaseRuntime currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
                    if (currentRuntime == null || (shareState = currentRuntime.getShareState()) == null) {
                        return;
                    } else {
                        shareState.shareJson = jSONObject.toString();
                    }
                }
                MiniProgramShareUtils.OnShareListener onShareListener = this.f347556b;
                if (onShareListener instanceof OnShareListenerForMiniBox) {
                    ((OnShareListenerForMiniBox) onShareListener).onSharePrepared(this.f347557c, jSONObject, this.f347555a);
                    return;
                }
                boolean l3 = ShareQQArkHelper.l(this.f347558d, this.f347557c, jSONObject, this.f347555a);
                MiniProgramShareUtils.OnShareListener onShareListener2 = this.f347556b;
                if (onShareListener2 != null) {
                    onShareListener2.onShared(false, l3);
                    return;
                }
                return;
            }
            QLog.e("ShareQQArkHelper", 1, "onCmdListener: share failed " + z16 + " " + jSONObject);
            ShareQQArkHelper.q(this.f347558d, z16, jSONObject, this.f347556b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class d implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f347561a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OnShareListenerForMiniBox f347562b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MiniArkShareModel f347563c;

        d(int i3, OnShareListenerForMiniBox onShareListenerForMiniBox, MiniArkShareModel miniArkShareModel) {
            this.f347561a = i3;
            this.f347562b = onShareListenerForMiniBox;
            this.f347563c = miniArkShareModel;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            ShareState shareState;
            if (z16 && jSONObject != null) {
                if (this.f347561a == 5) {
                    BaseRuntime currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
                    if (currentRuntime == null || (shareState = currentRuntime.getShareState()) == null) {
                        return;
                    } else {
                        shareState.shareJson = jSONObject.toString();
                    }
                }
                OnShareListenerForMiniBox onShareListenerForMiniBox = this.f347562b;
                if (onShareListenerForMiniBox != null) {
                    onShareListenerForMiniBox.onSharePrepared(this.f347563c, jSONObject, this.f347561a);
                    return;
                }
                return;
            }
            QLog.e("ShareQQArkHelper", 1, "onCmdListener: share failed " + z16 + " " + jSONObject);
            ShareQQArkHelper.q(BaseApplicationImpl.getApplication(), z16, jSONObject, this.f347562b);
        }
    }

    public static boolean k(Activity activity) {
        if (activity == null || activity.isDestroyed()) {
            return true;
        }
        return activity.isFinishing();
    }
}
