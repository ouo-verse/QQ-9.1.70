package com.tencent.mobileqq.ark.api.module;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.music.g;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes11.dex */
public class ArkAppMusicModule extends b {

    /* renamed from: p, reason: collision with root package name */
    private static String f198955p = "";

    /* renamed from: q, reason: collision with root package name */
    protected static final CopyOnWriteArrayList<WeakReference<ArkAppMusicModule>> f198956q = new CopyOnWriteArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    private static a f198957r;

    /* renamed from: l, reason: collision with root package name */
    private WeakReference<ArkAppMusicModule> f198958l;

    /* renamed from: m, reason: collision with root package name */
    protected long f198959m;

    /* renamed from: n, reason: collision with root package name */
    protected String f198960n;

    /* renamed from: o, reason: collision with root package name */
    protected SongInfo f198961o;

    public ArkAppMusicModule(ark.Application application, int i3) {
        super(application, i3);
        this.f198959m = 0L;
        f198957r = new a();
        WeakReference<ArkAppMusicModule> weakReference = new WeakReference<>(this);
        this.f198958l = weakReference;
        f198956q.add(weakReference);
    }

    protected static int s(int i3) {
        if (i3 != 0) {
            switch (i3) {
                case 2:
                    return 1;
                case 3:
                    return 2;
                case 4:
                    return 3;
                case 5:
                case 6:
                case 7:
                    return 0;
                default:
                    return 5;
            }
        }
        return 4;
    }

