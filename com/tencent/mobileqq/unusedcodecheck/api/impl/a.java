package com.tencent.mobileqq.unusedcodecheck.api.impl;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unusedcodecheck.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProcessUtil;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J7\u0010\u0016\u001a\u00028\u0000\"\b\b\u0000\u0010\u0012*\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\u001c\u0010\u001b\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0018H\u0016J\u0006\u0010\u001d\u001a\u00020\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/api/impl/a;", "Lcom/tencent/mobileqq/unusedcodecheck/g;", "", "tag", "msg", "", "c", "e", "", ReportConstant.COSTREPORT_TRANS, tl.h.F, "Landroid/content/Context;", "getContext", "b", "key", "Landroid/os/Parcelable;", "value", "d", "T", "Ljava/lang/Class;", "clazz", RemoteHandleConst.PARAM_DEFAULT_VALUE, "g", "(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Parcelable;)Landroid/os/Parcelable;", "", "params", "i", "f", "", "j", "<init>", "()V", "a", "unusedcode_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements com.tencent.mobileqq.unusedcodecheck.g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/api/impl/a$a;", "", "", "IPC_ACTION_ANALYSIS", "Ljava/lang/String;", "IPC_ACTION_ANALYSIS_CHECK_INIT", "IPC_MODULE_NAME", "REPORT_COVERAGE_KEY_EVENT_NAME", "REPORT_KEY_EVENT_NAME", "<init>", "()V", "unusedcode_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.unusedcodecheck.api.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return g.a.a(this);
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    @Nullable
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return ProcessUtil.getCurrentProcessName(getContext());
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    public void c(@NotNull String tag, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(tag, 2, msg2);
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    public void d(@NotNull String key, @NotNull Parcelable value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) key, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        MMKVOptionEntity from = QMMKV.from(getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_COMMON)");
        from.encodeParcelable(key, value);
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    public void e(@NotNull String tag, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i(tag, 1, msg2);
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    public void f(@NotNull Map<String, String> params) {
        String str;
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (j() && new Random().nextInt(100) < 1) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            QQBeaconReport.report(str, "UnusedCodeCheckCoverageReport", params);
        }
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    @NotNull
    public <T extends Parcelable> T g(@NotNull String key, @NotNull Class<T> clazz, @NotNull T defaultValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, this, key, clazz, defaultValue);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        MMKVOptionEntity from = QMMKV.from(getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_COMMON)");
        T t16 = (T) from.decodeParcelable(key, clazz, defaultValue);
        Intrinsics.checkNotNullExpressionValue(t16, "entity.decodeParcelable(key, clazz, defaultValue)");
        return t16;
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    @NotNull
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        return context;
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    public void h(@NotNull String tag, @NotNull String msg2, @NotNull Throwable tr5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, tag, msg2, tr5);
            return;
        }
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(tr5, "tr");
        QLog.e(tag, 1, msg2, tr5);
    }

    @Override // com.tencent.mobileqq.unusedcodecheck.g
    public void i(@NotNull Map<String, String> params) {
        String str;
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (j()) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            QQBeaconReport.report(str, "UnusedCodeCheckReport", params);
        }
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }
}
