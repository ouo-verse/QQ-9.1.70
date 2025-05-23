package ar2;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f26807b = new a();

    /* renamed from: c, reason: collision with root package name */
    private static String f26808c;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0065a f26809a;

    /* compiled from: P */
    /* renamed from: ar2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0065a {
        void a(int i3, String str, boolean z16);

        void b(int i3, String str, boolean z16);
    }

    a() {
        f26808c = getClass().getSimpleName();
    }

    public static a a() {
        return f26807b;
    }

    private void c(boolean z16, int i3, String str, boolean z17) {
        InterfaceC0065a interfaceC0065a = this.f26809a;
        if (interfaceC0065a != null) {
            if (z16) {
                interfaceC0065a.a(i3, str, z17);
            } else {
                interfaceC0065a.b(i3, str, z17);
            }
        }
    }

    public boolean b(Object obj, int i3, String str) {
        if (!(obj instanceof AudioCapture) || i3 != 3) {
            return true;
        }
        c(true, 2001, HardCodeUtil.qqStr(R.string.m_w) + "2001\uff09", true);
        return false;
    }

    public void d() {
        this.f26809a = null;
    }

    public void e(InterfaceC0065a interfaceC0065a) {
        this.f26809a = interfaceC0065a;
    }
}
