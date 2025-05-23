package com.tencent.mobileqq.qzoneplayer.player;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.player.IExo2MediaPlayer;
import com.tencent.oskplayer.util.PlayerUtils;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f279455b = false;

    /* renamed from: c, reason: collision with root package name */
    private static a f279456c = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f279457d = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f279458a = false;

    a() {
    }

    private void a() {
        if (this.f279458a) {
            return;
        }
        try {
            IPatchRedirector iPatchRedirector = Exo2MediaPlayer.$redirector_;
            this.f279458a = true;
        } catch (ClassNotFoundException unused) {
            PlayerUtils.log(4, "Exo2MediaPlayerUtil", "exoplayer2 disabled");
        }
    }

    public static a c() {
        if (f279456c == null) {
            synchronized (a.class) {
                if (f279456c == null) {
                    f279456c = new a();
                }
            }
        }
        return f279456c;
    }

    private PlayerSupportStatus e() {
        a();
        if (!this.f279458a) {
            return PlayerSupportStatus.UNSUPPORT_CLASS_NOTFOUND;
        }
        return PlayerSupportStatus.SUPPORTED;
    }

    private static void g() {
        if (f279457d) {
            return;
        }
        String qLoadControlConfig = PlayerConfig.g().getQLoadControlConfig();
        PlayerUtils.log(4, "Exo2MediaPlayerUtil", "updateQLoadControlConfig " + qLoadControlConfig);
        try {
            Method declaredMethod = Class.forName("com.google.android.exoplayer2.ext.mediaplayer.QLoadControl").getDeclaredMethod("updateConfig", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, qLoadControlConfig);
            f279457d = true;
        } catch (Exception e16) {
            PlayerUtils.log(6, "Exo2MediaPlayerUtil", "failed updateQLoadControlConfig " + e16);
        }
    }

    public IExo2MediaPlayer b(Context context) {
        g();
        try {
            IPatchRedirector iPatchRedirector = Exo2MediaPlayer.$redirector_;
            return (IExo2MediaPlayer) Exo2MediaPlayer.class.getConstructor(Context.class).newInstance(context);
        } catch (Exception e16) {
            PlayerUtils.log(6, "Exo2MediaPlayerUtil", "failed create exo2mediaplayer " + e16);
            return null;
        }
    }

    public PlayerSupportStatus d() {
        if (f279455b) {
            return PlayerSupportStatus.UNSUPPORT_DISABLED;
        }
        return e();
    }

    public void f(boolean z16) {
        PlayerUtils.log(5, "Exo2MediaPlayerUtil", "setDisabled " + z16);
        f279455b = z16;
    }
}
