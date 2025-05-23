package com.tencent.state.status;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.mvvm.c;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.DressInfo;
import com.tencent.state.square.data.DressInfoResponse;
import com.tencent.state.square.data.PanelInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003J,\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/status/SquareStatusViewModel;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/state/status/SquareStatusRepository;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/state/square/data/PanelInfo;", "getPanelInfo", "Lcom/tencent/state/square/data/DressInfoResponse;", "getDressInfo", "", "isMale", "", "status", "richStatus", "", "", "recentList", "", "loadStatusListData", "uin", "loadDressInfo", "panelInfo", "Landroidx/lifecycle/MutableLiveData;", "dressInfoResponse", "dressInfoOnLoading", "Z", "repository", "Lcom/tencent/state/status/SquareStatusRepository;", "<init>", "(Lcom/tencent/state/status/SquareStatusRepository;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareStatusViewModel extends c<SquareStatusRepository> {
    private static final String TAG = "SquareStatusViewModel";
    private boolean dressInfoOnLoading;
    private final MutableLiveData<DressInfoResponse> dressInfoResponse;
    private final MutableLiveData<PanelInfo> panelInfo;
    private final SquareStatusRepository repository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareStatusViewModel(SquareStatusRepository repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        this.panelInfo = new MutableLiveData<>();
        this.dressInfoResponse = new MutableLiveData<>();
    }

    public final MutableLiveData<DressInfoResponse> getDressInfo() {
        return this.dressInfoResponse;
    }

    public final MutableLiveData<PanelInfo> getPanelInfo() {
        return this.panelInfo;
    }

    public final void loadDressInfo(long uin) {
        if (this.dressInfoOnLoading) {
            return;
        }
        DressInfoResponse value = this.dressInfoResponse.getValue();
        if (value != null && value.getErrorCode() == null) {
            this.dressInfoResponse.postValue(value);
        } else {
            this.dressInfoOnLoading = true;
            this.repository.getDressInfo(uin, new ResultCallback<DressInfo>() { // from class: com.tencent.state.status.SquareStatusViewModel$loadDressInfo$2
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    MutableLiveData mutableLiveData;
                    DressInfoResponse dressInfoResponse = new DressInfoResponse(null, Integer.valueOf(error), message);
                    mutableLiveData = SquareStatusViewModel.this.dressInfoResponse;
                    mutableLiveData.postValue(dressInfoResponse);
                    SquareStatusViewModel.this.dressInfoOnLoading = false;
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(DressInfo result) {
                    MutableLiveData mutableLiveData;
                    Intrinsics.checkNotNullParameter(result, "result");
                    DressInfoResponse dressInfoResponse = new DressInfoResponse(result, null, null);
                    mutableLiveData = SquareStatusViewModel.this.dressInfoResponse;
                    mutableLiveData.postValue(dressInfoResponse);
                    SquareStatusViewModel.this.dressInfoOnLoading = false;
                }
            });
        }
    }

    public final void loadStatusListData(boolean isMale, int status, int richStatus, List<Long> recentList) {
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        this.repository.getOnlineStatusList(isMale, status, richStatus, recentList, new ResultCallback<PanelInfo>() { // from class: com.tencent.state.status.SquareStatusViewModel$loadStatusListData$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                MutableLiveData mutableLiveData;
                List emptyList;
                List emptyList2;
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareStatusViewModel", "error: " + error + ", message: " + message, null, 4, null);
                mutableLiveData = SquareStatusViewModel.this.panelInfo;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                mutableLiveData.postValue(new PanelInfo(emptyList, emptyList2));
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(PanelInfo result) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(result, "result");
                mutableLiveData = SquareStatusViewModel.this.panelInfo;
                mutableLiveData.postValue(result);
            }
        });
    }
}
