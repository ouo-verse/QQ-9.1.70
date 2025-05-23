package com.tencent.mobileqq.mutualmark.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.widget.MutualMarkIcon;
import com.tencent.relation.common.widget.squaredIndicator.SquaredIndicatorView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MutualMarkDemoFragment extends QPublicBaseFragment {
    private View C;
    private MutualMarkIcon D;
    private SquaredIndicatorView E;

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.f167360cw3, viewGroup, false);
        this.C = inflate;
        this.D = (MutualMarkIcon) inflate.findViewById(R.id.ohm);
        this.E = (SquaredIndicatorView) this.C.findViewById(R.id.ohl);
        return this.C;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.D.h(new MutualMarkModel());
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 20; i3++) {
            arrayList.add(new MutualMarkModel());
        }
        this.E.i(arrayList);
    }
}
