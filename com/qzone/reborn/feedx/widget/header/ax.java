package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ax extends d {

    /* renamed from: f, reason: collision with root package name */
    private ImageView f56215f;

    /* renamed from: h, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f56216h;

    public ax(View view) {
        super(view);
        this.f56215f = (ImageView) view.findViewById(R.id.f162854n00);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(x6.a aVar) {
        ImageView imageView = this.f56215f;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(com.qzone.reborn.feedx.util.k.G(aVar) ? 0 : 8);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeSplitLineElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) k(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f56216h = wVar;
        if (wVar != null) {
            wVar.C2().observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.aw
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ax.this.o((x6.a) obj);
                }
            });
        }
    }
}