    public static String t() {
        if (TextUtils.isEmpty(f198955p)) {
            f198955p = QQPlayerService.Y(1, "ark.music.module");
        }
        return f198955p;
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        QQPlayerService.S0(f198957r);
        f198956q.remove(this.f198958l);
        this.f198958l = null;
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQMusic";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        if (str.equals("Play") || str.equals("Stop") || str.equals("Pause") || str.equals("Resume") || str.equals("GetCurrentTime") || str.equals("GetDuration") || str.equals("GetState") || str.equals("GetCurrentSong") || str.equals("SetCallback") || str.equals("AttachEvent") || str.equals("DetachEvent")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        ark.VariantWrapper l3;
        if (!str.equals("GetCurrentTime") && !str.equals("GetDuration")) {
            QLog.i("ark.music.module", 2, "ArkAppMusicModule.invokeFunc." + str);
        }
        if (str.equals("Play")) {
            QQPlayerService.Z0(null);
            v(variantWrapperArr);
            return true;
        }
        if (str.equals("Stop")) {
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.3
                @Override // java.lang.Runnable
                public void run() {
                    BaseActivity baseActivity = BaseActivity.sTopActivity;
                    if (baseActivity instanceof BaseActivity) {
                        QQPlayerService.m1(baseActivity);
                    }
                }
            });
            return true;
        }
        if (str.equals("Pause")) {
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.4
                @Override // java.lang.Runnable
                public void run() {
                    BaseActivity baseActivity = BaseActivity.sTopActivity;
                    if (baseActivity instanceof BaseActivity) {
                        QQPlayerService.K0(baseActivity);
                    }
                }
            });
            return true;
        }
        if (str.equals("Resume")) {
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.5
                @Override // java.lang.Runnable
                public void run() {
                    BaseActivity baseActivity = BaseActivity.sTopActivity;
                    if (baseActivity instanceof BaseActivity) {
                        QQPlayerService.U0(baseActivity);
                    }
                }
            });
            return true;
        }
        if (str.equals("GetCurrentTime")) {
            double d16 = 0.0d;
            if (QQPlayerService.m0() == 2 || QQPlayerService.m0() == 3) {
                try {
                    d16 = QQPlayerService.a0() / 1000.0d;
                } catch (IllegalStateException e16) {
                    QLog.d("ark.music.module", 2, "ArkAppMusicModule.invokeFunc.getCurrentPlayPosition.error", e16.getMessage());
                }
            }
            variantWrapper.SetDouble(d16);
            return true;
        }
        if (str.equals("GetDuration")) {
            variantWrapper.SetDouble(QQPlayerService.e0() / 1000.0d);
            return true;
        }
        if (str.equals("GetState")) {
            variantWrapper.SetInt(s(QQPlayerService.m0()));
            return true;
        }
        if (str.equals("GetCurrentSong")) {
            r(variantWrapperArr[0], QQPlayerService.b0());
            return true;
        }
        if (str.equals("SetCallback")) {
            ark.VariantWrapper l16 = l(this.f198959m);
            if (l16 != null) {
                l16.Reset();
            }
            ark.VariantWrapper variantWrapper2 = variantWrapperArr[0];
            if (variantWrapper2 != null && variantWrapper2.IsFunction()) {
                this.f198959m = g(variantWrapper2.Copy());
                QQPlayerService.R(f198957r);
                QQPlayerService.Z0(null);
                return true;
            }
            this.f198959m = 0L;
            return true;
        }
        if (str.equals("AttachEvent")) {
            ark.VariantWrapper variantWrapper3 = variantWrapperArr[0];
            if (variantWrapper3 != null && variantWrapper3.IsString() && "State".equals(variantWrapper3.GetString())) {
                ark.VariantWrapper l17 = l(this.f198959m);
                if (l17 != null) {
                    l17.Reset();
                }
                ark.VariantWrapper variantWrapper4 = variantWrapperArr[1];
                if (variantWrapper4 != null && variantWrapper4.IsFunction()) {
                    this.f198959m = g(variantWrapper4.Copy());
                    QQPlayerService.Z0(null);
                    return true;
                }
                this.f198959m = 0L;
            }
            return true;
        }
        if (!str.equals("DetachEvent")) {
            return false;
        }
        ark.VariantWrapper variantWrapper5 = variantWrapperArr[0];
        if (variantWrapper5 != null && variantWrapper5.IsString() && "State".equals(variantWrapper5.GetString()) && (l3 = l(this.f198959m)) != null) {
            l3.Reset();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    protected e[] e() {
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean n() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return false;
    }

    public void q(ark.VariantWrapper variantWrapper, int i3, SongInfo songInfo) {
        if (variantWrapper != null && variantWrapper.IsFunction() && songInfo != null) {
            int s16 = s(i3);
            if (s16 == 5) {
                if (QLog.isColorLevel()) {
                    QLog.i("ark.music.module", 2, "ArkAppMusicModule.callback.state.invalid");
                    return;
                }
                return;
            }
            ark.VariantWrapper Create = variantWrapper.Create();
            if (QLog.isColorLevel()) {
                QLog.i("ark.music.module", 2, String.format(Locale.CHINA, "ArkAppMusicModule.callback.state: %d", Integer.valueOf(s16)));
            }
            Create.SetInt(s16);
            ark.VariantWrapper Create2 = variantWrapper.Create();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", songInfo.f251870h);
                jSONObject.put("title", songInfo.f251871i);
                jSONObject.put("singer", songInfo.F);
                jSONObject.put("id", String.format(Locale.CHINA, "%d", Long.valueOf(songInfo.f251867d)));
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ark.music.module", 2, "ArkAppMusicModule.doCallback.1.json.", e16.getMessage());
                }
            }
            Create2.SetTableAsJsonString(jSONObject.toString());
            ark.VariantWrapper Create3 = variantWrapper.Create();
            variantWrapper.InvokeDefault(new ark.VariantWrapper[]{Create, Create2}, Create3);
            Create2.Reset();
            Create.Reset();
            Create3.Reset();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ark.music.module", 2, "ArkAppMusicModule.callback.invalid");
        }
    }

    public void r(ark.VariantWrapper variantWrapper, SongInfo songInfo) {
        if (variantWrapper != null && variantWrapper.IsFunction()) {
            ark.VariantWrapper Create = variantWrapper.Create();
            ark.VariantWrapper Create2 = variantWrapper.Create();
            if (songInfo != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", songInfo.f251870h);
                    jSONObject.put("title", songInfo.f251871i);
                    jSONObject.put("singer", songInfo.F);
                    jSONObject.put("id", String.format(Locale.CHINA, "%d", Long.valueOf(songInfo.f251867d)));
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ark.music.module", 2, "ArkAppMusicModule.doCallback.2.json.", e16.getMessage());
                    }
                }
                Create2.SetTableAsJsonString(jSONObject.toString());
            }
            variantWrapper.InvokeDefault(new ark.VariantWrapper[]{Create2}, Create);
            Create2.Reset();
            Create.Reset();
        }
    }

    public void u(final int i3) {
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(this.f199566b, new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.1
            @Override // java.lang.Runnable
            public void run() {
                ArkAppMusicModule arkAppMusicModule = ArkAppMusicModule.this;
                long j3 = arkAppMusicModule.f198959m;
                if (j3 != 0) {
                    ark.VariantWrapper d16 = arkAppMusicModule.d(j3);
                    SongInfo b06 = QQPlayerService.b0();
                    if (b06 == null) {
                        b06 = ArkAppMusicModule.this.f198961o;
                    }
                    ArkAppMusicModule.this.q(d16, i3, b06);
                    if (i3 == 4) {
                        ArkAppMusicModule.this.f198961o = null;
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ark.music.module", 2, "ArkAppMusicModule.callback.invalid");
                }
            }
        });
    }

    protected void v(ark.VariantWrapper[] variantWrapperArr) {
        if (variantWrapperArr != null && variantWrapperArr.length >= 2) {
            final SongInfo songInfo = new SongInfo();
            songInfo.I = 4;
            String GetString = variantWrapperArr[0].GetString();
            songInfo.f251870h = GetString;
            if (GetString != null) {
                try {
                    songInfo.f251868e = Uri.parse(GetString).getQueryParameter("songmid");
                } catch (Exception e16) {
                    QLog.e("ark.music.module", 1, "songmid = null: " + e16);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(variantWrapperArr[1].GetTableAsJsonString());
                songInfo.D = jSONObject.optString("url");
                songInfo.f251871i = jSONObject.optString("title");
                songInfo.F = jSONObject.optString("singer");
                songInfo.f251867d = jSONObject.optLong("id");
            } catch (JSONException e17) {
                QLog.e("ark.music.module", 2, "QQMusic.Play parameter error: " + e17.getMessage());
            }
            this.f198960n = songInfo.f251870h;
            this.f198961o = songInfo;
            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.ArkAppMusicModule.2
                @Override // java.lang.Runnable
                public void run() {
                    BaseActivity baseActivity = BaseActivity.sTopActivity;
                    if (baseActivity instanceof BaseActivity) {
                        QQPlayerService.b1(new Intent(BaseApplication.getContext(), (Class<?>) MusicPlayerActivity.class));
                        QQPlayerService.c1(101);
                        QQPlayerService.i1(baseActivity, ArkAppMusicModule.t(), new SongInfo[]{songInfo});
                        QLog.d("ark.music.module", 2, "QQMusic.startPlayMusic: " + songInfo.f251870h);
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static final class a implements g {
        @Override // com.tencent.mobileqq.music.g
        public String getToken() {
            return ArkAppMusicModule.t();
        }

        @Override // com.tencent.mobileqq.music.g
        public void onPlayStateChanged(int i3) {
            Iterator<WeakReference<ArkAppMusicModule>> it = ArkAppMusicModule.f198956q.iterator();
            while (it.hasNext()) {
                ArkAppMusicModule arkAppMusicModule = it.next().get();
                if (arkAppMusicModule != null) {
                    arkAppMusicModule.u(i3);
                }
            }
        }

        @Override // com.tencent.mobileqq.music.g
        public void onPlaySongChanged(SongInfo songInfo) {
        }
    }
}
