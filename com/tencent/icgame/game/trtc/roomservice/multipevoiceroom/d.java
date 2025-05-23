package com.tencent.icgame.game.trtc.roomservice.multipevoiceroom;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.icgame.game.ui.widget.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d {

    /* renamed from: n, reason: collision with root package name */
    private static volatile d f115884n;

    /* renamed from: d, reason: collision with root package name */
    private volatile TRTCCloud f115888d;

    /* renamed from: a, reason: collision with root package name */
    public final MutableLiveData<ConcurrentHashMap<String, c>> f115885a = new MutableLiveData<>();

    /* renamed from: b, reason: collision with root package name */
    public final MutableLiveData<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>> f115886b = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f115887c = new MutableLiveData<>();

    /* renamed from: e, reason: collision with root package name */
    private volatile int f115889e = 100;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f115890f = false;

    /* renamed from: g, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, c> f115891g = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> f115892h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f115893i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private ConcurrentHashMap<String, View> f115894j = new ConcurrentHashMap<>();

    /* renamed from: k, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f115895k = new ConcurrentHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private ConcurrentHashMap<String, b> f115896l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private List<String> f115897m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements Observer<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> concurrentHashMap) {
            if (d.this.f115886b.hasObservers()) {
                d.this.f115892h.putAll(concurrentHashMap);
                d dVar = d.this;
                dVar.f115886b.setValue(dVar.f115892h);
            }
        }
    }

    d() {
    }

    private synchronized void b() {
        if (this.f115891g.size() == 0) {
            QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "checkAndDestoryTrtc:\u5f53\u524d\u5df2\u7ecf\u4e0d\u5b58\u5728\u623f\u95f4\u5b9e\u4f8b\uff0c\u91ca\u653eTrtc\u8d44\u6e90");
            TRTCCloud.destroySharedInstance();
            this.f115888d = null;
        } else {
            QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "checkAndDestoryTrtc:\u5f53\u524d\u5b58\u5728\u623f\u95f4\u5b9e\u4f8b\uff0c\u4fdd\u7559Trtc\u8d44\u6e90");
        }
    }

    private boolean c() {
        if (TimiGameQQTrtcUtil.f()) {
            return true;
        }
        if (!TimiGameQQTrtcUtil.f115852b) {
            QLog.e("ICGameTRTCMultipeVoiceRoomManager", 2, "Trtc So\u52a0\u8f7d\u9a8c\u8bc1\u5931\u8d25\uff0c\u4e1a\u52a1\u9700\u5148\u901a\u8fc7TimiGameQQTrtcUtil#checkTrtcEnv\u6821\u9a8c");
        }
        if (!TimiGameQQTrtcUtil.f115851a) {
            QLog.e("ICGameTRTCMultipeVoiceRoomManager", 2, "QQ Trtc\u4e1a\u52a1\u6388\u6743\u9a8c\u8bc1\u5931\u8d25\uff0c\u4e1a\u52a1\u9700\u5148\u901a\u8fc7TimiGameQQTrtcUtil#requestQQAudioEnv\u6821\u9a8c");
        }
        if (TextUtils.isEmpty(TimiGameQQTrtcUtil.f115853c)) {
            QLog.e("ICGameTRTCMultipeVoiceRoomManager", 2, "Trtc\u7528\u6237\u7b7e\u540d\u9a8c\u8bc1\u5931\u8d25\uff0c\u4e1a\u52a1\u9700\u5148\u901a\u8fc7TimiGameQQTrtcUtil#checkTrtcUserSig\u6821\u9a8c");
        }
        if (TextUtils.isEmpty(TimiGameQQTrtcUtil.f115854d)) {
            QLog.e("ICGameTRTCMultipeVoiceRoomManager", 2, "\u76f4\u64adTrtc\u7528\u6237\u7b7e\u540d\u9a8c\u8bc1\u5931\u8d25\uff0c\u4e1a\u52a1\u9700\u5148\u901a\u8fc7TimiGameQQTrtcUtil#checkTrtcUserSig\u6821\u9a8c");
            return false;
        }
        return false;
    }

    private void d() {
        boolean z16;
        Iterator<c> it = this.f115891g.values().iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().k()) {
                    z16 = false;
                    break;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (z16) {
            this.f115888d.stopLocalAudio();
        }
        if (this.f115890f == z16) {
            this.f115890f = !z16;
            this.f115887c.setValue(Boolean.valueOf(this.f115890f));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TRTCCloudDef.TRTCParams e(com.tencent.icgame.game.trtc.roomservice.multipevoiceroom.a aVar, String str, String str2) {
        int i3;
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        if (ServerEnv.d()) {
            i3 = 1400468649;
        } else {
            i3 = 1400467382;
        }
        String str3 = TimiGameQQTrtcUtil.f115853c;
        tRTCParams.role = 20;
        tRTCParams.userSig = str3;
        tRTCParams.sdkAppId = i3;
        tRTCParams.userId = str;
        if (str2 != 0) {
            if (str2 instanceof Integer) {
                tRTCParams.roomId = ((Integer) str2).intValue();
            } else if (str2 instanceof String) {
                tRTCParams.roomId = -1;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("strGroupId", str2);
                } catch (JSONException e16) {
                    QLog.e("ICGameTRTCMultipeVoiceRoomManager", 4, e16.toString(), e16);
                }
                tRTCParams.businessInfo = jSONObject.toString();
            }
        }
        return tRTCParams;
    }

    public static d h() {
        if (f115884n == null) {
            synchronized (d.class) {
                if (f115884n == null) {
                    f115884n = new d();
                }
            }
        }
        return f115884n;
    }

    private synchronized boolean j() {
        QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "initTrtc");
        try {
            this.f115888d = TRTCCloud.sharedInstance(BaseApplication.getContext());
            this.f115888d.switchRole(20);
            this.f115888d.muteLocalAudio(true);
            this.f115888d.muteLocalVideo(true);
            this.f115888d.setSystemVolumeType(1);
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    private void k(@NonNull String str, @Nullable String str2, @Nullable View view) {
        c i3 = i(str);
        if (i3 != null && (view instanceof TXCloudVideoView)) {
            i3.j().setRemoteViewFillMode(str2, 1);
            i3.j().startRemoteView(str2, (TXCloudVideoView) view);
        }
    }

    private void p(String str) {
        r(str);
        a aVar = new a();
        this.f115893i.put(str, aVar);
        c i3 = i(str);
        if (i3 != null) {
            i3.f115869l.observeForever(aVar);
        }
    }

    private void r(String str) {
        a aVar = this.f115893i.get(str);
        c i3 = i(str);
        if (aVar != null && i3 != null) {
            i3.f115869l.removeObserver(aVar);
            this.f115892h.remove(str);
            this.f115886b.setValue(this.f115892h);
        }
    }

    public synchronized void f(String str, String str2, com.tencent.icgame.game.trtc.roomservice.multipevoiceroom.a aVar, int i3, b bVar) {
        String str3;
        if (!c()) {
            return;
        }
        if (i3 == 1) {
            str3 = "\u8f66\u961f";
        } else if (i3 == 5) {
            str3 = "\u5927\u5385";
        } else {
            str3 = "\u623f\u95f4";
        }
        QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "enterVoiceRoom:" + str + " userID:" + str2 + " roomBizSimpleName:" + str3);
        this.f115895k.put(str, str3);
        this.f115896l.put(str, bVar);
        if (this.f115888d == null) {
            QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "enterVoiceRoom Trtc\u5df2\u91ca\u653e\uff0c\u91cd\u65b0\u521b\u5efa trigger by Room:" + str);
            j();
        }
        c i16 = i(str);
        if (i16 == null) {
            TRTCCloud createSubCloud = this.f115888d.createSubCloud();
            if (createSubCloud != null) {
                i16 = new c(createSubCloud, str, str2);
                this.f115891g.put(str, i16);
            }
            if (i16 == null) {
                QLog.e("ICGameTRTCMultipeVoiceRoomManager", 4, "enterVoiceRoom\uff01\uff01trtc\u521d\u59cb\u5316\u5931\u8d25:" + str);
                return;
            }
            TRTCCloud j3 = i16.j();
            TRTCCloudDef.TRTCParams e16 = e(aVar, str2, str);
            j3.enableAudioVolumeEvaluation(300);
            j3.enterRoom(e16, 1);
            j3.muteLocalAudio(true);
            p(str);
            s();
            return;
        }
        QLog.e("ICGameTRTCMultipeVoiceRoomManager", 4, "enterVoiceRoom\uff01\uff01\u5df2\u7ecf\u5728\u623f\u95f4\u5185:" + str);
    }

    public synchronized void g(String str) {
        QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "exitVoiceRoom:" + str);
        if (!c()) {
            return;
        }
        this.f115895k.remove(str);
        this.f115896l.remove(str);
        this.f115897m.remove(str);
        c i3 = i(str);
        if (i3 != null) {
            l(str);
            m(str);
            i3.j().exitRoom();
            this.f115888d.destroySubCloud(i3.j());
            d();
            r(str);
            this.f115891g.remove(str);
            s();
            b();
            this.f115894j.clear();
        } else {
            QLog.e("ICGameTRTCMultipeVoiceRoomManager", 4, "exitVoiceRoom:" + str + "Not Found!");
        }
    }

    public synchronized c i(String str) {
        if (!c()) {
            return null;
        }
        return this.f115891g.get(str);
    }

    public synchronized void l(String str) {
        QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "muteMicForVoiceRoom:" + str);
        if (!c()) {
            return;
        }
        c i3 = i(str);
        if (i3 != null) {
            i3.j().muteLocalAudio(true);
            i3.m(true);
            d();
            s();
            this.f115897m.clear();
            if (this.f115897m.size() > 0) {
                String str2 = this.f115897m.get(0);
                String str3 = this.f115895k.get(str2);
                QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "muteMicForVoiceRoom " + str + ", resume closed room first = " + str2 + " - " + str3);
                this.f115897m.clear();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u5df2\u4e3a\u4f60\u81ea\u52a8\u6062\u590d");
                sb5.append(str3);
                sb5.append("\u9ea6\u514b\u98ce");
                f.b(sb5.toString());
                b bVar = this.f115896l.get(str2);
                if (bVar != null) {
                    bVar.a(str2, true);
                } else {
                    n(str2);
                }
            }
        } else {
            QLog.e("ICGameTRTCMultipeVoiceRoomManager", 4, "muteMicForVoiceRoom:" + str + "Not Found!");
        }
    }

    public synchronized void m(String str) {
        QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "muteSpeakerForVoiceRoom:" + str);
        if (!c()) {
            return;
        }
        c i3 = i(str);
        if (i3 != null) {
            i3.j().muteAllRemoteAudio(true);
            i3.o(true);
            s();
        } else {
            QLog.e("ICGameTRTCMultipeVoiceRoomManager", 4, "muteSpeakerForVoiceRoom:" + str + "Not Found!");
        }
    }

    public synchronized void n(String str) {
        QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "openMicForVoiceRoom:" + str);
        if (!c()) {
            return;
        }
        c i3 = i(str);
        if (i3 != null) {
            this.f115897m.clear();
            for (c cVar : this.f115891g.values()) {
                if (!cVar.k() && !cVar.i().equals(str)) {
                    l(cVar.i());
                    m(cVar.i());
                    b bVar = this.f115896l.get(cVar.i());
                    if (bVar != null) {
                        bVar.a(cVar.i(), false);
                    }
                    this.f115897m.add(cVar.i());
                }
            }
            if (this.f115897m.size() > 0) {
                String str2 = this.f115897m.get(0);
                String str3 = this.f115895k.get(str);
                String str4 = this.f115895k.get(str2);
                QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "openMicForVoiceRoom " + str + " - " + str3 + ", closed room first = " + str2 + " - " + str4);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u5df2\u5207\u6362\u4e3a");
                sb5.append(str3);
                sb5.append("\u8bed\u97f3\uff0c");
                sb5.append(str4);
                sb5.append("\u58f0\u97f3\u5df2\u5173\u95ed");
                f.b(sb5.toString());
            }
            this.f115888d.startLocalAudio();
            i3.j().muteLocalAudio(false);
            i3.m(false);
            d();
            s();
        } else {
            QLog.e("ICGameTRTCMultipeVoiceRoomManager", 4, "openMicForVoiceRoom:" + str + "Not Found!");
        }
    }

    public synchronized void o(String str) {
        QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "openSpeakerForVoiceRoom:" + str);
        if (!c()) {
            return;
        }
        c i3 = i(str);
        if (i3 != null) {
            ArrayList arrayList = new ArrayList();
            for (c cVar : this.f115891g.values()) {
                if (!cVar.l() && !cVar.i().equals(str)) {
                    m(cVar.i());
                    l(cVar.i());
                    arrayList.add(cVar.i());
                    b bVar = this.f115896l.get(cVar.i());
                    if (bVar != null) {
                        bVar.a(cVar.i(), false);
                    }
                    this.f115897m.add(cVar.i());
                }
            }
            if (arrayList.size() > 0) {
                String str2 = (String) arrayList.get(0);
                String str3 = this.f115895k.get(str);
                String str4 = this.f115895k.get(str2);
                QLog.i("ICGameTRTCMultipeVoiceRoomManager", 4, "openSpeakerForVoiceRoom " + str + " - " + str3 + ", closed room first = " + str2 + " - " + str4);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u5df2\u5207\u6362\u4e3a");
                sb5.append(str3);
                sb5.append("\u8bed\u97f3\uff0c");
                sb5.append(str4);
                sb5.append("\u58f0\u97f3\u5df2\u5173\u95ed");
                f.b(sb5.toString());
            }
            i3.j().muteAllRemoteAudio(false);
            i3.o(false);
            s();
        } else {
            QLog.e("ICGameTRTCMultipeVoiceRoomManager", 4, "openSpeakerForVoiceRoom:" + str + "Not Found!");
        }
    }

    public void q(@NonNull String str, @Nullable String str2) {
        View view;
        if (!TextUtils.isEmpty(str2) && (view = this.f115894j.get(str2)) != null) {
            k(str, str2, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        if (this.f115885a.hasObservers()) {
            this.f115885a.setValue(this.f115891g);
        }
    }
}
