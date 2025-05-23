package k6;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.qzone.component.banner.general.builder.GeneralModelBaseCardView;
import com.qzone.component.banner.general.builder.bigcard.GeneralBigCardView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a implements d<GeneralBigCardView> {

    /* renamed from: d, reason: collision with root package name */
    protected GeneralBigCardView f411719d;

    /* renamed from: e, reason: collision with root package name */
    protected ViewGroup f411720e;

    @Override // gf.r
    public void a() {
        QZoneVideoItemWidgetView d16 = d();
        if (d16 != null) {
            d16.a();
        }
    }

    /* renamed from: b */
    public void n(i6.a aVar, GeneralBigCardView generalBigCardView) {
        this.f411719d = generalBigCardView;
    }

    public ViewGroup c(GeneralModelBaseCardView generalModelBaseCardView) {
        ViewStub viewStub;
        ViewGroup viewGroup = this.f411720e;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (generalModelBaseCardView == null || (viewStub = (ViewStub) generalModelBaseCardView.findViewById(R.id.f192658)) == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewStub.inflate();
        this.f411720e = viewGroup2;
        return viewGroup2;
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        GeneralBigCardView generalBigCardView = this.f411719d;
        if (generalBigCardView != null) {
            return generalBigCardView.D;
        }
        return null;
    }

    @Override // gf.r
    public void pause() {
        QZoneVideoItemWidgetView d16 = d();
        if (d16 != null) {
            d16.pause();
        }
    }

    @Override // gf.r
    public void play() {
        QZoneVideoItemWidgetView d16 = d();
        if (d16 != null) {
            d16.play();
        }
    }
}
