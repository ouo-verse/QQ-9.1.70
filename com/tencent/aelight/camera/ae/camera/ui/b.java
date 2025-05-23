package com.tencent.aelight.camera.ae.camera.ui;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class b {

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0538b extends b {
        @Override // com.tencent.aelight.camera.ae.camera.ui.b
        public int a(int i3) {
            return i3 * (-1);
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.b
        public boolean c(int i3) {
            if (i3 < 0) {
                return true;
            }
            return false;
        }
    }

    public abstract int a(int i3);

    public abstract boolean c(int i3);

    public static b b(int i3) {
        if (i3 > 0) {
            return new a();
        }
        return new C0538b();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a extends b {
        @Override // com.tencent.aelight.camera.ae.camera.ui.b
        public boolean c(int i3) {
            if (i3 > 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.b
        public int a(int i3) {
            return i3;
        }
    }
}
