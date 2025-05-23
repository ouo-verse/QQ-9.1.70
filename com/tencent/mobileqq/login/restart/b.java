package com.tencent.mobileqq.login.restart;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\b\u0012\b\b\u0002\u0010,\u001a\u00020\b\u0012\b\b\u0002\u0010/\u001a\u00020\u0004\u0012\b\b\u0002\u00103\u001a\u00020\u0004\u0012\b\b\u0002\u00107\u001a\u00020\u0004\u0012\b\b\u0002\u0010:\u001a\u00020\u0004\u00a2\u0006\u0004\b;\u0010<J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\"\u0010(\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u0013\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0014\u001a\u0004\b\u000b\u0010\u0016\"\u0004\b.\u0010\u0018R\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0014\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u0014\u001a\u0004\b\u0010\u0010\u0016\"\u0004\b9\u0010\u0018\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/login/restart/b;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "Ljava/util/List;", "g", "()Ljava/util/List;", "scenes", "e", "b", "deviceLevels", "f", "I", "a", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "androidVersion", tl.h.F, "i", ReportConstant.COSTREPORT_PREFIX, "slowLaunchThreshold", "r", "slowColdStartThreshold", "j", "t", "slowWarmStartThreshold", BdhLogUtil.LogTag.Tag_Conn, "Z", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "killProcessDoubleCheck", "D", "l", "v", "waitingProcessPreload", "E", "o", "downgradeTimeThreshold", UserInfo.SEX_FEMALE, "c", DomainData.DOMAIN_NAME, "downgradeSlowNum", "G", "k", "u", "totalPssThreshold", "H", "p", "javaUsedRatioThreshold", "<init>", "(Ljava/util/List;Ljava/util/List;IIIIZZIIII)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class b implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean killProcessDoubleCheck;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean waitingProcessPreload;

    /* renamed from: E, reason: from kotlin metadata */
    private int downgradeTimeThreshold;

    /* renamed from: F, reason: from kotlin metadata */
    private int downgradeSlowNum;

    /* renamed from: G, reason: from kotlin metadata */
    private int totalPssThreshold;

    /* renamed from: H, reason: from kotlin metadata */
    private int javaUsedRatioThreshold;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> scenes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> deviceLevels;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int androidVersion;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int slowLaunchThreshold;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int slowColdStartThreshold;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int slowWarmStartThreshold;

    public b() {
        this(null, null, 0, 0, 0, 0, false, false, 0, 0, 0, 0, 4095, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) {
            return;
        }
        iPatchRedirector.redirect((short) 41, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.androidVersion;
    }

    @NotNull
    public final List<Integer> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.deviceLevels;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.downgradeSlowNum;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.downgradeTimeThreshold;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.javaUsedRatioThreshold;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.scenes, bVar.scenes) && Intrinsics.areEqual(this.deviceLevels, bVar.deviceLevels) && this.androidVersion == bVar.androidVersion && this.slowLaunchThreshold == bVar.slowLaunchThreshold && this.slowColdStartThreshold == bVar.slowColdStartThreshold && this.slowWarmStartThreshold == bVar.slowWarmStartThreshold && this.killProcessDoubleCheck == bVar.killProcessDoubleCheck && this.waitingProcessPreload == bVar.waitingProcessPreload && this.downgradeTimeThreshold == bVar.downgradeTimeThreshold && this.downgradeSlowNum == bVar.downgradeSlowNum && this.totalPssThreshold == bVar.totalPssThreshold && this.javaUsedRatioThreshold == bVar.javaUsedRatioThreshold) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.killProcessDoubleCheck;
    }

    @NotNull
    public final List<String> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.scenes;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.slowColdStartThreshold;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        int hashCode = ((((((((((this.scenes.hashCode() * 31) + this.deviceLevels.hashCode()) * 31) + this.androidVersion) * 31) + this.slowLaunchThreshold) * 31) + this.slowColdStartThreshold) * 31) + this.slowWarmStartThreshold) * 31;
        boolean z16 = this.killProcessDoubleCheck;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode + i16) * 31;
        boolean z17 = this.waitingProcessPreload;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((((((i17 + i3) * 31) + this.downgradeTimeThreshold) * 31) + this.downgradeSlowNum) * 31) + this.totalPssThreshold) * 31) + this.javaUsedRatioThreshold;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.slowLaunchThreshold;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.slowWarmStartThreshold;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.totalPssThreshold;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.waitingProcessPreload;
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.androidVersion = i3;
        }
    }

    public final void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.downgradeSlowNum = i3;
        }
    }

    public final void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.downgradeTimeThreshold = i3;
        }
    }

    public final void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.javaUsedRatioThreshold = i3;
        }
    }

    public final void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.killProcessDoubleCheck = z16;
        }
    }

    public final void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.slowColdStartThreshold = i3;
        }
    }

    public final void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.slowLaunchThreshold = i3;
        }
    }

    public final void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.slowWarmStartThreshold = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return "LoginProcessRestartConfig(scenes=" + this.scenes + ", deviceLevels=" + this.deviceLevels + ", androidVersion=" + this.androidVersion + ", slowLaunchThreshold=" + this.slowLaunchThreshold + ", slowColdStartThreshold=" + this.slowColdStartThreshold + ", slowWarmStartThreshold=" + this.slowWarmStartThreshold + ", killProcessDoubleCheck=" + this.killProcessDoubleCheck + ", waitingProcessPreload=" + this.waitingProcessPreload + ", downgradeTimeThreshold=" + this.downgradeTimeThreshold + ", downgradeSlowNum=" + this.downgradeSlowNum + ", totalPssThreshold=" + this.totalPssThreshold + ", javaUsedRatioThreshold=" + this.javaUsedRatioThreshold + ")";
    }

    public final void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.totalPssThreshold = i3;
        }
    }

    public final void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.waitingProcessPreload = z16;
        }
    }

    public b(@NotNull List<String> scenes, @NotNull List<Integer> deviceLevels, int i3, int i16, int i17, int i18, boolean z16, boolean z17, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(scenes, "scenes");
        Intrinsics.checkNotNullParameter(deviceLevels, "deviceLevels");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scenes, deviceLevels, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
            return;
        }
        this.scenes = scenes;
        this.deviceLevels = deviceLevels;
        this.androidVersion = i3;
        this.slowLaunchThreshold = i16;
        this.slowColdStartThreshold = i17;
        this.slowWarmStartThreshold = i18;
        this.killProcessDoubleCheck = z16;
        this.waitingProcessPreload = z17;
        this.downgradeTimeThreshold = i19;
        this.downgradeSlowNum = i26;
        this.totalPssThreshold = i27;
        this.javaUsedRatioThreshold = i28;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ b(List list, List list2, int i3, int i16, int i17, int i18, boolean z16, boolean z17, int i19, int i26, int i27, int i28, int i29, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, r4, (i29 & 4) != 0 ? 31 : i3, (i29 & 8) != 0 ? 1000 : i16, (i29 & 16) != 0 ? 3000 : i17, (i29 & 32) != 0 ? 3000 : i18, (i29 & 64) != 0 ? true : z16, (i29 & 128) != 0 ? true : z17, (i29 & 256) != 0 ? 5000 : i19, (i29 & 512) != 0 ? 2 : i26, (i29 & 1024) != 0 ? 400 : i27, (i29 & 2048) != 0 ? 18 : i28);
        List list3;
        List list4;
        List mutableListOf;
        List mutableListOf2;
        if ((i29 & 1) != 0) {
            mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf("switchAccount");
            list3 = mutableListOf2;
        } else {
            list3 = list;
        }
        if ((i29 & 2) != 0) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(1);
            list4 = mutableListOf;
        } else {
            list4 = list2;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, list2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i29), defaultConstructorMarker);
    }
}
