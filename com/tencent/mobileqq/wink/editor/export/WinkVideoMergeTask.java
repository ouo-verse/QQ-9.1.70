package com.tencent.mobileqq.wink.editor.export;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r63.MetaVideo;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J2\u0010\u000e\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J8\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0019\u001a\u00020\nR\u0014\u0010\u001c\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/WinkVideoMergeTask;", "Lcom/tencent/mobileqq/wink/editor/export/x;", "", "outPath", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcom/tencent/mobileqq/wink/model/WinkExportParams;", "winkExportParams", "Lcom/tencent/mobileqq/wink/editor/export/c;", "callBack", "", "r", "", "progress", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errCode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", "mVideoExportStartTime", "", "mUseH265", "t", "p", tl.h.F, "()Ljava/lang/String;", "tag", "<init>", "()V", "f", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkVideoMergeTask extends x {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/export/WinkVideoMergeTask$b", "Lr63/a;", "Lr63/d;", TtmlNode.TAG_METADATA, "", "b", "", "progress", "c", "Lcom/tencent/mobileqq/winkpublish/report/ExportErrorCode;", "errorCode", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements r63.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f320162b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WinkEditDataWrapper f320163c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkExportParams f320164d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f320165e;

        b(String str, WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams, c cVar) {
            this.f320162b = str;
            this.f320163c = winkEditDataWrapper;
            this.f320164d = winkExportParams;
            this.f320165e = cVar;
        }

        @Override // r63.a
        public void a(@NotNull r63.Metadata metadata, @NotNull ExportErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (!WinkVideoMergeTask.this.getIsCanceled()) {
                WinkVideoMergeTask.this.q(this.f320164d, errorCode, this.f320165e);
            }
        }

        @Override // r63.a
        public void b(@NotNull r63.Metadata metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            WinkVideoMergeTask.this.r(this.f320162b, this.f320163c, this.f320164d, this.f320165e);
        }

        @Override // r63.a
        public void c(@NotNull r63.Metadata metadata, double progress) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            if (!WinkVideoMergeTask.this.getIsCanceled()) {
                WinkVideoMergeTask.this.s(this.f320165e, this.f320163c, this.f320164d, progress, this.f320162b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(WinkExportParams winkExportParams, ExportErrorCode errCode, c callBack) {
        w53.b.c("WinkPublish-Export-WinkVideoMergeTask", "winkVideoMerger fail: " + errCode);
        ac acVar = ac.f320179a;
        String str = winkExportParams.E;
        Intrinsics.checkNotNullExpressionValue(str, "winkExportParams.mMissionID");
        acVar.c(str);
        e(winkExportParams, errCode, 3, callBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String outPath, WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams, c callBack) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkVideoMergeTask$doOnVideoMergeSucceed$1(this, outPath, winkEditDataWrapper, winkExportParams, callBack, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(c callBack, WinkEditDataWrapper winkEditDataWrapper, WinkExportParams winkExportParams, double progress, String outPath) {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - getLastSendTime()) > 1000) {
            l(currentTimeMillis);
            if (callBack != null) {
                callBack.b(winkExportParams.E, WinkVideoComposeTask.L(winkExportParams.E, (float) progress, 0.0f, 0.0f, 0L, outPath, winkEditDataWrapper.getOriginMediaInfos()));
            }
            w53.b.f("WinkPublish-Export-WinkVideoMergeTask", "winkVideoMerger progress:" + progress);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.export.x
    @NotNull
    public String h() {
        return "WinkPublish-Export-WinkVideoMergeTask";
    }

    public final void p() {
        j(true);
    }

    public final boolean t(@NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull LocalMediaInfo localMediaInfo, @NotNull WinkExportParams winkExportParams, long mVideoExportStartTime, boolean mUseH265, @Nullable c callBack) {
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        w53.b.f("WinkPublish-Export-WinkVideoMergeTask", "[doVideoMerge] start");
        k(System.currentTimeMillis());
        ac acVar = ac.f320179a;
        String str = winkExportParams.E;
        Intrinsics.checkNotNullExpressionValue(str, "winkExportParams.mMissionID");
        ArrayList<MetaVideo> f16 = acVar.f(str, mVideoExportStartTime);
        MetaVideo d16 = acVar.d(localMediaInfo.path, mVideoExportStartTime, mUseH265);
        if (f16 != null && d16 != null) {
            f16.add(d16);
            w53.b.f("WinkPublish-Export-WinkVideoMergeTask", "videos:" + f16);
            af afVar = af.f320186a;
            String str2 = winkExportParams.D;
            Intrinsics.checkNotNullExpressionValue(str2, "winkExportParams.mBusinessName");
            String str3 = winkExportParams.E;
            Intrinsics.checkNotNullExpressionValue(str3, "winkExportParams.mMissionID");
            String e16 = afVar.e(str2, str3, 3);
            new r63.f().c(new r63.Metadata(e16, f16), new b(e16, winkEditDataWrapper, winkExportParams, callBack));
            l(0L);
            return true;
        }
        q(winkExportParams, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_MERGE_ERROR, ""), callBack);
        return false;
    }
}
