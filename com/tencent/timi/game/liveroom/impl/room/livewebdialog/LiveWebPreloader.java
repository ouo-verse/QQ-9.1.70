package com.tencent.timi.game.liveroom.impl.room.livewebdialog;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.livewebdialog.LiveWebView;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class LiveWebPreloader {

    /* renamed from: a, reason: collision with root package name */
    private String f377879a;

    /* renamed from: d, reason: collision with root package name */
    private LiveWebView f377882d;

    /* renamed from: b, reason: collision with root package name */
    private Queue<String> f377880b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f377881c = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    private LiveWebView.b f377883e = new a();

    /* renamed from: f, reason: collision with root package name */
    private Runnable f377884f = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.livewebdialog.LiveWebPreloader.2
        @Override // java.lang.Runnable
        public void run() {
            LiveWebPreloader.this.e();
        }
    };

    /* loaded from: classes26.dex */
    class a implements LiveWebView.b {
        a() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.livewebdialog.LiveWebView.b
        public void a(@Nullable String str) {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "OnLoadCallback.loadFinish", "preload finish, url=" + str);
            LiveWebPreloader.this.f377879a = "";
            LiveWebPreloader.this.l();
        }
    }

    private void c(String str) {
        if (this.f377881c.size() > 1000) {
            this.f377881c.clear();
        }
        this.f377881c.add(g(str));
    }

    private void d(String str) {
        this.f377880b.offer(str);
    }

    private void f() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f377884f);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.f377884f, 60000L);
    }

    private String g(String str) {
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    private boolean h(String str) {
        if (this.f377881c.contains(g(str))) {
            return true;
        }
        return false;
    }

    private boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "isUrl", "check url, url=null");
            return false;
        }
        AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "isUrl", "check url=" + str);
        Uri parse = Uri.parse(str);
        if (parse == null) {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "isUrl", "check url, uri=null");
            return false;
        }
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.indexOf("http") >= 0) {
            return true;
        }
        AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "isUrl", "check url, is not url");
        return false;
    }

    private void k() {
        AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preloadInner", "url=" + this.f377879a);
        this.f377882d.loadUrl(this.f377879a);
        c(this.f377879a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f377880b.size() == 0) {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preloadNext", "fail, mUrlQueue.size=0");
            f();
            return;
        }
        this.f377879a = this.f377880b.poll();
        AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preloadNext", "url=" + this.f377879a);
        k();
    }

    public void e() {
        AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", QCircleLpReportDc05507.KEY_CLEAR);
        this.f377879a = "";
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f377884f);
        LiveWebView liveWebView = this.f377882d;
        if (liveWebView != null) {
            liveWebView.destroy();
            this.f377882d = null;
        }
        Queue<String> queue = this.f377880b;
        if (queue != null && queue.size() > 0) {
            this.f377880b.clear();
        }
    }

    public void j(Activity activity, String str) {
        if (!ht3.a.e("qqlive_task_preload_web_config", false)) {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preload", "fail, switchOn closed, return");
            return;
        }
        if (activity.isFinishing()) {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preload", "fail, activity finish, return");
            return;
        }
        if (!i(str)) {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preload", "fail, is not url, url=" + str);
            return;
        }
        if (h(str)) {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preload", "is preloaded, return, url=" + str);
            return;
        }
        AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preload", "url=" + str);
        if (this.f377882d == null) {
            LiveWebView g16 = LiveWebViewContainer.g(activity, "", true);
            this.f377882d = g16;
            g16.setOnLoadCallback(this.f377883e);
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f377884f);
        if (TextUtils.isEmpty(this.f377879a)) {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preload", "now");
            this.f377879a = str;
            k();
        } else {
            AegisLogger.i("unknown|live_web_dialog[LiveWebPreloader]", "preload", "delay, add to queue");
            d(str);
        }
    }
}
