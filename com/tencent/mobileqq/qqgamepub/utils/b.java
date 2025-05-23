package com.tencent.mobileqq.qqgamepub.utils;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.QGameBusEvent;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends Observable implements Handler.Callback, SimpleEventReceiver, Observer {
    static IPatchRedirector $redirector_;
    public static b C;

    /* renamed from: d, reason: collision with root package name */
    private int f264707d;

    /* renamed from: e, reason: collision with root package name */
    private String f264708e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<GameArkView> f264709f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<QQGamePubWebView> f264710h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<HippyEngine> f264711i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f264712m;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f264707d = -1;
            this.f264712m = new Handler(this);
        }
    }

    public static void b(int i3) {
        GamePubAccountHelper.e(i3);
    }

    public static b c() {
        if (C == null) {
            synchronized (b.class) {
                if (C == null) {
                    C = new b();
                }
            }
        }
        return C;
    }

    private void f() {
        QLog.d("QQGamePub_GameVideoManager", 4, "------>resumeFeedVideo");
    }

    private void j() {
        int i3 = this.f264707d;
        if (i3 == 1) {
            m();
            return;
        }
        if (i3 == 2) {
            k();
        } else if (i3 == 2) {
            l();
        } else {
            QLog.e("QQGamePub_GameVideoManager", 2, "qgame_pub type no set");
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).removeNotify("com.tencent.gamecenter.newvideo");
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).deleteObserver(this);
        this.f264710h = null;
        this.f264709f = null;
        this.f264711i = null;
        C = null;
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.f264707d = i3;
        SimpleEventBus.getInstance().registerReceiver(this);
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.gamecenter.newvideo");
        ((IArkPubicEventWrap) QRoute.api(IArkPubicEventWrap.class)).addObserver(this);
    }

    public void e() {
        GameArkView gameArkView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.d("QQGamePub_GameVideoManager", 4, "--->playArkVideo viewId:" + this.f264708e);
        WeakReference<GameArkView> weakReference = this.f264709f;
        if (weakReference != null && (gameArkView = weakReference.get()) != null && !TextUtils.isEmpty(this.f264708e) && gameArkView.h() && GamePubAccountHelper.E(gameArkView.f())) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("viewId", this.f264708e);
                ark.arkNotify("com.tencent.gamecenter.newvideo", "", "notift_ark_video_play", jSONObject.toString(), ark.ARKMETADATA_JSON);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void g(GameArkView gameArkView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gameArkView);
        } else if (gameArkView != null) {
            this.f264709f = new WeakReference<>(gameArkView);
        } else {
            this.f264709f = null;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QGameBusEvent.class);
        return arrayList;
    }

    public void h(QQGamePubWebView qQGamePubWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQGamePubWebView);
        } else if (qQGamePubWebView != null) {
            this.f264710h = new WeakReference<>(qQGamePubWebView);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        return false;
    }

    public void i() {
        GameArkView gameArkView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d("QQGamePub_GameVideoManager", 4, "--->stopArkVideo viewId:" + this.f264708e);
        WeakReference<GameArkView> weakReference = this.f264709f;
        if (weakReference != null && (gameArkView = weakReference.get()) != null && !TextUtils.isEmpty(this.f264708e) && gameArkView.h() && GamePubAccountHelper.E(gameArkView.f())) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("viewId", this.f264708e);
                ark.arkNotify("com.tencent.gamecenter.newvideo", "", "notift_ark_video_stop", jSONObject.toString(), ark.ARKMETADATA_JSON);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        WeakReference<QQGamePubWebView> weakReference = this.f264710h;
        if (weakReference != null) {
            QQGamePubWebView qQGamePubWebView = weakReference.get();
            qQGamePubWebView.getPluginEngine().s(qQGamePubWebView.getUrl(), 8589934625L, null);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        WeakReference<HippyEngine> weakReference = this.f264711i;
        if (weakReference != null) {
            ((EventDispatcher) weakReference.get().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onGameFeedsPause", null);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).stopVideo();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QGameBusEvent) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceiveEvent() called with: event = [");
            QGameBusEvent qGameBusEvent = (QGameBusEvent) simpleBaseEvent;
            sb5.append(qGameBusEvent.eventType);
            sb5.append("]");
            QLog.d("QQGamePub_GameVideoManager", 4, sb5.toString());
            switch (qGameBusEvent.eventType) {
                case 1:
                case 5:
                    e();
                    return;
                case 2:
                case 6:
                    i();
                    return;
                case 3:
                    f();
                    return;
                case 4:
                    j();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) observable, obj);
            return;
        }
        try {
            if (obj instanceof IArkPubicEventWrap.a) {
                String str = ((IArkPubicEventWrap.a) obj).f279242a;
                String str2 = ((IArkPubicEventWrap.a) obj).f279243b;
                String str3 = ((IArkPubicEventWrap.a) obj).f279244c;
                if (!TextUtils.isEmpty(str) && "com.tencent.gamecenter.newvideo".equals(str) && !TextUtils.isEmpty(str2) && "gc_ark_video_play".equals(str2) && !TextUtils.isEmpty(str3)) {
                    JSONObject jSONObject = new JSONObject(str3);
                    String optString = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL, "");
                    String optString2 = jSONObject.optString("viewId", "");
                    QLog.d("QQGamePub_GameVideoManager", 2, "update videoUrl: " + optString);
                    QLog.d("QQGamePub_GameVideoManager", 2, "update viewId: " + optString2);
                    this.f264708e = optString2;
                    j();
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
