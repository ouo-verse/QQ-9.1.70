package com.tencent.mobileqq.wink.editor.export.compress.base;

import androidx.annotation.CallSuper;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.core.ExportConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 \f2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J&\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0004J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH$J\b\u0010\u0011\u001a\u00020\u0006H\u0017J\b\u0010\u0012\u001a\u00020\u0006H\u0004J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0004J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0004J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000eH\u0004J\b\u0010\u001e\u001a\u00020\u0006H\u0004J\u001e\u0010 \u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00152\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002H\u0004R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!R\u0016\u0010%\u001a\u00020#8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/compress/base/c;", "Lcom/tencent/mobileqq/wink/editor/export/compress/base/a;", "", "b", "Lcom/tencent/mobileqq/wink/editor/export/compress/base/b;", "listener", "", "a", "inputPath", "outputPath", "Lcom/tencent/tav/core/ExportConfig;", "exportConfig", "c", "errMsg", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "k", "l", "cancel", "i", "", "progress", "", QFSEdgeItem.KEY_VIDEO_TIME, "audioTime", "totalTime", "j", "output", "g", "errorCode", h.F, "d", "errorMsg", "e", "Lcom/tencent/mobileqq/wink/editor/export/compress/base/b;", "resultListener", "", "Z", "isCancelled", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class c implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    protected volatile b resultListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    protected volatile boolean isCancelled;

    public static /* synthetic */ void f(c cVar, long j3, String str, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                j3 = ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_RESULT_SOFT_COMPRESS_ERROR;
            }
            if ((i3 & 2) != 0) {
                str = null;
            }
            cVar.e(j3, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyWinkVideoExportCancelOrError");
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.a
    @CallSuper
    public void a(@Nullable b listener) {
        this.resultListener = listener;
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.a
    @NotNull
    public String b() {
        return "WinkPublish-NCompress-WinkBaseVideoCompressProcessor_";
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.a
    public void c(@Nullable String inputPath, @Nullable String outputPath, @Nullable ExportConfig exportConfig) {
        boolean z16;
        boolean z17 = false;
        if (inputPath != null && inputPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (outputPath == null || outputPath.length() == 0) {
                z17 = true;
            }
            if (!z17 && exportConfig != null) {
                l(inputPath, outputPath, exportConfig);
                return;
            }
        }
        QLog.e(b(), 1, "startCompress, params invalid ");
        h(k("startCompress, invalid params "));
    }

    @Override // com.tencent.mobileqq.wink.editor.export.compress.base.a
    @CallSuper
    public void cancel() {
        QLog.d(b(), 1, "cancel ");
        this.isCancelled = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        b bVar = this.resultListener;
        if (bVar != null) {
            bVar.c();
        }
    }

    protected final void e(long errorCode, @Nullable String errorMsg) {
        QLog.d(b(), 1, "notifyWinkVideoExportCancelOrError, isCancelled:" + this.isCancelled);
        if (this.isCancelled) {
            d();
        } else {
            h(new ExportErrorCode(errorCode, errorMsg));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(@Nullable String output) {
        b bVar = this.resultListener;
        if (bVar != null) {
            bVar.a(output);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(@NotNull ExportErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        b bVar = this.resultListener;
        if (bVar != null) {
            bVar.d(errorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        b bVar = this.resultListener;
        if (bVar != null) {
            bVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(float progress, long videoTime, long audioTime, long totalTime) {
        b bVar = this.resultListener;
        if (bVar != null) {
            bVar.b(progress, videoTime, audioTime, totalTime);
        }
    }

    @NotNull
    protected final ExportErrorCode k(@Nullable String errMsg) {
        return new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_PARAMS_ERROR, errMsg);
    }

    protected abstract void l(@NotNull String inputPath, @NotNull String outputPath, @NotNull ExportConfig exportConfig);
}
