package com.tencent.luggage.wxa.nm;

import android.media.AudioManager;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static final String f135882d = "MicroMsg.Music.MusicAudioFocusHelper";

    /* renamed from: e, reason: collision with root package name */
    public static final int f135883e = 3;

    /* renamed from: f, reason: collision with root package name */
    private static int f135884f = 3;

    /* renamed from: a, reason: collision with root package name */
    private final c f135885a = c.a(new c.a() { // from class: com.tencent.luggage.wxa.nm.b
        @Override // com.tencent.luggage.wxa.so.c.a
        public final Object a() {
            AudioManager c16;
            c16 = a.c();
            return c16;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private boolean f135886b = false;

    /* renamed from: c, reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f135887c = new C6519a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.nm.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6519a implements AudioManager.OnAudioFocusChangeListener {
        public C6519a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            w.d(a.f135882d, "focus change %d", Integer.valueOf(i3));
            if (i3 != -2 && i3 != -3) {
                if (i3 != 1 && i3 != 2 && i3 != 3) {
                    if (i3 == -1) {
                        w.d(a.f135882d, "audio focus loss, passive pause");
                        if (a.this.f135885a.b() != null) {
                            ((AudioManager) a.this.f135885a.b()).abandonAudioFocus(a.this.f135887c);
                        }
                        a.this.f135886b = false;
                        return;
                    }
                    return;
                }
                w.d(a.f135882d, "audio focus gain");
                return;
            }
            w.d(a.f135882d, "audio focus lossTransient");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AudioManager c() {
        return (AudioManager) z.c().getSystemService("audio");
    }

    public boolean d() {
        boolean z16;
        if (this.f135885a.b() == null) {
            return false;
        }
        int requestAudioFocus = ((AudioManager) this.f135885a.b()).requestAudioFocus(this.f135887c, f135884f, 2);
        Object[] objArr = new Object[2];
        if (requestAudioFocus == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        objArr[1] = Integer.valueOf(f135884f);
        w.d(f135882d, "request audio focus %b %d", objArr);
        if (requestAudioFocus == 1) {
            this.f135886b = true;
        }
        if (requestAudioFocus != 1) {
            return false;
        }
        return true;
    }

    public boolean b() {
        return this.f135886b;
    }

    public static void a(int i3) {
        f135884f = i3;
    }

    public void a() {
        w.d(f135882d, "abandonFocus");
        if (this.f135885a.b() == null) {
            return;
        }
        ((AudioManager) this.f135885a.b()).abandonAudioFocus(this.f135887c);
        this.f135886b = false;
    }
}
