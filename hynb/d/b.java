package hynb.d;

import android.text.TextUtils;
import com.huya.huyasdk.api.HuyaLiveJoinCallback;
import com.huya.huyasdk.api.HuyaLiveJoinConfig;
import com.huya.huyasdk.api.HuyaLiveJoinResult;
import com.huya.huyasdk.api.LiveRoomEventCallback;
import com.huya.huyasdk.data.RegisterResultInfo;
import com.huya.huyasdk.service.api.ILiveRoomEventService;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import hynb.b.g;
import hynb.b.i;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b extends hynb.j.b implements ILiveRoomEventService {

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f406692a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HuyaLiveJoinCallback f406693a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f406694b;

        public a(HuyaLiveJoinCallback huyaLiveJoinCallback, long j3) {
            this.f406693a = huyaLiveJoinCallback;
            this.f406694b = j3;
        }

        @Override // hynb.b.g
        public void a(RegisterResultInfo registerResultInfo) {
            hynb.p.g.f406799a.a("HuyaLiveRoomEventService", "joinLive onRegisterGroupSuccess: " + registerResultInfo);
            if (registerResultInfo != null && registerResultInfo.getGroupId().startsWith("open_live:")) {
                hynb.d.a.a();
                HuyaLiveJoinCallback huyaLiveJoinCallback = this.f406693a;
                if (huyaLiveJoinCallback != null) {
                    huyaLiveJoinCallback.onJoinResult(new HuyaLiveJoinResult(this.f406694b, true, 0));
                }
                hynb.d.a.f406690d = true;
            }
        }

        @Override // hynb.b.g
        public void b(RegisterResultInfo registerResultInfo) {
            if (registerResultInfo == null) {
                return;
            }
            hynb.p.g.f406799a.a("HuyaLiveRoomEventService", "joinLive onRegisterFailed: " + registerResultInfo);
            b.this.f406692a.remove(registerResultInfo.getGroupId());
            if (registerResultInfo.getGroupId().startsWith("open_live:")) {
                hynb.d.a.f406690d = false;
                hynb.d.a.f406689c = 0L;
                HuyaLiveJoinCallback huyaLiveJoinCallback = this.f406693a;
                if (huyaLiveJoinCallback != null) {
                    huyaLiveJoinCallback.onJoinResult(new HuyaLiveJoinResult(this.f406694b, false, registerResultInfo.getStatus()));
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: hynb.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class C10482b implements i {
        public C10482b(b bVar) {
        }

        @Override // hynb.b.i
        public void a(RegisterResultInfo registerResultInfo) {
            hynb.p.g.f406799a.a("HuyaLiveRoomEventService", "quitLive, onUnRegisterGroupSuccess() called with: registerResultInfo = [" + registerResultInfo + "]");
        }

        @Override // hynb.b.i
        public void b(RegisterResultInfo registerResultInfo) {
            hynb.p.g.f406799a.a("HuyaLiveRoomEventService", "quitLive, onUnRegisterGroupFailed() called with: registerResultInfo = [" + registerResultInfo + "]");
        }
    }

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public synchronized void enterLiveRoom(HuyaLiveJoinConfig huyaLiveJoinConfig, HuyaLiveJoinCallback huyaLiveJoinCallback) {
        String trim;
        String str;
        if (huyaLiveJoinConfig.presenterUid == hynb.d.a.f406689c) {
            hynb.p.g.f406799a.a("HuyaLiveRoomEventService", "joinLive: " + huyaLiveJoinConfig.presenterUid + ", already joined");
            return;
        }
        quitLiveRoom();
        long j3 = huyaLiveJoinConfig.presenterUid;
        String str2 = huyaLiveJoinConfig.password;
        if (str2 == null) {
            trim = "";
        } else {
            trim = str2.trim();
        }
        if (!TextUtils.isEmpty(trim)) {
            str = a("HUYA" + huyaLiveJoinConfig.password + "LIVE").toLowerCase(Locale.ROOT);
        } else {
            str = null;
        }
        hynb.d.a.f406689c = j3;
        hynb.p.g.f406799a.a("HuyaLiveRoomEventService", "joinLive: " + j3 + ", pwd: " + str);
        this.f406692a.clear();
        this.f406692a.addAll(a(j3));
        hynb.g.b.f406712m.a("HuyaLiveRoomEventService", this.f406692a, new a(huyaLiveJoinCallback, j3));
    }

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public long getCurrentPid() {
        return hynb.d.a.f406689c;
    }

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public boolean inLiveRoom() {
        return hynb.d.a.f406690d;
    }

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public synchronized long quitLiveRoom() {
        long j3;
        j3 = 0;
        if (!this.f406692a.isEmpty()) {
            hynb.p.g.f406799a.a("HuyaLiveRoomEventService", "quitLive: presenterId: " + hynb.d.a.f406689c);
            long j16 = hynb.d.a.f406689c;
            hynb.d.a.b();
            hynb.d.a.f406689c = 0L;
            hynb.d.a.f406690d = false;
            hynb.g.b.f406712m.a("HuyaLiveRoomEventService", this.f406692a, new C10482b(this));
            this.f406692a.clear();
            j3 = j16;
        }
        return j3;
    }

    @Override // com.huya.huyasdk.service.api.ILiveRoomEventService
    public void registerLiveEvent(LiveRoomEventCallback liveRoomEventCallback) {
        hynb.d.a.a(liveRoomEventCallback);
    }

    public final String a(String str) {
        StringBuilder sb5 = new StringBuilder();
        try {
            sb5.append(a(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e16) {
            hynb.p.g.f406799a.a("HuyaLiveRoomEventService", e16);
        }
        return sb5.toString();
    }

    public final String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        if (bArr != null) {
            for (byte b16 : bArr) {
                sb5.append(Integer.toString((b16 & 255) + 256).substring(1));
            }
        }
        return sb5.toString();
    }

    public static List<String> a(long j3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("open_live:" + j3);
        return arrayList;
    }
}
