package com.tencent.mobileqq.magicface.service;

import android.media.SoundPool;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.TimerTask;

/* loaded from: classes15.dex */
public class SoundPoolUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected SoundPool f243501a;

    /* renamed from: b, reason: collision with root package name */
    protected HashMap<String, Integer> f243502b;

    /* renamed from: com.tencent.mobileqq.magicface.service.SoundPoolUtil$2, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass2 extends TimerTask {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f243503d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f243504e;
        final /* synthetic */ SoundPoolUtil this$0;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            SoundPool soundPool = this.this$0.f243501a;
            if (soundPool != null && soundPool.play(this.f243503d, 1.0f, 1.0f, 0, 0, 1.0f) == 0 && QLog.isColorLevel()) {
                QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.f243504e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a implements SoundPool.OnLoadCompleteListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f243505a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f243506b;

        a(int i3, String str) {
            this.f243505a = i3;
            this.f243506b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SoundPoolUtil.this, Integer.valueOf(i3), str);
            }
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, soundPool, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (SoundPoolUtil.this.f243501a.play(i3, 1.0f, 1.0f, 0, this.f243505a, 1.0f) == 0 && QLog.isColorLevel()) {
                QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.f243506b);
            }
        }
    }

    public SoundPoolUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean a(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QQAudioUtils.i(BaseApplication.getContext(), true);
        if (this.f243501a == null) {
            this.f243501a = new SoundPool(1, i16, 0);
        }
        if (this.f243502b == null) {
            this.f243502b = new HashMap<>();
        }
        if (!this.f243502b.containsKey(str)) {
            if (!b(str)) {
                return false;
            }
            this.f243501a.setOnLoadCompleteListener(new a(i3, str));
        } else if (this.f243501a.play(this.f243502b.get(str).intValue(), 1.0f, 1.0f, 0, 0, 1.0f) == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SoundPoolUtil", 2, "play failure filepath=" + str);
            }
            return false;
        }
        return true;
    }

    public boolean b(String str) {
        HashMap<String, Integer> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || ((hashMap = this.f243502b) != null && hashMap.containsKey(str))) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (this.f243501a == null) {
            this.f243501a = new SoundPool(1, 3, 0);
        }
        if (this.f243502b == null) {
            this.f243502b = new HashMap<>();
        }
        this.f243501a.setOnLoadCompleteListener(null);
        int load = this.f243501a.load(file.getAbsolutePath(), 1);
        if (load == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SoundPoolUtil", 2, "load failure filepath=" + str);
            }
            return false;
        }
        this.f243502b.put(str, Integer.valueOf(load));
        return true;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.f243501a != null) {
            QQAudioUtils.i(BaseApplication.getContext(), false);
            this.f243501a.release();
        }
    }

    public void d(String str) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        HashMap<String, Integer> hashMap = this.f243502b;
        if (hashMap != null && (num = hashMap.get(str)) != null) {
            QQAudioUtils.i(BaseApplication.getContext(), false);
            this.f243501a.stop(num.intValue());
            this.f243502b.remove(str);
        }
    }
}
