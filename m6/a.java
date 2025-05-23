package m6;

import android.view.ViewGroup;
import com.qzone.component.banner.general.builder.bigcard.GeneralBigCardView;
import com.qzone.component.banner.general.view.GameCenterMallBottom;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends l6.a {

    /* renamed from: h, reason: collision with root package name */
    private GameCenterMallBottom f416290h;

    @Override // l6.a, k6.d
    /* renamed from: b */
    public void n(i6.a aVar, GeneralBigCardView generalBigCardView) {
        try {
            super.n(aVar, generalBigCardView);
            GameCenterMallBottom gameCenterMallBottom = new GameCenterMallBottom(generalBigCardView.getContext());
            this.f416290h = gameCenterMallBottom;
            gameCenterMallBottom.d(aVar);
            QLog.d("BigCardMallDecorator", 1, "decorate data=" + aVar);
            if (this.f411720e == null) {
                this.f411720e = c(generalBigCardView);
            }
            ViewGroup viewGroup = this.f411720e;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.f411720e.addView(this.f416290h);
            }
        } catch (Throwable th5) {
            QLog.e("BigCardMallDecorator", 1, th5, new Object[0]);
            if (generalBigCardView != null) {
                generalBigCardView.setVisibility(8);
            }
        }
    }

    @Override // l6.a, i6.e
    public void onDestroy() {
    }

    @Override // l6.a, i6.e
    public void onInit() {
    }

    @Override // l6.a, i6.e
    public void onPause() {
    }

    @Override // l6.a, i6.e
    public void onResume() {
    }
}
