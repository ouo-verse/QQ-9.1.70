package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.d;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends QQGameHippyBasePresenter<Object, com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a> {
    static IPatchRedirector $redirector_;

    @SuppressLint({"HandlerLeak"})
    private final Handler G;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
                b.this.G(i3, message.arg1, message.arg2, (String) message.obj);
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.G = new a(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S() {
        if (((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("qqgame_pub_preload_mini_game_switch")) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).preloadMiniGame();
            QLog.i("QQGamePub_QQGameHippyPresenterV2", 2, MiniGameKuiklyModule.METHOD_PRELOAD_MINI_GAME);
        }
    }

    private void T() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.a
            @Override // java.lang.Runnable
            public final void run() {
                b.S();
            }
        }, 16, null, false);
    }

    private void U() {
        String jSONArray = GamePubAccountHelper.o(this.f264636m, ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).b(), ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).d(), null).toString();
        this.G.removeMessages(2);
        Message message = new Message();
        message.what = 2;
        message.arg1 = -1;
        message.arg2 = -1;
        message.obj = jSONArray;
        this.G.sendMessage(message);
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    protected int B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 12;
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public void D(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            QLog.d("QQGamePub_QQGameHippyPresenterV2", 1, "hippyV2,call handleAdReverseFeedBack arkViewId:" + str);
            for (QQGameMsgInfo qQGameMsgInfo : this.f264636m) {
                if (str.equals(String.valueOf(qQGameMsgInfo.uniseq))) {
                    this.f264636m.remove(qQGameMsgInfo);
                    U();
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public void P(ArrayList<QQGameMsgInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
        } else if (arrayList != null && arrayList.size() > 0) {
            this.f264636m.addAll(0, arrayList);
            U();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a(this);
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a
    public void e(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
        } else {
            super.e(activity);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a
    public void f(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) configuration);
        } else {
            super.f(configuration);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.h();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public JSONObject o(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
        }
        if (jSONObject != null) {
            try {
                JSONObject jsInitData = ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getJsInitData(y(), new d(this.f264636m, ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).b(), ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).d()));
                if (jsInitData != null) {
                    Iterator keys = jsInitData.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        jSONObject.put(str, jsInitData.opt(str));
                    }
                }
            } catch (Exception e16) {
                QLog.e("QQGamePub_QQGameHippyPresenterV2", 1, e16.getMessage());
            }
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public View r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        }
        T();
        return super.r(layoutInflater, viewGroup, bundle);
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.t();
            this.G.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return GamePubAccountHelper.s();
    }
}
