package com.tencent.mobileqq.wink.editor.export.compress.base;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.export.WinkVideoComposeTask;
import com.tencent.mobileqq.wink.editor.export.ab;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 62\u00020\u0001:\u0001\rBI\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020!\u0012\u0006\u0010'\u001a\u00020\u0006\u0012\u0006\u0010)\u001a\u00020\u000b\u0012\u0006\u0010,\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0013\u001a\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0017\u0010\u0018\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0017\u0010'\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u0015R\u0014\u0010,\u001a\u00020*8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010+R\u0016\u0010/\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010.R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00101R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010$\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/compress/base/WinkBaseVideoCompressResultListener;", "Lcom/tencent/mobileqq/wink/editor/export/compress/base/b;", "", "e", "", "progress", "", QFSEdgeItem.KEY_VIDEO_TIME, "audioTime", "totalTime", "b", "", "exportPath", "a", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errorCode", "d", "", "j", "k", "c", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "logTag", "Lcom/tencent/mobileqq/wink/editor/export/ab;", "Lcom/tencent/mobileqq/wink/editor/export/ab;", h.F, "()Lcom/tencent/mobileqq/wink/editor/export/ab;", "compressTask", "Lcom/tencent/tavcut/core/render/exporter/ExportOutput;", "Lcom/tencent/tavcut/core/render/exporter/ExportOutput;", "exportOutput", "Lcom/tencent/mobileqq/wink/model/WinkExportParams;", "Lcom/tencent/mobileqq/wink/model/WinkExportParams;", "winkExportParams", "J", "g", "()J", "beginTime", "f", "exportFilePath", "", "I", "type", "Lcom/tencent/mobileqq/wink/editor/export/c;", "Lcom/tencent/mobileqq/wink/editor/export/c;", "callback", "lastSendTime", UserInfo.SEX_FEMALE, "lastSendProgress", "videoAheadTime", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/wink/editor/export/ab;Lcom/tencent/tavcut/core/render/exporter/ExportOutput;Lcom/tencent/mobileqq/wink/model/WinkExportParams;JLjava/lang/String;ILcom/tencent/mobileqq/wink/editor/export/c;)V", "l", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkBaseVideoCompressResultListener implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ab compressTask;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final ExportOutput exportOutput;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final WinkExportParams winkExportParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long beginTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final String exportFilePath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final int type;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public final com.tencent.mobileqq.wink.editor.export.c callback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long lastSendTime;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float lastSendProgress;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long videoAheadTime;

    public WinkBaseVideoCompressResultListener(@NotNull String logTag, @NotNull ab compressTask, @NotNull ExportOutput exportOutput, @NotNull WinkExportParams winkExportParams, long j3, @NotNull String exportFilePath, int i3, @Nullable com.tencent.mobileqq.wink.editor.export.c cVar) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(compressTask, "compressTask");
        Intrinsics.checkNotNullParameter(exportOutput, "exportOutput");
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        Intrinsics.checkNotNullParameter(exportFilePath, "exportFilePath");
        this.logTag = logTag;
        this.compressTask = compressTask;
        this.exportOutput = exportOutput;
        this.winkExportParams = winkExportParams;
        this.beginTime = j3;
        this.exportFilePath = exportFilePath;
        this.type = i3;
        this.callback = cVar;
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
    public void a(@Nullable String exportPath) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkBaseVideoCompressResultListener$onWinkVideoExportCompleted$1(this, exportPath, null), 3, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
    public void b(float progress, long videoTime, long audioTime, long totalTime) {
        long coerceAtLeast;
        ArrayList arrayListOf;
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Math.abs(videoTime - audioTime), this.videoAheadTime);
        this.videoAheadTime = coerceAtLeast;
        if (Math.abs(currentTimeMillis - this.lastSendTime) > 1000) {
            float f16 = this.lastSendProgress;
            long j3 = 0;
            if (f16 > 0.0f) {
                long j16 = this.lastSendTime;
                if (j16 > 0) {
                    if (progress == f16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        j3 = ((float) (currentTimeMillis - j16)) / (progress - f16);
                    }
                }
            }
            long j17 = j3;
            this.lastSendTime = currentTimeMillis;
            this.lastSendProgress = progress;
            LocalMediaInfo b16 = this.winkExportParams.b();
            Intrinsics.checkNotNullExpressionValue(b16, "winkExportParams.localMediaInfo");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(b16);
            ExportingParam L = WinkVideoComposeTask.L(this.winkExportParams.E, progress, 0.0f, 0.0f, j17, this.exportFilePath, arrayListOf);
            QLog.e(this.logTag, 1, "onWinkVideoExporting, progress:" + progress + ", predictTime:" + j17 + ", videoTime:" + videoTime + ", audioTime:" + audioTime);
            com.tencent.mobileqq.wink.editor.export.c cVar = this.callback;
            if (cVar != null) {
                cVar.b(this.winkExportParams.E, L);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
    public void c() {
        QLog.d(this.logTag, 1, "onWinkVideoExportCancel ");
        com.tencent.mobileqq.wink.editor.export.c cVar = this.callback;
        if (cVar != null) {
            cVar.a(this.winkExportParams.E);
        }
        this.compressTask.e(this.winkExportParams, true, false, this.type);
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
    public void d(@Nullable ExportErrorCode errorCode) {
        Long l3;
        com.tencent.mobileqq.wink.editor.export.c cVar;
        String str = this.logTag;
        String str2 = null;
        if (errorCode != null) {
            l3 = Long.valueOf(errorCode.transformedCode());
        } else {
            l3 = null;
        }
        if (errorCode != null) {
            str2 = errorCode.getMessage();
        }
        QLog.d(str, 1, "onWinkVideoExportError, errCode:" + l3 + ", errMsg:" + str2);
        this.compressTask.g(this.winkExportParams, errorCode, true, false, this.type);
        if (k()) {
            com.tencent.mobileqq.wink.editor.export.c cVar2 = this.callback;
            if (cVar2 != null) {
                WinkExportParams winkExportParams = this.winkExportParams;
                cVar2.d(winkExportParams.E, winkExportParams.b(), false);
                return;
            }
            return;
        }
        if (!j(errorCode) && (cVar = this.callback) != null) {
            cVar.c(this.winkExportParams.E, errorCode);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
    public void e() {
        QLog.d(this.logTag, 1, "onWinkVideoExportStart ");
        com.tencent.mobileqq.wink.editor.export.c cVar = this.callback;
        if (cVar != null) {
            cVar.e(this.winkExportParams.E, this.type);
        }
    }

    /* renamed from: g, reason: from getter */
    public final long getBeginTime() {
        return this.beginTime;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final ab getCompressTask() {
        return this.compressTask;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getLogTag() {
        return this.logTag;
    }

    protected boolean j(@Nullable ExportErrorCode errorCode) {
        throw null;
    }

    protected boolean k() {
        throw null;
    }
}
