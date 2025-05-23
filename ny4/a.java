package ny4;

import android.media.AudioManager;
import com.tencent.component.utils.LogUtil;
import com.tme.karaoke.lib_earback.base.b;
import com.tme.karaoke.lib_earback.e;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a implements e {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f421598c = {"GM1910", "GM1911", "GM1913", "GM1917", "GM1900", "GM1901", "GM1903"};

    /* renamed from: a, reason: collision with root package name */
    private AudioManager f421599a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f421600b;

    public a() {
        try {
            this.f421599a = (AudioManager) b.a().getApplicationContext().getSystemService("audio");
        } catch (Exception e16) {
            LogUtil.e("OnePlusFeedback", e16.getMessage());
            e16.printStackTrace();
        }
    }

    public void a() {
        this.f421599a.setParameters("loopback_switch=off");
    }

    public boolean b() {
        return this.f421600b;
    }

    public void c() {
        this.f421599a.setParameters("loopback_switch=on");
    }

    @Override // com.tme.karaoke.lib_earback.e
    public boolean turnFeedback(boolean z16) {
        LogUtil.i("OnePlusFeedback", "turnFeedback: able=" + z16);
        this.f421600b = z16;
        if (z16) {
            c();
        } else {
            a();
        }
        return b();
    }
}
