package com.tencent.mobileqq.perf.memory.dump;

import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.AppSetting;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/dump/a;", "", "", "withTimeSuffix", "", "i", h.F, "f", "g", "c", "d", "e", "Ljava/text/SimpleDateFormat;", "b", "Ljava/text/SimpleDateFormat;", "()Ljava/text/SimpleDateFormat;", "formatter", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "dumpDir", "k", "zipUuid", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257721a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat formatter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String dumpDir;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String zipUuid;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30248);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        f257721a = new a();
        formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINESE);
        File externalFilesDir = BaseApplication.context.getExternalFilesDir("perf/autoTest/memory");
        Intrinsics.checkNotNull(externalFilesDir);
        String absolutePath = externalFilesDir.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "context.getExternalFiles\u2026_DUMP_DIR)!!.absolutePath");
        dumpDir = absolutePath;
        zipUuid = "memoryTestZip_" + AppSetting.getBuildNum() + ".zip";
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ String j(a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return aVar.i(z16);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return dumpDir;
    }

    @NotNull
    public final SimpleDateFormat b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SimpleDateFormat) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return formatter;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return dumpDir + File.separator + "hprof_" + formatter.format(new Date()) + ".hprof";
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return dumpDir + File.separator + "info_" + formatter.format(new Date());
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return dumpDir + File.separator + "class_load";
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return dumpDir + File.separator + "native_" + formatter.format(new Date()) + Sticker.JSON_SUFFIX;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return dumpDir + File.separator + "smaps_" + formatter.format(new Date());
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "/proc/" + Process.myPid() + "/smaps";
    }

    @NotNull
    public final String i(boolean withTimeSuffix) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, withTimeSuffix);
        }
        if (withTimeSuffix) {
            str = "memoryTestZip_" + formatter.format(new Date()) + ".zip";
        } else {
            str = "memoryTestZip_" + AppSetting.getBuildNum() + ".zip";
        }
        StringBuilder sb5 = new StringBuilder();
        String parent = new File(dumpDir).getParent();
        Intrinsics.checkNotNull(parent);
        sb5.append(parent);
        sb5.append(File.separator);
        sb5.append(str);
        return sb5.toString();
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return zipUuid;
    }
}
