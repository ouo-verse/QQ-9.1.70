package l8;

import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import cooperation.qzone.util.QZLog;
import j8.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends j8.b {

    /* renamed from: e, reason: collision with root package name */
    int f413937e;

    /* renamed from: f, reason: collision with root package name */
    protected int f413938f;

    /* compiled from: P */
    /* renamed from: l8.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10712a extends b.a<C10712a> {

        /* renamed from: e, reason: collision with root package name */
        protected int f413939e = 0;

        /* renamed from: f, reason: collision with root package name */
        protected int f413940f = 0;

        public C10712a h(int i3) {
            this.f413940f = i3;
            return this;
        }

        @Override // j8.b.a
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Builder{\n");
            stringBuffer.append("source=");
            stringBuffer.append(this.f413939e);
            stringBuffer.append('\n');
            stringBuffer.append(", deleteType=");
            stringBuffer.append(this.f413940f);
            stringBuffer.append('\n');
            stringBuffer.append(", galleryShowType=");
            stringBuffer.append(this.f409637a);
            stringBuffer.append('\n');
            stringBuffer.append(", allPhotoCount=");
            stringBuffer.append(this.f409638b);
            stringBuffer.append('\n');
            stringBuffer.append(", indexInAlbum=");
            stringBuffer.append(this.f409639c);
            stringBuffer.append('\n');
            stringBuffer.append(", isShowMenu=");
            stringBuffer.append(this.f409640d);
            stringBuffer.append('\n');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        @Override // j8.b.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public a a() {
            QZLog.d("[PhotoAlbum]", 1, toString());
            return new a(this);
        }
    }

    public a(C10712a c10712a) {
        super(c10712a);
        this.f413937e = c10712a.f413939e;
        this.f413938f = c10712a.f413940f;
    }

    @Override // j8.b, j8.c
    public Bundle getParams() {
        Bundle params = super.getParams();
        params.putInt("source_from", this.f413937e);
        params.putInt(PictureConst.KEY_DEL_TYPE, this.f413938f);
        return params;
    }
}
