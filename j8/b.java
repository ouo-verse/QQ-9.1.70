package j8;

import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import cooperation.peak.PeakConstants;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    protected int f409633a;

    /* renamed from: b, reason: collision with root package name */
    protected int f409634b;

    /* renamed from: c, reason: collision with root package name */
    protected int f409635c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f409636d;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a<S extends a<S>> {

        /* renamed from: b, reason: collision with root package name */
        protected int f409638b;

        /* renamed from: c, reason: collision with root package name */
        protected int f409639c;

        /* renamed from: a, reason: collision with root package name */
        protected int f409637a = 0;

        /* renamed from: d, reason: collision with root package name */
        protected boolean f409640d = true;

        public S c(int i3) {
            this.f409638b = i3;
            return b();
        }

        public S d(int i3) {
            this.f409637a = i3;
            return b();
        }

        public S e(int i3) {
            this.f409639c = i3;
            return b();
        }

        public S f(boolean z16) {
            this.f409640d = z16;
            return b();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Builder{\n");
            stringBuffer.append("galleryShowType=");
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

        public b a() {
            QZLog.d("[PhotoAlbum]", 1, toString());
            return new b(this);
        }

        private S b() {
            return this;
        }
    }

    public <S extends a<S>> b(a<S> aVar) {
        this.f409633a = aVar.f409637a;
        this.f409634b = aVar.f409638b;
        this.f409635c = aVar.f409639c;
        this.f409636d = aVar.f409640d;
    }

    @Override // j8.c
    public Bundle getParams() {
        Bundle bundle = new Bundle();
        bundle.putInt(PeakConstants.KEY_SHOW_TYPE, this.f409633a);
        bundle.putInt(PictureConst.KEY_ALL_PHOTO_COUNT, this.f409634b);
        bundle.putInt(PictureConst.KEY_PHOTO_INDEX_IN_ALBUM, this.f409635c);
        bundle.putBoolean(PictureConst.KEY_SHOW_MENU, this.f409636d);
        return bundle;
    }
}
