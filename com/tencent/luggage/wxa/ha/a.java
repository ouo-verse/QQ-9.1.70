package com.tencent.luggage.wxa.ha;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends Fragment {
    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.luggage.wxa.fa.a.a().b(this, 7);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.luggage.wxa.fa.a.a().b(this, 13);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.tencent.luggage.wxa.fa.a.a().b(this, 12);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
        com.tencent.luggage.wxa.fa.a.a().a(this, z16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.luggage.wxa.fa.a.a().b(this, 9);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.luggage.wxa.fa.a.a().b(this, 8);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        com.tencent.luggage.wxa.fa.a.a().b(this, z16);
    }
}
