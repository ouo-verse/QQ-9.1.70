package com.tencent.cache.api.memory;

import NS_COMM.COMM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/cache/api/memory/MemoryFlag;", "", "flag", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, "", "isGraphic", "", "(Ljava/lang/String;IILjava/lang/String;Z)V", "getFlag", "()I", "()Z", "getReportKey", "()Ljava/lang/String;", "OTHER_DALVIK_OTHER", "OTHER_GFX_DEV", "OTHER_SO", "OTHER_JAR", "OTHER_APK", "OTHER_TTF", "OTHER_DEX", "OTHER_OAT", "OTHER_ART", "EGL", "GL_M_TRACK", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class MemoryFlag {
    private static final /* synthetic */ MemoryFlag[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MemoryFlag EGL;
    public static final MemoryFlag GL_M_TRACK;
    public static final MemoryFlag OTHER_APK;
    public static final MemoryFlag OTHER_ART;
    public static final MemoryFlag OTHER_DALVIK_OTHER;
    public static final MemoryFlag OTHER_DEX;
    public static final MemoryFlag OTHER_GFX_DEV;
    public static final MemoryFlag OTHER_JAR;
    public static final MemoryFlag OTHER_OAT;
    public static final MemoryFlag OTHER_SO;
    public static final MemoryFlag OTHER_TTF;
    private final int flag;
    private final boolean isGraphic;

    @NotNull
    private final String reportKey;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(COMM.security_bypass);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        MemoryFlag memoryFlag = new MemoryFlag("OTHER_DALVIK_OTHER", 0, 0, "dalvikOther", false, 4, null);
        OTHER_DALVIK_OTHER = memoryFlag;
        MemoryFlag memoryFlag2 = new MemoryFlag("OTHER_GFX_DEV", 1, 4, "GfxDev", true);
        OTHER_GFX_DEV = memoryFlag2;
        MemoryFlag memoryFlag3 = new MemoryFlag("OTHER_SO", 2, 6, "soMmap", false, 4, null);
        OTHER_SO = memoryFlag3;
        boolean z16 = false;
        int i3 = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        MemoryFlag memoryFlag4 = new MemoryFlag("OTHER_JAR", 3, 7, "jarMmap", z16, i3, defaultConstructorMarker);
        OTHER_JAR = memoryFlag4;
        MemoryFlag memoryFlag5 = new MemoryFlag("OTHER_APK", 4, 8, "apkMmap", z16, i3, defaultConstructorMarker);
        OTHER_APK = memoryFlag5;
        MemoryFlag memoryFlag6 = new MemoryFlag("OTHER_TTF", 5, 9, "ttfMmap", z16, i3, defaultConstructorMarker);
        OTHER_TTF = memoryFlag6;
        MemoryFlag memoryFlag7 = new MemoryFlag("OTHER_DEX", 6, 10, "dexMmap", z16, i3, defaultConstructorMarker);
        OTHER_DEX = memoryFlag7;
        MemoryFlag memoryFlag8 = new MemoryFlag("OTHER_OAT", 7, 11, "oatMmap", z16, i3, defaultConstructorMarker);
        OTHER_OAT = memoryFlag8;
        MemoryFlag memoryFlag9 = new MemoryFlag("OTHER_ART", 8, 12, "artMmap", z16, i3, defaultConstructorMarker);
        OTHER_ART = memoryFlag9;
        MemoryFlag memoryFlag10 = new MemoryFlag("EGL", 9, 14, "egl", true);
        EGL = memoryFlag10;
        MemoryFlag memoryFlag11 = new MemoryFlag("GL_M_TRACK", 10, 15, "glMTrack", true);
        GL_M_TRACK = memoryFlag11;
        $VALUES = new MemoryFlag[]{memoryFlag, memoryFlag2, memoryFlag3, memoryFlag4, memoryFlag5, memoryFlag6, memoryFlag7, memoryFlag8, memoryFlag9, memoryFlag10, memoryFlag11};
    }

    MemoryFlag(String str, int i3, int i16, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Boolean.valueOf(z16));
            return;
        }
        this.flag = i16;
        this.reportKey = str2;
        this.isGraphic = z16;
    }

    public static MemoryFlag valueOf(String str) {
        return (MemoryFlag) Enum.valueOf(MemoryFlag.class, str);
    }

    public static MemoryFlag[] values() {
        return (MemoryFlag[]) $VALUES.clone();
    }

    public final int getFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.flag;
    }

    @NotNull
    public final String getReportKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.reportKey;
    }

    public final boolean isGraphic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isGraphic;
    }

    public /* synthetic */ MemoryFlag(String str, int i3, int i16, String str2, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i16, str2, (i17 & 4) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Boolean.valueOf(z16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
