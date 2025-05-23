package com.tencent.mobileqq.qqexpand.match;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private a f263929a;

    /* renamed from: b, reason: collision with root package name */
    private final d f263930b;

    /* renamed from: c, reason: collision with root package name */
    private final C8320c f263931c;

    /* renamed from: d, reason: collision with root package name */
    private final b f263932d;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f263933a = -1;

        /* renamed from: b, reason: collision with root package name */
        protected com.tencent.mobileqq.qqexpand.manager.c f263934b;

        /* renamed from: c, reason: collision with root package name */
        protected c f263935c;

        public a(c cVar, com.tencent.mobileqq.qqexpand.manager.c cVar2) {
            this.f263934b = cVar2;
            this.f263935c = cVar;
        }

        public boolean a(int i3, int i16) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("LimitChatUiStateMachine", 2, "state " + this.f263933a + " start handle event " + i3 + ", subEvent " + i16);
            return false;
        }

        public void b() {
            if (QLog.isColorLevel()) {
                QLog.d("LimitChatUiStateMachine", 2, "state " + this.f263933a + " onEnd");
            }
        }

        public void c() {
            if (QLog.isColorLevel()) {
                QLog.d("LimitChatUiStateMachine", 2, "state " + this.f263933a + " onForceEnd");
            }
        }

        public void d(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("LimitChatUiStateMachine", 2, "state " + this.f263933a + " onStart subinfo:" + i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class b extends a {
        public b(c cVar, com.tencent.mobileqq.qqexpand.manager.c cVar2) {
            super(cVar, cVar2);
            this.f263933a = -1;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.match.c$c, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static class C8320c extends a {
        public C8320c(c cVar, com.tencent.mobileqq.qqexpand.manager.c cVar2) {
            super(cVar, cVar2);
            this.f263933a = 2;
        }

        @Override // com.tencent.mobileqq.qqexpand.match.c.a
        public boolean a(int i3, int i16) {
            super.a(i3, i16);
            switch (i3) {
                case 102:
                    this.f263934b.s().b();
                    this.f263935c.f(0, i16);
                    this.f263935c.e(i3, i16);
                    return false;
                case 103:
                    this.f263934b.s().b();
                    break;
                case 104:
                    break;
                case 105:
                    this.f263935c.f(0, i16);
                    return true;
                default:
                    return false;
            }
            this.f263935c.f(0, i16);
            return true;
        }

        @Override // com.tencent.mobileqq.qqexpand.match.c.a
        public void c() {
            super.c();
            this.f263934b.s().b();
        }

        @Override // com.tencent.mobileqq.qqexpand.match.c.a
        public void d(int i3) {
            super.d(i3);
            this.f263934b.n();
            this.f263934b.s().f(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class d extends a {
        public d(c cVar, com.tencent.mobileqq.qqexpand.manager.c cVar2) {
            super(cVar, cVar2);
            this.f263933a = 0;
        }

        @Override // com.tencent.mobileqq.qqexpand.match.c.a
        public boolean a(int i3, int i16) {
            super.a(i3, i16);
            if (i3 != 102) {
                return false;
            }
            this.f263935c.f(2, i16);
            return true;
        }

        @Override // com.tencent.mobileqq.qqexpand.match.c.a
        public void d(int i3) {
            super.d(i3);
            this.f263934b.n();
        }
    }

    public c(com.tencent.mobileqq.qqexpand.manager.c cVar) {
        d dVar = new d(this, cVar);
        this.f263930b = dVar;
        this.f263931c = new C8320c(this, cVar);
        this.f263932d = new b(this, cVar);
        this.f263929a = dVar;
    }

    public int b() {
        return this.f263929a.f263933a;
    }

    public void e(int i3, int i16) {
        a(i3, i16);
        a aVar = this.f263929a;
        int i17 = aVar.f263933a;
        if (aVar.a(i3, i16) || !QLog.isColorLevel()) {
            return;
        }
        QLog.e("LimitChatUiStateMachine", 2, "state " + i17 + " not handle event " + i3 + ", subEvent " + i16);
    }

    public void f(int i3, int i16) {
        a c16;
        if (i3 == this.f263929a.f263933a || (c16 = c(i3)) == null) {
            return;
        }
        this.f263929a.b();
        this.f263929a = c16;
        c16.d(i16);
    }

    public void d(int i3) {
        e(i3, -1);
    }

    public void a(int i3, int i16) {
        if (i3 != 101) {
            return;
        }
        a aVar = this.f263929a;
        if (aVar.f263933a != 0) {
            aVar.c();
            d dVar = this.f263930b;
            this.f263929a = dVar;
            dVar.d(-1);
        }
    }

    public a c(int i3) {
        if (i3 == 0) {
            return this.f263930b;
        }
        if (i3 != 2) {
            return this.f263932d;
        }
        return this.f263931c;
    }
}
