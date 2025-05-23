package com.tencent.qqnt.compress.video.config;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.compress.api.IVideoManagerConfigApi;
import com.tencent.qqnt.util.video.a;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/compress/video/config/a;", "", "", "inputPath", "Lkotlin/Pair;", "Lcom/tencent/richmedia/videocompress/VideoConverterConfig;", "", "a", "Lcom/tencent/qqnt/util/video/a$a;", QCircleScheme.AttrDetail.VIDEO_INFO, "Lcom/tencent/qqnt/compress/video/config/a$a;", DownloadInfo.spKey_Config, "", "b", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f355762a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u0012\b\b\u0002\u0010$\u001a\u00020\u001b\u0012\b\b\u0002\u0010&\u001a\u00020\u001b\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\t\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\"\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b!\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b'\u0010\u000e\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/compress/video/config/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "k", "(I)V", "maxLength", "", "b", "D", "()D", "i", "(D)V", "maxDensity", "c", "g", DomainData.DOMAIN_NAME, "minDensity", "", "J", "()J", h.F, "(J)V", "maxBitRate", "e", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "minBitRate", "l", "maxSize", "j", "maxFPS", "<init>", "(IDDJJJI)V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.compress.video.config.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final /* data */ class C9606a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int maxLength;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private double maxDensity;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private double minDensity;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long maxBitRate;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long minBitRate;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long maxSize;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int maxFPS;

        public C9606a() {
            this(0, 0.0d, 0.0d, 0L, 0L, 0L, 0, 127, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
                return;
            }
            iPatchRedirector.redirect((short) 28, (Object) this);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
            }
            return this.maxBitRate;
        }

        public final double b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Double) iPatchRedirector.redirect((short) 5, (Object) this)).doubleValue();
            }
            return this.maxDensity;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            return this.maxFPS;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.maxLength;
        }

        public final long e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
            }
            return this.maxSize;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C9606a)) {
                return false;
            }
            C9606a c9606a = (C9606a) other;
            if (this.maxLength == c9606a.maxLength && Double.compare(this.maxDensity, c9606a.maxDensity) == 0 && Double.compare(this.minDensity, c9606a.minDensity) == 0 && this.maxBitRate == c9606a.maxBitRate && this.minBitRate == c9606a.minBitRate && this.maxSize == c9606a.maxSize && this.maxFPS == c9606a.maxFPS) {
                return true;
            }
            return false;
        }

        public final long f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
            }
            return this.minBitRate;
        }

        public final double g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Double) iPatchRedirector.redirect((short) 7, (Object) this)).doubleValue();
            }
            return this.minDensity;
        }

        public final void h(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, j3);
            } else {
                this.maxBitRate = j3;
            }
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
            }
            return (((((((((((this.maxLength * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.maxDensity)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.minDensity)) * 31) + androidx.fragment.app.a.a(this.maxBitRate)) * 31) + androidx.fragment.app.a.a(this.minBitRate)) * 31) + androidx.fragment.app.a.a(this.maxSize)) * 31) + this.maxFPS;
        }

        public final void i(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Double.valueOf(d16));
            } else {
                this.maxDensity = d16;
            }
        }

        public final void j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, i3);
            } else {
                this.maxFPS = i3;
            }
        }

        public final void k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.maxLength = i3;
            }
        }

        public final void l(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, j3);
            } else {
                this.maxSize = j3;
            }
        }

        public final void m(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, j3);
            } else {
                this.minBitRate = j3;
            }
        }

        public final void n(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Double.valueOf(d16));
            } else {
                this.minDensity = d16;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (String) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            return "ManageConfig(maxLength=" + this.maxLength + ", maxDensity=" + this.maxDensity + ", minDensity=" + this.minDensity + ", maxBitRate=" + this.maxBitRate + ", minBitRate=" + this.minBitRate + ", maxSize=" + this.maxSize + ", maxFPS=" + this.maxFPS + ")";
        }

        public C9606a(int i3, double d16, double d17, long j3, long j16, long j17, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Double.valueOf(d16), Double.valueOf(d17), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i16));
                return;
            }
            this.maxLength = i3;
            this.maxDensity = d16;
            this.minDensity = d17;
            this.maxBitRate = j3;
            this.minBitRate = j16;
            this.maxSize = j17;
            this.maxFPS = i16;
        }

        public /* synthetic */ C9606a(int i3, double d16, double d17, long j3, long j16, long j17, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 1280 : i3, (i17 & 2) != 0 ? 0.075d : d16, (i17 & 4) != 0 ? 0.067d : d17, (i17 & 8) != 0 ? 2097152L : j3, (i17 & 16) != 0 ? 1048576L : j16, (i17 & 32) != 0 ? 754974720L : j17, (i17 & 64) != 0 ? 30 : i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Double.valueOf(d16), Double.valueOf(d17), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39583);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f355762a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Pair<VideoConverterConfig, Float> a(@NotNull String inputPath) {
        int coerceAtLeast;
        int f16;
        int e16;
        float f17;
        int c16;
        long coerceAtMost;
        long coerceAtMost2;
        int i3;
        double coerceIn;
        long coerceIn2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) inputPath);
        }
        Intrinsics.checkNotNullParameter(inputPath, "inputPath");
        a.C9706a a16 = com.tencent.qqnt.util.video.a.f362991a.a(inputPath);
        C9606a config = ((IVideoManagerConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IVideoManagerConfigApi.class)).getConfig(MobileQQ.sMobileQQ.peekAppRuntime());
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(a16.f(), a16.e());
        if (coerceAtLeast > config.d()) {
            f17 = config.d() / coerceAtLeast;
            f16 = (int) (a16.f() * f17);
            e16 = (int) (a16.e() * f17);
        } else {
            f16 = a16.f();
            e16 = a16.e();
            f17 = 1.0f;
        }
        VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
        videoConverterConfig.destWidth = f16;
        videoConverterConfig.destHeight = e16;
        videoConverterConfig.scaleRate = f17;
        if (a16.d() > 0 && config.c() > 0 && a16.d() < config.c()) {
            c16 = a16.d();
        } else {
            c16 = config.c();
        }
        videoConverterConfig.videoFrameRate = c16;
        float b16 = a16.b() / 1000;
        int i16 = f16 * e16;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((long) (videoConverterConfig.videoFrameRate * i16 * config.b()), a16.a());
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtMost, config.a());
        if (((float) coerceAtMost2) * b16 > ((float) config.e())) {
            coerceIn = RangesKt___RangesKt.coerceIn(config.e() / ((videoConverterConfig.videoFrameRate * i16) * b16), config.g(), config.b());
            coerceIn2 = RangesKt___RangesKt.coerceIn((long) (i16 * videoConverterConfig.videoFrameRate * coerceIn), config.f(), config.a());
            i3 = (int) coerceIn2;
        } else {
            i3 = (int) coerceAtMost2;
        }
        videoConverterConfig.videoBitRate = i3;
        return new Pair<>(videoConverterConfig, Float.valueOf(b16));
    }

    public final boolean b(@Nullable a.C9706a videoInfo, @Nullable C9606a config) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) videoInfo, (Object) config)).booleanValue();
        }
        if (videoInfo != null && config != null) {
            if (videoInfo.c() * 8 > config.e()) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicCompress_VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + videoInfo.c());
                }
                return true;
            }
            if (videoInfo.a() < config.f()) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicCompress_VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + videoInfo.a() + ", minBitRate = " + config.f());
                }
                return false;
            }
            if (videoInfo.a() > config.a()) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicCompress_VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + videoInfo.a() + ", maxBitRate = " + config.a());
                }
                return true;
            }
            if (videoInfo.d() > 0) {
                i3 = videoInfo.d();
            } else {
                i3 = 30;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PicCompress_VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i3);
            }
            if (videoInfo.a() > videoInfo.f() * videoInfo.e() * i3 * config.b() * 1.2d) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicCompress_VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensity. bitRate = " + videoInfo.a() + ", width * height * videoFps * maxDensity * 1.2 = " + (videoInfo.f() * videoInfo.e() * i3 * config.b() * 1.2d));
                }
                return true;
            }
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("PicCompress_VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensity. bitRate = " + videoInfo.a() + ", width * height * videoFps * maxDensity * 1.2 = " + (videoInfo.f() * videoInfo.e() * i3 * config.b() * 1.2d));
            return false;
        }
        QLog.e("PicCompress_VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
        return false;
    }
}
