package k8;

import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import cooperation.qzone.util.QZLog;
import j8.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends j8.a {

    /* renamed from: f, reason: collision with root package name */
    protected int f411847f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f411848g;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a extends a.C10575a {

        /* renamed from: f, reason: collision with root package name */
        protected int f411849f;

        /* renamed from: g, reason: collision with root package name */
        protected boolean f411850g = false;

        public a i(int i3) {
            this.f411849f = i3;
            return this;
        }

        public a j(boolean z16) {
            this.f411850g = z16;
            return this;
        }

        @Override // j8.a.C10575a
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Builder{\n");
            stringBuffer.append("photoCount=");
            stringBuffer.append(this.f411849f);
            stringBuffer.append('\n');
            stringBuffer.append(", isSafeModeFeed=");
            stringBuffer.append(this.f411850g);
            stringBuffer.append('\n');
            stringBuffer.append(", pageMode=");
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
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        @Override // j8.a.C10575a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public b a() {
            QZLog.d("[PhotoAlbum]", 1, toString());
            return new b(this);
        }
    }

    public b(a aVar) {
        super(aVar);
        this.f411847f = aVar.f411849f;
        this.f411848g = aVar.f411850g;
    }

    @Override // j8.a, j8.c
    public Bundle getParams() {
        Bundle params = super.getParams();
        params.putInt(PictureConst.KEY_PHTOTCOUNT, this.f411847f);
        params.putBoolean(PictureConst.KEY_SAFE_MODE_FEED, this.f411848g);
        return params;
    }
}
