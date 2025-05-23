package com.tencent.zplan;

import android.util.Log;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.zplan.encode.EncodeConfig;
import com.tencent.zplan.encode.EncodeResult;
import com.tencent.zplan.encode.EncodeType;
import com.tencent.zplan.encode.IEncoder;
import com.tencent.zplan.encode.Mp4SynthesizerTask;
import com.tencent.zplan.encode.SoftwareEncoder;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import ox4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00072\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b(\u0010)J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0004J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0019\u001a\u00020\u0004J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001dR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\"R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/zplan/a;", "", "Lcom/tencent/zplan/encode/a;", DownloadInfo.spKey_Config, "", "type", "", "g", "", "b", "k", "Lcom/tencent/zplan/encode/IEncoder;", "f", "i", "index", "", "pixels", "sourceWidth", "sourceHeight", "a", "totalFrame", "Lcom/tencent/zplan/encode/EncodeResult;", "j", "", "e", "d", "", "c", "()Ljava/lang/Long;", "Lcom/tencent/zplan/encode/a;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialize", "Ljava/io/File;", "Ljava/io/File;", "file", "I", "Lcom/tencent/zplan/encode/IEncoder;", "encoder", "encodeMode", "<init>", "()V", "mp4_encoder_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private EncodeConfig config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private File file;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IEncoder encoder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int encodeMode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean initialize = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int totalFrame = -1;

    private final void b(EncodeConfig config) {
        boolean z16;
        boolean isBlank;
        Mp4SynthesizerTask.Companion companion = Mp4SynthesizerTask.INSTANCE;
        String f16 = companion.f();
        int i3 = 0;
        if (f16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(f16);
            if (!isBlank) {
                z16 = false;
                if (!z16 && !Intrinsics.areEqual(companion.f(), "1.0.1")) {
                    i3 = (config.getEncodeMode() == 3 || Intrinsics.areEqual(companion.e(), Boolean.TRUE)) ? config.getEncodeMode() : 1;
                }
                this.encodeMode = i3;
            }
        }
        z16 = true;
        if (!z16) {
            if (config.getEncodeMode() == 3) {
            }
        }
        this.encodeMode = i3;
    }

    private final boolean g(EncodeConfig config, int type) {
        IEncoder f16;
        Log.i("EncodeManager", "start initEncoder:" + type + ", " + config);
        if (type == EncodeType.SOFTWARE.ordinal()) {
            f16 = new SoftwareEncoder();
        } else {
            f16 = f();
        }
        this.encoder = f16;
        if (f16 == null) {
            return false;
        }
        return f16.a(config);
    }

    public final boolean a(int index, byte[] pixels, int sourceWidth, int sourceHeight) {
        File file;
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        IEncoder iEncoder = this.encoder;
        boolean z16 = false;
        boolean c16 = iEncoder == null ? false : iEncoder.c(this.encodeMode, index, pixels, sourceWidth, sourceHeight);
        EncodeConfig encodeConfig = this.config;
        if (encodeConfig != null && encodeConfig.getIsDebugger()) {
            z16 = true;
        }
        if (z16 && (file = this.file) != null) {
            FilesKt__FileReadWriteKt.appendBytes(file, pixels);
        }
        return c16;
    }

    public final Long c() {
        EncodeConfig encodeConfig = this.config;
        int encodeMode = encodeConfig == null ? 0 : encodeConfig.getEncodeMode();
        IEncoder iEncoder = this.encoder;
        if (iEncoder == null) {
            return null;
        }
        return iEncoder.d(encodeMode);
    }

    /* renamed from: d, reason: from getter */
    public final int getEncodeMode() {
        return this.encodeMode;
    }

    public final String e() {
        IEncoder iEncoder = this.encoder;
        if (iEncoder == null) {
            return null;
        }
        return iEncoder.getTypeName();
    }

    public final void i(EncodeConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Log.i("EncodeManager", "start initialize encoder:" + this.encoder + ", " + config);
        if (this.initialize.compareAndSet(false, true)) {
            this.config = config;
            if (!h(this, config, 0, 2, null) && config.getType() == EncodeType.SOFTWARE.ordinal()) {
                g(config, EncodeType.HARDWARE.ordinal());
            }
            if (config.getIsDebugger()) {
                if (config.getTempPath().length() > 0) {
                    File file = new File(config.getTempPath());
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.file = new File(file, "rgba.0");
                }
            }
            b(config);
            Log.i("EncodeManager", "initialize encoder:" + this.encoder + ", " + config);
        }
    }

    public final EncodeResult j(int totalFrame) {
        this.totalFrame = totalFrame;
        IEncoder iEncoder = this.encoder;
        EncodeResult e16 = iEncoder == null ? null : iEncoder.e(this.encodeMode, totalFrame);
        if (e16 == null) {
            e16 = EncodeResult.UN_KNOW;
        }
        IEncoder iEncoder2 = this.encoder;
        if (iEncoder2 != null) {
            iEncoder2.b(this.encodeMode);
        }
        k();
        return e16;
    }

    private final IEncoder f() {
        try {
            b.Companion companion = ox4.b.INSTANCE;
            Object newInstance = ox4.b.class.newInstance();
            if (newInstance instanceof IEncoder) {
                return (IEncoder) newInstance;
            }
            return null;
        } catch (Throwable th5) {
            Log.e("EncodeManager", "getHardwareEncoder throw t:", th5);
            return null;
        }
    }

    private final void k() {
        this.totalFrame = -1;
    }

    static /* synthetic */ boolean h(a aVar, EncodeConfig encodeConfig, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = encodeConfig.getType();
        }
        return aVar.g(encodeConfig, i3);
    }
}
