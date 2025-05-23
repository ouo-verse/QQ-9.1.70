package com.tencent.videocut.utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Size;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/videocut/utils/l;", "", "Landroid/media/MediaCodecInfo;", "codecInfo", "", "mime", "", "c", "b", "width", "height", "", "d", "Landroid/util/Size;", "a", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f384250a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9363);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f384250a = new l();
        }
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    private final int b(MediaCodecInfo codecInfo, String mime) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (codecInfo != null && (capabilitiesForType = codecInfo.getCapabilitiesForType(mime)) != null && (videoCapabilities = capabilitiesForType.getVideoCapabilities()) != null) {
            return videoCapabilities.getHeightAlignment();
        }
        return 16;
    }

    private final int c(MediaCodecInfo codecInfo, String mime) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (codecInfo != null && (capabilitiesForType = codecInfo.getCapabilitiesForType(mime)) != null && (videoCapabilities = capabilitiesForType.getVideoCapabilities()) != null) {
            return videoCapabilities.getWidthAlignment();
        }
        return 16;
    }

    private final boolean d(MediaCodecInfo codecInfo, String mime, int width, int height) {
        if (codecInfo != null) {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfo.getCapabilitiesForType(mime);
            Intrinsics.checkNotNullExpressionValue(capabilitiesForType, "codecInfo.getCapabilitie\u2026           mime\n        )");
            if (capabilitiesForType.getVideoCapabilities().isSizeSupported(width, height)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Size a(int width, int height, @NotNull String mime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Size) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(width), Integer.valueOf(height), mime);
        }
        Intrinsics.checkNotNullParameter(mime, "mime");
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        int i3 = 0;
        while (i3 < codecCount && mediaCodecInfo == null) {
            MediaCodecInfo info = MediaCodecList.getCodecInfoAt(i3);
            Intrinsics.checkNotNullExpressionValue(info, "info");
            if (info.isEncoder()) {
                String[] supportedTypes = info.getSupportedTypes();
                boolean z16 = false;
                for (int i16 = 0; i16 < supportedTypes.length && !z16; i16++) {
                    if (Intrinsics.areEqual(supportedTypes[i16], mime)) {
                        z16 = true;
                    }
                }
                if (z16) {
                    i3++;
                    mediaCodecInfo = info;
                }
            }
            i3++;
        }
        int c16 = c(mediaCodecInfo, mime);
        int b16 = b(mediaCodecInfo, mime);
        double d16 = width;
        double d17 = c16;
        int ceil = (int) (Math.ceil(d16 / d17) * d17);
        int ceil2 = (int) (((float) Math.ceil(height / r1)) * b16);
        if (!d(mediaCodecInfo, mime, ceil, ceil2)) {
            double d18 = 16;
            ceil = (int) (Math.ceil(d16 / d18) * d18);
            ceil2 = (int) (Math.ceil(height / d18) * d18);
        }
        return new Size(ceil, ceil2);
    }
}
