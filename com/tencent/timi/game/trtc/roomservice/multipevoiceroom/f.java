package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f implements d {

    /* renamed from: n, reason: collision with root package name */
    private static volatile f f380034n;

    /* renamed from: d, reason: collision with root package name */
    private volatile TRTCCloud f380038d;

    /* renamed from: a, reason: collision with root package name */
    public final MutableLiveData<ConcurrentHashMap<String, e>> f380035a = new MutableLiveData<>();

    /* renamed from: b, reason: collision with root package name */
    public final MutableLiveData<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>> f380036b = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f380037c = new MutableLiveData<>();

    /* renamed from: e, reason: collision with root package name */
    private volatile int f380039e = 100;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f380040f = false;

    /* renamed from: g, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, e> f380041g = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> f380042h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f380043i = new ConcurrentHashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private ConcurrentHashMap<String, View> f380044j = new ConcurrentHashMap<>();

    /* renamed from: k, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f380045k = new ConcurrentHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private ConcurrentHashMap<String, c> f380046l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private List<String> f380047m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements Observer<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> concurrentHashMap) {
            if (f.this.f380036b.hasObservers()) {
                f.this.f380042h.putAll(concurrentHashMap);
                f fVar = f.this;
                fVar.f380036b.setValue(fVar.f380042h);
            }
        }
    }

    f() {
    }

    private synchronized void q() {
        if (this.f380041g.size() == 0) {
            QLog.i("TRTCMultipeVoiceRoomManager", 4, "checkAndDestoryTrtc:\u5f53\u524d\u5df2\u7ecf\u4e0d\u5b58\u5728\u623f\u95f4\u5b9e\u4f8b\uff0c\u91ca\u653eTrtc\u8d44\u6e90");
            TRTCCloud.destroySharedInstance();
            this.f380038d = null;
        } else {
            QLog.i("TRTCMultipeVoiceRoomManager", 4, "checkAndDestoryTrtc:\u5f53\u524d\u5b58\u5728\u623f\u95f4\u5b9e\u4f8b\uff0c\u4fdd\u7559Trtc\u8d44\u6e90");
        }
    }

    private boolean r() {
        if (TimiGameQQTrtcUtil.f()) {
            return true;
        }
        if (!TimiGameQQTrtcUtil.f379998b) {
            QLog.e("TRTCMultipeVoiceRoomManager", 2, "Trtc So\u52a0\u8f7d\u9a8c\u8bc1\u5931\u8d25\uff0c\u4e1a\u52a1\u9700\u5148\u901a\u8fc7TimiGameQQTrtcUtil#checkTrtcEnv\u6821\u9a8c");
        }
        if (!TimiGameQQTrtcUtil.f379997a) {
            QLog.e("TRTCMultipeVoiceRoomManager", 2, "QQ Trtc\u4e1a\u52a1\u6388\u6743\u9a8c\u8bc1\u5931\u8d25\uff0c\u4e1a\u52a1\u9700\u5148\u901a\u8fc7TimiGameQQTrtcUtil#requestQQAudioEnv\u6821\u9a8c");
        }
        if (TextUtils.isEmpty(TimiGameQQTrtcUtil.f379999c)) {
            QLog.e("TRTCMultipeVoiceRoomManager", 2, "Trtc\u7528\u6237\u7b7e\u540d\u9a8c\u8bc1\u5931\u8d25\uff0c\u4e1a\u52a1\u9700\u5148\u901a\u8fc7TimiGameQQTrtcUtil#checkTrtcUserSig\u6821\u9a8c");
        }
        if (TextUtils.isEmpty(TimiGameQQTrtcUtil.f380000d)) {
            QLog.e("TRTCMultipeVoiceRoomManager", 2, "\u76f4\u64adTrtc\u7528\u6237\u7b7e\u540d\u9a8c\u8bc1\u5931\u8d25\uff0c\u4e1a\u52a1\u9700\u5148\u901a\u8fc7TimiGameQQTrtcUtil#checkTrtcUserSig\u6821\u9a8c");
            return false;
        }
        return false;
    }

    private void s() {
        boolean z16;
        Iterator<e> it = this.f380041g.values().iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().o()) {
                    z16 = false;
                    break;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (z16) {
            this.f380038d.stopLocalAudio();
        }
        if (this.f380040f == z16) {
            this.f380040f = !z16;
            this.f380037c.setValue(Boolean.valueOf(this.f380040f));
        }
    }

    private TRTCCloudDef.TRTCParams t(com.tencent.timi.game.trtc.roomservice.multipevoiceroom.a aVar, String str, String str2) {
        int i3;
        int i16;
        String str3;
        Object obj;
        String str4;
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        if (aVar != null) {
            i16 = aVar.f380004a;
            str4 = aVar.f380005b;
            obj = aVar.f380006c;
            str3 = aVar.f380007d;
        } else {
            if (ServerEnv.d()) {
                i3 = 1400468649;
            } else {
                i3 = 1400467382;
            }
            i16 = i3;
            str3 = str;
            obj = str2;
            str4 = TimiGameQQTrtcUtil.f379999c;
        }
        tRTCParams.role = 20;
        tRTCParams.userSig = str4;
        tRTCParams.sdkAppId = i16;
        tRTCParams.userId = str3;
        if (obj != null) {
            if (obj instanceof Integer) {
                tRTCParams.roomId = ((Integer) obj).intValue();
            } else if (obj instanceof String) {
                tRTCParams.roomId = -1;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("strGroupId", (String) obj);
                } catch (JSONException e16) {
                    QLog.e("TRTCMultipeVoiceRoomManager", 4, e16.toString(), e16);
                }
                tRTCParams.businessInfo = jSONObject.toString();
            }
        }
        return tRTCParams;
    }

    public static f u() {
        if (f380034n == null) {
            synchronized (f.class) {
                if (f380034n == null) {
                    f380034n = new f();
                }
            }
        }
        return f380034n;
    }

    private synchronized boolean v() {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "initTrtc");
        try {
            this.f380038d = TRTCCloud.sharedInstance(BaseApplication.getContext());
            this.f380038d.switchRole(20);
            this.f380038d.muteLocalAudio(true);
            this.f380038d.muteLocalVideo(true);
            this.f380038d.setSystemVolumeType(1);
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    private void w(@NonNull String str, @Nullable String str2, @Nullable View view) {
        e j3 = j(str);
        if (j3 != null && (view instanceof TXCloudVideoView)) {
            j3.n().setRemoteViewFillMode(str2, 1);
            j3.n().startRemoteView(str2, (TXCloudVideoView) view);
        }
    }

    private void x(String str) {
        z(str);
        a aVar = new a();
        this.f380043i.put(str, aVar);
        e j3 = j(str);
        if (j3 != null) {
            j3.f380019l.observeForever(aVar);
        }
    }

    private void z(String str) {
        a aVar = this.f380043i.get(str);
        e j3 = j(str);
        if (aVar != null && j3 != null) {
            j3.f380019l.removeObserver(aVar);
            this.f380042h.remove(str);
            this.f380036b.setValue(this.f380042h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        if (this.f380035a.hasObservers()) {
            this.f380035a.setValue(this.f380041g);
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.d
    public synchronized void a(String str, String str2, com.tencent.timi.game.trtc.roomservice.multipevoiceroom.a aVar, int i3, c cVar) {
        String str3;
        if (!r()) {
            return;
        }
        if (aVar != null) {
            str = aVar.f380006c + "";
        }
        if (i3 == 1) {
            str3 = "\u8f66\u961f";
        } else if (i3 == 5) {
            str3 = "\u5927\u5385";
        } else {
            str3 = "\u623f\u95f4";
        }
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "enterVoiceRoom:" + str + " userID:" + str2 + " roomBizSimpleName:" + str3);
        this.f380045k.put(str, str3);
        this.f380046l.put(str, cVar);
        if (this.f380038d == null) {
            QLog.i("TRTCMultipeVoiceRoomManager", 4, "enterVoiceRoom Trtc\u5df2\u91ca\u653e\uff0c\u91cd\u65b0\u521b\u5efa trigger by Room:" + str);
            v();
        }
        e j3 = j(str);
        if (j3 == null && this.f380038d != null) {
            TRTCCloud createSubCloud = this.f380038d.createSubCloud();
            if (createSubCloud != null) {
                j3 = new e(createSubCloud, str, str2);
                this.f380041g.put(str, j3);
            }
            if (j3 == null) {
                QLog.e("TRTCMultipeVoiceRoomManager", 4, "enterVoiceRoom\uff01\uff01trtc\u521d\u59cb\u5316\u5931\u8d25:" + str);
                return;
            }
            TRTCCloud n3 = j3.n();
            TRTCCloudDef.TRTCParams t16 = t(aVar, str2, str);
            n3.enableAudioVolumeEvaluation(300);
            n3.enterRoom(t16, 1);
            n3.muteLocalAudio(true);
            x(str);
            A();
            return;
        }
        QLog.e("TRTCMultipeVoiceRoomManager", 4, "enterVoiceRoom\uff01\uff01\u5df2\u7ecf\u5728\u623f\u95f4\u5185:" + str);
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public synchronized void b(String str) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "muteMicForVoiceRoom:" + str);
        if (!r()) {
            return;
        }
        e j3 = j(str);
        if (j3 != null) {
            j3.n().muteLocalAudio(true);
            j3.r(true);
            s();
            A();
            this.f380047m.clear();
            if (this.f380047m.size() > 0) {
                String str2 = this.f380047m.get(0);
                String str3 = this.f380045k.get(str2);
                QLog.i("TRTCMultipeVoiceRoomManager", 4, "muteMicForVoiceRoom " + str + ", resume closed room first = " + str2 + " - " + str3);
                this.f380047m.clear();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u5df2\u4e3a\u4f60\u81ea\u52a8\u6062\u590d");
                sb5.append(str3);
                sb5.append("\u9ea6\u514b\u98ce");
                com.tencent.timi.game.ui.widget.f.c(sb5.toString());
                c cVar = this.f380046l.get(str2);
                if (cVar != null) {
                    cVar.a(str2, true);
                } else {
                    h(str2);
                }
            }
        } else {
            QLog.e("TRTCMultipeVoiceRoomManager", 4, "muteMicForVoiceRoom:" + str + "Not Found!");
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public synchronized void c(String str) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "openSpeakerForVoiceRoom:" + str);
        if (!r()) {
            return;
        }
        e j3 = j(str);
        if (j3 != null) {
            ArrayList arrayList = new ArrayList();
            for (e eVar : this.f380041g.values()) {
                if (!eVar.p() && !eVar.i().equals(str)) {
                    k(eVar.i());
                    b(eVar.i());
                    arrayList.add(eVar.i());
                    c cVar = this.f380046l.get(eVar.i());
                    if (cVar != null) {
                        cVar.a(eVar.i(), false);
                    }
                    this.f380047m.add(eVar.i());
                }
            }
            if (arrayList.size() > 0) {
                String str2 = (String) arrayList.get(0);
                String str3 = this.f380045k.get(str);
                String str4 = this.f380045k.get(str2);
                QLog.i("TRTCMultipeVoiceRoomManager", 4, "openSpeakerForVoiceRoom " + str + " - " + str3 + ", closed room first = " + str2 + " - " + str4);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u5df2\u5207\u6362\u4e3a");
                sb5.append(str3);
                sb5.append("\u8bed\u97f3\uff0c");
                sb5.append(str4);
                sb5.append("\u58f0\u97f3\u5df2\u5173\u95ed");
                com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            }
            j3.n().muteAllRemoteAudio(false);
            j3.u(false);
            A();
        } else {
            QLog.e("TRTCMultipeVoiceRoomManager", 4, "openSpeakerForVoiceRoom:" + str + "Not Found!");
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.d
    public void d(String str, TRTCCloudListener tRTCCloudListener) {
        e j3;
        if (r() && (j3 = j(str)) != null) {
            j3.q(tRTCCloudListener);
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public boolean e(String str) {
        e j3;
        if (!r() || (j3 = j(str)) == null || j3.o()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.d
    public void f(String str, TRTCCloudListener tRTCCloudListener) {
        e j3;
        if (r() && (j3 = j(str)) != null) {
            j3.w(tRTCCloudListener);
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public synchronized void g(String str, int i3) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "setVoiceRoomVolume:" + str + " volume:" + i3);
        if (!r()) {
            return;
        }
        e j3 = j(str);
        if (j3 != null && i3 >= 0 && i3 <= 100) {
            j3.v(i3);
            A();
        } else {
            QLog.e("TRTCMultipeVoiceRoomManager", 4, "setVoiceRoomVolume:" + str + "Not Found!");
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public synchronized void h(String str) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "openMicForVoiceRoom:" + str);
        if (!r()) {
            return;
        }
        e j3 = j(str);
        if (j3 != null) {
            this.f380047m.clear();
            for (e eVar : this.f380041g.values()) {
                if (!eVar.o() && !eVar.i().equals(str)) {
                    b(eVar.i());
                    k(eVar.i());
                    c cVar = this.f380046l.get(eVar.i());
                    if (cVar != null) {
                        cVar.a(eVar.i(), false);
                    }
                    this.f380047m.add(eVar.i());
                }
            }
            if (this.f380047m.size() > 0) {
                String str2 = this.f380047m.get(0);
                String str3 = this.f380045k.get(str);
                String str4 = this.f380045k.get(str2);
                QLog.i("TRTCMultipeVoiceRoomManager", 4, "openMicForVoiceRoom " + str + " - " + str3 + ", closed room first = " + str2 + " - " + str4);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u5df2\u5207\u6362\u4e3a");
                sb5.append(str3);
                sb5.append("\u8bed\u97f3\uff0c");
                sb5.append(str4);
                sb5.append("\u58f0\u97f3\u5df2\u5173\u95ed");
                com.tencent.timi.game.ui.widget.f.c(sb5.toString());
            }
            this.f380038d.startLocalAudio();
            j3.n().muteLocalAudio(false);
            j3.r(false);
            s();
            A();
        } else {
            QLog.e("TRTCMultipeVoiceRoomManager", 4, "openMicForVoiceRoom:" + str + "Not Found!");
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public synchronized void i(String str) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "setOffMicPosition:" + str);
        if (!r()) {
            return;
        }
        e j3 = j(str);
        if (j3 != null) {
            j3.s(false);
            b(str);
            A();
        } else {
            QLog.e("TRTCMultipeVoiceRoomManager", 4, "setOffMicPosition:" + str + "Not Found!");
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public synchronized e j(String str) {
        if (!r()) {
            return null;
        }
        return this.f380041g.get(str);
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public synchronized void k(String str) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "muteSpeakerForVoiceRoom:" + str);
        if (!r()) {
            return;
        }
        e j3 = j(str);
        if (j3 != null) {
            j3.n().muteAllRemoteAudio(true);
            j3.u(true);
            A();
        } else {
            QLog.e("TRTCMultipeVoiceRoomManager", 4, "muteSpeakerForVoiceRoom:" + str + "Not Found!");
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public synchronized void l(String str) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "setOnMicPosition:" + str);
        if (!r()) {
            return;
        }
        e j3 = j(str);
        if (j3 != null) {
            j3.s(true);
            A();
        } else {
            QLog.e("TRTCMultipeVoiceRoomManager", 4, "setOnMicPosition:" + str + "Not Found!");
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public synchronized void m(int i3) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "setMicVolume:" + i3);
        if (!r()) {
            return;
        }
        if (i3 >= 0 && i3 <= 100) {
            this.f380039e = i3;
            this.f380038d.setAudioCaptureVolume(this.f380039e);
            A();
        } else {
            QLog.e("TRTCMultipeVoiceRoomManager", 4, "setMicVolume:" + i3 + " not validate!");
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.d
    public synchronized void n(String str) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "exitVoiceRoom:" + str);
        if (!r()) {
            return;
        }
        this.f380045k.remove(str);
        this.f380046l.remove(str);
        this.f380047m.remove(str);
        e j3 = j(str);
        if (j3 != null) {
            b(str);
            k(str);
            j3.n().exitRoom();
            this.f380038d.destroySubCloud(j3.n());
            s();
            z(str);
            this.f380041g.remove(str);
            A();
            q();
            this.f380044j.clear();
        } else {
            QLog.e("TRTCMultipeVoiceRoomManager", 4, "exitVoiceRoom:" + str + "Not Found!");
        }
    }

    @Override // com.tencent.timi.game.trtc.roomservice.multipevoiceroom.b
    public void o(String str, String str2, boolean z16) {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "muteRemoteAudio:" + str2 + " " + z16);
        e j3 = j(str);
        if (j3 != null) {
            j3.n().muteRemoteAudio(str2, z16);
        }
    }

    public void y(@NonNull String str, @Nullable String str2) {
        View view;
        if (!TextUtils.isEmpty(str2) && (view = this.f380044j.get(str2)) != null) {
            w(str, str2, view);
        }
    }
}
