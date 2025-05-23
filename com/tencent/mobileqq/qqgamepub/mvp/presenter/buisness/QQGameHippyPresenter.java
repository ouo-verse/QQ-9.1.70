package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.viewpager.widget.ViewPager;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.g;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class QQGameHippyPresenter extends QQGameHippyBasePresenter<mh2.b, com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a> {
    static IPatchRedirector $redirector_;
    private final List<com.tencent.mobileqq.qqgamepub.view.a> G;
    private com.tencent.mobileqq.qqgamepub.hippy.view.a H;

    @SuppressLint({"HandlerLeak"})
    private final Handler I;

    /* loaded from: classes16.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameHippyPresenter.this);
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
            if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
                if (i3 == 102) {
                    int i16 = message.arg1;
                    try {
                        if (QQGameHippyPresenter.this.j()) {
                            ((mh2.b) ((com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a) QQGameHippyPresenter.this).f264631d.get()).N5(i16);
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        return;
                    }
                }
                return;
            }
            QQGameHippyPresenter.this.G(i3, message.arg1, message.arg2, (String) message.obj);
        }
    }

    public QQGameHippyPresenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.G = new ArrayList();
            this.I = new a();
        }
    }

    private void g0(int i3, int i16, int i17, Object obj) {
        if (this.f264636m != null) {
            Message message = new Message();
            message.what = i3;
            message.arg1 = i16;
            message.arg2 = i17;
            message.obj = obj;
            this.I.sendMessage(message);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    protected int B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return 5;
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public void D(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        super.D(str);
        if (j() && !TextUtils.isEmpty(str)) {
            QLog.d("QQGamePub_QQGameHippyPresenter", 1, "hippy,call handleAdReverseFeedBack arkViewId:" + str);
            int i3 = 0;
            ((mh2.b) this.f264631d.get()).o(false, 0);
            if (this.f264636m != null) {
                while (true) {
                    if (i3 < this.f264636m.size()) {
                        if (str.equals(String.valueOf(this.f264636m.get(i3).uniseq))) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 > -1 && i3 < this.G.size()) {
                    com.tencent.mobileqq.qqgamepub.view.a aVar = this.G.get(i3);
                    ViewPager n06 = ((mh2.b) this.f264631d.get()).n0();
                    if (this.H != null && n06 != null) {
                        int currentItem = n06.getCurrentItem();
                        if (currentItem == this.f264636m.size() - 1) {
                            currentItem--;
                        }
                        this.G.remove(aVar);
                        this.f264636m.remove(i3);
                        ((mh2.b) this.f264631d.get()).refreshHead(currentItem);
                        g0(2, currentItem, -1, GamePubAccountHelper.m(this.f264636m).toString());
                        g0(1, currentItem, -1, "");
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public void P(ArrayList<QQGameMsgInfo> arrayList) {
        boolean z16;
        int i3;
        int currentItem;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) arrayList);
            return;
        }
        super.P(arrayList);
        if (!j()) {
            return;
        }
        ViewPager n06 = ((mh2.b) this.f264631d.get()).n0();
        if (arrayList != null && arrayList.size() > 0) {
            com.tencent.mobileqq.qqgamepub.hippy.view.a aVar = this.H;
            if (aVar != null && aVar.getF373114d() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.f264636m == null) {
                return;
            }
            M m3 = this.f264632e;
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) m3).s(((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) m3).f() + arrayList.size());
            M m16 = this.f264632e;
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) m16).r(((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) m16).e() + arrayList.size());
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                this.f264636m.add(0, arrayList.get(i16));
                this.G.add(0, ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).createHeader(arrayList.get(i16), y()));
                if (!TextUtils.isEmpty(arrayList.get(i16).arkAppName)) {
                    this.C.add(arrayList.get(i16).arkAppName);
                }
                if (z16) {
                    currentItem = n06.getCurrentItem();
                } else {
                    currentItem = n06.getCurrentItem() + 1;
                }
                ((mh2.b) this.f264631d.get()).refreshHead(currentItem);
                if (TextUtils.isEmpty(arrayList.get(i16).gameAppId)) {
                    str = "";
                } else {
                    str = arrayList.get(i16).gameAppId;
                }
                C().f(str, arrayList.get(i16).paMsgid);
            }
            String jSONArray = GamePubAccountHelper.m(this.f264636m).toString();
            this.I.removeMessages(2);
            Message message = new Message();
            message.what = 2;
            if (n06 != null) {
                i3 = n06.getCurrentItem();
            } else {
                i3 = -1;
            }
            message.arg1 = i3;
            message.arg2 = -1;
            message.obj = jSONArray;
            this.I.sendMessage(message);
        }
    }

    public void S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        try {
            QQGameMsgInfo W = W(i3);
            if (i3 == 0 && W != null) {
                ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).l(W, 0, z());
                com.tencent.mobileqq.qqgamepub.view.a aVar = this.G.get(i3);
                if (aVar instanceof GameArkView) {
                    ((GameArkView) aVar).c();
                }
            }
        } catch (Throwable th5) {
            QLog.e("QQGamePub_QQGameHippyPresenter", 1, th5.getMessage());
        }
    }

    public boolean T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        int i3 = this.f264635i;
        if (i3 != 3 && i3 != 4) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a(this);
    }

    public void V(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        List<QQGameMsgInfo> list = this.f264636m;
        if (list != null && i3 < list.size()) {
            Message obtain = Message.obtain();
            obtain.what = 102;
            obtain.arg1 = i3;
            this.I.removeMessages(102);
            this.I.sendMessageDelayed(obtain, 200L);
        }
        List<QQGameMsgInfo> list2 = this.f264636m;
        if (list2 != null && list2.size() > 0) {
            if (i3 >= this.f264636m.size()) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQGameHippyPresenter.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            if (!QQGameHippyPresenter.this.j()) {
                                return;
                            }
                            ((mh2.b) ((com.tencent.mobileqq.qqgamepub.mvp.presenter.base.a) QQGameHippyPresenter.this).f264631d.get()).o(false, 0);
                            ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterAIO(QQGameHippyPresenter.this.y(), true);
                            QQGameHippyPresenter.this.C().d();
                        }
                    }
                }, 0L);
                return;
            }
            if (!j()) {
                return;
            }
            ((mh2.b) this.f264631d.get()).R0(i3);
            QQGameMsgInfo qQGameMsgInfo = this.f264636m.get(i3);
            GamePubAccountHelper.M(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), qQGameMsgInfo.paMsgid);
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) this.f264632e).m(i3, qQGameMsgInfo, z());
            this.I.removeMessages(1);
            Message obtain2 = Message.obtain();
            obtain2.what = 1;
            obtain2.arg1 = i3;
            obtain2.arg2 = -1;
            obtain2.obj = "";
            this.I.sendMessage(obtain2);
        }
    }

    public QQGameMsgInfo W(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQGameMsgInfo) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        List<QQGameMsgInfo> list = this.f264636m;
        if (list != null && i3 < list.size()) {
            return this.f264636m.get(i3);
        }
        return null;
    }

    public int X(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        List<QQGameMsgInfo> list = this.f264636m;
        if (list != null && i3 == list.size() && i3 > 0) {
            return i3 - 1;
        }
        return i3;
    }

    public com.tencent.mobileqq.qqgamepub.hippy.view.a Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.qqgamepub.hippy.view.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.H;
    }

    public List<com.tencent.mobileqq.qqgamepub.view.a> Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.G;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int a0() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) i()).d() != 0) {
            return 0;
        }
        String x16 = GamePubAccountHelper.x(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface());
        for (int i3 = 0; i3 < this.f264636m.size(); i3++) {
            QQGameMsgInfo qQGameMsgInfo = this.f264636m.get(i3);
            if (qQGameMsgInfo != null && (str = qQGameMsgInfo.paMsgid) != null && str.equals(x16)) {
                return i3;
            }
        }
        return 0;
    }

    public int b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        List<QQGameMsgInfo> list = this.f264636m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        com.tencent.mobileqq.qqgamepub.hippy.view.a aVar = this.H;
        if (aVar != null) {
            return aVar.getF373114d();
        }
        return 0;
    }

    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqgamepub.hippy.view.a aVar = this.H;
        if (aVar != null) {
            aVar.e(this.G, this.f264636m);
        }
    }

    public void e0(Context context, GamePAHippyFragment gamePAHippyFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) gamePAHippyFragment);
        } else {
            this.H = new com.tencent.mobileqq.qqgamepub.hippy.view.a(this.G, this.f264636m, context, gamePAHippyFragment);
        }
    }

    public void f0(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, obj);
        } else {
            this.I.removeCallbacksAndMessages(obj);
        }
    }

    public void h0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = -1;
        obtain.arg2 = (int) g.b(i3, MobileQQ.sMobileQQ.getResources());
        QLog.d("QQGamePub_QQGameHippyPresenter", 2, "#### height:" + obtain.arg2);
        this.I.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.n();
        if (!j()) {
            return;
        }
        Iterator<QQGameMsgInfo> it = this.f264636m.iterator();
        while (it.hasNext()) {
            this.G.add(((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).createHeader(it.next(), y()));
        }
        this.G.add(new MoreMsgHeaderView(y()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public JSONObject o(JSONObject jSONObject) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (JSONObject) iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSONObject);
        }
        if (jSONObject != null && this.f264636m != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("gameData", GamePubAccountHelper.m(this.f264636m));
                jSONObject2.put(HippyHeaderScrollViewController.HEADER_HEIGHT, 417);
                if (((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) i()).d() == 0) {
                    String x16 = GamePubAccountHelper.x(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface());
                    i3 = 0;
                    while (i3 < this.f264636m.size()) {
                        String str = this.f264636m.get(i3).paMsgid;
                        if (str != null && str.equals(x16)) {
                            break;
                        }
                        i3++;
                    }
                }
                i3 = 0;
                jSONObject2.put("index", i3);
                jSONObject.put("GpInitData", jSONObject2);
                if (QLog.isColorLevel()) {
                    QLog.d("QQGamePub_QQGameHippyPresenter", 1, "feedEventJson=" + jSONObject2.toString());
                }
            } catch (JSONException e16) {
                QLog.e("QQGamePub_QQGameHippyPresenter", 1, e16, new Object[0]);
            }
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public void p(GmpEnterInfoRsp gmpEnterInfoRsp, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, gmpEnterInfoRsp, Boolean.valueOf(z16));
            return;
        }
        super.p(gmpEnterInfoRsp, z16);
        if (!j()) {
            return;
        }
        ((mh2.b) this.f264631d.get()).q(gmpEnterInfoRsp, z16);
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.t();
        try {
            f0(null);
            for (com.tencent.mobileqq.qqgamepub.view.a aVar : this.G) {
                if (aVar != null) {
                    aVar.onDestory();
                }
            }
        } catch (Throwable th5) {
            QLog.e("QQGamePub_QQGameHippyPresenter", 1, th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter
    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "2";
    }
}
