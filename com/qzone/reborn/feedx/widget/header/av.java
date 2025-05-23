package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class av extends d {

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f56212f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f56213h;

    public av(View view) {
        super(view);
        this.f56213h = (TextView) view.findViewById(R.id.ncl);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeFriendshipElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) k(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f56212f = wVar;
        wVar.C2().observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                av.this.o((x6.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(x6.a aVar) {
        if (aVar != null && aVar.isSpecialCare) {
            this.f56213h.setVisibility(0);
            this.f56213h.setText(com.qzone.util.l.a(R.string.k3o));
        } else {
            this.f56213h.setVisibility(8);
        }
    }
}
