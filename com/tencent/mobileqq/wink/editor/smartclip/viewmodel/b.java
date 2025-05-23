package com.tencent.mobileqq.wink.editor.smartclip.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016R \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR#\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/viewmodel/b;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "", "startTimes", "", "O1", "", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "N1", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_modifiedClipStartTimeLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "L1", "()Landroidx/lifecycle/LiveData;", "modifiedClipStartTimeLiveData", BdhLogUtil.LogTag.Tag_Conn, "_segFragmentQuitLiveData", "D", "M1", "segFragmentQuitLiveData", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _segFragmentQuitLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> segFragmentQuitLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<Long>> _modifiedClipStartTimeLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<List<Long>> modifiedClipStartTimeLiveData;

    public b() {
        MutableLiveData<List<Long>> mutableLiveData = new MutableLiveData<>();
        this._modifiedClipStartTimeLiveData = mutableLiveData;
        this.modifiedClipStartTimeLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._segFragmentQuitLiveData = mutableLiveData2;
        this.segFragmentQuitLiveData = mutableLiveData2;
    }

    @NotNull
    public final LiveData<List<Long>> L1() {
        return this.modifiedClipStartTimeLiveData;
    }

    @NotNull
    public final LiveData<Boolean> M1() {
        return this.segFragmentQuitLiveData;
    }

    public final void N1(boolean confirm) {
        this._segFragmentQuitLiveData.postValue(Boolean.valueOf(confirm));
    }

    public final void O1(@NotNull List<Long> startTimes) {
        Intrinsics.checkNotNullParameter(startTimes, "startTimes");
        this._modifiedClipStartTimeLiveData.postValue(startTimes);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
