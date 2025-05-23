package com.qzone.reborn.feedx.part.userhome;

import android.view.View;
import androidx.lifecycle.Observer;
import com.qzone.reborn.userhome.header.QZoneFamousUserHomeNaviBar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class i extends com.qzone.reborn.feedx.part.g {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f55365d;

    /* renamed from: e, reason: collision with root package name */
    private QZoneFamousUserHomeNaviBar f55366e;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements Observer<x6.a> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(x6.a aVar) {
            if (!(!com.qzone.reborn.feedx.util.k.G(aVar))) {
                i.this.f55366e.q(aVar);
            } else {
                i.this.f55366e.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFamousUserNaviBarPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55366e = (QZoneFamousUserHomeNaviBar) view.findViewById(R.id.nci);
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f55365d = wVar;
        if (wVar != null) {
            wVar.C2().observe(getPartHost().getLifecycleOwner(), new a());
        }
    }
}
