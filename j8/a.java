package j8;

import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f409623a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f409624b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f409625c;

    /* renamed from: d, reason: collision with root package name */
    protected int f409626d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f409627e;

    /* compiled from: P */
    /* renamed from: j8.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10575a<S extends C10575a<S>> {

        /* renamed from: a, reason: collision with root package name */
        protected int f409628a = 0;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f409629b = false;

        /* renamed from: c, reason: collision with root package name */
        protected boolean f409630c = false;

        /* renamed from: d, reason: collision with root package name */
        protected boolean f409631d = false;

        /* renamed from: e, reason: collision with root package name */
        protected boolean f409632e = true;

        public S c(boolean z16) {
            this.f409630c = z16;
            return b();
        }

        public S d(boolean z16) {
            this.f409631d = z16;
            return b();
        }

        public S e(boolean z16) {
            this.f409632e = z16;
            return b();
        }

        public S f(int i3) {
            this.f409628a = i3;
            return b();
        }

        public S g(boolean z16) {
            this.f409629b = z16;
            return b();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Builder{\n");
            stringBuffer.append("pageMode=");
            stringBuffer.append(this.f409628a);
            stringBuffer.append('\n');
            stringBuffer.append(", isPreviewLocal=");
            stringBuffer.append(this.f409629b);
            stringBuffer.append('\n');
            stringBuffer.append(", isFakeFeed=");
            stringBuffer.append(this.f409630c);
            stringBuffer.append('\n');
            stringBuffer.append(", isFromWx=");
            stringBuffer.append(this.f409631d);
            stringBuffer.append('\n');
            stringBuffer.append(", isNeedShowProgress=");
            stringBuffer.append(this.f409632e);
            stringBuffer.append('\n');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        public a a() {
            QZLog.d("[PhotoAlbum]", 1, toString());
            return new a(this);
        }

        private S b() {
            return this;
        }
    }

    public <S extends C10575a<S>> a(C10575a<S> c10575a) {
        this.f409626d = c10575a.f409628a;
        this.f409623a = c10575a.f409629b;
        this.f409624b = c10575a.f409630c;
        this.f409625c = c10575a.f409631d;
    }

    @Override // j8.c
    public Bundle getParams() {
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.KEY_PAGE_MODE, this.f409626d);
        bundle.putBoolean(PictureConst.KEY_PHOTO_PREVIEW_LOCAL, this.f409623a);
        bundle.putBoolean(PictureConst.KEY_FAKE_FEED, this.f409624b);
        bundle.putBoolean(PictureConst.PARAM_FROM_WX, this.f409625c);
        bundle.putBoolean(PictureConst.KEY_SHOW_PROGRESSVIEW, this.f409627e);
        return bundle;
    }
}
