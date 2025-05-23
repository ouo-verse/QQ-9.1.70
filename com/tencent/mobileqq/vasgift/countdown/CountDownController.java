package com.tencent.mobileqq.vasgift.countdown;

import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vasgift.utils.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CountDownController {

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f311632f = new byte[1];

    /* renamed from: a, reason: collision with root package name */
    private String f311633a;

    /* renamed from: b, reason: collision with root package name */
    private Timer f311634b = null;

    /* renamed from: c, reason: collision with root package name */
    private final a f311635c = new a();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, CountDownInfo> f311636d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final MutableLiveData<a> f311637e = new MutableLiveData<>();

    public CountDownController(String str) {
        this.f311633a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (f311632f) {
            Timer timer = this.f311634b;
            if (timer != null) {
                timer.cancel();
                this.f311634b.purge();
            }
        }
    }

    private boolean i(Object obj) {
        Map.Entry entry;
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).entrySet().iterator();
            if (it.hasNext() && (entry = (Map.Entry) it.next()) != null && (entry.getKey() instanceof String) && (entry.getValue() instanceof CountDownInfo)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void l() {
        long serverTime = NetConnInfoCenter.getServerTime();
        VasMMKVProxy giftPanelCountDown = VasMMKV.getGiftPanelCountDown(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        Iterator<String> it = this.f311636d.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            long decodeLong = giftPanelCountDown.decodeLong("last_send_" + n() + next, 0L);
            CountDownInfo countDownInfo = this.f311636d.get(next);
            long j3 = serverTime - decodeLong;
            QLog.i("CountDownController", 1, "filteredFinishedGift timePassedMills:" + j3 + " lastSendTime:" + decodeLong + " serviceTimeNow:" + serverTime);
            long j16 = countDownInfo.countDownTime;
            if (j3 >= j16) {
                it.remove();
            } else {
                countDownInfo.remainTime = j16 - j3;
            }
        }
        QLog.i("CountDownController", 1, "filteredFinishedGift mCountDownInfoMap:" + this.f311636d);
    }

    private String n() {
        return "key_count_down_gift" + this.f311633a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f311636d.clear();
        this.f311636d.putAll(v("infos_map_" + n()));
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            String a16 = h.a(MobileQQ.sMobileQQ, n());
            this.f311636d.clear();
            if (TextUtils.isEmpty(a16)) {
                QLog.e("CountDownController", 2, "initCountDownMapFromSp countDownGifts is empty");
                return;
            }
            JSONObject jSONObject = new JSONObject(a16);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                long optLong = jSONObject.optLong(str);
                if (optLong > 0) {
                    this.f311636d.put(str, new CountDownInfo(Integer.parseInt(str), 1 + optLong, optLong));
                } else {
                    keys.remove();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("CountDownController", 2, "[initCountDownMapFromSp] " + a16);
            }
        } catch (Exception e16) {
            QLog.e("CountDownController", 1, e16, new Object[0]);
        }
    }

    private byte[] r(@NotNull Map map) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(map);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream2.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e16) {
                        QLog.e("CountDownController", 1, "mapToBytes :" + e16);
                    }
                    return byteArray;
                } catch (IOException e17) {
                    e = e17;
                    objectOutputStream = objectOutputStream2;
                    QLog.e("CountDownController", 1, "mapToBytes :" + e);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e18) {
                            QLog.e("CountDownController", 1, "mapToBytes :" + e18);
                            return new byte[0];
                        }
                    }
                    byteArrayOutputStream.close();
                    return new byte[0];
                } catch (Throwable th5) {
                    th = th5;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e19) {
                            QLog.e("CountDownController", 1, "mapToBytes :" + e19);
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f311636d.size() == 0) {
            h();
            if (QLog.isColorLevel()) {
                QLog.i("CountDownController", 2, "[onTimerUpdate] mCountDownInfoMap is empty");
                return;
            }
            return;
        }
        MutableLiveData<a> o16 = o();
        if (o16 != null) {
            Iterator<CountDownInfo> it = this.f311636d.values().iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                CountDownInfo next = it.next();
                long j3 = next.remainTime;
                if (j3 > 1) {
                    next.remainTime = j3 - 1;
                } else {
                    it.remove();
                    z16 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CountDownController", 2, "[onTimerUpdate] countDownInfo:" + next + ",updateData:" + o16);
                }
            }
            if (z16) {
                z();
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                o16.setValue(this.f311635c);
            } else {
                o16.postValue(this.f311635c);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.ObjectInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map<String, CountDownInfo> v(String str) {
        Throwable th5;
        Object e16;
        ObjectInputStream objectInputStream;
        ?? decodeBytes = VasMMKV.getGiftPanelCountDown(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()).decodeBytes(str, null);
        if (decodeBytes == 0) {
            QLog.i("CountDownController", 1, "readInfoMapFromMMKV mmkv is empty, key:" + n());
            return Collections.emptyMap();
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decodeBytes);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e17) {
                e = e17;
                e16 = e;
                objectInputStream = null;
                QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e16);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return Collections.emptyMap();
            } catch (ClassCastException e18) {
                e = e18;
                e16 = e;
                objectInputStream = null;
                QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e16);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return Collections.emptyMap();
            } catch (ClassNotFoundException e19) {
                e = e19;
                e16 = e;
                objectInputStream = null;
                QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e16);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return Collections.emptyMap();
            } catch (Throwable th6) {
                th5 = th6;
                decodeBytes = 0;
                if (decodeBytes != 0) {
                }
                byteArrayInputStream.close();
                throw th5;
            }
            try {
                Object readObject = objectInputStream.readObject();
                if (i(readObject)) {
                    Map<String, CountDownInfo> map = (Map) readObject;
                    try {
                        objectInputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e26) {
                        QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e26);
                    }
                    return map;
                }
                Map<String, CountDownInfo> emptyMap = Collections.emptyMap();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e27) {
                    QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e27);
                }
                return emptyMap;
            } catch (IOException e28) {
                e16 = e28;
                QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e16);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e29) {
                        QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e29);
                        return Collections.emptyMap();
                    }
                }
                byteArrayInputStream.close();
                return Collections.emptyMap();
            } catch (ClassCastException e36) {
                e16 = e36;
                QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e16);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return Collections.emptyMap();
            } catch (ClassNotFoundException e37) {
                e16 = e37;
                QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e16);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return Collections.emptyMap();
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (decodeBytes != 0) {
                try {
                    decodeBytes.close();
                } catch (IOException e38) {
                    QLog.e("CountDownController", 1, "readInfoMapFromMMKV key:" + n() + e38);
                    throw th5;
                }
            }
            byteArrayInputStream.close();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        synchronized (f311632f) {
            this.f311634b = new BaseTimer();
            s();
            this.f311634b.schedule(new TimerTask() { // from class: com.tencent.mobileqq.vasgift.countdown.CountDownController.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    CountDownController.this.s();
                }
            }, 1000L, 1000L);
        }
    }

    private void y(int i3) {
        long serverTime = NetConnInfoCenter.getServerTime();
        VasMMKVProxy giftPanelCountDown = VasMMKV.getGiftPanelCountDown(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        giftPanelCountDown.encodeBytes("infos_map_" + n(), r(this.f311636d));
        giftPanelCountDown.encodeLong("last_send_" + n() + i3, serverTime);
        QLog.i("CountDownController", 1, "writeCountDownInfo mCountDownInfoMap:" + this.f311636d + " sceneid:" + n() + " time" + serverTime);
    }

    private void z() {
        if (this.f311636d.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, CountDownInfo> entry : this.f311636d.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue().countDownTime);
                    h.c(MobileQQ.sMobileQQ, n(), jSONObject.toString());
                } catch (Exception e16) {
                    QLog.e("CountDownController", 1, e16, new Object[0]);
                }
            }
            return;
        }
        h.b(MobileQQ.sMobileQQ, n());
    }

    @Deprecated
    public void j() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.vasgift.countdown.CountDownController.2
            @Override // java.lang.Runnable
            public void run() {
                CountDownController.this.q();
                CountDownController.this.h();
                if (CountDownController.this.f311636d.size() > 0) {
                    CountDownController.this.x();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CountDownController", 2, "[enterRoom] key:" + CountDownController.this.f311633a + ",mCountDownInfoMapSize:" + CountDownController.this.f311636d.size());
                }
            }
        });
    }

    @Deprecated
    public void k() {
        h();
        if (QLog.isColorLevel()) {
            QLog.i("CountDownController", 2, "[exitRoom] key:" + this.f311633a);
        }
    }

    public Map<String, CountDownInfo> m() {
        return this.f311636d;
    }

    public MutableLiveData<a> o() {
        return this.f311637e;
    }

    public void t() {
        h();
    }

    public void u() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vasgift.countdown.CountDownController.1
            @Override // java.lang.Runnable
            public void run() {
                CountDownController.this.p();
                CountDownController.this.h();
                if (CountDownController.this.f311636d.size() > 0) {
                    CountDownController.this.x();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("CountDownController", 2, "[showPanel] key:" + CountDownController.this.f311633a + ",mCountDownInfoMapSize:" + CountDownController.this.f311636d.size());
                }
            }
        }, 16, null, false);
    }

    public void w(int i3, long j3) {
        this.f311636d.put(String.valueOf(i3), new CountDownInfo(i3, j3 + 1, j3));
        z();
        y(i3);
        h();
        x();
    }
}
