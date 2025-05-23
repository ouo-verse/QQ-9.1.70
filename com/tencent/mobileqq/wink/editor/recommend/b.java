package com.tencent.mobileqq.wink.editor.recommend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.render.extension.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import z93.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\t\b\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J:\u0010\u000f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\u0010H\u0016R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/recommend/b;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/videocut/model/MediaClip;", "clips", "", "isAllImage", "", "totalDurationUs", "", "M1", "Ljava/util/ArrayList;", "", "result", "startTime", "L1", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_extractBitmapsLiveData", "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "extractBitmapsLiveData", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<byte[]>> _extractBitmapsLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/recommend/b$b", "Lcom/tencent/mobileqq/wink/editor/extractor/ExtractCoverHelper$a;", "Ljava/util/ArrayList;", "", "result", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.recommend.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9033b implements ExtractCoverHelper.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<MediaClip> f321466b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f321467c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f321468d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f321469e;

        /* JADX WARN: Multi-variable type inference failed */
        C9033b(List<? extends MediaClip> list, long j3, boolean z16, long j16) {
            this.f321466b = list;
            this.f321467c = j3;
            this.f321468d = z16;
            this.f321469e = j16;
        }

        @Override // com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper.a
        public void a(@NotNull ArrayList<byte[]> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            b.this.L1(result, this.f321466b, this.f321467c, this.f321468d, this.f321469e);
        }
    }

    public final void L1(@NotNull ArrayList<byte[]> result, @NotNull List<? extends MediaClip> clips, long startTime, boolean isAllImage, long totalDurationUs) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(clips, "clips");
        try {
            if (((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_qqvideo_topicguid_1505")) {
                a.f321459a.e(WinkContext.INSTANCE.d().getTraceId(), result, null);
            }
        } catch (Exception e16) {
            com.tencent.xaction.log.b.c("WinkRecommendViewModel", 1, "[onFinish] ", e16);
        }
        this._extractBitmapsLiveData.postValue(result);
        try {
            Result.Companion companion = Result.INSTANCE;
            WinkContext.Companion companion2 = WinkContext.INSTANCE;
            if (companion2.d().u("QCIRCLE")) {
                WinkPublishQualityReportData reportData = new WinkPublishQualityReportData.Builder().eventId("E_EDIT_EXTRACT_COVER").traceId(companion2.d().getTraceId()).ext1("clips" + clips.size()).ext2(String.valueOf(System.currentTimeMillis() - startTime)).ext3(String.valueOf(isAllImage)).ext4(String.valueOf(totalDurationUs)).getReportData();
                c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(reportData, companion2.d().k().b());
                }
            }
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    public final void M1(@NotNull List<? extends MediaClip> clips, boolean isAllImage, long totalDurationUs) {
        Intrinsics.checkNotNullParameter(clips, "clips");
        a.f321459a.a();
        C9033b c9033b = new C9033b(clips, System.currentTimeMillis(), isAllImage, totalDurationUs);
        if (e.u(clips)) {
            ExtractCoverHelper.f320276a.u(clips, c9033b);
        } else {
            ExtractCoverHelper.f320276a.y(clips, totalDurationUs, c9033b);
        }
    }

    @NotNull
    public final LiveData<List<byte[]>> N1() {
        return this._extractBitmapsLiveData;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkRecommendViewModel";
    }
}
