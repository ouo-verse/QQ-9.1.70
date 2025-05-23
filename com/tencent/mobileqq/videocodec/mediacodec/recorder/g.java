package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/g;", "", "", "sampleType", "Landroid/media/MediaFormat;", "format", "", "b", "Ljava/nio/ByteBuffer;", "byteBuf", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "writeSampleData", "Landroid/media/MediaMuxer;", "a", "release", "VideoCodec_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface g {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/g$a;", "", "<init>", "()V", "VideoCodec_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.videocodec.mediacodec.recorder.g$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f312651a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41976);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f312651a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(41982), (Class<?>) g.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f312651a;
        }
    }

    @NotNull
    MediaMuxer a();

    void b(int sampleType, @NotNull MediaFormat format);

    void release();

    void writeSampleData(int sampleType, @NotNull ByteBuffer byteBuf, @NotNull MediaCodec.BufferInfo bufferInfo);
}
