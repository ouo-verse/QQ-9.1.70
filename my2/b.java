package my2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import bu2.c;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.video.rfw.player.events.RFWTVKPlayerStatusEvent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.webview.TVideoPublicWebView;
import com.tencent.mobileqq.tvideo.webview.d;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONObject;
import zt2.e;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<TVideoPublicWebView> f417796a;

    /* renamed from: b, reason: collision with root package name */
    private final Observer<Integer> f417797b;

    /* renamed from: c, reason: collision with root package name */
    private final au2.a f417798c;

    public b(@NonNull TVideoPublicWebView tVideoPublicWebView) {
        Observer<Integer> observer = new Observer() { // from class: my2.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                b.this.d((Integer) obj);
            }
        };
        this.f417797b = observer;
        a aVar = new a();
        this.f417798c = aVar;
        this.f417796a = new WeakReference<>(tVideoPublicWebView);
        fy2.b.f400938a.c().observeForever(observer);
        e.f453199a.w(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Integer num) {
        if (num.intValue() > 0 && num.intValue() % 10 == 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WidgetCacheConstellationData.INTERVAL, 10);
                f(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, jSONObject.toString());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private boolean g() {
        if (this.f417796a.get() != null) {
            return true;
        }
        return false;
    }

    public void c(RFWTVKPlayerStatusEvent rFWTVKPlayerStatusEvent) {
        QLog.i("TVideoPendantViewController", 1, "handlePlayerStatusEvent:" + rFWTVKPlayerStatusEvent.getPlayerStatus());
        if (!g()) {
            return;
        }
        int playerStatus = rFWTVKPlayerStatusEvent.getPlayerStatus();
        if (playerStatus == 4) {
            f("playStart", "");
        } else if (playerStatus > 4) {
            f("playPause", "");
        }
    }

    public void e() {
        QLog.i("TVideoPendantViewController", 1, "release");
        fy2.b.f400938a.c().removeObserver(this.f417797b);
        e.f453199a.x(this.f417798c);
        WeakReference<TVideoPublicWebView> weakReference = this.f417796a;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public void f(String str, String str2) {
        if (g()) {
            this.f417796a.get().D(str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements au2.a {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // au2.a
        public void a(@NonNull bu2.a aVar) {
            d.v((CustomWebView) b.this.f417796a.get());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // au2.a
        public void d() {
            d.v((CustomWebView) b.this.f417796a.get());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // au2.a
        public void e(@NonNull bu2.a aVar) {
            d.v((CustomWebView) b.this.f417796a.get());
        }

        @Override // au2.a
        public void b(@NonNull c cVar) {
        }

        @Override // au2.a
        public void c(@Nullable bu2.a aVar) {
        }
    }
}
