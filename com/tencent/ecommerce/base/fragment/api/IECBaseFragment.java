package com.tencent.ecommerce.base.fragment.api;

import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.ui.api.IECFragmentApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/fragment/api/IECBaseFragment;", "Lcom/tencent/ecommerce/base/fragment/api/IECContentDescProvider;", "Lcom/tencent/ecommerce/base/ui/api/IECFragmentApi;", "getBusinessDescription", "", "realFragment", "Landroidx/fragment/app/Fragment;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface IECBaseFragment extends IECContentDescProvider, IECFragmentApi {
    String getBusinessDescription();

    Fragment realFragment();
}
