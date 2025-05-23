package com.tencent.zplan.meme.encoder.sharpp;

import android.graphics.Bitmap;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sharpP.SharpPEncoder;
import com.tencent.zplan.common.soloader.c;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_SHARPP_ENCODE_FAIL;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.encoder.a;
import com.tencent.zplan.meme.f;
import com.tencent.zplan.meme.model.BusinessConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 D2\u00020\u0001:\u0001\u0015B'\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010>\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010A\u001a\u00020\u0002\u00a2\u0006\u0004\bB\u0010CJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\b*\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001dR\u001b\u0010,\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b'\u0010+R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00110-j\b\u0012\u0004\u0012\u00020\u0011`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001dR\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010\u001aR\u0014\u0010A\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010\u001a\u00a8\u0006E"}, d2 = {"Lcom/tencent/zplan/meme/encoder/sharpp/MemeSharpPEncoder;", "Lcom/tencent/zplan/meme/encoder/a;", "", "width", "height", "Lcom/tencent/sharpP/SharpPEncoder$SharpPEncCreateParam;", "f", "", "Lkotlin/Pair;", h.F, "", "init", "portraitId", "", "pixels", "", "b", "", "outputFilePath", "frameTime", "Lcom/tencent/zplan/meme/action/ActionStatus;", "a", "", "getFrames", "getFrameCount", "close", "I", "frameCount", "c", "J", "nativeHandle", "d", "Lcom/tencent/sharpP/SharpPEncoder$SharpPEncCreateParam;", "createParams", "", "e", "[I", "qpArray", "encodeState", "g", "encodeBufferSize", "Lcom/tencent/sharpP/SharpPEncoder;", "Lkotlin/Lazy;", "()Lcom/tencent/sharpP/SharpPEncoder;", "realEncoder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "framePathList", "j", "encodeTimeStart", "", "k", UserInfo.SEX_FEMALE, "estimateCompressRate", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "l", "Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "tempFilePath", DomainData.DOMAIN_NAME, "o", "totalFrame", "<init>", "(Lcom/tencent/zplan/meme/model/BusinessConfig;Ljava/lang/String;II)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeSharpPEncoder implements com.tencent.zplan.meme.encoder.a {

    /* renamed from: p, reason: collision with root package name */
    private static volatile boolean f385848p;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int frameCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long nativeHandle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private SharpPEncoder.SharpPEncCreateParam createParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int[] qpArray;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int encodeState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long encodeBufferSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy realEncoder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> framePathList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long encodeTimeStart;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final float estimateCompressRate;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final BusinessConfig config;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String tempFilePath;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int frameTime;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int totalFrame;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/zplan/meme/encoder/sharpp/MemeSharpPEncoder$a;", "", "", "b", "c", "", "SO_NAME", "Ljava/lang/String;", "TAG", "soLoaded", "Z", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.encoder.sharpp.MemeSharpPEncoder$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return MemeSharpPEncoder.f385848p;
        }

        public final synchronized boolean c() {
            if (!MemeSharpPEncoder.f385848p) {
                MemeSharpPEncoder.f385848p = c.INSTANCE.b("SharpPEnc");
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeSharpPEncoder]", 1, "load sharpP so, success:" + MemeSharpPEncoder.f385848p, null, 8, null);
                }
                return MemeSharpPEncoder.f385848p;
            }
            return true;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MemeSharpPEncoder(@NotNull BusinessConfig config, @NotNull String tempFilePath, int i3, int i16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        this.config = config;
        this.tempFilePath = tempFilePath;
        this.frameTime = i3;
        this.totalFrame = i16;
        this.qpArray = new int[27];
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SharpPEncoder>() { // from class: com.tencent.zplan.meme.encoder.sharpp.MemeSharpPEncoder$realEncoder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SharpPEncoder invoke() {
                return new SharpPEncoder();
            }
        });
        this.realEncoder = lazy;
        this.framePathList = new ArrayList<>();
        this.estimateCompressRate = Meme.f385754h.k().getSharpPConfig().getEstimateCompressRatePercent() / 100;
    }

    private final SharpPEncoder.SharpPEncCreateParam f(int width, int height) {
        SharpPEncoder.SharpPEncCreateParam sharpPEncCreateParam = new SharpPEncoder.SharpPEncCreateParam();
        sharpPEncCreateParam.width = width;
        sharpPEncCreateParam.height = height;
        sharpPEncCreateParam.layer_num = 1;
        sharpPEncCreateParam.level = 0;
        sharpPEncCreateParam.image_mode = 4;
        sharpPEncCreateParam.frame_count = 0;
        sharpPEncCreateParam.thread_num = 1;
        sharpPEncCreateParam.appid = 935116461L;
        int i3 = this.totalFrame;
        if (i3 <= 0) {
            i3 = Meme.f385754h.k().getMaximumFrameCount();
        }
        sharpPEncCreateParam.pStreamData = new byte[(int) (width * height * 4 * i3 * this.estimateCompressRate)];
        return sharpPEncCreateParam;
    }

    private final SharpPEncoder g() {
        return (SharpPEncoder) this.realEncoder.getValue();
    }

    private final Pair<Long, Integer> h(long j3) {
        return new Pair<>(Long.valueOf(j3 & (-1)), Integer.valueOf((int) ((j3 >> 32) & (-1))));
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public ActionStatus a(int portraitId, @NotNull String outputFilePath, int frameTime) {
        ActionStatus actionStatus;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
        if (!INSTANCE.b()) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.b(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeSharpPEncoder]", 1, "encode fail, so not ready", null, 8, null);
            }
            return ERROR_SHARPP_ENCODE_FAIL.INSTANCE;
        }
        if (this.createParams != null && this.encodeState == 0 && this.encodeBufferSize != 0) {
            g().closeEncode(this.nativeHandle);
            String str = outputFilePath + util.base64_pad_url + System.nanoTime();
            try {
                com.tencent.zplan.common.utils.c.f385288a.c(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                try {
                    SharpPEncoder.SharpPEncCreateParam sharpPEncCreateParam = this.createParams;
                    if (sharpPEncCreateParam != null) {
                        bArr = sharpPEncCreateParam.pStreamData;
                    } else {
                        bArr = null;
                    }
                    fileOutputStream.write(bArr, 0, (int) this.encodeBufferSize);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                } finally {
                }
            } catch (Throwable th5) {
                d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    a17.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeSharpPEncoder]", 1, "encode to " + outputFilePath + " exception", th5);
                }
            }
            com.tencent.zplan.common.utils.c cVar = com.tencent.zplan.common.utils.c.f385288a;
            long i3 = cVar.i(str);
            if (i3 > 0 && cVar.j(str, outputFilePath)) {
                actionStatus = RECORD_COMPLETE.INSTANCE;
            } else {
                actionStatus = ERROR_SHARPP_ENCODE_FAIL.INSTANCE;
            }
            int frameCount = getFrameCount();
            d a18 = LogUtil.f385285b.a();
            if (a18 != null) {
                d.a.c(a18, "[zplan][MemePlayer-SDK][MemeEncoder][MemeSharpPEncoder]", 1, "assemble to " + outputFilePath + ", result:" + actionStatus + ", fileSize:" + i3 + ", frameCount:" + frameCount + ", costTime:" + (Meme.f385754h.i() - this.encodeTimeStart), null, 8, null);
            }
            return actionStatus;
        }
        d a19 = LogUtil.f385285b.a();
        if (a19 != null) {
            d.a.b(a19, "[zplan][MemePlayer-SDK][MemeEncoder][MemeSharpPEncoder]", 1, "encode fail, encodeState:" + this.encodeState + ", encodeBufferSize:" + this.encodeBufferSize, null, 8, null);
        }
        return ERROR_SHARPP_ENCODE_FAIL.INSTANCE;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public boolean b(int portraitId, @NotNull byte[] pixels, int width, int height) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        if (!INSTANCE.b()) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeSharpPEncoder]", 1, "addFrame fail, so not ready", null, 8, null);
            }
            return false;
        }
        if (this.nativeHandle == 0) {
            this.createParams = f(width, height);
            this.nativeHandle = g().startEncode(this.createParams);
            this.encodeTimeStart = Meme.f385754h.i();
        }
        SharpPEncoder.SharpPInFrame sharpPInFrame = new SharpPEncoder.SharpPInFrame();
        sharpPInFrame.pData = pixels;
        sharpPInFrame.fmt = 3;
        sharpPInFrame.delayTime = this.frameTime;
        this.qpArray[0] = Meme.f385754h.k().getSharpPConfig().getQualityParameter();
        Pair<Long, Integer> h16 = h(g().encode(this.nativeHandle, sharpPInFrame, this.qpArray, this.frameCount));
        long longValue = h16.component1().longValue();
        int intValue = h16.component2().intValue();
        this.encodeState = intValue;
        d a17 = LogUtil.f385285b.a();
        if (a17 != null) {
            d.a.c(a17, "[zplan][MemePlayer-SDK][MemeEncoder][MemeSharpPEncoder]", 1, "addFrame index:" + this.frameCount + ", errCode:" + intValue + ", currFrameLength:" + longValue + ", totalFrameLength:" + this.encodeBufferSize + ", frameTime:" + this.frameTime, null, 8, null);
        }
        if (intValue == 0 && longValue > 0) {
            this.encodeBufferSize += longValue;
            this.frameCount++;
        }
        if (!this.config.getSaveEachFrame2File()) {
            if (intValue != 0) {
                return false;
            }
            return true;
        }
        BusinessConfig.FrameType frameType = this.config.getFrameType();
        Bitmap bitmap = null;
        try {
            try {
                bitmap = a.Companion.b(com.tencent.zplan.meme.encoder.a.INSTANCE, pixels, width, height, null, 4, null);
                String str = this.tempFilePath + File.separator + System.nanoTime() + frameType.suffix();
                int i3 = a.f385864a[frameType.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        f.d(bitmap, new File(str));
                    }
                } else {
                    f.e(bitmap, 100, str);
                }
                this.framePathList.add(str);
                if (intValue != 0) {
                    return false;
                }
                return true;
            } catch (OutOfMemoryError e16) {
                d a18 = LogUtil.f385285b.a();
                if (a18 != null) {
                    a18.e("[zplan][MemePlayer-SDK][MemeEncoder][MemeSharpPEncoder]", 1, "addFrame OOM", e16);
                }
                System.gc();
                throw e16;
            }
        } finally {
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public boolean c() {
        return a.C10067a.b(this);
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void close() {
        SharpPEncoder.SharpPEncCreateParam sharpPEncCreateParam = this.createParams;
        if (sharpPEncCreateParam != null) {
            sharpPEncCreateParam.pStreamData = null;
        }
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public int getFrameCount() {
        return this.frameCount;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public List<String> getFrames() {
        List<String> list;
        list = CollectionsKt___CollectionsKt.toList(this.framePathList);
        return list;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void init() {
        a.C10067a.c(this);
        INSTANCE.c();
        d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeSharpPEncoder]", 1, "estimateCompressRate:" + this.estimateCompressRate, null, 8, null);
        }
    }
}
