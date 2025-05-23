package com.tencent.zplan.meme.encoder;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.Constant;
import com.tencent.zplan.meme.action.ActionStatus;
import com.tencent.zplan.meme.action.COMPLETE;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.encoder.MemeEncodeController;
import com.tencent.zplan.meme.encoder.apng.MemeApngEncoder;
import com.tencent.zplan.meme.encoder.frame.MemeFrameEncoder;
import com.tencent.zplan.meme.encoder.gif.MemeGifEncoder;
import com.tencent.zplan.meme.encoder.sharpp.MemeSharpPEncoder;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeRecordParams;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001\u0006BS\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u00105\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010%\u001a\u00020\u001f\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020\u001f\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0017\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b\u001a\u0010!R\u0017\u0010%\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010!R\u0017\u0010)\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b#\u0010(R\u0017\u0010,\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010!R\u0011\u0010.\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010!R\u0011\u00101\u001a\u00020/8F\u00a2\u0006\u0006\u001a\u0004\b*\u00100R\u0011\u00104\u001a\u0002028F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/zplan/meme/encoder/b;", "", "", "l", "", "g", "a", "Lcom/tencent/zplan/meme/action/ActionStatus;", "Lcom/tencent/zplan/meme/action/ActionStatus;", "i", "()Lcom/tencent/zplan/meme/action/ActionStatus;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/zplan/meme/action/ActionStatus;)V", "status", "b", "I", "recordFrameCount", "Lcom/tencent/zplan/meme/encoder/a;", "c", "Lcom/tencent/zplan/meme/encoder/a;", "()Lcom/tencent/zplan/meme/encoder/a;", "encoder", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "d", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "recordParams", "e", "f", "()I", "portraitId", "frameTime", "", "Ljava/lang/String;", "()Ljava/lang/String;", "outputFilePath", h.F, "getTempFilePath", "tempFilePath", "Lwx4/c;", "Lwx4/c;", "()Lwx4/c;", "statistic", "j", "getCoverFilePath", "coverFilePath", "k", "uniKey", "Lcom/tencent/zplan/meme/action/MODE;", "()Lcom/tencent/zplan/meme/action/MODE;", "type", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "()Lcom/tencent/zplan/meme/model/BusinessConfig;", DownloadInfo.spKey_Config, "totalFrameCount", "Lcom/tencent/zplan/meme/encoder/MemeEncodeController$b;", "stopper", "<init>", "(Lcom/tencent/zplan/meme/model/MemeRecordParams;IIILjava/lang/String;Ljava/lang/String;Lcom/tencent/zplan/meme/encoder/MemeEncodeController$b;Lwx4/c;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ActionStatus status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int recordFrameCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a encoder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MemeRecordParams recordParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int portraitId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int frameTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String outputFilePath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tempFilePath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wx4.c statistic;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String coverFilePath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/zplan/meme/encoder/b$a;", "", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.encoder.b$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b() {
            try {
                File file = new File(Constant.f385743c.a());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, ".nomedia");
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Throwable th5) {
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    a16.e("[zplan][MemeCoderResource]", 1, "initOutputDirIfNeed", th5);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        companion.b();
    }

    public b(@NotNull MemeRecordParams recordParams, int i3, int i16, int i17, @NotNull String outputFilePath, @NotNull String tempFilePath, @Nullable MemeEncodeController.b bVar, @NotNull wx4.c statistic, @NotNull String coverFilePath) {
        a aVar;
        Intrinsics.checkNotNullParameter(recordParams, "recordParams");
        Intrinsics.checkNotNullParameter(outputFilePath, "outputFilePath");
        Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
        Intrinsics.checkNotNullParameter(statistic, "statistic");
        Intrinsics.checkNotNullParameter(coverFilePath, "coverFilePath");
        this.recordParams = recordParams;
        this.portraitId = i3;
        this.frameTime = i16;
        this.outputFilePath = outputFilePath;
        this.tempFilePath = tempFilePath;
        this.statistic = statistic;
        this.coverFilePath = coverFilePath;
        this.status = COMPLETE.INSTANCE;
        int i18 = c.f385824a[j().ordinal()];
        if (i18 != 1) {
            if (i18 != 2) {
                if (i18 != 3) {
                    if (i18 != 4) {
                        if (i18 == 5) {
                            aVar = new wx4.b(statistic, new vx4.a(statistic, b(), outputFilePath, i16, i17, tempFilePath, coverFilePath));
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        aVar = new wx4.b(statistic, new MemeSharpPEncoder(b(), tempFilePath, i16, i17));
                    }
                } else {
                    aVar = new wx4.b(statistic, new MemeFrameEncoder(bVar, b(), tempFilePath));
                }
            } else {
                aVar = new wx4.b(statistic, new MemeGifEncoder(b(), tempFilePath, outputFilePath, i16));
            }
        } else {
            aVar = new wx4.a(statistic, new MemeApngEncoder(b(), tempFilePath, i16));
        }
        this.encoder = aVar;
        l();
        aVar.init();
    }

    private final void l() {
        try {
            String str = this.tempFilePath;
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    com.tencent.zplan.common.utils.c.f385288a.e(str);
                } else if (file.isFile()) {
                    file.delete();
                }
            }
            file.mkdir();
        } catch (Throwable th5) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                a16.e("[zplan][MemeCoderResource]", 1, "initTempFilePath", th5);
            }
        }
    }

    public final void a() {
        this.recordFrameCount++;
    }

    @NotNull
    public final BusinessConfig b() {
        return this.recordParams.getBusinessConfig();
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final a getEncoder() {
        return this.encoder;
    }

    /* renamed from: d, reason: from getter */
    public final int getFrameTime() {
        return this.frameTime;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getOutputFilePath() {
        return this.outputFilePath;
    }

    /* renamed from: f, reason: from getter */
    public final int getPortraitId() {
        return this.portraitId;
    }

    /* renamed from: g, reason: from getter */
    public final int getRecordFrameCount() {
        return this.recordFrameCount;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final wx4.c getStatistic() {
        return this.statistic;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final ActionStatus getStatus() {
        return this.status;
    }

    @NotNull
    public final MODE j() {
        return this.recordParams.getRecordMode();
    }

    @NotNull
    public final String k() {
        return this.recordParams.getUniKey();
    }

    public final void m(@NotNull ActionStatus actionStatus) {
        Intrinsics.checkNotNullParameter(actionStatus, "<set-?>");
        this.status = actionStatus;
    }
}
