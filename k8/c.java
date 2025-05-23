package k8;

import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;
import j8.a;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends j8.a {

    /* renamed from: f, reason: collision with root package name */
    protected long f411851f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f411852g;

    /* renamed from: h, reason: collision with root package name */
    protected int f411853h;

    /* renamed from: i, reason: collision with root package name */
    protected int f411854i;

    /* renamed from: j, reason: collision with root package name */
    protected ArrayList<PhotoParam> f411855j;

    /* renamed from: k, reason: collision with root package name */
    protected int f411856k;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a extends a.C10575a {

        /* renamed from: f, reason: collision with root package name */
        protected long f411857f;

        /* renamed from: h, reason: collision with root package name */
        protected int f411859h;

        /* renamed from: i, reason: collision with root package name */
        protected int f411860i;

        /* renamed from: j, reason: collision with root package name */
        protected ArrayList<PhotoParam> f411861j;

        /* renamed from: g, reason: collision with root package name */
        protected boolean f411858g = true;

        /* renamed from: k, reason: collision with root package name */
        protected int f411862k = 1;

        public a i(int i3) {
            this.f411860i = i3;
            return this;
        }

        public a j(boolean z16) {
            this.f411858g = z16;
            return this;
        }

        public a k(int i3) {
            this.f411859h = i3;
            return this;
        }

        public a l(ArrayList<PhotoParam> arrayList) {
            this.f411861j = arrayList;
            return this;
        }

        public a m(int i3) {
            this.f411862k = i3;
            return this;
        }

        public a n(long j3) {
            this.f411857f = j3;
            return this;
        }

        @Override // j8.a.C10575a
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Builder{\n");
            stringBuffer.append("uin=");
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

        @Override // j8.a.C10575a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public c a() {
            QZLog.d("[PhotoAlbum]", 1, toString());
            return new c(this);
        }
    }

    public c(a aVar) {
        super(aVar);
        this.f411851f = aVar.f411857f;
        this.f411852g = aVar.f411858g;
        this.f411853h = aVar.f411859h;
        this.f411854i = aVar.f411860i;
        this.f411855j = aVar.f411861j;
        this.f411856k = aVar.f411862k;
    }

    @Override // j8.a, j8.c
    public Bundle getParams() {
        Bundle params = super.getParams();
        params.putLong("key_uin", this.f411851f);
        params.putBoolean(PictureConst.KEY_HAS_MORE, this.f411852g);
        params.putInt(PictureConst.KEY_INDEX_OFFSET, this.f411853h);
        params.putInt(PictureConst.KEY_CACHE_COUNT, this.f411854i);
        params.putParcelableArrayList(PictureConst.KEY_PHOTO_PARAM_LIST, this.f411855j);
        params.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, this.f411856k);
        return params;
    }
}
