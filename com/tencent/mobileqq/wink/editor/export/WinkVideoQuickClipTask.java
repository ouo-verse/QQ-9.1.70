package com.tencent.mobileqq.wink.editor.export;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J0\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J&\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\fR$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/WinkVideoQuickClipTask;", "Lcom/tencent/mobileqq/wink/editor/export/x;", "Lcom/tencent/mobileqq/wink/editor/export/c;", "callback", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcom/tencent/mobileqq/wink/model/WinkExportParams;", "winkExportParams", "", "progress", "", "outPath", "", "r", "filePath", "Lcom/tencent/tavcut/core/render/exporter/ExportOutput;", "exportOutput", "p", "t", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errorCode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lcom/tencent/mobileqq/wink/editor/export/d;", "f", "Lcom/tencent/mobileqq/wink/editor/export/d;", "getNextTask", "()Lcom/tencent/mobileqq/wink/editor/export/d;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/wink/editor/export/d;)V", "nextTask", tl.h.F, "()Ljava/lang/String;", "tag", "<init>", "()V", "g", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkVideoQuickClipTask extends x {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d nextTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/WinkVideoQuickClipTask$a;", "", "", "a", "", "TAG", "Ljava/lang/String;", "", "TYPE", "I", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.export.WinkVideoQuickClipTask$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return uq3.c.z5();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/wink/editor/export/WinkVideoQuickClipTask$b", "Lcom/tencent/mobileqq/wink/editor/export/compress/base/b;", "", "e", "", "progress", "", "video", "audioTime", "totalTime", "b", "", "filePath", "a", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errorCode", "d", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.mobileqq.wink.editor.export.compress.base.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f320169b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f320170c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkExportParams f320171d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WinkEditDataWrapper f320172e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ExportOutput f320173f;

        b(String str, c cVar, WinkExportParams winkExportParams, WinkEditDataWrapper winkEditDataWrapper, ExportOutput exportOutput) {
            this.f320169b = str;
            this.f320170c = cVar;
            this.f320171d = winkExportParams;
            this.f320172e = winkEditDataWrapper;
            this.f320173f = exportOutput;
        }

        @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
        public void a(@NotNull String filePath) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            if (!WinkVideoQuickClipTask.this.getIsCanceled()) {
                WinkVideoQuickClipTask.this.p(filePath, this.f320171d, this.f320172e, this.f320170c, this.f320173f);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
        public void b(float progress, long video, long audioTime, long totalTime) {
            if (!WinkVideoQuickClipTask.this.getIsCanceled()) {
                WinkVideoQuickClipTask.this.r(this.f320170c, this.f320172e, this.f320171d, progress, this.f320169b);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
        public void c() {
            w53.b.f("WinkPublish-Export-WinkVideoQuickClipTask", "[onWinkVideoExportCancel]");
        }

        @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
        public void d(@NotNull ExportErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (WinkVideoQuickClipTask.this.getIsCanceled()) {
                return;
            }
            WinkVideoQuickClipTask.this.q(this.f320173f, this.f320172e, this.f320171d, this.f320170c, errorCode);
        }

        @Override // com.tencent.mobileqq.wink.editor.export.compress.base.b
        public void e() {
            if (WinkVideoQuickClipTask.this.getIsCanceled()) {
                return;
            }
            w53.b.f("WinkPublish-Export-WinkVideoQuickClipTask", "[onWinkVideoExportStart] path=" + this.f320169b);
            c cVar = this.f320170c;
            if (cVar != null) {
                cVar.e(this.f320171d.E, 2);
            }
            WinkVideoQuickClipTask.this.k(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String filePath, WinkExportParams winkExportParams, WinkEditDataWrapper winkEditDataWrapper, c callback, ExportOutput exportOutput) {
        w53.b.f("WinkPublish-Export-WinkVideoQuickClipTask", "[onWinkVideoExportCompleted] path=" + filePath);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkVideoQuickClipTask$doQuickClickCompleted$1(filePath, winkEditDataWrapper, winkExportParams, this, callback, exportOutput, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(c callback, WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams, float progress, String outPath) {
        if (Math.abs(System.currentTimeMillis() - getLastSendTime()) > 1000) {
            w53.b.f("WinkPublish-Export-WinkVideoQuickClipTask", "[onWinkVideoExporting] progress=" + progress);
            l(System.currentTimeMillis());
            if (callback != null) {
                callback.b(winkExportParams.E, WinkVideoComposeTask.L(winkExportParams.E, progress, 0.0f, 0.0f, 0L, outPath, winkEditDataWrapper.getOriginMediaInfos()));
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.export.x
    @NotNull
    public String h() {
        return "WinkPublish-Export-WinkVideoQuickClipTask";
    }

    public final void o() {
        j(true);
        com.tencent.mobileqq.wink.editor.export.compress.a.c();
    }

    public final void q(@NotNull ExportOutput exportOutput, @NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull WinkExportParams winkExportParams, @NotNull c callback, @NotNull ExportErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(exportOutput, "exportOutput");
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        w53.b.f("WinkPublish-Export-WinkVideoQuickClipTask", "[onWinkVideoExportError] " + errorCode);
        e(winkExportParams, errorCode, 2, null);
        d dVar = this.nextTask;
        if (dVar != null) {
            dVar.a(exportOutput, winkEditDataWrapper, winkExportParams, callback);
        } else {
            w53.b.c("WinkPublish-Export-WinkVideoQuickClipTask", "[composeVideo] error, load so fail");
            callback.c(winkExportParams.E, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_SO_LOAD_FAIL, null));
        }
    }

    public final void s(@Nullable d dVar) {
        this.nextTask = dVar;
    }

    public final void t(@NotNull ExportOutput exportOutput, @NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull WinkExportParams winkExportParams, @NotNull c callback) {
        LocalMediaInfo localMediaInfo;
        int i3;
        Intrinsics.checkNotNullParameter(exportOutput, "exportOutput");
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList<LocalMediaInfo> n3 = com.tencent.mobileqq.wink.editor.draft.c.n(winkEditDataWrapper);
        int i16 = 0;
        if (n3 != null) {
            localMediaInfo = n3.get(0);
        } else {
            localMediaInfo = null;
        }
        if (localMediaInfo != null && e93.i.c(localMediaInfo)) {
            af afVar = af.f320186a;
            String str = winkExportParams.D;
            Intrinsics.checkNotNullExpressionValue(str, "winkExportParams.mBusinessName");
            String str2 = winkExportParams.E;
            Intrinsics.checkNotNullExpressionValue(str2, "winkExportParams.mMissionID");
            String e16 = afVar.e(str, str2, 2);
            String str3 = localMediaInfo.path;
            long b16 = WinkConfig.f317649a.b();
            String musicPath = winkEditDataWrapper.getMusicPath();
            float originVolume = winkEditDataWrapper.getOriginVolume();
            float bgmVolume = winkEditDataWrapper.getBgmVolume();
            Integer selectMusicStart = winkEditDataWrapper.getSelectMusicStart();
            if (selectMusicStart != null) {
                i3 = selectMusicStart.intValue();
            } else {
                i3 = 0;
            }
            long j3 = i3 * 1000;
            Integer musicDuration = winkEditDataWrapper.getMusicDuration();
            if (musicDuration != null) {
                i16 = musicDuration.intValue();
            }
            com.tencent.mobileqq.wink.editor.export.compress.a.n(str3, e16, 0L, b16, musicPath, originVolume, bgmVolume, j3, i16 * 1000, new b(e16, callback, winkExportParams, winkEditDataWrapper, exportOutput));
            callback.f(winkExportParams.E, 2);
            k(System.currentTimeMillis());
            b(winkEditDataWrapper, 2, 0L, winkExportParams, false);
            return;
        }
        callback.c(winkExportParams.E, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_ORIGIN_FILE_INVALID, null));
    }
}
