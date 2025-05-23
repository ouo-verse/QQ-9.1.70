package com.tencent.mobileqq.app.message.messageclean;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b0\u0018\u0000 #2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\"\u0010\u001a\"\u0004\b)\u0010\u001cR\"\u0010.\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b/\u0010\u001cR\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0018\u001a\u0004\b+\u0010\u001a\"\u0004\b6\u0010\u001cR\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b8\u0010\u001cR\u0011\u0010:\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b1\u0010\u001aR\u0011\u0010;\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u001aR\u0011\u0010<\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b5\u0010\u001a\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/app/message/messageclean/be;", "", "", "p", "", "deleteChatRecordSize", "o", "deleteChatFileSize", DomainData.DOMAIN_NAME, "newZootopiaSize", BdhLogUtil.LogTag.Tag_Conn, "newMiniGameSize", "B", "", "toString", "", "a", "Z", tl.h.F, "()Z", HippyTKDListViewAdapter.X, "(Z)V", "needUpdateUi", "b", "J", "f", "()J", "v", "(J)V", "deviceTotalSize", "c", "e", "u", "deviceAvailableSize", "d", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qqTotalSize", "k", "y", "qqAppSize", ReportConstant.COSTREPORT_PREFIX, "chatRecordSize", "g", "getChatRecordTextSize", "t", "chatRecordTextSize", "r", "chatFileSize", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "zootopiaSize", "j", "w", "minigameSize", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "cacheSize", "otherAppSize", "chatAndFileSize", "otherDataSize", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class be {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean needUpdateUi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long deviceTotalSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long deviceAvailableSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long qqTotalSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long qqAppSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long chatRecordSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long chatRecordTextSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long chatFileSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long zootopiaSize;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long minigameSize;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long cacheSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/message/messageclean/be$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.message.messageclean.be$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public be() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void A(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
        } else {
            this.zootopiaSize = j3;
        }
    }

    public final void B(long newMiniGameSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, newMiniGameSize);
            return;
        }
        long j3 = this.minigameSize;
        if (j3 == newMiniGameSize) {
            return;
        }
        long j16 = j3 - newMiniGameSize;
        this.qqTotalSize -= j16;
        this.deviceAvailableSize += j16;
        this.minigameSize = newMiniGameSize;
        this.needUpdateUi = true;
        QLog.d("StorageSize", 1, "deleteMiniGameSize:" + j16 + ", storageSize:" + this);
    }

    public final void C(long newZootopiaSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, newZootopiaSize);
            return;
        }
        long j3 = this.zootopiaSize;
        if (j3 == newZootopiaSize) {
            return;
        }
        long j16 = j3 - newZootopiaSize;
        this.qqTotalSize -= j16;
        this.deviceAvailableSize += j16;
        this.zootopiaSize = newZootopiaSize;
        this.needUpdateUi = true;
        QLog.d("StorageSize", 1, "deleteZootopiaSize:" + j16 + ", storageSize:" + this);
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return this.cacheSize;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Long) iPatchRedirector.redirect((short) 25, (Object) this)).longValue();
        }
        return this.chatFileSize + this.chatRecordTextSize + this.zootopiaSize + this.minigameSize;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.chatFileSize;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.chatRecordSize;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.deviceAvailableSize;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.deviceTotalSize;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this)).longValue();
        }
        return this.minigameSize;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.needUpdateUi;
    }

    public final long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return (this.deviceTotalSize - this.qqTotalSize) - this.deviceAvailableSize;
    }

    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Long) iPatchRedirector.redirect((short) 26, (Object) this)).longValue();
        }
        return (this.qqTotalSize - b()) - this.cacheSize;
    }

    public final long k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.qqAppSize;
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.qqTotalSize;
    }

    public final long m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.zootopiaSize;
    }

    public final void n(long deleteChatFileSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, deleteChatFileSize);
            return;
        }
        this.qqTotalSize -= deleteChatFileSize;
        this.deviceAvailableSize += deleteChatFileSize;
        this.needUpdateUi = true;
        QLog.d("StorageSize", 1, "deleteChatFileSize:" + deleteChatFileSize + ", storageSize:" + this);
    }

    public final void o(long deleteChatRecordSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, deleteChatRecordSize);
            return;
        }
        this.qqTotalSize -= deleteChatRecordSize;
        this.deviceAvailableSize += deleteChatRecordSize;
        this.needUpdateUi = true;
        QLog.d("StorageSize", 1, "deleteChatRecordSize:" + deleteChatRecordSize + ", storageSize:" + this);
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        long j3 = this.qqTotalSize;
        long j16 = this.cacheSize;
        this.qqTotalSize = j3 - j16;
        this.deviceAvailableSize += j16;
        this.cacheSize = 0L;
        QLog.d("StorageSize", 1, "cacheSize:0, storageSize:" + this);
    }

    public final void q(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, j3);
        } else {
            this.cacheSize = j3;
        }
    }

    public final void r(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        } else {
            this.chatFileSize = j3;
        }
    }

    public final void s(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.chatRecordSize = j3;
        }
    }

    public final void t(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            this.chatRecordTextSize = j3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return "StorageSize(needUpdateUi=" + this.needUpdateUi + ", deviceTotalSize=" + this.deviceTotalSize + ", deviceAvailableSize=" + this.deviceAvailableSize + ", otherAppSize=" + i() + ", qqTotalSize=" + this.qqTotalSize + ", chatRecordSize=" + this.chatRecordSize + ", chatRecordTextSize=" + this.chatRecordTextSize + ", chatFileSize=" + this.chatFileSize + ", zootopiaSize=" + this.zootopiaSize + ", minigameSize=" + this.minigameSize + ", cacheSize=" + this.cacheSize + ", chatAndFileSize=" + b() + ", otherDataSize=" + j() + ")";
    }

    public final void u(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.deviceAvailableSize = j3;
        }
    }

    public final void v(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.deviceTotalSize = j3;
        }
    }

    public final void w(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, j3);
        } else {
            this.minigameSize = j3;
        }
    }

    public final void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.needUpdateUi = z16;
        }
    }

    public final void y(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
        } else {
            this.qqAppSize = j3;
        }
    }

    public final void z(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            this.qqTotalSize = j3;
        }
    }
}
