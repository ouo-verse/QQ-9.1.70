package com.tencent.mobileqq.webview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewAioShareMusicHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WebViewFragment f313782a;

    /* renamed from: b, reason: collision with root package name */
    public String f313783b;

    /* renamed from: c, reason: collision with root package name */
    private String f313784c;

    /* renamed from: d, reason: collision with root package name */
    private int f313785d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f313786e;

    /* renamed from: f, reason: collision with root package name */
    private String f313787f;

    /* renamed from: g, reason: collision with root package name */
    private int f313788g;

    /* renamed from: h, reason: collision with root package name */
    private String f313789h;

    /* renamed from: i, reason: collision with root package name */
    private int f313790i;

    /* renamed from: j, reason: collision with root package name */
    private int f313791j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f313792k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f313793l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f313794m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewAioShareMusicHelper.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    public WebViewAioShareMusicHelper(WebViewFragment webViewFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) webViewFragment);
        } else {
            this.f313782a = webViewFragment;
        }
    }

    private boolean d() {
        if (!TextUtils.isEmpty(this.f313789h) && this.f313782a.getAppRuntime().getAccount().equals(this.f313789h)) {
            return true;
        }
        return false;
    }

    private boolean g(String str) {
        TroopInfo troopInfoFromCache;
        if (!TextUtils.isEmpty(str) && (troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str)) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " isTroopAdminOrOwner() troopInfo = " + troopInfoFromCache.isOwnerOrAdmin());
            }
            if (troopInfoFromCache.isTroopOwner(this.f313782a.getAppRuntime().getAccount()) || troopInfoFromCache.isOwnerOrAdmin()) {
                return true;
            }
        }
        return false;
    }

    private void i(Intent intent) {
        String str;
        String str2;
        int i3;
        String stringExtra = intent.getStringExtra("forward_ark_app_meta");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra).getJSONObject("music");
                Bundle extras = intent.getExtras();
                if (this.f313785d == 0) {
                    str = "friend_uin";
                } else {
                    str = "groupUin";
                }
                Object string = extras.getString(str, "");
                if (this.f313785d == 0) {
                    str2 = AppConstants.Key.H5_ARK_URL_WEB_SENDER_UIN;
                } else {
                    str2 = "friendUin";
                }
                Object string2 = extras.getString(str2);
                int i16 = jSONObject.getInt("appid");
                Object string3 = jSONObject.getString("title");
                Object string4 = jSONObject.getString("musicUrl");
                String string5 = jSONObject.getString("desc");
                JSONObject jSONObject2 = new JSONObject();
                if (this.f313785d == 0) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                jSONObject2.put("enum_aio_type", i3);
                jSONObject2.put("uint64_id", string);
                jSONObject2.put("uint32_share_appid", i16);
                jSONObject2.put("bytes_song_name", string3);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("singer", string5);
                jSONArray.mo162put(jSONObject3);
                jSONObject2.put("rpt_bytes_singer", jSONArray);
                jSONObject2.put("bytes_song_url", string4);
                jSONObject2.put("bool_cut_song", this.f313786e);
                jSONObject2.put("str_song_id", this.f313787f);
                jSONObject2.put("uint32_duration", this.f313788g);
                jSONObject2.put("uint64_sharer_uin", string2);
                jSONObject2.put("bytes_cover", this.f313784c);
                if (QLog.isColorLevel()) {
                    QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "realStartAioShareMusic() jsonObject = " + jSONObject2.toString());
                }
                com.tencent.aiosharemusic.b.b(jSONObject2, "startListenAioShareMusic", null);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    private void j(String str) {
        WebViewFragment webViewFragment = this.f313782a;
        if (webViewFragment != null && webViewFragment.getQBaseActivity() != null) {
            DialogUtil.createCustomDialog(this.f313782a.getQBaseActivity(), 230).setMessage(str).setPositiveButton(R.string.f171094it1, new a()).show();
        }
    }

    private void k(String str) {
        if (this.f313782a != null) {
            QQToast.makeText(BaseApplicationImpl.getApplication(), str, 1).show();
        }
    }

    public void c(Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        if (intent == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " checkAndShowAioShareMusic inten is null ");
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("forward_ark_app_view");
        this.f313785d = intent.getIntExtra("uinType", 0);
        if ("music".equalsIgnoreCase(stringExtra)) {
            int i3 = this.f313785d;
            int i16 = 1;
            if (i3 == 0 || i3 == 1) {
                String stringExtra2 = intent.getStringExtra("forward_ark_app_meta");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra2).getJSONObject("music");
                        if (this.f313785d == 0) {
                            str = "friend_uin";
                        } else {
                            str = "groupUin";
                        }
                        Object stringExtra3 = intent.getStringExtra(str);
                        int i17 = jSONObject.getInt("appid");
                        Object string = jSONObject.getString("title");
                        Object string2 = jSONObject.getString("musicUrl");
                        String string3 = jSONObject.getString("desc");
                        this.f313784c = jSONObject.getString("preview");
                        JSONObject jSONObject2 = new JSONObject();
                        if (this.f313785d == 0) {
                            i16 = 2;
                        }
                        jSONObject2.put("enum_aio_type", i16);
                        jSONObject2.put("uint64_id", stringExtra3);
                        jSONObject2.put("uint32_share_appid", i17);
                        jSONObject2.put("bytes_song_name", string);
                        jSONObject2.put("uint32_duration", 0);
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("singer", string3);
                        jSONArray.mo162put(jSONObject3);
                        jSONObject2.put("rpt_bytes_singer", jSONArray);
                        jSONObject2.put("bytes_song_url", string2);
                        if (QLog.isColorLevel()) {
                            QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " type is music jsonObject = " + jSONObject2.toString());
                        }
                        com.tencent.aiosharemusic.b.b(jSONObject2, "checkAioShareMusic", null);
                        return;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " type is not music just return, ShareType = " + stringExtra + " mAioType = " + this.f313785d);
        }
    }

    public void e(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            boolean z16 = jSONObject.getBoolean("isSuccess");
            if (QLog.isColorLevel()) {
                QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "handleCheckAioShareMusic() isSuccess = " + z16 + " data = " + jSONObject.toString());
            }
            if (z16) {
                boolean z17 = jSONObject.getBoolean("bool_show_icon");
                this.f313790i = jSONObject.getInt("enum_aio_state");
                this.f313791j = jSONObject.getInt("enum_media_type");
                this.f313787f = jSONObject.getString("str_song_id");
                this.f313788g = jSONObject.getInt("uint32_duration");
                this.f313789h = String.valueOf(jSONObject.getLong("uint64_create_uin"));
                this.f313792k = jSONObject.getBoolean("bool_song_existed");
                this.f313793l = jSONObject.getBoolean("bool_allow_member_start");
                this.f313794m = jSONObject.getBoolean("bool_allow_member_add");
                this.f313783b = jSONObject.getString("current_song_id");
                WebViewFragment webViewFragment = this.f313782a;
                if (webViewFragment != null && webViewFragment.getQBaseActivity() != null) {
                    this.f313782a.getQBaseActivity().runOnUiThread(new Runnable(z17) { // from class: com.tencent.mobileqq.webview.WebViewAioShareMusicHelper.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f313795d;

                        {
                            this.f313795d = z17;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, WebViewAioShareMusicHelper.this, Boolean.valueOf(z17));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (WebViewAioShareMusicHelper.this.f313782a != null && WebViewAioShareMusicHelper.this.f313782a.getUIStyleHandler() != null) {
                                WebViewAioShareMusicHelper.this.f313782a.getUIStyleHandler().Z(this.f313795d, WebViewAioShareMusicHelper.this.f313785d);
                            }
                        }
                    });
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void f(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSONObject);
            return;
        }
        try {
            WebViewFragment webViewFragment = this.f313782a;
            if (webViewFragment != null && jSONObject != null && webViewFragment.getQBaseActivity() != null) {
                boolean z16 = jSONObject.getBoolean("isSuccess");
                if (!z16) {
                    int i3 = jSONObject.getInt("uint32_result");
                    String string = jSONObject.getString("bytes_errmsg");
                    if (!TextUtils.isEmpty(string)) {
                        switch (i3) {
                            default:
                                switch (i3) {
                                    case 10100:
                                        k(String.format(this.f313782a.getString(R.string.f171071ft1), string));
                                        break;
                                    case 10102:
                                        k(string);
                                        break;
                                    case TVKEventId.PLAYER_STATE_START_PLAY /* 10103 */:
                                        j(string);
                                        break;
                                }
                            case 10001:
                            case 10002:
                            case 10003:
                            case 10004:
                                k(this.f313782a.getString(R.string.cpp));
                                break;
                        }
                    }
                } else {
                    k(this.f313782a.getString(R.string.fsp));
                    this.f313782a.getQBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.webview.WebViewAioShareMusicHelper.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewAioShareMusicHelper.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                WebViewAioShareMusicHelper.this.f313782a.doOnBackEvent();
                            }
                        }
                    });
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "handleCheckAioShareMusic() isSuccess = " + z16 + " data = " + jSONObject.toString());
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "handleCheckAioShareMusic()  data  = " + jSONObject + " mWebViewFragment = " + this.f313782a);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f313782a = null;
        }
    }

    public void l(Intent intent) {
        String str;
        String str2;
        String str3;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        if (intent != null && this.f313782a != null) {
            this.f313786e = true;
            String stringExtra = intent.getStringExtra("groupUin");
            int i16 = this.f313785d;
            if (i16 == 0) {
                str = "c2c_AIO";
            } else {
                str = "Grp_AIO";
            }
            if (i16 == 0) {
                str2 = "clk_share_c2c";
            } else {
                str2 = "clk_share_grp";
            }
            if (i16 == 0) {
                str3 = "";
            } else {
                str3 = stringExtra;
            }
            ReportController.o(null, "dc00899", str, "", "music_tab", str2, 0, 0, str3, "", "", "");
            int i17 = this.f313791j;
            if (i17 != 1 && this.f313790i != 3) {
                WebViewFragment webViewFragment = this.f313782a;
                if (i17 == 2) {
                    i3 = R.string.ix8;
                } else {
                    i3 = R.string.ix7;
                }
                k(String.format(this.f313782a.getString(R.string.f171071ft1), webViewFragment.getString(i3)));
                return;
            }
            if (this.f313790i != 3 && this.f313783b.equals(this.f313787f)) {
                k(this.f313782a.getString(R.string.e5w));
                return;
            }
            if (this.f313785d == 1) {
                boolean g16 = g(stringExtra);
                int i18 = this.f313790i;
                if (i18 == 3 && !g16 && !this.f313793l) {
                    j(this.f313782a.getString(R.string.dfr));
                    return;
                }
                if (i18 == 3 && !g16 && this.f313793l && !this.f313794m) {
                    j(this.f313782a.getString(R.string.dfw));
                    return;
                }
                if (i18 != 3 && !g16 && !this.f313794m) {
                    j(this.f313782a.getString(R.string.d9q));
                    return;
                }
                if (i18 != 3 && !d() && !g16 && this.f313794m) {
                    if (this.f313792k) {
                        k(this.f313782a.getString(R.string.fsp));
                        return;
                    }
                    this.f313786e = false;
                }
            }
            i(intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " checkAndShowAioShareMusic inten is null ");
        }
    }
}
