package com.tencent.mobileqq.musicgene;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.c;
import com.tencent.mobileqq.music.e;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webviewplugin.r;
import com.tencent.open.agent.util.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class MusicGeneWebViewPlugin extends WebViewPlugin {
    static IPatchRedirector $redirector_;
    private int C;
    private SongInfo D;
    private int E;
    private JsBridgeListener F;
    private ServiceConnection G;
    private c.a H;
    private BroadcastReceiver I;
    private Handler J;

    /* renamed from: d, reason: collision with root package name */
    private Context f251887d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f251888e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f251889f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.music.e f251890h;

    /* renamed from: i, reason: collision with root package name */
    private Timer f251891i;

    /* renamed from: m, reason: collision with root package name */
    private int f251892m;

    /* loaded from: classes15.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicGeneWebViewPlugin.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            MusicGeneWebViewPlugin.this.f251890h = e.a.j(iBinder);
            try {
                MusicGeneWebViewPlugin.this.f251890h.C4(MusicGeneWebViewPlugin.this.H);
                if (MusicGeneWebViewPlugin.this.F != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", "0");
                    MusicGeneWebViewPlugin.this.F.c(jSONObject);
                    MusicGeneWebViewPlugin.this.F = null;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            try {
                if (MusicGeneWebViewPlugin.this.f251890h != null) {
                    MusicGeneWebViewPlugin.this.f251890h.X3(MusicGeneWebViewPlugin.this.H);
                }
                if (MusicGeneWebViewPlugin.this.F != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", "1");
                    MusicGeneWebViewPlugin.this.F.c(jSONObject);
                    MusicGeneWebViewPlugin.this.F = null;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            MusicGeneWebViewPlugin.this.f251890h = null;
        }
    }

    /* loaded from: classes15.dex */
    class b extends c.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicGeneWebViewPlugin.this);
            }
        }

        @Override // com.tencent.mobileqq.music.c
        public void onPlaySongChanged(SongInfo songInfo) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) songInfo);
            } else if (MusicGeneWebViewPlugin.this.f251890h != null) {
                MusicGeneWebViewPlugin musicGeneWebViewPlugin = MusicGeneWebViewPlugin.this;
                musicGeneWebViewPlugin.D = musicGeneWebViewPlugin.f251890h.getCurrentSong();
            }
        }

        @Override // com.tencent.mobileqq.music.c
        public void onPlayStateChanged(int i3) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MusicGeneWebViewPlugin.this.P(i3);
                if (i3 == 2) {
                    MusicGeneWebViewPlugin musicGeneWebViewPlugin = MusicGeneWebViewPlugin.this;
                    musicGeneWebViewPlugin.f251892m = musicGeneWebViewPlugin.f251890h.getDuration();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    /* loaded from: classes15.dex */
    class c extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicGeneWebViewPlugin.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (intent != null && "BROAD_CAST_CALL_PAGE_SHARE".equals(intent.getAction())) {
                MusicGeneWebViewPlugin.this.R();
            }
        }
    }

    /* loaded from: classes15.dex */
    class d extends Handler {
        static IPatchRedirector $redirector_;

        d(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicGeneWebViewPlugin.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            Bundle data = message.getData();
            if (data != null) {
                str = data.getString("BUNDLE_KEY_FILE_PATH");
            } else {
                str = null;
            }
            Bitmap bitmap = (Bitmap) message.obj;
            if (bitmap != null && str != null) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public MusicGeneWebViewPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251887d = null;
        this.f251888e = false;
        this.f251889f = false;
        this.f251890h = null;
        this.f251891i = new BaseTimer();
        this.f251892m = 0;
        this.C = 0;
        this.D = null;
        this.E = 0;
        this.F = null;
        this.G = new a();
        this.H = new b();
        this.I = new c();
        this.J = new d(Looper.getMainLooper());
    }

    private void B() {
        try {
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar != null) {
                Activity a16 = bVar.a();
                if (a16 != null && this.f251890h == null) {
                    a16.bindService(new Intent(a16, (Class<?>) QQPlayerService.class), this.G, 33);
                    QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService end!");
                } else {
                    QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService activity is null!");
                }
            } else {
                QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService mRuntime is null!");
            }
        } catch (Exception e16) {
            QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService exception", e16);
        }
    }

    private SongInfo[] C(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long parseLong;
        String str7;
        String str8;
        SongInfo[] songInfoArr = null;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("list")) {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            songInfoArr = new SongInfo[jSONArray.length()];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                if (jSONObject2 != null) {
                    String str9 = "";
                    if (!jSONObject2.has(IOnlineStatusService.SONG_ID)) {
                        str = "";
                    } else {
                        str = jSONObject2.getString(IOnlineStatusService.SONG_ID);
                    }
                    SongInfo songInfo = new SongInfo();
                    if (!jSONObject2.has("songName")) {
                        str2 = "";
                    } else {
                        str2 = jSONObject2.getString("songName");
                    }
                    songInfo.f251871i = str2;
                    if (!jSONObject2.has("playUrl")) {
                        str3 = "";
                    } else {
                        str3 = jSONObject2.getString("playUrl");
                    }
                    songInfo.f251870h = str3;
                    if (!jSONObject2.has(AEEditorConstants.ALBUMNAME)) {
                        str4 = "";
                    } else {
                        str4 = jSONObject2.getString(AEEditorConstants.ALBUMNAME);
                    }
                    songInfo.f251872m = str4;
                    if (!jSONObject2.has("albumImg")) {
                        str5 = "";
                    } else {
                        str5 = jSONObject2.getString("albumImg");
                    }
                    songInfo.C = str5;
                    if (!jSONObject2.has("songPage")) {
                        str6 = "";
                    } else {
                        str6 = jSONObject2.getString("songPage");
                    }
                    songInfo.D = str6;
                    if (TextUtils.isEmpty(str)) {
                        parseLong = 0;
                    } else {
                        parseLong = Long.parseLong(str);
                    }
                    songInfo.f251867d = parseLong;
                    if (!jSONObject2.has(AEEditorConstants.ALBUMNAME)) {
                        str7 = "";
                    } else {
                        str7 = jSONObject2.getString(AEEditorConstants.ALBUMNAME);
                    }
                    songInfo.E = str7;
                    if (!jSONObject2.has("singerName")) {
                        str8 = "";
                    } else {
                        str8 = jSONObject2.getString("singerName");
                    }
                    songInfo.F = str8;
                    if (jSONObject2.has("songmid")) {
                        str9 = jSONObject2.getString("songmid");
                    }
                    songInfo.f251868e = str9;
                    songInfoArr[i3] = songInfo;
                }
            }
        }
        return songInfoArr;
    }

    private int D(int i3) {
        if (i3 != 0) {
            if (i3 == 1 || i3 != 3) {
                return 103;
            }
            return 101;
        }
        return 102;
    }

    private JSONObject E(SongInfo songInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (songInfo != null) {
            jSONObject.put("playUrl", songInfo.f251870h);
            jSONObject.put("songPage", songInfo.D);
            jSONObject.put(IOnlineStatusService.SONG_ID, songInfo.f251867d);
            jSONObject.put("songName", songInfo.f251871i);
            jSONObject.put("singerName", songInfo.F);
            jSONObject.put(AEEditorConstants.ALBUMNAME, songInfo.E);
            jSONObject.put("albumImg", songInfo.C);
        }
        return jSONObject;
    }

    private int F(int i3) {
        switch (i3) {
            case 0:
            case 4:
            case 5:
            case 7:
            default:
                return 0;
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
                return 2;
            case 6:
                return -1001;
        }
    }

    private HashMap<String, JSONObject> G(JSONArray jSONArray) {
        HashMap<String, JSONObject> hashMap = new HashMap<>();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                if (jSONObject != null) {
                    hashMap.put(jSONObject.getString(IOnlineStatusService.SONG_ID), jSONObject);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return hashMap;
    }

    private String H() {
        String T4;
        try {
            if (L()) {
                T4 = com.tencent.mobileqq.musicgene.d.a();
            } else {
                T4 = this.f251890h.T4(3, "MusicGeneWebViewPlugin");
            }
            return T4;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    public static Bitmap I(String str) {
        Throwable th5;
        InputStream inputStream;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException e16) {
                e = e16;
                inputStream = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                inputStream = null;
            } catch (Throwable th6) {
                th5 = th6;
                str = 0;
                h.a(str);
                throw th5;
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                h.a(inputStream);
                return decodeStream;
            } catch (IOException e18) {
                e = e18;
                e.printStackTrace();
                h.a(inputStream);
                return null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                e.printStackTrace();
                h.a(inputStream);
                return null;
            }
        } catch (Throwable th7) {
            th5 = th7;
            h.a(str);
            throw th5;
        }
    }

    private int J() {
        com.tencent.mobileqq.music.e eVar;
        if (this.f251892m <= 0 && (eVar = this.f251890h) != null) {
            try {
                this.f251892m = eVar.getDuration();
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
        }
        return this.f251892m;
    }

    private SongInfo K() {
        com.tencent.mobileqq.music.e eVar;
        SongInfo songInfo = this.D;
        if (songInfo == null && (eVar = this.f251890h) != null) {
            try {
                return eVar.getCurrentSong();
            } catch (Exception e16) {
                e16.printStackTrace();
                return songInfo;
            }
        }
        return songInfo;
    }

    private boolean L() {
        int i3 = this.E;
        if (1 == i3 || 2 == i3) {
            return true;
        }
        return false;
    }

    private boolean M() {
        com.tencent.mobileqq.music.e eVar = this.f251890h;
        if (eVar == null) {
            return false;
        }
        try {
            String token = eVar.getToken();
            String H = H();
            if (TextUtils.isEmpty(token)) {
                return false;
            }
            if (!token.equals(H)) {
                return false;
            }
            return true;
        } catch (RemoteException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static boolean N(String str) {
        boolean z16 = true;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic urlString is not url!");
                return false;
            }
            String host = parse.getHost();
            if (TextUtils.isEmpty(host) || (!host.contains("y.qq.com") && !host.contains("music.qq.com") && !host.contains("imgcache.gtimg.cn") && !host.contains(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE) && !host.contains(PublicAccountDetailActivityImpl.DOMAIN_MP_POST))) {
                z16 = false;
            }
            return z16;
        } catch (Exception e16) {
            QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic exception: " + e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String str = "data:image\\/jpg;base64," + PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", "0");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("imgUrl", str);
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            callJs(String.format("try{qqmusicBridge.appTrigger('%s',  %s);}catch(e){}", "DO_MACK_IMG_CALLBACK", jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[Catch: JSONException -> 0x0057, TRY_ENTER, TryCatch #1 {JSONException -> 0x0057, blocks: (B:11:0x0031, B:14:0x004f, B:18:0x0053, B:22:0x002d, B:8:0x001c, B:10:0x0024), top: B:7:0x001c, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[Catch: JSONException -> 0x0057, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0057, blocks: (B:11:0x0031, B:14:0x004f, B:18:0x0053, B:22:0x002d, B:8:0x001c, B:10:0x0024), top: B:7:0x001c, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean P(int i3) {
        int i16;
        int i17;
        Bundle extras;
        com.tencent.mobileqq.music.e eVar = this.f251890h;
        if (!this.f251888e || eVar == null) {
            return false;
        }
        try {
            i16 = eVar.q4();
        } catch (RemoteException e16) {
            e16.printStackTrace();
            i16 = 0;
        }
        int F = F(i3);
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                extras = this.f251890h.getExtras();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        } catch (JSONException e18) {
            e18.printStackTrace();
        }
        if (extras != null) {
            i17 = extras.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
            jSONObject.put("state", F);
            jSONObject.put("index", i16);
            jSONObject.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, i17);
            if (!M()) {
                jSONObject.put("code", "0");
            } else {
                jSONObject.put("code", "0");
            }
            callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", "CALLPAGE_SONG_STATE_CHANGE", jSONObject.toString()));
            return true;
        }
        i17 = 0;
        jSONObject.put("state", F);
        jSONObject.put("index", i16);
        jSONObject.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, i17);
        if (!M()) {
        }
        callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", "CALLPAGE_SONG_STATE_CHANGE", jSONObject.toString()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086 A[Catch: Exception -> 0x00c4, TryCatch #4 {Exception -> 0x00c4, blocks: (B:25:0x0080, B:27:0x0086, B:28:0x008a, B:30:0x0090, B:32:0x009e, B:34:0x00b4, B:35:0x00b7, B:45:0x007c, B:20:0x0069, B:22:0x006d, B:24:0x0073), top: B:19:0x0069, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b4 A[Catch: Exception -> 0x00c4, TryCatch #4 {Exception -> 0x00c4, blocks: (B:25:0x0080, B:27:0x0086, B:28:0x008a, B:30:0x0090, B:32:0x009e, B:34:0x00b4, B:35:0x00b7, B:45:0x007c, B:20:0x0069, B:22:0x006d, B:24:0x0073), top: B:19:0x0069, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Q() {
        SongInfo songInfo;
        int i3;
        int i16;
        int i17;
        com.tencent.mobileqq.music.e eVar;
        int i18;
        int i19;
        JSONObject E;
        com.tencent.mobileqq.music.e eVar2;
        Bundle extras;
        if (!this.f251889f) {
            return false;
        }
        JSONObject jSONObject = null;
        try {
            songInfo = K();
            try {
                com.tencent.mobileqq.music.e eVar3 = this.f251890h;
                if (eVar3 != null) {
                    i16 = eVar3.getCurrentSongPosition();
                } else {
                    i16 = 0;
                }
            } catch (Exception e16) {
                e = e16;
                i3 = 0;
                e.printStackTrace();
                i16 = i3;
                i17 = 0;
                eVar = this.f251890h;
                String str = "0";
                if (eVar != null) {
                }
                if (jSONObject == null) {
                }
                if (songInfo != null) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            songInfo = null;
        }
        try {
            i17 = J();
        } catch (Exception e18) {
            i3 = i16;
            e = e18;
            e.printStackTrace();
            i16 = i3;
            i17 = 0;
            eVar = this.f251890h;
            String str2 = "0";
            if (eVar != null) {
            }
            if (jSONObject == null) {
            }
            if (songInfo != null) {
            }
        }
        eVar = this.f251890h;
        String str22 = "0";
        if (eVar != null) {
            try {
                i18 = F(eVar.getPlayState());
                try {
                    Bundle extras2 = this.f251890h.getExtras();
                    if (extras2 != null) {
                        str22 = extras2.getString("BUNDLE_KEY_GENE_ID");
                        jSONObject = new JSONObject(extras2.getString("data"));
                    }
                } catch (Exception e19) {
                    e = e19;
                    e.printStackTrace();
                    if (jSONObject == null) {
                    }
                    if (songInfo != null) {
                    }
                }
            } catch (Exception e26) {
                e = e26;
                i18 = 0;
            }
        } else {
            i18 = 0;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (songInfo != null) {
            return false;
        }
        try {
            try {
                eVar2 = this.f251890h;
            } catch (Exception e27) {
                e27.printStackTrace();
            }
        } catch (Exception e28) {
            e28.printStackTrace();
        }
        if (eVar2 != null && (extras = eVar2.getExtras()) != null) {
            i19 = extras.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
            E = E(songInfo);
            if (E != null) {
                Iterator keys = E.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    jSONObject.put(str3, E.get(str3));
                }
            }
            jSONObject.put("curTime", i16 / 1000);
            jSONObject.put("totalTime", i17 / 1000);
            if (!jSONObject.has("geneId")) {
                jSONObject.put("geneId", str22);
            }
            jSONObject.put("state", i18);
            jSONObject.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, i19);
            if (jSONObject != null) {
                return false;
            }
            callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", "CALLPAGE_SONG_TIME_UPDATE", jSONObject.toString()));
            return true;
        }
        i19 = 0;
        E = E(songInfo);
        if (E != null) {
        }
        jSONObject.put("curTime", i16 / 1000);
        jSONObject.put("totalTime", i17 / 1000);
        if (!jSONObject.has("geneId")) {
        }
        jSONObject.put("state", i18);
        jSONObject.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, i19);
        if (jSONObject != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        callJs(String.format("try{qqmusicBridge.appTrigger('%s');}catch(e){}", "CALLPAGE_SHARE"));
    }

    private void S() {
        this.f251891i.schedule(new TimerTask() { // from class: com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MusicGeneWebViewPlugin.this);
                }
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    MusicGeneWebViewPlugin.this.Q();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 1000L, 1000L);
    }

    private void T() {
        this.f251891i.cancel();
    }

    private void U() {
        Activity a16;
        try {
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar != null && (a16 = bVar.a()) != null) {
                a16.unbindService(this.G);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "qqmusic";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).longValue();
        }
        return 3L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), map)).booleanValue();
        }
        if (j3 == 8589934594L && this.f251887d != null) {
            Intent intent = new Intent("BROAD_CAST_UPDATE_TITLE");
            intent.putExtra("BUNDLE_KEY_URL", str);
            this.f251887d.sendBroadcast(intent, "com.tencent.music.data.permission");
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0393 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x039a A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03a3 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03b1 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03d7 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0480 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x048c A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04a2 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0494 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0436 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x02a1 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x02ac A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x02b5 A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x035b A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x034b A[Catch: Exception -> 0x0728, TryCatch #8 {Exception -> 0x0728, blocks: (B:14:0x0065, B:16:0x0070, B:18:0x007a, B:20:0x0082, B:22:0x0088, B:23:0x0091, B:26:0x00c1, B:29:0x00c6, B:32:0x00ec, B:35:0x00f4, B:37:0x00fa, B:38:0x0100, B:40:0x0106, B:41:0x010c, B:43:0x0112, B:44:0x0116, B:46:0x0121, B:47:0x0127, B:49:0x012d, B:50:0x0133, B:52:0x016c, B:54:0x0179, B:55:0x017f, B:57:0x0198, B:58:0x019f, B:65:0x01d9, B:70:0x01cf, B:75:0x01ea, B:77:0x01fa, B:79:0x0212, B:81:0x021d, B:83:0x022d, B:85:0x0236, B:87:0x0246, B:89:0x024f, B:91:0x025f, B:93:0x0268, B:95:0x0278, B:293:0x02a1, B:294:0x02a6, B:296:0x02ac, B:298:0x02b5, B:300:0x02bb, B:304:0x02c5, B:306:0x02cb, B:308:0x02e9, B:310:0x02ef, B:311:0x02f3, B:313:0x02f9, B:315:0x0307, B:317:0x0317, B:318:0x0319, B:319:0x0320, B:321:0x0326, B:322:0x032d, B:323:0x0355, B:325:0x035b, B:326:0x035e, B:328:0x032a, B:329:0x031b, B:331:0x034b, B:339:0x029b, B:97:0x0365, B:206:0x0393, B:208:0x039a, B:210:0x03a3, B:212:0x03a9, B:215:0x03b1, B:217:0x03ba, B:218:0x03c3, B:220:0x03c9, B:222:0x03d7, B:225:0x03eb, B:227:0x03ee, B:229:0x03f2, B:231:0x03fd, B:235:0x0419, B:244:0x0469, B:246:0x0480, B:247:0x0483, B:249:0x048c, B:250:0x049b, B:252:0x04a2, B:253:0x04a7, B:255:0x0494, B:257:0x0436, B:260:0x044b, B:262:0x044e, B:264:0x0452, B:268:0x045f, B:284:0x038d, B:99:0x04b5, B:102:0x04c2, B:104:0x04cd, B:105:0x04d7, B:108:0x04eb, B:111:0x04f8, B:113:0x0501, B:114:0x050a, B:119:0x0519, B:121:0x0524, B:122:0x0534, B:126:0x053c, B:130:0x054a, B:132:0x0550, B:135:0x055b, B:136:0x0566, B:140:0x0583, B:141:0x0597, B:143:0x05aa, B:144:0x05cc, B:150:0x05c4, B:152:0x05c9, B:153:0x058f, B:157:0x0578, B:160:0x05d9, B:162:0x05e2, B:164:0x05eb, B:166:0x05f6, B:168:0x0607, B:169:0x060c, B:170:0x0616, B:173:0x061e, B:177:0x062c, B:179:0x0655, B:180:0x0659, B:182:0x065d, B:183:0x0691, B:185:0x069e, B:188:0x06a9, B:190:0x06cb, B:191:0x06d6, B:193:0x06df, B:194:0x06e3, B:196:0x06e7, B:198:0x071b, B:352:0x00ba, B:353:0x008f, B:60:0x01a6, B:62:0x01b9, B:63:0x01c4, B:68:0x01bf, B:138:0x056a, B:344:0x009d, B:346:0x00a7, B:350:0x00ad, B:147:0x05b7), top: B:13:0x0065, inners: #0, #5, #7, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0774 A[Catch: JSONException -> 0x07aa, TryCatch #9 {JSONException -> 0x07aa, blocks: (B:363:0x0743, B:365:0x074e, B:371:0x076b, B:373:0x0774, B:375:0x0789, B:377:0x0792, B:385:0x0767), top: B:362:0x0743 }] */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0789 A[Catch: JSONException -> 0x07aa, TryCatch #9 {JSONException -> 0x07aa, blocks: (B:363:0x0743, B:365:0x074e, B:371:0x076b, B:373:0x0774, B:375:0x0789, B:377:0x0792, B:385:0x0767), top: B:362:0x0743 }] */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        int i3;
        int i16;
        Bundle extras;
        JSONObject jSONObject;
        Bundle bundle;
        JSONObject jSONObject2;
        SongInfo K;
        int currentSongPosition;
        Bundle bundle2;
        JSONObject jSONObject3;
        String str4;
        JSONArray jSONArray;
        String str5;
        int i17;
        String str6;
        String str7;
        String str8;
        int i18;
        int i19;
        String str9;
        String str10;
        String str11;
        SongInfo[] songInfoArr;
        String str12;
        String str13;
        String str14;
        AudioManager audioManager;
        boolean z16;
        File cacheDir;
        String str15;
        AudioManager audioManager2;
        String str16;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        if ("qqmusic".equals(str2)) {
            if ("webCallApp".equals(str3)) {
                try {
                    jSONObject = new JSONObject((String) arrayList.get(0));
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return true;
                }
                if (!jSONObject.has("action")) {
                    return true;
                }
                String string = jSONObject.getString("action");
                JSONObject jSONObject4 = jSONObject.has("data") ? jSONObject.getJSONObject("data") : null;
                if (jSONObject4 != null && jSONObject4.has(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE)) {
                    this.E = jSONObject4.getInt(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE);
                } else {
                    this.E = 0;
                }
                if ("MANUAL_INIT".equals(string)) {
                    try {
                        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handle js request: MANUAL_INIT");
                        if (this.f251890h == null) {
                            this.F = jsBridgeListener;
                            B();
                        } else {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("code", "0");
                            jsBridgeListener.c(jSONObject5);
                        }
                    } catch (Exception e17) {
                        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handle js request get exception in ACTION_MANUAL_INIT", e17);
                    }
                    return true;
                }
                com.tencent.mobileqq.music.e eVar = this.f251890h;
                if (eVar == null) {
                    return false;
                }
                String str17 = "uin";
                if ("SONG_PLAY".equals(string)) {
                    SongInfo[] C = C(jSONObject4);
                    if (jSONObject4 == null || C == null) {
                        str16 = "code";
                        obj = "1";
                    } else {
                        int i26 = jSONObject4.has("index") ? jSONObject4.getInt("index") : 0;
                        String string2 = jSONObject4.has("geneId") ? jSONObject4.getString("geneId") : "0";
                        long j3 = jSONObject4.has("uin") ? jSONObject4.getLong("uin") : 0L;
                        if (jSONObject4.has("geneType")) {
                            jSONObject4.getString("geneType");
                        }
                        JSONArray jSONArray2 = jSONObject4.has("list") ? jSONObject4.getJSONArray("list") : null;
                        String valueOf = String.valueOf(j3);
                        str16 = "code";
                        Intent intent = new Intent(this.f251887d, (Class<?>) MusicPlayerActivity.class);
                        String format = String.format("https://y.qq.com/m/recent_listen/play.html?uin=%s&_bid=266&_wv=14115", valueOf);
                        intent.putExtra("uin", valueOf);
                        intent.putExtra("url", format);
                        intent.putExtra("BUNDLE_KEY_FROM_PLAY_BAR", true);
                        if (jSONObject4.has(VasWebviewConstants.KEY_PAGE_URL)) {
                            String string3 = jSONObject4.getString(VasWebviewConstants.KEY_PAGE_URL);
                            if (!TextUtils.isEmpty(string3)) {
                                intent.putExtra("url", string3);
                            }
                        }
                        Bundle bundle3 = new Bundle();
                        bundle3.putLong("BUNDLE_KEY_UIN", j3);
                        bundle3.putString("BUNDLE_KEY_GENE_ID", string2);
                        bundle3.putInt("BUNDLE_KEY_PLAY_TYPE", this.E);
                        if (jSONArray2 != null) {
                            bundle3.putString("BUNDLE_KEY_JSONARRAY_SONG_LIST", jSONArray2.toString());
                        }
                        bundle3.putString("data", jSONObject4.toString());
                        try {
                            eVar.setExtras(bundle3);
                            eVar.C4(this.H);
                            eVar.m2(intent);
                            if (L()) {
                                eVar.setPlayMode(102);
                            } else {
                                eVar.setPlayMode(103);
                            }
                            eVar.b2(H(), C, i26);
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        obj = "0";
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put(str16, obj);
                    jsBridgeListener.c(jSONObject6);
                    return true;
                }
                String str18 = "code";
                if ("SONG_PAUSE".equals(string)) {
                    this.C = eVar.getCurrentSongPosition();
                    eVar.pause();
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put(str18, "0");
                    jsBridgeListener.c(jSONObject7);
                    return true;
                }
                String str19 = "0";
                if ("SONG_RESUME".equals(string)) {
                    eVar.resume();
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put(str18, str19);
                    jsBridgeListener.c(jSONObject8);
                    return true;
                }
                if ("SONG_STOP".equals(string)) {
                    eVar.stop();
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put(str18, str19);
                    jsBridgeListener.c(jSONObject9);
                    return true;
                }
                if ("SONG_PLAY_NEXT".equals(string)) {
                    eVar.r();
                    JSONObject jSONObject10 = new JSONObject();
                    jSONObject10.put(str18, str19);
                    jsBridgeListener.c(jSONObject10);
                    return true;
                }
                if ("SONG_PLAY_PREV".equals(string)) {
                    eVar.p0();
                    JSONObject jSONObject11 = new JSONObject();
                    jSONObject11.put(str18, str19);
                    jsBridgeListener.c(jSONObject11);
                    return true;
                }
                if ("SONG_GET_SONG_INFO".equals(string)) {
                    try {
                        bundle = eVar.getExtras();
                    } catch (Exception e19) {
                        e = e19;
                        bundle = null;
                    }
                    if (bundle != null) {
                        try {
                        } catch (Exception e26) {
                            e = e26;
                            e.printStackTrace();
                            jSONObject2 = null;
                            if (jSONObject2 == null) {
                            }
                            K = K();
                            if (bundle != null) {
                            }
                            if (bundle != null) {
                            }
                            long j16 = r17;
                            if (K != null) {
                            }
                            if (!jSONObject2.has("uin")) {
                            }
                            jsBridgeListener.c(jSONObject2);
                            return true;
                        }
                        if (bundle.containsKey("data")) {
                            jSONObject2 = new JSONObject(bundle.getString("data"));
                            if (jSONObject2 == null) {
                                jSONObject2 = new JSONObject();
                            }
                            K = K();
                            int i27 = bundle != null ? bundle.getInt("BUNDLE_KEY_PLAY_TYPE", 0) : 0;
                            if (bundle != null && bundle.containsKey("BUNDLE_KEY_UIN")) {
                                r17 = bundle.getLong("BUNDLE_KEY_UIN");
                            }
                            long j162 = r17;
                            if (K != null) {
                                JSONObject jSONObject12 = (bundle == null || !bundle.containsKey("BUNDLE_KEY_JSONARRAY_SONG_LIST")) ? null : G(new JSONArray(bundle.getString("BUNDLE_KEY_JSONARRAY_SONG_LIST"))).get(String.valueOf(K.f251867d));
                                if (jSONObject12 == null) {
                                    jSONObject12 = E(K);
                                }
                                if (jSONObject12 != null) {
                                    Iterator keys = jSONObject12.keys();
                                    while (keys.hasNext()) {
                                        String str20 = (String) keys.next();
                                        jSONObject2.put(str20, jSONObject12.get(str20));
                                    }
                                }
                                long J = J();
                                int playState = eVar.getPlayState();
                                int F = F(playState);
                                if (playState == 3) {
                                    currentSongPosition = this.C;
                                } else {
                                    currentSongPosition = eVar.getCurrentSongPosition();
                                }
                                long j17 = currentSongPosition;
                                if (M()) {
                                    jSONObject2.put(str18, str19);
                                } else {
                                    jSONObject2.put(str18, str19);
                                }
                                jSONObject2.put("curTime", j17 / 1000);
                                jSONObject2.put("totalTime", J / 1000);
                                jSONObject2.put("state", F);
                                jSONObject2.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, i27);
                            } else {
                                jSONObject2.put(str18, "1");
                                jSONObject2.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, i27);
                            }
                            if (!jSONObject2.has("uin")) {
                                jSONObject2.put("uin", j162);
                            }
                            jsBridgeListener.c(jSONObject2);
                            return true;
                        }
                    }
                    jSONObject2 = null;
                    if (jSONObject2 == null) {
                    }
                    K = K();
                    if (bundle != null) {
                    }
                    if (bundle != null) {
                        r17 = bundle.getLong("BUNDLE_KEY_UIN");
                    }
                    long j1622 = r17;
                    if (K != null) {
                    }
                    if (!jSONObject2.has("uin")) {
                    }
                    jsBridgeListener.c(jSONObject2);
                    return true;
                }
                String str21 = TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE;
                JSONObject jSONObject13 = jSONObject4;
                if ("SONG_GET_LIST_INFO".equals(string)) {
                    try {
                        bundle2 = eVar.getExtras();
                    } catch (Exception e27) {
                        e = e27;
                        bundle2 = null;
                    }
                    if (bundle2 != null) {
                        try {
                        } catch (Exception e28) {
                            e = e28;
                            e.printStackTrace();
                            jSONObject3 = null;
                            if (jSONObject3 == null) {
                            }
                            if (bundle2 != null) {
                            }
                            if (bundle2 != null) {
                            }
                            long j18 = r17;
                            if (bundle2 != null) {
                            }
                            jSONArray = null;
                            if (jSONArray != null) {
                            }
                            str8 = str17;
                            i18 = i19;
                            jSONObject3.put("index", i18);
                            jSONObject3.put("state", F(eVar.getPlayState()));
                            if (!jSONObject3.has("geneId")) {
                            }
                            jSONObject3.put("list", jSONArray);
                            if (M()) {
                            }
                            str10 = str8;
                            if (!jSONObject3.has(str10)) {
                            }
                            jSONObject3.put(str6, i17);
                            jsBridgeListener.c(jSONObject3);
                            return true;
                        }
                        if (bundle2.containsKey("data")) {
                            jSONObject3 = new JSONObject(bundle2.getString("data"));
                            if (jSONObject3 == null) {
                                jSONObject3 = new JSONObject();
                            }
                            int i28 = bundle2 != null ? bundle2.getInt("BUNDLE_KEY_PLAY_TYPE", 0) : 0;
                            if (bundle2 != null && bundle2.containsKey("BUNDLE_KEY_UIN")) {
                                r17 = bundle2.getLong("BUNDLE_KEY_UIN");
                            }
                            long j182 = r17;
                            if (bundle2 != null) {
                                str4 = bundle2.containsKey("BUNDLE_KEY_GENE_ID") ? bundle2.getString("BUNDLE_KEY_GENE_ID") : str19;
                                if (bundle2.containsKey("BUNDLE_KEY_JSONARRAY_SONG_LIST")) {
                                    jSONArray = new JSONArray(bundle2.getString("BUNDLE_KEY_JSONARRAY_SONG_LIST"));
                                    if (jSONArray != null) {
                                        jSONArray = new JSONArray();
                                        SongInfo[] B2 = eVar.B2();
                                        SongInfo K2 = K();
                                        if (B2 != null) {
                                            i17 = i28;
                                            int i29 = 0;
                                            i19 = 0;
                                            while (i29 < B2.length) {
                                                SongInfo songInfo = B2[i29];
                                                if (songInfo != null) {
                                                    songInfoArr = B2;
                                                    jSONArray.put(i29, E(songInfo));
                                                    if (K2 != null) {
                                                        str11 = str18;
                                                        str12 = str21;
                                                        str13 = str19;
                                                        if (songInfo.f251867d == K2.f251867d) {
                                                            i19 = i29;
                                                        }
                                                        i29++;
                                                        B2 = songInfoArr;
                                                        str21 = str12;
                                                        str19 = str13;
                                                        str18 = str11;
                                                    } else {
                                                        str11 = str18;
                                                    }
                                                } else {
                                                    str11 = str18;
                                                    songInfoArr = B2;
                                                }
                                                str12 = str21;
                                                str13 = str19;
                                                i29++;
                                                B2 = songInfoArr;
                                                str21 = str12;
                                                str19 = str13;
                                                str18 = str11;
                                            }
                                            str5 = str18;
                                            str6 = str21;
                                            str7 = str19;
                                        } else {
                                            str5 = str18;
                                            i17 = i28;
                                            str6 = str21;
                                            str7 = str19;
                                            i19 = 0;
                                        }
                                    } else {
                                        str5 = str18;
                                        i17 = i28;
                                        str6 = str21;
                                        str7 = str19;
                                        SongInfo[] B22 = eVar.B2();
                                        SongInfo K3 = K();
                                        if (B22 != null) {
                                            int i36 = 0;
                                            i19 = 0;
                                            while (i36 < B22.length) {
                                                SongInfo songInfo2 = B22[i36];
                                                if (songInfo2 != null) {
                                                    str9 = str17;
                                                    if (songInfo2.f251867d == K3.f251867d) {
                                                        i19 = i36;
                                                    }
                                                } else {
                                                    str9 = str17;
                                                }
                                                i36++;
                                                str17 = str9;
                                            }
                                        } else {
                                            str8 = "uin";
                                            i18 = 0;
                                            jSONObject3.put("index", i18);
                                            jSONObject3.put("state", F(eVar.getPlayState()));
                                            if (!jSONObject3.has("geneId")) {
                                                jSONObject3.put("geneId", str4);
                                            }
                                            jSONObject3.put("list", jSONArray);
                                            if (M()) {
                                                jSONObject3.put(str5, str7);
                                            } else {
                                                jSONObject3.put(str5, str7);
                                            }
                                            str10 = str8;
                                            if (!jSONObject3.has(str10)) {
                                                jSONObject3.put(str10, j182);
                                            }
                                            jSONObject3.put(str6, i17);
                                            jsBridgeListener.c(jSONObject3);
                                            return true;
                                        }
                                    }
                                    str8 = str17;
                                    i18 = i19;
                                    jSONObject3.put("index", i18);
                                    jSONObject3.put("state", F(eVar.getPlayState()));
                                    if (!jSONObject3.has("geneId")) {
                                    }
                                    jSONObject3.put("list", jSONArray);
                                    if (M()) {
                                    }
                                    str10 = str8;
                                    if (!jSONObject3.has(str10)) {
                                    }
                                    jSONObject3.put(str6, i17);
                                    jsBridgeListener.c(jSONObject3);
                                    return true;
                                }
                            } else {
                                str4 = str19;
                            }
                            jSONArray = null;
                            if (jSONArray != null) {
                            }
                            str8 = str17;
                            i18 = i19;
                            jSONObject3.put("index", i18);
                            jSONObject3.put("state", F(eVar.getPlayState()));
                            if (!jSONObject3.has("geneId")) {
                            }
                            jSONObject3.put("list", jSONArray);
                            if (M()) {
                            }
                            str10 = str8;
                            if (!jSONObject3.has(str10)) {
                            }
                            jSONObject3.put(str6, i17);
                            jsBridgeListener.c(jSONObject3);
                            return true;
                        }
                    }
                    jSONObject3 = null;
                    if (jSONObject3 == null) {
                    }
                    if (bundle2 != null) {
                    }
                    if (bundle2 != null) {
                        r17 = bundle2.getLong("BUNDLE_KEY_UIN");
                    }
                    long j1822 = r17;
                    if (bundle2 != null) {
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                    }
                    str8 = str17;
                    i18 = i19;
                    jSONObject3.put("index", i18);
                    jSONObject3.put("state", F(eVar.getPlayState()));
                    if (!jSONObject3.has("geneId")) {
                    }
                    jSONObject3.put("list", jSONArray);
                    if (M()) {
                    }
                    str10 = str8;
                    if (!jSONObject3.has(str10)) {
                    }
                    jSONObject3.put(str6, i17);
                    jsBridgeListener.c(jSONObject3);
                    return true;
                }
                if ("SONG_SET_PLAYMODE".equals(string)) {
                    eVar.setPlayMode(D((jSONObject13 == null || !jSONObject13.has("type")) ? 103 : jSONObject13.getInt("type")));
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put(str18, str19);
                    jsBridgeListener.c(jSONObject14);
                    return true;
                }
                if ("SONG_SET_VOLUME".equals(string)) {
                    int i37 = (jSONObject13 == null || !jSONObject13.has(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME)) ? 0 : jSONObject13.getInt(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME);
                    JSONObject jSONObject15 = new JSONObject();
                    Context context = this.f251887d;
                    if (context == null || i37 < 0 || i37 > 100 || (audioManager2 = (AudioManager) context.getSystemService("audio")) == null) {
                        str15 = "1";
                    } else {
                        audioManager2.setStreamVolume(3, (audioManager2.getStreamMaxVolume(3) * i37) / 100, 4);
                        str15 = str19;
                    }
                    jSONObject15.put(str18, str15);
                    jsBridgeListener.c(jSONObject15);
                    return true;
                }
                if ("DO_MACK_IMG".equals(string)) {
                    String string4 = (jSONObject13 == null || !jSONObject13.has("imgUrl")) ? "" : jSONObject13.getString("imgUrl");
                    int optInt = jSONObject13 != null ? jSONObject13.optInt("degree", 0) : 0;
                    String md5 = MD5.toMD5(string4);
                    try {
                        z16 = "mounted".equals(Environment.getExternalStorageState());
                    } catch (Exception e29) {
                        QLog.e("MusicGeneWebViewPlugin", 1, e29, new Object[0]);
                        z16 = false;
                    }
                    if (z16) {
                        cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
                    } else {
                        cacheDir = BaseApplication.getContext().getCacheDir();
                    }
                    File file = new File(new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE), md5);
                    if (!file.exists()) {
                        ThreadManagerV2.post(new Runnable(string4, optInt, file) { // from class: com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.5
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ String f251893d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ int f251894e;

                            /* renamed from: f, reason: collision with root package name */
                            final /* synthetic */ File f251895f;

                            {
                                this.f251893d = string4;
                                this.f251894e = optInt;
                                this.f251895f = file;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, MusicGeneWebViewPlugin.this, string4, Integer.valueOf(optInt), file);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Bitmap I = MusicGeneWebViewPlugin.I(this.f251893d);
                                if (I != null) {
                                    int i38 = this.f251894e;
                                    if (i38 <= 0) {
                                        i38 = 5;
                                    }
                                    Bitmap b16 = com.tencent.mobileqq.musicgene.b.b(I, 3, i38, i38);
                                    MusicGeneWebViewPlugin.this.O(b16);
                                    Message obtain = Message.obtain(MusicGeneWebViewPlugin.this.J);
                                    obtain.obj = b16;
                                    Bundle bundle4 = new Bundle();
                                    bundle4.putString("BUNDLE_KEY_FILE_PATH", this.f251895f.getPath());
                                    obtain.setData(bundle4);
                                    obtain.sendToTarget();
                                }
                            }
                        }, 8, null, true);
                    } else {
                        try {
                            O(BitmapFactory.decodeFile(file.getPath()));
                        } catch (Exception e36) {
                            e36.printStackTrace();
                        } catch (OutOfMemoryError e37) {
                            e37.printStackTrace();
                        }
                    }
                    JSONObject jSONObject16 = new JSONObject();
                    jSONObject16.put(str18, str19);
                    jsBridgeListener.c(jSONObject16);
                    return true;
                }
                if ("SONG_GET_VOLUME".equals(string)) {
                    Context context2 = this.f251887d;
                    JSONObject jSONObject17 = new JSONObject();
                    if (context2 == null || (audioManager = (AudioManager) context2.getSystemService("audio")) == null) {
                        str14 = "1";
                    } else {
                        float streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        float streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
                        int i38 = (int) streamVolume;
                        if (streamMaxVolume > 0.0f) {
                            i38 = (int) ((streamVolume / streamMaxVolume) * 100.0f);
                        }
                        jSONObject17.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, i38);
                        str14 = str19;
                    }
                    jSONObject17.put(str18, str14);
                    jsBridgeListener.c(jSONObject17);
                    return true;
                }
                if ("SHARE_SONG".equals(string)) {
                    if (jSONObject13 != null) {
                        String string5 = jSONObject13.getString("title");
                        String string6 = jSONObject13.getString("desc");
                        String string7 = jSONObject13.getString("imgUrl");
                        String string8 = jSONObject13.getString("src");
                        String string9 = jSONObject13.getString("audioUrl");
                        String string10 = jSONObject13.has("iconUrl") ? jSONObject13.getString("iconUrl") : "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif";
                        if (this.f251887d != null) {
                            Intent intent2 = new Intent("BROAD_CAST_SHARE_SONG");
                            intent2.putExtra("BUNDLE_KEY_TITLE", string5);
                            intent2.putExtra("BUNDLE_KEY_DESC", string6);
                            intent2.putExtra("BUDNLE_KEY_IMG_URL", string7);
                            intent2.putExtra("BUNDLE_KEY_SRC", string8);
                            intent2.putExtra("BUNDLE_KEY_AUDIO_URL", string9);
                            intent2.putExtra("BUNDLE_KEY_ICON_URL", string10);
                            this.f251887d.sendBroadcast(intent2, "com.tencent.music.data.permission");
                        }
                    }
                    JSONObject jSONObject18 = new JSONObject();
                    jSONObject18.put(str18, str19);
                    jsBridgeListener.c(jSONObject18);
                    return true;
                }
                if (!"SHARE_GENE".equals(string)) {
                    return true;
                }
                if (jSONObject13 != null) {
                    String string11 = jSONObject13.getString("title");
                    String string12 = jSONObject13.getString("desc");
                    String string13 = jSONObject13.getString("imgUrl");
                    String string14 = jSONObject13.getString("src");
                    long j19 = jSONObject13.has("appid") ? jSONObject13.getLong("appid") : 1101244924L;
                    String string15 = jSONObject13.has("iconUrl") ? jSONObject13.getString("iconUrl") : "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif";
                    if (this.f251887d != null) {
                        Intent intent3 = new Intent("BROAD_CAST_SHARE_MUSIC_GENE");
                        intent3.putExtra("BUNDLE_KEY_TITLE", string11);
                        intent3.putExtra("BUNDLE_KEY_DESC", string12);
                        intent3.putExtra("BUDNLE_KEY_IMG_URL", string13);
                        intent3.putExtra("BUNDLE_KEY_SRC", string14);
                        intent3.putExtra("BUNDKE_KEY_APP_ID", j19);
                        intent3.putExtra("BUNDLE_KEY_ICON_URL", string15);
                        this.f251887d.sendBroadcast(intent3, "com.tencent.music.data.permission");
                    }
                }
                JSONObject jSONObject19 = new JSONObject();
                jSONObject19.put(str18, str19);
                jsBridgeListener.c(jSONObject19);
                return true;
                e16.printStackTrace();
                return true;
            }
            if ("bindApp".equals(str3)) {
                try {
                    JSONObject jSONObject20 = new JSONObject((String) arrayList.get(0));
                    String string16 = jSONObject20.has("action") ? jSONObject20.getString("action") : null;
                    try {
                        extras = this.f251890h.getExtras();
                        i3 = 0;
                    } catch (Exception e38) {
                        e = e38;
                        i3 = 0;
                    }
                    if (extras != null) {
                        try {
                            i16 = extras.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
                        } catch (Exception e39) {
                            e = e39;
                            e.printStackTrace();
                            i16 = i3;
                            if ("CALLPAGE_SONG_STATE_CHANGE".equals(string16)) {
                            }
                        }
                        if ("CALLPAGE_SONG_STATE_CHANGE".equals(string16)) {
                            this.f251888e = true;
                            JSONObject jSONObject21 = new JSONObject();
                            jSONObject21.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, i16);
                            jSONObject21.put("code", "0");
                            jsBridgeListener.c(jSONObject21);
                            S();
                            return true;
                        }
                        if (!"CALLPAGE_SONG_TIME_UPDATE".equals(string16)) {
                            return true;
                        }
                        this.f251889f = true;
                        JSONObject jSONObject22 = new JSONObject();
                        jSONObject22.put(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, i16);
                        jSONObject22.put("code", "0");
                        jsBridgeListener.c(jSONObject22);
                        return true;
                    }
                    i16 = i3;
                    if ("CALLPAGE_SONG_STATE_CHANGE".equals(string16)) {
                    }
                } catch (JSONException unused) {
                    return true;
                }
            } else {
                "unbindApp".equals(str3);
                return true;
            }
        } else {
            return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        try {
            if (this.f251890h == null && N(str)) {
                B();
            }
        } catch (Exception e16) {
            QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handleSchemaRequest exception", e16);
        }
        return super.handleSchemaRequest(str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Activity a16 = this.mRuntime.a();
        if (a16 != null) {
            this.f251887d = a16.getApplicationContext();
        }
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        com.tencent.mobileqq.music.e eVar;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            T();
            if (this.f251887d != null && (eVar = this.f251890h) != null) {
                try {
                    i3 = eVar.getPlayState();
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                    i3 = 4;
                }
                if (i3 != 2) {
                    if (i3 == 3) {
                        try {
                            String token = this.f251890h.getToken();
                            if (token != null && token.startsWith("music_gene_")) {
                                this.f251890h.stop();
                            }
                        } catch (RemoteException e17) {
                            e17.printStackTrace();
                        }
                    }
                    P(4);
                }
                U();
                this.f251887d.unregisterReceiver(this.I);
            }
        } catch (Exception e18) {
            QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", e18);
        }
        this.f251887d = null;
        this.F = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        String url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) customWebView);
            return;
        }
        super.onWebViewCreated(customWebView);
        if (customWebView != null) {
            try {
                url = customWebView.getUrl();
            } catch (Exception e16) {
                QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", e16);
                return;
            }
        } else {
            url = "";
        }
        if (TextUtils.isEmpty(url)) {
            WebViewPlugin.b bVar = this.mRuntime;
            y d16 = bVar.d(bVar.a());
            if (d16 != null && (d16 instanceof r)) {
                url = ((r) d16).getCurrentUrl();
            }
        }
        if (this.f251887d != null) {
            if (N(url)) {
                B();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("BROAD_CAST_CALL_PAGE_SHARE");
            this.f251887d.registerReceiver(this.I, intentFilter);
        }
    }
}
