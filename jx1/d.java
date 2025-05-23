package jx1;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private ix1.a f411056a;

    public d(ix1.a aVar) {
        this.f411056a = aVar;
    }

    @Override // jx1.a
    public void onEvent(int i3) {
        if (i3 != 6) {
            if (i3 != 7 && i3 != 14) {
                if (i3 != 15) {
                    return;
                }
            } else {
                this.f411056a.I();
            }
            this.f411056a.I();
            return;
        }
        this.f411056a.X(0);
    }
}
