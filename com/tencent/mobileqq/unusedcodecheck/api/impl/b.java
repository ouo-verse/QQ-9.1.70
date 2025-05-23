package com.tencent.mobileqq.unusedcodecheck.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\"\u0010,\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\"\u00102\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010.\u001a\u0004\b\u0010\u0010/\"\u0004\b0\u00101R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010.\u001a\u0004\b\u0015\u0010/\"\u0004\b3\u00101R\"\u00108\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\"\u0010<\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010.\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\"\u0010>\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010.\u001a\u0004\b\u0005\u0010/\"\u0004\b=\u00101R\"\u0010A\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010.\u001a\u0004\b?\u0010/\"\u0004\b@\u00101R\"\u0010D\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010!\u001a\u0004\b\f\u0010#\"\u0004\bC\u0010%R\"\u0010F\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010!\u001a\u0004\b \u0010#\"\u0004\b!\u0010%\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/api/impl/b;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "d", "Z", "p", "()Z", UserInfo.SEX_FEMALE, "(Z)V", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "e", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "grayVersionIsOpen", "f", "o", "B", "isInvalidModel", "", tl.h.F, "I", "i", "()I", "y", "(I)V", "fileBufferSize", DomainData.DOMAIN_NAME, "E", "lookupCountLimit", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "D", "l", "()D", BdhLogUtil.LogTag.Tag_Conn, "(D)V", "loadRateLimit", "k", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "grayVersionLoadRateLimit", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "allowLookupFailCount", "", "J", "()J", "v", "(J)V", "delayTimeMainProcess", HippyTKDListViewAdapter.X, "delayTimeOtherProcess", "G", "g", "w", "delayTimeMsfProcess", "H", "b", "r", "checkTimeIntervalMainProcess", "t", "checkTimeIntervalOtherProcess", "c", ReportConstant.COSTREPORT_PREFIX, "checkTimeIntervalMsfProcess", "K", "u", "cpuUsageLimit", "L", "loadRateLimitLastVersion", "<init>", "()V", "unusedcode_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private double grayVersionLoadRateLimit;

    /* renamed from: D, reason: from kotlin metadata */
    private int allowLookupFailCount;

    /* renamed from: E, reason: from kotlin metadata */
    private long delayTimeMainProcess;

    /* renamed from: F, reason: from kotlin metadata */
    private long delayTimeOtherProcess;

    /* renamed from: G, reason: from kotlin metadata */
    private long delayTimeMsfProcess;

    /* renamed from: H, reason: from kotlin metadata */
    private long checkTimeIntervalMainProcess;

    /* renamed from: I, reason: from kotlin metadata */
    private long checkTimeIntervalOtherProcess;

    /* renamed from: J, reason: from kotlin metadata */
    private long checkTimeIntervalMsfProcess;

    /* renamed from: K, reason: from kotlin metadata */
    private double cpuUsageLimit;

    /* renamed from: L, reason: from kotlin metadata */
    private double loadRateLimitLastVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isOpen;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean grayVersionIsOpen;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInvalidModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int fileBufferSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lookupCountLimit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private double loadRateLimit;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.grayVersionIsOpen = true;
        this.fileBufferSize = 20480;
        this.lookupCountLimit = 500;
        this.loadRateLimit = 0.4d;
        this.grayVersionLoadRateLimit = 0.2d;
        this.allowLookupFailCount = 3;
        this.delayTimeMainProcess = 600000L;
        this.delayTimeOtherProcess = MiniBoxNoticeInfo.MIN_5;
        long j3 = 5;
        this.delayTimeMsfProcess = MiniBoxNoticeInfo.MIN_5 * j3;
        this.checkTimeIntervalMainProcess = 600000L;
        this.checkTimeIntervalOtherProcess = 1500000L;
        this.checkTimeIntervalMsfProcess = 1500000 * j3;
        this.cpuUsageLimit = 8.0d;
        this.loadRateLimitLastVersion = 0.25d;
    }

    public final void A(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Double.valueOf(d16));
        } else {
            this.grayVersionLoadRateLimit = d16;
        }
    }

    public final void B(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isInvalidModel = z16;
        }
    }

    public final void C(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Double.valueOf(d16));
        } else {
            this.loadRateLimit = d16;
        }
    }

    public final void D(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Double.valueOf(d16));
        } else {
            this.loadRateLimitLastVersion = d16;
        }
    }

    public final void E(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.lookupCountLimit = i3;
        }
    }

    public final void F(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isOpen = z16;
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.allowLookupFailCount;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Long) iPatchRedirector.redirect((short) 24, (Object) this)).longValue();
        }
        return this.checkTimeIntervalMainProcess;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this)).longValue();
        }
        return this.checkTimeIntervalMsfProcess;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Long) iPatchRedirector.redirect((short) 26, (Object) this)).longValue();
        }
        return this.checkTimeIntervalOtherProcess;
    }

    public final double e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Double) iPatchRedirector.redirect((short) 30, (Object) this)).doubleValue();
        }
        return this.cpuUsageLimit;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        return this.delayTimeMainProcess;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this)).longValue();
        }
        return this.delayTimeMsfProcess;
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this)).longValue();
        }
        return this.delayTimeOtherProcess;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.fileBufferSize;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.grayVersionIsOpen;
    }

    public final double k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Double) iPatchRedirector.redirect((short) 14, (Object) this)).doubleValue();
        }
        return this.grayVersionLoadRateLimit;
    }

    public final double l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Double) iPatchRedirector.redirect((short) 12, (Object) this)).doubleValue();
        }
        return this.loadRateLimit;
    }

    public final double m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Double) iPatchRedirector.redirect((short) 32, (Object) this)).doubleValue();
        }
        return this.loadRateLimitLastVersion;
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.lookupCountLimit;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isInvalidModel;
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isOpen;
    }

    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.allowLookupFailCount = i3;
        }
    }

    public final void r(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, j3);
        } else {
            this.checkTimeIntervalMainProcess = j3;
        }
    }

    public final void s(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, j3);
        } else {
            this.checkTimeIntervalMsfProcess = j3;
        }
    }

    public final void t(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, j3);
        } else {
            this.checkTimeIntervalOtherProcess = j3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return "UnusedCodeCheckConfigBean(isOpen=" + this.isOpen + ", isInvalidModel=" + this.isInvalidModel + ", fileBufferSize=" + this.fileBufferSize + ", lookupCountLimit=" + this.lookupCountLimit + ", loadRateLimit=" + this.loadRateLimit + ", allowLookupFailCount=" + this.allowLookupFailCount + ", delayTimeMainProcess=" + this.delayTimeMainProcess + ", delayTimeOtherProcess=" + this.delayTimeOtherProcess + ", delayTimeMsfProcess=" + this.delayTimeMsfProcess + ", checkTimeIntervalMainProcess=" + this.checkTimeIntervalMainProcess + ", checkTimeIntervalOtherProcess=" + this.checkTimeIntervalOtherProcess + ", checkTimeIntervalMsfProcess=" + this.checkTimeIntervalMsfProcess + ", cpuUsageLimit=" + this.cpuUsageLimit + ", loadRateLimitLastVersion=" + this.loadRateLimitLastVersion + ", grayVersionLoadRate=" + this.grayVersionLoadRateLimit + ", grayVersionIsOpen=" + this.grayVersionIsOpen + ")";
    }

    public final void u(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Double.valueOf(d16));
        } else {
            this.cpuUsageLimit = d16;
        }
    }

    public final void v(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, j3);
        } else {
            this.delayTimeMainProcess = j3;
        }
    }

    public final void w(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, j3);
        } else {
            this.delayTimeMsfProcess = j3;
        }
    }

    public final void x(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, j3);
        } else {
            this.delayTimeOtherProcess = j3;
        }
    }

    public final void y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.fileBufferSize = i3;
        }
    }

    public final void z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.grayVersionIsOpen = z16;
        }
    }
}
