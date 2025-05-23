package mo;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.personalize.model.CustomNaviCacheData;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.reborn.userhome.header.QZoneUserHomeNaviBar;
import com.tencent.mobileqq.R;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i extends com.qzone.reborn.feedx.widget.header.d {

    /* renamed from: f, reason: collision with root package name */
    public final QZoneUserHomeNaviBar f417077f;

    /* renamed from: h, reason: collision with root package name */
    private w f417078h;

    public i(View view) {
        super(view);
        this.f417077f = (QZoneUserHomeNaviBar) view.findViewById(R.id.nco);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public View e() {
        return this.f417077f;
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeHeaderNaviBarElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        w wVar = (w) k(w.class);
        this.f417078h = wVar;
        if (wVar != null) {
            MutableLiveData<x6.a> C2 = wVar.C2();
            LifecycleOwner i3 = i();
            QZoneUserHomeNaviBar qZoneUserHomeNaviBar = this.f417077f;
            Objects.requireNonNull(qZoneUserHomeNaviBar);
            C2.observe(i3, new a(qZoneUserHomeNaviBar));
            MutableLiveData<CustomNaviCacheData> A2 = this.f417078h.A2();
            LifecycleOwner i16 = i();
            final QZoneUserHomeNaviBar qZoneUserHomeNaviBar2 = this.f417077f;
            Objects.requireNonNull(qZoneUserHomeNaviBar2);
            A2.observe(i16, new Observer() { // from class: mo.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZoneUserHomeNaviBar.this.J((CustomNaviCacheData) obj);
                }
            });
            this.f417078h.r2();
        }
        MutableLiveData<Integer> M1 = ((com.qzone.reborn.feedx.viewmodel.f) k(com.qzone.reborn.feedx.viewmodel.f.class)).M1();
        LifecycleOwner i17 = i();
        final QZoneUserHomeNaviBar qZoneUserHomeNaviBar3 = this.f417077f;
        Objects.requireNonNull(qZoneUserHomeNaviBar3);
        M1.observe(i17, new Observer() { // from class: mo.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneUserHomeNaviBar.this.h(((Integer) obj).intValue());
            }
        });
    }

    public void n(boolean z16) {
        QZoneUserHomeNaviBar qZoneUserHomeNaviBar = this.f417077f;
        if (qZoneUserHomeNaviBar == null) {
            return;
        }
        qZoneUserHomeNaviBar.I(z16);
    }
}
