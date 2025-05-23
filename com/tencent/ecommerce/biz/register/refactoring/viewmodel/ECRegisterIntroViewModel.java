package com.tencent.ecommerce.biz.register.refactoring.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterIntroViewModel;", "Landroidx/lifecycle/ViewModel;", "", "N1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "_unbindPromoterStatus", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "setUnbindPromoterStatusLiveData", "(Landroidx/lifecycle/LiveData;)V", "unbindPromoterStatusLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRegisterIntroViewModel extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _unbindPromoterStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LiveData<Boolean> unbindPromoterStatusLiveData;

    public ECRegisterIntroViewModel() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._unbindPromoterStatus = mutableLiveData;
        this.unbindPromoterStatusLiveData = mutableLiveData;
    }

    public final LiveData<Boolean> M1() {
        return this.unbindPromoterStatusLiveData;
    }

    public final void N1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECRegisterIntroViewModel$unbindPromoter$1(this, null), 3, null);
    }
}
