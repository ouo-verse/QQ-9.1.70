package com.tencent.state.square;

import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.event.Event;
import com.tencent.state.square.data.QZoneFeedsInfo;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.detail.StatusUpdateData;
import com.tencent.state.square.guide.SquareNoviceGuideConfig;
import com.tencent.state.square.guide.SquareNoviceGuideRecord;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0013\u0018\u0000 92\u00020\u0001:\u00019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020'H\u0014J)\u0010(\u001a\u00020'\"\u0004\b\u0000\u0010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0\u00042\u0006\u0010+\u001a\u0002H)H\u0002\u00a2\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0010J\u000e\u0010/\u001a\u00020'2\u0006\u0010+\u001a\u00020\u0014J\u000e\u00100\u001a\u00020'2\u0006\u0010+\u001a\u00020\fJ\u000e\u00101\u001a\u00020'2\u0006\u0010+\u001a\u00020\u000eJ\u0016\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\bJ\u000e\u00105\u001a\u00020'2\u0006\u0010+\u001a\u00020\nJ\u000e\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\nJ\u0016\u00108\u001a\u00020'2\u0006\u00103\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0010R&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00050\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R)\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u00060\u00050\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00050\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018\u00a8\u0006:"}, d2 = {"Lcom/tencent/state/square/SquareViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_feedsInfoOfUin", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/state/event/Event;", "Lkotlin/Pair;", "", "Lcom/tencent/state/square/data/QZoneFeedsInfo;", "_isScaleAnimDone", "", "_noviceGuideConfig", "Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "_noviceGuideRecord", "Lcom/tencent/state/square/guide/SquareNoviceGuideRecord;", "_resourceOfMe", "Lcom/tencent/state/square/data/Resource;", "_resourceOfUin", "_scaledVisibility", "_statusUpdateData", "Lcom/tencent/state/square/detail/StatusUpdateData;", "feedsInfoOfUin", "Landroidx/lifecycle/LiveData;", "getFeedsInfoOfUin", "()Landroidx/lifecycle/LiveData;", "isScaleAnimDone", "noviceGuideConfig", "getNoviceGuideConfig", "noviceGuideRecord", "getNoviceGuideRecord", "resourceOfMe", "getResourceOfMe", "resourceOfUin", "getResourceOfUin", "scaledVisibility", "getScaledVisibility", "statusUpdateData", "getStatusUpdateData", "onCleared", "", "updateLiveData", "T", "liveData", "data", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "updateMeResource", "resource", "updateMeStatus", "updateNoviceGuideConfig", "updateNoviceGuideRecord", "updateQZoneFeeds", "uin", "feedsInfo", "updateScaleAnimState", "updateScaledAvatarVisibility", NodeProps.VISIBLE, "updateTargetResource", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareViewModel extends ViewModel {
    private static final String TAG = "SquareViewModel";
    private final MutableLiveData<Event<Pair<String, QZoneFeedsInfo>>> _feedsInfoOfUin;
    private final MutableLiveData<Boolean> _isScaleAnimDone;
    private final MutableLiveData<SquareNoviceGuideConfig> _noviceGuideConfig;
    private final MutableLiveData<SquareNoviceGuideRecord> _noviceGuideRecord;
    private final MutableLiveData<Event<Resource>> _resourceOfMe;
    private final MutableLiveData<Event<Pair<String, Resource>>> _resourceOfUin;
    private final MutableLiveData<Event<Boolean>> _scaledVisibility;
    private final MutableLiveData<Event<StatusUpdateData>> _statusUpdateData;
    private final LiveData<Event<Pair<String, QZoneFeedsInfo>>> feedsInfoOfUin;
    private final LiveData<Boolean> isScaleAnimDone;
    private final LiveData<SquareNoviceGuideConfig> noviceGuideConfig;
    private final LiveData<SquareNoviceGuideRecord> noviceGuideRecord;
    private final LiveData<Event<Resource>> resourceOfMe;
    private final LiveData<Event<Pair<String, Resource>>> resourceOfUin;
    private final LiveData<Event<Boolean>> scaledVisibility;
    private final LiveData<Event<StatusUpdateData>> statusUpdateData;

    public SquareViewModel() {
        MutableLiveData<Event<Resource>> mutableLiveData = new MutableLiveData<>();
        this._resourceOfMe = mutableLiveData;
        this.resourceOfMe = mutableLiveData;
        MutableLiveData<Event<Pair<String, Resource>>> mutableLiveData2 = new MutableLiveData<>();
        this._resourceOfUin = mutableLiveData2;
        this.resourceOfUin = mutableLiveData2;
        MutableLiveData<Event<StatusUpdateData>> mutableLiveData3 = new MutableLiveData<>();
        this._statusUpdateData = mutableLiveData3;
        this.statusUpdateData = mutableLiveData3;
        MutableLiveData<Event<Boolean>> mutableLiveData4 = new MutableLiveData<>();
        this._scaledVisibility = mutableLiveData4;
        this.scaledVisibility = mutableLiveData4;
        MutableLiveData<Event<Pair<String, QZoneFeedsInfo>>> mutableLiveData5 = new MutableLiveData<>();
        this._feedsInfoOfUin = mutableLiveData5;
        this.feedsInfoOfUin = mutableLiveData5;
        MutableLiveData<SquareNoviceGuideConfig> mutableLiveData6 = new MutableLiveData<>();
        this._noviceGuideConfig = mutableLiveData6;
        this.noviceGuideConfig = mutableLiveData6;
        MutableLiveData<SquareNoviceGuideRecord> mutableLiveData7 = new MutableLiveData<>(new SquareNoviceGuideRecord());
        this._noviceGuideRecord = mutableLiveData7;
        this.noviceGuideRecord = mutableLiveData7;
        MutableLiveData<Boolean> mutableLiveData8 = new MutableLiveData<>(Boolean.FALSE);
        this._isScaleAnimDone = mutableLiveData8;
        this.isScaleAnimDone = mutableLiveData8;
    }

    private final <T> void updateLiveData(MutableLiveData<T> liveData, T data) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            liveData.setValue(data);
        } else {
            liveData.postValue(data);
        }
    }

    public final LiveData<Event<Pair<String, QZoneFeedsInfo>>> getFeedsInfoOfUin() {
        return this.feedsInfoOfUin;
    }

    public final LiveData<SquareNoviceGuideConfig> getNoviceGuideConfig() {
        return this.noviceGuideConfig;
    }

    public final LiveData<SquareNoviceGuideRecord> getNoviceGuideRecord() {
        return this.noviceGuideRecord;
    }

    public final LiveData<Event<Resource>> getResourceOfMe() {
        return this.resourceOfMe;
    }

    public final LiveData<Event<Pair<String, Resource>>> getResourceOfUin() {
        return this.resourceOfUin;
    }

    public final LiveData<Event<Boolean>> getScaledVisibility() {
        return this.scaledVisibility;
    }

    public final LiveData<Event<StatusUpdateData>> getStatusUpdateData() {
        return this.statusUpdateData;
    }

    public final LiveData<Boolean> isScaleAnimDone() {
        return this.isScaleAnimDone;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SquareBaseKt.getSquareLog().i(TAG, "onCleared");
    }

    public final void updateMeResource(Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        updateLiveData(this._resourceOfMe, new Event(resource));
    }

    public final void updateMeStatus(StatusUpdateData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        updateLiveData(this._statusUpdateData, new Event(data));
    }

    public final void updateNoviceGuideConfig(SquareNoviceGuideConfig data) {
        Intrinsics.checkNotNullParameter(data, "data");
        updateLiveData(this._noviceGuideConfig, data);
    }

    public final void updateNoviceGuideRecord(SquareNoviceGuideRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
        updateLiveData(this._noviceGuideRecord, data);
    }

    public final void updateQZoneFeeds(String uin, QZoneFeedsInfo feedsInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(feedsInfo, "feedsInfo");
        updateLiveData(this._feedsInfoOfUin, new Event(TuplesKt.to(uin, feedsInfo)));
    }

    public final void updateScaleAnimState(boolean data) {
        updateLiveData(this._isScaleAnimDone, Boolean.valueOf(data));
    }

    public final void updateScaledAvatarVisibility(boolean visible) {
        updateLiveData(this._scaledVisibility, new Event(Boolean.valueOf(visible)));
    }

    public final void updateTargetResource(String uin, Resource resource) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(resource, "resource");
        updateLiveData(this._resourceOfUin, new Event(TuplesKt.to(uin, resource)));
    }
}
