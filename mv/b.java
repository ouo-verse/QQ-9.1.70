package mv;

import com.tencent.av.config.api.IConfigParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f417646a;

    /* renamed from: b, reason: collision with root package name */
    public int f417647b;

    /* renamed from: c, reason: collision with root package name */
    public int f417648c;

    /* renamed from: d, reason: collision with root package name */
    public String f417649d;

    public static b a() {
        IConfigParser b16 = du.a.b(BaseApplication.getContext());
        if (!b16.isEmpty()) {
            b bVar = new b();
            bVar.b(b16);
            return bVar;
        }
        return null;
    }

    public boolean b(IConfigParser iConfigParser) {
        try {
            this.f417646a = iConfigParser.getIntValue("OpenGLBlowUp/IsOpen", 0);
            this.f417647b = iConfigParser.getIntValue("OpenGLBlowUp/width", 0);
            this.f417648c = iConfigParser.getIntValue("OpenGLBlowUp/level", 0);
            this.f417649d = iConfigParser.getStringValue("OpenGLBlowUp/versionname", "");
            if (QLog.isColorLevel()) {
                QLog.i("RendererConfig", 2, "OpenGLSharpenConfig isOpen: " + this.f417646a + " width: " + this.f417647b + " level: " + this.f417648c + " versionName: " + this.f417649d);
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
