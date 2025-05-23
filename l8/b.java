package l8;

import android.os.Bundle;
import com.qzone.preview.service.base.PictureConst;
import cooperation.qzone.util.QZLog;
import j8.b;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends j8.b {

    /* renamed from: e, reason: collision with root package name */
    protected int f413941e;

    /* renamed from: f, reason: collision with root package name */
    protected ArrayList<String> f413942f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f413943g;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a extends b.a<a> {

        /* renamed from: f, reason: collision with root package name */
        protected ArrayList<String> f413945f;

        /* renamed from: e, reason: collision with root package name */
        protected int f413944e = 50;

        /* renamed from: g, reason: collision with root package name */
        protected boolean f413946g = false;

        public a h(boolean z16) {
            this.f413946g = z16;
            return this;
        }

        public a i(int i3) {
            this.f413944e = i3;
            return this;
        }

        public a j(ArrayList<String> arrayList) {
            this.f413945f = arrayList;
            return this;
        }

        @Override // j8.b.a
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Builder{\n");
            stringBuffer.append("maxSelectCount=");
            stringBuffer.append(this.f413944e);
            stringBuffer.append('\n');
            stringBuffer.append(", selectedLloc=");
            stringBuffer.append(this.f413945f);
            stringBuffer.append('\n');
            stringBuffer.append(", isInOrder=");
            stringBuffer.append(this.f413946g);
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
        public b a() {
            QZLog.d("[PhotoAlbum]", 1, toString());
            return new b(this);
        }
    }

    public b(a aVar) {
        super(aVar);
        this.f413941e = aVar.f413944e;
        this.f413942f = aVar.f413945f;
        this.f413943g = aVar.f413946g;
    }

    @Override // j8.b, j8.c
    public Bundle getParams() {
        Bundle params = super.getParams();
        params.putInt(PictureConst.KEY_MAX_SELECT_COUNT, this.f413941e);
        params.putStringArrayList(PictureConst.KEY_SELECTED_PHOTO_LLOC, this.f413942f);
        params.putBoolean(PictureConst.KEY_CHECKBOX_WITH_NUMBER, this.f413943g);
        return params;
    }
}
