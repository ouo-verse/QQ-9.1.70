package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalInfoResult;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/viewmodel/QQStrangerSignalSquareViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "partnerId", "", "P1", "O1", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareRepository;", "i", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareRepository;", "repository", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_updateSignalsLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "updateSignalsLiveData", "<init>", "()V", "D", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<QQStrangerSignalInfoResult> updateSignalsLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerSignalSquareRepository repository = new QQStrangerSignalSquareRepository();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<QQStrangerSignalInfoResult> _updateSignalsLiveData;

    public QQStrangerSignalSquareViewModel() {
        MutableLiveData<QQStrangerSignalInfoResult> mutableLiveData = new MutableLiveData<>();
        this._updateSignalsLiveData = mutableLiveData;
        this.updateSignalsLiveData = mutableLiveData;
    }

    public final LiveData<QQStrangerSignalInfoResult> N1() {
        return this.updateSignalsLiveData;
    }

    public final void O1(long partnerId) {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSignalSquareViewModel$loadMoreSignals$1(this, partnerId, null), 12, null);
    }

    public final void P1(long partnerId) {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSquareViewModel", Boolean.FALSE, null, null, new QQStrangerSignalSquareViewModel$refreshSignals$1(this, partnerId, null), 12, null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QQStrangerSquareViewModel";
    }
}
