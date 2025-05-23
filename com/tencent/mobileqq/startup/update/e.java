package com.tencent.mobileqq.startup.update;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/startup/update/e;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/content/Context;", "context", "", "a", TencentLocation.RUN_MODE, "<init>", "()V", "d", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/startup/update/e$a;", "", "", "KEY_NAME", "Ljava/lang/String;", "SP_NAME", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.update.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61741);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(Context context) {
        QLog.d("PatchLogTag", 1, "UpdatePatchConfig clearPatchConfig start.");
        try {
            context.getSharedPreferences(PatchSharedPreUtil.SHARED_PREFERENCE_HOTPATCH, 4).edit().clear().commit();
            FileUtils.deleteFile(new File(PatchCommonUtil.getPatchPath("")));
            context.getSharedPreferences(MsfCmdConfig.SP_SAFEMODE_NOT_EXIT, 4).edit().clear().commit();
            context.getSharedPreferences("QQDetectAttack", 0).edit().clear().commit();
        } catch (Throwable th5) {
            QLog.d("PatchLogTag", 1, "UpdatePatchConfig clearPatchConfig exception=" + th5);
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = BaseApplicationImpl.sApplication.getApplicationContext();
        SharedPreferences sharedPreferences = context2.getSharedPreferences("sp_update_version", 0);
        String string = sharedPreferences.getString("key_cur_version", "");
        String str = com.tencent.mobileqq.cooperation.a.c(context2) + "." + com.tencent.mobileqq.cooperation.a.a(context2);
        QLog.d("PatchLogTag", 1, "UpdatePatchConfig oldVersion=" + string + ", curVersion=" + str);
        if (!Intrinsics.areEqual(str, string)) {
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            a(context2);
            sharedPreferences.edit().putString("key_cur_version", str).commit();
        }
    }
}
