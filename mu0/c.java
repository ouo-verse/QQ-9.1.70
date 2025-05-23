package mu0;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {

    /* renamed from: h, reason: collision with root package name */
    private static final c f417620h = new c();

    /* renamed from: a, reason: collision with root package name */
    private final ko4.c<Boolean> f417621a;

    /* renamed from: b, reason: collision with root package name */
    private final ko4.c<Boolean> f417622b;

    /* renamed from: c, reason: collision with root package name */
    private final ko4.c<View> f417623c;

    /* renamed from: d, reason: collision with root package name */
    private final ko4.c<Boolean> f417624d;

    /* renamed from: e, reason: collision with root package name */
    private final ko4.c<Integer> f417625e;

    /* renamed from: f, reason: collision with root package name */
    private final ko4.c<View> f417626f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f417627g;

    public c() {
        Boolean bool = Boolean.FALSE;
        this.f417621a = new ko4.c<>(bool);
        this.f417622b = new ko4.c<>(bool);
        this.f417623c = new ko4.c<>(null);
        this.f417624d = new ko4.c<>(Boolean.TRUE);
        this.f417625e = new ko4.c<>(0);
        this.f417626f = new ko4.c<>(null);
    }

    public static c b() {
        return f417620h;
    }

    public void a() {
        c b16 = b();
        Boolean bool = Boolean.FALSE;
        b16.f(bool);
        b16.h(0);
        b16.g(null);
        b16.k(Boolean.TRUE);
        b16.j(bool);
        b16.e(null);
    }

    public LiveData<Boolean> c() {
        return this.f417622b;
    }

    public LiveData<Boolean> d() {
        return this.f417621a;
    }

    public void f(Boolean bool) {
        this.f417622b.setValue(bool);
    }

    public void g(View view) {
        this.f417623c.setValue(view);
    }

    public void h(int i3) {
        this.f417625e.setValue(Integer.valueOf(i3));
    }

    public void i(String str) {
        QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomUIData", 1, "updateRoomLogo roomLog:" + str);
        if (!TextUtils.isEmpty(str)) {
            this.f417627g = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null);
        }
    }

    public void j(Boolean bool) {
        this.f417621a.setValue(bool);
    }

    public void k(Boolean bool) {
        QLog.i("ICGameTgLiveTag_ICGameTgLiveRoomUIData", 1, "updateVideoIsLand isLand:" + bool);
        this.f417624d.setValue(bool);
    }

    public void e(GiftMessage giftMessage) {
    }
}
