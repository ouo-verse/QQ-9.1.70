package com.tencent.mobileqq.zplan.meme.animation2D;

import android.graphics.Bitmap;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPEncoder;
import com.tencent.zplan.meme.Meme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000eB3\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DSharppEncoder;", "Lcom/tencent/mobileqq/zplan/meme/animation2D/e;", "", "Lkotlin/Pair;", "", "i", "width", "height", "frameCount", "Lcom/tencent/sharpP/SharpPEncoder$SharpPEncCreateParam;", "g", "Landroid/graphics/Bitmap;", "frameBitmap", "frameIndex", "a", "", "pngPath", "encode", "c", "", "d", "", "b", "I", "getFrameRate", "()I", "frameRate", "", UserInfo.SEX_FEMALE, "getEstimateCompressRate", "()F", "estimateCompressRate", "Lcom/tencent/sharpP/SharpPEncoder;", "Lkotlin/Lazy;", h.F, "()Lcom/tencent/sharpP/SharpPEncoder;", "realEncoder", "J", "nativeHandle", "e", "Lcom/tencent/sharpP/SharpPEncoder$SharpPEncCreateParam;", "createParams", "", "f", "[I", "qpArray", "allFrameCount", "<init>", "(IIIIF)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class Anim2DSharppEncoder implements e {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f333909h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int frameRate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float estimateCompressRate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy realEncoder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long nativeHandle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SharpPEncoder.SharpPEncCreateParam createParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int[] qpArray;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DSharppEncoder$a;", "", "", "b", "c", "", "SO_NAME", "Ljava/lang/String;", "TAG", "soLoaded", "Z", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DSharppEncoder$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return Anim2DSharppEncoder.f333909h;
        }

        public final boolean c() {
            if (Anim2DSharppEncoder.f333909h) {
                return true;
            }
            Anim2DSharppEncoder.f333909h = com.tencent.zplan.common.soloader.c.INSTANCE.d("SharpPEnc");
            QLog.i("Anim2DSharppEncoder", 1, "load sharpP so, success:" + Anim2DSharppEncoder.f333909h);
            return Anim2DSharppEncoder.f333909h;
        }

        Companion() {
        }
    }

    public Anim2DSharppEncoder(int i3, int i16, int i17, int i18, float f16) {
        Lazy lazy;
        this.frameRate = i18;
        this.estimateCompressRate = f16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SharpPEncoder>() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DSharppEncoder$realEncoder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharpPEncoder invoke() {
                return new SharpPEncoder();
            }
        });
        this.realEncoder = lazy;
        this.qpArray = new int[27];
        Companion companion = INSTANCE;
        companion.c();
        if (companion.b()) {
            this.createParams = g(i3, i16, i17);
            this.nativeHandle = h().startEncode(this.createParams);
        }
    }

    private final SharpPEncoder.SharpPEncCreateParam g(int width, int height, int frameCount) {
        SharpPEncoder.SharpPEncCreateParam sharpPEncCreateParam = new SharpPEncoder.SharpPEncCreateParam();
        sharpPEncCreateParam.width = width;
        sharpPEncCreateParam.height = height;
        sharpPEncCreateParam.layer_num = 1;
        sharpPEncCreateParam.level = 0;
        sharpPEncCreateParam.image_mode = 4;
        sharpPEncCreateParam.frame_count = 0;
        sharpPEncCreateParam.thread_num = 1;
        sharpPEncCreateParam.appid = 935116461L;
        if (frameCount <= 0) {
            frameCount = Meme.f385754h.k().getMaximumFrameCount();
        }
        sharpPEncCreateParam.pStreamData = new byte[(int) (width * height * 4 * frameCount * this.estimateCompressRate)];
        return sharpPEncCreateParam;
    }

    private final SharpPEncoder h() {
        return (SharpPEncoder) this.realEncoder.getValue();
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public Pair<Long, Integer> a(Bitmap frameBitmap, int frameIndex) {
        Intrinsics.checkNotNullParameter(frameBitmap, "frameBitmap");
        if (!INSTANCE.b()) {
            return new Pair<>(0L, -18011);
        }
        this.qpArray[0] = Meme.f385754h.k().getSharpPConfig().getQualityParameter();
        SharpPEncoder.SharpPInFrame sharpPInFrame = new SharpPEncoder.SharpPInFrame();
        sharpPInFrame.pData = d.f333935a.a(frameBitmap);
        sharpPInFrame.fmt = 3;
        sharpPInFrame.delayTime = this.frameRate;
        return i(h().encode(this.nativeHandle, sharpPInFrame, this.qpArray, frameIndex));
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public void b() {
        SharpPEncoder.SharpPEncCreateParam sharpPEncCreateParam = this.createParams;
        if (sharpPEncCreateParam == null) {
            return;
        }
        sharpPEncCreateParam.pStreamData = null;
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public int c() {
        if (!INSTANCE.b()) {
            return -18011;
        }
        h().closeEncode(this.nativeHandle);
        return 0;
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public byte[] d() {
        SharpPEncoder.SharpPEncCreateParam sharpPEncCreateParam = this.createParams;
        if (sharpPEncCreateParam != null) {
            return sharpPEncCreateParam.pStreamData;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.meme.animation2D.e
    public Pair<Long, Integer> encode(String pngPath) {
        Intrinsics.checkNotNullParameter(pngPath, "pngPath");
        return new Pair<>(0L, 0);
    }

    private final Pair<Long, Integer> i(long j3) {
        return new Pair<>(Long.valueOf(j3 & (-1)), Integer.valueOf((int) ((j3 >> 32) & (-1))));
    }
}
