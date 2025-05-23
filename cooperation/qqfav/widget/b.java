package cooperation.qqfav.widget;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b implements f {

    /* renamed from: d, reason: collision with root package name */
    private Long f390715d;

    /* renamed from: e, reason: collision with root package name */
    private Context f390716e;

    public b(Context context, Long l3) {
        this.f390715d = l3;
        this.f390716e = context;
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        ColorNote.a aVar = new ColorNote.a();
        if (QLog.isColorLevel()) {
            QLog.i("FavColorNoteServiceInfo", 2, "getColorNote: colorNote key [qfav]");
        }
        String string = this.f390716e.getString(R.string.f170043dr);
        String string2 = this.f390716e.getString(R.string.b3m);
        aVar.g(android.R.dimen.app_icon_size);
        aVar.i("" + this.f390715d + "-4");
        aVar.d(string);
        aVar.h(string2);
        aVar.e("resdrawable://" + R.drawable.f161601e84);
        return aVar.a();
    }
}
