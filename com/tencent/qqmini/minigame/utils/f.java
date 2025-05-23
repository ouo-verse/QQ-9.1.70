package com.tencent.qqmini.minigame.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\t\u001a\u00020\u0006H\u0003\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqmini/minigame/utils/f;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "", "a", "b", "c", "<init>", "()V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f346838a = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        public static final a f346839d = new a();

        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            QMLog.e("V8OOMHandler", "showV8OOMDialog: exit process by v8 oom.");
            ProcessUtil.killProcess(Process.myPid());
        }
    }

    f() {
    }

    @JvmStatic
    public static final void a(@Nullable Activity activity, @Nullable MiniAppInfo miniAppInfo) {
        QMLog.w("V8OOMHandler", "onReceive v8 oom.");
        if (miniAppInfo != null) {
            MiniGameBeaconReport miniGameBeaconReport = MiniGameBeaconReport.INSTANCE;
            String str = miniAppInfo.appId;
            Intrinsics.checkExpressionValueIsNotNull(str, "miniAppInfo.appId");
            String str2 = miniAppInfo.name;
            Intrinsics.checkExpressionValueIsNotNull(str2, "miniAppInfo.name");
            miniGameBeaconReport.reportV8OOMEvent(str, str2);
        }
        if (ViewUtils.isActivityInvalid(activity)) {
            QMLog.e("V8OOMHandler", "handle: show toast tips, exit process by v8 oom.");
            c();
            return;
        }
        if (activity == null) {
            try {
                Intrinsics.throwNpe();
            } catch (Exception e16) {
                QMLog.e("V8OOMHandler", "handle: showV8OOMDialog failed.", e16);
                c();
                return;
            }
        }
        b(activity);
    }

    @JvmStatic
    private static final void b(Activity activity) {
        MiniCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 0, "\u63d0\u793a", "\u5f53\u524d\u6e38\u620f\u8fd0\u884c\u5185\u5b58\u5df2\u8fbe\u4e0a\u9650\uff0c\u8bf7\u9000\u51fa\u91cd\u8fdb\u3002", (String) null, "\u9000\u51fa", a.f346839d, (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(false);
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.show();
    }

    @JvmStatic
    private static final void c() {
        AppLoaderFactory g16 = AppLoaderFactory.g();
        Intrinsics.checkExpressionValueIsNotNull(g16, "AppLoaderFactory.g()");
        Context context = g16.getContext();
        if (context != null) {
            Toast.makeText(context, "\u5f53\u524d\u6e38\u620f\u8fd0\u884c\u5185\u5b58\u5df2\u8fbe\u4e0a\u9650\uff0c\u8bf7\u9000\u51fa\u91cd\u8fdb\u3002", 1).show();
            ProcessUtil.killProcess(Process.myPid());
        }
    }
}
