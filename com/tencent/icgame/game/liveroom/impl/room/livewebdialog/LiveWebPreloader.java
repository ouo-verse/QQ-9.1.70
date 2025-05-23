package com.tencent.icgame.game.liveroom.impl.room.livewebdialog;

import android.app.Activity;
import com.tencent.icgame.game.liveroom.impl.room.livewebdialog.LiveWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class LiveWebPreloader {

    /* renamed from: a, reason: collision with root package name */
    private String f115418a;

    /* renamed from: d, reason: collision with root package name */
    private LiveWebView f115421d;

    /* renamed from: b, reason: collision with root package name */
    private Queue<String> f115419b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f115420c = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private LiveWebView.b f115422e = new a();

    /* renamed from: f, reason: collision with root package name */
    private Runnable f115423f = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.livewebdialog.LiveWebPreloader.2
        @Override // java.lang.Runnable
        public void run() {
            LiveWebPreloader.this.d();
        }
    };

    /* loaded from: classes7.dex */
    class a implements LiveWebView.b {
        a() {
        }

        @Override // com.tencent.icgame.game.liveroom.impl.room.livewebdialog.LiveWebView.b
        public void a(@Nullable String str) {
            rt0.a.f("ICGameUnknown|ICGameLive_web_dialogICGame[LiveWebPreloader]", "OnLoadCallback.loadFinish", "preload finish, url=" + str);
            LiveWebPreloader.this.f115418a = "";
            LiveWebPreloader.this.i();
        }
    }

    private void c(String str) {
        if (this.f115420c.size() > 1000) {
            this.f115420c.clear();
        }
        this.f115420c.add(f(str));
    }

    private void e() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f115423f);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.f115423f, 60000L);
    }

    private String f(String str) {
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    private void h() {
        rt0.a.f("ICGameUnknown|ICGameLive_web_dialogICGame[LiveWebPreloader]", "preloadInner", "url=" + this.f115418a);
        this.f115421d.loadUrl(this.f115418a);
        c(this.f115418a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f115419b.size() == 0) {
            rt0.a.f("ICGameUnknown|ICGameLive_web_dialogICGame[LiveWebPreloader]", "preloadNext", "fail, mUrlQueue.size=0");
            e();
            return;
        }
        this.f115418a = this.f115419b.poll();
        rt0.a.f("ICGameUnknown|ICGameLive_web_dialogICGame[LiveWebPreloader]", "preloadNext", "url=" + this.f115418a);
        h();
    }

    public void d() {
        rt0.a.e("ICGameUnknown|ICGameLive_web_dialogICGame[LiveWebPreloader]", QCircleLpReportDc05507.KEY_CLEAR);
        this.f115418a = "";
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f115423f);
        LiveWebView liveWebView = this.f115421d;
        if (liveWebView != null) {
            liveWebView.destroy();
            this.f115421d = null;
        }
        Queue<String> queue = this.f115419b;
        if (queue != null && queue.size() > 0) {
            this.f115419b.clear();
        }
    }

    public void g(Activity activity, String str) {
    }
}
