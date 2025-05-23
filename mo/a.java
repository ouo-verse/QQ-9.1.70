package mo;

import androidx.lifecycle.Observer;
import com.qzone.reborn.userhome.header.QZoneUserHomeNaviBar;

/* compiled from: P */
/* loaded from: classes38.dex */
public final /* synthetic */ class a implements Observer {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ QZoneUserHomeNaviBar f417068d;

    public /* synthetic */ a(QZoneUserHomeNaviBar qZoneUserHomeNaviBar) {
        this.f417068d = qZoneUserHomeNaviBar;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f417068d.P((x6.a) obj);
    }
}
