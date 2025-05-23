package com.tencent.mobileqq.ar.ARPromotion;

import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes11.dex */
public class ARPromotionSoundPlayer implements SoundPool.OnLoadCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    private SoundPool f196820a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f196821b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f196822c = false;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, a> f196823d = new HashMap(10);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f196824a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f196825b;

        /* renamed from: c, reason: collision with root package name */
        public int f196826c;

        public a(int i3, int i16) {
            this.f196825b = i3;
            this.f196826c = i16;
        }

        public boolean a() {
            if (this.f196826c == 2) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (this.f196826c == 1) {
                return true;
            }
            return false;
        }

        public boolean c() {
            if (this.f196826c == 3) {
                return true;
            }
            return false;
        }
    }

    public ARPromotionSoundPlayer() {
        SoundPool soundPool = new SoundPool(10, 3, 0);
        this.f196820a = soundPool;
        soundPool.setOnLoadCompleteListener(this);
    }

    private void e() {
        try {
            Iterator<Map.Entry<String, a>> it = this.f196823d.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && value.c()) {
                    this.f196820a.pause(value.f196824a);
                    value.f196826c = 2;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("ARPromotionSoundPlayer", 2, "stopSound exception", e16);
            }
        }
    }

    public void c(String str, boolean z16) {
        int i3;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("ARPromotionSoundPlayer", 2, "playSound resPath: " + str);
        }
        this.f196822c = false;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("ARPromotionSoundPlayer", 2, "playSound resPath is empty!");
                return;
            }
            return;
        }
        if (!new File(str).exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("ARPromotionSoundPlayer", 2, "playSound file not exist");
                return;
            }
            return;
        }
        if (!this.f196822c) {
            if (this.f196823d.containsKey(str)) {
                e();
                a aVar = this.f196823d.get(str);
                if (aVar != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ARPromotionSoundPlayer", 2, "playSound contains resPath, state: " + aVar.f196826c);
                    }
                    if (!this.f196821b) {
                        if (aVar.a()) {
                            SoundPool soundPool = this.f196820a;
                            int i17 = aVar.f196825b;
                            if (z16) {
                                i16 = -1;
                            } else {
                                i16 = 0;
                            }
                            aVar.f196824a = soundPool.play(i17, 1.0f, 1.0f, 0, i16, 1.0f);
                        } else if (aVar.c()) {
                            SoundPool soundPool2 = this.f196820a;
                            int i18 = aVar.f196825b;
                            if (z16) {
                                i3 = -1;
                            } else {
                                i3 = 0;
                            }
                            aVar.f196824a = soundPool2.play(i18, 1.0f, 1.0f, 0, i3, 1.0f);
                        }
                        aVar.f196826c = 3;
                        return;
                    }
                    aVar.f196826c = 4;
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ARPromotionSoundPlayer", 2, "playSound not contains resPath, load");
            }
            this.f196823d.put(str, new a(this.f196820a.load(str, 1), 3));
        }
    }

    public void d() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = ARPromotionSoundPlayer.this.f196823d.entrySet().iterator();
                    while (it.hasNext()) {
                        a aVar = (a) ((Map.Entry) it.next()).getValue();
                        if (aVar != null) {
                            ARPromotionSoundPlayer.this.f196820a.stop(aVar.f196824a);
                        }
                    }
                    ARPromotionSoundPlayer.this.f196820a.release();
                    ARPromotionSoundPlayer.this.f196823d.clear();
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("ARPromotionSoundPlayer", 2, "release exception", e16);
                    }
                }
            }
        }, 8, null, true);
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("ARPromotionSoundPlayer", 2, "onLoadComplete sampleId:" + i3 + ", status:" + i16);
        }
        if (i16 == 0) {
            try {
                Iterator<Map.Entry<String, a>> it = this.f196823d.entrySet().iterator();
                while (it.hasNext()) {
                    a value = it.next().getValue();
                    if (value != null && value.f196825b == i3) {
                        if (value.b()) {
                            value.f196826c = 2;
                        } else if (value.c()) {
                            if (!this.f196821b) {
                                value.f196824a = soundPool.play(i3, 1.0f, 1.0f, 0, 0, 1.0f);
                            } else {
                                value.f196826c = 4;
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("ARPromotionSoundPlayer", 2, "onLoadComplete exception", e16);
                }
            }
        }
    }
}
