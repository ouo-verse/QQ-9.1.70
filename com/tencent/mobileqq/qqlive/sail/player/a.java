package com.tencent.mobileqq.qqlive.sail.player;

import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.model.UploadVideoObject;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0015\u0018\u0000 E2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\bC\u0010DJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006R\"\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\"\u00100\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00102R\u0016\u00104\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001eR\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001eR\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u001eR\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001eR\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u0015R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0016\u0010<\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0016\u0010>\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\u001eR\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\u001eR\u0016\u0010B\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010\u001e\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/a;", "", "", "e", "Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", "c", "", "playId", "g", "", "timestamp", h.F, "size", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "a", "p", "b", "d", "codecId", "k", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "url", "getContainerFormat", "f", "containerFormat", "J", "getVideoBitrate", "()J", "j", "(J)V", "videoBitrate", "", "I", "getVideoWidth", "()I", DomainData.DOMAIN_NAME, "(I)V", "videoWidth", "getVideoHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "videoHeight", "getVideoFps", "l", "videoFps", "", UserInfo.SEX_FEMALE, "speedKB", "bufferCount", "totalBufferTimeMs", "prepareCostMs", "firstFrameShowTimeMs", "firstFrameCostMs", "playTimestampMs", AudienceReportConst.PROTOCOL, "videoCodecFormat", "lastCachedSize", "r", "lastCachedSizeTimestamp", ReportConstant.COSTREPORT_PREFIX, "startBufferTimestamp", "t", "startPrepareTimestamp", "<init>", "()V", "u", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String containerFormat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long videoBitrate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int videoWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int videoHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int videoFps;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float speedKB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int bufferCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long totalBufferTimeMs;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long prepareCostMs;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long firstFrameShowTimeMs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long firstFrameCostMs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long playTimestampMs;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String protocol;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoCodecFormat;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String playId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private long lastCachedSize;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private long lastCachedSizeTimestamp;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private long startBufferTimestamp;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private long startPrepareTimestamp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/player/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.player.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.url = "";
        this.containerFormat = "";
        this.videoBitrate = -1L;
        this.videoWidth = -1;
        this.videoHeight = -1;
        this.videoFps = -1;
        this.speedKB = -1.0f;
        this.bufferCount = -1;
        this.totalBufferTimeMs = -1L;
        this.prepareCostMs = -1L;
        this.firstFrameShowTimeMs = -1L;
        this.firstFrameCostMs = -1L;
        this.playTimestampMs = -1L;
        this.protocol = "";
        this.videoCodecFormat = "";
        this.playId = "";
        this.lastCachedSize = -1L;
        this.lastCachedSizeTimestamp = -1L;
        this.startBufferTimestamp = -1L;
        this.startPrepareTimestamp = -1L;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.totalBufferTimeMs += System.currentTimeMillis() - this.startBufferTimestamp;
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.prepareCostMs = System.currentTimeMillis() - this.startPrepareTimestamp;
        }
    }

    @NotNull
    public final com.tencent.mobileqq.qqlive.sail.model.player.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.mobileqq.qqlive.sail.model.player.a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return new com.tencent.mobileqq.qqlive.sail.model.player.a(this.url, this.containerFormat, this.videoCodecFormat, this.videoBitrate, this.videoFps, this.videoWidth, this.videoHeight, this.speedKB, this.bufferCount, this.totalBufferTimeMs, this.startBufferTimestamp, this.prepareCostMs, this.firstFrameShowTimeMs, this.firstFrameCostMs, this.playTimestampMs, this.protocol, this.playId);
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.firstFrameShowTimeMs = currentTimeMillis;
        this.firstFrameCostMs = currentTimeMillis - this.startPrepareTimestamp;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.url = "";
        this.containerFormat = "";
        this.videoCodecFormat = "";
        this.videoBitrate = -1L;
        this.videoFps = -1;
        this.videoWidth = -1;
        this.videoHeight = -1;
        this.speedKB = -1.0f;
        this.bufferCount = -1;
        this.totalBufferTimeMs = -1L;
        this.prepareCostMs = -1L;
        this.firstFrameShowTimeMs = -1L;
        this.firstFrameCostMs = -1L;
        this.playTimestampMs = -1L;
        this.lastCachedSize = -1L;
        this.lastCachedSizeTimestamp = -1L;
        this.startBufferTimestamp = -1L;
        this.startPrepareTimestamp = -1L;
        this.protocol = "";
    }

    public final void f(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.containerFormat = str;
        }
    }

    public final void g(@NotNull String playId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) playId);
        } else {
            Intrinsics.checkNotNullParameter(playId, "playId");
            this.playId = playId;
        }
    }

    public final void h(long timestamp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, timestamp);
        } else {
            this.playTimestampMs = timestamp;
        }
    }

    public final void i(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }
    }

    public final void j(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.videoBitrate = j3;
        }
    }

    public final void k(@NotNull String codecId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) codecId);
            return;
        }
        Intrinsics.checkNotNullParameter(codecId, "codecId");
        if (Intrinsics.areEqual(codecId, "TP_CODEC_ID_H264")) {
            str = "h264";
        } else if (Intrinsics.areEqual(codecId, "TP_CODEC_ID_HEVC")) {
            str = UploadVideoObject.VODEO_FORMAT_H265;
        } else {
            str = "unknown";
        }
        this.videoCodecFormat = str;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d("QQLive_Player|LiveVideoQualityStatistics", "setVideoCodecFormat", "videoCodecFormat=" + this.videoCodecFormat);
        }
    }

    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.videoFps = i3;
        }
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.videoHeight = i3;
        }
    }

    public final void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.videoWidth = i3;
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.bufferCount++;
            this.startBufferTimestamp = System.currentTimeMillis();
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.startPrepareTimestamp = System.currentTimeMillis();
        }
    }

    public final void q(long size) {
        long coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, size);
            return;
        }
        float currentTimeMillis = (((float) (System.currentTimeMillis() - this.lastCachedSizeTimestamp)) * 1.0f) / 1000;
        if (currentTimeMillis > 0.0f) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(size - this.lastCachedSize, 0L);
            this.speedKB = ((((float) coerceAtLeast) * 1.0f) / currentTimeMillis) / 1024;
            this.lastCachedSize = size;
            this.lastCachedSizeTimestamp = System.currentTimeMillis();
        }
    }
}
