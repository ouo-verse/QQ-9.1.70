package com.tencent.mobileqq.qqlive.room.report;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\bX\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010*R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0012\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010*R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0012\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010*R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010*R\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0012\u001a\u0004\b/\u0010\u0014\"\u0004\b6\u0010*R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010*R\"\u0010>\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u0012\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010*R\"\u0010D\u001a\u00020?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010@\u001a\u0004\bA\u0010B\"\u0004\b\u0012\u0010CR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u0012\u001a\u0004\bF\u0010\u0014\"\u0004\bG\u0010*R\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u0012\u001a\u0004\bE\u0010\u0014\"\u0004\b@\u0010*R\"\u0010L\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\u0016\u001a\u0004\bJ\u0010\u0018\"\u0004\bK\u0010\u001aR\"\u0010O\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\bM\u0010\u0018\"\u0004\bN\u0010\u001aR\"\u0010Q\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\u0016\u001a\u0004\b;\u0010\u0018\"\u0004\bP\u0010\u001aR\"\u0010T\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0016\u001a\u0004\bR\u0010\u0018\"\u0004\bS\u0010\u001aR\"\u0010W\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u001c\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010 \u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/report/b;", "", "", "d", "c", "start", "end", "a", "f", "e", "g", HippyTKDListViewAdapter.X, "", "b", "y", "", "i", "toString", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()J", "roomId", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "Z", "B", "()Z", ExifInterface.LATITUDE_SOUTH, "(Z)V", "isVideoFirstFrameComReported", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Req, "isUserFirstFrameComeReported", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "isEnterRoomSucReported", ReportConstant.COSTREPORT_PREFIX, "M", "(J)V", "startClickTime", "t", "N", "startPreloadTime", h.F, "u", "O", "startSwitchTime", "j", "E", "firstFrameEnd", BdhLogUtil.LogTag.Tag_Conn, "enterRoomEnd", "getPageInTime", "G", "pageInTime", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "H", "pageOutTime", "", "I", "o", "()I", "(I)V", "playerBufferTimes", DomainData.DOMAIN_NAME, "p", "K", "playerStartBufferTimeMs", "playerBufferDurationMs", "getVideoSource", "setVideoSource", "videoSource", "r", "L", "roomType", UserInfo.SEX_FEMALE, "jumpSource", "v", "P", "uid", "w", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "useLivesdk", "<init>", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoFirstFrameComReported;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isUserFirstFrameComeReported;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isEnterRoomSucReported;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long startClickTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long startPreloadTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long startSwitchTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long firstFrameEnd;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long enterRoomEnd;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long pageInTime;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long pageOutTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int playerBufferTimes;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long playerStartBufferTimeMs;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long playerBufferDurationMs;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoSource;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String roomType;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jumpSource;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean useLivesdk;

    public b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
            return;
        }
        this.roomId = j3;
        this.id = j3 + "_" + System.currentTimeMillis();
        this.startClickTime = -1L;
        this.startPreloadTime = -1L;
        this.startSwitchTime = -1L;
        this.firstFrameEnd = -1L;
        this.enterRoomEnd = -1L;
        this.pageInTime = -1L;
        this.pageOutTime = -1L;
        this.playerStartBufferTimeMs = -1L;
        this.playerBufferDurationMs = -1L;
        this.videoSource = "";
        this.roomType = "";
        this.jumpSource = "";
        this.uid = "";
        this.useLivesdk = true;
    }

    private final long a(long start, long end) {
        if (start == -1 || end == -1 || end < start) {
            return -1L;
        }
        return end - start;
    }

    private final long c() {
        long j3 = this.pageInTime;
        if (j3 != -1) {
            return j3;
        }
        long j16 = this.startSwitchTime;
        if (j16 != -1) {
            return j16;
        }
        long j17 = this.startClickTime;
        if (j17 != -1) {
            return j17;
        }
        return this.startPreloadTime;
    }

    private final long d() {
        long j3 = this.startClickTime;
        if (j3 != -1) {
            return j3;
        }
        long j16 = this.startPreloadTime;
        if (j16 != -1) {
            return j16;
        }
        return this.startSwitchTime;
    }

    public final boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isUserFirstFrameComeReported;
    }

    public final boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isVideoFirstFrameComReported;
    }

    public final void C(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
        } else {
            this.enterRoomEnd = j3;
        }
    }

    public final void D(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.isEnterRoomSucReported = z16;
        }
    }

    public final void E(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        } else {
            this.firstFrameEnd = j3;
        }
    }

    public final void F(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jumpSource = str;
        }
    }

    public final void G(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, j3);
        } else {
            this.pageInTime = j3;
        }
    }

    public final void H(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, j3);
        } else {
            this.pageOutTime = j3;
        }
    }

    public final void I(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, j3);
        } else {
            this.playerBufferDurationMs = j3;
        }
    }

    public final void J(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.playerBufferTimes = i3;
        }
    }

    public final void K(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        } else {
            this.playerStartBufferTimeMs = j3;
        }
    }

    public final void L(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.roomType = str;
        }
    }

    public final void M(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
        } else {
            this.startClickTime = j3;
        }
    }

    public final void N(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.startPreloadTime = j3;
        }
    }

    public final void O(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            this.startSwitchTime = j3;
        }
    }

    public final void P(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }
    }

    public final void Q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, z16);
        } else {
            this.useLivesdk = z16;
        }
    }

    public final void R(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.isUserFirstFrameComeReported = z16;
        }
    }

    public final void S(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.isVideoFirstFrameComReported = z16;
        }
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        if (this.firstFrameEnd != -1 && (this.startSwitchTime != -1 || this.startClickTime != -1)) {
            return true;
        }
        return false;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Long) iPatchRedirector.redirect((short) 42, (Object) this)).longValue();
        }
        return a(c(), this.enterRoomEnd);
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Long) iPatchRedirector.redirect((short) 41, (Object) this)).longValue();
        }
        return a(d(), this.firstFrameEnd);
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Long) iPatchRedirector.redirect((short) 43, (Object) this)).longValue();
        }
        return a(d(), System.currentTimeMillis());
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.enterRoomEnd;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (String) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return "ReportRecord(roomId='" + this.roomId + "', startClickTime=" + this.startClickTime + ", startSwitchTime=" + this.startSwitchTime + ", firstFrameEnd=" + this.firstFrameEnd + ")";
    }

    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.firstFrameEnd;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.id;
    }

    @NotNull
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.jumpSource;
    }

    public final long m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return this.pageOutTime;
    }

    public final long n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Long) iPatchRedirector.redirect((short) 29, (Object) this)).longValue();
        }
        return this.playerBufferDurationMs;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.playerBufferTimes;
    }

    public final long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Long) iPatchRedirector.redirect((short) 27, (Object) this)).longValue();
        }
        return this.playerStartBufferTimeMs;
    }

    public final long q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.roomId;
    }

    @NotNull
    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.roomType;
    }

    public final long s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.startClickTime;
    }

    public final long t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.startPreloadTime;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (String) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return "ReportRecord(id='" + this.id + "', isVideoFirstFrameComReported=" + this.isVideoFirstFrameComReported + ", isEnterRoomSucReported=" + this.isEnterRoomSucReported + ", roomId='" + this.roomId + "', startClickTime=" + this.startClickTime + ", startPreloadTime=" + this.startPreloadTime + ", startSwitchTime=" + this.startSwitchTime + ", firstFrameEnd=" + this.firstFrameEnd + ", enterRoomEnd=" + this.enterRoomEnd + ", videoSource='" + this.videoSource + "', roomType='" + this.roomType + "', jumpSource='" + this.jumpSource + "', uid='" + this.uid + "', uselivesdk='" + this.useLivesdk + "')";
    }

    public final long u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.startSwitchTime;
    }

    @NotNull
    public final String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.uid;
    }

    public final boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return this.useLivesdk;
    }

    public final long x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Long) iPatchRedirector.redirect((short) 44, (Object) this)).longValue();
        }
        long j3 = this.firstFrameEnd;
        long j16 = this.startSwitchTime;
        if (j3 < j16) {
            return 0L;
        }
        long j17 = this.startClickTime;
        if (j17 != -1) {
            return j3 - j17;
        }
        return j3 - j16;
    }

    public final boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        if (this.isVideoFirstFrameComReported && this.isEnterRoomSucReported && this.isUserFirstFrameComeReported) {
            return true;
        }
        return false;
    }

    public final boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isEnterRoomSucReported;
    }
}
