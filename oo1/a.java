package oo1;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.data.x;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp;
import java.util.List;
import rr1.b;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        switch (i3) {
            case 1:
                x xVar = (x) obj;
                a(z16, (IGProChannelInfo) xVar.a(), xVar.b());
                return;
            case 2:
                b(z16, (IGProChannelInfo) obj);
                return;
            case 3:
                c(z16, (IGProChannelInfo) obj);
                return;
            case 4:
            case 14:
            default:
                return;
            case 5:
                if (obj instanceof Object[]) {
                    Object[] objArr = (Object[]) obj;
                    q(objArr[0], ((Integer) objArr[1]).intValue());
                    return;
                }
                return;
            case 6:
                p((String) obj);
                return;
            case 7:
                d((b) obj);
                return;
            case 8:
                e();
                return;
            case 9:
                l();
                return;
            case 10:
                i((IGProChannelInfo) obj);
                return;
            case 11:
                if (obj instanceof Object[]) {
                    Object[] objArr2 = (Object[]) obj;
                    k((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                    return;
                }
                return;
            case 12:
                if (obj instanceof Boolean) {
                    f(((Boolean) obj).booleanValue());
                    return;
                }
                return;
            case 13:
                h();
                return;
            case 15:
                if (obj instanceof Object[]) {
                    Object[] objArr3 = (Object[]) obj;
                    j((String) objArr3[0], ((Integer) objArr3[1]).intValue());
                    return;
                }
                return;
            case 16:
                if (obj instanceof Object[]) {
                    Object[] objArr4 = (Object[]) obj;
                    n((String) objArr4[0], (List) objArr4[1]);
                    return;
                }
                return;
            case 17:
                if (obj instanceof String) {
                    r((String) obj);
                    return;
                }
                return;
            case 18:
                if (obj instanceof Object[]) {
                    Object[] objArr5 = (Object[]) obj;
                    o(((Long) objArr5[0]).longValue(), ((Boolean) objArr5[1]).booleanValue(), ((Boolean) objArr5[2]).booleanValue(), (List) objArr5[3]);
                    return;
                }
                return;
            case 19:
                if (obj instanceof Object[]) {
                    Object[] objArr6 = (Object[]) obj;
                    m((String) objArr6[0], ((Boolean) objArr6[1]).booleanValue(), (List) objArr6[2]);
                    return;
                }
                return;
            case 20:
                if (obj instanceof Object[]) {
                    Object[] objArr7 = (Object[]) obj;
                    g((String) objArr7[0], (IGProGuildCheckinRsp) objArr7[1]);
                    return;
                }
                return;
        }
    }

    public void e() {
    }

    public void h() {
    }

    public void l() {
    }

    public void d(b bVar) {
    }

    public void f(boolean z16) {
    }

    public void i(IGProChannelInfo iGProChannelInfo) {
    }

    public void p(String str) {
    }

    public void r(String str) {
    }

    public void b(boolean z16, IGProChannelInfo iGProChannelInfo) {
    }

    public void c(boolean z16, IGProChannelInfo iGProChannelInfo) {
    }

    public void g(String str, IGProGuildCheckinRsp iGProGuildCheckinRsp) {
    }

    public void j(String str, int i3) {
    }

    public void k(String str, int i3) {
    }

    public void n(String str, List<String> list) {
    }

    public void q(Object obj, int i3) {
    }

    public void a(boolean z16, IGProChannelInfo iGProChannelInfo, String str) {
    }

    public void m(String str, boolean z16, List<String> list) {
    }

    public void o(long j3, boolean z16, boolean z17, List<Long> list) {
    }
}
