package com.tencent.mobileqq.wink.editor.performance;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.cu;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 p2\u00020\u0001:\u0001qB\u0007\u00a2\u0006\u0004\bn\u0010oJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002JU\u0010\u0014\u001a\u00020\u00022K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J6\u0010#\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010!\u001a\u00020\u001d2\b\b\u0002\u0010\"\u001a\u00020\u0015J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004J\b\u0010&\u001a\u00020\u0002H\u0014R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020(0,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020(0,8\u0006\u00a2\u0006\f\n\u0004\b4\u0010.\u001a\u0004\b5\u00100R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010*R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b9\u0010.\u001a\u0004\b:\u00100R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010*R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\b>\u0010.\u001a\u0004\b?\u00100R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010*R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\bC\u0010.\u001a\u0004\bD\u00100R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010*R\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\bH\u0010.\u001a\u0004\bI\u00100R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010*R\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0006\u00a2\u0006\f\n\u0004\bM\u0010.\u001a\u0004\bN\u00100R\u0018\u0010R\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\"\u0010W\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010T\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\"\u0010i\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010T\u001a\u0004\bg\u0010X\"\u0004\bh\u0010ZR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010l\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "S1", "", "finishTimeMs", "X1", "frameTimeCostInMs", "renderNodeCostInMs", "", "frameCount", "", "jankCostList", "b2", "c2", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "currentRenderTimeInUs", "action", "Z1", "", "getLogTag", "Lcom/tencent/mobileqq/wink/editor/dr;", "cutManager", "R1", "Q1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "g2", "", "isUseTemplate", "mediaInputInfo", "templateId", "preloadPlayer", "sessionID", "W1", "duration", "U1", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "_curFpsLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "getCurFpsLiveData", "()Landroidx/lifecycle/LiveData;", "curFpsLiveData", BdhLogUtil.LogTag.Tag_Conn, "_materialAvgFps", "D", "getMaterialAvgFps", "materialAvgFps", "E", "_firstFrameCostFps", UserInfo.SEX_FEMALE, "getFirstFrameCostMs", "firstFrameCostMs", "G", "_tFirstFrameShow", "H", "getTFirstFrameShow", "tFirstFrameShow", "I", "_importCost", "J", "getImportCost", "importCost", "K", "_importCostWithTemplate", "L", "getImportCostWithTemplate", "importCostWithTemplate", "M", "_enhanceCost", "N", "getEnhanceCost", "enhanceCost", "P", "Lcom/tencent/mobileqq/wink/editor/dr;", "winkVideoTavCut", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "hasShownFirstFrame", BdhLogUtil.LogTag.Tag_Req, "isFromMagicStudio", "()Z", "e2", "(Z)V", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "getBusinessName", "()Ljava/lang/String;", "d2", "(Ljava/lang/String;)V", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lcom/tencent/mobileqq/wink/editor/performance/RenderTimeProxy;", "T", "Lcom/tencent/mobileqq/wink/editor/performance/RenderTimeProxy;", "renderTimeCallbackProxy", "U", "T1", "f2", "needSkipFrameCount", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "V", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "renderTimeListener", "<init>", "()V", "W", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditPerformanceViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Double> _materialAvgFps;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Double> materialAvgFps;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _firstFrameCostFps;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> firstFrameCostMs;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _tFirstFrameShow;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> tFirstFrameShow;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _importCost;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> importCost;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _importCostWithTemplate;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> importCostWithTemplate;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _enhanceCost;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> enhanceCost;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private dr winkVideoTavCut;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean hasShownFirstFrame;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isFromMagicStudio;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String businessName;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final RenderTimeProxy renderTimeCallbackProxy;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean needSkipFrameCount;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final IRenderTimeListener renderTimeListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Double> _curFpsLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Double> curFpsLiveData;

    public WinkEditPerformanceViewModel() {
        MutableLiveData<Double> mutableLiveData = new MutableLiveData<>();
        this._curFpsLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Double>");
        this.curFpsLiveData = mutableLiveData;
        MutableLiveData<Double> mutableLiveData2 = new MutableLiveData<>();
        this._materialAvgFps = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Double>");
        this.materialAvgFps = mutableLiveData2;
        MutableLiveData<Long> mutableLiveData3 = new MutableLiveData<>();
        this._firstFrameCostFps = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Long>");
        this.firstFrameCostMs = mutableLiveData3;
        MutableLiveData<Long> mutableLiveData4 = new MutableLiveData<>();
        this._tFirstFrameShow = mutableLiveData4;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Long>");
        this.tFirstFrameShow = mutableLiveData4;
        MutableLiveData<Long> mutableLiveData5 = new MutableLiveData<>();
        this._importCost = mutableLiveData5;
        Intrinsics.checkNotNull(mutableLiveData5, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Long>");
        this.importCost = mutableLiveData5;
        MutableLiveData<Long> mutableLiveData6 = new MutableLiveData<>();
        this._importCostWithTemplate = mutableLiveData6;
        Intrinsics.checkNotNull(mutableLiveData6, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Long>");
        this.importCostWithTemplate = mutableLiveData6;
        MutableLiveData<Long> mutableLiveData7 = new MutableLiveData<>();
        this._enhanceCost = mutableLiveData7;
        Intrinsics.checkNotNull(mutableLiveData7, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Long>");
        this.enhanceCost = mutableLiveData7;
        this.businessName = "QCIRCLE";
        this.renderTimeCallbackProxy = RenderTimeProxy.INSTANCE.a();
        this.renderTimeListener = new c();
        Z1(new Function3<Long, Long, Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, Long l16, Long l17) {
                invoke(l3.longValue(), l16.longValue(), l17.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, long j16, long j17) {
                WinkEditPerformanceViewModel.this._curFpsLiveData.postValue(Double.valueOf(com.tencent.mobileqq.wink.editor.performance.b.c(com.tencent.mobileqq.wink.editor.performance.b.a(j3), 0, 1, null)));
            }
        });
    }

    private final void S1() {
        this.renderTimeCallbackProxy.c();
    }

    private final void X1(long finishTimeMs) {
        if (this.isFromMagicStudio) {
            ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MAGIC_GALLERY_FIRST_FRAME, finishTimeMs);
        }
    }

    private final void Z1(Function3<? super Long, ? super Long, ? super Long, Unit> action) {
        this.renderTimeCallbackProxy.b(new b(action));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(long frameTimeCostInMs, long renderNodeCostInMs, int frameCount, List<Long> jankCostList) {
        WinkVideoTavCut winkVideoTavCut;
        double averageOfLong;
        int roundToInt;
        String valueOf;
        Object m912maxOrThrow;
        h73.b bVar = h73.b.f404555a;
        dr drVar = this.winkVideoTavCut;
        if (drVar instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) drVar;
        } else {
            winkVideoTavCut = null;
        }
        HashMap<String, String> a16 = bVar.a(winkVideoTavCut);
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FRAME_TIME_COST, String.valueOf(frameTimeCostInMs));
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_RENDER_NODE_COST, String.valueOf(renderNodeCostInMs));
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FRAME_COUNT, String.valueOf(frameCount));
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_JANK_FRAME_COUNT, String.valueOf(jankCostList.size()));
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUSINESS_NAME, this.businessName);
        String str = "0";
        if (!jankCostList.isEmpty()) {
            averageOfLong = CollectionsKt___CollectionsKt.averageOfLong(jankCostList);
            roundToInt = MathKt__MathJVMKt.roundToInt(averageOfLong);
            valueOf = String.valueOf(roundToInt);
        } else {
            valueOf = "0";
        }
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AVG_JANK_COST, valueOf);
        if (!jankCostList.isEmpty()) {
            m912maxOrThrow = CollectionsKt___CollectionsKt.m912maxOrThrow((Iterable<? extends Object>) jankCostList);
            str = String.valueOf(((Number) m912maxOrThrow).longValue());
        }
        a16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MAX_JANK_COST, str);
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportWinkEditorFluency(a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(long frameTimeCostInMs, long renderNodeCostInMs) {
        WinkImageTavCut winkImageTavCut;
        String str;
        h73.b bVar = h73.b.f404555a;
        dr drVar = this.winkVideoTavCut;
        if (drVar instanceof WinkImageTavCut) {
            winkImageTavCut = (WinkImageTavCut) drVar;
        } else {
            winkImageTavCut = null;
        }
        HashMap<String, String> b16 = bVar.b(winkImageTavCut);
        b16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FRAME_TIME_COST, String.valueOf(frameTimeCostInMs));
        b16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_RENDER_NODE_COST, String.valueOf(renderNodeCostInMs));
        dr drVar2 = this.winkVideoTavCut;
        boolean z16 = false;
        if (drVar2 != null && drVar2.p()) {
            z16 = true;
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        b16.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_IMAGE_ENHANCE, str);
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportWinkImageModeEditorFluency(b16);
    }

    public final void Q1() {
        this.needSkipFrameCount = true;
        this.renderTimeCallbackProxy.b(this.renderTimeListener);
    }

    public final void R1(@Nullable dr cutManager) {
        this.winkVideoTavCut = cutManager;
        WinkImageTavCut winkImageTavCut = null;
        WinkVideoTavCut winkVideoTavCut = null;
        if (cutManager instanceof WinkVideoTavCut) {
            if (cutManager instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) cutManager;
            }
            if (winkVideoTavCut != null) {
                winkVideoTavCut.Q2(this.renderTimeCallbackProxy);
                return;
            }
            return;
        }
        if (cutManager instanceof WinkImageTavCut) {
            if (cutManager instanceof WinkImageTavCut) {
                winkImageTavCut = (WinkImageTavCut) cutManager;
            }
            if (winkImageTavCut != null) {
                winkImageTavCut.w1(this.renderTimeCallbackProxy);
            }
        }
    }

    /* renamed from: T1, reason: from getter */
    public final boolean getNeedSkipFrameCount() {
        return this.needSkipFrameCount;
    }

    public final void U1(long duration) {
        this._enhanceCost.postValue(Long.valueOf(duration));
    }

    public final void W1(boolean isUseTemplate, @NotNull String mediaInputInfo, @Nullable String templateId, boolean preloadPlayer, @NotNull String sessionID) {
        long j3;
        String str;
        Intrinsics.checkNotNullParameter(mediaInputInfo, "mediaInputInfo");
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        if (this.hasShownFirstFrame) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.hasShownFirstFrame = true;
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_VIDEO_LOAD_FIRST_FRAME, currentTimeMillis);
        X1(currentTimeMillis);
        long timeCost = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_MEDIA_IMPORT);
        if (templateId == null) {
            this._importCost.postValue(Long.valueOf(timeCost));
        } else {
            this._importCostWithTemplate.postValue(Long.valueOf(timeCost));
        }
        long timeCost2 = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_EXTRACT_COVER);
        long timeCost3 = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_FETCH_MUSIC);
        long timeCost4 = ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_FETCH_MUSIC_STUCK_POINT);
        dr drVar = this.winkVideoTavCut;
        if (drVar != null) {
            j3 = drVar.getDurationUs();
        } else {
            j3 = -1;
        }
        long j16 = j3;
        if (templateId == null) {
            str = "";
        } else {
            str = templateId;
        }
        this._firstFrameCostFps.postValue(Long.valueOf(cu.C(isUseTemplate, mediaInputInfo, j16, str, timeCost, timeCost2, timeCost3, timeCost4, preloadPlayer, this.businessName)));
    }

    public final void a2() {
        this.renderTimeCallbackProxy.d(this.renderTimeListener);
    }

    public final void d2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.businessName = str;
    }

    public final void e2(boolean z16) {
        this.isFromMagicStudio = z16;
    }

    public final void f2(boolean z16) {
        this.needSkipFrameCount = z16;
    }

    public final void g2() {
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_VIDEO_LOAD_FAKE_FIRST_FRAME, System.currentTimeMillis());
        this._tFirstFrameShow.postValue(Long.valueOf(((IPrefRecorder) QRoute.api(IPrefRecorder.class)).getTimeCost(IPrefRecorder.MILESTONE_VIDEO_LOAD_FAKE_FIRST_FRAME)));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        String simpleName = WinkEditPerformanceViewModel.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        S1();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel$b", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "finishTimeInMs", "", "onFirstFrameTimeFinish", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onRenderTimeCost", "onSingleFrameTimeCost", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements IRenderTimeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Long, Long, Long, Unit> f321440a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super Long, ? super Long, ? super Long, Unit> function3) {
            this.f321440a = function3;
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
            this.f321440a.invoke(Long.valueOf(frameTimeCostInMs), Long.valueOf(renderNodeCostInMs), Long.valueOf(currentRenderTimeInUs));
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onFirstFrameTimeFinish(long finishTimeInMs) {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel$c", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "finishTimeInMs", "", "onFirstFrameTimeFinish", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onRenderTimeCost", "onSingleFrameTimeCost", "", "a", "Ljava/util/List;", "jankCostList", "b", "J", "accFrameTimeCost", "", "c", "I", "frameCount", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements IRenderTimeListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<Long> jankCostList = new ArrayList();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long accFrameTimeCost;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int frameCount;

        c() {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
            long j3 = 0;
            if (renderNodeCostInMs > 0) {
                j3 = 1000 / renderNodeCostInMs;
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TIMELINE_FPS, Long.valueOf(j3));
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
            if (WinkEditPerformanceViewModel.this.winkVideoTavCut instanceof WinkImageTavCut) {
                WinkEditPerformanceViewModel.this.c2(frameTimeCostInMs, renderNodeCostInMs);
                return;
            }
            if (WinkEditPerformanceViewModel.this.getNeedSkipFrameCount()) {
                WinkEditPerformanceViewModel.this.f2(false);
                return;
            }
            if (WinkEditPerformanceViewModel.this.winkVideoTavCut instanceof WinkVideoTavCut) {
                this.frameCount++;
                this.accFrameTimeCost += frameTimeCostInMs;
                if (frameTimeCostInMs >= 83) {
                    this.jankCostList.add(Long.valueOf(frameTimeCostInMs));
                }
                int i3 = this.frameCount;
                if (i3 > 150) {
                    long j3 = this.accFrameTimeCost / i3;
                    WinkEditPerformanceViewModel.this.b2(j3, renderNodeCostInMs, i3, this.jankCostList);
                    this.accFrameTimeCost = 0L;
                    this.frameCount = 0;
                    this.jankCostList.clear();
                    WinkEditPerformanceViewModel.this._materialAvgFps.postValue(Double.valueOf(j3));
                }
            }
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onFirstFrameTimeFinish(long finishTimeInMs) {
        }
    }
}
