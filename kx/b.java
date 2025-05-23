package kx;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.jsp.h;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.g;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    public static String f413344e = "msg_key";

    /* renamed from: b, reason: collision with root package name */
    TroopMemberApiService f413346b;

    /* renamed from: a, reason: collision with root package name */
    private final String f413345a = "QQMusicService";

    /* renamed from: c, reason: collision with root package name */
    long f413347c = 0;

    /* renamed from: d, reason: collision with root package name */
    g f413348d = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements g {
        a() {
        }

        @Override // com.tencent.mobileqq.music.g
        public String getToken() {
            return QQPlayerService.Y(5, "" + b.this.f413347c);
        }

        @Override // com.tencent.mobileqq.music.g
        public void onPlaySongChanged(SongInfo songInfo) {
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicService", 2, "onPlaySongChanged:" + songInfo.f251871i);
            }
        }

        @Override // com.tencent.mobileqq.music.g
        public void onPlayStateChanged(int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicService", 2, "onPlayStateChanged:" + i3);
            }
            JSONObject d16 = b.this.d(QQPlayerService.b0());
            if (d16 != null) {
                try {
                    d16.put("state", i3);
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQMusicService", 2, "onPlayStateChanged:" + e16.getStackTrace());
                    }
                    e16.printStackTrace();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add("*.qq.com");
                h.w("qbrowserMusicStateChange", d16, arrayList, null);
            }
        }
    }

    public b(TroopMemberApiService troopMemberApiService) {
        this.f413346b = troopMemberApiService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject d(SongInfo songInfo) {
        if (songInfo == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", songInfo.f251867d);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        try {
            jSONObject.put(AppConstants.Key.SHARE_REQ_AUDIO_URL, songInfo.f251870h);
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        try {
            jSONObject.put("title", songInfo.f251871i);
        } catch (JSONException e18) {
            e18.printStackTrace();
        }
        try {
            jSONObject.put("desc", songInfo.f251872m);
        } catch (JSONException e19) {
            e19.printStackTrace();
        }
        try {
            jSONObject.put("image_url", songInfo.C);
        } catch (JSONException e26) {
            e26.printStackTrace();
        }
        try {
            jSONObject.put(GetGuildJoinUrlServlet.BUNDLE_KEY_URL, songInfo.D);
        } catch (JSONException e27) {
            e27.printStackTrace();
        }
        return jSONObject;
    }

    public void b(AppRuntime appRuntime, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int i3 = bundle.getInt(f413344e);
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f413344e, i3);
        int i16 = bundle.getInt("seq", -1);
        if (i16 != -1) {
            bundle2.putInt("seq", i16);
        }
        switch (i3) {
            case 1:
                c(bundle.getString("music"));
                return;
            case 2:
                QQPlayerService.K0(BaseApplication.getContext());
                return;
            case 3:
                QQPlayerService.U0(BaseApplication.getContext());
                return;
            case 4:
                QQPlayerService.Z0(this.f413348d);
                bundle2.putInt("state", QQPlayerService.m0());
                this.f413346b.X(8, bundle2);
                return;
            case 5:
                QQPlayerService.c1(bundle.getInt("mode"));
                return;
            case 6:
                QQPlayerService.Z0(this.f413348d);
                bundle2.putInt("mode", QQPlayerService.l0());
                this.f413346b.X(8, bundle2);
                return;
            case 7:
                QQPlayerService.Z0(this.f413348d);
                JSONObject d16 = d(QQPlayerService.b0());
                if (d16 != null) {
                    bundle2.putString("music", d16.toString());
                }
                this.f413346b.X(8, bundle2);
                return;
            case 8:
                QQPlayerService.m1(BaseApplication.getContext());
                return;
            default:
                return;
        }
    }

    public void c(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("QQMusicService", 2, "playQQMusic err:" + str);
            }
            e16.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("mtype", 1);
        SongInfo songInfo = new SongInfo();
        songInfo.f251867d = jSONObject.optLong("id");
        songInfo.f251870h = jSONObject.optString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
        songInfo.f251871i = jSONObject.optString("title");
        songInfo.f251872m = jSONObject.optString("desc");
        songInfo.C = jSONObject.optString("image_url");
        songInfo.D = jSONObject.optString(GetGuildJoinUrlServlet.BUNDLE_KEY_URL);
        this.f413347c = songInfo.f251867d;
        QQPlayerService.b1(new Intent(BaseApplication.getContext(), (Class<?>) MusicPlayerActivity.class));
        QQPlayerService.Z0(this.f413348d);
        QQPlayerService.l1(BaseApplication.getContext(), this.f413348d.getToken(), songInfo);
    }
}
