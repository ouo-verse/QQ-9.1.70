package k8;

import android.os.Bundle;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.component.app.common.ParcelableWrapper;
import cooperation.qzone.util.QZLog;
import k8.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends c {

    /* renamed from: l, reason: collision with root package name */
    protected String f411863l;

    /* renamed from: m, reason: collision with root package name */
    protected String f411864m;

    /* renamed from: n, reason: collision with root package name */
    protected int f411865n;

    /* renamed from: o, reason: collision with root package name */
    protected SearchFilterComposition f411866o;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a extends c.a {

        /* renamed from: l, reason: collision with root package name */
        protected String f411867l;

        /* renamed from: m, reason: collision with root package name */
        protected String f411868m;

        /* renamed from: n, reason: collision with root package name */
        protected int f411869n;

        /* renamed from: o, reason: collision with root package name */
        protected SearchFilterComposition f411870o;

        public a p(String str) {
            this.f411867l = str;
            return this;
        }

        public a q(String str) {
            this.f411868m = str;
            return this;
        }

        public a r(SearchFilterComposition searchFilterComposition) {
            this.f411870o = searchFilterComposition;
            return this;
        }

        public a s(int i3) {
            this.f411869n = i3;
            return this;
        }

        @Override // k8.c.a, j8.a.C10575a
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Builder{\n");
            stringBuffer.append("albumId='");
            stringBuffer.append(this.f411867l);
            stringBuffer.append('\'');
            stringBuffer.append('\n');
            stringBuffer.append(", attachInfo='");
            stringBuffer.append(this.f411868m);
            stringBuffer.append('\'');
            stringBuffer.append('\n');
            stringBuffer.append(", searchResultTotal=");
            stringBuffer.append(this.f411869n);
            stringBuffer.append('\n');
            stringBuffer.append(", filterComposition=");
            stringBuffer.append(this.f411870o);
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
        public d a() {
            QZLog.d("[PhotoAlbum]", 1, toString());
            return new d(this);
        }
    }

    public d(a aVar) {
        super(aVar);
        this.f411863l = aVar.f411867l;
        this.f411864m = aVar.f411868m;
        this.f411865n = aVar.f411869n;
        this.f411866o = aVar.f411870o;
    }

    @Override // k8.c, j8.a, j8.c
    public Bundle getParams() {
        Bundle params = super.getParams();
        params.putString(PictureConst.KEY_ALBUM_ID, this.f411863l);
        params.putString("attach_info", this.f411864m);
        params.putInt(PictureConst.KEY_SEARCH_RESULT_TOTAL, this.f411865n);
        ParcelableWrapper.putDataToBundle(params, PictureConst.KEY_FILTER_DATA, this.f411866o);
        return params;
    }
}
