package com.tencent.state.square.components;

import androidx.lifecycle.MutableLiveData;
import com.tencent.state.config.ConfigService;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import nt4.e;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0006\u0010\f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/components/SquareConfigHelper;", "", "()V", "TAG", "", "isUpdated", "Landroidx/lifecycle/MutableLiveData;", "", "doAfterConfigUpdated", "", "callback", "Lkotlin/Function0;", "loadAndUpdateConfig", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareConfigHelper {
    private static final String TAG = "SquareConfigHelper";
    public static final SquareConfigHelper INSTANCE = new SquareConfigHelper();
    private static final MutableLiveData<Boolean> isUpdated = new MutableLiveData<>(Boolean.FALSE);

    SquareConfigHelper() {
    }

    public final void doAfterConfigUpdated(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SquareBaseKt.getSquareLog().d(TAG, "doAfterConfigUpdated");
        MutableLiveData<Boolean> mutableLiveData = isUpdated;
        synchronized (mutableLiveData) {
            if (!Intrinsics.areEqual(mutableLiveData.getValue(), Boolean.TRUE)) {
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new SquareConfigHelper$doAfterConfigUpdated$$inlined$synchronized$lambda$1(null, callback), 2, null);
            } else {
                callback.invoke();
            }
        }
    }

    public final void loadAndUpdateConfig() {
        SquareBaseKt.getSquareLog().d(TAG, "loadAndUpdateConfig start");
        MutableLiveData<Boolean> mutableLiveData = isUpdated;
        synchronized (mutableLiveData) {
            mutableLiveData.setValue(Boolean.FALSE);
            Unit unit = Unit.INSTANCE;
        }
        new ConfigService().getConfig(new Function1<e, Unit>() { // from class: com.tencent.state.square.components.SquareConfigHelper$loadAndUpdateConfig$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e eVar) {
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                int i3;
                SquareBaseKt.getSquareLog().d("SquareConfigHelper", "loadAndUpdateConfig done");
                if (eVar != null) {
                    Square.INSTANCE.getConfig().getCommonUtils().setSquarePlayCountIncludeMe(eVar.f421283a);
                }
                if (eVar != null && (i3 = eVar.f421285c) != 0) {
                    Square.INSTANCE.getConfig().getCommonUtils().setSquareFilamentPlayCountIncludeMe(i3);
                }
                if (eVar != null) {
                    SquareBaseKt.getSquareCommon().setForbidLocalRecord(eVar.f421284b);
                }
                SquareConfigHelper squareConfigHelper = SquareConfigHelper.INSTANCE;
                mutableLiveData2 = SquareConfigHelper.isUpdated;
                synchronized (mutableLiveData2) {
                    mutableLiveData3 = SquareConfigHelper.isUpdated;
                    mutableLiveData3.postValue(Boolean.TRUE);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        });
    }
}
