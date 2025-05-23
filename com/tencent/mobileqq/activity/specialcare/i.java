package com.tencent.mobileqq.activity.specialcare;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.activity.specialcare.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bp;
import com.tencent.mobileqq.vas.quickupdate.RingUpdateBusiness;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i extends VasWebviewJsPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IQvipSpecialSoundManager f186589d;

    /* renamed from: e, reason: collision with root package name */
    private bp f186590e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements com.tencent.mobileqq.activity.specialcare.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f186591a;

        a(String str) {
            this.f186591a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.activity.specialcare.c
        public void onResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            try {
                if (!z16) {
                    i.this.N(this.f186591a, null);
                } else {
                    i.this.N(this.f186591a, f.f186572a.get("key_special_sound_list" + i.this.mRuntime.b().getCurrentAccountUin()));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                try {
                    i.this.N(this.f186591a, null);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements com.tencent.mobileqq.activity.specialcare.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f186593a;

        b(String str) {
            this.f186593a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.activity.specialcare.c
        public void onResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            try {
                if (!z16) {
                    i.this.N(this.f186593a, null);
                } else {
                    i.this.N(this.f186593a, f.f186572a.get("key_special_sound_list" + i.this.mRuntime.b().getCurrentAccountUin()));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                try {
                    i.this.N(this.f186593a, null);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f186595a;

        c(String str) {
            this.f186595a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 2);
                jSONObject.put("errorCode", updateListenerParams.mErrorCode);
                i.this.callJs(this.f186595a, jSONObject.toString());
            } catch (JSONException unused) {
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 2);
                jSONObject.put("errorCode", updateListenerParams.mErrorCode);
                i.this.callJs(this.f186595a, jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements MediaPlayer.OnCompletionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f186597d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f186598e;

        d(int i3, String str) {
            this.f186597d = i3;
            this.f186598e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, i.this, Integer.valueOf(i3), str);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                return;
            }
            QLog.e("QVipSpecialSoundWebViewPlugin", 1, "play completed, soundId:" + this.f186597d);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                i.this.callJs(this.f186598e, jSONObject.toString());
            } catch (JSONException e16) {
                QLog.e("QVipSpecialSoundWebViewPlugin", 1, "onCompletion: " + this.f186597d, e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements MediaPlayer.OnPreparedListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        JSONObject f186600d;

        /* renamed from: e, reason: collision with root package name */
        String f186601e;

        /* renamed from: f, reason: collision with root package name */
        boolean f186602f;

        public e(JSONObject jSONObject, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, i.this, jSONObject, str, Boolean.valueOf(z16));
                return;
            }
            this.f186600d = jSONObject;
            this.f186601e = str;
            this.f186602f = z16;
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                this.f186600d.put("code", 2);
                this.f186600d.put("errorMessage", "can't play");
                i.this.callJs(this.f186601e, this.f186600d.toString());
            } catch (Exception e16) {
                i.this.log("-->handleJsRequest exception:" + e16.toString());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 2);
                    jSONObject.put("errorMessage", "exception");
                    i.this.callJs(this.f186601e, jSONObject.toString());
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mediaPlayer);
                return;
            }
            if (i.this.f186590e.i()) {
                try {
                    if (this.f186602f) {
                        this.f186600d.put("code", 0);
                        i.this.callJs(this.f186601e, this.f186600d.toString());
                    }
                } catch (Exception e16) {
                    i.this.log("-->handleJsRequest exception:" + e16.toString());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", 2);
                        jSONObject.put("errorMessage", "exception");
                        i.this.callJs(this.f186601e, jSONObject.toString());
                        return;
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        return;
                    }
                }
            }
            i.this.log("-->play failed");
            this.f186600d.put("code", 2);
            this.f186600d.put("errorMessage", "can't play");
            i.this.callJs(this.f186601e, this.f186600d.toString());
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f186589d = null;
            this.f186590e = bp.a();
        }
    }

    private boolean A(int i3, String str) throws JSONException {
        boolean z16;
        QLog.e("QVipSpecialSoundWebViewPlugin", 1, "handlePlayRing: " + i3);
        JSONObject jSONObject = new JSONObject();
        if (this.f186590e.b()) {
            z16 = this.f186590e.j();
        } else {
            z16 = true;
        }
        this.f186590e.h(new d(i3, str));
        String wavPath = ((RingUpdateBusiness) QQVasUpdateBusiness.getBusiness(RingUpdateBusiness.class)).getWavPath(i3);
        if (!new File(wavPath).exists()) {
            jSONObject.put("code", 2);
            jSONObject.put("errorMessage", "audio is missing");
            callJs(str, jSONObject.toString());
        } else {
            this.f186590e.f(this.mRuntime.a().getApplicationContext(), wavPath, new e(jSONObject, str, z16));
        }
        return true;
    }

    private boolean B(String str, JSONObject jSONObject) throws JSONException {
        boolean z16;
        File file = new File(this.mRuntime.a().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json");
        JSONObject jSONObject2 = new JSONObject();
        if (file.exists()) {
            log("-->config file already exists!");
            jSONObject2.put("code", -1);
            jSONObject2.put("errorMessage", "Config file already exists at local.");
        } else {
            try {
                z16 = file.createNewFile();
            } catch (IOException unused) {
                z16 = false;
            }
            if (!z16) {
                log("-->Could not create config file!");
                jSONObject2.put("code", -1);
                jSONObject2.put("errorMessage", "Could not create file!");
            } else {
                log("-->Write config to file.");
                O(file, jSONObject.toString());
                jSONObject2.put("code", 0);
            }
        }
        callJs(str, jSONObject2.toString());
        return true;
    }

    private boolean C(String str) throws JSONException {
        File file = new File(this.mRuntime.a().getApplicationContext().getFilesDir(), "pddata/vas/special_remind/new_config.json");
        JSONObject jSONObject = new JSONObject();
        if (file.exists()) {
            jSONObject.put("code", 0);
        } else {
            jSONObject.put("code", 1);
            jSONObject.put("errorMessage", "config file does not exists at local!");
        }
        callJs(str, jSONObject.toString());
        return true;
    }

    private boolean D(int i3, String str, boolean z16, String str2) throws JSONException {
        log("-->handleSetRing,id=" + i3 + ",uin=" + str);
        if (z16) {
            this.mRuntime.a().getApplicationContext().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit().putInt(AppConstants.Preferences.SPECIAL_ID_CACHE + str, i3).commit();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            callJs(str2, jSONObject.toString());
            return true;
        }
        if (!NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext())) {
            log("-->no network");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", -1);
            jSONObject2.put("errorMessage", getErrorMsg(-1));
            callJs(str2, jSONObject2.toString());
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i3);
        bundle.putString("uin", str);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("special_care_set_ring", str2, this.mOnRemoteResp.key, bundle), false, false);
        return true;
    }

    private boolean E(String str) throws JSONException {
        boolean j3;
        if (!this.f186590e.b()) {
            j3 = true;
        } else {
            j3 = this.f186590e.j();
        }
        QLog.e("QVipSpecialSoundWebViewPlugin", 1, "handleStopRing " + j3);
        JSONObject jSONObject = new JSONObject();
        if (!j3) {
            jSONObject.put("code", -1);
            jSONObject.put("errorMessage", "stop error");
        } else {
            jSONObject.put("code", 0);
        }
        callJs(str, jSONObject.toString());
        return true;
    }

    private boolean F(String str) {
        return new File(this.mRuntime.a().getApplicationContext().getFilesDir(), str).exists();
    }

    private void G(String str, Bundle bundle) throws JSONException {
        log("-->isSpecialFriendIpcResponse");
        if (bundle == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -1);
            jSONObject.put("errorMessage", "invalid data");
            callJs(str, jSONObject.toString());
            return;
        }
        int i3 = bundle.getInt("isSpecialFriend");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("code", 0);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("isSpecialFriend", i3);
        jSONObject2.put("data", jSONObject3);
        callJs(str, jSONObject2.toString());
    }

    private void H(String str, Bundle bundle) throws JSONException {
        log("-->onDeleteSpecialSoundResponse");
        if (bundle == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -3);
            jSONObject.put("errorMessage", getErrorMsg(-3));
            callJs(str, jSONObject.toString());
            return;
        }
        int i3 = bundle.getInt("error");
        JSONObject jSONObject2 = new JSONObject();
        if (i3 != 0) {
            log("-->delete ring failed");
            jSONObject2.put("code", i3);
            jSONObject2.put("errorMessage", getErrorMsg(i3));
        } else {
            log("-->delete ring ok!");
            jSONObject2.put("code", 0);
        }
        callJs(str, jSONObject2.toString());
    }

    private void I(String str, Bundle bundle) throws JSONException {
        log("-->handleGetFriendCountResponse,callback=" + str + ",bundle=" + bundle);
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            jSONObject.put("code", -1);
            jSONObject.put("errorMessage", "id error");
        } else {
            int i3 = bundle.getInt("count");
            jSONObject.put("code", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SquareJSConst.Params.PARAMS_NUMS, i3);
            jSONObject.put("data", jSONObject2);
        }
        callJs(str, jSONObject.toString());
    }

    private void J(String str, Bundle bundle) throws JSONException {
        log("-->handleGetRingResponse, callback=" + str + ",bundle=" + bundle);
        if (bundle == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -1);
            jSONObject.put("errorMessage", "invalid data");
            callJs(str, jSONObject.toString());
            return;
        }
        int i3 = bundle.getInt("id");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", i3);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("code", 0);
        jSONObject3.put("data", jSONObject2);
        callJs(str, jSONObject3.toString());
    }

    private void K(String str, Bundle bundle) throws JSONException {
        log("-->onSetRingForFriendIpcResponse");
        if (bundle == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -3);
            jSONObject.put("errorMessage", getErrorMsg(-3));
            callJs(str, jSONObject.toString());
            return;
        }
        int i3 = bundle.getInt("error");
        JSONObject jSONObject2 = new JSONObject();
        if (i3 != 0) {
            log("-->set ring failed, error:" + getErrorMsg(i3));
            jSONObject2.put("code", i3);
            jSONObject2.put("errorMessage", getErrorMsg(i3));
        } else {
            log("-->set ring ok!");
            jSONObject2.put("code", 0);
        }
        callJs(str, jSONObject2.toString());
    }

    private void L(String str, Bundle bundle) throws JSONException {
        int i3;
        log("-->onSpecialSoundSwitchState,callback=" + str);
        if (bundle == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -1);
            jSONObject.put("errorMessage", "get state failed");
            callJs(str, jSONObject.toString());
            return;
        }
        int i16 = bundle.getInt("state");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("code", 0);
        JSONObject jSONObject3 = new JSONObject();
        if (i16 == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        jSONObject3.put("canPlay", i3);
        jSONObject2.put("data", jSONObject3);
        callJs(str, jSONObject2.toString());
    }

    private void M(String str) {
        File file = new File(this.mRuntime.a().getApplicationContext().getFilesDir(), "https://i.gtimg.cn/club/moblie/special_sound/sound_config.json");
        if (file.exists() && !file.delete()) {
            log("-->can't delete file!");
        }
        this.f186589d.loadSpecialSoundConfig(new b(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, List<g.a> list) {
        log("-->responseRingsList,callback:" + str + ",list:" + list);
        try {
            JSONObject jSONObject = new JSONObject();
            if (list != null && list.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                for (g.a aVar : list) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", aVar.f186575a);
                    jSONObject3.put("soundName", aVar.f186576b);
                    jSONObject3.put("type", aVar.f186577c);
                    jSONObject3.put("soundVersion", aVar.f186578d);
                    jSONObject3.put("soundUrl", aVar.f186579e);
                    jSONObject3.put("whiteList", aVar.f186580f);
                    jSONObject3.put(ViewStickEventHelper.IS_SHOW, aVar.f186581g);
                    jSONObject3.put("backgroundUrl", aVar.f186582h);
                    jSONObject3.put("access", aVar.f186583i);
                    jSONObject3.put("useNum", aVar.f186584j);
                    jSONObject3.put("classify", aVar.f186585k);
                    jSONObject3.put("classifyName", aVar.f186586l);
                    jSONObject3.put("limitFreeStart", aVar.f186587m);
                    jSONObject3.put("limitFreeEnd", aVar.f186588n);
                    String str2 = aVar.f186579e;
                    if (str2 != null && !TextUtils.isEmpty(str2) && F(aVar.f186579e)) {
                        jSONObject3.put("isDownload", true);
                    } else {
                        jSONObject3.put("isDownload", false);
                    }
                    jSONObject2.put(String.valueOf(aVar.f186575a), jSONObject3);
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("rings", jSONObject2);
                jSONObject.put("code", 0);
                jSONObject.put("data", jSONObject4);
                callJs(str, jSONObject.toString());
                return;
            }
            log("-->responseRingsList:list is empety");
            jSONObject.put("code", -1);
            jSONObject.put("errorMessage", "rings not found");
            callJs(str, jSONObject.toString());
        } catch (JSONException e16) {
            log("-->json exception:" + e16.toString() + ".Reload json...");
            M(str);
        }
    }

    private void O(File file, String str) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException unused) {
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                } catch (IOException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    fileOutputStream2.close();
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            } catch (IOException unused4) {
            }
        }
    }

    private String getErrorMsg(int i3) {
        if (i3 != -3) {
            if (i3 != -2) {
                if (i3 != -1) {
                    if (i3 != 0) {
                        if (i3 != 10010) {
                            if (i3 != 11001) {
                                switch (i3) {
                                    case 10001:
                                        return "ERR_METHOD_NOT_SUPPORT";
                                    case 10002:
                                        return "ERR_INVALID_ARGUMENT";
                                    case 10003:
                                        return "ERR_SET_REMIND_ERROR";
                                    case 10004:
                                        return "ERR_CLEAR_REMIND_ERROR";
                                    case 10005:
                                        return "ERR_GET_CLUBINFO_ERROR";
                                    default:
                                        switch (i3) {
                                            case 20001:
                                                return "ERR_OIDB_INIT_ERR";
                                            case 20002:
                                                return "ERR_OIDB_PB_SR_ERR";
                                            case 20003:
                                                return "E_OIDB_PB_PACK_ERR";
                                            case 20004:
                                                return "E_OIDB_PB_UNPACK_ERR";
                                            default:
                                                return "UNKNOWN ERROR";
                                        }
                                }
                            }
                            return "ERR_PROTO_SERIAL_ERR";
                        }
                        return "ERR_SET_QUOTA_LIMIT";
                    }
                    return "SUCC";
                }
                return "ERR_NO_NETWORK";
            }
            return "ERR_REQUEST_TIMEOUT";
        }
        return "ERR_ANDROID_ERROR";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.e("QVipSpecialSoundWebViewPlugin", 2, str);
        }
    }

    private boolean s(String str, String str2) throws JSONException {
        log("-->handleCancelDownload,url:" + str + ",callback:" + str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", 0);
        callJs(str2, jSONObject.toString());
        return true;
    }

    private boolean t(int i3, String str, String str2) throws JSONException {
        log("-->handleSetRing,id=" + i3 + ",uin=" + str);
        if (!NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext())) {
            log("-->no network");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", -1);
            jSONObject.put("errorMessage", getErrorMsg(-1));
            callJs(str2, jSONObject.toString());
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i3);
        bundle.putString("uin", str);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("sepcial_care_delete_ring", str2, this.mOnRemoteResp.key, bundle), false, false);
        return true;
    }

    private boolean u(int i3, String str) throws JSONException {
        QLog.e("QVipSpecialSoundWebViewPlugin", 1, "handleDownloadRing: " + i3);
        JSONObject jSONObject = new JSONObject();
        RingUpdateBusiness ringUpdateBusiness = (RingUpdateBusiness) QQVasUpdateBusiness.getBusiness(RingUpdateBusiness.class);
        if (ringUpdateBusiness.isFileExists(i3)) {
            QLog.e("QVipSpecialSoundWebViewPlugin", 1, "handleDownloadRing: " + i3 + " exists");
            jSONObject.put("code", 2);
            jSONObject.put("errorCode", 0);
            callJs(str, jSONObject.toString());
        } else {
            jSONObject.put("code", 0);
            callJs(str, jSONObject.toString());
            ringUpdateBusiness.addDownLoadListener(i3, new c(str));
            ringUpdateBusiness.startDownload(i3);
        }
        return true;
    }

    private boolean v(String str) {
        log("-->handleGetFriendCount,callback=" + str);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("special_care_get_friend_count", str, this.mOnRemoteResp.key, null), false, false);
        return true;
    }

    private boolean w(String str, String str2, boolean z16) throws JSONException {
        log("-->handleGetRing, uin=" + str + ",callback=" + str2);
        if (z16) {
            int i3 = this.mRuntime.a().getApplicationContext().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getInt(AppConstants.Preferences.SPECIAL_ID_CACHE + str, 1);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", i3);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", 0);
            jSONObject2.put("data", jSONObject);
            callJs(str2, jSONObject2.toString());
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uin", str);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("special_care_get_ring", str2, this.mOnRemoteResp.key, bundle), false, false);
        return true;
    }

    private boolean x(String str) throws JSONException {
        log("-->handleGetRingsInfo,callback=" + str);
        if (!this.f186589d.isCacheData()) {
            this.f186589d.loadSpecialSoundConfig(new a(str));
            return true;
        }
        N(str, f.f186572a.get("key_special_sound_list" + this.mRuntime.b().getCurrentAccountUin()));
        return true;
    }

    private boolean y(String str) {
        log("-->handleGetSpecialSoundSwitchState,callback:" + str);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("special_care_get_switch_state", str, this.mOnRemoteResp.key, null), false, false);
        return true;
    }

    private boolean z(String str, String str2) throws JSONException {
        log("-->handleIsSpecialCareFriend,friendUin:" + str + ",callback:" + str2);
        Bundle bundle = new Bundle();
        bundle.putString("friendUin", str);
        sendRemoteReq(com.tencent.mobileqq.emosm.a.a("is_special_friend", str2, this.mOnRemoteResp.key, bundle), false, false);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "specialRing";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jSONObject;
        String string;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (str2 != null && str2.equalsIgnoreCase("specialRing")) {
            try {
                jSONObject = new JSONObject(strArr[0]);
            } catch (JSONException e16) {
                log("-->failed to parse json str,json=" + ((Object) null));
                e16.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject == null) {
                return false;
            }
            try {
                string = jSONObject.getString("callback");
                VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
                log("-->handleJsRequest:method:" + str3 + ",callback" + string + ", json:" + jSONObject.toString());
            } catch (Exception e17) {
                log("-->handleJsRequest exception:" + e17.toString());
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    jSONObject2.put("errorMessage", "exception");
                    callJs(null, jSONObject2.toString());
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
            if (str3.equals("getRingsInfo")) {
                return x(string);
            }
            if (str3.equals("cancelDownload")) {
                s(jSONObject.getString("url"), string);
            } else {
                if (str3.equals("downloadRing")) {
                    return u(jSONObject.optInt("id"), string);
                }
                if (str3.equals("setDefaultRing")) {
                    try {
                        z16 = jSONObject.getBoolean("lazy");
                    } catch (Exception unused) {
                        z16 = false;
                    }
                    return D(jSONObject.getInt("id"), jSONObject.getString("uin"), z16, string);
                }
                if (str3.equals("getDefaultRing")) {
                    try {
                        z17 = jSONObject.getBoolean("lazy");
                    } catch (Exception unused2) {
                        z17 = false;
                    }
                    return w(jSONObject.getString("uin"), string, z17);
                }
                if (str3.equals("play")) {
                    return A(jSONObject.optInt("id"), string);
                }
                if (str3.equals("stop")) {
                    return E(string);
                }
                if (str3.equals("getSpecialFriendsNum")) {
                    return v(string);
                }
                if (str3.equals("deleteSpecialSound")) {
                    return t(jSONObject.getInt("id"), jSONObject.getString("uin"), string);
                }
                if (str3.equals("canPlaySpecialSound")) {
                    return y(string);
                }
                if (str3.equals("isSpecialCareFriend")) {
                    return z(jSONObject.getString("friendUin"), string);
                }
                if (str3.equals("queryRingDataStatus")) {
                    return C(string);
                }
                if (str3.equals("pushRingData")) {
                    return B(string, jSONObject.getJSONObject("data"));
                }
            }
            return true;
        }
        log("-->handleJsRequest returned, pkgName=" + str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
            this.f186589d = VasUtil.getService().getSpecialSoundManager();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
            this.f186590e.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        if (bundle != null) {
            try {
                if (bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
                    String string = bundle.getString("cmd");
                    String string2 = bundle.getString("callbackid");
                    Bundle bundle2 = bundle.getBundle("response");
                    log("-->onResponse,callback=" + string2 + ",cmd=" + string + ",respbundle=" + bundle2);
                    if (string != null) {
                        if ("special_care_get_ring".equals(string)) {
                            J(string2, bundle2);
                            return;
                        }
                        if ("special_care_get_friend_count".equals(string)) {
                            I(string2, bundle2);
                            return;
                        }
                        if ("special_care_set_ring".equals(string)) {
                            K(string2, bundle2);
                            return;
                        }
                        if ("sepcial_care_delete_ring".equals(string)) {
                            H(string2, bundle2);
                        } else if ("special_care_get_switch_state".equals(string)) {
                            L(string2, bundle2);
                        } else if ("is_special_friend".equals(string)) {
                            G(string2, bundle2);
                        }
                    }
                }
            } catch (Exception e16) {
                log("-->exception in onResponse," + e16.toString());
                e16.printStackTrace();
            }
        }
    }
}
