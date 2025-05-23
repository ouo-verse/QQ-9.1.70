package com.tencent.timi.game.scheme.tools;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.timi.game.utils.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SchemeRouteTranslucentFragment extends QPublicBaseFragment {
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getActivity().getIntent();
        String stringExtra = intent.getStringExtra("schemestring");
        String stringExtra2 = intent.getStringExtra("src_biz");
        l.i("wjySchemeRouteTranslucentFragment", "onCreate - " + stringExtra);
        SchemeUtil.f(getActivity(), stringExtra, stringExtra2, true);
        getActivity().finish();
    }
}
