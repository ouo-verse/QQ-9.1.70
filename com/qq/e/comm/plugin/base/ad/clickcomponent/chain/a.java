package com.qq.e.comm.plugin.base.ad.clickcomponent.chain;

import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickResult;
import com.qq.e.comm.plugin.base.ad.clickcomponent.c.b;
import com.qq.e.comm.plugin.base.ad.clickcomponent.c.c;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.C2SReportNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node.CGINode;
import com.qq.e.comm.util.GDTLogger;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements AbsJumpNode.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<AbsJumpNode> f38548a;

    /* renamed from: b, reason: collision with root package name */
    private final int f38549b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f38550c = false;

    /* renamed from: d, reason: collision with root package name */
    private CGINode f38551d;

    /* renamed from: e, reason: collision with root package name */
    private C2SReportNode f38552e;

    /* renamed from: f, reason: collision with root package name */
    private ClickInfo f38553f;

    /* renamed from: g, reason: collision with root package name */
    private int f38554g;

    public a(List<AbsJumpNode> list, int i3, ClickInfo clickInfo, int i16) {
        this.f38548a = list;
        this.f38549b = i3;
        this.f38553f = clickInfo;
        this.f38551d = new CGINode(clickInfo);
        this.f38552e = new C2SReportNode(clickInfo);
        this.f38554g = i16;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode.a
    public void a(String str, boolean z16) {
        int pow = this.f38554g + ((int) Math.pow(2.0d, b.a(str) - 1));
        this.f38554g = pow;
        if (z16) {
            c.a(133007, this.f38553f, pow, 0L);
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode.a
    public ClickResult b() throws Throwable {
        return this.f38552e.c(this);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode.a
    public ClickResult a(ClickInfo clickInfo) {
        List<AbsJumpNode> list = this.f38548a;
        if (list != null && this.f38549b < list.size()) {
            a aVar = new a(this.f38548a, this.f38549b + 1, clickInfo, this.f38554g);
            AbsJumpNode absJumpNode = this.f38548a.get(this.f38549b);
            try {
                return absJumpNode.c(aVar);
            } catch (Throwable th5) {
                th5.printStackTrace();
                c.a(clickInfo, -1, absJumpNode.f38543a, -1, th5.getMessage() + Arrays.toString(th5.getStackTrace()));
                return new ClickResult(2, "some error happen in" + absJumpNode.f38543a, new Throwable("click chain fail"));
            }
        }
        GDTLogger.e("no jump nodes configured");
        return null;
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode.a
    public ClickResult a() throws Throwable {
        if (this.f38550c) {
            GDTLogger.e("proceedClickCGI had Reported");
            return new ClickResult(1, "proceedClickCGI hadReported ");
        }
        this.f38550c = true;
        return this.f38551d.c(this);
    }
}
