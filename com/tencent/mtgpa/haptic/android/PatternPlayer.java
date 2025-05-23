package com.tencent.mtgpa.haptic.android;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes21.dex */
public class PatternPlayer extends com.tencent.mtgpa.haptic.base.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f336877a;

    /* renamed from: b, reason: collision with root package name */
    private Vibrator f336878b;

    /* renamed from: c, reason: collision with root package name */
    private PatternPlayThread f336879c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class PatternPlayThread extends BaseThread {
        static IPatchRedirector $redirector_;
        final Object C;
        final Object D;
        boolean E;
        List<a> F;

        PatternPlayThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PatternPlayer.this);
                return;
            }
            this.C = new Object();
            this.D = new Object();
            this.E = false;
            this.F = new ArrayList();
        }

        long o() {
            return SystemClock.elapsedRealtime();
        }

        boolean p() {
            synchronized (this.D) {
                Iterator<a> it = this.F.iterator();
                while (it.hasNext()) {
                    if (it.next().f336886g) {
                        return true;
                    }
                }
                return false;
            }
        }

        public void q(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            synchronized (this.C) {
                aVar.g(aVar.c() + PatternPlayer.e(aVar.e()));
                aVar.f336885f = 0L;
                synchronized (this.D) {
                    if (this.F.size() > 0) {
                        if (PatternPlayer.this.f336877a) {
                            Log.d("PatternPlayer", "vibrating , interrupt it.");
                        }
                        this.F.get(0).f336886g = false;
                    }
                    this.F.add(0, aVar);
                }
                try {
                    this.C.notify();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        public void r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            synchronized (this.C) {
                try {
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                synchronized (this.D) {
                    if (this.F.isEmpty()) {
                        return;
                    }
                    a aVar = this.F.get(0);
                    if (aVar.f336886g) {
                        aVar.f336886g = false;
                    }
                    this.C.notify();
                }
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            Log.i("PatternPlayer", "thread start!");
            while (!this.E) {
                if (!this.F.isEmpty() && p()) {
                    long o16 = o();
                    a aVar = this.F.get(0);
                    if (aVar.f336886g) {
                        long j3 = aVar.f336885f;
                        if (j3 <= o16) {
                            PatternPlayer.this.g(aVar.e(), aVar.d(), aVar.c(), aVar.a(), aVar.b());
                            aVar.f336888i++;
                            if (PatternPlayer.this.f336877a) {
                                Log.d("PatternPlayer", "already vib num: " + aVar.f336888i);
                            }
                            if (aVar.f336888i >= aVar.d()) {
                                if (PatternPlayer.this.f336877a) {
                                    str = "PatternPlayer";
                                    str2 = "wake up vib looper is end, remove it!";
                                    Log.d(str, str2);
                                }
                                aVar.f336886g = false;
                            } else {
                                aVar.f336885f = o() + aVar.f();
                                if (PatternPlayer.this.f336877a) {
                                    Log.d("PatternPlayer", "vib now: " + o() + " when: " + aVar.f336885f + " lastTime: " + aVar.f());
                                }
                            }
                        } else {
                            long j16 = j3 - o16;
                            synchronized (this.C) {
                                try {
                                    if (PatternPlayer.this.f336877a) {
                                        Log.d("PatternPlayer", "go to sleep :" + j16);
                                    }
                                    this.C.wait(j16);
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                            }
                            if (aVar.f336888i > aVar.d()) {
                                if (PatternPlayer.this.f336877a) {
                                    str = "PatternPlayer";
                                    str2 = "looper finished, remove it!";
                                    Log.d(str, str2);
                                }
                                aVar.f336886g = false;
                            }
                        }
                    }
                } else {
                    synchronized (this.C) {
                        try {
                            synchronized (this.D) {
                                this.F.clear();
                            }
                            if (PatternPlayer.this.f336877a) {
                                Log.d("PatternPlayer", "nothing is in loop list, just wait!");
                            }
                            LockMethodProxy.wait(this.C);
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                    }
                }
            }
            Log.i("PatternPlayer", "thread quit!");
        }
    }

    public PatternPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f336877a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b4, code lost:
    
        android.util.Log.e("PatternPlayer", "can't get Event Type value, please check he format.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(String str) {
        int i3;
        int f16;
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("Pattern");
            int min = Math.min(jSONArray.length(), 16);
            int i16 = min * 2;
            long[] jArr = new long[i16];
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                if (i17 >= min) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i17).getJSONObject("Event");
                String string = jSONObject.getString("Type");
                if (TextUtils.equals("continuous", string)) {
                    int i26 = i17 * 2;
                    long j3 = (jSONObject.getInt("RelativeTime") - i18) - i19;
                    jArr[i26] = j3;
                    if (j3 < 0) {
                        jArr[i26] = 50;
                    }
                    f16 = jSONObject.getInt("Duration");
                    if (f16 > 50 && f16 < 100) {
                        f16 = 50;
                    } else if (f16 > 100) {
                        f16 -= 50;
                    }
                    jArr[i26 + 1] = f16;
                } else {
                    if (!TextUtils.equals("transient", string)) {
                        break;
                    }
                    int i27 = i17 * 2;
                    long j16 = (jSONObject.getInt("RelativeTime") - i18) - i19;
                    jArr[i27] = j16;
                    if (j16 < 0) {
                        jArr[i27] = 50;
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("Parameters");
                    f16 = f(jSONObject2.getInt("Intensity"), jSONObject2.getInt("Frequency"));
                    jArr[i27 + 1] = f16;
                }
                i19 = f16;
                i18 = jSONObject.getInt("RelativeTime");
                i17++;
            }
            i3 = 0;
            for (int i28 = 0; i28 < i16; i28++) {
                try {
                    i3 = (int) (i3 + jArr[i28]);
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    return i3;
                }
            }
            if (i3 > 30000) {
                Log.e("PatternPlayer", "Pattern's duration should be less than 30000");
                return 0;
            }
            return i3;
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
    }

    private static int f(int i3, int i16) {
        if (i16 >= 41 && i16 <= 68) {
            if (i3 > 0 && i3 < 50) {
                return 15;
            }
            if (i3 >= 50 && i3 < 75) {
                return 20;
            }
            if (i3 >= 75 && i3 <= 100) {
                return 30;
            }
            return 0;
        }
        if (i3 > 0 && i3 < 50) {
            return 10;
        }
        if (i3 >= 50 && i3 <= 100) {
            return 15;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0158, code lost:
    
        r5 = 0;
        android.util.Log.e("PatternPlayer", "can't get Event Type value, please check he format.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(String str, int i3, int i16, int i17, int i18) {
        int i19;
        long[] jArr;
        int i26;
        VibrationEffect createWaveform;
        String str2;
        int i27;
        if (this.f336878b == null) {
            Log.e("PatternPlayer", "Please prepare before invoke play method.");
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("Pattern");
            int min = Math.min(jSONArray.length(), 16);
            int i28 = min * 2;
            long[] jArr2 = new long[i28];
            int[] iArr = new int[i28];
            int i29 = 0;
            Arrays.fill(iArr, 0);
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            while (true) {
                if (i36 < min) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i36).getJSONObject("Event");
                        String string = jSONObject.getString("Type");
                        JSONArray jSONArray2 = jSONArray;
                        int i39 = min;
                        i19 = i28;
                        if (TextUtils.equals("continuous", string)) {
                            int i46 = i36 * 2;
                            long j3 = (jSONObject.getInt("RelativeTime") - i37) - i38;
                            jArr2[i46] = j3;
                            if (j3 < 0) {
                                jArr2[i46] = 50;
                            }
                            iArr[i46] = 0;
                            int i47 = jSONObject.getInt("Duration");
                            if (i47 > 50 && i47 < 100) {
                                i47 = 50;
                            } else if (i47 > 100) {
                                i47 -= 50;
                            }
                            int i48 = i46 + 1;
                            jArr2[i48] = i47;
                            JSONObject jSONObject2 = jSONObject.getJSONObject("Parameters");
                            JSONArray jSONArray3 = jSONObject2.getJSONArray("Curve");
                            jArr = jArr2;
                            int min2 = Math.min((int) (jSONArray3.getJSONObject(1).getDouble("Intensity") * 255.0d), 255);
                            double d16 = jSONArray3.getJSONObject(2).getDouble("Intensity");
                            int i49 = i47;
                            int max = Math.max(min2, Math.min((int) (d16 * 255.0d), 255));
                            int i56 = jSONObject2.getInt("Intensity");
                            int i57 = jSONObject2.getInt("Frequency");
                            int max2 = Math.max(1, (int) (((max * (i56 / 100.0d)) * i17) / 255.0d));
                            if (i57 < 30) {
                                max2 = 0;
                            }
                            iArr[i48] = max2;
                            i38 = i49;
                            str2 = "RelativeTime";
                            i27 = 0;
                        } else {
                            jArr = jArr2;
                            if (!TextUtils.equals("transient", string)) {
                                break;
                            }
                            int i58 = i36 * 2;
                            str2 = "RelativeTime";
                            long j16 = (jSONObject.getInt(str2) - i37) - i38;
                            jArr[i58] = j16;
                            if (j16 < 0) {
                                jArr[i58] = 50;
                            }
                            i27 = 0;
                            iArr[i58] = 0;
                            JSONObject jSONObject3 = jSONObject.getJSONObject("Parameters");
                            int i59 = jSONObject3.getInt("Intensity");
                            int f16 = f(i59, jSONObject3.getInt("Frequency"));
                            int i65 = i58 + 1;
                            jArr[i65] = f16;
                            iArr[i65] = Math.max(1, Math.min((int) (((i17 * 1.0d) * i59) / 100.0d), 255));
                            i38 = f16;
                        }
                        i37 = jSONObject.getInt(str2);
                        i36++;
                        jSONArray = jSONArray2;
                        i29 = i27;
                        min = i39;
                        i28 = i19;
                        jArr2 = jArr;
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        return;
                    }
                } else {
                    i19 = i28;
                    jArr = jArr2;
                    i26 = i29;
                    break;
                }
            }
            if (this.f336877a) {
                Log.d("PatternPlayer", "timings:" + Arrays.toString(jArr));
            }
            int i66 = i19;
            for (int i67 = i26; i67 < i66; i67++) {
                i26 = (int) (i26 + jArr[i67]);
            }
            if (i26 > 30000) {
                Log.e("PatternPlayer", "Pattern's duration should be less than 30000");
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Vibrator vibrator = this.f336878b;
                createWaveform = VibrationEffect.createWaveform(jArr, iArr, -1);
                vibrator.vibrate(createWaveform);
            } else {
                this.f336878b.vibrate(jArr, -1);
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // com.tencent.mtgpa.haptic.base.a
    public void a(String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            h();
            this.f336879c.q(new a(str, i3, i16, i17, i18));
        }
    }

    @Override // com.tencent.mtgpa.haptic.base.a
    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        this.f336878b = (Vibrator) context.getSystemService("vibrator");
        PatternPlayThread patternPlayThread = new PatternPlayThread();
        this.f336879c = patternPlayThread;
        patternPlayThread.start();
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        PatternPlayThread patternPlayThread = this.f336879c;
        if (patternPlayThread != null) {
            patternPlayThread.r();
        }
        Vibrator vibrator = this.f336878b;
        if (vibrator != null) {
            vibrator.cancel();
        }
    }
}
