package androidx.constraintlayout.solver.widgets;

/* compiled from: P */
/* loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f26466x;

    /* renamed from: y, reason: collision with root package name */
    public int f26467y;

    public boolean contains(int i3, int i16) {
        int i17;
        int i18 = this.f26466x;
        if (i3 >= i18 && i3 < i18 + this.width && i16 >= (i17 = this.f26467y) && i16 < i17 + this.height) {
            return true;
        }
        return false;
    }

    public int getCenterX() {
        return (this.f26466x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f26467y + this.height) / 2;
    }

    void grow(int i3, int i16) {
        this.f26466x -= i3;
        this.f26467y -= i16;
        this.width += i3 * 2;
        this.height += i16 * 2;
    }

    boolean intersects(Rectangle rectangle) {
        int i3;
        int i16;
        int i17 = this.f26466x;
        int i18 = rectangle.f26466x;
        if (i17 >= i18 && i17 < i18 + rectangle.width && (i3 = this.f26467y) >= (i16 = rectangle.f26467y) && i3 < i16 + rectangle.height) {
            return true;
        }
        return false;
    }

    public void setBounds(int i3, int i16, int i17, int i18) {
        this.f26466x = i3;
        this.f26467y = i16;
        this.width = i17;
        this.height = i18;
    }
}
