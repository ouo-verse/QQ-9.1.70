package com.qq.e.comm.plugin.base.ad.clickcomponent;

import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private List<AbsJumpNode> f38538a;

    /* renamed from: b, reason: collision with root package name */
    private ClickInfo f38539b;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final List<AbsJumpNode> f38540a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        ClickInfo f38541b;

        public a a(ClickInfo clickInfo) {
            this.f38541b = clickInfo;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public com.qq.e.comm.plugin.base.ad.clickcomponent.b.a a() {
        return d.a(this, this.f38539b);
    }

    public List<AbsJumpNode> b() {
        return this.f38538a;
    }

    b(a aVar) {
        this.f38538a = aVar.f38540a;
        this.f38539b = aVar.f38541b;
    }
}
