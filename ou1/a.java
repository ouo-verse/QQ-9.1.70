package ou1;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import tencent.im.group_pro_proto.synclogic.synclogic$FirstViewRsp;
import tencent.im.group_pro_proto.synclogic.synclogic$GuildNode;
import tencent.im.group_pro_proto.synclogic.synclogic$MultiChannelMsgRsp;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements BusinessObserver {
    public static final int C;

    /* renamed from: d, reason: collision with root package name */
    private static int f424089d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f424090e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f424091f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f424092h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f424093i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f424094m;

    static {
        int i3 = 0 + 1;
        int i16 = i3 + 1;
        f424091f = i3;
        int i17 = i16 + 1;
        f424092h = i16;
        int i18 = i17 + 1;
        f424093i = i17;
        int i19 = i18 + 1;
        f424094m = i18;
        f424089d = i19 + 1;
        C = i19;
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 != f424092h) {
            return;
        }
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                a(((Integer) objArr[0]).intValue());
                return;
            }
        }
        a(0);
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 != f424093i) {
            return;
        }
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                b(z16, ((Integer) objArr[0]).intValue(), (synclogic$MultiChannelMsgRsp) objArr[1]);
                return;
            }
        }
        b(z16, 0, null);
    }

    private void i(int i3, boolean z16, Object obj) {
        if (i3 != f424094m) {
            return;
        }
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                c(z16, ((Integer) objArr[0]).intValue());
                return;
            }
        }
        c(z16, 0);
    }

    private void j(int i3, boolean z16, Object obj) {
        if (i3 != C) {
            return;
        }
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                d(((Integer) objArr[0]).intValue());
                return;
            }
        }
        d(0);
    }

    private void k(int i3, boolean z16, Object obj) {
        if (i3 != f424091f) {
            return;
        }
        if (obj == null) {
            e(z16, null);
        } else {
            e(z16, (ArrayList) ((Object[]) obj)[0]);
        }
    }

    private void l(int i3, boolean z16, Object obj) {
        if (i3 != f424090e) {
            return;
        }
        if (obj == null) {
            f(z16, null);
        } else {
            f(z16, (synclogic$FirstViewRsp) ((Object[]) obj)[0]);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        l(i3, z16, obj);
        k(i3, z16, obj);
        g(i3, z16, obj);
        h(i3, z16, obj);
        i(i3, z16, obj);
        j(i3, z16, obj);
    }

    protected void a(int i3) {
    }

    protected void d(int i3) {
    }

    protected void c(boolean z16, int i3) {
    }

    protected void e(boolean z16, ArrayList<synclogic$GuildNode> arrayList) {
    }

    protected void f(boolean z16, synclogic$FirstViewRsp synclogic_firstviewrsp) {
    }

    protected void b(boolean z16, int i3, synclogic$MultiChannelMsgRsp synclogic_multichannelmsgrsp) {
    }
}
