package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.g;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e$AppFriendsInfo;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e$ReqBody;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e$RspBody;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d extends com.tencent.mobileqq.Doraemon.e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f154166d;

    /* renamed from: b, reason: collision with root package name */
    protected c f154167b;

    /* renamed from: c, reason: collision with root package name */
    protected e f154168c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends com.tencent.mobileqq.Doraemon.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.a f154169a;

        a(com.tencent.mobileqq.Doraemon.a aVar) {
            this.f154169a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.d
        protected void b(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
            } else if (bundle != null) {
                DoraemonUtil.e(this.f154169a, com.tencent.mobileqq.Doraemon.c.a(bundle));
            } else {
                DoraemonUtil.c(this.f154169a, 1, "get user info error, try again");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.Doraemon.a f154171d;

        b(com.tencent.mobileqq.Doraemon.a aVar) {
            this.f154171d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) aVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(d.f154166d, 2, "onResult appid=" + ((com.tencent.mobileqq.Doraemon.e) d.this).f154095a.f154071c + ", openid=" + d.this.f154167b.f154173a + ", openkey=" + d.this.f154167b.f154174b + ", code=" + i3);
            }
            if (i3 == 0 && bArr != null) {
                Oidb_0xb6e$RspBody oidb_0xb6e$RspBody = new Oidb_0xb6e$RspBody();
                try {
                    oidb_0xb6e$RspBody.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    oidb_0xb6e$RspBody = null;
                }
                if (oidb_0xb6e$RspBody != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    for (Oidb_0xb6e$AppFriendsInfo oidb_0xb6e$AppFriendsInfo : oidb_0xb6e$RspBody.rpt_friends_info.get()) {
                        String str = oidb_0xb6e$AppFriendsInfo.openid.get();
                        String stringUtf8 = oidb_0xb6e$AppFriendsInfo.nick.get().toStringUtf8();
                        String str2 = oidb_0xb6e$AppFriendsInfo.figure_url_qq.get();
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("openid", str.toUpperCase());
                                jSONObject2.put("nickName", stringUtf8);
                                jSONObject2.put(PhotoCategorySummaryInfo.AVATAR_URL, str2);
                                jSONArray.mo162put(jSONObject2);
                            } catch (JSONException e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(d.f154166d, 2, e17.getMessage(), e17);
                                }
                            }
                        }
                    }
                    try {
                        jSONObject.put("appfriends", jSONArray);
                    } catch (JSONException e18) {
                        if (QLog.isColorLevel()) {
                            QLog.e(d.f154166d, 2, e18.getMessage(), e18);
                        }
                    }
                    DoraemonUtil.e(this.f154171d, jSONObject);
                    return;
                }
                DoraemonUtil.c(this.f154171d, -1, "parse result error, try again");
                return;
            }
            DoraemonUtil.c(this.f154171d, i3, "getappfriends result error, try again");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f154173a;

        /* renamed from: b, reason: collision with root package name */
        public String f154174b;

        /* renamed from: c, reason: collision with root package name */
        public String f154175c;

        /* renamed from: d, reason: collision with root package name */
        public long f154176d;

        /* renamed from: e, reason: collision with root package name */
        public long f154177e;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public JSONObject a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("openid", this.f154173a);
                jSONObject.put(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, this.f154174b);
                jSONObject.put("pay_token", this.f154175c);
                jSONObject.put("expire_in", this.f154176d);
                jSONObject.put(VasQQSettingMeImpl.EXPIRE_TIME, this.f154177e);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(d.f154166d, 2, e16.getMessage(), e16);
                }
            }
            return jSONObject;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "LoginInfo{, openid='" + this.f154173a + "', access_token='" + this.f154174b + "', pay_token='" + this.f154175c + "', expireIn='" + this.f154176d + "', expireTime='" + this.f154177e + "'}";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66529);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f154166d = "DoraemonOpenAPI." + d.class.getSimpleName();
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Bundle g() {
        String str;
        QQAppInterface a16 = ed0.a.a();
        FriendsManager friendsManager = (FriendsManager) a16.getManager(QQManagerFactory.FRIENDS_MANAGER);
        String currentAccountUin = a16.getCurrentAccountUin();
        Card r16 = friendsManager.r(currentAccountUin);
        if (r16 != null) {
            String str2 = r16.strNick;
            short s16 = r16.shGender;
            int i3 = 1;
            if (s16 != 0) {
                if (s16 == 1) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
            }
            String str3 = r16.strCity;
            String str4 = r16.strProvince;
            String str5 = r16.strCountry;
            Setting qQHeadSettingFromDB = a16.getQQHeadSettingFromDB(currentAccountUin);
            if (qQHeadSettingFromDB != null && !TextUtils.isEmpty(qQHeadSettingFromDB.url)) {
                str = MsfSdkUtils.insertMtype("QQHeadIcon", AvatarDownloadUtil.getQQAvatarDownLoadUrl(qQHeadSettingFromDB.url, qQHeadSettingFromDB.bFaceFlags, qQHeadSettingFromDB.bUsrType, 0));
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(f154166d + ".getUserInfoDirectly", 2, "getUserInfo QQHeadSetting is empty");
                }
                str = "";
            }
            Bundle bundle = new Bundle();
            bundle.putString("nickName", str2);
            bundle.putInt("gender", i3);
            bundle.putString(PhotoCategorySummaryInfo.AVATAR_URL, str);
            bundle.putString("city", str3);
            bundle.putString("province", str4);
            bundle.putString("country", str5);
            if (QLog.isDevelopLevel()) {
                QLog.i(f154166d + ".getUserInfoDirectly", 2, bundle.toString());
            }
            return bundle;
        }
        return null;
    }

    private void i(JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i(f154166d + ".requestAppFriends", 2, "url params = " + jSONObject);
        }
        Oidb_0xb6e$ReqBody oidb_0xb6e$ReqBody = new Oidb_0xb6e$ReqBody();
        oidb_0xb6e$ReqBody.appid.set(Integer.valueOf(this.f154095a.f154071c).intValue());
        oidb_0xb6e$ReqBody.openid.set(this.f154167b.f154173a);
        oidb_0xb6e$ReqBody.openkey.set(this.f154167b.f154174b);
        oidb_0xb6e$ReqBody.platform.set("openmobile_android");
        ProtoUtils.c(BaseApplicationImpl.getApplication().getRuntime(), new b(aVar), oidb_0xb6e$ReqBody.toByteArray(), "OidbSvc.0xb6e", 2926, 1, null, 0L);
    }

    private void j(JSONObject jSONObject, com.tencent.mobileqq.Doraemon.a aVar) {
        if (DoraemonUtil.g()) {
            Bundle g16 = g();
            if (g16 != null) {
                DoraemonUtil.e(aVar, com.tencent.mobileqq.Doraemon.c.a(g16));
                return;
            } else {
                DoraemonUtil.c(aVar, 1, "get user info error, try again");
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(f154166d + ".requestUserInfo", 2, "not main process, send to main process");
        }
        g.b(1, null, new a(aVar));
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f154167b = null;
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.e
    public boolean c(int i3, String str, JSONObject jSONObject, @NonNull com.tencent.mobileqq.Doraemon.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, jSONObject, aVar)).booleanValue();
        }
        if (i3 != 5) {
            if (i3 != 10) {
                if (i3 != 17) {
                    if (i3 != 18) {
                        return false;
                    }
                    if (h()) {
                        DoraemonUtil.e(aVar, this.f154167b.a());
                        if (QLog.isColorLevel()) {
                            QLog.i(f154166d + "." + str, 2, "has login, use cache: " + this.f154167b.toString());
                        }
                        return true;
                    }
                    if (this.f154168c == null) {
                        this.f154168c = new e(this.f154095a, this);
                    }
                    this.f154168c.i(jSONObject, aVar, true);
                } else {
                    if (h() && !com.tencent.mobileqq.Doraemon.ui.a.L) {
                        DoraemonUtil.e(aVar, this.f154167b.a());
                        if (QLog.isColorLevel()) {
                            QLog.i(f154166d + "." + str, 2, "has login, use cache: " + this.f154167b.toString());
                        }
                        return true;
                    }
                    if (this.f154168c == null) {
                        this.f154168c = new e(this.f154095a, this);
                    }
                    this.f154168c.i(jSONObject, aVar, false);
                }
            } else {
                if (!h()) {
                    DoraemonUtil.d(aVar, 5);
                    return true;
                }
                j(jSONObject, aVar);
            }
        } else {
            if (!h()) {
                DoraemonUtil.d(aVar, 5);
                return true;
            }
            i(jSONObject, aVar);
        }
        return true;
    }

    public c f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f154167b;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        c cVar = this.f154167b;
        if (cVar != null && !TextUtils.isEmpty(cVar.f154173a) && !TextUtils.isEmpty(this.f154167b.f154174b)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.f154167b = cVar;
        }
    }
}
