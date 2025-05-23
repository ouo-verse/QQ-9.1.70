package ih;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c {
    public static void a(String str, int i3, int i16, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i("QZoneAdFeedxPreloadUtil", 2, "[preloadVideoCover]width:" + i3 + " height:" + i16 + " url:" + str);
        Option obtain = Option.obtain();
        obtain.setUrl(str);
        obtain.setRequestWidth(i3);
        obtain.setRequestHeight(i16);
        if (imageView != null) {
            obtain.setTargetView(imageView);
            obtain.setNeedShowLoadingDrawable(false);
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(obtain, new a(i3, i16, str));
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f407620d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f407621e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f407622f;

        a(int i3, int i16, String str) {
            this.f407620d = i3;
            this.f407621e = i16;
            this.f407622f = str;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState == null || !loadState.isFinishSuccess()) {
                return;
            }
            QLog.i("QZoneAdFeedxPreloadUtil", 2, "[preloadVideoCover] successwidth:" + this.f407620d + " height:" + this.f407621e + " url:" + this.f407622f);
        }
    }
}
