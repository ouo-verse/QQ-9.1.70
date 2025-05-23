package com.qq.e.comm.plugin.base.ad.clickcomponent.chain;

import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickResult;
import com.qq.e.comm.plugin.base.ad.clickcomponent.c.b;
import com.qq.e.comm.plugin.base.ad.clickcomponent.c.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.Arrays;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AbsJumpNode {
    public static final int JUMP_C2S = 4;
    public static final int JUMP_CLICK_CGI = 3;
    public static final int JUMP_NEXT = 2;
    public static final int JUMP_OUT = 1;

    /* renamed from: a, reason: collision with root package name */
    protected String f38543a = getClass().getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    protected ClickInfo f38544b;

    /* renamed from: c, reason: collision with root package name */
    protected JSONObject f38545c;

    /* renamed from: d, reason: collision with root package name */
    protected String f38546d;

    /* renamed from: e, reason: collision with root package name */
    private long f38547e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        ClickResult a() throws Throwable;

        ClickResult a(ClickInfo clickInfo) throws Throwable;

        void a(String str, boolean z16);

        ClickResult b() throws Throwable;
    }

    public AbsJumpNode(ClickInfo clickInfo) {
        this.f38544b = clickInfo;
        if (clickInfo != null) {
            this.f38545c = clickInfo.j();
            this.f38546d = clickInfo.c().f38511c;
        }
    }

    private void d(a aVar, int i3) {
        long currentTimeMillis = System.currentTimeMillis() - this.f38547e;
        GDTLogger.d(this.f38543a + "--exit cost" + currentTimeMillis);
        c.a(133006, this.f38544b, this.f38543a, currentTimeMillis);
        if (i3 != 2 && b.a(this.f38543a) != 12 && b.a(this.f38543a) != 13) {
            aVar.a(this.f38543a, true);
        } else {
            aVar.a(this.f38543a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
        this.f38547e = System.currentTimeMillis();
        GDTLogger.d(this.f38543a + "--enter ||");
    }

    protected abstract boolean a();

    protected abstract int b(a aVar) throws Throwable;

    protected ClickResult b(a aVar, int i3) {
        GDTLogger.d(this.f38543a + "--exit in NORMAL mode cost" + (System.currentTimeMillis() - this.f38547e));
        try {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return new ClickResult(1, this.f38543a + "end");
                    }
                    return aVar.b();
                }
                return aVar.a();
            }
            return aVar.a(this.f38544b);
        } catch (Throwable th5) {
            c.a(this.f38544b, -1, this.f38543a, -1, th5.getMessage() + Arrays.toString(th5.getStackTrace()));
            return new ClickResult(2, "click jump exception", new IllegalThreadStateException("wrong click jump type"));
        }
    }

    protected ClickResult c(a aVar, int i3) {
        GDTLogger.d(this.f38543a + "--exit in ONLY_ACTION mode cost" + (System.currentTimeMillis() - this.f38547e));
        try {
            if (i3 != 2) {
                return new ClickResult(1, this.f38543a + "end");
            }
            return aVar.a(this.f38544b);
        } catch (Throwable th5) {
            th5.printStackTrace();
            c.a(this.f38544b, -1, this.f38543a, -1, th5.getMessage() + Arrays.toString(th5.getStackTrace()));
            return new ClickResult(2, "click jump exception", new IllegalThreadStateException("wrong click jump type"));
        }
    }

    protected ClickResult a(a aVar, int i3) {
        int g16 = this.f38544b.g();
        d(aVar, i3);
        if (g16 != 3 && g16 != 4 && g16 != 10) {
            return b(aVar, i3);
        }
        return c(aVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ClickResult c(a aVar) throws Throwable {
        if (a()) {
            a(aVar);
            return a(aVar, b(aVar));
        }
        return aVar.a(this.f38544b);
    }
}
