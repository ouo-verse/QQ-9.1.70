package com.tencent.qqnt.util.video;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/util/video/a;", "", "", "inputPath", "Lcom/tencent/qqnt/util/video/a$a;", "a", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f362991a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\u0016\u0010\nR\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/util/video/a$a;", "", "", "toString", "", "a", "I", "f", "()I", "l", "(I)V", "width", "b", "e", "k", "height", "c", "d", "j", "frameRate", "g", "bitRate", h.F, "duration", "", "J", "()J", "i", "(J)V", "fileSize", "<init>", "()V", "nt_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.util.video.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9706a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int width;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int height;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int frameRate;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int bitRate;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int duration;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long fileSize;

        public C9706a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.frameRate = 30;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.bitRate;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.duration;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
            }
            return this.fileSize;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.frameRate;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.height;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.width;
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, i3);
            } else {
                this.bitRate = i3;
            }
        }

        public final void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
            } else {
                this.duration = i3;
            }
        }

        public final void i(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, j3);
            } else {
                this.fileSize = j3;
            }
        }

        public final void j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.frameRate = i3;
            }
        }

        public final void k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.height = i3;
            }
        }

        public final void l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.width = i3;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "w: " + this.width + ", h: " + this.height + ", fps: " + this.frameRate + ", bps: " + this.bitRate + ", dur: " + this.duration + " ms";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f362991a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final C9706a a(@NotNull String inputPath) {
        boolean startsWith$default;
        int roundToInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (C9706a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) inputPath);
        }
        Intrinsics.checkNotNullParameter(inputPath, "inputPath");
        C9706a c9706a = new C9706a();
        c9706a.i(new File(inputPath).length());
        MediaExtractor mediaExtractor = new MediaExtractor();
        int i3 = 0;
        try {
            try {
                mediaExtractor.setDataSource(inputPath);
                int trackCount = mediaExtractor.getTrackCount();
                int i16 = 0;
                while (i16 < trackCount) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i16);
                    Intrinsics.checkNotNullExpressionValue(trackFormat, "extractor.getTrackFormat(i)");
                    String string = trackFormat.getString("mime");
                    Intrinsics.checkNotNull(string);
                    int i17 = trackCount;
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(string, "video/", false, 2, null);
                    if (startsWith$default) {
                        if (trackFormat.containsKey("width")) {
                            c9706a.l(trackFormat.getInteger("width"));
                        }
                        if (trackFormat.containsKey("height")) {
                            c9706a.k(trackFormat.getInteger("height"));
                        }
                        if (trackFormat.containsKey("bitrate")) {
                            c9706a.g(trackFormat.getInteger("bitrate"));
                        }
                        if (trackFormat.containsKey("frame-rate")) {
                            c9706a.j(trackFormat.getInteger("frame-rate"));
                        }
                        if (trackFormat.containsKey("durationUs")) {
                            roundToInt = MathKt__MathJVMKt.roundToInt(((float) trackFormat.getLong("durationUs")) / 1000);
                            c9706a.h(roundToInt);
                        }
                    }
                    i16++;
                    trackCount = i17;
                }
            } catch (IOException e16) {
                QLog.e("VideoUtil", 1, "getVideoInfo fail", e16);
            } catch (IllegalArgumentException e17) {
                QLog.e("VideoUtil", 1, "getVideoInfo fail:", e17);
            }
            if (c9706a.a() == 0) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(inputPath);
                        String extractMetadata = mediaMetadataRetriever.extractMetadata(20);
                        if (extractMetadata != null) {
                            i3 = Integer.parseInt(extractMetadata);
                        }
                        c9706a.g(i3);
                    } finally {
                        mediaMetadataRetriever.release();
                    }
                } catch (Exception e18) {
                    QLog.w("VideoUtil", 1, "[getVideoInfo] fail, exc=" + e18 + ", path=" + inputPath);
                }
            }
            return c9706a;
        } finally {
            mediaExtractor.release();
        }
    }
}
