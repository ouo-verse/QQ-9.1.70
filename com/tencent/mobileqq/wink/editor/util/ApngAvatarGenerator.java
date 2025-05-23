package com.tencent.mobileqq.wink.editor.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.thumb.IThumbProvider;
import com.tencent.zplan.common.soloader.p017default.InternalSoLoader;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.encoder.apng.MemeApngEncoder;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeRecordParams;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.components.TimeRange;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f*\u00016\u0018\u0000 H2\u00020\u0001:\u0002IJBA\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010)\u001a\u00020$\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010&R\u0014\u00101\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010\"R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010;\u001a\u0004\b<\u0010=R$\u0010E\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b!\u0010B\"\u0004\bC\u0010D\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator;", "Ljava/io/Closeable;", "", "k", "release", "Lkotlin/sequences/Sequence;", "", tl.h.F, "j", "close", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "d", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clipSource", "Lorg/light/lightAssetKit/components/Size;", "e", "Lorg/light/lightAssetKit/components/Size;", "getOriginalVideoSize", "()Lorg/light/lightAssetKit/components/Size;", "originalVideoSize", "Lorg/light/lightAssetKit/components/TimeRange;", "f", "Lorg/light/lightAssetKit/components/TimeRange;", "timeRange", "getOutputSize", "outputSize", "Landroid/graphics/Rect;", "i", "Landroid/graphics/Rect;", "getOutputRect", "()Landroid/graphics/Rect;", "outputRect", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "apngPath", "", BdhLogUtil.LogTag.Tag_Conn, "I", "l", "()I", "frameTime", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "D", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "thumbProvider", "E", "portraitId", UserInfo.SEX_FEMALE, "uniKey", "", "G", "Z", AudioContext.State.CLOSED, "com/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$c", "H", "Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$c;", "statisticListener", "Lcom/tencent/zplan/meme/encoder/b;", "Lkotlin/Lazy;", "p", "()Lcom/tencent/zplan/meme/encoder/b;", "memeEncodeResource", "Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$b;", "J", "Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$b;", "()Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$b;)V", "generateListener", "<init>", "(Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;Lorg/light/lightAssetKit/components/Size;Lorg/light/lightAssetKit/components/TimeRange;Lorg/light/lightAssetKit/components/Size;Landroid/graphics/Rect;Ljava/lang/String;I)V", "K", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ApngAvatarGenerator implements Closeable {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final int frameTime;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final IThumbProvider thumbProvider;

    /* renamed from: E, reason: from kotlin metadata */
    private final int portraitId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String uniKey;

    /* renamed from: G, reason: from kotlin metadata */
    private volatile boolean closed;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final c statisticListener;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy memeEncodeResource;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private b generateListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ClipSource clipSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Size originalVideoSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TimeRange timeRange;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Size outputSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect outputRect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String apngPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$a;", "", "Lorg/light/lightAssetKit/components/Size;", "outputSize", "Landroid/graphics/Rect;", "outputRect", "Landroid/graphics/Bitmap;", "input", "b", "Lkotlin/Function1;", "", "", "callback", "c", "", "DEFAULT_FRAME_TIME", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Function1 callback, int i3, LoadExtResult loadExtResult) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            w53.b.f("ApngAvatarGenerator", "load so result:" + i3 + " " + loadExtResult + " ");
            if (i3 == 0 && loadExtResult.isSucc()) {
                MemeApngEncoder.INSTANCE.e(true);
                callback.invoke(Boolean.TRUE);
            } else {
                callback.invoke(Boolean.FALSE);
            }
        }

        @Nullable
        public final Bitmap b(@NotNull Size outputSize, @NotNull Rect outputRect, @Nullable Bitmap input) {
            Intrinsics.checkNotNullParameter(outputSize, "outputSize");
            Intrinsics.checkNotNullParameter(outputRect, "outputRect");
            if (input == null) {
                return null;
            }
            Matrix matrix = new Matrix();
            float max = Math.max(outputSize.width / input.getWidth(), outputSize.height / input.getHeight());
            matrix.postScale(max, max);
            try {
                return Bitmap.createBitmap(input, outputRect.left, outputRect.top, outputRect.width(), outputRect.height(), matrix, true);
            } catch (Exception e16) {
                w53.b.d("ApngAvatarGenerator", "cropByRect fail:outputSize: " + outputSize.width + " " + outputSize.height + " outputRect: " + outputRect + " input: " + input.getWidth() + " " + input.getHeight(), e16);
                return input;
            }
        }

        public final void c(@NotNull final Function1<? super Boolean, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            w53.b.f("ApngAvatarGenerator", "generateApng load so");
            ((ISoLoaderService) QRoute.api(ISoLoaderService.class)).load(SoLoadConstants.APNG_SO, new OnLoadListener() { // from class: com.tencent.mobileqq.wink.editor.util.a
                @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
                public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                    ApngAvatarGenerator.Companion.d(Function1.this, i3, loadExtResult);
                }
            });
        }

        Companion() {
        }
    }

    public ApngAvatarGenerator(@NotNull ClipSource clipSource, @NotNull Size originalVideoSize, @NotNull TimeRange timeRange, @NotNull Size outputSize, @NotNull Rect outputRect, @NotNull String apngPath, int i3) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(clipSource, "clipSource");
        Intrinsics.checkNotNullParameter(originalVideoSize, "originalVideoSize");
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        Intrinsics.checkNotNullParameter(outputSize, "outputSize");
        Intrinsics.checkNotNullParameter(outputRect, "outputRect");
        Intrinsics.checkNotNullParameter(apngPath, "apngPath");
        this.clipSource = clipSource;
        this.originalVideoSize = originalVideoSize;
        this.timeRange = timeRange;
        this.outputSize = outputSize;
        this.outputRect = outputRect;
        this.apngPath = apngPath;
        this.frameTime = i3;
        this.thumbProvider = rd4.c.f431135f.i(clipSource, originalVideoSize);
        int nextInt = Random.INSTANCE.nextInt();
        this.portraitId = nextInt;
        this.uniKey = "wink_dynamic_avatar_" + nextInt;
        this.statisticListener = new c();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.zplan.meme.encoder.b>() { // from class: com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator$memeEncodeResource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.zplan.meme.encoder.b invoke() {
                String str;
                int i16;
                String str2;
                ApngAvatarGenerator.c cVar;
                str = ApngAvatarGenerator.this.uniKey;
                MemeRecordParams memeRecordParams = new MemeRecordParams(str, 0, 0, null, null, 0, 0, 0, 0, MODE.APNG, null, 0, false, new BusinessConfig(0, false, false, false, BusinessConfig.FrameType.PNG, 0, null, null, null, null, null, null, null, false, null, 0, null, 131055, null), "", 0, null, 105974, null);
                com.tencent.zplan.common.soloader.c.INSTANCE.e(SoLoadConstants.APNG_SO, InternalSoLoader.INSTANCE.a());
                i16 = ApngAvatarGenerator.this.portraitId;
                int frameTime = ApngAvatarGenerator.this.getFrameTime();
                str2 = ApngAvatarGenerator.this.apngPath;
                cVar = ApngAvatarGenerator.this.statisticListener;
                return new com.tencent.zplan.meme.encoder.b(memeRecordParams, i16, frameTime, -1, str2, "", null, cVar, "");
            }
        });
        this.memeEncodeResource = lazy;
    }

    private final Sequence<Long> h() {
        Sequence<Long> generateSequence;
        generateSequence = SequencesKt__SequencesKt.generateSequence(Long.valueOf(this.timeRange.startTime), (Function1<? super Long, ? extends Long>) ((Function1<? super Object, ? extends Object>) new Function1<Long, Long>() { // from class: com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator$genFrameTimes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Long l3) {
                return invoke(l3.longValue());
            }

            @Nullable
            public final Long invoke(long j3) {
                TimeRange timeRange;
                TimeRange timeRange2;
                long frameTime = j3 + (ApngAvatarGenerator.this.getFrameTime() * 1000);
                timeRange = ApngAvatarGenerator.this.timeRange;
                long j16 = timeRange.startTime;
                timeRange2 = ApngAvatarGenerator.this.timeRange;
                if (frameTime > j16 + timeRange2.duration) {
                    return null;
                }
                return Long.valueOf(frameTime);
            }
        }));
        return generateSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        Integer num;
        w53.b.f("ApngAvatarGenerator", "generateApng");
        com.tencent.zplan.meme.encoder.a encoder = p().getEncoder();
        int i3 = 0;
        for (Long l3 : h()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            long longValue = l3.longValue();
            if (this.closed) {
                w53.b.f("ApngAvatarGenerator", "generateApng closed");
                release();
                return;
            }
            b bVar = this.generateListener;
            if (bVar != null) {
                bVar.beforeCaptureFrame(i3, longValue);
            }
            Bitmap thumbAtTime = this.thumbProvider.getThumbAtTime(longValue);
            b bVar2 = this.generateListener;
            if (bVar2 != null) {
                bVar2.onCaptureFrame(i3, longValue, thumbAtTime);
            }
            if (thumbAtTime != null) {
                num = Integer.valueOf(thumbAtTime.getByteCount());
            } else {
                num = null;
            }
            w53.b.f("ApngAvatarGenerator", "generateApng on frame " + longValue + " " + num);
            Bitmap b16 = INSTANCE.b(this.outputSize, this.outputRect, thumbAtTime);
            if (b16 == null) {
                Size size = this.outputSize;
                b16 = Bitmap.createBitmap(size.width, size.height, Bitmap.Config.ARGB_8888);
            }
            b bVar3 = this.generateListener;
            if (bVar3 != null) {
                bVar3.onCropFrame(i3, longValue, b16);
            }
            if (b16 == null) {
                w53.b.c("ApngAvatarGenerator", "generateApng crop null");
                Size size2 = this.outputSize;
                b16 = Bitmap.createBitmap(size2.width, size2.height, Bitmap.Config.ARGB_8888);
                b16.eraseColor(0);
            }
            w53.b.f("ApngAvatarGenerator", "generateApng alloc and addFrame");
            ByteBuffer allocate = ByteBuffer.allocate(b16.getByteCount());
            b16.copyPixelsToBuffer(allocate);
            int i17 = this.portraitId;
            byte[] array = allocate.array();
            Intrinsics.checkNotNullExpressionValue(array, "bb.array()");
            encoder.b(i17, array, b16.getWidth(), b16.getHeight());
            b bVar4 = this.generateListener;
            if (bVar4 != null) {
                bVar4.onAddFrame(i3);
            }
            i3 = i16;
        }
        w53.b.f("ApngAvatarGenerator", "generateApng alloc and addFrame finished");
        b bVar5 = this.generateListener;
        if (bVar5 != null) {
            bVar5.beforeEncode();
        }
        encoder.a(this.portraitId, this.apngPath, this.frameTime);
        if (new File(this.apngPath).exists()) {
            b bVar6 = this.generateListener;
            if (bVar6 != null) {
                bVar6.onEncoded(this.apngPath);
                return;
            }
            return;
        }
        b bVar7 = this.generateListener;
        if (bVar7 != null) {
            bVar7.onError(new IllegalStateException("apng generate fail " + this.apngPath));
        }
    }

    private final com.tencent.zplan.meme.encoder.b p() {
        return (com.tencent.zplan.meme.encoder.b) this.memeEncodeResource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void release() {
        w53.b.f("ApngAvatarGenerator", "release");
        p().getEncoder().close();
        this.thumbProvider.release();
        this.closed = true;
        b bVar = this.generateListener;
        if (bVar != null) {
            bVar.onRelease();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        w53.b.f("ApngAvatarGenerator", "close");
        this.closed = true;
    }

    public final void j() {
        final ApngAvatarGenerator$generateApng$executeGenerateLambda$1 apngAvatarGenerator$generateApng$executeGenerateLambda$1 = new ApngAvatarGenerator$generateApng$executeGenerateLambda$1(this);
        if (!MemeApngEncoder.INSTANCE.b()) {
            INSTANCE.c(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.editor.util.ApngAvatarGenerator$generateApng$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (!z16) {
                        ApngAvatarGenerator.b generateListener = ApngAvatarGenerator.this.getGenerateListener();
                        if (generateListener != null) {
                            generateListener.onError(new IllegalStateException("load apng so fail"));
                            return;
                        }
                        return;
                    }
                    apngAvatarGenerator$generateApng$executeGenerateLambda$1.invoke();
                }
            });
        } else {
            w53.b.f("ApngAvatarGenerator", "generateApng so already loaded.");
            apngAvatarGenerator$generateApng$executeGenerateLambda$1.invoke();
        }
    }

    /* renamed from: l, reason: from getter */
    public final int getFrameTime() {
        return this.frameTime;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final b getGenerateListener() {
        return this.generateListener;
    }

    public final void q(@Nullable b bVar) {
        this.generateListener = bVar;
    }

    public /* synthetic */ ApngAvatarGenerator(ClipSource clipSource, Size size, TimeRange timeRange, Size size2, Rect rect, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(clipSource, size, timeRange, size2, rect, str, (i16 & 64) != 0 ? 100 : i3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$b;", "", "", "frameNum", "", "frameTs", "", "beforeCaptureFrame", "Landroid/graphics/Bitmap;", "frameBitmap", "onCaptureFrame", "croppedBitmap", "onCropFrame", "onAddFrame", "beforeEncode", "", "outputPath", "onEncoded", "onRelease", "", "t", "onError", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void beforeCaptureFrame(int frameNum, long frameTs);

        void beforeEncode();

        void onAddFrame(int frameNum);

        void onCaptureFrame(int frameNum, long frameTs, @Nullable Bitmap frameBitmap);

        void onCropFrame(int frameNum, long frameTs, @Nullable Bitmap croppedBitmap);

        void onEncoded(@NotNull String outputPath);

        void onError(@NotNull Throwable t16);

        void onRelease();

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public static final class a {
            public static void d(@NotNull b bVar) {
            }

            public static void b(@NotNull b bVar, int i3) {
            }

            public static void a(@NotNull b bVar, int i3, long j3) {
            }

            public static void c(@NotNull b bVar, int i3, long j3, @Nullable Bitmap bitmap) {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/wink/editor/util/ApngAvatarGenerator$c", "Lwx4/c;", "", "portraitId", "Lcom/tencent/zplan/meme/action/ActionStatus;", "status", "", "path", "realFrameCount", "", "a", "b", "c", "scriptStatisticData", "e", "totalFrameCount", "f", "", "value", "g", "()Z", "d", "(Z)V", "occurOOM", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements wx4.c {
        c() {
        }

        @Override // wx4.c
        public void a(int portraitId, @NotNull ActionStatus status, @NotNull String path, int realFrameCount) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(path, "path");
        }

        @Override // wx4.c
        public void c(int portraitId, @NotNull ActionStatus status, @NotNull String path) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(path, "path");
        }

        @Override // wx4.c
        public void e(int portraitId, @NotNull ActionStatus status, @Nullable String scriptStatisticData) {
            Intrinsics.checkNotNullParameter(status, "status");
        }

        @Override // wx4.c
        /* renamed from: g */
        public boolean getOccurOOM() {
            return false;
        }

        @Override // wx4.c
        public void b(int portraitId) {
        }

        @Override // wx4.c
        public void d(boolean z16) {
        }

        @Override // wx4.c
        public void f(int portraitId, int totalFrameCount, @Nullable String scriptStatisticData) {
        }
    }
}
