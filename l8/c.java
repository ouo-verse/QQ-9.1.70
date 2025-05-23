package l8;

import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import cooperation.qzone.util.QZLog;
import j8.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends j8.b {

    /* renamed from: e, reason: collision with root package name */
    protected String f413947e;

    /* renamed from: f, reason: collision with root package name */
    protected long f413948f;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a extends b.a<a> {

        /* renamed from: e, reason: collision with root package name */
        protected String f413949e;

        /* renamed from: f, reason: collision with root package name */
        public long f413950f = 0;

        public a h(long j3) {
            this.f413950f = j3;
            return this;
        }

        public a i(String str) {
            this.f413949e = str;
            return this;
        }

        @Override // j8.b.a
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Builder{\n");
            stringBuffer.append("uuid='");
            stringBuffer.append(this.f413949e);
            stringBuffer.append('\'');
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
            stringBuffer.append(", feedDeleteTime=");
            stringBuffer.append(this.f413950f);
            stringBuffer.append('\n');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        @Override // j8.b.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public c a() {
            QZLog.d("[PhotoAlbum]", 1, toString());
            return new c(this);
        }
    }

    public c(a aVar) {
        super(aVar);
        this.f413947e = aVar.f413949e;
        this.f413948f = aVar.f413950f;
    }

    @Override // j8.b, j8.c
    public Bundle getParams() {
        Bundle params = super.getParams();
        params.putLong(PictureConst.KEY_FEED_DELETE_TIME, this.f413948f);
        String str = this.f413947e;
        if (str != null) {
            try {
                params.putString("recommend_report_uuid", str);
            } catch (Exception unused) {
                QZLog.e("[PhotoAlbum]QzonePictureViewerParam", "format parent cookie requireParams error! ");
            }
        }
        return params;
    }
}
