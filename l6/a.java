package l6;

import android.view.View;
import android.widget.ImageView;
import com.qzone.component.banner.general.builder.bigcard.GeneralBigCardView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends k6.a implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    protected i6.a f413874f;

    @Override // k6.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void n(i6.a aVar, GeneralBigCardView generalBigCardView) {
        super.n(aVar, generalBigCardView);
        QLog.d("BigCardGameBaseDecorator", 1, "decorate data=" + aVar);
        this.f413874f = aVar;
        GeneralBigCardView generalBigCardView2 = this.f411719d;
        if (generalBigCardView2 == null || aVar == null) {
            return;
        }
        generalBigCardView2.G.setVisibility(8);
        this.f411719d.F.setVisibility(8);
        ImageView imageView = (ImageView) this.f411719d.D.findViewById(R.id.l2y);
        if (imageView != null) {
            imageView.setImageResource(R.drawable.f15538f);
            imageView.setOnClickListener(this);
        }
        int f16 = d.f(this.f413874f, "app_type");
        d.j(this.f413874f.g(), "914334", "", this.f413874f.s(), "8", String.valueOf(f16), this.f413874f.e(), String.valueOf(this.f413874f.c()), d.a(f16));
        LpReportInfo_pf00064.allReport(619, 18, 1, "", "1");
        d.k(this.f413874f.d(), 101, "tianshu.289");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.l2y) {
            play();
            QLog.d("BigCardGameBaseDecorator", 1, "onclick mVideoView play");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // i6.e
    public void onClose() {
        if (this.f413874f != null) {
            LpReportInfo_pf00064.allReport(619, 18, 4, "", "1");
            int f16 = d.f(this.f413874f, "app_type");
            d.j(this.f413874f.g(), "914344", "", this.f413874f.s(), "20", String.valueOf(f16), this.f413874f.e(), String.valueOf(this.f413874f.c()), d.a(f16));
            d.k(this.f413874f.d(), 122, "tianshu.289");
        }
    }

    @Override // i6.e
    public void onDestroy() {
    }

    @Override // i6.e
    public void onInit() {
    }

    @Override // i6.e
    public void onPause() {
    }

    @Override // i6.e
    public void onResume() {
    }
}
