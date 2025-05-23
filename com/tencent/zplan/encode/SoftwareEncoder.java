package com.tencent.zplan.encode;

import android.util.Log;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.zplan.encode.EncodeConfig;
import com.tencent.zplan.encode.IEncoder;
import com.tencent.zplan.encode.utils.d;
import com.tencent.zplan.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J0\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\b\u0001\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0019\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010%R\u0016\u0010'\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010)R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010)R\u0014\u0010-\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010)\u00a8\u00061"}, d2 = {"Lcom/tencent/zplan/encode/SoftwareEncoder;", "Lcom/tencent/zplan/encode/IEncoder;", "", "index", "", "pixels", "", "j", "sourceWidth", "sourceHeight", "k", tl.h.F, "i", "width", "height", DomainData.DOMAIN_NAME, "l", "frameRate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/zplan/encode/a;", DownloadInfo.spKey_Config, "a", "mode", "c", "totalFrame", "Lcom/tencent/zplan/encode/EncodeResult;", "e", "", "b", "", "getTypeName", "", "d", "(I)Ljava/lang/Long;", "Lcom/tencent/zplan/encode/Mp4SynthesizerTask;", "Lcom/tencent/zplan/encode/Mp4SynthesizerTask;", "softwareEncoder", "Lcom/tencent/zplan/encode/a;", "Lcom/tencent/zplan/encode/EncodeResult;", "encodeResult", "Lcom/tencent/zplan/j;", "Lcom/tencent/zplan/j;", "encodeTimeRecorder", "diverRGBATimeRecorder", "f", "convertYuvTimeRecorder", "<init>", "()V", "g", "mp4_encoder_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public final class SoftwareEncoder implements IEncoder {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Mp4SynthesizerTask softwareEncoder;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private EncodeConfig config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private EncodeResult encodeResult = EncodeResult.UN_KNOW;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final j encodeTimeRecorder = new j();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final j diverRGBATimeRecorder = new j();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final j convertYuvTimeRecorder = new j();

    private final boolean h(final int index, final byte[] pixels, final int sourceWidth, final int sourceHeight) {
        final Mp4SynthesizerTask mp4SynthesizerTask = this.softwareEncoder;
        if (mp4SynthesizerTask == null) {
            Log.e("SoftwareEncoder", "inputFrameToSoftwareEncoder but softwareEncoder is null");
            return false;
        }
        final EncodeConfig encodeConfig = this.config;
        if (encodeConfig == null) {
            return false;
        }
        this.encodeTimeRecorder.b(new Function0<Unit>() { // from class: com.tencent.zplan.encode.SoftwareEncoder$addRGBAFrame$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int m3;
                int i3 = index;
                m3 = this.m(encodeConfig.getEncodeConfig().f385470h);
                int i16 = i3 * m3;
                Mp4SynthesizerTask mp4SynthesizerTask2 = mp4SynthesizerTask;
                byte[] bArr = pixels;
                mp4SynthesizerTask2.l(bArr, bArr.length, i16, index, sourceWidth, sourceHeight);
            }
        });
        return true;
    }

    private final boolean i(final int index, final byte[] pixels, final int sourceWidth, final int sourceHeight) {
        final Mp4SynthesizerTask mp4SynthesizerTask = this.softwareEncoder;
        if (mp4SynthesizerTask == null) {
            Log.e("SoftwareEncoder", "inputFrameToSoftwareEncoder but softwareEncoder is null");
            return false;
        }
        final EncodeConfig encodeConfig = this.config;
        if (encodeConfig == null) {
            return false;
        }
        this.encodeTimeRecorder.b(new Function0<Unit>() { // from class: com.tencent.zplan.encode.SoftwareEncoder$addRGBAFrameWithCPlusAndLibYuv$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int m3;
                int i3 = index;
                m3 = this.m(encodeConfig.getEncodeConfig().f385470h);
                int i16 = i3 * m3;
                Mp4SynthesizerTask mp4SynthesizerTask2 = mp4SynthesizerTask;
                byte[] bArr = pixels;
                mp4SynthesizerTask2.m(bArr, bArr.length, i16, index, sourceWidth, sourceHeight);
            }
        });
        return true;
    }

    private final boolean j(final int index, byte[] pixels) {
        final byte[] l3;
        final Mp4SynthesizerTask mp4SynthesizerTask = this.softwareEncoder;
        if (mp4SynthesizerTask == null) {
            Log.e("SoftwareEncoder", "inputFrameToSoftwareEncoder but softwareEncoder is null");
            return false;
        }
        final EncodeConfig encodeConfig = this.config;
        if (encodeConfig == null || (l3 = l(pixels, encodeConfig.getWidth(), encodeConfig.getHeight())) == null) {
            return false;
        }
        this.encodeTimeRecorder.b(new Function0<Unit>() { // from class: com.tencent.zplan.encode.SoftwareEncoder$addRGBAFrameWithJava$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int m3;
                int i3 = index;
                m3 = this.m(encodeConfig.getEncodeConfig().f385470h);
                int i16 = i3 * m3;
                Mp4SynthesizerTask mp4SynthesizerTask2 = mp4SynthesizerTask;
                byte[] bArr = l3;
                mp4SynthesizerTask2.j(bArr, bArr.length, i16, index);
            }
        });
        return true;
    }

    private final boolean k(final int index, final byte[] pixels, final int sourceWidth, final int sourceHeight) {
        final Mp4SynthesizerTask mp4SynthesizerTask = this.softwareEncoder;
        if (mp4SynthesizerTask == null) {
            Log.e("SoftwareEncoder", "inputFrameToSoftwareEncoder but softwareEncoder is null");
            return false;
        }
        final EncodeConfig encodeConfig = this.config;
        if (encodeConfig == null) {
            return false;
        }
        this.encodeTimeRecorder.b(new Function0<Unit>() { // from class: com.tencent.zplan.encode.SoftwareEncoder$addRGBAFrameWithNeon$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int m3;
                int i3 = index;
                m3 = this.m(encodeConfig.getEncodeConfig().f385470h);
                int i16 = i3 * m3;
                Mp4SynthesizerTask mp4SynthesizerTask2 = mp4SynthesizerTask;
                byte[] bArr = pixels;
                mp4SynthesizerTask2.n(bArr, bArr.length, i16, index, sourceWidth, sourceHeight);
            }
        });
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final byte[] l(final byte[] pixels, final int width, final int height) {
        final EncodeConfig.Config encodeConfig;
        EncodeConfig encodeConfig2 = this.config;
        if (encodeConfig2 == null || (encodeConfig = encodeConfig2.getEncodeConfig()) == null) {
            return null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        this.diverRGBATimeRecorder.b(new Function0<Unit>() { // from class: com.tencent.zplan.encode.SoftwareEncoder$getFormatNV12Data$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, byte[]] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                objectRef.element = com.tencent.zplan.encode.utils.e.f385508a.a(pixels, height, width);
            }
        });
        if (((byte[]) objectRef.element) == null) {
            return null;
        }
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        this.convertYuvTimeRecorder.b(new Function0<Unit>() { // from class: com.tencent.zplan.encode.SoftwareEncoder$getFormatNV12Data$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, byte[]] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                objectRef2.element = com.tencent.zplan.encode.utils.d.d(encodeConfig, objectRef.element, new d.i(3, 0, 1, 2), 1);
            }
        });
        return (byte[]) objectRef2.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m(int frameRate) {
        return (int) (1000.0f / frameRate);
    }

    private final int n(int width, int height) {
        return width * height * 4 * 2;
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public boolean a(EncodeConfig config) {
        boolean endsWith;
        String stringPlus;
        String str;
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        try {
            int width = config.getWidth() * 2;
            config.getEncodeConfig().f385466d = width;
            config.getEncodeConfig().f385468f = width;
            com.tencent.zplan.encode.utils.d.f(config.getEncodeConfig());
            com.tencent.zplan.encode.utils.e.f385508a.d(n(width, config.getHeight()));
            endsWith = StringsKt__StringsJVMKt.endsWith(config.getSavaPath(), ".mp4", true);
            if (endsWith) {
                stringPlus = StringsKt__StringsJVMKt.replace$default(config.getSavaPath(), ".mp4", "_temp.mp4", false, 4, (Object) null);
            } else {
                stringPlus = Intrinsics.stringPlus(config.getSavaPath(), ".mp4");
            }
            String str2 = stringPlus;
            com.tencent.zplan.encode.utils.b.f385478a.a(str2);
            int height = config.getHeight();
            String savaPath = config.getSavaPath();
            int i3 = config.getEncodeConfig().f385470h;
            if (config.getIsDebugger()) {
                str = Intrinsics.stringPlus(config.getTempPath(), "/yuv_c.txt");
            } else {
                str = "";
            }
            this.softwareEncoder = new Mp4SynthesizerTask(width, height, savaPath, i3, str, config.getIsDebugger(), config.getEncodeConfig().getEnableBFrame(), str2);
            return true;
        } catch (UnsatisfiedLinkError e16) {
            Log.w("SoftwareEncoder", Intrinsics.stringPlus("prepareSoftwareEncoder ", e16));
            return false;
        }
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public void b(int mode) {
        long f16;
        com.tencent.zplan.encode.utils.e.f385508a.b();
        com.tencent.zplan.encode.utils.d.c();
        if (mode == 0) {
            f16 = this.convertYuvTimeRecorder.getCostTime();
        } else {
            Mp4SynthesizerTask mp4SynthesizerTask = this.softwareEncoder;
            f16 = (mp4SynthesizerTask == null ? 0L : mp4SynthesizerTask.f()) * 1000;
        }
        this.convertYuvTimeRecorder.c(f16);
        this.softwareEncoder = null;
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public boolean c(int mode, int index, byte[] pixels, int sourceWidth, int sourceHeight) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        if (mode == 0) {
            return j(index, pixels);
        }
        if (mode == 1) {
            return h(index, pixels, sourceWidth, sourceHeight);
        }
        if (mode == 2) {
            return i(index, pixels, sourceWidth, sourceHeight);
        }
        if (mode != 3) {
            return false;
        }
        return k(index, pixels, sourceWidth, sourceHeight);
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public Long d(int mode) {
        return Long.valueOf(this.diverRGBATimeRecorder.getCostTime() + this.convertYuvTimeRecorder.getCostTime());
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public EncodeResult e(@IEncoder.EncodeMode int mode, int totalFrame) {
        final Mp4SynthesizerTask mp4SynthesizerTask = this.softwareEncoder;
        if (mp4SynthesizerTask != null) {
            this.encodeTimeRecorder.b(new Function0<Unit>() { // from class: com.tencent.zplan.encode.SoftwareEncoder$inputFrameEnd$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    EncodeResult encodeResult;
                    SoftwareEncoder softwareEncoder = SoftwareEncoder.this;
                    if (mp4SynthesizerTask.k()) {
                        encodeResult = EncodeResult.SUCCESS;
                    } else {
                        encodeResult = EncodeResult.ERROR;
                    }
                    softwareEncoder.encodeResult = encodeResult;
                }
            });
            EncodeConfig encodeConfig = this.config;
            if (encodeConfig != null && !com.tencent.zplan.encode.utils.b.f385478a.b(mp4SynthesizerTask.getFilePath(), encodeConfig.getSavaPath())) {
                Log.e("SoftwareEncoder", "rename failed");
                EncodeResult encodeResult = EncodeResult.UN_KNOW;
            }
        }
        return this.encodeResult;
    }

    @Override // com.tencent.zplan.encode.IEncoder
    public String getTypeName() {
        return "SoftwareEncoder";
    }
}
