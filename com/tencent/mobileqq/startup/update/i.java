package com.tencent.mobileqq.startup.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/update/i;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", TencentLocation.RUN_MODE, "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/startup/update/i$a;", "", "", "DEL_SO_TAG", "Ljava/lang/String;", "KEY_DEL_SHARPP_SO", "KEY_PROC_FIRST_LAUNCH", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.update.i$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61756);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4);
        String j3 = AppSetting.j(BaseApplication.getContext());
        if (!sharedPreferences.getBoolean("HasDelSharppSo" + j3, false)) {
            QLog.d("DelSharpp", 1, "start del sharpp, ver:HasDelSharppSo" + j3);
            try {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                String[] strArr = {BaseApplication.getContext().getFilesDir().getParent() + "/txlib/libTcHevcDec.so", BaseApplication.getContext().getApplicationInfo().nativeLibraryDir + "/libTcHevcDec.so", BaseApplication.getContext().getFilesDir().getParent() + "/files/QWallet/.preloaduni/548AE8904CEA12E40CF7331FBA903BCF/libTcHevcDec.so", BaseApplication.getContext().getFilesDir().getParent() + "/files/QWallet/.preloaduni/BD579B6BFA641346A63CB158BA643C3A/libTcHevcDec.so", BaseApplication.getContext().getFilesDir().toString() + "/pddata/prd/early/qq.android.qav.sov8_826", absolutePath + "/Tencent/MobileQQ/pddata/prd/early/qq.android.qav.sov8_826", absolutePath + "/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/pddata/prd/early/qq.android.qav.sov8_826", BaseApplication.getContext().getFilesDir().getParent() + "/txlib/cmshow/libTcHevcDec.so", absolutePath + "/Tencent/MobileQQ/pddata/prd/early/android.qq.apollo.jsc800", absolutePath + "/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/pddata/prd/early/android.qq.apollo.jsc800"};
                for (int i3 = 0; i3 < 10; i3++) {
                    String str = strArr[i3];
                    File file = new File(str);
                    if (file.exists()) {
                        z16 = file.delete();
                        QLog.d("DelSharpp", 1, "exist" + str);
                    } else {
                        QLog.d("DelSharpp", 1, "not exist" + str);
                        z16 = true;
                    }
                    if (!z16) {
                        QLog.d("DelSharpp", 1, " del fail" + str);
                    } else {
                        QLog.d("DelSharpp", 1, " del succ" + str);
                    }
                }
            } catch (Throwable th5) {
                QLog.e("DelSharpp", 1, "Fail to del files." + th5);
            }
            QLog.d("DelSharpp", 1, "end del sharpp");
            sharedPreferences.edit().putBoolean("HasDelSharppSo" + j3, true).commit();
            return;
        }
        QLog.d("DelSharpp", 1, "has del sharpp, ver:HasDelSharppSo" + j3);
    }
}
