package jd0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f409821a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f409822b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f409823c;

    /* renamed from: d, reason: collision with root package name */
    private c f409824d;

    /* renamed from: e, reason: collision with root package name */
    protected BroadcastReceiver f409825e = new C10581a();

    /* compiled from: P */
    /* renamed from: jd0.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C10581a extends BroadcastReceiver {
        C10581a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(action)) {
                String stringExtra = intent.getStringExtra("data");
                String stringExtra2 = intent.getStringExtra("event");
                if (QLog.isColorLevel()) {
                    QLog.d("MusicCache", 2, "onReceive:" + stringExtra);
                }
                if (!TextUtils.isEmpty(stringExtra2) && stringExtra2.equals(QQWinkConstants.JS_PLUGIN_EVENT_SELECT_MUSIC) && !TextUtils.isEmpty(stringExtra)) {
                    a.this.f409824d.c();
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        int optInt = jSONObject.optInt("id");
                        String string = context.getSharedPreferences("VideoMusicCache", 0).getString(String.valueOf(optInt), null);
                        if (string != null && new File(string).exists()) {
                            d dVar = new d();
                            dVar.f409838b = jSONObject.optString("title");
                            dVar.f409844h = 2;
                            dVar.f409837a = String.valueOf(optInt);
                            dVar.f409846j = string;
                            a.this.f409824d.a(dVar);
                        } else {
                            MusicItemInfo musicItemInfo = new MusicItemInfo();
                            musicItemInfo.mType = 5;
                            musicItemInfo.mItemId = optInt;
                            musicItemInfo.mMusicName = jSONObject.optString("title");
                            musicItemInfo.mSingername = jSONObject.optString("desc");
                            musicItemInfo.mSongMid = jSONObject.optString("mid");
                            a.this.f409823c = jSONObject.optBoolean(IAELaunchMusicConfigManager.JSON_KEY_H5_MUSIC_FROM, false);
                            a.this.h(musicItemInfo.mSongMid);
                        }
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("MusicCache", 2, "on receiver error, ", e16);
                        }
                    }
                    id0.b.i("0X80076D6");
                    return;
                }
                return;
            }
            if ("action_music_start".equals(action)) {
                a.this.f409824d.b();
            } else if ("action_music_refresh_list".equals(action)) {
                a.this.f409822b.sendEmptyMessage(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements ns.a {
        b() {
        }

        @Override // ns.a
        public void a(boolean z16, Object obj) {
            String string = a.this.f409821a.getResources().getString(R.string.f2s);
            if (z16) {
                FlowMusic flowMusic = (FlowMusic) obj;
                if (QLog.isColorLevel()) {
                    QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + flowMusic.toString());
                }
                if (flowMusic.playable == 1 && !TextUtils.isEmpty(flowMusic.url)) {
                    d dVar = new d();
                    dVar.f409838b = flowMusic.songName;
                    dVar.f409840d = flowMusic.url;
                    dVar.f409844h = 2;
                    dVar.f409837a = String.valueOf(flowMusic.songId);
                    a.this.g(12, dVar);
                    return;
                }
                if (flowMusic.playable != 1) {
                    string = a.this.f409821a.getResources().getString(R.string.f2t);
                }
            }
            a.this.g(7, string);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
        void a(d dVar);

        void b();

        void c();
    }

    public a(Context context, c cVar, Handler handler) {
        this.f409821a = context;
        this.f409822b = handler;
        this.f409824d = cVar;
        IntentFilter intentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        intentFilter.addAction("action_music_start");
        intentFilter.addAction("action_music_refresh_list");
        this.f409821a.registerReceiver(this.f409825e, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("MusicCache", 2, "songMid not exist");
            }
            g(7, this.f409821a.getResources().getString(R.string.f2s));
        } else if (!NetworkUtil.isNetSupport(this.f409821a)) {
            if (QLog.isColorLevel()) {
                QLog.d("MusicCache", 2, "Net not Support");
            }
            g(7, this.f409821a.getResources().getString(R.string.f2x));
        } else {
            if (NetworkUtil.isMobileNetWork(this.f409821a)) {
                g(7, this.f409821a.getResources().getString(R.string.f2w));
            }
            ((IAELaunchMusicConfigManager) QRoute.api(IAELaunchMusicConfigManager.class)).getSingleFullMusicInfo(str, this.f409823c, new b());
        }
    }

    public void f() {
        this.f409821a.unregisterReceiver(this.f409825e);
    }

    public void g(int i3, Object obj) {
        this.f409822b.sendMessage(this.f409822b.obtainMessage(i3, obj));
    }
}
