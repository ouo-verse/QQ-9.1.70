package ck4;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qqlive.webview.LiveWebDialogEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.livewebdialog.e;
import com.tencent.timi.game.liveroom.impl.room.payguide.showdialog.ShowDialogEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private TouchWebView f31054d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Activity> f31055e;

    /* renamed from: f, reason: collision with root package name */
    private String f31056f = "";

    /* renamed from: h, reason: collision with root package name */
    private boolean f31057h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ck4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C0198a implements PopupWindow.OnDismissListener {
        C0198a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a.this.a();
        }
    }

    public a() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private boolean c(ShowDialogEvent showDialogEvent) {
        if (showDialogEvent.getWebViewHashCode() == 0) {
            return true;
        }
        TouchWebView touchWebView = this.f31054d;
        if (touchWebView != null && touchWebView.hashCode() == showDialogEvent.getWebViewHashCode()) {
            return true;
        }
        return false;
    }

    private void d() {
        Activity activity;
        WeakReference<Activity> weakReference;
        if (this.f31054d != null && (weakReference = this.f31055e) != null && weakReference.get() != null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("UniteDialog", 1, "realShow");
            e.n(false, this.f31055e.get(), false, null, this.f31054d, new C0198a());
            return;
        }
        WeakReference<Activity> weakReference2 = this.f31055e;
        if (weakReference2 != null) {
            activity = weakReference2.get();
        } else {
            activity = null;
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("UniteDialog", 1, "realShow fail, webView=" + this.f31054d + ", activity=" + activity);
    }

    public void a() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        TouchWebView touchWebView = this.f31054d;
        if (touchWebView != null) {
            touchWebView.destroy();
        }
        this.f31054d = null;
    }

    public void b() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public boolean e(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("UniteDialog", 1, "show fail, url=" + str);
            return false;
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("UniteDialog", 1, "show, url=" + str);
        this.f31056f = str;
        this.f31055e = new WeakReference<>(activity);
        if (this.f31057h) {
            return true;
        }
        this.f31054d = e.f(activity, str, true);
        this.f31056f = "";
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(ShowDialogEvent.class);
        arrayList.add(LiveWebDialogEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof ShowDialogEvent) {
            ShowDialogEvent showDialogEvent = (ShowDialogEvent) simpleBaseEvent;
            if (showDialogEvent.getCmd().compareTo("showPopActivity") == 0 && c(showDialogEvent)) {
                d();
            }
        }
    }
}
