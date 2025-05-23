package com.tencent.mobileqq.qqgamepub.mvp.model.bean;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.base.b;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import eipc.EIPCResult;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements kh2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQGameWebPresenter f264620d;

    /* renamed from: e, reason: collision with root package name */
    private int f264621e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.mobileqq.qqgamepub.model.a f264622f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.qqgamepub.view.a f264623h;

    /* renamed from: i, reason: collision with root package name */
    private int f264624i;

    public a(QQGameWebPresenter qQGameWebPresenter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQGameWebPresenter);
            return;
        }
        this.f264621e = 0;
        w(qQGameWebPresenter);
        this.f264622f = new com.tencent.mobileqq.qqgamepub.model.a();
    }

    private String i(AppInterface appInterface) {
        return appInterface.getApp().getSharedPreferences("game_center_sp", 0).getString("msgPos_web" + appInterface.getCurrentAccountUin(), "");
    }

    public com.tencent.mobileqq.qqgamepub.view.a a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (com.tencent.mobileqq.qqgamepub.view.a) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        return this.f264622f.c(i3);
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        String i3 = i(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface());
        if (!TextUtils.isEmpty(i3)) {
            for (int i16 = 0; i16 < l(); i16++) {
                QQGameMsgInfo c16 = c(i16);
                if (c16 != null && !TextUtils.isEmpty(c16.paMsgid) && c16.paMsgid.equals(i3)) {
                    return i16;
                }
            }
        }
        return 0;
    }

    public QQGameMsgInfo c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (QQGameMsgInfo) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        return this.f264622f.d(i3);
    }

    public com.tencent.mobileqq.qqgamepub.view.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.qqgamepub.view.a) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f264623h;
    }

    public com.tencent.mobileqq.qqgamepub.model.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.qqgamepub.model.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f264622f;
    }

    public String f(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        }
        int j3 = j();
        List<QQGameMsgInfo> g16 = this.f264622f.g();
        if (!TextUtils.isEmpty(str) && g16 != null && g16.size() > 0) {
            try {
                if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) == -1) {
                    str = str + "?gameData=" + URLEncoder.encode(g(), "utf-8") + "&index=" + j3 + "&height=" + i3 + "&_bid=4235";
                } else {
                    str = str + "&gameData=" + URLEncoder.encode(g(), "utf-8") + "&index=" + j3 + "&height=" + i3 + "&_bid=4235";
                }
                return str;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return str;
            }
        }
        if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) == -1) {
            return str + "?height=" + i3 + "&_bid=4235";
        }
        return str + "&height=" + i3 + "&_bid=4235";
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        List<QQGameMsgInfo> g16 = this.f264622f.g();
        if (g16 != null && g16.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (QQGameMsgInfo qQGameMsgInfo : g16) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("rawMsgId", qQGameMsgInfo.msgId);
                    jSONObject.put("adID", qQGameMsgInfo.paMsgid);
                    jSONObject.put("msgID", qQGameMsgInfo.paMsgid);
                    jSONObject.put("appID", qQGameMsgInfo.gameAppId);
                    jSONObject.put("msgTime", qQGameMsgInfo.msgTime);
                    if (!TextUtils.isEmpty(qQGameMsgInfo.sortedConfigs)) {
                        jSONObject.put("sorted_configs", qQGameMsgInfo.sortedConfigs);
                    }
                    if (!TextUtils.isEmpty(qQGameMsgInfo.extJson)) {
                        jSONObject.put(WadlProxyConsts.EXT_JSON, qQGameMsgInfo.extJson);
                    }
                    jSONArray.mo162put(jSONObject);
                }
                return jSONArray.toString();
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.f264622f.e();
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f264624i;
    }

    public int k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str)).intValue();
        }
        if (e().k()) {
            QLog.e("QQGameWebFeedModel", 1, "handleAdReverseFeedBack, msgInfoList is null");
        }
        for (int i3 = 0; i3 < l(); i3++) {
            if (str.equals(String.valueOf(this.f264622f.g().get(i3).uniseq))) {
                return i3;
            }
        }
        return -1;
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.f264622f.h();
    }

    public void m(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (QQGameMsgInfo qQGameMsgInfo : e().g()) {
            arrayList.add(((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).createHeader(qQGameMsgInfo, activity));
            if (!TextUtils.isEmpty(qQGameMsgInfo.arkAppName)) {
                this.f264620d.X(qQGameMsgInfo.arkAppName);
            }
        }
        arrayList.add(new MoreMsgHeaderView(activity));
        e().n(arrayList);
    }

    public boolean n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, i3)).booleanValue();
        }
        return this.f264622f.i(i3);
    }

    public boolean o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, i3)).booleanValue();
        }
        return this.f264622f.l(i3);
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f264621e > 0) {
            return true;
        }
        return false;
    }

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f264621e++;
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f264621e--;
        }
    }

    public void s(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appInterface, (Object) str);
            return;
        }
        appInterface.getApp().getSharedPreferences("game_center_sp", 0).edit().putString("msgPos_web" + appInterface.getCurrentAccountUin(), str).apply();
    }

    public void t(com.tencent.mobileqq.qqgamepub.view.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aVar);
        } else {
            this.f264623h = aVar;
        }
    }

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.f264624i = i3;
        }
    }

    public void v(EIPCResult eIPCResult) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) eIPCResult);
            return;
        }
        if (eIPCResult != null && eIPCResult.code == 0 && (bundle = eIPCResult.data) != null) {
            List<QQGameMsgInfo> list = (List) bundle.getSerializable("key_get_msg");
            if (list == null) {
                list = new ArrayList<>();
            }
            this.f264622f.o(list);
        }
    }

    public void w(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            this.f264620d = (QQGameWebPresenter) bVar;
        }
    }
}
