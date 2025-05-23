package com.tencent.zplan.meme.encoder.frame;

import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.common.utils.c;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.ERROR_ENCODE_NO_FRAME;
import com.tencent.zplan.meme.action.RECORD_COMPLETE;
import com.tencent.zplan.meme.encoder.MemeEncodeController;
import com.tencent.zplan.meme.encoder.a;
import com.tencent.zplan.meme.f;
import com.tencent.zplan.meme.model.BusinessConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0015B!\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010+\u001a\u00020\u000f\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J(\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR+\u0010&\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010(R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/zplan/meme/encoder/frame/MemeFrameEncoder;", "Lcom/tencent/zplan/meme/encoder/a;", "", "f", "i", "Ljava/io/File;", "file", "", "pixels", "", "width", "height", "", h.F, "portraitId", "", "outputFilePath", "frameTime", "Lcom/tencent/zplan/meme/action/ActionStatus;", "a", "c", "b", "getFrameCount", "", "getFrames", "Ljava/io/File;", "frameFile", "Z", "hasSetTimeoutScheduler", "d", "hasEvaluateStopRecord", "<set-?>", "e", "Lkotlin/properties/ReadWriteProperty;", "g", "()I", "j", "(I)V", "waitingFrameIndex", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, "Ljava/lang/String;", "tempFilePath", "Lcom/tencent/zplan/meme/encoder/MemeEncodeController$b;", "stopper", "<init>", "(Lcom/tencent/zplan/meme/encoder/MemeEncodeController$b;Lcom/tencent/zplan/meme/model/BusinessConfig;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeFrameEncoder implements com.tencent.zplan.meme.encoder.a {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f385825h = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MemeFrameEncoder.class, "waitingFrameIndex", "getWaitingFrameIndex()I", 0))};

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private File frameFile;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasSetTimeoutScheduler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasEvaluateStopRecord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty waitingFrameIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final BusinessConfig config;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String tempFilePath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a extends ObservableProperty<Integer> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f385833b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MemeFrameEncoder f385834c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, MemeFrameEncoder memeFrameEncoder) {
            super(obj2);
            this.f385833b = obj;
            this.f385834c = memeFrameEncoder;
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(@NotNull KProperty<?> property, Integer oldValue, Integer newValue) {
            Intrinsics.checkNotNullParameter(property, "property");
            int intValue = newValue.intValue();
            oldValue.intValue();
            if (intValue == 0) {
                this.f385834c.f();
            }
        }
    }

    public MemeFrameEncoder(@Nullable MemeEncodeController.b bVar, @NotNull BusinessConfig config, @NotNull String tempFilePath) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        this.config = config;
        this.tempFilePath = tempFilePath;
        Delegates delegates = Delegates.INSTANCE;
        Integer valueOf = Integer.valueOf(Meme.f385754h.k().getFrameModeConfig().getWaitingFrameIndex());
        this.waitingFrameIndex = new a(valueOf, valueOf, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        if (this.hasEvaluateStopRecord) {
            return;
        }
        this.hasEvaluateStopRecord = true;
    }

    private final int g() {
        return ((Number) this.waitingFrameIndex.getValue(this, f385825h[0])).intValue();
    }

    private final boolean h(File file, byte[] pixels, int width, int height) {
        boolean e16;
        boolean z16;
        BusinessConfig.FrameType frameType = this.config.getFrameType();
        int backgroundColor = this.config.getBackgroundColor();
        if (backgroundColor != 0) {
            f.f(pixels, backgroundColor);
        }
        Bitmap b16 = a.Companion.b(com.tencent.zplan.meme.encoder.a.INSTANCE, pixels, width, height, null, 4, null);
        if (this.config.getFrameType() == BusinessConfig.FrameType.JPG) {
            e16 = f.c(b16, 100, file);
        } else {
            e16 = f.e(b16, 100, file.getAbsolutePath());
        }
        if (e16 && file.exists() && file.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeFrameEncoder]", 1, "saveFrame2File " + file.getAbsolutePath() + ", type:" + frameType + ", backgroundColor:" + backgroundColor + ", success:" + z16, null, 8, null);
        }
        return z16;
    }

    private final void i() {
        if (!this.hasEvaluateStopRecord && !this.hasSetTimeoutScheduler) {
            this.hasSetTimeoutScheduler = true;
            final long j3 = 333.33334f;
            Meme.f385754h.C(new Function0<Unit>() { // from class: com.tencent.zplan.meme.encoder.frame.MemeFrameEncoder$setTimeoutSchedulerIfNeed$1
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
                    String str;
                    d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("call evaluateStopRecordIfNeed on timeout:");
                        sb5.append(j3);
                        sb5.append(" ms, tempFilePath:");
                        str = MemeFrameEncoder.this.tempFilePath;
                        sb5.append(str);
                        d.a.d(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeFrameEncoder]", 1, sb5.toString(), null, 8, null);
                    }
                    MemeFrameEncoder.this.f();
                }
            }, j3);
        }
    }

    private final void j(int i3) {
        this.waitingFrameIndex.setValue(this, f385825h[0], Integer.valueOf(i3));
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public ActionStatus a(int portraitId, @NotNull String outputFilePath, int frameTime) {
        Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
        File file = this.frameFile;
        if (file != null) {
            Intrinsics.checkNotNull(file);
            if (file.exists()) {
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("encode frameFile:");
                    File file2 = this.frameFile;
                    Intrinsics.checkNotNull(file2);
                    sb5.append(file2.getAbsolutePath());
                    sb5.append(" to ");
                    sb5.append(outputFilePath);
                    d.a.c(a16, "[zplan][MemePlayer-SDK][MemeEncoder][MemeFrameEncoder]", 1, sb5.toString(), null, 8, null);
                }
                c cVar = c.f385288a;
                File file3 = this.frameFile;
                Intrinsics.checkNotNull(file3);
                cVar.j(file3.getAbsolutePath(), outputFilePath);
                return RECORD_COMPLETE.INSTANCE;
            }
        }
        return ERROR_ENCODE_NO_FRAME.INSTANCE;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public boolean b(int portraitId, @NotNull byte[] pixels, int width, int height) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        if (g() == 0) {
            return false;
        }
        File file = new File(this.tempFilePath + File.separator + System.nanoTime());
        boolean h16 = h(file, pixels, width, height);
        if (!h16) {
            c.f385288a.f(file);
            h16 = h(file, pixels, width, height);
        }
        File file2 = this.frameFile;
        this.frameFile = file;
        if (file2 != null && file2.exists()) {
            c.f385288a.g(file2.getAbsolutePath());
        }
        j(g() - 1);
        i();
        return h16;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public boolean c() {
        return false;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void close() {
        a.C10067a.a(this);
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public int getFrameCount() {
        if (this.frameFile == null) {
            return 0;
        }
        return 1;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    @NotNull
    public List<String> getFrames() {
        ArrayList arrayList = new ArrayList();
        File file = this.frameFile;
        if (file != null && file.exists()) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "frame.absolutePath");
            arrayList.add(absolutePath);
        }
        return arrayList;
    }

    @Override // com.tencent.zplan.meme.encoder.a
    public void init() {
        a.C10067a.c(this);
    }
}
