package pq1;

import com.tencent.mobileqq.guild.mainframe.k;
import rr1.i;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends k {

    /* renamed from: e, reason: collision with root package name */
    private boolean f426988e;

    /* renamed from: f, reason: collision with root package name */
    private final rr1.a f426989f;

    /* compiled from: P */
    /* renamed from: pq1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C11036a extends rr1.a {
        C11036a() {
        }

        @Override // rr1.a
        public void c(i iVar) {
            if (iVar.f() == 1 && iVar.c() == 3) {
                com.tencent.mobileqq.guild.live.helper.a.d().f(false);
                com.tencent.mobileqq.guild.live.helper.a.d().g(false);
                a.this.f426988e = true;
            }
            if (iVar.f() == 3 && iVar.c() == 3) {
                com.tencent.mobileqq.guild.live.helper.a.d().f(true);
                a.this.f426988e = false;
            }
        }
    }

    public a(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        this.f426988e = false;
        this.f426989f = new C11036a();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void a(boolean z16) {
        super.a(z16);
        this.f227466d.N().removeGestureListener(this.f426989f);
        com.tencent.mobileqq.guild.live.helper.a.d().f(false);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onResume(boolean z16) {
        super.onResume(z16);
        this.f227466d.N().addGestureListener(this.f426989f);
        if (!this.f426988e) {
            com.tencent.mobileqq.guild.live.helper.a.d().f(true);
        }
    }
}
