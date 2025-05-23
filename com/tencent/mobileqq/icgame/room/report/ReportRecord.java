package com.tencent.mobileqq.icgame.room.report;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\bX\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010*R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0012\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010*R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0012\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010*R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010*R\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0012\u001a\u0004\b/\u0010\u0014\"\u0004\b6\u0010*R\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010*R\"\u0010>\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u0012\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010*R\"\u0010E\u001a\u00020?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\u0012\u001a\u0004\bG\u0010\u0014\"\u0004\b@\u0010*R\"\u0010J\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u0012\u001a\u0004\bF\u0010\u0014\"\u0004\bI\u0010*R\"\u0010M\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\u0016\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010\u001aR\"\u0010O\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\bN\u0010\u0018\"\u0004\b\u0012\u0010\u001aR\"\u0010Q\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0016\u001a\u0004\b;\u0010\u0018\"\u0004\bP\u0010\u001aR\"\u0010T\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0016\u001a\u0004\bR\u0010\u0018\"\u0004\bS\u0010\u001aR\"\u0010W\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u001c\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010 \u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/report/c;", "", "", "d", "c", "start", "end", "a", "f", "e", "g", "v", "", "b", "w", "", "i", "toString", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()J", "roomId", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Z", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Z)V", "isVideoFirstFrameComReported", "y", "P", "isUserFirstFrameComeReported", HippyTKDListViewAdapter.X, "B", "isEnterRoomSucReported", "r", "K", "(J)V", "startClickTime", ReportConstant.COSTREPORT_PREFIX, "L", "startPreloadTime", h.F, "t", "M", "startSwitchTime", "j", BdhLogUtil.LogTag.Tag_Conn, "firstFrameEnd", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "enterRoomEnd", "getPageInTime", "E", "pageInTime", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "pageOutTime", "", "I", "o", "()I", "H", "(I)V", "playerBufferTimes", DomainData.DOMAIN_NAME, "p", "playerStartBufferTimeMs", "G", "playerBufferDurationMs", "getVideoSource", "setVideoSource", "videoSource", "getRoomType", "roomType", "D", "jumpSource", "u", "N", "uid", "getUseLivesdk", "O", "useLivesdk", "<init>", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.icgame.room.report.c, reason: from toString */
/* loaded from: classes15.dex */
public final class ReportRecord {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isVideoFirstFrameComReported;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isUserFirstFrameComeReported;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isEnterRoomSucReported;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int playerBufferTimes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long startClickTime = -1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long startPreloadTime = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long startSwitchTime = -1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private long firstFrameEnd = -1;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private long enterRoomEnd = -1;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long pageInTime = -1;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long pageOutTime = -1;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long playerStartBufferTimeMs = -1;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long playerBufferDurationMs = -1;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String videoSource = "";

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String roomType = "";

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String jumpSource = "";

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String uid = "";

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean uselivesdk = true;

    public ReportRecord(long j3) {
        this.roomId = j3;
        this.id = j3 + "_" + System.currentTimeMillis();
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

    public final void A(long j3) {
        this.enterRoomEnd = j3;
    }

    public final void B(boolean z16) {
        this.isEnterRoomSucReported = z16;
    }

    public final void C(long j3) {
        this.firstFrameEnd = j3;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpSource = str;
    }

    public final void E(long j3) {
        this.pageInTime = j3;
    }

    public final void F(long j3) {
        this.pageOutTime = j3;
    }

    public final void G(long j3) {
        this.playerBufferDurationMs = j3;
    }

    public final void H(int i3) {
        this.playerBufferTimes = i3;
    }

    public final void I(long j3) {
        this.playerStartBufferTimeMs = j3;
    }

    public final void J(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.roomType = str;
    }

    public final void K(long j3) {
        this.startClickTime = j3;
    }

    public final void L(long j3) {
        this.startPreloadTime = j3;
    }

    public final void M(long j3) {
        this.startSwitchTime = j3;
    }

    public final void N(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uid = str;
    }

    public final void O(boolean z16) {
        this.uselivesdk = z16;
    }

    public final void P(boolean z16) {
        this.isUserFirstFrameComeReported = z16;
    }

    public final void Q(boolean z16) {
        this.isVideoFirstFrameComReported = z16;
    }

    public final boolean b() {
        if (this.firstFrameEnd != -1 && (this.startSwitchTime != -1 || this.startClickTime != -1)) {
            return true;
        }
        return false;
    }

    public final long e() {
        return a(c(), this.enterRoomEnd);
    }

    public final long f() {
        return a(d(), this.firstFrameEnd);
    }

    public final long g() {
        return a(d(), System.currentTimeMillis());
    }

    /* renamed from: h, reason: from getter */
    public final long getEnterRoomEnd() {
        return this.enterRoomEnd;
    }

    @NotNull
    public final String i() {
        return "ReportRecord(roomId='" + this.roomId + "', startClickTime=" + this.startClickTime + ", startSwitchTime=" + this.startSwitchTime + ", firstFrameEnd=" + this.firstFrameEnd + ")";
    }

    /* renamed from: j, reason: from getter */
    public final long getFirstFrameEnd() {
        return this.firstFrameEnd;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getJumpSource() {
        return this.jumpSource;
    }

    /* renamed from: m, reason: from getter */
    public final long getPageOutTime() {
        return this.pageOutTime;
    }

    /* renamed from: n, reason: from getter */
    public final long getPlayerBufferDurationMs() {
        return this.playerBufferDurationMs;
    }

    /* renamed from: o, reason: from getter */
    public final int getPlayerBufferTimes() {
        return this.playerBufferTimes;
    }

    /* renamed from: p, reason: from getter */
    public final long getPlayerStartBufferTimeMs() {
        return this.playerStartBufferTimeMs;
    }

    /* renamed from: q, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: r, reason: from getter */
    public final long getStartClickTime() {
        return this.startClickTime;
    }

    /* renamed from: s, reason: from getter */
    public final long getStartPreloadTime() {
        return this.startPreloadTime;
    }

    /* renamed from: t, reason: from getter */
    public final long getStartSwitchTime() {
        return this.startSwitchTime;
    }

    @NotNull
    public String toString() {
        return "ReportRecord(id='" + this.id + "', isVideoFirstFrameComReported=" + this.isVideoFirstFrameComReported + ", isEnterRoomSucReported=" + this.isEnterRoomSucReported + ", roomId='" + this.roomId + "', startClickTime=" + this.startClickTime + ", startPreloadTime=" + this.startPreloadTime + ", startSwitchTime=" + this.startSwitchTime + ", firstFrameEnd=" + this.firstFrameEnd + ", enterRoomEnd=" + this.enterRoomEnd + ", videoSource='" + this.videoSource + "', roomType='" + this.roomType + "', jumpSource='" + this.jumpSource + "', uid='" + this.uid + "', uselivesdk='" + this.uselivesdk + "')";
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    public final long v() {
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

    public final boolean w() {
        if (this.isVideoFirstFrameComReported && this.isEnterRoomSucReported && this.isUserFirstFrameComeReported) {
            return true;
        }
        return false;
    }

    /* renamed from: x, reason: from getter */
    public final boolean getIsEnterRoomSucReported() {
        return this.isEnterRoomSucReported;
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsUserFirstFrameComeReported() {
        return this.isUserFirstFrameComeReported;
    }

    /* renamed from: z, reason: from getter */
    public final boolean getIsVideoFirstFrameComReported() {
        return this.isVideoFirstFrameComReported;
    }
}
