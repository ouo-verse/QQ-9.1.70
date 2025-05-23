package com.tencent.ecommerce.biz.hr;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.biz.hr.api.IECHRFragmentModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J7\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022%\u0010\u000b\u001a!\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\nH\u0016J$\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/b;", "Lcom/tencent/ecommerce/biz/hr/api/IECHRFragmentModel;", "Landroid/os/Bundle;", "bundle", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "Lkotlin/ParameterName;", "name", "fragment", "", "Lcom/tencent/ecommerce/biz/hr/api/GetFragmentCallback;", "getFragmentCallback", "getFragment", "", AdMetricTag.EVENT_NAME, "", "", "data", "sendEvent", "manualOnStop", "Lcom/tencent/ecommerce/biz/hr/ECHRFragment;", "a", "Lcom/tencent/ecommerce/biz/hr/ECHRFragment;", "hrFragment", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b implements IECHRFragmentModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ECHRFragment hrFragment;

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRFragmentModel
    public void getFragment(Bundle bundle, Function1<? super Fragment, Unit> getFragmentCallback) {
        if (this.hrFragment == null) {
            ECHRFragment eCHRFragment = new ECHRFragment();
            eCHRFragment.setArguments(bundle);
            Unit unit = Unit.INSTANCE;
            this.hrFragment = eCHRFragment;
        }
        ECHRFragment eCHRFragment2 = this.hrFragment;
        Intrinsics.checkNotNull(eCHRFragment2);
        getFragmentCallback.invoke(eCHRFragment2);
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRFragmentModel
    public void manualOnStop() {
        ECHRFragment eCHRFragment = this.hrFragment;
        if (eCHRFragment != null) {
            eCHRFragment.ti();
        }
    }

    @Override // com.tencent.ecommerce.biz.hr.api.IECHRFragmentModel
    public void sendEvent(String eventName, Map<String, ? extends Object> data) {
        ECHRFragment eCHRFragment = this.hrFragment;
        if (eCHRFragment != null) {
            eCHRFragment.vi(eventName, data);
        }
    }
}
