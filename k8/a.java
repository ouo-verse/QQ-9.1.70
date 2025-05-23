package k8;

import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import cooperation.qzone.util.QZLog;
import k8.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends c {

    /* renamed from: l, reason: collision with root package name */
    protected int f411841l;

    /* renamed from: m, reason: collision with root package name */
    protected String f411842m;

    /* renamed from: n, reason: collision with root package name */
    protected String f411843n;

    /* compiled from: P */
    /* renamed from: k8.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10640a extends c.a {

        /* renamed from: l, reason: collision with root package name */
        protected int f411844l;

        /* renamed from: m, reason: collision with root package name */
        protected String f411845m;

        /* renamed from: n, reason: collision with root package name */
        protected String f411846n;

        public C10640a p(String str) {
            this.f411845m = str;
            return this;
        }

        public C10640a q(String str) {
            this.f411846n = str;
            return this;
        }

        public C10640a r(int i3) {
            this.f411844l = i3;
            return this;
        }

        @Override // k8.c.a, j8.a.C10575a
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Builder{\n");
            stringBuffer.append("categoryType=");
            stringBuffer.append(this.f411844l);
            stringBuffer.append('\n');
            stringBuffer.append(", categoryId='");
            stringBuffer.append(this.f411845m);
            stringBuffer.append('\'');
            stringBuffer.append('\n');
            stringBuffer.append(", categoryPageStr='");
            stringBuffer.append(this.f411846n);
            stringBuffer.append('\'');
            stringBuffer.append('\n');
            stringBuffer.append(", uin=");
            stringBuffer.append(this.f411857f);
            stringBuffer.append('\n');
            stringBuffer.append(", hasMore=");
            stringBuffer.append(this.f411858g);
            stringBuffer.append('\n');
            stringBuffer.append(", indexOffset=");
            stringBuffer.append(this.f411859h);
            stringBuffer.append('\n');
            stringBuffer.append(", cacheCount=");
            stringBuffer.append(this.f411860i);
            stringBuffer.append('\n');
            stringBuffer.append(", photoParams=");
            stringBuffer.append(this.f411861j);
            stringBuffer.append('\n');
            stringBuffer.append(", reqForRecentOrVideo=");
            stringBuffer.append(this.f411862k);
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

        @Override // k8.c.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public a a() {
            QZLog.d("[PhotoAlbum]", 1, toString());
            return new a(this);
        }
    }

    public a(C10640a c10640a) {
        super(c10640a);
        this.f411841l = c10640a.f411844l;
        this.f411842m = c10640a.f411845m;
        this.f411843n = c10640a.f411846n;
    }

    @Override // k8.c, j8.a, j8.c
    public Bundle getParams() {
        Bundle params = super.getParams();
        params.putInt(PictureConst.KEY_CATEGORY_TYPE, this.f411841l);
        params.putString(PictureConst.KEY_CATEGORY_ID, this.f411842m);
        params.putString(PictureConst.KEY_CATEGORY_PAGESTR, this.f411843n);
        return params;
    }
}
