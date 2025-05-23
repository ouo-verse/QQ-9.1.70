package nw0;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.livewebdialog.f;
import com.tencent.icgame.game.liveroom.impl.room.payguide.showdialog.ShowDialogEvent;
import com.tencent.mobileqq.icgame.webview.LiveWebDialogEvent;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private TouchWebView f421446d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<Activity> f421447e;

    /* renamed from: f, reason: collision with root package name */
    private String f421448f = "";

    /* renamed from: h, reason: collision with root package name */
    private boolean f421449h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: nw0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C10868a implements PopupWindow.OnDismissListener {
        C10868a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a.this.a();
        }
    }

    public a() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private boolean b(ShowDialogEvent showDialogEvent) {
        if (showDialogEvent.getWebViewHashCode() == 0) {
            return true;
        }
        TouchWebView touchWebView = this.f421446d;
        if (touchWebView != null && touchWebView.hashCode() == showDialogEvent.getWebViewHashCode()) {
            return true;
        }
        return false;
    }

    private void e() {
        Activity activity;
        WeakReference<Activity> weakReference;
        if (this.f421446d != null && (weakReference = this.f421447e) != null && weakReference.get() != null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("ICGameUniteDialog", 1, "realShow");
            f.n(false, this.f421447e.get(), false, null, this.f421446d, new C10868a());
            return;
        }
        WeakReference<Activity> weakReference2 = this.f421447e;
        if (weakReference2 != null) {
            activity = weakReference2.get();
        } else {
            activity = null;
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("ICGameUniteDialog", 1, "realShow fail, webView=" + this.f421446d + ", activity=" + activity);
    }

    public void a() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.f421446d = null;
    }

    public boolean f(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).e("ICGameUniteDialog", 1, "show fail, url=" + str);
            return false;
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("ICGameUniteDialog", 1, "show, url=" + str);
        this.f421448f = str;
        this.f421447e = new WeakReference<>(activity);
        if (this.f421449h) {
            return true;
        }
        this.f421446d = f.g(activity, str, true);
        this.f421448f = "";
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
            if (showDialogEvent.getCmd().compareTo("showPopActivity") == 0 && b(showDialogEvent)) {
                e();
            }
        }
    }

    public void c() {
    }

    public void d() {
    }
}
