package ip;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends c {

    /* renamed from: f, reason: collision with root package name */
    private static final int f408124f = b.f408127c;

    /* renamed from: d, reason: collision with root package name */
    private float f408125d;

    /* renamed from: e, reason: collision with root package name */
    private float f408126e;

    public a(b bVar) {
        super(bVar);
        this.f408125d = -1.0f;
        this.f408126e = -1.0f;
        this.f408131b = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0013, code lost:
    
        if (e(r5) != false) goto L6;
     */
    @Override // ip.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int i3 = 0;
        if (action == 0) {
            this.f408125d = motionEvent.getX();
            this.f408126e = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
            }
            i3 = 1;
        } else {
            if (!e(motionEvent)) {
                i3 = 2;
            }
            i3 = 1;
        }
        if (i3 == 1 || i3 == 2) {
            this.f408126e = -1.0f;
            this.f408125d = -1.0f;
        }
        return i3;
    }

    private boolean e(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return true;
        }
        float f16 = this.f408125d;
        if (f16 == -1.0f || this.f408126e == -1.0f) {
            return true;
        }
        float x16 = f16 - motionEvent.getX();
        float y16 = this.f408126e - motionEvent.getY();
        return (x16 * x16) + (y16 * y16) > ((float) f408124f);
    }
}
