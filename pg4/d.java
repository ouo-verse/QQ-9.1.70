package pg4;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: h, reason: collision with root package name */
    private static final d f426202h = new d();

    /* renamed from: a, reason: collision with root package name */
    private final ko4.c<Boolean> f426203a;

    /* renamed from: b, reason: collision with root package name */
    private final ko4.c<Boolean> f426204b;

    /* renamed from: c, reason: collision with root package name */
    private final ko4.c<View> f426205c;

    /* renamed from: d, reason: collision with root package name */
    private final ko4.c<Boolean> f426206d;

    /* renamed from: e, reason: collision with root package name */
    private final ko4.c<Integer> f426207e;

    /* renamed from: f, reason: collision with root package name */
    private final ko4.c<View> f426208f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f426209g;

    public d() {
        Boolean bool = Boolean.FALSE;
        this.f426203a = new ko4.c<>(bool);
        this.f426204b = new ko4.c<>(bool);
        this.f426205c = new ko4.c<>(null);
        this.f426206d = new ko4.c<>(Boolean.TRUE);
        this.f426207e = new ko4.c<>(0);
        this.f426208f = new ko4.c<>(null);
    }

    public static d b() {
        return f426202h;
    }

    public void a() {
        d b16 = b();
        Boolean bool = Boolean.FALSE;
        b16.f(bool);
        b16.h(0);
        b16.g(null);
        b16.k(Boolean.TRUE);
        b16.j(bool);
        b16.e(null);
    }

    public LiveData<Boolean> c() {
        return this.f426204b;
    }

    public LiveData<Boolean> d() {
        return this.f426203a;
    }

    public void f(Boolean bool) {
        this.f426204b.setValue(bool);
    }

    public void g(View view) {
        this.f426205c.setValue(view);
    }

    public void h(int i3) {
        this.f426207e.setValue(Integer.valueOf(i3));
    }

    public void i(String str) {
        QLog.i("TgLiveTag_TgLiveRoomUIData", 1, "updateRoomLogo roomLog:" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f426209g = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null);
            } catch (Exception e16) {
                QLog.e("TgLiveTag_TgLiveRoomUIData", 1, "updateRoomLogo, failed, ", e16);
            }
        }
    }

    public void j(Boolean bool) {
        this.f426203a.setValue(bool);
    }

    public void k(Boolean bool) {
        QLog.i("TgLiveTag_TgLiveRoomUIData", 1, "updateVideoIsLand isLand:" + bool);
        this.f426206d.setValue(bool);
    }

    public void e(GiftMessage giftMessage) {
    }
}
