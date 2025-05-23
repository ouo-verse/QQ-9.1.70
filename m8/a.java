package m8;

import android.os.Bundle;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;
import j8.c;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    protected int f416411a;

    /* renamed from: b, reason: collision with root package name */
    protected int f416412b;

    /* renamed from: c, reason: collision with root package name */
    protected PhotoParam f416413c;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<PhotoInfo> f416414d;

    public a(int i3, int i16, PhotoParam photoParam, ArrayList<PhotoInfo> arrayList) {
        this.f416411a = i3;
        this.f416412b = i16;
        this.f416413c = photoParam;
        this.f416414d = arrayList;
        QZLog.d("[PhotoAlbum]", 1, toString());
    }

    @Override // j8.c
    public Bundle getParams() {
        Bundle bundle = new Bundle();
        bundle.putInt("curindex", this.f416411a);
        bundle.putInt("mode", this.f416412b);
        bundle.putParcelable("photo_param", this.f416413c);
        bundle.putSerializable("picturelist", this.f416414d);
        return bundle;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RequireParam{\n");
        stringBuffer.append("curIndex=");
        stringBuffer.append(this.f416411a);
        stringBuffer.append('\n');
        stringBuffer.append(", mode=");
        stringBuffer.append(this.f416412b);
        stringBuffer.append('\n');
        stringBuffer.append(", photoParam=");
        stringBuffer.append(this.f416413c);
        stringBuffer.append('\n');
        stringBuffer.append(", photoInfoList size=");
        ArrayList<PhotoInfo> arrayList = this.f416414d;
        stringBuffer.append(arrayList != null ? arrayList.size() : 0);
        stringBuffer.append('\n');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
