package a7;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends e15.b {
    public d(String str, View view) {
        super(str, view);
    }

    @Override // e15.b, e15.f
    public void l() {
        LottieLoader lottieLoader = this.E;
        if (lottieLoader != null && (lottieLoader instanceof com.qzone.homepage.diy.a)) {
            ((com.qzone.homepage.diy.a) lottieLoader).e();
        }
        super.l();
    }

    @Override // e15.b
    protected LottieLoader u(Context context) {
        com.qzone.homepage.diy.a aVar = new com.qzone.homepage.diy.a(context);
        int a16 = (int) (sy3.b.a() / 8);
        QZLog.i("QZoneLottieViewModel", 1, " lottie current can user cache size = " + a16);
        aVar.setMemoryCacheSize(a16);
        return aVar;
    }
}
