package com.tencent.mobileqq.qqaudio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQAudioUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f262098a;

    /* renamed from: b, reason: collision with root package name */
    @ConfigInject(configPath = "AutoInjectYml/Component/AudioKit/Inject_QQAudioFocusLossProcessor.yml", version = 1)
    public static ArrayList<Class<? extends com.tencent.mobileqq.qqaudio.a>> f262099b;

    /* renamed from: c, reason: collision with root package name */
    private static final ArrayList<com.tencent.mobileqq.qqaudio.a> f262100c;

    /* renamed from: d, reason: collision with root package name */
    private static final b.c f262101d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements b.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.mediafocus.b.c
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 == -2 || i3 == -1) {
                QQAudioUtils.j();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36840);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f262098a = new int[]{8000, 12000, 16000, RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000, 36000, 44100, 48000};
        ArrayList<Class<? extends com.tencent.mobileqq.qqaudio.a>> arrayList = new ArrayList<>();
        f262099b = arrayList;
        arrayList.add(com.tencent.mobileqq.pttview.a.class);
        f262099b.add(s64.a.class);
        f262101d = new a();
        f262100c = new ArrayList<>();
        Iterator<Class<? extends com.tencent.mobileqq.qqaudio.a>> it = f262099b.iterator();
        while (it.hasNext()) {
            try {
                f262100c.add(it.next().newInstance());
            } catch (IllegalAccessException | InstantiationException e16) {
                QLog.e("QQAudioUtils", 1, "initAudioFocusLossProcessor error! ", e16);
            }
        }
    }

    public static int b(byte[] bArr) {
        return (bArr[0] & 255) + ((bArr[1] & 255) << 8);
    }

    public static int c(int i3) {
        return ((i3 * 20) * 2) / 1000;
    }

    public static int d(byte b16) {
        if (b16 >= 0) {
            int[] iArr = f262098a;
            if (b16 < iArr.length) {
                return iArr[b16];
            }
        }
        return 0;
    }

    public static int e(byte b16, InputStream inputStream) throws IOException {
        byte[] bArr = new byte[2];
        int i3 = 0;
        while (inputStream.read(bArr) > 0) {
            int b17 = b(bArr);
            i3 += 20;
            if (b17 > 0) {
                inputStream.skip(b17);
            }
        }
        return i3;
    }

    public static byte f(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[10];
        inputStream.read(bArr, 0, 10);
        if (h(bArr)) {
            return bArr[0];
        }
        return (byte) -1;
    }

    public static byte[] g(int i3, byte[] bArr, int i16) {
        bArr[i16] = (byte) (i3 & 255);
        bArr[i16 + 1] = (byte) ((i3 >> 8) & 255);
        return bArr;
    }

    public static boolean h(byte[] bArr) throws Exception {
        if (bArr != null && bArr.length == 10) {
            String x16 = AudioUtil.x(bArr, 1, 9);
            if (QLog.isColorLevel()) {
                QLog.d("QQAudioUtils", 2, "getSilkFs " + ((int) bArr[0]) + x16);
            }
            if (x16.startsWith("#!SILK_V")) {
                return true;
            }
            QLog.e("QQAudioUtils", 1, "isSilkFileHead: headString = " + x16);
        }
        return false;
    }

    @TargetApi(8)
    public static boolean i(Context context, boolean z16) {
        boolean z17 = false;
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioUtil", 2, "context is null.");
            }
            return false;
        }
        if (!VersionUtils.isrFroyo()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQAudioUtils", 2, "Android 2.1 and below can not stop music");
            }
            return false;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (z16) {
            if (audioManager.requestAudioFocus(null, 3, 2) == 1) {
                z17 = true;
            }
            com.tencent.mobileqq.mediafocus.b.i().l(1, f262101d);
        } else {
            try {
                if (audioManager.abandonAudioFocus(null) == 1) {
                    z17 = true;
                }
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqaudio.QQAudioUtils.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            com.tencent.mobileqq.mediafocus.b.i().d(QQAudioUtils.f262101d);
                        }
                    }
                }, 1000L);
            } catch (NullPointerException e16) {
                QLog.e("QQAudioUtils", 1, "caught npe", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAudioUtils", 2, "pauseMusic bMute=" + z16 + " result=" + z17);
        }
        return z17;
    }

    protected static void j() {
        Iterator<com.tencent.mobileqq.qqaudio.a> it = f262100c.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}
