package com.tencent.mobileqq.qqlive.sail.model.player;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010)\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\u0006\u0010,\u001a\u00020\u0013\u0012\u0006\u0010.\u001a\u00020\u0013\u0012\u0006\u0010/\u001a\u00020\u0013\u0012\u0006\u00100\u001a\u00020\u0013\u0012\u0006\u00101\u001a\u00020\u0013\u0012\u0006\u00102\u001a\u00020\u0013\u0012\u0006\u00103\u001a\u00020\u0002\u0012\u0006\u00104\u001a\u00020\u0002\u00a2\u0006\u0004\b5\u00106J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b\t\u0010\u001cR\u0017\u0010,\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b\u000e\u0010\u0017R\u0017\u0010.\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b-\u0010\u0017R\u0017\u0010/\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b%\u0010\u0017R\u0017\u00100\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u00101\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\u0017\u00102\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b!\u0010\u0017R\u0017\u00103\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b*\u0010\fR\u0017\u00104\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\f\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/player/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "url", "b", "c", "containerFormat", DomainData.DOMAIN_NAME, "videoCodecFormat", "", "d", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "videoBitrate", "e", "I", "o", "()I", "videoFps", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "videoWidth", "g", "p", "videoHeight", "", h.F, UserInfo.SEX_FEMALE, "j", "()F", "speedKB", "i", "bufferCount", "bufferTotalDuration", "k", "startBufferTimeMs", "prepareCostMs", "firstFrameShowTimeMs", "firstFrameCostMs", "playTimestampMs", AudienceReportConst.PROTOCOL, "playId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIIFIJJJJJJLjava/lang/String;Ljava/lang/String;)V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String containerFormat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String videoCodecFormat;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long videoBitrate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int videoFps;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int videoWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int videoHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float speedKB;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int bufferCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final long bufferTotalDuration;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final long startBufferTimeMs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final long prepareCostMs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long firstFrameShowTimeMs;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final long firstFrameCostMs;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final long playTimestampMs;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String protocol;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String playId;

    public a(@NotNull String url, @NotNull String containerFormat, @NotNull String videoCodecFormat, long j3, int i3, int i16, int i17, float f16, int i18, long j16, long j17, long j18, long j19, long j26, long j27, @NotNull String protocol2, @NotNull String playId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(containerFormat, "containerFormat");
        Intrinsics.checkNotNullParameter(videoCodecFormat, "videoCodecFormat");
        Intrinsics.checkNotNullParameter(protocol2, "protocol");
        Intrinsics.checkNotNullParameter(playId, "playId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, url, containerFormat, videoCodecFormat, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(f16), Integer.valueOf(i18), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), protocol2, playId);
            return;
        }
        this.url = url;
        this.containerFormat = containerFormat;
        this.videoCodecFormat = videoCodecFormat;
        this.videoBitrate = j3;
        this.videoFps = i3;
        this.videoWidth = i16;
        this.videoHeight = i17;
        this.speedKB = f16;
        this.bufferCount = i18;
        this.bufferTotalDuration = j16;
        this.startBufferTimeMs = j17;
        this.prepareCostMs = j18;
        this.firstFrameShowTimeMs = j19;
        this.firstFrameCostMs = j26;
        this.playTimestampMs = j27;
        this.protocol = protocol2;
        this.playId = playId;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.bufferCount;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.bufferTotalDuration;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.containerFormat;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.firstFrameCostMs;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.firstFrameShowTimeMs;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.url, aVar.url) && Intrinsics.areEqual(this.containerFormat, aVar.containerFormat) && Intrinsics.areEqual(this.videoCodecFormat, aVar.videoCodecFormat) && this.videoBitrate == aVar.videoBitrate && this.videoFps == aVar.videoFps && this.videoWidth == aVar.videoWidth && this.videoHeight == aVar.videoHeight && Float.compare(this.speedKB, aVar.speedKB) == 0 && this.bufferCount == aVar.bufferCount && this.bufferTotalDuration == aVar.bufferTotalDuration && this.startBufferTimeMs == aVar.startBufferTimeMs && this.prepareCostMs == aVar.prepareCostMs && this.firstFrameShowTimeMs == aVar.firstFrameShowTimeMs && this.firstFrameCostMs == aVar.firstFrameCostMs && this.playTimestampMs == aVar.playTimestampMs && Intrinsics.areEqual(this.protocol, aVar.protocol) && Intrinsics.areEqual(this.playId, aVar.playId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.playId;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.playTimestampMs;
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.prepareCostMs;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return (((((((((((((((((((((((((((((((this.url.hashCode() * 31) + this.containerFormat.hashCode()) * 31) + this.videoCodecFormat.hashCode()) * 31) + androidx.fragment.app.a.a(this.videoBitrate)) * 31) + this.videoFps) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31) + Float.floatToIntBits(this.speedKB)) * 31) + this.bufferCount) * 31) + androidx.fragment.app.a.a(this.bufferTotalDuration)) * 31) + androidx.fragment.app.a.a(this.startBufferTimeMs)) * 31) + androidx.fragment.app.a.a(this.prepareCostMs)) * 31) + androidx.fragment.app.a.a(this.firstFrameShowTimeMs)) * 31) + androidx.fragment.app.a.a(this.firstFrameCostMs)) * 31) + androidx.fragment.app.a.a(this.playTimestampMs)) * 31) + this.protocol.hashCode()) * 31) + this.playId.hashCode();
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.protocol;
    }

    public final float j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.speedKB;
    }

    public final long k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.startBufferTimeMs;
    }

    @NotNull
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.url;
    }

    public final long m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.videoBitrate;
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.videoCodecFormat;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.videoFps;
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.videoHeight;
    }

    public final int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.videoWidth;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return "PlayerQuality(url=" + this.url + ", containerFormat=" + this.containerFormat + ", videoCodecFormat=" + this.videoCodecFormat + ", videoBitrate=" + this.videoBitrate + ", videoFps=" + this.videoFps + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", speedKB=" + this.speedKB + ", bufferCount=" + this.bufferCount + ", bufferTotalDuration=" + this.bufferTotalDuration + ", startBufferTimeMs=" + this.startBufferTimeMs + ", prepareCostMs=" + this.prepareCostMs + ", firstFrameShowTimeMs=" + this.firstFrameShowTimeMs + ", firstFrameCostMs=" + this.firstFrameCostMs + ", playTimestampMs=" + this.playTimestampMs + ", protocol=" + this.protocol + ", playId=" + this.playId + ")";
    }
}
