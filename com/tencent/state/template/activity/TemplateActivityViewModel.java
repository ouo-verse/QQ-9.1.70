package com.tencent.state.template.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.state.event.Event;
import com.tencent.state.template.data.SitDownUpdateData;
import com.tencent.state.template.data.User;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\rR&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/template/activity/TemplateActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_endFocusUser", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/state/event/Event;", "Lkotlin/Pair;", "", "_isMeSeat", "", "_scaledVisibility", "Lcom/tencent/state/template/data/SitDownUpdateData;", "_startFocusUser", "Lcom/tencent/state/template/data/User;", "endFocusUser", "Landroidx/lifecycle/LiveData;", "getEndFocusUser", "()Landroidx/lifecycle/LiveData;", "isMeSeat", "scaledVisibility", "getScaledVisibility", "startFocusUser", "getStartFocusUser", "updateEndFocusUser", "", "tabId", "uin", "updateIsMySeat", "isSeat", "updateScaledAvatarVisibility", "data", "updateStartFocusUser", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateActivityViewModel extends ViewModel {
    private final MutableLiveData<Event<Pair<Long, Long>>> _endFocusUser;
    private final MutableLiveData<Boolean> _isMeSeat;
    private final MutableLiveData<Event<SitDownUpdateData>> _scaledVisibility;
    private final MutableLiveData<Event<User>> _startFocusUser;
    private final LiveData<Event<Pair<Long, Long>>> endFocusUser;
    private final LiveData<Boolean> isMeSeat;
    private final LiveData<Event<SitDownUpdateData>> scaledVisibility;
    private final LiveData<Event<User>> startFocusUser;

    public TemplateActivityViewModel() {
        MutableLiveData<Event<SitDownUpdateData>> mutableLiveData = new MutableLiveData<>();
        this._scaledVisibility = mutableLiveData;
        this.scaledVisibility = mutableLiveData;
        MutableLiveData<Event<User>> mutableLiveData2 = new MutableLiveData<>();
        this._startFocusUser = mutableLiveData2;
        this.startFocusUser = mutableLiveData2;
        MutableLiveData<Event<Pair<Long, Long>>> mutableLiveData3 = new MutableLiveData<>();
        this._endFocusUser = mutableLiveData3;
        this.endFocusUser = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._isMeSeat = mutableLiveData4;
        this.isMeSeat = mutableLiveData4;
    }

    public final LiveData<Event<Pair<Long, Long>>> getEndFocusUser() {
        return this.endFocusUser;
    }

    public final LiveData<Event<SitDownUpdateData>> getScaledVisibility() {
        return this.scaledVisibility;
    }

    public final LiveData<Event<User>> getStartFocusUser() {
        return this.startFocusUser;
    }

    public final LiveData<Boolean> isMeSeat() {
        return this.isMeSeat;
    }

    public final void updateEndFocusUser(long tabId, long uin) {
        this._endFocusUser.postValue(new Event<>(TuplesKt.to(Long.valueOf(tabId), Long.valueOf(uin))));
    }

    public final void updateIsMySeat(boolean isSeat) {
        this._isMeSeat.postValue(Boolean.valueOf(isSeat));
    }

    public final void updateScaledAvatarVisibility(SitDownUpdateData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this._scaledVisibility.setValue(new Event<>(data));
    }

    public final void updateStartFocusUser(User data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this._startFocusUser.postValue(new Event<>(data));
    }
}
