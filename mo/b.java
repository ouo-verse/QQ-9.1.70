package mo;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.feedx.viewmodel.w;
import com.qzone.reborn.userhome.header.QZoneUserHomeNaviBar;
import com.tencent.mobileqq.R;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends com.qzone.reborn.feedx.widget.header.d {

    /* renamed from: f, reason: collision with root package name */
    private final QZoneUserHomeNaviBar f417069f;

    /* renamed from: h, reason: collision with root package name */
    private w f417070h;

    public b(View view) {
        super(view);
        this.f417069f = (QZoneUserHomeNaviBar) view.findViewById(R.id.nco);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public View e() {
        return this.f417069f;
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneDIYUserHomeHeaderNaviBarElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        w wVar = (w) k(w.class);
        this.f417070h = wVar;
        if (wVar != null) {
            MutableLiveData<x6.a> C2 = wVar.C2();
            LifecycleOwner i3 = i();
            QZoneUserHomeNaviBar qZoneUserHomeNaviBar = this.f417069f;
            Objects.requireNonNull(qZoneUserHomeNaviBar);
            C2.observe(i3, new a(qZoneUserHomeNaviBar));
        }
        this.f417069f.setBackgroundResource(R.color.a_n);
    }
}
