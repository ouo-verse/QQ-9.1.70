package l6;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qzone.component.banner.general.builder.bigcard.GeneralBigCardView;
import com.qzone.component.banner.general.view.GameCenterGameBottom;
import com.qzone.util.am;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends a {

    /* renamed from: h, reason: collision with root package name */
    protected GameCenterGameBottom f413875h;

    @Override // l6.a, k6.d
    /* renamed from: b */
    public void n(i6.a aVar, GeneralBigCardView generalBigCardView) {
        try {
            super.n(aVar, generalBigCardView);
            GameCenterGameBottom gameCenterGameBottom = new GameCenterGameBottom(generalBigCardView.getContext());
            this.f413875h = gameCenterGameBottom;
            gameCenterGameBottom.n(aVar);
            QLog.d("BigCardGameDecorator", 1, "decorate data=" + aVar);
            if (this.f411720e == null) {
                this.f411720e = c(generalBigCardView);
            }
            ViewGroup viewGroup = this.f411720e;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.f411720e.addView(this.f413875h);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) generalBigCardView.I.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = 0;
            }
            if (aVar == null || am.h(aVar.f())) {
                return;
            }
            this.f413875h.setMinimumHeight(generalBigCardView.getMeasuredWidth() / 5);
        } catch (Throwable th5) {
            QLog.e("BigCardGameDecorator", 1, th5, new Object[0]);
            if (generalBigCardView != null) {
                generalBigCardView.setVisibility(8);
            }
        }
    }

    @Override // l6.a, i6.e
    public void onDestroy() {
        GameCenterGameBottom gameCenterGameBottom = this.f413875h;
        if (gameCenterGameBottom != null) {
            gameCenterGameBottom.o();
        }
    }

    @Override // l6.a, i6.e
    public void onInit() {
        GameCenterGameBottom gameCenterGameBottom;
        QLog.d("BigCardGameDecorator", 1, "onInit mCard=" + this.f411719d + ",mGameBottomView=" + this.f413875h);
        GeneralBigCardView generalBigCardView = this.f411719d;
        if (generalBigCardView == null || (gameCenterGameBottom = this.f413875h) == null) {
            return;
        }
        gameCenterGameBottom.setActionCallback(generalBigCardView.f());
    }

    @Override // l6.a, i6.e
    public void onResume() {
        GameCenterGameBottom gameCenterGameBottom = this.f413875h;
        if (gameCenterGameBottom != null) {
            gameCenterGameBottom.q();
        }
    }

    @Override // l6.a, i6.e
    public void onPause() {
    }
}
